package org.tron.core.net.service.effective;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EffectiveCheckServiceDiffblueTest {
  @InjectMocks private EffectiveCheckService effectiveCheckService;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link EffectiveCheckService#isIsolateLand()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EffectiveCheckService.isIsolateLand()"})
  public void testIsIsolateLand_givenArrayListAddPeerConnection_thenReturnTrue() {
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
   * Test {@link EffectiveCheckService#isIsolateLand()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PeerConnection} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EffectiveCheckService.isIsolateLand()"})
  public void testIsIsolateLand_givenArrayListAddPeerConnection_thenReturnTrue2() {
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
   * Test {@link EffectiveCheckService#isIsolateLand()}.
   *
   * <ul>
   *   <li>Given {@link PeerConnection} (default constructor) NeedSyncFromUs is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EffectiveCheckService.isIsolateLand()"})
  public void testIsIsolateLand_givenPeerConnectionNeedSyncFromUsIsFalse_thenReturnFalse() {
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
   * Test {@link EffectiveCheckService#isIsolateLand()}.
   *
   * <ul>
   *   <li>Then calls {@link PeerConnection#isNeedSyncFromUs()}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EffectiveCheckService.isIsolateLand()"})
  public void testIsIsolateLand_thenCallsIsNeedSyncFromUs() {
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
   * Test {@link EffectiveCheckService#isIsolateLand()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#isIsolateLand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EffectiveCheckService.isIsolateLand()"})
  public void testIsIsolateLand_thenReturnTrue() {
    // Arrange
    when(tronNetDelegate.getActivePeer()).thenReturn(new ArrayList<>());

    // Act
    boolean actualIsIsolateLandResult = effectiveCheckService.isIsolateLand();

    // Assert
    verify(tronNetDelegate, atLeast(1)).getActivePeer();
    assertTrue(actualIsIsolateLandResult);
  }

  /**
   * Test {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}.
   *
   * <ul>
   *   <li>Given {@link EffectiveCheckService} (default constructor) Cur is createUnresolved {@code
   *       foo} and one.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EffectiveCheckService.onDisconnect(InetSocketAddress)"})
  public void testOnDisconnect_givenEffectiveCheckServiceCurIsCreateUnresolvedFooAndOne() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();
    effectiveCheckService.setCur(InetSocketAddress.createUnresolved("foo", 1));

    // Act
    effectiveCheckService.onDisconnect(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    assertNull(effectiveCheckService.getCur());
  }

  /**
   * Test {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}.
   *
   * <ul>
   *   <li>Given {@link EffectiveCheckService} (default constructor).
   *   <li>Then {@link EffectiveCheckService} (default constructor) Cur is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#onDisconnect(InetSocketAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EffectiveCheckService.onDisconnect(InetSocketAddress)"})
  public void testOnDisconnect_givenEffectiveCheckService_thenEffectiveCheckServiceCurIsNull() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();

    // Act
    effectiveCheckService.onDisconnect(InetSocketAddress.createUnresolved("foo", 1));

    // Assert that nothing has changed
    assertNull(effectiveCheckService.getCur());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EffectiveCheckService#setCur(InetSocketAddress)}
   *   <li>{@link EffectiveCheckService#getCur()}
   *   <li>{@link EffectiveCheckService#isEffectiveCheck()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "InetSocketAddress EffectiveCheckService.getCur()",
    "boolean EffectiveCheckService.isEffectiveCheck()",
    "void EffectiveCheckService.setCur(InetSocketAddress)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EffectiveCheckService effectiveCheckService = new EffectiveCheckService();
    InetSocketAddress cur = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    effectiveCheckService.setCur(cur);
    InetSocketAddress actualCur = effectiveCheckService.getCur();

    // Assert
    assertFalse(effectiveCheckService.isEffectiveCheck());
    assertSame(cur, actualCur);
  }
}
