package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionListFromPendingServletDiffblueTest {
  @InjectMocks private GetTransactionListFromPendingServlet getTransactionListFromPendingServlet;

  @Mock private Manager manager;

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{}\n", response.getContentAsString());
    assertArrayEquals("{}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code :}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenColon_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNotBlank_whenMockHttpServletRequestAddParameterVisibleAndNotBlank()
      throws UnsupportedEncodingException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"txId":["visible"]}}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsTxIdVisible()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"visible\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"visible\"]}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code {"txId":["{","visible"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsTxIdVisible2()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"{\",\"visible\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"{\",\"visible\"]}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code {"txId":["\"","{","visible"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsTxIdVisible3()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("{");
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"\\\"\",\"{\",\"visible\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"\\\"\",\"{\",\"visible\"]}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"txId":["\"","\\\"","visible"]}}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsTxIdVisible4()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("\\\"");
    stringList.add(Util.VISIBLE);
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doGet(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"\\\"\",\"\\\\\\\"\",\"visible\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"\\\"\",\"\\\\\\\"\",\"visible\"]}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetTransactionListFromPendingServlet getTransactionListFromPendingServlet =
        new GetTransactionListFromPendingServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost2() throws UnsupportedEncodingException {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{}\n", response.getContentAsString());
    assertArrayEquals("{}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code {"txId":["{"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsTxId()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"{\"]}\n", response.getContentAsString());
    assertArrayEquals("{\"txId\":[\"{\"]}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code {"txId":["\"","{"]}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsTxId2()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("{");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"\\\"\",\"{\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"\\\"\",\"{\"]}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }

  /**
   * Test {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       {"txId":["\"","\\\""]}}.
   * </ul>
   *
   * <p>Method under test: {@link GetTransactionListFromPendingServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionListFromPendingServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsTxId3()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\"");
    stringList.add("\\\"");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getTransactionListFromPendingServlet.doPost(request, response);

    // Assert
    verify(manager).getTxListFromPending();
    assertEquals("{\"txId\":[\"\\\"\",\"\\\\\\\"\"]}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"txId\":[\"\\\"\",\"\\\\\\\"\"]}\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
