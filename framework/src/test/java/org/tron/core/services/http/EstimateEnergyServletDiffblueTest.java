package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class EstimateEnergyServletDiffblueTest {
  @InjectMocks
  private EstimateEnergyServlet estimateEnergyServlet;

  /**
   * Test {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link FileReader#FileReader(FileDescriptor)} with {@link FileDescriptor#FileDescriptor()}.</li>
   *   <li>Then calls {@link HttpServletResponseWrapper#addDateHeader(String, long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EstimateEnergyServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenFileReaderWithFileDescriptor_thenCallsAddDateHeader() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(new BufferedReader(new FileReader(new FileDescriptor()), 1));
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
    ContentCachingResponseWrapper response = mock(ContentCachingResponseWrapper.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
    doNothing().when(response).addDateHeader(Mockito.<String>any(), anyLong());
    response.addDateHeader("'", 1L);

    // Act
    estimateEnergyServlet.doPost(request, response);

    // Assert
    verify(response).addDateHeader(eq("'"), eq(1L));
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getReader();
    verify(response).getWriter();
  }

  /**
   * Test {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MockHttpServletRequest} {@link MockHttpServletRequest#getReader()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EstimateEnergyServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenNull_whenMockHttpServletRequestGetReaderReturnNull() throws IOException {
    // Arrange
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getReader()).thenReturn(null);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    estimateEnergyServlet.doPost(request, response);

    // Assert
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getReader();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"result\": {\"code\": \"OTHER_ERROR\",\"message\": \"636c617373206a6176612e6c616e672e4e756c6c506f696e746572"
            + "457863657074696f6e203a206e756c6c\"}}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(136, response.getByteSize());
    assertEquals(136, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletRequest#MockHttpServletRequest()} Reader lines collect joining lf is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EstimateEnergyServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletRequestReaderLinesCollectJoiningLfIsEmptyString() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    estimateEnergyServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"result\": {\"code\": \"OTHER_ERROR\",\"message\": \"636c617373206a6176612e6c616e672e4e756c6c506f696e746572"
            + "457863657074696f6e203a206e756c6c\"}}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(136, response.getByteSize());
    assertEquals(136, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EstimateEnergyServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EstimateEnergyServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenNull() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    estimateEnergyServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"result\": {\"code\": \"OTHER_ERROR\",\"message\": \"636c617373206a6176612e6c616e672e4e756c6c506f696e746572"
            + "457863657074696f6e203a206e756c6c\"}}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(136, response.getByteSize());
    assertEquals(136, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }
}
