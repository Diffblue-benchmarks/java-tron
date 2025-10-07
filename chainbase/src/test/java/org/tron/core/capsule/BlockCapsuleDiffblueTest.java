package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.Transaction;

public class BlockCapsuleDiffblueTest {
  /**
   * Test BlockId {@link BlockId#compareTo(Sha256Hash)} with {@code Sha256Hash}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>When {@link BlockId#BlockId()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#compareTo(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockId.compareTo(Sha256Hash)"})
  public void testBlockIdCompareToWithSha256Hash_givenBlockId_whenBlockId_thenReturnZero() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act and Assert
    assertEquals(0, blockId.compareTo(new BlockId()));
  }

  /**
   * Test BlockId {@link BlockId#compareTo(Sha256Hash)} with {@code Sha256Hash}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#compareTo(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockId.compareTo(Sha256Hash)"})
  public void testBlockIdCompareToWithSha256Hash_givenBlockId_whenZero_hash_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new BlockId().compareTo(Sha256Hash.ZERO_HASH));
  }

  /**
   * Test BlockId {@link BlockId#compareTo(Sha256Hash)} with {@code Sha256Hash}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#compareTo(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockId.compareTo(Sha256Hash)"})
  public void testBlockIdCompareToWithSha256Hash_thenReturnMinusOne() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act
    int actualCompareToResult = blockId.compareTo(new Sha256Hash(31L, Sha256Hash.ZERO_HASH));

    // Assert
    assertEquals(-1, actualCompareToResult);
  }

  /**
   * Test BlockId {@link BlockId#compareTo(Sha256Hash)} with {@code Sha256Hash}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#compareTo(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockId.compareTo(Sha256Hash)"})
  public void testBlockIdCompareToWithSha256Hash_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new BlockId(Sha256Hash.ZERO_HASH, 31L).compareTo(Sha256Hash.ZERO_HASH));
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}, and {@link BlockId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockId#equals(Object)}
   *   <li>{@link BlockId#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockId blockId = new BlockId();
    BlockId blockId2 = new BlockId();

    // Act and Assert
    assertEquals(blockId, blockId2);
    assertEquals(blockId.hashCode(), blockId2.hashCode());
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}, and {@link BlockId#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockId#equals(Object)}
   *   <li>{@link BlockId#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act and Assert
    assertEquals(blockId, blockId);
    int expectedHashCodeResult = blockId.hashCode();
    assertEquals(expectedHashCodeResult, blockId.hashCode());
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BlockId blockId = new BlockId(Sha256Hash.ZERO_HASH, 1L);

    // Act and Assert
    assertNotEquals(blockId, new BlockId());
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange, Act and Assert
    assertEquals(new BlockId(), Sha256Hash.ZERO_HASH);
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockId(), null);
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockId(), "Different type to BlockId");
  }

  /**
   * Test BlockId {@link BlockId#getNum()}.
   *
   * <p>Method under test: {@link BlockId#getNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BlockId.getNum()", "java.lang.String BlockId.toString()"})
  public void testBlockIdGetNum() {
    // Arrange, Act and Assert
    assertEquals(0L, new BlockId().getNum());
  }

  /**
   * Test BlockId {@link BlockId#getString()}.
   *
   * <p>Method under test: {@link BlockId#getString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BlockId.getString()"})
  public void testBlockIdGetString() {
    // Arrange, Act and Assert
    assertEquals(
        "Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        new BlockId().getString());
  }

  /**
   * Test BlockId {@link BlockId#BlockId()}.
   *
   * <p>Method under test: {@link BlockId#BlockId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockId.<init>()"})
  public void testBlockIdNewBlockId() {
    // Arrange and Act
    BlockId actualBlockId = new BlockId();

    // Assert
    BigInteger toBigIntegerResult = actualBlockId.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    assertEquals(
        "Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockId.getString());
    ByteString byteString = actualBlockId.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    assertEquals(0L, actualBlockId.getNum());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualBlockId.getBytes());
  }

  /**
   * Test BlockId {@link BlockId#BlockId(Sha256Hash)}.
   *
   * <p>Method under test: {@link BlockId#BlockId(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockId.<init>(Sha256Hash)"})
  public void testBlockIdNewBlockId2() {
    // Arrange, Act and Assert
    assertEquals(Sha256Hash.ZERO_HASH, new BlockId(Sha256Hash.ZERO_HASH));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag())
        .thenThrow(
            new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule2() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64())
        .thenThrow(
            new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule3() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule("\n\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule5() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule("A\bA\bA\bA\bA\bA\bA\bA\n".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule6() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule("\n\nA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule7() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule("\n\b\n\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return Transactions size is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(long, ByteString, long, List)"})
  public void testNewBlockCapsule_givenDefaultInstance_thenReturnTransactionsSizeIsOne() {
    // Arrange
    ByteString parentHash = mock(ByteString.class);

    ArrayList<Transaction> transactionList = new ArrayList<>();
    transactionList.add(Transaction.getDefaultInstance());

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(10L, parentHash, 1L, transactionList);

    // Assert
    List<TransactionCapsule> transactions = actualBlockCapsule.getTransactions();
    assertEquals(1, transactions.size());
    Block instance = actualBlockCapsule.getInstance();
    assertEquals(1, instance.getTransactionsList().size());
    assertEquals(1, instance.getTransactionsCount());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12L, actualBlockCapsule.getSerializedSize());
    assertEquals(45, instance.getDescriptorForType().getFile().getMessageTypes().size());
    TransactionCapsule getResult = transactions.get(0);
    assertArrayEquals(new byte[] {}, getResult.getData());
    assertArrayEquals(
        new byte[] {0}, actualBlockCapsule.getAccountRoot().toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[] {'\n', 0, 18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1},
        actualBlockCapsule.getData());
    BlockId blockId = actualBlockCapsule.getBlockId();
    assertArrayEquals(
        new byte[] {
          1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2, '\t', 'y', -29, 'Z',
          -46, '4', '^', 't', '!', -35, -38
        },
        blockId.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        getResult.getMerkleHash().getBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        getResult.getTransactionId().getBytes());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
          '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38
        },
        blockId.getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule_givenRuntimeException() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   *
   * <ul>
   *   <li>Then return Instance SerializedSize is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(long, ByteString, long, List)"})
  public void testNewBlockCapsule_thenReturnInstanceSerializedSizeIsFourteen() {
    // Arrange
    ByteString parentHash = mock(ByteString.class);

    ArrayList<Transaction> transactionList = new ArrayList<>();
    transactionList.add(Transaction.getDefaultInstance());
    transactionList.add(Transaction.getDefaultInstance());

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(10L, parentHash, 1L, transactionList);

    // Assert
    Block instance = actualBlockCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(14L, actualBlockCapsule.getSerializedSize());
    assertEquals(2, actualBlockCapsule.getTransactions().size());
    assertEquals(2, instance.getTransactionsList().size());
    assertEquals(2, instance.getTransactionsCount());
    assertArrayEquals(
        new byte[] {'\n', 0, '\n', 0, 18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1},
        actualBlockCapsule.getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
          '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38
        },
        actualBlockCapsule.getBlockId().getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Instance TransactionsCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(long, ByteString, long, List)"})
  public void testNewBlockCapsule_whenArrayList_thenReturnInstanceTransactionsCountIsZero() {
    // Arrange
    ByteString parentHash = mock(ByteString.class);

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(10L, parentHash, 1L, new ArrayList<>());

    // Assert
    Block instance = actualBlockCapsule.getInstance();
    assertEquals(0, instance.getTransactionsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10L, actualBlockCapsule.getSerializedSize());
    assertEquals(2, instance.getDescriptorForType().getFields().size());
    assertTrue(actualBlockCapsule.getTransactions().isEmpty());
    List<Transaction> transactionsList = instance.getTransactionsList();
    assertTrue(transactionsList.isEmpty());
    Block defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(transactionsList, defaultInstanceForType.getTransactionsList());
    assertSame(transactionsList, defaultInstanceForType.getTransactionsOrBuilderList());
    assertArrayEquals(
        new byte[] {0}, actualBlockCapsule.getAccountRoot().toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[] {18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1}, actualBlockCapsule.getData());
    BlockId blockId = actualBlockCapsule.getBlockId();
    assertArrayEquals(
        new byte[] {
          1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2, '\t', 'y', -29, 'Z',
          -46, '4', '^', 't', '!', -35, -38
        },
        blockId.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
          '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38
        },
        blockId.getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithAAndBackspace_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  18
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithAAndBackspace_thenThrowBadItemException2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  -1
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and backspace.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndBackspace()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and backspace.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndBackspace2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  18, '\b', 1, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and backspace.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndBackspace3()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  18, '\b', 18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndLf_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  18, '\n', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndX_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndZero_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndBackspace_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  '\n', '\b', 1, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and backspace.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndBackspace_thenThrowBadItemException2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  '\n', '\b', 18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndZero_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithMinusOneAndX_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithOneAndX_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new BlockCapsule(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   *
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readFixed64()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule_whenCodedInputStreamReadFixed64ReturnOne()
      throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64()).thenReturn(1L);
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(Block)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Bloom is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(Protocol.Block)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(Protocol.Block)"})
  public void testNewBlockCapsule_whenDefaultInstance_thenReturnBloomIsNull() {
    // Arrange
    Block block = Block.getDefaultInstance();

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(block);

    // Assert
    assertNull(actualBlockCapsule.getBloom());
    assertNull(actualBlockCapsule.getResult());
    assertEquals(0L, actualBlockCapsule.getNum());
    assertEquals(0L, actualBlockCapsule.getSerializedSize());
    assertEquals(0L, actualBlockCapsule.getTimeStamp());
    assertFalse(actualBlockCapsule.hasWitnessSignature());
    assertFalse(actualBlockCapsule.isSwitch());
    assertFalse(actualBlockCapsule.generatedByMyself);
    assertTrue(actualBlockCapsule.getTransactions().isEmpty());
    assertTrue(actualBlockCapsule.isMerkleRootEmpty());
    assertSame(block, actualBlockCapsule.getInstance());
    assertArrayEquals(new byte[] {}, actualBlockCapsule.getData());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Bloom is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenEmptyArrayOfByte_thenReturnBloomIsNull()
      throws BadItemException {
    // Arrange and Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(new byte[] {});

    // Assert
    assertNull(actualBlockCapsule.getBloom());
    assertNull(actualBlockCapsule.getResult());
    assertEquals(0L, actualBlockCapsule.getNum());
    assertEquals(0L, actualBlockCapsule.getSerializedSize());
    assertEquals(0L, actualBlockCapsule.getTimeStamp());
    assertFalse(actualBlockCapsule.hasWitnessSignature());
    assertFalse(actualBlockCapsule.isSwitch());
    assertFalse(actualBlockCapsule.generatedByMyself);
    assertTrue(actualBlockCapsule.getTransactions().isEmpty());
    assertTrue(actualBlockCapsule.isMerkleRootEmpty());
    assertArrayEquals(new byte[] {}, actualBlockCapsule.getData());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenLf_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new BlockCapsule(
                new byte[] {
                  18, '\b', '\n', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A',
                  '\b'
                }));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, Sha256Hash, long, ByteString)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return Bloom is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BlockCapsule#BlockCapsule(long, Sha256Hash, long, ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockCapsule.<init>(long, Sha256Hash, long, ByteString)"})
  public void testNewBlockCapsule_whenZero_hash_thenReturnBloomIsNull() {
    // Arrange
    ByteString witnessAddress = mock(ByteString.class);

    // Act
    BlockCapsule actualBlockCapsule =
        new BlockCapsule(1L, Sha256Hash.ZERO_HASH, 1L, witnessAddress);

    // Assert
    assertNull(actualBlockCapsule.getBloom());
    assertNull(actualBlockCapsule.getResult());
    assertEquals(1L, actualBlockCapsule.getNum());
    assertEquals(1L, actualBlockCapsule.getTimeStamp());
    assertEquals(46L, actualBlockCapsule.getSerializedSize());
    assertFalse(actualBlockCapsule.hasWitnessSignature());
    assertFalse(actualBlockCapsule.isSwitch());
    assertFalse(actualBlockCapsule.generatedByMyself);
    assertTrue(actualBlockCapsule.getTransactions().isEmpty());
    assertTrue(actualBlockCapsule.isMerkleRootEmpty());
    assertSame(Sha256Hash.ZERO_HASH, actualBlockCapsule.getAccountRoot());
    assertSame(witnessAddress, actualBlockCapsule.getWitnessAddress());
    assertArrayEquals(
        new byte[] {
          18, ',', '\n', '*', '\b', 1, 26, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '8', 1, 'J', 0, 'P', ' '
        },
        actualBlockCapsule.getData());
  }
}
