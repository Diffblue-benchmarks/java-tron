package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.UnfreezeBalanceV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnfreezeBalanceV2ProcessorDiffblueTest {
  /**
   * Test {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.validate(UnfreezeBalanceV2Param, Repository)"
  })
  public void testValidate_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.validate(UnfreezeBalanceV2Param, Repository)"
  })
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress(new byte[] {});
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link UnfreezeBalanceV2Param} (default constructor) OwnerAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.validate(UnfreezeBalanceV2Param, Repository)"
  })
  public void testValidate_givenNull_whenUnfreezeBalanceV2ParamOwnerAddressIsNull()
      throws ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress(null);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(42L);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.validate(UnfreezeBalanceV2Param, Repository)"
  })
  public void testValidate_givenZero_whenNull()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(0L);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, null));
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link UnfreezeBalanceV2Param} (default constructor) UnfreezeBalance is zero.
   * </ul>
   *
   * <p>Method under test: {@link UnfreezeBalanceV2Processor#validate(UnfreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.validate(UnfreezeBalanceV2Param, Repository)"
  })
  public void testValidate_givenZero_whenUnfreezeBalanceV2ParamUnfreezeBalanceIsZero()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    UnfreezeBalanceV2Param param = new UnfreezeBalanceV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setUnfreezeBalance(0L);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unfreezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode,
   * long, Repository)}.
   *
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForBandwidthV2(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode, long,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.updateTotalResourceWeight(AccountCapsule, ResourceCode, long, Repository)"
  })
  public void testUpdateTotalResourceWeight_thenCallsAddFrozenBalanceForBandwidthV2() {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any()))
        .thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(
        accountCapsule, ResourceCode.BANDWIDTH, 42L, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(-42L);
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(ResourceCode.BANDWIDTH);
    verify(repo).addTotalNetWeight(0L);
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode,
   * long, Repository)}.
   *
   * <ul>
   *   <li>When {@code ENERGY}.
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForEnergyV2(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode, long,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.updateTotalResourceWeight(AccountCapsule, ResourceCode, long, Repository)"
  })
  public void testUpdateTotalResourceWeight_whenEnergy_thenCallsAddFrozenBalanceForEnergyV2() {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).addFrozenBalanceForEnergyV2(anyLong());
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any()))
        .thenReturn(42L);

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalEnergyWeight(anyLong());

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(
        accountCapsule, ResourceCode.ENERGY, 42L, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForEnergyV2(-42L);
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(ResourceCode.ENERGY);
    verify(repo).addTotalEnergyWeight(0L);
  }

  /**
   * Test {@link UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode,
   * long, Repository)}.
   *
   * <ul>
   *   <li>When {@code TRON_POWER}.
   *   <li>Then calls {@link AccountCapsule#addFrozenForTronPowerV2(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnfreezeBalanceV2Processor#updateTotalResourceWeight(AccountCapsule, ResourceCode, long,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnfreezeBalanceV2Processor.updateTotalResourceWeight(AccountCapsule, ResourceCode, long, Repository)"
  })
  public void testUpdateTotalResourceWeight_whenTronPower_thenCallsAddFrozenForTronPowerV2() {
    // Arrange
    UnfreezeBalanceV2Processor unfreezeBalanceV2Processor = new UnfreezeBalanceV2Processor();

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getTronPowerFrozenV2Balance()).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenForTronPowerV2(anyLong());

    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalTronPowerWeight(anyLong());

    // Act
    unfreezeBalanceV2Processor.updateTotalResourceWeight(
        accountCapsule, ResourceCode.TRON_POWER, 42L, repo);

    // Assert
    verify(accountCapsule).addFrozenForTronPowerV2(-42L);
    verify(accountCapsule, atLeast(1)).getTronPowerFrozenV2Balance();
    verify(repo).addTotalTronPowerWeight(0L);
  }
}
