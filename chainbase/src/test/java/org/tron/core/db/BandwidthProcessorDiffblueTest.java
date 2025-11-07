package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.AssetIssueCapsule;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.Common;

public class BandwidthProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNetUsage(anyLong());
    doNothing().when(ac).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(1L));
    verify(ac).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(ac).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsageForDelegated(ac));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1000L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNetUsage(anyLong());
    doNothing().when(ac).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(0L));
    verify(ac).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(28800000L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(0L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNetUsage(anyLong());
    doNothing().when(ac).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(1L));
    verify(ac).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(1003L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    doNothing().when(ac).setNetUsage(anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(1L));
    verify(ac).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(ac).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsageForDelegated(ac));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(0L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    doNothing().when(ac).setNetUsage(anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(1L));
    verify(ac).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(4L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(Long.MAX_VALUE);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    doNothing().when(ac).setNetUsage(anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(0L));
    verify(ac).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(28800L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doNothing().when(ac).setNetUsage(anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsageForDelegated(ac);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNetUsage(eq(1L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsageForDelegated(AccountCapsule)}
   */
  @Test
  public void testUpdateUsageForDelegated10() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(Long.MAX_VALUE);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule ac = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(ac).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(ac.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(ac.getLatestConsumeTime()).thenReturn(1L);
    when(ac.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsageForDelegated(ac));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(ac).getLatestConsumeTime();
    verify(ac).getNetUsage();
    verify(ac).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(ac).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(28800L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    doNothing().when(accountCapsule).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(accountCapsule)
        .setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsage(accountCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1000L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    doNothing().when(accountCapsule).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(0L));
    verify(accountCapsule).setNetUsage(eq(0L));
    verify(accountCapsule).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(28800000L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(Long.MAX_VALUE);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    doNothing().when(accountCapsule).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(0L));
    verify(accountCapsule).setNetUsage(eq(0L));
    verify(accountCapsule).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(28800000L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMap()).thenReturn(new HashMap<>());
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    doNothing().when(accountCapsule).setNewWindowSizeV2(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getWindowSizeV2(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).getWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSizeV2(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(new HashMap<>());
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doThrow(new RuntimeException("foo")).when(accountCapsule)
        .setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsage(accountCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(20800L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(new HashMap<>());
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(0L));
    verify(accountCapsule).setNetUsage(eq(0L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(28800L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMap()).thenReturn(new HashMap<>());
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage10() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage11() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("42", 20800L);
    stringResultLongMap.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule, atLeast(1)).getFreeAssetNetUsage(Mockito.<String>any());
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule, atLeast(1)).getLatestAssetOperationTime(Mockito.<String>any());
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule, atLeast(1)).putFreeAssetNetUsage(Mockito.<String>any(), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage12() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsageV2(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTimeV2(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsageV2(Mockito.<String>any(), anyLong());
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule).getFreeAssetNetUsageV2(eq("foo"));
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule).getLatestAssetOperationTimeV2(eq("foo"));
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule).putFreeAssetNetUsageV2(eq("foo"), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage13() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("42", 20800L);
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsageV2(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTimeV2(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsageV2(Mockito.<String>any(), anyLong());
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule, atLeast(1)).getFreeAssetNetUsageV2(Mockito.<String>any());
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule, atLeast(1)).getLatestAssetOperationTimeV2(Mockito.<String>any());
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule, atLeast(1)).putFreeAssetNetUsageV2(Mockito.<String>any(), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage14() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap3 = new HashMap<>();
    stringResultLongMap3.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsageV2(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTimeV2(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsageV2(Mockito.<String>any(), anyLong());
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap3);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMapV2()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule).getFreeAssetNetUsageV2(eq("foo"));
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule).getLatestAssetOperationTimeV2(eq("foo"));
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule).putFreeAssetNetUsageV2(eq("foo"), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage15() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsageV2(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTimeV2(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsageV2(Mockito.<String>any(), anyLong());
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(20800L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule).getFreeAssetNetUsageV2(eq("foo"));
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule).getLatestAssetOperationTimeV2(eq("foo"));
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule).putFreeAssetNetUsageV2(eq("foo"), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(6934L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(20802L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AccountCapsule)}
   */
  @Test
  public void testUpdateUsage16() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);
    when(dynamicPropertiesStore.supportAllowCancelAllUnfreezeV2()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 1L);

    HashMap<String, Long> stringResultLongMap2 = new HashMap<>();
    stringResultLongMap2.put("foo", 1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFreeAssetNetUsageV2(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));
    when(accountCapsule.getFreeAssetNetUsage(Mockito.<String>any())).thenReturn(1L);
    when(accountCapsule.getLatestAssetOperationTime(Mockito.<String>any())).thenReturn(1L);
    doNothing().when(accountCapsule).putFreeAssetNetUsage(Mockito.<String>any(), anyLong());
    doNothing().when(accountCapsule).setNewWindowSize(Mockito.<Common.ResourceCode>any(), anyLong());
    when(accountCapsule.getAssetMap()).thenReturn(stringResultLongMap2);
    when(accountCapsule.getAllFreeAssetNetUsageV2()).thenReturn(stringResultLongMap);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    when(accountCapsule.getFreeNetUsage()).thenReturn(1L);
    when(accountCapsule.getLatestConsumeFreeTime()).thenReturn(1L);
    doNothing().when(accountCapsule).setFreeNetUsage(anyLong());
    doNothing().when(accountCapsule).setNetUsage(anyLong());
    when(accountCapsule.getWindowSize(Mockito.<Common.ResourceCode>any())).thenReturn(3L);
    when(accountCapsule.getLatestConsumeTime()).thenReturn(1L);
    when(accountCapsule.getNetUsage()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsage(accountCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(accountCapsule).getAllFreeAssetNetUsageV2();
    verify(accountCapsule).getAssetMap();
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule).getFreeAssetNetUsage(eq("foo"));
    verify(accountCapsule).getFreeAssetNetUsageV2(eq("foo"));
    verify(accountCapsule).getFreeNetUsage();
    verify(accountCapsule).getLatestAssetOperationTime(eq("foo"));
    verify(accountCapsule).getLatestConsumeFreeTime();
    verify(accountCapsule).getLatestConsumeTime();
    verify(accountCapsule).getNetUsage();
    verify(accountCapsule).getWindowSize(eq(Common.ResourceCode.BANDWIDTH));
    verify(accountCapsule).putFreeAssetNetUsage(eq("foo"), eq(1L));
    verify(accountCapsule).setFreeNetUsage(eq(1L));
    verify(accountCapsule).setNetUsage(eq(1L));
    verify(accountCapsule).setNewWindowSize(eq(Common.ResourceCode.BANDWIDTH), eq(3L));
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    verify(dynamicPropertiesStore).supportAllowCancelAllUnfreezeV2();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  public void testUpdateUsage17() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    assertEquals(assetIssueContract, assetIssueCapsule.getInstance());
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  public void testUpdateUsage18() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(28800L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    assertEquals(assetIssueContract, assetIssueCapsule.getInstance());
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  public void testUpdateUsage19() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(0L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    assertEquals(assetIssueContract, assetIssueCapsule.getInstance());
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  public void testUpdateUsage20() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    // Act
    bandwidthProcessor
        .updateUsage(new AssetIssueCapsule(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, "42", "Name", "Abbr", 1L, 1));

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  public void testUpdateUsage21() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueCapsule assetIssueCapsule = mock(AssetIssueCapsule.class);
    when(assetIssueCapsule.getPublicFreeAssetNetUsage()).thenReturn(1L);
    when(assetIssueCapsule.getPublicLatestFreeNetTime()).thenReturn(1L);
    doNothing().when(assetIssueCapsule).setPublicFreeAssetNetUsage(anyLong());

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert that nothing has changed
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(eq(1L));
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsage(AssetIssueCapsule, long)}
   */
  @Test
  public void testUpdateUsage22() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule, 1L);

    // Assert
    assertEquals(assetIssueContract, assetIssueCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#updateUsage(AssetIssueCapsule, long)}
   */
  @Test
  public void testUpdateUsage23() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());
    AssetIssueContractOuterClass.AssetIssueContract assetIssueContract = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(assetIssueContract);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule, 28800L);

    // Assert
    assertEquals(assetIssueContract, assetIssueCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#contractCreateNewAccount(Protocol.Transaction.Contract)}
   */
  @Test
  public void testContractCreateNewAccount() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());

    // Act and Assert
    assertTrue(bandwidthProcessor.contractCreateNewAccount(Protocol.Transaction.Contract.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenThrow(new RuntimeException("foo"));
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.calculateGlobalNetLimit(accountCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(true);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(true);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(1L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(false);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(1L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(true);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenThrow(new RuntimeException("foo"));
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(1L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1000000L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.calculateGlobalNetLimit(accountCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
  }

  /**
   * Method under test:
   * {@link BandwidthProcessor#calculateGlobalNetLimit(AccountCapsule)}
   */
  @Test
  public void testCalculateGlobalNetLimit9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowNewReward()).thenReturn(false);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(0L);
    when(dynamicPropertiesStore.supportUnfreezeDelay()).thenReturn(false);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllFrozenBalanceForBandwidth()).thenReturn(1000000L);

    // Act
    long actualCalculateGlobalNetLimitResult = bandwidthProcessor.calculateGlobalNetLimit(accountCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(accountCapsule).getAllFrozenBalanceForBandwidth();
    verify(dynamicPropertiesStore).allowNewReward();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    verify(dynamicPropertiesStore).supportUnfreezeDelay();
    assertEquals(0L, actualCalculateGlobalNetLimitResult);
  }

  /**
   * Method under test: {@link BandwidthProcessor#calculateGlobalNetLimitV2(long)}
   */
  @Test
  public void testCalculateGlobalNetLimitV2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(1L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualCalculateGlobalNetLimitV2Result = (new BandwidthProcessor(chainBaseManager))
        .calculateGlobalNetLimitV2(42L);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    assertEquals(0L, actualCalculateGlobalNetLimitV2Result);
  }

  /**
   * Method under test: {@link BandwidthProcessor#calculateGlobalNetLimitV2(long)}
   */
  @Test
  public void testCalculateGlobalNetLimitV22() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getTotalNetLimit()).thenReturn(1L);
    when(dynamicPropertiesStore.getTotalNetWeight()).thenReturn(0L);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualCalculateGlobalNetLimitV2Result = (new BandwidthProcessor(chainBaseManager))
        .calculateGlobalNetLimitV2(42L);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getTotalNetLimit();
    verify(dynamicPropertiesStore).getTotalNetWeight();
    assertEquals(0L, actualCalculateGlobalNetLimitV2Result);
  }
}
