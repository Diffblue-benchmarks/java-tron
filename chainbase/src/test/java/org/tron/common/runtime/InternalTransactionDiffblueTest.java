package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InternalTransaction.<init>(Transaction, TrxType)"})
  public void testNewInternalTransaction() throws ContractValidateException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction =
        new InternalTransaction(Transaction.getDefaultInstance(), TrxType.TRX_PRECOMPILED_TYPE);

    // Assert
    Transaction transaction = actualInternalTransaction.getTransaction();
    Transaction actualDefaultInstanceForType = transaction.getDefaultInstanceForType();
    assertSame(transaction, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getEncoded());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long,
   * byte[], String, long, Map)}.
   *
   * <p>Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[],
   * byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"
  })
  public void testNewInternalTransaction2() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualInternalTransaction =
        new InternalTransaction(
            parentHash, 1, 1, sendAddress, new byte[] {}, 42L, data, "Note", 1L, new HashMap<>());

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getParentHash());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getSender());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getReceiveAddress());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0,
          0, 0, 0, 0, '*'
        },
        actualInternalTransaction.getEncoded());
    assertArrayEquals(
        new byte[] {
          -108,
          3,
          -93,
          '2',
          'P',
          ',',
          -19,
          -105,
          '4',
          'Y',
          '.',
          -57,
          -35,
          -32,
          'j',
          'K',
          '3',
          'E',
          -17,
          Byte.MIN_VALUE,
          -18,
          'T',
          ' ',
          '[',
          24,
          -15,
          14,
          'n',
          -2,
          'l',
          -23,
          20
        },
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long,
   * byte[], String, long, Map)}.
   *
   * <ul>
   *   <li>Then return ReceiveAddress is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[],
   * byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"
  })
  public void testNewInternalTransaction_thenReturnReceiveAddressIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualInternalTransaction =
        new InternalTransaction(
            parentHash,
            1,
            1,
            sendAddress,
            transferToAddress,
            42L,
            data,
            "Note",
            1L,
            new HashMap<>());

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getParentHash());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getReceiveAddress());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getSender());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'
        },
        actualInternalTransaction.getHash());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
          'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'
        },
        actualInternalTransaction.getEncoded());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[], byte[], long,
   * byte[], String, long, Map)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#InternalTransaction(byte[], int, int, byte[],
   * byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InternalTransaction.<init>(byte[], int, int, byte[], byte[], long, byte[], String, long, Map)"
  })
  public void testNewInternalTransaction_whenA_thenReturnDataIsEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction =
        new InternalTransaction(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            1,
            1,
            null,
            null,
            42L,
            null,
            "Note",
            1L,
            null);

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInternalTransaction.getParentHash());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getData());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getReceiveAddress());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getSender());
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getTransferToAddress());
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'},
        actualInternalTransaction.getEncoded());
    assertArrayEquals(
        new byte[] {
          -22,
          'I',
          -109,
          -90,
          -12,
          'C',
          Byte.MAX_VALUE,
          -39,
          -25,
          '$',
          -110,
          -1,
          -112,
          '|',
          '}',
          16,
          16,
          '9',
          'B',
          'x',
          -65,
          1,
          '9',
          -55,
          '{',
          -110,
          '(',
          -14,
          -85,
          -121,
          -40,
          -86
        },
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}.
   *
   * <ul>
   *   <li>When {@code TRX_UNKNOWN_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#InternalTransaction(Transaction, TrxType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void InternalTransaction.<init>(Transaction, TrxType)"})
  public void testNewInternalTransaction_whenTrxUnknownType() throws ContractValidateException {
    // Arrange and Act
    InternalTransaction actualInternalTransaction =
        new InternalTransaction(Transaction.getDefaultInstance(), TrxType.TRX_UNKNOWN_TYPE);

    // Assert
    Transaction transaction = actualInternalTransaction.getTransaction();
    Transaction actualDefaultInstanceForType = transaction.getDefaultInstanceForType();
    assertSame(transaction, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualInternalTransaction.getEncoded());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualInternalTransaction.getHash());
  }

  /**
   * Test {@link InternalTransaction#getTransferToAddress()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getTransferToAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getTransferToAddress()"})
  public void testGetTransferToAddress_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getTransferToAddress());
  }

  /**
   * Test {@link InternalTransaction#getNote()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTransaction.getNote()"})
  public void testGetNote_thenReturnEmptyString() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        "",
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                null,
                1L,
                new HashMap<>())
            .getNote());
  }

  /**
   * Test {@link InternalTransaction#getNote()}.
   *
   * <ul>
   *   <li>Then return {@code Note}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getNote()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTransaction.getNote()"})
  public void testGetNote_thenReturnNote() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        "Note",
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getNote());
  }

  /**
   * Test {@link InternalTransaction#getSender()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getSender()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getSender()"})
  public void testGetSender_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getSender());
  }

  /**
   * Test {@link InternalTransaction#getReceiveAddress()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getReceiveAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getReceiveAddress()"})
  public void testGetReceiveAddress_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getReceiveAddress());
  }

  /**
   * Test {@link InternalTransaction#getParentHash()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getParentHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getParentHash()"})
  public void testGetParentHash_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getParentHash());
  }

  /**
   * Test {@link InternalTransaction#getData()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getData()"})
  public void testGetData_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getData());
  }

  /**
   * Test {@link InternalTransaction#getExtra()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTransaction.getExtra()"})
  public void testGetExtra_thenReturnEmptyString() throws ContractValidateException {
    // Arrange
    InternalTransaction internalTransaction =
        new InternalTransaction(Transaction.getDefaultInstance(), TrxType.TRX_PRECOMPILED_TYPE);
    internalTransaction.setExtra(null);

    // Act and Assert
    assertEquals("", internalTransaction.getExtra());
  }

  /**
   * Test {@link InternalTransaction#getExtra()}.
   *
   * <ul>
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getExtra()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String InternalTransaction.getExtra()"})
  public void testGetExtra_thenReturnFoo() throws ContractValidateException {
    // Arrange
    InternalTransaction internalTransaction =
        new InternalTransaction(Transaction.getDefaultInstance(), TrxType.TRX_PRECOMPILED_TYPE);
    internalTransaction.setExtra("foo");

    // Act and Assert
    assertEquals("foo", internalTransaction.getExtra());
  }

  /**
   * Test {@link InternalTransaction#getHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-six and minus one hundred twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
        new byte[] {
          -86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X',
          '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'
        },
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getHash());
  }

  /**
   * Test {@link InternalTransaction#getEncoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link InternalTransaction#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] InternalTransaction.getEncoded()"})
  public void testGetEncoded_thenReturnArrayOfByteWithAAndX() throws UnsupportedEncodingException {
    // Arrange
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] sendAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferToAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
          'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'
        },
        new InternalTransaction(
                parentHash,
                1,
                1,
                sendAddress,
                transferToAddress,
                42L,
                data,
                "Note",
                1L,
                new HashMap<>())
            .getEncoded());
  }
}
