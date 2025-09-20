package org.tron.core.net.message.pbft;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.PbftSignCapsule;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTCommitResult;

public class PbftCommitMessageDiffblueTest {
  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(PbftSignCapsule)"})
  public void testNewPbftCommitMessage() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.size()).thenReturn(3);
    when(data.isEmpty()).thenReturn(true);
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(data, new ArrayList<>());

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(pbftSignCapsule);

    // Assert
    verify(data, atLeast(1)).isEmpty();
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    assertEquals(
        "��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", messageId.getByteString().toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualPbftCommitMessage.getPBFTCommitResult().getSerializedSize());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertArrayEquals(new byte[] {}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[] {}, actualPbftCommitMessage.getPbftSignCapsule().getData());
    assertArrayEquals(new byte[] {20}, actualPbftCommitMessage.getSendBytes());
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
   * Test {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(PbftSignCapsule)"})
  public void testNewPbftCommitMessage2() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.size()).thenReturn(0);
    when(data.isEmpty()).thenReturn(false);
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(data, new ArrayList<>());

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(pbftSignCapsule);

    // Assert
    verify(data, atLeast(1)).isEmpty();
    verify(data, atLeast(1)).size();
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "7313544042625969693652647544284131139450332464251605647944075309827545716228",
        toBigIntegerResult.toString());
    assertEquals(
        "\u0010+Q�vZV����\u000e�RQ��\u0003�W�0����{\u0015V\u0004",
        messageId.getByteString().toStringUtf8());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertEquals(2, actualPbftCommitMessage.getPBFTCommitResult().getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertArrayEquals(new byte[] {'\n', 0}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[] {'\n', 0}, actualPbftCommitMessage.getPbftSignCapsule().getData());
    assertArrayEquals(new byte[] {20, '\n', 0}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          16, '+', 'Q', -71, 'v', 'Z', 'V', -93, -24, -103, -9, -49, 14, -29, -114, 'R', 'Q', -7,
          -59, 3, -77, 'W', -77, '0', -92, -111, -125, -21, '{', 21, 'V', 4
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          16, '+', 'Q', -71, 'v', 'Z', 'V', -93, -24, -103, -9, -49, 14, -29, -114, 'R', 'Q', -7,
          -59, 3, -77, 'W', -77, '0', -92, -111, -125, -21, '{', 21, 'V', 4
        },
        messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage3() throws UnsupportedEncodingException {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage =
        new PbftCommitMessage("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "27814841491300551620637839695245580487413248989291079516140212605229874411388",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("=~�sf7\u0003��W��'jR�HD�����\u0001�ٰ�p=�|", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('=', iteratorResult.next().byteValue());
    assertEquals('~', iteratorResult.next().byteValue());
    assertArrayEquals(
        "A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"), actualPbftCommitMessage.getData());
    assertArrayEquals(
        new byte[] {
          20, 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
        },
        actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '=', '~', -92, 's', 'f', '7', 3, -118, -67, 'W', -34, -20, '\'', 'j', 'R', -121, 'H', 'D',
          -32, -116, -40, -2, -113, 1, -30, -39, -80, -14, 'p', '=', -9, '|'
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '=', '~', -92, 's', 'f', '7', 3, -118, -67, 'W', -34, -20, '\'', 'j', 'R', -121, 'H', 'D',
          -32, -116, -40, -2, -113, 1, -30, -39, -80, -14, 'p', '=', -9, '|'
        },
        messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage4() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage =
        new PbftCommitMessage(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "10109112538131138963270889445860316441852476481186449711178364366494370681744",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals(
        "\u0016Y�\u0010\u000bU�\u001ff�rn�#S3\u001dBk,\t\u0003�A��__K�Ӑ",
        byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 22, iteratorResult.next().byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertTrue(iteratorResult.hasNext());
    assertEquals('Y', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getData());
    assertArrayEquals(
        new byte[] {20, 18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
          'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
          'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112
        },
        messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage5() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage =
        new PbftCommitMessage(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    assertEquals("'+\fz��1\u001b>R�6�p\u0002v;�R=tN�Q�\u0011n�zG��", byteString.toStringUtf8());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "17716261653332058702551037193821777919710228588426908374632522673751065071800",
        toBigIntegerResult.toString());
    assertEquals(3, toBigIntegerResult.getLowestSetBit());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\'', iteratorResult.next().byteValue());
    assertEquals('+', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getData());
    assertArrayEquals(
        new byte[] {20, 0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
          'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
          'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72
        },
        messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage6() throws UnsupportedEncodingException {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage =
        new PbftCommitMessage("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "62017759947867326790397937317822928385036747986258009767931877639769525601817",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("�\u001c��>-�:��\u001e�\u0014��*�m��&/���8�*`F\u0019", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -119, iteratorResult.next().byteValue());
    assertEquals((byte) 28, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(
        "\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"), actualPbftCommitMessage.getData());
    assertArrayEquals(
        new byte[] {
          20, '\n', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A',
          '\n'
        },
        actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -119, 28, -50, -26, -127, '>', '-', -55, ':', -18, -35, 30, -116, 20, -68, -37, '*', -82,
          'm', -103, -84, '&', '/', -97, -32, -108, '8', -51, '*', '`', 'F', 25
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -119, 28, -50, -26, -127, '>', '-', -55, ':', -18, -35, 30, -116, 20, -68, -37, '*',
          -82, 'm', -103, -84, '&', '/', -97, -32, -108, '8', -51, '*', '`', 'F', 25
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <ul>
   *   <li>Then return Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage_thenReturnDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPbftCommitMessage.getData());
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\\', iteratorResult.next().byteValue());
    assertEquals('[', iteratorResult.next().byteValue());
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
    assertArrayEquals(
        new byte[] {20, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualPbftCommitMessage.getSendBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage_thenSendDataReturnUnpooledHeapByteBuf() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(new byte[] {});

    // Assert
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    PBFTCommitResult pBFTCommitResult = actualPbftCommitMessage.getPBFTCommitResult();
    assertEquals("", pBFTCommitResult.getInitializationErrorString());
    assertEquals(0, pBFTCommitResult.getSerializedSize());
    assertEquals(0, pBFTCommitResult.getSignatureCount());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(pBFTCommitResult.findInitializationErrors().isEmpty());
    assertTrue(pBFTCommitResult.getSignatureList().isEmpty());
    assertTrue(pBFTCommitResult.getAllFields().isEmpty());
    assertTrue(pBFTCommitResult.isInitialized());
    PBFTCommitResult actualDefaultInstanceForType = pBFTCommitResult.getDefaultInstanceForType();
    assertEquals(pBFTCommitResult, actualDefaultInstanceForType);
    PbftSignCapsule pbftSignCapsule = actualPbftCommitMessage.getPbftSignCapsule();
    assertSame(pBFTCommitResult, pbftSignCapsule.getInstance());
    assertSame(pBFTCommitResult, pbftSignCapsule.getPbftCommitResult());
    assertArrayEquals(new byte[] {}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[] {}, pbftSignCapsule.getData());
    assertArrayEquals(new byte[] {20}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualPbftCommitMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return Data is array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage_whenLf_thenReturnDataIsArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage =
        new PbftCommitMessage(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertArrayEquals(
        new byte[] {
          18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
        },
        actualPbftCommitMessage.getData());
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) -98, iteratorResult.next().byteValue());
    assertEquals((byte) -28, iteratorResult.next().byteValue());
    assertEquals("��\u0002�`_\u0007����H$Շcǰ�5�d��9iR�3��\u001f", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          -98, -28, 2, -75, '`', '_', 7, -97, -79, -93, -25, 'H', '$', -43, -121, 'c', -57, -80,
          -65, '5', -58, 'd', -112, -47, '9', 'i', 'R', -123, '3', -71, -46, 31
        },
        messageId.getBytes());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertArrayEquals(
        new byte[] {
          0, -98, -28, 2, -75, '`', '_', 7, -97, -79, -93, -25, 'H', '$', -43, -121, 'c', -57, -80,
          -65, '5', -58, 'd', -112, -47, '9', 'i', 'R', -123, '3', -71, -46, 31
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "71868289900317674309922667353229887372050334972135325732825308464016273297951",
        toBigIntegerResult.toString());
    assertArrayEquals(
        new byte[] {
          20, 18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
        },
        actualPbftCommitMessage.getSendBytes());
  }

  /**
   * Test {@link PbftCommitMessage#getPBFTCommitResult()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PbftCommitMessage#getPBFTCommitResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftCommitMessage.getPBFTCommitResult()"})
  public void testGetPBFTCommitResult_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(new byte[] {});

    // Act
    PBFTCommitResult actualPBFTCommitResult =
        new PbftCommitMessage(pbftSignCapsule).getPBFTCommitResult();

    // Assert
    assertEquals("", actualPBFTCommitResult.getInitializationErrorString());
    assertEquals(0, actualPBFTCommitResult.getSerializedSize());
    assertEquals(0, actualPBFTCommitResult.getSignatureCount());
    assertTrue(actualPBFTCommitResult.findInitializationErrors().isEmpty());
    assertTrue(actualPBFTCommitResult.getSignatureList().isEmpty());
    assertTrue(actualPBFTCommitResult.getAllFields().isEmpty());
    assertTrue(actualPBFTCommitResult.isInitialized());
    PBFTCommitResult actualDefaultInstanceForType =
        actualPBFTCommitResult.getDefaultInstanceForType();
    assertEquals(actualPBFTCommitResult, actualDefaultInstanceForType);
  }
}
