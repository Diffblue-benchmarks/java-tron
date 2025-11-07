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
import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.net.message.MessageTypes;
import org.tron.protos.Protocol;

public class TransactionMessageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionMessage#toString()}
   *   <li>{@link TransactionMessage#getAnswerMessage()}
   *   <li>{@link TransactionMessage#getTransactionCapsule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Protocol.Transaction trx = Protocol.Transaction.getDefaultInstance();
    TransactionMessage transactionMessage = new TransactionMessage(trx);

    // Act
    String actualToStringResult = transactionMessage.toString();
    Class<?> actualAnswerMessage = transactionMessage.getAnswerMessage();
    TransactionCapsule actualTransactionCapsule = transactionMessage.getTransactionCapsule();

    // Assert
    Sha256Hash merkleHash = actualTransactionCapsule.getMerkleHash();
    BigInteger toBigIntegerResult = merkleHash.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = merkleHash.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertEquals("type: TRX\nmessageId: e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualToStringResult);
    assertNull(actualAnswerMessage);
    assertNull(actualTransactionCapsule.getTrxTrace());
    assertNull(actualTransactionCapsule.getContractResult());
    assertNull(actualTransactionCapsule.getContractRet());
    assertEquals(-1L, actualTransactionCapsule.getBlockNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualTransactionCapsule.getData().length);
    assertEquals(0L, actualTransactionCapsule.getExpiration());
    assertEquals(0L, actualTransactionCapsule.getFeeLimit());
    assertEquals(0L, actualTransactionCapsule.getOrder());
    assertEquals(0L, actualTransactionCapsule.getResultSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, actualTransactionCapsule.getSerializedSize());
    assertEquals(0L, actualTransactionCapsule.getTime());
    assertEquals(0L, actualTransactionCapsule.getTimestamp());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertFalse(actualTransactionCapsule.isInBlock());
    assertFalse(actualTransactionCapsule.isTransactionCreate());
    assertTrue(iteratorResult.hasNext());
    assertSame(trx, actualTransactionCapsule.getInstance());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, merkleHash.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test:
   * {@link TransactionMessage#TransactionMessage(Protocol.Transaction)}
   */
  @Test
  public void testNewTransactionMessage() {
    // Arrange
    Protocol.Transaction trx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionMessage actualTransactionMessage = new TransactionMessage(trx);

    // Assert
    ByteBuf sendData = actualTransactionMessage.getSendData();
    ByteBufAllocator allocResult = sendData.alloc();
    assertTrue(allocResult instanceof UnpooledByteBufAllocator);
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Sha256Hash messageId = actualTransactionMessage.getMessageId();
    BigInteger toBigIntegerResult = messageId.toBigInteger();
    assertEquals("102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
    ByteString byteString = messageId.getByteString();
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertNull(sendData.unwrap());
    assertNull(actualTransactionMessage.getAnswerMessage());
    TransactionCapsule transactionCapsule = actualTransactionMessage.getTransactionCapsule();
    assertNull(transactionCapsule.getTrxTrace());
    assertNull(transactionCapsule.getContractResult());
    assertNull(transactionCapsule.getContractRet());
    assertEquals(-1L, transactionCapsule.getBlockNum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualTransactionMessage.getData().length);
    assertEquals(0, transactionCapsule.getData().length);
    assertEquals(0L, transactionCapsule.getExpiration());
    assertEquals(0L, transactionCapsule.getFeeLimit());
    assertEquals(0L, transactionCapsule.getOrder());
    assertEquals(0L, transactionCapsule.getResultSerializedSize());
    assertEquals(0L, transactionCapsule.getResultSizeWithMaxContractRet());
    assertEquals(0L, transactionCapsule.getSerializedSize());
    assertEquals(0L, transactionCapsule.getTime());
    assertEquals(0L, transactionCapsule.getTimestamp());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertEquals(1, sendData.refCnt());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(MessageTypes.TRX, actualTransactionMessage.getType());
    assertFalse(byteString.isEmpty());
    assertFalse(sendData.hasMemoryAddress());
    assertFalse(sendData.isDirect());
    assertFalse(sendData.isReadOnly());
    assertFalse(sendData.isWritable());
    assertFalse(allocResult.isDirectBufferPooled());
    assertFalse(transactionCapsule.isInBlock());
    assertFalse(transactionCapsule.isTransactionCreate());
    assertTrue(sendData.hasArray());
    assertTrue(sendData.isContiguous());
    assertTrue(sendData.isReadable());
    assertTrue(sendData.readBoolean());
    assertTrue(iteratorResult.hasNext());
    assertEquals(messageId, transactionCapsule.getMerkleHash());
    assertSame(messageId, transactionCapsule.getTransactionId());
    assertSame(trx, transactionCapsule.getInstance());
    assertArrayEquals(new byte[]{1}, actualTransactionMessage.getSendBytes());
    assertArrayEquals(new byte[]{-29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
        -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        toBigIntegerResult.toByteArray());
  }
}
