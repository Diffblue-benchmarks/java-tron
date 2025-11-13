package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.metrics.net.RateInfo;

public class BlockChainInfoDiffblueTest {
  /**
   * Test {@link BlockChainInfo#equals(Object)}, and {@link BlockChainInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockChainInfo#equals(Object)}
   *   <li>{@link BlockChainInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertEquals(blockChainInfo, blockChainInfo2);
    assertEquals(blockChainInfo.hashCode(), blockChainInfo2.hashCode());
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}, and {@link BlockChainInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockChainInfo#equals(Object)}
   *   <li>{@link BlockChainInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(null);
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(null);
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertEquals(blockChainInfo, blockChainInfo2);
    assertEquals(blockChainInfo.hashCode(), blockChainInfo2.hashCode());
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}, and {@link BlockChainInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockChainInfo#equals(Object)}
   *   <li>{@link BlockChainInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertEquals(blockChainInfo, blockChainInfo);
    int expectedHashCodeResult = blockChainInfo.hashCode();
    assertEquals(expectedHashCodeResult, blockChainInfo.hashCode());
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(null);
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(mock(RateInfo.class));
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    ArrayList<DupWitnessInfo> dupWitness = new ArrayList<>();
    dupWitness.add(dupWitnessInfo);

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(dupWitness);
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(1);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(3L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Head Block Hash");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason(null);
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(1);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Just cause");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash(null);
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(3L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(3L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(null);
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(mock(RateInfo.class));
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(null);
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(mock(RateInfo.class));
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(1);
    blockChainInfo.setWitnesses(new ArrayList<>());

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ArrayList<WitnessInfo> witnesses = new ArrayList<>();
    witnesses.add(new WitnessInfo("42 Main St", 1));

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(witnesses);

    BlockChainInfo blockChainInfo2 = new BlockChainInfo();
    blockChainInfo2.setBlockProcessTime(new RateInfo());
    blockChainInfo2.setDupWitness(new ArrayList<>());
    blockChainInfo2.setFailForkCount(3);
    blockChainInfo2.setFailProcessBlockNum(1L);
    blockChainInfo2.setFailProcessBlockReason("Just cause");
    blockChainInfo2.setForkCount(3);
    blockChainInfo2.setHeadBlockHash("Head Block Hash");
    blockChainInfo2.setHeadBlockNum(1L);
    blockChainInfo2.setHeadBlockTimestamp(1L);
    blockChainInfo2.setMissedTransaction(new RateInfo());
    blockChainInfo2.setTps(new RateInfo());
    blockChainInfo2.setTransactionCacheSize(3);
    blockChainInfo2.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, blockChainInfo2);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, null);
  }

  /**
   * Test {@link BlockChainInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockChainInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockChainInfo.equals(Object)", "int BlockChainInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    // Act and Assert
    assertNotEquals(blockChainInfo, "Different type to BlockChainInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BlockChainInfo}
   *   <li>{@link BlockChainInfo#setBlockProcessTime(RateInfo)}
   *   <li>{@link BlockChainInfo#setDupWitness(List)}
   *   <li>{@link BlockChainInfo#setFailForkCount(int)}
   *   <li>{@link BlockChainInfo#setFailProcessBlockNum(long)}
   *   <li>{@link BlockChainInfo#setFailProcessBlockReason(String)}
   *   <li>{@link BlockChainInfo#setForkCount(int)}
   *   <li>{@link BlockChainInfo#setHeadBlockHash(String)}
   *   <li>{@link BlockChainInfo#setHeadBlockNum(long)}
   *   <li>{@link BlockChainInfo#setHeadBlockTimestamp(long)}
   *   <li>{@link BlockChainInfo#setMissedTransaction(RateInfo)}
   *   <li>{@link BlockChainInfo#setTps(RateInfo)}
   *   <li>{@link BlockChainInfo#setTransactionCacheSize(int)}
   *   <li>{@link BlockChainInfo#setWitnesses(List)}
   *   <li>{@link BlockChainInfo#toString()}
   *   <li>{@link BlockChainInfo#getBlockProcessTime()}
   *   <li>{@link BlockChainInfo#getDupWitness()}
   *   <li>{@link BlockChainInfo#getFailForkCount()}
   *   <li>{@link BlockChainInfo#getFailProcessBlockNum()}
   *   <li>{@link BlockChainInfo#getFailProcessBlockReason()}
   *   <li>{@link BlockChainInfo#getForkCount()}
   *   <li>{@link BlockChainInfo#getHeadBlockHash()}
   *   <li>{@link BlockChainInfo#getHeadBlockNum()}
   *   <li>{@link BlockChainInfo#getHeadBlockTimestamp()}
   *   <li>{@link BlockChainInfo#getMissedTransaction()}
   *   <li>{@link BlockChainInfo#getTps()}
   *   <li>{@link BlockChainInfo#getTransactionCacheSize()}
   *   <li>{@link BlockChainInfo#getWitnesses()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockChainInfo.<init>()",
    "RateInfo BlockChainInfo.getBlockProcessTime()",
    "List BlockChainInfo.getDupWitness()",
    "int BlockChainInfo.getFailForkCount()",
    "long BlockChainInfo.getFailProcessBlockNum()",
    "String BlockChainInfo.getFailProcessBlockReason()",
    "int BlockChainInfo.getForkCount()",
    "String BlockChainInfo.getHeadBlockHash()",
    "long BlockChainInfo.getHeadBlockNum()",
    "long BlockChainInfo.getHeadBlockTimestamp()",
    "RateInfo BlockChainInfo.getMissedTransaction()",
    "RateInfo BlockChainInfo.getTps()",
    "int BlockChainInfo.getTransactionCacheSize()",
    "List BlockChainInfo.getWitnesses()",
    "void BlockChainInfo.setBlockProcessTime(RateInfo)",
    "void BlockChainInfo.setDupWitness(List)",
    "void BlockChainInfo.setFailForkCount(int)",
    "void BlockChainInfo.setFailProcessBlockNum(long)",
    "void BlockChainInfo.setFailProcessBlockReason(String)",
    "void BlockChainInfo.setForkCount(int)",
    "void BlockChainInfo.setHeadBlockHash(String)",
    "void BlockChainInfo.setHeadBlockNum(long)",
    "void BlockChainInfo.setHeadBlockTimestamp(long)",
    "void BlockChainInfo.setMissedTransaction(RateInfo)",
    "void BlockChainInfo.setTps(RateInfo)",
    "void BlockChainInfo.setTransactionCacheSize(int)",
    "void BlockChainInfo.setWitnesses(List)",
    "String BlockChainInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BlockChainInfo actualBlockChainInfo = new BlockChainInfo();
    RateInfo blockProcessTime = new RateInfo();
    actualBlockChainInfo.setBlockProcessTime(blockProcessTime);
    ArrayList<DupWitnessInfo> dupWitness = new ArrayList<>();
    actualBlockChainInfo.setDupWitness(dupWitness);
    actualBlockChainInfo.setFailForkCount(3);
    actualBlockChainInfo.setFailProcessBlockNum(1L);
    actualBlockChainInfo.setFailProcessBlockReason("Just cause");
    actualBlockChainInfo.setForkCount(3);
    actualBlockChainInfo.setHeadBlockHash("Head Block Hash");
    actualBlockChainInfo.setHeadBlockNum(1L);
    actualBlockChainInfo.setHeadBlockTimestamp(1L);
    RateInfo missedTransaction = new RateInfo();
    actualBlockChainInfo.setMissedTransaction(missedTransaction);
    RateInfo tps = new RateInfo();
    actualBlockChainInfo.setTps(tps);
    actualBlockChainInfo.setTransactionCacheSize(3);
    ArrayList<WitnessInfo> witnesses = new ArrayList<>();
    actualBlockChainInfo.setWitnesses(witnesses);
    String actualToStringResult = actualBlockChainInfo.toString();
    RateInfo actualBlockProcessTime = actualBlockChainInfo.getBlockProcessTime();
    List<DupWitnessInfo> actualDupWitness = actualBlockChainInfo.getDupWitness();
    int actualFailForkCount = actualBlockChainInfo.getFailForkCount();
    long actualFailProcessBlockNum = actualBlockChainInfo.getFailProcessBlockNum();
    String actualFailProcessBlockReason = actualBlockChainInfo.getFailProcessBlockReason();
    int actualForkCount = actualBlockChainInfo.getForkCount();
    String actualHeadBlockHash = actualBlockChainInfo.getHeadBlockHash();
    long actualHeadBlockNum = actualBlockChainInfo.getHeadBlockNum();
    long actualHeadBlockTimestamp = actualBlockChainInfo.getHeadBlockTimestamp();
    RateInfo actualMissedTransaction = actualBlockChainInfo.getMissedTransaction();
    RateInfo actualTps = actualBlockChainInfo.getTps();
    int actualTransactionCacheSize = actualBlockChainInfo.getTransactionCacheSize();
    List<WitnessInfo> actualWitnesses = actualBlockChainInfo.getWitnesses();

    // Assert
    assertEquals(
        "BlockChainInfo(headBlockNum=1, headBlockTimestamp=1, headBlockHash=Head Block Hash, forkCount=3,"
            + " failForkCount=3, blockProcessTime=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0,"
            + " fifteenMinuteRate=0.0, count=0), tps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0,"
            + " fifteenMinuteRate=0.0, count=0), transactionCacheSize=3, missedTransaction=RateInfo(meanRate=0.0,"
            + " oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0, count=0), witnesses=[], failProcessBlockNum=1,"
            + " failProcessBlockReason=Just cause, dupWitness=[])",
        actualToStringResult);
    assertEquals("Head Block Hash", actualHeadBlockHash);
    assertEquals("Just cause", actualFailProcessBlockReason);
    assertEquals(1L, actualFailProcessBlockNum);
    assertEquals(1L, actualHeadBlockNum);
    assertEquals(1L, actualHeadBlockTimestamp);
    assertEquals(3, actualFailForkCount);
    assertEquals(3, actualForkCount);
    assertEquals(3, actualTransactionCacheSize);
    assertTrue(actualDupWitness.isEmpty());
    assertTrue(actualWitnesses.isEmpty());
    assertSame(dupWitness, actualDupWitness);
    assertSame(witnesses, actualWitnesses);
    assertSame(blockProcessTime, actualBlockProcessTime);
    assertSame(missedTransaction, actualMissedTransaction);
    assertSame(tps, actualTps);
  }
}
