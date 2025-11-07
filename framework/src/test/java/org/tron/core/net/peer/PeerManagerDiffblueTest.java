package org.tron.core.net.peer;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.tron.p2p.connection.Channel;

public class PeerManagerDiffblueTest {
  /**
   * Method under test: {@link PeerManager#remove(Channel)}
   */
  @Test
  public void testRemove() {
    // Arrange, Act and Assert
    assertNull(PeerManager.remove(new Channel()));
  }

  /**
   * Method under test: {@link PeerManager#getPeerConnection(Channel)}
   */
  @Test
  public void testGetPeerConnection() {
    // Arrange, Act and Assert
    assertNull(PeerManager.getPeerConnection(new Channel()));
  }
}
