package org.tron.common.runtime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.protos.contract.SmartContractOuterClass;

public class LogEventWrapperDiffblueTest {
  /**
   * Method under test: {@link LogEventWrapper#getEventSignatureFull()}
   */
  @Test
  public void testGetEventSignatureFull() {
    // Arrange, Act and Assert
    assertEquals("fallback()", (new LogEventWrapper()).getEventSignatureFull());
  }

  /**
   * Method under test: {@link LogEventWrapper#getEventSignatureFull()}
   */
  @Test
  public void testGetEventSignatureFull2() {
    // Arrange
    LogEventWrapper logEventWrapper = new LogEventWrapper();
    logEventWrapper.setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Act and Assert
    assertEquals("()", logEventWrapper.getEventSignatureFull());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LogEventWrapper}
   *   <li>
   * {@link LogEventWrapper#setAbiEntry(SmartContractOuterClass.SmartContract.ABI.Entry)}
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
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    LogEventWrapper actualLogEventWrapper = new LogEventWrapper();
    SmartContractOuterClass.SmartContract.ABI.Entry abiEntry = SmartContractOuterClass.SmartContract.ABI.Entry
        .getDefaultInstance();
    actualLogEventWrapper.setAbiEntry(abiEntry);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualLogEventWrapper.setData(data);
    actualLogEventWrapper.setEventSignature("Event Signature");
    ArrayList<byte[]> topicList = new ArrayList<>();
    actualLogEventWrapper.setTopicList(topicList);
    SmartContractOuterClass.SmartContract.ABI.Entry actualAbiEntry = actualLogEventWrapper.getAbiEntry();
    byte[] actualData = actualLogEventWrapper.getData();
    String actualEventSignature = actualLogEventWrapper.getEventSignature();
    List<byte[]> actualTopicList = actualLogEventWrapper.getTopicList();

    // Assert that nothing has changed
    assertEquals("Event Signature", actualEventSignature);
    assertEquals(0L, actualLogEventWrapper.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualLogEventWrapper.getTimeStamp());
    assertFalse(actualLogEventWrapper.isRemoved());
    assertSame(topicList, actualTopicList);
    assertSame(data, actualData);
    assertSame(abiEntry, actualAbiEntry);
  }
}
