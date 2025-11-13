package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Given forty-two.
   *   <li>When {@link FreezeBalanceV2Param} (default constructor) FrozenBalance is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenFortyTwo_whenFreezeBalanceV2ParamFrozenBalanceIsFortyTwo()
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
   *   <li>Given {@code null}.
   *   <li>When {@link FreezeBalanceV2Param} (default constructor) OwnerAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param,
   * Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenNull_whenFreezeBalanceV2ParamOwnerAddressIsNull()
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreezeBalanceV2Processor.validate(FreezeBalanceV2Param, Repository)"})
  public void testValidate_givenZero_whenNull()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(ResourceCode.BANDWIDTH);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, null));
  }
}
