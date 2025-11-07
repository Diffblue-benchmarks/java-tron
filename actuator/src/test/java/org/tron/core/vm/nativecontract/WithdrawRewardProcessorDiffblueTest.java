package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.WithdrawRewardParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;

public class WithdrawRewardProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link WithdrawRewardProcessor#validate(WithdrawRewardParam, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();

    WithdrawRewardParam param = new WithdrawRewardParam();
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> withdrawRewardProcessor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  public void testExecute() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();

    WithdrawRewardParam param = new WithdrawRewardParam();
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act
    long actualExecuteResult = withdrawRewardProcessor.execute(param,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  public void testExecute2() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();

    WithdrawRewardParam param = new WithdrawRewardParam();
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAllowance(2L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    long actualExecuteResult = withdrawRewardProcessor.execute(param,
        new RepositoryImpl(StoreFactory.getInstance(), repository));

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    assertEquals(2L, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  public void testExecute3() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();

    WithdrawRewardParam param = new WithdrawRewardParam();
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repository2 = mock(RepositoryImpl.class);
    when(repository2.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repository3 = new RepositoryImpl(StoreFactory.getInstance(), repository2);

    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);
    repo.setParent(repository3);

    // Act
    long actualExecuteResult = withdrawRewardProcessor.execute(param, repo);

    // Assert
    verify(repository2).getAccount(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
  }
}
