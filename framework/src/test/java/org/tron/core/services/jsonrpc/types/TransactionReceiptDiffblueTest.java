package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.jsonrpc.types.TransactionReceipt.TransactionLog;

public class TransactionReceiptDiffblueTest {
  /**
   * Test TransactionLog getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TransactionLog}
   *   <li>{@link TransactionLog#setAddress(String)}
   *   <li>{@link TransactionLog#setBlockHash(String)}
   *   <li>{@link TransactionLog#setBlockNumber(String)}
   *   <li>{@link TransactionLog#setData(String)}
   *   <li>{@link TransactionLog#setLogIndex(String)}
   *   <li>{@link TransactionLog#setRemoved(boolean)}
   *   <li>{@link TransactionLog#setTopics(String[])}
   *   <li>{@link TransactionLog#setTransactionHash(String)}
   *   <li>{@link TransactionLog#setTransactionIndex(String)}
   *   <li>{@link TransactionLog#getAddress()}
   *   <li>{@link TransactionLog#getBlockHash()}
   *   <li>{@link TransactionLog#getBlockNumber()}
   *   <li>{@link TransactionLog#getData()}
   *   <li>{@link TransactionLog#getLogIndex()}
   *   <li>{@link TransactionLog#getTopics()}
   *   <li>{@link TransactionLog#getTransactionHash()}
   *   <li>{@link TransactionLog#getTransactionIndex()}
   *   <li>{@link TransactionLog#isRemoved()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionLog.<init>()",
    "String TransactionLog.getAddress()",
    "String TransactionLog.getBlockHash()",
    "String TransactionLog.getBlockNumber()",
    "String TransactionLog.getData()",
    "String TransactionLog.getLogIndex()",
    "String[] TransactionLog.getTopics()",
    "String TransactionLog.getTransactionHash()",
    "String TransactionLog.getTransactionIndex()",
    "boolean TransactionLog.isRemoved()",
    "void TransactionLog.setAddress(String)",
    "void TransactionLog.setBlockHash(String)",
    "void TransactionLog.setBlockNumber(String)",
    "void TransactionLog.setData(String)",
    "void TransactionLog.setLogIndex(String)",
    "void TransactionLog.setRemoved(boolean)",
    "void TransactionLog.setTopics(String[])",
    "void TransactionLog.setTransactionHash(String)",
    "void TransactionLog.setTransactionIndex(String)"
  })
  public void testTransactionLogGettersAndSetters() {
    // Arrange and Act
    TransactionLog actualTransactionLog = new TransactionLog();
    actualTransactionLog.setAddress("42 Main St");
    actualTransactionLog.setBlockHash("Block Hash");
    actualTransactionLog.setBlockNumber("42");
    actualTransactionLog.setData("Data");
    actualTransactionLog.setLogIndex("Log Index");
    actualTransactionLog.setRemoved(true);
    String[] topics = new String[] {"Topics"};
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

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualBlockNumber);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("Data", actualData);
    assertEquals("Log Index", actualLogIndex);
    assertEquals("Transaction Hash", actualTransactionHash);
    assertEquals("Transaction Index", actualTransactionIndex);
    assertTrue(actualTransactionLog.isRemoved());
    assertSame(topics, actualTopics);
    assertArrayEquals(new String[] {"Topics"}, actualTopics);
  }
}
