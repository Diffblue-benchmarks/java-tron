package org.tron.core.net.message.sync;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import org.tron.core.capsule.BlockCapsule;

public class SyncBlockChainMessageDiffblueTest {
  /**
   * Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("type: SYNC_BLOCK_CHAIN\nsize: 0", (new SyncBlockChainMessage(new ArrayList<>())).toString());
  }

  /**
   * Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayList<BlockCapsule.BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockCapsule.BlockId());

    // Act and Assert
    assertEquals(
        "type: SYNC_BLOCK_CHAIN\n"
            + "size: 1, start block: Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        (new SyncBlockChainMessage(blockIds)).toString());
  }

  /**
   * Method under test: {@link SyncBlockChainMessage#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ArrayList<BlockCapsule.BlockId> blockIds = new ArrayList<>();
    blockIds.add(new BlockCapsule.BlockId());
    blockIds.add(new BlockCapsule.BlockId());

    // Act and Assert
    assertEquals(
        "type: SYNC_BLOCK_CHAIN\n"
            + "size: 2, start block: Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000, end"
            + " block Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        (new SyncBlockChainMessage(blockIds)).toString());
  }

  /**
   * Method under test: {@link SyncBlockChainMessage#getAnswerMessage()}
   */
  @Test
  public void testGetAnswerMessage() {
    // Arrange and Act
    Class<?> actualAnswerMessage = (new SyncBlockChainMessage(new ArrayList<>())).getAnswerMessage();

    // Assert
    Class<ChainInventoryMessage> expectedAnswerMessage = ChainInventoryMessage.class;
    assertEquals(expectedAnswerMessage, actualAnswerMessage);
  }
}
