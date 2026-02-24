package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
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
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.Wallet;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetBandwidthPricesServletDiffblueTest {
  @InjectMocks private GetBandwidthPricesServlet getBandwidthPricesServlet;

  @Mock private Wallet wallet;

  /**
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws IOException {
    // Arrange
    when(wallet.getBandwidthPrices()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBandwidthPricesServlet.doGet(request, response);

    // Assert
    verify(wallet).getBandwidthPrices();
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
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenRuntimeException_thenThrowRuntimeException() throws IOException {
    // Arrange
    when(wallet.getBandwidthPrices()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new RuntimeException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> getBandwidthPricesServlet.doGet(request, new HttpServletResponseWrapper(response2)));
    verify(response).getOutputStream();
    verify(wallet).getBandwidthPrices();
  }

  /**
   * Test {@link GetBandwidthPricesServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBandwidthPricesServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBandwidthPricesServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    when(wallet.getBandwidthPrices()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
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
    getBandwidthPricesServlet.doGet(request, response2);

    // Assert
    verify(wallet).getBandwidthPrices();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(52L, httpOutput.getWritten());
    assertEquals(52L, ((Response) response3).getContentCount());
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
   * Test {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBandwidthPricesServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBandwidthPricesServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getBandwidthPricesServlet.doPost(request, response);

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
   * Test {@link GetBandwidthPricesServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetBandwidthPricesServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBandwidthPricesServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    GetBandwidthPricesServlet getBandwidthPricesServlet = new GetBandwidthPricesServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
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
    getBandwidthPricesServlet.doPost(request, response2);

    // Assert
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(56L, httpOutput.getWritten());
    assertEquals(56L, ((Response) response3).getContentCount());
    assertFalse(httpOutput.isAsync());
    assertFalse(httpOutput.isClosed());
    assertFalse(((Response) response3).isStreaming());
    assertTrue(httpOutput.isWritten());
    assertTrue(((Response) response3).isWriting());
    assertSame(channel2, httpOutput.getHttpChannel());
    assertSame(channel2, httpOutput.getInterceptor());
    assertSame(writer, response3.getWriter());
  }
}
