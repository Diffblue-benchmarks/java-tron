package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.ResponseWriter;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.core.services.filter.CharResponseWrapper;

public class GetAssetIssueListServletDiffblueTest {
  /**
   * Test {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());
    Response response = new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getAssetIssueListServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    assertTrue(response.getHttpChannel().getHttpTransport() instanceof HttpConnection);
    assertTrue(response.getWriter() instanceof ResponseWriter);
    HttpOutput httpOutput = response.getHttpOutput();
    ByteBuffer buffer = httpOutput.getBuffer();
    assertEquals(56, buffer.limit());
    assertEquals(56L, httpOutput.getWritten());
    assertEquals(56L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(buffer.hasRemaining());
    assertTrue(httpOutput.isWritten());
    assertTrue(response.isWriting());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenCallsGetParameter() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenNull() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doGet(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());
    Response response = new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getAssetIssueListServlet.doPost(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    assertTrue(response.getHttpChannel().getHttpTransport() instanceof HttpConnection);
    assertTrue(response.getWriter() instanceof ResponseWriter);
    HttpOutput httpOutput = response.getHttpOutput();
    ByteBuffer buffer = httpOutput.getBuffer();
    assertEquals(56, buffer.limit());
    assertEquals(56L, httpOutput.getWritten());
    assertEquals(56L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(buffer.hasRemaining());
    assertTrue(httpOutput.isWritten());
    assertTrue(response.isWriting());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenCallsGetParameter() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doPost(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenMockHttpServletRequest() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAssetIssueListServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetAssetIssueListServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenNull() throws IOException {
    // Arrange
    GetAssetIssueListServlet getAssetIssueListServlet = new GetAssetIssueListServlet();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getAssetIssueListServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }
}
