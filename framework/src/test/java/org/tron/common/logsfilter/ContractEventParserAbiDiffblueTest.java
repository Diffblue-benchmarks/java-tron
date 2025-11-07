package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * Test {@link ContractEventParserAbi#parseTopics(List, Entry)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseTopics(List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseTopics(List, ABI.Entry)"})
  public void testParseTopics_givenA_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseTopicsResult.size());
    assertEquals("4101410141014101", actualParseTopicsResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseTopics(List, Entry)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add array of {@code byte} with {@code A} and one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseTopics(List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseTopics(List, ABI.Entry)"})
  public void testParseTopics_givenA_whenArrayListAddArrayOfByteWithAAndOne_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Test {@link ContractEventParserAbi#parseTopics(List, Entry)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseTopics(List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseTopics(List, ABI.Entry)"})
  public void testParseTopics_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code 0} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_givenA_thenReturn0Is4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code 1} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_givenA_thenReturn1Is4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("1"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code 0} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenArrayList_thenReturn0Is4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(new byte[]{}, topicList,
        Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Test {@link ContractEventParserAbi#parseEventData(byte[], List, Entry)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserAbi#parseEventData(byte[], List, ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserAbi.parseEventData(byte[], List, ABI.Entry)"})
  public void testParseEventData_whenNull_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(null, topicList,
        Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }
}
