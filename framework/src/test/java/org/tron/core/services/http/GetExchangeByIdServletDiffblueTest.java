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

public class GetExchangeByIdServletDiffblueTest {
  /**
   * Test {@link GetExchangeByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("id", "42");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, " : ");
    request.addParameter("id", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("id", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetExchangeByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetExchangeByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExchangeByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetExchangeByIdServlet getExchangeByIdServlet = new GetExchangeByIdServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getExchangeByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }
}
