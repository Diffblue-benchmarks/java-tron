package org.tron.core.capsule.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;

public class BlockUtilDiffblueTest {
  /**
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  public void testIsParentOf() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockCapsule.BlockId());
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
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  public void testIsParentOf2() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(new BlockCapsule.BlockId());

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertTrue(actualIsParentOfResult);
  }

  /**
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  public void testIsParentOf3() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(new BlockCapsule.BlockId());
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
   * Method under test: {@link BlockUtil#isParentOf(BlockCapsule, BlockCapsule)}
   */
  @Test
  public void testIsParentOf4() {
    // Arrange
    BlockCapsule blockCapsule1 = mock(BlockCapsule.class);
    when(blockCapsule1.getBlockId()).thenReturn(mock(BlockCapsule.BlockId.class));
    BlockCapsule blockCapsule2 = mock(BlockCapsule.class);
    when(blockCapsule2.getParentHash()).thenReturn(mock(Sha256Hash.class));

    // Act
    boolean actualIsParentOfResult = BlockUtil.isParentOf(blockCapsule1, blockCapsule2);

    // Assert
    verify(blockCapsule1).getBlockId();
    verify(blockCapsule2).getParentHash();
    assertFalse(actualIsParentOfResult);
  }
}
