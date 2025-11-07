package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;

public class BlockFilterCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockFilterCapsule#BlockFilterCapsule(String, boolean)}
   *   <li>{@link BlockFilterCapsule#setBlockHash(String)}
   *   <li>{@link BlockFilterCapsule#setSolidified(boolean)}
   *   <li>{@link BlockFilterCapsule#toString()}
   *   <li>{@link BlockFilterCapsule#getBlockHash()}
   *   <li>{@link BlockFilterCapsule#isSolidified()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockFilterCapsule.<init>(String, boolean)", "String BlockFilterCapsule.getBlockHash()",
      "boolean BlockFilterCapsule.isSolidified()", "void BlockFilterCapsule.setBlockHash(String)",
      "void BlockFilterCapsule.setSolidified(boolean)", "String BlockFilterCapsule.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BlockFilterCapsule actualBlockFilterCapsule = new BlockFilterCapsule("Block Hash", true);
    actualBlockFilterCapsule.setBlockHash("Block Hash");
    actualBlockFilterCapsule.setSolidified(true);
    String actualToStringResult = actualBlockFilterCapsule.toString();
    String actualBlockHash = actualBlockFilterCapsule.getBlockHash();

    // Assert
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("BlockFilterCapsule(blockHash=Block Hash, solidified=true)", actualToStringResult);
    assertTrue(actualBlockFilterCapsule.isSolidified());
  }

  /**
   * Test {@link BlockFilterCapsule#BlockFilterCapsule(BlockCapsule, boolean)}.
   * <p>
   * Method under test: {@link BlockFilterCapsule#BlockFilterCapsule(BlockCapsule, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockFilterCapsule.<init>(BlockCapsule, boolean)"})
  public void testNewBlockFilterCapsule() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    BlockFilterCapsule actualBlockFilterCapsule = new BlockFilterCapsule(block, true);

    // Assert
    verify(block).getBlockId();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000",
        actualBlockFilterCapsule.getBlockHash());
    assertTrue(actualBlockFilterCapsule.isSolidified());
  }

  /**
   * Test {@link BlockFilterCapsule#BlockFilterCapsule(BlockCapsule, boolean)}.
   * <ul>
   *   <li>Given {@link BlockId}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockFilterCapsule#BlockFilterCapsule(BlockCapsule, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockFilterCapsule.<init>(BlockCapsule, boolean)"})
  public void testNewBlockFilterCapsule_givenBlockId_whenBlockCapsuleGetBlockIdReturnBlockId() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getBlockId()).thenReturn(mock(BlockId.class));

    // Act
    BlockFilterCapsule actualBlockFilterCapsule = new BlockFilterCapsule(block, true);

    // Assert
    verify(block).getBlockId();
    assertTrue(actualBlockFilterCapsule.isSolidified());
  }
}
