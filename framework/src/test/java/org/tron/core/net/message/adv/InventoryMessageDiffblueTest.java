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

public class InventoryMessageDiffblueTest {
  /**
   * Test {@link InventoryMessage#InventoryMessage(List, InventoryType)}.
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.</li>
   *   <li>Then return HashList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(List, InventoryType)"})
  public void testNewInventoryMessage_givenBlockId_thenReturnHashListSizeIsOne() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());

    // Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(hashList, InventoryType.TRX);

    // Assert
    ByteBuf sendData = actualInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertEquals(1, actualInventoryMessage.getHashList().size());
    Inventory inventory = actualInventoryMessage.getInventory();
    assertEquals(1, inventory.getIdsList().size());
    assertEquals(1, inventory.getIdsCount());
    assertEquals(34, inventory.getSerializedSize());
    assertEquals(35, sendData.capacity());
    assertEquals(35, sendData.maxCapacity());
    assertEquals(35, sendData.writerIndex());
    assertArrayEquals(
        new byte[]{'I', -54, '%', -109, -27, 'V', -98, -38, 29, 'r', -58, 'I', -8, -92, -85, 'U', 19, -101, 'C', -102,
            -9, 'n', -93, 'M', 'D', '%', -25, -67, -87, ':', -105, 'X'},
        actualInventoryMessage.getMessageId().getBytes());
    assertArrayEquals(new byte[]{18, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0}, actualInventoryMessage.getData());
    assertArrayEquals(new byte[]{6, 18, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0}, actualInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link InventoryMessage#InventoryMessage(List, InventoryType)}.
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.</li>
   *   <li>Then return HashList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(List, InventoryType)"})
  public void testNewInventoryMessage_givenBlockId_thenReturnHashListSizeIsTwo() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());
    hashList.add(new BlockId());

    // Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(hashList, InventoryType.TRX);

    // Assert
    assertTrue(actualInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(2, actualInventoryMessage.getHashList().size());
    assertEquals(68, actualInventoryMessage.getData().length);
    assertEquals(69, actualInventoryMessage.getSendBytes().length);
  }

  /**
   * Test {@link InventoryMessage#InventoryMessage(Inventory)}.
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(Protocol.Inventory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(Protocol.Inventory)"})
  public void testNewInventoryMessage_thenSendDataReturnUnpooledHeapByteBuf() {
    // Arrange
    Inventory inv = Inventory.getDefaultInstance();

    // Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(inv);

    // Assert
    assertTrue(actualInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualInventoryMessage.getAnswerMessage());
    assertEquals(MessageTypes.INVENTORY, actualInventoryMessage.getType());
    assertEquals(MessageTypes.TRX, actualInventoryMessage.getInvMessageType());
    assertEquals(InventoryType.TRX, actualInventoryMessage.getInventoryType());
    assertTrue(actualInventoryMessage.getHashList().isEmpty());
    assertSame(inv, actualInventoryMessage.getInventory());
    assertArrayEquals(new byte[]{}, actualInventoryMessage.getData());
    assertArrayEquals(new byte[]{6}, actualInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link InventoryMessage#InventoryMessage(byte[])}.
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(byte[])"})
  public void testNewInventoryMessage_thenSendDataReturnUnpooledHeapByteBuf2() throws Exception {
    // Arrange and Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(new byte[]{});

    // Assert
    assertTrue(actualInventoryMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualInventoryMessage.getAnswerMessage());
    assertEquals(MessageTypes.INVENTORY, actualInventoryMessage.getType());
    assertEquals(MessageTypes.TRX, actualInventoryMessage.getInvMessageType());
    assertEquals(InventoryType.TRX, actualInventoryMessage.getInventoryType());
    assertTrue(actualInventoryMessage.getHashList().isEmpty());
    assertArrayEquals(new byte[]{}, actualInventoryMessage.getData());
    assertArrayEquals(new byte[]{6}, actualInventoryMessage.getSendBytes());
  }

  /**
   * Test {@link InventoryMessage#InventoryMessage(List, InventoryType)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Inventory SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(List, InventoryType)"})
  public void testNewInventoryMessage_whenArrayList_thenReturnInventorySerializedSizeIsZero() {
    // Arrange and Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(new ArrayList<>(), InventoryType.TRX);

    // Assert
    ByteBuf sendData = actualInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualInventoryMessage.getInventory();
    assertEquals(0, inventory.getSerializedSize());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(inventory.getAllFields().isEmpty());
    assertEquals(inventory, inventory.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{}, actualInventoryMessage.getData());
    assertArrayEquals(new byte[]{6}, actualInventoryMessage.getSendBytes());
    assertArrayEquals(
        new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82, 'A', -28,
            'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        actualInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link InventoryMessage#InventoryMessage(List, InventoryType)}.
   * <ul>
   *   <li>When {@code BLOCK}.</li>
   *   <li>Then return Inventory TypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#InventoryMessage(List, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InventoryMessage.<init>(List, InventoryType)"})
  public void testNewInventoryMessage_whenBlock_thenReturnInventoryTypeValueIsOne() {
    // Arrange and Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(new ArrayList<>(), InventoryType.BLOCK);

    // Assert
    ByteBuf sendData = actualInventoryMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Inventory inventory = actualInventoryMessage.getInventory();
    assertEquals(1, inventory.getTypeValue());
    assertEquals(2, inventory.getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertEquals(MessageTypes.BLOCK, actualInventoryMessage.getInvMessageType());
    assertEquals(InventoryType.BLOCK, actualInventoryMessage.getInventoryType());
    assertEquals(InventoryType.BLOCK, inventory.getType());
    assertArrayEquals(new byte[]{'\b', 1}, actualInventoryMessage.getData());
    assertArrayEquals(new byte[]{6, '\b', 1}, actualInventoryMessage.getSendBytes());
    assertArrayEquals(new byte[]{-5, -115, -89, -21, '[', 27, '9', -98, 's', '!', 23, -99, -84, -98, -97, 'e', 'w', '=',
        's', '1', -31, -29, 5, 'T', -29, -111, 30, 'C', '%', -31, -17, 25},
        actualInventoryMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link InventoryMessage#getInvMessageType()}.
   * <ul>
   *   <li>Then return {@code BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getInvMessageType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageTypes InventoryMessage.getInvMessageType()"})
  public void testGetInvMessageType_thenReturnBlock() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.BLOCK,
        (new FetchInvDataMessage(new ArrayList<>(), InventoryType.BLOCK)).getInvMessageType());
  }

  /**
   * Test {@link InventoryMessage#getInvMessageType()}.
   * <ul>
   *   <li>Then return {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getInvMessageType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageTypes InventoryMessage.getInvMessageType()"})
  public void testGetInvMessageType_thenReturnTrx() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.TRX, (new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX)).getInvMessageType());
  }

  /**
   * Test {@link InventoryMessage#getInventoryType()}.
   * <ul>
   *   <li>Then return {@code BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getInventoryType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType InventoryMessage.getInventoryType()"})
  public void testGetInventoryType_thenReturnBlock() {
    // Arrange, Act and Assert
    assertEquals(InventoryType.BLOCK,
        (new FetchInvDataMessage(new ArrayList<>(), InventoryType.BLOCK)).getInventoryType());
  }

  /**
   * Test {@link InventoryMessage#getInventoryType()}.
   * <ul>
   *   <li>Then return {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getInventoryType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType InventoryMessage.getInventoryType()"})
  public void testGetInventoryType_thenReturnTrx() {
    // Arrange, Act and Assert
    assertEquals(InventoryType.TRX, (new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX)).getInventoryType());
  }

  /**
   * Test {@link InventoryMessage#toString()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String InventoryMessage.toString()"})
  public void testToString_givenArrayListAddBlockId_thenReturnAString() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());

    // Act and Assert
    assertEquals(
        "type: FETCH_INV_DATA\n"
            + "invType: TRX, size: 1, First hash: 0000000000000000000000000000000000000000000000000000000000000000",
        (new FetchInvDataMessage(hashList, InventoryType.TRX)).toString());
  }

  /**
   * Test {@link InventoryMessage#toString()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String InventoryMessage.toString()"})
  public void testToString_givenArrayListAddBlockId_thenReturnAString2() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());
    hashList.add(new BlockId());

    // Act and Assert
    assertEquals(
        "type: FETCH_INV_DATA\n"
            + "invType: TRX, size: 2, First hash: 0000000000000000000000000000000000000000000000000000000000000000,"
            + " End hash: 0000000000000000000000000000000000000000000000000000000000000000",
        (new FetchInvDataMessage(hashList, InventoryType.TRX)).toString());
  }

  /**
   * Test {@link InventoryMessage#toString()}.
   * <ul>
   *   <li>Then return {@code type: FETCH_INV_DATA invType: BLOCK, size: 0, First hash: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String InventoryMessage.toString()"})
  public void testToString_thenReturnTypeFetchInvDataInvTypeBlockSize0FirstHashNull() {
    // Arrange, Act and Assert
    assertEquals("type: FETCH_INV_DATA\ninvType: BLOCK, size: 0, First hash: null",
        (new FetchInvDataMessage(new ArrayList<>(), InventoryType.BLOCK)).toString());
  }

  /**
   * Test {@link InventoryMessage#toString()}.
   * <ul>
   *   <li>Then return {@code type: FETCH_INV_DATA invType: TRX, size: 0, First hash: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String InventoryMessage.toString()"})
  public void testToString_thenReturnTypeFetchInvDataInvTypeTrxSize0FirstHashNull() {
    // Arrange, Act and Assert
    assertEquals("type: FETCH_INV_DATA\ninvType: TRX, size: 0, First hash: null",
        (new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX)).toString());
  }

  /**
   * Test {@link InventoryMessage#toString()}.
   * <ul>
   *   <li>Then return {@code type: INVENTORY invType: TRX, size: 0, First hash: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String InventoryMessage.toString()"})
  public void testToString_thenReturnTypeInventoryInvTypeTrxSize0FirstHashNull() {
    // Arrange, Act and Assert
    assertEquals("type: INVENTORY\ninvType: TRX, size: 0, First hash: null",
        (new InventoryMessage(new ArrayList<>(), InventoryType.TRX)).toString());
  }

  /**
   * Test {@link InventoryMessage#getHashList()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getHashList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List InventoryMessage.getHashList()"})
  public void testGetHashList_givenArrayListAddBlockId_thenReturnArrayList() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockId());

    // Act and Assert
    assertEquals(hashList, (new FetchInvDataMessage(hashList, InventoryType.TRX)).getHashList());
  }

  /**
   * Test {@link InventoryMessage#getHashList()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getHashList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List InventoryMessage.getHashList()"})
  public void testGetHashList_givenArrayListAddBlockId_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    BlockId blockId = new BlockId();
    hashList.add(blockId);
    hashList.add(new BlockId());

    // Act
    List<Sha256Hash> actualHashList = (new FetchInvDataMessage(hashList, InventoryType.TRX)).getHashList();

    // Assert
    assertEquals(2, actualHashList.size());
    assertEquals(blockId, actualHashList.get(1));
    Sha256Hash getResult = actualHashList.get(0);
    assertArrayEquals(new byte[]{0}, getResult.toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        getResult.getBytes());
  }

  /**
   * Test {@link InventoryMessage#getHashList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryMessage#getHashList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List InventoryMessage.getHashList()"})
  public void testGetHashList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FetchInvDataMessage(new ArrayList<>(), InventoryType.TRX)).getHashList().isEmpty());
  }
}
