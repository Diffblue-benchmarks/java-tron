package org.tron.core.net.message.keepalive;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.net.message.MessageTypes;

public class PingMessageDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PingMessage#PingMessage(byte, byte[])}
   *   <li>{@link PingMessage#toString()}
   *   <li>{@link PingMessage#getAnswerMessage()}
   *   <li>{@link PingMessage#getData()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PingMessage.<init>(byte, byte[])",
    "Class PingMessage.getAnswerMessage()",
    "byte[] PingMessage.getData()",
    "String PingMessage.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    PingMessage actualPingMessage = new PingMessage((byte) 'A', "AXAXAXAX".getBytes("UTF-8"));
    String actualToStringResult = actualPingMessage.toString();
    Class<?> actualAnswerMessage = actualPingMessage.getAnswerMessage();
    byte[] actualData = actualPingMessage.getData();

    // Assert
    assertEquals("type: null\n", actualToStringResult);
    Class<PongMessage> expectedAnswerMessage = PongMessage.class;
    assertEquals(expectedAnswerMessage, actualAnswerMessage);
    assertArrayEquals(new byte[] {-64}, actualData);
  }

  /**
   * Test {@link PingMessage#PingMessage()}.
   *
   * <p>Method under test: {@link PingMessage#PingMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PingMessage.<init>()"})
  public void testNewPingMessage() {
    // Arrange and Act
    PingMessage actualPingMessage = new PingMessage();

    // Assert
    assertTrue(actualPingMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(MessageTypes.P2P_PING, actualPingMessage.getType());
    Class<PongMessage> expectedAnswerMessage = PongMessage.class;
    assertEquals(expectedAnswerMessage, actualPingMessage.getAnswerMessage());
    assertArrayEquals(new byte[] {-64}, actualPingMessage.getData());
    assertArrayEquals(new byte[] {'"', -64}, actualPingMessage.getSendBytes());
  }

  /**
   * Test {@link PingMessage#PingMessage(byte[])}.
   *
   * <p>Method under test: {@link PingMessage#PingMessage(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PingMessage.<init>(byte[])"})
  public void testNewPingMessage2() throws UnsupportedEncodingException {
    // Arrange and Act
    PingMessage actualPingMessage = new PingMessage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualPingMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertEquals(MessageTypes.P2P_PING, actualPingMessage.getType());
    Class<PongMessage> expectedAnswerMessage = PongMessage.class;
    assertEquals(expectedAnswerMessage, actualPingMessage.getAnswerMessage());
    assertArrayEquals(new byte[] {-64}, actualPingMessage.getData());
    assertArrayEquals(new byte[] {'"', -64}, actualPingMessage.getSendBytes());
  }

  /**
   * Test {@link PingMessage#getType()}.
   *
   * <p>Method under test: {@link PingMessage#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageTypes PingMessage.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.P2P_PING, new PingMessage().getType());
  }
}
