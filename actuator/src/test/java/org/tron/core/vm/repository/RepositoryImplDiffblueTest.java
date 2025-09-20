package org.tron.core.vm.repository;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BytesCapsule;
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
import org.tron.protos.Protocol.AccountType;

public class RepositoryImplDiffblueTest {
  /**
   * Test {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}.
   *
   * <p>Method under test: {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.<init>(StoreFactory, RepositoryImpl)"})
  public void testNewRepositoryImpl() {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();

    // Act
    RepositoryImpl actualRepositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));

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
   *
   * <p>Method under test: {@link RepositoryImpl#createRoot(StoreFactory)}
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
   *
   * <p>Method under test: {@link RepositoryImpl#newRepositoryChild()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Repository RepositoryImpl.newRepositoryChild()"})
  public void testNewRepositoryChild() {
    // Arrange and Act
    Repository actualNewRepositoryChildResult =
        RepositoryImpl.createRoot(StoreFactory.getInstance()).newRepositoryChild();

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
   * Test {@link RepositoryImpl#createAccount(byte[], String, AccountType)} with {@code address},
   * {@code accountName}, {@code type}.
   *
   * <p>Method under test: {@link RepositoryImpl#createAccount(byte[], String,
   * Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "AccountCapsule RepositoryImpl.createAccount(byte[], String, Protocol.AccountType)"
  })
  public void testCreateAccountWithAddressAccountNameType() throws UnsupportedEncodingException {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        RepositoryImpl.createRoot(StoreFactory.getInstance())
            .createAccount("AXAXAXAX".getBytes("UTF-8"), "Dr Jane Doe", AccountType.Normal);

    // Assert
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
   * Test {@link RepositoryImpl#createAccount(byte[], String, AccountType)} with {@code address},
   * {@code accountName}, {@code type}.
   *
   * <p>Method under test: {@link RepositoryImpl#createAccount(byte[], String,
   * Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "AccountCapsule RepositoryImpl.createAccount(byte[], String, Protocol.AccountType)"
  })
  public void testCreateAccountWithAddressAccountNameType2() {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        RepositoryImpl.createRoot(StoreFactory.getInstance())
            .createAccount(new byte[] {}, "Dr Jane Doe", AccountType.Normal);

    // Assert
    assertArrayEquals(new byte[] {}, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(
        new byte[] {'\n', 11, 'D', 'r', ' ', 'J', 'a', 'n', 'e', ' ', 'D', 'o', 'e'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link RepositoryImpl#createAccount(byte[], AccountType)} with {@code address}, {@code
   * type}.
   *
   * <p>Method under test: {@link RepositoryImpl#createAccount(byte[], Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule RepositoryImpl.createAccount(byte[], Protocol.AccountType)"})
  public void testCreateAccountWithAddressType() throws UnsupportedEncodingException {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        RepositoryImpl.createRoot(StoreFactory.getInstance())
            .createAccount("AXAXAXAX".getBytes("UTF-8"), AccountType.Normal);

    // Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(
        new byte[] {26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link RepositoryImpl#createAccount(byte[], AccountType)} with {@code address}, {@code
   * type}.
   *
   * <ul>
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#createAccount(byte[], Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule RepositoryImpl.createAccount(byte[], Protocol.AccountType)"})
  public void testCreateAccountWithAddressType_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange and Act
    AccountCapsule actualCreateAccountResult =
        RepositoryImpl.createRoot(StoreFactory.getInstance())
            .createAccount(new byte[] {}, AccountType.Normal);

    // Assert
    assertArrayEquals(new byte[] {}, actualCreateAccountResult.getData());
    assertArrayEquals(new byte[] {}, actualCreateAccountResult.getWitnessPermissionAddress());
  }

  /**
   * Test {@link RepositoryImpl#getDelegation(Key)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#getDelegation(Key)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BytesCapsule RepositoryImpl.getDelegation(Key)"})
  public void testGetDelegation_givenA_whenCreateAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 1);

    ProtoCapsule<Object> capsule3 = mock(ProtoCapsule.class);
    when(capsule3.getInstance()).thenReturn("Instance");
    Value<Object> value3 = Value.create(capsule3, 1);

    ProtoCapsule<Object> capsule4 = mock(ProtoCapsule.class);
    when(capsule4.getInstance()).thenReturn("Instance");
    Value<Object> value4 = Value.create(capsule4, 1);

    ProtoCapsule<Object> capsule5 = mock(ProtoCapsule.class);
    when(capsule5.getInstance()).thenReturn("Instance");
    Value<Object> value5 = Value.create(capsule5, 1);

    ProtoCapsule<Object> capsule6 = mock(ProtoCapsule.class);
    when(capsule6.getInstance()).thenReturn("Instance");
    Value<Object> value6 = Value.create(capsule6, 1);

    ProtoCapsule<Object> capsule7 = mock(ProtoCapsule.class);
    when(capsule7.getInstance()).thenReturn("Instance");
    Value<Object> value7 = Value.create(capsule7, 1);

    ProtoCapsule<Object> capsule8 = mock(ProtoCapsule.class);
    when(capsule8.getInstance()).thenReturn("Instance");
    Value<Object> value8 = Value.create(capsule8, 1);

    ProtoCapsule<Object> capsule9 = mock(ProtoCapsule.class);
    when(capsule9.getInstance()).thenReturn("Instance");
    Value<Object> value9 = Value.create(capsule9, 1);

    ProtoCapsule<Object> capsule10 = mock(ProtoCapsule.class);
    when(capsule10.getInstance()).thenReturn("Instance");
    Value<Object> value10 = Value.create(capsule10, 1);

    ProtoCapsule<Object> capsule11 = mock(ProtoCapsule.class);
    when(capsule11.getInstance()).thenReturn("Instance");
    Value<Object> value11 = Value.create(capsule11, 1);

    ProtoCapsule<Object> capsule12 = mock(ProtoCapsule.class);
    when(capsule12.getInstance()).thenReturn("Instance");
    Value<Object> value12 = Value.create(capsule12, 1);

    ProtoCapsule<Object> capsule13 = mock(ProtoCapsule.class);
    when(capsule13.getInstance()).thenReturn("Instance");
    Value<Object> value13 = Value.create(capsule13, 1);

    ProtoCapsule<Object> capsule14 = mock(ProtoCapsule.class);
    when(capsule14.getInstance()).thenReturn("Instance");
    Value<Object> value14 = Value.create(capsule14, 1);

    ProtoCapsule<Object> capsule15 = mock(ProtoCapsule.class);
    when(capsule15.getInstance()).thenReturn("Instance");
    Value<Object> value15 = Value.create(capsule15, 1);

    ProtoCapsule<Object> capsule16 = mock(ProtoCapsule.class);
    when(capsule16.getInstance()).thenReturn("Instance");
    Value<Object> value16 = Value.create(capsule16, 1);

    ProtoCapsule<Object> capsule17 = mock(ProtoCapsule.class);
    when(capsule17.getInstance()).thenReturn("Instance");
    Value<Object> value17 = Value.create(capsule17, 1);

    ProtoCapsule<Object> capsule18 = mock(ProtoCapsule.class);
    when(capsule18.getInstance()).thenReturn("Instance");
    Value<Object> value18 = Value.create(capsule18, 1);

    ProtoCapsule<Object> capsule19 = mock(ProtoCapsule.class);
    when(capsule19.getInstance()).thenReturn("Instance");
    Value<Object> value19 = Value.create(capsule19, 1);

    ProtoCapsule<Object> capsule20 = mock(ProtoCapsule.class);
    when(capsule20.getInstance()).thenReturn("Instance");
    Value<Object> value20 = Value.create(capsule20, 1);

    ProtoCapsule<Object> capsule21 = mock(ProtoCapsule.class);
    when(capsule21.getInstance()).thenReturn("Instance");
    Value<Object> value21 = Value.create(capsule21, 1);

    ProtoCapsule<Object> capsule22 = mock(ProtoCapsule.class);
    when(capsule22.getInstance()).thenReturn("Instance");
    Value<Object> value22 = Value.create(capsule22, 1);

    ProtoCapsule<Object> capsule23 = mock(ProtoCapsule.class);
    when(capsule23.getInstance()).thenReturn("Instance");
    Value<Object> value23 = Value.create(capsule23, 1);

    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value23);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value22);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value21);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value20);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value19);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value18);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value17);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value16);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value15);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value14);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value13);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value12);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value11);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value10);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value9);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value8);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value7);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value6);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value5);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Value<byte[]> value24 = Value.create(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1);

    createRootResult.putDelegation(key, value24);

    // Act
    BytesCapsule actualDelegation =
        createRootResult.getDelegation(Key.create("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(capsule23).getInstance();
    verify(capsule22).getInstance();
    verify(capsule21).getInstance();
    verify(capsule20).getInstance();
    verify(capsule19).getInstance();
    verify(capsule18).getInstance();
    verify(capsule17).getInstance();
    verify(capsule16).getInstance();
    verify(capsule15).getInstance();
    verify(capsule14).getInstance();
    verify(capsule13).getInstance();
    verify(capsule12).getInstance();
    verify(capsule11).getInstance();
    verify(capsule10).getInstance();
    verify(capsule9).getInstance();
    verify(capsule8).getInstance();
    verify(capsule7).getInstance();
    verify(capsule6).getInstance();
    verify(capsule5).getInstance();
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
    assertNull(actualDelegation.getInstance());
    assertArrayEquals(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, actualDelegation.getData());
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   *
   * <p>Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);

    ProtoCapsule<Object> capsule2 = mock(ProtoCapsule.class);
    when(capsule2.getInstance()).thenReturn("Instance");
    Value<Object> value2 = Value.create(capsule2, 2);
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));
    repositoryImpl.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    repositoryImpl.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   *
   * <p>Method under test: {@link RepositoryImpl#commit()}
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
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));
    repositoryImpl.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    repositoryImpl.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    repositoryImpl.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   *
   * <p>Method under test: {@link RepositoryImpl#commit()}
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
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));
    repositoryImpl.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    repositoryImpl.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    repositoryImpl.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    repositoryImpl.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   *
   * <p>Method under test: {@link RepositoryImpl#commit()}
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
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Storage cache = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    repositoryImpl.putStorage(key, cache);
    repositoryImpl.putContractState(Key.create("AXAXAXAX".getBytes("UTF-8")), value4);
    repositoryImpl.putContract(Key.create("AXAXAXAX".getBytes("UTF-8")), value3);
    repositoryImpl.putCode(Key.create("AXAXAXAX".getBytes("UTF-8")), value2);
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    repositoryImpl.setParent(RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule4).getInstance();
    verify(capsule3).getInstance();
    verify(capsule2).getInstance();
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#commit()}.
   *
   * <ul>
   *   <li>Then calls {@link ProtoCapsule#getInstance()}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.commit()"})
  public void testCommit_thenCallsGetInstance() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    StoreFactory storeFactory = StoreFactory.getInstance();

    RepositoryImpl repositoryImpl =
        new RepositoryImpl(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));
    repositoryImpl.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    // Act
    repositoryImpl.commit();

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Test {@link RepositoryImpl#putAccount(Key, Value)}.
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putAccount(Key, Value)"})
  public void testPutAccount_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putAccount(Key, Value)"})
  public void testPutAccount_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putCode(Key, Value)"})
  public void testPutCode_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContract(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContract(Key, Value)"})
  public void testPutContract_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContract(Key, Value)}
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putContractState(Key, Value)"})
  public void testPutContractState_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDynamicProperty(Key, Value)"})
  public void testPutDynamicProperty_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenCreateRootInstance_whenCreateAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putVotes(Key, Value)"})
  public void testPutVotes_givenProtoCapsuleGetInstanceReturnInstance_whenNull()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   *   <li>When create {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegation(Key, Value)"})
  public void testPutDelegation_givenProtoCapsuleGetInstanceReturnInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
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
   *
   * <ul>
   *   <li>Given createRoot Instance.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RepositoryImpl.putDelegatedResourceAccountIndex(Key, Value)"})
  public void testPutDelegatedResourceAccountIndex_givenCreateRootInstance()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>Given {@link ProtoCapsule} {@link ProtoCapsule#getInstance()} return {@code Instance}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
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
    createRootResult.putDelegatedResourceAccountIndex(
        Key.create("AXAXAXAX".getBytes("UTF-8")), value);
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
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
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
    createRootResult.putDelegatedResourceAccountIndex(
        Key.create("AXAXAXAX".getBytes("UTF-8")), value);

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
   *
   * <p>Method under test: {@link RepositoryImpl#saveTotalNetWeight(long)}
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
   *
   * <p>Method under test: {@link RepositoryImpl#saveTotalEnergyWeight(long)}
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
   *
   * <p>Method under test: {@link RepositoryImpl#saveTotalTronPowerWeight(long)}
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
   *
   * <p>Methods under test:
   *
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
  @MethodsUnderTest({
    "AbiStore RepositoryImpl.getAbiStore()",
    "AccountStore RepositoryImpl.getAccountStore()",
    "AssetIssueStore RepositoryImpl.getAssetIssueStore()",
    "AssetIssueV2Store RepositoryImpl.getAssetIssueV2Store()",
    "BlockIndexStore RepositoryImpl.getBlockIndexStore()",
    "BlockStore RepositoryImpl.getBlockStore()",
    "CodeStore RepositoryImpl.getCodeStore()",
    "ContractStateStore RepositoryImpl.getContractStateStore()",
    "ContractStore RepositoryImpl.getContractStore()",
    "DelegatedResourceAccountIndexStore RepositoryImpl.getDelegatedResourceAccountIndexStore()",
    "DelegatedResourceStore RepositoryImpl.getDelegatedResourceStore()",
    "DelegationStore RepositoryImpl.getDelegationStore()",
    "DynamicPropertiesStore RepositoryImpl.getDynamicPropertiesStore()",
    "KhaosDatabase RepositoryImpl.getKhaosDb()",
    "StorageRowStore RepositoryImpl.getStorageRowStore()",
    "VotesStore RepositoryImpl.getVotesStore()",
    "org.tron.core.store.WitnessStore RepositoryImpl.getWitnessStore()",
    "void RepositoryImpl.removeLruCache(byte[])",
    "void RepositoryImpl.setParent(Repository)"
  })
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
    DelegatedResourceAccountIndexStore actualDelegatedResourceAccountIndexStore =
        createRootResult.getDelegatedResourceAccountIndexStore();
    DelegatedResourceStore actualDelegatedResourceStore =
        createRootResult.getDelegatedResourceStore();
    DelegationStore actualDelegationStore = createRootResult.getDelegationStore();
    DynamicPropertiesStore actualDynamicPropertiesStore =
        createRootResult.getDynamicPropertiesStore();
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
