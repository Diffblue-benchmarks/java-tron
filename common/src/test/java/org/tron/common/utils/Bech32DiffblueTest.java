package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Bech32DiffblueTest {
  /**
   * Test {@link Bech32#encode(String, byte[])} with {@code hrp}, {@code values}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code hrp1vhqs52}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Bech32#encode(String, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Bech32.encode(String, byte[])"})
  public void testEncodeWithHrpValues_whenEmptyArrayOfByte_thenReturnHrp1vhqs52() {
    // Arrange, Act and Assert
    assertEquals("hrp1vhqs52", Bech32.encode("Hrp", new byte[]{}));
  }
}
