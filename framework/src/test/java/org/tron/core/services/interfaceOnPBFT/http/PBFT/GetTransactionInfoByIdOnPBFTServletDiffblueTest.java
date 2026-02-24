package org.tron.core.services.interfaceOnPBFT.http.PBFT;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.interfaceOnPBFT.WalletOnPBFT;

@RunWith(MockitoJUnitRunner.class)
public class GetTransactionInfoByIdOnPBFTServletDiffblueTest {
  @InjectMocks private GetTransactionInfoByIdOnPBFTServlet getTransactionInfoByIdOnPBFTServlet;

  @Mock private WalletOnPBFT walletOnPBFT;

  /**
   * Test {@link GetTransactionInfoByIdOnPBFTServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionInfoByIdOnPBFTServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionInfoByIdOnPBFTServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act
    getTransactionInfoByIdOnPBFTServlet.doGet(
        request,
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }

  /**
   * Test {@link GetTransactionInfoByIdOnPBFTServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetTransactionInfoByIdOnPBFTServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetTransactionInfoByIdOnPBFTServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnPBFT).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act
    getTransactionInfoByIdOnPBFTServlet.doPost(
        request,
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())));

    // Assert
    verify(walletOnPBFT).futureGet(isA(Runnable.class));
  }
}
