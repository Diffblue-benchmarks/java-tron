package org.tron.common.logsfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractEventParserAbiDiffblueTest {
  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseTopics(List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseTopics() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseTopics(List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseTopics2() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseTopicsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseTopics(List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseTopics3() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseTopicsResult = ContractEventParserAbi.parseTopics(topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseTopicsResult.size());
    assertEquals("4101410141014101", actualParseTopicsResult.get("0"));
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseEventData(byte[], List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseEventData() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseEventData(byte[], List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseEventData2() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(null, topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseEventData(byte[], List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseEventData3() {
    // Arrange
    ArrayList<byte[]> topicList = new ArrayList<>();

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(new byte[]{}, topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertTrue(actualParseEventDataResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseEventData(byte[], List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseEventData4() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("0"));
  }

  /**
   * Method under test:
   * {@link ContractEventParserAbi#parseEventData(byte[], List, SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testParseEventData5() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    ArrayList<byte[]> topicList = new ArrayList<>();
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    topicList.add(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualParseEventDataResult = ContractEventParserAbi.parseEventData(data, topicList,
        SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance());

    // Assert
    assertEquals(1, actualParseEventDataResult.size());
    assertEquals("4158415841584158", actualParseEventDataResult.get("1"));
  }
}
