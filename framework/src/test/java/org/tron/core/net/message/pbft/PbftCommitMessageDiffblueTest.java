package org.tron.core.net.message.pbft;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.PbftSignCapsule;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTCommitResult;

public class PbftCommitMessageDiffblueTest {
  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   * <p>
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(
        new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("10109112538131138963270889445860316441852476481186449711178364366494370681744",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("\u0016Y�\u0010\u000bU�\u001ff�rn�#S3\u001dBk,\t\u0003�A��__K�Ӑ", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 22, iteratorResult.next().byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertTrue(iteratorResult.hasNext());
    assertEquals('Y', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, 18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
        'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
        'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112}, messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   * <p>
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage2() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    assertEquals("'+\fz��1\u001b>R�6�p\u0002v;�R=tN�Q�\u0011n�zG��", byteString.toStringUtf8());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("17716261653332058702551037193821777919710228588426908374632522673751065071800",
        toBigIntegerResult.toString());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\'', iteratorResult.next().byteValue());
    assertEquals('+', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, 0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{'\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
        'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
        'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72}, messageId.getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   * <p>
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage3() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("99182231635367035906374262725925497861204924188231249344207799420611367497768",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("�G'\\5D�k�f:\u0012�C�ȟ�L>��1~\u0015%l��p(", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -37, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertEquals('G', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, '\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{-37, 'G', '\'', '\\', '5', 'D', -77, 'k', -16, -82, 'f', ':', 18, -43, 'C', -127, -56,
        -97, -70, 'L', '>', -76, -117, '1', '~', 21, '%', 'l', -16, -117, 'p', '('}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -37, 'G', '\'', '\\', '5', 'D', -77, 'k', -16, -82, 'f', ':', 18, -43, 'C', -127,
        -56, -97, -70, 'L', '>', -76, -117, '1', '~', 21, '%', 'l', -16, -117, 'p', '('},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}.
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(PbftSignCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(PbftSignCapsule)"})
  public void testNewPbftCommitMessage_thenSendDataReturnUnpooledHeapByteBuf() {
    // Arrange
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(new byte[]{});

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(pbftSignCapsule);

    // Assert
    assertTrue(actualPbftCommitMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualPbftCommitMessage.getAnswerMessage());
    assertEquals(MessageTypes.PBFT_COMMIT_MSG, actualPbftCommitMessage.getType());
    assertSame(pbftSignCapsule, actualPbftCommitMessage.getPbftSignCapsule());
    assertArrayEquals(new byte[]{}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20}, actualPbftCommitMessage.getSendBytes());
  }

  /**
   * Test {@link PbftCommitMessage#PbftCommitMessage(byte[])}.
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftCommitMessage.<init>(byte[])"})
  public void testNewPbftCommitMessage_thenSendDataReturnUnpooledHeapByteBuf2() {
    // Arrange and Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(new byte[]{});

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
    assertEquals(pBFTCommitResult, pBFTCommitResult.getDefaultInstanceForType());
    PbftSignCapsule pbftSignCapsule = actualPbftCommitMessage.getPbftSignCapsule();
    assertSame(pBFTCommitResult, pbftSignCapsule.getInstance());
    assertSame(pBFTCommitResult, pbftSignCapsule.getPbftCommitResult());
    assertArrayEquals(new byte[]{}, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{}, pbftSignCapsule.getData());
    assertArrayEquals(new byte[]{20}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        actualPbftCommitMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftCommitMessage#getPBFTCommitResult()}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftCommitMessage#getPBFTCommitResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftCommitMessage.getPBFTCommitResult()"})
  public void testGetPBFTCommitResult_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    PBFTCommitResult actualPBFTCommitResult = (new PbftCommitMessage(new PbftSignCapsule(new byte[]{})))
        .getPBFTCommitResult();

    // Assert
    assertEquals("", actualPBFTCommitResult.getInitializationErrorString());
    assertEquals(0, actualPBFTCommitResult.getSerializedSize());
    assertEquals(0, actualPBFTCommitResult.getSignatureCount());
    assertTrue(actualPBFTCommitResult.findInitializationErrors().isEmpty());
    assertTrue(actualPBFTCommitResult.getSignatureList().isEmpty());
    assertTrue(actualPBFTCommitResult.getAllFields().isEmpty());
    assertTrue(actualPBFTCommitResult.isInitialized());
    assertEquals(actualPBFTCommitResult, actualPBFTCommitResult.getDefaultInstanceForType());
  }
}
