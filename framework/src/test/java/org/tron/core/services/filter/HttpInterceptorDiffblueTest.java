package org.tron.core.services.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletResponse;

public class HttpInterceptorDiffblueTest {
  /**
   * Test {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link HttpInterceptor#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpInterceptor.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    HttpInterceptor httpInterceptor = new HttpInterceptor();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpInterceptor.doFilter(null, response, chain);

    // Assert
    verify(chain).doFilter(isNull(), isA(ServletResponse.class));
  }
}
