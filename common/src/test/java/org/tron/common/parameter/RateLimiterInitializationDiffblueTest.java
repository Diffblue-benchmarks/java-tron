package org.tron.common.parameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.typesafe.config.ConfigObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.parameter.RateLimiterInitialization.HttpRateLimiterItem;
import org.tron.common.parameter.RateLimiterInitialization.RpcRateLimiterItem;

public class RateLimiterInitializationDiffblueTest {
  /**
   * Test {@link RateLimiterInitialization#createHttpItem(ConfigObject)}.
   *
   * <p>Method under test: {@link RateLimiterInitialization#createHttpItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"HttpRateLimiterItem RateLimiterInitialization.createHttpItem(ConfigObject)"})
  public void testCreateHttpItem() {
    // Arrange, Act and Assert
    assertNull(RateLimiterInitialization.createHttpItem(null));
  }

  /**
   * Test {@link RateLimiterInitialization#createRpcItem(ConfigObject)}.
   *
   * <p>Method under test: {@link RateLimiterInitialization#createRpcItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RpcRateLimiterItem RateLimiterInitialization.createRpcItem(ConfigObject)"})
  public void testCreateRpcItem() {
    // Arrange, Act and Assert
    assertNull(RateLimiterInitialization.createRpcItem(null));
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_givenNull_whenArrayListAddNull() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    rateLimiterInitialization.setHttpMap(new ArrayList<>());
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    ArrayList<HttpRateLimiterItem> list = new ArrayList<>();
    list.add(null);

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   *
   * <ul>
   *   <li>Given {@link RateLimiterInitialization} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_givenRateLimiterInitialization_whenArrayList() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setHttpMap(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   *
   * <ul>
   *   <li>Then {@link RateLimiterInitialization} (default constructor) HttpMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_thenRateLimiterInitializationHttpMapSizeIsOne() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    rateLimiterInitialization.setHttpMap(new ArrayList<>());
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    ArrayList<HttpRateLimiterItem> list = new ArrayList<>();
    list.add(mock(HttpRateLimiterItem.class));

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert
    assertEquals(1, rateLimiterInitialization.getHttpMap().size());
    assertTrue(rateLimiterInitialization.isHttpFlag());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_givenNull_whenArrayListAddNull() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    rateLimiterInitialization.setHttpMap(new ArrayList<>());
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    ArrayList<RpcRateLimiterItem> list = new ArrayList<>();
    list.add(null);

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   *
   * <ul>
   *   <li>Given {@link RateLimiterInitialization} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_givenRateLimiterInitialization_whenArrayList() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   *
   * <ul>
   *   <li>Then {@link RateLimiterInitialization} (default constructor) RpcMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_thenRateLimiterInitializationRpcMapSizeIsOne() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    rateLimiterInitialization.setHttpMap(new ArrayList<>());
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    ArrayList<RpcRateLimiterItem> list = new ArrayList<>();
    list.add(mock(RpcRateLimiterItem.class));

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert
    assertEquals(1, rateLimiterInitialization.getRpcMap().size());
    assertTrue(rateLimiterInitialization.isRpcFlag());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RateLimiterInitialization}
   *   <li>{@link RateLimiterInitialization#getRpcMap()}
   *   <li>{@link RateLimiterInitialization#isHttpFlag()}
   *   <li>{@link RateLimiterInitialization#isRpcFlag()}
   *   <li>{@link RateLimiterInitialization#getHttpMap()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RateLimiterInitialization.<init>()",
    "Map RateLimiterInitialization.getHttpMap()",
    "Map RateLimiterInitialization.getRpcMap()",
    "boolean RateLimiterInitialization.isHttpFlag()",
    "boolean RateLimiterInitialization.isRpcFlag()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RateLimiterInitialization actualRateLimiterInitialization = new RateLimiterInitialization();
    Map<String, RpcRateLimiterItem> actualRpcMap = actualRateLimiterInitialization.getRpcMap();
    boolean actualIsHttpFlagResult = actualRateLimiterInitialization.isHttpFlag();

    // Assert
    assertFalse(actualIsHttpFlagResult);
    assertFalse(actualRateLimiterInitialization.isRpcFlag());
    assertTrue(actualRateLimiterInitialization.getHttpMap().isEmpty());
    assertTrue(actualRpcMap.isEmpty());
  }
}
