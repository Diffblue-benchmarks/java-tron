package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetRewardServletDiffblueTest {
  @InjectMocks
  private GetRewardServlet getRewardServlet;

  @Mock
  private Manager manager;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(request, response2);

    // Assert
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(null, response2);

    // Assert
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(request, response2);

    // Assert
    verify(request).getMethod();
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet4() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream())
        .thenReturn(new DelegatingServletInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(101, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet5() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream()).thenThrow(new IllegalArgumentException("address"));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(38, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet6() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream()).thenReturn(new DelegatingServletInputStream(new ByteArrayInputStream(new byte[]{})));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doGet(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(request, response2);

    // Assert
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(null, response2);

    // Assert
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(request, response2);

    // Assert
    verify(request).getMethod();
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost4() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream())
        .thenReturn(new DelegatingServletInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(101, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost5() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream()).thenThrow(new IllegalArgumentException("address"));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(38, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetRewardServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost6() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getInputStream()).thenReturn(new DelegatingServletInputStream(new ByteArrayInputStream(new byte[]{})));
    when(request.getContentType()).thenReturn("text/plain");
    when(request.getMethod()).thenReturn("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getRewardServlet.doPost(request, response2);

    // Assert
    verify(request).getContentType();
    verify(request).getInputStream();
    verify(request).getMethod();
    assertEquals(14, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }
}
