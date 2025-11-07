package org.tron.core.net.message.base;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class DisconnectMessageDiffblueTest {
  /**
   * Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  public void testGetReason() {
    // Arrange, Act and Assert
    assertEquals(Protocol.ReasonCode.REQUESTED, (new DisconnectMessage(Protocol.ReasonCode.REQUESTED)).getReason());
    assertEquals(Protocol.ReasonCode.BAD_PROTOCOL,
        (new DisconnectMessage(Protocol.ReasonCode.BAD_PROTOCOL)).getReason());
    assertEquals(Protocol.ReasonCode.TOO_MANY_PEERS,
        (new DisconnectMessage(Protocol.ReasonCode.TOO_MANY_PEERS)).getReason());
    assertEquals(Protocol.ReasonCode.DUPLICATE_PEER,
        (new DisconnectMessage(Protocol.ReasonCode.DUPLICATE_PEER)).getReason());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_PROTOCOL,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_PROTOCOL)).getReason());
    assertEquals(Protocol.ReasonCode.RANDOM_ELIMINATION,
        (new DisconnectMessage(Protocol.ReasonCode.RANDOM_ELIMINATION)).getReason());
    assertEquals(Protocol.ReasonCode.PEER_QUITING,
        (new DisconnectMessage(Protocol.ReasonCode.PEER_QUITING)).getReason());
    assertEquals(Protocol.ReasonCode.UNEXPECTED_IDENTITY,
        (new DisconnectMessage(Protocol.ReasonCode.UNEXPECTED_IDENTITY)).getReason());
    assertEquals(Protocol.ReasonCode.LOCAL_IDENTITY,
        (new DisconnectMessage(Protocol.ReasonCode.LOCAL_IDENTITY)).getReason());
    assertEquals(Protocol.ReasonCode.PING_TIMEOUT,
        (new DisconnectMessage(Protocol.ReasonCode.PING_TIMEOUT)).getReason());
    assertEquals(Protocol.ReasonCode.USER_REASON, (new DisconnectMessage(Protocol.ReasonCode.USER_REASON)).getReason());
    assertEquals(Protocol.ReasonCode.RESET, (new DisconnectMessage(Protocol.ReasonCode.RESET)).getReason());
    assertEquals(Protocol.ReasonCode.SYNC_FAIL, (new DisconnectMessage(Protocol.ReasonCode.SYNC_FAIL)).getReason());
    assertEquals(Protocol.ReasonCode.FETCH_FAIL, (new DisconnectMessage(Protocol.ReasonCode.FETCH_FAIL)).getReason());
    assertEquals(Protocol.ReasonCode.BAD_TX, (new DisconnectMessage(Protocol.ReasonCode.BAD_TX)).getReason());
    assertEquals(Protocol.ReasonCode.BAD_BLOCK, (new DisconnectMessage(Protocol.ReasonCode.BAD_BLOCK)).getReason());
    assertEquals(Protocol.ReasonCode.FORKED, (new DisconnectMessage(Protocol.ReasonCode.FORKED)).getReason());
    assertEquals(Protocol.ReasonCode.UNLINKABLE, (new DisconnectMessage(Protocol.ReasonCode.UNLINKABLE)).getReason());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_VERSION,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_VERSION)).getReason());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_CHAIN,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_CHAIN)).getReason());
  }

  /**
   * Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  public void testGetReasonCode() {
    // Arrange, Act and Assert
    assertEquals(Protocol.ReasonCode.REQUESTED, (new DisconnectMessage(Protocol.ReasonCode.REQUESTED)).getReasonCode());
    assertEquals(Protocol.ReasonCode.BAD_PROTOCOL,
        (new DisconnectMessage(Protocol.ReasonCode.BAD_PROTOCOL)).getReasonCode());
    assertEquals(Protocol.ReasonCode.TOO_MANY_PEERS,
        (new DisconnectMessage(Protocol.ReasonCode.TOO_MANY_PEERS)).getReasonCode());
    assertEquals(Protocol.ReasonCode.DUPLICATE_PEER,
        (new DisconnectMessage(Protocol.ReasonCode.DUPLICATE_PEER)).getReasonCode());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_PROTOCOL,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_PROTOCOL)).getReasonCode());
    assertEquals(Protocol.ReasonCode.RANDOM_ELIMINATION,
        (new DisconnectMessage(Protocol.ReasonCode.RANDOM_ELIMINATION)).getReasonCode());
    assertEquals(Protocol.ReasonCode.PEER_QUITING,
        (new DisconnectMessage(Protocol.ReasonCode.PEER_QUITING)).getReasonCode());
    assertEquals(Protocol.ReasonCode.UNEXPECTED_IDENTITY,
        (new DisconnectMessage(Protocol.ReasonCode.UNEXPECTED_IDENTITY)).getReasonCode());
    assertEquals(Protocol.ReasonCode.LOCAL_IDENTITY,
        (new DisconnectMessage(Protocol.ReasonCode.LOCAL_IDENTITY)).getReasonCode());
    assertEquals(Protocol.ReasonCode.PING_TIMEOUT,
        (new DisconnectMessage(Protocol.ReasonCode.PING_TIMEOUT)).getReasonCode());
    assertEquals(Protocol.ReasonCode.USER_REASON,
        (new DisconnectMessage(Protocol.ReasonCode.USER_REASON)).getReasonCode());
    assertEquals(Protocol.ReasonCode.RESET, (new DisconnectMessage(Protocol.ReasonCode.RESET)).getReasonCode());
    assertEquals(Protocol.ReasonCode.SYNC_FAIL, (new DisconnectMessage(Protocol.ReasonCode.SYNC_FAIL)).getReasonCode());
    assertEquals(Protocol.ReasonCode.FETCH_FAIL,
        (new DisconnectMessage(Protocol.ReasonCode.FETCH_FAIL)).getReasonCode());
    assertEquals(Protocol.ReasonCode.BAD_TX, (new DisconnectMessage(Protocol.ReasonCode.BAD_TX)).getReasonCode());
    assertEquals(Protocol.ReasonCode.BAD_BLOCK, (new DisconnectMessage(Protocol.ReasonCode.BAD_BLOCK)).getReasonCode());
    assertEquals(Protocol.ReasonCode.FORKED, (new DisconnectMessage(Protocol.ReasonCode.FORKED)).getReasonCode());
    assertEquals(Protocol.ReasonCode.UNLINKABLE,
        (new DisconnectMessage(Protocol.ReasonCode.UNLINKABLE)).getReasonCode());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_VERSION,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_VERSION)).getReasonCode());
    assertEquals(Protocol.ReasonCode.INCOMPATIBLE_CHAIN,
        (new DisconnectMessage(Protocol.ReasonCode.INCOMPATIBLE_CHAIN)).getReasonCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectMessage#toString()}
   *   <li>{@link DisconnectMessage#getAnswerMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DisconnectMessage disconnectMessage = new DisconnectMessage(Protocol.ReasonCode.REQUESTED);

    // Act
    String actualToStringResult = disconnectMessage.toString();

    // Assert
    assertEquals("type: P2P_DISCONNECT\nreason: REQUESTED", actualToStringResult);
    assertNull(disconnectMessage.getAnswerMessage());
  }

  /**
   * Method under test: {@link DisconnectMessage#DisconnectMessage(byte, byte[])}
   */
  @Test
  public void testNewDisconnectMessage() throws Exception {
    // Arrange
    byte[] rawData = new byte[]{};

    // Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage((byte) 'A', rawData);

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualDisconnectMessage.getAnswerMessage());
    assertNull(actualDisconnectMessage.getType());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    byte[] data = actualDisconnectMessage.getData();
    assertEquals(0, data.length);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertFalse(byteString.isEmpty());
    assertFalse(sendData.hasMemoryAddress());
    assertFalse(sendData.isDirect());
    assertFalse(sendData.isReadOnly());
    assertFalse(sendData.isWritable());
    assertFalse(allocResult.isDirectBufferPooled());
    assertTrue(sendData.hasArray());
    assertTrue(sendData.isContiguous());
    assertTrue(sendData.isReadable());
    assertTrue(sendData.readBoolean());
    assertTrue(iteratorResult.hasNext());
    assertSame(rawData, data);
    assertArrayEquals(new byte[]{'A'}, actualDisconnectMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test:
   * {@link DisconnectMessage#DisconnectMessage(Protocol.ReasonCode)}
   */
  @Test
  public void testNewDisconnectMessage2() {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage(Protocol.ReasonCode.REQUESTED);

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualDisconnectMessage.getAnswerMessage());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualDisconnectMessage.getData().length);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.P2P_DISCONNECT, actualDisconnectMessage.getType());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertFalse(byteString.isEmpty());
    assertFalse(sendData.hasMemoryAddress());
    assertFalse(sendData.isDirect());
    assertFalse(sendData.isReadOnly());
    assertFalse(sendData.isWritable());
    assertFalse(allocResult.isDirectBufferPooled());
    assertTrue(sendData.hasArray());
    assertTrue(sendData.isContiguous());
    assertTrue(sendData.isReadable());
    assertTrue(sendData.readBoolean());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{'!'}, actualDisconnectMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link DisconnectMessage#DisconnectMessage(byte[])}
   */
  @Test
  public void testNewDisconnectMessage3() throws Exception {
    // Arrange
    byte[] data = new byte[]{};

    // Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage(data);

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualDisconnectMessage.getAnswerMessage());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    byte[] data2 = actualDisconnectMessage.getData();
    assertEquals(0, data2.length);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.P2P_DISCONNECT, actualDisconnectMessage.getType());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(Protocol.ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertFalse(byteString.isEmpty());
    assertFalse(sendData.hasMemoryAddress());
    assertFalse(sendData.isDirect());
    assertFalse(sendData.isReadOnly());
    assertFalse(sendData.isWritable());
    assertFalse(allocResult.isDirectBufferPooled());
    assertTrue(sendData.hasArray());
    assertTrue(sendData.isContiguous());
    assertTrue(sendData.isReadable());
    assertTrue(sendData.readBoolean());
    assertTrue(iteratorResult.hasNext());
    assertSame(data, data2);
    assertArrayEquals(new byte[]{'!'}, actualDisconnectMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }
}
