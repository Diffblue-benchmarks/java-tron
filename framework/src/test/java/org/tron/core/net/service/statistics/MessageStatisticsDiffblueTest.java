package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.overlay.message.Message;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.net.message.base.DisconnectMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.message.keepalive.PongMessage;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

public class MessageStatisticsDiffblueTest {
  /**
   * Test {@link MessageStatistics#addTcpInMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link
   *       MessageStatistics#p2pInDisconnect} TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpInMessage(Message)"})
  public void testAddTcpInMessage_thenMessageStatisticsP2pInDisconnectTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    messageStatistics.addTcpInMessage(new PingMessage());

    // Act
    messageStatistics.addTcpInMessage(new DisconnectMessage(ReasonCode.REQUESTED));

    // Assert
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(2L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpInMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link MessageStatistics#p2pInPong}
   *       TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpInMessage(Message)"})
  public void testAddTcpInMessage_thenMessageStatisticsP2pInPongTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PongMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpInMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link MessageStatistics#tronInTrx}
   *       TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpInMessage(Message)"})
  public void testAddTcpInMessage_thenMessageStatisticsTronInTrxTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    PingMessage msg = new PingMessage((byte) 1, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    messageStatistics.addTcpInMessage(msg);

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
    assertEquals(1L, messageStatistics.tronInTrx.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpInMessage(Message)}.
   *
   * <ul>
   *   <li>When {@link PbftMessage#PbftMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpInMessage(Message)"})
  public void testAddTcpInMessage_whenPbftMessage() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PbftMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpInMessage(Message)}.
   *
   * <ul>
   *   <li>When {@link PingMessage#PingMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpInMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpInMessage(Message)"})
  public void testAddTcpInMessage_whenPingMessage() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpInMessage(new PingMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pInDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pInPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronInTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pInPing.getTotalCount());
    assertEquals(1L, messageStatistics.tronInMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpOutMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link
   *       MessageStatistics#p2pOutDisconnect} TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpOutMessage(Message)"})
  public void testAddTcpOutMessage_thenMessageStatisticsP2pOutDisconnectTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    messageStatistics.addTcpInMessage(new PingMessage());

    // Act
    messageStatistics.addTcpOutMessage(new DisconnectMessage(ReasonCode.REQUESTED));

    // Assert
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpOutMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link MessageStatistics#p2pOutPing}
   *       TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpOutMessage(Message)"})
  public void testAddTcpOutMessage_thenMessageStatisticsP2pOutPingTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PingMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpOutMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link MessageStatistics#p2pOutPong}
   *       TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpOutMessage(Message)"})
  public void testAddTcpOutMessage_thenMessageStatisticsP2pOutPongTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PongMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(1L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpOutMessage(Message)}.
   *
   * <ul>
   *   <li>Then {@link MessageStatistics} (default constructor) {@link MessageStatistics#tronOutTrx}
   *       TotalCount is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpOutMessage(Message)"})
  public void testAddTcpOutMessage_thenMessageStatisticsTronOutTrxTotalCountIsOne() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();
    PingMessage msg =
        new PingMessage((byte) 1, new byte[] {'A', -24, 'A', -24, 'A', -24, 'A', -24});

    // Act
    messageStatistics.addTcpOutMessage(msg);

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutTrx.getTotalCount());
  }

  /**
   * Test {@link MessageStatistics#addTcpOutMessage(Message)}.
   *
   * <ul>
   *   <li>When {@link PbftMessage#PbftMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageStatistics#addTcpOutMessage(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.addTcpOutMessage(Message)"})
  public void testAddTcpOutMessage_whenPbftMessage() {
    // Arrange
    MessageStatistics messageStatistics = new MessageStatistics();

    // Act
    messageStatistics.addTcpOutMessage(new PbftMessage());

    // Assert
    assertEquals(0L, messageStatistics.p2pOutDisconnect.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPing.getTotalCount());
    assertEquals(0L, messageStatistics.p2pOutPong.getTotalCount());
    assertEquals(0L, messageStatistics.tronOutTrx.getTotalCount());
    assertEquals(1L, messageStatistics.tronOutMessage.getTotalCount());
  }

  /**
   * Test new {@link MessageStatistics} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MessageStatistics}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageStatistics.<init>()"})
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
