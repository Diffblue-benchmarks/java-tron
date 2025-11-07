package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;

public class TransactionInfoCapsuleDiffblueTest {
  /**
   * Method under test: {@link TransactionInfoCapsule#getPackingFee()}
   */
  @Test
  public void testGetPackingFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getPackingFee());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getFee()}
   */
  @Test
  public void testGetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getFee());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setFee(long)}
   */
  @Test
  public void testSetFee() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setFee(1L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getId()}
   */
  @Test
  public void testGetId() {
    // Arrange, Act and Assert
    assertEquals(0, (new TransactionInfoCapsule()).getId().length);
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setId(byte[])}
   */
  @Test
  public void testSetId() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString id = instance.getId();
    assertEquals("AXAXAXAX", id.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertFalse(id.isEmpty());
    ByteString.ByteIterator iteratorResult = id.iterator();
    assertTrue(iteratorResult.hasNext());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedId, transactionInfoCapsule.getId());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getUnfreezeAmount()}
   */
  @Test
  public void testGetUnfreezeAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getUnfreezeAmount());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setUnfreezeAmount(long)}
   */
  @Test
  public void testSetUnfreezeAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setUnfreezeAmount(10L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getUnfreezeAmount());
    assertEquals(10L, instance.getUnfreezeAmount());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(3, instance.getSerializedSize());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{Byte.MIN_VALUE, 1, '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getWithdrawAmount()}
   */
  @Test
  public void testGetWithdrawAmount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getWithdrawAmount());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setWithdrawAmount(long)}
   */
  @Test
  public void testSetWithdrawAmount() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setWithdrawAmount(10L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getWithdrawAmount());
    assertEquals(10L, instance.getWithdrawAmount());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{'x', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setResMessage(String)}
   */
  @Test
  public void testSetResMessage() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setResMessage("Not all who wander are lost");

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString resMessage = instance.getResMessage();
    assertEquals("Not all who wander are lost", resMessage.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(24, descriptorForType.getFields().size());
    assertEquals(29, instance.getSerializedSize());
    assertFalse(resMessage.isEmpty());
    ByteString.ByteIterator iteratorResult = resMessage.iterator();
    assertTrue(iteratorResult.hasNext());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals('N', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{'R', 27, 'N', 'o', 't', ' ', 'a', 'l', 'l', ' ', 'w', 'h', 'o', ' ', 'w', 'a', 'n',
        'd', 'e', 'r', ' ', 'a', 'r', 'e', ' ', 'l', 'o', 's', 't'}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#addFee(long)}
   */
  @Test
  public void testAddFee() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.addFee(1L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getFee());
    assertEquals(1L, instance.getFee());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{16, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getBlockNumber()}
   */
  @Test
  public void testGetBlockNumber() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getBlockNumber());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setBlockNumber(long)}
   */
  @Test
  public void testSetBlockNumber() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockNumber(1L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, transactionInfoCapsule.getBlockNumber());
    assertEquals(1L, instance.getBlockNumber());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{24, 1}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getBlockTimeStamp()}
   */
  @Test
  public void testGetBlockTimeStamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TransactionInfoCapsule()).getBlockTimeStamp());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setBlockTimeStamp(long)}
   */
  @Test
  public void testSetBlockTimeStamp() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setBlockTimeStamp(10L);

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, transactionInfoCapsule.getBlockTimeStamp());
    assertEquals(10L, instance.getBlockTimeStamp());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertArrayEquals(new byte[]{' ', '\n'}, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setContractResult(byte[])}
   */
  @Test
  public void testSetContractResult() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setContractResult("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<ByteString> contractResultList = instance.getContractResultList();
    assertEquals(1, contractResultList.size());
    ByteString getResult = contractResultList.get(0);
    assertEquals("AXAXAXAX", getResult.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getContractResultCount());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(24, descriptorForType.getFields().size());
    assertFalse(getResult.isEmpty());
    ByteString.ByteIterator iteratorResult = getResult.iterator();
    assertTrue(iteratorResult.hasNext());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getContractResultList().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedData = "*\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#setContractAddress(byte[])}
   */
  @Test
  public void testSetContractAddress() throws UnsupportedEncodingException {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    ByteString contractAddress = instance.getContractAddress();
    assertEquals("AXAXAXAX", contractAddress.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(24, fields.size());
    assertFalse(contractAddress.isEmpty());
    ByteString.ByteIterator iteratorResult = contractAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    Protocol.TransactionInfo defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.getReceipt().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2Amount().isEmpty());
    assertTrue(instance.getCancelUnfreezeV2AmountMap().isEmpty());
    assertTrue(defaultInstanceForType.getCancelUnfreezeV2AmountMap().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    ByteString id = instance.getId();
    assertSame(id, fields.get(0).getDefaultValue());
    assertSame(id, defaultInstanceForType.getContractAddress());
    assertSame(id, defaultInstanceForType.getId());
    assertSame(id, instance.getOrderId());
    assertSame(id, defaultInstanceForType.getOrderId());
    assertSame(id, instance.getResMessage());
    assertSame(id, defaultInstanceForType.getResMessage());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, transactionInfoCapsule.getData());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#addAllLog(List)}
   */
  @Test
  public void testAddAllLog() {
    // Arrange
    TransactionInfoCapsule transactionInfoCapsule = new TransactionInfoCapsule();

    // Act
    transactionInfoCapsule.addAllLog(new ArrayList<>());

    // Assert
    Protocol.TransactionInfo instance = transactionInfoCapsule.getInstance();
    List<Protocol.TransactionInfo.Log> logList = instance.getLogList();
    assertTrue(logList.isEmpty());
    assertSame(logList, instance.getLogOrBuilderList());
  }

  /**
   * Method under test: {@link TransactionInfoCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new TransactionInfoCapsule()).getData().length);
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(Protocol.TransactionInfo)}
   */
  @Test
  public void testNewTransactionInfoCapsule() {
    // Arrange
    Protocol.TransactionInfo trxRet = Protocol.TransactionInfo.getDefaultInstance();

    // Act and Assert
    assertSame(trxRet, (new TransactionInfoCapsule(trxRet)).getInstance());
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule2() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule5() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule6() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule7() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule8() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule9() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("*XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule10() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule11() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("2XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule12() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule(":XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule13() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionInfoCapsule("BXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule14() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link TransactionInfoCapsule#TransactionInfoCapsule(byte[])}
   */
  @Test
  public void testNewTransactionInfoCapsule15() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new TransactionInfoCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }
}
