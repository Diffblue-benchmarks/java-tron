package org.tron.core.services.ratelimiter.adapter;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.RuntimeData;

public class GlobalPreemptibleAdapterDiffblueTest {
  /**
   * Test {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleAdapter.<init>(String)"})
  public void testNewGlobalPreemptibleAdapter_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(new GlobalPreemptibleAdapter("").acquire(null));
  }

  /**
   * Test {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}.
   *
   * <ul>
   *   <li>When {@code Param String}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleAdapter.<init>(String)"})
  public void testNewGlobalPreemptibleAdapter_whenParamString() {
    // Arrange, Act and Assert
    assertTrue(new GlobalPreemptibleAdapter("Param String").acquire(null));
  }

  /**
   * Test {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}.
   *
   * <ul>
   *   <li>When {@code UUU=UUU}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalPreemptibleAdapter#GlobalPreemptibleAdapter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleAdapter.<init>(String)"})
  public void testNewGlobalPreemptibleAdapter_whenUuuUuu() {
    // Arrange, Act and Assert
    assertTrue(new GlobalPreemptibleAdapter("UUU=UUU").acquire(null));
  }

  /**
   * Test {@link GlobalPreemptibleAdapter#acquire(RuntimeData)}.
   *
   * <p>Method under test: {@link GlobalPreemptibleAdapter#acquire(RuntimeData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GlobalPreemptibleAdapter.acquire(RuntimeData)"})
  public void testAcquire() {
    // Arrange
    GlobalPreemptibleAdapter globalPreemptibleAdapter =
        new GlobalPreemptibleAdapter("Param String");

    // Act
    boolean actualAcquireResult = globalPreemptibleAdapter.acquire(new RuntimeData("42"));

    // Assert
    assertTrue(actualAcquireResult);
  }
}
