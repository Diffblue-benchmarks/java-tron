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

public class GetBlockByLatestNumServletDiffblueTest {
  /**
   * Test {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("num", "42");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, " : ");
    request.addParameter("num", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("num", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockByLatestNumServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockByLatestNumServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetBlockByLatestNumServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetBlockByLatestNumServlet getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockByLatestNumServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
