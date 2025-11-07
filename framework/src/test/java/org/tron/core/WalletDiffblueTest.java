package org.tron.core;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.api.GrpcAPI;
import org.tron.common.crypto.ECKey;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;
import org.tron.core.zen.address.IncomingViewingKey;
import org.tron.protos.contract.BalanceContract;

public class WalletDiffblueTest {
  /**
   * Method under test: {@link Wallet#getAddress()}
   */
  @Test
  public void testGetAddress() {
    // Arrange and Act
    byte[] actualAddress = (new Wallet(new ECKey())).getAddress();

    // Assert
    assertEquals(Constant.TRON_ADDRESS_SIZE, actualAddress.length);
    assertEquals('A', actualAddress[0]);
  }

  /**
   * Method under test: {@link Wallet#getAddress()}
   */
  @Test
  public void testGetAddress2() throws UnsupportedEncodingException {
    // Arrange
    ECKey cryptoEngine = mock(ECKey.class);
    when(cryptoEngine.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualAddress = (new Wallet(cryptoEngine)).getAddress();

    // Assert
    verify(cryptoEngine, atLeast(1)).getAddress();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAddress);
  }

  /**
   * Method under test: {@link Wallet#getIncomingViewingKey(byte[], byte[])}
   */
  @Test
  public void testGetIncomingViewingKey() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    Wallet wallet = new Wallet();
    byte[] ak = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> wallet.getIncomingViewingKey(ak, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link Wallet#getPaymentAddress(IncomingViewingKey, DiversifierT)}
   */
  @Test
  public void testGetPaymentAddress() throws UnsupportedEncodingException, BadItemException, ZksnarkException {
    // Arrange
    Wallet wallet = new Wallet();
    IncomingViewingKey ivk = new IncomingViewingKey("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> wallet.getPaymentAddress(ivk, DiversifierT.random()));
  }

  /**
   * Method under test:
   * {@link Wallet#createSpendAuthSig(GrpcAPI.SpendAuthSigParameters)}
   */
  @Test
  public void testCreateSpendAuthSig() throws ZksnarkException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(ZksnarkException.class,
        () -> wallet.createSpendAuthSig(GrpcAPI.SpendAuthSigParameters.getDefaultInstance()));
  }

  /**
   * Method under test: {@link Wallet#stripRightZero(byte[])}
   */
  @Test
  public void testStripRightZero() throws UnsupportedEncodingException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act
    byte[] actualStripRightZeroResult = wallet.stripRightZero("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripRightZeroResult);
  }

  /**
   * Method under test: {@link Wallet#stripRightZero(byte[])}
   */
  @Test
  public void testStripRightZero2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripRightZeroResult = (new Wallet()).stripRightZero(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualStripRightZeroResult);
  }

  /**
   * Method under test: {@link Wallet#stripRightZero(byte[])}
   */
  @Test
  public void testStripRightZero3() {
    // Arrange, Act and Assert
    assertEquals(0, (new Wallet()).stripRightZero(new byte[]{}).length);
  }

  /**
   * Method under test: {@link Wallet#stripRightZero(byte[])}
   */
  @Test
  public void testStripRightZero4() throws UnsupportedEncodingException {
    // Arrange
    ECKey cryptoEngine = mock(ECKey.class);
    when(cryptoEngine.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Wallet wallet = new Wallet(cryptoEngine);

    // Act
    byte[] actualStripRightZeroResult = wallet.stripRightZero("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cryptoEngine).getAddress();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripRightZeroResult);
  }

  /**
   * Method under test: {@link Wallet#getShieldedContractScalingFactor(byte[])}
   */
  @Test
  public void testGetShieldedContractScalingFactor() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(ContractExeException.class,
        () -> wallet.getShieldedContractScalingFactor("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Wallet#getShieldedContractScalingFactor(byte[])}
   */
  @Test
  public void testGetShieldedContractScalingFactor2() throws ContractExeException {
    // Arrange, Act and Assert
    assertThrows(ContractExeException.class, () -> (new Wallet()).getShieldedContractScalingFactor(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Wallet#getTriggerInputForShieldedTRC20Contract(GrpcAPI.ShieldedTRC20TriggerContractParameters)}
   */
  @Test
  public void testGetTriggerInputForShieldedTRC20Contract() throws ContractValidateException, ZksnarkException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> wallet
        .getTriggerInputForShieldedTRC20Contract(GrpcAPI.ShieldedTRC20TriggerContractParameters.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link Wallet#getAccountBalance(BalanceContract.AccountBalanceRequest)}
   */
  @Test
  public void testGetAccountBalance() throws ItemNotFoundException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> wallet.getAccountBalance(BalanceContract.AccountBalanceRequest.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link Wallet#getBlockBalance(BalanceContract.BlockBalanceTrace.BlockIdentifier)}
   */
  @Test
  public void testGetBlockBalance() throws BadItemException, ItemNotFoundException {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> wallet.getBlockBalance(BalanceContract.BlockBalanceTrace.BlockIdentifier.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link Wallet#checkBlockIdentifier(BalanceContract.BlockBalanceTrace.BlockIdentifier)}
   */
  @Test
  public void testCheckBlockIdentifier() {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> wallet.checkBlockIdentifier(BalanceContract.BlockBalanceTrace.BlockIdentifier.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link Wallet#checkAccountIdentifier(BalanceContract.AccountIdentifier)}
   */
  @Test
  public void testCheckAccountIdentifier() {
    // Arrange
    Wallet wallet = new Wallet();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> wallet.checkAccountIdentifier(BalanceContract.AccountIdentifier.getDefaultInstance()));
  }

  /**
   * Method under test: {@link Wallet#getCoinbase()}
   */
  @Test
  public void testGetCoinbase() {
    // Arrange, Act and Assert
    assertNull((new Wallet()).getCoinbase());
  }

  /**
   * Method under test: {@link Wallet#getCoinbase()}
   */
  @Test
  public void testGetCoinbase2() throws UnsupportedEncodingException {
    // Arrange
    ECKey cryptoEngine = mock(ECKey.class);
    when(cryptoEngine.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCoinbase = (new Wallet(cryptoEngine)).getCoinbase();

    // Assert
    verify(cryptoEngine).getAddress();
    assertNull(actualCoinbase);
  }

  /**
   * Method under test: {@link Wallet#isMining()}
   */
  @Test
  public void testIsMining() {
    // Arrange, Act and Assert
    assertFalse((new Wallet()).isMining());
  }

  /**
   * Method under test: {@link Wallet#isMining()}
   */
  @Test
  public void testIsMining2() throws UnsupportedEncodingException {
    // Arrange
    ECKey cryptoEngine = mock(ECKey.class);
    when(cryptoEngine.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsMiningResult = (new Wallet(cryptoEngine)).isMining();

    // Assert
    verify(cryptoEngine).getAddress();
    assertFalse(actualIsMiningResult);
  }
}
