package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpDiffblueTest {
  /**
   * Test {@link Op#getNameOf(byte)} with {@code byte}.
   *
   * <p>Method under test: {@link Op#getNameOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Op.getNameOf(byte)"})
  public void testGetNameOfWithByte() {
    // Arrange, Act and Assert
    assertEquals("COINBASE", Op.getNameOf((byte) 'A'));
  }

  /**
   * Test {@link Op#getNameOf(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link Op#getNameOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Op.getNameOf(int)"})
  public void testGetNameOfWithInt_whenOne_thenReturnAdd() {
    // Arrange, Act and Assert
    assertEquals("ADD", Op.getNameOf(1));
  }
}
