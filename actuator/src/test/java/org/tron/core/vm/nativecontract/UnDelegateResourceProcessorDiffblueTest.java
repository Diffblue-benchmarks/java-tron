package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
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
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link UnDelegateResourceProcessor#validate(UnDelegateResourceParam,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnDelegateResourceProcessor.validate(UnDelegateResourceParam, Repository)"
  })
  public void testValidate_givenZero_thenThrowContractValidateException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnDelegateResourceProcessor unDelegateResourceProcessor = new UnDelegateResourceProcessor();

    UnDelegateResourceParam param = new UnDelegateResourceParam();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setUnDelegateBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> unDelegateResourceProcessor.validate(param, null));
  }
}
