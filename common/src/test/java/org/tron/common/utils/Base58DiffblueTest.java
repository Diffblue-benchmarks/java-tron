package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Base58DiffblueTest {
  /**
   * Test {@link Base58#encode(byte[])}, and {@link Base58#decode(String)}.
   * <ul>
   *   <li>Then return decode is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Base58.encode(byte[])", "byte[] Base58.decode(String)"})
  public void testEncodeAndDecode_thenReturnDecodeIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    byte[] input = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }

  /**
   * Test {@link Base58#encode(byte[])}, and {@link Base58#decode(String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return decode is array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Base58.encode(byte[])", "byte[] Base58.decode(String)"})
  public void testEncodeAndDecode_whenA_thenReturnDecodeIsArrayOfByteWithZeroAndX() throws IllegalArgumentException {
    // Arrange
    byte[] input = new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }

  /**
   * Test {@link Base58#encode(byte[])}, and {@link Base58#decode(String)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return decode is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Base58#encode(byte[])}
   *   <li>{@link Base58#decode(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Base58.encode(byte[])", "byte[] Base58.decode(String)"})
  public void testEncodeAndDecode_whenEmptyArrayOfByte_thenReturnDecodeIsEmptyArrayOfByte()
      throws IllegalArgumentException {
    // Arrange
    byte[] input = new byte[]{};

    // Act and Assert
    assertArrayEquals(input, Base58.decode(Base58.encode(input)));
  }
}
