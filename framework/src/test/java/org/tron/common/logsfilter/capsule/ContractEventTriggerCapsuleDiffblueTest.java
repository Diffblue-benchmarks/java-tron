package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertArrayEquals;
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
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.runtime.LogEventWrapper;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractEventTriggerCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link ContractEventTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());
    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);

    // Act
    contractEventTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    assertEquals(1L, contractEventTriggerCapsule.getContractEventTrigger().getLatestSolidifiedBlockNumber());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ContractEventTriggerCapsule#setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry)}
   *   <li>
   * {@link ContractEventTriggerCapsule#setContractEventTrigger(ContractEventTrigger)}
   *   <li>{@link ContractEventTriggerCapsule#setData(byte[])}
   *   <li>{@link ContractEventTriggerCapsule#setTopicList(List)}
   *   <li>{@link ContractEventTriggerCapsule#getAbiEntry()}
   *   <li>{@link ContractEventTriggerCapsule#getContractEventTrigger()}
   *   <li>{@link ContractEventTriggerCapsule#getData()}
   *   <li>{@link ContractEventTriggerCapsule#getTopicList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    log.setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());
    log.setBlockHash("Block Hash");
    log.setBlockNumber(1L);
    log.setCallerAddress("42 Main St");
    log.setContractAddress("42 Main St");
    log.setCreatorAddress("42 Main St");
    log.setData("AXAXAXAX".getBytes("UTF-8"));
    log.setEventSignature("Event Signature");
    log.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    log.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    log.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    log.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    log.setRemoved(true);
    log.setTimeStamp(10L);
    log.setTopicList(new ArrayList<>());
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");
    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);
    SmartContractOuterClass.SmartContract.ABI.Entry abiEntry = SmartContractOuterClass.SmartContract.ABI.Entry
        .getDefaultInstance();

    // Act
    contractEventTriggerCapsule.setAbiEntry(abiEntry);
    ContractEventTrigger contractEventTrigger = new ContractEventTrigger();
    contractEventTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    contractEventTrigger.setBlockHash("Block Hash");
    contractEventTrigger.setBlockNumber(1L);
    contractEventTrigger.setCallerAddress("42 Main St");
    contractEventTrigger.setContractAddress("42 Main St");
    contractEventTrigger.setCreatorAddress("42 Main St");
    contractEventTrigger.setDataMap(new HashMap<>());
    contractEventTrigger.setEventName("Event Name");
    contractEventTrigger.setEventSignature("Event Signature");
    contractEventTrigger.setEventSignatureFull("Event Signature Full");
    contractEventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address3 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics3 = new ArrayList<>();
    contractEventTrigger.setLogInfo(new LogInfo(address3, topics3, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setOriginAddress("42 Main St");
    byte[] address4 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics4 = new ArrayList<>();
    contractEventTrigger.setRawData(new RawData(address4, topics4, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setRemoved(true);
    contractEventTrigger.setTimeStamp(10L);
    contractEventTrigger.setTopicMap(new HashMap<>());
    contractEventTrigger.setTransactionId("42");
    contractEventTrigger.setTriggerName("Trigger Name");
    contractEventTrigger.setUniqueId("42");
    contractEventTriggerCapsule.setContractEventTrigger(contractEventTrigger);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    contractEventTriggerCapsule.setData(data);
    ArrayList<byte[]> topicList = new ArrayList<>();
    contractEventTriggerCapsule.setTopicList(topicList);
    SmartContractOuterClass.SmartContract.ABI.Entry actualAbiEntry = contractEventTriggerCapsule.getAbiEntry();
    ContractEventTrigger actualContractEventTrigger = contractEventTriggerCapsule.getContractEventTrigger();
    byte[] actualData = contractEventTriggerCapsule.getData();

    // Assert that nothing has changed
    assertSame(topicList, contractEventTriggerCapsule.getTopicList());
    assertSame(contractEventTrigger, actualContractEventTrigger);
    assertSame(data, actualData);
    assertSame(abiEntry, actualAbiEntry);
  }

  /**
   * Method under test: {@link ContractEventTriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    ContractEventTrigger contractEventTrigger = new ContractEventTrigger();
    contractEventTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    contractEventTrigger.setBlockHash("Block Hash");
    contractEventTrigger.setBlockNumber(1L);
    contractEventTrigger.setCallerAddress("42 Main St");
    contractEventTrigger.setContractAddress("42 Main St");
    contractEventTrigger.setCreatorAddress("42 Main St");
    contractEventTrigger.setDataMap(new HashMap<>());
    contractEventTrigger.setEventName("Event Name");
    contractEventTrigger.setEventSignature("Event Signature");
    contractEventTrigger.setEventSignatureFull("Event Signature Full");
    contractEventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    contractEventTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    contractEventTrigger.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setRemoved(true);
    contractEventTrigger.setTimeStamp(10L);
    contractEventTrigger.setTopicMap(new HashMap<>());
    contractEventTrigger.setTransactionId("42");
    contractEventTrigger.setTriggerName("Trigger Name");
    contractEventTrigger.setUniqueId("42");

    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);
    contractEventTriggerCapsule.setContractEventTrigger(contractEventTrigger);

    // Act
    contractEventTriggerCapsule.processTrigger();

    // Assert
    assertSame(contractEventTrigger, contractEventTriggerCapsule.getContractEventTrigger());
  }

  /**
   * Method under test: {@link ContractEventTriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger2() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    HashMap<String, String> dataMap = new HashMap<>();
    dataMap.computeIfPresent("invalid filter: fromBlockNumber: {}, toBlockNumber: {}", mock(BiFunction.class));

    ContractEventTrigger contractEventTrigger = new ContractEventTrigger();
    contractEventTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    contractEventTrigger.setBlockHash("Block Hash");
    contractEventTrigger.setBlockNumber(1L);
    contractEventTrigger.setCallerAddress("42 Main St");
    contractEventTrigger.setContractAddress("42 Main St");
    contractEventTrigger.setCreatorAddress("42 Main St");
    contractEventTrigger.setDataMap(dataMap);
    contractEventTrigger.setEventName("Event Name");
    contractEventTrigger.setEventSignature("Event Signature");
    contractEventTrigger.setEventSignatureFull("Event Signature Full");
    contractEventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    contractEventTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    contractEventTrigger.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    contractEventTrigger.setRemoved(true);
    contractEventTrigger.setTimeStamp(10L);
    contractEventTrigger.setTopicMap(new HashMap<>());
    contractEventTrigger.setTransactionId("42");
    contractEventTrigger.setTriggerName("Trigger Name");
    contractEventTrigger.setUniqueId("42");

    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);
    contractEventTriggerCapsule.setContractEventTrigger(contractEventTrigger);

    // Act
    contractEventTriggerCapsule.processTrigger();

    // Assert
    assertSame(contractEventTrigger, contractEventTriggerCapsule.getContractEventTrigger());
  }

  /**
   * Method under test:
   * {@link ContractEventTriggerCapsule#ContractEventTriggerCapsule(LogEventWrapper)}
   */
  @Test
  public void testNewContractEventTriggerCapsule() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    SmartContractOuterClass.SmartContract.ABI.Entry abiEntry = SmartContractOuterClass.SmartContract.ABI.Entry
        .getDefaultInstance();
    log.setAbiEntry(abiEntry);
    log.setBlockHash("Block Hash");
    log.setBlockNumber(1L);
    log.setCallerAddress("42 Main St");
    log.setContractAddress("42 Main St");
    log.setCreatorAddress("42 Main St");
    log.setData("AXAXAXAX".getBytes("UTF-8"));
    log.setEventSignature("Event Signature");
    log.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    log.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    log.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    log.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    log.setRemoved(true);
    log.setTimeStamp(10L);
    ArrayList<byte[]> topicList = new ArrayList<>();
    log.setTopicList(topicList);
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");

    // Act
    ContractEventTriggerCapsule actualContractEventTriggerCapsule = new ContractEventTriggerCapsule(log);

    // Assert
    ContractEventTrigger contractEventTrigger = actualContractEventTriggerCapsule.getContractEventTrigger();
    assertEquals("", contractEventTrigger.getEventName());
    assertEquals("()", contractEventTrigger.getEventSignatureFull());
    assertEquals("42 Main St", contractEventTrigger.getCallerAddress());
    assertEquals("42 Main St", contractEventTrigger.getContractAddress());
    assertEquals("42 Main St", contractEventTrigger.getCreatorAddress());
    assertEquals("42 Main St", contractEventTrigger.getOriginAddress());
    assertEquals("42", contractEventTrigger.getTransactionId());
    assertEquals("42", contractEventTrigger.getUniqueId());
    assertEquals("Event Signature", contractEventTrigger.getEventSignature());
    assertEquals("contractEventTrigger", contractEventTrigger.getTriggerName());
    assertNull(contractEventTrigger.getBlockHash());
    assertNull(contractEventTrigger.getDataMap());
    assertNull(contractEventTrigger.getTopicMap());
    assertNull(contractEventTrigger.getRawData());
    assertNull(contractEventTrigger.getLogInfo());
    assertNull(contractEventTrigger.getAbi());
    assertEquals(0L, contractEventTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(10L, contractEventTrigger.getTimeStamp());
    assertEquals(1L, contractEventTrigger.getBlockNumber().longValue());
    assertFalse(contractEventTrigger.isRemoved());
    List<byte[]> topicList2 = actualContractEventTriggerCapsule.getTopicList();
    assertTrue(topicList2.isEmpty());
    assertSame(topicList, topicList2);
    assertSame(abiEntry, actualContractEventTriggerCapsule.getAbiEntry());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualContractEventTriggerCapsule.getData());
  }
}
