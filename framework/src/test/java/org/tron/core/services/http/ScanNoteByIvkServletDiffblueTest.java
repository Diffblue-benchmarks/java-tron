package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.DecryptNotes;

public class ScanNoteByIvkServletDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_given0x_whenMockHttpServletRequestAddParameterIvkAnd0x()
      throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "0x");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code ivk}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenIvk_whenMockHttpServletRequestAddParameterIvkAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "42");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Util#VISIBLE}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenVisible() throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ScanNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScanNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    ScanNoteByIvkServlet scanNoteByIvkServlet = new ScanNoteByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }
}
