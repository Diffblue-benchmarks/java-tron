package org.tron.core.actuator;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ActuatorFactoryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link ActuatorFactory#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ActuatorFactory ActuatorFactory.getInstance()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertSame(ActuatorFactory.INSTANCE, ActuatorFactory.getInstance().getInstance());
  }
}
