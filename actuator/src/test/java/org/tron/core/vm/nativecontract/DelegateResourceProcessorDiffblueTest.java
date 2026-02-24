package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
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
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.DelegateResourceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class DelegateResourceProcessorDiffblueTest {
  /**
   * Test {@link DelegateResourceProcessor#validate(DelegateResourceParam, Repository)}.
   *
   * <ul>
   *   <li>Given {@code 1000000}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link DelegateResourceProcessor#validate(DelegateResourceParam,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegateResourceProcessor.validate(DelegateResourceParam, Repository)"})
  public void testValidate_given1000000_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange
    DelegateResourceProcessor delegateResourceProcessor = new DelegateResourceProcessor();

    DelegateResourceParam param = new DelegateResourceParam();
    param.setDelegateBalance(1000000L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);
    param.setReceiverAddress(null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> delegateResourceProcessor.validate(param, null));
  }

  /**
   * Test {@link DelegateResourceProcessor#execute(DelegateResourceParam, Repository)}.
   *
   * <ul>
   *   <li>Given {@code TRON_POWER}.
   *   <li>Then calls {@link AccountCapsule#addDelegatedFrozenBalanceForBandwidth(long)}.
   * </ul>
   *
   * <p>Method under test: {@link DelegateResourceProcessor#execute(DelegateResourceParam,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegateResourceProcessor.execute(DelegateResourceParam, Repository)"})
  public void testExecute_givenTronPower_thenCallsAddDelegatedFrozenBalanceForBandwidth()
      throws UnsupportedEncodingException {
    // Arrange
    DelegateResourceProcessor delegateResourceProcessor = new DelegateResourceProcessor();

    DelegateResourceParam param = new DelegateResourceParam();
    param.setDelegateBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.TRON_POWER);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    delegateResourceProcessor.execute(param, repo);

    // Assert
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(42L);
    verify(accountCapsule).createDbKey();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }
}
