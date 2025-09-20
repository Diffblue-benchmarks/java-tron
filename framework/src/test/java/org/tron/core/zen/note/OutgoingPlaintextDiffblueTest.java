package org.tron.core.zen.note;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OutgoingPlaintextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OutgoingPlaintext#OutgoingPlaintext(byte[], byte[])}
   *   <li>{@link OutgoingPlaintext#setEsk(byte[])}
   *   <li>{@link OutgoingPlaintext#setPkD(byte[])}
   *   <li>{@link OutgoingPlaintext#getEsk()}
   *   <li>{@link OutgoingPlaintext#getPkD()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OutgoingPlaintext.<init>(byte[], byte[])",
    "byte[] OutgoingPlaintext.getEsk()",
    "byte[] OutgoingPlaintext.getPkD()",
    "void OutgoingPlaintext.setEsk(byte[])",
    "void OutgoingPlaintext.setPkD(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    OutgoingPlaintext actualOutgoingPlaintext =
        new OutgoingPlaintext("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));
    byte[] esk = "AXAXAXAX".getBytes("UTF-8");
    actualOutgoingPlaintext.setEsk(esk);
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    actualOutgoingPlaintext.setPkD(pkD);
    byte[] actualEsk = actualOutgoingPlaintext.getEsk();
    byte[] actualPkD = actualOutgoingPlaintext.getPkD();

    // Assert
    assertSame(esk, actualEsk);
    assertSame(pkD, actualPkD);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPkD);
  }
}
