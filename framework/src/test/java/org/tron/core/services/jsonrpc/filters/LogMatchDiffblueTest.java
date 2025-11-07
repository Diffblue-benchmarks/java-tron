package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.core.Wallet;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.protos.Protocol;

public class LogMatchDiffblueTest {
  /**
   * Method under test:
   * {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  public void testMatchBlock() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    // Act
    List<TronJsonRpc.LogFilterElement> actualMatchBlockResult = LogMatch.matchBlock(logFilter, 1L, "Block Hash",
        new ArrayList<>(), true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  public void testMatchBlock2() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    ArrayList<Protocol.TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    List<TronJsonRpc.LogFilterElement> actualMatchBlockResult = LogMatch.matchBlock(logFilter, 1L, "Block Hash",
        transactionInfoList, true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  public void testMatchBlock3() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    ArrayList<Protocol.TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    List<TronJsonRpc.LogFilterElement> actualMatchBlockResult = LogMatch.matchBlock(logFilter, 1L, "Block Hash",
        transactionInfoList, true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Method under test: {@link LogMatch#matchBlockOneByOne()}
   */
  @Test
  public void testMatchBlockOneByOne()
      throws BadItemException, ItemNotFoundException, JsonRpcInvalidParamsException, JsonRpcTooManyResultException {
    // Arrange
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    ArrayList<Long> blockNumList = new ArrayList<>();

    // Act and Assert
    assertEquals(0, (new LogMatch(logFilterWrapper, blockNumList, new Manager())).matchBlockOneByOne().length);
  }
}
