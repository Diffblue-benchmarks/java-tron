package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ArrayByteBufferPool;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetPendingSizeServletDiffblueTest {
  @InjectMocks
  private GetPendingSizeServlet getPendingSizeServlet;

  @Mock
  private Manager manager;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getPendingSizeServlet.doGet(request, response2);

    // Assert
    verify(manager).getPendingSize();
    assertEquals(19, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet2() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet3() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet4() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
    LocalConnector connector = mock(LocalConnector.class);
    when(connector.getByteBufferPool()).thenReturn(new ArrayByteBufferPool());
    when(connector.getHttpChannelListeners()).thenReturn(new HttpChannel.TransientListeners());
    when(connector.getServer()).thenReturn(new Server());
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(1);
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint("Input", 3), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);

    // Act
    getPendingSizeServlet.doGet(request, new CharResponseWrapper(response));

    // Assert
    verify(connector, atLeast(1)).getByteBufferPool();
    verify(connector).getHttpChannelListeners();
    verify(connector, atLeast(1)).getServer();
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet5() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doGet(request, response);

    // Assert
    verify(manager).getPendingSize();
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(19L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getPendingSizeServlet.doPost(request, response2);

    // Assert
    verify(manager).getPendingSize();
    assertEquals(19, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost2() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doPost(request, new CharResponseWrapper(response));

    // Assert
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost3() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doPost(request, new CharResponseWrapper(response));

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost4() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
    LocalConnector connector = mock(LocalConnector.class);
    when(connector.getByteBufferPool()).thenReturn(new ArrayByteBufferPool());
    when(connector.getHttpChannelListeners()).thenReturn(new HttpChannel.TransientListeners());
    when(connector.getServer()).thenReturn(new Server());
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(1);
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint("Input", 3), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);

    // Act
    getPendingSizeServlet.doPost(request, new CharResponseWrapper(response));

    // Assert
    verify(connector, atLeast(1)).getByteBufferPool();
    verify(connector).getHttpChannelListeners();
    verify(connector, atLeast(1)).getServer();
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link GetPendingSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost5() throws IOException {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    getPendingSizeServlet.doPost(request, response);

    // Assert
    verify(manager).getPendingSize();
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(19L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }
}
