package org.tron.common.runtime;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuntimeImpl}
   *   <li>{@link RuntimeImpl#getActuator2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuntimeImpl.<init>()",
    "org.tron.core.actuator.Actuator2 RuntimeImpl.getActuator2()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new RuntimeImpl().getActuator2());
  }
}
