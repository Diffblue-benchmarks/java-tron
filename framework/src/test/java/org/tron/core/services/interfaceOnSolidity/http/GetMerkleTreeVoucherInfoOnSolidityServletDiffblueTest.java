package org.tron.core.services.interfaceOnSolidity.http;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.tron.core.services.interfaceOnSolidity.WalletOnSolidity;

@RunWith(MockitoJUnitRunner.class)
public class GetMerkleTreeVoucherInfoOnSolidityServletDiffblueTest {
  @InjectMocks
  private GetMerkleTreeVoucherInfoOnSolidityServlet getMerkleTreeVoucherInfoOnSolidityServlet;

  @Mock private WalletOnSolidity walletOnSolidity;

  /**
   * Test {@link GetMerkleTreeVoucherInfoOnSolidityServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * GetMerkleTreeVoucherInfoOnSolidityServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void GetMerkleTreeVoucherInfoOnSolidityServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act
    getMerkleTreeVoucherInfoOnSolidityServlet.doGet(
        request,
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }

  /**
   * Test {@link GetMerkleTreeVoucherInfoOnSolidityServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * GetMerkleTreeVoucherInfoOnSolidityServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void GetMerkleTreeVoucherInfoOnSolidityServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    doNothing().when(walletOnSolidity).futureGet(Mockito.<Runnable>any());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act
    getMerkleTreeVoucherInfoOnSolidityServlet.doPost(
        request,
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse())));

    // Assert
    verify(walletOnSolidity).futureGet(isA(Runnable.class));
  }
}
