package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.api.GrpcAPI;
import org.tron.core.Wallet;
import org.tron.protos.Protocol;

@ContextConfiguration(classes = {BlockResult.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BlockResultDiffblueTest {
  @Autowired
  private BlockResult blockResult;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockResult#setBaseFeePerGas(String)}
   *   <li>{@link BlockResult#setDifficulty(String)}
   *   <li>{@link BlockResult#setExtraData(String)}
   *   <li>{@link BlockResult#setGasLimit(String)}
   *   <li>{@link BlockResult#setGasUsed(String)}
   *   <li>{@link BlockResult#setHash(String)}
   *   <li>{@link BlockResult#setLogsBloom(String)}
   *   <li>{@link BlockResult#setMiner(String)}
   *   <li>{@link BlockResult#setMixHash(String)}
   *   <li>{@link BlockResult#setNonce(String)}
   *   <li>{@link BlockResult#setNumber(String)}
   *   <li>{@link BlockResult#setParentHash(String)}
   *   <li>{@link BlockResult#setReceiptsRoot(String)}
   *   <li>{@link BlockResult#setSha3Uncles(String)}
   *   <li>{@link BlockResult#setSize(String)}
   *   <li>{@link BlockResult#setStateRoot(String)}
   *   <li>{@link BlockResult#setTimestamp(String)}
   *   <li>{@link BlockResult#setTotalDifficulty(String)}
   *   <li>{@link BlockResult#setTransactions(Object[])}
   *   <li>{@link BlockResult#setTransactionsRoot(String)}
   *   <li>{@link BlockResult#setUncles(String[])}
   *   <li>{@link BlockResult#getBaseFeePerGas()}
   *   <li>{@link BlockResult#getDifficulty()}
   *   <li>{@link BlockResult#getExtraData()}
   *   <li>{@link BlockResult#getGasLimit()}
   *   <li>{@link BlockResult#getGasUsed()}
   *   <li>{@link BlockResult#getHash()}
   *   <li>{@link BlockResult#getLogsBloom()}
   *   <li>{@link BlockResult#getMiner()}
   *   <li>{@link BlockResult#getMixHash()}
   *   <li>{@link BlockResult#getNonce()}
   *   <li>{@link BlockResult#getNumber()}
   *   <li>{@link BlockResult#getParentHash()}
   *   <li>{@link BlockResult#getReceiptsRoot()}
   *   <li>{@link BlockResult#getSha3Uncles()}
   *   <li>{@link BlockResult#getSize()}
   *   <li>{@link BlockResult#getStateRoot()}
   *   <li>{@link BlockResult#getTimestamp()}
   *   <li>{@link BlockResult#getTotalDifficulty()}
   *   <li>{@link BlockResult#getTransactions()}
   *   <li>{@link BlockResult#getTransactionsRoot()}
   *   <li>{@link BlockResult#getUncles()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BlockResult blockResult = new BlockResult();

    // Act
    blockResult.setBaseFeePerGas("Base Fee Per Gas");
    blockResult.setDifficulty("Difficulty");
    blockResult.setExtraData("Extra Data");
    blockResult.setGasLimit("Gas Limit");
    blockResult.setGasUsed("Gas Used");
    blockResult.setHash("Hash");
    blockResult.setLogsBloom("Logs Bloom");
    blockResult.setMiner("Miner");
    blockResult.setMixHash("Mix Hash");
    blockResult.setNonce("Nonce");
    blockResult.setNumber("42");
    blockResult.setParentHash("Parent Hash");
    blockResult.setReceiptsRoot("Receipts Root");
    blockResult.setSha3Uncles("Sha3 Uncles");
    blockResult.setSize("Size");
    blockResult.setStateRoot("MD");
    blockResult.setTimestamp("Timestamp");
    blockResult.setTotalDifficulty("Total Difficulty");
    Object[] transactions = new Object[]{"Transactions"};
    blockResult.setTransactions(transactions);
    blockResult.setTransactionsRoot("Transactions Root");
    String[] uncles = new String[]{"Uncles"};
    blockResult.setUncles(uncles);
    String actualBaseFeePerGas = blockResult.getBaseFeePerGas();
    String actualDifficulty = blockResult.getDifficulty();
    String actualExtraData = blockResult.getExtraData();
    String actualGasLimit = blockResult.getGasLimit();
    String actualGasUsed = blockResult.getGasUsed();
    String actualHash = blockResult.getHash();
    String actualLogsBloom = blockResult.getLogsBloom();
    String actualMiner = blockResult.getMiner();
    String actualMixHash = blockResult.getMixHash();
    String actualNonce = blockResult.getNonce();
    String actualNumber = blockResult.getNumber();
    String actualParentHash = blockResult.getParentHash();
    String actualReceiptsRoot = blockResult.getReceiptsRoot();
    String actualSha3Uncles = blockResult.getSha3Uncles();
    String actualSize = blockResult.getSize();
    String actualStateRoot = blockResult.getStateRoot();
    String actualTimestamp = blockResult.getTimestamp();
    String actualTotalDifficulty = blockResult.getTotalDifficulty();
    Object[] actualTransactions = blockResult.getTransactions();
    String actualTransactionsRoot = blockResult.getTransactionsRoot();
    String[] actualUncles = blockResult.getUncles();

    // Assert that nothing has changed
    assertEquals("42", actualNumber);
    assertEquals("Base Fee Per Gas", actualBaseFeePerGas);
    assertEquals("Difficulty", actualDifficulty);
    assertEquals("Extra Data", actualExtraData);
    assertEquals("Gas Limit", actualGasLimit);
    assertEquals("Gas Used", actualGasUsed);
    assertEquals("Hash", actualHash);
    assertEquals("Logs Bloom", actualLogsBloom);
    assertEquals("MD", actualStateRoot);
    assertEquals("Miner", actualMiner);
    assertEquals("Mix Hash", actualMixHash);
    assertEquals("Nonce", actualNonce);
    assertEquals("Parent Hash", actualParentHash);
    assertEquals("Receipts Root", actualReceiptsRoot);
    assertEquals("Sha3 Uncles", actualSha3Uncles);
    assertEquals("Size", actualSize);
    assertEquals("Timestamp", actualTimestamp);
    assertEquals("Total Difficulty", actualTotalDifficulty);
    assertEquals("Transactions Root", actualTransactionsRoot);
    assertEquals("Transactions", actualTransactions[0]);
    assertEquals(1, actualTransactions.length);
    assertSame(transactions, actualTransactions);
    assertSame(uncles, actualUncles);
    assertArrayEquals(new String[]{"Uncles"}, actualUncles);
  }

  /**
   * Method under test: {@link BlockResult#BlockResult()}
   */
  @Test
  public void testNewBlockResult() {
    // Arrange and Act
    BlockResult actualBlockResult = new BlockResult();

    // Assert
    assertEquals("0x0", actualBlockResult.getBaseFeePerGas());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualBlockResult.getMixHash());
    assertNull(actualBlockResult.getTransactions());
    assertNull(actualBlockResult.getUncles());
    assertNull(actualBlockResult.getDifficulty());
    assertNull(actualBlockResult.getExtraData());
    assertNull(actualBlockResult.getGasLimit());
    assertNull(actualBlockResult.getGasUsed());
    assertNull(actualBlockResult.getHash());
    assertNull(actualBlockResult.getLogsBloom());
    assertNull(actualBlockResult.getMiner());
    assertNull(actualBlockResult.getNonce());
    assertNull(actualBlockResult.getNumber());
    assertNull(actualBlockResult.getParentHash());
    assertNull(actualBlockResult.getReceiptsRoot());
    assertNull(actualBlockResult.getSha3Uncles());
    assertNull(actualBlockResult.getSize());
    assertNull(actualBlockResult.getStateRoot());
    assertNull(actualBlockResult.getTimestamp());
    assertNull(actualBlockResult.getTotalDifficulty());
    assertNull(actualBlockResult.getTransactionsRoot());
  }

  /**
   * Method under test:
   * {@link BlockResult#BlockResult(Protocol.Block, boolean, Wallet)}
   */
  @Test
  public void testNewBlockResult2() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    Wallet wallet = mock(Wallet.class);
    when(wallet.getEnergyFee(anyLong())).thenReturn(1L);
    when(wallet.getTransactionInfoByBlockNum(anyLong())).thenReturn(GrpcAPI.TransactionInfoList.getDefaultInstance());

    // Act
    BlockResult actualBlockResult = new BlockResult(block, true, wallet);

    // Assert
    verify(wallet).getEnergyFee(eq(0L));
    verify(wallet).getTransactionInfoByBlockNum(eq(0L));
    assertEquals("0x", actualBlockResult.getExtraData());
    assertEquals("0x", actualBlockResult.getParentHash());
    assertEquals("0x", actualBlockResult.getStateRoot());
    assertEquals("0x", actualBlockResult.getTransactionsRoot());
    assertEquals("0x0", actualBlockResult.getBaseFeePerGas());
    assertEquals("0x0", actualBlockResult.getDifficulty());
    assertEquals("0x0", actualBlockResult.getGasLimit());
    assertEquals("0x0", actualBlockResult.getGasUsed());
    assertEquals("0x0", actualBlockResult.getNumber());
    assertEquals("0x0", actualBlockResult.getSize());
    assertEquals("0x0", actualBlockResult.getTimestamp());
    assertEquals("0x0", actualBlockResult.getTotalDifficulty());
    assertEquals("0x0000000000000000", actualBlockResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualBlockResult.getMiner());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualBlockResult.getMixHash());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockResult.getReceiptsRoot());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockResult.getSha3Uncles());
    assertEquals("0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "00000000000000", actualBlockResult.getLogsBloom());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", actualBlockResult.getHash());
    assertEquals(0, actualBlockResult.getTransactions().length);
    assertEquals(0, actualBlockResult.getUncles().length);
  }

  /**
   * Method under test:
   * {@link BlockResult#BlockResult(Protocol.Block, boolean, Wallet)}
   */
  @Test
  public void testNewBlockResult3() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    Wallet wallet = mock(Wallet.class);
    when(wallet.getTransactionInfoByBlockNum(anyLong())).thenReturn(GrpcAPI.TransactionInfoList.getDefaultInstance());

    // Act
    BlockResult actualBlockResult = new BlockResult(block, false, wallet);

    // Assert
    verify(wallet).getTransactionInfoByBlockNum(eq(0L));
    assertEquals("0x", actualBlockResult.getExtraData());
    assertEquals("0x", actualBlockResult.getParentHash());
    assertEquals("0x", actualBlockResult.getStateRoot());
    assertEquals("0x", actualBlockResult.getTransactionsRoot());
    assertEquals("0x0", actualBlockResult.getBaseFeePerGas());
    assertEquals("0x0", actualBlockResult.getDifficulty());
    assertEquals("0x0", actualBlockResult.getGasLimit());
    assertEquals("0x0", actualBlockResult.getGasUsed());
    assertEquals("0x0", actualBlockResult.getNumber());
    assertEquals("0x0", actualBlockResult.getSize());
    assertEquals("0x0", actualBlockResult.getTimestamp());
    assertEquals("0x0", actualBlockResult.getTotalDifficulty());
    assertEquals("0x0000000000000000", actualBlockResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualBlockResult.getMiner());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000", actualBlockResult.getMixHash());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockResult.getReceiptsRoot());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockResult.getSha3Uncles());
    assertEquals("0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "00000000000000", actualBlockResult.getLogsBloom());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", actualBlockResult.getHash());
    assertEquals(0, actualBlockResult.getTransactions().length);
    assertEquals(0, actualBlockResult.getUncles().length);
  }
}
