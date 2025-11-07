package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.FreezeBalanceV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class FreezeBalanceV2ProcessorDiffblueTest {
  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress(new byte[]{});
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link FreezeBalanceV2Param} (default constructor) FrozenBalance is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenZero_whenFreezeBalanceV2ParamFrozenBalanceIsZero() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenZero_whenNull() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, null));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#oldTronPowerIsNotInitialized()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_givenAccountCapsuleOldTronPowerIsNotInitializedReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.TRON_POWER);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getTronPowerFrozenV2Balance()).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenForTronPowerV2(anyLong());
    when(accountCapsule.oldTronPowerIsNotInitialized()).thenReturn(false);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(true);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalTronPowerWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenForTronPowerV2(eq(42L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule, atLeast(1)).getTronPowerFrozenV2Balance();
    verify(accountCapsule).oldTronPowerIsNotInitialized();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalTronPowerWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#supportAllowNewResourceModel()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_givenDynamicPropertiesStoreSupportAllowNewResourceModelReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.TRON_POWER);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getTronPowerFrozenV2Balance()).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenForTronPowerV2(anyLong());
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(false);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalTronPowerWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenForTronPowerV2(eq(42L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule, atLeast(1)).getTronPowerFrozenV2Balance();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalTronPowerWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code ENERGY}.</li>
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForEnergyV2(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_givenEnergy_thenCallsAddFrozenBalanceForEnergyV2() throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.ENERGY);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).addFrozenBalanceForEnergyV2(anyLong());
    doNothing().when(accountCapsule).initializeOldTronPower();
    when(accountCapsule.oldTronPowerIsNotInitialized()).thenReturn(true);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(true);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalEnergyWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForEnergyV2(eq(42L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.ENERGY));
    verify(accountCapsule).initializeOldTronPower();
    verify(accountCapsule).oldTronPowerIsNotInitialized();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalEnergyWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code TRON_POWER}.</li>
   *   <li>Then calls {@link AccountCapsule#addFrozenForTronPowerV2(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_givenTronPower_thenCallsAddFrozenForTronPowerV2() throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.TRON_POWER);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getTronPowerFrozenV2Balance()).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenForTronPowerV2(anyLong());
    doNothing().when(accountCapsule).initializeOldTronPower();
    when(accountCapsule.oldTronPowerIsNotInitialized()).thenReturn(true);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(true);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalTronPowerWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenForTronPowerV2(eq(42L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule, atLeast(1)).getTronPowerFrozenV2Balance();
    verify(accountCapsule).initializeOldTronPower();
    verify(accountCapsule).oldTronPowerIsNotInitialized();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalTronPowerWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code UNRECOGNIZED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_givenUnrecognized() throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.UNRECOGNIZED);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).initializeOldTronPower();
    when(accountCapsule.oldTronPowerIsNotInitialized()).thenReturn(true);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(true);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule).initializeOldTronPower();
    verify(accountCapsule).oldTronPowerIsNotInitialized();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}.
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForBandwidthV2(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Processor#execute(FreezeBalanceV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.execute(FreezeBalanceV2Param, Repository)"})
  public void testExecute_thenCallsAddFrozenBalanceForBandwidthV2() throws UnsupportedEncodingException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();
    FreezeBalanceV2Param param = mock(FreezeBalanceV2Param.class);
    when(param.getResourceType()).thenReturn(ResourceCode.BANDWIDTH);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getFrozenBalance()).thenReturn(42L);
    doNothing().when(param).setFrozenBalance(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<ResourceCode>any());
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).initializeOldTronPower();
    when(accountCapsule.oldTronPowerIsNotInitialized()).thenReturn(true);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(42L);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    doNothing().when(accountCapsule).setBalance(anyLong());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowNewResourceModel()).thenReturn(true);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    freezeBalanceV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(eq(42L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.BANDWIDTH));
    verify(accountCapsule).initializeOldTronPower();
    verify(accountCapsule).oldTronPowerIsNotInitialized();
    verify(accountCapsule).setBalance(eq(0L));
    verify(dynamicPropertiesStore).supportAllowNewResourceModel();
    verify(param).getFrozenBalance();
    verify(param).getOwnerAddress();
    verify(param).getResourceType();
    verify(param).setFrozenBalance(eq(42L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setResourceType(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalNetWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
  }
}
