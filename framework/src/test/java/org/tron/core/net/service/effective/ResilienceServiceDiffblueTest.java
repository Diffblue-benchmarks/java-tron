package org.tron.core.net.service.effective;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.net.service.effective.ResilienceService.WeightedRandom;

public class ResilienceServiceDiffblueTest {
  /**
   * Test WeightedRandom {@link WeightedRandom#next()}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return one.
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link WeightedRandom#next()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WeightedRandom.next()"})
  public void testWeightedRandomNext_givenBiFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    BiFunction<Object, Integer, Integer> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<Object>any(), Mockito.<Integer>any())).thenReturn(1);

    HashMap<Object, Integer> weights = new HashMap<>();
    weights.put(42, -1);
    weights.put("42", Integer.MIN_VALUE);
    weights.replaceAll(biFunction);

    // Act
    new WeightedRandom(weights).next();

    // Assert
    verify(biFunction, atLeast(1)).apply(Mockito.<Object>any(), Mockito.<Integer>any());
  }

  /**
   * Test WeightedRandom {@link WeightedRandom#next()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is one.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link WeightedRandom#next()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WeightedRandom.next()"})
  public void testWeightedRandomNext_givenHashMap42IsOne_thenReturn42() {
    // Arrange
    HashMap<Object, Integer> weights = new HashMap<>();
    weights.put("42", 1);

    // Act and Assert
    assertEquals("42", new WeightedRandom(weights).next());
  }
}
