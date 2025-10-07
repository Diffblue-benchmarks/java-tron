package org.tron.common.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.http.FullNodeHttpApiService;

public class HttpServiceDiffblueTest {
  /**
   * Test {@link HttpService#equals(Object)}, and {@link HttpService#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HttpService#equals(Object)}
   *   <li>{@link HttpService#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HttpService.equals(Object)", "int HttpService.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullNodeHttpApiService fullNodeHttpApiService = new FullNodeHttpApiService();
    FullNodeHttpApiService fullNodeHttpApiService2 = new FullNodeHttpApiService();

    // Act and Assert
    assertEquals(fullNodeHttpApiService, fullNodeHttpApiService2);
    assertEquals(fullNodeHttpApiService.hashCode(), fullNodeHttpApiService2.hashCode());
  }

  /**
   * Test {@link HttpService#equals(Object)}, and {@link HttpService#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HttpService#equals(Object)}
   *   <li>{@link HttpService#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HttpService.equals(Object)", "int HttpService.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullNodeHttpApiService fullNodeHttpApiService = new FullNodeHttpApiService();

    // Act and Assert
    assertEquals(fullNodeHttpApiService, fullNodeHttpApiService);
    int expectedHashCodeResult = fullNodeHttpApiService.hashCode();
    assertEquals(expectedHashCodeResult, fullNodeHttpApiService.hashCode());
  }

  /**
   * Test {@link HttpService#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HttpService.equals(Object)", "int HttpService.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), "https://example.org/example");
  }

  /**
   * Test {@link HttpService#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HttpService.equals(Object)", "int HttpService.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), null);
  }

  /**
   * Test {@link HttpService#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HttpService.equals(Object)", "int HttpService.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), "Different type to HttpService");
  }
}
