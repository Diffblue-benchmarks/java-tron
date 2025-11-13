package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ScanAndMarkNoteByIvkServletDiffblueTest {
  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_given0x_whenMockHttpServletRequestAddParameterIvkAnd0x()
      throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "0x");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code ak}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ak} and
   *       {@code end_block_index}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenAk_whenMockHttpServletRequestAddParameterAkAndEndBlockIndex()
      throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ak", "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code ivk}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenIvk_whenMockHttpServletRequestAddParameterIvkAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "42");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code nk}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code nk} and
   *       {@code end_block_index}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNk_whenMockHttpServletRequestAddParameterNkAndEndBlockIndex()
      throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("nk", "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Util#VISIBLE}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenVisible() throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code end_block_index}.
   * </ul>
   *
   * <p>Method under test: {@link ScanAndMarkNoteByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanAndMarkNoteByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterIvkAndEndBlockIndex()
      throws UnsupportedEncodingException {
    // Arrange
    ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "end_block_index");
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanAndMarkNoteByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }
}
