package org.tron.core.net.message.sync;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ChainInventory;

public class ChainInventoryMessageDiffblueTest {
  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());

    // Act
    ChainInventoryMessage actualChainInventoryMessage = new ChainInventoryMessage(blockIds, 1L);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualChainInventoryMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "32963036005062014189731242060698727671555359852037768251696305966095079293463",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("H�j���\\ߑXu�U�IK��.93��(�5~�C�\u0017", byteString.toStringUtf8());
    List<BlockId> blockIds2 = actualChainInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(38, actualChainInventoryMessage.chainInventory.getSerializedSize());
    assertEquals(39, sendData.capacity());
    assertEquals(39, sendData.maxCapacity());
    assertEquals(39, sendData.writerIndex());
    assertTrue(byteString.iterator().hasNext());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        blockIds2.get(0).getBytes());
    assertArrayEquals(
        new byte[] {
          'H',
          -32,
          'j',
          -50,
          -13,
          -4,
          '\\',
          -33,
          -111,
          Byte.MAX_VALUE,
          'X',
          'u',
          -106,
          'U',
          -28,
          'I',
          'K',
          -14,
          -25,
          '.',
          '9',
          '3',
          -40,
          -20,
          '(',
          -49,
          '5',
          '~',
          -63,
          'C',
          -62,
          23
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          'H',
          -32,
          'j',
          -50,
          -13,
          -4,
          '\\',
          -33,
          -111,
          Byte.MAX_VALUE,
          'X',
          'u',
          -106,
          'U',
          -28,
          'I',
          'K',
          -14,
          -25,
          '.',
          '9',
          '3',
          -40,
          -20,
          '(',
          -49,
          '5',
          '~',
          -63,
          'C',
          -62,
          23
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualChainInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          '\t', '\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualChainInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>Then return BlockIds size is two.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_givenBlockId_thenReturnBlockIdsSizeIsTwo() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());
    blockIds.add(new BlockId());

    // Act
    ChainInventoryMessage actualChainInventoryMessage = new ChainInventoryMessage(blockIds, 1L);

    // Assert
    assertTrue(actualChainInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualChainInventoryMessage.getBlockIds().size());
    assertEquals(74, actualChainInventoryMessage.getData().length);
    assertEquals(75, actualChainInventoryMessage.getSendBytes().length);
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>Then return {@link ChainInventoryMessage#chainInventory} IdsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_thenReturnChainInventoryIdsListSizeIsOne() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    BlockId blockId = new BlockId(new BlockId(), -1L);
    blockIds.add(blockId);

    // Act
    ChainInventoryMessage actualChainInventoryMessage = new ChainInventoryMessage(blockIds, 1L);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    List<BlockId> blockIds2 = actualChainInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    ChainInventory chainInventory = actualChainInventoryMessage.chainInventory;
    assertEquals(1, chainInventory.getIdsList().size());
    assertEquals(49, chainInventory.getSerializedSize());
    assertEquals(50, sendData.capacity());
    assertEquals(50, sendData.maxCapacity());
    assertEquals(50, sendData.writerIndex());
    assertEquals(blockId, blockIds2.get(0));
    assertArrayEquals(
        new byte[] {
          Byte.MAX_VALUE,
          -21,
          -100,
          -9,
          -111,
          -22,
          -107,
          'q',
          -100,
          ',',
          -72,
          26,
          '"',
          23,
          -106,
          '|',
          Byte.MAX_VALUE,
          'm',
          '5',
          5,
          'A',
          -109,
          -59,
          16,
          -123,
          '4',
          -74,
          'l',
          -22,
          '%',
          -83,
          -32
        },
        actualChainInventoryMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '-', '\n', ' ', -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, 1
        },
        actualChainInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          '\t', '\n', '-', '\n', ' ', -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, 1
        },
        actualChainInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>Then return {@link ChainInventoryMessage#chainInventory} SerializedSize is ten.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_thenReturnChainInventorySerializedSizeIsTen() {
    // Arrange and Act
    ChainInventoryMessage actualChainInventoryMessage =
        new ChainInventoryMessage(new ArrayList<>(), Long.MAX_VALUE);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    ChainInventory chainInventory = actualChainInventoryMessage.chainInventory;
    assertEquals(10, chainInventory.getSerializedSize());
    assertEquals(11, sendData.capacity());
    assertEquals(11, sendData.maxCapacity());
    assertEquals(11, sendData.writerIndex());
    assertEquals(Long.MAX_VALUE, actualChainInventoryMessage.getRemainNum().longValue());
    assertEquals(Long.MAX_VALUE, chainInventory.getRemainNum());
    assertArrayEquals(
        new byte[] {16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        actualChainInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {'\t', 16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        actualChainInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '[', -11, 'q', ';', '>', -11, -3, -52, '[', -52, '\f', '6', -110, 'r', -101, 23, '>', 24,
          '9', -96, 'H', 27, '%', -75, -99, -16, -1, -71, 'P', -24, -79, 3
        },
        actualChainInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>Then return {@link ChainInventoryMessage#chainInventory} SerializedSize is two.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_thenReturnChainInventorySerializedSizeIsTwo() {
    // Arrange and Act
    ChainInventoryMessage actualChainInventoryMessage =
        new ChainInventoryMessage(new ArrayList<>(), 1L);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualChainInventoryMessage.chainInventory.getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertArrayEquals(new byte[] {16, 1}, actualChainInventoryMessage.getData());
    assertArrayEquals(new byte[] {'\t', 16, 1}, actualChainInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '\'', -62, 'O', -53, -124, 't', 'w', '>', '*', -9, -103, -48, -124, -124, -107, -1, 5,
          '2', 'r', -45, '<', 'C', '-', -62, 'b', 'w', -103, '=', -12, '\\', -110, 'v'
        },
        actualChainInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>Then return {@link ChainInventoryMessage#chainInventory} SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_thenReturnChainInventorySerializedSizeIsZero() {
    // Arrange and Act
    ChainInventoryMessage actualChainInventoryMessage =
        new ChainInventoryMessage(new ArrayList<>(), 0L);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    ChainInventory chainInventory = actualChainInventoryMessage.chainInventory;
    assertEquals(0, chainInventory.getSerializedSize());
    assertEquals(0L, actualChainInventoryMessage.getRemainNum().longValue());
    assertEquals(0L, chainInventory.getRemainNum());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(chainInventory.getAllFields().isEmpty());
    assertEquals(
        actualChainInventoryMessage.chainInventory, chainInventory.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {}, actualChainInventoryMessage.getData());
    assertArrayEquals(new byte[] {'\t'}, actualChainInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualChainInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(byte[])"})
  public void testNewChainInventoryMessage_thenSendDataReturnUnpooledHeapByteBuf()
      throws Exception {
    // Arrange and Act
    ChainInventoryMessage actualChainInventoryMessage = new ChainInventoryMessage(new byte[] {});

    // Assert
    assertTrue(actualChainInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualChainInventoryMessage.getAnswerMessage());
    assertEquals(0L, actualChainInventoryMessage.getRemainNum().longValue());
    assertEquals(MessageTypes.BLOCK_CHAIN_INVENTORY, actualChainInventoryMessage.getType());
    assertTrue(actualChainInventoryMessage.getBlockIds().isEmpty());
    assertArrayEquals(new byte[] {}, actualChainInventoryMessage.getData());
    assertArrayEquals(new byte[] {'\t'}, actualChainInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return RemainNum longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#ChainInventoryMessage(List, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMessage.<init>(List, Long)"})
  public void testNewChainInventoryMessage_whenMinusOne_thenReturnRemainNumLongValueIsMinusOne() {
    // Arrange and Act
    ChainInventoryMessage actualChainInventoryMessage =
        new ChainInventoryMessage(new ArrayList<>(), -1L);

    // Assert
    ByteBuf sendData = actualChainInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(-1L, actualChainInventoryMessage.getRemainNum().longValue());
    ChainInventory chainInventory = actualChainInventoryMessage.chainInventory;
    assertEquals(-1L, chainInventory.getRemainNum());
    assertEquals(11, chainInventory.getSerializedSize());
    assertEquals(12, sendData.capacity());
    assertEquals(12, sendData.maxCapacity());
    assertEquals(12, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualChainInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {'\t', 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        actualChainInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          'y', -119, -39, 'H', -62, -39, '.', -71, -88, '*', 't', 'G', 'j', -73, '|', -56, -104, 15,
          '#', -35, '=', -52, -105, '>', -7, -89, '`', -120, ':', ':', '>', 'o'
        },
        actualChainInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link ChainInventoryMessage#getBlockIds()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#getBlockIds()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChainInventoryMessage.getBlockIds()"})
  public void testGetBlockIds_thenReturnEmpty() throws Exception {
    // Arrange
    ChainInventoryMessage chainInventoryMessage = new ChainInventoryMessage(new byte[] {});

    // Act and Assert
    assertTrue(chainInventoryMessage.getBlockIds().isEmpty());
  }

  /**
   * Test {@link ChainInventoryMessage#getRemainNum()}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#getRemainNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ChainInventoryMessage.getRemainNum()"})
  public void testGetRemainNum_thenReturnLongValueIsZero() throws Exception {
    // Arrange
    ChainInventoryMessage chainInventoryMessage = new ChainInventoryMessage(new byte[] {});

    // Act and Assert
    assertEquals(0L, chainInventoryMessage.getRemainNum().longValue());
  }

  /**
   * Test {@link ChainInventoryMessage#toString()}.
   *
   * <ul>
   *   <li>Then return {@code type: BLOCK_CHAIN_INVENTORY size: 0, remain_num: 0}.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMessage#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ChainInventoryMessage.toString()"})
  public void testToString_thenReturnTypeBlockChainInventorySize0RemainNum0() throws Exception {
    // Arrange
    ChainInventoryMessage chainInventoryMessage = new ChainInventoryMessage(new byte[] {});

    // Act and Assert
    assertEquals(
        "type: BLOCK_CHAIN_INVENTORY\nsize: 0, remain_num: 0", chainInventoryMessage.toString());
  }
}
