package org.tron.core.actuator;

import static org.junit.Assert.assertNull;
import com.google.protobuf.GeneratedMessageV3;
import org.junit.Test;
import org.tron.protos.Protocol;

public class TransactionFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link TransactionFactory#getActuator(Protocol.Transaction.Contract.ContractType)}
   */
  @Test
  public void testGetActuator() {
    // Arrange and Act
    Class<? extends Actuator> actualActuator = TransactionFactory
        .getActuator(Protocol.Transaction.Contract.ContractType.AccountCreateContract);

    // Assert
    assertNull(actualActuator);
  }

  /**
   * Method under test:
   * {@link TransactionFactory#getContract(Protocol.Transaction.Contract.ContractType)}
   */
  @Test
  public void testGetContract() {
    // Arrange and Act
    Class<? extends GeneratedMessageV3> actualContract = TransactionFactory
        .getContract(Protocol.Transaction.Contract.ContractType.AccountCreateContract);

    // Assert
    assertNull(actualContract);
  }
}
