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

public class ValidateAddressServletDiffblueTest {
  /**
   * Test {@link ValidateAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ValidateAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    ValidateAddressServlet validateAddressServlet = new ValidateAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    validateAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"result\":false,\"message\":\"Length error\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"result\":false,\"message\":\"Length error\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ValidateAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"result":false}}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidateAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsResultFalse()
      throws UnsupportedEncodingException {
    // Arrange
    ValidateAddressServlet validateAddressServlet = new ValidateAddressServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    validateAddressServlet.doGet(request, response);

    // Assert
    assertEquals("{\"result\":false}\n", response.getContentAsString());
    assertArrayEquals("{\"result\":false}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
