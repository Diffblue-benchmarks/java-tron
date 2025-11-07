package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.mockito.Mockito;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.MarketContract;

public class MarketOrderCapsuleDiffblueTest {
  /**
   * Method under test: {@link MarketOrderCapsule#getID()}
   */
  @Test
  public void testGetID() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    ByteString actualID = marketOrderCapsule.getID();

    // Assert
    assertSame(order, marketOrderCapsule.getInstance());
    ByteString byteString = actualID.EMPTY;
    assertSame(byteString, actualID);
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getID()}
   */
  @Test
  public void testGetID2() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    ByteString actualID = marketOrderCapsule.getID();

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(12, fields.size());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = actualID.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        MarketContract.MarketSellAssetContract.getDefaultInstance());
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals("", instance.getDescriptorForType().getFile().toProto().getDefaultInstanceForType().getName());
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(1L);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(1L);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(1L);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("A\u0001A\u0001A\u0001A\u0001", buyTokenId.toStringUtf8());
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    assertTrue(buyTokenId.iterator().hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  public void testSetID10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = id.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(id, marketOrderCapsule.getID());
    assertSame(id, instance.getOrderId());
    assertArrayEquals(new byte[]{'\n', 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getOwnerAddress()}
   */
  @Test
  public void testGetOwnerAddress() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    ByteString actualOwnerAddress = marketOrderCapsule.getOwnerAddress();

    // Assert
    assertSame(order, marketOrderCapsule.getInstance());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertSame(byteString, marketOrderCapsule.getID());
    assertSame(byteString, actualOwnerAddress);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getOwnerAddress()}
   */
  @Test
  public void testGetOwnerAddress2() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    ByteString actualOwnerAddress = marketOrderCapsule.getOwnerAddress();

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(11);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(order, instance.getDefaultInstanceForType());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, actualOwnerAddress);
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
        MarketContract.MarketSellAssetContract.getDefaultInstance());
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[11]);
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(12, fields.size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[10]);
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    Protocol.MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 2, data[11]);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0, '(', 2}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0, 'H', 2}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0, 'P', 2}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("A\u0002A\u0002A\u0002A\u0002", buyTokenId.toStringUtf8());
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 2, data[11]);
    assertFalse(buyTokenId.isEmpty());
    assertTrue(buyTokenId.iterator().hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  public void testSetOwnerAddress10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(10).getDefaultValue());
    assertSame(byteString, fields.get(11).getDefaultValue());
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(address, marketOrderCapsule.getOwnerAddress());
    assertSame(address, instance.getOwnerAddress());
    assertArrayEquals(new byte[]{18, 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getCreateTime()}
   */
  @Test
  public void testGetCreateTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getCreateTime());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getCreateTime()}
   */
  @Test
  public void testGetCreateTime2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getCreateTime());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 24, data[10]);
    assertEquals('\n', data[11]);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 4, data[11]);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', '(', 4}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', 'H', 4}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', 'P', 4}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 4, data[11]);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(10L, marketOrderCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  public void testGetSellTokenId() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getSellTokenId().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  public void testGetSellTokenId2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, marketOrderCapsule.getSellTokenId().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  public void testGetSellTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSellTokenId = marketOrderCapsule.getSellTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSellTokenId);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(12, descriptorForType.getFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId2() throws UnsupportedEncodingException {
    // Arrange
    byte[] id = "A\bA\bA\bA\b".getBytes("UTF-8");
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(id,
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(20, data.length);
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('A', data[12]);
    assertEquals('A', data[14]);
    assertEquals('A', data[18]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('X', data[13]);
    assertEquals('X', data[15]);
    assertEquals('X', data[17]);
    assertEquals('X', data[19]);
    assertEquals('"', data[10]);
    assertEquals('\b', data[11]);
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{'\n', 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{24, '\n', '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX(\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXH\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId8() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXP\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId9() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX2\bA\bA\bA\bA\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  public void testSetSellTokenId10() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(sellTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantity()}
   */
  @Test
  public void testGetSellTokenQuantity() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getSellTokenQuantity());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantity()}
   */
  @Test
  public void testGetSellTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantity());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals('(', data[10]);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[3]);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('(', data[10]);
    assertEquals('A', data[2]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(16L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1, 'H', 16}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(16L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1, 'P', 16}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[11]);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals((byte) 1, data[1]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('(', data[0]);
    assertEquals('2', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  public void testSetSellTokenQuantity10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityRemain()}
   */
  @Test
  public void testGetSellTokenQuantityRemain() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getSellTokenQuantityRemain());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityRemain()}
   */
  @Test
  public void testGetSellTokenQuantityRemain2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityRemain());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(
        new byte[]{'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals('H', data[10]);
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule
        .setSellTokenId(new byte[]{'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE});

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[3]);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('H', data[10]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(128L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 1, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(128L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', 1, 'P', Byte.MIN_VALUE, 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule
        .setBuyTokenId(new byte[]{'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE, 'A', Byte.MIN_VALUE});

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[3]);
    assertEquals('2', data[0]);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('H', data[10]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  public void testSetSellTokenQuantityRemain10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(1L, instance.getSellTokenQuantityRemain());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', '*', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityReturn()}
   */
  @Test
  public void testGetSellTokenQuantityReturn() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getSellTokenQuantityReturn());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityReturn()}
   */
  @Test
  public void testGetSellTokenQuantityReturn2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0, marketOrderCapsule.getData().length);
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(order, marketOrderCapsule.getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn2() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, marketOrderCapsule.getData().length);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, marketOrderCapsule.getData().length);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, marketOrderCapsule.getData().length);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) -1, data[3]);
    assertEquals((byte) -1, data[5]);
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10, data.length);
    assertEquals('A', data[4]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertEquals(3, marketOrderCapsule.getData().length);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(256L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(256L, instance.getSellTokenQuantityReturn());
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) 2, data[5]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(Byte.MIN_VALUE, data[4]);
    assertEquals('P', data[3]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) -1, data[3]);
    assertEquals((byte) -1, data[5]);
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10, data.length);
    assertEquals('A', data[4]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  public void testSetSellTokenQuantityReturn9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, marketOrderCapsule.getData().length);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn11() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals('P', data[10]);
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn12() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn13() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn14() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn15() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) -1, data[3]);
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('P', data[10]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn16() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn17() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn18() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    byte[] data = marketOrderCapsule.getData();
    assertEquals((byte) -1, data[3]);
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[0]);
    assertEquals('A', data[2]);
    assertEquals('A', data[4]);
    assertEquals('P', data[10]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  public void testSetSellTokenQuantityReturn19() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(1L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(1L, instance.getSellTokenQuantityReturn());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', '*', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  public void testGetBuyTokenId() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getBuyTokenId().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  public void testGetBuyTokenId2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, marketOrderCapsule.getBuyTokenId().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  public void testGetBuyTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualBuyTokenId = marketOrderCapsule.getBuyTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBuyTokenId);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(12, descriptorForType.getFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId2() throws UnsupportedEncodingException {
    // Arrange
    byte[] id = "A A A A ".getBytes("UTF-8");
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(id,
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(20, data.length);
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('2', data[10]);
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('A', data[12]);
    assertEquals('A', data[14]);
    assertEquals('A', data[18]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('X', data[13]);
    assertEquals('X', data[15]);
    assertEquals('X', data[17]);
    assertEquals('X', data[19]);
    assertEquals('\b', data[11]);
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{'\n', 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{18, 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId("A A A A ".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(8, marketOrderCapsule.getSellTokenId().length);
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    byte[] expectedData = "\"\bA A A A 2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "( 2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId8() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAXH ".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId9() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAXP ".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  public void testSetBuyTokenId10() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("AXAXAXAX", buyTokenId.toStringUtf8());
    byte[] next = marketOrderCapsule.getNext();
    assertEquals(0, next.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(buyTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = buyTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(next, marketOrderCapsule.getPrev());
    assertSame(next, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getBuyTokenQuantity()}
   */
  @Test
  public void testGetBuyTokenQuantity() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getBuyTokenQuantity());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getBuyTokenQuantity()}
   */
  @Test
  public void testGetBuyTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getBuyTokenQuantity());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity2() throws UnsupportedEncodingException {
    // Arrange
    byte[] id = "A@A@A@A@".getBytes("UTF-8");
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(id,
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    assertEquals('*', data[11]);
    assertEquals('8', data[10]);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId("A@A@A@A@".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[11]);
    assertEquals('8', data[10]);
    assertEquals('@', data[3]);
    assertEquals('A', data[2]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "(@8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity8() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*H@".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity9() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*P@".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  public void testSetBuyTokenQuantity10() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId("A@A@A@A@".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(42L, marketOrderCapsule.getBuyTokenQuantity());
    assertEquals(42L, instance.getBuyTokenQuantity());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[11]);
    assertEquals('2', data[0]);
    assertEquals('8', data[10]);
    assertEquals('@', data[3]);
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertSame(order, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  public void testGetSt() {
    // Arrange, Act and Assert
    assertEquals(Protocol.MarketOrder.State.ACTIVE,
        (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getSt());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  public void testGetSt2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(Protocol.MarketOrder.State.ACTIVE, marketOrderCapsule.getSt());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertEquals(order, marketOrderCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState2() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState3() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState4() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState5() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState6() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(512L);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState7() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(512L);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState8() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(512L);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState9() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#setState(Protocol.MarketOrder.State)}
   */
  @Test
  public void testSetState10() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setState(Protocol.MarketOrder.State.ACTIVE);

    // Assert
    assertSame(order, marketOrderCapsule.getInstance().getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).isActive());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  public void testIsActive2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertTrue(marketOrderCapsule.isActive());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  public void testGetNext() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getNext().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  public void testGetNext2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, marketOrderCapsule.getNext().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  public void testGetNext3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNext = marketOrderCapsule.getNext();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNext);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(12, descriptorForType.getFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    byte[] expectedData = "j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(20, data.length);
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('A', data[12]);
    assertEquals('A', data[14]);
    assertEquals('A', data[18]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('X', data[13]);
    assertEquals('X', data[15]);
    assertEquals('X', data[17]);
    assertEquals('X', data[19]);
    assertEquals('\b', data[11]);
    assertEquals('j', data[10]);
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'\n', 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{18, 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{24, '\n', 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(8, marketOrderCapsule.getSellTokenId().length);
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext8() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext9() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'P', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext10() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    byte[] prev = marketOrderCapsule.getPrev();
    assertEquals(0, prev.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(prev, marketOrderCapsule.getSellTokenId());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[]{'2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  public void testSetNext11() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertFalse(marketOrderCapsule.isNextNull());
    ByteString.ByteIterator iteratorResult = next.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  public void testGetPrev() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getPrev().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  public void testGetPrev2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, marketOrderCapsule.getPrev().length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  public void testGetPrev3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPrev = marketOrderCapsule.getPrev();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPrev);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(12, descriptorForType.getFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    byte[] expectedData = "b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        MarketContract.MarketSellAssetContract.getDefaultInstance());

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] data = marketOrderCapsule.getData();
    assertEquals(20, data.length);
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('A', data[12]);
    assertEquals('A', data[14]);
    assertEquals('A', data[18]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('X', data[13]);
    assertEquals('X', data[15]);
    assertEquals('X', data[17]);
    assertEquals('X', data[19]);
    assertEquals('\b', data[11]);
    assertEquals('b', data[10]);
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'\n', 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{18, 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{24, '\n', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantity(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev8() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityRemain(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev9() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setSellTokenQuantityReturn(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'P', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev10() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[]{'2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  public void testSetPrev11() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(order);
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(prev.isEmpty());
    assertFalse(marketOrderCapsule.isPreNull());
    ByteString.ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(order, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  public void testIsPreNull() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).isPreNull());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  public void testIsPreNull2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertTrue(marketOrderCapsule.isPreNull());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  public void testIsPreNull3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setPrev(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertFalse(marketOrderCapsule.isPreNull());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  public void testIsNextNull() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).isNextNull());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  public void testIsNextNull2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act and Assert
    assertTrue(marketOrderCapsule.isNextNull());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  public void testIsNextNull3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setNext(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertFalse(marketOrderCapsule.isNextNull());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}
   */
  @Test
  public void testGetPrevCapsule() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getPrevCapsule(null));
    assertNull((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance()))
        .getPrevCapsule(mock(MarketOrderStore.class)));
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}
   */
  @Test
  public void testGetPrevCapsule2() throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setPrev(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    MarketOrderCapsule marketOrderCapsule2 = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    when(orderStore.get(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule2);

    // Act
    MarketOrderCapsule actualPrevCapsule = marketOrderCapsule.getPrevCapsule(orderStore);

    // Assert
    verify(orderStore).get(isA(byte[].class));
    assertSame(marketOrderCapsule2, actualPrevCapsule);
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}
   */
  @Test
  public void testGetNextCapsule() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getNextCapsule(null));
    assertNull((new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance()))
        .getNextCapsule(mock(MarketOrderStore.class)));
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}
   */
  @Test
  public void testGetNextCapsule2() throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setNext(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    MarketOrderCapsule marketOrderCapsule2 = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    when(orderStore.get(Mockito.<byte[]>any())).thenReturn(marketOrderCapsule2);

    // Act
    MarketOrderCapsule actualNextCapsule = marketOrderCapsule.getNextCapsule(orderStore);

    // Assert
    verify(orderStore).get(isA(byte[].class));
    assertSame(marketOrderCapsule2, actualNextCapsule);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance())).getData().length);
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1},
        (new MarketOrderCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
            MarketContract.MarketSellAssetContract.getDefaultInstance())).getData());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(id, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setCreateTime(10L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, '\n'}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setSellTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setSellTokenQuantity(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setSellTokenQuantityRemain(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'H', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setSellTokenQuantityReturn(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'P', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setBuyTokenId(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setBuyTokenQuantity(42L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'8', '*'}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setNext(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'j', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData12() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setPrev(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'b', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  public void testGetData13() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(Protocol.MarketOrder.getDefaultInstance());
    marketOrderCapsule.setCreateTime(Long.MAX_VALUE);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Method under test: {@link MarketOrderCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    // Act and Assert
    assertSame(order, (new MarketOrderCapsule(order)).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderCapsule#MarketOrderCapsule(Protocol.MarketOrder)}
   */
  @Test
  public void testNewMarketOrderCapsule() {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();

    // Act and Assert
    assertSame(order, (new MarketOrderCapsule(order)).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule4() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule5() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule9() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule11() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule13() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule14() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule15() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("PXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule16() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule17() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule18() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderCapsule19() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
