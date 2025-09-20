package org.tron.core.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.metrics.blockchain.BlockChainInfo;
import org.tron.core.metrics.net.NetInfo;
import org.tron.core.metrics.node.NodeInfo;

public class MetricsInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MetricsInfo.<init>()",
    "BlockChainInfo MetricsInfo.getBlockchain()",
    "long MetricsInfo.getInterval()",
    "NetInfo MetricsInfo.getNet()",
    "NodeInfo MetricsInfo.getNode()",
    "void MetricsInfo.setBlockchain(BlockChainInfo)",
    "void MetricsInfo.setInterval(long)",
    "void MetricsInfo.setNet(NetInfo)",
    "void MetricsInfo.setNode(NodeInfo)",
    "java.lang.String MetricsInfo.toString()"
  })
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
    BlockChainInfo actualBlockchain = actualMetricsInfo.getBlockchain();
    long actualInterval = actualMetricsInfo.getInterval();
    NetInfo actualNet = actualMetricsInfo.getNet();

    // Assert
    assertNull(actualBlockchain);
    assertNull(actualNet);
    assertEquals(42L, actualInterval);
    assertSame(node, actualMetricsInfo.getNode());
  }
}
