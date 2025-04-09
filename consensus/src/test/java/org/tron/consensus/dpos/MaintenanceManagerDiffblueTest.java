package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.pbft.PbftManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.store.DelegationStore;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MaintenanceManagerDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private MaintenanceManager maintenanceManager;

  /**
   * Test {@link MaintenanceManager#init()}.
   * <p>
   * Method under test: {@link MaintenanceManager#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaintenanceManager.init()"})
  public void testInit() {
    // Arrange
    when(consensusDelegate.getActiveWitnesses()).thenReturn(new ArrayList<>());

    // Act
    maintenanceManager.init();

    // Assert
    verify(consensusDelegate).getActiveWitnesses();
  }

  /**
   * Test {@link MaintenanceManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#getNextMaintenanceTime()} return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaintenanceManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaintenanceManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenConsensusDelegateGetNextMaintenanceTimeReturnMax_value()
      throws UnsupportedEncodingException {
    // Arrange
    PbftManager pbftManager = mock(PbftManager.class);
    doNothing().when(pbftManager).blockPrePrepare(Mockito.<BlockCapsule>any(), anyLong());

    MaintenanceManager maintenanceManager = new MaintenanceManager();
    maintenanceManager.setPbftManager(pbftManager);
    ReflectionTestUtils.setField(maintenanceManager, "incentiveManager", mock(IncentiveManager.class));
    DelegationStore delegationStore = mock(DelegationStore.class);
    doNothing().when(delegationStore).addReward(anyLong(), Mockito.<byte[]>any(), anyLong());
    delegationStore.addReward(1L, "AXAXAXAX".getBytes("UTF-8"), 42L);
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    doNothing().when(consensusDelegate).saveStateFlag(anyInt());
    when(consensusDelegate.getNextMaintenanceTime()).thenReturn(Long.MAX_VALUE);
    ReflectionTestUtils.setField(maintenanceManager, "consensusDelegate", consensusDelegate);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    maintenanceManager.applyBlock(blockCapsule);

    // Assert
    verify(consensusDelegate, atLeast(1)).getNextMaintenanceTime();
    verify(consensusDelegate).saveStateFlag(eq(0));
    verify(pbftManager).blockPrePrepare(isA(BlockCapsule.class), eq(9223372036854775807L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(delegationStore).addReward(eq(1L), isA(byte[].class), eq(42L));
  }

  /**
   * Test {@link MaintenanceManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#getNextMaintenanceTime()} return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaintenanceManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaintenanceManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenConsensusDelegateGetNextMaintenanceTimeReturnMax_value2()
      throws UnsupportedEncodingException {
    // Arrange
    PbftManager pbftManager = mock(PbftManager.class);
    doNothing().when(pbftManager).blockPrePrepare(Mockito.<BlockCapsule>any(), anyLong());

    MaintenanceManager maintenanceManager = new MaintenanceManager();
    maintenanceManager.setPbftManager(pbftManager);
    ReflectionTestUtils.setField(maintenanceManager, "incentiveManager", mock(IncentiveManager.class));
    DelegationStore delegationStore = mock(DelegationStore.class);
    doNothing().when(delegationStore).addReward(anyLong(), Mockito.<byte[]>any(), anyLong());
    delegationStore.addReward(1L, "AXAXAXAX".getBytes("UTF-8"), 42L);
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    doNothing().when(consensusDelegate).saveStateFlag(anyInt());
    when(consensusDelegate.getNextMaintenanceTime()).thenReturn(Long.MAX_VALUE);
    ReflectionTestUtils.setField(maintenanceManager, "consensusDelegate", consensusDelegate);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(10L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    maintenanceManager.applyBlock(blockCapsule);

    // Assert
    verify(consensusDelegate, atLeast(1)).getNextMaintenanceTime();
    verify(consensusDelegate).saveStateFlag(eq(0));
    verify(pbftManager).blockPrePrepare(isA(BlockCapsule.class), eq(9223372036854775807L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(delegationStore).addReward(eq(1L), isA(byte[].class), eq(42L));
  }

  /**
   * Test {@link MaintenanceManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link ConsensusDelegate#updateNextMaintenanceTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaintenanceManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaintenanceManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenOne_thenCallsUpdateNextMaintenanceTime() throws UnsupportedEncodingException {
    // Arrange
    PbftManager pbftManager = mock(PbftManager.class);
    doNothing().when(pbftManager).blockPrePrepare(Mockito.<BlockCapsule>any(), anyLong());

    MaintenanceManager maintenanceManager = new MaintenanceManager();
    maintenanceManager.setPbftManager(pbftManager);
    ReflectionTestUtils.setField(maintenanceManager, "incentiveManager", mock(IncentiveManager.class));
    DelegationStore delegationStore = mock(DelegationStore.class);
    doNothing().when(delegationStore).addReward(anyLong(), Mockito.<byte[]>any(), anyLong());
    delegationStore.addReward(1L, "AXAXAXAX".getBytes("UTF-8"), 42L);
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    doNothing().when(consensusDelegate).updateNextMaintenanceTime(anyLong());
    doNothing().when(consensusDelegate).saveStateFlag(anyInt());
    when(consensusDelegate.getNextMaintenanceTime()).thenReturn(1L);
    ReflectionTestUtils.setField(maintenanceManager, "consensusDelegate", consensusDelegate);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    maintenanceManager.applyBlock(blockCapsule);

    // Assert
    verify(consensusDelegate, atLeast(1)).getNextMaintenanceTime();
    verify(consensusDelegate).saveStateFlag(eq(1));
    verify(consensusDelegate).updateNextMaintenanceTime(eq(10L));
    verify(pbftManager).blockPrePrepare(isA(BlockCapsule.class), eq(1L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(delegationStore).addReward(eq(1L), isA(byte[].class), eq(42L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MaintenanceManager#setDposService(DposService)}
   *   <li>{@link MaintenanceManager#setPbftManager(PbftManager)}
   *   <li>{@link MaintenanceManager#getBeforeMaintenanceTime()}
   *   <li>{@link MaintenanceManager#getBeforeWitness()}
   *   <li>{@link MaintenanceManager#getCurrentWitness()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MaintenanceManager.getBeforeMaintenanceTime()", "List MaintenanceManager.getBeforeWitness()",
      "List MaintenanceManager.getCurrentWitness()", "void MaintenanceManager.setDposService(DposService)",
      "void MaintenanceManager.setPbftManager(PbftManager)"})
  public void testGettersAndSetters() {
    // Arrange
    MaintenanceManager maintenanceManager = new MaintenanceManager();

    // Act
    maintenanceManager.setDposService(new DposService());
    maintenanceManager.setPbftManager(new PbftManager());
    long actualBeforeMaintenanceTime = maintenanceManager.getBeforeMaintenanceTime();
    List<ByteString> actualBeforeWitness = maintenanceManager.getBeforeWitness();
    List<ByteString> actualCurrentWitness = maintenanceManager.getCurrentWitness();

    // Assert
    assertEquals(0L, actualBeforeMaintenanceTime);
    assertTrue(actualBeforeWitness.isEmpty());
    assertTrue(actualCurrentWitness.isEmpty());
  }
}
