package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.protos.Protocol;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WitnessProductBlockService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WitnessProductBlockServiceDiffblueTest {
  @Autowired
  private WitnessProductBlockService witnessProductBlockService;

  /**
   * Method under test:
   * {@link WitnessProductBlockService.CheatWitnessInfo#add(BlockCapsule)}
   */
  @Test
  public void testCheatWitnessInfoAdd() {
    // Arrange
    WitnessProductBlockService.CheatWitnessInfo cheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Act
    WitnessProductBlockService.CheatWitnessInfo actualAddResult = cheatWitnessInfo.add(null);

    // Assert
    assertEquals(1, cheatWitnessInfo.getBlockCapsuleSet().size());
    assertSame(cheatWitnessInfo, actualAddResult);
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService.CheatWitnessInfo#clear()}
   */
  @Test
  public void testCheatWitnessInfoClear() {
    // Arrange
    WitnessProductBlockService.CheatWitnessInfo cheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Act and Assert
    assertSame(cheatWitnessInfo, cheatWitnessInfo.clear());
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService.CheatWitnessInfo#getBlockCapsuleSet()}
   */
  @Test
  public void testCheatWitnessInfoGetBlockCapsuleSet() {
    // Arrange, Act and Assert
    assertTrue((new WitnessProductBlockService.CheatWitnessInfo()).getBlockCapsuleSet().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WitnessProductBlockService.CheatWitnessInfo#setLatestBlockNum(long)}
   *   <li>{@link WitnessProductBlockService.CheatWitnessInfo#setTime(long)}
   *   <li>
   * {@link WitnessProductBlockService.CheatWitnessInfo#setTimes(AtomicInteger)}
   *   <li>{@link WitnessProductBlockService.CheatWitnessInfo#toString()}
   *   <li>{@link WitnessProductBlockService.CheatWitnessInfo#getLatestBlockNum()}
   *   <li>{@link WitnessProductBlockService.CheatWitnessInfo#getTime()}
   *   <li>{@link WitnessProductBlockService.CheatWitnessInfo#getTimes()}
   * </ul>
   */
  @Test
  public void testCheatWitnessInfoGettersAndSetters() {
    // Arrange
    WitnessProductBlockService.CheatWitnessInfo cheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Act
    WitnessProductBlockService.CheatWitnessInfo actualSetLatestBlockNumResult = cheatWitnessInfo.setLatestBlockNum(1L);
    WitnessProductBlockService.CheatWitnessInfo actualSetTimeResult = cheatWitnessInfo.setTime(10L);
    AtomicInteger times = new AtomicInteger(1);
    WitnessProductBlockService.CheatWitnessInfo actualSetTimesResult = cheatWitnessInfo.setTimes(times);
    String actualToStringResult = cheatWitnessInfo.toString();
    long actualLatestBlockNum = cheatWitnessInfo.getLatestBlockNum();
    long actualTime = cheatWitnessInfo.getTime();
    AtomicInteger actualTimes = cheatWitnessInfo.getTimes();

    // Assert
    assertEquals("{times=1, time=10, latestBlockNum=1, blockCapsuleSet=[]}", actualToStringResult);
    assertEquals(10L, actualTime);
    assertEquals(1L, actualLatestBlockNum);
    assertTrue(actualSetLatestBlockNumResult.getBlockCapsuleSet().isEmpty());
    assertSame(times, actualTimes);
    assertSame(cheatWitnessInfo, actualSetLatestBlockNumResult);
    assertSame(cheatWitnessInfo, actualSetTimeResult);
    assertSame(cheatWitnessInfo, actualSetTimesResult);
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService.CheatWitnessInfo#increment()}
   */
  @Test
  public void testCheatWitnessInfoIncrement() {
    // Arrange
    WitnessProductBlockService.CheatWitnessInfo cheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Act and Assert
    assertSame(cheatWitnessInfo, cheatWitnessInfo.increment());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link WitnessProductBlockService.CheatWitnessInfo}
   */
  @Test
  public void testCheatWitnessInfoNewCheatWitnessInfo() {
    // Arrange and Act
    WitnessProductBlockService.CheatWitnessInfo actualCheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Assert
    assertEquals(0, actualCheatWitnessInfo.getTimes().get());
    assertEquals(0L, actualCheatWitnessInfo.getLatestBlockNum());
    assertEquals(0L, actualCheatWitnessInfo.getTime());
    assertTrue(actualCheatWitnessInfo.getBlockCapsuleSet().isEmpty());
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService.CheatWitnessInfo#setBlockCapsuleSet(Set)}
   */
  @Test
  public void testCheatWitnessInfoSetBlockCapsuleSet() {
    // Arrange
    WitnessProductBlockService.CheatWitnessInfo cheatWitnessInfo = new WitnessProductBlockService.CheatWitnessInfo();

    // Act and Assert
    assertSame(cheatWitnessInfo, cheatWitnessInfo.setBlockCapsuleSet(new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  public void testValidWitnessProductTwoBlock() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    when(block.getNum()).thenReturn(1L);

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(block).getInstance();
    verify(block, atLeast(1)).getNum();
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  public void testValidWitnessProductTwoBlock2() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getInstance()).thenReturn(null);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getInstance();
    verify(block, atLeast(1)).getNum();
  }

  /**
   * Method under test:
   * {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  public void testValidWitnessProductTwoBlock3() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getInstance()).thenReturn(null);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(mock(BlockCapsule.BlockId.class));

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getInstance();
    verify(block, atLeast(1)).getNum();
  }

  /**
   * Method under test: {@link WitnessProductBlockService#queryCheatWitnessInfo()}
   */
  @Test
  public void testQueryCheatWitnessInfo() {
    // Arrange, Act and Assert
    assertTrue(witnessProductBlockService.queryCheatWitnessInfo().isEmpty());
  }
}
