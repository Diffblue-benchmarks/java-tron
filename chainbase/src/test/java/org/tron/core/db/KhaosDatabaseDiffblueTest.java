package org.tron.core.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.KhaosDatabase.KhaosBlock;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class KhaosDatabaseDiffblueTest {
  @Mock private BlockCapsule blockCapsule;

  @InjectMocks private KhaosBlock khaosBlock;

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}, and {@link KhaosBlock#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KhaosBlock#equals(Object)}
   *   <li>{@link KhaosBlock#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(khaosBlock.hashCode(), khaosBlock2.hashCode());
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act and Assert
    assertNotEquals(new KhaosBlock(blk), Sha256Hash.ZERO_HASH);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KhaosBlock#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KhaosBlock.equals(Object)", "int KhaosBlock.hashCode()"})
  public void testKhaosBlockEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BlockCapsule blk = mock(BlockCapsule.class);
    when(blk.getNum()).thenReturn(1L);
    when(blk.getBlockId()).thenReturn(new BlockId());

    // Act and Assert
    assertNotEquals(new KhaosBlock(blk), null);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#getParent()}.
   *
   * <p>Method under test: {@link KhaosBlock#getParent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"KhaosBlock KhaosBlock.getParent()"})
  public void testKhaosBlockGetParent() {
    // Arrange, Act and Assert
    assertNull(khaosBlock.getParent());
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#getParentHash()}.
   *
   * <p>Method under test: {@link KhaosBlock#getParentHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash KhaosBlock.getParentHash()"})
  public void testKhaosBlockGetParentHash() {
    // Arrange
    when(blockCapsule.getParentHash()).thenReturn(Sha256Hash.ZERO_HASH);

    // Act
    Sha256Hash actualParentHash = khaosBlock.getParentHash();

    // Assert
    verify(blockCapsule).getParentHash();
    assertSame(Sha256Hash.ZERO_HASH, actualParentHash);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#setParent(KhaosBlock)}.
   *
   * <p>Method under test: {@link KhaosBlock#setParent(KhaosBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KhaosBlock.setParent(KhaosBlock)"})
  public void testKhaosBlockSetParent() {
    // Arrange and Act
    khaosBlock.setParent(khaosBlock);

    // Assert
    KhaosBlock actualParent = khaosBlock.getParent();
    assertSame(khaosBlock, actualParent);
  }

  /**
   * Test KhaosBlock {@link KhaosBlock#toString()}.
   *
   * <ul>
   *   <li>Then return {@code KhaosBlock{blk=blockCapsule, parent=null, id=null, num=0}}.
   * </ul>
   *
   * <p>Method under test: {@link KhaosBlock#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KhaosBlock.toString()"})
  public void testKhaosBlockToString_thenReturnKhaosBlockBlkBlockCapsuleParentNullIdNullNum0() {
    // Arrange, Act and Assert
    assertEquals(
        "KhaosBlock{blk=blockCapsule, parent=null, id=null, num=0}", khaosBlock.toString());
  }
}
