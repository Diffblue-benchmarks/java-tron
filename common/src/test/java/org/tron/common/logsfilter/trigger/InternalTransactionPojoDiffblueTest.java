package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InternalTransactionPojoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link InternalTransactionPojo}
   *   <li>{@link InternalTransactionPojo#setCallValue(long)}
   *   <li>{@link InternalTransactionPojo#setCaller_address(String)}
   *   <li>{@link InternalTransactionPojo#setData(String)}
   *   <li>{@link InternalTransactionPojo#setExtra(String)}
   *   <li>{@link InternalTransactionPojo#setHash(String)}
   *   <li>{@link InternalTransactionPojo#setNote(String)}
   *   <li>{@link InternalTransactionPojo#setRejected(boolean)}
   *   <li>{@link InternalTransactionPojo#setTokenInfo(Map)}
   *   <li>{@link InternalTransactionPojo#setTransferTo_address(String)}
   *   <li>{@link InternalTransactionPojo#getCallValue()}
   *   <li>{@link InternalTransactionPojo#getCaller_address()}
   *   <li>{@link InternalTransactionPojo#getData()}
   *   <li>{@link InternalTransactionPojo#getExtra()}
   *   <li>{@link InternalTransactionPojo#getHash()}
   *   <li>{@link InternalTransactionPojo#getNote()}
   *   <li>{@link InternalTransactionPojo#getTokenInfo()}
   *   <li>{@link InternalTransactionPojo#getTransferTo_address()}
   *   <li>{@link InternalTransactionPojo#isRejected()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InternalTransactionPojo.<init>()",
    "long InternalTransactionPojo.getCallValue()",
    "String InternalTransactionPojo.getCaller_address()",
    "String InternalTransactionPojo.getData()",
    "String InternalTransactionPojo.getExtra()",
    "String InternalTransactionPojo.getHash()",
    "String InternalTransactionPojo.getNote()",
    "Map InternalTransactionPojo.getTokenInfo()",
    "String InternalTransactionPojo.getTransferTo_address()",
    "boolean InternalTransactionPojo.isRejected()",
    "void InternalTransactionPojo.setCallValue(long)",
    "void InternalTransactionPojo.setCaller_address(String)",
    "void InternalTransactionPojo.setData(String)",
    "void InternalTransactionPojo.setExtra(String)",
    "void InternalTransactionPojo.setHash(String)",
    "void InternalTransactionPojo.setNote(String)",
    "void InternalTransactionPojo.setRejected(boolean)",
    "void InternalTransactionPojo.setTokenInfo(Map)",
    "void InternalTransactionPojo.setTransferTo_address(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    InternalTransactionPojo actualInternalTransactionPojo = new InternalTransactionPojo();
    actualInternalTransactionPojo.setCallValue(42L);
    actualInternalTransactionPojo.setCaller_address("42 Main St");
    actualInternalTransactionPojo.setData("Data");
    actualInternalTransactionPojo.setExtra("Extra");
    actualInternalTransactionPojo.setHash("Hash");
    actualInternalTransactionPojo.setNote("Note");
    actualInternalTransactionPojo.setRejected(true);
    HashMap<String, Long> tokenInfo = new HashMap<>();
    actualInternalTransactionPojo.setTokenInfo(tokenInfo);
    actualInternalTransactionPojo.setTransferTo_address("42 Main St");
    long actualCallValue = actualInternalTransactionPojo.getCallValue();
    String actualCaller_address = actualInternalTransactionPojo.getCaller_address();
    String actualData = actualInternalTransactionPojo.getData();
    String actualExtra = actualInternalTransactionPojo.getExtra();
    String actualHash = actualInternalTransactionPojo.getHash();
    String actualNote = actualInternalTransactionPojo.getNote();
    Map<String, Long> actualTokenInfo = actualInternalTransactionPojo.getTokenInfo();
    String actualTransferTo_address = actualInternalTransactionPojo.getTransferTo_address();
    boolean actualIsRejectedResult = actualInternalTransactionPojo.isRejected();

    // Assert
    assertEquals("42 Main St", actualCaller_address);
    assertEquals("42 Main St", actualTransferTo_address);
    assertEquals("Data", actualData);
    assertEquals("Extra", actualExtra);
    assertEquals("Hash", actualHash);
    assertEquals("Note", actualNote);
    assertEquals(42L, actualCallValue);
    assertTrue(actualTokenInfo.isEmpty());
    assertTrue(actualIsRejectedResult);
    assertSame(tokenInfo, actualTokenInfo);
  }
}
