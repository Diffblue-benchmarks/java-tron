package org.tron.core.zen.address;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class FullViewingKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FullViewingKey#FullViewingKey(byte[], byte[], byte[])}
   *   <li>{@link FullViewingKey#setAk(byte[])}
   *   <li>{@link FullViewingKey#setNk(byte[])}
   *   <li>{@link FullViewingKey#setOvk(byte[])}
   *   <li>{@link FullViewingKey#getAk()}
   *   <li>{@link FullViewingKey#getNk()}
   *   <li>{@link FullViewingKey#getOvk()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] ak = "AXAXAXAX".getBytes("UTF-8");
    byte[] nk = "AXAXAXAX".getBytes("UTF-8");

    // Act
    FullViewingKey actualFullViewingKey = new FullViewingKey(ak, nk, "AXAXAXAX".getBytes("UTF-8"));
    byte[] ak2 = "AXAXAXAX".getBytes("UTF-8");
    actualFullViewingKey.setAk(ak2);
    byte[] nk2 = "AXAXAXAX".getBytes("UTF-8");
    actualFullViewingKey.setNk(nk2);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualFullViewingKey.setOvk(ovk);
    byte[] actualAk = actualFullViewingKey.getAk();
    byte[] actualNk = actualFullViewingKey.getNk();

    // Assert that nothing has changed
    assertSame(ak2, actualAk);
    assertSame(nk2, actualNk);
    assertSame(ovk, actualFullViewingKey.getOvk());
  }
}
