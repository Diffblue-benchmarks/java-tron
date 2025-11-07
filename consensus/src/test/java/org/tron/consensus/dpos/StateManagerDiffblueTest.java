package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.base.State;
import org.tron.core.capsule.BlockCapsule;

@RunWith(MockitoJUnitRunner.class)
public class StateManagerDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private StateManager stateManager;

  /**
   * Method under test: {@link StateManager#getState()}
   */
  @Test
  public void testGetState() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);

    // Act
    State actualState = stateManager.getState();

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
    assertEquals(State.CLOCK_ERROR, actualState);
  }

  /**
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock() {
    // Arrange
    StateManager stateManager = new StateManager();
    stateManager.setCurrentBlockId(new BlockCapsule.BlockId());
    ReflectionTestUtils.setField(stateManager, "consensusDelegate", mock(ConsensusDelegate.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert that nothing has changed
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock2() {
    // Arrange
    StateManager stateManager = new StateManager();
    stateManager.setDposService(new DposService());
    ReflectionTestUtils.setField(stateManager, "consensusDelegate", mock(ConsensusDelegate.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert that nothing has changed
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getTimeStamp();
  }

  /**
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock3() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);

    StateManager stateManager = new StateManager();
    stateManager.setDposService(dposService);
    ReflectionTestUtils.setField(stateManager, "consensusDelegate", mock(ConsensusDelegate.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert that nothing has changed
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock4() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);

    StateManager stateManager = new StateManager();
    stateManager.setDposService(dposService);
    ReflectionTestUtils.setField(stateManager, "consensusDelegate", mock(ConsensusDelegate.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(mock(BlockCapsule.BlockId.class));

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert that nothing has changed
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock5() throws UnsupportedEncodingException {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);
    BlockCapsule.BlockId currentBlockId = mock(BlockCapsule.BlockId.class);
    when(currentBlockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    StateManager stateManager = new StateManager();
    stateManager.setCurrentBlockId(currentBlockId);
    stateManager.setDposService(dposService);
    ReflectionTestUtils.setField(stateManager, "consensusDelegate", mock(ConsensusDelegate.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert that nothing has changed
    verify(currentBlockId).getBytes();
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }
}
