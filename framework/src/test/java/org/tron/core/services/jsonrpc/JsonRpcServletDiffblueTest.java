package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.googlecode.jsonrpc4j.JsonRpcInterceptor;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.services.http.AccountPermissionUpdateServlet;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcServletDiffblueTest {
  @Mock
  private JsonRpcInterceptor jsonRpcInterceptor;

  @InjectMocks
  private JsonRpcServlet jsonRpcServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private TronJsonRpc tronJsonRpc;

  /**
   * Method under test: {@link JsonRpcServlet#init(ServletConfig)}
   */
  @Test
  public void testInit() throws ServletException {
    // Arrange
    AccountPermissionUpdateServlet config = new AccountPermissionUpdateServlet();

    // Act
    jsonRpcServlet.init(config);

    // Assert
    assertSame(config, jsonRpcServlet.getServletConfig());
  }

  /**
   * Method under test: {@link JsonRpcServlet#init(ServletConfig)}
   */
  @Test
  public void testInit2() throws ServletException {
    // Arrange and Act
    jsonRpcServlet.init(jsonRpcServlet);

    // Assert
    assertSame(jsonRpcServlet, jsonRpcServlet.getServletConfig());
  }

  /**
   * Method under test: {@link JsonRpcServlet#init(ServletConfig)}
   */
  @Test
  public void testInit3() throws ServletException {
    // Arrange
    DefaultServlet config = mock(DefaultServlet.class);

    // Act
    jsonRpcServlet.init(config);

    // Assert
    assertNull(jsonRpcServlet.getServletName());
    assertNull(jsonRpcServlet.getInitParameterNames());
    assertNull(jsonRpcServlet.getServletContext());
    assertSame(config, jsonRpcServlet.getServletConfig());
  }
}
