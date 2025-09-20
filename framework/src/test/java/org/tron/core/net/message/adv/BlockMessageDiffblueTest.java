package org.tron.core.net.message.adv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
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

public class BlockMessageDiffblueTest {
  /**
   * Test {@link BlockMessage#getBlockId()}.
   *
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockMessage#getBlockId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockId BlockMessage.getBlockId()"})
  public void testGetBlockId_thenReturnBlockId() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockId blockId = new BlockId();
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    BlockId actualBlockId = new BlockMessage(block).getBlockId();

    // Assert
    verify(block).getBlockId();
    verify(block).getData();
    assertSame(blockId, actualBlockId);
  }

  /**
   * Test {@link BlockMessage#getMessageId()}.
   *
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockMessage#getMessageId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash BlockMessage.getMessageId()"})
  public void testGetMessageId_thenReturnBlockId() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockId blockId = new BlockId();
    when(block.getBlockId()).thenReturn(blockId);

    // Act
    Sha256Hash actualMessageId = new BlockMessage(block).getMessageId();

    // Assert
    verify(block).getBlockId();
    verify(block).getData();
    assertSame(blockId, actualMessageId);
  }

  /**
   * Test {@link BlockMessage#equals(Object)}, and {@link BlockMessage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockMessage#equals(Object)}
   *   <li>{@link BlockMessage#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockMessage.equals(Object)", "int BlockMessage.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage = new BlockMessage(block);

    BlockCapsule block2 = mock(BlockCapsule.class);
    when(block2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage2 = new BlockMessage(block2);

    // Act and Assert
    assertEquals(blockMessage, blockMessage2);
    assertEquals(blockMessage.hashCode(), blockMessage2.hashCode());
  }

  /**
   * Test {@link BlockMessage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BlockMessage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockMessage.equals(Object)", "int BlockMessage.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn(new byte[] {});
    BlockMessage blockMessage = new BlockMessage(block);

    BlockCapsule block2 = mock(BlockCapsule.class);
    when(block2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(blockMessage, new BlockMessage(block2));
  }
}
