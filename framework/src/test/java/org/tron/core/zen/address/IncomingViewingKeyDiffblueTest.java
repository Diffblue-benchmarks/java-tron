package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IncomingViewingKeyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncomingViewingKey#IncomingViewingKey(byte[])}
   *   <li>{@link IncomingViewingKey#setValue(byte[])}
   *   <li>{@link IncomingViewingKey#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncomingViewingKey.<init>(byte[])", "byte[] IncomingViewingKey.getValue()",
      "void IncomingViewingKey.setValue(byte[])"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    IncomingViewingKey actualIncomingViewingKey = new IncomingViewingKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] value = "AXAXAXAX".getBytes("UTF-8");
    actualIncomingViewingKey.setValue(value);
    byte[] actualValue = actualIncomingViewingKey.getValue();

    // Assert
    assertSame(value, actualValue);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }
}
