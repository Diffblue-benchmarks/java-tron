package org.tron.core.services.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.eclipse.jetty.server.ServletResponseHttpWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.utils.client.utils.HttpMethed;

public class HttpInterceptorDiffblueTest {
  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));
    ServletResponseHttpWrapper response2 = new ServletResponseHttpWrapper(response);
    CharResponseWrapper response3 = new CharResponseWrapper(response2);
    HttpServletResponseWrapper response4 = new HttpServletResponseWrapper(response3);

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(request, response4, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenRuntimeException_whenFilterChainDoFilterThrowRuntimeException()
      throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doThrow(new RuntimeException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenRuntimeException_whenFilterChainDoFilterThrowRuntimeException2()
      throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doThrow(new RuntimeException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(null, response, chain);

    // Assert
    verify(chain).doFilter(isNull(), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When createRequest {@code https://example.org/example}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_whenCreateRequestHttpsExampleOrgExample_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_whenNull_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(null, response, chain);

    // Assert
    verify(chain).doFilter(isNull(), isA(ServletResponse.class));
  }
}
