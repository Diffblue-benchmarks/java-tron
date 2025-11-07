package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Test;
import org.mockito.Mockito;

public class CollectionUtilsDiffblueTest {
  /**
   * Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  public void testCollectList() {
    // Arrange and Act
    List<Object> actualCollectListResult = CollectionUtils.<Object, Object>collectList(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualCollectListResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  public void testCollectList2() {
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
   * Method under test: {@link CollectionUtils#collectList(Collection, Function)}
   */
  @Test
  public void testCollectList3() {
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
   * Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  public void testCollectSet() {
    // Arrange and Act
    Set<Object> actualCollectSetResult = CollectionUtils.<Object, Object>collectSet(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualCollectSetResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  public void testCollectSet2() {
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
   * Method under test: {@link CollectionUtils#collectSet(Collection, Function)}
   */
  @Test
  public void testCollectSet3() {
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
   * Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  public void testTruncate() {
    // Arrange and Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualTruncateResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  public void testTruncate2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(items, 1);

    // Assert
    assertEquals(1, actualTruncateResult.size());
    assertEquals("42", actualTruncateResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  public void testTruncate3() {
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
   * Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  public void testTruncate4() {
    // Arrange and Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(new ArrayList<>(), 0);

    // Assert
    assertTrue(actualTruncateResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#truncate(List, int)}
   */
  @Test
  public void testTruncate5() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateResult = CollectionUtils.truncate(items, 0);

    // Assert
    assertEquals(1, actualTruncateResult.size());
    assertEquals("42", actualTruncateResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom() {
    // Arrange and Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(new ArrayList<>(), 1, 1);

    // Assert
    assertTrue(actualTruncateRandomResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom2() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 1, 1);

    // Assert
    assertEquals(1, actualTruncateRandomResult.size());
    assertEquals("42", actualTruncateRandomResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom3() {
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
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom4() {
    // Arrange and Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(new ArrayList<>(), 0, 1);

    // Assert
    assertTrue(actualTruncateRandomResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom5() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 0, 1);

    // Assert
    assertEquals(1, actualTruncateRandomResult.size());
    assertEquals("42", actualTruncateRandomResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom6() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    List<Object> actualTruncateRandomResult = CollectionUtils.truncateRandom(items, 1, 0);

    // Assert
    assertEquals(1, actualTruncateRandomResult.size());
    assertEquals("42", actualTruncateRandomResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtils#truncateRandom(List, int, int)}
   */
  @Test
  public void testTruncateRandom7() {
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
   * Method under test: {@link CollectionUtils#selectList(Collection, Predicate)}
   */
  @Test
  public void testSelectList() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();

    // Act
    List<Object> actualSelectListResult = CollectionUtils.selectList(items, new ByteArrayMap<>()::containsKey);

    // Assert
    assertTrue(actualSelectListResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtils#selectSet(Collection, Predicate)}
   */
  @Test
  public void testSelectSet() {
    // Arrange
    ArrayList<Object> items = new ArrayList<>();

    // Act
    Set<Object> actualSelectSetResult = CollectionUtils.selectSet(items, new ByteArrayMap<>()::containsKey);

    // Assert
    assertTrue(actualSelectSetResult.isEmpty());
  }
}
