package org.tron.core.services.jsonrpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FullNodeJsonRpcHttpServiceDiffblueTest {
  @InjectMocks
  private FullNodeJsonRpcHttpService fullNodeJsonRpcHttpService;

  @Mock
  private JsonRpcServlet jsonRpcServlet;

  /**
   * Test {@link FullNodeJsonRpcHttpService#start()}.
   * <p>
   * Method under test: {@link FullNodeJsonRpcHttpService#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FullNodeJsonRpcHttpService.start()"})
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(jsonRpcServlet).init(Mockito.<ServletConfig>any());

    // Act
    fullNodeJsonRpcHttpService.start();

    // Assert
    verify(jsonRpcServlet).init(isA(ServletConfig.class));
  }
}
