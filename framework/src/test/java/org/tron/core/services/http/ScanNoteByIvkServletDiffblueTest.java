package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashMap;
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
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.ResponseWriter;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.DecryptNotes;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class ScanNoteByIvkServletDiffblueTest {
  @InjectMocks private ScanNoteByIvkServlet scanNoteByIvkServlet;

  /**
   * Test {@link ScanNoteByIvkServlet#convertOutput(DecryptNotes, boolean)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then calls {@link GrpcAPI.DecryptNotes#getAllFields()}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#convertOutput(GrpcAPI.DecryptNotes, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ScanNoteByIvkServlet.convertOutput(GrpcAPI.DecryptNotes, boolean)"})
  public void testConvertOutput_givenZero_thenCallsGetAllFields() {
    // Arrange
    DecryptNotes notes = mock(DecryptNotes.class);
    when(notes.getNoteTxsCount()).thenReturn(0);
    when(notes.getAllFields()).thenReturn(new HashMap<>());

    // Act
    String actualConvertOutputResult = ScanNoteByIvkServlet.convertOutput(notes, true);

    // Assert
    verify(notes).getAllFields();
    verify(notes).getNoteTxsCount();
    assertEquals("{}", actualConvertOutputResult);
  }

  /**
   * Test {@link ScanNoteByIvkServlet#convertOutput(DecryptNotes, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#convertOutput(GrpcAPI.DecryptNotes, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ScanNoteByIvkServlet.convertOutput(GrpcAPI.DecryptNotes, boolean)"})
  public void testConvertOutput_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertEquals("{}", ScanNoteByIvkServlet.convertOutput(DecryptNotes.getDefaultInstance(), true));
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    scanNoteByIvkServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(95, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(95, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    scanNoteByIvkServlet.doPost(null, response);

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
   * Test {@link ScanNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost3() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(new BufferedReader(new StringReader("foo"), 1));
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");

    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    response.setCharacterEncoding("https://example.org/example");
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    scanNoteByIvkServlet.doPost(request, response3);

    // Assert that nothing has changed
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
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
    assertEquals(0, ((CharResponseWrapper) response6).getByteSize());
    assertArrayEquals(new byte[] {}, ((MockHttpServletResponse) response7).getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost4() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(null);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("Name", "42");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    scanNoteByIvkServlet.doPost(request, response3);

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
   * Test {@link ScanNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletRequest#MockHttpServletRequest()} Reader lines collect joining
   *       lf is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletRequestReaderLinesCollectJoiningLfIsEmptyString()
      throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    scanNoteByIvkServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(95, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(95, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(57, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    scanNoteByIvkServlet.doGet(null, response);

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
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
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
    scanNoteByIvkServlet.doGet(request, response2);

    // Assert
    verify(request).addParameter("Name", "42");
    verify(request).getParameter("start_block_index");
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(102L, httpOutput.getWritten());
    assertEquals(102L, ((Response) response3).getContentCount());
    assertEquals(32768, httpOutput.getBufferSize());
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
