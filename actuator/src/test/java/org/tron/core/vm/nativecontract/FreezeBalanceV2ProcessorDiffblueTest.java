package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.FreezeBalanceV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.Common;

public class FreezeBalanceV2ProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate2() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate3() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(0L);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceV2Processor#validate(FreezeBalanceV2Param, Repository)}
   */
  @Test
  public void testValidate4() throws ContractValidateException {
    // Arrange
    FreezeBalanceV2Processor freezeBalanceV2Processor = new FreezeBalanceV2Processor();

    FreezeBalanceV2Param param = new FreezeBalanceV2Param();
    param.setFrozenBalance(42L);
    param.setOwnerAddress(new byte[]{});
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }
}
