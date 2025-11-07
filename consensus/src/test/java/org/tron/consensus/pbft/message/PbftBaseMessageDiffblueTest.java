package org.tron.consensus.pbft.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import org.junit.Test;
import org.tron.protos.Protocol;

public class PbftBaseMessageDiffblueTest {
  /**
   * Method under test: {@link PbftBaseMessage#getAnswerMessage()}
   */
  @Test
  public void testGetAnswerMessage() {
    // Arrange, Act and Assert
    assertNull((new PbftMessage()).getAnswerMessage());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getPbftMessage()}
   */
  @Test
  public void testGetPbftMessage() {
    // Arrange, Act and Assert
    assertNull((new PbftMessage()).getPbftMessage());
  }

  /**
   * Method under test:
   * {@link PbftBaseMessage#setPbftMessage(Protocol.PBFTMessage)}
   */
  @Test
  public void testSetPbftMessage() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();

    // Act and Assert
    assertSame(pbftMessage, pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance()));
  }

  /**
   * Method under test: {@link PbftBaseMessage#isSwitch()}
   */
  @Test
  public void testIsSwitch() {
    // Arrange, Act and Assert
    assertFalse((new PbftMessage()).isSwitch());
  }

  /**
   * Method under test: {@link PbftBaseMessage#isSwitch()}
   */
  @Test
  public void testIsSwitch2() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setSwitch(true);

    // Act and Assert
    assertTrue(pbftMessage.isSwitch());
  }

  /**
   * Method under test: {@link PbftBaseMessage#setSwitch(boolean)}
   */
  @Test
  public void testSetSwitch() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();

    // Act
    PbftBaseMessage actualSetSwitchResult = pbftMessage.setSwitch(true);

    // Assert
    assertTrue(pbftMessage.isSwitch());
    assertSame(pbftMessage, actualSetSwitchResult);
  }

  /**
   * Method under test: {@link PbftBaseMessage#setType(byte)}
   */
  @Test
  public void testSetType() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();

    // Act
    PbftBaseMessage actualSetTypeResult = pbftMessage.setType((byte) 'A');

    // Assert
    ByteBuf sendData = pbftMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    assertNull(pbftMessage.getType());
    assertTrue(sendData.readBoolean());
    assertSame(pbftMessage, actualSetTypeResult);
    assertArrayEquals(new byte[]{'A'}, pbftMessage.getSendBytes());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getPublicKey()}
   */
  @Test
  public void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull((new PbftMessage()).getPublicKey());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getDataKey()}
   */
  @Test
  public void testGetDataKey() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("0_BLOCK_", pbftMessage.getDataKey());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getNumber()}
   */
  @Test
  public void testGetNumber() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, pbftMessage.getNumber());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getEpoch()}
   */
  @Test
  public void testGetEpoch() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, pbftMessage.getEpoch());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getDataType()}
   */
  @Test
  public void testGetDataType() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals(Protocol.PBFTMessage.DataType.BLOCK, pbftMessage.getDataType());
  }

  /**
   * Method under test: {@link PbftBaseMessage#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("DataType:BLOCK, MsgType:VIEW_CHANGE, node address:null, viewN:0, epoch:0, data:, type: FIRST\n",
        pbftMessage.toString());
  }

  /**
   * Method under test: {@link PbftBaseMessage#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setType((byte) 'A');
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("DataType:BLOCK, MsgType:VIEW_CHANGE, node address:null, viewN:0, epoch:0, data:, type: null\n",
        pbftMessage.toString());
  }

  /**
   * Method under test: {@link PbftBaseMessage#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setType((byte) 1);
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("DataType:BLOCK, MsgType:VIEW_CHANGE, node address:null, viewN:0, epoch:0, data:, type: TRX\n",
        pbftMessage.toString());
  }

  /**
   * Method under test: {@link PbftBaseMessage#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setType((byte) 2);
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("DataType:BLOCK, MsgType:VIEW_CHANGE, node address:null, viewN:0, epoch:0, data:, type: BLOCK\n",
        pbftMessage.toString());
  }

  /**
   * Method under test: {@link PbftBaseMessage#getDataString()}
   */
  @Test
  public void testGetDataString() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setPbftMessage(Protocol.PBFTMessage.getDefaultInstance());

    // Act and Assert
    assertEquals("", pbftMessage.getDataString());
  }
}
