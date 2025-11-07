package org.tron.core.services.interfaceOnPBFT.http.PBFT;

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
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetBlockOnPBFTServletDiffblueTest {
  @InjectMocks
  private GetBlockOnPBFTServlet getBlockOnPBFTServlet;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  @Mock
  private Wallet wallet;

  @Mock
  private WalletOnPBFT walletOnPBFT;

  /**
   * Method under test:
   * {@link GetBlockOnPBFTServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getBlockOnPBFTServlet.doGet(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link GetBlockOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    getBlockOnPBFTServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }
}
