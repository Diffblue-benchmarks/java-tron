package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;

public class TransactionRetCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionRetCapsule#addTransactionInfo(Protocol.TransactionInfo)}
   */
  @Test
  public void testAddTransactionInfo() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule(blockCapsule);

    // Act
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Assert
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
  }

  /**
   * Method under test:
   * {@link TransactionRetCapsule#addTransactionInfo(Protocol.TransactionInfo)}
   */
  @Test
  public void testAddTransactionInfo2() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(0L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule(blockCapsule);

    // Act
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Assert
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
  }

  /**
   * Method under test:
   * {@link TransactionRetCapsule#addTransactionInfo(Protocol.TransactionInfo)}
   */
  @Test
  public void testAddTransactionInfo3() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(0L);
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule(blockCapsule);

    // Act
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Assert
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
  }

  /**
   * Method under test: {@link TransactionRetCapsule#addAllTransactionInfos(List)}
   */
  @Test
  public void testAddAllTransactionInfos() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();

    // Act
    transactionRetCapsule.addAllTransactionInfos(new ArrayList<>());

    // Assert
    Protocol.TransactionRet instance = transactionRetCapsule.getInstance();
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransactionRetCapsule#addAllTransactionInfos(List)}
   */
  @Test
  public void testAddAllTransactionInfos2() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    transactionRetCapsule.addAllTransactionInfos(new ArrayList<>());

    // Assert
    Protocol.TransactionRet instance = transactionRetCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Protocol.TransactionRet defaultInstanceForType = instance.getDefaultInstanceForType();
    List<Protocol.TransactionInfo> transactioninfoList = defaultInstanceForType.getTransactioninfoList();
    assertTrue(transactioninfoList.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(transactioninfoList, defaultInstanceForType2.getEnumTypeList());
    assertSame(transactioninfoList, toProtoResult.getEnumTypeList());
    assertSame(transactioninfoList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getExtensionList());
    assertSame(transactioninfoList, toProtoResult.getExtensionList());
    assertSame(transactioninfoList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getExtensionRangeList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeList());
    assertSame(transactioninfoList, defaultInstanceForType2.getExtensionRangeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getFieldList());
    assertSame(transactioninfoList, defaultInstanceForType2.getFieldOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getNestedTypeList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeList());
    assertSame(transactioninfoList, defaultInstanceForType2.getNestedTypeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getOneofDeclList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclList());
    assertSame(transactioninfoList, defaultInstanceForType2.getOneofDeclOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType2.getReservedRangeList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeList());
    assertSame(transactioninfoList, defaultInstanceForType2.getReservedRangeOrBuilderList());
    assertSame(transactioninfoList, toProtoResult.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options = fields.get(0).getOptions();
    assertSame(transactioninfoList, options.getEditionDefaultsList());
    assertSame(transactioninfoList, options.getEditionDefaultsOrBuilderList());
    assertSame(transactioninfoList, options.getUninterpretedOptionList());
    assertSame(transactioninfoList, options.getUninterpretedOptionOrBuilderList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(transactioninfoList, defaultInstanceForType3.getEnumTypeList());
    assertSame(transactioninfoList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType3.getExtensionList());
    assertSame(transactioninfoList, toProtoResult2.getExtensionList());
    assertSame(transactioninfoList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(transactioninfoList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType3.getMessageTypeList());
    assertSame(transactioninfoList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType3.getServiceList());
    assertSame(transactioninfoList, toProtoResult2.getServiceList());
    assertSame(transactioninfoList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(transactioninfoList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(transactioninfoList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(transactioninfoList, options2.getUninterpretedOptionList());
    assertSame(transactioninfoList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(transactioninfoList, options2.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.MessageOptions options3 = descriptorForType.getOptions();
    assertSame(transactioninfoList, options3.getUninterpretedOptionList());
    assertSame(transactioninfoList, options3.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(transactioninfoList, sourceCodeInfo.getLocationList());
    assertSame(transactioninfoList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(transactioninfoList, defaultInstanceForType.getTransactioninfoOrBuilderList());
  }

  /**
   * Method under test: {@link TransactionRetCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new TransactionRetCapsule()).getData().length);
  }

  /**
   * Method under test: {@link TransactionRetCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    TransactionRetCapsule transactionRetCapsule = new TransactionRetCapsule();
    transactionRetCapsule.addTransactionInfo(Protocol.TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, transactionRetCapsule.getData());
  }

  /**
   * Method under test:
   * {@link TransactionRetCapsule#TransactionRetCapsule(byte[])}
   */
  @Test
  public void testNewTransactionRetCapsule() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("\bXAXAXAX".getBytes("UTF-8")));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("XXAXAXAX".getBytes("UTF-8")));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 16}));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 26}));
    assertThrows(BadItemException.class, () -> new TransactionRetCapsule(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '\b', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 16, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 2, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '\n', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, 24, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, ' ', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(BadItemException.class,
        () -> new TransactionRetCapsule(new byte[]{26, 4, '*', 'X', 'A', 'X', 'A', 'X'}));
  }
}
