package org.tron.core.services.jsonrpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FullNodeJsonRpcHttpServiceDiffblueTest {
  @InjectMocks private FullNodeJsonRpcHttpService fullNodeJsonRpcHttpService;

  @Mock private JsonRpcServlet jsonRpcServlet;

  /**
   * Test {@link FullNodeJsonRpcHttpService#start()}.
   *
   * <ul>
   *   <li>Given {@link JsonRpcServlet} {@link JsonRpcServlet#init(ServletConfig)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link JsonRpcServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link FullNodeJsonRpcHttpService#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FullNodeJsonRpcHttpService.start()"})
  public void testStart_givenJsonRpcServletInitThrowRuntimeException_thenCallsInit()
      throws ServletException {
    // Arrange
    doThrow(new RuntimeException()).when(jsonRpcServlet).init(Mockito.<ServletConfig>any());

    // Act
    fullNodeJsonRpcHttpService.start();

    // Assert
    verify(jsonRpcServlet).init(isA(ServletConfig.class));
  }
}
