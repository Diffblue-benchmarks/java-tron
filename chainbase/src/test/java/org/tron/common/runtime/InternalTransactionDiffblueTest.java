package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.InternalTransaction.TrxType;
import org.tron.core.exception.ContractValidateException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

public class InternalTransactionDiffblueTest {
  /**
   * Test {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}.
   * <p>
   * Method under test: {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InternalTransaction.<init>(Transaction, TrxType)"})
  public void testNewInternalTransaction() throws ContractValidateException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(Transaction.getDefaultInstance(),
        TrxType.TRX_PRECOMPILED_TYPE);

    // Assert
    Transaction transaction = actualInternalTransaction.getTransaction();
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}.
   * <ul>
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"})
  public void testNewInternalTransaction_thenReturnDataIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(parentHash, 1, 1, sendAddress,
        transferToAddress, 42L, data, "Note", 1L, new HashMap<>());

    // Assert
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
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"})
  public void testNewInternalTransaction_whenA_thenReturnDataIsEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, null, null, 42L, null, "Note", 1L, null);

    // Assert
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualInternalTransaction.getParentHash());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getData());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getReceiveAddress());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getSender());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-22, 'I', -109, -90, -12, 'C', Byte.MAX_VALUE, -39, -25, '$', -110, -1, -112, '|', '}',
        16, 16, '9', 'B', 'x', -65, 1, '9', -55, '{', -110, '(', -14, -85, -121, -40, -86},
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"})
  public void testNewInternalTransaction_whenEmptyArrayOfByte_thenReturnDataIsEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, new byte[]{}, null, 42L, null, "Note", 1L,
        new HashMap<>());

    // Assert
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualInternalTransaction.getParentHash());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getData());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getReceiveAddress());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getSender());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-22, 'I', -109, -90, -12, 'C', Byte.MAX_VALUE, -39, -25, '$', -110, -1, -112, '|', '}',
        16, 16, '9', 'B', 'x', -65, 1, '9', -55, '{', -110, '(', -14, -85, -121, -40, -86},
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}.
   * <ul>
   *   <li>When {@code TRX_UNKNOWN_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InternalTransaction.<init>(Transaction, TrxType)"})
  public void testNewInternalTransaction_whenTrxUnknownType() throws ContractValidateException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction = new InternalTransaction(Transaction.getDefaultInstance(),
        TrxType.TRX_UNKNOWN_TYPE);

    // Assert
    Transaction transaction = actualInternalTransaction.getTransaction();
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{}, actualInternalTransaction.getEncoded());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#getTransferToAddress()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getTransferToAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getTransferToAddress()"})
  public void testGetTransferToAddress_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getNote()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InternalTransaction.getNote()"})
  public void testGetNote_thenReturnEmptyString() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("", (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, null, 1L,
        new HashMap<>())).getNote());
  }

  /**
   * Test {@link InternalTransaction#getNote()}.
   * <ul>
   *   <li>Then return {@code Note}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InternalTransaction.getNote()"})
  public void testGetNote_thenReturnNote() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getSender()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getSender()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getSender()"})
  public void testGetSender_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getReceiveAddress()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getReceiveAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getReceiveAddress()"})
  public void testGetReceiveAddress_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getParentHash()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getParentHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getParentHash()"})
  public void testGetParentHash_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getData()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getData()"})
  public void testGetData_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
   * Test {@link InternalTransaction#getExtra()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InternalTransaction.getExtra()"})
  public void testGetExtra_thenReturnEmptyString() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("", (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L,
        new HashMap<>())).getExtra());
  }

  /**
   * Test {@link InternalTransaction#getExtra()}.
   * <ul>
   *   <li>Then return {@code Extra}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InternalTransaction.getExtra()"})
  public void testGetExtra_thenReturnExtra() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    InternalTransaction internalTransaction = new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress,
        42L, data, "Note", 1L, new HashMap<>());
    internalTransaction.setExtra("Extra");

    // Act and Assert
    assertEquals("Extra", internalTransaction.getExtra());
  }

  /**
   * Test {@link InternalTransaction#getHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-six and minus one hundred twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getHash()"})
  public void testGetHash_thenReturnArrayOfByteWithMinusEightySixAndMinusOneHundredTwentyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X', '7', 'O',
            -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'},
        (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L,
            new HashMap<>())).getHash());
  }

  /**
   * Test {@link InternalTransaction#getEncoded()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InternalTransaction#getEncoded()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InternalTransaction.getEncoded()"})
  public void testGetEncoded_thenReturnArrayOfByteWithAAndX() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
            'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        (new InternalTransaction(parentHash, 1, 1, sendAddress, transferToAddress, 42L, data, "Note", 1L,
            new HashMap<>())).getEncoded());
  }
}
