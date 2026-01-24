package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;

public class LogFilterWrapperDiffblueTest {
  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenEmptyString_whenFilterRequestFromBlockIsEmptyString()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Then return ToBlock is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenReturnToBlockIsZero()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setToBlock("earliest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(0L, actualLogFilterWrapper.getFromBlock());
    assertEquals(0L, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} BlockHash is {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestBlockHashIs0x()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash("0x");

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, null));
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} BlockHash is {@code pending}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestBlockHashIsPending()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash("pending");
    fr.setFromBlock("pending");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} BlockHash is {@code pending}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestBlockHashIsPending2()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash("pending");
    fr.setToBlock("latest");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is {@code earliest}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestFromBlockIsEarliest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("earliest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(0L, actualLogFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is {@code latest}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestFromBlockIsLatest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("latest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} ToBlock is {@code latest}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestToBlockIsLatest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setToBlock("latest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequest_thenReturnArrayLengthIsZero()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(logFilter.getTopics().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LogFilterWrapper#getFromBlock()}
   *   <li>{@link LogFilterWrapper#getLogFilter()}
   *   <li>{@link LogFilterWrapper#getToBlock()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LogFilterWrapper.getFromBlock()",
    "LogFilter LogFilterWrapper.getLogFilter()",
    "long LogFilterWrapper.getToBlock()"
  })
  public void testGettersAndSetters() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act
    long actualFromBlock = logFilterWrapper.getFromBlock();
    LogFilter actualLogFilter = logFilterWrapper.getLogFilter();
    long actualToBlock = logFilterWrapper.getToBlock();

    // Assert
    assertEquals(0, actualLogFilter.getContractAddresses().length);
    assertEquals(1L, actualFromBlock);
    assertTrue(actualLogFilter.getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualToBlock);
  }
}
