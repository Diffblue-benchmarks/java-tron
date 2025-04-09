package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.KhaosDatabase.KhaosBlock;
import org.tron.core.db.KhaosDatabase.KhaosStore;

@RunWith(MockitoJUnitRunner.class)
public class KhaosDatabaseDiffblueTest {
  @Mock
  private KhaosDatabase khaosDatabase;

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}, and {@link KhaosBlock#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KhaosBlock#equals(Object)}
   *   <li>{@link KhaosBlock#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());
    KhaosBlock khaosBlock = new KhaosBlock(blk);
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockId());
    KhaosBlock khaosBlock2 = new KhaosBlock(blk2);

    // Act and Assert
    assertEquals(khaosBlock, khaosBlock2);
    int expectedHashCodeResult = khaosBlock.hashCode();
    assertEquals(expectedHashCodeResult, khaosBlock2.hashCode());
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(null);
    KhaosBlock khaosBlock = new KhaosBlock(blk);
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockId());

    // Act and Assert
    assertNotEquals(khaosBlock, new KhaosBlock(blk2));
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act and Assert
    assertNotEquals(new KhaosBlock(blk), null);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());
    KhaosBlock khaosBlock = new KhaosBlock(blk);

    // Act and Assert
    assertNotEquals(khaosBlock, new BlockId());
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#getParentHash()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getNum()} return one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#getParentHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash KhaosBlock.getParentHash()"})
  public void testKhaosBlockGetParentHash_givenBlockCapsuleGetNumReturnOne_thenReturnNull() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getParentHash()).thenReturn(null);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act
    Sha256Hash actualParentHash = (new KhaosBlock(blk)).getParentHash();

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
    verify(blk).getParentHash();
    assertNull(actualParentHash);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#getParent()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getNum()} return one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#getParent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KhaosBlock KhaosBlock.getParent()"})
  public void testKhaosBlockGetParent_givenBlockCapsuleGetNumReturnOne_thenReturnNull() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act
    KhaosBlock actualParent = (new KhaosBlock(blk)).getParent();

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
    assertNull(actualParent);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#KhaosBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return ParentHash is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#KhaosBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KhaosBlock.<init>(BlockCapsule)"})
  public void testKhaosBlockNewKhaosBlock_givenOne_thenReturnParentHashIsNull() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act
    KhaosBlock actualKhaosBlock = new KhaosBlock(blk);

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
    assertNull(actualKhaosBlock.getParentHash());
    assertNull(actualKhaosBlock.getParent());
    assertSame(blk, actualKhaosBlock.getBlk());
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#setParent(KhaosBlock)}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getNum()} return one.</li>
   *   <li>Then calls {@link BlockCapsule#getBlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#setParent(KhaosBlock)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KhaosBlock.setParent(KhaosBlock)"})
  public void testKhaosBlockSetParent_givenBlockCapsuleGetNumReturnOne_thenCallsGetBlockId() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());
    KhaosBlock khaosBlock = new KhaosBlock(blk);
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockId());

    // Act
    khaosBlock.setParent(new KhaosBlock(blk2));

    // Assert
    verify(blk).getBlockId();
    verify(blk2).getBlockId();
    verify(blk).getNum();
    verify(blk2).getNum();
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#toString()}.
   * <p>
   * Method under test: {@link KhaosBlock#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KhaosBlock.toString()"})
  public void testKhaosBlockToString() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());
    BlockCapsule blk2 = mock(BlockCapsule.class);
    when(blk2.getNum()).thenReturn(1L);
    when(blk2.getBlockId()).thenReturn(new BlockId());
    KhaosBlock parent = new KhaosBlock(blk2);

    KhaosBlock khaosBlock = new KhaosBlock(blk);
    khaosBlock.setParent(parent);

    // Act
    khaosBlock.toString();

    // Assert
    verify(blk).getBlockId();
    verify(blk2).getBlockId();
    verify(blk).getNum();
    verify(blk2).getNum();
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#toString()}.
   * <ul>
   *   <li>Given {@link KhaosBlock#KhaosBlock(BlockCapsule)} with blk is {@link BlockCapsule}.</li>
   *   <li>Then calls {@link BlockCapsule#getBlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KhaosBlock#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KhaosBlock.toString()"})
  public void testKhaosBlockToString_givenKhaosBlockWithBlkIsBlockCapsule_thenCallsGetBlockId() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act
    (new KhaosBlock(blk)).toString();

    // Assert
    verify(blk).getBlockId();
    verify(blk).getNum();
  }

  /**
   * Test KhaosStore {@link KhaosStore#KhaosStore(KhaosDatabase)}.
   * <p>
   * Method under test: {@link KhaosStore#KhaosStore(KhaosDatabase)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KhaosStore.<init>(KhaosDatabase)"})
  public void testKhaosStoreNewKhaosStore() {
    // Arrange and Act
    KhaosStore actualKhaosStore = khaosDatabase.new KhaosStore();

    // Assert
    assertEquals(0, actualKhaosStore.size());
    assertTrue(actualKhaosStore.getNumKblkMap().isEmpty());
  }
}
