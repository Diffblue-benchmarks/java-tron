package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SetAdapterDiffblueTest {
  /**
   * Test {@link SetAdapter#SetAdapter(Map)}.
   *
   * <p>Method under test: {@link SetAdapter#SetAdapter(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetAdapter.<init>(Map)"})
  public void testNewSetAdapter() {
    // Arrange and Act
    SetAdapter<Object> actualObjectSet = new SetAdapter<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectSet.isEmpty());
  }

  /**
   * Test {@link SetAdapter#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#contains(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.contains(Object)"})
  public void testContains_givenHashMap42Is42_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> delegate = new HashMap<>();
    delegate.put("42", "42");
    SetAdapter<Object> objectSet = new SetAdapter<>(delegate);

    // Act and Assert
    assertTrue(objectSet.contains("42"));
  }

  /**
   * Test {@link SetAdapter#contains(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#contains(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.contains(Object)"})
  public void testContains_thenReturnFalse() {
    // Arrange
    SetAdapter<Object> objectSet = new SetAdapter<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectSet.contains("42"));
  }

  /**
   * Test {@link SetAdapter#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.add(Object)"})
  public void testAdd_givenHashMap42Is42_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> delegate = new HashMap<>();
    delegate.put("42", "42");
    SetAdapter<Object> objectSet = new SetAdapter<>(delegate);

    // Act
    boolean actualAddResult = objectSet.add("42");

    // Assert
    assertEquals(1, objectSet.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link SetAdapter#add(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.add(Object)"})
  public void testAdd_thenReturnTrue() {
    // Arrange
    SetAdapter<Object> objectSet = new SetAdapter<>(new HashMap<>());

    // Act
    boolean actualAddResult = objectSet.add("42");

    // Assert
    assertEquals(1, objectSet.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link SetAdapter#remove(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#remove(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.remove(Object)"})
  public void testRemove_givenHashMap42Is42_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> delegate = new HashMap<>();
    delegate.put("42", "42");
    SetAdapter<Object> objectSet = new SetAdapter<>(delegate);

    // Act
    boolean actualRemoveResult = objectSet.remove("42");

    // Assert
    assertTrue(objectSet.isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link SetAdapter#remove(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SetAdapter#remove(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.remove(Object)"})
  public void testRemove_thenReturnFalse() {
    // Arrange
    SetAdapter<Object> objectSet = new SetAdapter<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectSet.remove("42"));
    assertTrue(objectSet.isEmpty());
  }

  /**
   * Test {@link SetAdapter#addAll(Collection)}.
   *
   * <p>Method under test: {@link SetAdapter#addAll(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.addAll(Collection)"})
  public void testAddAll() {
    // Arrange
    SetAdapter<Object> objectSet = new SetAdapter<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectSet.addAll(new ArrayList<>()));
  }

  /**
   * Test {@link SetAdapter#removeAll(Collection)}.
   *
   * <p>Method under test: {@link SetAdapter#removeAll(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SetAdapter.removeAll(Collection)"})
  public void testRemoveAll() {
    // Arrange
    SetAdapter<Object> objectSet = new SetAdapter<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectSet.removeAll(new ArrayList<>()));
  }
}
