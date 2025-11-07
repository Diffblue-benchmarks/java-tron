package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class TronJsonRpcDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TronJsonRpc.CompilationInfo}
   *   <li>{@link TronJsonRpc.CompilationInfo#toString()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getCompilerVersion()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getDeveloperDoc()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getLanguage()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getLanguageVersion()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getSource()}
   *   <li>{@link TronJsonRpc.CompilationInfo#getUserDoc()}
   * </ul>
   */
  @Test
  public void testCompilationInfoGettersAndSetters() {
    // Arrange and Act
    TronJsonRpc.CompilationInfo actualCompilationInfo = new TronJsonRpc.CompilationInfo();
    String actualToStringResult = actualCompilationInfo.toString();
    String actualCompilerVersion = actualCompilationInfo.getCompilerVersion();
    String actualDeveloperDoc = actualCompilationInfo.getDeveloperDoc();
    String actualLanguage = actualCompilationInfo.getLanguage();
    String actualLanguageVersion = actualCompilationInfo.getLanguageVersion();
    String actualSource = actualCompilationInfo.getSource();

    // Assert
    assertEquals("TronJsonRpc.CompilationInfo(source=null, language=null, languageVersion=null, compilerVersion=null,"
        + " userDoc=null, developerDoc=null)", actualToStringResult);
    assertNull(actualCompilerVersion);
    assertNull(actualDeveloperDoc);
    assertNull(actualLanguage);
    assertNull(actualLanguageVersion);
    assertNull(actualSource);
    assertNull(actualCompilationInfo.getUserDoc());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TronJsonRpc.CompilationResult}
   *   <li>{@link TronJsonRpc.CompilationResult#toString()}
   *   <li>{@link TronJsonRpc.CompilationResult#getCode()}
   *   <li>{@link TronJsonRpc.CompilationResult#getInfo()}
   * </ul>
   */
  @Test
  public void testCompilationResultGettersAndSetters() {
    // Arrange and Act
    TronJsonRpc.CompilationResult actualCompilationResult = new TronJsonRpc.CompilationResult();
    String actualToStringResult = actualCompilationResult.toString();
    String actualCode = actualCompilationResult.getCode();

    // Assert
    assertEquals("TronJsonRpc.CompilationResult(code=null, info=null)", actualToStringResult);
    assertNull(actualCode);
    assertNull(actualCompilationResult.getInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronJsonRpc.FilterRequest#FilterRequest()}
   *   <li>{@link TronJsonRpc.FilterRequest#setAddress(Object)}
   *   <li>{@link TronJsonRpc.FilterRequest#setBlockHash(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setFromBlock(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setToBlock(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setTopics(Object[])}
   *   <li>{@link TronJsonRpc.FilterRequest#getAddress()}
   *   <li>{@link TronJsonRpc.FilterRequest#getBlockHash()}
   *   <li>{@link TronJsonRpc.FilterRequest#getFromBlock()}
   *   <li>{@link TronJsonRpc.FilterRequest#getToBlock()}
   *   <li>{@link TronJsonRpc.FilterRequest#getTopics()}
   * </ul>
   */
  @Test
  public void testFilterRequestGettersAndSetters() {
    // Arrange and Act
    TronJsonRpc.FilterRequest actualFilterRequest = new TronJsonRpc.FilterRequest();
    actualFilterRequest.setAddress("Address");
    actualFilterRequest.setBlockHash("Block Hash");
    actualFilterRequest.setFromBlock("jane.doe@example.org");
    actualFilterRequest.setToBlock("To Block");
    Object[] topics = new Object[]{"Topics"};
    actualFilterRequest.setTopics(topics);
    Object actualAddress = actualFilterRequest.getAddress();
    String actualBlockHash = actualFilterRequest.getBlockHash();
    String actualFromBlock = actualFilterRequest.getFromBlock();
    String actualToBlock = actualFilterRequest.getToBlock();
    Object[] actualTopics = actualFilterRequest.getTopics();

    // Assert that nothing has changed
    assertEquals("Address", actualAddress);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("To Block", actualToBlock);
    assertEquals("Topics", actualTopics[0]);
    assertEquals("jane.doe@example.org", actualFromBlock);
    assertEquals(1, actualTopics.length);
    assertSame(topics, actualTopics);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TronJsonRpc.FilterRequest#FilterRequest(String, String, Object, Object[], String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setAddress(Object)}
   *   <li>{@link TronJsonRpc.FilterRequest#setBlockHash(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setFromBlock(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setToBlock(String)}
   *   <li>{@link TronJsonRpc.FilterRequest#setTopics(Object[])}
   *   <li>{@link TronJsonRpc.FilterRequest#getAddress()}
   *   <li>{@link TronJsonRpc.FilterRequest#getBlockHash()}
   *   <li>{@link TronJsonRpc.FilterRequest#getFromBlock()}
   *   <li>{@link TronJsonRpc.FilterRequest#getToBlock()}
   *   <li>{@link TronJsonRpc.FilterRequest#getTopics()}
   * </ul>
   */
  @Test
  public void testFilterRequestGettersAndSetters2() {
    // Arrange and Act
    TronJsonRpc.FilterRequest actualFilterRequest = new TronJsonRpc.FilterRequest("jane.doe@example.org", "To Block",
        "Address", new Object[]{"Topics"}, "Block Hash");
    actualFilterRequest.setAddress("Address");
    actualFilterRequest.setBlockHash("Block Hash");
    actualFilterRequest.setFromBlock("jane.doe@example.org");
    actualFilterRequest.setToBlock("To Block");
    Object[] topics = new Object[]{"Topics"};
    actualFilterRequest.setTopics(topics);
    Object actualAddress = actualFilterRequest.getAddress();
    String actualBlockHash = actualFilterRequest.getBlockHash();
    String actualFromBlock = actualFilterRequest.getFromBlock();
    String actualToBlock = actualFilterRequest.getToBlock();
    Object[] actualTopics = actualFilterRequest.getTopics();

    // Assert that nothing has changed
    assertEquals("Address", actualAddress);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("To Block", actualToBlock);
    assertEquals("Topics", actualTopics[0]);
    assertEquals("jane.doe@example.org", actualFromBlock);
    assertEquals(1, actualTopics.length);
    assertSame(topics, actualTopics);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronJsonRpc.LogFilterElement#getAddress()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getBlockHash()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getBlockNumber()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getData()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getLogIndex()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getTopics()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getTransactionHash()}
   *   <li>{@link TronJsonRpc.LogFilterElement#getTransactionIndex()}
   *   <li>{@link TronJsonRpc.LogFilterElement#isRemoved()}
   * </ul>
   */
  @Test
  public void testLogFilterElementGettersAndSetters() {
    // Arrange
    TronJsonRpc.LogFilterElement logFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1,
        "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Act
    String actualAddress = logFilterElement.getAddress();
    String actualBlockHash = logFilterElement.getBlockHash();
    String actualBlockNumber = logFilterElement.getBlockNumber();
    String actualData = logFilterElement.getData();
    String actualLogIndex = logFilterElement.getLogIndex();
    String[] actualTopics = logFilterElement.getTopics();
    String actualTransactionHash = logFilterElement.getTransactionHash();
    String actualTransactionIndex = logFilterElement.getTransactionIndex();

    // Assert
    assertEquals("0x1", actualBlockNumber);
    assertEquals("0x1", actualLogIndex);
    assertEquals("0x1", actualTransactionIndex);
    assertEquals("0x42 Main St", actualAddress);
    assertEquals("0x42", actualTransactionHash);
    assertEquals("0xBlock Hash", actualBlockHash);
    assertEquals("0xLog Data", actualData);
    assertEquals(0, actualTopics.length);
    assertTrue(logFilterElement.isRemoved());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement() {
    // Arrange and Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1,
        "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertEquals(0, actualLogFilterElement.getTopics().length);
    assertTrue(actualLogFilterElement.isRemoved());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement2() {
    // Arrange and Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement(null, 1L, "42", 1,
        "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getBlockHash());
    assertEquals(0, actualLogFilterElement.getTopics().length);
    assertTrue(actualLogFilterElement.isRemoved());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement3() {
    // Arrange and Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", null, "42", 1,
        "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getBlockNumber());
    assertEquals(0, actualLogFilterElement.getTopics().length);
    assertTrue(actualLogFilterElement.isRemoved());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement4() {
    // Arrange and Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", null,
        "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getTransactionIndex());
    assertEquals(0, actualLogFilterElement.getTopics().length);
    assertTrue(actualLogFilterElement.isRemoved());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement5() {
    // Arrange
    ArrayList<DataWord> topicList = new ArrayList<>();
    topicList.add(DataWord.ZERO());

    // Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1,
        "42 Main St", topicList, "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertTrue(actualLogFilterElement.isRemoved());
    assertArrayEquals(new String[]{"0x0000000000000000000000000000000000000000000000000000000000000000"},
        actualLogFilterElement.getTopics());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement6() {
    // Arrange
    ArrayList<DataWord> topicList = new ArrayList<>();
    topicList.add(DataWord.ZERO());
    topicList.add(DataWord.ZERO());

    // Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1,
        "42 Main St", topicList, "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertTrue(actualLogFilterElement.isRemoved());
    assertArrayEquals(new String[]{"0x0000000000000000000000000000000000000000000000000000000000000000",
        "0x0000000000000000000000000000000000000000000000000000000000000000"}, actualLogFilterElement.getTopics());
  }

  /**
   * Method under test:
   * {@link TronJsonRpc.LogFilterElement#LogFilterElement(String, Long, String, Integer, String, List, String, int, boolean)}
   */
  @Test
  public void testLogFilterElementNewLogFilterElement7() {
    // Arrange and Act
    TronJsonRpc.LogFilterElement actualLogFilterElement = new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1,
        "42 Main St", new ArrayList<>(), null, 1, true);

    // Assert
    assertEquals("0x", actualLogFilterElement.getData());
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getLogIndex());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0x42 Main St", actualLogFilterElement.getAddress());
    assertEquals("0x42", actualLogFilterElement.getTransactionHash());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals(0, actualLogFilterElement.getTopics().length);
    assertTrue(actualLogFilterElement.isRemoved());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronJsonRpc.SyncingResult#SyncingResult(String, String, String)}
   *   <li>{@link TronJsonRpc.SyncingResult#toString()}
   *   <li>{@link TronJsonRpc.SyncingResult#getCurrentBlock()}
   *   <li>{@link TronJsonRpc.SyncingResult#getHighestBlock()}
   *   <li>{@link TronJsonRpc.SyncingResult#getStartingBlock()}
   * </ul>
   */
  @Test
  public void testSyncingResultGettersAndSetters() {
    // Arrange and Act
    TronJsonRpc.SyncingResult actualSyncingResult = new TronJsonRpc.SyncingResult("Starting Block", "Current Block",
        "Highest Block");
    String actualToStringResult = actualSyncingResult.toString();
    String actualCurrentBlock = actualSyncingResult.getCurrentBlock();
    String actualHighestBlock = actualSyncingResult.getHighestBlock();

    // Assert
    assertEquals("Current Block", actualCurrentBlock);
    assertEquals("Highest Block", actualHighestBlock);
    assertEquals("Starting Block", actualSyncingResult.getStartingBlock());
    assertEquals(
        "TronJsonRpc.SyncingResult(startingBlock=Starting Block, currentBlock=Current Block, highestBlock=Highest"
            + " Block)",
        actualToStringResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TronJsonRpc.TransactionJson}
   *   <li>{@link TronJsonRpc.TransactionJson#setTransaction(JSONObject)}
   *   <li>{@link TronJsonRpc.TransactionJson#getTransaction()}
   * </ul>
   */
  @Test
  public void testTransactionJsonGettersAndSetters() {
    // Arrange and Act
    TronJsonRpc.TransactionJson actualTransactionJson = new TronJsonRpc.TransactionJson();
    JSONObject transaction = new JSONObject();
    actualTransactionJson.setTransaction(transaction);

    // Assert that nothing has changed
    assertSame(transaction, actualTransactionJson.getTransaction());
  }
}
