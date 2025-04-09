package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransactionLogTriggerDiffblueTest {
  /**
   * Test new {@link TransactionLogTrigger} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TransactionLogTrigger}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionLogTrigger.<init>()"})
  public void testNewTransactionLogTrigger() {
    // Arrange and Act
    TransactionLogTrigger actualTransactionLogTrigger = new TransactionLogTrigger();

    // Assert
    assertNull(actualTransactionLogTrigger.getAssetName());
    assertNull(actualTransactionLogTrigger.getBlockHash());
    assertNull(actualTransactionLogTrigger.getContractAddress());
    assertNull(actualTransactionLogTrigger.getContractResult());
    assertNull(actualTransactionLogTrigger.getContractType());
    assertNull(actualTransactionLogTrigger.getData());
    assertNull(actualTransactionLogTrigger.getFromAddress());
    assertNull(actualTransactionLogTrigger.getResult());
    assertNull(actualTransactionLogTrigger.getToAddress());
    assertNull(actualTransactionLogTrigger.getTransactionId());
    assertNull(actualTransactionLogTrigger.getInternalTransactionList());
    assertNull(actualTransactionLogTrigger.getLogList());
    assertNull(actualTransactionLogTrigger.getExtMap());
    assertEquals(-1L, actualTransactionLogTrigger.getBlockNumber());
    assertEquals(0, actualTransactionLogTrigger.getTransactionIndex());
    assertEquals(0L, actualTransactionLogTrigger.getAssetAmount());
    assertEquals(0L, actualTransactionLogTrigger.getContractCallValue());
    assertEquals(0L, actualTransactionLogTrigger.getCumulativeEnergyUsed());
    assertEquals(0L, actualTransactionLogTrigger.getEnergyFee());
    assertEquals(0L, actualTransactionLogTrigger.getEnergyUnitPrice());
    assertEquals(0L, actualTransactionLogTrigger.getEnergyUsage());
    assertEquals(0L, actualTransactionLogTrigger.getEnergyUsageTotal());
    assertEquals(0L, actualTransactionLogTrigger.getFeeLimit());
    assertEquals(0L, actualTransactionLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualTransactionLogTrigger.getNetFee());
    assertEquals(0L, actualTransactionLogTrigger.getNetUsage());
    assertEquals(0L, actualTransactionLogTrigger.getOriginEnergyUsage());
    assertEquals(0L, actualTransactionLogTrigger.getPreCumulativeLogCount());
    assertEquals(0L, actualTransactionLogTrigger.getTimeStamp());
    assertEquals(Trigger.TRANSACTION_TRIGGER_NAME, actualTransactionLogTrigger.getTriggerName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionLogTrigger#setAssetAmount(long)}
   *   <li>{@link TransactionLogTrigger#setAssetName(String)}
   *   <li>{@link TransactionLogTrigger#setBlockHash(String)}
   *   <li>{@link TransactionLogTrigger#setBlockNumber(long)}
   *   <li>{@link TransactionLogTrigger#setContractAddress(String)}
   *   <li>{@link TransactionLogTrigger#setContractCallValue(long)}
   *   <li>{@link TransactionLogTrigger#setContractResult(String)}
   *   <li>{@link TransactionLogTrigger#setContractType(String)}
   *   <li>{@link TransactionLogTrigger#setCumulativeEnergyUsed(long)}
   *   <li>{@link TransactionLogTrigger#setData(String)}
   *   <li>{@link TransactionLogTrigger#setEnergyFee(long)}
   *   <li>{@link TransactionLogTrigger#setEnergyUnitPrice(long)}
   *   <li>{@link TransactionLogTrigger#setEnergyUsage(long)}
   *   <li>{@link TransactionLogTrigger#setEnergyUsageTotal(long)}
   *   <li>{@link TransactionLogTrigger#setExtMap(Map)}
   *   <li>{@link TransactionLogTrigger#setFeeLimit(long)}
   *   <li>{@link TransactionLogTrigger#setFromAddress(String)}
   *   <li>{@link TransactionLogTrigger#setInternalTransactionList(List)}
   *   <li>{@link TransactionLogTrigger#setLatestSolidifiedBlockNumber(long)}
   *   <li>{@link TransactionLogTrigger#setLogList(List)}
   *   <li>{@link TransactionLogTrigger#setNetFee(long)}
   *   <li>{@link TransactionLogTrigger#setNetUsage(long)}
   *   <li>{@link TransactionLogTrigger#setOriginEnergyUsage(long)}
   *   <li>{@link TransactionLogTrigger#setPreCumulativeLogCount(long)}
   *   <li>{@link TransactionLogTrigger#setResult(String)}
   *   <li>{@link TransactionLogTrigger#setTimeStamp(long)}
   *   <li>{@link TransactionLogTrigger#setToAddress(String)}
   *   <li>{@link TransactionLogTrigger#setTransactionId(String)}
   *   <li>{@link TransactionLogTrigger#setTransactionIndex(int)}
   *   <li>{@link TransactionLogTrigger#getAssetAmount()}
   *   <li>{@link TransactionLogTrigger#getAssetName()}
   *   <li>{@link TransactionLogTrigger#getBlockHash()}
   *   <li>{@link TransactionLogTrigger#getBlockNumber()}
   *   <li>{@link TransactionLogTrigger#getContractAddress()}
   *   <li>{@link TransactionLogTrigger#getContractCallValue()}
   *   <li>{@link TransactionLogTrigger#getContractResult()}
   *   <li>{@link TransactionLogTrigger#getContractType()}
   *   <li>{@link TransactionLogTrigger#getCumulativeEnergyUsed()}
   *   <li>{@link TransactionLogTrigger#getData()}
   *   <li>{@link TransactionLogTrigger#getEnergyFee()}
   *   <li>{@link TransactionLogTrigger#getEnergyUnitPrice()}
   *   <li>{@link TransactionLogTrigger#getEnergyUsage()}
   *   <li>{@link TransactionLogTrigger#getEnergyUsageTotal()}
   *   <li>{@link TransactionLogTrigger#getExtMap()}
   *   <li>{@link TransactionLogTrigger#getFeeLimit()}
   *   <li>{@link TransactionLogTrigger#getFromAddress()}
   *   <li>{@link TransactionLogTrigger#getInternalTransactionList()}
   *   <li>{@link TransactionLogTrigger#getLatestSolidifiedBlockNumber()}
   *   <li>{@link TransactionLogTrigger#getLogList()}
   *   <li>{@link TransactionLogTrigger#getNetFee()}
   *   <li>{@link TransactionLogTrigger#getNetUsage()}
   *   <li>{@link TransactionLogTrigger#getOriginEnergyUsage()}
   *   <li>{@link TransactionLogTrigger#getPreCumulativeLogCount()}
   *   <li>{@link TransactionLogTrigger#getResult()}
   *   <li>{@link TransactionLogTrigger#getToAddress()}
   *   <li>{@link TransactionLogTrigger#getTransactionId()}
   *   <li>{@link TransactionLogTrigger#getTransactionIndex()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionLogTrigger.getAssetAmount()", "String TransactionLogTrigger.getAssetName()",
      "String TransactionLogTrigger.getBlockHash()", "long TransactionLogTrigger.getBlockNumber()",
      "String TransactionLogTrigger.getContractAddress()", "long TransactionLogTrigger.getContractCallValue()",
      "String TransactionLogTrigger.getContractResult()", "String TransactionLogTrigger.getContractType()",
      "long TransactionLogTrigger.getCumulativeEnergyUsed()", "String TransactionLogTrigger.getData()",
      "long TransactionLogTrigger.getEnergyFee()", "long TransactionLogTrigger.getEnergyUnitPrice()",
      "long TransactionLogTrigger.getEnergyUsage()", "long TransactionLogTrigger.getEnergyUsageTotal()",
      "Map TransactionLogTrigger.getExtMap()", "long TransactionLogTrigger.getFeeLimit()",
      "String TransactionLogTrigger.getFromAddress()", "List TransactionLogTrigger.getInternalTransactionList()",
      "long TransactionLogTrigger.getLatestSolidifiedBlockNumber()", "List TransactionLogTrigger.getLogList()",
      "long TransactionLogTrigger.getNetFee()", "long TransactionLogTrigger.getNetUsage()",
      "long TransactionLogTrigger.getOriginEnergyUsage()", "long TransactionLogTrigger.getPreCumulativeLogCount()",
      "String TransactionLogTrigger.getResult()", "String TransactionLogTrigger.getToAddress()",
      "String TransactionLogTrigger.getTransactionId()", "int TransactionLogTrigger.getTransactionIndex()",
      "void TransactionLogTrigger.setAssetAmount(long)", "void TransactionLogTrigger.setAssetName(String)",
      "void TransactionLogTrigger.setBlockHash(String)", "void TransactionLogTrigger.setBlockNumber(long)",
      "void TransactionLogTrigger.setContractAddress(String)", "void TransactionLogTrigger.setContractCallValue(long)",
      "void TransactionLogTrigger.setContractResult(String)", "void TransactionLogTrigger.setContractType(String)",
      "void TransactionLogTrigger.setCumulativeEnergyUsed(long)", "void TransactionLogTrigger.setData(String)",
      "void TransactionLogTrigger.setEnergyFee(long)", "void TransactionLogTrigger.setEnergyUnitPrice(long)",
      "void TransactionLogTrigger.setEnergyUsage(long)", "void TransactionLogTrigger.setEnergyUsageTotal(long)",
      "void TransactionLogTrigger.setExtMap(Map)", "void TransactionLogTrigger.setFeeLimit(long)",
      "void TransactionLogTrigger.setFromAddress(String)",
      "void TransactionLogTrigger.setInternalTransactionList(List)",
      "void TransactionLogTrigger.setLatestSolidifiedBlockNumber(long)", "void TransactionLogTrigger.setLogList(List)",
      "void TransactionLogTrigger.setNetFee(long)", "void TransactionLogTrigger.setNetUsage(long)",
      "void TransactionLogTrigger.setOriginEnergyUsage(long)",
      "void TransactionLogTrigger.setPreCumulativeLogCount(long)", "void TransactionLogTrigger.setResult(String)",
      "void TransactionLogTrigger.setTimeStamp(long)", "void TransactionLogTrigger.setToAddress(String)",
      "void TransactionLogTrigger.setTransactionId(String)", "void TransactionLogTrigger.setTransactionIndex(int)"})
  public void testGettersAndSetters() {
    // Arrange
    TransactionLogTrigger transactionLogTrigger = new TransactionLogTrigger();

    // Act
    transactionLogTrigger.setAssetAmount(1L);
    transactionLogTrigger.setAssetName("Asset Name");
    transactionLogTrigger.setBlockHash("Block Hash");
    transactionLogTrigger.setBlockNumber(1L);
    transactionLogTrigger.setContractAddress("42 Main St");
    transactionLogTrigger.setContractCallValue(42L);
    transactionLogTrigger.setContractResult("Contract Result");
    transactionLogTrigger.setContractType("Contract Type");
    transactionLogTrigger.setCumulativeEnergyUsed(1L);
    transactionLogTrigger.setData("Data");
    transactionLogTrigger.setEnergyFee(1L);
    transactionLogTrigger.setEnergyUnitPrice(1L);
    transactionLogTrigger.setEnergyUsage(1L);
    transactionLogTrigger.setEnergyUsageTotal(1L);
    HashMap<String, Long> extMap = new HashMap<>();
    transactionLogTrigger.setExtMap(extMap);
    transactionLogTrigger.setFeeLimit(1L);
    transactionLogTrigger.setFromAddress("42 Main St");
    ArrayList<InternalTransactionPojo> internalTransactionList = new ArrayList<>();
    transactionLogTrigger.setInternalTransactionList(internalTransactionList);
    transactionLogTrigger.setLatestSolidifiedBlockNumber(1L);
    ArrayList<LogPojo> logList = new ArrayList<>();
    transactionLogTrigger.setLogList(logList);
    transactionLogTrigger.setNetFee(1L);
    transactionLogTrigger.setNetUsage(1L);
    transactionLogTrigger.setOriginEnergyUsage(1L);
    transactionLogTrigger.setPreCumulativeLogCount(3L);
    transactionLogTrigger.setResult("Result");
    transactionLogTrigger.setTimeStamp(1L);
    transactionLogTrigger.setToAddress("42 Main St");
    transactionLogTrigger.setTransactionId("42");
    transactionLogTrigger.setTransactionIndex(1);
    long actualAssetAmount = transactionLogTrigger.getAssetAmount();
    String actualAssetName = transactionLogTrigger.getAssetName();
    String actualBlockHash = transactionLogTrigger.getBlockHash();
    long actualBlockNumber = transactionLogTrigger.getBlockNumber();
    String actualContractAddress = transactionLogTrigger.getContractAddress();
    long actualContractCallValue = transactionLogTrigger.getContractCallValue();
    String actualContractResult = transactionLogTrigger.getContractResult();
    String actualContractType = transactionLogTrigger.getContractType();
    long actualCumulativeEnergyUsed = transactionLogTrigger.getCumulativeEnergyUsed();
    String actualData = transactionLogTrigger.getData();
    long actualEnergyFee = transactionLogTrigger.getEnergyFee();
    long actualEnergyUnitPrice = transactionLogTrigger.getEnergyUnitPrice();
    long actualEnergyUsage = transactionLogTrigger.getEnergyUsage();
    long actualEnergyUsageTotal = transactionLogTrigger.getEnergyUsageTotal();
    Map<String, Long> actualExtMap = transactionLogTrigger.getExtMap();
    long actualFeeLimit = transactionLogTrigger.getFeeLimit();
    String actualFromAddress = transactionLogTrigger.getFromAddress();
    List<InternalTransactionPojo> actualInternalTransactionList = transactionLogTrigger.getInternalTransactionList();
    long actualLatestSolidifiedBlockNumber = transactionLogTrigger.getLatestSolidifiedBlockNumber();
    List<LogPojo> actualLogList = transactionLogTrigger.getLogList();
    long actualNetFee = transactionLogTrigger.getNetFee();
    long actualNetUsage = transactionLogTrigger.getNetUsage();
    long actualOriginEnergyUsage = transactionLogTrigger.getOriginEnergyUsage();
    long actualPreCumulativeLogCount = transactionLogTrigger.getPreCumulativeLogCount();
    String actualResult = transactionLogTrigger.getResult();
    String actualToAddress = transactionLogTrigger.getToAddress();
    String actualTransactionId = transactionLogTrigger.getTransactionId();

    // Assert
    assertEquals("42 Main St", actualContractAddress);
    assertEquals("42 Main St", actualFromAddress);
    assertEquals("42 Main St", actualToAddress);
    assertEquals("42", actualTransactionId);
    assertEquals("Asset Name", actualAssetName);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("Contract Result", actualContractResult);
    assertEquals("Contract Type", actualContractType);
    assertEquals("Data", actualData);
    assertEquals("Result", actualResult);
    assertEquals(1, transactionLogTrigger.getTransactionIndex());
    assertEquals(1L, actualAssetAmount);
    assertEquals(1L, actualBlockNumber);
    assertEquals(1L, actualCumulativeEnergyUsed);
    assertEquals(1L, actualEnergyFee);
    assertEquals(1L, actualEnergyUnitPrice);
    assertEquals(1L, actualEnergyUsage);
    assertEquals(1L, actualEnergyUsageTotal);
    assertEquals(1L, actualFeeLimit);
    assertEquals(1L, actualLatestSolidifiedBlockNumber);
    assertEquals(1L, actualNetFee);
    assertEquals(1L, actualNetUsage);
    assertEquals(1L, actualOriginEnergyUsage);
    assertEquals(3L, actualPreCumulativeLogCount);
    assertEquals(42L, actualContractCallValue);
    assertTrue(actualInternalTransactionList.isEmpty());
    assertTrue(actualLogList.isEmpty());
    assertTrue(actualExtMap.isEmpty());
    assertSame(internalTransactionList, actualInternalTransactionList);
    assertSame(logList, actualLogList);
    assertSame(extMap, actualExtMap);
  }
}
