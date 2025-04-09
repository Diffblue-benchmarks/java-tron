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
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ArrayByteBufferPool;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.AbstractConnector;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpChannel.TransientListeners;
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
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionListFromPendingServletDiffblueTest {
  @InjectMocks
  private GetTransactionListFromPendingServlet getTransactionListFromPendingServlet;

  @Mock
  private Manager manager;

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(3, response.getByteSize());
    byte[] expectedContentAsByteArray = "{}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"txId\":[\"visible\"]}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(21, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"txId\":[\"visible\"]}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"txId\":[\"{\",\"visible\"]}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(25, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"txId\":[\"{\",\"visible\"]}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet4() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(null, response);

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
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(3, response.getByteSize());
    byte[] expectedContentAsByteArray = "{}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet6() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
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
    CharResponseWrapper response = new CharResponseWrapper(
        new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
            new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)))));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(((Response) response2).getHttpChannel().getHttpTransport() instanceof HttpConnection);
    assertTrue(response2 instanceof Response);
    HttpOutput httpOutput = ((Response) response2).getHttpOutput();
    ByteBuffer buffer = httpOutput.getBuffer();
    assertEquals(3, buffer.limit());
    assertEquals(3L, httpOutput.getWritten());
    assertEquals(3L, ((Response) response2).getContentCount());
    assertTrue(buffer.hasRemaining());
    assertTrue(httpOutput.isWritten());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet7() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert that nothing has changed
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet8() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
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
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    assertTrue(response.getHttpChannel().getHttpTransport() instanceof HttpConnection);
    assertTrue(response.getWriter() instanceof ResponseWriter);
    HttpOutput httpOutput = response.getHttpOutput();
    ByteBuffer buffer = httpOutput.getBuffer();
    assertEquals(3, buffer.limit());
    assertEquals(3L, httpOutput.getWritten());
    assertEquals(3L, response.getContentCount());
    assertFalse(response.isStreaming());
    assertTrue(buffer.hasRemaining());
    assertTrue(httpOutput.isWritten());
    assertTrue(response.isWriting());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenColon() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(" : ");
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert that nothing has changed
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenEmptyString() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(request).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(3, response.getByteSize());
    byte[] expectedContentAsByteArray = "{}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Response} {@link Response#getCharacterEncoding()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenFoo_whenResponseGetCharacterEncodingReturnFoo() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("foo");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert that nothing has changed
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link AbstractConnector#getByteBufferPool()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenCallsGetByteBufferPool() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    LocalConnector connector = mock(LocalConnector.class);
    when(connector.getByteBufferPool()).thenReturn(new ArrayByteBufferPool());
    when(connector.getHttpChannelListeners()).thenReturn(new TransientListeners());
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert that nothing has changed
    verify(connector, atLeast(1)).getByteBufferPool();
    verify(connector).getHttpChannelListeners();
    verify(connector, atLeast(1)).getServer();
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    verify(request, atLeast(1)).getParameter(eq("visible"));
    verify(manager).getTxListFromPending();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(3, response.getByteSize());
    byte[] expectedContentAsByteArray = "{}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{\"txId\":[\"{\"]}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(15, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"txId\":[\"{\"]}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost3() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{\"txId\":[\"\\\"\",\"{\"]}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(20, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"txId\":[\"\\\"\",\"{\"]}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost4() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doPost(null, response);

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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost5() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("\\\"");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("{\"txId\":[\"\\\"\",\"\\\\\\\"\"]}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(23, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"txId\":[\"\\\"\",\"\\\\\\\"\"]}\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost6() throws IOException {
    // Arrange
    MockHttpServletResponse response = mock(MockHttpServletResponse.class);
    when(response.getCharacterEncoding()).thenReturn("https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doPost(null, response2);

    // Assert that nothing has changed
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost7() throws IOException {
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
    Response response = new Response(channel, new HttpOutput(new HttpChannel(connector3, configuration2, endPoint2,
        new HttpConnection(config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));

    // Act
    getTransactionListFromPendingServlet.doPost(null, response);

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
