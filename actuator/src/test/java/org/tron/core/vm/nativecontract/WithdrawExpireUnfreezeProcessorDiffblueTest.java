package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"})
  public void testValidate_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"})
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(new byte[]{});

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"})
  public void testValidate_givenNull_whenNull() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param, null));
  }

  /**
   * Test {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link WithdrawExpireUnfreezeParam} (default constructor) OwnerAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WithdrawExpireUnfreezeProcessor.validate(WithdrawExpireUnfreezeParam, Repository)"})
  public void testValidate_givenNull_whenWithdrawExpireUnfreezeParamOwnerAddressIsNull()
      throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }
}
