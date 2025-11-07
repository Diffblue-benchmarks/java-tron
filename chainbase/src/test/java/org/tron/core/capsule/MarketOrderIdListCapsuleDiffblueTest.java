package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.core.store.MarketPairPriceToOrderStore;
import org.tron.protos.Protocol;

@ContextConfiguration(classes = {MarketOrderIdListCapsule.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MarketOrderIdListCapsuleDiffblueTest {
  @Autowired
  private MarketOrderIdListCapsule marketOrderIdListCapsule;

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#isOrderExists(byte[], MarketOrderStore)}
   */
  @Test
  public void testIsOrderExists() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange, Act and Assert
    assertFalse(marketOrderIdListCapsule.isOrderExists("AXAXAXAX".getBytes("UTF-8"), null));
    assertFalse(marketOrderIdListCapsule.isOrderExists(new byte[]{}, null));
    assertFalse(marketOrderIdListCapsule.isOrderExists("AXAXAXAX".getBytes("UTF-8"), mock(MarketOrderStore.class)));
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#removeOrder(MarketOrderCapsule, MarketOrderStore, byte[], MarketPairPriceToOrderStore)}
   */
  @Test
  public void testRemoveOrder() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule marketOrderCapsule = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule.getID()).thenReturn(byteString);
    doNothing().when(marketOrderCapsule).setPrev(Mockito.<byte[]>any());
    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule marketOrderCapsule2 = mock(MarketOrderCapsule.class);
    when(marketOrderCapsule2.getID()).thenReturn(byteString2);
    doNothing().when(marketOrderCapsule2).setNext(Mockito.<byte[]>any());
    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString3);
    doNothing().when(currentCapsule).setNext(Mockito.<byte[]>any());
    doNothing().when(currentCapsule).setPrev(Mockito.<byte[]>any());
    when(currentCapsule.getPrev()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(currentCapsule.getNext()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(currentCapsule.getNextCapsule(Mockito.<MarketOrderStore>any())).thenReturn(marketOrderCapsule);
    when(currentCapsule.getPrevCapsule(Mockito.<MarketOrderStore>any())).thenReturn(marketOrderCapsule2);
    MarketOrderStore marketOrderStore = mock(MarketOrderStore.class);
    doNothing().when(marketOrderStore).put(Mockito.<byte[]>any(), Mockito.<MarketOrderCapsule>any());

    // Act
    marketOrderIdListCapsule.removeOrder(currentCapsule, marketOrderStore, "AXAXAXAX".getBytes("UTF-8"), null);

    // Assert that nothing has changed
    verify(byteString3).toByteArray();
    verify(byteString).toByteArray();
    verify(byteString2).toByteArray();
    verify(currentCapsule).getID();
    verify(marketOrderCapsule).getID();
    verify(marketOrderCapsule2).getID();
    verify(currentCapsule).getNext();
    verify(currentCapsule).getNextCapsule(isA(MarketOrderStore.class));
    verify(currentCapsule).getPrev();
    verify(currentCapsule).getPrevCapsule(isA(MarketOrderStore.class));
    verify(currentCapsule).setNext(isA(byte[].class));
    verify(marketOrderCapsule2).setNext(isA(byte[].class));
    verify(currentCapsule).setPrev(isA(byte[].class));
    verify(marketOrderCapsule).setPrev(isA(byte[].class));
    verify(marketOrderStore, atLeast(1)).put(Mockito.<byte[]>any(), Mockito.<MarketOrderCapsule>any());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  public void testSetHead() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    assertEquals(0, marketOrderIdListCapsule.getTail().length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  public void testSetHead2() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrderIdList orderIdList = Protocol.MarketOrderIdList.getDefaultInstance();
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(orderIdList);

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("", tail.toStringUtf8());
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    assertEquals(0, marketOrderIdListCapsule.getTail().length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(head.isEmpty());
    assertFalse(tail.iterator().hasNext());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    assertTrue(tail.isEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(tail, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(tail, toProtoResult2.getDefaultValueBytes());
    assertEquals(tail, defaultInstanceForType.getExtendeeBytes());
    assertEquals(tail, toProtoResult.getExtendeeBytes());
    assertEquals(tail, toProtoResult2.getExtendeeBytes());
    assertEquals(tail, defaultInstanceForType.getJsonNameBytes());
    assertEquals(tail, toProtoResult.getJsonNameBytes());
    assertEquals(tail, toProtoResult2.getJsonNameBytes());
    assertEquals(tail, defaultInstanceForType.getNameBytes());
    assertEquals(tail, toProtoResult.getTypeNameBytes());
    assertEquals(tail, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType2.getNameBytes());
    assertEquals(tail, defaultInstanceForType2.getPackageBytes());
    assertEquals(tail, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(tail, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(tail, getResult.getDefaultValue());
    assertSame(tail, getResult2.getDefaultValue());
    assertSame(orderIdList, instance.getDefaultInstanceForType());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setHead(byte[])}
   */
  @Test
  public void testSetHead3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});

    // Act
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("", tail.toStringUtf8());
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    assertEquals(0, marketOrderIdListCapsule.getTail().length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(head.isEmpty());
    assertFalse(tail.iterator().hasNext());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    assertTrue(tail.isEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(tail, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(tail, toProtoResult2.getDefaultValueBytes());
    assertEquals(tail, defaultInstanceForType.getExtendeeBytes());
    assertEquals(tail, toProtoResult.getExtendeeBytes());
    assertEquals(tail, toProtoResult2.getExtendeeBytes());
    assertEquals(tail, defaultInstanceForType.getJsonNameBytes());
    assertEquals(tail, toProtoResult.getJsonNameBytes());
    assertEquals(tail, toProtoResult2.getJsonNameBytes());
    assertEquals(tail, defaultInstanceForType.getNameBytes());
    assertEquals(tail, toProtoResult.getTypeNameBytes());
    assertEquals(tail, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType2.getNameBytes());
    assertEquals(tail, defaultInstanceForType2.getPackageBytes());
    assertEquals(tail, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(tail, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(tail, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(tail, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(tail, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(tail, getResult.getDefaultValue());
    assertSame(tail, getResult2.getDefaultValue());
    Protocol.MarketOrderIdList defaultInstanceForType4 = instance.getDefaultInstanceForType();
    assertSame(tail, defaultInstanceForType4.getHead());
    assertSame(tail, defaultInstanceForType4.getTail());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getHead()}
   */
  @Test
  public void testGetHead() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderIdListCapsule()).getHead().length);
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getHead()}
   */
  @Test
  public void testGetHead2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualHead = marketOrderIdListCapsule.getHead();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualHead);
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getTail()}
   */
  @Test
  public void testGetTail() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderIdListCapsule()).getTail().length);
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getTail()}
   */
  @Test
  public void testGetTail2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualTail = marketOrderIdListCapsule.getTail();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTail);
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  public void testSetTail() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("AXAXAXAX", tail.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(tail.isEmpty());
    ByteString.ByteIterator iteratorResult = tail.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  public void testSetTail2() throws UnsupportedEncodingException {
    // Arrange
    Protocol.MarketOrderIdList orderIdList = Protocol.MarketOrderIdList.getDefaultInstance();
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(orderIdList);

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("AXAXAXAX", tail.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(tail.isEmpty());
    ByteString.ByteIterator iteratorResult = tail.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(orderIdList, instance.getDefaultInstanceForType());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#setTail(byte[])}
   */
  @Test
  public void testSetTail3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule(new byte[]{});

    // Act
    marketOrderIdListCapsule.setTail("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString tail = instance.getTail();
    assertEquals("AXAXAXAX", tail.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertFalse(tail.isEmpty());
    ByteString.ByteIterator iteratorResult = tail.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#isOrderEmpty()}
   */
  @Test
  public void testIsOrderEmpty() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderIdListCapsule()).isOrderEmpty());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#isOrderEmpty()}
   */
  @Test
  public void testIsOrderEmpty2() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}
   */
  @Test
  public void testAddOrder() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString);

    // Act
    marketOrderIdListCapsule.addOrder(currentCapsule, mock(MarketOrderStore.class));

    // Assert
    verify(byteString).toByteArray();
    verify(currentCapsule).getID();
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals(head, instance.getTail());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}
   */
  @Test
  public void testAddOrder2() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString);

    // Act
    marketOrderIdListCapsule.addOrder(currentCapsule, mock(MarketOrderStore.class));

    // Assert
    verify(byteString).toByteArray();
    verify(currentCapsule).getID();
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals(head, instance.getTail());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#addOrder(MarketOrderCapsule, MarketOrderStore)}
   */
  @Test
  public void testAddOrder3() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule currentCapsule = mock(MarketOrderCapsule.class);
    when(currentCapsule.getID()).thenReturn(byteString);

    // Act
    marketOrderIdListCapsule.addOrder(currentCapsule, mock(MarketOrderStore.class));

    // Assert
    verify(byteString).toByteArray();
    verify(currentCapsule).getID();
    Protocol.MarketOrderIdList instance = marketOrderIdListCapsule.getInstance();
    ByteString head = instance.getHead();
    assertEquals("AXAXAXAX", head.toStringUtf8());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertFalse(head.isEmpty());
    assertFalse(marketOrderIdListCapsule.isOrderEmpty());
    ByteString.ByteIterator iteratorResult = head.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertEquals(head, instance.getTail());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedHead = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedHead, marketOrderIdListCapsule.getHead());
    byte[] expectedTail = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTail, marketOrderIdListCapsule.getTail());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X'}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#getHeadOrder(MarketOrderStore)}
   */
  @Test
  public void testGetHeadOrder() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull(marketOrderIdListCapsule.getHeadOrder(null));
    assertNull(marketOrderIdListCapsule.getHeadOrder(mock(MarketOrderStore.class)));
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#getOrderByIndex(int, MarketOrderStore)}
   */
  @Test
  public void testGetOrderByIndex() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull(marketOrderIdListCapsule.getOrderByIndex(1, null));
    assertNull(marketOrderIdListCapsule.getOrderByIndex(1, mock(MarketOrderStore.class)));
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#getOrderSize(MarketOrderStore)}
   */
  @Test
  public void testGetOrderSize() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertEquals(0, marketOrderIdListCapsule.getOrderSize(null));
    assertEquals(0, marketOrderIdListCapsule.getOrderSize(mock(MarketOrderStore.class)));
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new MarketOrderIdListCapsule()).getData().length);
    assertEquals(0, (new MarketOrderIdListCapsule(Protocol.MarketOrderIdList.getDefaultInstance())).getData().length);
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new MarketOrderIdListCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new MarketOrderIdListCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'})).getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setHead(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    MarketOrderIdListCapsule marketOrderIdListCapsule = new MarketOrderIdListCapsule();
    marketOrderIdListCapsule.setTail(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{18, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, marketOrderIdListCapsule.getData());
  }

  /**
   * Method under test: {@link MarketOrderIdListCapsule#getData()}
   */
  @Test
  public void testGetData4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new MarketOrderIdListCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#getAllOrder(MarketOrderStore, long)}
   */
  @Test
  public void testGetAllOrder() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertTrue(marketOrderIdListCapsule.getAllOrder(mock(MarketOrderStore.class), 1L).isEmpty());
    assertTrue(marketOrderIdListCapsule.getAllOrder(mock(MarketOrderStore.class), 1L).isEmpty());
    assertTrue(marketOrderIdListCapsule.getAllOrder(mock(MarketOrderStore.class), 1L).isEmpty());
    assertTrue(marketOrderIdListCapsule.getAllOrder(mock(MarketOrderStore.class), 1L).isEmpty());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(Protocol.MarketOrderIdList)}
   */
  @Test
  public void testNewMarketOrderIdListCapsule() {
    // Arrange
    Protocol.MarketOrderIdList orderIdList = Protocol.MarketOrderIdList.getDefaultInstance();

    // Act and Assert
    assertSame(orderIdList, (new MarketOrderIdListCapsule(orderIdList)).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule4() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule5() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule7() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule8() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link MarketOrderIdListCapsule#MarketOrderIdListCapsule(byte[])}
   */
  @Test
  public void testNewMarketOrderIdListCapsule9() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderIdListCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
