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

public class GetZenPaymentAddressServletDiffblueTest {
  /**
   * Test {@link GetZenPaymentAddressServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("d", "ivk");
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("ivk", "0x");
    request.addParameter("d", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code d} and
   *       {@code ivk}.
   * </ul>
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterDAndIvk()
      throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("d", "ivk");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@code ivk}.
   * </ul>
   *
   * <p>Method under test: {@link GetZenPaymentAddressServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetZenPaymentAddressServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterIvkAndIvk()
      throws UnsupportedEncodingException {
    // Arrange
    GetZenPaymentAddressServlet getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("ivk", "ivk");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getZenPaymentAddressServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }
}
