package org.tron.core.db2.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WrappedByteArrayDiffblueTest {
  /**
   * Test {@link WrappedByteArray#of(byte[])}.
   *
   * <p>Method under test: {@link WrappedByteArray#of(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WrappedByteArray WrappedByteArray.of(byte[])"})
  public void testOf() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), WrappedByteArray.of("AXAXAXAX".getBytes("UTF-8")).getBytes());
  }

  /**
   * Test {@link WrappedByteArray#copyOf(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedByteArray#copyOf(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WrappedByteArray WrappedByteArray.copyOf(byte[])"})
  public void testCopyOf_whenAxaxaxaxBytesIsUtf8_thenReturnBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")).getBytes());
  }

  /**
   * Test {@link WrappedByteArray#copyOf(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Bytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedByteArray#copyOf(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WrappedByteArray WrappedByteArray.copyOf(byte[])"})
  public void testCopyOf_whenNull_thenReturnBytesIsNull() {
    // Arrange and Act
    WrappedByteArray actualCopyOfResult = WrappedByteArray.copyOf(null);

    // Assert
    assertNull(actualCopyOfResult.getBytes());
  }

  /**
   * Test {@link WrappedByteArray#equals(Object)}, and {@link WrappedByteArray#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WrappedByteArray#equals(Object)}
   *   <li>{@link WrappedByteArray#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedByteArray.equals(Object)", "int WrappedByteArray.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray copyOfResult = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));
    WrappedByteArray copyOfResult2 = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    assertEquals(copyOfResult.hashCode(), copyOfResult2.hashCode());
  }

  /**
   * Test {@link WrappedByteArray#equals(Object)}, and {@link WrappedByteArray#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WrappedByteArray#equals(Object)}
   *   <li>{@link WrappedByteArray#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedByteArray.equals(Object)", "int WrappedByteArray.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray copyOfResult = WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Test {@link WrappedByteArray#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WrappedByteArray#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedByteArray.equals(Object)", "int WrappedByteArray.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link WrappedByteArray#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WrappedByteArray#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedByteArray.equals(Object)", "int WrappedByteArray.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(
        WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")),
        "Different type to WrappedByteArray");
  }

  /**
   * Test {@link WrappedByteArray#getBytes()}.
   *
   * <p>Method under test: {@link WrappedByteArray#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WrappedByteArray.getBytes()"})
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        WrappedByteArray.copyOf("AXAXAXAX".getBytes("UTF-8")).getBytes());
  }
}
