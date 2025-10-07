package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class ContractEventParserAbiDiffblueTest {
  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code 0} is {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_givenA_thenReturn0Is4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult =
        ContractEventParserAbi.parseEventData(data, topicList, Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code 1} is {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_givenA_thenReturn1Is4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult =
        ContractEventParserAbi.parseEventData(data, topicList, Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("1"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 0} is {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenAxaxaxaxBytesIsUtf8_thenReturn0Is4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Map<String, String> actualParseEventDataResult =
        ContractEventParserAbi.parseEventData(data, new ArrayList<>(), Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualParseEventDataResult =
        ContractEventParserAbi.parseEventData(
            new byte[] {}, new ArrayList<>(), Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualParseEventDataResult =
        ContractEventParserAbi.parseEventData(null, new ArrayList<>(), Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }
}
