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

public class GetAssetIssueListByNameServletDiffblueTest {
  /**
   * Test {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(PostParams.S_VALUE, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(PostParams.S_VALUE, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter(PostParams.S_VALUE, "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetAssetIssueListByNameServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetAssetIssueListByNameServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAssetIssueListByNameServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetAssetIssueListByNameServlet getAssetIssueListByNameServlet =
        new GetAssetIssueListByNameServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getAssetIssueListByNameServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }
}
