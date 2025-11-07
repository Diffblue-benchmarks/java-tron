package org.tron.common.backup.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import java.math.BigInteger;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.P2pException;
import org.tron.p2p.discover.Node;
import org.tron.protos.Discover;

public class MessageDiffblueTest {
  /**
   * Method under test: {@link Message#getNode(Discover.Endpoint)}
   */
  @Test
  public void testGetNode() {
    // Arrange and Act
    Node actualNode = Message.getNode(Discover.Endpoint.getDefaultInstance());

    // Assert
    assertEquals("", actualNode.getHexId());
    assertEquals("", actualNode.getIdString());
    assertEquals("Node{ hostV4='null', hostV6='null', port=0}", actualNode.format());
    assertNull(actualNode.getHostV4());
    assertNull(actualNode.getHostV6());
    assertNull(actualNode.getInetSocketAddressV4());
    assertNull(actualNode.getInetSocketAddressV6());
    assertNull(actualNode.getPreferInetSocketAddress());
    assertEquals(0, actualNode.getPort());
    assertEquals(0, actualNode.getId().length);
  }

  /**
   * Method under test: {@link Message#parse(byte[])}
   */
  @Test
  public void testParse() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> Message.parse("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(P2pException.class, () -> Message.parse(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> Message.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link Message#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(UdpMessageTypeEnum.BACKUP_KEEP_ALIVE, (new KeepAliveMessage(true, 1)).getType());
  }

  /**
   * Method under test: {@link Message#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act and Assert
    assertSame(keepAliveMessage.data, keepAliveMessage.getData());
  }

  /**
   * Method under test: {@link Message#getSendData()}
   */
  @Test
  public void testGetSendData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{5, '\b', 1, 16, 1}, (new KeepAliveMessage(true, 1)).getSendData());
    assertArrayEquals(new byte[]{5}, (new KeepAliveMessage(false, 0)).getSendData());
  }

  /**
   * Method under test: {@link Message#getMessageId()}
   */
  @Test
  public void testGetMessageId() {
    // Arrange and Act
    Sha256Hash actualMessageId = (new KeepAliveMessage(true, 1)).getMessageId();

    // Assert
    BigInteger toBigIntegerResult = actualMessageId.toBigInteger();
    assertEquals("65085834912529076615808765632958408533825304582800044733745558973486862168400",
        toBigIntegerResult.toString());
    ByteString byteString = actualMessageId.getByteString();
    assertEquals("��F��B\u0014�\u001fa�|EV�\u001f�\u0002h3A\u0000���wyk�P", byteString.toStringUtf8());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -113, iteratorResult.next().byteValue());
    assertEquals((byte) -27, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertEquals('F', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{-113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
        31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'}, actualMessageId.getBytes());
    assertArrayEquals(new byte[]{0, -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
        31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'}, toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link Message#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[Message Type: BACKUP_KEEP_ALIVE, len: 4]", (new KeepAliveMessage(true, 1)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Message#equals(Object)}
   *   <li>{@link Message#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act and Assert
    assertEquals(keepAliveMessage, keepAliveMessage);
    int expectedHashCodeResult = keepAliveMessage.hashCode();
    assertEquals(expectedHashCodeResult, keepAliveMessage.hashCode());
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act and Assert
    assertNotEquals(keepAliveMessage, new KeepAliveMessage(true, 1));
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeepAliveMessage(true, 1), null);
  }

  /**
   * Method under test: {@link Message#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeepAliveMessage(true, 1), "Different type to Message");
  }
}
