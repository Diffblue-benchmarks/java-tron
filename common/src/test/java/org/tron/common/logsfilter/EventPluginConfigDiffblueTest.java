package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class EventPluginConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EventPluginConfig}
   *   <li>{@link EventPluginConfig#setBindPort(int)}
   *   <li>{@link EventPluginConfig#setDbConfig(String)}
   *   <li>{@link EventPluginConfig#setPluginPath(String)}
   *   <li>{@link EventPluginConfig#setSendQueueLength(int)}
   *   <li>{@link EventPluginConfig#setServerAddress(String)}
   *   <li>{@link EventPluginConfig#setTriggerConfigList(List)}
   *   <li>{@link EventPluginConfig#setUseNativeQueue(boolean)}
   *   <li>{@link EventPluginConfig#getBindPort()}
   *   <li>{@link EventPluginConfig#getDbConfig()}
   *   <li>{@link EventPluginConfig#getPluginPath()}
   *   <li>{@link EventPluginConfig#getSendQueueLength()}
   *   <li>{@link EventPluginConfig#getServerAddress()}
   *   <li>{@link EventPluginConfig#getTriggerConfigList()}
   *   <li>{@link EventPluginConfig#isUseNativeQueue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EventPluginConfig actualEventPluginConfig = new EventPluginConfig();
    actualEventPluginConfig.setBindPort(8080);
    actualEventPluginConfig.setDbConfig("Db Config");
    actualEventPluginConfig.setPluginPath("Plugin Path");
    actualEventPluginConfig.setSendQueueLength(3);
    actualEventPluginConfig.setServerAddress("42 Main St");
    ArrayList<TriggerConfig> triggerConfigList = new ArrayList<>();
    actualEventPluginConfig.setTriggerConfigList(triggerConfigList);
    actualEventPluginConfig.setUseNativeQueue(true);
    int actualBindPort = actualEventPluginConfig.getBindPort();
    String actualDbConfig = actualEventPluginConfig.getDbConfig();
    String actualPluginPath = actualEventPluginConfig.getPluginPath();
    int actualSendQueueLength = actualEventPluginConfig.getSendQueueLength();
    String actualServerAddress = actualEventPluginConfig.getServerAddress();
    List<TriggerConfig> actualTriggerConfigList = actualEventPluginConfig.getTriggerConfigList();
    boolean actualIsUseNativeQueueResult = actualEventPluginConfig.isUseNativeQueue();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualServerAddress);
    assertEquals("Db Config", actualDbConfig);
    assertEquals("Plugin Path", actualPluginPath);
    assertEquals(3, actualSendQueueLength);
    assertEquals(8080, actualBindPort);
    assertTrue(actualTriggerConfigList.isEmpty());
    assertTrue(actualIsUseNativeQueueResult);
    assertSame(triggerConfigList, actualTriggerConfigList);
  }
}
