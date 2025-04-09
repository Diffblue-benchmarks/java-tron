package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FullViewingKeyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FullViewingKey.<init>(byte[], byte[], byte[])", "byte[] FullViewingKey.getAk()",
      "byte[] FullViewingKey.getNk()", "byte[] FullViewingKey.getOvk()", "void FullViewingKey.setAk(byte[])",
      "void FullViewingKey.setNk(byte[])", "void FullViewingKey.setOvk(byte[])"})
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
    byte[] actualOvk = actualFullViewingKey.getOvk();

    // Assert
    assertSame(ak2, actualAk);
    assertSame(nk2, actualNk);
    assertSame(ovk, actualOvk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOvk);
  }
}
