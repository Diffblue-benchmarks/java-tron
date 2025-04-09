package org.tron.core.capsule.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>Given {@link BlockId}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockUtil.isParentOf(BlockCapsule, BlockCapsule)"})
  public void testIsParentOf_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(mock(BlockId.class));
    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(mock(Sha256Hash.class));

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }

  /**
   * Test {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getParentHash()} return {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getParentHash()} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
