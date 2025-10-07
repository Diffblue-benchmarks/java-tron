package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BytesCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BytesCapsule#BytesCapsule(byte[])}
   *   <li>{@link BytesCapsule#getData()}
   *   <li>{@link BytesCapsule#getInstance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BytesCapsule.<init>(byte[])",
    "byte[] BytesCapsule.getData()",
    "java.lang.Object BytesCapsule.getInstance()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    BytesCapsule actualBytesCapsule = new BytesCapsule(bytes);
    byte[] actualData = actualBytesCapsule.getData();

    // Assert
    assertNull(actualBytesCapsule.getInstance());
    assertSame(bytes, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
