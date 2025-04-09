package org.tron.core.actuator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.TransactionCapsule;

public class ActuatorFactoryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link ActuatorFactory#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ActuatorFactory ActuatorFactory.getInstance()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ActuatorFactory actualInstance = ActuatorFactory.getInstance().getInstance();

    // Assert
    assertSame(actualInstance.INSTANCE, actualInstance);
  }

  /**
   * Test {@link ActuatorFactory#createActuator(TransactionCapsule, ChainBaseManager)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActuatorFactory#createActuator(TransactionCapsule, ChainBaseManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ActuatorFactory.createActuator(TransactionCapsule, ChainBaseManager)"})
  public void testCreateActuator_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Actuator> actualCreateActuatorResult = ActuatorFactory.createActuator(null, null);

    // Assert
    assertTrue(actualCreateActuatorResult.isEmpty());
  }
}
