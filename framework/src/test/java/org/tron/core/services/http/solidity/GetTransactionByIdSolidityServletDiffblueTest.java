package org.tron.core.services.http.solidity;

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

public class GetTransactionByIdSolidityServletDiffblueTest {
  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("value", "not blank");
    request.addParameter("value", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    assertEquals(
        "exception decoding Hex string: invalid characters encountered in Hex string\n",
        response.getContentAsString());
    assertEquals(76, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code visible}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code visible}
   *       and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenVisible_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("visible", "not blank");
    request.addParameter("value", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code value}
   *       and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterValueAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("value", "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code visible}
   *       and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("visible", "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doGet(request, response);

    // Assert
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionByIdSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionByIdSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet =
        new GetTransactionByIdSolidityServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionByIdSolidityServlet.doPost(request, response);

    // Assert
    assertEquals("1:1: Expected \"{\".\n", response.getContentAsString());
    assertArrayEquals("1:1: Expected \"{\".\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
