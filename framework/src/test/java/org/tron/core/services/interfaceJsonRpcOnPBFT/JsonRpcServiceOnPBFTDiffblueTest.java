package org.tron.core.services.interfaceJsonRpcOnPBFT;

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
public class JsonRpcServiceOnPBFTDiffblueTest {
  @Mock private JsonRpcOnPBFTServlet jsonRpcOnPBFTServlet;

  @InjectMocks private JsonRpcServiceOnPBFT jsonRpcServiceOnPBFT;

  /**
   * Test {@link JsonRpcServiceOnPBFT#start()}.
   *
   * <ul>
   *   <li>Given {@link JsonRpcOnPBFTServlet} {@link JsonRpcOnPBFTServlet#init(ServletConfig)} throw
   *       {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link JsonRpcOnPBFTServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonRpcServiceOnPBFT#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonRpcServiceOnPBFT.start()"})
  public void testStart_givenJsonRpcOnPBFTServletInitThrowRuntimeException_thenCallsInit()
      throws ServletException {
    // Arrange
    doThrow(new RuntimeException()).when(jsonRpcOnPBFTServlet).init(Mockito.<ServletConfig>any());

    // Act
    jsonRpcServiceOnPBFT.start();

    // Assert
    verify(jsonRpcOnPBFTServlet).init(isA(ServletConfig.class));
  }
}
