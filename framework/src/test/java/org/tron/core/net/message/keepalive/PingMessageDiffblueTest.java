package org.tron.core.net.message.keepalive;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.net.message.MessageTypes;

public class PingMessageDiffblueTest {
  /**
   * Method under test: {@link PingMessage#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.P2P_PING, (new PingMessage()).getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PingMessage#PingMessage(byte, byte[])}
   *   <li>{@link PingMessage#toString()}
   *   <li>{@link PingMessage#getAnswerMessage()}
   *   <li>{@link PingMessage#getData()}
   * </ul>
   */
  @Test
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
    assertArrayEquals(new byte[]{-64}, actualData);
  }
}
