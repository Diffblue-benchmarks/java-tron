package org.tron.core.db.api;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeStore;

@RunWith(MockitoJUnitRunner.class)
public class AssetUpdateHelperDiffblueTest {
  @InjectMocks private AssetUpdateHelper assetUpdateHelper;

  @Mock private ChainBaseManager chainBaseManager;

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenAssetIssueV2StoreIsNotEmptyReturnFalse() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(assetIssueV2Store).reset();
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenAssetIssueV2StoreIsNotEmptyThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.doWork());
    verify(chainBaseManager).getAssetIssueV2Store();
    verify(assetIssueV2Store).isNotEmpty();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getAssetIssueV2Store()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenChainBaseManagerGetAssetIssueV2StoreThrowRuntimeException() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.doWork());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getExchangeV2Store()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_thenCallsGetExchangeV2Store() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} return {@code
   *       false}.
   *   <li>Then calls {@link ChainBaseManager#getExchangeV2Store()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenAssetIssueV2StoreIsNotEmptyReturnFalse_thenCallsGetExchangeV2Store() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(assetIssueV2Store).reset();
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} return {@code
   *       true}.
   *   <li>Then calls {@link ChainBaseManager#getExchangeV2Store()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenAssetIssueV2StoreIsNotEmptyReturnTrue_thenCallsGetExchangeV2Store() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenAssetIssueV2StoreIsNotEmptyThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.init());
    verify(chainBaseManager).getAssetIssueV2Store();
    verify(assetIssueV2Store).isNotEmpty();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getAssetIssueV2Store()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenChainBaseManagerGetAssetIssueV2StoreThrowRuntimeException() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.init());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   *
   * <p>Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.getAllAssetIssues());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   *
   * <p>Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.getAllAssetIssues());
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_givenChainBaseManagerGetBlockByNumReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_givenChainBaseManagerGetBlockByNumThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAsset());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenChainBaseManagerGetBlockByNumReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAsset());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenChainBaseManagerGetBlockByNumThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAsset());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getTokenIdNum()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenDynamicPropertiesStoreGetTokenIdNumThrowRuntimeException() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTokenIdNum()).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAsset());
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getExchangeStore()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_givenChainBaseManagerGetExchangeStoreThrowRuntimeException() {
    // Arrange
    when(chainBaseManager.getExchangeStore()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateExchange());
    verify(chainBaseManager).getExchangeStore();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeStore} {@link ExchangeStore#getAllExchanges()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_givenExchangeStoreGetAllExchangesReturnArrayList() {
    // Arrange
    ExchangeStore exchangeStore = mock(ExchangeStore.class);
    when(exchangeStore.getAllExchanges()).thenReturn(new ArrayList<>());
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeStore);

    // Act
    assetUpdateHelper.updateExchange();

    // Assert
    verify(chainBaseManager).getExchangeStore();
    verify(exchangeStore).getAllExchanges();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeStore} {@link ExchangeStore#getAllExchanges()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_givenExchangeStoreGetAllExchangesThrowRuntimeException() {
    // Arrange
    ExchangeStore exchangeStore = mock(ExchangeStore.class);
    when(exchangeStore.getAllExchanges()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateExchange());
    verify(chainBaseManager).getExchangeStore();
    verify(exchangeStore).getAllExchanges();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Given {@link AccountStore} {@link AccountStore#iterator()} return {@link
   *       ArrayList#ArrayList()} iterator.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_givenAccountStoreIteratorReturnArrayListIterator() {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);

    ArrayList<Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    when(accountStore.iterator()).thenReturn(entryList.iterator());
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    assetUpdateHelper.updateAccount();

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(accountStore).iterator();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Given {@link AccountStore} {@link AccountStore#iterator()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_givenAccountStoreIteratorThrowRuntimeException() {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.iterator()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAccount());
    verify(chainBaseManager).getAccountStore();
    verify(accountStore).iterator();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getAccountStore()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_givenChainBaseManagerGetAccountStoreThrowRuntimeException() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assetUpdateHelper.updateAccount());
    verify(chainBaseManager).getAccountStore();
  }

  /**
   * Test {@link AssetUpdateHelper#finish()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getDynamicPropertiesStore()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#finish()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetUpdateHelper.finish()"})
  public void testFinish_thenCallsGetDynamicPropertiesStore() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTokenUpdateDone(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    new AssetUpdateHelper(chainBaseManager).finish();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveTokenUpdateDone(1L);
  }
}
