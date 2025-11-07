package org.tron.core.net.messagehandler;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
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
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class PbftDataSyncHandlerDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private PbftDataSyncHandler pbftDataSyncHandler;

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processMessage(PeerConnection, TronMessage)}
   */
  @Test
  public void testProcessMessage() throws P2pException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processMessage(new PeerConnection(), null);

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  public void testProcessPBFTCommitData() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  public void testProcessPBFTCommitData2() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  public void testProcessPBFTCommitData3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(null);

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  public void testProcessPBFTCommitData4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
    verify(dynamicPropertiesStore).getMaintenanceTimeInterval();
  }

  /**
   * Method under test:
   * {@link PbftDataSyncHandler#processPBFTCommitData(BlockCapsule)}
   */
  @Test
  public void testProcessPBFTCommitData5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(0L);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftDataSyncHandler.processPBFTCommitData(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
    verify(dynamicPropertiesStore).getMaintenanceTimeInterval();
  }
}
