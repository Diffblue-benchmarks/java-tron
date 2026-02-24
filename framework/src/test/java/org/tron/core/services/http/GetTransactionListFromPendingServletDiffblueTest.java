package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
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
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.db.Manager;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionListFromPendingServletDiffblueTest {
  @InjectMocks private GetTransactionListFromPendingServlet getTransactionListFromPendingServlet;

  @Mock private Manager manager;

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("{}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(3, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{}\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
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
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet3() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"txId\":[\"visible\"]}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(21, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"txId\":[\"visible\"]}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet4() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"txId\":[\"{\",\"visible\"]}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(25, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"txId\":[\"{\",\"visible\"]}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet5() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(null, response);

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
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet6() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(request, atLeast(1)).getParameter("visible");
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("{}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(3, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{}\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet7() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());

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
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter("visible");
    verify(manager).getTxListFromPending();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(3L, httpOutput.getWritten());
    assertEquals(3L, ((Response) response3).getContentCount());
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
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet8() throws IOException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

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
    getTransactionListFromPendingServlet.doGet(request, response2);

    // Assert
    verify(request, atLeast(1)).getParameter("visible");
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

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then calls {@link Response#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString_thenCallsGetWriter() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(response).getWriter();
    verify(request).getParameter("visible");
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenRuntimeException_thenThrowRuntimeException() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new RuntimeException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            getTransactionListFromPendingServlet.doGet(
                request, new HttpServletResponseWrapper(response2)));
    verify(response, atLeast(1)).getOutputStream();
    verify(request, atLeast(1)).getParameter("visible");
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("{}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(3, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{}\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost2() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost3() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"txId\":[\"{\"]}\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(15, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"txId\":[\"{\"]}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost4() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"txId\":[\"\\\"\",\"{\"]}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(20, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"txId\":[\"\\\"\",\"{\"]}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost5() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getTransactionListFromPendingServlet.doPost(null, response);

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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost6() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost7() throws IOException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
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
    getTransactionListFromPendingServlet.doPost(request, response2);

    // Assert
    verify(manager).getTxListFromPending();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(3L, httpOutput.getWritten());
    assertEquals(3L, ((Response) response3).getContentCount());
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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost8() throws IOException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

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
    getTransactionListFromPendingServlet.doPost(request, response2);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
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
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost9() throws IOException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getContentType()).thenThrow(new RuntimeException());
    when(request.getReader()).thenReturn(new BufferedReader(new StringReader(""), 1));
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getTransactionListFromPendingServlet.doPost(request, response3);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getContentType();
    verify(request).getReader();
    ServletResponse response4 = response3.getResponse();
    ServletResponse response5 = ((CharResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((CharResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertTrue(response4 instanceof CharResponseWrapper);
    assertTrue(response6 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n",
        ((MockHttpServletResponse) response7).getContentAsString());
    assertEquals(52, ((CharResponseWrapper) response4).getByteSize());
    assertEquals(52, ((CharResponseWrapper) response6).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response7).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost10() throws IOException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(null);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getTransactionListFromPendingServlet.doPost(request, response3);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getReader();
    ServletResponse response4 = response3.getResponse();
    ServletResponse response5 = ((CharResponseWrapper) response4).getResponse();
    assertTrue(response5 instanceof HttpServletResponseWrapper);
    ServletResponse response6 = ((HttpServletResponseWrapper) response5).getResponse();
    ServletResponse response7 = ((CharResponseWrapper) response6).getResponse();
    assertTrue(response7 instanceof MockHttpServletResponse);
    assertTrue(response4 instanceof CharResponseWrapper);
    assertTrue(response6 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response7).getContentAsString());
    assertEquals(56, ((CharResponseWrapper) response6).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response7).getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getReader()}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_givenStringReaderWithFoo_thenCallsGetReader() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getReader()).thenReturn(new BufferedReader(new StringReader("foo"), 1));

    Response response = mock(Response.class);
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    when(response.getWriter()).thenReturn(printWriter);
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doPost(request, response2);

    // Assert that nothing has changed
    verify(request).getReader();
    verify(response).getWriter();
    assertSame(printWriter, response2.getWriter());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link Request#Request(HttpChannel, HttpInput)} with channel is {@link
   *       HttpChannel#HttpChannel(Connector, HttpConfiguration, EndPoint, HttpTransport)} and input
   *       is {@link HttpInput#HttpInput(HttpChannelState)} InputState is two.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenRequestWithChannelIsHttpChannelAndInputIsHttpInputInputStateIsTwo()
      throws IOException {
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

    Response response = mock(Response.class);
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    when(response.getWriter()).thenReturn(printWriter);
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    getTransactionListFromPendingServlet.doPost(request, response2);

    // Assert
    verify(response).getWriter();
    assertEquals(2, request.getInputState());
    assertFalse(request.getReader().ready());
    assertSame(printWriter, response2.getWriter());
  }
}
