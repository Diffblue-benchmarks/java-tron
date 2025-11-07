package org.tron.consensus.pbft.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.tron.protos.Protocol;

public class PbftMessageDiffblueTest {
  /**
   * Method under test: {@link PbftMessage#getNo()}
   */
  @Test
  public void testGetNo() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("0_BLOCK", pbftMessage.getNo());
  }

  /**
   * Method under test: {@link PbftMessage#PbftMessage()}
   */
  @Test
  public void testNewPbftMessage() {
    // Arrange and Act
    PbftMessage actualPbftMessage = new PbftMessage();

    // Assert
    assertNull(actualPbftMessage.getData());
    assertNull(actualPbftMessage.getPublicKey());
    assertNull(actualPbftMessage.getPbftMessage());
    assertFalse(actualPbftMessage.isSwitch());
  }
}
