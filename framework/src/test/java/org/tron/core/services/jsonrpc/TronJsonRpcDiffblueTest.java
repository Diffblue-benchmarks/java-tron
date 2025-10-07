package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.alibaba.fastjson.JSONObject;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.services.jsonrpc.TronJsonRpc.CompilationInfo;
import org.tron.core.services.jsonrpc.TronJsonRpc.CompilationResult;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.core.services.jsonrpc.TronJsonRpc.LogFilterElement;
import org.tron.core.services.jsonrpc.TronJsonRpc.SyncingResult;
import org.tron.core.services.jsonrpc.TronJsonRpc.TransactionJson;

public class TronJsonRpcDiffblueTest {
  /**
   * Test CompilationInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CompilationInfo}
   *   <li>{@link CompilationInfo#toString()}
   *   <li>{@link CompilationInfo#getCompilerVersion()}
   *   <li>{@link CompilationInfo#getDeveloperDoc()}
   *   <li>{@link CompilationInfo#getLanguage()}
   *   <li>{@link CompilationInfo#getLanguageVersion()}
   *   <li>{@link CompilationInfo#getSource()}
   *   <li>{@link CompilationInfo#getUserDoc()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompilationInfo.<init>()",
    "String CompilationInfo.getCompilerVersion()",
    "String CompilationInfo.getDeveloperDoc()",
    "String CompilationInfo.getLanguage()",
    "String CompilationInfo.getLanguageVersion()",
    "String CompilationInfo.getSource()",
    "String CompilationInfo.getUserDoc()",
    "String CompilationInfo.toString()"
  })
  public void testCompilationInfoGettersAndSetters() {
    // Arrange and Act
    CompilationInfo actualCompilationInfo = new CompilationInfo();
    String actualToStringResult = actualCompilationInfo.toString();
    String actualCompilerVersion = actualCompilationInfo.getCompilerVersion();
    String actualDeveloperDoc = actualCompilationInfo.getDeveloperDoc();
    String actualLanguage = actualCompilationInfo.getLanguage();
    String actualLanguageVersion = actualCompilationInfo.getLanguageVersion();
    String actualSource = actualCompilationInfo.getSource();

    // Assert
    assertEquals(
        "TronJsonRpc.CompilationInfo(source=null, language=null, languageVersion=null, compilerVersion=null,"
            + " userDoc=null, developerDoc=null)",
        actualToStringResult);
    assertNull(actualCompilerVersion);
    assertNull(actualDeveloperDoc);
    assertNull(actualLanguage);
    assertNull(actualLanguageVersion);
    assertNull(actualSource);
    assertNull(actualCompilationInfo.getUserDoc());
  }

  /**
   * Test CompilationResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CompilationResult}
   *   <li>{@link CompilationResult#toString()}
   *   <li>{@link CompilationResult#getCode()}
   *   <li>{@link CompilationResult#getInfo()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompilationResult.<init>()",
    "String CompilationResult.getCode()",
    "CompilationInfo CompilationResult.getInfo()",
    "String CompilationResult.toString()"
  })
  public void testCompilationResultGettersAndSetters() {
    // Arrange and Act
    CompilationResult actualCompilationResult = new CompilationResult();
    String actualToStringResult = actualCompilationResult.toString();
    String actualCode = actualCompilationResult.getCode();

    // Assert
    assertEquals("TronJsonRpc.CompilationResult(code=null, info=null)", actualToStringResult);
    assertNull(actualCode);
    assertNull(actualCompilationResult.getInfo());
  }

  /**
   * Test FilterRequest getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FilterRequest#FilterRequest()}
   *   <li>{@link FilterRequest#setAddress(Object)}
   *   <li>{@link FilterRequest#setBlockHash(String)}
   *   <li>{@link FilterRequest#setFromBlock(String)}
   *   <li>{@link FilterRequest#setToBlock(String)}
   *   <li>{@link FilterRequest#setTopics(Object[])}
   *   <li>{@link FilterRequest#getAddress()}
   *   <li>{@link FilterRequest#getBlockHash()}
   *   <li>{@link FilterRequest#getFromBlock()}
   *   <li>{@link FilterRequest#getToBlock()}
   *   <li>{@link FilterRequest#getTopics()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterRequest.<init>()",
    "void FilterRequest.<init>(String, String, Object, Object[], String)",
    "Object FilterRequest.getAddress()",
    "String FilterRequest.getBlockHash()",
    "String FilterRequest.getFromBlock()",
    "String FilterRequest.getToBlock()",
    "Object[] FilterRequest.getTopics()",
    "void FilterRequest.setAddress(Object)",
    "void FilterRequest.setBlockHash(String)",
    "void FilterRequest.setFromBlock(String)",
    "void FilterRequest.setToBlock(String)",
    "void FilterRequest.setTopics(Object[])"
  })
  public void testFilterRequestGettersAndSetters() {
    // Arrange and Act
    FilterRequest actualFilterRequest = new FilterRequest();
    actualFilterRequest.setAddress("Address");
    actualFilterRequest.setBlockHash("Block Hash");
    actualFilterRequest.setFromBlock("jane.doe@example.org");
    actualFilterRequest.setToBlock("To Block");
    Object[] topics = new Object[] {"Topics"};
    actualFilterRequest.setTopics(topics);
    Object actualAddress = actualFilterRequest.getAddress();
    String actualBlockHash = actualFilterRequest.getBlockHash();
    String actualFromBlock = actualFilterRequest.getFromBlock();
    String actualToBlock = actualFilterRequest.getToBlock();
    Object[] actualTopics = actualFilterRequest.getTopics();

    // Assert
    assertEquals("Address", actualAddress);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("To Block", actualToBlock);
    assertEquals("Topics", actualTopics[0]);
    assertEquals("jane.doe@example.org", actualFromBlock);
    assertEquals(1, actualTopics.length);
    assertSame(topics, actualTopics);
  }

  /**
   * Test FilterRequest getters and setters.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FilterRequest#FilterRequest(String, String, Object, Object[], String)}
   *   <li>{@link FilterRequest#setAddress(Object)}
   *   <li>{@link FilterRequest#setBlockHash(String)}
   *   <li>{@link FilterRequest#setFromBlock(String)}
   *   <li>{@link FilterRequest#setToBlock(String)}
   *   <li>{@link FilterRequest#setTopics(Object[])}
   *   <li>{@link FilterRequest#getAddress()}
   *   <li>{@link FilterRequest#getBlockHash()}
   *   <li>{@link FilterRequest#getFromBlock()}
   *   <li>{@link FilterRequest#getToBlock()}
   *   <li>{@link FilterRequest#getTopics()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterRequest.<init>()",
    "void FilterRequest.<init>(String, String, Object, Object[], String)",
    "Object FilterRequest.getAddress()",
    "String FilterRequest.getBlockHash()",
    "String FilterRequest.getFromBlock()",
    "String FilterRequest.getToBlock()",
    "Object[] FilterRequest.getTopics()",
    "void FilterRequest.setAddress(Object)",
    "void FilterRequest.setBlockHash(String)",
    "void FilterRequest.setFromBlock(String)",
    "void FilterRequest.setToBlock(String)",
    "void FilterRequest.setTopics(Object[])"
  })
  public void testFilterRequestGettersAndSetters_whenJaneDoeExampleOrg() {
    // Arrange
    Object[] topics = new Object[] {"Topics"};

    // Act
    FilterRequest actualFilterRequest =
        new FilterRequest("jane.doe@example.org", "To Block", "Address", topics, "Block Hash");
    actualFilterRequest.setAddress("Address");
    actualFilterRequest.setBlockHash("Block Hash");
    actualFilterRequest.setFromBlock("jane.doe@example.org");
    actualFilterRequest.setToBlock("To Block");
    Object[] topics2 = new Object[] {"Topics"};
    actualFilterRequest.setTopics(topics2);
    Object actualAddress = actualFilterRequest.getAddress();
    String actualBlockHash = actualFilterRequest.getBlockHash();
    String actualFromBlock = actualFilterRequest.getFromBlock();
    String actualToBlock = actualFilterRequest.getToBlock();
    Object[] actualTopics = actualFilterRequest.getTopics();

    // Assert
    assertEquals("Address", actualAddress);
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("To Block", actualToBlock);
    assertEquals("Topics", actualTopics[0]);
    assertEquals("jane.doe@example.org", actualFromBlock);
    assertEquals(1, actualTopics.length);
    assertSame(topics2, actualTopics);
  }

  /**
   * Test LogFilterElement getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LogFilterElement#getAddress()}
   *   <li>{@link LogFilterElement#getBlockHash()}
   *   <li>{@link LogFilterElement#getBlockNumber()}
   *   <li>{@link LogFilterElement#getData()}
   *   <li>{@link LogFilterElement#getLogIndex()}
   *   <li>{@link LogFilterElement#getTopics()}
   *   <li>{@link LogFilterElement#getTransactionHash()}
   *   <li>{@link LogFilterElement#getTransactionIndex()}
   *   <li>{@link LogFilterElement#isRemoved()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String LogFilterElement.getAddress()",
    "String LogFilterElement.getBlockHash()",
    "String LogFilterElement.getBlockNumber()",
    "String LogFilterElement.getData()",
    "String LogFilterElement.getLogIndex()",
    "String[] LogFilterElement.getTopics()",
    "String LogFilterElement.getTransactionHash()",
    "String LogFilterElement.getTransactionIndex()",
    "boolean LogFilterElement.isRemoved()"
  })
  public void testLogFilterElementGettersAndSetters() {
    // Arrange
    LogFilterElement logFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

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
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement() {
    // Arrange
    ArrayList<DataWord> topicList = new ArrayList<>();
    topicList.add(DataWord.ZERO());

    // Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", topicList, "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertArrayEquals(
        new String[] {"0x0000000000000000000000000000000000000000000000000000000000000000"},
        actualLogFilterElement.getTopics());
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement2() {
    // Arrange
    ArrayList<DataWord> topicList = new ArrayList<>();
    topicList.add(DataWord.ZERO());
    topicList.add(DataWord.ZERO());

    // Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", topicList, "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertArrayEquals(
        new String[] {
          "0x0000000000000000000000000000000000000000000000000000000000000000",
          "0x0000000000000000000000000000000000000000000000000000000000000000"
        },
        actualLogFilterElement.getTopics());
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertEquals(0, actualLogFilterElement.getTopics().length);
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <ul>
   *   <li>Then return TransactionIndex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement_thenReturnTransactionIndexIsNull() {
    // Arrange and Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", null, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getTransactionIndex());
    assertEquals(0, actualLogFilterElement.getTopics().length);
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return BlockHash is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement_whenNull_thenReturnBlockHashIsNull() {
    // Arrange and Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            null, 1L, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getBlockHash());
    assertEquals(0, actualLogFilterElement.getTopics().length);
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return BlockNumber is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement_whenNull_thenReturnBlockNumberIsNull() {
    // Arrange and Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", null, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Assert
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals("0xLog Data", actualLogFilterElement.getData());
    assertNull(actualLogFilterElement.getBlockNumber());
    assertEquals(0, actualLogFilterElement.getTopics().length);
  }

  /**
   * Test LogFilterElement {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Data is {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterElement#LogFilterElement(String, Long, String, Integer,
   * String, List, String, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LogFilterElement.<init>(String, Long, String, Integer, String, List, String, int, boolean)"
  })
  public void testLogFilterElementNewLogFilterElement_whenNull_thenReturnDataIs0x() {
    // Arrange and Act
    LogFilterElement actualLogFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(), null, 1, true);

    // Assert
    assertEquals("0x", actualLogFilterElement.getData());
    assertEquals("0x1", actualLogFilterElement.getBlockNumber());
    assertEquals("0x1", actualLogFilterElement.getTransactionIndex());
    assertEquals("0xBlock Hash", actualLogFilterElement.getBlockHash());
    assertEquals(0, actualLogFilterElement.getTopics().length);
  }

  /**
   * Test SyncingResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SyncingResult#SyncingResult(String, String, String)}
   *   <li>{@link SyncingResult#toString()}
   *   <li>{@link SyncingResult#getCurrentBlock()}
   *   <li>{@link SyncingResult#getHighestBlock()}
   *   <li>{@link SyncingResult#getStartingBlock()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SyncingResult.<init>(String, String, String)",
    "String SyncingResult.getCurrentBlock()",
    "String SyncingResult.getHighestBlock()",
    "String SyncingResult.getStartingBlock()",
    "String SyncingResult.toString()"
  })
  public void testSyncingResultGettersAndSetters() {
    // Arrange and Act
    SyncingResult actualSyncingResult =
        new SyncingResult("Starting Block", "Current Block", "Highest Block");
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
   * Test TransactionJson getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TransactionJson}
   *   <li>{@link TransactionJson#setTransaction(JSONObject)}
   *   <li>{@link TransactionJson#getTransaction()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionJson.<init>()",
    "JSONObject TransactionJson.getTransaction()",
    "void TransactionJson.setTransaction(JSONObject)"
  })
  public void testTransactionJsonGettersAndSetters() {
    // Arrange and Act
    TransactionJson actualTransactionJson = new TransactionJson();
    JSONObject transaction = new JSONObject();
    actualTransactionJson.setTransaction(transaction);

    // Assert
    assertSame(transaction, actualTransactionJson.getTransaction());
  }
}
