package org.tron.core.services.interfaceJsonRpcOnSolidity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
public class JsonRpcServiceOnSolidityDiffblueTest {
  @Mock private JsonRpcOnSolidityServlet jsonRpcOnSolidityServlet;

  @InjectMocks private JsonRpcServiceOnSolidity jsonRpcServiceOnSolidity;

  /**
   * Test {@link JsonRpcServiceOnSolidity#start()}.
   *
   * <ul>
   *   <li>Given {@link JsonRpcOnSolidityServlet} {@link
   *       JsonRpcOnSolidityServlet#init(ServletConfig)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link JsonRpcOnSolidityServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonRpcServiceOnSolidity#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonRpcServiceOnSolidity.start()"})
  public void testStart_givenJsonRpcOnSolidityServletInitThrowRuntimeException_thenCallsInit()
      throws ServletException {
    // Arrange
    doThrow(new RuntimeException())
        .when(jsonRpcOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    jsonRpcServiceOnSolidity.start();

    // Assert
    verify(jsonRpcOnSolidityServlet).init(isA(ServletConfig.class));
  }
}
