package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.FreezeBalanceV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class FreezeBalanceV2ProcessorDiffblueTest {
  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(ResourceCode.BANDWIDTH);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress(new byte[] {});
    param.setResourceType(ResourceCode.BANDWIDTH);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link FreezeBalanceV2Param} (default constructor) FrozenBalance is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenZero_whenFreezeBalanceV2ParamFrozenBalanceIsZero()
      throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, repo));
  }

  /**
   * Test {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenZero_whenNull() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, null));
  }
}
