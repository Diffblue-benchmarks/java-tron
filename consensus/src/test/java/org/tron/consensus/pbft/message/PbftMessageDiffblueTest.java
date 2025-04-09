package org.tron.consensus.pbft.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTMessage;

public class PbftMessageDiffblueTest {
  /**
   * Test {@link PbftMessage#PbftMessage()}.
   * <p>
   * Method under test: {@link PbftMessage#PbftMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessage.<init>()"})
  public void testNewPbftMessage() {
    // Arrange and Act
    PbftMessage actualPbftMessage = new PbftMessage();

    // Assert
    assertNull(actualPbftMessage.getData());
    assertNull(actualPbftMessage.getPublicKey());
    assertNull(actualPbftMessage.getPbftMessage());
    assertFalse(actualPbftMessage.isSwitch());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("1_BLOCK_0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataKey());
    Sha256Hash messageId = actualFullNodePrePrepareBlockMsgResult.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("27548361574068452382717000686053265716799474787895719134948477245045934357755",
        toBigIntegerResult.toString());
    assertEquals("<����@��\u0002qD��\u0007k\u000b\u0002^~ �iÃ�*k���|�", messageId.getByteString().toStringUtf8());
    PBFTMessage pbftMessage = actualFullNodePrePrepareBlockMsgResult.getPbftMessage();
    assertEquals(40, pbftMessage.getRawData().getSerializedSize());
    assertEquals(42, pbftMessage.getSerializedSize());
    assertEquals(43, sendData.capacity());
    assertEquals(43, sendData.maxCapacity());
    assertEquals(43, sendData.writerIndex());
    assertArrayEquals(new byte[]{'<', -25, -47, -15, -21, '@', -58, -17, 2, 'q', 'D', -109, -21, 7, 'k', 11, 2, '^',
        '~', ' ', -97, 'i', -61, -125, -78, '*', 'k', -98, -90, -53, '|', -5}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'<', -25, -47, -15, -21, '@', -58, -17, 2, 'q', 'D', -109, -21, 7, 'k', 11, 2, '^',
        '~', ' ', -97, 'i', -61, -125, -78, '*', 'k', -98, -90, -53, '|', -5}, messageId.getBytes());
    assertArrayEquals(new byte[]{'\n', '(', '\b', 2, 24, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(new byte[]{'4', '\n', '(', '\b', 2, 24, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg2() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(byteString);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualFullNodePrePrepareBlockMsgResult.getMessageId();
    assertEquals("/w*Z�Z\r����xY���iW��CX��j\u001fR�4D", messageId.getByteString().toStringUtf8());
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("21469251008987621528085222773821930044677120552097884545087242222500198233156",
        toBigIntegerResult.toString());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    PBFTMessage pbftMessage = actualFullNodePrePrepareBlockMsgResult.getPbftMessage();
    assertEquals(6, pbftMessage.getRawData().getSerializedSize());
    assertEquals(8, pbftMessage.getSerializedSize());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertArrayEquals(new byte[]{'\n', 6, '\b', 2, 24, 1, ' ', 1}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(new byte[]{'4', '\n', 6, '\b', 2, 24, 1, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(new byte[]{'/', 'w', '*', 'Z', -18, -112, 'Z', '\r', -58, -43, -5, -112, 'x', 'Y', -88, -99, -17,
        -113, 'i', 'W', -88, -94, 'C', 'X', -107, -86, 'j', 31, 'R', -120, '4', 'D'}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'/', 'w', '*', 'Z', -18, -112, 'Z', '\r', -58, -43, -5, -112, 'x', 'Y', -88, -99, -17,
        -113, 'i', 'W', -88, -94, 'C', 'X', -107, -86, 'j', 31, 'R', -120, '4', 'D'}, messageId.getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return No is {@code -1_BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_givenMinusOne_thenReturnNoIs1Block() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(-1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("-1_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    assertEquals("-1_BLOCK_0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataKey());
    assertEquals(-1L, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertEquals(51, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(52, sendData.capacity());
    assertEquals(52, sendData.maxCapacity());
    assertEquals(52, sendData.writerIndex());
    assertArrayEquals(
        new byte[]{'m', 'Q', '+', -19, ']', -107, 'R', -104, 'H', 'k', '\n', -98, 'B', -75, -49, -19, -27, -113, -39,
            '-', 'u', '5', -70, -63, -17, 'd', '`', -116, '4', 30, -126, -90},
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
    assertArrayEquals(
        new byte[]{'\n', '1', '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[]{'4', '\n', '1', '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return No is {@code 0_BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_givenZero_thenReturnNoIs0Block() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(0L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("0_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    assertEquals("0_BLOCK_0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataKey());
    assertEquals(0L, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertEquals(40, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(41, sendData.capacity());
    assertEquals(41, sendData.maxCapacity());
    assertEquals(41, sendData.writerIndex());
    assertArrayEquals(
        new byte[]{'(', 'X', -92, -12, '%', 26, '%', 1, 'h', 19, '<', 'Q', 'x', -40, -98, 'n', -83, -118, -81, 'b', -10,
            '}', -13, -126, '\'', 'v', -124, -7, -17, '[', -25, -14},
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
    assertArrayEquals(new byte[]{'\n', '&', '\b', 2, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(new byte[]{'4', '\n', '&', '\b', 2, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, actualFullNodePrePrepareBlockMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <ul>
   *   <li>Then return No is {@code 9223372036854775807_BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_thenReturnNoIs9223372036854775807Block() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(Long.MAX_VALUE);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("9223372036854775807_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    assertEquals("9223372036854775807_BLOCK_0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataKey());
    assertEquals(50, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(51, sendData.capacity());
    assertEquals(51, sendData.maxCapacity());
    assertEquals(51, sendData.writerIndex());
    assertEquals(Long.MAX_VALUE, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertArrayEquals(
        new byte[]{-8, 'a', -15, -4, -60, 'R', '(', -70, -16, -45, -89, -97, -94, -57, -46, 'e', -123, '\b', -83, -97,
            'j', -47, 'r', 'u', -93, '\f', -61, '[', -105, 'T', -68, -8},
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
    assertArrayEquals(
        new byte[]{'\n', '0', '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, ' ', 1, '*', ' ', 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[]{'4', '\n', '0', '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, ' ', 1, '*', ' ', 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Epoch is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_whenZero_thenReturnEpochIsZero() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);
    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(byteString);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult = PbftMessage.fullNodePrePrepareBlockMsg(block, 0L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(0L, actualFullNodePrePrepareBlockMsgResult.getEpoch());
    assertEquals(6, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(7, sendData.capacity());
    assertEquals(7, sendData.maxCapacity());
    assertEquals(7, sendData.writerIndex());
    assertArrayEquals(new byte[]{'\n', 4, '\b', 2, 24, 1}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(new byte[]{'4', '\n', 4, '\b', 2, 24, 1}, actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[]{'%', -81, 1, 31, '/', 27, -71, 29, -46, -49, -80, 'p', -57, -34, '!', 21, -61, 'g', -18, -48, '1',
            -27, -92, 'S', 25, ']', ':', -93, '-', 'U', -22, -53},
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
  }
}
