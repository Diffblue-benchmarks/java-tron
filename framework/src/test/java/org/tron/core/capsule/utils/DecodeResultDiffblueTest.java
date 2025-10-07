package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DecodeResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DecodeResult#DecodeResult(int, Object)}
   *   <li>{@link DecodeResult#toString()}
   *   <li>{@link DecodeResult#getDecoded()}
   *   <li>{@link DecodeResult#getPos()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DecodeResult.<init>(int, Object)",
    "Object DecodeResult.getDecoded()",
    "int DecodeResult.getPos()",
    "String DecodeResult.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DecodeResult actualDecodeResult = new DecodeResult(1, "Decoded");
    String actualToStringResult = actualDecodeResult.toString();
    Object actualDecoded = actualDecodeResult.getDecoded();

    // Assert
    assertEquals("Decoded", actualToStringResult);
    assertEquals("Decoded", actualDecoded);
    assertEquals(1, actualDecodeResult.getPos());
  }
}
