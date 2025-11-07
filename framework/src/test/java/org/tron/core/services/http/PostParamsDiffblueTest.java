package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class PostParamsDiffblueTest {
  /**
   * Method under test: {@link PostParams#getPostParams(HttpServletRequest)}
   */
  @Test
  public void testGetPostParams() throws Exception {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    PostParams actualPostParams = PostParams.getPostParams(request);

    // Assert
    Stream<String> linesResult = request.getReader().lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("", actualPostParams.getParams());
    assertFalse(actualPostParams.isVisible());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PostParams#PostParams(String, boolean)}
   *   <li>{@link PostParams#getParams()}
   *   <li>{@link PostParams#isVisible()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PostParams actualPostParams = new PostParams("https://example.org/example", true);
    String actualParams = actualPostParams.getParams();

    // Assert
    assertEquals("https://example.org/example", actualParams);
    assertTrue(actualPostParams.isVisible());
  }
}
