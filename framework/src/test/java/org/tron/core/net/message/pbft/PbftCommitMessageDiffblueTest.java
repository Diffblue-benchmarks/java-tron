package org.tron.core.net.message.pbft;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.PbftSignCapsule;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class PbftCommitMessageDiffblueTest {
  /**
   * Method under test: {@link PbftCommitMessage#getPBFTCommitResult()}
   */
  @Test
  public void testGetPBFTCommitResult() throws UnsupportedEncodingException {
    // Arrange
    PbftSignCapsule pbftSignCapsule = mock(PbftSignCapsule.class);
    when(pbftSignCapsule.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Protocol.PBFTCommitResult defaultInstance = Protocol.PBFTCommitResult.getDefaultInstance();
    when(pbftSignCapsule.getPbftCommitResult()).thenReturn(defaultInstance);

    // Act
    Protocol.PBFTCommitResult actualPBFTCommitResult = (new PbftCommitMessage(pbftSignCapsule)).getPBFTCommitResult();

    // Assert
    verify(pbftSignCapsule).getData();
    verify(pbftSignCapsule).getPbftCommitResult();
    assertSame(defaultInstance, actualPBFTCommitResult);
  }

  /**
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  public void testNewPbftCommitMessage() {
    // Arrange
    byte[] data = new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(data);

    // Assert
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("10109112538131138963270889445860316441852476481186449711178364366494370681744",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("\u0016Y�\u0010\u000bU�\u001ff�rn�#S3\u001dBk,\t\u0003�A��__K�Ӑ", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualPbftCommitMessage.getAnswerMessage());
    PbftSignCapsule pbftSignCapsule = actualPbftCommitMessage.getPbftSignCapsule();
    assertNull(pbftSignCapsule.getInstance());
    assertNull(pbftSignCapsule.getPbftCommitResult());
    assertNull(actualPbftCommitMessage.getPBFTCommitResult());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 22, iteratorResult.next().byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertEquals(MessageTypes.PBFT_COMMIT_MSG, actualPbftCommitMessage.getType());
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
    assertEquals('Y', iteratorResult.next().byteValue());
    assertSame(data, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, 18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
        'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{22, 'Y', -114, 16, 11, 'U', -126, 31, 'f', -20, 'r', 'n', -53, '#', 'S', '3', 29, 'B',
        'k', ',', '\t', 3, -123, 'A', -107, -123, '_', '_', 'K', -20, -45, -112}, messageId.getBytes());
  }

  /**
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  public void testNewPbftCommitMessage2() {
    // Arrange
    byte[] data = new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(data);

    // Assert
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    ByteString byteString = messageId.getByteString();
    assertEquals("'+\fz��1\u001b>R�6�p\u0002v;�R=tN�Q�\u0011n�zG��", byteString.toStringUtf8());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("17716261653332058702551037193821777919710228588426908374632522673751065071800",
        toBigIntegerResult.toString());
    assertNull(sendData.unwrap());
    assertNull(actualPbftCommitMessage.getAnswerMessage());
    PbftSignCapsule pbftSignCapsule = actualPbftCommitMessage.getPbftSignCapsule();
    assertNull(pbftSignCapsule.getInstance());
    assertNull(pbftSignCapsule.getPbftCommitResult());
    assertNull(actualPbftCommitMessage.getPBFTCommitResult());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(3, toBigIntegerResult.getLowestSetBit());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertEquals(MessageTypes.PBFT_COMMIT_MSG, actualPbftCommitMessage.getType());
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
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('\'', iteratorResult.next().byteValue());
    assertEquals('+', iteratorResult.next().byteValue());
    assertSame(data, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, 0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{'\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
        'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'\'', '+', '\f', 'z', -22, -46, '1', 27, '>', 'R', -99, '6', -54, 'p', 2, 'v', ';', -3,
        'R', '=', 't', 'N', -87, 'Q', -1, 17, 'n', -98, 'z', 'G', -112, -72}, messageId.getBytes());
  }

  /**
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  public void testNewPbftCommitMessage3() {
    // Arrange
    byte[] data = new byte[]{};

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(data);

    // Assert
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualPbftCommitMessage.getAnswerMessage());
    byte[] toByteArrayResult = toBigIntegerResult.toByteArray();
    assertEquals((byte) -101, toByteArrayResult[22]);
    assertEquals((byte) -102, toByteArrayResult[9]);
    assertEquals((byte) -103, toByteArrayResult[13]);
    assertEquals((byte) -103, toByteArrayResult[27]);
    assertEquals((byte) -104, toByteArrayResult[5]);
    assertEquals((byte) -107, toByteArrayResult[26]);
    assertEquals((byte) -109, toByteArrayResult[23]);
    assertEquals((byte) -12, toByteArrayResult[11]);
    assertEquals((byte) -28, toByteArrayResult[20]);
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -29, toByteArrayResult[1]);
    assertEquals((byte) -4, toByteArrayResult[6]);
    assertEquals((byte) -56, toByteArrayResult[12]);
    assertEquals((byte) -5, toByteArrayResult[10]);
    assertEquals((byte) -60, toByteArrayResult[3]);
    assertEquals((byte) -71, toByteArrayResult[15]);
    assertEquals((byte) -72, toByteArrayResult[31]);
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals((byte) -80, toByteArrayResult[2]);
    assertEquals((byte) -82, toByteArrayResult[18]);
    assertEquals((byte) -92, toByteArrayResult[25]);
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    byte[] data2 = actualPbftCommitMessage.getData();
    assertEquals(0, data2.length);
    assertEquals((byte) 0, toByteArrayResult[0]);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals((byte) 20, toByteArrayResult[8]);
    assertEquals((byte) 27, toByteArrayResult[28]);
    assertEquals((byte) 28, toByteArrayResult[7]);
    assertEquals(33, toByteArrayResult.length);
    assertEquals(MessageTypes.PBFT_COMMIT_MSG, actualPbftCommitMessage.getType());
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
    assertEquals('$', toByteArrayResult[Short.SIZE]);
    assertEquals('\'', toByteArrayResult[17]);
    assertEquals('A', toByteArrayResult[19]);
    assertEquals('B', toByteArrayResult[4]);
    assertEquals('L', toByteArrayResult[24]);
    assertEquals('R', toByteArrayResult[30]);
    assertEquals('d', toByteArrayResult[21]);
    assertEquals('o', toByteArrayResult[14]);
    assertEquals('x', toByteArrayResult[29]);
    assertSame(data, data2);
    assertArrayEquals(new byte[]{20}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
  }

  /**
   * Method under test: {@link PbftCommitMessage#PbftCommitMessage(byte[])}
   */
  @Test
  public void testNewPbftCommitMessage4() {
    // Arrange
    byte[] data = new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    PbftCommitMessage actualPbftCommitMessage = new PbftCommitMessage(data);

    // Assert
    ByteBuf sendData = actualPbftCommitMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualPbftCommitMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("99182231635367035906374262725925497861204924188231249344207799420611367497768",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("�G'\\5D�k�f:\u0012�C�ȟ�L>��1~\u0015%l��p(", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualPbftCommitMessage.getAnswerMessage());
    PbftSignCapsule pbftSignCapsule = actualPbftCommitMessage.getPbftSignCapsule();
    assertNull(pbftSignCapsule.getInstance());
    assertNull(pbftSignCapsule.getPbftCommitResult());
    assertNull(actualPbftCommitMessage.getPBFTCommitResult());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -37, iteratorResult.next().byteValue());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(3, toBigIntegerResult.getLowestSetBit());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertEquals(MessageTypes.PBFT_COMMIT_MSG, actualPbftCommitMessage.getType());
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
    assertEquals('G', iteratorResult.next().byteValue());
    assertSame(data, actualPbftCommitMessage.getData());
    assertArrayEquals(new byte[]{20, '\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, actualPbftCommitMessage.getSendBytes());
    assertArrayEquals(new byte[]{-37, 'G', '\'', '\\', '5', 'D', -77, 'k', -16, -82, 'f', ':', 18, -43, 'C', -127, -56,
        -97, -70, 'L', '>', -76, -117, '1', '~', 21, '%', 'l', -16, -117, 'p', '('}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -37, 'G', '\'', '\\', '5', 'D', -77, 'k', -16, -82, 'f', ':', 18, -43, 'C', -127,
        -56, -97, -70, 'L', '>', -76, -117, '1', '~', 21, '%', 'l', -16, -117, 'p', '('},
        toBigIntegerResult.toByteArray());
  }
}
