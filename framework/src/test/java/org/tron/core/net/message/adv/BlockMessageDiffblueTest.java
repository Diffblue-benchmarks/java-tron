package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
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
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.message.MessageTypes;

public class BlockMessageDiffblueTest {
  /**
   * Test {@link BlockMessage#BlockMessage(BlockCapsule)}.
   * <ul>
   *   <li>Then SendData return {@link UnpooledHeapByteBuf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockMessage#BlockMessage(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockMessage.<init>(BlockCapsule)"})
  public void testNewBlockMessage_thenSendDataReturnUnpooledHeapByteBuf() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    BlockMessage actualBlockMessage = new BlockMessage(block);

    // Assert
    verify(block).getData();
    assertTrue(actualBlockMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualBlockMessage.getAnswerMessage());
    assertNull(actualBlockMessage.getMessageId());
    assertNull(actualBlockMessage.getBlockId());
    assertEquals(MessageTypes.BLOCK, actualBlockMessage.getType());
    assertSame(block, actualBlockMessage.getBlockCapsule());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualBlockMessage.getData());
    assertArrayEquals(new byte[]{2, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualBlockMessage.getSendBytes());
  }

  /**
   * Test {@link BlockMessage#getBlockId()}.
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockMessage#getBlockId()}
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
    BlockId actualBlockId = (new BlockMessage(block)).getBlockId();

    // Assert
    verify(block).getBlockId();
    verify(block).getData();
    assertSame(blockId, actualBlockId);
  }

  /**
   * Test {@link BlockMessage#getMessageId()}.
   * <ul>
   *   <li>Then return {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockMessage#getMessageId()}
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
    Sha256Hash actualMessageId = (new BlockMessage(block)).getMessageId();

    // Assert
    verify(block).getBlockId();
    verify(block).getData();
    assertSame(blockId, actualMessageId);
  }

  /**
   * Test {@link BlockMessage#equals(Object)}, and {@link BlockMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockMessage#equals(Object)}
   *   <li>{@link BlockMessage#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockMessage.equals(Object)", "int BlockMessage.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage = new BlockMessage(block);
    BlockCapsule block2 = mock(BlockCapsule.class);
    when(block2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockMessage blockMessage2 = new BlockMessage(block2);

    // Act and Assert
    assertEquals(blockMessage, blockMessage2);
    int expectedHashCodeResult = blockMessage.hashCode();
    assertEquals(expectedHashCodeResult, blockMessage2.hashCode());
  }

  /**
   * Test {@link BlockMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockMessage#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockMessage.equals(Object)", "int BlockMessage.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getData()).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    BlockMessage blockMessage = new BlockMessage(block);
    BlockCapsule block2 = mock(BlockCapsule.class);
    when(block2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(blockMessage, new BlockMessage(block2));
  }
}
