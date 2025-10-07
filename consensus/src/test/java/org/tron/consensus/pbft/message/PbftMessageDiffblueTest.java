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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
   *
   * <p>Method under test: {@link PbftMessage#PbftMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataString());
    assertEquals(
        "1_BLOCK_0000000000000000000000000000000000000000000000000000000000000000",
        actualFullNodePrePrepareBlockMsgResult.getDataKey());
    assertEquals(42, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(43, sendData.capacity());
    assertEquals(43, sendData.maxCapacity());
    assertEquals(43, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {
          '<', -25, -47, -15, -21, '@', -58, -17, 2, 'q', 'D', -109, -21, 7, 'k', 11, 2, '^', '~',
          ' ', -97, 'i', -61, -125, -78, '*', 'k', -98, -90, -53, '|', -5
        },
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '(', '\b', 2, 24, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4', '\n', '(', '\b', 2, 24, 1, ' ', 1, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

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
    assertEquals(
        "21469251008987621528085222773821930044677120552097884545087242222500198233156",
        toBigIntegerResult.toString());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    PBFTMessage pbftMessage = actualFullNodePrePrepareBlockMsgResult.getPbftMessage();
    assertEquals(6, pbftMessage.getRawData().getSerializedSize());
    assertEquals(8, pbftMessage.getSerializedSize());
    assertEquals(9, sendData.capacity());
    assertEquals(9, sendData.maxCapacity());
    assertEquals(9, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {'\n', 6, '\b', 2, 24, 1, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {'4', '\n', 6, '\b', 2, 24, 1, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '/', 'w', '*', 'Z', -18, -112, 'Z', '\r', -58, -43, -5, -112, 'x', 'Y', -88, -99, -17,
          -113, 'i', 'W', -88, -94, 'C', 'X', -107, -86, 'j', 31, 'R', -120, '4', 'D'
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '/', 'w', '*', 'Z', -18, -112, 'Z', '\r', -58, -43, -5, -112, 'x', 'Y', -88, -99, -17,
          -113, 'i', 'W', -88, -94, 'C', 'X', -107, -86, 'j', 31, 'R', -120, '4', 'D'
        },
        messageId.getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return No is {@code -1_BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_givenMinusOne_thenReturnNoIs1Block() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);

    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(byteString);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(-1L);
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("-1_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    assertEquals(-1L, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertEquals(17, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(18, sendData.capacity());
    assertEquals(18, sendData.maxCapacity());
    assertEquals(18, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {'\n', 15, '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {'4', '\n', 15, '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -62, 'm', 25, -61, -98, -14, -43, -25, -73, ',', 11, -105, -83, -51, '*', 'R', 'e', -2,
          -50, -101, -120, -125, 'z', -44, '\b', 23, -6, 'C', -62, 0, -59, 'V'
        },
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return No is {@code 0_BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_givenZero_thenReturnNoIs0Block() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);

    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(byteString);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(0L);
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    assertEquals("0_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    Sha256Hash messageId = actualFullNodePrePrepareBlockMsgResult.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "85848870009492566494866400042748251493265039619463615170654422681145499167970",
        toBigIntegerResult.toString());
    assertEquals(
        "�̽\u000e�\u00105�\u0012Mhf6��zne��&B��w��s��", messageId.getByteString().toStringUtf8());
    assertEquals(0L, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertEquals(
        0L, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getRawData().getViewN());
    assertArrayEquals(
        new byte[] {'\n', 4, '\b', 2, ' ', 1}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {'4', '\n', 4, '\b', 2, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -67,
          -52,
          -67,
          14,
          -80,
          16,
          '5',
          -31,
          18,
          'M',
          'h',
          'f',
          '6',
          -62,
          -113,
          Byte.MIN_VALUE,
          -107,
          'z',
          'n',
          'e',
          -97,
          -90,
          '&',
          'B',
          -114,
          -37,
          'w',
          -94,
          -63,
          's',
          -84,
          -30
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          0,
          -67,
          -52,
          -67,
          14,
          -80,
          16,
          '5',
          -31,
          18,
          'M',
          'h',
          'f',
          '6',
          -62,
          -113,
          Byte.MIN_VALUE,
          -107,
          'z',
          'n',
          'e',
          -97,
          -90,
          '&',
          'B',
          -114,
          -37,
          'w',
          -94,
          -63,
          's',
          -84,
          -30
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>Then return No is {@code 9223372036854775807_BLOCK}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareBlockMsg(BlockCapsule, long)"})
  public void testFullNodePrePrepareBlockMsg_thenReturnNoIs9223372036854775807Block() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);

    BlockId blockId = mock(BlockId.class);
    when(blockId.getByteString()).thenReturn(byteString);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);
    when(block.getNum()).thenReturn(Long.MAX_VALUE);
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 1L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareBlockMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("9223372036854775807_BLOCK", actualFullNodePrePrepareBlockMsgResult.getNo());
    assertEquals(17, sendData.capacity());
    assertEquals(17, sendData.maxCapacity());
    assertEquals(17, sendData.writerIndex());
    assertEquals(Long.MAX_VALUE, actualFullNodePrePrepareBlockMsgResult.getNumber());
    assertEquals(
        Short.SIZE, actualFullNodePrePrepareBlockMsgResult.getPbftMessage().getSerializedSize());
    assertArrayEquals(
        new byte[] {'\n', 14, '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, ' ', 1},
        actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4', '\n', 14, '\b', 2, 24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, ' ', 1
        },
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          19, -99, 'Y', -54, -11, -92, -102, ',', -26, 3, '\n', 'p', -122, -25, 'I', 'E', -25, -92,
          '-', 6, -121, 'G', -64, 'L', 28, 'V', '=', '/', 's', 15, '<', ' '
        },
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Epoch is zero.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareBlockMsg(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    PbftMessage actualFullNodePrePrepareBlockMsgResult =
        PbftMessage.fullNodePrePrepareBlockMsg(block, 0L);

    // Assert
    verify(byteString, atLeast(1)).isEmpty();
    verify(blockId).getByteString();
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).isSwitch();
    assertEquals(0L, actualFullNodePrePrepareBlockMsgResult.getEpoch());
    assertArrayEquals(
        new byte[] {'\n', 4, '\b', 2, 24, 1}, actualFullNodePrePrepareBlockMsgResult.getData());
    assertArrayEquals(
        new byte[] {'4', '\n', 4, '\b', 2, 24, 1},
        actualFullNodePrePrepareBlockMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '%', -81, 1, 31, '/', 27, -71, 29, -46, -49, -80, 'p', -57, -34, '!', 21, -61, 'g', -18,
          -48, '1', -27, -92, 'S', 25, ']', ':', -93, '-', 'U', -22, -53
        },
        actualFullNodePrePrepareBlockMsgResult.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return No is {@code 1_SRL}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareSRLMsg(BlockCapsule, List, long)"})
  public void testFullNodePrePrepareSRLMsg_givenTrue_thenReturnNoIs1Srl() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);

    ByteString byteString = mock(ByteString.class);
    when(byteString.size()).thenReturn(1);

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.size()).thenReturn(-1);

    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.size()).thenReturn(0);

    ArrayList<ByteString> currentWitness = new ArrayList<>();
    currentWitness.add(byteString3);
    currentWitness.add(byteString2);
    currentWitness.add(byteString);

    // Act
    PbftMessage actualFullNodePrePrepareSRLMsgResult =
        PbftMessage.fullNodePrePrepareSRLMsg(block, currentWitness, 1L);

    // Assert
    verify(byteString3, atLeast(1)).size();
    verify(byteString2, atLeast(1)).size();
    verify(byteString, atLeast(1)).size();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareSRLMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("1_SRL", actualFullNodePrePrepareSRLMsgResult.getNo());
    assertEquals("1_SRL_0a000affffffff0f0a01", actualFullNodePrePrepareSRLMsgResult.getDataKey());
    assertEquals(1L, actualFullNodePrePrepareSRLMsgResult.getEpoch());
    assertEquals(1L, actualFullNodePrePrepareSRLMsgResult.getNumber());
    assertEquals(22, actualFullNodePrePrepareSRLMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(23, sendData.capacity());
    assertEquals(23, sendData.maxCapacity());
    assertEquals(23, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {
          '\n', 20, '\b', 2, 16, 1, 24, 1, ' ', 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1, 15,
          '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4', '\n', 20, '\b', 2, 16, 1, 24, 1, ' ', 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1,
          15, '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -67, -18, '!', -37, 'A', '\f', -21, '<', -26, 's', 'U', -89, 19, -115, -88, 'a', -47, -86,
          -52, 31, 'E', -102, '3', -39, '>', -46, 1, -109, -57, -43, -114, -105
        },
        actualFullNodePrePrepareSRLMsgResult.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When minus one.
   *   <li>Then return No is {@code -1_SRL}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareSRLMsg(BlockCapsule, List, long)"})
  public void testFullNodePrePrepareSRLMsg_givenTrue_whenMinusOne_thenReturnNoIs1Srl() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);

    ByteString byteString = mock(ByteString.class);
    when(byteString.size()).thenReturn(1);

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.size()).thenReturn(-1);

    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.size()).thenReturn(0);

    ArrayList<ByteString> currentWitness = new ArrayList<>();
    currentWitness.add(byteString3);
    currentWitness.add(byteString2);
    currentWitness.add(byteString);

    // Act
    PbftMessage actualFullNodePrePrepareSRLMsgResult =
        PbftMessage.fullNodePrePrepareSRLMsg(block, currentWitness, -1L);

    // Assert
    verify(byteString3, atLeast(1)).size();
    verify(byteString2, atLeast(1)).size();
    verify(byteString, atLeast(1)).size();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareSRLMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("-1_SRL", actualFullNodePrePrepareSRLMsgResult.getNo());
    assertEquals("-1_SRL_0a000affffffff0f0a01", actualFullNodePrePrepareSRLMsgResult.getDataKey());
    assertEquals(-1L, actualFullNodePrePrepareSRLMsgResult.getEpoch());
    assertEquals(-1L, actualFullNodePrePrepareSRLMsgResult.getNumber());
    assertEquals(40, actualFullNodePrePrepareSRLMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(41, sendData.capacity());
    assertEquals(41, sendData.maxCapacity());
    assertEquals(41, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {
          -54, -89, -84, 'C', -72, '0', '1', -122, -50, -111, 'e', 'M', -77, 'S', '4', -2, '5', 'T',
          -21, -38, ';', ']', -122, -26, '&', 'o', -126, ')', -109, 'z', '&', 'N'
        },
        actualFullNodePrePrepareSRLMsgResult.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '&', '\b', 2, 16, 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', -1, -1, -1, -1,
          -1, -1, -1, -1, -1, 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1, 15, '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4', '\n', '&', '\b', 2, 16, 1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, ' ', -1, -1,
          -1, -1, -1, -1, -1, -1, -1, 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1, 15, '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getSendBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When zero.
   *   <li>Then return No is {@code 0_SRL}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareSRLMsg(BlockCapsule, List, long)"})
  public void testFullNodePrePrepareSRLMsg_givenTrue_whenZero_thenReturnNoIs0Srl() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);

    ByteString byteString = mock(ByteString.class);
    when(byteString.size()).thenReturn(1);

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.size()).thenReturn(-1);

    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.size()).thenReturn(0);

    ArrayList<ByteString> currentWitness = new ArrayList<>();
    currentWitness.add(byteString3);
    currentWitness.add(byteString2);
    currentWitness.add(byteString);

    // Act
    PbftMessage actualFullNodePrePrepareSRLMsgResult =
        PbftMessage.fullNodePrePrepareSRLMsg(block, currentWitness, 0L);

    // Assert
    verify(byteString3, atLeast(1)).size();
    verify(byteString2, atLeast(1)).size();
    verify(byteString, atLeast(1)).size();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareSRLMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("0_SRL", actualFullNodePrePrepareSRLMsgResult.getNo());
    assertEquals("0_SRL_0a000affffffff0f0a01", actualFullNodePrePrepareSRLMsgResult.getDataKey());
    assertEquals(0L, actualFullNodePrePrepareSRLMsgResult.getEpoch());
    assertEquals(0L, actualFullNodePrePrepareSRLMsgResult.getNumber());
    assertEquals(18, actualFullNodePrePrepareSRLMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(19, sendData.capacity());
    assertEquals(19, sendData.maxCapacity());
    assertEquals(19, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {
          '\n', 16, '\b', 2, 16, 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1, 15, '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4', '\n', 16, '\b', 2, 16, 1, '*', '\n', '\n', 0, '\n', -1, -1, -1, -1, 15, '\n', 1
        },
        actualFullNodePrePrepareSRLMsgResult.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '3',
          -80,
          -74,
          3,
          -89,
          -18,
          '<',
          -66,
          23,
          -61,
          17,
          -95,
          22,
          -22,
          'X',
          -34,
          -63,
          -124,
          'z',
          -111,
          -121,
          0,
          3,
          -49,
          'd',
          's',
          'r',
          -27,
          -127,
          '6',
          Byte.MIN_VALUE,
          -98
        },
        actualFullNodePrePrepareSRLMsgResult.getMessageId().getBytes());
  }

  /**
   * Test {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return No is {@code 9223372036854775807_SRL}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessage#fullNodePrePrepareSRLMsg(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PbftMessage PbftMessage.fullNodePrePrepareSRLMsg(BlockCapsule, List, long)"})
  public void testFullNodePrePrepareSRLMsg_whenMax_value_thenReturnNoIs9223372036854775807Srl() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.isSwitch()).thenReturn(true);

    ByteString byteString = mock(ByteString.class);
    when(byteString.size()).thenReturn(1);

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.size()).thenReturn(-1);

    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.size()).thenReturn(0);

    ArrayList<ByteString> currentWitness = new ArrayList<>();
    currentWitness.add(byteString3);
    currentWitness.add(byteString2);
    currentWitness.add(byteString);

    // Act
    PbftMessage actualFullNodePrePrepareSRLMsgResult =
        PbftMessage.fullNodePrePrepareSRLMsg(block, currentWitness, Long.MAX_VALUE);

    // Assert
    verify(byteString3, atLeast(1)).size();
    verify(byteString2, atLeast(1)).size();
    verify(byteString, atLeast(1)).size();
    verify(block).isSwitch();
    ByteBuf sendData = actualFullNodePrePrepareSRLMsgResult.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals("9223372036854775807_SRL", actualFullNodePrePrepareSRLMsgResult.getNo());
    assertEquals(
        "9223372036854775807_SRL_0a000affffffff0f0a01",
        actualFullNodePrePrepareSRLMsgResult.getDataKey());
    assertEquals(38, actualFullNodePrePrepareSRLMsgResult.getPbftMessage().getSerializedSize());
    assertEquals(39, sendData.capacity());
    assertEquals(39, sendData.maxCapacity());
    assertEquals(39, sendData.writerIndex());
    assertEquals(Long.MAX_VALUE, actualFullNodePrePrepareSRLMsgResult.getEpoch());
    assertEquals(Long.MAX_VALUE, actualFullNodePrePrepareSRLMsgResult.getNumber());
    assertArrayEquals(
        new byte[] {
          'm', 24, -47, 4, '`', 'E', 'U', -97, -37, 4, -17, 'Z', -89, 'v', -101, '_', '\\', -11, 11,
          -4, -9, 24, -34, -73, -109, -57, -42, 'D', -29, '(', -74, -100
        },
        actualFullNodePrePrepareSRLMsgResult.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n',
          '$',
          '\b',
          2,
          16,
          1,
          24,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE,
          ' ',
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE,
          '*',
          '\n',
          '\n',
          0,
          '\n',
          -1,
          -1,
          -1,
          -1,
          15,
          '\n',
          1
        },
        actualFullNodePrePrepareSRLMsgResult.getData());
    assertArrayEquals(
        new byte[] {
          '4',
          '\n',
          '$',
          '\b',
          2,
          16,
          1,
          24,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE,
          ' ',
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE,
          '*',
          '\n',
          '\n',
          0,
          '\n',
          -1,
          -1,
          -1,
          -1,
          15,
          '\n',
          1
        },
        actualFullNodePrePrepareSRLMsgResult.getSendBytes());
  }
}
