package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecodeResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeResult#DecodeResult(int, Object)}
   *   <li>{@link DecodeResult#toString()}
   *   <li>{@link DecodeResult#getDecoded()}
   *   <li>{@link DecodeResult#getPos()}
   * </ul>
   */
  @Test
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
