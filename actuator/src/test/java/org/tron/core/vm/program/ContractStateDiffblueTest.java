package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceAccountIndexCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.store.StorageRowStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Key;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Account.Frozen;
import org.tron.protos.Protocol.AccountType;
import org.tron.protos.Protocol.DelegatedResourceAccountIndex;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractStateDiffblueTest {
  /**
   * Test {@link ContractState#ContractState(ProgramInvoke)}.
   *
   * <ul>
   *   <li>When {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link
   *       ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.<init>(ProgramInvoke)"})
  public void testNewContractState_whenContractStateWithProgramInvokeIsProgramInvokeMockImpl()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            32L,
            new ContractState(new ProgramInvokeMockImpl()),
            32L,
            32L,
            32L);

    // Act
    ContractState actualContractState = new ContractState(programInvoke);

    // Assert
    assertNull(actualContractState.getAssetIssueStore());
    assertNull(actualContractState.getAssetIssueV2Store());
    assertNull(actualContractState.getDelegationStore());
    assertNull(actualContractState.getDynamicPropertiesStore());
  }

  /**
   * Test {@link ContractState#ContractState(ProgramInvoke)}.
   *
   * <ul>
   *   <li>When {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   *   <li>Then return AssetIssueStore is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.<init>(ProgramInvoke)"})
  public void testNewContractState_whenProgramInvokeMockImpl_thenReturnAssetIssueStoreIsNull() {
    // Arrange and Act
    ContractState actualContractState = new ContractState(new ProgramInvokeMockImpl());

    // Assert
    assertNull(actualContractState.getAssetIssueStore());
    assertNull(actualContractState.getAssetIssueV2Store());
    assertNull(actualContractState.getDelegationStore());
    assertNull(actualContractState.getDynamicPropertiesStore());
  }

  /**
   * Test {@link ContractState#getAssetIssueV2Store()}.
   *
   * <p>Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.AssetIssueV2Store ContractState.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1L,
            new ContractState(new ProgramInvokeMockImpl()),
            1L,
            1L,
            1L);

    // Act and Assert
    assertNull(new ContractState(programInvoke).getAssetIssueV2Store());
  }

  /**
   * Test {@link ContractState#getAssetIssueV2Store()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.AssetIssueV2Store ContractState.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ContractState(new ProgramInvokeMockImpl()).getAssetIssueV2Store());
  }

  /**
   * Test {@link ContractState#getAssetIssueStore()}.
   *
   * <p>Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.AssetIssueStore ContractState.getAssetIssueStore()"})
  public void testGetAssetIssueStore() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1L,
            new ContractState(new ProgramInvokeMockImpl()),
            1L,
            1L,
            1L);

    // Act and Assert
    assertNull(new ContractState(programInvoke).getAssetIssueStore());
  }

  /**
   * Test {@link ContractState#getAssetIssueStore()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.AssetIssueStore ContractState.getAssetIssueStore()"})
  public void testGetAssetIssueStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ContractState(new ProgramInvokeMockImpl()).getAssetIssueStore());
  }

  /**
   * Test {@link ContractState#getDynamicPropertiesStore()}.
   *
   * <p>Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.store.DynamicPropertiesStore ContractState.getDynamicPropertiesStore()"
  })
  public void testGetDynamicPropertiesStore() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1L,
            new ContractState(new ProgramInvokeMockImpl()),
            1L,
            1L,
            1L);

    // Act and Assert
    assertNull(new ContractState(programInvoke).getDynamicPropertiesStore());
  }

  /**
   * Test {@link ContractState#getDynamicPropertiesStore()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.tron.core.store.DynamicPropertiesStore ContractState.getDynamicPropertiesStore()"
  })
  public void testGetDynamicPropertiesStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ContractState(new ProgramInvokeMockImpl()).getDynamicPropertiesStore());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], AccountType)} with {@code addr}, {@code type}.
   *
   * <ul>
   *   <li>When {@code Normal}.
   *   <li>Then return FrozenCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#createAccount(byte[], AccountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], AccountType)"})
  public void testCreateAccountWithAddrType_whenNormal_thenReturnFrozenCountIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        new ContractState(new ProgramInvokeMockImpl())
            .createAccount("AXAXAXAX".getBytes("UTF-8"), AccountType.Normal);

    // Assert
    assertEquals(0, actualCreateAccountResult.getFrozenCount());
    assertEquals(0, actualCreateAccountResult.getFrozenSupplyCount());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAllTronPower());
    assertEquals(0L, actualCreateAccountResult.getAllowance());
    assertEquals(0L, actualCreateAccountResult.getBalance());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getEnergyFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getEnergyUsage());
    assertEquals(0L, actualCreateAccountResult.getFreeNetUsage());
    assertEquals(0L, actualCreateAccountResult.getFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getFrozenSupplyBalance());
    assertEquals(0L, actualCreateAccountResult.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeFreeTime());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeTime());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualCreateAccountResult.getLatestExchangeStorageTime());
    assertEquals(0L, actualCreateAccountResult.getLatestOperationTime());
    assertEquals(0L, actualCreateAccountResult.getLatestWithdrawTime());
    assertEquals(0L, actualCreateAccountResult.getNetUsage());
    assertEquals(0L, actualCreateAccountResult.getStorageLeft());
    assertEquals(0L, actualCreateAccountResult.getStorageLimit());
    assertEquals(0L, actualCreateAccountResult.getStorageUsage());
    assertEquals(
        0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getTronPower());
    assertEquals(0L, actualCreateAccountResult.getTronPowerFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualCreateAccountResult.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualCreateAccountResult.getType());
    assertFalse(actualCreateAccountResult.getAssetOptimized());
    assertFalse(actualCreateAccountResult.getIsCommittee());
    assertFalse(actualCreateAccountResult.getIsWitness());
    List<Frozen> frozenList = actualCreateAccountResult.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualCreateAccountResult.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualCreateAccountResult.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualCreateAccountResult.getAssetMap().isEmpty());
    assertTrue(actualCreateAccountResult.getAssetMapForTest().isEmpty());
    assertTrue(actualCreateAccountResult.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualCreateAccountResult.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualCreateAccountResult.getFrozenSupplyList());
    assertSame(frozenList, actualCreateAccountResult.getFrozenV2List());
    assertSame(frozenList, actualCreateAccountResult.getUnfrozenV2List());
    assertSame(frozenList, actualCreateAccountResult.getVotesList());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(
        new byte[] {26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], String, AccountType)} with {@code address},
   * {@code accountName}, {@code type}.
   *
   * <ul>
   *   <li>Then return FrozenCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#createAccount(byte[], String, AccountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], String, AccountType)"})
  public void testCreateAccountWithAddressAccountNameType_thenReturnFrozenCountIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        new ContractState(new ProgramInvokeMockImpl())
            .createAccount("AXAXAXAX".getBytes("UTF-8"), "Dr Jane Doe", AccountType.Normal);

    // Assert
    assertEquals(0, actualCreateAccountResult.getFrozenCount());
    assertEquals(0, actualCreateAccountResult.getFrozenSupplyCount());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAcquiredDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAllFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getAllFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getAllTronPower());
    assertEquals(0L, actualCreateAccountResult.getAllowance());
    assertEquals(0L, actualCreateAccountResult.getBalance());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getDelegatedFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getEnergyFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getEnergyUsage());
    assertEquals(0L, actualCreateAccountResult.getFreeNetUsage());
    assertEquals(0L, actualCreateAccountResult.getFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getFrozenSupplyBalance());
    assertEquals(0L, actualCreateAccountResult.getFrozenV2BalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getFrozenV2BalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeFreeTime());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeTime());
    assertEquals(0L, actualCreateAccountResult.getLatestConsumeTimeForEnergy());
    assertEquals(0L, actualCreateAccountResult.getLatestExchangeStorageTime());
    assertEquals(0L, actualCreateAccountResult.getLatestOperationTime());
    assertEquals(0L, actualCreateAccountResult.getLatestWithdrawTime());
    assertEquals(0L, actualCreateAccountResult.getNetUsage());
    assertEquals(0L, actualCreateAccountResult.getStorageLeft());
    assertEquals(0L, actualCreateAccountResult.getStorageLimit());
    assertEquals(0L, actualCreateAccountResult.getStorageUsage());
    assertEquals(
        0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getTotalDelegatedFrozenBalanceForBandwidth());
    assertEquals(0L, actualCreateAccountResult.getTotalDelegatedFrozenBalanceForEnergy());
    assertEquals(0L, actualCreateAccountResult.getTronPower());
    assertEquals(0L, actualCreateAccountResult.getTronPowerFrozenBalance());
    assertEquals(0L, actualCreateAccountResult.getTronPowerFrozenV2Balance());
    assertEquals(0L, actualCreateAccountResult.getTronPowerUsage());
    assertEquals(AccountType.Normal, actualCreateAccountResult.getType());
    assertFalse(actualCreateAccountResult.getAssetOptimized());
    assertFalse(actualCreateAccountResult.getIsCommittee());
    assertFalse(actualCreateAccountResult.getIsWitness());
    List<Frozen> frozenList = actualCreateAccountResult.getFrozenList();
    assertTrue(frozenList.isEmpty());
    assertTrue(actualCreateAccountResult.getAllFreeAssetNetUsage().isEmpty());
    assertTrue(actualCreateAccountResult.getAllFreeAssetNetUsageV2().isEmpty());
    assertTrue(actualCreateAccountResult.getAssetMap().isEmpty());
    assertTrue(actualCreateAccountResult.getAssetMapForTest().isEmpty());
    assertTrue(actualCreateAccountResult.getLatestAssetOperationTimeMap().isEmpty());
    assertTrue(actualCreateAccountResult.getLatestAssetOperationTimeMapV2().isEmpty());
    assertSame(frozenList, actualCreateAccountResult.getFrozenSupplyList());
    assertSame(frozenList, actualCreateAccountResult.getFrozenV2List());
    assertSame(frozenList, actualCreateAccountResult.getUnfrozenV2List());
    assertSame(frozenList, actualCreateAccountResult.getVotesList());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(
        new byte[] {
          '\n', 11, 'D', 'r', ' ', 'J', 'a', 'n', 'e', ' ', 'D', 'o', 'e', 26, '\b', 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#getDynamicProperty(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getDynamicProperty(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BytesCapsule ContractState.getDynamicProperty(byte[])"})
  public void testGetDynamicProperty() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    BytesCapsule actualDynamicProperty =
        contractState.getDynamicProperty("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertSame(bytesCapsule, actualDynamicProperty);
  }

  /**
   * Test {@link ContractState#getDynamicProperty(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getDynamicProperty(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BytesCapsule ContractState.getDynamicProperty(byte[])"})
  public void testGetDynamicProperty2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    BytesCapsule actualDynamicProperty =
        contractState.getDynamicProperty("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertSame(bytesCapsule, actualDynamicProperty);
  }

  /**
   * Test {@link ContractState#getWitness(byte[])}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getWitness(byte[])} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getWitness(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WitnessCapsule ContractState.getWitness(byte[])"})
  public void testGetWitness_givenRepositoryImplGetWitnessReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getWitness(Mockito.<byte[]>any())).thenReturn(null);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    WitnessCapsule actualWitness =
        new ContractState(programInvoke).getWitness("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(deposit).getWitness(isA(byte[].class));
    assertNull(actualWitness);
  }

  /**
   * Test {@link ContractState#deleteContract(byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link RepositoryImpl#deleteContract(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#deleteContract(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.deleteContract(byte[])"})
  public void testDeleteContract_thenCallsDeleteContract() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).deleteContract(Mockito.<byte[]>any());
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    new ContractState(programInvoke).deleteContract("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(deposit).deleteContract(isA(byte[].class));
  }

  /**
   * Test {@link ContractState#getContractState(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getContractState(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContractStateCapsule ContractState.getContractState(byte[])"})
  public void testGetContractState() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContractState(Mockito.<byte[]>any()))
        .thenReturn(new ContractStateCapsule(1L));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    ContractStateCapsule actualContractState =
        contractState.getContractState("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getContractState(isA(byte[].class));
    SmartContractOuterClass.ContractState instance = actualContractState.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    SmartContractOuterClass.ContractState defaultInstanceForType =
        instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {24, 1}, actualContractState.getData());
  }

  /**
   * Test {@link ContractState#getContractState(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getContractState(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContractStateCapsule ContractState.getContractState(byte[])"})
  public void testGetContractState2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContractState(Mockito.<byte[]>any()))
        .thenReturn(new ContractStateCapsule(1L));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    ContractStateCapsule actualContractState =
        contractState.getContractState("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getContractState(isA(byte[].class));
    SmartContractOuterClass.ContractState instance = actualContractState.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    SmartContractOuterClass.ContractState defaultInstanceForType =
        instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {24, 1}, actualContractState.getData());
  }

  /**
   * Test {@link ContractState#getCode(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractState.getCode(byte[])"})
  public void testGetCode() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    byte[] actualCode = contractState.getCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Test {@link ContractState#getCode(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractState.getCode(byte[])"})
  public void testGetCode2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    byte[] actualCode = contractState.getCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Test {@link ContractState#getBalance(byte[])}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getAccount(byte[])} return {@code
   *       null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getBalance(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getBalance(byte[])"})
  public void testGetBalance_givenRepositoryImplGetAccountReturnNull_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(null);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualBalance = contractState.getBalance("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualBalance);
  }

  /**
   * Test {@link ContractState#addBalance(byte[], long)}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getAccount(byte[])} return {@code
   *       null}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#addBalance(byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.addBalance(byte[], long)"})
  public void testAddBalance_givenRepositoryImplGetAccountReturnNull_thenReturnFortyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(null);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualAddBalanceResult = contractState.addBalance("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(42L, actualAddBalanceResult);
  }

  /**
   * Test {@link ContractState#newRepositoryChild()}.
   *
   * <p>Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Repository ContractState.newRepositoryChild()"})
  public void testNewRepositoryChild() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A@A@A@A@".getBytes("UTF-8");
    byte[] origin = "A@A@A@A@".getBytes("UTF-8");
    byte[] caller = "A@A@A@A@".getBytes("UTF-8");
    byte[] msgData = "A@A@A@A@".getBytes("UTF-8");
    byte[] lastHash = "A@A@A@A@".getBytes("UTF-8");
    byte[] coinbase = "A@A@A@A@".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1000000L,
            new ContractState(new ProgramInvokeMockImpl()),
            1000000L,
            1000000L,
            1000000L);

    // Act
    Repository actualNewRepositoryChildResult =
        new ContractState(programInvoke).newRepositoryChild();

    // Assert
    assertTrue(actualNewRepositoryChildResult instanceof RepositoryImpl);
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getBlockIndexStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getBlockStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getKhaosDb());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getAbiStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getAccountStore());
    assertNull(actualNewRepositoryChildResult.getAssetIssueStore());
    assertNull(actualNewRepositoryChildResult.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getCodeStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getContractStateStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getContractStore());
    assertNull(
        ((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceStore());
    assertNull(actualNewRepositoryChildResult.getDelegationStore());
    assertNull(actualNewRepositoryChildResult.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getStorageRowStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getVotesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getWitnessStore());
  }

  /**
   * Test {@link ContractState#newRepositoryChild()}.
   *
   * <ul>
   *   <li>Then return {@link RepositoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Repository ContractState.newRepositoryChild()"})
  public void testNewRepositoryChild_thenReturnRepositoryImpl() {
    // Arrange and Act
    Repository actualNewRepositoryChildResult =
        new ContractState(new ProgramInvokeMockImpl()).newRepositoryChild();

    // Assert
    assertTrue(actualNewRepositoryChildResult instanceof RepositoryImpl);
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getBlockIndexStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getBlockStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getKhaosDb());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getAbiStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getAccountStore());
    assertNull(actualNewRepositoryChildResult.getAssetIssueStore());
    assertNull(actualNewRepositoryChildResult.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getCodeStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getContractStateStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getContractStore());
    assertNull(
        ((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceStore());
    assertNull(actualNewRepositoryChildResult.getDelegationStore());
    assertNull(actualNewRepositoryChildResult.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getStorageRowStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getVotesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getWitnessStore());
  }

  /**
   * Test {@link ContractState#getStorage(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getStorage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Storage ContractState.getStorage(byte[])"})
  public void testGetStorage() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any())).thenReturn(null);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    when(repository.getStorage(Mockito.<byte[]>any())).thenReturn(storage);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    Storage actualStorage = contractState.getStorage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository, atLeast(1)).getContract(isA(byte[].class));
    verify(repository).getStorage(isA(byte[].class));
    assertSame(storage, actualStorage);
  }

  /**
   * Test {@link ContractState#getStorage(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getStorage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Storage ContractState.getStorage(byte[])"})
  public void testGetStorage2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any())).thenReturn(null);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    when(repository.getStorage(Mockito.<byte[]>any())).thenReturn(storage);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1L,
            new ContractState(new ProgramInvokeMockImpl()),
            1L,
            1L,
            1L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    Storage actualStorage = contractState.getStorage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository, atLeast(1)).getContract(isA(byte[].class));
    verify(repository).getStorage(isA(byte[].class));
    assertSame(storage, actualStorage);
  }

  /**
   * Test {@link ContractState#getBlackHoleAddress()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getBlackHoleAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractState.getBlackHoleAddress()"})
  public void testGetBlackHoleAddress_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getBlackHoleAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    byte[] actualBlackHoleAddress = new ContractState(programInvoke).getBlackHoleAddress();

    // Assert
    verify(deposit).getBlackHoleAddress();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBlackHoleAddress);
  }

  /**
   * Test {@link ContractState#getBlockByNum(long)}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getBlockByNum(long)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getBlockByNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockCapsule ContractState.getBlockByNum(long)"})
  public void testGetBlockByNum_givenRepositoryImplGetBlockByNumReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getBlockByNum(anyLong())).thenReturn(null);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    BlockCapsule actualBlockByNum = new ContractState(programInvoke).getBlockByNum(1L);

    // Assert
    verify(deposit).getBlockByNum(1L);
    assertNull(actualBlockByNum);
  }

  /**
   * Test {@link ContractState#createNormalAccount(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#createNormalAccount(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountCapsule ContractState.createNormalAccount(byte[])"})
  public void testCreateNormalAccount_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.createNormalAccount(Mockito.<byte[]>any())).thenReturn(null);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    AccountCapsule actualCreateNormalAccountResult =
        new ContractState(programInvoke).createNormalAccount("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(deposit).createNormalAccount(isA(byte[].class));
    assertNull(actualCreateNormalAccountResult);
  }

  /**
   * Test {@link ContractState#getDelegationStore()}.
   *
   * <p>Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.DelegationStore ContractState.getDelegationStore()"})
  public void testGetDelegationStore() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            1L,
            new ContractState(new ProgramInvokeMockImpl()),
            1L,
            1L,
            1L);

    // Act and Assert
    assertNull(new ContractState(programInvoke).getDelegationStore());
  }

  /**
   * Test {@link ContractState#getDelegationStore()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.store.DelegationStore ContractState.getDelegationStore()"})
  public void testGetDelegationStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ContractState(new ProgramInvokeMockImpl()).getDelegationStore());
  }

  /**
   * Test {@link ContractState#getBeginCycle(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getBeginCycle(byte[])"})
  public void testGetBeginCycle() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualBeginCycle = contractState.getBeginCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(0L, actualBeginCycle);
  }

  /**
   * Test {@link ContractState#getBeginCycle(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getBeginCycle(byte[])"})
  public void testGetBeginCycle2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    long actualBeginCycle = contractState.getBeginCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualBeginCycle);
  }

  /**
   * Test {@link ContractState#getBeginCycle(byte[])}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getDelegation(Key)} return {@code
   *       null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getBeginCycle(byte[])"})
  public void testGetBeginCycle_givenRepositoryImplGetDelegationReturnNull_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(null);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualBeginCycle = contractState.getBeginCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(0L, actualBeginCycle);
  }

  /**
   * Test {@link ContractState#getBeginCycle(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getBeginCycle(byte[])"})
  public void testGetBeginCycle_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualBeginCycle = contractState.getBeginCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualBeginCycle);
  }

  /**
   * Test {@link ContractState#getEndCycle(byte[])}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getEndCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getEndCycle(byte[])"})
  public void testGetEndCycle_givenA_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[] {'A', 20, 'A', 20, 'A', 20, 'A', 20},
            10L,
            20L,
            new ContractState(new ProgramInvokeMockImpl()),
            20L,
            20L,
            20L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    long actualEndCycle = contractState.getEndCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualEndCycle);
  }

  /**
   * Test {@link ContractState#getEndCycle(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getEndCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getEndCycle(byte[])"})
  public void testGetEndCycle_thenReturn4708585257725083992() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualEndCycle = contractState.getEndCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualEndCycle);
  }

  /**
   * Test {@link ContractState#getEndCycle(byte[])}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getEndCycle(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getEndCycle(byte[])"})
  public void testGetEndCycle_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualEndCycle = contractState.getEndCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(0L, actualEndCycle);
  }

  /**
   * Test {@link ContractState#getAccountVote(long, byte[])}.
   *
   * <p>Method under test: {@link ContractState#getAccountVote(long, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountCapsule ContractState.getAccountVote(long, byte[])"})
  public void testGetAccountVote() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    AccountCapsule actualAccountVote =
        contractState.getAccountVote(3L, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertNull(actualAccountVote.getInstance());
  }

  /**
   * Test {@link ContractState#getAccountVote(long, byte[])}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getAccountVote(long, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountCapsule ContractState.getAccountVote(long, byte[])"})
  public void testGetAccountVote_givenA_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[] {'A', 31, 'A', 31, 'A', 31, 'A', 31},
            10L,
            31L,
            new ContractState(new ProgramInvokeMockImpl()),
            31L,
            31L,
            31L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    AccountCapsule actualAccountVote =
        contractState.getAccountVote(3L, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertNull(actualAccountVote.getInstance());
  }

  /**
   * Test {@link ContractState#getDelegation(Key)}.
   *
   * <p>Method under test: {@link ContractState#getDelegation(Key)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BytesCapsule ContractState.getDelegation(Key)"})
  public void testGetDelegation() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    BytesCapsule actualDelegation =
        contractState.getDelegation(new Key("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertSame(bytesCapsule, actualDelegation);
  }

  /**
   * Test {@link ContractState#getDelegation(Key)}.
   *
   * <p>Method under test: {@link ContractState#getDelegation(Key)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BytesCapsule ContractState.getDelegation(Key)"})
  public void testGetDelegation2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    BytesCapsule actualDelegation =
        contractState.getDelegation(new Key("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertSame(bytesCapsule, actualDelegation);
  }

  /**
   * Test {@link ContractState#getDelegatedResourceAccountIndex(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getDelegatedResourceAccountIndex(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DelegatedResourceAccountIndexCapsule ContractState.getDelegatedResourceAccountIndex(byte[])"
  })
  public void testGetDelegatedResourceAccountIndex() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegatedResourceAccountIndex(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceAccountIndexCapsule(mock(ByteString.class)));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndex =
        contractState.getDelegatedResourceAccountIndex("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegatedResourceAccountIndex(isA(byte[].class));
    DelegatedResourceAccountIndex instance = actualDelegatedResourceAccountIndex.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {'\n', 0}, actualDelegatedResourceAccountIndex.getData());
  }

  /**
   * Test {@link ContractState#getDelegatedResourceAccountIndex(byte[])}.
   *
   * <p>Method under test: {@link ContractState#getDelegatedResourceAccountIndex(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DelegatedResourceAccountIndexCapsule ContractState.getDelegatedResourceAccountIndex(byte[])"
  })
  public void testGetDelegatedResourceAccountIndex2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegatedResourceAccountIndex(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceAccountIndexCapsule(mock(ByteString.class)));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");

    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            msgData,
            lastHash,
            coinbase,
            10L,
            8L,
            new ContractState(new ProgramInvokeMockImpl()),
            8L,
            8L,
            8L);

    ContractState contractState = new ContractState(programInvoke);
    contractState.setParent(repository2);

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndex =
        contractState.getDelegatedResourceAccountIndex("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegatedResourceAccountIndex(isA(byte[].class));
    DelegatedResourceAccountIndex instance = actualDelegatedResourceAccountIndex.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {'\n', 0}, actualDelegatedResourceAccountIndex.getData());
  }

  /**
   * Test {@link ContractState#addTotalNetWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalNetWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalNetWeight(long)"})
  public void testAddTotalNetWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalNetWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalNetWeight());
  }

  /**
   * Test {@link ContractState#addTotalNetWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalNetWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalNetWeight(long)"})
  public void testAddTotalNetWeight2() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalNetWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(10L, contractState.getTotalNetWeight());
  }

  /**
   * Test {@link ContractState#addTotalEnergyWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalEnergyWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalEnergyWeight(long)"})
  public void testAddTotalEnergyWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalEnergyWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalEnergyWeight());
  }

  /**
   * Test {@link ContractState#addTotalEnergyWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalEnergyWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalEnergyWeight(long)"})
  public void testAddTotalEnergyWeight2() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalEnergyWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(10L, contractState.getTotalEnergyWeight());
  }

  /**
   * Test {@link ContractState#addTotalTronPowerWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalTronPowerWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalTronPowerWeight(long)"})
  public void testAddTotalTronPowerWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalTronPowerWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Test {@link ContractState#addTotalTronPowerWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#addTotalTronPowerWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.addTotalTronPowerWeight(long)"})
  public void testAddTotalTronPowerWeight2() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    contractState.addTotalTronPowerWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(10L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Test {@link ContractState#saveTotalNetWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalNetWeight(long)"})
  public void testSaveTotalNetWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalNetWeight());
  }

  /**
   * Test {@link ContractState#saveTotalNetWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalNetWeight(long)"})
  public void testSaveTotalNetWeight2() {
    // Arrange
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[] {'A', 16, 'A', 16, 'A', 16, 'A', 16},
            10L,
            16L,
            new ContractState(new ProgramInvokeMockImpl()),
            16L,
            16L,
            16L);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalNetWeight());
  }

  /**
   * Test {@link ContractState#saveTotalEnergyWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalEnergyWeight(long)"})
  public void testSaveTotalEnergyWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalEnergyWeight());
  }

  /**
   * Test {@link ContractState#saveTotalEnergyWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalEnergyWeight(long)"})
  public void testSaveTotalEnergyWeight2() {
    // Arrange
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[] {'A', 19, 'A', 19, 'A', 19, 'A', 19},
            10L,
            19L,
            new ContractState(new ProgramInvokeMockImpl()),
            19L,
            19L,
            19L);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalEnergyWeight());
  }

  /**
   * Test {@link ContractState#saveTotalTronPowerWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalTronPowerWeight(long)"})
  public void testSaveTotalTronPowerWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Test {@link ContractState#saveTotalTronPowerWeight(long)}.
   *
   * <p>Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractState.saveTotalTronPowerWeight(long)"})
  public void testSaveTotalTronPowerWeight2() {
    // Arrange
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[] {'A', 23, 'A', 23, 'A', 23, 'A', 23},
            10L,
            23L,
            new ContractState(new ProgramInvokeMockImpl()),
            23L,
            23L,
            23L);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Test {@link ContractState#getTotalNetWeight()}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalNetWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalNetWeight()"})
  public void testGetTotalNetWeight_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalNetWeight = contractState.getTotalNetWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalNetWeight);
  }

  /**
   * Test {@link ContractState#getTotalNetWeight()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalNetWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalNetWeight()"})
  public void testGetTotalNetWeight_thenReturnZero() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalNetWeight = contractState.getTotalNetWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualTotalNetWeight);
  }

  /**
   * Test {@link ContractState#getTotalEnergyWeight()}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalEnergyWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalEnergyWeight()"})
  public void testGetTotalEnergyWeight_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalEnergyWeight = contractState.getTotalEnergyWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalEnergyWeight);
  }

  /**
   * Test {@link ContractState#getTotalEnergyWeight()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalEnergyWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalEnergyWeight()"})
  public void testGetTotalEnergyWeight_thenReturnZero() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalEnergyWeight = contractState.getTotalEnergyWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualTotalEnergyWeight);
  }

  /**
   * Test {@link ContractState#getTotalTronPowerWeight()}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalTronPowerWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalTronPowerWeight()"})
  public void testGetTotalTronPowerWeight_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalTronPowerWeight = contractState.getTotalTronPowerWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalTronPowerWeight);
  }

  /**
   * Test {@link ContractState#getTotalTronPowerWeight()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getTotalTronPowerWeight()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getTotalTronPowerWeight()"})
  public void testGetTotalTronPowerWeight_thenReturnZero() {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl repository2 = new RepositoryImpl(StoreFactory.getInstance(), repository);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository2);

    // Act
    long actualTotalTronPowerWeight = contractState.getTotalTronPowerWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualTotalTronPowerWeight);
  }

  /**
   * Test {@link ContractState#getHeadSlot()}.
   *
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getHeadSlot()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getHeadSlot()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getHeadSlot()"})
  public void testGetHeadSlot_givenRepositoryImplGetHeadSlotReturnOne_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getHeadSlot()).thenReturn(1L);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    long actualHeadSlot = new ContractState(programInvoke).getHeadSlot();

    // Assert
    verify(deposit).getHeadSlot();
    assertEquals(1L, actualHeadSlot);
  }

  /**
   * Test {@link ContractState#getSlotByTimestampMs(long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ContractState#getSlotByTimestampMs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractState.getSlotByTimestampMs(long)"})
  public void testGetSlotByTimestampMs_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getSlotByTimestampMs(anyLong())).thenReturn(1L);
    ProgramInvokeImpl programInvoke =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act
    long actualSlotByTimestampMs = new ContractState(programInvoke).getSlotByTimestampMs(10L);

    // Assert
    verify(deposit).getSlotByTimestampMs(10L);
    assertEquals(1L, actualSlotByTimestampMs);
  }
}
