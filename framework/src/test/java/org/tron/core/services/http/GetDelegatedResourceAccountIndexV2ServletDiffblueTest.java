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

public class GetDelegatedResourceAccountIndexV2ServletDiffblueTest {
  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       PostParams#S_VALUE} and {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_given0x_whenMockHttpServletRequestAddParameterS_valueAnd0x()
      throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(PostParams.S_VALUE, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(PostParams.S_VALUE, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(PostParams.S_VALUE, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       PostParams#S_VALUE} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterS_valueAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(PostParams.S_VALUE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetDelegatedResourceAccountIndexV2Servlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * GetDelegatedResourceAccountIndexV2Servlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetDelegatedResourceAccountIndexV2Servlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet =
        new GetDelegatedResourceAccountIndexV2Servlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getDelegatedResourceAccountIndexV2Servlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
