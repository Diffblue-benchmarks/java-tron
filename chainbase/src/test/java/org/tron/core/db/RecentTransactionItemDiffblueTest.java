package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RecentTransactionItemDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RecentTransactionItem#RecentTransactionItem()}
   *   <li>{@link RecentTransactionItem#setNum(long)}
   *   <li>{@link RecentTransactionItem#setTransactionIds(List)}
   *   <li>{@link RecentTransactionItem#getNum()}
   *   <li>{@link RecentTransactionItem#getTransactionIds()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RecentTransactionItem.<init>()",
    "long RecentTransactionItem.getNum()",
    "List RecentTransactionItem.getTransactionIds()",
    "void RecentTransactionItem.setNum(long)",
    "void RecentTransactionItem.setTransactionIds(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RecentTransactionItem actualRecentTransactionItem = new RecentTransactionItem();
    actualRecentTransactionItem.setNum(1L);
    ArrayList<String> transactionIds = new ArrayList<>();
    actualRecentTransactionItem.setTransactionIds(transactionIds);
    long actualNum = actualRecentTransactionItem.getNum();
    List<String> actualTransactionIds = actualRecentTransactionItem.getTransactionIds();

    // Assert
    assertEquals(1L, actualNum);
    assertTrue(actualTransactionIds.isEmpty());
    assertSame(transactionIds, actualTransactionIds);
  }

  /**
   * Test {@link RecentTransactionItem#RecentTransactionItem(long, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RecentTransactionItem.<init>(long, List)"})
  public void testNewRecentTransactionItem_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> transactionIds = new ArrayList<>();
    transactionIds.add("42");
    transactionIds.add("foo");

    // Act
    RecentTransactionItem actualRecentTransactionItem =
        new RecentTransactionItem(1L, transactionIds);

    // Assert
    assertEquals(1L, actualRecentTransactionItem.getNum());
    assertSame(transactionIds, actualRecentTransactionItem.getTransactionIds());
  }

  /**
   * Test {@link RecentTransactionItem#RecentTransactionItem(long, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return TransactionIds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RecentTransactionItem.<init>(long, List)"})
  public void testNewRecentTransactionItem_givenFoo_thenReturnTransactionIdsIsArrayList() {
    // Arrange
    ArrayList<String> transactionIds = new ArrayList<>();
    transactionIds.add("foo");

    // Act
    RecentTransactionItem actualRecentTransactionItem =
        new RecentTransactionItem(1L, transactionIds);

    // Assert
    assertEquals(1L, actualRecentTransactionItem.getNum());
    assertSame(transactionIds, actualRecentTransactionItem.getTransactionIds());
  }

  /**
   * Test {@link RecentTransactionItem#RecentTransactionItem(long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return TransactionIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link RecentTransactionItem#RecentTransactionItem(long, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RecentTransactionItem.<init>(long, List)"})
  public void testNewRecentTransactionItem_whenArrayList_thenReturnTransactionIdsEmpty() {
    // Arrange and Act
    RecentTransactionItem actualRecentTransactionItem =
        new RecentTransactionItem(1L, new ArrayList<>());

    // Assert
    assertEquals(1L, actualRecentTransactionItem.getNum());
    assertTrue(actualRecentTransactionItem.getTransactionIds().isEmpty());
  }
}
