package org.tron.core.net.messagehandler;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.utils.Pair;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.message.sync.ChainInventoryMessage;
import org.tron.core.net.peer.PeerConnection;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ChainInventoryMsgHandlerDiffblueTest {
  /**
   * Test {@link ChainInventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   *
   * <ul>
   *   <li>When {@link ChainInventoryMessage#ChainInventoryMessage(byte[])} with data is empty array
   *       of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMsgHandler#processMessage(PeerConnection,
   * TronMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenChainInventoryMessageWithDataIsEmptyArrayOfByte()
      throws Exception {
    // Arrange
    ChainInventoryMsgHandler chainInventoryMsgHandler = new ChainInventoryMsgHandler();

    PeerConnection peer = new PeerConnection();
    peer.setSyncChainRequested(new Pair<>(new LinkedList<>(), 42L));
    ChainInventoryMessage msg = new ChainInventoryMessage(new byte[] {});

    // Act and Assert
    assertThrows(P2pException.class, () -> chainInventoryMsgHandler.processMessage(peer, msg));
  }

  /**
   * Test {@link ChainInventoryMsgHandler#processMessage(PeerConnection, TronMessage)}.
   *
   * <ul>
   *   <li>When {@link PeerConnection} (default constructor).
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link ChainInventoryMsgHandler#processMessage(PeerConnection,
   * TronMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChainInventoryMsgHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_whenPeerConnection_thenThrowP2pException() throws P2pException {
    // Arrange
    ChainInventoryMsgHandler chainInventoryMsgHandler = new ChainInventoryMsgHandler();

    // Act and Assert
    assertThrows(
        P2pException.class,
        () -> chainInventoryMsgHandler.processMessage(new PeerConnection(), null));
  }
}
