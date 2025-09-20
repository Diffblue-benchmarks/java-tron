package org.tron.consensus.pbft.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTMessage;

public class PbftBaseMessageDiffblueTest {
  /**
   * Test {@link PbftBaseMessage#getAnswerMessage()}.
   *
   * <p>Method under test: {@link PbftBaseMessage#getAnswerMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Class PbftBaseMessage.getAnswerMessage()"})
  public void testGetAnswerMessage() {
    // Arrange, Act and Assert
    assertNull(new PbftMessage().getAnswerMessage());
  }

  /**
   * Test {@link PbftBaseMessage#getPbftMessage()}.
   *
   * <p>Method under test: {@link PbftBaseMessage#getPbftMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTMessage PbftBaseMessage.getPbftMessage()"})
  public void testGetPbftMessage() {
    // Arrange, Act and Assert
    assertNull(new PbftMessage().getPbftMessage());
  }

  /**
   * Test {@link PbftBaseMessage#setPbftMessage(PBFTMessage)}.
   *
   * <p>Method under test: {@link PbftBaseMessage#setPbftMessage(PBFTMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftBaseMessage PbftBaseMessage.setPbftMessage(PBFTMessage)"})
  public void testSetPbftMessage() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();

    // Act
    PbftBaseMessage actualSetPbftMessageResult =
        pbftMessage.setPbftMessage(PBFTMessage.getDefaultInstance());

    // Assert
    assertSame(pbftMessage, actualSetPbftMessageResult);
  }

  /**
   * Test {@link PbftBaseMessage#isSwitch()}.
   *
   * <ul>
   *   <li>Given {@link PbftMessage#PbftMessage()} Switch is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PbftBaseMessage#isSwitch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftBaseMessage.isSwitch()"})
  public void testIsSwitch_givenPbftMessageSwitchIsTrue_thenReturnTrue() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    pbftMessage.setSwitch(true);

    // Act and Assert
    assertTrue(pbftMessage.isSwitch());
  }

  /**
   * Test {@link PbftBaseMessage#isSwitch()}.
   *
   * <ul>
   *   <li>Given {@link PbftMessage#PbftMessage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PbftBaseMessage#isSwitch()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftBaseMessage.isSwitch()"})
  public void testIsSwitch_givenPbftMessage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PbftMessage().isSwitch());
  }

  /**
   * Test {@link PbftBaseMessage#setSwitch(boolean)}.
   *
   * <p>Method under test: {@link PbftBaseMessage#setSwitch(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftBaseMessage PbftBaseMessage.setSwitch(boolean)"})
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
   * Test {@link PbftBaseMessage#setData(byte[])}.
   *
   * <p>Method under test: {@link PbftBaseMessage#setData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftBaseMessage PbftBaseMessage.setData(byte[])"})
  public void testSetData() throws UnsupportedEncodingException {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    PbftBaseMessage actualSetDataResult = pbftMessage.setData(data);

    // Assert
    assertSame(pbftMessage, actualSetDataResult);
    assertSame(data, pbftMessage.getData());
    assertArrayEquals(
        new byte[] {0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, pbftMessage.getSendBytes());
  }

  /**
   * Test {@link PbftBaseMessage#setType(byte)}.
   *
   * <p>Method under test: {@link PbftBaseMessage#setType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PbftBaseMessage PbftBaseMessage.setType(byte)"})
  public void testSetType() {
    // Arrange
    PbftMessage pbftMessage = new PbftMessage();

    // Act
    PbftBaseMessage actualSetTypeResult = pbftMessage.setType((byte) 'A');

    // Assert
    assertNull(pbftMessage.getType());
    assertSame(pbftMessage, actualSetTypeResult);
    assertArrayEquals(new byte[] {'A'}, pbftMessage.getSendBytes());
  }

  /**
   * Test {@link PbftBaseMessage#getPublicKey()}.
   *
   * <p>Method under test: {@link PbftBaseMessage#getPublicKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftBaseMessage.getPublicKey()"})
  public void testGetPublicKey() {
    // Arrange, Act and Assert
    assertNull(new PbftMessage().getPublicKey());
  }
}
