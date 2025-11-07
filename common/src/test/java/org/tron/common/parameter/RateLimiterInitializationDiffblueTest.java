package org.tron.common.parameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;

public class RateLimiterInitializationDiffblueTest {
  /**
   * Method under test:
   * {@link RateLimiterInitialization#createHttpItem(ConfigObject)}
   */
  @Test
  public void testCreateHttpItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RateLimiterInitialization.HttpRateLimiterItem actualCreateHttpItemResult = RateLimiterInitialization
        .createHttpItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualCreateHttpItemResult.getComponent());
    assertEquals("Unwrapped", actualCreateHttpItemResult.getParams());
    assertEquals("Unwrapped", actualCreateHttpItemResult.getStrategy());
  }

  /**
   * Method under test:
   * {@link RateLimiterInitialization#createRpcItem(ConfigObject)}
   */
  @Test
  public void testCreateRpcItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RateLimiterInitialization.RpcRateLimiterItem actualCreateRpcItemResult = RateLimiterInitialization
        .createRpcItem(asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualCreateRpcItemResult.getComponent());
    assertEquals("Unwrapped", actualCreateRpcItemResult.getParams());
    assertEquals("Unwrapped", actualCreateRpcItemResult.getStrategy());
  }

  /**
   * Method under test:
   * {@link RateLimiterInitialization.HttpRateLimiterItem#HttpRateLimiterItem(ConfigObject)}
   */
  @Test
  public void testHttpRateLimiterItemNewHttpRateLimiterItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RateLimiterInitialization.HttpRateLimiterItem actualHttpRateLimiterItem = new RateLimiterInitialization.HttpRateLimiterItem(
        asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getComponent());
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getParams());
    assertEquals("Unwrapped", actualHttpRateLimiterItem.getStrategy());
  }

  /**
   * Method under test:
   * {@link RateLimiterInitialization.RpcRateLimiterItem#RpcRateLimiterItem(ConfigObject)}
   */
  @Test
  public void testRpcRateLimiterItemNewRpcRateLimiterItem() {
    // Arrange
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);

    // Act
    RateLimiterInitialization.RpcRateLimiterItem actualRpcRateLimiterItem = new RateLimiterInitialization.RpcRateLimiterItem(
        asset);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getComponent());
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getParams());
    assertEquals("Unwrapped", actualRpcRateLimiterItem.getStrategy());
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  public void testSetHttpMap() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setHttpMap(new ArrayList<>());

    // Assert
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  public void testSetHttpMap2() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);
    RateLimiterInitialization.HttpRateLimiterItem httpRateLimiterItem = new RateLimiterInitialization.HttpRateLimiterItem(
        asset);

    ArrayList<RateLimiterInitialization.HttpRateLimiterItem> list = new ArrayList<>();
    list.add(httpRateLimiterItem);

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    Map<String, RateLimiterInitialization.HttpRateLimiterItem> httpMap = rateLimiterInitialization.getHttpMap();
    assertEquals(1, httpMap.size());
    assertTrue(rateLimiterInitialization.isHttpFlag());
    assertSame(httpRateLimiterItem, httpMap.get("Unwrapped"));
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  public void testSetHttpMap3() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<RateLimiterInitialization.HttpRateLimiterItem> list = new ArrayList<>();
    list.add(null);

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert
    assertFalse(rateLimiterInitialization.isHttpFlag());
    assertTrue(rateLimiterInitialization.getHttpMap().isEmpty());
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setHttpMap(List)}
   */
  @Test
  public void testSetHttpMap4() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);
    RateLimiterInitialization.HttpRateLimiterItem httpRateLimiterItem = new RateLimiterInitialization.HttpRateLimiterItem(
        asset);

    ArrayList<RateLimiterInitialization.HttpRateLimiterItem> list = new ArrayList<>();
    list.add(null);
    list.add(httpRateLimiterItem);

    // Act
    rateLimiterInitialization.setHttpMap(list);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    Map<String, RateLimiterInitialization.HttpRateLimiterItem> httpMap = rateLimiterInitialization.getHttpMap();
    assertEquals(1, httpMap.size());
    assertTrue(rateLimiterInitialization.isHttpFlag());
    assertSame(httpRateLimiterItem, httpMap.get("Unwrapped"));
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  public void testSetRpcMap() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    // Act
    rateLimiterInitialization.setRpcMap(new ArrayList<>());

    // Assert
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  public void testSetRpcMap2() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);
    RateLimiterInitialization.RpcRateLimiterItem rpcRateLimiterItem = new RateLimiterInitialization.RpcRateLimiterItem(
        asset);

    ArrayList<RateLimiterInitialization.RpcRateLimiterItem> list = new ArrayList<>();
    list.add(rpcRateLimiterItem);

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    Map<String, RateLimiterInitialization.RpcRateLimiterItem> rpcMap = rateLimiterInitialization.getRpcMap();
    assertEquals(1, rpcMap.size());
    assertTrue(rateLimiterInitialization.isRpcFlag());
    assertSame(rpcRateLimiterItem, rpcMap.get("Unwrapped"));
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  public void testSetRpcMap3() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();

    ArrayList<RateLimiterInitialization.RpcRateLimiterItem> list = new ArrayList<>();
    list.add(null);

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert
    assertFalse(rateLimiterInitialization.isRpcFlag());
    assertTrue(rateLimiterInitialization.getRpcMap().isEmpty());
  }

  /**
   * Method under test: {@link RateLimiterInitialization#setRpcMap(List)}
   */
  @Test
  public void testSetRpcMap4() {
    // Arrange
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenReturn("Unwrapped");
    ConfigObject asset = mock(ConfigObject.class);
    when(asset.get(Mockito.<Object>any())).thenReturn(configValue);
    RateLimiterInitialization.RpcRateLimiterItem rpcRateLimiterItem = new RateLimiterInitialization.RpcRateLimiterItem(
        asset);

    ArrayList<RateLimiterInitialization.RpcRateLimiterItem> list = new ArrayList<>();
    list.add(null);
    list.add(rpcRateLimiterItem);

    // Act
    rateLimiterInitialization.setRpcMap(list);

    // Assert
    verify(asset, atLeast(1)).get(Mockito.<Object>any());
    verify(configValue, atLeast(1)).unwrapped();
    Map<String, RateLimiterInitialization.RpcRateLimiterItem> rpcMap = rateLimiterInitialization.getRpcMap();
    assertEquals(1, rpcMap.size());
    assertTrue(rateLimiterInitialization.isRpcFlag());
    assertSame(rpcRateLimiterItem, rpcMap.get("Unwrapped"));
  }

  /**
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
  public void testGettersAndSetters() {
    // Arrange and Act
    RateLimiterInitialization actualRateLimiterInitialization = new RateLimiterInitialization();
    Map<String, RateLimiterInitialization.HttpRateLimiterItem> actualHttpMap = actualRateLimiterInitialization
        .getHttpMap();
    Map<String, RateLimiterInitialization.RpcRateLimiterItem> actualRpcMap = actualRateLimiterInitialization
        .getRpcMap();
    boolean actualIsHttpFlagResult = actualRateLimiterInitialization.isHttpFlag();

    // Assert
    assertFalse(actualIsHttpFlagResult);
    assertFalse(actualRateLimiterInitialization.isRpcFlag());
    assertTrue(actualHttpMap.isEmpty());
    assertTrue(actualRpcMap.isEmpty());
  }
}
