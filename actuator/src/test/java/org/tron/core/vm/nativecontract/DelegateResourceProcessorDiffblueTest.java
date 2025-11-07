package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.DelegateResourceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.contract.Common;

public class DelegateResourceProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link DelegateResourceProcessor#validate(DelegateResourceParam, Repository)}
   */
  @Test
  public void testValidate() throws ContractValidateException {
    // Arrange
    DelegateResourceProcessor delegateResourceProcessor = new DelegateResourceProcessor();

    DelegateResourceParam param = new DelegateResourceParam();
    param.setDelegateBalance(1000000L);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setReceiverAddress(null);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> delegateResourceProcessor.validate(param, null));
  }
}
