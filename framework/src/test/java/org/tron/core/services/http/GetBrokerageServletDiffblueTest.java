package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
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
import java.io.PrintWriter;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.bouncycastle.util.encoders.DecoderException;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetBrokerageServletDiffblueTest {
  @InjectMocks private GetBrokerageServlet getBrokerageServlet;

  @Mock private Manager manager;

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(52, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(request).getMethod();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\": \"INVALID address, null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(35, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenManagerGetDynamicPropertiesStoreReturnNull() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
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
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenManagerGetDynamicPropertiesStoreThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\": \"INVALID address, null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(35, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link DecoderException#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenCallsGetMessage() throws IOException {
    // Arrange
    DecoderException decoderException = mock(DecoderException.class);
    when(decoderException.getMessage()).thenThrow(new IllegalArgumentException());
    when(manager.getDynamicPropertiesStore()).thenThrow(decoderException);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            getBrokerageServlet.doGet(
                request,
                new HttpServletResponseWrapper(
                    new CharResponseWrapper(new MockHttpServletResponse()))));
    verify(decoderException).getMessage();
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link Response#getOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenCallsGetOutputStream() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IllegalArgumentException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> getBrokerageServlet.doGet(request, new HttpServletResponseWrapper(response2)));
    verify(request).getMethod();
    verify(response).getOutputStream();
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());
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
    getBrokerageServlet.doGet(request, response2);

    // Assert
    verify(request).getMethod();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(35L, httpOutput.getWritten());
    assertEquals(35L, ((Response) response3).getContentCount());
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
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockMultipartHttpServletRequest#MockMultipartHttpServletRequest()}.
   *   <li>Then calls {@link DecoderException#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockMultipartHttpServletRequest_thenCallsGetMessage()
      throws IOException {
    // Arrange
    DecoderException decoderException = mock(DecoderException.class);
    when(decoderException.getMessage()).thenThrow(new IllegalArgumentException());
    when(manager.getDynamicPropertiesStore()).thenThrow(decoderException);
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            getBrokerageServlet.doGet(
                request,
                new HttpServletResponseWrapper(
                    new CharResponseWrapper(new MockHttpServletResponse()))));
    verify(decoderException).getMessage();
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenNull() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doGet(null, response);

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
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
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
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(52, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(request).getMethod();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\": \"INVALID address, null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(35, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenManagerGetDynamicPropertiesStoreThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\": \"INVALID address, null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(35, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());
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
    getBrokerageServlet.doPost(request, response2);

    // Assert
    verify(request).getMethod();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(35L, httpOutput.getWritten());
    assertEquals(35L, ((Response) response3).getContentCount());
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
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new IllegalArgumentException());

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IllegalArgumentException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> getBrokerageServlet.doPost(request, new HttpServletResponseWrapper(response2)));
    verify(request).getMethod();
    verify(response).getOutputStream();
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockMultipartHttpServletRequest#MockMultipartHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenMockMultipartHttpServletRequest() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
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
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenNull() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBrokerageServlet.doPost(null, response);

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
}
