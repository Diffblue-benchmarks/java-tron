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
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class LogEventWrapperDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"void LogEventWrapper.<init>()", "ABI.Entry LogEventWrapper.getAbiEntry()",
      "byte[] LogEventWrapper.getData()", "String LogEventWrapper.getEventSignature()",
      "List LogEventWrapper.getTopicList()", "void LogEventWrapper.setAbiEntry(ABI.Entry)",
      "void LogEventWrapper.setData(byte[])", "void LogEventWrapper.setEventSignature(String)",
      "void LogEventWrapper.setTopicList(List)"})
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
    assertNull(actualAbiEntry);
    assertNull(actualLogEventWrapper.getAbi());
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
   * <p>
   * Method under test: {@link LogEventWrapper#getEventSignatureFull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LogEventWrapper.getEventSignatureFull()"})
  public void testGetEventSignatureFull() {
    // Arrange, Act and Assert
    assertEquals("fallback()", (new LogEventWrapper()).getEventSignatureFull());
  }
}
