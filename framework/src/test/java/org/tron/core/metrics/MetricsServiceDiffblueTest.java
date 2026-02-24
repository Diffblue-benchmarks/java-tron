package org.tron.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.metrics.blockchain.BlockChainMetricManager;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MetricsServiceDiffblueTest {
  @Mock private BlockChainMetricManager blockChainMetricManager;

  @InjectMocks private MetricsService metricsService;

  /**
   * Test {@link MetricsService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockChainMetricManager} {@link
   *       BlockChainMetricManager#applyBlock(BlockCapsule)} does nothing.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenBlockChainMetricManagerApplyBlockDoesNothing_whenNull() {
    // Arrange
    doNothing().when(blockChainMetricManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    metricsService.applyBlock(null);

    // Assert
    verify(blockChainMetricManager).applyBlock(isNull());
  }

  /**
   * Test {@link MetricsService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link
   *       BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId() {
    // Arrange
    doThrow(new RuntimeException())
        .when(blockChainMetricManager)
        .applyBlock(Mockito.<BlockCapsule>any());

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    metricsService.applyBlock(block);

    // Assert
    verify(block).getBlockId();
    verify(blockChainMetricManager).applyBlock(isA(BlockCapsule.class));
  }

  /**
   * Test {@link MetricsService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId}.
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId2() {
    // Arrange
    doThrow(new RuntimeException())
        .when(blockChainMetricManager)
        .applyBlock(Mockito.<BlockCapsule>any());

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getBlockId()).thenReturn(mock(BlockId.class));

    // Act
    metricsService.applyBlock(block);

    // Assert
    verify(block).getBlockId();
    verify(blockChainMetricManager).applyBlock(isA(BlockCapsule.class));
  }

  /**
   * Test {@link MetricsService#failProcessBlock(long, String)}.
   *
   * <p>Method under test: {@link MetricsService#failProcessBlock(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsService.failProcessBlock(long, String)"})
  public void testFailProcessBlock() {
    // Arrange
    doThrow(new RuntimeException()).when(blockChainMetricManager).setFailProcessBlockNum(anyLong());

    // Act
    metricsService.failProcessBlock(1L, "An error occurred");

    // Assert
    verify(blockChainMetricManager).setFailProcessBlockNum(1L);
  }

  /**
   * Test {@link MetricsService#failProcessBlock(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link BlockChainMetricManager#setFailProcessBlockReason(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsService#failProcessBlock(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsService.failProcessBlock(long, String)"})
  public void testFailProcessBlock_thenCallsSetFailProcessBlockReason() {
    // Arrange
    doNothing().when(blockChainMetricManager).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainMetricManager).setFailProcessBlockReason(Mockito.<String>any());

    // Act
    metricsService.failProcessBlock(1L, "An error occurred");

    // Assert
    verify(blockChainMetricManager).setFailProcessBlockNum(1L);
    verify(blockChainMetricManager).setFailProcessBlockReason("An error occurred");
  }

  /**
   * Test {@link MetricsService#getMetricsInfo()}.
   *
   * <p>Method under test: {@link MetricsService#getMetricsInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricsInfo MetricsService.getMetricsInfo()"})
  public void testGetMetricsInfo() {
    // Arrange and Act
    MetricsInfo actualMetricsInfo = metricsService.getMetricsInfo();

    // Assert
    assertNull(actualMetricsInfo.getBlockchain());
    assertNull(actualMetricsInfo.getNet());
    assertNull(actualMetricsInfo.getNode());
    assertEquals(0L, actualMetricsInfo.getInterval());
  }
}
