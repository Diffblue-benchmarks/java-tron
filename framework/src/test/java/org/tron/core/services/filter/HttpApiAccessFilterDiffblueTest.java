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
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HttpApiAccessFilterDiffblueTest {
  /**
   * Test {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link LocalConnector#LocalConnector(Server)} with server is {@link Server#Server()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpApiAccessFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_whenLocalConnectorWithServerIsServer() throws IOException, ServletException {
    // Arrange
    HttpApiAccessFilter httpApiAccessFilter = new HttpApiAccessFilter();
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpChannel channel = new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true));

    Request request = new Request(channel, new HttpInput(null));

    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpApiAccessFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpApiAccessFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_whenMockHttpServletRequest() throws IOException, ServletException {
    // Arrange
    HttpApiAccessFilter httpApiAccessFilter = new HttpApiAccessFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpApiAccessFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpApiAccessFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpApiAccessFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_whenNull() throws IOException, ServletException {
    // Arrange
    HttpApiAccessFilter httpApiAccessFilter = new HttpApiAccessFilter();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    httpApiAccessFilter.doFilter(null, response, chain);

    // Assert
    verify(chain).doFilter(isNull(), isA(ServletResponse.class));
  }
}
