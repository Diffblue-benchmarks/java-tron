package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.FreezeBalanceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class FreezeBalanceProcessorDiffblueTest {
  /**
   * Test {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreezeBalanceProcessor.validate(FreezeBalanceParam, Repository)"})
  public void testValidate_givenZero_thenThrowContractValidateException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceProcessor freezeBalanceProcessor = new FreezeBalanceProcessor();

    FreezeBalanceParam param = new FreezeBalanceParam();
    param.setDelegating(true);
    param.setFrozenDuration(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceProcessor.validate(param, null));
  }
}
