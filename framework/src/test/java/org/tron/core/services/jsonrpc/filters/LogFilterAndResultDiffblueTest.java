package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.core.services.jsonrpc.TronJsonRpc.LogFilterElement;

public class LogFilterAndResultDiffblueTest {
  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given array of {@link Object} with {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_givenArrayOfObjectWithArrayList() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash(null);
    fr.setFromBlock(null);
    fr.setToBlock(null);
    fr.setAddress(null);
    fr.setTopics(new Object[]{new ArrayList<>()});

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, Long.MAX_VALUE, null);

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    List<byte[][]> topics = logFilter.getTopics();
    assertEquals(1, topics.size());
    assertEquals(0, topics.get(0).length);
    assertEquals(0, logFilter.getContractAddresses().length);
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_givenEmptyString() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("");

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, logFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given {@code latest}.</li>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is {@code latest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_givenLatest_whenFilterRequestFromBlockIsLatest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("latest");

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, logFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Then return LogFilterWrapper FromBlock is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_thenReturnLogFilterWrapperFromBlockIsZero()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("earliest");

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(0L, logFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Then return LogFilterWrapper LogFilter Topics first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_thenReturnLogFilterWrapperLogFilterTopicsFirstIsNull()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash(null);
    fr.setFromBlock(null);
    fr.setToBlock(null);
    fr.setAddress(null);
    fr.setTopics(new Object[]{null});

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, Long.MAX_VALUE, null);

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    List<byte[][]> topics = logFilter.getTopics();
    assertEquals(1, topics.size());
    assertNull(topics.get(0));
    assertEquals(0, logFilter.getContractAddresses().length);
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_whenFilterRequest() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, logFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#add(LogFilterElement)} with {@code LogFilterElement}.
   * <p>
   * Method under test: {@link LogFilterAndResult#add(LogFilterElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterAndResult.add(LogFilterElement)"})
  public void testAddWithLogFilterElement() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterAndResult logFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Act
    logFilterAndResult
        .add(new LogFilterElement("Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true));

    // Assert
    assertEquals(1, logFilterAndResult.getResult().size());
  }

  /**
   * Test {@link LogFilterAndResult#popAll()}.
   * <p>
   * Method under test: {@link LogFilterAndResult#popAll()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogFilterAndResult.popAll()"})
  public void testPopAll() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act and Assert
    assertTrue((new LogFilterAndResult(fr, 1L, new Wallet())).popAll().isEmpty());
  }

  /**
   * Test {@link LogFilterAndResult#getLogFilterWrapper()}.
   * <p>
   * Method under test: {@link LogFilterAndResult#getLogFilterWrapper()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterWrapper LogFilterAndResult.getLogFilterWrapper()"})
  public void testGetLogFilterWrapper() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act
    LogFilterWrapper actualLogFilterWrapper = (new LogFilterAndResult(fr, 1L, new Wallet())).getLogFilterWrapper();

    // Assert
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }
}
