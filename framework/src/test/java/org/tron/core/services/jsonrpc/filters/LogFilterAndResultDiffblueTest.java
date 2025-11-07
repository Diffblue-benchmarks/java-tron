package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.services.jsonrpc.TronJsonRpc;

public class LogFilterAndResultDiffblueTest {
  /**
   * Method under test:
   * {@link LogFilterAndResult#add(TronJsonRpc.LogFilterElement)}
   */
  @Test
  public void testAdd() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterAndResult logFilterAndResult = new LogFilterAndResult(fr, 1L, new Wallet());

    // Act
    logFilterAndResult.add(new TronJsonRpc.LogFilterElement("Block Hash", 1L, "42", 1, "42 Main St", new ArrayList<>(),
        "Log Data", 1, true));

    // Assert
    assertEquals(1, logFilterAndResult.getResult().size());
  }

  /**
   * Method under test: {@link LogFilterAndResult#popAll()}
   */
  @Test
  public void testPopAll() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();

    // Act and Assert
    assertTrue((new LogFilterAndResult(fr, 1L, new Wallet())).popAll().isEmpty());
  }

  /**
   * Method under test: {@link LogFilterAndResult#getLogFilterWrapper()}
   */
  @Test
  public void testGetLogFilterWrapper() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();

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
