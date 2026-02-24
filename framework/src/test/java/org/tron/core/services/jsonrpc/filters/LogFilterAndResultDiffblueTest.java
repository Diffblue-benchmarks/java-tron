package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
   *
   * <p>Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest,
   * long, Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest(null, null, null, new Object[] {}, null);

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, Long.MAX_VALUE, null);

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   *
   * <p>Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest,
   * long, Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult2() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest("", null, null, new Object[] {}, null);

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, Long.MAX_VALUE, null);

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   *
   * <p>Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest,
   * long, Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult3() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest(null, null, new ArrayList<>(), new Object[] {}, null);

    // Act
    LogFilterAndResult actualLogFilterAndResult = new LogFilterAndResult(fr, Long.MAX_VALUE, null);

    // Assert
    LogFilterWrapper logFilterWrapper = actualLogFilterAndResult.getLogFilterWrapper();
    LogFilter logFilter = logFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertTrue(actualLogFilterAndResult.getResult().isEmpty());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, logFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterAndResult#LogFilterAndResult(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Then return LogFilterWrapper FromBlock is one.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterAndResult#LogFilterAndResult(TronJsonRpc.FilterRequest,
   * long, Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterAndResult.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterAndResult_thenReturnLogFilterWrapperFromBlockIsOne()
      throws JsonRpcInvalidParamsException {
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
   *
   * <p>Method under test: {@link LogFilterAndResult#add(LogFilterElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterAndResult.add(LogFilterElement)"})
  public void testAddWithLogFilterElement() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterAndResult logFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());
    LogFilterElement logFilterElement =
        new LogFilterElement(
            "Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(), "Log Data", 1, true);

    // Act
    logFilterAndResult.add(logFilterElement);

    // Assert
    assertEquals(1, logFilterAndResult.getResult().size());
  }

  /**
   * Test {@link LogFilterAndResult#popAll()}.
   *
   * <p>Method under test: {@link LogFilterAndResult#popAll()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List LogFilterAndResult.popAll()"})
  public void testPopAll() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act and Assert
    assertTrue(new LogFilterAndResult(fr, 1L, new Wallet()).popAll().isEmpty());
  }

  /**
   * Test {@link LogFilterAndResult#getLogFilterWrapper()}.
   *
   * <p>Method under test: {@link LogFilterAndResult#getLogFilterWrapper()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LogFilterWrapper LogFilterAndResult.getLogFilterWrapper()"})
  public void testGetLogFilterWrapper() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act
    LogFilterWrapper actualLogFilterWrapper =
        new LogFilterAndResult(fr, 1L, new Wallet()).getLogFilterWrapper();

    // Assert
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(logFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }
}
