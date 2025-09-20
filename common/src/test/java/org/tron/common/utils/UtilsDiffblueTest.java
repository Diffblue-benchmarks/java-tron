package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UtilsDiffblueTest {
  /**
   * Test {@link Utils#getBytes(char[])}.
   *
   * <p>Method under test: {@link Utils#getBytes(char[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utils.getBytes(char[])"})
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("AZAZ".getBytes("UTF-8"), Utils.getBytes("AZAZ".toCharArray()));
  }

  /**
   * Test {@link Utils#getIdShort(String)}.
   *
   * <ul>
   *   <li>When {@code 42<null>}.
   *   <li>Then return {@code 42<null>}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#getIdShort(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.getIdShort(String)"})
  public void testGetIdShort_when42Null_thenReturn42Null() {
    // Arrange, Act and Assert
    assertEquals("42<null>", Utils.getIdShort("42<null>"));
  }

  /**
   * Test {@link Utils#getIdShort(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code <null>}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#getIdShort(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.getIdShort(String)"})
  public void testGetIdShort_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("<null>", Utils.getIdShort(null));
  }

  /**
   * Test {@link Utils#clone(byte[])}.
   *
   * <p>Method under test: {@link Utils#clone(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utils.clone(byte[])"})
  public void testClone() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), Utils.clone("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code A42}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_when42_thenReturnA42() {
    // Arrange and Act
    String actualAlignResult = Utils.align("42", 'A', 3, true);

    // Assert
    assertEquals("A42", actualAlignResult);
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code 42A}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_whenFalse_thenReturn42a() {
    // Arrange and Act
    String actualAlignResult = Utils.align("42", 'A', 3, false);

    // Assert
    assertEquals("42A", actualAlignResult);
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_whenFoo_thenReturnFoo() {
    // Arrange and Act
    String actualAlignResult = Utils.align("foo", 'A', 3, true);

    // Assert
    assertEquals("foo", actualAlignResult);
  }

  /**
   * Test {@link Utils#repeat(String, int)}.
   *
   * <p>Method under test: {@link Utils#repeat(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.repeat(String, int)"})
  public void testRepeat() {
    // Arrange, Act and Assert
    assertEquals("foo", Utils.repeat("foo", 1));
  }
}
