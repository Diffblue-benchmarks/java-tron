package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class SolidityEventCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SolidityEventCapsule#SolidityEventCapsule(ContractEventTrigger)}
   *   <li>{@link SolidityEventCapsule#setSolidityEventTrigger(ContractEventTrigger)}
   *   <li>{@link SolidityEventCapsule#getSolidityEventTrigger()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolidityEventCapsule.<init>(ContractEventTrigger)",
      "ContractEventTrigger SolidityEventCapsule.getSolidityEventTrigger()",
      "void SolidityEventCapsule.setSolidityEventTrigger(ContractEventTrigger)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ContractEventTrigger solidityEventTrigger = new ContractEventTrigger();
    solidityEventTrigger.setAbi(ABI.getDefaultInstance());
    solidityEventTrigger.setBlockHash("Block Hash");
    solidityEventTrigger.setBlockNumber(1L);
    solidityEventTrigger.setCallerAddress("42 Main St");
    solidityEventTrigger.setContractAddress("42 Main St");
    solidityEventTrigger.setCreatorAddress("42 Main St");
    solidityEventTrigger.setDataMap(new HashMap<>());
    solidityEventTrigger.setEventName("Event Name");
    solidityEventTrigger.setEventSignature("Event Signature");
    solidityEventTrigger.setEventSignatureFull("Event Signature Full");
    solidityEventTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    solidityEventTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    solidityEventTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    solidityEventTrigger.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    solidityEventTrigger.setRemoved(true);
    solidityEventTrigger.setTimeStamp(10L);
    solidityEventTrigger.setTopicMap(new HashMap<>());
    solidityEventTrigger.setTransactionId("42");
    solidityEventTrigger.setTriggerName("Trigger Name");
    solidityEventTrigger.setUniqueId("42");

    // Act
    SolidityEventCapsule actualSolidityEventCapsule = new SolidityEventCapsule(solidityEventTrigger);
    ContractEventTrigger solidityEventTrigger2 = new ContractEventTrigger();
    solidityEventTrigger2.setAbi(ABI.getDefaultInstance());
    solidityEventTrigger2.setBlockHash("Block Hash");
    solidityEventTrigger2.setBlockNumber(1L);
    solidityEventTrigger2.setCallerAddress("42 Main St");
    solidityEventTrigger2.setContractAddress("42 Main St");
    solidityEventTrigger2.setCreatorAddress("42 Main St");
    solidityEventTrigger2.setDataMap(new HashMap<>());
    solidityEventTrigger2.setEventName("Event Name");
    solidityEventTrigger2.setEventSignature("Event Signature");
    solidityEventTrigger2.setEventSignatureFull("Event Signature Full");
    solidityEventTrigger2.setLatestSolidifiedBlockNumber(1L);
    byte[] address3 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics3 = new ArrayList<>();
    solidityEventTrigger2.setLogInfo(new LogInfo(address3, topics3, "AXAXAXAX".getBytes("UTF-8")));
    solidityEventTrigger2.setOriginAddress("42 Main St");
    byte[] address4 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics4 = new ArrayList<>();
    solidityEventTrigger2.setRawData(new RawData(address4, topics4, "AXAXAXAX".getBytes("UTF-8")));
    solidityEventTrigger2.setRemoved(true);
    solidityEventTrigger2.setTimeStamp(10L);
    solidityEventTrigger2.setTopicMap(new HashMap<>());
    solidityEventTrigger2.setTransactionId("42");
    solidityEventTrigger2.setTriggerName("Trigger Name");
    solidityEventTrigger2.setUniqueId("42");
    actualSolidityEventCapsule.setSolidityEventTrigger(solidityEventTrigger2);

    // Assert
    assertSame(solidityEventTrigger2, actualSolidityEventCapsule.getSolidityEventTrigger());
  }
}
