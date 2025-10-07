package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CharResponseWrapper.<init>(HttpServletResponse)"})
  public void testNewCharResponseWrapper() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new MockHttpServletResponse());

    // Act and Assert
    assertSame(response, new CharResponseWrapper(response).getResponse());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   *
   * <p>Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream =
        new CharResponseWrapper(new HttpServletResponseWrapper(new MockHttpServletResponse()))
            .getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   *
   * <p>Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    ServletOutputStream actualOutputStream = new CharResponseWrapper(response2).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getWriter()}.
   *
   * <ul>
   *   <li>Given {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with {@link Response}.
   * </ul>
   *
   * <p>Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.PrintWriter CharResponseWrapper.getWriter()"})
  public void testGetWriter_givenHttpServletResponseWrapperWithResponse() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IllegalStateException());
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new CharResponseWrapper(response2).getWriter());
    verify(response).getOutputStream();
  }

  /**
   * Test {@link CharResponseWrapper#getWriter()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.PrintWriter CharResponseWrapper.getWriter()"})
  public void testGetWriter_thenThrowIllegalStateException() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IllegalStateException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);
    CharResponseWrapper response4 = new CharResponseWrapper(response3);
    HttpServletResponseWrapper response5 = new HttpServletResponseWrapper(response4);

    CharResponseWrapper charResponseWrapper = new CharResponseWrapper(mock(Response.class));
    charResponseWrapper.setResponse(response5);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> charResponseWrapper.getWriter());
    verify(response).getOutputStream();
  }

  /**
   * Test {@link CharResponseWrapper#getByteSize()}.
   *
   * <p>Method under test: {@link CharResponseWrapper#getByteSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CharResponseWrapper.getByteSize()"})
  public void testGetByteSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new CharResponseWrapper(new HttpServletResponseWrapper(new MockHttpServletResponse()))
            .getByteSize());
  }
}
