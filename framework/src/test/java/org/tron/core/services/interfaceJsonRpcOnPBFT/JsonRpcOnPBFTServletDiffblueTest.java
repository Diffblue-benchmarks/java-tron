package org.tron.core.services.interfaceJsonRpcOnPBFT;

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
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcOnPBFTServletDiffblueTest {
  @Mock
  private JsonRpcInterceptor jsonRpcInterceptor;

  @InjectMocks
  private JsonRpcOnPBFTServlet jsonRpcOnPBFTServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private TronJsonRpc tronJsonRpc;

  @Mock
  private WalletOnPBFT walletOnPBFT;

  /**
   * Method under test:
   * {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    jsonRpcOnPBFTServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }
}
