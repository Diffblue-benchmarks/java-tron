package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.DelegateResourceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class DelegateResourceProcessorDiffblueTest {
  /**
   * Test {@link DelegateResourceProcessor#validate(DelegateResourceParam, Repository)}.
   * <ul>
   *   <li>Given {@code 1000000}.</li>
   *   <li>Then throw {@link ContractValidateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceProcessor#validate(DelegateResourceParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegateResourceProcessor.validate(DelegateResourceParam, Repository)"})
  public void testValidate_given1000000_thenThrowContractValidateException() throws ContractValidateException {
    // Arrange
    DelegateResourceProcessor delegateResourceProcessor = new DelegateResourceProcessor();

    DelegateResourceParam param = new DelegateResourceParam();
    param.setDelegateBalance(1000000L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setReceiverAddress(null);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> delegateResourceProcessor.validate(param, null));
  }
}
