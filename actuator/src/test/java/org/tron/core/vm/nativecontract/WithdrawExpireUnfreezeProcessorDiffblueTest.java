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
import org.tron.core.vm.nativecontract.param.WithdrawExpireUnfreezeParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class WithdrawExpireUnfreezeProcessorDiffblueTest {
  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"
  })
  public void testValidate_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor =
        new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> withdrawExpireUnfreezeProcessor.validate(param, repo));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"
  })
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor =
        new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(new byte[] {});
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> withdrawExpireUnfreezeProcessor.validate(param, repo));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link ContractValidateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"
  })
  public void testValidate_givenNull_whenNull_thenThrowContractValidateException()
      throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor =
        new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> withdrawExpireUnfreezeProcessor.validate(param, null));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link WithdrawExpireUnfreezeParam} (default constructor) OwnerAddress is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"
  })
  public void testValidate_givenNull_whenWithdrawExpireUnfreezeParamOwnerAddressIsNull()
      throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor =
        new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertThrows(
        ContractValidateException.class,
        () -> withdrawExpireUnfreezeProcessor.validate(param, repo));
  }
}
