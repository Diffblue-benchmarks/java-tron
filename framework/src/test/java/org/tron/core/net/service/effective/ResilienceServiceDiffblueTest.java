package org.tron.core.net.service.effective;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.net.service.effective.ResilienceService.WeightedRandom;

public class ResilienceServiceDiffblueTest {
  /**
   * Test WeightedRandom {@link WeightedRandom#next()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is one.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeightedRandom#next()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object WeightedRandom.next()"})
  public void testWeightedRandomNext_givenHashMap42IsOne_thenReturn42() {
    // Arrange
    HashMap<Object, Integer> weights = new HashMap<>();
    weights.put("42", 1);

    // Act and Assert
    assertEquals("42", (new WeightedRandom(weights)).next());
  }
}
