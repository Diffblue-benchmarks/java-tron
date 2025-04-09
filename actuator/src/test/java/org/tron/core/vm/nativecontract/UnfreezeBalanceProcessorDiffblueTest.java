package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.UnfreezeBalanceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class UnfreezeBalanceProcessorDiffblueTest {
  /**
   * Test {@link UnfreezeBalanceProcessor#validate(UnfreezeBalanceParam, Repository)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ContractValidateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceProcessor#validate(UnfreezeBalanceParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnfreezeBalanceProcessor.validate(UnfreezeBalanceParam, Repository)"})
  public void testValidate_whenNull_thenThrowContractValidateException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceProcessor.validate(param, null));
  }
}
