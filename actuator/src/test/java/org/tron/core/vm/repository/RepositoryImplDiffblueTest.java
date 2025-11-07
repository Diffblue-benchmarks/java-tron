package org.tron.core.vm.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.capsule.ProtoCapsule;
import org.tron.core.capsule.VotesCapsule;
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
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.SmartContractOuterClass;

public class RepositoryImplDiffblueTest {
  /**
   * Method under test: {@link RepositoryImpl#createRoot(StoreFactory)}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#init(StoreFactory, RepositoryImpl)}
   */
  @Test
  public void testInit() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);
    StoreFactory storeFactory = StoreFactory.getInstance();

    // Act
    createRootResult.init(storeFactory, RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#newRepositoryChild()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#newRepositoryChild()}
   */
  @Test
  public void testNewRepositoryChild2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1000000);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A@A@A@A@".getBytes("UTF-8")), value);

    // Act
    Repository actualNewRepositoryChildResult = createRootResult.newRepositoryChild();

    // Assert
    verify(capsule).getInstance();
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
   * Method under test: {@link RepositoryImpl#getAccount(byte[])}
   */
  @Test
  public void testGetAccount() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = RepositoryImpl.createRoot(StoreFactory.getInstance());
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    repository.putAccountValue(address, new AccountCapsule((Protocol.Account) null));
    RepositoryImpl repositoryImpl = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act and Assert
    assertNull(repositoryImpl.getAccount("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#createContract(byte[], ContractCapsule)}
   */
  @Test
  public void testCreateContract() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.createContract(address,
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#createContract(byte[], ContractCapsule)}
   */
  @Test
  public void testCreateContract2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.createContract(new byte[]{},
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#createContract(byte[], ContractCapsule)}
   */
  @Test
  public void testCreateContract3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.createContract(address, new ContractCapsule((SmartContractOuterClass.SmartContract) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContract(byte[], ContractCapsule)}
   */
  @Test
  public void testUpdateContract() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateContract(address,
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContract(byte[], ContractCapsule)}
   */
  @Test
  public void testUpdateContract2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateContract(new byte[]{},
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContract(byte[], ContractCapsule)}
   */
  @Test
  public void testUpdateContract3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateContract(address, new ContractCapsule((SmartContractOuterClass.SmartContract) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContractState(byte[], ContractStateCapsule)}
   */
  @Test
  public void testUpdateContractState() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateContractState(address, new ContractStateCapsule(1L));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContractState(byte[], ContractStateCapsule)}
   */
  @Test
  public void testUpdateContractState2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateContractState(new byte[]{}, new ContractStateCapsule(1L));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateContractState(byte[], ContractStateCapsule)}
   */
  @Test
  public void testUpdateContractState3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateContractState(address, new ContractStateCapsule("A\bA\bA\bA\b".getBytes("UTF-8")));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccount(byte[], AccountCapsule)}
   */
  @Test
  public void testUpdateAccount() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateAccount(address, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccount(byte[], AccountCapsule)}
   */
  @Test
  public void testUpdateAccount2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateAccount(new byte[]{}, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccount(byte[], AccountCapsule)}
   */
  @Test
  public void testUpdateAccount3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateAccount(address, new AccountCapsule((Protocol.Account) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDynamicProperty(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDynamicProperty() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDynamicProperty(word, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDynamicProperty(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDynamicProperty2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateDynamicProperty(new byte[]{}, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDynamicProperty(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDynamicProperty3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDynamicProperty(word, new BytesCapsule(new byte[]{}));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegatedResource(byte[], DelegatedResourceCapsule)}
   */
  @Test
  public void testUpdateDelegatedResource() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDelegatedResource(word,
        new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegatedResource(byte[], DelegatedResourceCapsule)}
   */
  @Test
  public void testUpdateDelegatedResource2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateDelegatedResource(new byte[]{},
        new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegatedResource(byte[], DelegatedResourceCapsule)}
   */
  @Test
  public void testUpdateDelegatedResource3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDelegatedResource(word, new DelegatedResourceCapsule((Protocol.DelegatedResource) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateVotes(byte[], VotesCapsule)}
   */
  @Test
  public void testUpdateVotes() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateVotes(word, new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateVotes(byte[], VotesCapsule)}
   */
  @Test
  public void testUpdateVotes2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateVotes(new byte[]{}, new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateVotes(byte[], VotesCapsule)}
   */
  @Test
  public void testUpdateVotes3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateVotes(word, new VotesCapsule((Protocol.Votes) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateBeginCycle(byte[], long)}
   */
  @Test
  public void testUpdateBeginCycle() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateBeginCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateBeginCycle(byte[], long)}
   */
  @Test
  public void testUpdateBeginCycle2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateBeginCycle(new byte[]{}, 1L);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#updateEndCycle(byte[], long)}
   */
  @Test
  public void testUpdateEndCycle() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 20);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}), value);

    // Act
    createRootResult.updateEndCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateAccountVote(word, 3L, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateAccountVote(word, 3L,
        new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote4() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote5() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote6() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote7() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote8() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote9() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForEnergy(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote10() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenBalanceForEnergy(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote11() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenV2BalanceForEnergy(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote12() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.BANDWIDTH, -1L, -1L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote13() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAssetAmount(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, 10L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote14() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAssetMapV2(new HashMap<>());

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote15() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAllLatestAssetOperationTimeV2(new HashMap<>());

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote16() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putLatestAssetOperationTimeMap("-", 42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote17() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putLatestAssetOperationTimeMapV2("-", 42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote18() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAllFreeAssetNetUsageV2(new HashMap<>());

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote19() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putFreeAssetNetUsage("-", -1L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote20() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putFreeAssetNetUsageV2("-", -1L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote21() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2(Protocol.Account.UnFreezeV2.getDefaultInstance());

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote22() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.ENERGY, 1L, 1L);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote23() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addStorageUsage(1L);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote24() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAccountName(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote25() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAccountId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote26() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote27() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.TRON_POWER, 0L, 0L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote28() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setBalance(42L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote29() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestOperationTime(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote30() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestConsumeTime(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote31() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestConsumeFreeTime(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote32() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetOptimized(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote33() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetIssuedName(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote34() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetIssuedID(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote35() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAllowance(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote36() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestWithdrawTime(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote37() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setIsWitness(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote38() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setIsCommittee(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote39() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFrozen(42L, -1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote40() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setNetUsage(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote41() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFrozenForEnergy(42L, 10L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote42() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setEnergyUsage(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote43() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestConsumeTimeForEnergy(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote44() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFreeNetUsage(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote45() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setStorageLimit(-1L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote46() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestExchangeStorageTime(10L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote47() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    Protocol.Permission owner = Protocol.Permission.getDefaultInstance();
    Protocol.Permission witness = Protocol.Permission.getDefaultInstance();
    accountCapsule.updatePermissions(owner, witness, new ArrayList<>());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote48() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setNewWindowSize(Common.ResourceCode.BANDWIDTH, 3L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote49() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, -1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setWindowOptimized(Common.ResourceCode.BANDWIDTH, true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(42L);

    // Act
    createRootResult.updateAccountVote(word, 3L, accountCapsule);

    // Assert
    verify(capsule).getInstance();
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegation(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDelegation() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDelegation(word, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegation(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDelegation2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.updateDelegation(new byte[]{}, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#updateDelegation(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDelegation3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.updateDelegation(word, new BytesCapsule(new byte[]{}));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#saveCode(byte[], byte[])}
   */
  @Test
  public void testSaveCode() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.saveCode(address, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#saveCode(byte[], byte[])}
   */
  @Test
  public void testSaveCode2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.saveCode(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#saveCode(byte[], byte[])}
   */
  @Test
  public void testSaveCode3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.saveCode("AXAXAXAX".getBytes("UTF-8"), new byte[]{});

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#getStorage(byte[])}
   */
  @Test
  public void testGetStorage() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(storeFactory);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));
    Storage cache = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    createRootResult.putStorage(key, cache);

    // Act
    Storage actualStorage = createRootResult.getStorage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(storeFactory).getChainBaseManager();
    assertSame(cache, actualStorage);
  }

  /**
   * Method under test: {@link RepositoryImpl#getBalance(byte[])}
   */
  @Test
  public void testGetBalance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = RepositoryImpl.createRoot(StoreFactory.getInstance());
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    repository.putAccountValue(address, new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repositoryImpl = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act and Assert
    assertEquals(0L, repositoryImpl.getBalance("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  public void testCommit2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccountValue(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        new AccountCapsule(Protocol.Account.getDefaultInstance()));
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
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
   * Method under test: {@link RepositoryImpl#commit()}
   */
  @Test
  public void testCommit12() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  public void testPutAccount() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  public void testPutAccount2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putAccount(Key, Value)}
   */
  @Test
  public void testPutAccount3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  public void testPutCode() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  public void testPutCode2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putCode(Key, Value)}
   */
  @Test
  public void testPutCode3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  public void testPutContract() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  public void testPutContract2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContract(Key, Value)}
   */
  @Test
  public void testPutContract3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  public void testPutContractState() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  public void testPutContractState2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putContractState(Key, Value)}
   */
  @Test
  public void testPutContractState3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putStorage(Key, Storage)}
   */
  @Test
  public void testPutStorage() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(storeFactory);
    Key key = Key.create("AXAXAXAX".getBytes("UTF-8"));

    // Act
    createRootResult.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), null));

    // Assert
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#putAccountValue(byte[], AccountCapsule)}
   */
  @Test
  public void testPutAccountValue() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.putAccountValue(address, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#putAccountValue(byte[], AccountCapsule)}
   */
  @Test
  public void testPutAccountValue2() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);

    // Act
    createRootResult.putAccountValue(new byte[]{}, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#putAccountValue(byte[], AccountCapsule)}
   */
  @Test
  public void testPutAccountValue3() throws UnsupportedEncodingException {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 8);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create("A\bA\bA\bA\b".getBytes("UTF-8")), value);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createRootResult.putAccountValue(address, new AccountCapsule((Protocol.Account) null));

    // Assert
    verify(capsule).getInstance();
  }

  /**
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  public void testPutDynamicProperty() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  public void testPutDynamicProperty2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDynamicProperty(Key, Value)}
   */
  @Test
  public void testPutDynamicProperty3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  public void testPutDelegatedResource() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  public void testPutDelegatedResource2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegatedResource(Key, Value)}
   */
  @Test
  public void testPutDelegatedResource3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  public void testPutVotes() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  public void testPutVotes2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putVotes(Key, Value)}
   */
  @Test
  public void testPutVotes3() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  public void testPutDelegation() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  public void testPutDelegation2() throws UnsupportedEncodingException {
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
   * Method under test: {@link RepositoryImpl#putDelegation(Key, Value)}
   */
  @Test
  public void testPutDelegation3() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  public void testPutDelegatedResourceAccountIndex() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  public void testPutDelegatedResourceAccountIndex2() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link RepositoryImpl#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  public void testPutDelegatedResourceAccountIndex3() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act and Assert
    assertEquals(0L,
        createRootResult.calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance())));
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), value);

    // Act
    long actualCalculateGlobalEnergyLimitResult = createRootResult
        .calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit3() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), value);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = createRootResult.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit4() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), value);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = createRootResult.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit5() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), value);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForEnergyV2(42L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = createRootResult.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link RepositoryImpl#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit6() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), value);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFrozenForEnergy(42L, 10L);

    // Act
    long actualCalculateGlobalEnergyLimitResult = createRootResult.calculateGlobalEnergyLimit(accountCapsule);

    // Assert
    verify(capsule).getInstance();
    assertEquals(0L, actualCalculateGlobalEnergyLimitResult);
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalNetWeight(long)}
   */
  @Test
  public void testSaveTotalNetWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalNetWeight());
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalNetWeight(long)}
   */
  @Test
  public void testSaveTotalNetWeight2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, Short.SIZE);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}), value);

    // Act
    createRootResult.saveTotalNetWeight(1L);

    // Assert
    verify(capsule).getInstance();
    assertEquals(1L, createRootResult.getTotalNetWeight());
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalEnergyWeight(long)}
   */
  @Test
  public void testSaveTotalEnergyWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalEnergyWeight(long)}
   */
  @Test
  public void testSaveTotalEnergyWeight2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 19);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}), value);

    // Act
    createRootResult.saveTotalEnergyWeight(1L);

    // Assert
    verify(capsule).getInstance();
    assertEquals(1L, createRootResult.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalTronPowerWeight(long)}
   */
  @Test
  public void testSaveTotalTronPowerWeight() {
    // Arrange
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());

    // Act
    createRootResult.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, createRootResult.getTotalTronPowerWeight());
  }

  /**
   * Method under test: {@link RepositoryImpl#saveTotalTronPowerWeight(long)}
   */
  @Test
  public void testSaveTotalTronPowerWeight2() {
    // Arrange
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 23);
    RepositoryImpl createRootResult = RepositoryImpl.createRoot(StoreFactory.getInstance());
    createRootResult.putAccount(Key.create(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}), value);

    // Act
    createRootResult.saveTotalTronPowerWeight(1L);

    // Assert
    verify(capsule).getInstance();
    assertEquals(1L, createRootResult.getTotalTronPowerWeight());
  }

  /**
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

    // Assert that nothing has changed
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

  /**
   * Method under test:
   * {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}
   */
  @Test
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
   * Method under test:
   * {@link RepositoryImpl#RepositoryImpl(StoreFactory, RepositoryImpl)}
   */
  @Test
  public void testNewRepositoryImpl2() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1000000);
    RepositoryImpl repository = RepositoryImpl.createRoot(StoreFactory.getInstance());
    repository.putAccount(Key.create("A@A@A@A@".getBytes("UTF-8")), value);

    // Act
    RepositoryImpl actualRepositoryImpl = new RepositoryImpl(storeFactory, repository);

    // Assert
    verify(capsule).getInstance();
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
}
