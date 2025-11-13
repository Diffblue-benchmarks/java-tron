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

public class GetBlockServletDiffblueTest {
  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod(null);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Error}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Method is {@code Error}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenError_whenMockHttpServletRequestMethodIsError()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("Error");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Method}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Method is {@code Method}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenMethod_whenMockHttpServletRequestMethodIsMethod()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("Method");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod(null);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Error}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Method is {@code Error}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenError_whenMockHttpServletRequestMethodIsError()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("Error");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code Method}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} Method is {@code Method}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenMethod_whenMockHttpServletRequestMethodIsMethod()
      throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("Method");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetBlockServlet getBlockServlet = new GetBlockServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        response.getContentAsString());
    assertEquals(65, response.getContentAsByteArray().length);
  }
}
