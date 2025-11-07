package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.AssetIssueCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.capsule.ContractStateCapsule;
import org.tron.core.capsule.DelegatedResourceAccountIndexCapsule;
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
import org.tron.protos.Protocol.AccountType;

public class ContractStateDiffblueTest {
  /**
   * Test {@link ContractState#ContractState(ProgramInvoke)}.
   * <ul>
   *   <li>When {@link ContractState#ContractState(ProgramInvoke)} with programInvoke is {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ContractState#ContractState(ProgramInvoke)}.
   * <ul>
   *   <li>When {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.</li>
   *   <li>Then return AssetIssueStore is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#ContractState(ProgramInvoke)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ContractState#getAssetIssue(byte[])}.
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getAssetIssue(byte[])} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getAssetIssue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueCapsule ContractState.getAssetIssue(byte[])"})
  public void testGetAssetIssue_givenRepositoryImplGetAssetIssueReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAssetIssue(Mockito.<byte[]>any())).thenReturn(null);
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
    assertNull(actualAssetIssue);
  }

  /**
   * Test {@link ContractState#getAssetIssueV2Store()}.
   * <p>
   * Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.AssetIssueV2Store ContractState.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getAssetIssueV2Store()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getAssetIssueV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.AssetIssueV2Store ContractState.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getAssetIssueV2Store());
  }

  /**
   * Test {@link ContractState#getAssetIssueStore()}.
   * <p>
   * Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.AssetIssueStore ContractState.getAssetIssueStore()"})
  public void testGetAssetIssueStore() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getAssetIssueStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getAssetIssueStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.AssetIssueStore ContractState.getAssetIssueStore()"})
  public void testGetAssetIssueStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getAssetIssueStore());
  }

  /**
   * Test {@link ContractState#getDynamicPropertiesStore()}.
   * <p>
   * Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.DynamicPropertiesStore ContractState.getDynamicPropertiesStore()"})
  public void testGetDynamicPropertiesStore() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getDynamicPropertiesStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getDynamicPropertiesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.DynamicPropertiesStore ContractState.getDynamicPropertiesStore()"})
  public void testGetDynamicPropertiesStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getDynamicPropertiesStore());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], AccountType)} with {@code addr}, {@code type}.
   * <p>
   * Method under test: {@link ContractState#createAccount(byte[], Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], Protocol.AccountType)"})
  public void testCreateAccountWithAddrType() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    AccountCapsule actualCreateAccountResult = contractState.createAccount("AXAXAXAX".getBytes("UTF-8"),
        AccountType.Normal);

    // Assert
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], AccountType)} with {@code addr}, {@code type}.
   * <p>
   * Method under test: {@link ContractState#createAccount(byte[], Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], Protocol.AccountType)"})
  public void testCreateAccountWithAddrType2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, coinbase, 10L, 8L, new ContractState(new ProgramInvokeMockImpl()), 8L, 8L, 8L));

    // Act
    AccountCapsule actualCreateAccountResult = contractState.createAccount("AXAXAXAX".getBytes("UTF-8"),
        AccountType.Normal);

    // Assert
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], String, AccountType)} with {@code address}, {@code accountName}, {@code type}.
   * <p>
   * Method under test: {@link ContractState#createAccount(byte[], String, Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], String, Protocol.AccountType)"})
  public void testCreateAccountWithAddressAccountNameType() throws UnsupportedEncodingException {
    // Arrange
    ContractState contractState = new ContractState(new ProgramInvokeMockImpl());

    // Act
    AccountCapsule actualCreateAccountResult = contractState.createAccount("AXAXAXAX".getBytes("UTF-8"), "Dr Jane Doe",
        AccountType.Normal);

    // Assert
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{'\n', 11, 'D', 'r', ' ', 'J', 'a', 'n', 'e', ' ', 'D', 'o', 'e', 26, '\b', 'A', 'X',
        'A', 'X', 'A', 'X', 'A', 'X'}, actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#createAccount(byte[], String, AccountType)} with {@code address}, {@code accountName}, {@code type}.
   * <p>
   * Method under test: {@link ContractState#createAccount(byte[], String, Protocol.AccountType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ContractState.createAccount(byte[], String, Protocol.AccountType)"})
  public void testCreateAccountWithAddressAccountNameType2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] coinbase = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, coinbase, 10L, 8L, new ContractState(new ProgramInvokeMockImpl()), 8L, 8L, 8L));

    // Act
    AccountCapsule actualCreateAccountResult = contractState.createAccount("AXAXAXAX".getBytes("UTF-8"), "Dr Jane Doe",
        AccountType.Normal);

    // Assert
    byte[] expectedWitnessPermissionAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedWitnessPermissionAddress, actualCreateAccountResult.getWitnessPermissionAddress());
    assertArrayEquals(new byte[]{'\n', 11, 'D', 'r', ' ', 'J', 'a', 'n', 'e', ' ', 'D', 'o', 'e', 26, '\b', 'A', 'X',
        'A', 'X', 'A', 'X', 'A', 'X'}, actualCreateAccountResult.getData());
  }

  /**
   * Test {@link ContractState#getDynamicProperty(byte[])}.
   * <ul>
   *   <li>Then return {@link BytesCapsule#BytesCapsule(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getDynamicProperty(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BytesCapsule ContractState.getDynamicProperty(byte[])"})
  public void testGetDynamicProperty_thenReturnBytesCapsuleWithBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(bytesCapsule);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    BytesCapsule actualDynamicProperty = contractState.getDynamicProperty("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertSame(bytesCapsule, actualDynamicProperty);
  }

  /**
   * Test {@link ContractState#deleteContract(byte[])}.
   * <ul>
   *   <li>Then calls {@link RepositoryImpl#deleteContract(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#deleteContract(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.deleteContract(byte[])"})
  public void testDeleteContract_thenCallsDeleteContract() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).deleteContract(Mockito.<byte[]>any());
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L));

    // Act
    contractState.deleteContract("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(deposit).deleteContract(isA(byte[].class));
  }

  /**
   * Test {@link ContractState#getContractState(byte[])}.
   * <ul>
   *   <li>Then return {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getContractState(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractStateCapsule ContractState.getContractState(byte[])"})
  public void testGetContractState_thenReturnContractStateCapsuleWithCurrentCycleIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    when(repository.getContractState(Mockito.<byte[]>any())).thenReturn(contractStateCapsule);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    ContractStateCapsule actualContractState = contractState.getContractState("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getContractState(isA(byte[].class));
    assertSame(contractStateCapsule, actualContractState);
  }

  /**
   * Test {@link ContractState#getCode(byte[])}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getCode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractState.getCode(byte[])"})
  public void testGetCode_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getCode(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    byte[] actualCode = contractState.getCode("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getCode(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCode);
  }

  /**
   * Test {@link ContractState#putStorageValue(byte[], DataWord, DataWord)}.
   * <ul>
   *   <li>Then calls {@link RepositoryImpl#putStorageValue(byte[], DataWord, DataWord)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#putStorageValue(byte[], DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.putStorageValue(byte[], DataWord, DataWord)"})
  public void testPutStorageValue_thenCallsPutStorageValue() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).putStorageValue(Mockito.<byte[]>any(), Mockito.<DataWord>any(), Mockito.<DataWord>any());
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 42L, 42L,
            42L, 1L, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 10L, 20L, deposit, 20L, 20L, 20L));
    byte[] addr = "AXAXAXAX".getBytes("UTF-8");
    DataWord key = DataWord.ZERO();

    // Act
    contractState.putStorageValue(addr, key, DataWord.ZERO());

    // Assert
    verify(deposit).putStorageValue(isA(byte[].class), isA(DataWord.class), isA(DataWord.class));
  }

  /**
   * Test {@link ContractState#getStorageValue(byte[], DataWord)}.
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getStorageValue(byte[], DataWord)} return ZERO.</li>
   *   <li>Then return ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getStorageValue(byte[], DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ContractState.getStorageValue(byte[], DataWord)"})
  public void testGetStorageValue_givenRepositoryImplGetStorageValueReturnZero_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    DataWord ZEROResult = DataWord.ZERO();
    when(deposit.getStorageValue(Mockito.<byte[]>any(), Mockito.<DataWord>any())).thenReturn(ZEROResult);
    ContractState contractState = new ContractState(
        new ProgramInvokeImpl(new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 42L, 42L,
            42L, 1L, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20},
            new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20}, 10L, 20L, deposit, 20L, 20L, 20L));
    byte[] addr = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualStorageValue = contractState.getStorageValue(addr, DataWord.ZERO());

    // Assert
    verify(deposit).getStorageValue(isA(byte[].class), isA(DataWord.class));
    assertSame(ZEROResult, actualStorageValue);
  }

  /**
   * Test {@link ContractState#getBalance(byte[])}.
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getBalance(byte[])} return forty-two.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getBalance(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getBalance(byte[])"})
  public void testGetBalance_givenRepositoryImplGetBalanceReturnFortyTwo_thenReturnFortyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getBalance(Mockito.<byte[]>any())).thenReturn(42L);
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
    verify(deposit).getBalance(isA(byte[].class));
    assertEquals(42L, actualBalance);
  }

  /**
   * Test {@link ContractState#addBalance(byte[], long)}.
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#addBalance(byte[], long)} return forty-two.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#addBalance(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.addBalance(byte[], long)"})
  public void testAddBalance_givenRepositoryImplAddBalanceReturnFortyTwo_thenReturnFortyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.addBalance(Mockito.<byte[]>any(), anyLong())).thenReturn(42L);
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
    verify(deposit).addBalance(isA(byte[].class), eq(42L));
    assertEquals(42L, actualAddBalanceResult);
  }

  /**
   * Test {@link ContractState#newRepositoryChild()}.
   * <p>
   * Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Repository ContractState.newRepositoryChild()"})
  public void testNewRepositoryChild() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#newRepositoryChild()}.
   * <ul>
   *   <li>Then return {@link RepositoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#newRepositoryChild()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Repository ContractState.newRepositoryChild()"})
  public void testNewRepositoryChild_thenReturnRepositoryImpl() {
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
  public void testCommit4() {
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
  public void testCommit5() {
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
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
   * Test {@link ContractState#commit()}.
   * <ul>
   *   <li>Given {@link Value} {@link Value#getType()} return {@link Type#Type(int)} with type is one.</li>
   *   <li>Then calls {@link Value#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.commit()"})
  public void testCommit_givenValueGetTypeReturnTypeWithTypeIsOne_thenCallsGetType() {
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
   * Test {@link ContractState#getStorage(byte[])}.
   * <ul>
   *   <li>Then return {@link Storage#Storage(byte[], StorageRowStore)} with address is {@code AXAXAXAX} Bytes is {@code UTF-8} and store is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getStorage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Storage ContractState.getStorage(byte[])"})
  public void testGetStorage_thenReturnStorageWithAddressIsAxaxaxaxBytesIsUtf8AndStoreIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    when(deposit.getStorage(Mockito.<byte[]>any())).thenReturn(storage);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    Storage actualStorage = contractState.getStorage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(deposit).getStorage(isA(byte[].class));
    assertSame(storage, actualStorage);
  }

  /**
   * Test {@link ContractState#addTokenBalance(byte[], byte[], long)}.
   * <ul>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#addTokenBalance(byte[], byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.addTokenBalance(byte[], byte[], long)"})
  public void testAddTokenBalance_thenReturnFortyTwo() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.addTokenBalance(Mockito.<byte[]>any(), Mockito.<byte[]>any(), anyLong())).thenReturn(42L);
    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    long actualAddTokenBalanceResult = contractState.addTokenBalance(address2, "AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    verify(deposit).addTokenBalance(isA(byte[].class), isA(byte[].class), eq(42L));
    assertEquals(42L, actualAddTokenBalanceResult);
  }

  /**
   * Test {@link ContractState#getTokenBalance(byte[], byte[])}.
   * <ul>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getTokenBalance(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getTokenBalance(byte[], byte[])"})
  public void testGetTokenBalance_thenReturnFortyTwo() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getTokenBalance(Mockito.<byte[]>any(), Mockito.<byte[]>any())).thenReturn(42L);
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
    verify(deposit).getTokenBalance(isA(byte[].class), isA(byte[].class));
    assertEquals(42L, actualTokenBalance);
  }

  /**
   * Test {@link ContractState#getBlackHoleAddress()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getBlackHoleAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractState.getBlackHoleAddress()"})
  public void testGetBlackHoleAddress_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getBlackHoleAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualBlackHoleAddress = (new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L))).getBlackHoleAddress();

    // Assert
    verify(deposit).getBlackHoleAddress();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBlackHoleAddress);
  }

  /**
   * Test {@link ContractState#getDelegationStore()}.
   * <p>
   * Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.DelegationStore ContractState.getDelegationStore()"})
  public void testGetDelegationStore() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getDelegationStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getDelegationStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.store.DelegationStore ContractState.getDelegationStore()"})
  public void testGetDelegationStore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ContractState(new ProgramInvokeMockImpl())).getDelegationStore());
  }

  /**
   * Test {@link ContractState#getBeginCycle(byte[])}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getBeginCycle(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getBeginCycle(byte[])"})
  public void testGetBeginCycle_thenReturn4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getEndCycle(byte[])}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getEndCycle(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getEndCycle(byte[])"})
  public void testGetEndCycle_thenReturn4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getAccountVote(long, byte[])}.
   * <ul>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getAccountVote(long, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCapsule ContractState.getAccountVote(long, byte[])"})
  public void testGetAccountVote_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getDelegation(Key)}.
   * <ul>
   *   <li>Then return {@link BytesCapsule#BytesCapsule(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getDelegation(Key)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BytesCapsule ContractState.getDelegation(Key)"})
  public void testGetDelegation_thenReturnBytesCapsuleWithBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    BytesCapsule bytesCapsule = new BytesCapsule("AXAXAXAX".getBytes("UTF-8"));
    when(repository.getDelegation(Mockito.<Key>any())).thenReturn(bytesCapsule);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L));

    // Act
    BytesCapsule actualDelegation = contractState.getDelegation(new Key("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(repository).getDelegation(isA(Key.class));
    assertSame(bytesCapsule, actualDelegation);
  }

  /**
   * Test {@link ContractState#getDelegatedResourceAccountIndex(byte[])}.
   * <p>
   * Method under test: {@link ContractState#getDelegatedResourceAccountIndex(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceAccountIndexCapsule ContractState.getDelegatedResourceAccountIndex(byte[])"})
  public void testGetDelegatedResourceAccountIndex() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    when(repository.getDelegatedResourceAccountIndex(Mockito.<byte[]>any()))
        .thenReturn(delegatedResourceAccountIndexCapsule);
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    byte[] address = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] origin = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] caller = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] msgData = "A\bA\bA\bA\b".getBytes("UTF-8");
    byte[] lastHash = "A\bA\bA\bA\b".getBytes("UTF-8");
    ContractState contractState = new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "A\bA\bA\bA\b".getBytes("UTF-8"), 10L, 8L, deposit, 8L, 8L, 8L));

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndex = contractState
        .getDelegatedResourceAccountIndex("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(repository).getDelegatedResourceAccountIndex(isA(byte[].class));
    assertSame(delegatedResourceAccountIndexCapsule, actualDelegatedResourceAccountIndex);
  }

  /**
   * Test {@link ContractState#addTotalNetWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#addTotalNetWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.addTotalNetWeight(long)"})
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
   * Test {@link ContractState#addTotalEnergyWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#addTotalEnergyWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.addTotalEnergyWeight(long)"})
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
   * Test {@link ContractState#addTotalTronPowerWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#addTotalTronPowerWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.addTotalTronPowerWeight(long)"})
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
   * Test {@link ContractState#saveTotalNetWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link ContractState#saveTotalNetWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.saveTotalNetWeight(long)"})
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
   * Test {@link ContractState#saveTotalEnergyWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link ContractState#saveTotalEnergyWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.saveTotalEnergyWeight(long)"})
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
   * Test {@link ContractState#saveTotalTronPowerWeight(long)}.
   * <p>
   * Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link ContractState#saveTotalTronPowerWeight(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractState.saveTotalTronPowerWeight(long)"})
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
   * Test {@link ContractState#getTotalNetWeight()}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getTotalNetWeight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getTotalNetWeight()"})
  public void testGetTotalNetWeight_thenReturn4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getTotalEnergyWeight()}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getTotalEnergyWeight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getTotalEnergyWeight()"})
  public void testGetTotalEnergyWeight_thenReturn4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getTotalTronPowerWeight()}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getTotalTronPowerWeight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getTotalTronPowerWeight()"})
  public void testGetTotalTronPowerWeight_thenReturn4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ContractState#getHeadSlot()}.
   * <ul>
   *   <li>Given {@link RepositoryImpl} {@link RepositoryImpl#getHeadSlot()} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getHeadSlot()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getHeadSlot()"})
  public void testGetHeadSlot_givenRepositoryImplGetHeadSlotReturnOne_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getHeadSlot()).thenReturn(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");

    // Act
    long actualHeadSlot = (new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L))).getHeadSlot();

    // Assert
    verify(deposit).getHeadSlot();
    assertEquals(1L, actualHeadSlot);
  }

  /**
   * Test {@link ContractState#getSlotByTimestampMs(long)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#getSlotByTimestampMs(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractState.getSlotByTimestampMs(long)"})
  public void testGetSlotByTimestampMs_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    when(deposit.getSlotByTimestampMs(anyLong())).thenReturn(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");

    // Act
    long actualSlotByTimestampMs = (new ContractState(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L))).getSlotByTimestampMs(10L);

    // Assert
    verify(deposit).getSlotByTimestampMs(eq(10L));
    assertEquals(1L, actualSlotByTimestampMs);
  }
}
