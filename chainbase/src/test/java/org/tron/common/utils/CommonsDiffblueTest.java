package org.tron.common.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.ExchangeCapsule;
import org.tron.core.exception.BalanceInsufficientException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeStore;
import org.tron.core.store.ExchangeV2Store;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;

@RunWith(MockitoJUnitRunner.class)
public class CommonsDiffblueTest {
  @InjectMocks
  private Commons commons;

  /**
   * Method under test: {@link Commons#decode58Check(String)}
   */
  @Test
  public void testDecode58Check() {
    // Arrange, Act and Assert
    assertNull(Commons.decode58Check("Commons"));
    assertNull(Commons.decode58Check("42"));
    assertNull(Commons.decode58Check(""));
  }

  /**
   * Method under test: {@link Commons#decodeFromBase58Check(String)}
   */
  @Test
  public void testDecodeFromBase58Check() {
    // Arrange, Act and Assert
    assertNull(Commons.decodeFromBase58Check(null));
    assertNull(Commons.decodeFromBase58Check("Commons"));
    assertNull(Commons.decodeFromBase58Check("42"));
    assertNull(Commons.decodeFromBase58Check(""));
  }

  /**
   * Method under test:
   * {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  public void testAdjustBalance() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.getAddress()).thenReturn(byteString);
    when(account.getBalance()).thenReturn(42L);
    doNothing().when(account).setBalance(anyLong());

    // Act
    Commons.adjustBalance(accountStore, account, 10L);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(account).getAddress();
    verify(account).getBalance();
    verify(account).setBalance(eq(52L));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  public void testAdjustBalance2() throws BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.getBalance()).thenReturn(42L);

    // Act
    Commons.adjustBalance(accountStore, account, 0L);

    // Assert that nothing has changed
    verify(account).getBalance();
  }

  /**
   * Method under test:
   * {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  public void testAdjustBalance3() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.getAddress()).thenReturn(byteString);
    when(account.getBalance()).thenReturn(42L);
    doNothing().when(account).setBalance(anyLong());

    // Act
    Commons.adjustBalance(accountStore, account, -1L);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(account).getAddress();
    verify(account).getBalance();
    verify(account).setBalance(eq(41L));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  public void testAdjustBalance4() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(account.getBalance()).thenReturn(-1L);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class, () -> Commons.adjustBalance(accountStore, account, -1L));
    verify(account).createDbKey();
    verify(account).getBalance();
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance5() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act
    Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance6() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()));

    // Act
    Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance7() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAddress()).thenReturn(byteString);
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 10L);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(accountCapsule).getAddress();
    verify(accountCapsule).getBalance();
    verify(accountCapsule).setBalance(eq(52L));
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance8() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getBalance()).thenReturn(42L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), 0L);

    // Assert that nothing has changed
    verify(accountCapsule).getBalance();
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance9() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAddress()).thenReturn(byteString);
    when(accountCapsule.getBalance()).thenReturn(42L);
    doNothing().when(accountCapsule).setBalance(anyLong());
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), -1L);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(accountCapsule).getAddress();
    verify(accountCapsule).getBalance();
    verify(accountCapsule).setBalance(eq(41L));
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link Commons#adjustBalance(AccountStore, byte[], long)}
   */
  @Test
  public void testAdjustBalance10() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getBalance()).thenReturn(-1L);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustBalance(accountStore, "AXAXAXAX".getBytes("UTF-8"), -1L));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getBalance();
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore, ExchangeV2Store)}
   */
  @Test
  public void testGetExchangeStoreFinal() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    ExchangeStore actualExchangeStoreFinal = Commons.getExchangeStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualExchangeStoreFinal);
  }

  /**
   * Method under test:
   * {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore, ExchangeV2Store)}
   */
  @Test
  public void testGetExchangeStoreFinal2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    ExchangeStore actualExchangeStoreFinal = Commons.getExchangeStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualExchangeStoreFinal);
  }

  /**
   * Method under test:
   * {@link Commons#putExchangeCapsule(ExchangeCapsule, DynamicPropertiesStore, ExchangeStore, ExchangeV2Store, AssetIssueStore)}
   */
  @Test
  public void testPutExchangeCapsule() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = mock(ExchangeCapsule.class);
    when(exchangeCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    doNothing().when(exchangeV2Store).put(Mockito.<byte[]>any(), Mockito.<ExchangeCapsule>any());

    // Act
    Commons.putExchangeCapsule(exchangeCapsule, dynamicPropertiesStore, null, exchangeV2Store, null);

    // Assert that nothing has changed
    verify(exchangeCapsule).createDbKey();
    verify(exchangeV2Store).put(isA(byte[].class), isA(ExchangeCapsule.class));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
  }

  /**
   * Method under test:
   * {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore, AssetIssueV2Store)}
   */
  @Test
  public void testGetAssetIssueStoreFinal() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    AssetIssueStore actualAssetIssueStoreFinal = Commons.getAssetIssueStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualAssetIssueStoreFinal);
  }

  /**
   * Method under test:
   * {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore, AssetIssueV2Store)}
   */
  @Test
  public void testGetAssetIssueStoreFinal2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    AssetIssueStore actualAssetIssueStoreFinal = Commons.getAssetIssueStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualAssetIssueStoreFinal);
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV2() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.addAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(false);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", 10L, null, null, null));
    verify(account).addAssetAmountV2(isA(byte[].class), eq(10L), isNull(), isNull());
    verify(account).createDbKey();
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV22() throws BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.addAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(false);
    when(account.createDbKey()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", 10L, null, null, null));
    verify(account).addAssetAmountV2(isA(byte[].class), eq(10L), isNull(), isNull());
    verify(account).createDbKey();
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV23() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.reduceAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(false);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", -1L, null, null, null));
    verify(account).createDbKey();
    verify(account).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV24() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.reduceAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(true);
    when(account.getAddress()).thenReturn(byteString);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());

    // Act
    Commons.adjustAssetBalanceV2(account, "Asset ID", -1L, accountStore, null, null);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(account).getAddress();
    verify(account).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(byte[], String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV25() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    byte[] accountAddress = "AXAXAXAX".getBytes("UTF-8");
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.reduceAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(false);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(accountAddress, "Asset ID", -1L, accountStore, null, null));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(byte[], String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV26() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    byte[] accountAddress = "AXAXAXAX".getBytes("UTF-8");
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.reduceAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(false);
    when(accountCapsule.createDbKey()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(accountAddress, "Asset ID", -1L, accountStore, null, null));
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
    verify(accountStore).getUnchecked(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustAssetBalanceV2(byte[], String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustAssetBalanceV27() throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    byte[] accountAddress = "AXAXAXAX".getBytes("UTF-8");
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.reduceAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(true);
    when(accountCapsule.getAddress()).thenReturn(byteString);
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.getUnchecked(Mockito.<byte[]>any())).thenReturn(accountCapsule);

    // Act
    Commons.adjustAssetBalanceV2(accountAddress, "Asset ID", -1L, accountStore, null, null);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(accountCapsule).getAddress();
    verify(accountCapsule).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
    verify(accountStore).getUnchecked(isA(byte[].class));
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test:
   * {@link Commons#adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustTotalShieldedPoolValue() throws BalanceInsufficientException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTotalShieldedPoolValue(anyLong());
    when(dynamicPropertiesStore.getTotalShieldedPoolValue()).thenReturn(42L);

    // Act
    Commons.adjustTotalShieldedPoolValue(42L, dynamicPropertiesStore);

    // Assert that nothing has changed
    verify(dynamicPropertiesStore).getTotalShieldedPoolValue();
    verify(dynamicPropertiesStore).saveTotalShieldedPoolValue(eq(0L));
  }

  /**
   * Method under test:
   * {@link Commons#adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)}
   */
  @Test
  public void testAdjustTotalShieldedPoolValue2() throws BalanceInsufficientException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalShieldedPoolValue()).thenReturn(42L);

    // Act and Assert
    assertThrows(BalanceInsufficientException.class,
        () -> Commons.adjustTotalShieldedPoolValue(Long.MAX_VALUE, dynamicPropertiesStore));
    verify(dynamicPropertiesStore).getTotalShieldedPoolValue();
  }
}
