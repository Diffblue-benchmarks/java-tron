package org.tron.core.net.peer;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.TronNetDelegate;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ReasonCode;

@RunWith(MockitoJUnitRunner.class)
public class PeerStatusCheckDiffblueTest {
  @InjectMocks private PeerStatusCheck peerStatusCheck;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenArrayListAddPeerConnection_thenCallsGetActivePeer() {
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
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenArrayListAddPeerConnection_thenCallsGetActivePeer2() {
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
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId#BlockId()} is {@code -1120190104}.
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenHashMapBlockIdIs1120190104_thenCallsDisconnect() {
    // Arrange
    HashMap<BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockId(), -1120190104L);

    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    doNothing().when(peerConnection).disconnect(Mockito.<ReasonCode>any());
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
    verify(peerConnection).disconnect(ReasonCode.TIME_OUT);
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getInetAddress();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link BlockId#BlockId()} is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenHashMapBlockIdIsMax_value() {
    // Arrange
    HashMap<BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(new BlockId(), Long.MAX_VALUE);
    blockIdResultLongMap.putIfAbsent(new BlockId(), -1120190104L);

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
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code null} is {@link Long#MAX_VALUE}.
   *   <li>Then calls {@link PeerConnection#disconnect(ReasonCode)}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenHashMapNullIsMax_value_thenCallsDisconnect() {
    // Arrange
    HashMap<BlockId, Long> blockIdResultLongMap = new HashMap<>();
    blockIdResultLongMap.put(null, Long.MAX_VALUE);
    blockIdResultLongMap.putIfAbsent(new BlockId(), -1120190104L);

    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.getInetAddress()).thenReturn(mock(InetAddress.class));
    when(peerConnection.getBlockBothHaveUpdateTime()).thenReturn(Long.MAX_VALUE);
    doNothing().when(peerConnection).disconnect(Mockito.<ReasonCode>any());
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
    verify(peerConnection).disconnect(ReasonCode.TIME_OUT);
    verify(peerConnection).getAdvInvRequest();
    verify(peerConnection).getBlockBothHaveUpdateTime();
    verify(peerConnection).getInetAddress();
    verify(peerConnection).getSyncBlockRequested();
    verify(peerConnection).isNeedSyncFromPeer();
  }

  /**
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#getBlockBothHaveUpdateTime()} return
   *       {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenPeerConnectionGetBlockBothHaveUpdateTimeReturnMax_value() {
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
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Given {@link PeerConnection} {@link PeerConnection#isNeedSyncFromPeer()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_givenPeerConnectionIsNeedSyncFromPeerReturnFalse() {
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
   * Test {@link PeerStatusCheck#statusCheck()}.
   *
   * <ul>
   *   <li>Then calls {@link TronNetDelegate#getActivePeer()}.
   * </ul>
   *
   * <p>Method under test: {@link PeerStatusCheck#statusCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeerStatusCheck.statusCheck()"})
  public void testStatusCheck_thenCallsGetActivePeer() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    // Act
    peerStatusCheck.statusCheck();

    // Assert
    verify(tronNetDelegate).getActivePeer();
  }
}
