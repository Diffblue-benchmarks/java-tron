package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletResponse;

public class CharResponseWrapperDiffblueTest {
  /**
   * Test {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}.
   *
   * <p>Method under test: {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CharResponseWrapper.<init>(HttpServletResponse)"})
  public void testNewCharResponseWrapper() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertSame(response, new CharResponseWrapper(response).getResponse());
  }

  /**
   * Test {@link CharResponseWrapper#getOutputStream()}.
   *
   * <p>Method under test: {@link CharResponseWrapper#getOutputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ServletOutputStream CharResponseWrapper.getOutputStream()"})
  public void testGetOutputStream() throws IOException {
    // Arrange and Act
    ServletOutputStream actualOutputStream =
        new CharResponseWrapper(new MockHttpServletResponse()).getOutputStream();

    // Assert
    assertTrue(actualOutputStream instanceof ServletOutputStreamCopy);
    assertEquals(0, ((ServletOutputStreamCopy) actualOutputStream).getStreamByteSize());
    assertFalse(actualOutputStream.isReady());
  }

  /**
   * Test {@link CharResponseWrapper#getByteSize()}.
   *
   * <p>Method under test: {@link CharResponseWrapper#getByteSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CharResponseWrapper.getByteSize()"})
  public void testGetByteSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, new CharResponseWrapper(new MockHttpServletResponse()).getByteSize());
  }
}
