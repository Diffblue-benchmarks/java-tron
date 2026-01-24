package org.tron.core;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.NfParameters;
import org.tron.api.GrpcAPI.PrivateParameters;
import org.tron.api.GrpcAPI.PrivateParametersWithoutAsk;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk;
import org.tron.api.GrpcAPI.SpendAuthSigParameters;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.BalanceContract.AccountIdentifier;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace.BlockIdentifier;

public class WalletDiffblueTest {
  /**
   * Test {@link Wallet#createSpendAuthSig(SpendAuthSigParameters)}.
   *
   * <p>Method under test: {@link Wallet#createSpendAuthSig(GrpcAPI.SpendAuthSigParameters)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GrpcAPI.BytesMessage Wallet.createSpendAuthSig(GrpcAPI.SpendAuthSigParameters)"
  })
  public void testCreateSpendAuthSig() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> new Wallet().createSpendAuthSig(SpendAuthSigParameters.getDefaultInstance()));
  }

  /**
   * Test {@link Wallet#checkBlockIdentifier(BlockIdentifier)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#checkBlockIdentifier(BlockIdentifier)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wallet.checkBlockIdentifier(BlockIdentifier)"})
  public void testCheckBlockIdentifier_whenDefaultInstance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Wallet().checkBlockIdentifier(BlockIdentifier.getDefaultInstance()));
  }

  /**
   * Test {@link Wallet#checkAccountIdentifier(AccountIdentifier)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Wallet#checkAccountIdentifier(BalanceContract.AccountIdentifier)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Wallet.checkAccountIdentifier(BalanceContract.AccountIdentifier)"})
  public void testCheckAccountIdentifier_whenDefaultInstance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Wallet().checkAccountIdentifier(AccountIdentifier.getDefaultInstance()));
  }
}
