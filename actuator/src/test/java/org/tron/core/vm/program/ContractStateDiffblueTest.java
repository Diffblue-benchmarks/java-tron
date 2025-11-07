package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.AssetIssueCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceAccountIndexCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.capsule.StorageRowCapsule;
import org.tron.core.capsule.VotesCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.core.store.StorageRowStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.Key;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.core.vm.repository.Type;
import org.tron.core.vm.repository.Value;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractStateDiffblueTest {
  /**
   * Method under test: {@link ContractState#getAssetIssue(byte[])}
   */
  @Test
  public void testGetAssetIssue() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(
        AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance());
    when(repository.getAssetIssue(Mockito.<byte[]>any())).thenReturn(assetIssueCapsule);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    AssetIssueCapsule actualAssetIssue = contractState.getAssetIssue("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getAssetIssue(isA(byte[].class));
    assertSame(assetIssueCapsule, actualAssetIssue);
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  public void testGetAssetIssueV2Store() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getAssetIssueV2Store());
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  public void testGetAssetIssueV2Store2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash,
        coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L))).getAssetIssueV2Store());
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  public void testGetAssetIssueV2Store3() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key("AXAXAXAX".getBytes("UTF-8"));
    contractState.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Act and Assert
    assertNull(contractState.getAssetIssueV2Store());
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  public void testGetAssetIssueStore() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getAssetIssueStore());
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  public void testGetAssetIssueStore2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash,
        coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L))).getAssetIssueStore());
  }

  /**
   * Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  public void testGetAssetIssueStore3() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key("AXAXAXAX".getBytes("UTF-8"));
    contractState.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Act and Assert
    assertNull(contractState.getAssetIssueStore());
  }

  /**
   * Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  public void testGetDynamicPropertiesStore() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getDynamicPropertiesStore());
  }

  /**
   * Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  public void testGetDynamicPropertiesStore2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash,
        coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L))).getDynamicPropertiesStore());
  }

  /**
   * Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  public void testGetDynamicPropertiesStore3() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key("AXAXAXAX".getBytes("UTF-8"));
    contractState.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Act and Assert
    assertNull(contractState.getDynamicPropertiesStore());
  }

  /**
   * Method under test: {@link ContractState#getAccount(byte[])}
   */
  @Test
  public void testGetAccount() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    when(repositoryImpl.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    AccountCapsule actualAccount = contractState.getAccount("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getAccount(isA(byte[].class));
    assertSame(accountCapsule, actualAccount);
  }

  /**
   * Method under test: {@link ContractState#getDynamicProperty(byte[])}
   */
  @Test
  public void testGetDynamicProperty() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repositoryImpl.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    BytesCapsule actualDynamicProperty = contractState.getDynamicProperty("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getDynamicProperty(isA(byte[].class));
    assertSame(bytesCapsule, actualDynamicProperty);
  }

  /**
   * Method under test: {@link ContractState#getDelegatedResource(byte[])}
   */
  @Test
  public void testGetDelegatedResource() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    when(repositoryImpl.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    DelegatedResourceCapsule actualDelegatedResource = contractState.getDelegatedResource("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getDelegatedResource(isA(byte[].class));
    assertSame(delegatedResourceCapsule, actualDelegatedResource);
  }

  /**
   * Method under test: {@link ContractState#getWitness(byte[])}
   */
  @Test
  public void testGetWitness() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    when(repositoryImpl.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    WitnessCapsule actualWitness = contractState.getWitness("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getWitness(isA(byte[].class));
    assertSame(witnessCapsule, actualWitness);
  }

  /**
   * Method under test: {@link ContractState#deleteContract(byte[])}
   */
  @Test
  public void testDeleteContract() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    doNothing().when(repositoryImpl).deleteContract(Mockito.<byte[]>any());
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.deleteContract("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).deleteContract(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link ContractState#createContract(byte[], ContractCapsule)}
   */
  @Test
  public void testCreateContract() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] codeHash = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.createContract(codeHash,
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#getContract(byte[])}
   */
  @Test
  public void testGetContract() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    ContractCapsule contractCapsule = new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance());
    when(repositoryImpl.getContract(Mockito.<byte[]>any())).thenReturn(contractCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    ContractCapsule actualContract = contractState.getContract("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getContract(isA(byte[].class));
    assertSame(contractCapsule, actualContract);
  }

  /**
   * Method under test: {@link ContractState#getContractState(byte[])}
   */
  @Test
  public void testGetContractState() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    when(repositoryImpl.getContractState(Mockito.<byte[]>any())).thenReturn(contractStateCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    ContractStateCapsule actualContractState = contractState.getContractState("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getContractState(isA(byte[].class));
    assertSame(contractStateCapsule, actualContractState);
  }

  /**
   * Method under test:
   * {@link ContractState#updateContract(byte[], ContractCapsule)}
   */
  @Test
  public void testUpdateContract() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateContract(address,
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#updateContractState(byte[], ContractStateCapsule)}
   */
  @Test
  public void testUpdateContractState() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateContractState(address, new ContractStateCapsule(1L));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#updateAccount(byte[], AccountCapsule)}
   */
  @Test
  public void testUpdateAccount() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateAccount(address, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#saveCode(byte[], byte[])}
   */
  @Test
  public void testSaveCode() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.saveCode(address, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#getCode(byte[])}
   */
  @Test
  public void testGetCode() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    byte[] actualCode = contractState.getCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Method under test:
   * {@link ContractState#putStorageValue(byte[], DataWord, DataWord)}
   */
  @Test
  public void testPutStorageValue() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    when(repository.getStorage(Mockito.<byte[]>any()))
        .thenReturn(new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 42L, 42L,
            42L, 1L, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 10L, 20L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 20L, 20L, 20L));
    byte[] addr = "AXAXAXAX".getBytes("UTF-8");
    DataWord key = DataWord.ZERO();

    // Act
    contractState.putStorageValue(addr, key, DataWord.ZERO());

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getContract(isA(byte[].class));
    verify(repository).getStorage(isA(byte[].class));
  }

  /**
   * Method under test: {@link ContractState#getStorageValue(byte[], DataWord)}
   */
  @Test
  public void testGetStorageValue() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8")));
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getContract(Mockito.<byte[]>any()))
        .thenReturn(new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance()));
    when(repository.getStorage(Mockito.<byte[]>any())).thenReturn(storage);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 42L, 42L,
            42L, 1L, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 10L, 20L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 20L, 20L, 20L));
    byte[] addr = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualStorageValue = contractState.getStorageValue(addr, DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getContract(isA(byte[].class));
    verify(repository).getStorage(isA(byte[].class));
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualStorageValue.toHexString());
    assertEquals("415841", actualStorageValue.toPrefixString());
    assertFalse(actualStorageValue.isNegative());
    assertFalse(actualStorageValue.isZero());
    byte[] data = actualStorageValue.getData();
    assertSame(data, actualStorageValue.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualStorageValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualStorageValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualStorageValue.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualStorageValue.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link ContractState#getBalance(byte[])}
   */
  @Test
  public void testGetBalance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    long actualBalance = contractState.getBalance("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualBalance);
  }

  /**
   * Method under test: {@link ContractState#addBalance(byte[], long)}
   */
  @Test
  public void testAddBalance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    long actualAddBalanceResult = contractState.addBalance("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(42L, actualAddBalanceResult);
  }

  /**
   * Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  public void testNewRepositoryChild() {
    // Arrange and Act
    Repository actualNewRepositoryChildResult = (new ContractState(new ProgramInvokeMockImpl())).newRepositoryChild();

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
   * Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  public void testNewRepositoryChild2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A@A@A@A@".getBytes("UTF-8");
    byte[] origin = "A@A@A@A@".getBytes("UTF-8");
    byte[] caller = "A@A@A@A@".getBytes("UTF-8");
    byte[] msgData = "A@A@A@A@".getBytes("UTF-8");
    byte[] lastHash = "A@A@A@A@".getBytes("UTF-8");
    byte[] coinbase = "A@A@A@A@".getBytes("UTF-8");

    // Act
    Repository actualNewRepositoryChildResult = (new ContractState(
        new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1000000L,
            new ContractState(new ProgramInvokeMockImpl()), 1000000L, 1000000L, 1000000L))).newRepositoryChild();

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
   * Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  public void testNewRepositoryChild3() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key("A@A@A@A@".getBytes("UTF-8"));
    contractState.putStorage(key, new Storage("A@A@A@A@".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Act
    Repository actualNewRepositoryChildResult = contractState.newRepositoryChild();

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
   * Method under test: {@link ContractState#setParent(Repository)}
   */
  @Test
  public void testSetParent() {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.setParent(new ContractState(new ProgramInvokeMockImpl()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new RepositoryImpl(StoreFactory.getInstance(), null));

    // Act
    (new ContractState(programInvoke)).commit();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit2() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(new ContractState(new ProgramInvokeMockImpl()));
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke)).commit();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit3() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit4() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit5() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    contractState.putStorage(key, new Storage(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, null));
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit6() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));
    Value value2 = mock(Value.class);
    when(value2.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putDelegatedResource(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value2);
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value2).getType();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit7() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));
    Value value2 = mock(Value.class);
    when(value2.getType()).thenReturn(new Type(1));
    Value value3 = mock(Value.class);
    when(value3.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putDelegation(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value3);
    contractState.putDelegatedResource(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value2);
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value3).getType();
    verify(value2).getType();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit8() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));
    Value value2 = mock(Value.class);
    when(value2.getType()).thenReturn(new Type(1));
    Value value3 = mock(Value.class);
    when(value3.getType()).thenReturn(new Type(1));
    Value value4 = mock(Value.class);
    when(value4.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putDelegatedResourceAccountIndex(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value4);
    contractState.putDelegation(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value3);
    contractState.putDelegatedResource(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value2);
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value4).getType();
    verify(value3).getType();
    verify(value2).getType();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit9() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));
    Value value2 = mock(Value.class);
    when(value2.getType()).thenReturn(new Type(1));
    Value value3 = mock(Value.class);
    when(value3.getType()).thenReturn(new Type(1));
    Value value4 = mock(Value.class);
    when(value4.getType()).thenReturn(new Type(1));
    Value value5 = mock(Value.class);
    when(value5.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putDynamicProperty(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value5);
    contractState.putDelegatedResourceAccountIndex(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value4);
    contractState.putDelegation(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value3);
    contractState.putDelegatedResource(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value2);
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value5).getType();
    verify(value4).getType();
    verify(value3).getType();
    verify(value2).getType();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  public void testCommit10() {
    // Arrange
    ProgramInvoke programInvoke = mock(ProgramInvoke.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState repository = new ContractState(programInvoke);
    Value value = mock(Value.class);
    when(value.getType()).thenReturn(new Type(1));
    Value value2 = mock(Value.class);
    when(value2.getType()).thenReturn(new Type(1));
    Value value3 = mock(Value.class);
    when(value3.getType()).thenReturn(new Type(1));
    Value value4 = mock(Value.class);
    when(value4.getType()).thenReturn(new Type(1));
    Value value5 = mock(Value.class);
    when(value5.getType()).thenReturn(new Type(1));
    Value value6 = mock(Value.class);
    when(value6.getType()).thenReturn(new Type(1));

    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    contractState.putVotes(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value6);
    contractState.putDynamicProperty(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value5);
    contractState.putDelegatedResourceAccountIndex(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value4);
    contractState.putDelegation(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value3);
    contractState.putDelegatedResource(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value2);
    contractState.putContractState(new Key(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}), value);
    contractState.setParent(repository);
    ProgramInvoke programInvoke2 = mock(ProgramInvoke.class);
    when(programInvoke2.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke2.getDeposit()).thenReturn(contractState);

    // Act
    (new ContractState(programInvoke2)).commit();

    // Assert
    verify(programInvoke2).getContractAddress();
    verify(programInvoke).getContractAddress();
    verify(programInvoke2).getDeposit();
    verify(programInvoke).getDeposit();
    verify(value6).getType();
    verify(value5).getType();
    verify(value4).getType();
    verify(value3).getType();
    verify(value2).getType();
    verify(value).getType();
  }

  /**
   * Method under test: {@link ContractState#putAccount(Key, Value)}
   */
  @Test
  public void testPutAccount() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putAccount(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putCode(Key, Value)}
   */
  @Test
  public void testPutCode() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putCode(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putContract(Key, Value)}
   */
  @Test
  public void testPutContract() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putContract(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putContractState(Key, Value)}
   */
  @Test
  public void testPutContractState() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putContractState(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putStorage(Key, Storage)}
   */
  @Test
  public void testPutStorage() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    Key key = new Key("AXAXAXAX".getBytes("UTF-8"));

    // Act
    contractState.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), null));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#getStorage(byte[])}
   */
  @Test
  public void testGetStorage() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    when(repositoryImpl.getStorage(Mockito.<byte[]>any())).thenReturn(storage);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    Storage actualStorage = contractState.getStorage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getStorage(isA(byte[].class));
    assertSame(storage, actualStorage);
  }

  /**
   * Method under test:
   * {@link ContractState#putAccountValue(byte[], AccountCapsule)}
   */
  @Test
  public void testPutAccountValue() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.putAccountValue(address, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putDelegatedResource(Key, Value)}
   */
  @Test
  public void testPutDelegatedResource() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putDelegatedResource(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putDelegation(Key, Value)}
   */
  @Test
  public void testPutDelegation() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putDelegation(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#putDelegatedResourceAccountIndex(Key, Value)}
   */
  @Test
  public void testPutDelegatedResourceAccountIndex() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putDelegatedResourceAccountIndex(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#addTokenBalance(byte[], byte[], long)}
   */
  @Test
  public void testAddTokenBalance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.addTokenBalance(Mockito.<byte[]>any(), Mockito.<byte[]>any(), anyLong())).thenReturn(42L);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    long actualAddTokenBalanceResult = contractState.addTokenBalance(address, "AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).addTokenBalance(isA(byte[].class), isA(byte[].class), eq(42L));
    assertEquals(42L, actualAddTokenBalanceResult);
  }

  /**
   * Method under test: {@link ContractState#getTokenBalance(byte[], byte[])}
   */
  @Test
  public void testGetTokenBalance() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(null);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    long actualTokenBalance = contractState.getTokenBalance(address2, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualTokenBalance);
  }

  /**
   * Method under test:
   * {@link ContractState#getAccountLeftEnergyFromFreeze(AccountCapsule)}
   */
  @Test
  public void testGetAccountLeftEnergyFromFreeze() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getAccountLeftEnergyFromFreeze(Mockito.<AccountCapsule>any())).thenReturn(1234567890L);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    long actualAccountLeftEnergyFromFreeze = contractState
        .getAccountLeftEnergyFromFreeze(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getAccountLeftEnergyFromFreeze(isA(AccountCapsule.class));
    assertEquals(1234567890L, actualAccountLeftEnergyFromFreeze);
  }

  /**
   * Method under test:
   * {@link ContractState#getAccountEnergyUsage(AccountCapsule)}
   */
  @Test
  public void testGetAccountEnergyUsage() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getAccountEnergyUsage(Mockito.<AccountCapsule>any())).thenReturn(1234567890L);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    long actualAccountEnergyUsage = contractState
        .getAccountEnergyUsage(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getAccountEnergyUsage(isA(AccountCapsule.class));
    assertEquals(1234567890L, actualAccountEnergyUsage);
  }

  /**
   * Method under test:
   * {@link ContractState#getAccountEnergyUsageBalanceAndRestoreSeconds(AccountCapsule)}
   */
  @Test
  public void testGetAccountEnergyUsageBalanceAndRestoreSeconds() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    ImmutablePair<Long, Long> immutablePair = new ImmutablePair<>(1L, 1L);

    when(repositoryImpl.getAccountEnergyUsageBalanceAndRestoreSeconds(Mockito.<AccountCapsule>any()))
        .thenReturn(immutablePair);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    Pair<Long, Long> actualAccountEnergyUsageBalanceAndRestoreSeconds = contractState
        .getAccountEnergyUsageBalanceAndRestoreSeconds(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getAccountEnergyUsageBalanceAndRestoreSeconds(isA(AccountCapsule.class));
    assertSame(immutablePair, actualAccountEnergyUsageBalanceAndRestoreSeconds);
  }

  /**
   * Method under test:
   * {@link ContractState#getAccountNetUsageBalanceAndRestoreSeconds(AccountCapsule)}
   */
  @Test
  public void testGetAccountNetUsageBalanceAndRestoreSeconds() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    ImmutablePair<Long, Long> immutablePair = new ImmutablePair<>(1L, 1L);

    when(repositoryImpl.getAccountNetUsageBalanceAndRestoreSeconds(Mockito.<AccountCapsule>any()))
        .thenReturn(immutablePair);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    Pair<Long, Long> actualAccountNetUsageBalanceAndRestoreSeconds = contractState
        .getAccountNetUsageBalanceAndRestoreSeconds(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getAccountNetUsageBalanceAndRestoreSeconds(isA(AccountCapsule.class));
    assertSame(immutablePair, actualAccountNetUsageBalanceAndRestoreSeconds);
  }

  /**
   * Method under test:
   * {@link ContractState#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act and Assert
    assertEquals(0L,
        contractState.calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance())));
  }

  /**
   * Method under test:
   * {@link ContractState#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit2() {
    // Arrange
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 42L, 42L, 42L, 1L, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 10L, 1L,
            new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L));

    // Act and Assert
    assertEquals(0L,
        contractState.calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance())));
  }

  /**
   * Method under test:
   * {@link ContractState#calculateGlobalEnergyLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalEnergyLimit3() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    contractState.putStorage(key, new Storage(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, mock(StorageRowStore.class)));

    // Act and Assert
    assertEquals(0L,
        contractState.calculateGlobalEnergyLimit(new AccountCapsule(Protocol.Account.getDefaultInstance())));
  }

  /**
   * Method under test: {@link ContractState#getBlackHoleAddress()}
   */
  @Test
  public void testGetBlackHoleAddress() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlackHoleAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);

    // Act
    byte[] actualBlackHoleAddress = (new ContractState(programInvoke)).getBlackHoleAddress();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlackHoleAddress();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBlackHoleAddress);
  }

  /**
   * Method under test: {@link ContractState#getBlockByNum(long)}
   */
  @Test
  public void testGetBlockByNum() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getBlockByNum(anyLong())).thenReturn(null);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);

    // Act
    BlockCapsule actualBlockByNum = (new ContractState(programInvoke)).getBlockByNum(1L);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getBlockByNum(eq(1L));
    assertNull(actualBlockByNum);
  }

  /**
   * Method under test: {@link ContractState#createNormalAccount(byte[])}
   */
  @Test
  public void testCreateNormalAccount() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    when(repositoryImpl.createNormalAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    AccountCapsule actualCreateNormalAccountResult = contractState.createNormalAccount("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).createNormalAccount(isA(byte[].class));
    assertSame(accountCapsule, actualCreateNormalAccountResult);
  }

  /**
   * Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  public void testGetDelegationStore() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getDelegationStore());
  }

  /**
   * Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  public void testGetDelegationStore2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash,
        coinbase, 10L, 1L, new ContractState(new ProgramInvokeMockImpl()), 1L, 1L, 1L))).getDelegationStore());
  }

  /**
   * Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  public void testGetDelegationStore3() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key("AXAXAXAX".getBytes("UTF-8"));
    contractState.putStorage(key, new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Act and Assert
    assertNull(contractState.getDelegationStore());
  }

  /**
   * Method under test: {@link ContractState#getVotes(byte[])}
   */
  @Test
  public void testGetVotes() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    VotesCapsule votesCapsule = new VotesCapsule(Protocol.Votes.getDefaultInstance());
    when(repositoryImpl.getVotes(Mockito.<byte[]>any())).thenReturn(votesCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    VotesCapsule actualVotes = contractState.getVotes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getVotes(isA(byte[].class));
    assertSame(votesCapsule, actualVotes);
  }

  /**
   * Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  public void testGetBeginCycle() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    long actualBeginCycle = contractState.getBeginCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualBeginCycle);
  }

  /**
   * Method under test: {@link ContractState#getEndCycle(byte[])}
   */
  @Test
  public void testGetEndCycle() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 42L, 42L,
            42L, 1L, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 10L, 20L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 20L, 20L, 20L));

    // Act
    long actualEndCycle = contractState.getEndCycle("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertEquals(4708585257725083992L, actualEndCycle);
  }

  /**
   * Method under test: {@link ContractState#getAccountVote(long, byte[])}
   */
  @Test
  public void testGetAccountVote() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31}, new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31}, 42L, 42L,
            42L, 1L, new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31}, new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31},
            new byte[]{'A', 31, 'A', 31, 'A', 31, 'A', 31}, 10L, 31L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 31L, 31L, 31L));

    // Act
    AccountCapsule actualAccountVote = contractState.getAccountVote(3L, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertNull(actualAccountVote.getInstance());
  }

  /**
   * Method under test: {@link ContractState#getDelegation(Key)}
   */
  @Test
  public void testGetDelegation() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repositoryImpl.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    BytesCapsule actualDelegation = contractState.getDelegation(new Key("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getDelegation(isA(Key.class));
    assertSame(bytesCapsule, actualDelegation);
  }

  /**
   * Method under test:
   * {@link ContractState#getDelegatedResourceAccountIndex(byte[])}
   */
  @Test
  public void testGetDelegatedResourceAccountIndex() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    when(repositoryImpl.getDelegatedResourceAccountIndex(Mockito.<byte[]>any()))
        .thenReturn(delegatedResourceAccountIndexCapsule);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndex = contractState
        .getDelegatedResourceAccountIndex("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getDelegatedResourceAccountIndex(isA(byte[].class));
    assertSame(delegatedResourceAccountIndexCapsule, actualDelegatedResourceAccountIndex);
  }

  /**
   * Method under test:
   * {@link ContractState#updateDynamicProperty(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDynamicProperty() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateDynamicProperty(word, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#updateDelegatedResource(byte[], DelegatedResourceCapsule)}
   */
  @Test
  public void testUpdateDelegatedResource() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateDelegatedResource(word,
        new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#updateVotes(byte[], VotesCapsule)}
   */
  @Test
  public void testUpdateVotes() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateVotes(word, new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#updateBeginCycle(byte[], long)}
   */
  @Test
  public void testUpdateBeginCycle() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.updateBeginCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#updateBeginCycle(byte[], long)}
   */
  @Test
  public void testUpdateBeginCycle2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    doNothing().when(repositoryImpl).updateBeginCycle(Mockito.<byte[]>any(), anyLong());
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.updateBeginCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).updateBeginCycle(isA(byte[].class), eq(1L));
  }

  /**
   * Method under test: {@link ContractState#updateEndCycle(byte[], long)}
   */
  @Test
  public void testUpdateEndCycle() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.updateEndCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#updateEndCycle(byte[], long)}
   */
  @Test
  public void testUpdateEndCycle2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    doNothing().when(repositoryImpl).updateEndCycle(Mockito.<byte[]>any(), anyLong());
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.updateEndCycle("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).updateEndCycle(isA(byte[].class), eq(1L));
  }

  /**
   * Method under test:
   * {@link ContractState#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateAccountVote(word, 3L, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test:
   * {@link ContractState#updateAccountVote(byte[], long, AccountCapsule)}
   */
  @Test
  public void testUpdateAccountVote2() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    doNothing().when(repositoryImpl).updateAccountVote(Mockito.<byte[]>any(), anyLong(), Mockito.<AccountCapsule>any());
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateAccountVote(word, 3L, new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Assert that nothing has changed
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).updateAccountVote(isA(byte[].class), eq(3L), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link ContractState#updateDelegation(byte[], BytesCapsule)}
   */
  @Test
  public void testUpdateDelegation() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);
    byte[] word = "AXAXAXAX".getBytes("UTF-8");

    // Act
    contractState.updateDelegation(word, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putDynamicProperty(Key, Value)}
   */
  @Test
  public void testPutDynamicProperty() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putDynamicProperty(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#putVotes(Key, Value)}
   */
  @Test
  public void testPutVotes() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(new ContractState(new ProgramInvokeMockImpl()));
    ContractState contractState = new ContractState(programInvoke);

    // Act
    contractState.putVotes(new Key("AXAXAXAX".getBytes("UTF-8")), null);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
  }

  /**
   * Method under test: {@link ContractState#addTotalNetWeight(long)}
   */
  @Test
  public void testAddTotalNetWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 42L, 42L,
            42L, 1L, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 10L, 16L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 16L, 16L, 16L));

    // Act
    contractState.addTotalNetWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalNetWeight());
  }

  /**
   * Method under test: {@link ContractState#addTotalEnergyWeight(long)}
   */
  @Test
  public void testAddTotalEnergyWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 42L, 42L,
            42L, 1L, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 10L, 19L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 19L, 19L, 19L));

    // Act
    contractState.addTotalEnergyWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link ContractState#addTotalTronPowerWeight(long)}
   */
  @Test
  public void testAddTotalTronPowerWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 42L, 42L,
            42L, 1L, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 10L, 23L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 23L, 23L, 23L));

    // Act
    contractState.addTotalTronPowerWeight(10L);

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725084002L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  public void testSaveTotalNetWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalNetWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  public void testSaveTotalNetWeight2() {
    // Arrange
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 42L, 42L,
            42L, 1L, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
            new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 10L, 16L, new ContractState(new ProgramInvokeMockImpl()),
            16L, 16L, 16L));

    // Act
    contractState.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalNetWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  public void testSaveTotalNetWeight3() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});
    contractState.putStorage(key,
        new Storage(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, mock(StorageRowStore.class)));

    // Act
    contractState.saveTotalNetWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalNetWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  public void testSaveTotalEnergyWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  public void testSaveTotalEnergyWeight2() {
    // Arrange
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 42L, 42L,
            42L, 1L, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 10L, 19L, new ContractState(new ProgramInvokeMockImpl()),
            19L, 19L, 19L));

    // Act
    contractState.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  public void testSaveTotalEnergyWeight3() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19});
    contractState.putStorage(key,
        new Storage(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, mock(StorageRowStore.class)));

    // Act
    contractState.saveTotalEnergyWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalEnergyWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  public void testSaveTotalTronPowerWeight() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    contractState.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  public void testSaveTotalTronPowerWeight2() {
    // Arrange
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 42L, 42L,
            42L, 1L, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 10L, 23L, new ContractState(new ProgramInvokeMockImpl()),
            23L, 23L, 23L));

    // Act
    contractState.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  public void testSaveTotalTronPowerWeight3() {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());
    Key key = new Key(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23});
    contractState.putStorage(key,
        new Storage(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, mock(StorageRowStore.class)));

    // Act
    contractState.saveTotalTronPowerWeight(1L);

    // Assert
    assertEquals(1L, contractState.getTotalTronPowerWeight());
  }

  /**
   * Method under test: {@link ContractState#getTotalNetWeight()}
   */
  @Test
  public void testGetTotalNetWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    long actualTotalNetWeight = (new ContractState(new ProgramInvokeImpl(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
        new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 42L, 42L, 42L,
        1L, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
        new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 10L, 16L,
        new RepositoryImpl(StoreFactory.getInstance(), repository), 16L, 16L, 16L))).getTotalNetWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalNetWeight);
  }

  /**
   * Method under test: {@link ContractState#getTotalEnergyWeight()}
   */
  @Test
  public void testGetTotalEnergyWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    long actualTotalEnergyWeight = (new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 42L, 42L,
            42L, 1L, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19},
            new byte[]{'A', 19, 'A', 19, 'A', 19, 'A', 19}, 10L, 19L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 19L, 19L, 19L))).getTotalEnergyWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalEnergyWeight);
  }

  /**
   * Method under test: {@link ContractState#getTotalTronPowerWeight()}
   */
  @Test
  public void testGetTotalTronPowerWeight() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    long actualTotalTronPowerWeight = (new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 42L, 42L,
            42L, 1L, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23},
            new byte[]{'A', 23, 'A', 23, 'A', 23, 'A', 23}, 10L, 23L,
            new RepositoryImpl(StoreFactory.getInstance(), repository), 23L, 23L, 23L))).getTotalTronPowerWeight();

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(4708585257725083992L, actualTotalTronPowerWeight);
  }

  /**
   * Method under test: {@link ContractState#getHeadSlot()}
   */
  @Test
  public void testGetHeadSlot() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getHeadSlot()).thenReturn(1L);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);

    // Act
    long actualHeadSlot = (new ContractState(programInvoke)).getHeadSlot();

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getHeadSlot();
    assertEquals(1L, actualHeadSlot);
  }

  /**
   * Method under test: {@link ContractState#getSlotByTimestampMs(long)}
   */
  @Test
  public void testGetSlotByTimestampMs() {
    // Arrange
    RepositoryImpl repositoryImpl = mock(RepositoryImpl.class);
    when(repositoryImpl.getSlotByTimestampMs(anyLong())).thenReturn(1L);
    ProgramInvokeImpl programInvoke = mock(ProgramInvokeImpl.class);
    when(programInvoke.getContractAddress()).thenReturn(DataWord.ZERO());
    when(programInvoke.getDeposit()).thenReturn(repositoryImpl);

    // Act
    long actualSlotByTimestampMs = (new ContractState(programInvoke)).getSlotByTimestampMs(10L);

    // Assert
    verify(programInvoke).getContractAddress();
    verify(programInvoke).getDeposit();
    verify(repositoryImpl).getSlotByTimestampMs(eq(10L));
    assertEquals(1L, actualSlotByTimestampMs);
  }

  /**
   * Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  public void testNewContractState() {
    // Arrange and Act
    ContractState actualContractState = new ContractState(new ProgramInvokeMockImpl());

    // Assert
    assertNull(actualContractState.getAssetIssueStore());
    assertNull(actualContractState.getAssetIssueV2Store());
    assertNull(actualContractState.getDelegationStore());
    assertNull(actualContractState.getDynamicPropertiesStore());
  }

  /**
   * Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  public void testNewContractState2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");

    // Act
    ContractState actualContractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L,
        1L, msgData, lastHash, coinbase, 10L, 32L, new ContractState(new ProgramInvokeMockImpl()), 32L, 32L, 32L));

    // Assert
    assertNull(actualContractState.getAssetIssueStore());
    assertNull(actualContractState.getAssetIssueV2Store());
    assertNull(actualContractState.getDelegationStore());
    assertNull(actualContractState.getDynamicPropertiesStore());
  }

  /**
   * Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  public void testNewContractState3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A A A A ".getBytes("UTF-8");
    byte[] origin = "A A A A ".getBytes("UTF-8");
    byte[] caller = "A A A A ".getBytes("UTF-8");
    byte[] msgData = "A A A A ".getBytes("UTF-8");
    byte[] lastHash = "A A A A ".getBytes("UTF-8");
    byte[] coinbase = "A A A A ".getBytes("UTF-8");

    // Act
    ContractState actualContractState = new ContractState(
        new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 32L,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 32L, 32L, 32L));

    // Assert
    assertNull(actualContractState.getAssetIssueStore());
    assertNull(actualContractState.getAssetIssueV2Store());
    assertNull(actualContractState.getDelegationStore());
    assertNull(actualContractState.getDynamicPropertiesStore());
  }
}
