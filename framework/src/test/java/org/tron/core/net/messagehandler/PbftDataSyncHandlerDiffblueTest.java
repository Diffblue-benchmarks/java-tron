package org.tron.core.net.messagehandler;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class PbftDataSyncHandlerDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private ExecutorService executorService;

  @InjectMocks private PbftDataSyncHandler pbftDataSyncHandler;

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   *
   * <p>Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.processPBFTCommitData(BlockCapsule)"})
  public void testProcessPBFTCommitData() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   *
   * <p>Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.processPBFTCommitData(BlockCapsule)"})
  public void testProcessPBFTCommitData2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(block);

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(block, atLeast(1)).getNum();
    verify(block).getTimeStamp();
    verify(dynamicPropertiesStore).allowPBFT();
    verify(dynamicPropertiesStore).getMaintenanceTimeInterval();
  }

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   *
   * <p>Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.processPBFTCommitData(BlockCapsule)"})
  public void testProcessPBFTCommitData3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(0L);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(block);

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(block, atLeast(1)).getNum();
    verify(block).getTimeStamp();
    verify(dynamicPropertiesStore).allowPBFT();
    verify(dynamicPropertiesStore).getMaintenanceTimeInterval();
  }

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.processPBFTCommitData(BlockCapsule)"})
  public void testProcessPBFTCommitData_givenDynamicPropertiesStoreAllowPBFTReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.processPBFTCommitData(BlockCapsule)"})
  public void testProcessPBFTCommitData_givenDynamicPropertiesStoreAllowPBFTReturnTrue() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftDataSyncHandler#close()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code false}.
   *   <li>Then calls {@link ExecutorService#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftDataSyncHandler#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.close()"})
  public void testClose_givenExecutorServiceAwaitTerminationReturnFalse_thenCallsShutdownNow()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(false);
    when(executorService.shutdownNow()).thenReturn(new ArrayList<>());
    doNothing().when(executorService).shutdown();

    // Act
    pbftDataSyncHandler.close();

    // Assert
    verify(executorService, atLeast(1)).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
    verify(executorService).shutdownNow();
  }

  /**
   * Test {@link PbftDataSyncHandler#close()}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#awaitTermination(long, TimeUnit)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PbftDataSyncHandler#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftDataSyncHandler.close()"})
  public void testClose_givenExecutorServiceAwaitTerminationReturnTrue()
      throws InterruptedException {
    // Arrange
    when(executorService.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(executorService).shutdown();

    // Act
    pbftDataSyncHandler.close();

    // Assert
    verify(executorService).awaitTermination(60L, TimeUnit.SECONDS);
    verify(executorService).shutdown();
  }
}
