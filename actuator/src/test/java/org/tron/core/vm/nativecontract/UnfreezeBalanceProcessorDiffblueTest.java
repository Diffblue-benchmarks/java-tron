package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.UnfreezeBalanceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnfreezeBalanceProcessorDiffblueTest {
  /**
   * Test {@link UnfreezeBalanceProcessor#validate(UnfreezeBalanceParam, Repository)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceProcessor#validate(UnfreezeBalanceParam,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnfreezeBalanceProcessor.validate(UnfreezeBalanceParam, Repository)"})
  public void testValidate_whenNull_thenThrowContractValidateException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceProcessor.validate(param, null));
  }

  /**
   * Test {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long UnfreezeBalanceProcessor.execute(UnfreezeBalanceParam, Repository)"})
  public void testExecute_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    doNothing().when(accountCapsule).safeAddAcquiredDelegatedFrozenBalanceForBandwidth(anyLong());
    doNothing().when(accountCapsule).setBalance(anyLong());
    when(accountCapsule.getBalance()).thenReturn(42L);

    DelegatedResourceCapsule delegatedResourceCapsule = mock(DelegatedResourceCapsule.class);
    when(delegatedResourceCapsule.getFrozenBalanceForBandwidth()).thenReturn(1L);
    doNothing().when(delegatedResourceCapsule).setFrozenBalanceForBandwidth(anyLong(), anyLong());

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    doNothing()
        .when(repo)
        .updateDelegatedResource(Mockito.<byte[]>any(), Mockito.<DelegatedResourceCapsule>any());
    when(repo.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(-1L);
    verify(accountCapsule, atLeast(1)).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule).safeAddAcquiredDelegatedFrozenBalanceForBandwidth(-1L);
    verify(accountCapsule).setBalance(43L);
    verify(delegatedResourceCapsule).getFrozenBalanceForBandwidth();
    verify(delegatedResourceCapsule).setFrozenBalanceForBandwidth(0L, 0L);
    verify(repo).addTotalNetWeight(0L);
    verify(repo, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(repo).getDelegatedResource(isA(byte[].class));
    verify(repo, atLeast(1)).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
    verify(repo).updateDelegatedResource(isA(byte[].class), isA(DelegatedResourceCapsule.class));
    assertEquals(1L, actualExecuteResult);
  }
}
