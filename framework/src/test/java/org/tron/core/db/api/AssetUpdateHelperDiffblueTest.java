package org.tron.core.db.api;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.AssetIssueCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.ExchangeCapsule;
import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeV2Store;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AssetIssueContractOuterClass;

public class AssetUpdateHelperDiffblueTest {
  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException("Start to update the asset"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork2() throws BadItemException, ItemNotFoundException {
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
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException("Start to update the asset"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork3() throws BadItemException, ItemNotFoundException {
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
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork4() throws BadItemException, ItemNotFoundException {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(exchangeV2Store).reset();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException("Start to update the asset"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork5() throws BadItemException, ItemNotFoundException {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(assetIssueV2Store).reset();
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException("Start to update the asset"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  public void testDoWork6() throws BadItemException, ItemNotFoundException {
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

    ArrayList<AssetIssueCapsule> assetIssueCapsuleList = new ArrayList<>();
    assetIssueCapsuleList
        .add(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(assetIssueCapsuleList);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).init());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  public void testInit2() {
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
    (new AssetUpdateHelper(chainBaseManager)).init();

    // Assert that nothing has changed
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  public void testInit3() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(false);
    doNothing().when(exchangeV2Store).reset();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).init();

    // Assert that nothing has changed
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  public void testInit4() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(false);
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
    (new AssetUpdateHelper(chainBaseManager)).init();

    // Assert that nothing has changed
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1000000L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  public void testInit5() {
    // Arrange
    AssetIssueV2Store assetIssueV2Store = mock(AssetIssueV2Store.class);
    when(assetIssueV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(assetIssueV2Store).reset();
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.isNotEmpty()).thenReturn(true);
    doNothing().when(exchangeV2Store).reset();
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store);
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(assetIssueV2Store);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).init());
    verify(chainBaseManager, atLeast(1)).getAssetIssueV2Store();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager, atLeast(1)).getExchangeV2Store();
    verify(assetIssueV2Store).isNotEmpty();
    verify(exchangeV2Store).isNotEmpty();
    verify(assetIssueV2Store).reset();
    verify(exchangeV2Store).reset();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues2() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException("Block does not exist, num:"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues3() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues4() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    List<AssetIssueCapsule> actualAllAssetIssues = (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues();

    // Assert
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    assertTrue(actualAllAssetIssues.isEmpty());
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues5() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    ArrayList<AssetIssueCapsule> assetIssueCapsuleList = new ArrayList<>();
    assetIssueCapsuleList
        .add(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(assetIssueCapsuleList);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues6() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.addTransaction(new TransactionCapsule(Protocol.Transaction.getDefaultInstance()));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues7() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.get(Mockito.<byte[]>any()))
        .thenReturn(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    when(assetIssueStore.getAllAssetIssues()).thenReturn(new ArrayList<>());

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule
        .addTransaction(new TransactionCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager, atLeast(1)).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(assetIssueStore).get(isA(byte[].class));
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  public void testGetAllAssetIssues8() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    TransactionCapsule pendingTrx = mock(TransactionCapsule.class);
    when(pendingTrx.getInstance()).thenReturn(Protocol.Transaction.getDefaultInstance());

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.addTransaction(pendingTrx);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(pendingTrx, atLeast(1)).getInstance();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset2() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException("Block does not exist, num:"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset3() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset4() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTokenIdNum(anyLong());
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAsset();

    // Assert that nothing has changed
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset5() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doThrow(new RuntimeException("Total block:{}")).when(dynamicPropertiesStore).saveTokenIdNum(anyLong());
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
    verify(dynamicPropertiesStore).saveTokenIdNum(eq(1L));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset6() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);

    ArrayList<AssetIssueCapsule> assetIssueCapsuleList = new ArrayList<>();
    assetIssueCapsuleList
        .add(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.getAllAssetIssues()).thenReturn(assetIssueCapsuleList);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset7() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.addTransaction(new TransactionCapsule(Protocol.Transaction.getDefaultInstance()));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset8() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    AssetIssueStore assetIssueStore = mock(AssetIssueStore.class);
    when(assetIssueStore.get(Mockito.<byte[]>any()))
        .thenReturn(new AssetIssueCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    when(assetIssueStore.getAllAssetIssues()).thenReturn(new ArrayList<>());

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule
        .addTransaction(new TransactionCapsule(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getAssetIssueStore()).thenReturn(assetIssueStore);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager, atLeast(1)).getAssetIssueStore();
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(assetIssueStore).get(isA(byte[].class));
    verify(assetIssueStore).getAllAssetIssues();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  public void testUpdateAsset9() throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getTokenIdNum()).thenReturn(1L);
    TransactionCapsule pendingTrx = mock(TransactionCapsule.class);
    when(pendingTrx.getInstance()).thenReturn(Protocol.Transaction.getDefaultInstance());

    BlockCapsule blockCapsule = new BlockCapsule(Protocol.Block.getDefaultInstance());
    blockCapsule.addTransaction(pendingTrx);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getBlockByNum(eq(1L));
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(pendingTrx, atLeast(1)).getInstance();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getTokenIdNum();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  public void testUpdateExchange() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateExchange());
    verify(chainBaseManager).getExchangeStore();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  public void testUpdateExchange2() {
    // Arrange
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.getAllExchanges()).thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeV2Store);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateExchange();

    // Assert that nothing has changed
    verify(chainBaseManager).getExchangeStore();
    verify(exchangeV2Store).getAllExchanges();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  public void testUpdateExchange3() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = mock(ExchangeCapsule.class);
    when(exchangeCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(exchangeCapsule.getFirstTokenId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(exchangeCapsule.getSecondTokenId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(exchangeCapsule).setFirstTokenId(Mockito.<byte[]>any());
    doNothing().when(exchangeCapsule).setSecondTokenId(Mockito.<byte[]>any());

    ArrayList<ExchangeCapsule> exchangeCapsuleList = new ArrayList<>();
    exchangeCapsuleList.add(exchangeCapsule);
    ExchangeV2Store exchangeV2Store = mock(ExchangeV2Store.class);
    when(exchangeV2Store.getAllExchanges()).thenReturn(exchangeCapsuleList);
    ExchangeV2Store exchangeV2Store2 = mock(ExchangeV2Store.class);
    doNothing().when(exchangeV2Store2).put(Mockito.<byte[]>any(), Mockito.<ExchangeCapsule>any());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeV2Store()).thenReturn(exchangeV2Store2);
    when(chainBaseManager.getExchangeStore()).thenReturn(exchangeV2Store);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateExchange();

    // Assert that nothing has changed
    verify(chainBaseManager).getExchangeStore();
    verify(chainBaseManager).getExchangeV2Store();
    verify(exchangeCapsule).createDbKey();
    verify(exchangeCapsule, atLeast(1)).getFirstTokenId();
    verify(exchangeCapsule, atLeast(1)).getSecondTokenId();
    verify(exchangeCapsule).setFirstTokenId(isNull());
    verify(exchangeCapsule).setSecondTokenId(isNull());
    verify(exchangeV2Store2).put(isA(byte[].class), isA(ExchangeCapsule.class));
    verify(exchangeV2Store).getAllExchanges();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAccount());
    verify(chainBaseManager).getAccountStore();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount2() {
    // Arrange
    AccountStore accountStore = mock(AccountStore.class);

    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    when(accountStore.iterator()).thenReturn(entryList.iterator());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(accountStore).iterator();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount3() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    entryList.add(new AbstractMap.SimpleEntry<>(bytes, new AccountCapsule(Protocol.Account.getDefaultInstance())));
    Iterator<Map.Entry<byte[], AccountCapsule>> iteratorResult = entryList.iterator();
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.iterator()).thenReturn(iteratorResult);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert
    verify(chainBaseManager, atLeast(1)).getAccountStore();
    verify(accountStore).iterator();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount4() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    entryList.add(new AbstractMap.SimpleEntry<>(bytes, new AccountCapsule(Protocol.Account.getDefaultInstance())));
    byte[] bytes2 = "AXAXAXAX".getBytes("UTF-8");
    entryList.add(new AbstractMap.SimpleEntry<>(bytes2, new AccountCapsule(Protocol.Account.getDefaultInstance())));
    Iterator<Map.Entry<byte[], AccountCapsule>> iteratorResult = entryList.iterator();
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.iterator()).thenReturn(iteratorResult);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert
    verify(chainBaseManager, atLeast(1)).getAccountStore();
    verify(accountStore).iterator();
    verify(accountStore, atLeast(1)).put(isA(byte[].class), Mockito.<AccountCapsule>any());
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount5() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    entryList.add(new AbstractMap.SimpleEntry<>(bytes,
        new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance())));
    Iterator<Map.Entry<byte[], AccountCapsule>> iteratorResult = entryList.iterator();
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.iterator()).thenReturn(iteratorResult);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert
    verify(chainBaseManager, atLeast(1)).getAccountStore();
    verify(accountStore).iterator();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount6() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap3 = new HashMap<>();
    stringResultLongMap3.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(accountCapsule)
        .addAllLatestAssetOperationTimeV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAssetMapV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAllFreeAssetNetUsageV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAllFreeAssetNetUsage()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getLatestAssetOperationTimeMap()).thenReturn(stringResultLongMap3);
    doNothing().when(accountCapsule).clearAssetV2();
    doNothing().when(accountCapsule).clearFreeAssetNetUsageV2();
    doNothing().when(accountCapsule).clearLatestAssetOperationTimeV2();
    AbstractMap.SimpleEntry<byte[], AccountCapsule> simpleEntry = new AbstractMap.SimpleEntry<>(
        "AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);
    AccountStore accountStore = mock(AccountStore.class);
    when(accountStore.iterator()).thenReturn(entryList.iterator());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAccount());
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
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount7() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(true);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap3 = new HashMap<>();
    stringResultLongMap3.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(accountCapsule).addAllLatestAssetOperationTimeV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAssetMapV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAllFreeAssetNetUsageV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAssetIssuedName()).thenReturn(byteString);
    when(accountCapsule.getAllFreeAssetNetUsage()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getLatestAssetOperationTimeMap()).thenReturn(stringResultLongMap3);
    doNothing().when(accountCapsule).clearAssetV2();
    doNothing().when(accountCapsule).clearFreeAssetNetUsageV2();
    doNothing().when(accountCapsule).clearLatestAssetOperationTimeV2();
    AbstractMap.SimpleEntry<byte[], AccountCapsule> simpleEntry = new AbstractMap.SimpleEntry<>(
        "AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);
    Iterator<Map.Entry<byte[], AccountCapsule>> iteratorResult = entryList.iterator();
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.iterator()).thenReturn(iteratorResult);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert
    verify(byteString).isEmpty();
    verify(chainBaseManager, atLeast(1)).getAccountStore();
    verify(accountCapsule).addAllFreeAssetNetUsageV2(isA(Map.class));
    verify(accountCapsule).addAllLatestAssetOperationTimeV2(isA(Map.class));
    verify(accountCapsule).addAssetMapV2(isA(Map.class));
    verify(accountCapsule).clearAssetV2();
    verify(accountCapsule).clearFreeAssetNetUsageV2();
    verify(accountCapsule).clearLatestAssetOperationTimeV2();
    verify(accountCapsule).createDbKey();
    verify(accountCapsule, atLeast(1)).getAllFreeAssetNetUsage();
    verify(accountCapsule).getAssetIssuedName();
    verify(accountCapsule, atLeast(1)).getAssetMap();
    verify(accountCapsule, atLeast(1)).getLatestAssetOperationTimeMap();
    verify(accountStore).iterator();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  public void testUpdateAccount8() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.isEmpty()).thenReturn(false);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap3 = new HashMap<>();
    stringResultLongMap3.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(accountCapsule).setAssetIssuedID(Mockito.<byte[]>any());
    doNothing().when(accountCapsule).addAllLatestAssetOperationTimeV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAssetMapV2(Mockito.<Map<String, Long>>any());
    doNothing().when(accountCapsule).addAllFreeAssetNetUsageV2(Mockito.<Map<String, Long>>any());
    when(accountCapsule.getAssetIssuedName()).thenReturn(byteString);
    when(accountCapsule.getAllFreeAssetNetUsage()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getLatestAssetOperationTimeMap()).thenReturn(stringResultLongMap3);
    doNothing().when(accountCapsule).clearAssetV2();
    doNothing().when(accountCapsule).clearFreeAssetNetUsageV2();
    doNothing().when(accountCapsule).clearLatestAssetOperationTimeV2();
    AbstractMap.SimpleEntry<byte[], AccountCapsule> simpleEntry = new AbstractMap.SimpleEntry<>(
        "AXAXAXAX".getBytes("UTF-8"), accountCapsule);

    ArrayList<Map.Entry<byte[], AccountCapsule>> entryList = new ArrayList<>();
    entryList.add(simpleEntry);
    Iterator<Map.Entry<byte[], AccountCapsule>> iteratorResult = entryList.iterator();
    AccountStore accountStore = mock(AccountStore.class);
    doNothing().when(accountStore).put(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(accountStore.iterator()).thenReturn(iteratorResult);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(accountStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).updateAccount();

    // Assert
    verify(byteString).isEmpty();
    verify(byteString).toByteArray();
    verify(chainBaseManager, atLeast(1)).getAccountStore();
    verify(accountCapsule).addAllFreeAssetNetUsageV2(isA(Map.class));
    verify(accountCapsule).addAllLatestAssetOperationTimeV2(isA(Map.class));
    verify(accountCapsule).addAssetMapV2(isA(Map.class));
    verify(accountCapsule).clearAssetV2();
    verify(accountCapsule).clearFreeAssetNetUsageV2();
    verify(accountCapsule).clearLatestAssetOperationTimeV2();
    verify(accountCapsule).createDbKey();
    verify(accountCapsule, atLeast(1)).getAllFreeAssetNetUsage();
    verify(accountCapsule, atLeast(1)).getAssetIssuedName();
    verify(accountCapsule, atLeast(1)).getAssetMap();
    verify(accountCapsule, atLeast(1)).getLatestAssetOperationTimeMap();
    verify(accountCapsule).setAssetIssuedID(isNull());
    verify(accountStore).iterator();
    verify(accountStore).put(isA(byte[].class), isA(AccountCapsule.class));
  }

  /**
   * Method under test: {@link AssetUpdateHelper#finish()}
   */
  @Test
  public void testFinish() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).finish());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test: {@link AssetUpdateHelper#finish()}
   */
  @Test
  public void testFinish2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveTokenUpdateDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    (new AssetUpdateHelper(chainBaseManager)).finish();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveTokenUpdateDone(eq(1L));
  }
}
