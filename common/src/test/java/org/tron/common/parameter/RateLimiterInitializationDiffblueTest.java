package org.tron.common.parameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.parameter.RateLimiterInitialization.HttpRateLimiterItem;
import org.tron.common.parameter.RateLimiterInitialization.RpcRateLimiterItem;

public class RateLimiterInitializationDiffblueTest {
  /**
   * Test {@link RateLimiterInitialization#createHttpItem(ConfigObject)}.
   * <p>
   * Method under test: {@link RateLimiterInitialization#createHttpItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"HttpRateLimiterItem RateLimiterInitialization.createHttpItem(ConfigObject)"})
  public void testCreateHttpItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    HttpRateLimiterItem actualCreateHttpItemResult = RateLimiterInitialization.createHttpItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualCreateHttpItemResult.getComponent());
    assertEquals("Unwrapped", actualCreateHttpItemResult.getParams());
    assertEquals("Unwrapped", actualCreateHttpItemResult.getStrategy());
  }

  /**
   * Test {@link RateLimiterInitialization#createRpcItem(ConfigObject)}.
   * <p>
   * Method under test: {@link RateLimiterInitialization#createRpcItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RpcRateLimiterItem RateLimiterInitialization.createRpcItem(ConfigObject)"})
  public void testCreateRpcItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RpcRateLimiterItem actualCreateRpcItemResult = RateLimiterInitialization.createRpcItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualCreateRpcItemResult.getComponent());
    assertEquals("Unwrapped", actualCreateRpcItemResult.getParams());
    assertEquals("Unwrapped", actualCreateRpcItemResult.getStrategy());
  }

  /**
   * Test HttpRateLimiterItem {@link HttpRateLimiterItem#HttpRateLimiterItem(ConfigObject)}.
   * <p>
   * Method under test: {@link HttpRateLimiterItem#HttpRateLimiterItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpRateLimiterItem.<init>(ConfigObject)"})
  public void testHttpRateLimiterItemNewHttpRateLimiterItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    HttpRateLimiterItem actualHttpRateLimiterItem = new HttpRateLimiterItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getComponent());
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getParams());
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getStrategy());
  }

  /**
   * Test RpcRateLimiterItem {@link RpcRateLimiterItem#RpcRateLimiterItem(ConfigObject)}.
   * <p>
   * Method under test: {@link RpcRateLimiterItem#RpcRateLimiterItem(ConfigObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcRateLimiterItem.<init>(ConfigObject)"})
  public void testRpcRateLimiterItemNewRpcRateLimiterItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RpcRateLimiterItem actualRpcRateLimiterItem = new RpcRateLimiterItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getComponent());
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getParams());
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getStrategy());
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_givenNull_whenArrayListAddNull() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_givenNull_whenArrayListAddNull2() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<HttpRateLimiterItem> list = new ArrayList<>();
    list.add(null);
    list.add(null);

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   * <ul>
   *   <li>Then {@link RateLimiterInitialization} (default constructor) HttpMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_thenRateLimiterInitializationHttpMapSizeIsOne() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<HttpRateLimiterItem> list = new ArrayList<>();
    list.add(mock(HttpRateLimiterItem.class));

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert
    assertEquals(1, rateLimiterInitialization.getHttpMap().size());
    assertTrue(rateLimiterInitialization.isHttpFlag());
  }

  /**
   * Test {@link RateLimiterInitialization#setHttpMap(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then not {@link RateLimiterInitialization} (default constructor) HttpFlag.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setHttpMap(List)"})
  public void testSetHttpMap_whenArrayList_thenNotRateLimiterInitializationHttpFlag() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setHttpMap(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_givenNull_whenArrayListAddNull() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_givenNull_whenArrayListAddNull2() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<RpcRateLimiterItem> list = new ArrayList<>();
    list.add(null);
    list.add(null);

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   * <ul>
   *   <li>Then {@link RateLimiterInitialization} (default constructor) RpcMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_thenRateLimiterInitializationRpcMapSizeIsOne() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<RpcRateLimiterItem> list = new ArrayList<>();
    list.add(mock(RpcRateLimiterItem.class));

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert
    assertEquals(1, rateLimiterInitialization.getRpcMap().size());
    assertTrue(rateLimiterInitialization.isRpcFlag());
  }

  /**
   * Test {@link RateLimiterInitialization#setRpcMap(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then not {@link RateLimiterInitialization} (default constructor) RpcFlag.</li>
   * </ul>
   * <p>
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.setRpcMap(List)"})
  public void testSetRpcMap_whenArrayList_thenNotRateLimiterInitializationRpcFlag() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RateLimiterInitialization}
   *   <li>{@link RateLimiterInitialization#getHttpMap()}
   *   <li>{@link RateLimiterInitialization#getRpcMap()}
   *   <li>{@link RateLimiterInitialization#isHttpFlag()}
   *   <li>{@link RateLimiterInitialization#isRpcFlag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RateLimiterInitialization.<init>()", "Map RateLimiterInitialization.getHttpMap()",
      "Map RateLimiterInitialization.getRpcMap()", "boolean RateLimiterInitialization.isHttpFlag()",
      "boolean RateLimiterInitialization.isRpcFlag()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    RateLimiterInitialization actualRateLimiterInitialization = new RateLimiterInitialization();
    Map<String, HttpRateLimiterItem> actualHttpMap = actualRateLimiterInitialization.getHttpMap();
    Map<String, RpcRateLimiterItem> actualRpcMap = actualRateLimiterInitialization.getRpcMap();
    boolean actualIsHttpFlagResult = actualRateLimiterInitialization.isHttpFlag();

    // Assert
    assertFalse(actualIsHttpFlagResult);
    assertFalse(actualRateLimiterInitialization.isRpcFlag());
    assertTrue(actualHttpMap.isEmpty());
    assertTrue(actualRpcMap.isEmpty());
  }
}
