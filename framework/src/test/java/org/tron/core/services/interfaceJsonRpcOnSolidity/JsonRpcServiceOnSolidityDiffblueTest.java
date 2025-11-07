package org.tron.core.services.interfaceJsonRpcOnSolidity;

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
public class JsonRpcServiceOnSolidityDiffblueTest {
  @Mock
  private JsonRpcOnSolidityServlet jsonRpcOnSolidityServlet;

  @InjectMocks
  private JsonRpcServiceOnSolidity jsonRpcServiceOnSolidity;

  /**
   * Test {@link JsonRpcServiceOnSolidity#start()}.
   * <p>
   * Method under test: {@link JsonRpcServiceOnSolidity#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcServiceOnSolidity.start()"})
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(jsonRpcOnSolidityServlet).init(Mockito.<ServletConfig>any());

    // Act
    jsonRpcServiceOnSolidity.start();

    // Assert
    verify(jsonRpcOnSolidityServlet).init(isA(ServletConfig.class));
  }
}
