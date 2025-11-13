package org.tron.common.backup.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import org.tron.p2p.discover.Node;

public class KeepAliveMessageDiffblueTest {
  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}.
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(boolean, int)"})
  public void testNewKeepAliveMessage() {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(true, 1);

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "65085834912529076615808765632958408533825304582800044733745558973486862168400",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals(
        "��F��B\u0014�\u001fa�|EV�\u001f�\u0002h3A\u0000���wyk�P", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -113, iteratorResult.next().byteValue());
    assertEquals((byte) -27, iteratorResult.next().byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, actualKeepAliveMessage.getData());
    assertArrayEquals(new byte[] {5, '\b', 1, 16, 1}, actualKeepAliveMessage.getSendData());
    assertArrayEquals(
        new byte[] {
          -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57, 31,
          -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -113, -27, 'F', -17, -51, 'B', 20, -14, -117, 31, 'a', -25, -81, '|', 'E', 'V', -57,
          31, -77, 2, 'h', '3', 'A', 0, -83, -1, -24, 'w', 'y', 'k', -15, 'P'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}.
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(boolean, int)"})
  public void testNewKeepAliveMessage2() {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(true, 0);

    // Assert
    assertArrayEquals(new byte[] {'\b', 1}, actualKeepAliveMessage.getData());
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) -5, iteratorResult.next().byteValue());
    assertEquals((byte) -115, iteratorResult.next().byteValue());
    assertEquals(
        "����[\u001b9�s!\u0017����ew=s1��\u0005T�\u001eC%��\u0019", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          -5, -115, -89, -21, '[', 27, '9', -98, 's', '!', 23, -99, -84, -98, -97, 'e', 'w', '=',
          's', '1', -31, -29, 5, 'T', -29, -111, 30, 'C', '%', -31, -17, 25
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertArrayEquals(
        new byte[] {
          0, -5, -115, -89, -21, '[', 27, '9', -98, 's', '!', 23, -99, -84, -98, -97, 'e', 'w', '=',
          's', '1', -31, -29, 5, 'T', -29, -111, 30, 'C', '%', -31, -17, 25
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "113780809367355614764402642993164775391857922722563564225032412876168820289305",
        toBigIntegerResult.toString());
    assertEquals(0, actualKeepAliveMessage.getPriority());
    assertArrayEquals(new byte[] {5, '\b', 1}, actualKeepAliveMessage.getSendData());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(byte[])}.
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(byte[])"})
  public void testNewKeepAliveMessage3() throws Exception {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(new byte[] {});

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertFalse(actualKeepAliveMessage.getFlag());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {}, actualKeepAliveMessage.getData());
    assertArrayEquals(new byte[] {5}, actualKeepAliveMessage.getSendData());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
          -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(byte[])}.
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(byte[])"})
  public void testNewKeepAliveMessage4() throws Exception {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage =
        new KeepAliveMessage(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
            });

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "97808410430355507942467284857123901182623266498757764793137387803858232509555",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("�=�7��!3&�I�ӰsM��\"N\u0010G�l���\"��s", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -40, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertEquals('=', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualKeepAliveMessage.getData());
    assertArrayEquals(
        new byte[] {
          5, 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualKeepAliveMessage.getSendData());
    assertArrayEquals(
        new byte[] {
          -40, '=', -103, '7', -110, -123, '!', '3', '&', -44, 'I', -47, -45, -80, 's', 'M', -79,
          -89, '"', 'N', 16, 'G', -16, -74, 'l', -61, -17, -20, '"', -99, -124, 's'
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -40, '=', -103, '7', -110, -123, '!', '3', '&', -44, 'I', -47, -45, -80, 's', 'M', -79,
          -89, '"', 'N', 16, 'G', -16, -74, 'l', -61, -17, -20, '"', -99, -124, 's'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(byte[])}.
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(byte[])"})
  public void testNewKeepAliveMessage5() throws Exception {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage =
        new KeepAliveMessage(
            new byte[] {
              16, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
            });

    // Assert
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "74393127470313803220377630052594544903672434332516428041070212067985872204088",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals(
        "�y\u0004��O\u001a�\u0013�|�\"��\u0010��tT�\u000b��5ז��\u001d18",
        byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -92, iteratorResult.next().byteValue());
    assertEquals(3, toBigIntegerResult.getLowestSetBit());
    assertEquals(8, actualKeepAliveMessage.getPriority());
    assertTrue(iteratorResult.hasNext());
    assertEquals('y', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          16, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualKeepAliveMessage.getData());
    assertArrayEquals(
        new byte[] {
          5, 16, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualKeepAliveMessage.getSendData());
    assertArrayEquals(
        new byte[] {
          -92, 'y', 4, -101, -47, 'O', 26, -97, 19, -60, '|', -76, '"', -27, -36, 16, -63, -47, 't',
          'T', -4, 11, -39, -49, '5', -41, -106, -47, -33, 29, '1', '8'
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -92, 'y', 4, -101, -47, 'O', 26, -97, 19, -60, '|', -76, '"', -27, -36, 16, -63, -47,
          't', 'T', -4, 11, -39, -49, '5', -41, -106, -47, -33, 29, '1', '8'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}.
   *
   * <ul>
   *   <li>Then return MessageId ByteString iterator next byteValue is {@code s}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(boolean, int)"})
  public void testNewKeepAliveMessage_thenReturnMessageIdByteStringIteratorNextByteValueIsS() {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(true, -1);

    // Assert
    assertArrayEquals(
        new byte[] {'\b', 1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualKeepAliveMessage.getData());
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('s', iteratorResult.next().byteValue());
    assertEquals((byte) -114, iteratorResult.next().byteValue());
    assertEquals("s���pQ!���\u001b����W����l\tD�F��7�\nKM", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          's', -114, -118, -6, 'p', 'Q', '!', -116, -12, -78, 27, -6, -109, -89, -126, 'W', -37,
          -54, -7, -81, 'l', '\t', 'D', -107, 'F', -34, -42, '7', -66, '\n', 'K', 'M'
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertArrayEquals(
        new byte[] {
          's', -114, -118, -6, 'p', 'Q', '!', -116, -12, -78, 27, -6, -109, -89, -126, 'W', -37,
          -54, -7, -81, 'l', '\t', 'D', -107, 'F', -34, -42, '7', -66, '\n', 'K', 'M'
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "52267829063085041171109506235924885470666251068384078840629655038591664540493",
        toBigIntegerResult.toString());
    assertEquals(-1, actualKeepAliveMessage.getPriority());
    assertArrayEquals(
        new byte[] {5, '\b', 1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualKeepAliveMessage.getSendData());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(byte[])}.
   *
   * <ul>
   *   <li>Then return MessageId ByteString iterator next byteValue is {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(byte[])"})
  public void testNewKeepAliveMessage_thenReturnMessageIdByteStringIteratorNextByteValueIsW()
      throws Exception {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage =
        new KeepAliveMessage(
            new byte[] {
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              '\b',
              'A',
              Byte.MIN_VALUE,
              'A',
              '\b'
            });

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          Byte.MIN_VALUE,
          'A',
          '\b'
        },
        actualKeepAliveMessage.getData());
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('w', iteratorResult.next().byteValue());
    assertEquals((byte) -103, iteratorResult.next().byteValue());
    assertEquals(
        "w�᎑�̲��6�\u0018���\u0001�h�;\u00179�\u0019Vb�\u001f\u0007�$", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          'w', -103, -31, -114, -111, -107, -52, -78, -69, -66, '6', -1, 24, -126, -70, -24, 1, -72,
          'h', -96, ';', 23, '9', -9, 25, 'V', 'b', -43, 31, 7, -88, '$'
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          'w', -103, -31, -114, -111, -107, -52, -78, -69, -66, '6', -1, 24, -126, -70, -24, 1, -72,
          'h', -96, ';', 23, '9', -9, 25, 'V', 'b', -43, 31, 7, -88, '$'
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "54097113318892153905084433591584869059216185908516641822551022752152238401572",
        toBigIntegerResult.toString());
    assertArrayEquals(
        new byte[] {
          5,
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          '\b',
          'A',
          Byte.MIN_VALUE,
          'A',
          '\b'
        },
        actualKeepAliveMessage.getSendData());
  }

  /**
   * Test {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Data is array of {@code byte} with sixteen and one.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveMessage#KeepAliveMessage(boolean, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeepAliveMessage.<init>(boolean, int)"})
  public void testNewKeepAliveMessage_whenFalse_thenReturnDataIsArrayOfByteWithSixteenAndOne() {
    // Arrange and Act
    KeepAliveMessage actualKeepAliveMessage = new KeepAliveMessage(false, 1);

    // Assert
    assertArrayEquals(new byte[] {16, 1}, actualKeepAliveMessage.getData());
    assertFalse(actualKeepAliveMessage.getFlag());
    Sha256Hash messageId = actualKeepAliveMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\'', iteratorResult.next().byteValue());
    assertEquals((byte) -62, iteratorResult.next().byteValue());
    assertEquals("'�O˄tw>*��Є���\u00052r�<C-�bw�=�\\�v", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          '\'', -62, 'O', -53, -124, 't', 'w', '>', '*', -9, -103, -48, -124, -124, -107, -1, 5,
          '2', 'r', -45, '<', 'C', '-', -62, 'b', 'w', -103, '=', -12, '\\', -110, 'v'
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(1, toBigIntegerResult.getLowestSetBit());
    assertArrayEquals(
        new byte[] {
          '\'', -62, 'O', -53, -124, 't', 'w', '>', '*', -9, -103, -48, -124, -124, -107, -1, 5,
          '2', 'r', -45, '<', 'C', '-', -62, 'b', 'w', -103, '=', -12, '\\', -110, 'v'
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "17983520150094099340890878111062287376259986269405307550348495760712357679734",
        toBigIntegerResult.toString());
    assertArrayEquals(new byte[] {5, 16, 1}, actualKeepAliveMessage.getSendData());
  }

  /**
   * Test {@link KeepAliveMessage#getFlag()}.
   *
   * <ul>
   *   <li>Given {@link KeepAliveMessage#KeepAliveMessage(boolean, int)} with flag is {@code false}
   *       and priority is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveMessage#getFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeepAliveMessage.getFlag()"})
  public void testGetFlag_givenKeepAliveMessageWithFlagIsFalseAndPriorityIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new KeepAliveMessage(false, 1).getFlag());
  }

  /**
   * Test {@link KeepAliveMessage#getFlag()}.
   *
   * <ul>
   *   <li>Given {@link KeepAliveMessage#KeepAliveMessage(boolean, int)} with flag is {@code true}
   *       and priority is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KeepAliveMessage#getFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeepAliveMessage.getFlag()"})
  public void testGetFlag_givenKeepAliveMessageWithFlagIsTrueAndPriorityIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new KeepAliveMessage(true, 1).getFlag());
  }

  /**
   * Test {@link KeepAliveMessage#getPriority()}.
   *
   * <p>Method under test: {@link KeepAliveMessage#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int KeepAliveMessage.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(1, new KeepAliveMessage(true, 1).getPriority());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeepAliveMessage#getFrom()}
   *   <li>{@link KeepAliveMessage#getTimestamp()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
