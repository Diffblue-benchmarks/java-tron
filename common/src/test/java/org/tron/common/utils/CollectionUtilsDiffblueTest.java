package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class CollectionUtilsDiffblueTest {
  /**
   * Test {@link CollectionUtils#collectList(Collection, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.collectList(Collection, Function)"})
  public void testCollectList_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Function<Object, Object> collector = mock(Function.class);
    when(collector.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List<Object> actualCollectListResult = CollectionUtils.collectList(items, collector);

    // Assert
    verify(collector).apply(isA(Object.class));
    assertEquals(1, actualCollectListResult.size());
    assertEquals("Apply", actualCollectListResult.get(0));
  }

  /**
   * Test {@link CollectionUtils#collectList(Collection, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.collectList(Collection, Function)"})
  public void testCollectList_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    Function<Object, Object> collector = mock(Function.class);
    when(collector.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List<Object> actualCollectListResult = CollectionUtils.collectList(items, collector);

    // Assert
    verify(collector, atLeast(1)).apply(isA(Object.class));
    assertEquals(2, actualCollectListResult.size());
    assertEquals("Apply", actualCollectListResult.get(0));
    assertEquals("Apply", actualCollectListResult.get(1));
  }

  /**
   * Test {@link CollectionUtils#collectList(Collection, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.collectList(Collection, Function)"})
  public void testCollectList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualCollectListResult =
        CollectionUtils.collectList(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualCollectListResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#collectSet(Collection, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.collectSet(Collection, Function)"})
  public void testCollectSet_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Function<Object, Object> collector = mock(Function.class);
    when(collector.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualCollectSetResult = CollectionUtils.collectSet(items, collector);

    // Assert
    verify(collector).apply(isA(Object.class));
    assertEquals(1, actualCollectSetResult.size());
  }

  /**
   * Test {@link CollectionUtils#collectSet(Collection, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.collectSet(Collection, Function)"})
  public void testCollectSet_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    Function<Object, Object> collector = mock(Function.class);
    when(collector.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualCollectSetResult = CollectionUtils.collectSet(items, collector);

    // Assert
    verify(collector, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualCollectSetResult.size());
  }

  /**
   * Test {@link CollectionUtils#collectSet(Collection, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.collectSet(Collection, Function)"})
  public void testCollectSet_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualCollectSetResult =
        CollectionUtils.collectSet(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualCollectSetResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#truncate(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncate(List, int)"})
  public void testTruncate_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(items, 1);

    // Assert
    assertEquals(items, actualTruncateResult);
  }

  /**
   * Test {@link CollectionUtils#truncate(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncate(List, int)"})
  public void testTruncate_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    // Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(items, 1);

    // Assert
    assertEquals(1, actualTruncateResult.size());
    assertEquals("42", actualTruncateResult.get(0));
  }

  /**
   * Test {@link CollectionUtils#truncate(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When zero.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncate(List, int)"})
  public void testTruncate_given42_whenZero_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(items, 0);

    // Assert
    assertEquals(items, actualTruncateResult);
  }

  /**
   * Test {@link CollectionUtils#truncate(List, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncate(List, int)"})
  public void testTruncate_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualTruncateResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#truncate(List, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncate(List, int)"})
  public void testTruncate_whenZero_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(new ArrayList<>(), 0);

    // Assert
    assertTrue(actualTruncateResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 1, 1);

    // Assert
    assertEquals(items, actualTruncateRandomResult);
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 1, 1);

    // Assert
    assertEquals(1, actualTruncateRandomResult.size());
    assertEquals("42", actualTruncateRandomResult.get(0));
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When two.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_given42_whenTwo_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 2, 1);

    // Assert
    assertEquals(items, actualTruncateRandomResult);
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When zero.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_given42_whenZero_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 0, 1);

    // Assert
    assertEquals(items, actualTruncateRandomResult);
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When zero.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_given42_whenZero_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 1, 0);

    // Assert
    assertEquals(items, actualTruncateRandomResult);
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualTruncateRandomResult =
        CollectionUtils.truncateRandom(new ArrayList<>(), 1, 1);

    // Assert
    assertTrue(actualTruncateRandomResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#truncateRandom(List, int, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.truncateRandom(List, int, int)"})
  public void testTruncateRandom_whenArrayList_thenReturnEmpty2() {
    // Arrange and Act
    List<Object> actualTruncateRandomResult =
        CollectionUtils.truncateRandom(new ArrayList<>(), 0, 1);

    // Assert
    assertTrue(actualTruncateRandomResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectList(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectList(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.selectList(Collection, Predicate)"})
  public void testSelectList_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    List<Object> actualSelectListResult = CollectionUtils.selectList(items, predicate);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectList(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectList(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.selectList(Collection, Predicate)"})
  public void testSelectList_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    List<Object> actualSelectListResult = CollectionUtils.selectList(items, predicate);

    // Assert
    verify(predicate, atLeast(1)).test(isA(Object.class));
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectList(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectList(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.selectList(Collection, Predicate)"})
  public void testSelectList_givenTrue_whenPredicateTestReturnTrue_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    List<Object> actualSelectListResult = CollectionUtils.selectList(items, predicate);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals(items, actualSelectListResult);
  }

  /**
   * Test {@link CollectionUtils#selectList(Collection, Predicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectList(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CollectionUtils.selectList(Collection, Predicate)"})
  public void testSelectList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSelectListResult =
        CollectionUtils.selectList(new ArrayList<>(), mock(Predicate.class));

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectSet(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectSet(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.selectSet(Collection, Predicate)"})
  public void testSelectSet_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    Set<Object> actualSelectSetResult = CollectionUtils.selectSet(items, predicate);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertTrue(actualSelectSetResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectSet(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectSet(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.selectSet(Collection, Predicate)"})
  public void testSelectSet_givenFalse_whenPredicateTestReturnFalse_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    Set<Object> actualSelectSetResult = CollectionUtils.selectSet(items, predicate);

    // Assert
    verify(predicate, atLeast(1)).test(isA(Object.class));
    assertTrue(actualSelectSetResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtils#selectSet(Collection, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectSet(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.selectSet(Collection, Predicate)"})
  public void testSelectSet_givenTrue_whenPredicateTestReturnTrue_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    Set<Object> actualSelectSetResult = CollectionUtils.selectSet(items, predicate);

    // Assert
    verify(predicate).test(isA(Object.class));
    assertEquals(1, actualSelectSetResult.size());
  }

  /**
   * Test {@link CollectionUtils#selectSet(Collection, Predicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtils#selectSet(Collection, Predicate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CollectionUtils.selectSet(Collection, Predicate)"})
  public void testSelectSet_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualSelectSetResult =
        CollectionUtils.selectSet(new ArrayList<>(), mock(Predicate.class));

    // Assert
    assertTrue(actualSelectSetResult.isEmpty());
  }
}
