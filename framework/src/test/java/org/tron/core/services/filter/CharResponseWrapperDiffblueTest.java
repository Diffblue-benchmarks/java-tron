package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CharResponseWrapperDiffblueTest {
  @InjectMocks private CharResponseWrapper charResponseWrapper;

  @Mock private HttpServletResponse httpServletResponse;

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
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertSame(response, new CharResponseWrapper(response).getResponse());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   *
   * <ul>
   *   <li>Then return {@link ServletOutputStreamCopy}.
   * </ul>
   *
   * <p>Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream_thenReturnServletOutputStreamCopy() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream =
        new CharResponseWrapper(new MockHttpServletResponse()).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream_thenThrowIllegalStateException() throws IOException {
    // Arrange
    when(httpServletResponse.getOutputStream()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> charResponseWrapper.getOutputStream());
    verify(httpServletResponse).getOutputStream();
  }

  /**
   * Test {@link CharResponseWrapper#getWriter()}.
   *
   * <ul>
   *   <li>Then calls {@link HttpServletResponse#getCharacterEncoding()}.
   * </ul>
   *
   * <p>Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.PrintWriter CharResponseWrapper.getWriter()"})
  public void testGetWriter_thenCallsGetCharacterEncoding() throws IOException {
    // Arrange
    when(httpServletResponse.getCharacterEncoding()).thenReturn("UTF-8");
    when(httpServletResponse.getOutputStream())
        .thenReturn(new ServletOutputStreamCopy(new ByteArrayOutputStream()));

    // Act
    charResponseWrapper.getWriter();

    // Assert
    verify(httpServletResponse).getCharacterEncoding();
    verify(httpServletResponse).getOutputStream();
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
    when(httpServletResponse.getOutputStream()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> charResponseWrapper.getWriter());
    verify(httpServletResponse).getOutputStream();
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
    assertEquals(0, new CharResponseWrapper(new MockHttpServletResponse()).getByteSize());
  }
}
