package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.tron.common.overlay.message.Message;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.net.message.base.DisconnectMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.message.keepalive.PongMessage;
import org.tron.protos.Protocol;

public class MessageStatisticsDiffblueTest {
  /**
   * Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  public void testAddTcpInMessage() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PingMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  public void testAddTcpInMessage2() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PongMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  public void testAddTcpInMessage3() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PbftMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  public void testAddTcpInMessage4() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    messageStatistics.addTcpInMessage(new PingMessage());

    // Act
    messageStatistics.addTcpInMessage(new DisconnectMessage(Protocol.ReasonCode.REQUESTED));

    // Assert
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(2L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  public void testAddTcpOutMessage() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PingMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  public void testAddTcpOutMessage2() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PongMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  public void testAddTcpOutMessage3() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PbftMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  public void testAddTcpOutMessage4() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    messageStatistics.addTcpInMessage(new PingMessage());

    // Act
    messageStatistics.addTcpOutMessage(new DisconnectMessage(Protocol.ReasonCode.REQUESTED));

    // Assert
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MessageStatistics}
   */
  @Test
  public void testNewMessageStatistics() {
    // Arrange and Act
    MessageStatistics actualMessageStatistics = new MessageStatistics();

    // Assert
    assertEquals(0L, actualMessageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pInHello.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pOutHello.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, actualMessageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlock.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlockChainInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlockFetchInvData.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlockInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInBlockInventoryElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInMessage.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInSyncBlockChain.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrx.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrxFetchInvData.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrxInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrxInventoryElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronInTrxs.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutAdvBlock.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlock.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlockChainInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlockFetchInvData.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlockFetchInvDataElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlockInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutBlockInventoryElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutMessage.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutSyncBlockChain.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrx.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrxFetchInvData.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrxFetchInvDataElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrxInventory.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrxInventoryElement.getTotalCount());
    assertEquals(0L, actualMessageStatistics.tronOutTrxs.getTotalCount());
  }
}
