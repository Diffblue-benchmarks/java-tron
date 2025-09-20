package org.tron.core.vm.config;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VMConfigDiffblueTest {
  /**
   * Test {@link VMConfig#vmTrace()}.
   *
   * <p>Method under test: {@link VMConfig#vmTrace()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VMConfig.vmTrace()"})
  public void testVmTrace() {
    // Arrange, Act and Assert
    assertFalse(VMConfig.vmTrace());
  }

  /**
   * Test {@link VMConfig#vmTraceCompressed()}.
   *
   * <p>Method under test: {@link VMConfig#vmTraceCompressed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VMConfig.vmTraceCompressed()"})
  public void testVmTraceCompressed() {
    // Arrange, Act and Assert
    assertFalse(VMConfig.vmTraceCompressed());
  }
}
