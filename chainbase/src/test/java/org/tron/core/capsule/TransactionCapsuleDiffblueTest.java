package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.PermissionException;
import org.tron.core.exception.SignatureFormatException;
import org.tron.core.store.AccountStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.BalanceContract;

public class TransactionCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionCapsule#getWeight(Protocol.Permission, byte[])}
   */
  @Test
  public void testGetWeight() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Permission permission = Protocol.Permission.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, TransactionCapsule.getWeight(permission, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#checkWeight(Protocol.Permission, List, byte[], List)}
   */
  @Test
  public void testCheckWeight()
      throws UnsupportedEncodingException, SignatureException, PermissionException, SignatureFormatException {
    // Arrange
    Protocol.Permission permission = Protocol.Permission.getDefaultInstance();
    ArrayList<ByteString> sigs = new ArrayList<>();
    byte[] hash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, TransactionCapsule.checkWeight(permission, sigs, hash, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#getOwner(Protocol.Transaction.Contract)}
   */
  @Test
  public void testGetOwner() {
    // Arrange, Act and Assert
    assertEquals(0, TransactionCapsule.getOwner(Protocol.Transaction.Contract.getDefaultInstance()).length);
    assertEquals(0, TransactionCapsule.getOwner(null).length);
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#getToAddress(Protocol.Transaction.Contract)}
   */
  @Test
  public void testGetToAddress() {
    // Arrange, Act and Assert
    assertEquals(0, TransactionCapsule.getToAddress(Protocol.Transaction.Contract.getDefaultInstance()).length);
    assertEquals(0, TransactionCapsule.getToAddress(null).length);
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#getCallValue(Protocol.Transaction.Contract)}
   */
  @Test
  public void testGetCallValue() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionCapsule.getCallValue(Protocol.Transaction.Contract.getDefaultInstance()));
    assertEquals(0L, TransactionCapsule.getCallValue(null));
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#getBase64FromByteString(ByteString)}
   */
  @Test
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
   * Method under test:
   * {@link TransactionCapsule#getBase64FromByteString(ByteString)}
   */
  @Test
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

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionCapsule#TransactionCapsule(Protocol.Transaction)}
   *   <li>{@link TransactionCapsule#setBlockNum(long)}
   *   <li>{@link TransactionCapsule#setInBlock(boolean)}
   *   <li>{@link TransactionCapsule#setOrder(long)}
   *   <li>{@link TransactionCapsule#setTime(long)}
   *   <li>{@link TransactionCapsule#setTransactionCreate(boolean)}
   *   <li>{@link TransactionCapsule#setVerified(boolean)}
   *   <li>{@link TransactionCapsule#getBlockNum()}
   *   <li>{@link TransactionCapsule#getOrder()}
   *   <li>{@link TransactionCapsule#getTime()}
   *   <li>{@link TransactionCapsule#getTrxTrace()}
   *   <li>{@link TransactionCapsule#isInBlock()}
   *   <li>{@link TransactionCapsule#isTransactionCreate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Protocol.Transaction trx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionCapsule actualTransactionCapsule = new TransactionCapsule(trx);
    actualTransactionCapsule.setBlockNum(1L);
    actualTransactionCapsule.setInBlock(true);
    actualTransactionCapsule.setOrder(1L);
    actualTransactionCapsule.setTime(10L);
    actualTransactionCapsule.setTransactionCreate(true);
    actualTransactionCapsule.setVerified(true);
    long actualBlockNum = actualTransactionCapsule.getBlockNum();
    long actualOrder = actualTransactionCapsule.getOrder();
    long actualTime = actualTransactionCapsule.getTime();
    actualTransactionCapsule.getTrxTrace();
    boolean actualIsInBlockResult = actualTransactionCapsule.isInBlock();

    // Assert that nothing has changed
    assertEquals(10L, actualTime);
    assertEquals(1L, actualBlockNum);
    assertEquals(1L, actualOrder);
    assertTrue(actualIsInBlockResult);
    assertTrue(actualTransactionCapsule.isTransactionCreate());
    assertSame(trx, actualTransactionCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  public void testNewTransactionCapsule() throws IOException, BadItemException {
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
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  public void testNewTransactionCapsule2() throws IOException, BadItemException {
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
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  public void testNewTransactionCapsule3() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(-1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Method under test: {@link TransactionCapsule#TransactionCapsule(byte[])}
   */
  @Test
  public void testNewTransactionCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link TransactionCapsule#TransactionCapsule(byte[])}
   */
  @Test
  public void testNewTransactionCapsule5() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(AccountContract.AccountCreateContract, AccountStore)}
   */
  @Test
  public void testNewTransactionCapsule6() {
    // Arrange
    AccountContract.AccountCreateContract contract = AccountContract.AccountCreateContract.getDefaultInstance();
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.get(Mockito.<byte[]>any())).thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

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
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(AccountContract.AccountCreateContract, AccountStore)}
   */
  @Test
  public void testNewTransactionCapsule7() {
    // Arrange
    AccountContract.AccountCreateContract contract = AccountContract.AccountCreateContract.getDefaultInstance();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getType()).thenReturn(Protocol.AccountType.Normal);
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
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(BalanceContract.TransferContract, AccountStore)}
   */
  @Test
  public void testNewTransactionCapsule8() {
    // Arrange
    BalanceContract.TransferContract contract = BalanceContract.TransferContract.getDefaultInstance();
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
   * Method under test:
   * {@link TransactionCapsule#TransactionCapsule(BalanceContract.TransferContract, AccountStore)}
   */
  @Test
  public void testNewTransactionCapsule9() {
    // Arrange
    BalanceContract.TransferContract contract = BalanceContract.TransferContract.getDefaultInstance();
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
}
