package org.tron.common.backup.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.P2pException;
import org.tron.p2p.discover.Node;
import org.tron.protos.Discover;
import org.tron.protos.Discover.Endpoint;

public class MessageDiffblueTest {
  /**
   * Test {@link Message#getNode(Endpoint)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return HexId is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Message#getNode(Discover.Endpoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Message.getNode(Discover.Endpoint)"})
  public void testGetNode_whenDefaultInstance_thenReturnHexIdIsEmptyString() {
    // Arrange and Act
    Node actualNode = Message.getNode(Endpoint.getDefaultInstance());

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
    assertArrayEquals(new byte[] {}, actualNode.getId());
  }

  /**
   * Test {@link Message#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and one.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link Message#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message Message.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAAndOne_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () ->
            Message.parse(
                new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1}));
  }

  /**
   * Test {@link Message#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link Message#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message Message.parse(byte[])"})
  public void testParse_whenAxaxaxaxBytesIsUtf8_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> Message.parse("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Message#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link Message#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Message Message.parse(byte[])"})
  public void testParse_whenX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () -> Message.parse(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link Message#getType()}.
   *
   * <p>Method under test: {@link Message#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UdpMessageTypeEnum Message.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(UdpMessageTypeEnum.BACKUP_KEEP_ALIVE, new KeepAliveMessage(true, 1).getType());
  }

  /**
   * Test {@link Message#getData()}.
   *
   * <p>Method under test: {@link Message#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Message.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, new KeepAliveMessage(true, 1).getData());
  }

  /**
   * Test {@link Message#getSendData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with five.
   * </ul>
   *
   * <p>Method under test: {@link Message#getSendData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Message.getSendData()"})
  public void testGetSendData_thenReturnArrayOfByteWithFive() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {5}, new KeepAliveMessage(false, 0).getSendData());
  }

  /**
   * Test {@link Message#getSendData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with five and backspace.
   * </ul>
   *
   * <p>Method under test: {@link Message#getSendData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Message.getSendData()"})
  public void testGetSendData_thenReturnArrayOfByteWithFiveAndBackspace() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {5, '\b', 1, 16, 1}, new KeepAliveMessage(true, 1).getSendData());
  }

  /**
   * Test {@link Message#getMessageId()}.
   *
   * <p>Method under test: {@link Message#getMessageId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash Message.getMessageId()"})
  public void testGetMessageId() {
    // Arrange and Act
    Sha256Hash actualMessageId = new KeepAliveMessage(true, 1).getMessageId();

    // Assert
    BigInteger toBigIntegerResult = actualMessageId.toBigInteger();
    assertEquals(
        "65085834912529076615808765632958408533825304582800044733745558973486862168400",
        toBigIntegerResult.toString());
    ByteString byteString = actualMessageId.getByteString();
    assertEquals(
        "��F��B\u0014�\u001fa�|EV�\u001f�\u0002h3A\u0000���wyk�P", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -113, iteratorResult.next().byteValue());
    assertEquals((byte) -27, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertEquals('F', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57, 31,
          -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'
        },
        actualMessageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
          31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link Message#toString()}.
   *
   * <p>Method under test: {@link Message#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Message.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "[Message Type: BACKUP_KEEP_ALIVE, len: 4]", new KeepAliveMessage(true, 1).toString());
  }

  /**
   * Test {@link Message#equals(Object)}, and {@link Message#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Message#equals(Object)}
   *   <li>{@link Message#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Message.equals(Object)", "int Message.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act and Assert
    assertEquals(keepAliveMessage, keepAliveMessage);
    int expectedHashCodeResult = keepAliveMessage.hashCode();
    assertEquals(expectedHashCodeResult, keepAliveMessage.hashCode());
  }

  /**
   * Test {@link Message#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Message#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Message.equals(Object)", "int Message.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act and Assert
    assertNotEquals(keepAliveMessage, new KeepAliveMessage(true, 1));
  }

  /**
   * Test {@link Message#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Message#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Message.equals(Object)", "int Message.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeepAliveMessage(true, 1), null);
  }

  /**
   * Test {@link Message#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Message#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Message.equals(Object)", "int Message.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeepAliveMessage(true, 1), "Different type to Message");
  }
}
