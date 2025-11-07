package org.tron.core.net.messagehandler;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.TronMessage;
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class PbftDataSyncHandlerDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private PbftDataSyncHandler pbftDataSyncHandler;

  /**
   * Test {@link PbftDataSyncHandler#processMessage(PeerConnection, TronMessage)}.
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getDynamicPropertiesStore()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftDataSyncHandler.processMessage(PeerConnection, TronMessage)"})
  public void testProcessMessage_thenCallsGetDynamicPropertiesStore() throws P2pException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processMessage(new PeerConnection(), null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}.
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
}
