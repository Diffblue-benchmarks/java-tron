package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PeerStatisticsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PeerStatistics}
   */
  @Test
  public void testNewPeerStatistics() {
    // Arrange, Act and Assert
    MessageStatistics messageStatistics = (new PeerStatistics()).messageStatistics;
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInHello.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutHello.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockChainInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInBlockInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInMessage.getTotalCount());
    assertEquals(0L, messageStatistics.tronInSyncBlockChain.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrxs.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutAdvBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlock.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockChainInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutBlockInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutMessage.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutSyncBlockChain.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxFetchInvData.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxInventory.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxInventoryElement.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrxs.getTotalCount());
  }
}
