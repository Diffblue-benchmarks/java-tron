package org.tron.core.actuator;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.GeneratedMessageV3;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;

public class TransactionFactoryDiffblueTest {
  /**
   * Test {@link TransactionFactory#getActuator(ContractType)}.
   *
   * <p>Method under test: {@link TransactionFactory#getActuator(Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class TransactionFactory.getActuator(Transaction.Contract.ContractType)"})
  public void testGetActuator() {
    // Arrange and Act
    Class<? extends Actuator> actualActuator =
        TransactionFactory.getActuator(ContractType.AccountCreateContract);

    // Assert
    assertNull(actualActuator);
  }

  /**
   * Test {@link TransactionFactory#getContract(ContractType)}.
   *
   * <p>Method under test: {@link TransactionFactory#getContract(Transaction.Contract.ContractType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class TransactionFactory.getContract(Transaction.Contract.ContractType)"})
  public void testGetContract() {
    // Arrange and Act
    Class<? extends GeneratedMessageV3> actualContract =
        TransactionFactory.getContract(ContractType.AccountCreateContract);

    // Assert
    assertNull(actualContract);
  }
}
