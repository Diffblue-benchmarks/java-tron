package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionApprovedListServletDiffblueTest {
  @InjectMocks private GetTransactionApprovedListServlet getTransactionApprovedListServlet;

  /**
   * Test {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionApprovedListServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionApprovedListServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionApprovedListServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionApprovedListServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(56, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionApprovedListServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost3() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(new BufferedReader(new StringReader("foo"), 1));
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getTransactionApprovedListServlet.doPost(request, response3);

    // Assert that nothing has changed
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
    ServletResponse response4 = response3.getResponse();
    ServletResponse response5 = ((CharResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((CharResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertTrue(response4 instanceof CharResponseWrapper);
    assertTrue(response6 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
    assertEquals(0, ((CharResponseWrapper) response6).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response7).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionApprovedListServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionApprovedListServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost4() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(null);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getTransactionApprovedListServlet.doPost(request, response3);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
    ServletResponse response4 = response3.getResponse();
    ServletResponse response5 = ((CharResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((CharResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertTrue(response4 instanceof CharResponseWrapper);
    assertTrue(response6 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response7).getContentAsString());
    assertEquals(56, ((CharResponseWrapper) response6).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response7).getContentAsByteArray());
  }
}
