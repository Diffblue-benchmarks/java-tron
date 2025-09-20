package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.LogEventWrapper;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class ContractEventTriggerCapsuleDiffblueTest {
  /**
   * Test {@link ContractEventTriggerCapsule#ContractEventTriggerCapsule(LogEventWrapper)}.
   *
   * <p>Method under test: {@link
   * ContractEventTriggerCapsule#ContractEventTriggerCapsule(LogEventWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractEventTriggerCapsule.<init>(LogEventWrapper)"})
  public void testNewContractEventTriggerCapsule() throws UnsupportedEncodingException {
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
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    log.setLogInfo(logInfo);
    log.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    log.setRawData(rawData);
    log.setRemoved(true);
    log.setTimeStamp(10L);
    log.setTopicList(new ArrayList<>());
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");

    // Act
    ContractEventTriggerCapsule actualContractEventTriggerCapsule =
        new ContractEventTriggerCapsule(log);

    // Assert
    assertTrue(actualContractEventTriggerCapsule.getTopicList().isEmpty());
    assertSame(abiEntry, actualContractEventTriggerCapsule.getAbiEntry());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualContractEventTriggerCapsule.getData());
  }

  /**
   * Test {@link ContractEventTriggerCapsule#setLatestSolidifiedBlockNumber(long)}.
   *
   * <p>Method under test: {@link ContractEventTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractEventTriggerCapsule.setLatestSolidifiedBlockNumber(long)"})
  public void testSetLatestSolidifiedBlockNumber() throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper log = new LogEventWrapper();
    log.setAbi(ABI.getDefaultInstance());
    log.setAbiEntry(Entry.getDefaultInstance());
    log.setBlockHash("Block Hash");
    log.setBlockNumber(1L);
    log.setCallerAddress("42 Main St");
    log.setContractAddress("42 Main St");
    log.setCreatorAddress("42 Main St");
    log.setData("AXAXAXAX".getBytes("UTF-8"));
    log.setEventSignature("Event Signature");
    log.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    log.setLogInfo(logInfo);
    log.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    log.setRawData(rawData);
    log.setRemoved(true);
    log.setTimeStamp(10L);
    log.setTopicList(new ArrayList<>());
    log.setTransactionId("42");
    log.setTriggerName("Trigger Name");
    log.setUniqueId("42");
    ContractEventTriggerCapsule contractEventTriggerCapsule = new ContractEventTriggerCapsule(log);

    // Act
    contractEventTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    assertEquals(
        1L, contractEventTriggerCapsule.getContractEventTrigger().getLatestSolidifiedBlockNumber());
  }
}
