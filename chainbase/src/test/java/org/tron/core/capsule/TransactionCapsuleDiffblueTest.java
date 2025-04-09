package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.api.AuthProvider;
import com.google.api.AuthRequirement;
import com.google.api.Authentication;
import com.google.api.AuthenticationRule;
import com.google.api.BackendRule;
import com.google.api.Billing;
import com.google.api.Billing.BillingDestination;
import com.google.api.ClientLibrarySettings;
import com.google.api.CommonLanguageSettings;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.PermissionException;
import org.tron.core.exception.SignatureFormatException;
import org.tron.core.store.AccountStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.AccountType;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;
import org.tron.protos.Protocol.Transaction.raw;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AccountContract.AccountCreateContract;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.ParticipateAssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.TransferAssetContract;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.BalanceContract.TransferContract;
import org.tron.protos.contract.WitnessContract;
import org.tron.protos.contract.WitnessContract.VoteWitnessContract;
import org.tron.protos.contract.WitnessContract.WitnessCreateContract;
import org.tron.protos.contract.WitnessContract.WitnessUpdateContract;

public class TransactionCapsuleDiffblueTest {
  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64())
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(TransferContract, AccountStore)}.
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#getBalance()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(BalanceContract.TransferContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(BalanceContract.TransferContract, AccountStore)"})
  public void testNewTransactionCapsule_givenAccountCapsuleGetBalanceReturnMinusOne() {
    // Arrange
    TransferContract contract = TransferContract.getDefaultInstance();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getBalance()).thenReturn(-1L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountCapsule).getBalance();
    verify(accountStore).get(isA(byte[].class));
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getInstance());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}.
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#getType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(AccountCreateContract, AccountStore)"})
  public void testNewTransactionCapsule_givenAccountCapsuleGetTypeReturnNull() {
    // Arrange
    AccountCreateContract contract = AccountCreateContract.getDefaultInstance();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getType()).thenReturn(null);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountCapsule).getType();
    verify(accountStore).get(isA(byte[].class));
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    Sha256Hash transactionId = actualTransactionCapsule.getTransactionId();
    assertArrayEquals(new byte[]{-55, 'C', '\\', -42, '^', '{', -90, 25, 16, -117, '_', 'D', Byte.MIN_VALUE, -116, -41,
        -117, -4, -80, 'Q', -15, -13, 2, -77, -110, 1, '>', -125, -101, 14, 'Q', -86, 't'}, transactionId.getBytes());
    Sha256Hash merkleHash = actualTransactionCapsule.getMerkleHash();
    assertArrayEquals(new byte[]{-91, -3, -54, -55, 'R', 'n', -97, 22, -127, -83, Byte.MIN_VALUE, -28, -28, -7, -60, 24,
        0, 'n', '=', 'm', '>', -4, -104, 1, -70, 'f', 21, -61, '}', -12, -84, -63}, merkleHash.getBytes());
    assertArrayEquals(
        new byte[]{0, -55, 'C', '\\', -42, '^', '{', -90, 25, 16, -117, '_', 'D', Byte.MIN_VALUE, -116, -41, -117, -4,
            -80, 'Q', -15, -13, 2, -77, -110, 1, '>', -125, -101, 14, 'Q', -86, 't'},
        transactionId.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[]{0, -91, -3, -54, -55, 'R', 'n', -97, 22, -127, -83, Byte.MIN_VALUE, -28, -28, -7, -60, 24, 0, 'n',
            '=', 'm', '>', -4, -104, 1, -70, 'f', 21, -61, '}', -12, -84, -63},
        merkleHash.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[]{'\n', '8', 'Z', '6', 18, '4', '\n', '2', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l', 'e', 'a',
            'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'A', 'c', 'c', 'o',
            'u', 'n', 't', 'C', 'r', 'e', 'a', 't', 'e', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule_givenIOExceptionWithFoo() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64()).thenThrow(new IOException("foo"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule_givenMinusOne() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(-1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AccountStore} {@link AccountStore#get(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(AccountCreateContract, AccountStore)"})
  public void testNewTransactionCapsule_givenNull_whenAccountStoreGetReturnNull() {
    // Arrange
    AccountCreateContract contract = AccountCreateContract.getDefaultInstance();
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountStore).get(isA(byte[].class));
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    Sha256Hash transactionId = actualTransactionCapsule.getTransactionId();
    assertArrayEquals(new byte[]{-55, 'C', '\\', -42, '^', '{', -90, 25, 16, -117, '_', 'D', Byte.MIN_VALUE, -116, -41,
        -117, -4, -80, 'Q', -15, -13, 2, -77, -110, 1, '>', -125, -101, 14, 'Q', -86, 't'}, transactionId.getBytes());
    Sha256Hash merkleHash = actualTransactionCapsule.getMerkleHash();
    assertArrayEquals(new byte[]{-91, -3, -54, -55, 'R', 'n', -97, 22, -127, -83, Byte.MIN_VALUE, -28, -28, -7, -60, 24,
        0, 'n', '=', 'm', '>', -4, -104, 1, -70, 'f', 21, -61, '}', -12, -84, -63}, merkleHash.getBytes());
    assertArrayEquals(
        new byte[]{0, -55, 'C', '\\', -42, '^', '{', -90, 25, 16, -117, '_', 'D', Byte.MIN_VALUE, -116, -41, -117, -4,
            -80, 'Q', -15, -13, 2, -77, -110, 1, '>', -125, -101, 14, 'Q', -86, 't'},
        transactionId.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[]{0, -91, -3, -54, -55, 'R', 'n', -97, 22, -127, -83, Byte.MIN_VALUE, -28, -28, -7, -60, 24, 0, 'n',
            '=', 'm', '>', -4, -104, 1, -70, 'f', 21, -61, '}', -12, -84, -63},
        merkleHash.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[]{'\n', '8', 'Z', '6', 18, '4', '\n', '2', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l', 'e', 'a',
            'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'A', 'c', 'c', 'o',
            'u', 'n', 't', 'C', 'r', 'e', 'a', 't', 'e', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(TransferContract, AccountStore)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link AccountStore} {@link AccountStore#get(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(BalanceContract.TransferContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(BalanceContract.TransferContract, AccountStore)"})
  public void testNewTransactionCapsule_givenNull_whenAccountStoreGetReturnNull2() {
    // Arrange
    TransferContract contract = TransferContract.getDefaultInstance();
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountStore).get(isA(byte[].class));
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getInstance());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return array length is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnArrayLengthIsSixtyFive() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(BillingDestination.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(65, actualTransactionCapsule.getData().length);
    assertEquals(65L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(TransferContract, AccountStore)}.
   * <ul>
   *   <li>Then return ContractResult is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(BalanceContract.TransferContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(BalanceContract.TransferContract, AccountStore)"})
  public void testNewTransactionCapsule_thenReturnContractResultIsNull() {
    // Arrange
    TransferContract contract = TransferContract.getDefaultInstance();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getBalance()).thenReturn(42L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountCapsule).getBalance();
    verify(accountStore).get(isA(byte[].class));
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(55L, actualTransactionCapsule.getSerializedSize());
    assertEquals(contract, actualTransactionCapsule.getTransferContract());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(new byte[]{'\n', '5', 'Z', '3', '\b', 1, 18, '/', '\n', '-', 't', 'y', 'p', 'e', '.', 'g', 'o',
        'o', 'g', 'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.',
        'T', 'r', 'a', 'n', 's', 'f', 'e', 'r', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFifty() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(BackendRule.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(50, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(50L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{29, '2', -83, -103, 'P', -34, -87, -23, ';', 'a', 'E', -127, -53, 6, -67, 'a', ';', -64, -25, 'S',
            '-', 'x', '5', -17, -90, '=', -127, ']', -105, -39, 30, '\f'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'z', '[', -24, -79, Byte.MAX_VALUE, -22, 'z', -107, '6', -56, -64, 'q', '\'', 31, -32, -99, -76, 11,
            '4', -113, '"', 'o', 15, -59, ',', '3', -18, 's', '1', -104, -13, -49},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{'\n', '0', 'Z', '.', 18, ',', '\n', '*', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
        'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.',
        'B', 'a', 'c', 'k', 'e', 'n', 'd', 'R', 'u', 'l', 'e'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftyFive() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(BoolValue.getDefaultInstance(),
        ContractType.TransferAssetContract);

    // Assert
    assertEquals(55, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(55L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{30, ';', -109, -55, -15, Byte.MAX_VALUE, -29, -34, '1', 'g', Byte.MIN_VALUE, '@', -98, '?', -81, -53,
            'n', -27, '6', -123, -60, 'C', '^', 28, '`', -65, -3, -55, '$', -51, 'r', ')'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'f', '_', 16, -120, 'n', 21, -52, -7, -54, '\r', -85, 'c', '@', -72, 'O', '{', '9', -78, -90, -37,
            'T', -24, -12, -88, -106, -55, 'q', 'e', 'f', '>', -71, 'I'},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{'\n', '5', 'Z', '3', '\b', 2, 18, '/', '\n', '-', 't', 'y', 'p', 'e', '.', 'g', 'o',
        'o', 'g', 'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'p', 'r',
        'o', 't', 'o', 'b', 'u', 'f', '.', 'B', 'o', 'o', 'l', 'V', 'a', 'l', 'u', 'e'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftyFour() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(AuthRequirement.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(54, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(54L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'[', ':', -31, -94, '+', -123, -53, 18, -26, -26, '*', -63, 'n', -118, -50, '\'', -46, 'Q', -92, '?',
            -102, -19, '^', -53, -12, '{', -17, '8', -61, 5, -94, -109},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'s', '+', 0, '%', -69, '>', -123, '~', 'p', 17, 'w', -114, -87, ' ', -126, 'X', 'j', 's', 'P', -2,
            '0', -21, ',', 'q', 'I', -77, 'N', -88, -100, 'k', -51, '='},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(new byte[]{'\n', '4', 'Z', '2', 18, '0', '\n', '.', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
        'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.',
        'A', 'u', 't', 'h', 'R', 'e', 'q', 'u', 'i', 'r', 'e', 'm', 'e', 'n', 't'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftyOne() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(AuthProvider.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(51, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(51L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-38, -48, ';', -86, 's', ')', -24, '4', 'y', 'i', -39, 'Q', -111, '{', 19, 'E', '%', -92, -113, '<',
            -61, -23, 'K', 'A', 'M', 19, -8, '&', '\r', -99, -34, -20},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'k', -43, -97, 17, -64, '|', -99, 0, -69, -103, -36, -43, -24, '"', 30, -26, -7, -69, -87, -35, '-',
            -127, -10, -15, -64, -48, 'S', -71, -107, -109, 't', -115},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{'\n', '1', 'Z', '/', 18, '-', '\n', '+', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
        'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.',
        'A', 'u', 't', 'h', 'P', 'r', 'o', 'v', 'i', 'd', 'e', 'r'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftySeven() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(AuthenticationRule.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(57, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(57L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-31, -112, '~', 23, -87, 'E', -43, -28, 2, 'F', -127, -49, 'F', -109, -14, 14, 15, -107, 'j', -104,
            Byte.MAX_VALUE, -92, 20, -62, -13, '!', 'T', '\b', -4, ')', 5, -13},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{-49, -111, 'I', 31, -102, -15, -36, -123, 'J', '(', -13, -26, 26, 30, -36, '\f', 'J', '5', '\'', -42,
            -90, -25, -65, -14, -34, '*', '8', 21, -33, 'q', 0, 31},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'\n', '7', 'Z', '5', 18, '3', '\n', '1', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l', 'e', 'a',
            'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.', 'A', 'u',
            't', 'h', 'e', 'n', 't', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'R', 'u', 'l', 'e'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftySix() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(BytesValue.getDefaultInstance(),
        ContractType.TransferAssetContract);

    // Assert
    assertEquals(56, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(56L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-5, 15, 29, '{', 'R', -58, 22, -85, -64, '3', '\n', 'E', 'f', 'f', -52, -46, 'z', 25, -74, 'G', 17,
            -115, -78, -95, -28, -112, -9, -27, '`', 'k', -74, -15},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{24, -35, '8', '-', 3, '2', -72, 'S', -98, -103, 'L', -18, -55, -89, 'w', '"', 'h', -38, -63, '1',
            'd', -9, -75, -65, -16, '"', 25, -70, ']', -64, 'L', '\n'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'\n', '6', 'Z', '4', '\b', 2, 18, '0', '\n', '.', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l',
            'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'p', 'r', 'o', 't',
            'o', 'b', 'u', 'f', '.', 'B', 'y', 't', 'e', 's', 'V', 'a', 'l', 'u', 'e'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fifty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFiftyThree() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(Authentication.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(53, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(53L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-120, 'Z', 'b', '2', '-', -74, -22, '}', 'b', -95, '3', 29, '5', -110, -12, 'A', -56, -28, -124, -21,
            'S', '|', 7, 'o', -28, 23, 3, 21, -46, -66, 19, -64},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{-41, -3, '6', 'S', -6, 17, -95, 'a', -41, -59, -65, -10, 20, -81, -116, '?', -11, 22, -28, 'Z', 'D',
            'I', -124, -120, '\n', 'C', -117, '\t', -6, ',', 'r', -89},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{'\n', '3', 'Z', '1', 18, '/', '\n', '-', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
        'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.',
        'A', 'u', 't', 'h', 'e', 'n', 't', 'i', 'c', 'a', 't', 'i', 'o', 'n'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is forty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFortyFive() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(Advice.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(45, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(45L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(new byte[]{-29, -81, 21, -6, -53, '5', -89, 'v', 'g', 'm', 5, -58, 25, 'g', -120, '!', ')', ':',
        -84, -41, -57, -23, -6, -18, -99, 19, ';', 'B', -32, -73, '$', -11},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{-3, -116, '3', 'd', -90, -31, '4', -91, '"', -29, -30, -110, -8, -50, -13, '.', -102, 'T', -46, -52,
            21, -29, 'V', ' ', -118, -12, -96, 17, 'i', 'D', '!', 'Y'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(new byte[]{'\n', '+', 'Z', ')', 18, '\'', '\n', '%', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
        'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.',
        'A', 'd', 'v', 'i', 'c', 'e'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is forty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsFortySeven() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(Advice.getDefaultInstance(),
        ContractType.TransferContract);

    // Assert
    assertEquals(47, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(47L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-90, -108, -36, -78, 16, 'P', 'x', -22, -80, 'R', -6, '>', -97, -9, 'c', 'O', 30, -91, '/', 'I', -9,
            -86, ']', 27, 'b', -31, '?', 11, -51, -125, -112, '('},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'?', -66, -120, -118, ':', 21, -8, -52, -112, -29, -35, 7, -34, -53, '(', 'g', -26, 11, -60, 'a',
            -51, -121, 28, -87, '<', 0, '?', -1, ':', '!', '.', -6},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{'\n', '-', 'Z', '+', '\b', 1, 18, '\'', '\n', '%', 't', 'y', 'p', 'e', '.', 'g', 'o',
        'o', 'g', 'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p',
        'i', '.', 'A', 'd', 'v', 'i', 'c', 'e'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsSix() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(Any.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(6, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(6L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(new byte[]{'\n', 4, 'Z', 2, 18, 0}, actualTransactionCapsule.getData());
    assertArrayEquals(
        new byte[]{'5', -106, -85, 'I', -30, -64, '&', 'g', -43, -82, '\t', 'v', -100, -1, -52, -63, -23, 29, 25, -82,
            -76, -123, -70, -53, 3, -25, 'y', 15, '(', -80, 'g', 'a'},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'[', -12, -67, -75, '2', 'b', 11, -28, 'A', -59, -66, -112, -23, '\r', -41, 18, -75, 'c', 21, 'G',
            '-', 'K', '{', '$', '8', -28, Byte.MAX_VALUE, 'j', -26, 'r', -26, -82},
        actualTransactionCapsule.getTransactionId().getBytes());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is sixty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsSixty() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(ClientLibrarySettings.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(60, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(60L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-75, -91, -20, -106, 'R', -3, '&', '}', -9, -104, -63, 22, '\f', '8', -37, -95, ')', -126, '#', 'i',
            -21, 'b', 'S', 29, -108, '?', -82, 'x', -92, '|', -100, -37},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'!', '4', '\f', '_', -59, '9', -84, -34, -71, -49, -82, -63, '!', -31, -114, 2, 'S', -110, 'z', -3,
            -29, 'A', -83, '_', 'V', -84, 2, 22, 20, -61, -35, 'P'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'\n', ':', 'Z', '8', 18, '6', '\n', '4', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l', 'e', 'a',
            'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.', 'C', 'l',
            'i', 'e', 'n', 't', 'L', 'i', 'b', 'r', 'a', 'r', 'y', 'S', 'e', 't', 't', 'i', 'n', 'g', 's'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is sixty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnInstanceSerializedSizeIsSixtyOne() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(CommonLanguageSettings.getDefaultInstance(),
        ContractType.AccountCreateContract);

    // Assert
    assertEquals(61, actualTransactionCapsule.getInstance().getSerializedSize());
    assertEquals(61L, actualTransactionCapsule.getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'M', -75, -67, -72, 22, -76, 'M', -47, -80, '*', 25, -57, -13, -38, 'j', '2', 'G', '[', '<', -104,
            '1', Byte.MAX_VALUE, -88, -125, -64, -22, -68, -1, -34, 'Z', '2', -6},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[]{'j', -86, 7, -68, -37, 'm', 'O', -40, 'K', '*', '\f', 5, -28, -113, 20, 'J', 2, 'f', '/', -101, -63,
            -84, 'q', ':', '`', '\r', -102, 'B', '_', 'm', -123, -119},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'\n', ';', 'Z', '9', 18, '7', '\n', '5', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l', 'e', 'a',
            'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'a', 'p', 'i', '.', 'C', 'o',
            'm', 'm', 'o', 'n', 'L', 'a', 'n', 'g', 'u', 'a', 'g', 'e', 'S', 'e', 't', 't', 'i', 'n', 'g', 's'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(Message, ContractType)}.
   * <ul>
   *   <li>Then return SerializedSize is sixty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(Message, Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(Message, Transaction.Contract.ContractType)"})
  public void testNewTransactionCapsule_thenReturnSerializedSizeIsSixtyFour() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(FeatureSetDefaults.getDefaultInstance(),
        ContractType.TransferAssetContract);

    // Assert
    assertEquals(64L, actualTransactionCapsule.getSerializedSize());
    assertEquals(Double.SIZE, actualTransactionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{-53, -97, '{', 31, 'L', -51, 'I', 't', 16, -29, -73, 17, -2, -88, Byte.MIN_VALUE, -106, '*', '<',
            '}', '6', -64, -42, -74, -19, -122, -21, -4, '3', '/', 'F', -25, 'l'},
        actualTransactionCapsule.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[]{'L', 'g', -52, 5, -56, -49, -127, -59, '=', -116, -26, -27, '`', ')', '_', -72, -47, -83, '=', '4',
            -72, '|', 'v', 'O', 11, -56, -101, -48, 'a', -55, -27, 'a'},
        actualTransactionCapsule.getTransactionId().getBytes());
    assertArrayEquals(new byte[]{'\n', '>', 'Z', '<', '\b', 2, 18, '8', '\n', '6', 't', 'y', 'p', 'e', '.', 'g', 'o',
        'o', 'g', 'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'p', 'r',
        'o', 't', 'o', 'b', 'u', 'f', '.', 'F', 'e', 'a', 't', 'u', 'r', 'e', 'S', 'e', 't', 'D', 'e', 'f', 'a', 'u',
        'l', 't', 's'}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}.
   * <ul>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(AccountCreateContract, AccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(AccountCreateContract, AccountStore)"})
  public void testNewTransactionCapsule_thenReturnTrxTraceIsNull() {
    // Arrange
    AccountCreateContract contract = AccountCreateContract.getDefaultInstance();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getType()).thenReturn(AccountType.Normal);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(contract, accountStore);

    // Assert
    verify(accountCapsule).getType();
    verify(accountStore).get(isA(byte[].class));
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getInstance());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(byte[])"})
  public void testNewTransactionCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(raw, List)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(raw, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(raw, List)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull() {
    // Arrange
    raw rawData = raw.getDefaultInstance();

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(rawData, new ArrayList<>());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(2L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{'\n', 0}, actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(AssetIssueContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(AssetIssueContractOuterClass.AssetIssueContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(AssetIssueContractOuterClass.AssetIssueContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull2() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(AssetIssueContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(57L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'\n', '7', 'Z', '5', '\b', 6, 18, '1', '\n', '/', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l',
            'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'A', 's',
            's', 'e', 't', 'I', 's', 's', 'u', 'e', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(ParticipateAssetIssueContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(ParticipateAssetIssueContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(ParticipateAssetIssueContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull3() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(
        ParticipateAssetIssueContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(68, actualTransactionCapsule.getData().length);
    assertEquals(68L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(TransferAssetContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(TransferAssetContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(TransferAssetContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull4() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(TransferAssetContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(60L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'\n', ':', 'Z', '8', '\b', 2, 18, '4', '\n', '2', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l',
            'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'T', 'r',
            'a', 'n', 's', 'f', 'e', 'r', 'A', 's', 's', 'e', 't', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(VoteWitnessContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(WitnessContract.VoteWitnessContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(WitnessContract.VoteWitnessContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull5() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(VoteWitnessContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(58L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'\n', '8', 'Z', '6', '\b', 4, 18, '2', '\n', '0', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l',
            'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'V', 'o',
            't', 'e', 'W', 'i', 't', 'n', 'e', 's', 's', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(WitnessCreateContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(WitnessContract.WitnessCreateContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(WitnessContract.WitnessCreateContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull6() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(WitnessCreateContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(60L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'\n', ':', 'Z', '8', '\b', 5, 18, '4', '\n', '2', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g', 'l',
            'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'W', 'i',
            't', 'n', 'e', 's', 's', 'C', 'r', 'e', 'a', 't', 'e', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(WitnessUpdateContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return TrxTrace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(WitnessContract.WitnessUpdateContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(WitnessContract.WitnessUpdateContract)"})
  public void testNewTransactionCapsule_whenDefaultInstance_thenReturnTrxTraceIsNull7() {
    // Arrange and Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(WitnessUpdateContract.getDefaultInstance());

    // Assert
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertNull(actualTransactionCapsule.getTransferContract());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(60L, actualTransactionCapsule.getSerializedSize());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertArrayEquals(new byte[]{}, actualTransactionCapsule.getOwnerAddress());
    assertArrayEquals(
        new byte[]{'\n', ':', 'Z', '8', '\b', '\b', 18, '4', '\n', '2', 't', 'y', 'p', 'e', '.', 'g', 'o', 'o', 'g',
            'l', 'e', 'a', 'p', 'i', 's', '.', 'c', 'o', 'm', '/', 'p', 'r', 'o', 't', 'o', 'c', 'o', 'l', '.', 'W',
            'i', 't', 'n', 'e', 's', 's', 'U', 'p', 'd', 'a', 't', 'e', 'C', 'o', 'n', 't', 'r', 'a', 'c', 't'},
        actualTransactionCapsule.getData());
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#TransactionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(byte[])"})
  public void testNewTransactionCapsule_whenEmptyArrayOfByte() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(new byte[]{}));
  }

  /**
   * Test {@link TransactionCapsule#getWeight(Permission, byte[])}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getWeight(Permission, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionCapsule.getWeight(Permission, byte[])"})
  public void testGetWeight_whenDefaultInstance_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    Permission permission = Permission.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, TransactionCapsule.getWeight(permission, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionCapsule#checkWeight(Permission, List, byte[], List)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#checkWeight(Permission, List, byte[], List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionCapsule.checkWeight(Permission, List, byte[], List)"})
  public void testCheckWeight_whenDefaultInstance_thenReturnZero()
      throws UnsupportedEncodingException, SignatureException, PermissionException, SignatureFormatException {
    // Arrange
    Permission permission = Permission.getDefaultInstance();
    ArrayList<ByteString> sigs = new ArrayList<>();
    byte[] hash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, TransactionCapsule.checkWeight(permission, sigs, hash, new ArrayList<>()));
  }

  /**
   * Test {@link TransactionCapsule#getOwner(Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getOwner(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionCapsule.getOwner(Transaction.Contract)"})
  public void testGetOwner_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, TransactionCapsule.getOwner(Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionCapsule#getOwner(Contract)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getOwner(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionCapsule.getOwner(Transaction.Contract)"})
  public void testGetOwner_whenNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, TransactionCapsule.getOwner(null));
  }

  /**
   * Test {@link TransactionCapsule#getToAddress(Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getToAddress(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionCapsule.getToAddress(Transaction.Contract)"})
  public void testGetToAddress_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, TransactionCapsule.getToAddress(Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionCapsule#getToAddress(Contract)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getToAddress(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionCapsule.getToAddress(Transaction.Contract)"})
  public void testGetToAddress_whenNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, TransactionCapsule.getToAddress(null));
  }

  /**
   * Test {@link TransactionCapsule#getCallValue(Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getCallValue(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionCapsule.getCallValue(Transaction.Contract)"})
  public void testGetCallValue_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionCapsule.getCallValue(Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionCapsule#getCallValue(Contract)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionCapsule#getCallValue(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionCapsule.getCallValue(Transaction.Contract)"})
  public void testGetCallValue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionCapsule.getCallValue(null));
  }

  /**
   * Test {@link TransactionCapsule#getBase64FromByteString(ByteString)}.
   * <p>
   * Method under test: {@link TransactionCapsule#getBase64FromByteString(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionCapsule.getBase64FromByteString(ByteString)"})
  public void testGetBase64FromByteString() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString sign = mock(ByteString.class);
    when(sign.byteAt(anyInt())).thenReturn((byte) 'A');
    when(sign.substring(anyInt(), anyInt())).thenReturn(byteString);

    // Act
    String actualBase64FromByteString = TransactionCapsule.getBase64FromByteString(sign);

    // Assert
    verify(sign).byteAt(eq(64));
    verify(sign, atLeast(1)).substring(anyInt(), anyInt());
    verify(byteString, atLeast(1)).toByteArray();
    assertEquals("QQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEFYQVhBWEFYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQVhBWEFYQVg=",
        actualBase64FromByteString);
  }

  /**
   * Test {@link TransactionCapsule#getBase64FromByteString(ByteString)}.
   * <p>
   * Method under test: {@link TransactionCapsule#getBase64FromByteString(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionCapsule.getBase64FromByteString(ByteString)"})
  public void testGetBase64FromByteString2() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString sign = mock(ByteString.class);
    when(sign.byteAt(anyInt())).thenReturn((byte) 1);
    when(sign.substring(anyInt(), anyInt())).thenReturn(byteString);

    // Act
    String actualBase64FromByteString = TransactionCapsule.getBase64FromByteString(sign);

    // Assert
    verify(sign).byteAt(eq(64));
    verify(sign, atLeast(1)).substring(anyInt(), anyInt());
    verify(byteString, atLeast(1)).toByteArray();
    assertEquals("HAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEFYQVhBWEFYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQVhBWEFYQVg=",
        actualBase64FromByteString);
  }
}
