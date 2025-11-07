package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RandomGeneratorDiffblueTest {
  /**
   * Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  public void testShuffle() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();
    ArrayList<Object> list = new ArrayList<>();

    // Act
    List<Object> actualShuffleResult = randomGenerator.shuffle(list, 10L);

    // Assert
    assertTrue(actualShuffleResult.isEmpty());
    assertSame(list, actualShuffleResult);
  }

  /**
   * Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  public void testShuffle2() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualShuffleResult = randomGenerator.shuffle(list, 10L);

    // Assert
    assertEquals(1, actualShuffleResult.size());
    assertEquals("42", actualShuffleResult.get(0));
    assertSame(list, actualShuffleResult);
  }

  /**
   * Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  public void testShuffle3() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act and Assert
    assertSame(list, randomGenerator.shuffle(list, 10L));
  }

  /**
   * Method under test: {@link RandomGenerator#shuffle(List, long)}
   */
  @Test
  public void testShuffle4() {
    // Arrange
    RandomGenerator<Object> randomGenerator = new RandomGenerator<>();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act and Assert
    assertSame(list, randomGenerator.shuffle(list, -1L));
  }
}
