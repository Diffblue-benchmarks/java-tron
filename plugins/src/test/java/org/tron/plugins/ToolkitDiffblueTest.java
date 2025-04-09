package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ToolkitDiffblueTest {
  /**
   * Test {@link Toolkit#call()}.
   * <p>
   * Method under test: {@link Toolkit#call()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer Toolkit.call()"})
  public void testCall() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new Toolkit()).call().intValue());
  }
}
