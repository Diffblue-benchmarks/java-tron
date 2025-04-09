package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterQueryDiffblueTest {
  /**
   * Test {@link FilterQuery#parseFromBlockNumber(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseFromBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseFromBlockNumber(String)"})
  public void testParseFromBlockNumber_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, FilterQuery.parseFromBlockNumber("42"));
  }

  /**
   * Test {@link FilterQuery#parseFromBlockNumber(String)}.
   * <ul>
   *   <li>When {@link FilterQuery#EARLIEST}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseFromBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseFromBlockNumber(String)"})
  public void testParseFromBlockNumber_whenEarliest_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, FilterQuery.parseFromBlockNumber(FilterQuery.EARLIEST));
  }

  /**
   * Test {@link FilterQuery#parseFromBlockNumber(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseFromBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseFromBlockNumber(String)"})
  public void testParseFromBlockNumber_whenEmptyString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, FilterQuery.parseFromBlockNumber(""));
  }

  /**
   * Test {@link FilterQuery#parseFromBlockNumber(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseFromBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseFromBlockNumber(String)"})
  public void testParseFromBlockNumber_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, FilterQuery.parseFromBlockNumber(null));
  }

  /**
   * Test {@link FilterQuery#parseToBlockNumber(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseToBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseToBlockNumber(String)"})
  public void testParseToBlockNumber_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, FilterQuery.parseToBlockNumber("42"));
  }

  /**
   * Test {@link FilterQuery#parseToBlockNumber(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseToBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseToBlockNumber(String)"})
  public void testParseToBlockNumber_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, FilterQuery.parseToBlockNumber(""));
  }

  /**
   * Test {@link FilterQuery#parseToBlockNumber(String)}.
   * <ul>
   *   <li>When {@link FilterQuery#LATEST}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseToBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseToBlockNumber(String)"})
  public void testParseToBlockNumber_whenLatest_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, FilterQuery.parseToBlockNumber(FilterQuery.LATEST));
  }

  /**
   * Test {@link FilterQuery#parseToBlockNumber(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterQuery#parseToBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long FilterQuery.parseToBlockNumber(String)"})
  public void testParseToBlockNumber_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, FilterQuery.parseToBlockNumber(null));
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FilterQuery.<init>()", "List FilterQuery.getContractAddressList()",
      "List FilterQuery.getContractTopicList()", "long FilterQuery.getFromBlock()", "long FilterQuery.getToBlock()",
      "void FilterQuery.setContractAddressList(List)", "void FilterQuery.setContractTopicList(List)",
      "void FilterQuery.setFromBlock(long)", "void FilterQuery.setToBlock(long)", "String FilterQuery.toString()"})
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

    // Assert
    assertEquals("fromBlock: 1, toBlock: 1, contractAddress: [], contractTopics: []", actualToStringResult);
    assertEquals(1L, actualFromBlock);
    assertEquals(1L, actualFilterQuery.getToBlock());
    assertTrue(actualContractAddressList.isEmpty());
    assertTrue(actualContractTopicList.isEmpty());
    assertSame(contractAddressList, actualContractAddressList);
    assertSame(contractTopicList, actualContractTopicList);
  }
}
