package org.tron.common.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.RpcApiService;

public class RpcServiceDiffblueTest {
  /**
   * Test {@link RpcService#equals(Object)}, and {@link RpcService#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcService#equals(Object)}
   *   <li>{@link RpcService#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcService.equals(Object)", "int RpcService.hashCode()"})
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
   * Test {@link RpcService#equals(Object)}, and {@link RpcService#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcService#equals(Object)}
   *   <li>{@link RpcService#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcService.equals(Object)", "int RpcService.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();

    // Act and Assert
    assertEquals(rpcApiService, rpcApiService);
    int expectedHashCodeResult = rpcApiService.hashCode();
    assertEquals(expectedHashCodeResult, rpcApiService.hashCode());
  }

  /**
   * Test {@link RpcService#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcService.equals(Object)", "int RpcService.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), 1);
  }

  /**
   * Test {@link RpcService#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcService.equals(Object)", "int RpcService.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), null);
  }

  /**
   * Test {@link RpcService#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcService#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RpcService.equals(Object)", "int RpcService.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcApiService(), "Different type to RpcService");
  }
}
