package org.tron.core.zen.note;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class OutgoingPlaintextDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OutgoingPlaintext#OutgoingPlaintext(byte[], byte[])}
   *   <li>{@link OutgoingPlaintext#setEsk(byte[])}
   *   <li>{@link OutgoingPlaintext#setPkD(byte[])}
   *   <li>{@link OutgoingPlaintext#getEsk()}
   *   <li>{@link OutgoingPlaintext#getPkD()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");

    // Act
    OutgoingPlaintext actualOutgoingPlaintext = new OutgoingPlaintext(pkD, "AXAXAXAX".getBytes("UTF-8"));
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");
    actualOutgoingPlaintext.setEsk(esk);
    byte[] pkD2 = "AXAXAXAX".getBytes("UTF-8");
    actualOutgoingPlaintext.setPkD(pkD2);
    byte[] actualEsk = actualOutgoingPlaintext.getEsk();

    // Assert that nothing has changed
    assertSame(esk, actualEsk);
    assertSame(pkD2, actualOutgoingPlaintext.getPkD());
  }
}
