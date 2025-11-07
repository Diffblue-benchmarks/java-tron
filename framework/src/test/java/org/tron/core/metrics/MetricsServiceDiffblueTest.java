package org.tron.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.metrics.blockchain.BlockChainMetricManager;

@RunWith(MockitoJUnitRunner.class)
public class MetricsServiceDiffblueTest {
  @Mock
  private BlockChainMetricManager blockChainMetricManager;

  @InjectMocks
  private MetricsService metricsService;

  /**
   * Test {@link MetricsService#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Then calls {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsApplyBlock() {
    // Arrange
    doNothing().when(blockChainMetricManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    metricsService.applyBlock(null);

    // Assert
    verify(blockChainMetricManager).applyBlock(isNull());
  }

  /**
   * Test {@link MetricsService#failProcessBlock(long, String)}.
   * <p>
   * Method under test: {@link MetricsService#failProcessBlock(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsService.failProcessBlock(long, String)"})
  public void testFailProcessBlock() {
    // Arrange
    doNothing().when(blockChainMetricManager).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainMetricManager).setFailProcessBlockReason(Mockito.<String>any());

    // Act
    metricsService.failProcessBlock(1L, "An error occurred");

    // Assert
    verify(blockChainMetricManager).setFailProcessBlockNum(eq(1L));
    verify(blockChainMetricManager).setFailProcessBlockReason(eq("An error occurred"));
  }

  /**
   * Test {@link MetricsService#getMetricsInfo()}.
   * <p>
   * Method under test: {@link MetricsService#getMetricsInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
