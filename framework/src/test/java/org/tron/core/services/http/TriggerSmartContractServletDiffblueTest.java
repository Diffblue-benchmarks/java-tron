package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class TriggerSmartContractServletDiffblueTest {
  /**
   * Test {@link TriggerSmartContractServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link TriggerSmartContractServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TriggerSmartContractServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws IOException {
    // Arrange
    TriggerSmartContractServlet triggerSmartContractServlet = new TriggerSmartContractServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    triggerSmartContractServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"result\":{\"code\":\"OTHER_ERROR\",\"message\":\"636c617373206a6176612e6c616e672e4e756c6c506f696e746572457"
            + "863657074696f6e203a206e756c6c\"}}\n",
        response.getContentAsString());
    assertEquals(133, response.getContentAsByteArray().length);
  }
}
