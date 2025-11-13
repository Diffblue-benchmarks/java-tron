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

public class ListProposalsServletDiffblueTest {
  /**
   * Test {@link ListProposalsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenNotBlank() throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ListProposalsServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ListProposalsServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListProposalsServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    ListProposalsServlet listProposalsServlet = new ListProposalsServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    listProposalsServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }
}
