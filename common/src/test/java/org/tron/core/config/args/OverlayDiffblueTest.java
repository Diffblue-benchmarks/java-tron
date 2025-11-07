package org.tron.core.config.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class OverlayDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Overlay}
   *   <li>{@link Overlay#getPort()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new Overlay()).getPort());
  }

  /**
   * Method under test: {@link Overlay#setPort(int)}
   */
  @Test
  public void testSetPort() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    overlay.setPort(8080);

    // Assert
    assertEquals(8080, overlay.getPort());
  }

  /**
   * Method under test: {@link Overlay#setPort(int)}
   */
  @Test
  public void testSetPort2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Overlay()).setPort(-1));
  }
}
