package org.tron.core.net.message.keepalive;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.net.message.MessageTypes;

public class PongMessageDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PongMessage#PongMessage(byte, byte[])}
   *   <li>{@link PongMessage#toString()}
   *   <li>{@link PongMessage#getAnswerMessage()}
   *   <li>{@link PongMessage#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PongMessage.<init>(byte, byte[])", "Class PongMessage.getAnswerMessage()",
      "byte[] PongMessage.getData()", "String PongMessage.toString()"})
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

  /**
   * Test {@link PongMessage#PongMessage()}.
   * <p>
   * Method under test: {@link PongMessage#PongMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PongMessage.<init>()"})
  public void testNewPongMessage() {
    // Arrange and Act
    PongMessage actualPongMessage = new PongMessage();

    // Assert
    assertTrue(actualPongMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualPongMessage.getAnswerMessage());
    assertEquals(MessageTypes.P2P_PONG, actualPongMessage.getType());
    assertArrayEquals(new byte[]{-64}, actualPongMessage.getData());
    assertArrayEquals(new byte[]{'#', -64}, actualPongMessage.getSendBytes());
  }

  /**
   * Test {@link PongMessage#PongMessage(byte[])}.
   * <p>
   * Method under test: {@link PongMessage#PongMessage(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PongMessage.<init>(byte[])"})
  public void testNewPongMessage2() throws UnsupportedEncodingException {
    // Arrange and Act
    PongMessage actualPongMessage = new PongMessage("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualPongMessage.getSendData() instanceof UnpooledHeapByteBuf);
    assertNull(actualPongMessage.getAnswerMessage());
    assertEquals(MessageTypes.P2P_PONG, actualPongMessage.getType());
    assertArrayEquals(new byte[]{-64}, actualPongMessage.getData());
    assertArrayEquals(new byte[]{'#', -64}, actualPongMessage.getSendBytes());
  }

  /**
   * Test {@link PongMessage#getType()}.
   * <p>
   * Method under test: {@link PongMessage#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageTypes PongMessage.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(MessageTypes.P2P_PONG, (new PongMessage()).getType());
  }
}
