package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.FreezeBalanceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.Common;

public class FreezeBalanceProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceProcessor freezeBalanceProcessor = new FreezeBalanceProcessor();

    FreezeBalanceParam param = new FreezeBalanceParam();
    param.setDelegating(true);
    param.setFrozenDuration(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setFrozenBalance(0L);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> freezeBalanceProcessor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}
   */
  @Test
  public void testValidate2() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceProcessor freezeBalanceProcessor = new FreezeBalanceProcessor();

    FreezeBalanceParam param = new FreezeBalanceParam();
    param.setDelegating(true);
    param.setFrozenBalance(42L);
    param.setFrozenDuration(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> freezeBalanceProcessor.validate(param, new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(repository).getAccount(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}
   */
  @Test
  public void testValidate3() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceProcessor freezeBalanceProcessor = new FreezeBalanceProcessor();

    FreezeBalanceParam param = new FreezeBalanceParam();
    param.setDelegating(true);
    param.setFrozenBalance(1000000L);
    param.setFrozenDuration(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> freezeBalanceProcessor.validate(param, new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(repository).getAccount(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link FreezeBalanceProcessor#validate(FreezeBalanceParam, Repository)}
   */
  @Test
  public void testValidate4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    FreezeBalanceProcessor freezeBalanceProcessor = new FreezeBalanceProcessor();

    FreezeBalanceParam param = new FreezeBalanceParam();
    param.setDelegating(true);
    param.setFrozenBalance(-1L);
    param.setFrozenDuration(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> freezeBalanceProcessor.validate(param, new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(repository).getAccount(isA(byte[].class));
  }
}
