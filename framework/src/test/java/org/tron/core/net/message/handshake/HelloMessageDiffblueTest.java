package org.tron.core.net.message.handshake;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.HttpInetSocketAddress;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.net.message.MessageTypes;
import org.tron.p2p.discover.Node;
import org.tron.protos.Discover;
import org.tron.protos.Discover.Endpoint;

public class HelloMessageDiffblueTest {
  /**
   * Test {@link HelloMessage#HelloMessage(byte, byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#HelloMessage(byte, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HelloMessage.<init>(byte, byte[])"})
  public void testNewHelloMessage_whenEmptyArrayOfByte_thenSendDataReturnUnpooledHeapByteBuf() throws Exception {
    // Arrange and Act
    HelloMessage actualHelloMessage = new HelloMessage((byte) 'A', new byte[]{});

    // Assert
    assertTrue(actualHelloMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualHelloMessage.getAnswerMessage());
    assertNull(actualHelloMessage.getType());
    assertEquals(0, actualHelloMessage.getNodeType());
    assertEquals(0, actualHelloMessage.getVersion());
    assertEquals(0L, actualHelloMessage.getLowestBlockNum());
    assertEquals(0L, actualHelloMessage.getTimestamp());
    assertFalse(actualHelloMessage.valid());
    assertArrayEquals(new byte[]{}, actualHelloMessage.getData());
    assertArrayEquals(new byte[]{'A'}, actualHelloMessage.getSendBytes());
  }

  /**
   * Test {@link HelloMessage#HelloMessage(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#HelloMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HelloMessage.<init>(byte[])"})
  public void testNewHelloMessage_whenEmptyArrayOfByte_thenSendDataReturnUnpooledHeapByteBuf2() throws Exception {
    // Arrange and Act
    HelloMessage actualHelloMessage = new HelloMessage(new byte[]{});

    // Assert
    assertTrue(actualHelloMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualHelloMessage.getAnswerMessage());
    assertEquals(0, actualHelloMessage.getNodeType());
    assertEquals(0, actualHelloMessage.getVersion());
    assertEquals(0L, actualHelloMessage.getLowestBlockNum());
    assertEquals(0L, actualHelloMessage.getTimestamp());
    assertEquals(MessageTypes.P2P_HELLO, actualHelloMessage.getType());
    assertFalse(actualHelloMessage.valid());
    assertArrayEquals(new byte[]{}, actualHelloMessage.getData());
    assertArrayEquals(new byte[]{' '}, actualHelloMessage.getSendBytes());
  }

  /**
   * Test {@link HelloMessage#getVersion()}.
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int HelloMessage.getVersion()"})
  public void testGetVersion_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new HelloMessage(new byte[]{})).getVersion());
  }

  /**
   * Test {@link HelloMessage#getNodeType()}.
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getNodeType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int HelloMessage.getNodeType()"})
  public void testGetNodeType_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new HelloMessage(new byte[]{})).getNodeType());
  }

  /**
   * Test {@link HelloMessage#getLowestBlockNum()}.
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getLowestBlockNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long HelloMessage.getLowestBlockNum()"})
  public void testGetLowestBlockNum_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0L, (new HelloMessage(new byte[]{})).getLowestBlockNum());
  }

  /**
   * Test {@link HelloMessage#getTimestamp()}.
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long HelloMessage.getTimestamp()"})
  public void testGetTimestamp_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnZero() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0L, (new HelloMessage(new byte[]{})).getTimestamp());
  }

  /**
   * Test {@link HelloMessage#getFrom()}.
   * <ul>
   *   <li>Then return HexId is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getFrom()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node HelloMessage.getFrom()"})
  public void testGetFrom_thenReturnHexIdIsEmptyString() throws Exception {
    // Arrange and Act
    Node actualFrom = (new HelloMessage(new byte[]{})).getFrom();

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
    assertArrayEquals(new byte[]{}, actualFrom.getId());
  }

  /**
   * Test {@link HelloMessage#valid()}.
   * <ul>
   *   <li>Given {@link HelloMessage#HelloMessage(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#valid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HelloMessage.valid()"})
  public void testValid_givenHelloMessageWithDataIsEmptyArrayOfByte_thenReturnFalse() throws Exception {
    // Arrange, Act and Assert
    assertFalse((new HelloMessage(new byte[]{})).valid());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   * <p>
   * Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Discover.Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode() {
    // Arrange
    InetAddress addr = mock(InetAddress.class);
    when(addr.getHostAddress()).thenReturn("");

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(
        new Node(new HttpInetSocketAddress(HttpHost.create("https://example.org/example"), addr, 8080)));

    // Assert
    verify(addr).getHostAddress();
    DescriptorProto toProtoResult = actualEndpointFromNode.getDescriptorForType()
        .toProto()
        .getDescriptorForType()
        .toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("DescriptorProto", toProtoResult.getName());
    assertEquals(2, actualEndpointFromNode.getAllFields().size());
    assertEquals(69, actualEndpointFromNode.getSerializedSize());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return AddressIpv6 toStringUtf8 is {@code 0.0.0.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Discover.Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_given42_thenReturnAddressIpv6ToStringUtf8Is00042() {
    // Arrange
    HttpHost httphost = HttpHost.create("https://example.org/example");
    InetAddress addr = mock(InetAddress.class);
    when(addr.getHostAddress()).thenReturn("42");

    // Act
    Endpoint actualEndpointFromNode = HelloMessage
        .getEndpointFromNode(new Node(new HttpInetSocketAddress(httphost, addr, 8080)));

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
   * <ul>
   *   <li>Then return AddressIpv6 toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Discover.Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_thenReturnAddressIpv6ToStringUtf8IsEmptyString() {
    // Arrange and Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(new Node(new InetSocketAddress(1)));

    // Assert
    ByteString addressIpv6 = actualEndpointFromNode.getAddressIpv6();
    assertEquals("", addressIpv6.toStringUtf8());
    assertEquals(77, actualEndpointFromNode.getSerializedSize());
    assertFalse(addressIpv6.iterator().hasNext());
    assertTrue(addressIpv6.isEmpty());
    Endpoint defaultInstanceForType = actualEndpointFromNode.getDefaultInstanceForType();
    assertSame(addressIpv6, defaultInstanceForType.getAddress());
    assertSame(addressIpv6, defaultInstanceForType.getAddressIpv6());
    assertSame(addressIpv6, defaultInstanceForType.getNodeId());
  }

  /**
   * Test {@link HelloMessage#getEndpointFromNode(Node)}.
   * <ul>
   *   <li>Then return NodeId toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelloMessage#getEndpointFromNode(Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Discover.Endpoint HelloMessage.getEndpointFromNode(Node)"})
  public void testGetEndpointFromNode_thenReturnNodeIdToStringUtf8IsEmptyString() {
    // Arrange
    Node node = new Node(new InetSocketAddress(1));
    node.setId(null);
    node.updateHostV4("not empty");
    node.updateHostV6("not empty");

    // Act
    Endpoint actualEndpointFromNode = HelloMessage.getEndpointFromNode(node);

    // Assert
    ByteString nodeId = actualEndpointFromNode.getNodeId();
    assertEquals("", nodeId.toStringUtf8());
    ByteString addressIpv6 = actualEndpointFromNode.getAddressIpv6();
    assertEquals("not empty", addressIpv6.toStringUtf8());
    assertEquals(22, actualEndpointFromNode.getSerializedSize());
    assertFalse(nodeId.iterator().hasNext());
    assertTrue(nodeId.isEmpty());
    ByteIterator iteratorResult = addressIpv6.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    Endpoint defaultInstanceForType = actualEndpointFromNode.getDefaultInstanceForType();
    assertSame(nodeId, defaultInstanceForType.getAddress());
    assertSame(nodeId, defaultInstanceForType.getAddressIpv6());
    assertSame(nodeId, defaultInstanceForType.getNodeId());
  }
}
