package org.tron.core.services.http;

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

public class ExchangeCreateServletDiffblueTest {
  /**
   * Test {@link ExchangeCreateServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ExchangeCreateServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCreateServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCreateServlet exchangeCreateServlet = new ExchangeCreateServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    exchangeCreateServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
