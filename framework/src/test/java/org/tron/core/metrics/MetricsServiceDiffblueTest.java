package org.tron.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
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
   * Method under test: {@link MetricsService#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock() {
    // Arrange
    doNothing().when(blockChainMetricManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    metricsService.applyBlock(null);

    // Assert that nothing has changed
    verify(blockChainMetricManager).applyBlock(isNull());
  }

  /**
   * Method under test: {@link MetricsService#failProcessBlock(long, String)}
   */
  @Test
  public void testFailProcessBlock() {
    // Arrange
    doNothing().when(blockChainMetricManager).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainMetricManager).setFailProcessBlockReason(Mockito.<String>any());

    // Act
    metricsService.failProcessBlock(1L, "An error occurred");

    // Assert that nothing has changed
    verify(blockChainMetricManager).setFailProcessBlockNum(eq(1L));
    verify(blockChainMetricManager).setFailProcessBlockReason(eq("An error occurred"));
  }

  /**
   * Method under test: {@link MetricsService#getMetricsInfo()}
   */
  @Test
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
