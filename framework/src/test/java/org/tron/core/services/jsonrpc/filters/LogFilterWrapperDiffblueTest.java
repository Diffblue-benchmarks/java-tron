package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.services.jsonrpc.TronJsonRpc;

public class LogFilterWrapperDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LogFilterWrapper#getFromBlock()}
   *   <li>{@link LogFilterWrapper#getLogFilter()}
   *   <li>{@link LogFilterWrapper#getToBlock()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
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
