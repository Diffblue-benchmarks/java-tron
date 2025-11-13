package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.InternalTransaction;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionInfo.Log;
import org.tron.protos.Protocol.TransactionInfo.code;

public class TransactionInfoCapsuleDiffblueTest {
  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>()"})
  public void testNewTransactionInfoCapsule() {
    // Arrange and Act
    TransactionInfoCapsule actualTransactionInfoCapsule = new TransactionInfoCapsule();

    // Assert
    assertEquals(0L, actualTransactionInfoCapsule.getBlockNumber());
    assertEquals(0L, actualTransactionInfoCapsule.getBlockTimeStamp());
    assertEquals(0L, actualTransactionInfoCapsule.getFee());
    assertEquals(0L, actualTransactionInfoCapsule.getPackingFee());
    assertEquals(0L, actualTransactionInfoCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionInfoCapsule.getWithdrawAmount());
    assertArrayEquals(new byte[] {}, actualTransactionInfoCapsule.getData());
    assertArrayEquals(new byte[] {}, actualTransactionInfoCapsule.getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_when2xaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule("2XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWith2AndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionInfoCapsule(
                new byte[] {'2', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWith2AndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithAAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionInfoCapsule(
                new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithAsteriskAndTwo()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionInfoCapsule(
                new byte[] {'*', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithAsteriskAndZero()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code :} and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithColonAndTwo()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionInfoCapsule(
                new byte[] {':', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithLfAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            new TransactionInfoCapsule(
                new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithLfAndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithMinusOneAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithSixteenAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithTwentyFourAndX()
      throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return BlockNumber is zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenEmptyArrayOfByte_thenReturnBlockNumberIsZero()
      throws BadItemException {
    // Arrange and Act
    TransactionInfoCapsule actualTransactionInfoCapsule = new TransactionInfoCapsule(new byte[] {});

    // Assert
    assertEquals(0L, actualTransactionInfoCapsule.getBlockNumber());
    assertEquals(0L, actualTransactionInfoCapsule.getBlockTimeStamp());
    assertEquals(0L, actualTransactionInfoCapsule.getFee());
    assertEquals(0L, actualTransactionInfoCapsule.getPackingFee());
    assertEquals(0L, actualTransactionInfoCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionInfoCapsule.getWithdrawAmount());
    assertArrayEquals(new byte[] {}, actualTransactionInfoCapsule.getData());
    assertArrayEquals(new byte[] {}, actualTransactionInfoCapsule.getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException2()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException3()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule("*XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException4()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule(":XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link BadItemException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class, () -> new TransactionInfoCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#getPackingFee()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getPackingFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getPackingFee()"})
  public void testGetPackingFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getPackingFee());
  }

  /**
   * Test {@link TransactionInfoCapsule#getFee()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getFee()"})
  public void testGetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getFee());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getId()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new TransactionInfoCapsule().getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString id = instance.getId();
    assertEquals("AXAXAXAX", id.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(id.isEmpty());
    ByteIterator iteratorResult = id.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), transactionInfoCapsule.getId());
    assertArrayEquals("\n\bAXAXAXAX".getBytes("UTF-8"), transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getUnfreezeAmount()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getUnfreezeAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getUnfreezeAmount()"})
  public void testGetUnfreezeAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getUnfreezeAmount());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getWithdrawAmount()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getWithdrawAmount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getWithdrawAmount()"})
  public void testGetWithdrawAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getWithdrawAmount());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString resMessage = instance.getResMessage();
    assertEquals("Not all who wander are lost", resMessage.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(29, instance.getSerializedSize());
    assertFalse(resMessage.isEmpty());
    ByteIterator iteratorResult = resMessage.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('N', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd',
          'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'
        },
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getBlockNumber()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getBlockNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getBlockNumber()"})
  public void testGetBlockNumber() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getBlockNumber());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getBlockNumber());
    assertEquals(1L, instance.getBlockNumber());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getBlockTimeStamp()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getBlockTimeStamp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionInfoCapsule.getBlockTimeStamp()"})
  public void testGetBlockTimeStamp() {
    // Arrange, Act and Assert
    assertEquals(0L, new TransactionInfoCapsule().getBlockTimeStamp());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getBlockTimeStamp());
    assertEquals(10L, instance.getBlockTimeStamp());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractResult(byte[])}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setContractResult(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractResult(byte[])"})
  public void testSetContractResult() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setContractResult("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<ByteString> contractResultList = instance.getContractResultList();
    assertEquals(1, contractResultList.size());
    ByteString getResult = contractResultList.get(0);
    assertEquals("AXAXAXAX", getResult.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getContractResultCount());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(getResult.isEmpty());
    assertTrue(getResult.iterator().hasNext());
    assertTrue(instance.getDefaultInstanceForType().getContractResultList().isEmpty());
    assertArrayEquals("*\bAXAXAXAX".getBytes("UTF-8"), transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString contractAddress = instance.getContractAddress();
    assertEquals("AXAXAXAX", contractAddress.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(contractAddress.isEmpty());
    assertTrue(contractAddress.iterator().hasNext());
    ByteString id = instance.getId();
    TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(id, defaultInstanceForType.getContractAddress());
    assertSame(id, defaultInstanceForType.getId());
    assertSame(id, instance.getOrderId());
    assertSame(id, defaultInstanceForType.getOrderId());
    assertSame(id, instance.getResMessage());
    assertSame(id, defaultInstanceForType.getResMessage());
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new TransactionInfoCapsule().getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getInstance()}.
   *
   * <p>Method under test: {@link TransactionInfoCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TransactionInfo TransactionInfoCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    TransactionInfo actualInstance = new TransactionInfoCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals("", actualInstance.getAssetIssueID());
    assertEquals(0, actualInstance.getCancelUnfreezeV2AmountCount());
    assertEquals(0, actualInstance.getContractResultCount());
    assertEquals(0, actualInstance.getInternalTransactionsCount());
    assertEquals(0, actualInstance.getLogCount());
    assertEquals(0, actualInstance.getOrderDetailsCount());
    assertEquals(0, actualInstance.getResultValue());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0L, actualInstance.getBlockNumber());
    assertEquals(0L, actualInstance.getBlockTimeStamp());
    assertEquals(0L, actualInstance.getExchangeId());
    assertEquals(0L, actualInstance.getExchangeInjectAnotherAmount());
    assertEquals(0L, actualInstance.getExchangeReceivedAmount());
    assertEquals(0L, actualInstance.getExchangeWithdrawAnotherAmount());
    assertEquals(0L, actualInstance.getFee());
    assertEquals(0L, actualInstance.getPackingFee());
    assertEquals(0L, actualInstance.getShieldedTransactionFee());
    assertEquals(0L, actualInstance.getUnfreezeAmount());
    assertEquals(0L, actualInstance.getWithdrawAmount());
    assertEquals(0L, actualInstance.getWithdrawExpireAmount());
    assertEquals(code.SUCESS, actualInstance.getResult());
    assertFalse(actualInstance.hasReceipt());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getContractResultList().isEmpty());
    List<InternalTransaction> internalTransactionsList =
        actualInstance.getInternalTransactionsList();
    assertTrue(internalTransactionsList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2AmountMap().isEmpty());
    TransactionInfo actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
    ByteString contractAddress = actualInstance.getContractAddress();
    assertSame(contractAddress, actualInstance.getId());
    assertSame(contractAddress, actualInstance.getOrderId());
    assertSame(contractAddress, actualInstance.getResMessage());
    assertSame(internalTransactionsList, actualInstance.getInternalTransactionsOrBuilderList());
    assertSame(internalTransactionsList, actualInstance.getLogList());
    assertSame(internalTransactionsList, actualInstance.getLogOrBuilderList());
    assertSame(internalTransactionsList, actualInstance.getOrderDetailsList());
    assertSame(internalTransactionsList, actualInstance.getOrderDetailsOrBuilderList());
  }
}
