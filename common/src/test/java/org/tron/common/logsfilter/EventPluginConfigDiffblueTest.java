package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EventPluginConfigDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EventPluginConfig.<init>()",
    "int EventPluginConfig.getBindPort()",
    "String EventPluginConfig.getDbConfig()",
    "String EventPluginConfig.getPluginPath()",
    "int EventPluginConfig.getSendQueueLength()",
    "String EventPluginConfig.getServerAddress()",
    "List EventPluginConfig.getTriggerConfigList()",
    "boolean EventPluginConfig.isUseNativeQueue()",
    "void EventPluginConfig.setBindPort(int)",
    "void EventPluginConfig.setDbConfig(String)",
    "void EventPluginConfig.setPluginPath(String)",
    "void EventPluginConfig.setSendQueueLength(int)",
    "void EventPluginConfig.setServerAddress(String)",
    "void EventPluginConfig.setTriggerConfigList(List)",
    "void EventPluginConfig.setUseNativeQueue(boolean)"
  })
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

    // Assert
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
