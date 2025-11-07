package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import com.alibaba.fastjson.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ContractEventParserJsonDiffblueTest {
  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserJson.parseTopics(topicList, new JSONObject());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics2() {
    // Arrange and Act
    Map<String, String> actualParseTopicsResult = ContractEventParserJson.parseTopics(null, new JSONObject());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics3() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserJson.parseTopics(topicList, new JSONObject());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics4() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserJson.parseTopics(topicList, new JSONObject());

    // Assert
    assertEquals(1, actualParseTopicsResult.size());
    assertEquals("4101410141014101", actualParseTopicsResult.get("0"));
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics5() {
    // Arrange
    COWArrayList<byte[]> topicList = mock(COWArrayList.class);
    when(topicList.isEmpty()).thenReturn(true);

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserJson.parseTopics(topicList, new JSONObject());

    // Assert
    verify(topicList).isEmpty();
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseTopics(List, JSONObject)}
   */
  @Test
  public void testParseTopics6() {
    // Arrange
    COWArrayList<byte[]> topicList = mock(COWArrayList.class);
    when(topicList.get(anyInt())).thenThrow(new UnsupportedOperationException("foo"));
    when(topicList.isEmpty()).thenReturn(false);
    when(topicList.size()).thenReturn(3);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> ContractEventParserJson.parseTopics(topicList, new JSONObject()));
    verify(topicList).get(eq(1));
    verify(topicList, atLeast(1)).isEmpty();
    verify(topicList, atLeast(1)).size();
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData2() {
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
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData3() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(null, topicList,
        new JSONObject());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData4() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserJson.parseEventData(new byte[]{}, topicList,
        new JSONObject());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData5() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link ContractEventParserJson#parseEventData(byte[], List, JSONObject)}
   */
  @Test
  public void testParseEventData6() throws UnsupportedEncodingException {
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
}
