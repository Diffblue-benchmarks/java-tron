package org.tron.core.net.service.effective;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.Test;

public class ResilienceServiceDiffblueTest {
  /**
   * Method under test: {@link ResilienceService.WeightedRandom#next()}
   */
  @Test
  public void testWeightedRandomNext() {
    // Arrange
    HashMap<Object, Integer> weights = new HashMap<>();
    weights.put("42", 1);

    // Act and Assert
    assertEquals("42", (new ResilienceService.WeightedRandom(weights)).next());
  }

  /**
   * Method under test: {@link ResilienceService.WeightedRandom#next()}
   */
  @Test
  public void testWeightedRandomNext2() {
    // Arrange
    HashMap<Object, Integer> weights = new HashMap<>();
    weights.computeIfPresent("42", mock(BiFunction.class));
    weights.put("42", 1);

    // Act and Assert
    assertEquals("42", (new ResilienceService.WeightedRandom(weights)).next());
  }

  /**
   * Method under test: {@link ResilienceService.WeightedRandom#next()}
   */
  @Test
  public void testWeightedRandomNext3() {
    // Arrange
    HashMap<Object, Integer> weights = new HashMap<>();
    weights.put(42, 0);
    weights.computeIfPresent("42", mock(BiFunction.class));
    weights.put("42", 1);

    // Act and Assert
    assertEquals("42", (new ResilienceService.WeightedRandom(weights)).next());
  }
}
