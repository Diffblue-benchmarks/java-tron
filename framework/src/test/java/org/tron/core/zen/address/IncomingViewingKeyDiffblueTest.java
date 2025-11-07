package org.tron.core.zen.address;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class IncomingViewingKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IncomingViewingKey#IncomingViewingKey(byte[])}
   *   <li>{@link IncomingViewingKey#setValue(byte[])}
   *   <li>{@link IncomingViewingKey#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    IncomingViewingKey actualIncomingViewingKey = new IncomingViewingKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] value = "AXAXAXAX".getBytes("UTF-8");
    actualIncomingViewingKey.setValue(value);

    // Assert that nothing has changed
    assertSame(value, actualIncomingViewingKey.getValue());
  }
}
