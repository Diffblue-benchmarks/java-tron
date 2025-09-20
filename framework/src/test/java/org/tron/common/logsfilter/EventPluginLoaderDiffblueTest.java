package org.tron.common.logsfilter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class EventPluginLoaderDiffblueTest {
  /**
   * Test {@link EventPluginLoader#getInstance()}.
   *
   * <p>Method under test: {@link EventPluginLoader#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EventPluginLoader EventPluginLoader.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    EventPluginLoader actualInstance = EventPluginLoader.getInstance();

    // Assert
    assertFalse(actualInstance.isBlockLogTriggerEnable());
    assertFalse(actualInstance.isBlockLogTriggerSolidified());
    assertFalse(actualInstance.isContractEventTriggerEnable());
    assertFalse(actualInstance.isContractLogTriggerEnable());
    assertFalse(actualInstance.isContractLogTriggerRedundancy());
    assertFalse(actualInstance.isSolidityEventTriggerEnable());
    assertFalse(actualInstance.isSolidityLogTriggerEnable());
    assertFalse(actualInstance.isSolidityLogTriggerRedundancy());
    assertFalse(actualInstance.isSolidityTriggerEnable());
    assertFalse(actualInstance.isTransactionLogTriggerEnable());
    assertFalse(actualInstance.isTransactionLogTriggerEthCompatible());
    assertFalse(actualInstance.isTransactionLogTriggerSolidified());
  }

  /**
   * Test {@link EventPluginLoader#matchFilter(ContractTrigger)}.
   *
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.
   *   <li>When {@link ContractTrigger} (default constructor) BlockNumber is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link EventPluginLoader#matchFilter(ContractTrigger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EventPluginLoader.matchFilter(ContractTrigger)"})
  public void testMatchFilter_givenMax_value_whenContractTriggerBlockNumberIsMax_value()
      throws UnsupportedEncodingException {
    // Arrange
    ContractTrigger trigger = new ContractTrigger();
    trigger.setAbi(ABI.getDefaultInstance());
    trigger.setBlockHash("Block Hash");
    trigger.setBlockNumber(Long.MAX_VALUE);
    trigger.setCallerAddress("42 Main St");
    trigger.setContractAddress("42 Main St");
    trigger.setCreatorAddress("42 Main St");
    trigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setLogInfo(logInfo);
    trigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setRawData(rawData);
    trigger.setRemoved(true);
    trigger.setTimeStamp(10L);
    trigger.setTransactionId("42");
    trigger.setTriggerName("Trigger Name");
    trigger.setUniqueId("42");

    // Act and Assert
    assertFalse(EventPluginLoader.matchFilter(trigger));
  }

  /**
   * Test {@link EventPluginLoader#matchFilter(ContractTrigger)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link ContractTrigger} (default constructor) BlockNumber is minus one.
   * </ul>
   *
   * <p>Method under test: {@link EventPluginLoader#matchFilter(ContractTrigger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EventPluginLoader.matchFilter(ContractTrigger)"})
  public void testMatchFilter_givenMinusOne_whenContractTriggerBlockNumberIsMinusOne()
      throws UnsupportedEncodingException {
    // Arrange
    ContractTrigger trigger = new ContractTrigger();
    trigger.setAbi(ABI.getDefaultInstance());
    trigger.setBlockHash("Block Hash");
    trigger.setBlockNumber(-1L);
    trigger.setCallerAddress("42 Main St");
    trigger.setContractAddress("42 Main St");
    trigger.setCreatorAddress("42 Main St");
    trigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setLogInfo(logInfo);
    trigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setRawData(rawData);
    trigger.setRemoved(true);
    trigger.setTimeStamp(10L);
    trigger.setTransactionId("42");
    trigger.setTriggerName("Trigger Name");
    trigger.setUniqueId("42");

    // Act and Assert
    assertFalse(EventPluginLoader.matchFilter(trigger));
  }

  /**
   * Test {@link EventPluginLoader#matchFilter(ContractTrigger)}.
   *
   * <ul>
   *   <li>When {@link ContractTrigger} (default constructor) BlockNumber is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EventPluginLoader#matchFilter(ContractTrigger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EventPluginLoader.matchFilter(ContractTrigger)"})
  public void testMatchFilter_whenContractTriggerBlockNumberIsOne_thenReturnTrue()
      throws UnsupportedEncodingException {
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
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setLogInfo(logInfo);
    trigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    trigger.setRawData(rawData);
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
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link EventPluginConfig} (default constructor) UseNativeQueue is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EventPluginLoader#start(EventPluginConfig)}
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventPluginLoader#setFilterQuery(FilterQuery)}
   *   <li>{@link EventPluginLoader#getFilterQuery()}
   *   <li>{@link EventPluginLoader#isBlockLogTriggerEnable()}
   *   <li>{@link EventPluginLoader#isBlockLogTriggerSolidified()}
   *   <li>{@link EventPluginLoader#isContractEventTriggerEnable()}
   *   <li>{@link EventPluginLoader#isContractLogTriggerEnable()}
   *   <li>{@link EventPluginLoader#isContractLogTriggerRedundancy()}
   *   <li>{@link EventPluginLoader#isSolidityEventTriggerEnable()}
   *   <li>{@link EventPluginLoader#isSolidityLogTriggerEnable()}
   *   <li>{@link EventPluginLoader#isSolidityLogTriggerRedundancy()}
   *   <li>{@link EventPluginLoader#isSolidityTriggerEnable()}
   *   <li>{@link EventPluginLoader#isTransactionLogTriggerEnable()}
   *   <li>{@link EventPluginLoader#isTransactionLogTriggerEthCompatible()}
   *   <li>{@link EventPluginLoader#isTransactionLogTriggerSolidified()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "FilterQuery EventPluginLoader.getFilterQuery()",
    "boolean EventPluginLoader.isBlockLogTriggerEnable()",
    "boolean EventPluginLoader.isBlockLogTriggerSolidified()",
    "boolean EventPluginLoader.isContractEventTriggerEnable()",
    "boolean EventPluginLoader.isContractLogTriggerEnable()",
    "boolean EventPluginLoader.isContractLogTriggerRedundancy()",
    "boolean EventPluginLoader.isSolidityEventTriggerEnable()",
    "boolean EventPluginLoader.isSolidityLogTriggerEnable()",
    "boolean EventPluginLoader.isSolidityLogTriggerRedundancy()",
    "boolean EventPluginLoader.isSolidityTriggerEnable()",
    "boolean EventPluginLoader.isTransactionLogTriggerEnable()",
    "boolean EventPluginLoader.isTransactionLogTriggerEthCompatible()",
    "boolean EventPluginLoader.isTransactionLogTriggerSolidified()",
    "void EventPluginLoader.setFilterQuery(FilterQuery)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EventPluginLoader instance = EventPluginLoader.getInstance();

    FilterQuery filterQuery = new FilterQuery();
    filterQuery.setContractAddressList(new ArrayList<>());
    filterQuery.setContractTopicList(new ArrayList<>());
    filterQuery.setFromBlock(1L);
    filterQuery.setToBlock(1L);

    // Act
    instance.setFilterQuery(filterQuery);
    FilterQuery actualFilterQuery = instance.getFilterQuery();
    boolean actualIsBlockLogTriggerEnableResult = instance.isBlockLogTriggerEnable();
    boolean actualIsBlockLogTriggerSolidifiedResult = instance.isBlockLogTriggerSolidified();
    boolean actualIsContractEventTriggerEnableResult = instance.isContractEventTriggerEnable();
    boolean actualIsContractLogTriggerEnableResult = instance.isContractLogTriggerEnable();
    boolean actualIsContractLogTriggerRedundancyResult = instance.isContractLogTriggerRedundancy();
    boolean actualIsSolidityEventTriggerEnableResult = instance.isSolidityEventTriggerEnable();
    boolean actualIsSolidityLogTriggerEnableResult = instance.isSolidityLogTriggerEnable();
    boolean actualIsSolidityLogTriggerRedundancyResult = instance.isSolidityLogTriggerRedundancy();
    boolean actualIsSolidityTriggerEnableResult = instance.isSolidityTriggerEnable();
    boolean actualIsTransactionLogTriggerEnableResult = instance.isTransactionLogTriggerEnable();
    boolean actualIsTransactionLogTriggerEthCompatibleResult =
        instance.isTransactionLogTriggerEthCompatible();

    // Assert
    assertFalse(actualIsBlockLogTriggerEnableResult);
    assertFalse(actualIsBlockLogTriggerSolidifiedResult);
    assertFalse(actualIsContractEventTriggerEnableResult);
    assertFalse(actualIsContractLogTriggerEnableResult);
    assertFalse(actualIsContractLogTriggerRedundancyResult);
    assertFalse(actualIsSolidityEventTriggerEnableResult);
    assertFalse(actualIsSolidityLogTriggerEnableResult);
    assertFalse(actualIsSolidityLogTriggerRedundancyResult);
    assertFalse(actualIsSolidityTriggerEnableResult);
    assertFalse(actualIsTransactionLogTriggerEnableResult);
    assertFalse(actualIsTransactionLogTriggerEthCompatibleResult);
    assertFalse(instance.isTransactionLogTriggerSolidified());
    assertSame(filterQuery, actualFilterQuery);
  }

  /**
   * Test new {@link EventPluginLoader} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EventPluginLoader}
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
