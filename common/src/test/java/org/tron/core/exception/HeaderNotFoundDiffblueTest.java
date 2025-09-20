package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HeaderNotFoundDiffblueTest {
  /**
   * Test {@link HeaderNotFound#HeaderNotFound(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link HeaderNotFound#HeaderNotFound(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HeaderNotFound.<init>()", "void HeaderNotFound.<init>(String)"})
  public void testNewHeaderNotFound_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    HeaderNotFound actualHeaderNotFound = new HeaderNotFound("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualHeaderNotFound.getMessage());
    assertNull(actualHeaderNotFound.getCause());
    assertEquals(0, actualHeaderNotFound.getSuppressed().length);
  }

  /**
   * Test {@link HeaderNotFound#HeaderNotFound()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HeaderNotFound#HeaderNotFound()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HeaderNotFound.<init>()", "void HeaderNotFound.<init>(String)"})
  public void testNewHeaderNotFound_thenReturnMessageIsNull() {
    // Arrange and Act
    HeaderNotFound actualHeaderNotFound = new HeaderNotFound();

    // Assert
    assertNull(actualHeaderNotFound.getMessage());
    assertNull(actualHeaderNotFound.getCause());
    assertEquals(0, actualHeaderNotFound.getSuppressed().length);
  }
}
