package org.tron.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeMismatchNamingExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeMismatchNamingException#TypeMismatchNamingException(String)}
   *   <li>{@link TypeMismatchNamingException#getActualType()}
   *   <li>{@link TypeMismatchNamingException#getRequiredType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypeMismatchNamingException.<init>(String)",
      "Class TypeMismatchNamingException.getActualType()", "Class TypeMismatchNamingException.getRequiredType()"})
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
   * Test {@link TypeMismatchNamingException#TypeMismatchNamingException(String, Class, Class)}.
   * <p>
   * Method under test: {@link TypeMismatchNamingException#TypeMismatchNamingException(String, Class, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypeMismatchNamingException.<init>(String, Class, Class)"})
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
    assertEquals(expectedActualType, actualTypeMismatchNamingException.getActualType());
    assertSame(actualType, actualTypeMismatchNamingException.getRequiredType());
  }
}
