package org.tron.common.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.ISession;

public class SessionOptionalDiffblueTest {
  /**
   * Test {@link SessionOptional#instance()}.
   * <p>
   * Method under test: {@link SessionOptional#instance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SessionOptional SessionOptional.instance()"})
  public void testInstance() {
    // Arrange, Act and Assert
    assertFalse(SessionOptional.instance().valid());
  }

  /**
   * Test {@link SessionOptional#setValue(ISession)}.
   * <p>
   * Method under test: {@link SessionOptional#setValue(ISession)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SessionOptional SessionOptional.setValue(ISession)"})
  public void testSetValue() {
    // Arrange
    SessionOptional instanceResult = SessionOptional.instance();

    // Act and Assert
    assertSame(instanceResult, instanceResult.setValue(mock(ISession.class)));
  }
}
