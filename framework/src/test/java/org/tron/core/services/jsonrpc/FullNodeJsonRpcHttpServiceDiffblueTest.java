package org.tron.core.services.jsonrpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FullNodeJsonRpcHttpServiceDiffblueTest {
  @InjectMocks
  private FullNodeJsonRpcHttpService fullNodeJsonRpcHttpService;

  @Mock
  private JsonRpcServlet jsonRpcServlet;

  /**
   * Method under test: {@link FullNodeJsonRpcHttpService#start()}
   */
  @Test
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(jsonRpcServlet).init(Mockito.<ServletConfig>any());

    // Act
    fullNodeJsonRpcHttpService.start();

    // Assert
    verify(jsonRpcServlet).init(isA(ServletConfig.class));
  }
}
