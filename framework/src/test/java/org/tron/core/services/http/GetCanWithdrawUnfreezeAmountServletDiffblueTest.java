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

public class GetCanWithdrawUnfreezeAmountServletDiffblueTest {
  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("timestamp", Util.OWNER_ADDRESS);
    request.addParameter(Util.OWNER_ADDRESS, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"owner_address\\\"\"}\n",
        response.getContentAsString());
    assertEquals(88, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#OWNER_ADDRESS} and {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_given0x_whenMockHttpServletRequestAddParameterOwner_addressAnd0x()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, "0x");
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code timestamp}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code
   *       timestamp} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenTimestamp_whenMockHttpServletRequestAddParameterTimestampAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("timestamp", "42");
    request.addParameter(Util.OWNER_ADDRESS, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, Util.VISIBLE);
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#OWNER_ADDRESS} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterOwner_addressAnd42()
      throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.OWNER_ADDRESS, "42");
    request.addParameter(Util.VISIBLE, "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetCanWithdrawUnfreezeAmountServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetCanWithdrawUnfreezeAmountServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetCanWithdrawUnfreezeAmountServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet =
        new GetCanWithdrawUnfreezeAmountServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getCanWithdrawUnfreezeAmountServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }
}
