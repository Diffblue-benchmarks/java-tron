package org.tron.core.net.service.effective;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
public class EffectiveCheckServiceDiffblueTest {
  @InjectMocks
  private EffectiveCheckService effectiveCheckService;

  @Mock
  private TronNetDelegate tronNetDelegate;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EffectiveCheckService#setCur(InetSocketAddress)}
   *   <li>{@link EffectiveCheckService#getCur()}
   *   <li>{@link EffectiveCheckService#isEffectiveCheck()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();
    InetSocketAddress cur = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    effectiveCheckService.setCur(cur);
    InetSocketAddress actualCur = effectiveCheckService.getCur();

    // Assert that nothing has changed
    assertFalse(effectiveCheckService.isEffectiveCheck());
    assertSame(cur, actualCur);
  }

  /**
   * Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  public void testIsIsolateLand() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    assertTrue(actualIsIsolateLandResult);
  }

  /**
   * Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  public void testIsIsolateLand2() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    assertTrue(actualIsIsolateLandResult);
  }

  /**
   * Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  public void testIsIsolateLand3() {
    // Arrange
    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(new PeerConnection());
    peerConnectionList.add(new PeerConnection());
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    assertTrue(actualIsIsolateLandResult);
  }

  /**
   * Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  public void testIsIsolateLand4() {
    // Arrange
    PeerConnection peerConnection = mock(PeerConnection.class);
    when(peerConnection.isNeedSyncFromUs()).thenReturn(false);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    verify(peerConnection).isNeedSyncFromUs();
    assertFalse(actualIsIsolateLandResult);
  }

  /**
   * Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  public void testIsIsolateLand5() {
    // Arrange
    PeerConnection peerConnection = new PeerConnection();
    peerConnection.setNeedSyncFromUs(false);

    ArrayList<PeerConnection> peerConnectionList = new ArrayList<>();
    peerConnectionList.add(peerConnection);
    when(tronNetDelegate.getActivePeer()).thenReturn(peerConnectionList);

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    assertFalse(actualIsIsolateLandResult);
  }

  /**
   * Method under test:
   * {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}
   */
  @Test
  public void testOnDisconnect() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();
    ReflectionTestUtils.setField(effectiveCheckService, "tronNetDelegate", mock(TronNetDelegate.class));

    // Act
    effectiveCheckService.onDisconnect(InetSocketAddress.createUnresolved("foo", 1));

    // Assert that nothing has changed
    assertNull(effectiveCheckService.getCur());
  }

  /**
   * Method under test:
   * {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}
   */
  @Test
  public void testOnDisconnect2() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();
    effectiveCheckService.setCur(InetSocketAddress.createUnresolved("foo", 1));
    ReflectionTestUtils.setField(effectiveCheckService, "tronNetDelegate", mock(TronNetDelegate.class));

    // Act
    effectiveCheckService.onDisconnect(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    assertNull(effectiveCheckService.getCur());
  }
}
