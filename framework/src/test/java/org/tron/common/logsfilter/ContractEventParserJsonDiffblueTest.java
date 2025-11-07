package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.alibaba.fastjson.JSONObject;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ContractEventParserJsonDiffblueTest {
  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code 0} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_givenA_thenReturn0Is4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(data, topicList,
        new JSONObject());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code 1} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_givenA_thenReturn1Is4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(data, topicList,
        new JSONObject());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("1"));
  }

  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code 0} is {@code 0158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_whenA_thenReturn0Is0158415841584158() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson
        .parseEventData(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, topicList, new JSONObject());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("0158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 0} is {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_whenAxaxaxaxBytesIsUtf8_thenReturn0Is4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(data, topicList,
        new JSONObject());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(new byte[]{}, topicList,
        new JSONObject());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Test {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ContractEventParserJson.parseEventData(byte[], List, JSONObject)"})
  public void testParseEventData_whenNull_thenReturnEmpty() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(null, topicList,
        new JSONObject());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }
}
