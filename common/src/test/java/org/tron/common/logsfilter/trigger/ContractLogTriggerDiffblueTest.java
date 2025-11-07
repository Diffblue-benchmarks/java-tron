package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.Test;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractLogTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContractLogTrigger#setData(String)}
   *   <li>{@link ContractLogTrigger#setTopicList(List)}
   *   <li>{@link ContractLogTrigger#getData()}
   *   <li>{@link ContractLogTrigger#getTopicList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ContractLogTrigger contractLogTrigger = new ContractLogTrigger();

    // Act
    contractLogTrigger.setData("Data");
    ArrayList<String> topicList = new ArrayList<>();
    contractLogTrigger.setTopicList(topicList);
    String actualData = contractLogTrigger.getData();
    List<String> actualTopicList = contractLogTrigger.getTopicList();

    // Assert that nothing has changed
    assertEquals("Data", actualData);
    assertTrue(actualTopicList.isEmpty());
    assertSame(topicList, actualTopicList);
  }

  /**
   * Method under test: {@link ContractLogTrigger#ContractLogTrigger()}
   */
  @Test
  public void testNewContractLogTrigger() {
    // Arrange and Act
    ContractLogTrigger actualContractLogTrigger = new ContractLogTrigger();

    // Assert
    assertNull(actualContractLogTrigger.getBlockNumber());
    assertNull(actualContractLogTrigger.getData());
    assertNull(actualContractLogTrigger.getBlockHash());
    assertNull(actualContractLogTrigger.getCallerAddress());
    assertNull(actualContractLogTrigger.getContractAddress());
    assertNull(actualContractLogTrigger.getCreatorAddress());
    assertNull(actualContractLogTrigger.getOriginAddress());
    assertNull(actualContractLogTrigger.getTransactionId());
    assertNull(actualContractLogTrigger.getUniqueId());
    assertNull(actualContractLogTrigger.getTopicList());
    assertNull(actualContractLogTrigger.getRawData());
    assertNull(actualContractLogTrigger.getLogInfo());
    assertNull(actualContractLogTrigger.getAbi());
    assertEquals(0L, actualContractLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualContractLogTrigger.getTimeStamp());
    assertFalse(actualContractLogTrigger.isRemoved());
    assertEquals(Trigger.CONTRACTLOG_TRIGGER_NAME, actualContractLogTrigger.getTriggerName());
  }

  /**
   * Method under test:
   * {@link ContractLogTrigger#ContractLogTrigger(ContractEventTrigger)}
   */
  @Test
  public void testNewContractLogTrigger2() throws UnsupportedEncodingException {
    // Arrange
    ContractEventTrigger eventTrigger = new ContractEventTrigger();
    eventTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    eventTrigger.setBlockHash("Block Hash");
    eventTrigger.setBlockNumber(1L);
    eventTrigger.setCallerAddress("42 Main St");
    eventTrigger.setContractAddress("42 Main St");
    eventTrigger.setCreatorAddress("42 Main St");
    eventTrigger.setDataMap(new HashMap<>());
    eventTrigger.setEventName("Event Name");
    eventTrigger.setEventSignature("Event Signature");
    eventTrigger.setEventSignatureFull("Event Signature Full");
    eventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    eventTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    eventTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    RawData rawData = new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8"));

    eventTrigger.setRawData(rawData);
    eventTrigger.setRemoved(true);
    eventTrigger.setTimeStamp(10L);
    eventTrigger.setTopicMap(new HashMap<>());
    eventTrigger.setTransactionId("42");
    eventTrigger.setTriggerName("Trigger Name");
    eventTrigger.setUniqueId("42");

    // Act
    ContractLogTrigger actualContractLogTrigger = new ContractLogTrigger(eventTrigger);

    // Assert
    assertEquals("", actualContractLogTrigger.getCallerAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getContractAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getCreatorAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getOriginAddress());
    assertEquals("42", actualContractLogTrigger.getTransactionId());
    assertEquals("42", actualContractLogTrigger.getUniqueId());
    assertEquals("Block Hash", actualContractLogTrigger.getBlockHash());
    assertNull(actualContractLogTrigger.getData());
    assertNull(actualContractLogTrigger.getTopicList());
    assertNull(actualContractLogTrigger.getLogInfo());
    assertNull(actualContractLogTrigger.getAbi());
    assertEquals(10L, actualContractLogTrigger.getTimeStamp());
    assertEquals(1L, actualContractLogTrigger.getBlockNumber().longValue());
    assertEquals(1L, actualContractLogTrigger.getLatestSolidifiedBlockNumber());
    assertTrue(actualContractLogTrigger.isRemoved());
    assertEquals(Trigger.CONTRACTLOG_TRIGGER_NAME, actualContractLogTrigger.getTriggerName());
    assertSame(rawData, actualContractLogTrigger.getRawData());
  }

  /**
   * Method under test:
   * {@link ContractLogTrigger#ContractLogTrigger(ContractEventTrigger)}
   */
  @Test
  public void testNewContractLogTrigger3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> dataMap = new HashMap<>();
    dataMap.computeIfPresent(Trigger.CONTRACTLOG_TRIGGER_NAME, mock(BiFunction.class));

    ContractEventTrigger eventTrigger = new ContractEventTrigger();
    eventTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    eventTrigger.setBlockHash("Block Hash");
    eventTrigger.setBlockNumber(1L);
    eventTrigger.setCallerAddress("42 Main St");
    eventTrigger.setContractAddress("42 Main St");
    eventTrigger.setCreatorAddress("42 Main St");
    eventTrigger.setDataMap(dataMap);
    eventTrigger.setEventName("Event Name");
    eventTrigger.setEventSignature("Event Signature");
    eventTrigger.setEventSignatureFull("Event Signature Full");
    eventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    eventTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    eventTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    RawData rawData = new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8"));

    eventTrigger.setRawData(rawData);
    eventTrigger.setRemoved(true);
    eventTrigger.setTimeStamp(10L);
    eventTrigger.setTopicMap(new HashMap<>());
    eventTrigger.setTransactionId("42");
    eventTrigger.setTriggerName("Trigger Name");
    eventTrigger.setUniqueId("42");

    // Act
    ContractLogTrigger actualContractLogTrigger = new ContractLogTrigger(eventTrigger);

    // Assert
    assertEquals("", actualContractLogTrigger.getCallerAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getContractAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getCreatorAddress());
    assertEquals("42 Main St", actualContractLogTrigger.getOriginAddress());
    assertEquals("42", actualContractLogTrigger.getTransactionId());
    assertEquals("42", actualContractLogTrigger.getUniqueId());
    assertEquals("Block Hash", actualContractLogTrigger.getBlockHash());
    assertNull(actualContractLogTrigger.getData());
    assertNull(actualContractLogTrigger.getTopicList());
    assertNull(actualContractLogTrigger.getLogInfo());
    assertNull(actualContractLogTrigger.getAbi());
    assertEquals(10L, actualContractLogTrigger.getTimeStamp());
    assertEquals(1L, actualContractLogTrigger.getBlockNumber().longValue());
    assertEquals(1L, actualContractLogTrigger.getLatestSolidifiedBlockNumber());
    assertTrue(actualContractLogTrigger.isRemoved());
    assertEquals(Trigger.CONTRACTLOG_TRIGGER_NAME, actualContractLogTrigger.getTriggerName());
    assertSame(rawData, actualContractLogTrigger.getRawData());
  }
}
