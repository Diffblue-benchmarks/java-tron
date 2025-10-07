package org.tron.core.services.http.solidity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.Wallet;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionByIdSolidityServletDiffblueTest {
  @InjectMocks private GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet;

  @Mock private Wallet wallet;

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "exception decoding Hex string: invalid characters encountered in Hex string\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(76, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(76, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response3);

    // Assert that nothing has changed
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link DefaultMultipartHttpServletRequest} {@link
   *       DefaultMultipartHttpServletRequest#getParameter(String)} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_given42_whenDefaultMultipartHttpServletRequestGetParameterReturn42()
      throws IOException {
    // Arrange
    when(wallet.getTransactionById(Mockito.<ByteString>any())).thenThrow(new RuntimeException());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    verify(response).getWriter();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getTransactionById(isA(ByteString.class));
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString() throws IOException {
    // Arrange
    when(wallet.getTransactionById(Mockito.<ByteString>any())).thenThrow(new RuntimeException());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    verify(response).getWriter();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getTransactionById(isA(ByteString.class));
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenRuntimeException_thenThrowRuntimeException() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getWriter()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            getTransactionByIdSolidityServlet.doGet(
                request, new HttpServletResponseWrapper(response)));
    verify(response).getWriter();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    HttpConnection transport2 =
        new HttpConnection(
            config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel2 = new HttpChannel(connector3, configuration2, endPoint2, transport2);
    Response response = new Response(channel, new HttpOutput(channel2));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(76L, httpOutput.getWritten());
    assertEquals(76L, ((Response) response3).getContentCount());
    assertFalse(httpOutput.isAsync());
    assertFalse(httpOutput.isClosed());
    assertFalse(((Response) response3).isStreaming());
    assertTrue(httpOutput.isWritten());
    assertTrue(((Response) response3).isWriting());
    assertSame(channel2, httpOutput.getHttpChannel());
    assertSame(channel2, httpOutput.getInterceptor());
    assertSame(writer, response3.getWriter());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When createRequest {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenCreateRequestHttpsExampleOrgExample() throws IOException {
    // Arrange
    when(wallet.getTransactionById(Mockito.<ByteString>any())).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    verify(wallet).getTransactionById(isA(ByteString.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("null\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(5, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "null\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenNull() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doGet(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("null\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(5, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "null\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "1:1: Expected \"{\".\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(19, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "1:1: Expected \"{\".\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("null\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(5, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "null\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link Response#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_givenIOException_thenCallsGetWriter() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenThrow(new RuntimeException());
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");

    Response response = mock(Response.class);
    when(response.getWriter()).thenThrow(new IOException());

    // Act
    getTransactionByIdSolidityServlet.doPost(request, new HttpServletResponseWrapper(response));

    // Assert
    verify(response).getWriter();
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenThrow(new RuntimeException());
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    HttpConnection transport2 =
        new HttpConnection(
            config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel2 = new HttpChannel(connector3, configuration2, endPoint2, transport2);
    Response response = new Response(channel, new HttpOutput(channel2));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    getTransactionByIdSolidityServlet.doPost(request, response2);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(5L, httpOutput.getWritten());
    assertEquals(5L, ((Response) response3).getContentCount());
    assertFalse(httpOutput.isAsync());
    assertFalse(httpOutput.isClosed());
    assertFalse(((Response) response3).isStreaming());
    assertTrue(httpOutput.isWritten());
    assertTrue(((Response) response3).isWriting());
    assertSame(channel2, httpOutput.getHttpChannel());
    assertSame(channel2, httpOutput.getInterceptor());
    assertSame(writer, response3.getWriter());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletRequest#MockHttpServletRequest()} Reader lines collect joining
   *       lf is empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenMockHttpServletRequestReaderLinesCollectJoiningLfIsEmptyString()
      throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionByIdSolidityServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "1:1: Expected \"{\".\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(19, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "1:1: Expected \"{\".\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }
}
