package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DposServiceDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private DposService dposService;

  @Mock
  private MaintenanceManager maintenanceManager;

  @Mock
  private StatisticManager statisticManager;

  @Mock
  private StateManager stateManager;

  @Mock
  private DposSlot dposSlot;

  @Mock
  private DposTask dposTask;

  /**
   * Test {@link DposService#start(Param)}.
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString);
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    when(consensusDelegate.getAllWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getAllWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
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
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.getMiners().isEmpty());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#getLatestBlockHeaderNumber()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_givenConsensusDelegateGetLatestBlockHeaderNumberReturnOne() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
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
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.getMiners().isEmpty());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule} {@link WitnessCapsule#setIsJobs(boolean)} does nothing.</li>
   *   <li>Then calls {@link WitnessCapsule#setIsJobs(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_givenWitnessCapsuleSetIsJobsDoesNothing_thenCallsSetIsJobs()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString);
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    doNothing().when(witnessCapsule).setIsJobs(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    when(consensusDelegate.getAllWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getAllWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
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
    verify(witnessCapsule).setIsJobs(eq(true));
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.getMiners().isEmpty());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule} {@link WitnessCapsule#setIsJobs(boolean)} does nothing.</li>
   *   <li>Then calls {@link WitnessCapsule#setIsJobs(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_givenWitnessCapsuleSetIsJobsDoesNothing_thenCallsSetIsJobs2()
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
    doNothing().when(witnessCapsule).setIsJobs(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    when(consensusDelegate.getAllWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString).toByteArray();
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getAllWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
    verify(consensusDelegate, atLeast(1)).saveWitness(isA(WitnessCapsule.class));
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
    verify(witnessCapsule, atLeast(1)).setIsJobs(eq(true));
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.getMiners().isEmpty());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#getActiveWitnesses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_thenCallsGetActiveWitnesses() {
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
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(new ArrayList<>());
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
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
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.getMiners().isEmpty());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Then {@link DposService} Miners size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_thenDposServiceMinersSizeIsOne() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());

    ArrayList<Miner> minerList = new ArrayList<>();
    Miner miner = Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null);

    minerList.add(miner);
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(minerList);
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
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
    Map<ByteString, Miner> miners = dposService.getMiners();
    assertEquals(1, miners.size());
    assertSame(miner, miners.get(null));
  }

  /**
   * Test {@link DposService#start(Param)}.
   * <ul>
   *   <li>Then {@link DposService} Miners size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.start(Param)"})
  public void testStart_thenDposServiceMinersSizeIsOne2() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);
    doNothing().when(dposSlot).setDposService(Mockito.<DposService>any());
    doNothing().when(dposTask).init();
    doNothing().when(dposTask).setDposService(Mockito.<DposService>any());
    doNothing().when(maintenanceManager).init();
    doNothing().when(maintenanceManager).setDposService(Mockito.<DposService>any());
    doNothing().when(stateManager).setDposService(Mockito.<DposService>any());
    GenesisBlock resultDefault = GenesisBlock.getDefault();
    resultDefault.setAssets(new ArrayList<>());
    resultDefault.setNumber("42");
    resultDefault.setParentHash("Parent Hash");
    resultDefault.setWitnesses(new ArrayList<>());

    ArrayList<Miner> minerList = new ArrayList<>();
    minerList.add(Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null));
    Miner miner = Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null);

    minerList.add(miner);
    Param param = mock(Param.class);
    when(param.getMiners()).thenReturn(minerList);
    when(param.isEnable()).thenReturn(true);
    when(param.isNeedSyncCheck()).thenReturn(true);
    when(param.getBlockProduceTimeoutPercent()).thenReturn(10);
    when(param.getMinParticipationRate()).thenReturn(1);
    when(param.getGenesisBlock()).thenReturn(resultDefault);
    when(param.getBlockHandle()).thenReturn(mock(BlockHandle.class));

    // Act
    dposService.start(param);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
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
    Map<ByteString, Miner> miners = dposService.getMiners();
    assertEquals(1, miners.size());
    assertSame(miner, miners.get(null));
  }

  /**
   * Test {@link DposService#stop()}.
   * <p>
   * Method under test: {@link DposService#stop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link StateManager} {@link StateManager#receiveBlock(BlockCapsule)} does nothing.</li>
   *   <li>Then calls {@link StateManager#receiveBlock(BlockCapsule)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#receiveBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString);
    when(consensusDelegate.getLatestSolidifiedBlockNum()).thenReturn(1L);
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    doNothing().when(maintenanceManager).applyBlock(Mockito.<BlockCapsule>any());
    doNothing().when(statisticManager).applyBlock(Mockito.<BlockCapsule>any());

    // Act
    boolean actualApplyBlockResult = dposService.applyBlock(null);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getActiveWitnesses();
    verify(consensusDelegate).getLatestSolidifiedBlockNum();
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#getLatestSolidifiedBlockNum()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenConsensusDelegateGetLatestSolidifiedBlockNumReturnMinusOne()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(byteString);
    when(consensusDelegate.getLatestSolidifiedBlockNum()).thenReturn(-1L);
    doNothing().when(consensusDelegate).saveLatestSolidifiedBlockNum(anyLong());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
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
    verify(consensusDelegate).saveLatestSolidifiedBlockNum(eq(0L));
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Then calls {@link WitnessCapsule#getLatestBlockNum()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsGetLatestBlockNum() throws UnsupportedEncodingException {
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
    verify(consensusDelegate).saveLatestSolidifiedBlockNum(eq(1L));
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    verify(witnessCapsule).getLatestBlockNum();
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Then calls {@link WitnessCapsule#getLatestBlockNum()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DposService.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsGetLatestBlockNum2() throws UnsupportedEncodingException {
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
    verify(consensusDelegate).saveLatestSolidifiedBlockNum(eq(1L));
    verify(maintenanceManager).applyBlock(isNull());
    verify(statisticManager).applyBlock(isNull());
    verify(witnessCapsule, atLeast(1)).getLatestBlockNum();
    assertTrue(actualApplyBlockResult);
  }

  /**
   * Test {@link DposService#updateWitness(List)}.
   * <p>
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.updateWitness(List)"})
  public void testUpdateWitness() throws UnsupportedEncodingException {
    // Arrange
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> list = new ArrayList<>();
    list.add(byteString2);
    list.add(byteString);

    // Act
    dposService.updateWitness(list);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test {@link DposService#updateWitness(List)}.
   * <ul>
   *   <li>Given {@link ByteString}.</li>
   *   <li>Then calls {@link ConsensusDelegate#saveActiveWitnesses(List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.updateWitness(List)"})
  public void testUpdateWitness_givenByteString_thenCallsSaveActiveWitnesses() {
    // Arrange
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    ArrayList<ByteString> list = new ArrayList<>();
    list.add(mock(ByteString.class));

    // Act
    dposService.updateWitness(list);

    // Assert
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test {@link DposService#updateWitness(List)}.
   * <ul>
   *   <li>Then calls {@link WitnessCapsule#getVoteCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.updateWitness(List)"})
  public void testUpdateWitness_thenCallsGetVoteCount() throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getVoteCount()).thenReturn(3L);
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> list = new ArrayList<>();
    list.add(byteString2);
    list.add(byteString);

    // Act
    dposService.updateWitness(list);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString).toByteArray();
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
    verify(witnessCapsule, atLeast(1)).getVoteCount();
  }

  /**
   * Test {@link DposService#updateWitness(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ConsensusDelegate#saveActiveWitnesses(List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposService.updateWitness(List)"})
  public void testUpdateWitness_whenArrayList_thenCallsSaveActiveWitnesses() {
    // Arrange
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    dposService.updateWitness(new ArrayList<>());

    // Assert
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockHandle DposService.getBlockHandle()", "int DposService.getBlockProduceTimeoutPercent()",
      "GenesisBlock DposService.getGenesisBlock()", "long DposService.getGenesisBlockTime()",
      "int DposService.getMinParticipationRate()", "Map DposService.getMiners()", "boolean DposService.isEnable()",
      "boolean DposService.isNeedSyncCheck()", "void DposService.setNeedSyncCheck(boolean)"})
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
