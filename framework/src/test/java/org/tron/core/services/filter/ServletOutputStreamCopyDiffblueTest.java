package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ServletOutputStreamCopyDiffblueTest {
  /**
   * Test {@link ServletOutputStreamCopy#ServletOutputStreamCopy(OutputStream)}.
   *
   * <p>Method under test: {@link ServletOutputStreamCopy#ServletOutputStreamCopy(OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ServletOutputStreamCopy.<init>(OutputStream)"})
  public void testNewServletOutputStreamCopy() {
    // Arrange and Act
    ServletOutputStreamCopy actualServletOutputStreamCopy =
        new ServletOutputStreamCopy(new ByteArrayOutputStream());

    // Assert
    assertEquals(0, actualServletOutputStreamCopy.getStreamByteSize());
    assertFalse(actualServletOutputStreamCopy.isReady());
  }

  /**
   * Test {@link ServletOutputStreamCopy#write(int)} with {@code int}.
   *
   * <p>Method under test: {@link ServletOutputStreamCopy#write(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ServletOutputStreamCopy.write(int)"})
  public void testWriteWithInt() throws IOException {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy =
        new ServletOutputStreamCopy(new ByteArrayOutputStream());

    // Act
    servletOutputStreamCopy.write(19088743);

    // Assert
    assertEquals(1, servletOutputStreamCopy.getStreamByteSize());
  }

  /**
   * Test {@link ServletOutputStreamCopy#write(int)} with {@code int}.
   *
   * <p>Method under test: {@link ServletOutputStreamCopy#write(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ServletOutputStreamCopy.write(int)"})
  public void testWriteWithInt2() throws IOException {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy =
        new ServletOutputStreamCopy(new ServletOutputStreamCopy(new ByteArrayOutputStream()));

    // Act
    servletOutputStreamCopy.write(19088743);

    // Assert
    assertEquals(1, servletOutputStreamCopy.getStreamByteSize());
  }

  /**
   * Test {@link ServletOutputStreamCopy#getStreamByteSize()}.
   *
   * <p>Method under test: {@link ServletOutputStreamCopy#getStreamByteSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ServletOutputStreamCopy.getStreamByteSize()"})
  public void testGetStreamByteSize() {
    // Arrange, Act and Assert
    assertEquals(0, new ServletOutputStreamCopy(new ByteArrayOutputStream()).getStreamByteSize());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServletOutputStreamCopy#setWriteListener(WriteListener)}
   *   <li>{@link ServletOutputStreamCopy#isReady()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ServletOutputStreamCopy.isReady()",
    "void ServletOutputStreamCopy.setWriteListener(WriteListener)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy =
        new ServletOutputStreamCopy(new ByteArrayOutputStream());

    // Act
    servletOutputStreamCopy.setWriteListener(null);

    // Assert
    assertFalse(servletOutputStreamCopy.isReady());
  }
}
