package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionRet;

public class TransactionRetCapsuleDiffblueTest {
  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule()}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>()"})
  public void testNewTransactionRetCapsule() {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule = new TransactionRetCapsule();

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[]{}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(BlockCapsule)}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(BlockCapsule)"})
  public void testNewTransactionRetCapsule2() {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule = new TransactionRetCapsule((BlockCapsule) null);

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[]{}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule3() throws BadItemException {
    // Arrange and Act
    TransactionRetCapsule actualTransactionRetCapsule = new TransactionRetCapsule(new byte[]{});

    // Assert
    TransactionRet instance = actualTransactionRetCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getTransactioninfoCount());
    assertEquals(0L, instance.getBlockNumber());
    assertEquals(0L, instance.getBlockTimeStamp());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = instance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(transactioninfoList, instance.getTransactioninfoOrBuilderList());
    assertArrayEquals(new byte[]{}, actualTransactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 16}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 26}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithAAndBackspace3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithFourAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithMinusOneAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithSixteenAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndFour() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndFour2() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 16, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndFour3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 2, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndFour4() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 24, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndX() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenArrayOfByteWithTwentySixAndZero() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenAsterisk_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '*', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenAxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When backspace.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenBackspace_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '\b', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenLf_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenSpace_thenThrowBadItemException() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, ' ', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenXaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link BadItemException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.<init>(byte[])"})
  public void testNewTransactionRetCapsule_whenXxaxaxaxBytesIsUtf8_thenThrowBadItemException()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionRetCapsule#addAllTransactionInfos(List)}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#addAllTransactionInfos(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.addAllTransactionInfos(List)"})
  public void testAddAllTransactionInfos() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();

    // Act
    transactionRetCapsule.addAllTransactionInfos(new ArrayList<>());

    // Assert
    TransactionRet instance = transactionRetCapsule.getInstance();
    TransactionRet defaultInstanceForType = instance.getDefaultInstanceForType();
    List<TransactionInfo> transactioninfoList = defaultInstanceForType.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(transactioninfoList, toProtoResult.getEnumTypeList());
    assertSame(transactioninfoList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionList());
    assertSame(transactioninfoList, toProtoResult.getExtensionOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeOrBuilderList());
    MessageOptions options = descriptorForType.getOptions();
    assertSame(transactioninfoList, options.getUninterpretedOptionList());
    assertSame(transactioninfoList, options.getUninterpretedOptionOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType.getTransactioninfoOrBuilderList());
  }

  /**
   * Test {@link TransactionRetCapsule#addAllTransactionInfos(List)}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#addAllTransactionInfos(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionRetCapsule.addAllTransactionInfos(List)"})
  public void testAddAllTransactionInfos2() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();
    transactionRetCapsule.addTransactionInfo(TransactionInfo.getDefaultInstance());

    // Act
    transactionRetCapsule.addAllTransactionInfos(new ArrayList<>());

    // Assert that nothing has changed
    TransactionRet instance = transactionRetCapsule.getInstance();
    TransactionRet defaultInstanceForType = instance.getDefaultInstanceForType();
    List<TransactionInfo> transactioninfoList = defaultInstanceForType.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(transactioninfoList, toProtoResult.getEnumTypeList());
    assertSame(transactioninfoList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionList());
    assertSame(transactioninfoList, toProtoResult.getExtensionOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeOrBuilderList());
    MessageOptions options = descriptorForType.getOptions();
    assertSame(transactioninfoList, options.getUninterpretedOptionList());
    assertSame(transactioninfoList, options.getUninterpretedOptionOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType.getTransactioninfoOrBuilderList());
  }

  /**
   * Test {@link TransactionRetCapsule#getData()}.
   * <ul>
   *   <li>Given {@link TransactionRetCapsule#TransactionRetCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionRetCapsule.getData()"})
  public void testGetData_givenTransactionRetCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new TransactionRetCapsule()).getData());
  }

  /**
   * Test {@link TransactionRetCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionRetCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionRetCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndZero() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();
    transactionRetCapsule.addTransactionInfo(TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, transactionRetCapsule.getData());
  }

  /**
   * Test {@link TransactionRetCapsule#getInstance()}.
   * <p>
   * Method under test: {@link TransactionRetCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionRet TransactionRetCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    TransactionRet actualInstance = (new TransactionRetCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0, actualInstance.getTransactioninfoCount());
    assertEquals(0L, actualInstance.getBlockNumber());
    assertEquals(0L, actualInstance.getBlockTimeStamp());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<TransactionInfo> transactioninfoList = actualInstance.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
    assertSame(transactioninfoList, actualInstance.getTransactioninfoOrBuilderList());
  }
}
