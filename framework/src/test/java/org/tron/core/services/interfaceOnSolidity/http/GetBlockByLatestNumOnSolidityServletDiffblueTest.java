package org.tron.core.services.interfaceOnSolidity.http;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
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
import org.tron.core.Wallet;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.interfaceOnSolidity.WalletOnSolidity;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetBlockByLatestNumOnSolidityServletDiffblueTest {
  @InjectMocks
  private GetBlockByLatestNumOnSolidityServlet getBlockByLatestNumOnSolidityServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private Wallet wallet;

  @Mock
  private WalletOnSolidity walletOnSolidity;

  /**
   * Method under test:
   * {@link GetBlockByLatestNumOnSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getBlockByLatestNumOnSolidityServlet.doGet(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link GetBlockByLatestNumOnSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getBlockByLatestNumOnSolidityServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }
}
