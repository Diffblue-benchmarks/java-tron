package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.Sha256Hash;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.base.State;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;

@RunWith(MockitoJUnitRunner.class)
public class StateManagerDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private StateManager stateManager;

  /**
   * Test {@link StateManager#getState()}.
   * <ul>
   *   <li>Then return {@code CLOCK_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#getState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State StateManager.getState()"})
  public void testGetState_thenReturnClockError() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);

    // Act
    State actualState = stateManager.getState();

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
    assertEquals(State.CLOCK_ERROR, actualState);
  }

  /**
   * Test {@link StateManager#receiveBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link BlockId} {@link Sha256Hash#getBytes()} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StateManager.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_givenBlockIdGetBytesReturnAxaxaxaxBytesIsUtf8_thenCallsGetBytes()
      throws UnsupportedEncodingException {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);
    BlockId currentBlockId = mock(BlockId.class);
    when(currentBlockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    StateManager stateManager = new StateManager();
    stateManager.setCurrentBlockId(currentBlockId);
    stateManager.setDposService(dposService);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert
    verify(currentBlockId).getBytes();
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }

  /**
   * Test {@link StateManager#receiveBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link BlockId}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StateManager.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);

    StateManager stateManager = new StateManager();
    stateManager.setDposService(dposService);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(mock(BlockId.class));

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }

  /**
   * Test {@link StateManager#receiveBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link StateManager} (default constructor) CurrentBlockId is {@link BlockId#BlockId()}.</li>
   *   <li>Then calls {@link BlockCapsule#getBlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StateManager.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_givenStateManagerCurrentBlockIdIsBlockId_thenCallsGetBlockId() {
    // Arrange
    StateManager stateManager = new StateManager();
    stateManager.setCurrentBlockId(new BlockId());
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert
    verify(blockCapsule).getBlockId();
  }

  /**
   * Test {@link StateManager#receiveBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link StateManager} (default constructor) DposService is {@link DposService} (default constructor).</li>
   *   <li>Then calls {@link BlockCapsule#getTimeStamp()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StateManager.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_givenStateManagerDposServiceIsDposService_thenCallsGetTimeStamp() {
    // Arrange
    StateManager stateManager = new StateManager();
    stateManager.setDposService(new DposService());
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert
    verify(blockCapsule).getBlockId();
    verify(blockCapsule).getTimeStamp();
  }

  /**
   * Test {@link StateManager#receiveBlock(BlockCapsule)}.
   * <ul>
   *   <li>Then calls {@link DposService#isNeedSyncCheck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateManager#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StateManager.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_thenCallsIsNeedSyncCheck() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.isNeedSyncCheck()).thenReturn(true);

    StateManager stateManager = new StateManager();
    stateManager.setDposService(dposService);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());

    // Act
    stateManager.receiveBlock(blockCapsule);

    // Assert
    verify(dposService).isNeedSyncCheck();
    verify(blockCapsule).getBlockId();
  }
}
