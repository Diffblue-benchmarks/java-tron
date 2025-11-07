package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import io.netty.channel.DefaultEventLoop;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.Test;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.jsonrpc.TronJsonRpc;

public class LogBlockQueryDiffblueTest {
  /**
   * Method under test: {@link LogBlockQuery#getPossibleBlock()}
   */
  @Test
  public void testGetPossibleBlock()
      throws InterruptedException, ExecutionException, JsonRpcInvalidParamsException, JsonRpcTooManyResultException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act
    List<Long> actualPossibleBlock = (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop()))
        .getPossibleBlock();

    // Assert
    assertEquals(1, actualPossibleBlock.size());
    assertEquals(1L, actualPossibleBlock.get(0).longValue());
  }

  /**
   * Method under test: {@link LogBlockQuery#getPossibleBlock()}
   */
  @Test
  public void testGetPossibleBlock2()
      throws InterruptedException, ExecutionException, JsonRpcInvalidParamsException, JsonRpcTooManyResultException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act
    List<Long> actualPossibleBlock = (new LogBlockQuery(logFilterWrapper, null, 1L,
        new ScheduledThreadPoolExecutor(1, mock(RejectedExecutionHandler.class)))).getPossibleBlock();

    // Assert
    assertEquals(1, actualPossibleBlock.size());
    assertEquals(1L, actualPossibleBlock.get(0).longValue());
  }

  /**
   * Method under test: {@link LogBlockQuery#getConditions()}
   */
  @Test
  public void testGetConditions() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act and Assert
    assertEquals(0, (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop())).getConditions().length);
  }

  /**
   * Method under test: {@link LogBlockQuery#getConditions()}
   */
  @Test
  public void testGetConditions2() throws JsonRpcInvalidParamsException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act and Assert
    assertEquals(0, (new LogBlockQuery(logFilterWrapper, null, 1L,
        new ScheduledThreadPoolExecutor(1, mock(RejectedExecutionHandler.class)))).getConditions().length);
  }
}
