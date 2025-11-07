package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TypeMismatchNamingExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeMismatchNamingException#TypeMismatchNamingException(String)}
   *   <li>{@link TypeMismatchNamingException#getActualType()}
   *   <li>{@link TypeMismatchNamingException#getRequiredType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TypeMismatchNamingException actualTypeMismatchNamingException = new TypeMismatchNamingException("Explanation");
    Class<?> actualActualType = actualTypeMismatchNamingException.getActualType();

    // Assert
    assertEquals("Explanation", actualTypeMismatchNamingException.getMessage());
    assertNull(actualActualType);
    assertNull(actualTypeMismatchNamingException.getRequiredType());
    assertNull(actualTypeMismatchNamingException.getResolvedObj());
    assertNull(actualTypeMismatchNamingException.getCause());
    assertNull(actualTypeMismatchNamingException.getRootCause());
    assertNull(actualTypeMismatchNamingException.getRemainingName());
    assertNull(actualTypeMismatchNamingException.getResolvedName());
    assertEquals(0, actualTypeMismatchNamingException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TypeMismatchNamingException#TypeMismatchNamingException(String, Class, Class)}
   */
  @Test
  public void testNewTypeMismatchNamingException() {
    // Arrange
    Class<Object> requiredType = Object.class;
    Class<Object> actualType = Object.class;

    // Act
    TypeMismatchNamingException actualTypeMismatchNamingException = new TypeMismatchNamingException("Name",
        requiredType, actualType);

    // Assert
    assertEquals("Object of type [class java.lang.Object] available at store location [Name] is not assignable to"
        + " [java.lang.Object]", actualTypeMismatchNamingException.getLocalizedMessage());
    assertEquals("Object of type [class java.lang.Object] available at store location [Name] is not assignable to"
        + " [java.lang.Object]", actualTypeMismatchNamingException.getMessage());
    assertEquals("Object of type [class java.lang.Object] available at store location [Name] is not assignable to"
        + " [java.lang.Object]", actualTypeMismatchNamingException.getExplanation());
    assertNull(actualTypeMismatchNamingException.getResolvedObj());
    assertNull(actualTypeMismatchNamingException.getCause());
    assertNull(actualTypeMismatchNamingException.getRootCause());
    assertNull(actualTypeMismatchNamingException.getRemainingName());
    assertNull(actualTypeMismatchNamingException.getResolvedName());
    assertEquals(0, actualTypeMismatchNamingException.getSuppressed().length);
    Class<Object> expectedActualType = Object.class;
    Class<?> actualType2 = actualTypeMismatchNamingException.getActualType();
    assertEquals(expectedActualType, actualType2);
    assertSame(actualType, actualType2);
    assertSame(actualType, actualTypeMismatchNamingException.getRequiredType());
  }
}
