package org.tron.core.net.service.effective;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.net.TronNetDelegate;
import org.tron.core.net.peer.PeerConnection;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EffectiveCheckServiceDiffblueTest {
  @InjectMocks private EffectiveCheckService effectiveCheckService;

  @Mock private ScheduledExecutorService scheduledExecutorService;

  @Mock private TronNetDelegate tronNetDelegate;

  /**
   * Test {@link EffectiveCheckService#triggerNext()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledExecutorService} {@link ScheduledExecutorService#submit(Runnable)}
   *       return {@link CompletableFuture#CompletableFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#triggerNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EffectiveCheckService.triggerNext()"})
  public void testTriggerNext_givenScheduledExecutorServiceSubmitReturnCompletableFuture() {
    // Arrange
    Mockito.<Future<?>>when(scheduledExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(new CompletableFuture<>());

    // Act
    effectiveCheckService.triggerNext();

    // Assert
    verify(scheduledExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link EffectiveCheckService#triggerNext()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledExecutorService} {@link ScheduledExecutorService#submit(Runnable)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#triggerNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EffectiveCheckService.triggerNext()"})
  public void testTriggerNext_givenScheduledExecutorServiceSubmitThrowRuntimeException() {
    // Arrange
    Mockito.<Future<?>>when(scheduledExecutorService.submit(Mockito.<Runnable>any()))
        .thenThrow(new RuntimeException());

    // Act
    effectiveCheckService.triggerNext();

    // Assert
    verify(scheduledExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link EffectiveCheckService#close()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledExecutorService} {@link
   *       ScheduledExecutorService#awaitTermination(long, TimeUnit)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EffectiveCheckService.close()"})
  public void testClose_givenScheduledExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(true);
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    effectiveCheckService.close();

    // Assert
    verify(scheduledExecutorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
  }

  /**
   * Test {@link EffectiveCheckService#close()}.
   *
   * <ul>
   *   <li>Then calls {@link ScheduledExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link EffectiveCheckService#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EffectiveCheckService.close()"})
  public void testClose_thenCallsShutdownNow() throws InterruptedException {
    // Arrange
    when(scheduledExecutorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(false);
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(scheduledExecutorService).shutdown();

    // Act
    effectiveCheckService.close();

    // Assert
    verify(scheduledExecutorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(scheduledExecutorService).shutdown();
    verify(scheduledExecutorService).shutdownNow();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
