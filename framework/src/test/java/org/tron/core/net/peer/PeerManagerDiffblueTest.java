package org.tron.core.net.peer;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.p2p.connection.Channel;

public class PeerManagerDiffblueTest {
  /**
   * Test {@link PeerManager#remove(Channel)} with {@code channel}.
   * <p>
   * Method under test: {@link PeerManager#remove(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.peer.PeerConnection PeerManager.remove(Channel)"})
  public void testRemoveWithChannel() {
    // Arrange, Act and Assert
    assertNull(PeerManager.remove(new Channel()));
  }

  /**
   * Test {@link PeerManager#getPeerConnection(Channel)}.
   * <p>
   * Method under test: {@link PeerManager#getPeerConnection(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.peer.PeerConnection PeerManager.getPeerConnection(Channel)"})
  public void testGetPeerConnection() {
    // Arrange, Act and Assert
    assertNull(PeerManager.getPeerConnection(new Channel()));
  }
}
