package org.tron.core.vm.config;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VMConfig.vmTraceCompressed()"})
  public void testVmTraceCompressed() {
    // Arrange, Act and Assert
    assertFalse(VMConfig.vmTraceCompressed());
  }
}
