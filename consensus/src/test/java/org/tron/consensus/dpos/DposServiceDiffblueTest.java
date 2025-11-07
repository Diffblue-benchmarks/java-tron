package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.args.GenesisBlock;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.base.BlockHandle;
import org.tron.consensus.base.Param;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class DposServiceDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private DposService dposService;

  @Mock
  private DposSlot dposSlot;

  @Mock
  private DposTask dposTask;

  @Mock
  private MaintenanceManager maintenanceManager;

  @Mock
  private StateManager stateManager;

  @Mock
  private StatisticManager statisticManager;

  /**
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart() {
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
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart2() {
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
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart3() {
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

    ArrayList<Param.Miner> minerList = new ArrayList<>();
    Param.Miner miner = Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null);

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
    Map<ByteString, Param.Miner> miners = dposService.getMiners();
    assertEquals(1, miners.size());
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(miner, miners.get(null));
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart4() {
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

    ArrayList<Param.Miner> minerList = new ArrayList<>();
    minerList.add(Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null));
    Param.Miner miner = Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null);

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
    Map<ByteString, Param.Miner> miners = dposService.getMiners();
    assertEquals(1, miners.size());
    assertEquals(1, dposService.getMinParticipationRate());
    assertEquals(10, dposService.getBlockProduceTimeoutPercent());
    assertTrue(dposService.isEnable());
    assertTrue(dposService.isNeedSyncCheck());
    assertSame(miner, miners.get(null));
    assertSame(resultDefault, dposService.getGenesisBlock());
  }

  /**
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart5() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart6() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#start(Param)}
   */
  @Test
  public void testStart7() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#stop()}
   */
  @Test
  public void testStop() {
    // Arrange
    doNothing().when(dposTask).stop();

    // Act
    dposService.stop();

    // Assert that nothing has changed
    verify(dposTask).stop();
  }

  /**
   * Method under test: {@link DposService#receiveBlock(BlockCapsule)}
   */
  @Test
  public void testReceiveBlock() {
    // Arrange
    doNothing().when(stateManager).receiveBlock(Mockito.<BlockCapsule>any());

    // Act
    dposService.receiveBlock(null);

    // Assert that nothing has changed
    verify(stateManager).receiveBlock(isNull());
  }

  /**
   * Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  public void testValidBlock() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(0L);

    // Act
    boolean actualValidBlockResult = dposService.validBlock(null);

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    assertTrue(actualValidBlockResult);
  }

  /**
   * Method under test: {@link DposService#validBlock(BlockCapsule)}
   */
  @Test
  public void testValidBlock2() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);

    // Act
    boolean actualValidBlockResult = dposService.validBlock(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
    verify(dposSlot, atLeast(1)).getAbSlot(anyLong());
    assertFalse(actualValidBlockResult);
  }

  /**
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
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
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock2() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock3() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock4() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  public void testUpdateWitness() {
    // Arrange
    doNothing().when(consensusDelegate).saveActiveWitnesses(Mockito.<List<ByteString>>any());

    // Act
    dposService.updateWitness(new ArrayList<>());

    // Assert
    verify(consensusDelegate).saveActiveWitnesses(isA(List.class));
  }

  /**
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  public void testUpdateWitness2() {
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
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  public void testUpdateWitness3() throws UnsupportedEncodingException {
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
   * Method under test: {@link DposService#updateWitness(List)}
   */
  @Test
  public void testUpdateWitness4() throws UnsupportedEncodingException {
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
  public void testGettersAndSetters() {
    // Arrange
    DposService dposService = new DposService();

    // Act
    dposService.setNeedSyncCheck(true);
    dposService.getBlockHandle();
    int actualBlockProduceTimeoutPercent = dposService.getBlockProduceTimeoutPercent();
    dposService.getGenesisBlock();
    long actualGenesisBlockTime = dposService.getGenesisBlockTime();
    int actualMinParticipationRate = dposService.getMinParticipationRate();
    Map<ByteString, Param.Miner> actualMiners = dposService.getMiners();
    boolean actualIsEnableResult = dposService.isEnable();
    boolean actualIsNeedSyncCheckResult = dposService.isNeedSyncCheck();

    // Assert that nothing has changed
    assertEquals(0, actualBlockProduceTimeoutPercent);
    assertEquals(0, actualMinParticipationRate);
    assertEquals(0L, actualGenesisBlockTime);
    assertFalse(actualIsEnableResult);
    assertTrue(actualMiners.isEmpty());
    assertTrue(actualIsNeedSyncCheckResult);
  }
}
