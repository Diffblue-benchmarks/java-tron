package org.tron.common.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.core.db2.ISession;

public class SessionOptionalDiffblueTest {
  /**
   * Method under test: {@link SessionOptional#setValue(ISession)}
   */
  @Test
  public void testSetValue() {
    // Arrange
    SessionOptional instanceResult = SessionOptional.instance();

    // Act
    SessionOptional actualSetValueResult = instanceResult.setValue(mock(ISession.class));

    // Assert
    assertTrue(actualSetValueResult.valid());
    assertSame(instanceResult, actualSetValueResult);
  }

  /**
   * Method under test: {@link SessionOptional#valid()}
   */
  @Test
  public void testValid() {
    // Arrange
    SessionOptional instanceResult = SessionOptional.instance();
    instanceResult.setValue(mock(ISession.class));

    // Act and Assert
    assertTrue(instanceResult.valid());
  }

  /**
   * Method under test: {@link SessionOptional#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    SessionOptional instanceResult = SessionOptional.instance();

    // Act
    instanceResult.reset();

    // Assert
    assertFalse(instanceResult.valid());
  }
}
