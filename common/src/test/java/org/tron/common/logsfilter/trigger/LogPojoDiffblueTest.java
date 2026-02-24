package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LogPojoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LogPojo}
   *   <li>{@link LogPojo#setAddress(String)}
   *   <li>{@link LogPojo#setBlockHash(String)}
   *   <li>{@link LogPojo#setBlockNumber(long)}
   *   <li>{@link LogPojo#setData(String)}
   *   <li>{@link LogPojo#setLogIndex(long)}
   *   <li>{@link LogPojo#setTopicList(List)}
   *   <li>{@link LogPojo#setTransactionHash(String)}
   *   <li>{@link LogPojo#setTransactionIndex(long)}
   *   <li>{@link LogPojo#getAddress()}
   *   <li>{@link LogPojo#getBlockHash()}
   *   <li>{@link LogPojo#getBlockNumber()}
   *   <li>{@link LogPojo#getData()}
   *   <li>{@link LogPojo#getLogIndex()}
   *   <li>{@link LogPojo#getTopicList()}
   *   <li>{@link LogPojo#getTransactionHash()}
   *   <li>{@link LogPojo#getTransactionIndex()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogPojo.<init>()",
    "String LogPojo.getAddress()",
    "String LogPojo.getBlockHash()",
    "long LogPojo.getBlockNumber()",
    "String LogPojo.getData()",
    "long LogPojo.getLogIndex()",
    "List LogPojo.getTopicList()",
    "String LogPojo.getTransactionHash()",
    "long LogPojo.getTransactionIndex()",
    "void LogPojo.setAddress(String)",
    "void LogPojo.setBlockHash(String)",
    "void LogPojo.setBlockNumber(long)",
    "void LogPojo.setData(String)",
    "void LogPojo.setLogIndex(long)",
    "void LogPojo.setTopicList(List)",
    "void LogPojo.setTransactionHash(String)",
    "void LogPojo.setTransactionIndex(long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LogPojo actualLogPojo = new LogPojo();
    actualLogPojo.setAddress("42 Main St");
    actualLogPojo.setBlockHash("Block Hash");
    actualLogPojo.setBlockNumber(1L);
    actualLogPojo.setData("Data");
    actualLogPojo.setLogIndex(1L);
    ArrayList<String> topicList = new ArrayList<>();
    actualLogPojo.setTopicList(topicList);
    actualLogPojo.setTransactionHash("Transaction Hash");
    actualLogPojo.setTransactionIndex(1L);
    String actualAddress = actualLogPojo.getAddress();
    String actualBlockHash = actualLogPojo.getBlockHash();
    long actualBlockNumber = actualLogPojo.getBlockNumber();
    String actualData = actualLogPojo.getData();
    long actualLogIndex = actualLogPojo.getLogIndex();
    List<String> actualTopicList = actualLogPojo.getTopicList();
    String actualTransactionHash = actualLogPojo.getTransactionHash();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("Data", actualData);
    assertEquals("Transaction Hash", actualTransactionHash);
    assertEquals(1L, actualBlockNumber);
    assertEquals(1L, actualLogIndex);
    assertEquals(1L, actualLogPojo.getTransactionIndex());
    assertTrue(actualTopicList.isEmpty());
    assertSame(topicList, actualTopicList);
  }
}
