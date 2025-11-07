package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetBurnTrxServletDiffblueTest {
  @InjectMocks
  private GetBurnTrxServlet getBurnTrxServlet;

  @Mock
  private Manager manager;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  /**
   * Method under test:
   * {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getBurnTrxServlet.doGet(request, response2);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet2() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
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
    getBurnTrxServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(56L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }

  /**
   * Method under test:
   * {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getBurnTrxServlet.doPost(request, response2);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals(56, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost2() throws IOException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
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
    getBurnTrxServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertTrue(response.getWriter() instanceof ResponseWriter);
    assertEquals(56L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(response.isWriting());
    assertSame(channel, response.getHttpChannel());
    assertSame(out, response.getHttpOutput());
  }
}
