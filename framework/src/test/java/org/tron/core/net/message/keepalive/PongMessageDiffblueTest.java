package org.tron.core.net.message.keepalive;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.net.message.MessageTypes;

public class PongMessageDiffblueTest {
  /**
   * Method under test: {@link PongMessage#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.P2P_PONG, (new PongMessage()).getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PongMessage#PongMessage(byte, byte[])}
   *   <li>{@link PongMessage#toString()}
   *   <li>{@link PongMessage#getAnswerMessage()}
   *   <li>{@link PongMessage#getData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    PongMessage actualPongMessage = new PongMessage((byte) 'A', "AXAXAXAX".getBytes("UTF-8"));
    String actualToStringResult = actualPongMessage.toString();
    Class<?> actualAnswerMessage = actualPongMessage.getAnswerMessage();

    // Assert
    assertEquals("type: null\n", actualToStringResult);
    assertNull(actualAnswerMessage);
    assertArrayEquals(new byte[]{-64}, actualPongMessage.getData());
  }
}
