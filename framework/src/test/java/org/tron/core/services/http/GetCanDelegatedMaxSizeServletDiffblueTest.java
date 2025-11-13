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

public class GetCanDelegatedMaxSizeServletDiffblueTest {
  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"visible\\\"\"}\n",
        response.getContentAsString());
    assertEquals(82, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", Util.VISIBLE);
    request.addParameter(Util.VISIBLE, " : ");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"visible\\\"\"}\n",
        response.getContentAsString());
    assertEquals(82, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", "1");
    request.addParameter(Util.OWNER_ADDRESS, "not blank");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#OWNER_ADDRESS} and {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterOwner_addressAnd1()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, "1");
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#OWNER_ADDRESS} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterOwner_addressAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", "1");
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(Util.OWNER_ADDRESS, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code type}
   *       and {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterTypeAnd1()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", "1");
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("type", Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "");
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"visible\\\"\"}\n",
        response.getContentAsString());
    assertEquals(82, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanDelegatedMaxSizeServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetCanDelegatedMaxSizeServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanDelegatedMaxSizeServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet =
        new GetCanDelegatedMaxSizeServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanDelegatedMaxSizeServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
