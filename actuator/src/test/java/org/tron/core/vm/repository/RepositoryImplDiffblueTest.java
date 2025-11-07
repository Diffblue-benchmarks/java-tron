package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.ProtoCapsule;
import org.tron.core.db.BlockIndexStore;
import org.tron.core.db.BlockStore;
import org.tron.core.db.KhaosDatabase;
import org.tron.core.store.AbiStore;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.CodeStore;
import org.tron.core.store.ContractStateStore;
import org.tron.core.store.ContractStore;
import org.tron.core.store.DelegatedResourceAccountIndexStore;
import org.tron.core.store.DelegatedResourceStore;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StorageRowStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.store.VotesStore;
import org.tron.core.vm.program.Storage;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Account.Frozen;
import org.tron.protos.Protocol.AccountType;

public class RepositoryImplDiffblueTest {
  /**
   * Test {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}.
   * <p>
   * Method under test: {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.<init>(StoreFactory, RepositoryImpl)"})
  public void testNewRepositoryImpl() {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();

    // Act
    RepositoryImpl actualRepositoryImpl = new RepositoryImpl(storeFactory,
        RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Assert
    assertNull(actualRepositoryImpl.getBlockIndexStore());
    assertNull(actualRepositoryImpl.getBlockStore());
    assertNull(actualRepositoryImpl.getKhaosDb());
    assertNull(actualRepositoryImpl.getAbiStore());
    assertNull(actualRepositoryImpl.getAccountStore());
    assertNull(actualRepositoryImpl.getAssetIssueStore());
    assertNull(actualRepositoryImpl.getAssetIssueV2Store());
    assertNull(actualRepositoryImpl.getCodeStore());
    assertNull(actualRepositoryImpl.getContractStateStore());
    assertNull(actualRepositoryImpl.getContractStore());
    assertNull(actualRepositoryImpl.getDelegatedResourceAccountIndexStore());
    assertNull(actualRepositoryImpl.getDelegatedResourceStore());
    assertNull(actualRepositoryImpl.getDelegationStore());
    assertNull(actualRepositoryImpl.getDynamicPropertiesStore());
    assertNull(actualRepositoryImpl.getStorageRowStore());
    assertNull(actualRepositoryImpl.getVotesStore());
    assertNull(actualRepositoryImpl.getWitnessStore());
  }

  /**
   * Test {@link RepositoryImpl#createRoot(StoreFactory)}.
   * <p>
   * Method under test: {@link RepositoryImpl#createRoot(StoreFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RepositoryImpl RepositoryImpl.createRoot(StoreFactory)"})
  public void testCreateRoot() {
    // Arrange and Act
    RepositoryImpl actualCreateRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Assert
    assertNull(actualCreateRootResult.getBlockIndexStore());
    assertNull(actualCreateRootResult.getBlockStore());
    assertNull(actualCreateRootResult.getKhaosDb());
    assertNull(actualCreateRootResult.getAbiStore());
    assertNull(actualCreateRootResult.getAccountStore());
    assertNull(actualCreateRootResult.getAssetIssueStore());
    assertNull(actualCreateRootResult.getAssetIssueV2Store());
    assertNull(actualCreateRootResult.getCodeStore());
    assertNull(actualCreateRootResult.getContractStateStore());
    assertNull(actualCreateRootResult.getContractStore());
    assertNull(actualCreateRootResult.getDelegatedResourceAccountIndexStore());
    assertNull(actualCreateRootResult.getDelegatedResourceStore());
    assertNull(actualCreateRootResult.getDelegationStore());
    assertNull(actualCreateRootResult.getDynamicPropertiesStore());
    assertNull(actualCreateRootResult.getStorageRowStore());
    assertNull(actualCreateRootResult.getVotesStore());
    assertNull(actualCreateRootResult.getWitnessStore());
  }

  /**
   * Test {@link RepositoryImpl#newRepositoryChild()}.
   * <p>
   * Method under test: {@link RepositoryImpl#newRepositoryChild()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Repository RepositoryImpl.newRepositoryChild()"})
  public void testNewRepositoryChild() {
    // Arrange and Act
    Repository actualNewRepositoryChildResult = RepositoryImpl.createRoot(StoreFactory.getInstance())
        .newRepositoryChild();

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
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getDelegatedResourceStore());
    assertNull(actualNewRepositoryChildResult.getDelegationStore());
    assertNull(actualNewRepositoryChildResult.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getStorageRowStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getVotesStore());
    assertNull(((RepositoryImpl) actualNewRepositoryChildResult).getWitnessStore());
  }

  /**
   * Test {@link RepositoryImpl#createAccount(byte[], String, AccountType)} with {@code address}, {@code accountName}, {@code type}.
   * <ul>
   *   <li>Then return FrozenCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#createAccount(byte[], String, AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule RepositoryImpl.createAccount(byte[], String, AccountType)"})
  public void testCreateAccountWithAddressAccountNameType_thenReturnFrozenCountIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    AccountCapsule actualCreateAccountResult = createRootResult.createAccount("AXAXAXAX".getBytes("UTF-8"),
        "Dr Jane Doe", AccountType.Normal);

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
    assertEquals(0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
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
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{'\n', 11, 'D', 'r', ' ', 'J', 'a', 'n', 'e', ' ', 'D', 'o', 'e', 26, '\b', 'A', 'X',
        'A', 'X', 'A', 'X', 'A', 'X'}, actualCreateAccountResult.getData());
  }

  /**
   * Test {@link RepositoryImpl#createAccount(byte[], AccountType)} with {@code address}, {@code type}.
   * <ul>
   *   <li>Then return FrozenCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#createAccount(byte[], AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule RepositoryImpl.createAccount(byte[], AccountType)"})
  public void testCreateAccountWithAddressType_thenReturnFrozenCountIsZero() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    AccountCapsule actualCreateAccountResult = createRootResult.createAccount("AXAXAXAX".getBytes("UTF-8"),
        AccountType.Normal);

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
    assertEquals(0L, actualCreateAccountResult.getTotalAcquiredDelegatedFrozenBalanceForBandwidth());
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
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl = new RepositoryImpl(storeFactory,
        RepositoryImpl.createRoot(StoreFactory.getInstance()));
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    createRootResult.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit4() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit5() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit6() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit7() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit8() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 2);
    ProtoCapsule<Object> capsule9 = mock(ProtoCapsule.class);
    when(capsule9.getInstance()).thenReturn("Instance");
    Value<Object> value9 = Value.create(capsule9, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(Key.create("AXAXAXAX".getBytes("UTF-8")), value9);
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule9).getInstance();
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit9() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 2);
    ProtoCapsule<Object> capsule9 = mock(ProtoCapsule.class);
    when(capsule9.getInstance()).thenReturn("Instance");
    Value<Object> value9 = Value.create(capsule9, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(null, value9);
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule9).getInstance();
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit10() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 2);
    ProtoCapsule<Object> capsule9 = mock(ProtoCapsule.class);
    when(capsule9.getInstance()).thenReturn("Instance");
    Value<Object> value9 = Value.create(capsule9, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(Key.create("AXAXAXAX".getBytes("UTF-8")), value9);
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule9).getInstance();
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit11() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 2);
    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 2);
    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 2);
    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 2);
    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 2);
    ProtoCapsule<Object> capsule9 = mock(ProtoCapsule.class);
    when(capsule9.getInstance()).thenReturn("Instance");
    Value<Object> value9 = Value.create(capsule9, 0);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(Key.create("AXAXAXAX".getBytes("UTF-8")), value9);
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule9).getInstance();
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <ul>
   *   <li>Then calls {@link ProtoCapsule#getInstance()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit_thenCallsGetInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   * <ul>
   *   <li>Then calls {@link ProtoCapsule#getInstance()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit_thenCallsGetInstance2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 2);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    createRootResult.commit();

    // Assert
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putAccount(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putAccount(Key, Value)"})
  public void testPutAccount_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putAccount(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putAccount(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putAccount(Key, Value)"})
  public void testPutAccount_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putAccount(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putAccount(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putAccount(Key, Value)"})
  public void testPutAccount_givenProtoCapsuleGetInstanceReturnInstance_whenNull() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putAccount(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putCode(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putCode(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putCode(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putCode(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putCode(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenProtoCapsuleGetInstanceReturnInstance_whenNull() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putCode(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContract(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContract(Key, Value)"})
  public void testPutContract_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putContract(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContract(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContract(Key, Value)"})
  public void testPutContract_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putContract(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContract(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContract(Key, Value)"})
  public void testPutContract_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putContract(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContractState(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContractState(Key, Value)"})
  public void testPutContractState_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putContractState(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContractState(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContractState(Key, Value)"})
  public void testPutContractState_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putContractState(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putContractState(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContractState(Key, Value)"})
  public void testPutContractState_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putContractState(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDynamicProperty(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDynamicProperty(Key, Value)"})
  public void testPutDynamicProperty_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putDynamicProperty(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDynamicProperty(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDynamicProperty(Key, Value)"})
  public void testPutDynamicProperty_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDynamicProperty(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDynamicProperty(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDynamicProperty(Key, Value)"})
  public void testPutDynamicProperty_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDynamicProperty(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDynamicProperty(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResource(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResource(Key, Value)"})
  public void testPutDelegatedResource_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putDelegatedResource(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResource(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResource(Key, Value)"})
  public void testPutDelegatedResource_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegatedResource(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResource(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResource(Key, Value)"})
  public void testPutDelegatedResource_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResource(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegatedResource(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putVotes(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putVotes(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putVotes(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putVotes(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putVotes(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenProtoCapsuleGetInstanceReturnInstance_whenNull() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putVotes(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putVotes(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegation(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegation(Key, Value)"})
  public void testPutDelegation_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putDelegation(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegation(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegation(Key, Value)"})
  public void testPutDelegation_givenProtoCapsuleGetInstanceReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegation(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegation(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegation(Key, Value)"})
  public void testPutDelegation_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegation(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}.
   * <ul>
   *   <li>Given createRoot Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResourceAccountIndex(Key, Value)"})
  public void testPutDelegatedResourceAccountIndex_givenCreateRootInstance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    // Act
    createRootResult.putDelegatedResourceAccountIndex(key, value);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}.
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResourceAccountIndex(Key, Value)"})
  public void testPutDelegatedResourceAccountIndex_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegatedResourceAccountIndex(key, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResourceAccountIndex(Key, Value)"})
  public void testPutDelegatedResourceAccountIndex_whenNull() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putDelegatedResourceAccountIndex(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    // Act
    createRootResult.putDelegatedResourceAccountIndex(null, value2);

    // Assert
    verify(capsule).getInstance();
    verify(capsule2).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#saveTotalNetWeight(long)}.
   * <p>
   * Method under test: {@link RepositoryImpl#saveTotalNetWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.saveTotalNetWeight(long)"})
  public void testSaveTotalNetWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalNetWeight());
  }

  /**
   * Test {@link RepositoryImpl#saveTotalEnergyWeight(long)}.
   * <p>
   * Method under test: {@link RepositoryImpl#saveTotalEnergyWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.saveTotalEnergyWeight(long)"})
  public void testSaveTotalEnergyWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalEnergyWeight());
  }

  /**
   * Test {@link RepositoryImpl#saveTotalTronPowerWeight(long)}.
   * <p>
   * Method under test: {@link RepositoryImpl#saveTotalTronPowerWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.saveTotalTronPowerWeight(long)"})
  public void testSaveTotalTronPowerWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalTronPowerWeight());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepositoryImpl#setParent(Repository)}
   *   <li>{@link RepositoryImpl#removeLruCache(byte[])}
   *   <li>{@link RepositoryImpl#getAbiStore()}
   *   <li>{@link RepositoryImpl#getAccountStore()}
   *   <li>{@link RepositoryImpl#getAssetIssueStore()}
   *   <li>{@link RepositoryImpl#getAssetIssueV2Store()}
   *   <li>{@link RepositoryImpl#getBlockIndexStore()}
   *   <li>{@link RepositoryImpl#getBlockStore()}
   *   <li>{@link RepositoryImpl#getCodeStore()}
   *   <li>{@link RepositoryImpl#getContractStateStore()}
   *   <li>{@link RepositoryImpl#getContractStore()}
   *   <li>{@link RepositoryImpl#getDelegatedResourceAccountIndexStore()}
   *   <li>{@link RepositoryImpl#getDelegatedResourceStore()}
   *   <li>{@link RepositoryImpl#getDelegationStore()}
   *   <li>{@link RepositoryImpl#getDynamicPropertiesStore()}
   *   <li>{@link RepositoryImpl#getKhaosDb()}
   *   <li>{@link RepositoryImpl#getStorageRowStore()}
   *   <li>{@link RepositoryImpl#getVotesStore()}
   *   <li>{@link RepositoryImpl#getWitnessStore()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AbiStore RepositoryImpl.getAbiStore()", "AccountStore RepositoryImpl.getAccountStore()",
      "AssetIssueStore RepositoryImpl.getAssetIssueStore()", "AssetIssueV2Store RepositoryImpl.getAssetIssueV2Store()",
      "BlockIndexStore RepositoryImpl.getBlockIndexStore()", "BlockStore RepositoryImpl.getBlockStore()",
      "CodeStore RepositoryImpl.getCodeStore()", "ContractStateStore RepositoryImpl.getContractStateStore()",
      "ContractStore RepositoryImpl.getContractStore()",
      "DelegatedResourceAccountIndexStore RepositoryImpl.getDelegatedResourceAccountIndexStore()",
      "DelegatedResourceStore RepositoryImpl.getDelegatedResourceStore()",
      "DelegationStore RepositoryImpl.getDelegationStore()",
      "DynamicPropertiesStore RepositoryImpl.getDynamicPropertiesStore()", "KhaosDatabase RepositoryImpl.getKhaosDb()",
      "StorageRowStore RepositoryImpl.getStorageRowStore()", "VotesStore RepositoryImpl.getVotesStore()",
      "org.tron.core.store.WitnessStore RepositoryImpl.getWitnessStore()", "void RepositoryImpl.removeLruCache(byte[])",
      "void RepositoryImpl.setParent(Repository)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));
    createRootResult.removeLruCache("AXAXAXAX".getBytes("UTF-8"));
    AbiStore actualAbiStore = createRootResult.getAbiStore();
    AccountStore actualAccountStore = createRootResult.getAccountStore();
    AssetIssueStore actualAssetIssueStore = createRootResult.getAssetIssueStore();
    AssetIssueV2Store actualAssetIssueV2Store = createRootResult.getAssetIssueV2Store();
    BlockIndexStore actualBlockIndexStore = createRootResult.getBlockIndexStore();
    BlockStore actualBlockStore = createRootResult.getBlockStore();
    CodeStore actualCodeStore = createRootResult.getCodeStore();
    ContractStateStore actualContractStateStore = createRootResult.getContractStateStore();
    ContractStore actualContractStore = createRootResult.getContractStore();
    DelegatedResourceAccountIndexStore actualDelegatedResourceAccountIndexStore = createRootResult
        .getDelegatedResourceAccountIndexStore();
    DelegatedResourceStore actualDelegatedResourceStore = createRootResult.getDelegatedResourceStore();
    DelegationStore actualDelegationStore = createRootResult.getDelegationStore();
    DynamicPropertiesStore actualDynamicPropertiesStore = createRootResult.getDynamicPropertiesStore();
    KhaosDatabase actualKhaosDb = createRootResult.getKhaosDb();
    StorageRowStore actualStorageRowStore = createRootResult.getStorageRowStore();
    VotesStore actualVotesStore = createRootResult.getVotesStore();

    // Assert
    assertNull(actualBlockIndexStore);
    assertNull(actualBlockStore);
    assertNull(actualKhaosDb);
    assertNull(actualAbiStore);
    assertNull(actualAccountStore);
    assertNull(actualAssetIssueStore);
    assertNull(actualAssetIssueV2Store);
    assertNull(actualCodeStore);
    assertNull(actualContractStateStore);
    assertNull(actualContractStore);
    assertNull(actualDelegatedResourceAccountIndexStore);
    assertNull(actualDelegatedResourceStore);
    assertNull(actualDelegationStore);
    assertNull(actualDynamicPropertiesStore);
    assertNull(actualStorageRowStore);
    assertNull(actualVotesStore);
    assertNull(createRootResult.getWitnessStore());
  }
}
