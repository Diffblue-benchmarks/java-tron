package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class TriggerSmartContractServletDiffblueTest {
  @InjectMocks
  private TriggerSmartContractServlet triggerSmartContractServlet;

  /**
   * Test {@link TriggerSmartContractServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link TriggerSmartContractServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TriggerSmartContractServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    triggerSmartContractServlet.doPost(null, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"result\":{\"code\":\"OTHER_ERROR\",\"message\":\"636c617373206a6176612e6c616e672e4e756c6c506f696e746572457"
            + "863657074696f6e203a206e756c6c\"}}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(133, response.getByteSize());
    assertEquals(133, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link TriggerSmartContractServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletRequest#MockHttpServletRequest()} Reader lines collect joining lf is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContractServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TriggerSmartContractServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletRequestReaderLinesCollectJoiningLfIsEmptyString() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    triggerSmartContractServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals(
        "{\"result\":{\"code\":\"OTHER_ERROR\",\"message\":\"636c617373206a6176612e6c616e672e4e756c6c506f696e746572457"
            + "863657074696f6e203a206e756c6c\"}}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(133, response.getByteSize());
    assertEquals(133, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }
}
