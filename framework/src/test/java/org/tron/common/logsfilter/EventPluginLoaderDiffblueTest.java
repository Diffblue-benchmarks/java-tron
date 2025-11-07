package org.tron.common.logsfilter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class EventPluginLoaderDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link EventPluginLoader}
   */
  @Test
  public void testNewEventPluginLoader() {
    // Arrange and Act
    EventPluginLoader actualEventPluginLoader = new EventPluginLoader();

    // Assert
    assertNull(actualEventPluginLoader.getFilterQuery());
    assertFalse(actualEventPluginLoader.isBlockLogTriggerEnable());
    assertFalse(actualEventPluginLoader.isBlockLogTriggerSolidified());
    assertFalse(actualEventPluginLoader.isContractEventTriggerEnable());
    assertFalse(actualEventPluginLoader.isContractLogTriggerEnable());
    assertFalse(actualEventPluginLoader.isContractLogTriggerRedundancy());
    assertFalse(actualEventPluginLoader.isSolidityEventTriggerEnable());
    assertFalse(actualEventPluginLoader.isSolidityLogTriggerEnable());
    assertFalse(actualEventPluginLoader.isSolidityLogTriggerRedundancy());
    assertFalse(actualEventPluginLoader.isSolidityTriggerEnable());
    assertFalse(actualEventPluginLoader.isTransactionLogTriggerEnable());
    assertFalse(actualEventPluginLoader.isTransactionLogTriggerEthCompatible());
    assertFalse(actualEventPluginLoader.isTransactionLogTriggerSolidified());
  }

  /**
   * Method under test: {@link EventPluginLoader#start(EventPluginConfig)}
   */
  @Test
  public void testStart() {
    // Arrange
    EventPluginLoader instance = EventPluginLoader.getInstance();

    EventPluginConfig config = new EventPluginConfig();
    config.setDbConfig("Db Config");
    config.setPluginPath("Plugin Path");
    config.setServerAddress("42 Main St");
    config.setTriggerConfigList(new ArrayList<>());
    config.setUseNativeQueue(false);
    config.setBindPort(0);
    config.setSendQueueLength(0);

    // Act and Assert
    assertFalse(instance.start(config));
  }

  /**
   * Method under test: {@link EventPluginLoader#stopPlugin()}
   */
  @Test
  public void testStopPlugin() {
    // Arrange
    FilterQuery filterQuery = mock(FilterQuery.class);
    doNothing().when(filterQuery).setContractAddressList(Mockito.<List<String>>any());
    doNothing().when(filterQuery).setContractTopicList(Mockito.<List<String>>any());
    doNothing().when(filterQuery).setFromBlock(anyLong());
    doNothing().when(filterQuery).setToBlock(anyLong());
    filterQuery.setContractAddressList(new ArrayList<>());
    filterQuery.setContractTopicList(new ArrayList<>());
    filterQuery.setFromBlock(1L);
    filterQuery.setToBlock(1L);
    EventPluginLoader instance = EventPluginLoader.getInstance();
    instance.setFilterQuery(filterQuery);

    // Act
    instance.stopPlugin();

    // Assert
    verify(filterQuery).setContractAddressList(isA(List.class));
    verify(filterQuery).setContractTopicList(isA(List.class));
    verify(filterQuery).setFromBlock(eq(1L));
    verify(filterQuery).setToBlock(eq(1L));
  }
}
