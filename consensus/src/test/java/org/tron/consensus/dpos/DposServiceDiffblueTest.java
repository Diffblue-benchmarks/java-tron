package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.args.GenesisBlock;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.base.BlockHandle;
import org.tron.consensus.base.Param;
import org.tron.consensus.base.Param.Miner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.WitnessCapsule;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DposServiceDiffblueTest {
  @Mock private ConsensusDelegate consensusDelegate;

  @InjectMocks private DposService dposService;

  @Mock private DposSlot dposSlot;

  @Mock private DposTask dposTask;

  @Mock private MaintenanceManager maintenanceManager;

  @Mock private StateManager stateManager;

  @Mock private StatisticManager statisticManager;

  /**
   * Test {@link DposService#start(Param)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link DposService} GenesisBlockTime is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_givenArrayList_thenDposServiceGenesisBlockTimeIsFortyTwo() {
    // Arrange
    when(consensusDelegate.getActiveWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getAllWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());

    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setTimestamp("42");
    genesisBlock.setWitnesses(new ArrayList<>());

    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(genesisBlock);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getAllWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
    verify(param).getBlockHandle();
    verify(param).getBlockProduceTimeoutPercent();
    verify(param, atLeast(1)).getGenesisBlock();
    verify(param).getMinParticipationRate();
    verify(param).getMiners();
    verify(param).isEnable();
    verify(param).isNeedSyncCheck();
    verify(dposSlot).setDposService(isA(DposService.class));
    verify(dposTask).init();
    verify(dposTask).setDposService(isA(DposService.class));
    verify(maintenanceManager).init();
    verify(maintenanceManager).setDposService(isA(DposService.class));
    verify(stateManager).setDposService(isA(DposService.class));
    assertEquals(42L, dposService.getGenesisBlockTime());
    assertSame(genesisBlock, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#stop()}.
   *
   * <p>Method under test: {@link DposService#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposService.stop()"})
  public void testStop() {
    // Arrange
    doNothing().when(dposTask).stop();

    // Act
    dposService.stop();

    // Assert
    verify(dposTask).stop();
  }

  /**
   * Test {@link DposService#receiveBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link StateManager} {@link StateManager#receiveBlock(BlockCapsule)} does nothing.
   *   <li>Then calls {@link StateManager#receiveBlock(BlockCapsule)}.
   * </ul>
   *
   * <p>Method under test: {@link DposService#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DposService.receiveBlock(BlockCapsule)"})
  public void testReceiveBlock_givenStateManagerReceiveBlockDoesNothing_thenCallsReceiveBlock() {
    // Arrange
    doNothing().when(stateManager).receiveBlock(Mockito.<BlockCapsule>any());

    // Act
    dposService.receiveBlock(null);

    // Assert
    verify(stateManager).receiveBlock(isNull());
  }

  /**
   * Test {@link DposService#validBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DposService.validBlock(BlockCapsule)"})
  public void testValidBlock_thenReturnFalse() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(null);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    boolean actualValidBlockResult = dposService.validBlock(blockCapsule);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
    verify(dposSlot, atLeast(1)).getAbSlot(anyLong());
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    assertFalse(actualValidBlockResult);
  }

  /**
   * Test {@link DposService#validBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DposService.validBlock(BlockCapsule)"})
  public void testValidBlock_thenReturnTrue() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);

    // Act
    boolean actualValidBlockResult = dposService.validBlock(null);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    assertTrue(actualValidBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#getLatestSolidifiedBlockNum()}
   *       return twelve.
   * </ul>
   *
   * <p>Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenConsensusDelegateGetLatestSolidifiedBlockNumReturnTwelve()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString2);
    byteStringList.add(byteString);

    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getLatestBlockNum()).thenReturn(1L);
    when(consensusDelegate.getLatestSolidifiedBlockNum()).thenReturn(12L);
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(maintenanceManager).applyBlock(Mockito.<BlockCapsule>any());
    doNothing().when(statisticManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    boolean actualApplyBlockResult = dposService.applyBlock(null);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getActiveWitnesses();
    verify(consensusDelegate).getLatestSolidifiedBlockNum();
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    verify(witnessCapsule, atLeast(1)).getLatestBlockNum();
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#saveLatestSolidifiedBlockNum(long)}.
   * </ul>
   *
   * <p>Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsSaveLatestSolidifiedBlockNum()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString);

    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getLatestBlockNum()).thenReturn(1L);
    when(consensusDelegate.getLatestSolidifiedBlockNum()).thenReturn(1L);
    doNothing().when(consensusDelegate).saveLatestSolidifiedBlockNum(anyLong());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(maintenanceManager).applyBlock(Mockito.<BlockCapsule>any());
    doNothing().when(statisticManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    boolean actualApplyBlockResult = dposService.applyBlock(null);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getActiveWitnesses();
    verify(consensusDelegate, atLeast(1)).getLatestSolidifiedBlockNum();
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveLatestSolidifiedBlockNum(1L);
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    verify(witnessCapsule).getLatestBlockNum();
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#saveLatestSolidifiedBlockNum(long)}.
   * </ul>
   *
   * <p>Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsSaveLatestSolidifiedBlockNum2()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString2);
    byteStringList.add(byteString);

    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getLatestBlockNum()).thenReturn(1L);
    when(consensusDelegate.getLatestSolidifiedBlockNum()).thenReturn(1L);
    doNothing().when(consensusDelegate).saveLatestSolidifiedBlockNum(anyLong());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(maintenanceManager).applyBlock(Mockito.<BlockCapsule>any());
    doNothing().when(statisticManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    boolean actualApplyBlockResult = dposService.applyBlock(null);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getActiveWitnesses();
    verify(consensusDelegate, atLeast(1)).getLatestSolidifiedBlockNum();
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(consensusDelegate).saveLatestSolidifiedBlockNum(1L);
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    verify(witnessCapsule, atLeast(1)).getLatestBlockNum();
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DposService#setNeedSyncCheck(boolean)}
   *   <li>{@link DposService#getBlockHandle()}
   *   <li>{@link DposService#getBlockProduceTimeoutPercent()}
   *   <li>{@link DposService#getGenesisBlock()}
   *   <li>{@link DposService#getGenesisBlockTime()}
   *   <li>{@link DposService#getMinParticipationRate()}
   *   <li>{@link DposService#getMiners()}
   *   <li>{@link DposService#isEnable()}
   *   <li>{@link DposService#isNeedSyncCheck()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BlockHandle DposService.getBlockHandle()",
    "int DposService.getBlockProduceTimeoutPercent()",
    "GenesisBlock DposService.getGenesisBlock()",
    "long DposService.getGenesisBlockTime()",
    "int DposService.getMinParticipationRate()",
    "Map DposService.getMiners()",
    "boolean DposService.isEnable()",
    "boolean DposService.isNeedSyncCheck()",
    "void DposService.setNeedSyncCheck(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    DposService dposService = new DposService();

    // Act
    dposService.setNeedSyncCheck(true);
    BlockHandle actualBlockHandle = dposService.getBlockHandle();
    int actualBlockProduceTimeoutPercent = dposService.getBlockProduceTimeoutPercent();
    GenesisBlock actualGenesisBlock = dposService.getGenesisBlock();
    long actualGenesisBlockTime = dposService.getGenesisBlockTime();
    int actualMinParticipationRate = dposService.getMinParticipationRate();
    Map<ByteString, Miner> actualMiners = dposService.getMiners();
    boolean actualIsEnableResult = dposService.isEnable();
    boolean actualIsNeedSyncCheckResult = dposService.isNeedSyncCheck();

    // Assert
    assertNull(actualGenesisBlock);
    assertNull(actualBlockHandle);
    assertEquals(0, actualBlockProduceTimeoutPercent);
    assertEquals(0, actualMinParticipationRate);
    assertEquals(0L, actualGenesisBlockTime);
    assertFalse(actualIsEnableResult);
    assertTrue(actualMiners.isEmpty());
    assertTrue(actualIsNeedSyncCheckResult);
  }
}
