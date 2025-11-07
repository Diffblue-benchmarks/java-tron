package org.tron.core.actuator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.TransactionCapsule;

public class ActuatorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ActuatorFactory#createActuator(TransactionCapsule, ChainBaseManager)}
   */
  @Test
  public void testCreateActuator() {
    // Arrange and Act
    List<Actuator> actualCreateActuatorResult = ActuatorFactory.createActuator(null, null);

    // Assert
    assertTrue(actualCreateActuatorResult.isEmpty());
  }

  /**
   * Method under test: {@link ActuatorFactory#getInstance()}
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ActuatorFactory actualInstance = ActuatorFactory.getInstance().getInstance();

    // Assert
    assertSame(actualInstance.INSTANCE, actualInstance);
  }
}
