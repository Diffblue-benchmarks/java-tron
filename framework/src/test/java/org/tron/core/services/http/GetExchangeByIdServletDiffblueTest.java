package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.core.Wallet;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.ratelimiter.RateLimiterContainer;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class GetExchangeByIdServletDiffblueTest {
  @InjectMocks
  private GetExchangeByIdServlet getExchangeByIdServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private Wallet wallet;

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doPost(request, response2);

    // Assert
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doPost(null, response2);

    // Assert
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost3() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doPost(null, response2);

    // Assert
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    assertEquals(56, response2.getByteSize());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost4() throws IOException {
    // Arrange
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
    HttpOutput out = new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = new Response(channel, out);

    // Act
    getExchangeByIdServlet.doPost(null, response);

    // Assert
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(56L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    assertEquals(57, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet2() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(null, response2);

    // Assert
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertEquals(102, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet4() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(" : ");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertEquals(78, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet5() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(Protocol.Exchange.getDefaultInstance());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
    assertEquals(3, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet6() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(null);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet7() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getExchangeByIdServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertEquals(75, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet8() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("foo");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getExchangeByIdServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet9() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(Protocol.Exchange.getDefaultInstance());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(1);
    LocalConnector connector = new LocalConnector(new Server());
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);

    // Act
    getExchangeByIdServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet10() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(Protocol.Exchange.getDefaultInstance());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(1);
    LocalConnector connector = new LocalConnector(new Server());
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(Util.VISIBLE, 3), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);

    // Act
    getExchangeByIdServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet11() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(Protocol.Exchange.getDefaultInstance());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
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
    HttpOutput out = new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = new Response(channel, out);

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(3L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test:
   * {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet12() throws IOException {
    // Arrange
    when(wallet.getExchangeById(Mockito.<ByteString>any())).thenReturn(null);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(1);
    LocalConnector connector = new LocalConnector(new Server());
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(Util.VISIBLE, 3), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);

    // Act
    getExchangeByIdServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(wallet).getExchangeById(isA(ByteString.class));
  }
}
