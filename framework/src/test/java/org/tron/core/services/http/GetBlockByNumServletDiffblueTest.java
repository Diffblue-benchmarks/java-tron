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

public class GetBlockByNumServletDiffblueTest {
  /**
   * Test {@link GetBlockByNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code num} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_given42_whenMockHttpServletRequestAddParameterNumAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("num", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code num}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_given42_whenMockHttpServletRequestAddParameterVisibleAndNum()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "num");
    request.addParameter("num", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Error}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenError() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Error", "https://example.org/example");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNotBlank_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("num", "https://example.org/example");
    request.addParameter(Util.VISIBLE, "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockByNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByNumServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockByNumServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockByNumServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByNumServlet getBlockByNumServlet = new GetBlockByNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByNumServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
