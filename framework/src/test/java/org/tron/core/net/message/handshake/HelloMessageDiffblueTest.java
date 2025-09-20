package org.tron.core.net.message.handshake;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.UnknownFieldSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.HttpInetSocketAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.net.message.MessageTypes;
import org.tron.p2p.discover.Node;
import org.tron.protos.Discover;
import org.tron.protos.Discover.Endpoint;
import org.tron.protos.Protocol;

public class HelloMessageDiffblueTest {
  /**
   * Test {@link HelloMessage#HelloMessage(byte, byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#HelloMessage(byte, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HelloMessage.<init>(byte, byte[])"})
  public void testNewHelloMessage_whenEmptyArrayOfByte_thenSendDataReturnUnpooledHeapByteBuf()
      throws Exception {
    // Arrange and Act
    HelloMessage actualHelloMessage = new HelloMessage((byte) 'A', new byte[] {});

    // Assert
    assertTrue(actualHelloMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualHelloMessage.getAnswerMessage());
    assertNull(actualHelloMessage.getType());
    assertEquals(0, actualHelloMessage.getNodeType());
    assertEquals(0, actualHelloMessage.getVersion());
    assertEquals(0L, actualHelloMessage.getLowestBlockNum());
    assertEquals(0L, actualHelloMessage.getTimestamp());
    assertFalse(actualHelloMessage.valid());
    assertArrayEquals(new byte[] {}, actualHelloMessage.getData());
    assertArrayEquals(new byte[] {'A'}, actualHelloMessage.getSendBytes());
  }

  /**
   * Test {@link HelloMessage#HelloMessage(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#HelloMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HelloMessage.<init>(byte[])"})
  public void testNewHelloMessage_whenEmptyArrayOfByte_thenSendDataReturnUnpooledHeapByteBuf2()
      throws Exception {
    // Arrange and Act
    HelloMessage actualHelloMessage = new HelloMessage(new byte[] {});

    // Assert
    assertTrue(actualHelloMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualHelloMessage.getAnswerMessage());
    assertEquals(0, actualHelloMessage.getNodeType());
    assertEquals(0, actualHelloMessage.getVersion());
    assertEquals(0L, actualHelloMessage.getLowestBlockNum());
    assertEquals(0L, actualHelloMessage.getTimestamp());
    assertEquals(MessageTypes.P2P_HELLO, actualHelloMessage.getType());
    assertFalse(actualHelloMessage.valid());
    assertArrayEquals(new byte[] {}, actualHelloMessage.getData());
    assertArrayEquals(new byte[] {' '}, actualHelloMessage.getSendBytes());
  }

  /**
   * Test {@link HelloMessage#setHelloMessage(HelloMessage)}.
   *
   * <p>Method under test: {@link HelloMessage#setHelloMessage(Protocol.HelloMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HelloMessage.setHelloMessage(Protocol.HelloMessage)"})
  public void testSetHelloMessage() throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    Protocol.HelloMessage helloMessage2 = mock(Protocol.HelloMessage.class);
    when(helloMessage2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    helloMessage.setHelloMessage(helloMessage2);

    // Assert
    verify(helloMessage2).toByteArray();
    ByteBuf sendData = helloMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = helloMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
    assertEquals(
        "\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", messageId.getByteString().toStringUtf8());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertSame(helloMessage2, helloMessage.getHelloMessage());
    assertSame(helloMessage2, helloMessage.getInstance());
    assertArrayEquals(" AXAXAXAX".getBytes("UTF-8"), helloMessage.getSendBytes());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), helloMessage.getData());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        messageId.getBytes());
  }

  /**
   * Test {@link HelloMessage#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int HelloMessage.getVersion()"})
  public void testGetVersion_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero()
      throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act and Assert
    assertEquals(0, helloMessage.getVersion());
  }

  /**
   * Test {@link HelloMessage#getNodeType()}.
   *
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getNodeType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int HelloMessage.getNodeType()"})
  public void testGetNodeType_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero()
      throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act and Assert
    assertEquals(0, helloMessage.getNodeType());
  }

  /**
   * Test {@link HelloMessage#getLowestBlockNum()}.
   *
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getLowestBlockNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long HelloMessage.getLowestBlockNum()"})
  public void testGetLowestBlockNum_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero()
      throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act and Assert
    assertEquals(0L, helloMessage.getLowestBlockNum());
  }

  /**
   * Test {@link HelloMessage#getTimestamp()}.
   *
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long HelloMessage.getTimestamp()"})
  public void testGetTimestamp_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero()
      throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act and Assert
    assertEquals(0L, helloMessage.getTimestamp());
  }

  /**
   * Test {@link HelloMessage#getFrom()}.
   *
   * <ul>
   *   <li>Then return HexId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getFrom()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node HelloMessage.getFrom()"})
  public void testGetFrom_thenReturnHexIdIsEmptyString() throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act
    Node actualFrom = helloMessage.getFrom();

    // Assert
    assertEquals("", actualFrom.getHexId());
    assertEquals("", actualFrom.getIdString());
    assertEquals("Node{ hostV4='null', hostV6='null', port=0}", actualFrom.format());
    assertNull(actualFrom.getHostV4());
    assertNull(actualFrom.getHostV6());
    assertNull(actualFrom.getInetSocketAddressV4());
    assertNull(actualFrom.getInetSocketAddressV6());
    assertNull(actualFrom.getPreferInetSocketAddress());
    assertEquals(0, actualFrom.getPort());
    assertArrayEquals(new byte[] {}, actualFrom.getId());
  }

  /**
   * Test {@link HelloMessage#valid()}.
   *
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HelloMessage.valid()"})
  public void testValid_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnFalse()
      throws Exception {
    // Arrange
    HelloMessage helloMessage = new HelloMessage(new byte[] {});

    // Act and Assert
    assertFalse(helloMessage.valid());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   *
   * <p>Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode() {
    // Arrange
    InetAddress addr = mock(InetAddress.class);
    when(addr.getHostAddress()).thenReturn("");
    HttpInetSocketAddress address =
        new HttpInetSocketAddress(HttpHost.create("https://example.org/example"), addr, 8080);

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(new Node(address));

    // Assert
    verify(addr).getHostAddress();
    DescriptorProto toProtoResult =
        actualEndpointFromNode.getDescriptorForType().toProto().getDescriptorForType().toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("DescriptorProto", toProtoResult.getName());
    assertEquals(2, actualEndpointFromNode.getAllFields().size());
    assertEquals(69, actualEndpointFromNode.getSerializedSize());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return AddressIpv6 toStringUtf8 is {@code 0.0.0.42}.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_given42_thenReturnAddressIpv6ToStringUtf8Is00042() {
    // Arrange
    HttpHost httphost = HttpHost.create("https://example.org/example");

    InetAddress addr = mock(InetAddress.class);
    when(addr.getHostAddress()).thenReturn("42");

    HttpInetSocketAddress address = new HttpInetSocketAddress(httphost, addr, 8080);

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(new Node(address));

    // Assert
    ByteString addressIpv6 = actualEndpointFromNode.getAddressIpv6();
    ByteIterator iteratorResult = addressIpv6.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    verify(addr).getHostAddress();
    assertEquals("0.0.0.42", addressIpv6.toStringUtf8());
    assertEquals(79, actualEndpointFromNode.getSerializedSize());
    assertTrue(actualHasNextResult);
    assertEquals('.', nextResult2.byteValue());
    assertEquals('0', nextResult.byteValue());
    assertEquals('0', nextResult3.byteValue());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   *
   * <ul>
   *   <li>Given {@code Host V4}.
   *   <li>Then return NodeId toStringUtf8 is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_givenHostV4_thenReturnNodeIdToStringUtf8IsAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange
    Node node = mock(Node.class);
    when(node.getId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(node.getPort()).thenReturn(8080);
    when(node.getHostV4()).thenReturn("Host V4");
    when(node.getHostV6()).thenReturn("Host V6");

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(node);

    // Assert
    verify(node, atLeast(1)).getHostV4();
    verify(node, atLeast(1)).getHostV6();
    verify(node, atLeast(1)).getId();
    verify(node).getPort();
    ByteString nodeId = actualEndpointFromNode.getNodeId();
    assertEquals("AXAXAXAX", nodeId.toStringUtf8());
    assertEquals("Host V4", actualEndpointFromNode.getAddress().toStringUtf8());
    assertEquals("Host V6", actualEndpointFromNode.getAddressIpv6().toStringUtf8());
    assertEquals(31, actualEndpointFromNode.getSerializedSize());
    assertEquals(4, actualEndpointFromNode.getAllFields().size());
    assertTrue(nodeId.iterator().hasNext());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   *
   * <ul>
   *   <li>Then return AddressIpv6 toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_thenReturnAddressIpv6ToStringUtf8IsEmptyString() {
    // Arrange and Act
    Endpoint actualEndpointFromNode =
        HelloMessage.getEndpointFromNode(new Node(new InetSocketAddress(1)));

    // Assert
    ByteString addressIpv6 = actualEndpointFromNode.getAddressIpv6();
    assertEquals("", addressIpv6.toStringUtf8());
    assertEquals("0.0.0.0", actualEndpointFromNode.getAddress().toStringUtf8());
    assertEquals(1, actualEndpointFromNode.getPort());
    assertEquals(77, actualEndpointFromNode.getSerializedSize());
    assertFalse(addressIpv6.iterator().hasNext());
    assertTrue(addressIpv6.isEmpty());
    UnknownFieldSet unknownFields = actualEndpointFromNode.getUnknownFields();
    Endpoint defaultInstanceForType = actualEndpointFromNode.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(addressIpv6, defaultInstanceForType.getAddress());
    assertSame(addressIpv6, defaultInstanceForType.getAddressIpv6());
    assertSame(addressIpv6, defaultInstanceForType.getNodeId());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   *
   * <ul>
   *   <li>Then return NodeId toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_thenReturnNodeIdToStringUtf8IsEmptyString() {
    // Arrange
    Node node = mock(Node.class);
    when(node.getId()).thenReturn(null);
    when(node.getHostV4()).thenReturn("not empty");
    when(node.getHostV6()).thenReturn("not empty");
    when(node.getPort()).thenReturn(8080);

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(node);

    // Assert
    verify(node, atLeast(1)).getHostV4();
    verify(node, atLeast(1)).getHostV6();
    verify(node).getId();
    verify(node).getPort();
    ByteString nodeId = actualEndpointFromNode.getNodeId();
    assertEquals("", nodeId.toStringUtf8());
    ByteString address = actualEndpointFromNode.getAddress();
    assertEquals("not empty", address.toStringUtf8());
    assertEquals(25, actualEndpointFromNode.getSerializedSize());
    assertFalse(nodeId.iterator().hasNext());
    assertTrue(nodeId.isEmpty());
    assertEquals(address, actualEndpointFromNode.getAddressIpv6());
    Endpoint defaultInstanceForType = actualEndpointFromNode.getDefaultInstanceForType();
    assertSame(nodeId, defaultInstanceForType.getAddress());
    assertSame(nodeId, defaultInstanceForType.getAddressIpv6());
    assertSame(nodeId, defaultInstanceForType.getNodeId());
  }
}
