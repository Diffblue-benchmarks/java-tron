package org.tron.core.net.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.math.BigInteger;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.sync.ChainInventoryMessage;
import org.tron.core.net.message.sync.SyncBlockChainMessage;

public class TronMessageFactoryDiffblueTest {
  /**
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  public void testCreate() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{6, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{6, '\b', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', '\b'}));
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{7, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{'\b', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{'\t', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  public void testCreate2() throws Exception {
    // Arrange and Act
    TronMessage actualCreateResult = TronMessageFactory
        .create(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Assert
    ByteBuf sendData = actualCreateResult.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertTrue(actualCreateResult instanceof SyncBlockChainMessage);
    Sha256Hash messageId = actualCreateResult.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("93907731197596050714946754158793542046278514864085370575725419173937847285494",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("ϝ�m�_�R��X^<\b��f��I�-\u0012�e\u0003\u0011i�\u00116�", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -49, iteratorResult.next().byteValue());
    assertEquals((byte) -99, iteratorResult.next().byteValue());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(8, sendData.capacity());
    assertEquals(8, sendData.maxCapacity());
    assertEquals(8, sendData.writerIndex());
    assertEquals(MessageTypes.SYNC_BLOCK_CHAIN, actualCreateResult.getType());
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
    assertTrue(((SyncBlockChainMessage) actualCreateResult).getBlockIds().isEmpty());
    Class<ChainInventoryMessage> expectedAnswerMessage = ChainInventoryMessage.class;
    assertEquals(expectedAnswerMessage, actualCreateResult.getAnswerMessage());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getData());
    assertArrayEquals(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        actualCreateResult.getSendBytes());
    assertArrayEquals(new byte[]{-49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116, 'f',
        -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116,
        'f', -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10}, toBigIntegerResult.toByteArray());
  }
}
