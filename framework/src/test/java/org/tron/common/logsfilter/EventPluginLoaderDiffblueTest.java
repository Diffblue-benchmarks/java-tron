package org.tron.common.logsfilter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class EventPluginLoaderDiffblueTest {
  /**
   * Test {@link EventPluginLoader#matchFilter(ContractTrigger)}.
   * <ul>
   *   <li>When {@link ContractTrigger} (default constructor) BlockNumber is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventPluginLoader#matchFilter(ContractTrigger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EventPluginLoader.matchFilter(ContractTrigger)"})
  public void testMatchFilter_whenContractTriggerBlockNumberIsOne_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    ContractTrigger trigger = new ContractTrigger();
    trigger.setAbi(ABI.getDefaultInstance());
    trigger.setBlockHash("Block Hash");
    trigger.setBlockNumber(1L);
    trigger.setCallerAddress("42 Main St");
    trigger.setContractAddress("42 Main St");
    trigger.setCreatorAddress("42 Main St");
    trigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    trigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    trigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    trigger.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    trigger.setRemoved(true);
    trigger.setTimeStamp(10L);
    trigger.setTransactionId("42");
    trigger.setTriggerName("Trigger Name");
    trigger.setUniqueId("42");

    // Act and Assert
    assertTrue(EventPluginLoader.matchFilter(trigger));
  }

  /**
   * Test {@link EventPluginLoader#start(EventPluginConfig)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link EventPluginConfig} (default constructor) UseNativeQueue is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventPluginLoader#start(EventPluginConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EventPluginLoader.start(EventPluginConfig)"})
  public void testStart_givenFalse_whenEventPluginConfigUseNativeQueueIsFalse_thenReturnFalse() {
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
   * Test new {@link EventPluginLoader} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EventPluginLoader}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventPluginLoader.<init>()"})
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
}
