package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bouncycastle.util.encoders.DecoderException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.db.Manager;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class GetBrokerageServletDiffblueTest {
  @InjectMocks private GetBrokerageServlet getBrokerageServlet;

  @Mock private Manager manager;

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenThrow(new IllegalArgumentException());
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
    assertEquals("{\"Error\": \"INVALID address, null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link GetBrokerageServlet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenGetBrokerageServlet() throws UnsupportedEncodingException {
    // Arrange
    GetBrokerageServlet getBrokerageServlet = new GetBrokerageServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenManagerGetDynamicPropertiesStoreReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenManagerGetDynamicPropertiesStoreThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals("{\"Error\": \"INVALID address, null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"brokerage": 0}}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsBrokerage0()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
    assertEquals("{\"brokerage\": 0}\n", response.getContentAsString());
    assertArrayEquals("{\"brokerage\": 0}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenThrowIllegalArgumentException() {
    // Arrange
    DecoderException decoderException = mock(DecoderException.class);
    when(decoderException.getMessage()).thenThrow(new IllegalArgumentException());
    when(manager.getDynamicPropertiesStore()).thenThrow(decoderException);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> getBrokerageServlet.doGet(request, new MockHttpServletResponse()));
    verify(decoderException).getMessage();
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenThrow(new IllegalArgumentException());
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
    assertEquals("{\"Error\": \"INVALID address, null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link GetBrokerageServlet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenGetBrokerageServlet() throws UnsupportedEncodingException {
    // Arrange
    GetBrokerageServlet getBrokerageServlet = new GetBrokerageServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenManagerGetDynamicPropertiesStoreReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenManagerGetDynamicPropertiesStoreThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    assertEquals("{\"Error\": \"INVALID address, null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\": \"INVALID address, null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBrokerageServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"brokerage": 0}}.
   * </ul>
   *
   * <p>Method under test: {@link GetBrokerageServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBrokerageServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsBrokerage0()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("address", "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBrokerageServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
    assertEquals("{\"brokerage\": 0}\n", response.getContentAsString());
    assertArrayEquals("{\"brokerage\": 0}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
