package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.tron.protos.Protocol;

public class MarketAccountOrderCapsuleDiffblueTest {
  /**
   * Method under test: {@link MarketAccountOrderCapsule#getOwnerAddress()}
   */
  @Test
  public void testGetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    ByteString actualOwnerAddress = marketAccountOrderCapsule.getOwnerAddress();

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getOwnerAddress());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new MarketAccountOrderCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new MarketAccountOrderCapsule(Protocol.MarketAccountOrder.getDefaultInstance())).createDbKey().length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getOrdersList()}
   */
  @Test
  public void testGetOrdersList() {
    // Arrange, Act and Assert
    assertTrue((new MarketAccountOrderCapsule(mock(ByteString.class))).getOrdersList().isEmpty());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getOrdersCount());
    assertEquals((byte) 18, data[2]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals(45, file.getMessageTypes().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Protocol.MarketAccountOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getOrdersList().isEmpty());
    assertSame(order, ordersList.get(0));
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders2() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(accountOrder);
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getOrdersCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(45, file.getMessageTypes().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(accountOrder, instance.getDefaultInstanceForType());
    assertSame(order, ordersList.get(0));
    assertArrayEquals(new byte[]{18, 0}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getOrdersCount());
    assertEquals((byte) 18, data[2]);
    assertEquals((byte) 24, data[4]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[5]);
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Protocol.MarketAccountOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getOrdersList().isEmpty());
    assertSame(order, ordersList.get(0));
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getOrdersCount());
    assertEquals((byte) 18, data[2]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[5]);
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(45, file.getMessageTypes().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Protocol.MarketAccountOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getOrdersList().isEmpty());
    assertEquals(' ', data[4]);
    assertSame(order, ordersList.get(0));
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders5() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getOrdersCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(45, file.getMessageTypes().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Protocol.MarketAccountOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getOrdersList().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, ordersList.get(0));
    assertArrayEquals(new byte[]{18, 0}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#addOrders(ByteString)}
   */
  @Test
  public void testAddOrders6() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString order = mock(ByteString.class);

    // Act
    marketAccountOrderCapsule.addOrders(order);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    List<ByteString> ordersList = marketAccountOrderCapsule.getOrdersList();
    assertEquals(1, ordersList.size());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getOrdersCount());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    assertEquals((byte) 18, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(4, descriptorForType.getFields().size());
    assertEquals(45, file.getMessageTypes().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(file.getOptions().findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Protocol.MarketAccountOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getOrdersList().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertSame(order, ordersList.get(0));
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) -1, data[10]);
    assertEquals((byte) -1, data[11]);
    assertEquals((byte) -1, data[3]);
    assertEquals((byte) -1, data[4]);
    assertEquals((byte) -1, data[5]);
    assertEquals((byte) -1, data[6]);
    assertEquals((byte) -1, data[7]);
    assertEquals((byte) -1, data[8]);
    assertEquals((byte) -1, data[9]);
    assertEquals(13, instance.getSerializedSize());
    assertEquals(13, data.length);
    assertEquals((byte) 1, data[12]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 24, data[2]);
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder2() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(accountOrder);

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(11, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(accountOrder, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    assertEquals(2L, marketAccountOrderCapsule.getCount());
    assertEquals(2L, instance.getCount());
    assertEquals((byte) 2, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) -1, data[10]);
    assertEquals((byte) -1, data[11]);
    assertEquals((byte) -1, data[3]);
    assertEquals((byte) -1, data[4]);
    assertEquals((byte) -1, data[5]);
    assertEquals((byte) -1, data[6]);
    assertEquals((byte) -1, data[7]);
    assertEquals((byte) -1, data[8]);
    assertEquals((byte) -1, data[9]);
    assertEquals(15, instance.getSerializedSize());
    assertEquals(15, data.length);
    assertEquals((byte) 1, data[12]);
    assertEquals((byte) 24, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[14]);
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
    assertEquals(' ', data[13]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder5() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(11, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#removeOrder(ByteString)}
   */
  @Test
  public void testRemoveOrder6() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.removeOrder(mock(ByteString.class));

    // Assert
    assertEquals(-1L, marketAccountOrderCapsule.getCount());
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(-1L, instance.getCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(27, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    assertTrue(instance.getDefaultInstanceForType().getOrdersList().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount2() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(accountOrder);

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(accountOrder, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals((byte) 3, data[5]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(' ', data[4]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount5() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setCount(long)}
   */
  @Test
  public void testSetCount6() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals(18, data.length);
    assertEquals((byte) 24, data[0]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getCount()}
   */
  @Test
  public void testGetCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketAccountOrderCapsule(mock(ByteString.class))).getCount());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress2() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(accountOrder);

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(accountOrder, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[3]);
    assertEquals((byte) 3, data[5]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(' ', data[4]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress5() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setOwnerAddress(long)}
   */
  @Test
  public void testSetOwnerAddress6() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setOwnerAddress(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals(18, data.length);
    assertEquals((byte) 24, data[0]);
    assertEquals(3L, marketAccountOrderCapsule.getCount());
    assertEquals(3L, instance.getCount());
    assertEquals((byte) 3, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  public void testSetTotalCount() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals(' ', data[2]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  public void testSetTotalCount2() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(accountOrder);

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(accountOrder, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  public void testSetTotalCount3() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(mock(ByteString.class));
    marketAccountOrderCapsule.setCount(3L);

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals((byte) 24, data[2]);
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    assertEquals((byte) 3, data[3]);
    assertEquals((byte) 3, data[5]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(' ', data[4]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  public void testSetTotalCount4() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(new byte[]{});

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{' ', 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#setTotalCount(long)}
   */
  @Test
  public void testSetTotalCount5() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    marketAccountOrderCapsule.setTotalCount(3L);

    // Assert
    Protocol.MarketAccountOrder instance = marketAccountOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = marketAccountOrderCapsule.getData();
    assertEquals(18, data.length);
    assertEquals(3L, marketAccountOrderCapsule.getTotalCount());
    assertEquals(3L, instance.getTotalCount());
    assertEquals((byte) 3, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals(' ', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getTotalCount()}
   */
  @Test
  public void testGetTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketAccountOrderCapsule(mock(ByteString.class))).getTotalCount());
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new MarketAccountOrderCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketAccountOrderCapsule(Protocol.MarketAccountOrder.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(3L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 3}, actualData);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setTotalCount(3L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', 3}, actualData);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(-1L);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.setCount(Long.MAX_VALUE);

    // Act
    byte[] actualData = marketAccountOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Method under test: {@link MarketAccountOrderCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(
        Protocol.MarketAccountOrder.getDefaultInstance());
    marketAccountOrderCapsule.setCount(3L);

    // Act and Assert
    assertArrayEquals(new byte[]{24, 3}, marketAccountOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(Protocol.MarketAccountOrder)}
   */
  @Test
  public void testNewMarketAccountOrderCapsule() {
    // Arrange
    Protocol.MarketAccountOrder accountOrder = Protocol.MarketAccountOrder.getDefaultInstance();

    // Act and Assert
    assertSame(accountOrder, (new MarketAccountOrderCapsule(accountOrder)).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule4() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule5() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule7() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule9() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule10() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketAccountOrderCapsule11() {
    // Arrange, Act and Assert
    assertNull((new MarketAccountOrderCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
