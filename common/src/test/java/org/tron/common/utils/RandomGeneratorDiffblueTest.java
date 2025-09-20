package org.tron.common.utils;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RandomGeneratorDiffblueTest {
  /**
   * Test {@link RandomGenerator#shuffle(List, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RandomGenerator.shuffle(List, long)"})
  public void testShuffle_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualShuffleResult = randomGenerator.shuffle(list, 10L);

    // Assert
    assertSame(list, actualShuffleResult);
  }

  /**
   * Test {@link RandomGenerator#shuffle(List, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RandomGenerator.shuffle(List, long)"})
  public void testShuffle_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    List<Object> actualShuffleResult = randomGenerator.shuffle(list, 10L);

    // Assert
    assertSame(list, actualShuffleResult);
  }

  /**
   * Test {@link RandomGenerator#shuffle(List, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When minus one.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RandomGenerator.shuffle(List, long)"})
  public void testShuffle_given42_whenMinusOne_thenReturnArrayList() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    List<Object> actualShuffleResult = randomGenerator.shuffle(list, -1L);

    // Assert
    assertSame(list, actualShuffleResult);
  }

  /**
   * Test {@link RandomGenerator#shuffle(List, long)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RandomGenerator.shuffle(List, long)"})
  public void testShuffle_whenArrayList_thenReturnEmpty() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    // Act and Assert
    assertTrue(randomGenerator.shuffle(new ArrayList<>(), 10L).isEmpty());
  }
}
