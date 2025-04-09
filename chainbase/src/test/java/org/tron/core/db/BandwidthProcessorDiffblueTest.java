package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AssetIssueCapsule;

@RunWith(MockitoJUnitRunner.class)
public class BandwidthProcessorDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  /**
   * Test {@link BandwidthProcessor#BandwidthProcessor(ChainBaseManager)}.
   * <p>
   * Method under test: {@link BandwidthProcessor#BandwidthProcessor(ChainBaseManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.<init>(ChainBaseManager)"})
  public void testNewBandwidthProcessor() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    BandwidthProcessor actualBandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    assertNull(actualBandwidthProcessor.accountStore);
    assertNull(actualBandwidthProcessor.dynamicPropertiesStore);
    assertEquals(1000000L, actualBandwidthProcessor.precision);
    assertEquals(20L, actualBandwidthProcessor.averageWindowSize);
    assertEquals(28800L, actualBandwidthProcessor.windowSize);
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   * <p>
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    // Act
    bandwidthProcessor.updateUsage(new AssetIssueCapsule(new byte[]{}));

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   * <p>
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule2() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueCapsule assetIssueCapsule = mock(AssetIssueCapsule.class);
    doNothing().when(assetIssueCapsule).setPublicFreeAssetNetUsage(anyLong());
    when(assetIssueCapsule.getPublicFreeAssetNetUsage()).thenReturn(1L);
    when(assetIssueCapsule.getPublicLatestFreeNetTime()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(eq(1L));
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getHeadSlot()} return {@code 20800}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_givenChainBaseManagerGetHeadSlotReturn20800() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(20800L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueCapsule assetIssueCapsule = mock(AssetIssueCapsule.class);
    doNothing().when(assetIssueCapsule).setPublicFreeAssetNetUsage(anyLong());
    when(assetIssueCapsule.getPublicFreeAssetNetUsage()).thenReturn(1L);
    when(assetIssueCapsule.getPublicLatestFreeNetTime()).thenReturn(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(eq(0L));
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getHeadSlot()} return {@code 28800}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_givenChainBaseManagerGetHeadSlotReturn28800() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(28800L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    // Act
    bandwidthProcessor.updateUsage(new AssetIssueCapsule(new byte[]{}));

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(20800L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueCapsule assetIssueCapsule = mock(AssetIssueCapsule.class);
    doThrow(new RuntimeException("foo")).when(assetIssueCapsule).setPublicFreeAssetNetUsage(anyLong());
    when(assetIssueCapsule.getPublicFreeAssetNetUsage()).thenReturn(1L);
    when(assetIssueCapsule.getPublicLatestFreeNetTime()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bandwidthProcessor.updateUsage(assetIssueCapsule));
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(eq(0L));
  }
}
