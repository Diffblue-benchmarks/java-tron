package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.WithdrawRewardParam;
import org.tron.core.vm.repository.Repository;

public class WithdrawRewardProcessorDiffblueTest {
  /**
   * Test {@link WithdrawRewardProcessor#validate(WithdrawRewardParam, Repository)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link WithdrawRewardProcessor#validate(WithdrawRewardParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WithdrawRewardProcessor.validate(WithdrawRewardParam, Repository)"})
  public void testValidate_whenNull_thenThrowContractValidateException()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();

    WithdrawRewardParam param = new WithdrawRewardParam();
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> withdrawRewardProcessor.validate(param, null));
  }
}
