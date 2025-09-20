package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BlockResultDiffblueTest {
  /**
   * Test {@link BlockResult#BlockResult()}.
   *
   * <p>Method under test: {@link BlockResult#BlockResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockResult.<init>()"})
  public void testNewBlockResult() {
    // Arrange and Act
    BlockResult actualBlockResult = new BlockResult();

    // Assert
    assertEquals("0x0", actualBlockResult.getBaseFeePerGas());
    assertEquals(
        "0x0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockResult.getMixHash());
    assertNull(actualBlockResult.getTransactions());
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
    assertNull(actualBlockResult.getUncles());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String BlockResult.getBaseFeePerGas()",
    "String BlockResult.getDifficulty()",
    "String BlockResult.getExtraData()",
    "String BlockResult.getGasLimit()",
    "String BlockResult.getGasUsed()",
    "String BlockResult.getHash()",
    "String BlockResult.getLogsBloom()",
    "String BlockResult.getMiner()",
    "String BlockResult.getMixHash()",
    "String BlockResult.getNonce()",
    "String BlockResult.getNumber()",
    "String BlockResult.getParentHash()",
    "String BlockResult.getReceiptsRoot()",
    "String BlockResult.getSha3Uncles()",
    "String BlockResult.getSize()",
    "String BlockResult.getStateRoot()",
    "String BlockResult.getTimestamp()",
    "String BlockResult.getTotalDifficulty()",
    "Object[] BlockResult.getTransactions()",
    "String BlockResult.getTransactionsRoot()",
    "String[] BlockResult.getUncles()",
    "void BlockResult.setBaseFeePerGas(String)",
    "void BlockResult.setDifficulty(String)",
    "void BlockResult.setExtraData(String)",
    "void BlockResult.setGasLimit(String)",
    "void BlockResult.setGasUsed(String)",
    "void BlockResult.setHash(String)",
    "void BlockResult.setLogsBloom(String)",
    "void BlockResult.setMiner(String)",
    "void BlockResult.setMixHash(String)",
    "void BlockResult.setNonce(String)",
    "void BlockResult.setNumber(String)",
    "void BlockResult.setParentHash(String)",
    "void BlockResult.setReceiptsRoot(String)",
    "void BlockResult.setSha3Uncles(String)",
    "void BlockResult.setSize(String)",
    "void BlockResult.setStateRoot(String)",
    "void BlockResult.setTimestamp(String)",
    "void BlockResult.setTotalDifficulty(String)",
    "void BlockResult.setTransactions(Object[])",
    "void BlockResult.setTransactionsRoot(String)",
    "void BlockResult.setUncles(String[])"
  })
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
    Object[] transactions = new Object[] {"Transactions"};
    blockResult.setTransactions(transactions);
    blockResult.setTransactionsRoot("Transactions Root");
    String[] uncles = new String[] {"Uncles"};
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

    // Assert
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
    assertArrayEquals(new String[] {"Uncles"}, actualUncles);
  }
}
