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
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AssetIssueContractOuterClass;

public class ExchangeCapsuleDiffblueTest {
  /**
   * Method under test: {@link ExchangeCapsule#calculateDbKey(long)}
   */
  @Test
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, ExchangeCapsule.calculateDbKey(1L));
  }

  /**
   * Method under test: {@link ExchangeCapsule#getID()}
   */
  @Test
  public void testGetID() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getID());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getID()}
   */
  @Test
  public void testGetID2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L, (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getID());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  public void testSetID() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getID());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  public void testSetID2() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    assertEquals(1L, exchangeCapsule.getID());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  public void testSetID3() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    assertEquals(1L, exchangeCapsule.getID());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getCreatorAddress()}
   */
  @Test
  public void testGetCreatorAddress() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    ByteString actualCreatorAddress = exchangeCapsule.getCreatorAddress();

    // Assert
    assertSame(exchange, exchangeCapsule.getInstance());
    assertSame(actualCreatorAddress.EMPTY, actualCreatorAddress);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getCreatorAddress()}
   */
  @Test
  public void testGetCreatorAddress2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    ByteString actualCreatorAddress = exchangeCapsule.getCreatorAddress();

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualCreatorAddress.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    Protocol.Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  public void testSetExchangeAddress() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    ByteString address = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, instance.getFirstTokenId());
    assertSame(byteString, instance.getSecondTokenId());
    assertSame(address, exchangeCapsule.getCreatorAddress());
    assertSame(address, instance.getCreatorAddress());
    assertArrayEquals(new byte[]{18, 0}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  public void testSetExchangeAddress2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(mock(ByteString.class), 1L, 2L,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString address = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address);

    // Assert
    assertSame(address, exchangeCapsule.getCreatorAddress());
    assertSame(address, exchangeCapsule.getInstance().getCreatorAddress());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  public void testSetExchangeAddress3() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);
    ByteString address = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, instance.getFirstTokenId());
    assertSame(byteString, instance.getSecondTokenId());
    assertSame(address, exchangeCapsule.getCreatorAddress());
    assertSame(address, instance.getCreatorAddress());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  public void testSetExchangeAddress4() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);
    ByteString address = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, instance.getFirstTokenId());
    assertSame(byteString, instance.getSecondTokenId());
    assertSame(address, exchangeCapsule.getCreatorAddress());
    assertSame(address, instance.getCreatorAddress());
    assertArrayEquals(new byte[]{18, 0, '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(mock(ByteString.class), 1L, 16L,
        new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    byte[] data = exchangeCapsule.getData();
    assertEquals((byte) 16, data[27]);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(30, data.length);
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    assertEquals(7, instance.getAllFields().size());
    assertEquals('*', data[17]);
    assertEquals('*', data[29]);
    assertEquals('8', data[Short.SIZE]);
    assertEquals('A', data[26]);
    assertEquals('B', data[18]);
    assertEquals('H', data[28]);
    assertEquals('\b', data[19]);
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance3() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    assertEquals(6, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance4() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    assertEquals(6, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.transaction(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16}, 16L, true);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  public void testSetBalance6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.transaction(new byte[]{}, 16L, true);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(42L, instance.getSecondTokenBalance());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getCreateTime()}
   */
  @Test
  public void testGetCreateTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getCreateTime());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getCreateTime()}
   */
  @Test
  public void testGetCreateTime2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getCreateTime());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, exchangeCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(mock(ByteString.class), 1L, 4L,
        new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4}, new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, exchangeCapsule.getCreateTime());
    assertEquals(10L, exchangeCapsule.getInstance().getCreateTime());
    byte[] data = exchangeCapsule.getData();
    assertEquals(26, data.length);
    assertEquals('\n', data[5]);
  }

  /**
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime3() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, exchangeCapsule.getCreateTime());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, 24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime4() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, exchangeCapsule.getCreateTime());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, 24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  public void testSetCreateTime5() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, exchangeCapsule.getCreateTime());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '\n', '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  public void testGetFirstTokenId() {
    // Arrange, Act and Assert
    assertEquals(0, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getFirstTokenId().length);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  public void testGetFirstTokenId2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualFirstTokenId = (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8")))
        .getFirstTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualFirstTokenId);
  }

  /**
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  public void testSetFirstTokenId() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(0, exchangeCapsule.getSecondTokenId().length);
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(firstTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  public void testSetFirstTokenId2() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(0, exchangeCapsule.getSecondTokenId().length);
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(firstTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
    assertArrayEquals(new byte[]{'\b', 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  public void testSetFirstTokenId3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("", secondTokenId.toStringUtf8());
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(0, exchangeCapsule.getSecondTokenId().length);
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    assertFalse(firstTokenId.isEmpty());
    assertFalse(secondTokenId.iterator().hasNext());
    assertTrue(secondTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(secondTokenId, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(secondTokenId, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    assertEquals(secondTokenId, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertEquals(secondTokenId, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(6).toProto();
    assertEquals(secondTokenId, toProtoResult4.getDefaultValueBytes());
    assertEquals(secondTokenId, toProtoResult.getExtendeeBytes());
    assertEquals(secondTokenId, toProtoResult2.getExtendeeBytes());
    assertEquals(secondTokenId, toProtoResult3.getExtendeeBytes());
    assertEquals(secondTokenId, toProtoResult4.getExtendeeBytes());
    assertEquals(secondTokenId, toProtoResult.getJsonNameBytes());
    assertEquals(secondTokenId, toProtoResult2.getJsonNameBytes());
    assertEquals(secondTokenId, toProtoResult3.getJsonNameBytes());
    assertEquals(secondTokenId, toProtoResult4.getJsonNameBytes());
    assertEquals(secondTokenId, toProtoResult.getTypeNameBytes());
    assertEquals(secondTokenId, toProtoResult2.getTypeNameBytes());
    assertEquals(secondTokenId, toProtoResult3.getTypeNameBytes());
    assertEquals(secondTokenId, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(secondTokenId, defaultInstanceForType.getNameBytes());
    assertEquals(secondTokenId, defaultInstanceForType.getPackageBytes());
    assertEquals(secondTokenId, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(secondTokenId, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(secondTokenId, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(secondTokenId, getResult.getDefaultValue());
    assertSame(secondTokenId, getResult2.getDefaultValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
    assertArrayEquals(new byte[]{18, 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  public void testSetFirstTokenId4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(0, exchangeCapsule.getSecondTokenId().length);
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(firstTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "2\bAXAXAXAX8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  public void testGetSecondTokenId() {
    // Arrange, Act and Assert
    assertEquals(0, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getSecondTokenId().length);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  public void testGetSecondTokenId2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSecondTokenId = (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8")))
        .getSecondTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSecondTokenId);
  }

  /**
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  public void testSetSecondTokenId() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("AXAXAXAX", secondTokenId.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(secondTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = secondTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    byte[] expectedData = "B\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  public void testSetSecondTokenId2() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("AXAXAXAX", secondTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(secondTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = secondTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  public void testSetSecondTokenId3() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("AXAXAXAX", secondTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(secondTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = secondTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{18, 0, 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  public void testSetSecondTokenId4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("AXAXAXAX", secondTokenId.toStringUtf8());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    assertFalse(secondTokenId.isEmpty());
    ByteString.ByteIterator iteratorResult = secondTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*B\bAXAXAXAXH*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getFirstTokenBalance()}
   */
  @Test
  public void testGetFirstTokenBalance() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getFirstTokenBalance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getFirstTokenBalance()}
   */
  @Test
  public void testGetFirstTokenBalance2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getFirstTokenBalance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getSecondTokenBalance()}
   */
  @Test
  public void testGetSecondTokenBalance() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getSecondTokenBalance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getSecondTokenBalance()}
   */
  @Test
  public void testGetSecondTokenBalance2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getSecondTokenBalance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0},
        (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).createDbKey());
  }

  /**
   * Method under test: {@link ExchangeCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1},
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).createDbKey());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    long actualTransactionResult = exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualTransactionResult);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getFirstTokenBalance());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction2() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(mock(ByteString.class), 1L, -1486618624L,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(0L, exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true));
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getSecondTokenBalance());
    byte[] data = exchangeCapsule.getData();
    assertEquals((byte) 1, data[36]);
    assertEquals(37, instance.getSerializedSize());
    assertEquals(37, data.length);
    assertEquals(6, instance.getAllFields().size());
    assertEquals('H', data[35]);
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction3() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    long actualTransactionResult = exchangeCapsule.transaction(new byte[]{}, 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(0L, actualTransactionResult);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getSecondTokenBalance());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(1L, instance.getFirstTokenBalance());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'8', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction4() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);

    // Act
    long actualTransactionResult = exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, false);

    // Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualTransactionResult);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getFirstTokenBalance());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction5() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setID(1L);

    // Act
    long actualTransactionResult = exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualTransactionResult);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getFirstTokenBalance());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1, 'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction6() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setExchangeAddress(mock(ByteString.class));

    // Act
    long actualTransactionResult = exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualTransactionResult);
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getFirstTokenBalance());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{18, 0, 'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  public void testTransaction7() throws UnsupportedEncodingException {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    exchangeCapsule.setBalance(42L, 42L);

    // Act and Assert
    assertEquals(0L, exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true));
    Protocol.Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(42L, instance.getFirstTokenBalance());
    assertEquals(43L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(43L, instance.getSecondTokenBalance());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(7, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(exchange, instance.getDefaultInstanceForType());
    byte[] expectedData = "8*H+".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testResetTokenWithID() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    exchangeCapsule.resetTokenWithID(null, dynamicPropertiesStore);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertEquals(0, exchangeCapsule.getData().length);
    byte[] firstTokenId = exchangeCapsule.getFirstTokenId();
    assertEquals(0, firstTokenId.length);
    assertSame(firstTokenId, exchangeCapsule.getSecondTokenId());
    assertSame(exchange, exchangeCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testResetTokenWithID2() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(exchange);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.get(Mockito.<byte[]>any()))
        .thenReturn(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    exchangeCapsule.resetTokenWithID(assetIssueStore, dynamicPropertiesStore);

    // Assert
    verify(assetIssueStore, atLeast(1)).get(isA(byte[].class));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertEquals(0, exchangeCapsule.getData().length);
    byte[] firstTokenId = exchangeCapsule.getFirstTokenId();
    assertEquals(0, firstTokenId.length);
    assertEquals(exchange, exchangeCapsule.getInstance());
    assertSame(firstTokenId, exchangeCapsule.getSecondTokenId());
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new ExchangeCapsule(Protocol.Exchange.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, -1L, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A',
        -1, 'A', -1, 'B', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 0L, -1L, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A',
        -1, 'B', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1000000000000000000L, -1L,
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', Byte.MIN_VALUE, Byte.MIN_VALUE, -112, -69, -70, -42, -83, -16, '\r', 24, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'B', '\b', 'A', -1, 'A', -1, 'A',
        -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, 0L, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'B', '\b', 'A', -1, 'A', -1,
        'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, -1L, new byte[]{},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(
        new byte[]{'\b', 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 'B', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1},
        actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, -1L, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(
        new byte[]{'\b', 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1},
        actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, -1L,
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    byte[] actualData = exchangeCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', '\b', 'A', -1, 'A', -1, 'A',
        -1, 'A', -1, '8', '*', 'B', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'H', '*'}, actualData);
  }

  /**
   * Method under test: {@link ExchangeCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    // Act and Assert
    assertSame(exchange, (new ExchangeCapsule(exchange)).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(Protocol.Exchange)}
   */
  @Test
  public void testNewExchangeCapsule() {
    // Arrange
    Protocol.Exchange exchange = Protocol.Exchange.getDefaultInstance();

    // Act and Assert
    assertSame(exchange, (new ExchangeCapsule(exchange)).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule4() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule5() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule9() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("BXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule11() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule12() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule13() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule14() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule15() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  public void testNewExchangeCapsule16() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{'B', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
