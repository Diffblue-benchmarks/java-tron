package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.WithdrawExpireUnfreezeParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class WithdrawExpireUnfreezeProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  public void testValidate2() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  public void testValidate3() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link WithdrawExpireUnfreezeProcessor#validate(WithdrawExpireUnfreezeParam, Repository)}
   */
  @Test
  public void testValidate4() throws ContractValidateException {
    // Arrange
    WithdrawExpireUnfreezeProcessor withdrawExpireUnfreezeProcessor = new WithdrawExpireUnfreezeProcessor();

    WithdrawExpireUnfreezeParam param = new WithdrawExpireUnfreezeParam();
    param.setOwnerAddress(new byte[]{});

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawExpireUnfreezeProcessor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }
}
