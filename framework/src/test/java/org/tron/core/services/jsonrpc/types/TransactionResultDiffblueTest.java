package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.Wallet;
import org.tron.core.capsule.BlockCapsule;
import org.tron.protos.Protocol;

public class TransactionResultDiffblueTest {
  /**
   * Method under test: {@link TransactionResult#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

    // Act and Assert
    assertEquals("0x0", (new TransactionResult(tx, new Wallet())).getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionResult#toString()}
   *   <li>{@link TransactionResult#getBlockHash()}
   *   <li>{@link TransactionResult#getBlockNumber()}
   *   <li>{@link TransactionResult#getFrom()}
   *   <li>{@link TransactionResult#getGas()}
   *   <li>{@link TransactionResult#getGasPrice()}
   *   <li>{@link TransactionResult#getHash()}
   *   <li>{@link TransactionResult#getInput()}
   *   <li>{@link TransactionResult#getNonce()}
   *   <li>{@link TransactionResult#getR()}
   *   <li>{@link TransactionResult#getS()}
   *   <li>{@link TransactionResult#getTo()}
   *   <li>{@link TransactionResult#getTransactionIndex()}
   *   <li>{@link TransactionResult#getV()}
   *   <li>{@link TransactionResult#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();
    TransactionResult transactionResult = new TransactionResult(tx, new Wallet());

    // Act
    String actualToStringResult = transactionResult.toString();
    String actualBlockHash = transactionResult.getBlockHash();
    String actualBlockNumber = transactionResult.getBlockNumber();
    String actualFrom = transactionResult.getFrom();
    String actualGas = transactionResult.getGas();
    String actualGasPrice = transactionResult.getGasPrice();
    String actualHash = transactionResult.getHash();
    String actualInput = transactionResult.getInput();
    String actualNonce = transactionResult.getNonce();
    String actualR = transactionResult.getR();
    String actualS = transactionResult.getS();
    String actualTo = transactionResult.getTo();
    String actualTransactionIndex = transactionResult.getTransactionIndex();
    String actualV = transactionResult.getV();

    // Assert
    assertEquals("0x", actualBlockHash);
    assertEquals("0x", actualBlockNumber);
    assertEquals("0x", actualGasPrice);
    assertEquals("0x", actualInput);
    assertEquals("0x", actualTransactionIndex);
    assertEquals("0x0", actualGas);
    assertEquals("0x0", transactionResult.getValue());
    assertEquals("0x00", actualV);
    assertEquals("0x0000000000000000", actualNonce);
    assertEquals("0x0000000000000000000000000000000000000000", actualFrom);
    assertEquals("0x0000000000000000000000000000000000000000", actualTo);
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualR);
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualS);
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", actualHash);
    assertEquals("TransactionResult(hash=0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855, nonce"
        + "=0x0000000000000000, blockHash=0x, blockNumber=0x, transactionIndex=0x, from=0x000000000000000000000"
        + "0000000000000000000, to=0x0000000000000000000000000000000000000000, gas=0x0, gasPrice=0x, value=0x0,"
        + " input=0x, type=0x0, v=0x00, r=0x0000000000000000000000000000000000000000000000000000000000000000,"
        + " s=0x0000000000000000000000000000000000000000000000000000000000000000)", actualToStringResult);
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(BlockCapsule, int, Protocol.Transaction, long, long, Wallet)}
   */
  @Test
  public void testNewTransactionResult() {
    // Arrange
    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult = new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getBlockNumber());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getBlockHash());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(BlockCapsule, int, Protocol.Transaction, long, long, Wallet)}
   */
  @Test
  public void testNewTransactionResult2() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult = new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualTransactionResult.getBlockHash());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getBlockNumber());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(BlockCapsule, int, Protocol.Transaction, long, long, Wallet)}
   */
  @Test
  public void testNewTransactionResult3() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult = new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getBlockNumber());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals("0x4158415841584158", actualTransactionResult.getBlockHash());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(BlockCapsule, int, Protocol.Transaction, long, long, Wallet)}
   */
  @Test
  public void testNewTransactionResult4() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn(new byte[]{});
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

    // Act
    TransactionResult actualTransactionResult = new TransactionResult(blockCapsule, 1, tx, 1L, 1L, new Wallet());

    // Assert
    verify(blockId).getBytes();
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getNum();
    assertEquals("0x", actualTransactionResult.getBlockHash());
    assertEquals("0x", actualTransactionResult.getInput());
    assertEquals("0x0", actualTransactionResult.getType());
    assertEquals("0x0", actualTransactionResult.getValue());
    assertEquals("0x00", actualTransactionResult.getV());
    assertEquals("0x0000000000000000", actualTransactionResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getFrom());
    assertEquals("0x0000000000000000000000000000000000000000", actualTransactionResult.getTo());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0x1", actualTransactionResult.getBlockNumber());
    assertEquals("0x1", actualTransactionResult.getGas());
    assertEquals("0x1", actualTransactionResult.getGasPrice());
    assertEquals("0x1", actualTransactionResult.getTransactionIndex());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(Protocol.Transaction, Wallet)}
   */
  @Test
  public void testNewTransactionResult5() {
    // Arrange
    Protocol.Transaction tx = Protocol.Transaction.getDefaultInstance();

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
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }

  /**
   * Method under test:
   * {@link TransactionResult#TransactionResult(Protocol.Transaction, Wallet)}
   */
  @Test
  public void testNewTransactionResult6() {
    // Arrange and Act
    TransactionResult actualTransactionResult = new TransactionResult(Protocol.Transaction.getDefaultInstance(),
        mock(Wallet.class));

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
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getR());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualTransactionResult.getS());
    assertEquals("0xe3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionResult.getHash());
  }
}
