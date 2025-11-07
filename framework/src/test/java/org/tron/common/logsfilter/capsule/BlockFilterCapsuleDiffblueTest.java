package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.tron.core.capsule.BlockCapsule;
import org.tron.protos.Protocol;

public class BlockFilterCapsuleDiffblueTest {
  /**
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
  public void testGettersAndSetters() {
    // Arrange and Act
    BlockFilterCapsule actualBlockFilterCapsule = new BlockFilterCapsule("Block Hash", true);
    actualBlockFilterCapsule.setBlockHash("Block Hash");
    actualBlockFilterCapsule.setSolidified(true);
    String actualToStringResult = actualBlockFilterCapsule.toString();
    String actualBlockHash = actualBlockFilterCapsule.getBlockHash();

    // Assert that nothing has changed
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("BlockFilterCapsule(blockHash=Block Hash, solidified=true)", actualToStringResult);
    assertTrue(actualBlockFilterCapsule.isSolidified());
  }

  /**
   * Method under test: {@link BlockFilterCapsule#processFilterTrigger()}
   */
  @Test
  public void testProcessFilterTrigger() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getBlockId()).thenReturn(new BlockCapsule.BlockId());

    // Act
    (new BlockFilterCapsule(block, true)).processFilterTrigger();

    // Assert that nothing has changed
    verify(block).getBlockId();
  }

  /**
   * Method under test:
   * {@link BlockFilterCapsule#BlockFilterCapsule(BlockCapsule, boolean)}
   */
  @Test
  public void testNewBlockFilterCapsule() {
    // Arrange and Act
    BlockFilterCapsule actualBlockFilterCapsule = new BlockFilterCapsule(
        new BlockCapsule(Protocol.Block.getDefaultInstance()), true);

    // Assert
    assertEquals("00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualBlockFilterCapsule.getBlockHash());
    assertTrue(actualBlockFilterCapsule.isSolidified());
  }
}
