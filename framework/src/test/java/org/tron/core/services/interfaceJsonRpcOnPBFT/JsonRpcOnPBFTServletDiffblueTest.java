package org.tron.core.services.interfaceJsonRpcOnPBFT;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcOnPBFTServletDiffblueTest {
  @InjectMocks private JsonRpcOnPBFTServlet jsonRpcOnPBFTServlet;

  @Mock private WalletOnPBFT walletOnPBFT;

  /**
   * Test {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link WalletOnPBFT} {@link WalletOnPBFT#futureGet(Runnable)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcOnPBFTServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenWalletOnPBFTFutureGetDoesNothing() {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    jsonRpcOnPBFTServlet.doPost(request, new MockHttpServletResponse());

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }

  /**
   * Test {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcOnPBFTServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> jsonRpcOnPBFTServlet.doPost(request, new MockHttpServletResponse()));
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }
}
