package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.capsule.RawData;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class LogEventWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LogEventWrapper}
   *   <li>{@link LogEventWrapper#setData(byte[])}
   *   <li>{@link LogEventWrapper#setEventSignature(String)}
   *   <li>{@link LogEventWrapper#setTopicList(List)}
   *   <li>{@link LogEventWrapper#getAbiEntry()}
   *   <li>{@link LogEventWrapper#getData()}
   *   <li>{@link LogEventWrapper#getEventSignature()}
   *   <li>{@link LogEventWrapper#getTopicList()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LogEventWrapper.<init>()",
    "ABI.Entry LogEventWrapper.getAbiEntry()",
    "byte[] LogEventWrapper.getData()",
    "String LogEventWrapper.getEventSignature()",
    "List LogEventWrapper.getTopicList()",
    "void LogEventWrapper.setAbiEntry(ABI.Entry)",
    "void LogEventWrapper.setData(byte[])",
    "void LogEventWrapper.setEventSignature(String)",
    "void LogEventWrapper.setTopicList(List)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    LogEventWrapper actualLogEventWrapper = new LogEventWrapper();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualLogEventWrapper.setData(data);
    actualLogEventWrapper.setEventSignature("Event Signature");
    ArrayList<byte[]> topicList = new ArrayList<>();
    actualLogEventWrapper.setTopicList(topicList);
    Entry actualAbiEntry = actualLogEventWrapper.getAbiEntry();
    byte[] actualData = actualLogEventWrapper.getData();
    String actualEventSignature = actualLogEventWrapper.getEventSignature();
    List<byte[]> actualTopicList = actualLogEventWrapper.getTopicList();

    // Assert
    assertEquals("Event Signature", actualEventSignature);
    assertNull(actualLogEventWrapper.getBlockNumber());
    assertNull(actualLogEventWrapper.getBlockHash());
    assertNull(actualLogEventWrapper.getCallerAddress());
    assertNull(actualLogEventWrapper.getContractAddress());
    assertNull(actualLogEventWrapper.getCreatorAddress());
    assertNull(actualLogEventWrapper.getOriginAddress());
    assertNull(actualLogEventWrapper.getTransactionId());
    assertNull(actualLogEventWrapper.getUniqueId());
    assertNull(actualLogEventWrapper.getTriggerName());
    assertNull(actualLogEventWrapper.getRawData());
    assertNull(actualLogEventWrapper.getLogInfo());
    assertNull(actualLogEventWrapper.getAbi());
    assertNull(actualAbiEntry);
    assertEquals(0L, actualLogEventWrapper.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualLogEventWrapper.getTimeStamp());
    assertFalse(actualLogEventWrapper.isRemoved());
    assertTrue(actualTopicList.isEmpty());
    assertSame(topicList, actualTopicList);
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link LogEventWrapper#getEventSignatureFull()}.
   *
   * <ul>
   *   <li>Given {@link LogEventWrapper} (default constructor).
   *   <li>Then return {@code fallback()}.
   * </ul>
   *
   * <p>Method under test: {@link LogEventWrapper#getEventSignatureFull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LogEventWrapper.getEventSignatureFull()"})
  public void testGetEventSignatureFull_givenLogEventWrapper_thenReturnFallback() {
    // Arrange, Act and Assert
    assertEquals("fallback()", new LogEventWrapper().getEventSignatureFull());
  }

  /**
   * Test {@link LogEventWrapper#getEventSignatureFull()}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link LogEventWrapper#getEventSignatureFull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LogEventWrapper.getEventSignatureFull()"})
  public void testGetEventSignatureFull_thenReturnLeftParenthesisRightParenthesis()
      throws UnsupportedEncodingException {
    // Arrange
    LogEventWrapper logEventWrapper = new LogEventWrapper();
    logEventWrapper.setAbi(ABI.getDefaultInstance());
    logEventWrapper.setAbiEntry(Entry.getDefaultInstance());
    logEventWrapper.setBlockHash("Block Hash");
    logEventWrapper.setBlockNumber(1L);
    logEventWrapper.setCallerAddress("42 Main St");
    logEventWrapper.setContractAddress("42 Main St");
    logEventWrapper.setCreatorAddress("42 Main St");
    logEventWrapper.setData("AXAXAXAX".getBytes("UTF-8"));
    logEventWrapper.setEventSignature("Event Signature");
    logEventWrapper.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    LogInfo logInfo = new LogInfo(address, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    logEventWrapper.setLogInfo(logInfo);
    logEventWrapper.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    RawData rawData = new RawData(address2, new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));
    logEventWrapper.setRawData(rawData);
    logEventWrapper.setRemoved(true);
    logEventWrapper.setTimeStamp(10L);
    logEventWrapper.setTopicList(new ArrayList<>());
    logEventWrapper.setTransactionId("42");
    logEventWrapper.setTriggerName("Trigger Name");
    logEventWrapper.setUniqueId("42");

    // Act and Assert
    assertEquals("()", logEventWrapper.getEventSignatureFull());
  }
}
