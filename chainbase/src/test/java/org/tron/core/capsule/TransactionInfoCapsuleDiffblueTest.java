package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
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
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertArrayEquals(new byte[]{}, actualTransactionInfoCapsule.getData());
    assertArrayEquals(new byte[]{}, actualTransactionInfoCapsule.getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_when2xaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("2XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithLfAndTwo() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithLfAndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithMinusOneAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithSixteenAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithTwentyFourAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenArrayOfByteWithTwoAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code BXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenBxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("BXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return BlockNumber is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenEmptyArrayOfByte_thenReturnBlockNumberIsZero() throws BadItemException {
    // Arrange and Act
    TransactionInfoCapsule actualTransactionInfoCapsule = new TransactionInfoCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualTransactionInfoCapsule.getBlockNumber());
    assertEquals(0L, actualTransactionInfoCapsule.getBlockTimeStamp());
    assertEquals(0L, actualTransactionInfoCapsule.getFee());
    assertEquals(0L, actualTransactionInfoCapsule.getPackingFee());
    assertEquals(0L, actualTransactionInfoCapsule.getUnfreezeAmount());
    assertEquals(0L, actualTransactionInfoCapsule.getWithdrawAmount());
    assertArrayEquals(new byte[]{}, actualTransactionInfoCapsule.getData());
    assertArrayEquals(new byte[]{}, actualTransactionInfoCapsule.getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException2()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException3()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("*XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException4()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule(":XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.<init>(byte[])"})
  public void testNewTransactionInfoCapsule_whenXxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionInfoCapsule#getPackingFee()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getPackingFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getPackingFee()"})
  public void testGetPackingFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getPackingFee());
  }

  /**
   * Test {@link TransactionInfoCapsule#getFee()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getFee()"})
  public void testGetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getFee());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsule() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 1, 24, 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 1, ' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractAddress is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsuleContractAddressIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{16, 1, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractResult is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsuleContractResultIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{16, 1, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 1, 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Data is array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_thenTransactionInfoCapsuleDataIsArrayOfByteWithLfAndBackspace() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_thenTransactionInfoCapsuleInstanceSerializedSizeIsFive() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 1, Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is thirty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setFee(long)"})
  public void testSetFee_thenTransactionInfoCapsuleInstanceSerializedSizeIsThirtyOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(31, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 1, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a',
        'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getId()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getId()"})
  public void testGetId_givenTransactionInfoCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new TransactionInfoCapsule()).getId());
  }

  /**
   * Test {@link TransactionInfoCapsule#getId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getId()"})
  public void testGetId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualId = transactionInfoCapsule.getId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualId);
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(24, fields.size());
    ByteString orderId = instance.getOrderId();
    assertSame(orderId, fields.get(0).getDefaultValue());
    TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(orderId, defaultInstanceForType.getContractAddress());
    assertSame(orderId, defaultInstanceForType.getId());
    assertSame(orderId, defaultInstanceForType.getOrderId());
    assertSame(orderId, instance.getResMessage());
    assertSame(orderId, defaultInstanceForType.getResMessage());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, '2', '\b', 'A', 2, 'A', 2,
        'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_givenTransactionInfoCapsuleBlockNumberIsTwo() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, 24, 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_givenTransactionInfoCapsuleBlockTimeStampIsTen() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, ' ', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_givenTransactionInfoCapsuleWithdrawAmountIsTen() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance DescriptorForType EnumTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_thenTransactionInfoCapsuleInstanceDescriptorForTypeEnumTypesSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_thenTransactionInfoCapsuleInstanceSerializedSizeIsFifteen()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(15, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is forty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_thenTransactionInfoCapsuleInstanceSerializedSizeIsFortyOne()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(41, instance.getSerializedSize());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l',
            'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_thenTransactionInfoCapsuleInstanceSerializedSizeIsTwelve() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setId(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setId(byte[])"})
  public void testSetId_thenTransactionInfoCapsuleInstanceSerializedSizeIsTwentyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(22, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 16, 2, '*', '\b', 'A', 2, 'A', 2,
        'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getUnfreezeAmount()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getUnfreezeAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getUnfreezeAmount()"})
  public void testGetUnfreezeAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getUnfreezeAmount());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(15, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e',
            'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't', Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount3() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(15, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount4() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(15, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 2, Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setUnfreezeAmount(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setUnfreezeAmount(long)"})
  public void testSetUnfreezeAmount_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getWithdrawAmount()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getWithdrawAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getWithdrawAmount()"})
  public void testGetWithdrawAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getWithdrawAmount());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a',
        'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't', 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount3() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount4() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 2, 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setWithdrawAmount(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setWithdrawAmount(long)"})
  public void testSetWithdrawAmount_thenTransactionInfoCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'x', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(41, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{16, 2, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ',
            'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(41, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{16, 2, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ',
            'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w',
        'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ',
        'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a',
        'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't', 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Data is array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_thenTransactionInfoCapsuleDataIsArrayOfByteWithLfAndBackspace() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(41, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ',
            'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(29, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n',
        'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(31, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a',
        'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setResMessage(String)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is thirty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setResMessage(String)"})
  public void testSetResMessage_thenTransactionInfoCapsuleInstanceSerializedSizeIsThirtyFour() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{16, 2, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e',
            'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't', Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 3, 24, 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 3, ' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractAddress is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsuleContractAddressIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertArrayEquals(new byte[]{16, 3, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractResult is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsuleContractResultIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertArrayEquals(new byte[]{16, 3, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 3, 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()}.</li>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Fee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_givenTransactionInfoCapsule_thenTransactionInfoCapsuleFeeIsOne() {
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
    assertArrayEquals(new byte[]{16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Data is array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_thenTransactionInfoCapsuleDataIsArrayOfByteWithLfAndBackspace() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 3}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertArrayEquals(new byte[]{16, 3}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_thenTransactionInfoCapsuleInstanceSerializedSizeIsFive() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 3, Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addFee(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is thirty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addFee(long)"})
  public void testAddFee_thenTransactionInfoCapsuleInstanceSerializedSizeIsThirtyOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(31, instance.getSerializedSize());
    assertEquals(3L, transactionInfoCapsule.getFee());
    assertEquals(3L, instance.getFee());
    assertArrayEquals(new byte[]{16, 3, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a',
        'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getBlockNumber()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getBlockNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getBlockNumber()"})
  public void testGetBlockNumber() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getBlockNumber());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, 24, 1, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, 24, 1, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 1, ' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 1, 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Data is array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_thenTransactionInfoCapsuleDataIsArrayOfByteWithLfAndBackspace() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, 24, 1},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{24, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_thenTransactionInfoCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 1, Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockNumber(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is thirty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockNumber(long)"})
  public void testSetBlockNumber_thenTransactionInfoCapsuleInstanceSerializedSizeIsThirtyThree() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 1, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w',
        'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getBlockTimeStamp()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getBlockTimeStamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionInfoCapsule.getBlockTimeStamp()"})
  public void testGetBlockTimeStamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getBlockTimeStamp());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, ' ', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ',
        'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp3() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp4() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, 24, 2, ' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', 'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertArrayEquals(new byte[]{' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp_thenTransactionInfoCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setBlockTimeStamp(long)}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setBlockTimeStamp(long)"})
  public void testSetBlockTimeStamp_thenTransactionInfoCapsuleInstanceSerializedSizeIsSeven() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(7, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress2() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(24, fields.size());
    ByteString orderId = instance.getOrderId();
    assertSame(orderId, fields.get(0).getDefaultValue());
    TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(orderId, defaultInstanceForType.getContractAddress());
    assertSame(orderId, defaultInstanceForType.getId());
    assertSame(orderId, defaultInstanceForType.getOrderId());
    assertSame(orderId, instance.getResMessage());
    assertSame(orderId, defaultInstanceForType.getResMessage());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 16, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress3() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(41, instance.getSerializedSize());
    ByteString id = instance.getId();
    TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(id, defaultInstanceForType.getContractAddress());
    assertSame(id, defaultInstanceForType.getId());
    assertSame(id, instance.getOrderId());
    assertSame(id, defaultInstanceForType.getOrderId());
    assertSame(id, defaultInstanceForType.getResMessage());
    assertArrayEquals(
        new byte[]{16, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l',
            ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress4() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(22, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(
        new byte[]{16, 2, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress_givenTransactionInfoCapsuleBlockNumberIsTwo() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, 24, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress_givenTransactionInfoCapsuleBlockTimeStampIsTen()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, ' ', '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress_givenTransactionInfoCapsuleWithdrawAmountIsTen()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress_thenTransactionInfoCapsuleInstanceSerializedSizeIsFifteen()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(15, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#setContractAddress(byte[])}.
   * <ul>
   *   <li>Then {@link TransactionInfoCapsule#TransactionInfoCapsule()} Instance SerializedSize is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.setContractAddress(byte[])"})
  public void testSetContractAddress_thenTransactionInfoCapsuleInstanceSerializedSizeIsTwelve()
      throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{16, 2, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsule() {
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
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} addFee two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleAddFeeTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleBlockNumberIsTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(2L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractAddress is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleContractAddressIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ContractResult is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleContractResultIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} Id is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleIdIsArrayOfByteWithAAndTwo() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ResMessage is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleResMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} UnfreezeAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(2L);

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Test {@link TransactionInfoCapsule#addAllLog(List)}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionInfoCapsule.addAllLog(List)"})
  public void testAddAllLog_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(2L);

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
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractResult(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '*', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData2() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setContractAddress(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} addFee {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleAddFeeMax_value() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(Long.MAX_VALUE);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockNumber is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleBlockNumberIsMinusOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockNumber(-1L);
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} BlockTimeStamp is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleBlockTimeStampIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setBlockTimeStamp(10L);
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} ResMessage is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleResMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setResMessage("Not all who wander are lost");
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h',
            'o', ' ', 'w', 'a', 'n', 'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} UnfreezeAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleUnfreezeAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setUnfreezeAmount(10L);
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, Byte.MIN_VALUE, 1, '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()} WithdrawAmount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsuleWithdrawAmountIsTen() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setWithdrawAmount(10L);
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 'x', '\n'},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionInfoCapsule#TransactionInfoCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_givenTransactionInfoCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new TransactionInfoCapsule()).getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLfAndBackspace() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.setId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with sixteen and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionInfoCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSixteenAndMinusOne() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();
    transactionInfoCapsule.addFee(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Test {@link TransactionInfoCapsule#getInstance()}.
   * <p>
   * Method under test: {@link TransactionInfoCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionInfo TransactionInfoCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    TransactionInfo actualInstance = (new TransactionInfoCapsule()).getInstance();

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
    List<InternalTransaction> internalTransactionsList = actualInstance.getInternalTransactionsList();
    assertTrue(internalTransactionsList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(actualInstance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
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
