package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class InventoryMessageDiffblueTest {
  /**
   * Method under test: {@link InventoryMessage#getInvMessageType()}
   */
  @Test
  public void testGetInvMessageType() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.TRX, (new InventoryMessage(Protocol.Inventory.getDefaultInstance())).getInvMessageType());
    assertEquals(MessageTypes.BLOCK,
        (new FetchInvDataMessage(new ArrayList<>(), Protocol.Inventory.InventoryType.BLOCK)).getInvMessageType());
  }

  /**
   * Method under test: {@link InventoryMessage#getInventoryType()}
   */
  @Test
  public void testGetInventoryType() {
    // Arrange, Act and Assert
    assertEquals(Protocol.Inventory.InventoryType.TRX,
        (new InventoryMessage(Protocol.Inventory.getDefaultInstance())).getInventoryType());
    assertEquals(Protocol.Inventory.InventoryType.BLOCK,
        (new FetchInvDataMessage(new ArrayList<>(), Protocol.Inventory.InventoryType.BLOCK)).getInventoryType());
  }

  /**
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("type: INVENTORY\ninvType: TRX, size: 0, First hash: null",
        (new InventoryMessage(Protocol.Inventory.getDefaultInstance())).toString());
    assertEquals("type: FETCH_INV_DATA\ninvType: TRX, size: 0, First hash: null",
        (new FetchInvDataMessage(Protocol.Inventory.getDefaultInstance())).toString());
    assertEquals("type: INVENTORY\ninvType: BLOCK, size: 0, First hash: null",
        (new InventoryMessage(new ArrayList<>(), Protocol.Inventory.InventoryType.BLOCK)).toString());
  }

  /**
   * Method under test: {@link InventoryMessage#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(new BlockCapsule.BlockId());

    // Act and Assert
    assertEquals("type: INVENTORY\n"
        + "invType: BLOCK, size: 1, First hash: 000000000000000000000000000000000000000000000000000000" + "0000000000",
        (new InventoryMessage(hashList, Protocol.Inventory.InventoryType.BLOCK)).toString());
  }

  /**
   * Method under test: {@link InventoryMessage#getHashList()}
   */
  @Test
  public void testGetHashList() {
    // Arrange, Act and Assert
    assertTrue((new InventoryMessage(Protocol.Inventory.getDefaultInstance())).getHashList().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryMessage#getAnswerMessage()}
   *   <li>{@link InventoryMessage#getInventory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Protocol.Inventory inv = Protocol.Inventory.getDefaultInstance();
    InventoryMessage inventoryMessage = new InventoryMessage(inv);

    // Act
    Class<?> actualAnswerMessage = inventoryMessage.getAnswerMessage();

    // Assert
    assertNull(actualAnswerMessage);
    assertSame(inv, inventoryMessage.getInventory());
  }

  /**
   * Method under test:
   * {@link InventoryMessage#InventoryMessage(Protocol.Inventory)}
   */
  @Test
  public void testNewInventoryMessage() {
    // Arrange
    Protocol.Inventory inv = Protocol.Inventory.getDefaultInstance();

    // Act
    InventoryMessage actualInventoryMessage = new InventoryMessage(inv);

    // Assert
    ByteBuf sendData = actualInventoryMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualInventoryMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualInventoryMessage.getAnswerMessage());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualInventoryMessage.getData().length);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.INVENTORY, actualInventoryMessage.getType());
    assertEquals(MessageTypes.TRX, actualInventoryMessage.getInvMessageType());
    assertEquals(Protocol.Inventory.InventoryType.TRX, actualInventoryMessage.getInventoryType());
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
    assertTrue(actualInventoryMessage.getHashList().isEmpty());
    assertSame(inv, actualInventoryMessage.getInventory());
    assertArrayEquals(new byte[]{6}, actualInventoryMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }
}
