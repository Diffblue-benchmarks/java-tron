package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

public class FetchInvDataMessageDiffblueTest {
  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>Then return HashList size is one.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(List, InventoryType)"})
  public void testNewFetchInvDataMessage_givenBlockId_thenReturnHashListSizeIsOne() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());

    // Act
    FetchInvDataMessage actualFetchInvDataMessage =
        new FetchInvDataMessage(hashList, InventoryType.TRX);

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(1, actualFetchInvDataMessage.getHashList().size());
    Inventory inventory = actualFetchInvDataMessage.getInventory();
    assertEquals(1, inventory.getIdsList().size());
    assertEquals(1, inventory.getIdsCount());
    assertEquals(34, inventory.getSerializedSize());
    assertEquals(35, sendData.capacity());
    assertEquals(35, sendData.maxCapacity());
    assertEquals(35, sendData.writerIndex());
    assertArrayEquals(
        new byte[] {
          'I', -54, '%', -109, -27, 'V', -98, -38, 29, 'r', -58, 'I', -8, -92, -85, 'U', 19, -101,
          'C', -102, -9, 'n', -93, 'M', 'D', '%', -25, -67, -87, ':', -105, 'X'
        },
        actualFetchInvDataMessage.getMessageId().getBytes());
    assertArrayEquals(
        new byte[] {
          18, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualFetchInvDataMessage.getData());
    assertArrayEquals(
        new byte[] {
          7, 18, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0
        },
        actualFetchInvDataMessage.getSendBytes());
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>Then return HashList size is two.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(List, InventoryType)"})
  public void testNewFetchInvDataMessage_givenBlockId_thenReturnHashListSizeIsTwo() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());
    hashList.add(new BlockId());

    // Act
    FetchInvDataMessage actualFetchInvDataMessage =
        new FetchInvDataMessage(hashList, InventoryType.TRX);

    // Assert
    assertTrue(actualFetchInvDataMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualFetchInvDataMessage.getHashList().size());
    assertEquals(68, actualFetchInvDataMessage.getData().length);
    assertEquals(69, actualFetchInvDataMessage.getSendBytes().length);
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(byte[])}.
   *
   * <ul>
   *   <li>Then return Inventory AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(byte[])"})
  public void testNewFetchInvDataMessage_thenReturnInventoryAllFieldsSizeIsOne() throws Exception {
    // Arrange and Act
    FetchInvDataMessage actualFetchInvDataMessage =
        new FetchInvDataMessage(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
            });

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualFetchInvDataMessage.getInventory();
    assertEquals(1, inventory.getAllFields().size());
    assertEquals(1151, inventory.getTypeValue());
    assertEquals(12, inventory.getSerializedSize());
    assertEquals(17, sendData.capacity());
    assertEquals(17, sendData.maxCapacity());
    assertEquals(17, sendData.writerIndex());
    assertEquals(InventoryType.UNRECOGNIZED, actualFetchInvDataMessage.getInventoryType());
    assertEquals(InventoryType.UNRECOGNIZED, inventory.getType());
    assertArrayEquals(
        new byte[] {
          'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualFetchInvDataMessage.getData());
    assertArrayEquals(
        new byte[] {
          7, 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1, '\b'
        },
        actualFetchInvDataMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -40, '=', -103, '7', -110, -123, '!', '3', '&', -44, 'I', -47, -45, -80, 's', 'M', -79,
          -89, '"', 'N', 16, 'G', -16, -74, 'l', -61, -17, -20, '"', -99, -124, 's'
        },
        actualFetchInvDataMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(byte[])}.
   *
   * <ul>
   *   <li>Then return Inventory SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(byte[])"})
  public void testNewFetchInvDataMessage_thenReturnInventorySerializedSizeIsZero()
      throws Exception {
    // Arrange and Act
    FetchInvDataMessage actualFetchInvDataMessage = new FetchInvDataMessage(new byte[] {});

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualFetchInvDataMessage.getInventory();
    assertEquals(0, inventory.getSerializedSize());
    assertEquals(0, inventory.getTypeValue());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(InventoryType.TRX, actualFetchInvDataMessage.getInventoryType());
    assertEquals(InventoryType.TRX, inventory.getType());
    assertTrue(inventory.getAllFields().isEmpty());
    Inventory actualDefaultInstanceForType = inventory.getDefaultInstanceForType();
    assertEquals(inventory, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualFetchInvDataMessage.getData());
    assertArrayEquals(new byte[] {7}, actualFetchInvDataMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualFetchInvDataMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(Inventory)}.
   *
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(Protocol.Inventory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(Protocol.Inventory)"})
  public void testNewFetchInvDataMessage_thenSendDataReturnUnpooledHeapByteBuf() {
    // Arrange
    Inventory inv = Inventory.getDefaultInstance();

    // Act
    FetchInvDataMessage actualFetchInvDataMessage = new FetchInvDataMessage(inv);

    // Assert
    assertTrue(actualFetchInvDataMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualFetchInvDataMessage.getAnswerMessage());
    assertEquals(MessageTypes.FETCH_INV_DATA, actualFetchInvDataMessage.getType());
    assertEquals(MessageTypes.TRX, actualFetchInvDataMessage.getInvMessageType());
    assertEquals(InventoryType.TRX, actualFetchInvDataMessage.getInventoryType());
    assertTrue(actualFetchInvDataMessage.getHashList().isEmpty());
    assertSame(inv, actualFetchInvDataMessage.getInventory());
    assertArrayEquals(new byte[] {}, actualFetchInvDataMessage.getData());
    assertArrayEquals(new byte[] {7}, actualFetchInvDataMessage.getSendBytes());
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Inventory SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(List, InventoryType)"})
  public void testNewFetchInvDataMessage_whenArrayList_thenReturnInventorySerializedSizeIsZero() {
    // Arrange and Act
    FetchInvDataMessage actualFetchInvDataMessage =
        new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX);

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualFetchInvDataMessage.getInventory();
    assertEquals(0, inventory.getSerializedSize());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(inventory.getAllFields().isEmpty());
    Inventory actualDefaultInstanceForType = inventory.getDefaultInstanceForType();
    assertEquals(inventory, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualFetchInvDataMessage.getData());
    assertArrayEquals(new byte[] {7}, actualFetchInvDataMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualFetchInvDataMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}.
   *
   * <ul>
   *   <li>When {@code BLOCK}.
   *   <li>Then return Inventory TypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FetchInvDataMessage#FetchInvDataMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchInvDataMessage.<init>(List, InventoryType)"})
  public void testNewFetchInvDataMessage_whenBlock_thenReturnInventoryTypeValueIsOne() {
    // Arrange and Act
    FetchInvDataMessage actualFetchInvDataMessage =
        new FetchInvDataMessage(new ArrayList<>(), InventoryType.BLOCK);

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualFetchInvDataMessage.getInventory();
    assertEquals(1, inventory.getTypeValue());
    assertEquals(2, inventory.getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertEquals(MessageTypes.BLOCK, actualFetchInvDataMessage.getInvMessageType());
    assertEquals(InventoryType.BLOCK, actualFetchInvDataMessage.getInventoryType());
    assertEquals(InventoryType.BLOCK, inventory.getType());
    assertArrayEquals(new byte[] {'\b', 1}, actualFetchInvDataMessage.getData());
    assertArrayEquals(new byte[] {7, '\b', 1}, actualFetchInvDataMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -5, -115, -89, -21, '[', 27, '9', -98, 's', '!', 23, -99, -84, -98, -97, 'e', 'w', '=',
          's', '1', -31, -29, 5, 'T', -29, -111, 30, 'C', '%', -31, -17, 25
        },
        actualFetchInvDataMessage.getMessageId().getBytes());
  }
}
