package org.tron.core.net.peer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.net.TronNetDelegate;

@RunWith(MockitoJUnitRunner.class)
public class PeerStatusCheckDiffblueTest {
  @InjectMocks
  private PeerStatusCheck peerStatusCheck;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck3() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck4() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);
    when(peerConnection.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peerConnection.getSyncBlockRequested()).thenReturn(new HashMap<>());

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck5() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(false);
    when(peerConnection.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peerConnection.getSyncBlockRequested()).thenReturn(new HashMap<>());

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck6() {
    // Arrange
    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockCapsule.BlockId(), 1434605599L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);
    when(peerConnection.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peerConnection.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck7() {
    // Arrange
    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockCapsule.BlockId(), Long.MAX_VALUE);
    blockIdResultLongMap.putIfAbsent(new BlockCapsule.BlockId(), 1434605599L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);
    when(peerConnection.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peerConnection.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  public void testStatusCheck8() {
    // Arrange
    HashMap<BlockCapsule.BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(null, Long.MAX_VALUE);
    blockIdResultLongMap.putIfAbsent(new BlockCapsule.BlockId(), 1434605599L);
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    when(peerConnection.isNeedSyncFromPeer()).thenReturn(true);
    when(peerConnection.getAdvInvRequest()).thenReturn(new HashMap<>());
    when(peerConnection.getSyncBlockRequested()).thenReturn(blockIdResultLongMap);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }
}
