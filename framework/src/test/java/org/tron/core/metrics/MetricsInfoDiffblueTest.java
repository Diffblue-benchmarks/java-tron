package org.tron.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.tron.core.metrics.node.NodeInfo;

public class MetricsInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MetricsInfo}
   *   <li>{@link MetricsInfo#setInterval(long)}
   *   <li>{@link MetricsInfo#setNode(NodeInfo)}
   *   <li>{@link MetricsInfo#toString()}
   *   <li>{@link MetricsInfo#getBlockchain()}
   *   <li>{@link MetricsInfo#getInterval()}
   *   <li>{@link MetricsInfo#getNet()}
   *   <li>{@link MetricsInfo#getNode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MetricsInfo actualMetricsInfo = new MetricsInfo();
    actualMetricsInfo.setInterval(42L);
    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    actualMetricsInfo.setNode(node);
    actualMetricsInfo.toString();
    actualMetricsInfo.getBlockchain();
    long actualInterval = actualMetricsInfo.getInterval();
    actualMetricsInfo.getNet();

    // Assert that nothing has changed
    assertEquals(42L, actualInterval);
    assertSame(node, actualMetricsInfo.getNode());
  }
}
