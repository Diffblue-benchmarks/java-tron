package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.tron.api.GrpcAPI;
import org.tron.core.Wallet;
import org.tron.protos.Protocol;

public class TransactionReceiptDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionReceipt#TransactionReceipt(Protocol.Block, Protocol.TransactionInfo, Wallet)}
   */
  @Test
  public void testNewTransactionReceipt() {
    // Arrange
    Protocol.Block block = Protocol.Block.getDefaultInstance();
    Protocol.TransactionInfo txInfo = Protocol.TransactionInfo.getDefaultInstance();
    Wallet wallet = mock(Wallet.class);
    when(wallet.getEnergyFee(anyLong())).thenReturn(1L);
    when(wallet.getTransactionInfoByBlockNum(anyLong())).thenReturn(GrpcAPI.TransactionInfoList.getDefaultInstance());

    // Act
    TransactionReceipt actualTransactionReceipt = new TransactionReceipt(block, txInfo, wallet);

    // Assert
    verify(wallet).getEnergyFee(eq(0L));
    verify(wallet).getTransactionInfoByBlockNum(eq(0L));
    assertEquals("0x", actualTransactionReceipt.getTransactionHash());
    assertEquals("0x0", actualTransactionReceipt.getBlockNumber());
    assertEquals("0x0", actualTransactionReceipt.getType());
    assertEquals("0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "00000000000000", actualTransactionReceipt.getLogsBloom());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualTransactionReceipt.getBlockHash());
    assertEquals("0x1", actualTransactionReceipt.getEffectiveGasPrice());
    assertNull(actualTransactionReceipt.getContractAddress());
    assertNull(actualTransactionReceipt.getCumulativeGasUsed());
    assertNull(actualTransactionReceipt.getFrom());
    assertNull(actualTransactionReceipt.getGasUsed());
    assertNull(actualTransactionReceipt.getTo());
    assertNull(actualTransactionReceipt.getTransactionIndex());
    assertNull(actualTransactionReceipt.root);
    assertNull(actualTransactionReceipt.status);
    assertEquals(0, actualTransactionReceipt.getLogs().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TransactionReceipt.TransactionLog}
   *   <li>{@link TransactionReceipt.TransactionLog#setAddress(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setBlockHash(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setBlockNumber(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setData(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setLogIndex(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setRemoved(boolean)}
   *   <li>{@link TransactionReceipt.TransactionLog#setTopics(String[])}
   *   <li>{@link TransactionReceipt.TransactionLog#setTransactionHash(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#setTransactionIndex(String)}
   *   <li>{@link TransactionReceipt.TransactionLog#getAddress()}
   *   <li>{@link TransactionReceipt.TransactionLog#getBlockHash()}
   *   <li>{@link TransactionReceipt.TransactionLog#getBlockNumber()}
   *   <li>{@link TransactionReceipt.TransactionLog#getData()}
   *   <li>{@link TransactionReceipt.TransactionLog#getLogIndex()}
   *   <li>{@link TransactionReceipt.TransactionLog#getTopics()}
   *   <li>{@link TransactionReceipt.TransactionLog#getTransactionHash()}
   *   <li>{@link TransactionReceipt.TransactionLog#getTransactionIndex()}
   *   <li>{@link TransactionReceipt.TransactionLog#isRemoved()}
   * </ul>
   */
  @Test
  public void testTransactionLogGettersAndSetters() {
    // Arrange and Act
    TransactionReceipt.TransactionLog actualTransactionLog = new TransactionReceipt.TransactionLog();
    actualTransactionLog.setAddress("42 Main St");
    actualTransactionLog.setBlockHash("Block Hash");
    actualTransactionLog.setBlockNumber("42");
    actualTransactionLog.setData("Data");
    actualTransactionLog.setLogIndex("Log Index");
    actualTransactionLog.setRemoved(true);
    String[] topics = new String[]{"Topics"};
    actualTransactionLog.setTopics(topics);
    actualTransactionLog.setTransactionHash("Transaction Hash");
    actualTransactionLog.setTransactionIndex("Transaction Index");
    String actualAddress = actualTransactionLog.getAddress();
    String actualBlockHash = actualTransactionLog.getBlockHash();
    String actualBlockNumber = actualTransactionLog.getBlockNumber();
    String actualData = actualTransactionLog.getData();
    String actualLogIndex = actualTransactionLog.getLogIndex();
    String[] actualTopics = actualTransactionLog.getTopics();
    String actualTransactionHash = actualTransactionLog.getTransactionHash();
    String actualTransactionIndex = actualTransactionLog.getTransactionIndex();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualBlockNumber);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("Data", actualData);
    assertEquals("Log Index", actualLogIndex);
    assertEquals("Transaction Hash", actualTransactionHash);
    assertEquals("Transaction Index", actualTransactionIndex);
    assertTrue(actualTransactionLog.isRemoved());
    assertSame(topics, actualTopics);
    assertArrayEquals(new String[]{"Topics"}, actualTopics);
  }
}
