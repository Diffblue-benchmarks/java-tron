package org.tron.consensus.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.args.GenesisBlock;

public class ParamDiffblueTest {
  /**
   * Method under test: {@link Param#getMiner()}
   */
  @Test
  public void testGetMiner() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Param.Miner> miners = new ArrayList<>();
    Param instance = Param.getInstance();
    Param.Miner miner = instance.new Miner("AXAXAXAX".getBytes("UTF-8"), mock(ByteString.class),
        mock(ByteString.class));

    miners.add(miner);
    Param instance2 = Param.getInstance();
    instance2.setMiners(miners);

    // Act and Assert
    assertSame(miner, instance2.getMiner());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Param#setAgreeNodeCount(int)}
   *   <li>{@link Param#setBlockHandle(BlockHandle)}
   *   <li>{@link Param#setBlockProduceTimeoutPercent(int)}
   *   <li>{@link Param#setEnable(boolean)}
   *   <li>{@link Param#setGenesisBlock(GenesisBlock)}
   *   <li>{@link Param#setMinParticipationRate(int)}
   *   <li>{@link Param#setMiners(List)}
   *   <li>{@link Param#setNeedSyncCheck(boolean)}
   *   <li>{@link Param#setPbftInterface(PbftInterface)}
   *   <li>{@link Param#getAgreeNodeCount()}
   *   <li>{@link Param#getBlockHandle()}
   *   <li>{@link Param#getBlockProduceTimeoutPercent()}
   *   <li>{@link Param#getGenesisBlock()}
   *   <li>{@link Param#getMinParticipationRate()}
   *   <li>{@link Param#getMiners()}
   *   <li>{@link Param#getPbftInterface()}
   *   <li>{@link Param#isEnable()}
   *   <li>{@link Param#isNeedSyncCheck()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Param instance = Param.getInstance();

    // Act
    instance.setAgreeNodeCount(3);
    BlockHandle blockHandle = mock(BlockHandle.class);
    instance.setBlockHandle(blockHandle);
    instance.setBlockProduceTimeoutPercent(10);
    instance.setEnable(true);
    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setWitnesses(new ArrayList<>());
    instance.setGenesisBlock(genesisBlock);
    instance.setMinParticipationRate(1);
    ArrayList<Param.Miner> miners = new ArrayList<>();
    instance.setMiners(miners);
    instance.setNeedSyncCheck(true);
    PbftInterface pbftInterface = mock(PbftInterface.class);
    instance.setPbftInterface(pbftInterface);
    int actualAgreeNodeCount = instance.getAgreeNodeCount();
    BlockHandle actualBlockHandle = instance.getBlockHandle();
    int actualBlockProduceTimeoutPercent = instance.getBlockProduceTimeoutPercent();
    GenesisBlock actualGenesisBlock = instance.getGenesisBlock();
    int actualMinParticipationRate = instance.getMinParticipationRate();
    List<Param.Miner> actualMiners = instance.getMiners();
    PbftInterface actualPbftInterface = instance.getPbftInterface();
    boolean actualIsEnableResult = instance.isEnable();
    boolean actualIsNeedSyncCheckResult = instance.isNeedSyncCheck();

    // Assert that nothing has changed
    assertEquals(1, actualMinParticipationRate);
    assertEquals(10, actualBlockProduceTimeoutPercent);
    assertEquals(3, actualAgreeNodeCount);
    assertTrue(actualMiners.isEmpty());
    assertTrue(actualIsEnableResult);
    assertTrue(actualIsNeedSyncCheckResult);
    assertSame(miners, actualMiners);
    assertSame(genesisBlock, actualGenesisBlock);
    assertSame(blockHandle, actualBlockHandle);
    assertSame(pbftInterface, actualPbftInterface);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Param.Miner#Miner(Param, byte[], ByteString, ByteString)}
   *   <li>{@link Param.Miner#setPrivateKey(byte[])}
   *   <li>{@link Param.Miner#setPrivateKeyAddress(ByteString)}
   *   <li>{@link Param.Miner#setWitnessAddress(ByteString)}
   *   <li>{@link Param.Miner#getPrivateKey()}
   *   <li>{@link Param.Miner#getPrivateKeyAddress()}
   *   <li>{@link Param.Miner#getWitnessAddress()}
   * </ul>
   */
  @Test
  public void testMinerGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Param instance = Param.getInstance();

    // Act
    Param.Miner actualMiner = instance.new Miner("AXAXAXAX".getBytes("UTF-8"), null, null);
    byte[] privateKey = "AXAXAXAX".getBytes("UTF-8");
    actualMiner.setPrivateKey(privateKey);
    actualMiner.setPrivateKeyAddress(null);
    actualMiner.setWitnessAddress(null);
    byte[] actualPrivateKey = actualMiner.getPrivateKey();
    actualMiner.getPrivateKeyAddress();
    actualMiner.getWitnessAddress();

    // Assert that nothing has changed
    assertSame(privateKey, actualPrivateKey);
  }
}
