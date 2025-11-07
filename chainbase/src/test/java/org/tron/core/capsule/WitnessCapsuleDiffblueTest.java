package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

public class WitnessCapsuleDiffblueTest {
  /**
   * Method under test: {@link WitnessCapsule#compareTo(WitnessCapsule)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, witnessCapsule.compareTo(new WitnessCapsule(mock(ByteString.class))));
  }

  /**
   * Method under test: {@link WitnessCapsule#getAddress()}
   */
  @Test
  public void testGetAddress() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    ByteString actualAddress = witnessCapsule.getAddress();

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    ByteString byteString = actualAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, instance.getPubKey());
    assertSame(byteString, defaultInstanceForType.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new WitnessCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() {
    // Arrange, Act and Assert
    assertEquals(0, (new WitnessCapsule(Protocol.Witness.getDefaultInstance())).createDbKey().length);
  }

  /**
   * Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new WitnessCapsule(address)).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString2() {
    // Arrange, Act and Assert
    assertEquals("", (new WitnessCapsule(Protocol.Witness.getDefaultInstance())).createReadableString());
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new WitnessCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange, Act and Assert
    assertEquals(0, (new WitnessCapsule(Protocol.Witness.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(Protocol.Witness.getDefaultInstance());
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(pubKey, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setVoteCount(3L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{16, 3}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setTotalProduced(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setTotalMissed(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'0', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setLatestBlockNum(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'8', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setLatestSlotNum(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'@', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setIsJobs(true);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'H', 1}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setUrl("https://example.org/example");
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData12() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setVoteCount(Long.MAX_VALUE);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  public void testGetData13() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setUrl("https://example.org/examplehttps://example.org/example");
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals("\"6https://example.org/examplehttps://example.org/example".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertSame(pubKey, instance.getPubKey());
    assertArrayEquals(new byte[]{26, 0}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 26, data[4]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('(', data[4]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('0', data[4]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('8', data[4]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('@', data[4]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('H', data[4]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 27, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    assertEquals('.', data[21]);
    assertEquals('/', data[12]);
    assertEquals('/', data[13]);
    assertEquals('/', data[25]);
    assertEquals(':', data[11]);
    assertEquals('"', data[4]);
    assertEquals('a', data[28]);
    assertEquals('a', data[Short.SIZE]);
    assertEquals('e', data[14]);
    assertEquals('e', data[20]);
    assertEquals('e', data[26]);
    assertEquals('e', data[Integer.SIZE]);
    assertEquals('g', data[24]);
    assertEquals('h', data[6]);
    assertEquals('l', data[19]);
    assertEquals('l', data[31]);
    assertEquals('m', data[17]);
    assertEquals('m', data[29]);
    assertEquals('o', data[22]);
    assertEquals('p', data[18]);
    assertEquals('p', data[30]);
    assertEquals('p', data[9]);
    assertEquals('r', data[23]);
    assertEquals('s', data[10]);
    assertEquals('t', data[7]);
    assertEquals('t', data[8]);
    assertEquals('x', data[15]);
    assertEquals('x', data[27]);
    ByteString byteString = pubKey.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Protocol.Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(pubKey, instance.getPubKey());
    assertArrayEquals(new byte[]{26, 0}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  public void testSetPubKey11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    assertEquals((byte) 26, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertSame(pubKey, instance.getPubKey());
  }

  /**
   * Method under test: {@link WitnessCapsule#getVoteCount()}
   */
  @Test
  public void testGetVoteCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getVoteCount());
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{16, 3}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 26, data[4]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 27, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[3]);
    assertEquals('.', data[21]);
    assertEquals('/', data[12]);
    assertEquals('/', data[13]);
    assertEquals('/', data[25]);
    assertEquals(':', data[11]);
    assertEquals('"', data[4]);
    assertEquals('a', data[28]);
    assertEquals('a', data[Short.SIZE]);
    assertEquals('e', data[14]);
    assertEquals('e', data[20]);
    assertEquals('e', data[26]);
    assertEquals('e', data[Integer.SIZE]);
    assertEquals('g', data[24]);
    assertEquals('h', data[6]);
    assertEquals('l', data[19]);
    assertEquals('l', data[31]);
    assertEquals('m', data[17]);
    assertEquals('m', data[29]);
    assertEquals('o', data[22]);
    assertEquals('p', data[18]);
    assertEquals('p', data[30]);
    assertEquals('p', data[9]);
    assertEquals('r', data[23]);
    assertEquals('s', data[10]);
    assertEquals('t', data[7]);
    assertEquals('t', data[8]);
    assertEquals('x', data[15]);
    assertEquals('x', data[27]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{16, 3}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  public void testSetVoteCount11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[0]);
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals((byte) 3, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getTotalProduced()}
   */
  @Test
  public void testGetTotalProduced() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getTotalProduced());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals('(', data[2]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getTotalProduced());
    assertEquals(1L, instance.getTotalProduced());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals('(', data[31]);
    assertEquals('"', data[2]);
    assertEquals('h', data[4]);
    assertEquals('t', data[5]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getTotalProduced());
    assertEquals(1L, instance.getTotalProduced());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'(', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  public void testSetTotalProduced11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = witnessCapsule.getData();
    assertEquals(18, data.length);
    assertEquals(1L, witnessCapsule.getTotalProduced());
    assertEquals(1L, instance.getTotalProduced());
    assertEquals((byte) 1, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('(', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getTotalMissed()}
   */
  @Test
  public void testGetTotalMissed() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getTotalMissed());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals('0', data[2]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getTotalMissed());
    assertEquals(1L, instance.getTotalMissed());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'0', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[2]);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals('0', data[31]);
    assertEquals('"', data[2]);
    assertEquals('h', data[4]);
    assertEquals('t', data[5]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getTotalMissed());
    assertEquals(1L, instance.getTotalMissed());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'0', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  public void testSetTotalMissed11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = witnessCapsule.getData();
    assertEquals(18, data.length);
    assertEquals(1L, witnessCapsule.getTotalMissed());
    assertEquals(1L, instance.getTotalMissed());
    assertEquals((byte) 1, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('0', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getLatestBlockNum()}
   */
  @Test
  public void testGetLatestBlockNum() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getLatestBlockNum());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals('8', data[2]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[2]);
    assertEquals('8', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals('8', data[31]);
    assertEquals('"', data[2]);
    assertEquals('h', data[4]);
    assertEquals('t', data[5]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'8', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  public void testSetLatestBlockNum11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = witnessCapsule.getData();
    assertEquals(18, data.length);
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals((byte) 1, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('8', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getLatestSlotNum()}
   */
  @Test
  public void testGetLatestSlotNum() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getLatestSlotNum());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals('@', data[2]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'@', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('8', data[2]);
    assertEquals('@', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('@', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals('@', data[31]);
    assertEquals('"', data[2]);
    assertEquals('h', data[4]);
    assertEquals('t', data[5]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'@', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  public void testSetLatestSlotNum11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = witnessCapsule.getData();
    assertEquals(18, data.length);
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals((byte) 1, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('@', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getIsJobs()}
   */
  @Test
  public void testGetIsJobs() {
    // Arrange, Act and Assert
    assertFalse((new WitnessCapsule(mock(ByteString.class))).getIsJobs());
  }

  /**
   * Method under test: {@link WitnessCapsule#getIsJobs()}
   */
  @Test
  public void testGetIsJobs2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act and Assert
    assertTrue(witnessCapsule.getIsJobs());
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('H', data[2]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 26, data[2]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals((byte) 3, data[3]);
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('(', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('0', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('8', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[5]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('@', data[2]);
    assertEquals('H', data[4]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals('H', data[31]);
    assertEquals('"', data[2]);
    assertEquals('h', data[4]);
    assertEquals('t', data[5]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertArrayEquals(new byte[]{'H', 1}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  public void testSetIsJobs11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = witnessCapsule.getData();
    assertEquals(18, data.length);
    assertEquals((byte) 1, data[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('H', data[0]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
  }

  /**
   * Method under test: {@link WitnessCapsule#getUrl()}
   */
  @Test
  public void testGetUrl() {
    // Arrange, Act and Assert
    assertEquals("", (new WitnessCapsule(mock(ByteString.class))).getUrl());
    assertEquals("", (new WitnessCapsule(Protocol.Witness.getDefaultInstance())).getUrl());
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    assertEquals(2, instance.getAllFields().size());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 27, data[3]);
    assertEquals(31, instance.getSerializedSize());
    assertEquals(31, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals(':', data[9]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl2() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();
    WitnessCapsule witnessCapsule = new WitnessCapsule(witness);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(29, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertSame(witness, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 27, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[21]);
    assertEquals('/', data[12]);
    assertEquals('/', data[13]);
    assertEquals('/', data[25]);
    assertEquals(':', data[11]);
    assertEquals('"', data[4]);
    assertEquals('a', data[28]);
    assertEquals('a', data[Short.SIZE]);
    assertEquals('e', data[14]);
    assertEquals('e', data[20]);
    assertEquals('e', data[26]);
    assertEquals('e', data[Integer.SIZE]);
    assertEquals('g', data[24]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[6]);
    assertEquals('l', data[19]);
    assertEquals('l', data[31]);
    assertEquals('m', data[17]);
    assertEquals('m', data[29]);
    assertEquals('o', data[22]);
    assertEquals('p', data[18]);
    assertEquals('p', data[30]);
    assertEquals('p', data[9]);
    assertEquals('r', data[23]);
    assertEquals('s', data[10]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[7]);
    assertEquals('t', data[8]);
    assertEquals('x', data[15]);
    assertEquals('x', data[27]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals((byte) 27, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals((byte) 3, data[3]);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[21]);
    assertEquals('/', data[12]);
    assertEquals('/', data[13]);
    assertEquals('/', data[25]);
    assertEquals(':', data[11]);
    assertEquals('"', data[4]);
    assertEquals('a', data[28]);
    assertEquals('a', data[Short.SIZE]);
    assertEquals('e', data[14]);
    assertEquals('e', data[20]);
    assertEquals('e', data[26]);
    assertEquals('e', data[Integer.SIZE]);
    assertEquals('g', data[24]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[6]);
    assertEquals('l', data[19]);
    assertEquals('l', data[31]);
    assertEquals('m', data[17]);
    assertEquals('m', data[29]);
    assertEquals('o', data[22]);
    assertEquals('p', data[18]);
    assertEquals('p', data[30]);
    assertEquals('p', data[9]);
    assertEquals('r', data[23]);
    assertEquals('s', data[10]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[7]);
    assertEquals('t', data[8]);
    assertEquals('x', data[15]);
    assertEquals('x', data[27]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('(', data[31]);
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals(':', data[9]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals('0', data[31]);
    assertEquals(':', data[9]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals('8', data[31]);
    assertEquals(':', data[9]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl8() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals(':', data[9]);
    assertEquals('@', data[31]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl9() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    byte[] data = witnessCapsule.getData();
    assertEquals((byte) 1, data[Integer.SIZE]);
    assertEquals((byte) 27, data[3]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(33, data.length);
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('.', data[19]);
    assertEquals('/', data[10]);
    assertEquals('/', data[11]);
    assertEquals('/', data[23]);
    assertEquals(':', data[9]);
    assertEquals('H', data[31]);
    assertEquals('"', data[2]);
    assertEquals('a', data[14]);
    assertEquals('a', data[26]);
    assertEquals('e', data[12]);
    assertEquals('e', data[18]);
    assertEquals('e', data[24]);
    assertEquals('e', data[30]);
    assertEquals('g', data[22]);
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('h', data[4]);
    assertEquals('l', data[17]);
    assertEquals('l', data[29]);
    assertEquals('m', data[15]);
    assertEquals('m', data[27]);
    assertEquals('o', data[20]);
    assertEquals('p', data[28]);
    assertEquals('p', data[7]);
    assertEquals('p', data[Short.SIZE]);
    assertEquals('r', data[21]);
    assertEquals('s', data[8]);
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', data[5]);
    assertEquals('t', data[6]);
    assertEquals('x', data[13]);
    assertEquals('x', data[25]);
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl10() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(29, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  public void testSetUrl11() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Protocol.Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(45, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(9, descriptorForType.getFields().size());
    assertFalse(urlBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, witnessCapsule.getData());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(Protocol.Witness)}
   */
  @Test
  public void testNewWitnessCapsule() {
    // Arrange
    Protocol.Witness witness = Protocol.Witness.getDefaultInstance();

    // Act and Assert
    assertSame(witness, (new WitnessCapsule(witness)).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule4() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule5() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule9() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule11() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule13() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("@XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule14() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule15() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule16() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  public void testNewWitnessCapsule17() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
