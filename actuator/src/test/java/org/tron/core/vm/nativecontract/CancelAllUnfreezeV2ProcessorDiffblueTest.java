package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
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
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.CancelAllUnfreezeV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Account.UnFreezeV2;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class CancelAllUnfreezeV2ProcessorDiffblueTest {
  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"
  })
  public void testValidate_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, repo));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"
  })
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(new byte[] {});
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, repo));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CancelAllUnfreezeV2Param} (default constructor) OwnerAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"
  })
  public void testValidate_givenNull_whenCancelAllUnfreezeV2ParamOwnerAddressIsNull()
      throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, repo));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"
  })
  public void testValidate_givenNull_whenNull() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, null));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * UnFreezeV2, Repository)}.
   *
   * <p>Method under test: {@link
   * CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"
  })
  public void testUpdateFrozenInfoAndTotalResourceWeight() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any()))
        .thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    UnFreezeV2 unFreezeV2 = UnFreezeV2.getDefaultInstance();

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(
        accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(0L);
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(ResourceCode.BANDWIDTH);
    verify(repo).addTotalNetWeight(0L);
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * UnFreezeV2, Repository)}.
   *
   * <ul>
   *   <li>Given {@code BANDWIDTH}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"
  })
  public void testUpdateFrozenInfoAndTotalResourceWeight_givenBandwidth() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any()))
        .thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());

    UnFreezeV2 unFreezeV2 = mock(UnFreezeV2.class);
    when(unFreezeV2.getUnfreezeAmount()).thenReturn(1L);
    when(unFreezeV2.getType()).thenReturn(ResourceCode.BANDWIDTH);

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(
        accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(1L);
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(ResourceCode.BANDWIDTH);
    verify(repo).addTotalNetWeight(0L);
    verify(unFreezeV2).getType();
    verify(unFreezeV2).getUnfreezeAmount();
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * UnFreezeV2, Repository)}.
   *
   * <ul>
   *   <li>Given {@code UNRECOGNIZED}.
   *   <li>When {@link AccountCapsule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"
  })
  public void testUpdateFrozenInfoAndTotalResourceWeight_givenUnrecognized_whenAccountCapsule() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);

    UnFreezeV2 unFreezeV2 = mock(UnFreezeV2.class);
    when(unFreezeV2.getType()).thenReturn(ResourceCode.UNRECOGNIZED);

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(
        accountCapsule, unFreezeV2, mock(RepositoryImpl.class));

    // Assert
    verify(unFreezeV2).getType();
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * UnFreezeV2, Repository)}.
   *
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForEnergyV2(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"
  })
  public void testUpdateFrozenInfoAndTotalResourceWeight_thenCallsAddFrozenBalanceForEnergyV2() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).addFrozenBalanceForEnergyV2(anyLong());
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any()))
        .thenReturn(42L);

    UnFreezeV2 unFreezeV2 = mock(UnFreezeV2.class);
    when(unFreezeV2.getUnfreezeAmount()).thenReturn(1L);
    when(unFreezeV2.getType()).thenReturn(ResourceCode.ENERGY);

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalEnergyWeight(anyLong());

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(
        accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForEnergyV2(1L);
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(ResourceCode.ENERGY);
    verify(repo).addTotalEnergyWeight(0L);
    verify(unFreezeV2).getType();
    verify(unFreezeV2).getUnfreezeAmount();
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * UnFreezeV2, Repository)}.
   *
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addFrozenForTronPowerV2(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule,
   * Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"
  })
  public void testUpdateFrozenInfoAndTotalResourceWeight_thenCallsAddFrozenForTronPowerV2() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getTronPowerFrozenV2Balance()).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenForTronPowerV2(anyLong());

    UnFreezeV2 unFreezeV2 = mock(UnFreezeV2.class);
    when(unFreezeV2.getUnfreezeAmount()).thenReturn(1L);
    when(unFreezeV2.getType()).thenReturn(ResourceCode.TRON_POWER);

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalTronPowerWeight(anyLong());

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(
        accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenForTronPowerV2(1L);
    verify(accountCapsule, atLeast(1)).getTronPowerFrozenV2Balance();
    verify(repo).addTotalTronPowerWeight(0L);
    verify(unFreezeV2).getType();
    verify(unFreezeV2).getUnfreezeAmount();
  }
}
