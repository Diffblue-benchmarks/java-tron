package org.tron.core.net.message.sync;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.tron.protos.Protocol.BlockInventory;

public class SyncBlockChainMessageDiffblueTest {
  /**
   * Test {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}.
   *
   * <p>Method under test: {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncBlockChainMessage.<init>(List)"})
  public void testNewSyncBlockChainMessage() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());

    // Act
    SyncBlockChainMessage actualSyncBlockChainMessage = new SyncBlockChainMessage(blockIds);

    // Assert
    ByteBuf sendData = actualSyncBlockChainMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualSyncBlockChainMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "8961938729206494575310499200803321321964078422434039244376876812436164334265",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("\u0013�G\u000e��\\\u001a�s�W;$U|��U��ܾ�<� B�R�", byteString.toStringUtf8());
    List<BlockId> blockIds2 = actualSyncBlockChainMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(36, actualSyncBlockChainMessage.blockInventory.getSerializedSize());
    assertEquals(37, sendData.capacity());
    assertEquals(37, sendData.maxCapacity());
    assertEquals(37, sendData.writerIndex());
    assertTrue(byteString.iterator().hasNext());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        blockIds2.get(0).getBytes());
    assertArrayEquals(
        new byte[] {
          19, -48, 'G', 14, -112, -121, '\\', 26, -55, 's', -26, -103, 'W', ';', '$', 'U', '|', -87,
          -30, 'U', -19, -50, -36, -66, -60, '<', -56, ' ', 'B', -104, 'R', -71
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          19, -48, 'G', 14, -112, -121, '\\', 26, -55, 's', -26, -103, 'W', ';', '$', 'U', '|', -87,
          -30, 'U', -19, -50, -36, -66, -60, '<', -56, ' ', 'B', -104, 'R', -71
        },
        messageId.getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualSyncBlockChainMessage.getData());
    assertArrayEquals(
        new byte[] {
          '\b', '\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualSyncBlockChainMessage.getSendBytes());
  }

  /**
   * Test {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>Then return BlockIds size is two.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncBlockChainMessage.<init>(List)"})
  public void testNewSyncBlockChainMessage_givenBlockId_thenReturnBlockIdsSizeIsTwo() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());
    blockIds.add(new BlockId());

    // Act
    SyncBlockChainMessage actualSyncBlockChainMessage = new SyncBlockChainMessage(blockIds);

    // Assert
    assertTrue(actualSyncBlockChainMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualSyncBlockChainMessage.getBlockIds().size());
    assertEquals(72, actualSyncBlockChainMessage.getData().length);
    assertEquals(73, actualSyncBlockChainMessage.getSendBytes().length);
  }

  /**
   * Test {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} IdsCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncBlockChainMessage.<init>(List)"})
  public void testNewSyncBlockChainMessage_thenReturnBlockInventoryIdsCountIsZero() {
    // Arrange and Act
    SyncBlockChainMessage actualSyncBlockChainMessage =
        new SyncBlockChainMessage(new ArrayList<>());

    // Assert
    ByteBuf sendData = actualSyncBlockChainMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    BlockInventory blockInventory = actualSyncBlockChainMessage.blockInventory;
    assertEquals(0, blockInventory.getIdsCount());
    assertEquals(0, blockInventory.getSerializedSize());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(actualSyncBlockChainMessage.getBlockIds().isEmpty());
    assertTrue(blockInventory.getIdsList().isEmpty());
    assertTrue(blockInventory.getAllFields().isEmpty());
    assertEquals(
        actualSyncBlockChainMessage.blockInventory, blockInventory.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {}, actualSyncBlockChainMessage.getData());
    assertArrayEquals(new byte[] {'\b'}, actualSyncBlockChainMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualSyncBlockChainMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} IdsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#SyncBlockChainMessage(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncBlockChainMessage.<init>(List)"})
  public void testNewSyncBlockChainMessage_thenReturnBlockInventoryIdsListSizeIsOne() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    BlockId blockId = new BlockId(new BlockId(), 1L);
    blockIds.add(blockId);

    // Act
    SyncBlockChainMessage actualSyncBlockChainMessage = new SyncBlockChainMessage(blockIds);

    // Assert
    ByteBuf sendData = actualSyncBlockChainMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    List<BlockId> blockIds2 = actualSyncBlockChainMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    BlockInventory blockInventory = actualSyncBlockChainMessage.blockInventory;
    assertEquals(1, blockInventory.getIdsList().size());
    assertEquals(38, blockInventory.getSerializedSize());
    assertEquals(39, sendData.capacity());
    assertEquals(39, sendData.maxCapacity());
    assertEquals(39, sendData.writerIndex());
    assertEquals(blockId, blockIds2.get(0));
    assertArrayEquals(
        new byte[] {
          2, 'C', -43, -78, 'M', '\b', -93, 20, -53, -112, 'w', -34, -115, 'r', '-', 'f', -65, -21,
          'J', -87, -79, 'p', 'c', -9, -77, '\'', '\r', 'r', -24, -31, 'B', ')'
        },
        actualSyncBlockChainMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '$', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualSyncBlockChainMessage.getData());
    assertArrayEquals(
        new byte[] {
          '\b', '\n', '$', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualSyncBlockChainMessage.getSendBytes());
  }

  /**
   * Test {@link SyncBlockChainMessage#SyncBlockChainMessage(byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#SyncBlockChainMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SyncBlockChainMessage.<init>(byte[])"})
  public void testNewSyncBlockChainMessage_thenSendDataReturnUnpooledHeapByteBuf()
      throws Exception {
    // Arrange and Act
    SyncBlockChainMessage actualSyncBlockChainMessage = new SyncBlockChainMessage(new byte[] {});

    // Assert
    assertTrue(actualSyncBlockChainMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(MessageTypes.SYNC_BLOCK_CHAIN, actualSyncBlockChainMessage.getType());
    assertTrue(actualSyncBlockChainMessage.getBlockIds().isEmpty());
    Class<ChainInventoryMessage> expectedAnswerMessage = ChainInventoryMessage.class;
    assertEquals(expectedAnswerMessage, actualSyncBlockChainMessage.getAnswerMessage());
    assertArrayEquals(new byte[] {}, actualSyncBlockChainMessage.getData());
    assertArrayEquals(new byte[] {'\b'}, actualSyncBlockChainMessage.getSendBytes());
  }

  /**
   * Test {@link SyncBlockChainMessage#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SyncBlockChainMessage.toString()"})
  public void testToString_givenArrayListAddBlockId_thenReturnAString() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());

    // Act and Assert
    assertEquals(
        "type: SYNC_BLOCK_CHAIN\n"
            + "size: 1, start block: Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        new SyncBlockChainMessage(blockIds).toString());
  }

  /**
   * Test {@link SyncBlockChainMessage#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SyncBlockChainMessage.toString()"})
  public void testToString_givenArrayListAddBlockId_thenReturnAString2() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());
    blockIds.add(new BlockId());

    // Act and Assert
    assertEquals(
        "type: SYNC_BLOCK_CHAIN\n"
            + "size: 2, start block: Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000, end"
            + " block Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        new SyncBlockChainMessage(blockIds).toString());
  }

  /**
   * Test {@link SyncBlockChainMessage#toString()}.
   *
   * <ul>
   *   <li>Then return {@code type: SYNC_BLOCK_CHAIN size: 0}.
   * </ul>
   *
   * <p>Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SyncBlockChainMessage.toString()"})
  public void testToString_thenReturnTypeSyncBlockChainSize0() {
    // Arrange, Act and Assert
    assertEquals(
        "type: SYNC_BLOCK_CHAIN\nsize: 0", new SyncBlockChainMessage(new ArrayList<>()).toString());
  }

  /**
   * Test {@link SyncBlockChainMessage#getAnswerMessage()}.
   *
   * <p>Method under test: {@link SyncBlockChainMessage#getAnswerMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class SyncBlockChainMessage.getAnswerMessage()"})
  public void testGetAnswerMessage() {
    // Arrange and Act
    Class<?> actualAnswerMessage = new SyncBlockChainMessage(new ArrayList<>()).getAnswerMessage();

    // Assert
    Class<ChainInventoryMessage> expectedAnswerMessage = ChainInventoryMessage.class;
    assertEquals(expectedAnswerMessage, actualAnswerMessage);
  }
}
