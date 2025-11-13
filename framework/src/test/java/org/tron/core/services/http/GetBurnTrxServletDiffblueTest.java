package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
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
import org.tron.core.db.Manager;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class GetBurnTrxServletDiffblueTest {
  @InjectMocks private GetBurnTrxServlet getBurnTrxServlet;

  @Mock private Manager manager;

  /**
   * Test {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link GetBurnTrxServlet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenGetBurnTrxServlet() throws UnsupportedEncodingException {
    // Arrange
    GetBurnTrxServlet getBurnTrxServlet = new GetBurnTrxServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenManagerGetDynamicPropertiesStoreReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doGet(request, response);

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
   * Test {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"burnTrxAmount": 1}}.
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsBurnTrxAmount1()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doGet(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
    assertEquals("{\"burnTrxAmount\": 1}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"burnTrxAmount\": 1}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link GetBurnTrxServlet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenGetBurnTrxServlet() throws UnsupportedEncodingException {
    // Arrange
    GetBurnTrxServlet getBurnTrxServlet = new GetBurnTrxServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenManagerGetDynamicPropertiesStoreReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doPost(request, response);

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
   * Test {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"burnTrxAmount": 1}}.
   * </ul>
   *
   * <p>Method under test: {@link GetBurnTrxServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetBurnTrxServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsBurnTrxAmount1()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getBurnTrxServlet.doPost(request, response);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
    assertEquals("{\"burnTrxAmount\": 1}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"burnTrxAmount\": 1}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
