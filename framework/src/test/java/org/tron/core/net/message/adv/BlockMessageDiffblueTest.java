package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class BlockMessageDiffblueTest {
  /**
   * Method under test: {@link BlockMessage#getBlockId()}
   */
  @Test
  public void testGetBlockId() {
    // Arrange
    BlockCapsule block = new BlockCapsule(Protocol.Block.getDefaultInstance());
    BlockMessage blockMessage = new BlockMessage(block);

    // Act
    BlockCapsule.BlockId actualBlockId = blockMessage.getBlockId();

    // Assert
    BigInteger toBigIntegerResult = actualBlockId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualBlockId.getString());
    ByteString byteString = actualBlockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, actualBlockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertSame(block, blockMessage.getBlockCapsule());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualBlockId.getBytes());
  }

  /**
   * Method under test: {@link BlockMessage#getMessageId()}
   */
  @Test
  public void testGetMessageId() {
    // Arrange
    BlockCapsule block = new BlockCapsule(Protocol.Block.getDefaultInstance());
    BlockMessage blockMessage = new BlockMessage(block);

    // Act
    Sha256Hash actualMessageId = blockMessage.getMessageId();

    // Assert
    assertTrue(actualMessageId instanceof BlockCapsule.BlockId);
    BigInteger toBigIntegerResult = actualMessageId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        ((BlockCapsule.BlockId) actualMessageId).getString());
    ByteString byteString = actualMessageId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString.toStringUtf8());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0L, ((BlockCapsule.BlockId) actualMessageId).getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertSame(block, blockMessage.getBlockCapsule());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, actualMessageId.getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockMessage#equals(Object)}
   *   <li>{@link BlockMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage = new BlockMessage(block);
    BlockCapsule block2 = mock(BlockCapsule.class);
    when(block2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage2 = new BlockMessage(block2);

    // Act and Assert
    assertEquals(blockMessage, blockMessage2);
    int expectedHashCodeResult = blockMessage.hashCode();
    assertEquals(expectedHashCodeResult, blockMessage2.hashCode());
  }

  /**
   * Method under test: {@link BlockMessage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage = new BlockMessage(block);

    // Act and Assert
    assertNotEquals(blockMessage, new BlockMessage(new BlockCapsule(Protocol.Block.getDefaultInstance())));
  }

  /**
   * Method under test: {@link BlockMessage#BlockMessage(BlockCapsule)}
   */
  @Test
  public void testNewBlockMessage() {
    // Arrange
    BlockCapsule block = new BlockCapsule(Protocol.Block.getDefaultInstance());

    // Act
    BlockMessage actualBlockMessage = new BlockMessage(block);

    // Assert
    ByteBuf sendData = actualBlockMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    BlockCapsule.BlockId blockId = actualBlockMessage.getBlockId();
    BigInteger toBigIntegerResult = blockId.toBigInteger();
    assertEquals("3800201620905452580889821578709714074795303883058992822357", toBigIntegerResult.toString());
    assertEquals("Num:0,ID:00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", blockId.getString());
    ByteString byteString = blockId.getByteString();
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000���șo�$'�A�d��L���\u001bxR�U",
        byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualBlockMessage.getAnswerMessage());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualBlockMessage.getData().length);
    assertEquals(0L, blockId.getNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.BLOCK, actualBlockMessage.getType());
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
    assertSame(block, actualBlockMessage.getBlockCapsule());
    assertSame(blockId, actualBlockMessage.getMessageId());
    assertArrayEquals(new byte[]{2}, actualBlockMessage.getSendBytes());
    assertArrayEquals(new byte[]{0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28, 'd', -101, -109, 'L',
        -92, -107, -103, 27, 'x', 'R', -72, 'U'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
        'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, blockId.getBytes());
  }
}
