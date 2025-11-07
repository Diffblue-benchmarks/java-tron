package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class HeaderNotFoundDiffblueTest {
  /**
   * Method under test: {@link HeaderNotFound#HeaderNotFound()}
   */
  @Test
  public void testNewHeaderNotFound() {
    // Arrange and Act
    HeaderNotFound actualHeaderNotFound = new HeaderNotFound();

    // Assert
    assertNull(actualHeaderNotFound.getMessage());
    assertNull(actualHeaderNotFound.getCause());
    assertEquals(0, actualHeaderNotFound.getSuppressed().length);
  }

  /**
   * Method under test: {@link HeaderNotFound#HeaderNotFound(String)}
   */
  @Test
  public void testNewHeaderNotFound2() {
    // Arrange and Act
    HeaderNotFound actualHeaderNotFound = new HeaderNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualHeaderNotFound.getMessage());
    assertNull(actualHeaderNotFound.getCause());
    assertEquals(0, actualHeaderNotFound.getSuppressed().length);
  }
}
