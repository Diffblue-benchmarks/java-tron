package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
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
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.Container;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletResponse;

public class CharResponseWrapperDiffblueTest {
  /**
   * Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  public void testGetOutputStream() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream = (new CharResponseWrapper(new MockHttpServletResponse())).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  public void testGetOutputStream2() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream = (new CharResponseWrapper(
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())))).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  public void testGetWriter() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(new ServletOutputStreamCopy(new ByteArrayOutputStream(1)));

    // Act
    (new CharResponseWrapper(response)).getWriter();

    // Assert
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
  }

  /**
   * Method under test: {@link CharResponseWrapper#getWriter()}
   */
  @Test
  public void testGetWriter2() throws IOException {
    // Arrange
    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new CharResponseWrapper(response)).getWriter());
    verify(response).getOutputStream();
  }

  /**
   * Method under test: {@link CharResponseWrapper#flushBuffer()}
   */
  @Test
  public void testFlushBuffer() throws IOException {
    // Arrange
    Container.Listener listener = mock(Container.Listener.class);
    doNothing().when(listener).beanAdded(Mockito.<Container>any(), Mockito.<Object>any());

    Server server = new Server();
    server.addEventListener(listener);
    LocalConnector connector = new LocalConnector(server);
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

    // Act
    (new CharResponseWrapper(new Response(channel,
        new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
            new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))))))
                .flushBuffer();

    // Assert that nothing has changed
    verify(listener).beanAdded(isA(Container.class), isA(Object.class));
  }

  /**
   * Method under test: {@link CharResponseWrapper#getByteSize()}
   */
  @Test
  public void testGetByteSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new CharResponseWrapper(new MockHttpServletResponse())).getByteSize());
  }

  /**
   * Method under test: {@link CharResponseWrapper#getByteSize()}
   */
  @Test
  public void testGetByteSize2() throws IOException {
    // Arrange
    Container.Listener listener = mock(Container.Listener.class);
    doNothing().when(listener).beanAdded(Mockito.<Container>any(), Mockito.<Object>any());

    Server server = new Server();
    server.addEventListener(listener);
    LocalConnector connector = new LocalConnector(server);
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

    // Act
    int actualByteSize = (new CharResponseWrapper(new Response(channel,
        new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
            new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))))))
                .getByteSize();

    // Assert
    verify(listener).beanAdded(isA(Container.class), isA(Object.class));
    assertEquals(0, actualByteSize);
  }

  /**
   * Method under test:
   * {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}
   */
  @Test
  public void testNewCharResponseWrapper() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertSame(response, (new CharResponseWrapper(response)).getResponse());
  }
}
