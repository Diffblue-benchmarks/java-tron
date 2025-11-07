package org.tron.core.net.service.fetchblock;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class FetchBlockServiceDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private FetchBlockService fetchBlockService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test: {@link FetchBlockService#fetchBlock(List, PeerConnection)}
   */
  @Test
  public void testFetchBlock() {
    // Arrange
    when(chainBaseManager.getHeadBlockNum()).thenReturn(1L);

    ArrayList<Sha256Hash> sha256HashList = new ArrayList<>();
    sha256HashList.add(new BlockCapsule.BlockId());
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    fetchBlockService.fetchBlock(sha256HashList, peer);

    // Assert
    verify(chainBaseManager).getHeadBlockNum();
    verify(peer).getInetAddress();
  }

  /**
   * Method under test: {@link FetchBlockService#fetchBlock(List, PeerConnection)}
   */
  @Test
  public void testFetchBlock2() {
    // Arrange
    when(chainBaseManager.getHeadBlockNum()).thenReturn(-1L);

    ArrayList<Sha256Hash> sha256HashList = new ArrayList<>();
    sha256HashList.add(new BlockCapsule.BlockId());
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    fetchBlockService.fetchBlock(sha256HashList, peer);

    // Assert
    verify(chainBaseManager).getHeadBlockNum();
    verify(peer, atLeast(1)).getInetAddress();
  }
}
