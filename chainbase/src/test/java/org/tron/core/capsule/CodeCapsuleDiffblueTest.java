package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CodeCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CodeCapsule#CodeCapsule(byte[])}
   *   <li>{@link CodeCapsule#toString()}
   *   <li>{@link CodeCapsule#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeCapsule.<init>(byte[])", "byte[] CodeCapsule.getData()",
      "String CodeCapsule.toString()"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CodeCapsule actualCodeCapsule = new CodeCapsule(code);
    String actualToStringResult = actualCodeCapsule.toString();

    // Assert
    assertEquals("[65, 88, 65, 88, 65, 88, 65, 88]", actualToStringResult);
    assertSame(code, actualCodeCapsule.getData());
    byte[] instance = actualCodeCapsule.getInstance();
    assertSame(code, instance);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), instance);
  }

  /**
   * Test {@link CodeCapsule#getInstance()}.
   * <p>
   * Method under test: {@link CodeCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CodeCapsule.getInstance()"})
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualInstance = (new CodeCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInstance);
  }
}
