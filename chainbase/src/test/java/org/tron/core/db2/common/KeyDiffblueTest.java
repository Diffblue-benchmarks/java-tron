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

public class KeyDiffblueTest {
  /**
   * Test {@link Key#copyOf(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#copyOf(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.copyOf(byte[])"})
  public void testCopyOf_whenAxaxaxaxBytesIsUtf8_thenReturnBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualCopyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualCopyOfResult.getBytes());
  }

  /**
   * Test {@link Key#copyOf(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Bytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#copyOf(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.copyOf(byte[])"})
  public void testCopyOf_whenNull_thenReturnBytesIsNull() {
    // Arrange, Act and Assert
    assertNull(Key.copyOf(null).getBytes());
  }

  /**
   * Test {@link Key#of(byte[])}.
   * <p>
   * Method under test: {@link Key#of(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Key Key.of(byte[])"})
  public void testOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Key actualOfResult = Key.of("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualOfResult.getBytes());
  }

  /**
   * Test {@link Key#getBytes()}.
   * <ul>
   *   <li>Given copyOf {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Key.getBytes()"})
  public void testGetBytes_givenCopyOfAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Key.copyOf("AXAXAXAX".getBytes("UTF-8")).getBytes();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test {@link Key#getBytes()}.
   * <ul>
   *   <li>Given copyOf {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#getBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Key.getBytes()"})
  public void testGetBytes_givenCopyOfNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Key.copyOf(null).getBytes());
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key copyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));
    Key copyOfResult2 = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult2);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult2.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}, and {@link Key#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Key#equals(Object)}
   *   <li>{@link Key#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Key copyOfResult = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(copyOfResult, copyOfResult);
    int expectedHashCodeResult = copyOfResult.hashCode();
    assertEquals(expectedHashCodeResult, copyOfResult.hashCode());
  }

  /**
   * Test {@link Key#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Key copyOfResult = Key.copyOf(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNotEquals(copyOfResult, Key.copyOf("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Key#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.copyOf("AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test {@link Key#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Key#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Key.equals(Object)", "int Key.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNotEquals(Key.copyOf("AXAXAXAX".getBytes("UTF-8")), "Different type to Key");
  }
}
