package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.protos.Protocol;

public class InternalTransactionDiffblueTest {
  /**
   * Method under test: {@link InternalTransaction#getTransferToAddress()}
   */
  @Test
  public void testGetTransferToAddress() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualTransferToAddress = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        data, "Note", 1L, new HashMap<>())).getTransferToAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTransferToAddress);
  }

  /**
   * Method under test: {@link InternalTransaction#getTransferToAddress()}
   */
  @Test
  public void testGetTransferToAddress2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualTransferToAddress = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getTransferToAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTransferToAddress);
  }

  /**
   * Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  public void testGetNote() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals("", (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getNote());
  }

  /**
   * Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  public void testGetNote2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("Note", (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note",
        1L, new HashMap<>())).getNote());
  }

  /**
   * Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  public void testGetNote3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("Note", (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getNote());
  }

  /**
   * Method under test: {@link InternalTransaction#getSender()}
   */
  @Test
  public void testGetSender() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(0, (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getSender().length);
  }

  /**
   * Method under test: {@link InternalTransaction#getSender()}
   */
  @Test
  public void testGetSender2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSender = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note",
        1L, new HashMap<>())).getSender();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSender);
  }

  /**
   * Method under test: {@link InternalTransaction#getSender()}
   */
  @Test
  public void testGetSender3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSender = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getSender();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSender);
  }

  /**
   * Method under test: {@link InternalTransaction#getReceiveAddress()}
   */
  @Test
  public void testGetReceiveAddress() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(0, (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getReceiveAddress().length);
  }

  /**
   * Method under test: {@link InternalTransaction#getReceiveAddress()}
   */
  @Test
  public void testGetReceiveAddress2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualReceiveAddress = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data,
        "Note", 1L, new HashMap<>())).getReceiveAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiveAddress);
  }

  /**
   * Method under test: {@link InternalTransaction#getReceiveAddress()}
   */
  @Test
  public void testGetReceiveAddress3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualReceiveAddress = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getReceiveAddress();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReceiveAddress);
  }

  /**
   * Method under test: {@link InternalTransaction#getParentHash()}
   */
  @Test
  public void testGetParentHash() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(0, (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getParentHash().length);
  }

  /**
   * Method under test: {@link InternalTransaction#getParentHash()}
   */
  @Test
  public void testGetParentHash2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualParentHash = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data,
        "Note", 1L, new HashMap<>())).getParentHash();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualParentHash);
  }

  /**
   * Method under test: {@link InternalTransaction#getParentHash()}
   */
  @Test
  public void testGetParentHash3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualParentHash = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getParentHash();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualParentHash);
  }

  /**
   * Method under test: {@link InternalTransaction#getData()}
   */
  @Test
  public void testGetData() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(0, (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getData().length);
  }

  /**
   * Method under test: {@link InternalTransaction#getData()}
   */
  @Test
  public void testGetData2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note",
        1L, new HashMap<>())).getData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link InternalTransaction#getData()}
   */
  @Test
  public void testGetData3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L,
        "AXAXAXAX".getBytes("UTF-8"), "Note", 1L, tokenInfo)).getData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  public void testGetExtra() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals("", (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getExtra());
  }

  /**
   * Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  public void testGetExtra2() throws ContractValidateException {
    // Arrange
    InternalTransaction internalTransaction = new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE);
    internalTransaction.setExtra("foo");

    // Act and Assert
    assertEquals("foo", internalTransaction.getExtra());
  }

  /**
   * Method under test: {@link InternalTransaction#getHash()}
   */
  @Test
  public void testGetHash() throws ContractValidateException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
            InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getHash());
  }

  /**
   * Method under test: {@link InternalTransaction#getHash()}
   */
  @Test
  public void testGetHash2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X', '7', 'O',
            -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'},
        (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, "AXAXAXAX".getBytes("UTF-8"),
            "Note", 1L, tokenInfo)).getHash());
  }

  /**
   * Method under test: {@link InternalTransaction#getEncoded()}
   */
  @Test
  public void testGetEncoded() throws ContractValidateException {
    // Arrange, Act and Assert
    assertEquals(0, (new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE)).getEncoded().length);
  }

  /**
   * Method under test: {@link InternalTransaction#getEncoded()}
   */
  @Test
  public void testGetEncoded2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> tokenInfo = new HashMap<>();
    tokenInfo.computeIfPresent("foo", mock(BiFunction.class));
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
            'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, "AXAXAXAX".getBytes("UTF-8"),
            "Note", 1L, tokenInfo)).getEncoded());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InternalTransaction#setExtra(String)}
   *   <li>{@link InternalTransaction#setTransaction(Protocol.Transaction)}
   *   <li>{@link InternalTransaction#setValue(long)}
   *   <li>{@link InternalTransaction#reject()}
   *   <li>{@link InternalTransaction#getDeep()}
   *   <li>{@link InternalTransaction#getIndex()}
   *   <li>{@link InternalTransaction#getNonce()}
   *   <li>{@link InternalTransaction#getTokenInfo()}
   *   <li>{@link InternalTransaction#getTransaction()}
   *   <li>{@link InternalTransaction#getValue()}
   *   <li>{@link InternalTransaction#isRejected()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws ContractValidateException {
    // Arrange
    InternalTransaction internalTransaction = new InternalTransaction(Protocol.Transaction.getDefaultInstance(),
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE);

    // Act
    internalTransaction.setExtra("Extra");
    Protocol.Transaction transaction = Protocol.Transaction.getDefaultInstance();
    internalTransaction.setTransaction(transaction);
    internalTransaction.setValue(42L);
    internalTransaction.reject();
    int actualDeep = internalTransaction.getDeep();
    int actualIndex = internalTransaction.getIndex();
    long actualNonce = internalTransaction.getNonce();
    Map<String, Long> actualTokenInfo = internalTransaction.getTokenInfo();
    Protocol.Transaction actualTransaction = internalTransaction.getTransaction();
    long actualValue = internalTransaction.getValue();
    boolean actualIsRejectedResult = internalTransaction.isRejected();

    // Assert that nothing has changed
    assertEquals(-1, actualDeep);
    assertEquals(0, actualIndex);
    assertEquals(0L, actualNonce);
    assertEquals(42L, actualValue);
    assertTrue(actualTokenInfo.isEmpty());
    assertTrue(actualIsRejectedResult);
    assertSame(transaction, actualTransaction);
  }

  /**
   * Method under test:
   * {@link InternalTransaction#InternalTransaction(Protocol.Transaction, InternalTransaction.TrxType)}
   */
  @Test
  public void testNewInternalTransaction() throws ContractValidateException {
    // Arrange
    Protocol.Transaction trx = Protocol.Transaction.getDefaultInstance();

    // Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(trx,
        InternalTransaction.TrxType.TRX_PRECOMPILED_TYPE);

    // Assert
    assertEquals("", actualInternalTransaction.getExtra());
    assertEquals("", actualInternalTransaction.getNote());
    assertEquals(-1, actualInternalTransaction.getDeep());
    assertEquals(0, actualInternalTransaction.getIndex());
    byte[] data = actualInternalTransaction.getData();
    assertEquals(0, data.length);
    assertEquals(0, actualInternalTransaction.getEncoded().length);
    assertEquals(0L, actualInternalTransaction.getNonce());
    assertEquals(0L, actualInternalTransaction.getValue());
    assertFalse(actualInternalTransaction.isRejected());
    assertTrue(actualInternalTransaction.getTokenInfo().isEmpty());
    assertSame(data, actualInternalTransaction.getParentHash());
    assertSame(data, actualInternalTransaction.getReceiveAddress());
    assertSame(data, actualInternalTransaction.getSender());
    assertSame(trx, actualInternalTransaction.getTransaction());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        actualInternalTransaction.getHash());
  }

  /**
   * Method under test:
   * {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  public void testNewInternalTransaction2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>());

    // Assert
    assertEquals("", actualInternalTransaction.getExtra());
    assertEquals("Note", actualInternalTransaction.getNote());
    assertNull(actualInternalTransaction.getTransaction());
    assertEquals(1, actualInternalTransaction.getDeep());
    assertEquals(1, actualInternalTransaction.getIndex());
    assertEquals(1L, actualInternalTransaction.getNonce());
    assertEquals(42L, actualInternalTransaction.getValue());
    assertFalse(actualInternalTransaction.isRejected());
    assertTrue(actualInternalTransaction.getTokenInfo().isEmpty());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualInternalTransaction.getData());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualInternalTransaction.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, actualInternalTransaction.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, actualInternalTransaction.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'},
        actualInternalTransaction.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'}, actualInternalTransaction.getEncoded());
  }

  /**
   * Method under test:
   * {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  public void testNewInternalTransaction3() throws UnsupportedEncodingException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, null, null, 42L, null, "Note", 1L, null);

    // Assert
    assertEquals("", actualInternalTransaction.getExtra());
    assertEquals("Note", actualInternalTransaction.getNote());
    assertNull(actualInternalTransaction.getTransaction());
    assertEquals(0, actualInternalTransaction.getData().length);
    assertEquals(0, actualInternalTransaction.getReceiveAddress().length);
    assertEquals(0, actualInternalTransaction.getSender().length);
    assertEquals(0, actualInternalTransaction.getTransferToAddress().length);
    assertEquals(1, actualInternalTransaction.getDeep());
    assertEquals(1, actualInternalTransaction.getIndex());
    assertEquals(1L, actualInternalTransaction.getNonce());
    assertEquals(42L, actualInternalTransaction.getValue());
    assertFalse(actualInternalTransaction.isRejected());
    assertTrue(actualInternalTransaction.getTokenInfo().isEmpty());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualInternalTransaction.getParentHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-22, 'I', -109, -90, -12, 'C', Byte.MAX_VALUE, -39, -25, '$', -110, -1, -112, '|', '}',
        16, 16, '9', 'B', 'x', -65, 1, '9', -55, '{', -110, '(', -14, -85, -121, -40, -86},
        actualInternalTransaction.getHash());
  }

  /**
   * Method under test:
   * {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  public void testNewInternalTransaction4() throws UnsupportedEncodingException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, new byte[]{}, null, 42L, null, "Note", 1L,
        new HashMap<>());

    // Assert
    assertEquals("", actualInternalTransaction.getExtra());
    assertEquals("Note", actualInternalTransaction.getNote());
    assertNull(actualInternalTransaction.getTransaction());
    assertEquals(0, actualInternalTransaction.getData().length);
    assertEquals(0, actualInternalTransaction.getReceiveAddress().length);
    assertEquals(0, actualInternalTransaction.getSender().length);
    assertEquals(0, actualInternalTransaction.getTransferToAddress().length);
    assertEquals(1, actualInternalTransaction.getDeep());
    assertEquals(1, actualInternalTransaction.getIndex());
    assertEquals(1L, actualInternalTransaction.getNonce());
    assertEquals(42L, actualInternalTransaction.getValue());
    assertFalse(actualInternalTransaction.isRejected());
    assertTrue(actualInternalTransaction.getTokenInfo().isEmpty());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualInternalTransaction.getParentHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-22, 'I', -109, -90, -12, 'C', Byte.MAX_VALUE, -39, -25, '$', -110, -1, -112, '|', '}',
        16, 16, '9', 'B', 'x', -65, 1, '9', -55, '{', -110, '(', -14, -85, -121, -40, -86},
        actualInternalTransaction.getHash());
  }
}
