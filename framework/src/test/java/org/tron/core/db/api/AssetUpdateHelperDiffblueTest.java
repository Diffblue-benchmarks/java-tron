package org.tron.core.db.api;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.ExchangeCapsule;
import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeV2Store;

public class AssetUpdateHelperDiffblueTest {
  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenArrayListAddNull_thenCallsGetTransactions()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(null);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(transactionCapsuleList);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(blockCapsule).getTransactions();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(1000000L);
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} return {@code
   *       false}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenAssetIssueV2StoreIsNotEmptyReturnFalse_thenThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(assetIssueV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} return {@code
   *       null}.
   *   <li>Then calls {@link ChainBaseManager#getBlockByNum(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenChainBaseManagerGetBlockByNumReturnNull_thenCallsGetBlockByNum()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(1000000L);
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockByNum(long)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenChainBaseManagerGetBlockByNumThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(1000000L);
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getDynamicPropertiesStore()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenChainBaseManagerGetDynamicPropertiesStoreThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getExchangeV2Store()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenChainBaseManagerGetExchangeV2StoreThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeV2Store} {@link ExchangeV2Store#isNotEmpty()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_givenExchangeV2StoreIsNotEmptyReturnFalse() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(exchangeV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link AssetIssueV2Store} {@link AssetIssueV2Store#isNotEmpty()} return {@code
   *       false}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenAssetIssueV2StoreIsNotEmptyReturnFalse_thenThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(assetIssueV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getDynamicPropertiesStore()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenChainBaseManagerGetDynamicPropertiesStoreThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getExchangeV2Store()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenChainBaseManagerGetExchangeV2StoreThrowRuntimeException() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeV2Store} {@link ExchangeV2Store#isNotEmpty()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_givenExchangeV2StoreIsNotEmptyReturnFalse() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(exchangeV2Store).reset();

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicPropertiesStore#saveTokenIdNum(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_thenCallsSaveTokenIdNum() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act
    new AssetUpdateHelper(chainBaseManager).init();

    // Assert
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).saveTokenIdNum(1000000L);
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_givenArrayListAddNull_thenCallsGetTransactions()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(null);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(transactionCapsuleList);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule).getTransactions();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_givenChainBaseManagerGetBlockByNumReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).getAllAssetIssues());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_givenChainBaseManagerGetBlockByNumThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenArrayListAddNull_thenCallsGetTransactions()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(null);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(transactionCapsuleList);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAsset());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(blockCapsule).getTransactions();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenChainBaseManagerGetBlockByNumReturnNull()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAsset());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_givenChainBaseManagerGetBlockByNumThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAsset());
    verify(chainBaseManager).getBlockByNum(1L);
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getExchangeStore()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_thenCallsGetExchangeStore() {
    // Arrange
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.getAllExchanges()).thenReturn(new ArrayList<>());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeV2Store);

    // Act
    new AssetUpdateHelper(chainBaseManager).updateExchange();

    // Assert
    verify(chainBaseManager).getExchangeStore();
    verify(exchangeV2Store).getAllExchanges();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = mock(ExchangeCapsule.class);
    when(exchangeCapsule.getFirstTokenId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(exchangeCapsule.getSecondTokenId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(exchangeCapsule).setFirstTokenId(Mockito.<byte[]>any());
    doNothing().when(exchangeCapsule).setSecondTokenId(Mockito.<byte[]>any());

    ArrayList<ExchangeCapsule> exchangeCapsuleList = new ArrayList<>();
    exchangeCapsuleList.add(exchangeCapsule);

    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.getAllExchanges()).thenReturn(exchangeCapsuleList);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new RuntimeException());
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeV2Store);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateExchange());
    verify(chainBaseManager).getExchangeStore();
    verify(chainBaseManager).getExchangeV2Store();
    verify(exchangeCapsule, atLeast(1)).getFirstTokenId();
    verify(exchangeCapsule, atLeast(1)).getSecondTokenId();
    verify(exchangeCapsule).setFirstTokenId(isNull());
    verify(exchangeCapsule).setSecondTokenId(isNull());
    verify(exchangeV2Store).getAllExchanges();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException())
        .when(accountCapsule)
        .addAllFreeAssetNetUsageV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAllFreeAssetNetUsage()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMap()).thenReturn(new HashMap<>());
    doNothing().when(accountCapsule).clearAssetV2();
    doNothing().when(accountCapsule).clearFreeAssetNetUsageV2();
    SimpleEntry<byte[], AccountCapsule> simpleEntry =
        new SimpleEntry<>("AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);

    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.iterator()).thenReturn(entryList.iterator());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAccount());
    verify(chainBaseManager).getAccountStore();
    verify(accountCapsule).addAllFreeAssetNetUsageV2(isA(Map.class));
    verify(accountCapsule).clearAssetV2();
    verify(accountCapsule).clearFreeAssetNetUsageV2();
    verify(accountCapsule, atLeast(1)).getAllFreeAssetNetUsage();
    verify(accountCapsule).getAssetMap();
    verify(accountStore).iterator();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#addAssetMapV2(Map)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_givenAccountCapsuleAddAssetMapV2ThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException())
        .when(accountCapsule)
        .addAssetMapV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap);
    doNothing().when(accountCapsule).clearAssetV2();
    SimpleEntry<byte[], AccountCapsule> simpleEntry =
        new SimpleEntry<>("AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);

    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.iterator()).thenReturn(entryList.iterator());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAccount());
    verify(chainBaseManager).getAccountStore();
    verify(accountCapsule).addAssetMapV2(isA(Map.class));
    verify(accountCapsule).clearAssetV2();
    verify(accountCapsule, atLeast(1)).getAssetMap();
    verify(accountStore).iterator();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addAllLatestAssetOperationTimeV2(Map)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_thenCallsAddAllLatestAssetOperationTimeV2()
      throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap3 = new HashMap<>();
    stringResultLongMap3.put("foo", 1L);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException())
        .when(accountCapsule)
        .addAllLatestAssetOperationTimeV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAssetMapV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAllFreeAssetNetUsageV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAllFreeAssetNetUsage()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getLatestAssetOperationTimeMap()).thenReturn(stringResultLongMap3);
    doNothing().when(accountCapsule).clearAssetV2();
    doNothing().when(accountCapsule).clearFreeAssetNetUsageV2();
    doNothing().when(accountCapsule).clearLatestAssetOperationTimeV2();
    SimpleEntry<byte[], AccountCapsule> simpleEntry =
        new SimpleEntry<>("AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);

    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.iterator()).thenReturn(entryList.iterator());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> new AssetUpdateHelper(chainBaseManager).updateAccount());
    verify(chainBaseManager).getAccountStore();
    verify(accountCapsule).addAllFreeAssetNetUsageV2(isA(Map.class));
    verify(accountCapsule).addAllLatestAssetOperationTimeV2(isA(Map.class));
    verify(accountCapsule).addAssetMapV2(isA(Map.class));
    verify(accountCapsule).clearAssetV2();
    verify(accountCapsule).clearFreeAssetNetUsageV2();
    verify(accountCapsule).clearLatestAssetOperationTimeV2();
    verify(accountCapsule, atLeast(1)).getAllFreeAssetNetUsage();
    verify(accountCapsule, atLeast(1)).getAssetMap();
    verify(accountCapsule, atLeast(1)).getLatestAssetOperationTimeMap();
    verify(accountStore).iterator();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getAccountStore()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_thenCallsGetAccountStore() {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);

    ArrayList<Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    when(accountStore.iterator()).thenReturn(entryList.iterator());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    new AssetUpdateHelper(chainBaseManager).updateAccount();

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(accountStore).iterator();
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
  @Category(MaintainedByDiffblue.class)
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
