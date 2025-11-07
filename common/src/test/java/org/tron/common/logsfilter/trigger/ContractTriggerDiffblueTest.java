package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ContractTrigger}
   *   <li>{@link ContractTrigger#setAbi(SmartContractOuterClass.SmartContract.ABI)}
   *   <li>{@link ContractTrigger#setBlockHash(String)}
   *   <li>{@link ContractTrigger#setBlockNumber(Long)}
   *   <li>{@link ContractTrigger#setCallerAddress(String)}
   *   <li>{@link ContractTrigger#setContractAddress(String)}
   *   <li>{@link ContractTrigger#setCreatorAddress(String)}
   *   <li>{@link ContractTrigger#setLatestSolidifiedBlockNumber(long)}
   *   <li>{@link ContractTrigger#setLogInfo(LogInfo)}
   *   <li>{@link ContractTrigger#setOriginAddress(String)}
   *   <li>{@link ContractTrigger#setRawData(RawData)}
   *   <li>{@link ContractTrigger#setRemoved(boolean)}
   *   <li>{@link ContractTrigger#setTransactionId(String)}
   *   <li>{@link ContractTrigger#setUniqueId(String)}
   *   <li>{@link ContractTrigger#getAbi()}
   *   <li>{@link ContractTrigger#getBlockHash()}
   *   <li>{@link ContractTrigger#getBlockNumber()}
   *   <li>{@link ContractTrigger#getCallerAddress()}
   *   <li>{@link ContractTrigger#getContractAddress()}
   *   <li>{@link ContractTrigger#getCreatorAddress()}
   *   <li>{@link ContractTrigger#getLatestSolidifiedBlockNumber()}
   *   <li>{@link ContractTrigger#getLogInfo()}
   *   <li>{@link ContractTrigger#getOriginAddress()}
   *   <li>{@link ContractTrigger#getRawData()}
   *   <li>{@link ContractTrigger#getTransactionId()}
   *   <li>{@link ContractTrigger#getUniqueId()}
   *   <li>{@link ContractTrigger#isRemoved()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ContractTrigger actualContractTrigger = new ContractTrigger();
    SmartContractOuterClass.SmartContract.ABI abi = SmartContractOuterClass.SmartContract.ABI.getDefaultInstance();
    actualContractTrigger.setAbi(abi);
    actualContractTrigger.setBlockHash("Block Hash");
    actualContractTrigger.setBlockNumber(1L);
    actualContractTrigger.setCallerAddress("42 Main St");
    actualContractTrigger.setContractAddress("42 Main St");
    actualContractTrigger.setCreatorAddress("42 Main St");
    actualContractTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    actualContractTrigger.setLogInfo(logInfo);
    actualContractTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    RawData rawData = new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8"));

    actualContractTrigger.setRawData(rawData);
    actualContractTrigger.setRemoved(true);
    actualContractTrigger.setTransactionId("42");
    actualContractTrigger.setUniqueId("42");
    SmartContractOuterClass.SmartContract.ABI actualAbi = actualContractTrigger.getAbi();
    String actualBlockHash = actualContractTrigger.getBlockHash();
    Long actualBlockNumber = actualContractTrigger.getBlockNumber();
    String actualCallerAddress = actualContractTrigger.getCallerAddress();
    String actualContractAddress = actualContractTrigger.getContractAddress();
    String actualCreatorAddress = actualContractTrigger.getCreatorAddress();
    long actualLatestSolidifiedBlockNumber = actualContractTrigger.getLatestSolidifiedBlockNumber();
    LogInfo actualLogInfo = actualContractTrigger.getLogInfo();
    String actualOriginAddress = actualContractTrigger.getOriginAddress();
    RawData actualRawData = actualContractTrigger.getRawData();
    String actualTransactionId = actualContractTrigger.getTransactionId();
    String actualUniqueId = actualContractTrigger.getUniqueId();
    boolean actualIsRemovedResult = actualContractTrigger.isRemoved();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualCallerAddress);
    assertEquals("42 Main St", actualContractAddress);
    assertEquals("42 Main St", actualCreatorAddress);
    assertEquals("42 Main St", actualOriginAddress);
    assertEquals("42", actualTransactionId);
    assertEquals("42", actualUniqueId);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals(0L, actualContractTrigger.getTimeStamp());
    assertEquals(1L, actualBlockNumber.longValue());
    assertEquals(1L, actualLatestSolidifiedBlockNumber);
    assertTrue(actualIsRemovedResult);
    assertSame(rawData, actualRawData);
    assertSame(logInfo, actualLogInfo);
    assertSame(abi, actualAbi);
  }
}
