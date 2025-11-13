package org.tron.core.net.message.base;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

public class DisconnectMessageDiffblueTest {
  /**
   * Test {@link DisconnectMessage#DisconnectMessage(byte, byte[])}.
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte, byte[])"})
  public void testNewDisconnectMessage() throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage =
        new DisconnectMessage(
            (byte) 'A',
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
            });

    // Assert
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
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
        actualDisconnectMessage.getData());
    assertArrayEquals(
        new byte[] {
          'A', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualDisconnectMessage.getSendBytes());
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
   * Test {@link DisconnectMessage#DisconnectMessage(ReasonCode)}.
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(ReasonCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(ReasonCode)"})
  public void testNewDisconnectMessage2() {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage(ReasonCode.REQUESTED);

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    assertEquals(
        "��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", messageId.getByteString().toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertArrayEquals(new byte[] {}, actualDisconnectMessage.getData());
    assertArrayEquals(new byte[] {'!'}, actualDisconnectMessage.getSendBytes());
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
   * Test {@link DisconnectMessage#DisconnectMessage(ReasonCode)}.
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(ReasonCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(ReasonCode)"})
  public void testNewDisconnectMessage3() {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage(ReasonCode.BAD_PROTOCOL);

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "55330226321852901710927367809631444666145199179223163867839226118455992859420",
        toBigIntegerResult.toString());
    assertEquals(
        "zS�]�`Q/=���i]�\u0007 w���M���v�p�9;\u001c", messageId.getByteString().toStringUtf8());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertEquals(ReasonCode.BAD_PROTOCOL, actualDisconnectMessage.getReason());
    assertEquals(ReasonCode.BAD_PROTOCOL, actualDisconnectMessage.getReasonCode());
    assertArrayEquals(new byte[] {'\b', 2}, actualDisconnectMessage.getData());
    assertArrayEquals(new byte[] {'!', '\b', 2}, actualDisconnectMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          'z', 'S', -52, ']', -21, '`', 'Q', '/', '=', -84, -84, -57, 'i', ']', -43, 7, ' ', 'w',
          -58, -12, -104, 'M', -66, -37, -1, 'v', -30, 'p', -110, '9', ';', 28
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          'z', 'S', -52, ']', -21, '`', 'Q', '/', '=', -84, -84, -57, 'i', ']', -43, 7, ' ', 'w',
          -58, -12, -104, 'M', -66, -37, -1, 'v', -30, 'p', -110, '9', ';', 28
        },
        messageId.getBytes());
  }

  /**
   * Test {@link DisconnectMessage#DisconnectMessage(byte[])}.
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte[])"})
  public void testNewDisconnectMessage4() throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage =
        new DisconnectMessage(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
            });

    // Assert
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
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
        actualDisconnectMessage.getData());
    assertArrayEquals(
        new byte[] {
          '!', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualDisconnectMessage.getSendBytes());
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
   * Test {@link DisconnectMessage#DisconnectMessage(byte, byte[])}.
   *
   * <ul>
   *   <li>Then return MessageId ByteString iterator next byteValue is {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte, byte[])"})
  public void testNewDisconnectMessage_thenReturnMessageIdByteStringIteratorNextByteValueIsW()
      throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage =
        new DisconnectMessage(
            (byte) 'A',
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
        actualDisconnectMessage.getData());
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
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
          'A',
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
        actualDisconnectMessage.getSendBytes());
  }

  /**
   * Test {@link DisconnectMessage#DisconnectMessage(byte[])}.
   *
   * <ul>
   *   <li>Then return MessageId ByteString iterator next byteValue is {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte[])"})
  public void testNewDisconnectMessage_thenReturnMessageIdByteStringIteratorNextByteValueIsW2()
      throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage =
        new DisconnectMessage(
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
        actualDisconnectMessage.getData());
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
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
          '!',
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
        actualDisconnectMessage.getSendBytes());
  }

  /**
   * Test {@link DisconnectMessage#DisconnectMessage(byte, byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte, byte[])"})
  public void testNewDisconnectMessage_thenSendDataReturnUnpooledHeapByteBuf() throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage((byte) 'A', new byte[] {});

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    assertEquals(
        "��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", messageId.getByteString().toStringUtf8());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertArrayEquals(new byte[] {}, actualDisconnectMessage.getData());
    assertArrayEquals(new byte[] {'A'}, actualDisconnectMessage.getSendBytes());
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
   * Test {@link DisconnectMessage#DisconnectMessage(byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#DisconnectMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisconnectMessage.<init>(byte[])"})
  public void testNewDisconnectMessage_thenSendDataReturnUnpooledHeapByteBuf2() throws Exception {
    // Arrange and Act
    DisconnectMessage actualDisconnectMessage = new DisconnectMessage(new byte[] {});

    // Assert
    ByteBuf sendData = actualDisconnectMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualDisconnectMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    assertEquals(
        "��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", messageId.getByteString().toStringUtf8());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReason());
    assertEquals(ReasonCode.REQUESTED, actualDisconnectMessage.getReasonCode());
    assertArrayEquals(new byte[] {}, actualDisconnectMessage.getData());
    assertArrayEquals(new byte[] {'!'}, actualDisconnectMessage.getSendBytes());
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
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       BAD_BLOCK}.
   *   <li>Then return {@code BAD_BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_givenDisconnectMessageWithReasonCodeIsBadBlock_thenReturnBadBlock() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.BAD_BLOCK, new DisconnectMessage(ReasonCode.BAD_BLOCK).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       BAD_TX}.
   *   <li>Then return {@code BAD_TX}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_givenDisconnectMessageWithReasonCodeIsBadTx_thenReturnBadTx() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.BAD_TX, new DisconnectMessage(ReasonCode.BAD_TX).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       FORKED}.
   *   <li>Then return {@code FORKED}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_givenDisconnectMessageWithReasonCodeIsForked_thenReturnForked() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.FORKED, new DisconnectMessage(ReasonCode.FORKED).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       RESET}.
   *   <li>Then return {@code RESET}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_givenDisconnectMessageWithReasonCodeIsReset_thenReturnReset() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.RESET, new DisconnectMessage(ReasonCode.RESET).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       SYNC_FAIL}.
   *   <li>Then return {@code SYNC_FAIL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_givenDisconnectMessageWithReasonCodeIsSyncFail_thenReturnSyncFail() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.SYNC_FAIL, new DisconnectMessage(ReasonCode.SYNC_FAIL).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code BAD_PROTOCOL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnBadProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.BAD_PROTOCOL, new DisconnectMessage(ReasonCode.BAD_PROTOCOL).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code DUPLICATE_PEER}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnDuplicatePeer() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.DUPLICATE_PEER, new DisconnectMessage(ReasonCode.DUPLICATE_PEER).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code FETCH_FAIL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnFetchFail() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.FETCH_FAIL, new DisconnectMessage(ReasonCode.FETCH_FAIL).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code INCOMPATIBLE_PROTOCOL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnIncompatibleProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.INCOMPATIBLE_PROTOCOL,
        new DisconnectMessage(ReasonCode.INCOMPATIBLE_PROTOCOL).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code INCOMPATIBLE_VERSION}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnIncompatibleVersion() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.INCOMPATIBLE_VERSION,
        new DisconnectMessage(ReasonCode.INCOMPATIBLE_VERSION).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code LOCAL_IDENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnLocalIdentity() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.LOCAL_IDENTITY, new DisconnectMessage(ReasonCode.LOCAL_IDENTITY).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code PEER_QUITING}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnPeerQuiting() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.PEER_QUITING, new DisconnectMessage(ReasonCode.PEER_QUITING).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code PING_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnPingTimeout() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.PING_TIMEOUT, new DisconnectMessage(ReasonCode.PING_TIMEOUT).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code RANDOM_ELIMINATION}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnRandomElimination() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.RANDOM_ELIMINATION,
        new DisconnectMessage(ReasonCode.RANDOM_ELIMINATION).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code REQUESTED}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnRequested() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.REQUESTED, new DisconnectMessage(ReasonCode.REQUESTED).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code TOO_MANY_PEERS}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnTooManyPeers() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.TOO_MANY_PEERS, new DisconnectMessage(ReasonCode.TOO_MANY_PEERS).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code UNEXPECTED_IDENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnUnexpectedIdentity() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.UNEXPECTED_IDENTITY,
        new DisconnectMessage(ReasonCode.UNEXPECTED_IDENTITY).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code UNLINKABLE}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnUnlinkable() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.UNLINKABLE, new DisconnectMessage(ReasonCode.UNLINKABLE).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReason()}.
   *
   * <ul>
   *   <li>Then return {@code USER_REASON}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReason()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReason()"})
  public void testGetReason_thenReturnUserReason() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.USER_REASON, new DisconnectMessage(ReasonCode.USER_REASON).getReason());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       BAD_TX}.
   *   <li>Then return {@code BAD_TX}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_givenDisconnectMessageWithReasonCodeIsBadTx_thenReturnBadTx() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.BAD_TX, new DisconnectMessage(ReasonCode.BAD_TX).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       FORKED}.
   *   <li>Then return {@code FORKED}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_givenDisconnectMessageWithReasonCodeIsForked_thenReturnForked() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.FORKED, new DisconnectMessage(ReasonCode.FORKED).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Given {@link DisconnectMessage#DisconnectMessage(ReasonCode)} with reasonCode is {@code
   *       RESET}.
   *   <li>Then return {@code RESET}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_givenDisconnectMessageWithReasonCodeIsReset_thenReturnReset() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.RESET, new DisconnectMessage(ReasonCode.RESET).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code BAD_BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnBadBlock() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.BAD_BLOCK, new DisconnectMessage(ReasonCode.BAD_BLOCK).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code BAD_PROTOCOL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnBadProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.BAD_PROTOCOL, new DisconnectMessage(ReasonCode.BAD_PROTOCOL).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code DUPLICATE_PEER}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnDuplicatePeer() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.DUPLICATE_PEER,
        new DisconnectMessage(ReasonCode.DUPLICATE_PEER).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code FETCH_FAIL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnFetchFail() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.FETCH_FAIL, new DisconnectMessage(ReasonCode.FETCH_FAIL).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code INCOMPATIBLE_PROTOCOL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnIncompatibleProtocol() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.INCOMPATIBLE_PROTOCOL,
        new DisconnectMessage(ReasonCode.INCOMPATIBLE_PROTOCOL).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code INCOMPATIBLE_VERSION}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnIncompatibleVersion() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.INCOMPATIBLE_VERSION,
        new DisconnectMessage(ReasonCode.INCOMPATIBLE_VERSION).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code LOCAL_IDENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnLocalIdentity() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.LOCAL_IDENTITY,
        new DisconnectMessage(ReasonCode.LOCAL_IDENTITY).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code PEER_QUITING}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnPeerQuiting() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.PEER_QUITING, new DisconnectMessage(ReasonCode.PEER_QUITING).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code PING_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnPingTimeout() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.PING_TIMEOUT, new DisconnectMessage(ReasonCode.PING_TIMEOUT).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code RANDOM_ELIMINATION}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnRandomElimination() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.RANDOM_ELIMINATION,
        new DisconnectMessage(ReasonCode.RANDOM_ELIMINATION).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code REQUESTED}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnRequested() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.REQUESTED, new DisconnectMessage(ReasonCode.REQUESTED).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code SYNC_FAIL}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnSyncFail() {
    // Arrange, Act and Assert
    assertEquals(ReasonCode.SYNC_FAIL, new DisconnectMessage(ReasonCode.SYNC_FAIL).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code TOO_MANY_PEERS}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnTooManyPeers() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.TOO_MANY_PEERS,
        new DisconnectMessage(ReasonCode.TOO_MANY_PEERS).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code UNEXPECTED_IDENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnUnexpectedIdentity() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.UNEXPECTED_IDENTITY,
        new DisconnectMessage(ReasonCode.UNEXPECTED_IDENTITY).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code UNLINKABLE}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnUnlinkable() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.UNLINKABLE, new DisconnectMessage(ReasonCode.UNLINKABLE).getReasonCode());
  }

  /**
   * Test {@link DisconnectMessage#getReasonCode()}.
   *
   * <ul>
   *   <li>Then return {@code USER_REASON}.
   * </ul>
   *
   * <p>Method under test: {@link DisconnectMessage#getReasonCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReasonCode DisconnectMessage.getReasonCode()"})
  public void testGetReasonCode_thenReturnUserReason() {
    // Arrange, Act and Assert
    assertEquals(
        ReasonCode.USER_REASON, new DisconnectMessage(ReasonCode.USER_REASON).getReasonCode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DisconnectMessage#toString()}
   *   <li>{@link DisconnectMessage#getAnswerMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Class DisconnectMessage.getAnswerMessage()",
    "String DisconnectMessage.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DisconnectMessage disconnectMessage = new DisconnectMessage(ReasonCode.REQUESTED);

    // Act
    String actualToStringResult = disconnectMessage.toString();

    // Assert
    assertEquals("type: P2P_DISCONNECT\nreason: REQUESTED", actualToStringResult);
    assertNull(disconnectMessage.getAnswerMessage());
  }
}
