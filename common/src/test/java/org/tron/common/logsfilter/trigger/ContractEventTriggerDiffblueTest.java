package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractEventTriggerDiffblueTest {
  /**
   * Test new {@link ContractEventTrigger} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ContractEventTrigger}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractEventTrigger.<init>()"})
  public void testNewContractEventTrigger() {
    // Arrange and Act
    ContractEventTrigger actualContractEventTrigger = new ContractEventTrigger();

    // Assert
    assertNull(actualContractEventTrigger.getBlockNumber());
    assertNull(actualContractEventTrigger.getEventName());
    assertNull(actualContractEventTrigger.getEventSignature());
    assertNull(actualContractEventTrigger.getEventSignatureFull());
    assertNull(actualContractEventTrigger.getBlockHash());
    assertNull(actualContractEventTrigger.getCallerAddress());
    assertNull(actualContractEventTrigger.getContractAddress());
    assertNull(actualContractEventTrigger.getCreatorAddress());
    assertNull(actualContractEventTrigger.getOriginAddress());
    assertNull(actualContractEventTrigger.getTransactionId());
    assertNull(actualContractEventTrigger.getUniqueId());
    assertNull(actualContractEventTrigger.getDataMap());
    assertNull(actualContractEventTrigger.getTopicMap());
    assertNull(actualContractEventTrigger.getRawData());
    assertNull(actualContractEventTrigger.getLogInfo());
    assertNull(actualContractEventTrigger.getAbi());
    assertEquals(0L, actualContractEventTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualContractEventTrigger.getTimeStamp());
    assertFalse(actualContractEventTrigger.isRemoved());
    assertEquals(Trigger.CONTRACTEVENT_TRIGGER_NAME, actualContractEventTrigger.getTriggerName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ContractEventTrigger#setDataMap(Map)}
   *   <li>{@link ContractEventTrigger#setEventName(String)}
   *   <li>{@link ContractEventTrigger#setEventSignature(String)}
   *   <li>{@link ContractEventTrigger#setEventSignatureFull(String)}
   *   <li>{@link ContractEventTrigger#setTopicMap(Map)}
   *   <li>{@link ContractEventTrigger#getDataMap()}
   *   <li>{@link ContractEventTrigger#getEventName()}
   *   <li>{@link ContractEventTrigger#getEventSignature()}
   *   <li>{@link ContractEventTrigger#getEventSignatureFull()}
   *   <li>{@link ContractEventTrigger#getTopicMap()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Map ContractEventTrigger.getDataMap()",
    "String ContractEventTrigger.getEventName()",
    "String ContractEventTrigger.getEventSignature()",
    "String ContractEventTrigger.getEventSignatureFull()",
    "Map ContractEventTrigger.getTopicMap()",
    "void ContractEventTrigger.setDataMap(Map)",
    "void ContractEventTrigger.setEventName(String)",
    "void ContractEventTrigger.setEventSignature(String)",
    "void ContractEventTrigger.setEventSignatureFull(String)",
    "void ContractEventTrigger.setTopicMap(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ContractEventTrigger contractEventTrigger = new ContractEventTrigger();
    HashMap<String, String> dataMap = new HashMap<>();

    // Act
    contractEventTrigger.setDataMap(dataMap);
    contractEventTrigger.setEventName("Event Name");
    contractEventTrigger.setEventSignature("Event Signature");
    contractEventTrigger.setEventSignatureFull("Event Signature Full");
    HashMap<String, String> topicMap = new HashMap<>();
    contractEventTrigger.setTopicMap(topicMap);
    Map<String, String> actualDataMap = contractEventTrigger.getDataMap();
    String actualEventName = contractEventTrigger.getEventName();
    String actualEventSignature = contractEventTrigger.getEventSignature();
    String actualEventSignatureFull = contractEventTrigger.getEventSignatureFull();
    Map<String, String> actualTopicMap = contractEventTrigger.getTopicMap();

    // Assert
    assertEquals("Event Name", actualEventName);
    assertEquals("Event Signature Full", actualEventSignatureFull);
    assertEquals("Event Signature", actualEventSignature);
    assertTrue(actualDataMap.isEmpty());
    assertTrue(actualTopicMap.isEmpty());
    assertSame(dataMap, actualDataMap);
    assertSame(topicMap, actualTopicMap);
  }
}
