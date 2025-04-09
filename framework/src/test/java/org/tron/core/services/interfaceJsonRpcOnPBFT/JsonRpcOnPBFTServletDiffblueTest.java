package org.tron.core.services.interfaceJsonRpcOnPBFT;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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
import org.tron.core.services.WalletOnCursor;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcOnPBFTServletDiffblueTest {
  @InjectMocks
  private JsonRpcOnPBFTServlet jsonRpcOnPBFTServlet;

  @Mock
  private WalletOnPBFT walletOnPBFT;

  /**
   * Test {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link WalletOnPBFT} {@link WalletOnCursor#futureGet(Runnable)} does nothing.</li>
   *   <li>Then calls {@link WalletOnCursor#futureGet(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcOnPBFTServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcOnPBFTServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenWalletOnPBFTFutureGetDoesNothing_thenCallsFutureGet() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    jsonRpcOnPBFTServlet.doPost(request, new CharResponseWrapper(new MockHttpServletResponse()));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }
}
