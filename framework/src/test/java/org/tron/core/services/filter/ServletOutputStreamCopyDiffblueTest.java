package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Test;

public class ServletOutputStreamCopyDiffblueTest {
  /**
   * Method under test: {@link ServletOutputStreamCopy#write(int)}
   */
  @Test
  public void testWrite() throws IOException {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy = new ServletOutputStreamCopy(new ByteArrayOutputStream(1));

    // Act
    servletOutputStreamCopy.write(19088743);

    // Assert that nothing has changed
    assertEquals(1, servletOutputStreamCopy.getStreamByteSize());
  }

  /**
   * Method under test: {@link ServletOutputStreamCopy#write(int)}
   */
  @Test
  public void testWrite2() throws IOException {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy = new ServletOutputStreamCopy(
        new ServletOutputStreamCopy(new ByteArrayOutputStream(1)));

    // Act
    servletOutputStreamCopy.write(19088743);

    // Assert that nothing has changed
    assertEquals(1, servletOutputStreamCopy.getStreamByteSize());
  }

  /**
   * Method under test: {@link ServletOutputStreamCopy#getStreamByteSize()}
   */
  @Test
  public void testGetStreamByteSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ServletOutputStreamCopy(new ByteArrayOutputStream(1))).getStreamByteSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ServletOutputStreamCopy#setWriteListener(WriteListener)}
   *   <li>{@link ServletOutputStreamCopy#isReady()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ServletOutputStreamCopy servletOutputStreamCopy = new ServletOutputStreamCopy(new ByteArrayOutputStream(1));

    // Act
    servletOutputStreamCopy.setWriteListener(null);

    // Assert that nothing has changed
    assertFalse(servletOutputStreamCopy.isReady());
  }

  /**
   * Method under test:
   * {@link ServletOutputStreamCopy#ServletOutputStreamCopy(OutputStream)}
   */
  @Test
  public void testNewServletOutputStreamCopy() {
    // Arrange and Act
    ServletOutputStreamCopy actualServletOutputStreamCopy = new ServletOutputStreamCopy(new ByteArrayOutputStream(1));

    // Assert
    assertEquals(0, actualServletOutputStreamCopy.getStreamByteSize());
    assertFalse(actualServletOutputStreamCopy.isReady());
  }
}
