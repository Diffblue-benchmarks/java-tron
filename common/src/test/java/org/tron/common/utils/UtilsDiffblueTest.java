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
   * <p>
   * Method under test: {@link Utils#getBytes(char[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utils.getBytes(char[])"})
  public void testGetBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualBytes = Utils.getBytes("AZAZ".toCharArray());

    // Assert
    assertArrayEquals("AZAZ".getBytes("UTF-8"), actualBytes);
  }

  /**
   * Test {@link Utils#getIdShort(String)}.
   * <ul>
   *   <li>When {@code 42<null>}.</li>
   *   <li>Then return {@code 42<null>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#getIdShort(String)}
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code <null>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#getIdShort(String)}
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
   * <p>
   * Method under test: {@link Utils#clone(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Utils.clone(byte[])"})
  public void testClone() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCloneResult = Utils.clone("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCloneResult);
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code A42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_when42_thenReturnA42() {
    // Arrange, Act and Assert
    assertEquals("A42", Utils.align("42", 'A', 3, true));
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code 42A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_whenFalse_thenReturn42a() {
    // Arrange, Act and Assert
    assertEquals("42A", Utils.align("42", 'A', 3, false));
  }

  /**
   * Test {@link Utils#align(String, char, int, boolean)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#align(String, char, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.align(String, char, int, boolean)"})
  public void testAlign_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", Utils.align("foo", 'A', 3, true));
  }

  /**
   * Test {@link Utils#repeat(String, int)}.
   * <p>
   * Method under test: {@link Utils#repeat(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Utils.repeat(String, int)"})
  public void testRepeat() {
    // Arrange, Act and Assert
    assertEquals("foo", Utils.repeat("foo", 1));
  }
}
