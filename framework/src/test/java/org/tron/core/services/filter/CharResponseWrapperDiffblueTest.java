package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.eclipse.jetty.server.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletResponse;

public class CharResponseWrapperDiffblueTest {
  /**
   * Test {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}.
   * <p>
   * Method under test: {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CharResponseWrapper.<init>(HttpServletResponse)"})
  public void testNewCharResponseWrapper() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertSame(response, (new CharResponseWrapper(response)).getResponse());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   * <p>
   * Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream = (new CharResponseWrapper(new MockHttpServletResponse())).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   * <p>
   * Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream2() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream = (new CharResponseWrapper(
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())))).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getWriter()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.PrintWriter CharResponseWrapper.getWriter()"})
  public void testGetWriter_thenThrowIOException() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new CharResponseWrapper(response)).getWriter());
    verify(response).getOutputStream();
  }

  /**
   * Test {@link CharResponseWrapper#getWriter()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.PrintWriter CharResponseWrapper.getWriter()"})
  public void testGetWriter_thenThrowIOException2() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException("foo"));
    Response response2 = mock(Response.class);
    when(response2.getOutputStream()).thenThrow(new IOException("foo"));
    CharResponseWrapper response3 = new CharResponseWrapper(
        new HttpServletResponseWrapper(new CharResponseWrapper(response2)));

    CharResponseWrapper charResponseWrapper = new CharResponseWrapper(response);
    charResponseWrapper.setResponse(response3);

    // Act and Assert
    assertThrows(IOException.class, () -> charResponseWrapper.getWriter());
    verify(response2).getOutputStream();
  }

  /**
   * Test {@link CharResponseWrapper#getByteSize()}.
   * <p>
   * Method under test: {@link CharResponseWrapper#getByteSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CharResponseWrapper.getByteSize()"})
  public void testGetByteSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new CharResponseWrapper(new MockHttpServletResponse())).getByteSize());
  }
}
