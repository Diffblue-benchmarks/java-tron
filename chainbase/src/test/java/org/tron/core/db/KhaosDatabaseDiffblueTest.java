package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.TransactionCapsule;
import org.tron.protos.Protocol;

public class KhaosDatabaseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KhaosDatabase.KhaosBlock#equals(Object)}
   *   <li>{@link KhaosDatabase.KhaosBlock#hashCode()}
   * </ul>
   */
  @Test
  public void testKhaosBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    KhaosDatabase.KhaosBlock khaosBlock = new KhaosDatabase.KhaosBlock(blk);
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    KhaosDatabase.KhaosBlock khaosBlock2 = new KhaosDatabase.KhaosBlock(blk2);

    // Act and Assert
    assertEquals(khaosBlock, khaosBlock2);
    int expectedHashCodeResult = khaosBlock.hashCode();
    assertEquals(expectedHashCodeResult, khaosBlock2.hashCode());
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#equals(Object)}
   */
  @Test
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    KhaosDatabase.KhaosBlock khaosBlock = new KhaosDatabase.KhaosBlock(blk);

    // Act and Assert
    assertNotEquals(khaosBlock, new KhaosDatabase.KhaosBlock(new BlockCapsule(Protocol.Block.getDefaultInstance())));
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#equals(Object)}
   */
  @Test
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act and Assert
    assertNotEquals(new KhaosDatabase.KhaosBlock(blk), null);
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#equals(Object)}
   */
  @Test
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    KhaosDatabase.KhaosBlock khaosBlock = new KhaosDatabase.KhaosBlock(blk);

    // Act and Assert
    assertNotEquals(khaosBlock, new BlockCapsule.BlockId());
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#getParent()}
   */
  @Test
  public void testKhaosBlockGetParent() {
    // Arrange, Act and Assert
    assertNull((new KhaosDatabase.KhaosBlock(new BlockCapsule(Protocol.Block.getDefaultInstance()))).getParent());
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#getParentHash()}
   */
  @Test
  public void testKhaosBlockGetParentHash() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getParentHash()).thenReturn(null);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    Sha256Hash actualParentHash = (new KhaosDatabase.KhaosBlock(blk)).getParentHash();

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
    verify(blk).getParentHash();
    assertNull(actualParentHash);
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#KhaosBlock(BlockCapsule)}
   */
  @Test
  public void testKhaosBlockNewKhaosBlock() {
    // Arrange
    BlockCapsule blk = new BlockCapsule(Protocol.Block.getDefaultInstance());

    // Act
    KhaosDatabase.KhaosBlock actualKhaosBlock = new KhaosDatabase.KhaosBlock(blk);

    // Assert
    assertNull(actualKhaosBlock.getParent());
    assertSame(blk, actualKhaosBlock.getBlk());
  }

  /**
   * Method under test:
   * {@link KhaosDatabase.KhaosBlock#setParent(KhaosDatabase.KhaosBlock)}
   */
  @Test
  public void testKhaosBlockSetParent() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    KhaosDatabase.KhaosBlock khaosBlock = new KhaosDatabase.KhaosBlock(blk);

    // Act
    khaosBlock.setParent(new KhaosDatabase.KhaosBlock(new BlockCapsule(Protocol.Block.getDefaultInstance())));

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#toString()}
   */
  @Test
  public void testKhaosBlockToString() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    (new KhaosDatabase.KhaosBlock(blk)).toString();

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
  }

  /**
   * Method under test: {@link KhaosDatabase.KhaosBlock#toString()}
   */
  @Test
  public void testKhaosBlockToString2() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    doNothing().when(blk2).addAllTransactions(Mockito.<List<TransactionCapsule>>any());
    blk2.addAllTransactions(new ArrayList<>());
    KhaosDatabase.KhaosBlock parent = new KhaosDatabase.KhaosBlock(blk2);

    KhaosDatabase.KhaosBlock khaosBlock = new KhaosDatabase.KhaosBlock(blk);
    khaosBlock.setParent(parent);

    // Act
    khaosBlock.toString();

    // Assert
    verify(blk2).addAllTransactions(isA(List.class));
    verify(blk).getBlockId();
    verify(blk2).getBlockId();
    verify(blk).getNum();
    verify(blk2).getNum();
  }
}
