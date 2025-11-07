package org.tron.core.services.ratelimiter;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeDataDiffblueTest {
  /**
   * Test {@link RuntimeData#RuntimeData(Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return RemoteAddr is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeData#RuntimeData(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeData.<init>(Object)"})
  public void testNewRuntimeData_when42_thenReturnRemoteAddrIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new RuntimeData("42")).getRemoteAddr());
  }

  /**
   * Test {@link RuntimeData#getRemoteAddr()}.
   * <p>
   * Method under test: {@link RuntimeData#getRemoteAddr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RuntimeData.getRemoteAddr()"})
  public void testGetRemoteAddr() {
    // Arrange, Act and Assert
    assertEquals("", (new RuntimeData("42")).getRemoteAddr());
  }
}
