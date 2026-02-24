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
import org.tron.protos.Protocol.BlockInventory;
import org.tron.protos.Protocol.BlockInventory.Type;

public class BlockInventoryMessageDiffblueTest {
  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());

    // Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(blockIds, Type.SYNC);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualBlockInventoryMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals(
        "8961938729206494575310499200803321321964078422434039244376876812436164334265",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("\u0013�G\u000e��\\\u001a�s�W;$U|��U��ܾ�<� B�R�", byteString.toStringUtf8());
    List<BlockId> blockIds2 = actualBlockInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(36, actualBlockInventoryMessage.blockInventory.getSerializedSize());
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
        actualBlockInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          18, '\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualBlockInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>Then return BlockIds size is two.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_givenBlockId_thenReturnBlockIdsSizeIsTwo() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockId());
    blockIds.add(new BlockId());

    // Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(blockIds, Type.SYNC);

    // Assert
    assertTrue(actualBlockInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualBlockInventoryMessage.getBlockIds().size());
    assertEquals(72, actualBlockInventoryMessage.getData().length);
    assertEquals(73, actualBlockInventoryMessage.getSendBytes().length);
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} SerializedSize is forty-seven.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_thenReturnBlockInventorySerializedSizeIsFortySeven() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    BlockId blockId = new BlockId(new BlockId(), -1L);
    blockIds.add(blockId);

    // Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(blockIds, Type.SYNC);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    List<BlockId> blockIds2 = actualBlockInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(47, actualBlockInventoryMessage.blockInventory.getSerializedSize());
    assertEquals(48, sendData.capacity());
    assertEquals(48, sendData.maxCapacity());
    assertEquals(48, sendData.writerIndex());
    assertEquals(blockId, blockIds2.get(0));
    assertArrayEquals(
        new byte[] {
          -48, -48, -81, -10, 'w', '5', 'l', '0', 'i', '6', 'z', '0', '&', -88, 6, -97, 'j', 'Q',
          -79, -4, '@', -49, 'C', -108, -30, -66, -57, '^', 16, 'o', '>', -60
        },
        actualBlockInventoryMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '-', '\n', ' ', -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1
        },
        actualBlockInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          18, '\n', '-', '\n', ' ', -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1
        },
        actualBlockInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} SerializedSize is forty-six.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_thenReturnBlockInventorySerializedSizeIsFortySix() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    BlockId blockId = new BlockId(new BlockId(), Long.MAX_VALUE);
    blockIds.add(blockId);

    // Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(blockIds, Type.SYNC);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    List<BlockId> blockIds2 = actualBlockInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(46, actualBlockInventoryMessage.blockInventory.getSerializedSize());
    assertEquals(47, sendData.capacity());
    assertEquals(47, sendData.maxCapacity());
    assertEquals(47, sendData.writerIndex());
    assertEquals(blockId, blockIds2.get(0));
    assertArrayEquals(
        new byte[] {
          '<', -119, 3, -5, -96, '&', '[', 'i', 'l', -6, '8', -15, -7, -36, '5', '#', -101, '*',
          '#', '$', '_', 'z', 'r', -93, 'c', '"', -96, -58, 'U', 16, -91, -36
        },
        actualBlockInventoryMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n',
          ',',
          '\n',
          ' ',
          Byte.MAX_VALUE,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          16,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE
        },
        actualBlockInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          18,
          '\n',
          ',',
          '\n',
          ' ',
          Byte.MAX_VALUE,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          0,
          16,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE
        },
        actualBlockInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} SerializedSize is thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_thenReturnBlockInventorySerializedSizeIsThirtyEight() {
    // Arrange
    ArrayList<BlockId> blockIds = new ArrayList<>();
    BlockId blockId = new BlockId(new BlockId(), 1L);
    blockIds.add(blockId);

    // Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(blockIds, Type.SYNC);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    List<BlockId> blockIds2 = actualBlockInventoryMessage.getBlockIds();
    assertEquals(1, blockIds2.size());
    assertEquals(38, actualBlockInventoryMessage.blockInventory.getSerializedSize());
    assertEquals(39, sendData.capacity());
    assertEquals(39, sendData.maxCapacity());
    assertEquals(39, sendData.writerIndex());
    assertEquals(blockId, blockIds2.get(0));
    assertArrayEquals(
        new byte[] {
          2, 'C', -43, -78, 'M', '\b', -93, 20, -53, -112, 'w', -34, -115, 'r', '-', 'f', -65, -21,
          'J', -87, -79, 'p', 'c', -9, -77, '\'', '\r', 'r', -24, -31, 'B', ')'
        },
        actualBlockInventoryMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          '\n', '$', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualBlockInventoryMessage.getData());
    assertArrayEquals(
        new byte[] {
          18, '\n', '$', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 1
        },
        actualBlockInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_thenReturnBlockInventorySerializedSizeIsZero() {
    // Arrange and Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(new ArrayList<>(), Type.SYNC);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    BlockInventory blockInventory = actualBlockInventoryMessage.blockInventory;
    assertEquals(0, blockInventory.getSerializedSize());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(blockInventory.getAllFields().isEmpty());
    assertEquals(
        actualBlockInventoryMessage.blockInventory, blockInventory.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {}, actualBlockInventoryMessage.getData());
    assertArrayEquals(new byte[] {18}, actualBlockInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualBlockInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(byte[])}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(byte[])"})
  public void testNewBlockInventoryMessage_thenSendDataReturnUnpooledHeapByteBuf()
      throws Exception {
    // Arrange and Act
    BlockInventoryMessage actualBlockInventoryMessage = new BlockInventoryMessage(new byte[] {});

    // Assert
    assertTrue(actualBlockInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualBlockInventoryMessage.getAnswerMessage());
    assertEquals(MessageTypes.BLOCK_INVENTORY, actualBlockInventoryMessage.getType());
    assertTrue(actualBlockInventoryMessage.getBlockIds().isEmpty());
    assertArrayEquals(new byte[] {}, actualBlockInventoryMessage.getData());
    assertArrayEquals(new byte[] {18}, actualBlockInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#BlockInventoryMessage(List, Type)}.
   *
   * <ul>
   *   <li>When {@code ADVTISE}.
   *   <li>Then return {@link BlockInventoryMessage#blockInventory} TypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#BlockInventoryMessage(List,
   * BlockInventory.Type)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockInventoryMessage.<init>(List, BlockInventory.Type)"})
  public void testNewBlockInventoryMessage_whenAdvtise_thenReturnBlockInventoryTypeValueIsOne() {
    // Arrange and Act
    BlockInventoryMessage actualBlockInventoryMessage =
        new BlockInventoryMessage(new ArrayList<>(), Type.ADVTISE);

    // Assert
    ByteBuf sendData = actualBlockInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    BlockInventory blockInventory = actualBlockInventoryMessage.blockInventory;
    assertEquals(1, blockInventory.getTypeValue());
    assertEquals(2, blockInventory.getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertEquals(Type.ADVTISE, blockInventory.getType());
    assertArrayEquals(new byte[] {16, 1}, actualBlockInventoryMessage.getData());
    assertArrayEquals(new byte[] {18, 16, 1}, actualBlockInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '\'', -62, 'O', -53, -124, 't', 'w', '>', '*', -9, -103, -48, -124, -124, -107, -1, 5,
          '2', 'r', -45, '<', 'C', '-', -62, 'b', 'w', -103, '=', -12, '\\', -110, 'v'
        },
        actualBlockInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link BlockInventoryMessage#getBlockIds()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BlockInventoryMessage#getBlockIds()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BlockInventoryMessage.getBlockIds()"})
  public void testGetBlockIds_thenReturnEmpty() throws Exception {
    // Arrange
    BlockInventoryMessage blockInventoryMessage = new BlockInventoryMessage(new byte[] {});

    // Act and Assert
    assertTrue(blockInventoryMessage.getBlockIds().isEmpty());
  }
}
