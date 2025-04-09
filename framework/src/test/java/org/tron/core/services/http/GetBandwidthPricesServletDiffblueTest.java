package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.services.filter.CharResponseWrapper;

public class GetBandwidthPricesServletDiffblueTest {
  /**
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBandwidthPricesServlet.doGet(request, response);

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
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
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
    CharResponseWrapper response = new CharResponseWrapper(
        new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
            new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)))));

    // Act
    getBandwidthPricesServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(((Response) response2).getHttpChannel().getHttpTransport() instanceof HttpConnection);
    assertTrue(response2 instanceof Response);
    HttpOutput httpOutput = ((Response) response2).getHttpOutput();
    ByteBuffer buffer = httpOutput.getBuffer();
    assertEquals(56, buffer.limit());
    assertEquals(56L, httpOutput.getWritten());
    assertEquals(56L, ((Response) response2).getContentCount());
    assertTrue(buffer.hasRemaining());
    assertTrue(httpOutput.isWritten());
  }

  /**
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
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
    Response response = new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getBandwidthPricesServlet.doGet(request, response);

    // Assert
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
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)} with request is {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenHttpServletRequestWrapperWithRequestIsMockHttpServletRequest() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBandwidthPricesServlet.doGet(request, response);

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
   * Test {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBandwidthPricesServlet.doPost(request, response);

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
   * Test {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBandwidthPricesServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
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
    Response response = new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getBandwidthPricesServlet.doPost(request, response);

    // Assert
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
}
