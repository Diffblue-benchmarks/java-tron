package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
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
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.BlockReq;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.Wallet;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetBlockServletDiffblueTest {
  @InjectMocks private GetBlockServlet getBlockServlet;

  @Mock private Wallet wallet;

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(HttpMethed.createRequest("https://example.org/example"));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(null, response);

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
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(3, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{}\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet4() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new UnsupportedOperationException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(0, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(0, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link
   *       SerializeWriter#SerializeWriter()}.
   *   <li>Then calls {@link Response#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenPrintWriterWithSerializeWriter_thenCallsGetWriter()
      throws IOException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new SerializeWriter()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    verify(response).getWriter();
    verify(request).addParameter("Name", "42");
    verify(request).getMethod();
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlock(BlockReq)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenWalletGetBlockThrowUnsupportedOperationException() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new UnsupportedOperationException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
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
    getBlockServlet.doGet(request, response2);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getMethod();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(65L, httpOutput.getWritten());
    assertEquals(65L, ((Response) response3).getContentCount());
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
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When createRequest {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenCreateRequestHttpsExampleOrgExample() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link HttpInput#HttpInput(HttpChannelState)} with state is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenHttpInputWithStateIsNull() throws IOException {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    Request request = new Request(channel, new HttpInput(null));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

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
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(null, response);

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
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new UnsupportedOperationException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost3() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(3, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{}\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost4() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new UnsupportedOperationException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(0, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost5() throws IOException {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    verify(wallet).getBlock(isA(BlockReq.class));
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(0, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link
   *       SerializeWriter#SerializeWriter()}.
   *   <li>Then calls {@link Response#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenPrintWriterWithSerializeWriter_thenCallsGetWriter()
      throws IOException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new SerializeWriter()));

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    verify(response).getWriter();
    verify(request).addParameter("Name", "42");
    verify(request).getMethod();
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
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
    getBlockServlet.doPost(request, response2);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getMethod();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(65L, httpOutput.getWritten());
    assertEquals(65L, ((Response) response3).getContentCount());
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
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When createRequest {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenCreateRequestHttpsExampleOrgExample() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link HttpInput#HttpInput(HttpChannelState)} with state is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenHttpInputWithStateIsNull() throws IOException {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    Request request = new Request(channel, new HttpInput(null));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(request, response);

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
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenMockHttpServletRequest() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(65, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }
}
