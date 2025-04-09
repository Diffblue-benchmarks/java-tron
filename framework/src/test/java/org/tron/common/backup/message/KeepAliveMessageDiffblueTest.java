package org.tron.common.backup.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.p2p.discover.Node;

public class KeepAliveMessageDiffblueTest {
  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}.
   * <p>
   * Method under test: {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveMessage.<init>(boolean, int)"})
  public void testNewKeepAliveMessage() {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(true, 1);

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("65085834912529076615808765632958408533825304582800044733745558973486862168400",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��F��B\u0014�\u001fa�|EV�\u001f�\u0002h3A\u0000���wyk�P", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -113, iteratorResult.next().byteValue());
    assertEquals((byte) -27, iteratorResult.next().byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{'\b', 1, 16, 1}, actualKeepAliveMessage.getData());
    assertArrayEquals(new byte[]{5, '\b', 1, 16, 1}, actualKeepAliveMessage.getSendData());
    assertArrayEquals(new byte[]{-113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
        31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
        31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'}, toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(byte[])}.
   * <p>
   * Method under test: {@link KeepAliveMessage#KeepAliveMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeepAliveMessage.<init>(byte[])"})
  public void testNewKeepAliveMessage2() throws Exception {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(new byte[]{});

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(actualKeepAliveMessage.getFrom());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualKeepAliveMessage.getPriority());
    assertEquals(0L, actualKeepAliveMessage.getTimestamp());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(UdpMessageTypeEnum.BACKUP_KEEP_ALIVE, actualKeepAliveMessage.getType());
    assertFalse(byteString.isEmpty());
    assertFalse(actualKeepAliveMessage.getFlag());
    assertTrue(byteString.iterator().hasNext());
    assertArrayEquals(new byte[]{}, actualKeepAliveMessage.getData());
    assertArrayEquals(new byte[]{5}, actualKeepAliveMessage.getSendData());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#getFlag()}.
   * <ul>
   *   <li>Given {@link KeepAliveMessage#KeepAliveMessage(boolean, int)} with flag is {@code false} and priority is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeepAliveMessage#getFlag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeepAliveMessage.getFlag()"})
  public void testGetFlag_givenKeepAliveMessageWithFlagIsFalseAndPriorityIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new KeepAliveMessage(false, 1)).getFlag());
  }

  /**
   * Test {@link KeepAliveMessage#getFlag()}.
   * <ul>
   *   <li>Given {@link KeepAliveMessage#KeepAliveMessage(boolean, int)} with flag is {@code true} and priority is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeepAliveMessage#getFlag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KeepAliveMessage.getFlag()"})
  public void testGetFlag_givenKeepAliveMessageWithFlagIsTrueAndPriorityIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new KeepAliveMessage(true, 1)).getFlag());
  }

  /**
   * Test {@link KeepAliveMessage#getPriority()}.
   * <p>
   * Method under test: {@link KeepAliveMessage#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int KeepAliveMessage.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1, (new KeepAliveMessage(true, 1)).getPriority());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeepAliveMessage#getFrom()}
   *   <li>{@link KeepAliveMessage#getTimestamp()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node KeepAliveMessage.getFrom()", "long KeepAliveMessage.getTimestamp()"})
  public void testGettersAndSetters() {
    // Arrange
    KeepAliveMessage keepAliveMessage = new KeepAliveMessage(true, 1);

    // Act
    Node actualFrom = keepAliveMessage.getFrom();

    // Assert
    assertNull(actualFrom);
    assertEquals(0L, keepAliveMessage.getTimestamp());
  }
}
