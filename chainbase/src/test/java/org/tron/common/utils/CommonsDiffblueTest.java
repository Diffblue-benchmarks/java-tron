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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.BalanceInsufficientException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeStore;
import org.tron.core.store.ExchangeV2Store;

public class CommonsDiffblueTest {
  /**
   * Test {@link Commons#decode58Check(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decode58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decode58Check(String)"})
  public void testDecode58Check_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decode58Check("42"));
  }

  /**
   * Test {@link Commons#decode58Check(String)}.
   *
   * <ul>
   *   <li>When {@code Commons}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decode58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decode58Check(String)"})
  public void testDecode58Check_whenCommons_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decode58Check("Commons"));
  }

  /**
   * Test {@link Commons#decode58Check(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decode58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decode58Check(String)"})
  public void testDecode58Check_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decode58Check(""));
  }

  /**
   * Test {@link Commons#decodeFromBase58Check(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decodeFromBase58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decodeFromBase58Check(String)"})
  public void testDecodeFromBase58Check_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decodeFromBase58Check("42"));
  }

  /**
   * Test {@link Commons#decodeFromBase58Check(String)}.
   *
   * <ul>
   *   <li>When {@code Commons}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decodeFromBase58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decodeFromBase58Check(String)"})
  public void testDecodeFromBase58Check_whenCommons_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decodeFromBase58Check("Commons"));
  }

  /**
   * Test {@link Commons#decodeFromBase58Check(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decodeFromBase58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decodeFromBase58Check(String)"})
  public void testDecodeFromBase58Check_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decodeFromBase58Check(""));
  }

  /**
   * Test {@link Commons#decodeFromBase58Check(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#decodeFromBase58Check(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Commons.decodeFromBase58Check(String)"})
  public void testDecodeFromBase58Check_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Commons.decodeFromBase58Check(null));
  }

  /**
   * Test {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)} with {@code
   * accountStore}, {@code account}, {@code amount}.
   *
   * <p>Method under test: {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Commons.adjustBalance(AccountStore, AccountCapsule, long)"})
  public void testAdjustBalanceWithAccountStoreAccountAmount()
      throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(account.getBalance()).thenReturn(0L);

    // Act and Assert
    assertThrows(
        BalanceInsufficientException.class, () -> Commons.adjustBalance(null, account, -1L));
    verify(account).createDbKey();
    verify(account).getBalance();
  }

  /**
   * Test {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)} with {@code
   * accountStore}, {@code account}, {@code amount}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then calls {@link AccountCapsule#getBalance()}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#adjustBalance(AccountStore, AccountCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Commons.adjustBalance(AccountStore, AccountCapsule, long)"})
  public void testAdjustBalanceWithAccountStoreAccountAmount_whenZero_thenCallsGetBalance()
      throws BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.getBalance()).thenReturn(Long.MAX_VALUE);

    // Act
    Commons.adjustBalance(null, account, 0L);

    // Assert
    verify(account).getBalance();
  }

  /**
   * Test {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore,
   * ExchangeV2Store)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore,
   * ExchangeStore, ExchangeV2Store)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExchangeStore Commons.getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore, ExchangeV2Store)"
  })
  public void testGetExchangeStoreFinal_givenOne() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    ExchangeStore actualExchangeStoreFinal =
        Commons.getExchangeStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualExchangeStoreFinal);
  }

  /**
   * Test {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore,
   * ExchangeV2Store)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link Commons#getExchangeStoreFinal(DynamicPropertiesStore,
   * ExchangeStore, ExchangeV2Store)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExchangeStore Commons.getExchangeStoreFinal(DynamicPropertiesStore, ExchangeStore, ExchangeV2Store)"
  })
  public void testGetExchangeStoreFinal_givenZero() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    ExchangeStore actualExchangeStoreFinal =
        Commons.getExchangeStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualExchangeStoreFinal);
  }

  /**
   * Test {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore,
   * AssetIssueV2Store)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore,
   * AssetIssueStore, AssetIssueV2Store)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetIssueStore Commons.getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore, AssetIssueV2Store)"
  })
  public void testGetAssetIssueStoreFinal_givenOne() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    AssetIssueStore actualAssetIssueStoreFinal =
        Commons.getAssetIssueStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualAssetIssueStoreFinal);
  }

  /**
   * Test {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore,
   * AssetIssueV2Store)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link Commons#getAssetIssueStoreFinal(DynamicPropertiesStore,
   * AssetIssueStore, AssetIssueV2Store)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetIssueStore Commons.getAssetIssueStoreFinal(DynamicPropertiesStore, AssetIssueStore, AssetIssueV2Store)"
  })
  public void testGetAssetIssueStoreFinal_givenZero() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    AssetIssueStore actualAssetIssueStoreFinal =
        Commons.getAssetIssueStoreFinal(dynamicPropertiesStore, null, null);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualAssetIssueStoreFinal);
  }

  /**
   * Test {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore,
   * AssetIssueStore, DynamicPropertiesStore)} with {@code account}, {@code AssetID}, {@code
   * amount}, {@code accountStore}, {@code assetIssueStore}, {@code dynamicPropertiesStore}.
   *
   * <p>Method under test: {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long,
   * AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Commons.adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)"
  })
  public void
      testAdjustAssetBalanceV2WithAccountAssetIDAmountAccountStoreAssetIssueStoreDynamicPropertiesStore()
          throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.addAssetAmountV2(
            Mockito.<byte[]>any(),
            anyLong(),
            Mockito.<DynamicPropertiesStore>any(),
            Mockito.<AssetIssueStore>any()))
        .thenReturn(false);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", 10L, null, null, null));
    verify(account).addAssetAmountV2(isA(byte[].class), eq(10L), isNull(), isNull());
    verify(account).createDbKey();
  }

  /**
   * Test {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore,
   * AssetIssueStore, DynamicPropertiesStore)} with {@code account}, {@code AssetID}, {@code
   * amount}, {@code accountStore}, {@code assetIssueStore}, {@code dynamicPropertiesStore}.
   *
   * <p>Method under test: {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long,
   * AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Commons.adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)"
  })
  public void
      testAdjustAssetBalanceV2WithAccountAssetIDAmountAccountStoreAssetIssueStoreDynamicPropertiesStore2()
          throws UnsupportedEncodingException, BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.reduceAssetAmountV2(
            Mockito.<byte[]>any(),
            anyLong(),
            Mockito.<DynamicPropertiesStore>any(),
            Mockito.<AssetIssueStore>any()))
        .thenReturn(false);
    when(account.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", -1L, null, null, null));
    verify(account).createDbKey();
    verify(account).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
  }

  /**
   * Test {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore,
   * AssetIssueStore, DynamicPropertiesStore)} with {@code account}, {@code AssetID}, {@code
   * amount}, {@code accountStore}, {@code assetIssueStore}, {@code dynamicPropertiesStore}.
   *
   * <p>Method under test: {@link Commons#adjustAssetBalanceV2(AccountCapsule, String, long,
   * AccountStore, AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Commons.adjustAssetBalanceV2(AccountCapsule, String, long, AccountStore, AssetIssueStore, DynamicPropertiesStore)"
  })
  public void
      testAdjustAssetBalanceV2WithAccountAssetIDAmountAccountStoreAssetIssueStoreDynamicPropertiesStore3()
          throws BalanceInsufficientException {
    // Arrange
    AccountCapsule account = mock(AccountCapsule.class);
    when(account.reduceAssetAmountV2(
            Mockito.<byte[]>any(),
            anyLong(),
            Mockito.<DynamicPropertiesStore>any(),
            Mockito.<AssetIssueStore>any()))
        .thenReturn(false);
    when(account.createDbKey()).thenReturn(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        BalanceInsufficientException.class,
        () -> Commons.adjustAssetBalanceV2(account, "Asset ID", -1L, null, null, null));
    verify(account).createDbKey();
    verify(account).reduceAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
  }

  /**
   * Test {@link Commons#adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicPropertiesStore#saveTotalShieldedPoolValue(long)}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#adjustTotalShieldedPoolValue(long,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Commons.adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)"})
  public void testAdjustTotalShieldedPoolValue_thenCallsSaveTotalShieldedPoolValue()
      throws BalanceInsufficientException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTotalShieldedPoolValue(anyLong());
    when(dynamicPropertiesStore.getTotalShieldedPoolValue()).thenReturn(42L);

    // Act
    Commons.adjustTotalShieldedPoolValue(42L, dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getTotalShieldedPoolValue();
    verify(dynamicPropertiesStore).saveTotalShieldedPoolValue(0L);
  }

  /**
   * Test {@link Commons#adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then throw {@link BalanceInsufficientException}.
   * </ul>
   *
   * <p>Method under test: {@link Commons#adjustTotalShieldedPoolValue(long,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Commons.adjustTotalShieldedPoolValue(long, DynamicPropertiesStore)"})
  public void testAdjustTotalShieldedPoolValue_thenThrowBalanceInsufficientException()
      throws BalanceInsufficientException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalShieldedPoolValue()).thenReturn(42L);

    // Act and Assert
    assertThrows(
        BalanceInsufficientException.class,
        () -> Commons.adjustTotalShieldedPoolValue(Long.MAX_VALUE, dynamicPropertiesStore));
    verify(dynamicPropertiesStore).getTotalShieldedPoolValue();
  }
}
