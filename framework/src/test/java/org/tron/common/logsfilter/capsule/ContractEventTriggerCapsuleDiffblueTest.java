package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.runtime.LogEventWrapper;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class ContractEventTriggerCapsuleDiffblueTest {
  /**
   * Test {@link ContractEventTriggerCapsule#ContractEventTriggerCapsule(LogEventWrapper)}.
   * <ul>
   *   <li>Then return TopicList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventTriggerCapsule#ContractEventTriggerCapsule(LogEventWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractEventTriggerCapsule.<init>(LogEventWrapper)"})
  public void testNewContractEventTriggerCapsule_thenReturnTopicListEmpty() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbi(ABI.getDefaultInstance());
    Entry abiEntry = Entry.getDefaultInstance();
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
    log.setTopicList(new ArrayList<>());
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");

    // Act
    ContractEventTriggerCapsule actualContractEventTriggerCapsule = new ContractEventTriggerCapsule(log);

    // Assert
    assertTrue(actualContractEventTriggerCapsule.getTopicList().isEmpty());
    assertSame(abiEntry, actualContractEventTriggerCapsule.getAbiEntry());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualContractEventTriggerCapsule.getData());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContractEventTriggerCapsule#setContractEventTrigger(ContractEventTrigger)}
   *   <li>{@link ContractEventTriggerCapsule#setData(byte[])}
   *   <li>{@link ContractEventTriggerCapsule#setTopicList(List)}
   *   <li>{@link ContractEventTriggerCapsule#getAbiEntry()}
   *   <li>{@link ContractEventTriggerCapsule#getContractEventTrigger()}
   *   <li>{@link ContractEventTriggerCapsule#getData()}
   *   <li>{@link ContractEventTriggerCapsule#getTopicList()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ContractEventTriggerCapsule.getAbiEntry()",
      "ContractEventTrigger ContractEventTriggerCapsule.getContractEventTrigger()",
      "byte[] ContractEventTriggerCapsule.getData()", "List ContractEventTriggerCapsule.getTopicList()",
      "void ContractEventTriggerCapsule.setAbiEntry(ABI.Entry)",
      "void ContractEventTriggerCapsule.setContractEventTrigger(ContractEventTrigger)",
      "void ContractEventTriggerCapsule.setData(byte[])", "void ContractEventTriggerCapsule.setTopicList(List)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbi(ABI.getDefaultInstance());
    Entry abiEntry = Entry.getDefaultInstance();
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
    log.setTopicList(new ArrayList<>());
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");
    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);

    ContractEventTrigger contractEventTrigger = new ContractEventTrigger();
    contractEventTrigger.setAbi(ABI.getDefaultInstance());
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

    // Act
    contractEventTriggerCapsule.setContractEventTrigger(contractEventTrigger);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    contractEventTriggerCapsule.setData(data);
    ArrayList<byte[]> topicList = new ArrayList<>();
    contractEventTriggerCapsule.setTopicList(topicList);
    Entry actualAbiEntry = contractEventTriggerCapsule.getAbiEntry();
    ContractEventTrigger actualContractEventTrigger = contractEventTriggerCapsule.getContractEventTrigger();
    byte[] actualData = contractEventTriggerCapsule.getData();

    // Assert
    assertSame(topicList, contractEventTriggerCapsule.getTopicList());
    assertSame(contractEventTrigger, actualContractEventTrigger);
    assertSame(data, actualData);
    assertSame(abiEntry, actualAbiEntry);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
