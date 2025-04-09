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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#compareTo(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BlockId.compareTo(Sha256Hash)"})
  public void testBlockIdCompareToWithSha256Hash_whenBlockId_thenReturnZero() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act and Assert
    assertEquals(0, blockId.compareTo(new BlockId()));
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}, and {@link BlockId#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockId#equals(Object)}
   *   <li>{@link BlockId#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockId blockId = new BlockId();
    BlockId blockId2 = new BlockId();

    // Act and Assert
    assertEquals(blockId, blockId2);
    int expectedHashCodeResult = blockId.hashCode();
    assertEquals(expectedHashCodeResult, blockId2.hashCode());
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}, and {@link BlockId#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockId#equals(Object)}
   *   <li>{@link BlockId#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockId(), null);
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = new BlockId();
    Sha256Hash sha256Hash = mock(Sha256Hash.class);
    when(sha256Hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(blockId, sha256Hash);
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockId(), null);
  }

  /**
   * Test BlockId {@link BlockId#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockId.equals(Object)", "int BlockId.hashCode()"})
  public void testBlockIdEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockId(), "Different type to BlockId");
  }

  /**
   * Test BlockId {@link BlockId#getString()}.
   * <p>
   * Method under test: {@link BlockId#getString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BlockId.getString()"})
  public void testBlockIdGetString() {
    // Arrange, Act and Assert
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        (new BlockId()).getString());
  }

  /**
   * Test BlockId getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockId#toString()}
   *   <li>{@link BlockId#getNum()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BlockId.getNum()", "String BlockId.toString()"})
  public void testBlockIdGettersAndSetters() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act
    String actualToStringResult = blockId.toString();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", actualToStringResult);
    assertEquals(0L, blockId.getNum());
  }

  /**
   * Test BlockId {@link BlockId#BlockId()}.
   * <p>
   * Method under test: {@link BlockId#BlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockId.<init>()"})
  public void testBlockIdNewBlockId() {
    // Arrange and Act
    BlockId actualBlockId = new BlockId();

    // Assert
    BigInteger toBigIntegerResult = actualBlockId.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
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
    assertArrayEquals(new byte[]{0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBlockId.getBytes());
  }

  /**
   * Test BlockId {@link BlockId#BlockId(Sha256Hash)}.
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockId#BlockId(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockId.<init>(Sha256Hash)"})
  public void testBlockIdNewBlockId_whenBlockId_thenReturnBlockId() {
    // Arrange
    BlockId blockId = new BlockId();

    // Act and Assert
    assertEquals(blockId, new BlockId(blockId));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64())
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return Transactions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertArrayEquals(new byte[]{}, getResult.getData());
    assertArrayEquals(new byte[]{0}, actualBlockCapsule.getAccountRoot().toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{'\n', 0, 18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1}, actualBlockCapsule.getData());
    BlockId blockId = actualBlockCapsule.getBlockId();
    assertArrayEquals(new byte[]{1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2, '\t', 'y', -29, 'Z',
        -46, '4', '^', 't', '!', -35, -38}, blockId.toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        getResult.getMerkleHash().getBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        getResult.getTransactionId().getBytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
        '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38}, blockId.getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   * <ul>
   *   <li>Then return Instance SerializedSize is fourteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertArrayEquals(new byte[]{'\n', 0, '\n', 0, 18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1},
        actualBlockCapsule.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
        '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38}, actualBlockCapsule.getBlockId().getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Instance TransactionsCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(long, ByteString, long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertArrayEquals(new byte[]{0}, actualBlockCapsule.getAccountRoot().toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{18, '\b', '\n', 6, '\b', '\n', 26, 0, '8', 1}, actualBlockCapsule.getData());
    BlockId blockId = actualBlockCapsule.getBlockId();
    assertArrayEquals(new byte[]{1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2, '\t', 'y', -29, 'Z',
        -46, '4', '^', 't', '!', -35, -38}, blockId.toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 17, 'a', -104, -1, '-', '1', 'v', -101, '>', 'W', 26, -54, -2,
        '\t', 'y', -29, 'Z', -46, '4', '^', 't', '!', -35, -38}, blockId.getBytes());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndOne_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndOne_thenThrowBadItemException2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndOne_thenThrowBadItemException3()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndOne_thenThrowBadItemException4()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndX_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndZero_thenThrowBadItemException()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithEighteenAndZero_thenThrowBadItemException2()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 0, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndOne_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndOne_thenThrowBadItemException2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndOne_thenThrowBadItemException3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndOne_thenThrowBadItemException4() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, -1, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithLfAndZero_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithMinusOneAndX_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenArrayOfByteWithOneAndX_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(long, Sha256Hash, long, ByteString)}.
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return Bloom is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(long, Sha256Hash, long, ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(long, Sha256Hash, long, ByteString)"})
  public void testNewBlockCapsule_whenBlockId_thenReturnBloomIsNull() {
    // Arrange
    BlockId hash = new BlockId();
    ByteString witnessAddress = mock(ByteString.class);

    // Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(1L, hash, 1L, witnessAddress);

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
    assertEquals(hash, actualBlockCapsule.getParentBlockId());
    assertEquals(hash, actualBlockCapsule.getParentHash());
    Sha256Hash expectedAccountRoot = hash.ZERO_HASH;
    assertSame(expectedAccountRoot, actualBlockCapsule.getAccountRoot());
    assertSame(witnessAddress, actualBlockCapsule.getWitnessAddress());
    assertArrayEquals(new byte[]{18, ',', '\n', '*', '\b', 1, 26, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '8', 1, 'J', 0, 'P', ' '}, actualBlockCapsule.getData());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(CodedInputStream)}.
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readFixed64()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(CodedInputStream)"})
  public void testNewBlockCapsule_whenCodedInputStreamReadFixed64ReturnOne() throws IOException, BadItemException {
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
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Bloom is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(Block)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(Block)"})
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
    assertArrayEquals(new byte[]{}, actualBlockCapsule.getData());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Bloom is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenEmptyArrayOfByte_thenReturnBloomIsNull() throws BadItemException {
    // Arrange and Act
    BlockCapsule actualBlockCapsule = new BlockCapsule(new byte[]{});

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
    assertArrayEquals(new byte[]{}, actualBlockCapsule.getData());
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenLf_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{'\n', 1, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenLf_thenThrowBadItemException2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule(new byte[]{18, 1, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BlockCapsule#BlockCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockCapsule#BlockCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockCapsule.<init>(byte[])"})
  public void testNewBlockCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException2()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }
}
