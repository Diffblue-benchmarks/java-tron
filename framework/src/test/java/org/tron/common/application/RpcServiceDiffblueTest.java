package org.tron.common.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.core.services.RpcApiService;
import org.tron.core.services.interfaceOnPBFT.RpcApiServiceOnPBFT;

public class RpcServiceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcService#equals(Object)}
   *   <li>{@link RpcService#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    RpcApiService rpcApiService2 = new RpcApiService();

    // Act and Assert
    assertEquals(rpcApiService, rpcApiService2);
    int expectedHashCodeResult = rpcApiService.hashCode();
    assertEquals(expectedHashCodeResult, rpcApiService2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcService#equals(Object)}
   *   <li>{@link RpcService#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();

    // Act and Assert
    assertEquals(rpcApiService, rpcApiService);
    int expectedHashCodeResult = rpcApiService.hashCode();
    assertEquals(expectedHashCodeResult, rpcApiService.hashCode());
  }

  /**
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), 1);
    assertNotEquals(new RpcApiService(), mock(RpcApiServiceOnPBFT.class));
  }

  /**
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), null);
  }

  /**
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), "Different type to RpcService");
  }
}
