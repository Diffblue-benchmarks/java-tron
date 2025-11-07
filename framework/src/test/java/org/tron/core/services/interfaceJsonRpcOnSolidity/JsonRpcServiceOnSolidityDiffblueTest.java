package org.tron.core.services.interfaceJsonRpcOnSolidity;

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
public class JsonRpcServiceOnSolidityDiffblueTest {
  @Mock
  private JsonRpcOnSolidityServlet jsonRpcOnSolidityServlet;

  @InjectMocks
  private JsonRpcServiceOnSolidity jsonRpcServiceOnSolidity;

  /**
   * Method under test: {@link JsonRpcServiceOnSolidity#start()}
   */
  @Test
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(jsonRpcOnSolidityServlet).init(Mockito.<ServletConfig>any());

    // Act
    jsonRpcServiceOnSolidity.start();

    // Assert
    verify(jsonRpcOnSolidityServlet).init(isA(ServletConfig.class));
  }
}
