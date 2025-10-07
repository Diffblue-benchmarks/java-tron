package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheTypeDiffblueTest {
  /**
   * Test {@link CacheType#findByType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CacheType#findByType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheType CacheType.findByType(String)"})
  public void testFindByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheType.findByType("Type"));
  }

  /**
   * Test {@link CacheType#findByType(String)}.
   *
   * <ul>
   *   <li>When {@code witnessStandby}.
   *   <li>Then return {@code witnessStandby}.
   * </ul>
   *
   * <p>Method under test: {@link CacheType#findByType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheType CacheType.findByType(String)"})
  public void testFindByType_whenWitnessStandby_thenReturnWitnessStandby() {
    // Arrange, Act and Assert
    assertEquals(CacheType.witnessStandby, CacheType.findByType("witnessStandby"));
  }

  /**
   * Test {@link CacheType#toString()}.
   *
   * <p>Method under test: {@link CacheType#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CacheType.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("witnessStandby", CacheType.valueOf("witnessStandby").toString());
  }
}
