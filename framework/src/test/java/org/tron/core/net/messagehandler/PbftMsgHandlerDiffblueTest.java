package org.tron.core.net.messagehandler;

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
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class PbftMsgHandlerDiffblueTest {
  @InjectMocks private PbftMsgHandler pbftMsgHandler;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link PbftMsgHandler#processMessage(PeerConnection, PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link TronNetDelegate} {@link TronNetDelegate#allowPBFT()} return {@code false}.
   *   <li>Then calls {@link TronNetDelegate#allowPBFT()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMsgHandler#processMessage(PeerConnection, PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMsgHandler.processMessage(PeerConnection, PbftMessage)"})
  public void testProcessMessage_givenTronNetDelegateAllowPBFTReturnFalse_thenCallsAllowPBFT()
      throws Exception {
    // Arrange
    when(tronNetDelegate.allowPBFT()).thenReturn(false);
    PeerConnection peer = new PeerConnection();

    // Act
    pbftMsgHandler.processMessage(peer, new PbftMessage());

    // Assert
    verify(tronNetDelegate).allowPBFT();
  }
}
