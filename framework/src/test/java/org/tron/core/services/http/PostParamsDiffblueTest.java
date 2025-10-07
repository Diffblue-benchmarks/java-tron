package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.tron.common.utils.client.utils.HttpMethed;

public class PostParamsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PostParams#PostParams(String, boolean)}
   *   <li>{@link PostParams#getParams()}
   *   <li>{@link PostParams#isVisible()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PostParams.<init>(String, boolean)",
    "String PostParams.getParams()",
    "boolean PostParams.isVisible()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PostParams actualPostParams = new PostParams("https://example.org/example", true);
    String actualParams = actualPostParams.getParams();

    // Assert
    assertEquals("https://example.org/example", actualParams);
    assertTrue(actualPostParams.isVisible());
  }

  /**
   * Test {@link PostParams#getPostParams(HttpServletRequest)}.
   *
   * <p>Method under test: {@link PostParams#getPostParams(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PostParams PostParams.getPostParams(HttpServletRequest)"})
  public void testGetPostParams() throws Exception {
    // Arrange
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    // Act
    PostParams actualPostParams = PostParams.getPostParams(request);

    // Assert
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("", actualPostParams.getParams());
    assertFalse(actualPostParams.isVisible());
  }
}
