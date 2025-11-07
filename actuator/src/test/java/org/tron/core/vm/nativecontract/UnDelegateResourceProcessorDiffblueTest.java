package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.UnDelegateResourceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnDelegateResourceProcessorDiffblueTest {
  /**
   * Test {@link UnDelegateResourceProcessor#validate(UnDelegateResourceParam, Repository)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then throw {@link ContractValidateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceProcessor#validate(UnDelegateResourceParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnDelegateResourceProcessor.validate(UnDelegateResourceParam, Repository)"})
  public void testValidate_givenZero_thenThrowContractValidateException() throws ContractValidateException {
    // Arrange
    UnDelegateResourceProcessor unDelegateResourceProcessor = new UnDelegateResourceProcessor();

    UnDelegateResourceParam param = new UnDelegateResourceParam();
    param.setUnDelegateBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setReceiverAddress(null);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unDelegateResourceProcessor.validate(param, null));
  }
}
