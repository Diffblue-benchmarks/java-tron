package org.tron.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class CacheTypeDiffblueTest {
  /**
   * Method under test: {@link CacheType#findByType(String)}
   */
  @Test
  public void testFindByType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheType.findByType("Type"));
    assertEquals(CacheType.witnessStandby, CacheType.findByType("witnessStandby"));
  }

  /**
   * Method under test: {@link CacheType#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("witnessStandby", CacheType.valueOf("witnessStandby").toString());
  }
}
