package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RecentTransactionItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RecentTransactionItem#RecentTransactionItem()}
   *   <li>{@link RecentTransactionItem#setNum(long)}
   *   <li>{@link RecentTransactionItem#setTransactionIds(List)}
   *   <li>{@link RecentTransactionItem#getNum()}
   *   <li>{@link RecentTransactionItem#getTransactionIds()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RecentTransactionItem actualRecentTransactionItem = new RecentTransactionItem();
    actualRecentTransactionItem.setNum(1L);
    ArrayList<String> transactionIds = new ArrayList<>();
    actualRecentTransactionItem.setTransactionIds(transactionIds);
    long actualNum = actualRecentTransactionItem.getNum();
    List<String> actualTransactionIds = actualRecentTransactionItem.getTransactionIds();

    // Assert that nothing has changed
    assertEquals(1L, actualNum);
    assertTrue(actualTransactionIds.isEmpty());
    assertSame(transactionIds, actualTransactionIds);
  }

  /**
   * Method under test:
   * {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  public void testNewRecentTransactionItem() {
    // Arrange
    ArrayList<String> transactionIds = new ArrayList<>();

    // Act
    RecentTransactionItem actualRecentTransactionItem = new RecentTransactionItem(1L, transactionIds);

    // Assert
    assertEquals(1L, actualRecentTransactionItem.getNum());
    List<String> transactionIds2 = actualRecentTransactionItem.getTransactionIds();
    assertTrue(transactionIds2.isEmpty());
    assertSame(transactionIds, transactionIds2);
  }

  /**
   * Method under test:
   * {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  public void testNewRecentTransactionItem2() {
    // Arrange
    ArrayList<String> transactionIds = new ArrayList<>();
    transactionIds.add("foo");

    // Act
    RecentTransactionItem actualRecentTransactionItem = new RecentTransactionItem(1L, transactionIds);

    // Assert
    List<String> transactionIds2 = actualRecentTransactionItem.getTransactionIds();
    assertEquals(1, transactionIds2.size());
    assertEquals("foo", transactionIds2.get(0));
    assertEquals(1L, actualRecentTransactionItem.getNum());
    assertSame(transactionIds, transactionIds2);
  }

  /**
   * Method under test:
   * {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  public void testNewRecentTransactionItem3() {
    // Arrange
    ArrayList<String> transactionIds = new ArrayList<>();
    transactionIds.add("42");
    transactionIds.add("foo");

    // Act
    RecentTransactionItem actualRecentTransactionItem = new RecentTransactionItem(1L, transactionIds);

    // Assert
    assertEquals(1L, actualRecentTransactionItem.getNum());
    assertSame(transactionIds, actualRecentTransactionItem.getTransactionIds());
  }
}
