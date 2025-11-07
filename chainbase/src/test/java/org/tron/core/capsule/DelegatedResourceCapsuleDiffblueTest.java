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
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

public class DelegatedResourceCapsuleDiffblueTest {
  /**
   * Method under test: {@link DelegatedResourceCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).createDbKey().length);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() throws UnsupportedEncodingException {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new DelegatedResourceCapsule(from, resultTo)).createDbKey();

    // Assert
    verify(from).toByteArray();
    verify(resultTo).toByteArray();
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#createDbKey(byte[], byte[])}
   */
  @Test
  public void testCreateDbKey3() throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualCreateDbKeyResult = DelegatedResourceCapsule.createDbKey(from, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new DelegatedResourceCapsule(from, resultTo)).getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 2, '(', 1}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act and Assert
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, -1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 1, ' ', 1, '(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '0', 1}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    delegatedResourceCapsule.addFrozenBalanceForEnergy(Long.MAX_VALUE, 1L);

    // Act and Assert
    assertArrayEquals(new byte[]{' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, '0', 1},
        delegatedResourceCapsule.getData());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    // Act and Assert
    assertSame(delegatedResource, (new DelegatedResourceCapsule(delegatedResource)).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  public void testCreateDbKeyV2() throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{2, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        DelegatedResourceCapsule.createDbKeyV2(from, "AXAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  public void testCreateDbKeyV22() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        DelegatedResourceCapsule.createDbKeyV2(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, false));
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getFrom()}
   */
  @Test
  public void testGetFrom() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    ByteString actualFrom = delegatedResourceCapsule.getFrom();

    // Assert
    assertSame(delegatedResource, delegatedResourceCapsule.getInstance());
    ByteString byteString = actualFrom.EMPTY;
    assertSame(byteString, actualFrom);
    assertSame(byteString, delegatedResourceCapsule.getTo());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getFrom()}
   */
  @Test
  public void testGetFrom2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    ByteString actualFrom = delegatedResourceCapsule.getFrom();

    // Assert
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualFrom.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    Protocol.DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getTo()}
   */
  @Test
  public void testGetTo() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    ByteString actualTo = delegatedResourceCapsule.getTo();

    // Assert
    assertSame(delegatedResource, delegatedResourceCapsule.getInstance());
    ByteString byteString = actualTo.EMPTY;
    assertSame(byteString, delegatedResourceCapsule.getFrom());
    assertSame(byteString, actualTo);
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getTo()}
   */
  @Test
  public void testGetTo2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    ByteString actualTo = delegatedResourceCapsule.getTo();

    // Assert
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualTo.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    Protocol.DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#getFrozenBalanceForEnergy()}
   */
  @Test
  public void testGetFrozenBalanceForEnergy() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getFrozenBalanceForEnergy());
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalanceForEnergy());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForEnergy() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals(' ', data[4]);
    assertEquals('0', data[6]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForEnergy3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForEnergy4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 2, data[1]);
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(' ', data[2]);
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForEnergy() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals(' ', data[4]);
    assertEquals('0', data[6]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForEnergy3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(9L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertEquals(9L, instance.getFrozenBalanceForEnergy());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\t', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForEnergy4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 2, data[1]);
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals(9L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertEquals(9L, instance.getFrozenBalanceForEnergy());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(' ', data[2]);
    assertEquals('\t', data[3]);
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#getFrozenBalanceForBandwidth()}
   */
  @Test
  public void testGetFrozenBalanceForBandwidth() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getFrozenBalanceForBandwidth());
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalanceForBandwidth());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}
   */
  @Test
  public void testGetFrozenBalance() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getFrozenBalance(true));
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getFrozenBalance(false));
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalance(true));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForBandwidth() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 24, data[4]);
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals('(', data[6]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForBandwidth3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testSetFrozenBalanceForBandwidth4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForBandwidth() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 24, data[4]);
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    assertEquals('(', data[6]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForBandwidth3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  public void testAddFrozenBalanceForBandwidth4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(3L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(3L, instance.getFrozenBalanceForBandwidth());
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 3, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#getExpireTimeForBandwidth()}
   */
  @Test
  public void testGetExpireTimeForBandwidth() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getExpireTimeForBandwidth());
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getExpireTimeForBandwidth());
  }

  /**
   * Method under test: {@link DelegatedResourceCapsule#getExpireTimeForEnergy()}
   */
  @Test
  public void testGetExpireTimeForEnergy() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance())).getExpireTimeForEnergy());
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getExpireTimeForEnergy());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  public void testGetExpireTimeForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);

    // Act
    long actualExpireTimeForEnergy = delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  public void testGetExpireTimeForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(0L);

    // Act
    long actualExpireTimeForEnergy = delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  public void testSetExpireTimeForEnergy() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  public void testSetExpireTimeForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('0', data[4]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  public void testSetExpireTimeForEnergy3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(32L, 32L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(' ', data[0]);
    assertEquals(' ', data[1]);
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  public void testSetExpireTimeForEnergy4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(32L, 32L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[7]);
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 2, data[1]);
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(' ', data[3]);
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  public void testSetExpireTimeForBandwidth() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  public void testSetExpireTimeForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 1, data[5]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('(', data[4]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  public void testSetExpireTimeForBandwidth3() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(16L, 16L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(6, instance.getSerializedSize());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', 16, '(', 1, '0', 16}, delegatedResourceCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  public void testSetExpireTimeForBandwidth4() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(delegatedResource);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(16L, 16L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    byte[] data = delegatedResourceCapsule.getData();
    assertEquals((byte) 16, data[3]);
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    Protocol.DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals((byte) 1, data[5]);
    assertEquals((byte) 24, data[0]);
    assertEquals((byte) 2, data[1]);
    assertEquals(4, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(' ', data[2]);
    assertEquals('(', data[4]);
    assertSame(delegatedResource, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(Protocol.DelegatedResource)}
   */
  @Test
  public void testNewDelegatedResourceCapsule() {
    // Arrange
    Protocol.DelegatedResource delegatedResource = Protocol.DelegatedResource.getDefaultInstance();

    // Act and Assert
    assertSame(delegatedResource, (new DelegatedResourceCapsule(delegatedResource)).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule4() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule5() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule9() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule11() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule12() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceCapsule13() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
