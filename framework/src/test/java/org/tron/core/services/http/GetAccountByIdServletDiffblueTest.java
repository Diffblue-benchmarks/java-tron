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

public class GetAccountByIdServletDiffblueTest {
  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("account_id", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:15: INVALID hex String\"}\n",
        response.getContentAsString());
    assertEquals(99, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       account_id} and {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_given0x_whenMockHttpServletRequestAddParameterAccountIdAnd0x()
      throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("account_id", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       account_id} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_given42_whenMockHttpServletRequestAddParameterAccountIdAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("account_id", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("account_id", "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given space space space.
   * </ul>
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenSpaceSpaceSpace() throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "   ");
    request.addParameter("account_id", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:15: INVALID hex String\"}\n",
        response.getContentAsString());
    assertEquals(99, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetAccountByIdServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAccountByIdServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetAccountByIdServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAccountByIdServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetAccountByIdServlet getAccountByIdServlet = new GetAccountByIdServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAccountByIdServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
