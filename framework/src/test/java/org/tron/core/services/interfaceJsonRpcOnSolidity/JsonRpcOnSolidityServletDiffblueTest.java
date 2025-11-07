package org.tron.core.services.interfaceJsonRpcOnSolidity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.googlecode.jsonrpc4j.JsonRpcInterceptor;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.interfaceOnSolidity.WalletOnSolidity;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcOnSolidityServletDiffblueTest {
  @Mock
  private JsonRpcInterceptor jsonRpcInterceptor;

  @InjectMocks
  private JsonRpcOnSolidityServlet jsonRpcOnSolidityServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private TronJsonRpc tronJsonRpc;

  @Mock
  private WalletOnSolidity walletOnSolidity;

  /**
   * Method under test:
   * {@link JsonRpcOnSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    jsonRpcOnSolidityServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }
}
