package org.tron.core.services.ratelimiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.adapter.IRateLimiter;

public class RateLimiterContainerDiffblueTest {
  /**
   * Test {@link RateLimiterContainer#add(String, String, IRateLimiter)}.
   * <p>
   * Method under test: {@link RateLimiterContainer#add(String, String, IRateLimiter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterContainer.add(String, String, IRateLimiter)"})
  public void testAdd() {
    // Arrange
    RateLimiterContainer rateLimiterContainer = new RateLimiterContainer();
    IRateLimiter rateLimiter = mock(IRateLimiter.class);

    // Act
    rateLimiterContainer.add("Prefix", "Method", rateLimiter);

    // Assert
    Map<String, IRateLimiter> map = rateLimiterContainer.getMap();
    assertEquals(1, map.size());
    assertSame(rateLimiter, map.get("PrefixMethod"));
  }

  /**
   * Test {@link RateLimiterContainer#get(String, String)}.
   * <p>
   * Method under test: {@link RateLimiterContainer#get(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IRateLimiter RateLimiterContainer.get(String, String)"})
  public void testGet() {
    // Arrange, Act and Assert
    assertNull((new RateLimiterContainer()).get("Prefix", "Method"));
  }

  /**
   * Test {@link RateLimiterContainer#getMap()}.
   * <p>
   * Method under test: {@link RateLimiterContainer#getMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map RateLimiterContainer.getMap()"})
  public void testGetMap() {
    // Arrange, Act and Assert
    assertTrue((new RateLimiterContainer()).getMap().isEmpty());
  }
}
