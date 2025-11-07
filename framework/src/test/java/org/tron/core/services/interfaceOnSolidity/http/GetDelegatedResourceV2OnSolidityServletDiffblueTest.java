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
public class GetDelegatedResourceV2OnSolidityServletDiffblueTest {
  @InjectMocks
  private GetDelegatedResourceV2OnSolidityServlet getDelegatedResourceV2OnSolidityServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private Wallet wallet;

  @Mock
  private WalletOnSolidity walletOnSolidity;

  /**
   * Method under test:
   * {@link GetDelegatedResourceV2OnSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getDelegatedResourceV2OnSolidityServlet.doGet(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link GetDelegatedResourceV2OnSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getDelegatedResourceV2OnSolidityServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }
}
