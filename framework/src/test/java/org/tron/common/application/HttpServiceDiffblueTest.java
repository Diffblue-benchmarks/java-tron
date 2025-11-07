package org.tron.common.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.core.services.http.FullNodeHttpApiService;
import org.tron.core.services.http.solidity.SolidityNodeHttpApiService;

public class HttpServiceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HttpService#equals(Object)}
   *   <li>{@link HttpService#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullNodeHttpApiService fullNodeHttpApiService = new FullNodeHttpApiService();
    FullNodeHttpApiService fullNodeHttpApiService2 = new FullNodeHttpApiService();

    // Act and Assert
    assertEquals(fullNodeHttpApiService, fullNodeHttpApiService2);
    int expectedHashCodeResult = fullNodeHttpApiService.hashCode();
    assertEquals(expectedHashCodeResult, fullNodeHttpApiService2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HttpService#equals(Object)}
   *   <li>{@link HttpService#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullNodeHttpApiService fullNodeHttpApiService = new FullNodeHttpApiService();

    // Act and Assert
    assertEquals(fullNodeHttpApiService, fullNodeHttpApiService);
    int expectedHashCodeResult = fullNodeHttpApiService.hashCode();
    assertEquals(expectedHashCodeResult, fullNodeHttpApiService.hashCode());
  }

  /**
   * Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), "https://example.org/example");
    assertNotEquals(new FullNodeHttpApiService(), mock(SolidityNodeHttpApiService.class));
  }

  /**
   * Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), null);
  }

  /**
   * Method under test: {@link HttpService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullNodeHttpApiService(), "Different type to HttpService");
  }
}
