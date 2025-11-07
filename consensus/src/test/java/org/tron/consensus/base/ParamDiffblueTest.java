package org.tron.consensus.base;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.args.GenesisBlock;
import org.tron.consensus.base.Param.Miner;

public class ParamDiffblueTest {
  /**
   * Test {@link Param#getMiner()}.
   * <p>
   * Method under test: {@link Param#getMiner()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Miner Param.getMiner()"})
  public void testGetMiner() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Miner> miners = new ArrayList<>();
    Param instance = Param.getInstance();
    Miner miner = instance.new Miner("AXAXAXAX".getBytes("UTF-8"), mock(ByteString.class), mock(ByteString.class));

    miners.add(miner);
    Param instance2 = Param.getInstance();
    instance2.setMiners(miners);

    // Act
    Miner actualMiner = instance2.getMiner();

    // Assert
    assertSame(miner, actualMiner);
    byte[] expectedPrivateKey = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrivateKey, actualMiner.getPrivateKey());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Param.getAgreeNodeCount()", "BlockHandle Param.getBlockHandle()",
      "int Param.getBlockProduceTimeoutPercent()", "GenesisBlock Param.getGenesisBlock()",
      "int Param.getMinParticipationRate()", "List Param.getMiners()", "PbftInterface Param.getPbftInterface()",
      "boolean Param.isEnable()", "boolean Param.isNeedSyncCheck()", "void Param.setAgreeNodeCount(int)",
      "void Param.setBlockHandle(BlockHandle)", "void Param.setBlockProduceTimeoutPercent(int)",
      "void Param.setEnable(boolean)", "void Param.setGenesisBlock(GenesisBlock)",
      "void Param.setMinParticipationRate(int)", "void Param.setMiners(List)", "void Param.setNeedSyncCheck(boolean)",
      "void Param.setPbftInterface(PbftInterface)"})
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
    ArrayList<Miner> miners = new ArrayList<>();
    instance.setMiners(miners);
    instance.setNeedSyncCheck(true);
    PbftInterface pbftInterface = mock(PbftInterface.class);
    instance.setPbftInterface(pbftInterface);
    int actualAgreeNodeCount = instance.getAgreeNodeCount();
    BlockHandle actualBlockHandle = instance.getBlockHandle();
    int actualBlockProduceTimeoutPercent = instance.getBlockProduceTimeoutPercent();
    GenesisBlock actualGenesisBlock = instance.getGenesisBlock();
    int actualMinParticipationRate = instance.getMinParticipationRate();
    List<Miner> actualMiners = instance.getMiners();
    PbftInterface actualPbftInterface = instance.getPbftInterface();
    boolean actualIsEnableResult = instance.isEnable();
    boolean actualIsNeedSyncCheckResult = instance.isNeedSyncCheck();

    // Assert
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
   * Test Miner getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Miner#Miner(Param, byte[], ByteString, ByteString)}
   *   <li>{@link Miner#setPrivateKey(byte[])}
   *   <li>{@link Miner#setPrivateKeyAddress(ByteString)}
   *   <li>{@link Miner#setWitnessAddress(ByteString)}
   *   <li>{@link Miner#getPrivateKey()}
   *   <li>{@link Miner#getPrivateKeyAddress()}
   *   <li>{@link Miner#getWitnessAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Miner.<init>(Param, byte[], ByteString, ByteString)", "byte[] Miner.getPrivateKey()",
      "ByteString Miner.getPrivateKeyAddress()", "ByteString Miner.getWitnessAddress()",
      "void Miner.setPrivateKey(byte[])", "void Miner.setPrivateKeyAddress(ByteString)",
      "void Miner.setWitnessAddress(ByteString)"})
  public void testMinerGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Param instance = Param.getInstance();

    // Act
    Miner actualMiner = instance.new Miner("AXAXAXAX".getBytes("UTF-8"), null, null);
    byte[] privateKey = "AXAXAXAX".getBytes("UTF-8");
    actualMiner.setPrivateKey(privateKey);
    actualMiner.setPrivateKeyAddress(null);
    actualMiner.setWitnessAddress(null);
    byte[] actualPrivateKey = actualMiner.getPrivateKey();
    ByteString actualPrivateKeyAddress = actualMiner.getPrivateKeyAddress();

    // Assert
    assertNull(actualPrivateKeyAddress);
    assertNull(actualMiner.getWitnessAddress());
    assertSame(privateKey, actualPrivateKey);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPrivateKey);
  }
}
