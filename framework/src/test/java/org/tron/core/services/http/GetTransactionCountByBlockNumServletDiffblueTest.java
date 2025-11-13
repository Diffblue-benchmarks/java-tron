package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.Wallet;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionCountByBlockNumServletDiffblueTest {
  @InjectMocks private GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet;

  @Mock private Wallet wallet;

  /**
   * Test {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionCountByBlockNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet =
        new GetTransactionCountByBlockNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionCountByBlockNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionCountByBlockNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet =
        new GetTransactionCountByBlockNumServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("num", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionCountByBlockNumServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"count": 3}}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionCountByBlockNumServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionCountByBlockNumServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsCount3()
      throws UnsupportedEncodingException {
    // Arrange
    when(wallet.getTransactionCountByBlockNum(anyLong())).thenReturn(3L);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("num", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionCountByBlockNumServlet.doGet(request, response);

    // Assert
    verify(wallet).getTransactionCountByBlockNum(42L);
    assertEquals("{\"count\": 3}\n", response.getContentAsString());
    assertArrayEquals("{\"count\": 3}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionCountByBlockNumServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionCountByBlockNumServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionCountByBlockNumServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet =
        new GetTransactionCountByBlockNumServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionCountByBlockNumServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
