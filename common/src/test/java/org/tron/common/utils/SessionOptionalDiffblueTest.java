package org.tron.common.utils;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.ISession;

public class SessionOptionalDiffblueTest {
  /**
   * Test {@link SessionOptional#valid()}.
   *
   * <ul>
   *   <li>Given instance Value is {@link ISession}.
   * </ul>
   *
   * <p>Method under test: {@link SessionOptional#valid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionOptional.valid()"})
  public void testValid_givenInstanceValueIsISession() {
    // Arrange
    SessionOptional instanceResult = SessionOptional.instance();
    instanceResult.setValue(mock(ISession.class));

    // Act and Assert
    assertTrue(instanceResult.valid());
  }
}
