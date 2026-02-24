package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.ChainBaseManager;

@RunWith(MockitoJUnitRunner.class)
public class LiteFnQueryHttpFilterDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @InjectMocks private LiteFnQueryHttpFilter liteFnQueryHttpFilter;

  /**
   * Test {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#isLiteNode()} return {@code
   *       false}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteFnQueryHttpFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_givenChainBaseManagerIsLiteNodeReturnFalse_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    when(chainBaseManager.isLiteNode()).thenReturn(false);
    MockHttpServletRequest servletRequest = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper servletResponse =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    liteFnQueryHttpFilter.doFilter(servletRequest, servletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(chainBaseManager).isLiteNode();
  }

  /**
   * Test {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#isLiteNode()} return {@code true}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteFnQueryHttpFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_givenChainBaseManagerIsLiteNodeReturnTrue_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    when(chainBaseManager.isLiteNode()).thenReturn(true);
    MockHttpServletRequest servletRequest = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper servletResponse =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    liteFnQueryHttpFilter.doFilter(servletRequest, servletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(chainBaseManager).isLiteNode();
  }

  /**
   * Test {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link LiteFnQueryHttpFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteFnQueryHttpFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    when(chainBaseManager.isLiteNode()).thenReturn(true);
    MockHttpServletRequest servletRequest = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper servletResponse =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> liteFnQueryHttpFilter.doFilter(servletRequest, servletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(chainBaseManager).isLiteNode();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteFnQueryHttpFilter#destroy()}
   *   <li>{@link LiteFnQueryHttpFilter#init(FilterConfig)}
   *   <li>{@link LiteFnQueryHttpFilter#getFilterPaths()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LiteFnQueryHttpFilter.destroy()",
    "Set LiteFnQueryHttpFilter.getFilterPaths()",
    "void LiteFnQueryHttpFilter.init(FilterConfig)"
  })
  public void testGettersAndSetters() throws ServletException {
    // Arrange
    LiteFnQueryHttpFilter liteFnQueryHttpFilter = new LiteFnQueryHttpFilter();

    // Act
    liteFnQueryHttpFilter.destroy();
    liteFnQueryHttpFilter.init(new MockFilterConfig());
    Set<String> actualFilterPaths = liteFnQueryHttpFilter.getFilterPaths();

    // Assert
    assertEquals(Double.SIZE, actualFilterPaths.size());
    assertTrue(actualFilterPaths.contains("/wallet/getmarketpairlist"));
    assertTrue(actualFilterPaths.contains("/wallet/getmarketpricebypair"));
    assertTrue(actualFilterPaths.contains("/wallet/getmerkletreevoucherinfo"));
    assertTrue(actualFilterPaths.contains("/wallet/gettransactionreceiptbyid"));
    assertTrue(actualFilterPaths.contains("/wallet/scanshieldedtrc20notesbyovk"));
    assertTrue(actualFilterPaths.contains("/walletpbft/getblockbylatestnum"));
    assertTrue(actualFilterPaths.contains("/walletpbft/gettransactionbyid"));
    assertTrue(actualFilterPaths.contains("/walletpbft/isspend"));
    assertTrue(actualFilterPaths.contains("/walletsolidity/getblockbynum"));
    assertTrue(actualFilterPaths.contains("/walletsolidity/getmarketorderbyid"));
    assertTrue(actualFilterPaths.contains("/walletsolidity/scannotebyovk"));
  }
}
