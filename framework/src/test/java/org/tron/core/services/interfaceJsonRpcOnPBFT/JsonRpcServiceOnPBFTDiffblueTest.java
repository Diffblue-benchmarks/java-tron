package org.tron.core.services.interfaceJsonRpcOnPBFT;

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
public class JsonRpcServiceOnPBFTDiffblueTest {
  @Mock
  private JsonRpcOnPBFTServlet jsonRpcOnPBFTServlet;

  @InjectMocks
  private JsonRpcServiceOnPBFT jsonRpcServiceOnPBFT;

  /**
   * Method under test: {@link JsonRpcServiceOnPBFT#start()}
   */
  @Test
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(jsonRpcOnPBFTServlet).init(Mockito.<ServletConfig>any());

    // Act
    jsonRpcServiceOnPBFT.start();

    // Assert
    verify(jsonRpcOnPBFTServlet).init(isA(ServletConfig.class));
  }
}
