package org.tron.core.services.ratelimiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.services.ratelimiter.adapter.IRateLimiter;

@ContextConfiguration(classes = {RateLimiterContainer.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RateLimiterContainerDiffblueTest {
  @Autowired
  private RateLimiterContainer rateLimiterContainer;

  /**
   * Method under test:
   * {@link RateLimiterContainer#add(String, String, IRateLimiter)}
   */
  @Test
  public void testAdd() {
    // Arrange
    IRateLimiter rateLimiter = mock(IRateLimiter.class);

    // Act
    rateLimiterContainer.add("Prefix", "Method", rateLimiter);

    // Assert
    Map<String, IRateLimiter> map = rateLimiterContainer.getMap();
    assertEquals(1, map.size());
    assertSame(rateLimiter, map.get("PrefixMethod"));
  }

  /**
   * Method under test: {@link RateLimiterContainer#get(String, String)}
   */
  @Test
  public void testGet() {
    // Arrange, Act and Assert
    assertNull(rateLimiterContainer.get("Prefix", "Method"));
  }

  /**
   * Method under test: {@link RateLimiterContainer#getMap()}
   */
  @Test
  public void testGetMap() {
    // Arrange, Act and Assert
    assertTrue((new RateLimiterContainer()).getMap().isEmpty());
  }
}
