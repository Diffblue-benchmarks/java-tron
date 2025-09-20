package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.AssetIssueCapsule;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;

@RunWith(MockitoJUnitRunner.class)
public class BandwidthProcessorDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  /**
   * Test {@link BandwidthProcessor#BandwidthProcessor(ChainBaseManager)}.
   *
   * <p>Method under test: {@link BandwidthProcessor#BandwidthProcessor(ChainBaseManager)}
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
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
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
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule2() throws UnsupportedEncodingException {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule3() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setOrder(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule4() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule5() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule6() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setPublicLatestFreeNetTime(1L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule, long)} with {@code
   * assetIssueCapsule}, {@code now}.
   *
   * <ul>
   *   <li>Then calls {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule, long)"})
  public void testUpdateUsageWithAssetIssueCapsuleNow_thenCallsGetPublicFreeAssetNetUsage() {
    // Arrange
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(new ChainBaseManager());

    AssetIssueCapsule assetIssueCapsule = mock(AssetIssueCapsule.class);
    when(assetIssueCapsule.getPublicFreeAssetNetUsage()).thenReturn(1L);
    when(assetIssueCapsule.getPublicLatestFreeNetTime()).thenReturn(1L);
    doNothing().when(assetIssueCapsule).setPublicFreeAssetNetUsage(anyLong());
    doNothing().when(assetIssueCapsule).setPublicLatestFreeNetTime(anyLong());
    assetIssueCapsule.setPublicLatestFreeNetTime(Long.MAX_VALUE);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule, 1L);

    // Assert
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(1L);
    verify(assetIssueCapsule).setPublicLatestFreeNetTime(9223372036854775807L);
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <ul>
   *   <li>Given forty-two.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_givenFortyTwo() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <ul>
   *   <li>Given {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_givenMin_value() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getHeadSlot()).thenReturn(1L);
    when(chainBaseManager.getAccountStore()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);
    BandwidthProcessor bandwidthProcessor = new BandwidthProcessor(chainBaseManager);

    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});
    assetIssueCapsule.setPublicLatestFreeNetTime(Long.MIN_VALUE);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
  }

  /**
   * Test {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)} with {@code assetIssueCapsule}.
   *
   * <ul>
   *   <li>Then calls {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthProcessor#updateUsage(AssetIssueCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthProcessor.updateUsage(AssetIssueCapsule)"})
  public void testUpdateUsageWithAssetIssueCapsule_thenCallsGetPublicFreeAssetNetUsage() {
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
    doNothing().when(assetIssueCapsule).setPublicLatestFreeNetTime(anyLong());
    assetIssueCapsule.setPublicLatestFreeNetTime(Long.MAX_VALUE);

    // Act
    bandwidthProcessor.updateUsage(assetIssueCapsule);

    // Assert
    verify(chainBaseManager).getAccountStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(chainBaseManager).getHeadSlot();
    verify(assetIssueCapsule).getPublicFreeAssetNetUsage();
    verify(assetIssueCapsule).getPublicLatestFreeNetTime();
    verify(assetIssueCapsule).setPublicFreeAssetNetUsage(1L);
    verify(assetIssueCapsule).setPublicLatestFreeNetTime(9223372036854775807L);
  }

  /**
   * Test {@link BandwidthProcessor#contractCreateNewAccount(Contract)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthProcessor#contractCreateNewAccount(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BandwidthProcessor.contractCreateNewAccount(Transaction.Contract)"})
  public void testContractCreateNewAccount_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new BandwidthProcessor(new ChainBaseManager())
            .contractCreateNewAccount(Contract.getDefaultInstance()));
  }
}
