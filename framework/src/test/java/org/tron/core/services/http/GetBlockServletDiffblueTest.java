package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetBlockServletDiffblueTest {
  @InjectMocks
  private GetBlockServlet getBlockServlet;

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(65, response.getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link LocalConnector#LocalConnector(Server)} with server is {@link Server#Server()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenLocalConnectorWithServerIsServer() throws IOException {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    Request request = new Request(channel, new HttpInput(null));

    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doGet(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetBlockServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_whenNull() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doGet(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.UnsupportedOperationException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(65, response.getByteSize());
    assertEquals(65, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link LocalConnector#LocalConnector(Server)} with server is {@link Server#Server()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenLocalConnectorWithServerIsServer() throws IOException {
    // Arrange
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    Request request = new Request(channel, new HttpInput(null));

    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetBlockServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetBlockServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_whenNull() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getBlockServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(56, response.getByteSize());
    byte[] expectedContentAsByteArray = "{\"Error\":\"class java.lang.NullPointerException : null\"}\n"
        .getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }
}
