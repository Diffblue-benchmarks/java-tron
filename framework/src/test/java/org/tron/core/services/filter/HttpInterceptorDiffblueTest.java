package org.tron.core.services.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletResponse;

public class HttpInterceptorDiffblueTest {
  /**
   * Method under test:
   * {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(null, response, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isNull(), isA(ServletResponse.class));
  }
}
