package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.WithdrawRewardParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class WithdrawRewardProcessorDiffblueTest {
  /**
   * Test {@link WithdrawRewardProcessor#validate(WithdrawRewardParam, Repository)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ContractValidateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawRewardProcessor#validate(WithdrawRewardParam, Repository)}
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
    assertThrows(ContractValidateException.class, () -> withdrawRewardProcessor.validate(param, null));
  }

  /**
   * Test {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}.
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#getAllowance()} return minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WithdrawRewardProcessor.execute(WithdrawRewardParam, Repository)"})
  public void testExecute_givenAccountCapsuleGetAllowanceReturnMinusOne_thenReturnZero()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();
    WithdrawRewardParam param = mock(WithdrawRewardParam.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setNowInMs(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(-1L);
    when(accountCapsule.getBalance()).thenReturn(42L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    long actualExecuteResult = withdrawRewardProcessor.execute(param, repo);

    // Assert
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).getBalance();
    verify(param).getOwnerAddress();
    verify(param).setNowInMs(eq(1L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).getAccount(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Test {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}.
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#getAllowance()} return zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WithdrawRewardProcessor.execute(WithdrawRewardParam, Repository)"})
  public void testExecute_givenAccountCapsuleGetAllowanceReturnZero_thenReturnZero()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();
    WithdrawRewardParam param = mock(WithdrawRewardParam.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setNowInMs(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(0L);
    when(accountCapsule.getBalance()).thenReturn(42L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    long actualExecuteResult = withdrawRewardProcessor.execute(param, repo);

    // Assert
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).getBalance();
    verify(param).getOwnerAddress();
    verify(param).setNowInMs(eq(1L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).getAccount(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Test {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}.
   * <ul>
   *   <li>Then throw {@link ContractExeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawRewardProcessor#execute(WithdrawRewardParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WithdrawRewardProcessor.execute(WithdrawRewardParam, Repository)"})
  public void testExecute_thenThrowContractExeException() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    WithdrawRewardProcessor withdrawRewardProcessor = new WithdrawRewardProcessor();
    WithdrawRewardParam param = mock(WithdrawRewardParam.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setNowInMs(anyLong());
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setNowInMs(1L);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(Long.MAX_VALUE);
    when(accountCapsule.getBalance()).thenReturn(42L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> withdrawRewardProcessor.execute(param, repo));
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).getBalance();
    verify(param).getOwnerAddress();
    verify(param).setNowInMs(eq(1L));
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).getAccount(isA(byte[].class));
  }
}
