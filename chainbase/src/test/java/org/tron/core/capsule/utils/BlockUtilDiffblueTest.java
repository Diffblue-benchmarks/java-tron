package org.tron.core.capsule.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;

public class BlockUtilDiffblueTest {
  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId#BlockId(Sha256Hash, long)} with hash is {@link Sha256Hash#ZERO_HASH}
   *       and num is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_givenBlockIdWithHashIsZero_hashAndNumIsOne() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockId(Sha256Hash.ZERO_HASH, 1L));

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId}.
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId}.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(mock(BlockId.class));

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getParentHash()} return {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_givenNull_whenBlockCapsuleGetParentHashReturnNull_thenReturnFalse() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockId());

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(null);

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_givenZero_hash_thenReturnTrue() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockId());

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertTrue(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_thenCallsGetBytes() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockId());

    Sha256Hash sha256Hash = mock(Sha256Hash.class);
    when(sha256Hash.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(sha256Hash);

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(sha256Hash).getBytes();
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   *
   * <ul>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getParentHash()} return {@link
   *       BlockId#BlockId()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_whenBlockCapsuleGetParentHashReturnBlockId_thenReturnTrue() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockId());

    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(new BlockId());

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertTrue(actualIsParentOfResult);
  }
}
