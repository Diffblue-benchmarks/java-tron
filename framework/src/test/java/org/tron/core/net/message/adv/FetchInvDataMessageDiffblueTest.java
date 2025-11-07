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
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class FetchInvDataMessageDiffblueTest {
  /**
   * Method under test:
   * {@link FetchInvDataMessage#FetchInvDataMessage(Protocol.Inventory)}
   */
  @Test
  public void testNewFetchInvDataMessage() {
    // Arrange
    Protocol.Inventory inv = Protocol.Inventory.getDefaultInstance();

    // Act
    FetchInvDataMessage actualFetchInvDataMessage = new FetchInvDataMessage(inv);

    // Assert
    ByteBuf sendData = actualFetchInvDataMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualFetchInvDataMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualFetchInvDataMessage.getAnswerMessage());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualFetchInvDataMessage.getData().length);
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.FETCH_INV_DATA, actualFetchInvDataMessage.getType());
    assertEquals(MessageTypes.TRX, actualFetchInvDataMessage.getInvMessageType());
    assertEquals(Protocol.Inventory.InventoryType.TRX, actualFetchInvDataMessage.getInventoryType());
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
    assertTrue(actualFetchInvDataMessage.getHashList().isEmpty());
    assertSame(inv, actualFetchInvDataMessage.getInventory());
    assertArrayEquals(new byte[]{7}, actualFetchInvDataMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }
}
