package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

public class TransactionResultDiffblueTest {
  /**
   * Test {@link TransactionResult#TransactionResult(BlockCapsule, int, Transaction, long, long,
   * Wallet)}.
   *
   * <p>Method under test: {@link TransactionResult#TransactionResult(BlockCapsule, int,
   * Transaction, long, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TransactionResult.<init>(BlockCapsule, int, Transaction, long, long, Wallet)"
  })
  public void testNewTransactionResult() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(0L);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());
    Transaction tx = Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult =
        new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getBlockNumber());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getBlockHash());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getR());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals(
        "0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Test {@link TransactionResult#TransactionResult(BlockCapsule, int, Transaction, long, long,
   * Wallet)}.
   *
   * <ul>
   *   <li>Then return BlockHash is {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResult#TransactionResult(BlockCapsule, int,
   * Transaction, long, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TransactionResult.<init>(BlockCapsule, int, Transaction, long, long, Wallet)"
  })
  public void testNewTransactionResult_thenReturnBlockHashIs0x() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn(new byte[] {});

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(0L);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    Transaction tx = Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult =
        new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getBlockHash());
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getBlockNumber());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getR());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals(
        "0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Test {@link TransactionResult#TransactionResult(BlockCapsule, int, Transaction, long, long,
   * Wallet)}.
   *
   * <ul>
   *   <li>Then return BlockHash is {@code 0x4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResult#TransactionResult(BlockCapsule, int,
   * Transaction, long, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TransactionResult.<init>(BlockCapsule, int, Transaction, long, long, Wallet)"
  })
  public void testNewTransactionResult_thenReturnBlockHashIs0x4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(0L);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    Transaction tx = Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult =
        new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getBlockNumber());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getR());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals("0x4158415841584158", actualTransactionResult.getBlockHash());
    assertEquals(
        "0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Test {@link TransactionResult#TransactionResult(Transaction, Wallet)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return BlockHash is {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionResult#TransactionResult(Transaction, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionResult.<init>(Transaction, Wallet)"})
  public void testNewTransactionResult_whenDefaultInstance_thenReturnBlockHashIs0x() {
    // Arrange
    Transaction tx = Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult = new TransactionResult(tx, new Wallet());

    // Assert
    assertEquals("0x", actualTransactionResult.getBlockHash());
    assertEquals("0x", actualTransactionResult.getBlockNumber());
    assertEquals("0x", actualTransactionResult.getGasPrice());
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x", actualTransactionResult.getTransactionIndex());
    assertEquals("0x0", actualTransactionResult.getGas());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getR());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getS());
    assertEquals(
        "0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }
}
