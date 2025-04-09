package org.tron.core.config.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OverlayDiffblueTest {
  /**
   * Test {@link Overlay#setPort(int)}.
   * <ul>
   *   <li>When {@code 8080}.</li>
   *   <li>Then {@link Overlay} (default constructor) Port is {@code 8080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Overlay#setPort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Overlay.setPort(int)"})
  public void testSetPort_when8080_thenOverlayPortIs8080() {
    // Arrange
    Overlay overlay = new Overlay();

    // Act
    overlay.setPort(8080);

    // Assert
    assertEquals(8080, overlay.getPort());
  }

  /**
   * Test {@link Overlay#setPort(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Overlay#setPort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Overlay.setPort(int)"})
  public void testSetPort_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Overlay()).setPort(-1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Overlay}
   *   <li>{@link Overlay#getPort()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Overlay.<init>()", "int Overlay.getPort()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new Overlay()).getPort());
  }
}
