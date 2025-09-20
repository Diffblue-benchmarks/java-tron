package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
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
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class ContractTriggerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ContractTrigger}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ContractTrigger.<init>()",
    "ABI ContractTrigger.getAbi()",
    "String ContractTrigger.getBlockHash()",
    "Long ContractTrigger.getBlockNumber()",
    "String ContractTrigger.getCallerAddress()",
    "String ContractTrigger.getContractAddress()",
    "String ContractTrigger.getCreatorAddress()",
    "long ContractTrigger.getLatestSolidifiedBlockNumber()",
    "LogInfo ContractTrigger.getLogInfo()",
    "String ContractTrigger.getOriginAddress()",
    "RawData ContractTrigger.getRawData()",
    "String ContractTrigger.getTransactionId()",
    "String ContractTrigger.getUniqueId()",
    "boolean ContractTrigger.isRemoved()",
    "void ContractTrigger.setAbi(ABI)",
    "void ContractTrigger.setBlockHash(String)",
    "void ContractTrigger.setBlockNumber(Long)",
    "void ContractTrigger.setCallerAddress(String)",
    "void ContractTrigger.setContractAddress(String)",
    "void ContractTrigger.setCreatorAddress(String)",
    "void ContractTrigger.setLatestSolidifiedBlockNumber(long)",
    "void ContractTrigger.setLogInfo(LogInfo)",
    "void ContractTrigger.setOriginAddress(String)",
    "void ContractTrigger.setRawData(RawData)",
    "void ContractTrigger.setRemoved(boolean)",
    "void ContractTrigger.setTransactionId(String)",
    "void ContractTrigger.setUniqueId(String)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ContractTrigger actualContractTrigger = new ContractTrigger();
    actualContractTrigger.setBlockHash("Block Hash");
    actualContractTrigger.setBlockNumber(1L);
    actualContractTrigger.setCallerAddress("42 Main St");
    actualContractTrigger.setContractAddress("42 Main St");
    actualContractTrigger.setCreatorAddress("42 Main St");
    actualContractTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    actualContractTrigger.setLogInfo(logInfo);
    actualContractTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    actualContractTrigger.setRawData(rawData);
    actualContractTrigger.setRemoved(true);
    actualContractTrigger.setTransactionId("42");
    actualContractTrigger.setUniqueId("42");
    ABI actualAbi = actualContractTrigger.getAbi();
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

    // Assert
    assertEquals("42 Main St", actualCallerAddress);
    assertEquals("42 Main St", actualContractAddress);
    assertEquals("42 Main St", actualCreatorAddress);
    assertEquals("42 Main St", actualOriginAddress);
    assertEquals("42", actualTransactionId);
    assertEquals("42", actualUniqueId);
    assertEquals("Block Hash", actualBlockHash);
    assertNull(actualContractTrigger.getTriggerName());
    assertNull(actualAbi);
    assertEquals(0L, actualContractTrigger.getTimeStamp());
    assertEquals(1L, actualBlockNumber.longValue());
    assertEquals(1L, actualLatestSolidifiedBlockNumber);
    assertTrue(actualIsRemovedResult);
    assertSame(rawData, actualRawData);
    assertSame(logInfo, actualLogInfo);
  }
}
