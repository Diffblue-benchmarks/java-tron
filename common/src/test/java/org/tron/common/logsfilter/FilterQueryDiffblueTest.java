package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FilterQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FilterQuery}
   *   <li>{@link FilterQuery#setContractAddressList(List)}
   *   <li>{@link FilterQuery#setContractTopicList(List)}
   *   <li>{@link FilterQuery#setFromBlock(long)}
   *   <li>{@link FilterQuery#setToBlock(long)}
   *   <li>{@link FilterQuery#toString()}
   *   <li>{@link FilterQuery#getContractAddressList()}
   *   <li>{@link FilterQuery#getContractTopicList()}
   *   <li>{@link FilterQuery#getFromBlock()}
   *   <li>{@link FilterQuery#getToBlock()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterQuery actualFilterQuery = new FilterQuery();
    ArrayList<String> contractAddressList = new ArrayList<>();
    actualFilterQuery.setContractAddressList(contractAddressList);
    ArrayList<String> contractTopicList = new ArrayList<>();
    actualFilterQuery.setContractTopicList(contractTopicList);
    actualFilterQuery.setFromBlock(1L);
    actualFilterQuery.setToBlock(1L);
    String actualToStringResult = actualFilterQuery.toString();
    List<String> actualContractAddressList = actualFilterQuery.getContractAddressList();
    List<String> actualContractTopicList = actualFilterQuery.getContractTopicList();
    long actualFromBlock = actualFilterQuery.getFromBlock();

    // Assert that nothing has changed
    assertEquals("fromBlock: 1, toBlock: 1, contractAddress: [], contractTopics: []", actualToStringResult);
    assertEquals(1L, actualFromBlock);
    assertEquals(1L, actualFilterQuery.getToBlock());
    assertTrue(actualContractAddressList.isEmpty());
    assertTrue(actualContractTopicList.isEmpty());
    assertSame(contractAddressList, actualContractAddressList);
    assertSame(contractTopicList, actualContractTopicList);
  }

  /**
   * Method under test: {@link FilterQuery#parseFromBlockNumber(String)}
   */
  @Test
  public void testParseFromBlockNumber() {
    // Arrange, Act and Assert
    assertEquals(0L, FilterQuery.parseFromBlockNumber(null));
    assertEquals(0L, FilterQuery.parseFromBlockNumber(FilterQuery.EARLIEST));
    assertEquals(42L, FilterQuery.parseFromBlockNumber("42"));
    assertEquals(0L, FilterQuery.parseFromBlockNumber(""));
  }

  /**
   * Method under test: {@link FilterQuery#parseToBlockNumber(String)}
   */
  @Test
  public void testParseToBlockNumber() {
    // Arrange, Act and Assert
    assertEquals(-1L, FilterQuery.parseToBlockNumber(null));
    assertEquals(-1L, FilterQuery.parseToBlockNumber(FilterQuery.LATEST));
    assertEquals(42L, FilterQuery.parseToBlockNumber("42"));
    assertEquals(-1L, FilterQuery.parseToBlockNumber(""));
  }
}
