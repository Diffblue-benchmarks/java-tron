package org.tron.consensus.pbft;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftBaseMessage;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class PbftManagerDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private ExecutorService executorService;

  @Mock private MaintenanceManager maintenanceManager;

  @InjectMocks private PbftManager pbftManager;

  @Mock private PbftMessageHandle pbftMessageHandle;

  /**
   * Test {@link PbftManager#init()}.
   *
   * <p>Method under test: {@link PbftManager#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.init()"})
  public void testInit() {
    // Arrange
    doNothing().when(maintenanceManager).setPbftManager(Mockito.<PbftManager>any());
    doNothing().when(pbftMessageHandle).setMaintenanceManager(Mockito.<MaintenanceManager>any());

    // Act
    pbftManager.init();

    // Assert
    verify(maintenanceManager).setPbftManager(isA(PbftManager.class));
    verify(pbftMessageHandle).setMaintenanceManager(isA(MaintenanceManager.class));
  }

  /**
   * Test {@link PbftManager#blockPrePrepare(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenDynamicPropertiesStoreAllowPBFTReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftManager.blockPrePrepare(null, 1L);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#blockPrePrepare(BlockCapsule, long)}.
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code
   *       true}.
   *   <li>Then calls {@link PbftMessageHandle#isSyncing()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenPbftMessageHandleIsSyncingReturnTrue_thenCallsIsSyncing() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(true);

    // Act
    pbftManager.blockPrePrepare(null, 1L);

    // Assert
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.srPrePrepare(BlockCapsule, List, long)"})
  public void testSrPrePrepare_givenDynamicPropertiesStoreAllowPBFTReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftManager.srPrePrepare(null, new ArrayList<>(), 1L);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code
   *       true}.
   *   <li>Then calls {@link PbftMessageHandle#isSyncing()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.srPrePrepare(BlockCapsule, List, long)"})
  public void testSrPrePrepare_givenPbftMessageHandleIsSyncingReturnTrue_thenCallsIsSyncing() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(true);

    // Act
    pbftManager.srPrePrepare(null, new ArrayList<>(), 1L);

    // Assert
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#forwardMessage(PbftBaseMessage)}.
   *
   * <p>Method under test: {@link PbftManager#forwardMessage(PbftBaseMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.forwardMessage(PbftBaseMessage)"})
  public void testForwardMessage() {
    // Arrange
    doNothing().when(pbftMessageHandle).forwardMessage(Mockito.<PbftBaseMessage>any());

    // Act
    pbftManager.forwardMessage(new PbftMessage());

    // Assert
    verify(pbftMessageHandle).forwardMessage(isA(PbftBaseMessage.class));
  }

  /**
   * Test {@link PbftManager#doAction(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#submit(Runnable)} return {@link
   *       CompletableFuture#CompletableFuture()}.
   *   <li>Then calls {@link ExecutorService#submit(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#doAction(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PbftManager.doAction(PbftMessage)"})
  public void testDoAction_givenExecutorServiceSubmitReturnCompletableFuture_thenCallsSubmit() {
    // Arrange
    Mockito.<Future<?>>when(executorService.submit(Mockito.<Runnable>any()))
        .thenReturn(new CompletableFuture<>());

    // Act
    boolean actualDoActionResult = pbftManager.doAction(new PbftMessage());

    // Assert
    verify(executorService).submit(isA(Runnable.class));
    assertTrue(actualDoActionResult);
  }

  /**
   * Test {@link PbftManager#doAction(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link PbftManager} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#doAction(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PbftManager.doAction(PbftMessage)"})
  public void testDoAction_givenPbftManager() {
    // Arrange
    PbftManager pbftManager = new PbftManager();

    // Act and Assert
    assertTrue(pbftManager.doAction(new PbftMessage()));
  }

  /**
   * Test {@link PbftManager#close()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code false}.
   *   <li>Then calls {@link ExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.close()"})
  public void testClose_givenExecutorServiceAwaitTerminationReturnFalse_thenCallsShutdownNow()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(false);
    when(executorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(executorService).shutdown();

    // Act
    pbftManager.close();

    // Assert
    verify(executorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(executorService).shutdownNow();
  }

  /**
   * Test {@link PbftManager#close()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.close()"})
  public void testClose_givenExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act
    pbftManager.close();

    // Assert
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
  }
}
