package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.core.services.jsonrpc.TronJsonRpc.LogFilterElement;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;

public class LogMatchDiffblueTest {
  /**
   * Test {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogMatch.matchBlock(LogFilter, long, String, List, boolean)"})
  public void testMatchBlock_givenDefaultInstance_whenArrayListAddDefaultInstance() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    ArrayList<TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(TransactionInfo.getDefaultInstance());

    // Act
    List<LogFilterElement> actualMatchBlockResult =
        LogMatch.matchBlock(logFilter, 1L, "Block Hash", transactionInfoList, true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Test {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogMatch.matchBlock(LogFilter, long, String, List, boolean)"})
  public void testMatchBlock_givenDefaultInstance_whenArrayListAddDefaultInstance2() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    ArrayList<TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(TransactionInfo.getDefaultInstance());
    transactionInfoList.add(TransactionInfo.getDefaultInstance());

    // Act
    List<LogFilterElement> actualMatchBlockResult =
        LogMatch.matchBlock(logFilter, 1L, "Block Hash", transactionInfoList, true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Test {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogMatch#matchBlock(LogFilter, long, String, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogMatch.matchBlock(LogFilter, long, String, List, boolean)"})
  public void testMatchBlock_whenArrayList() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    // Act
    List<LogFilterElement> actualMatchBlockResult =
        LogMatch.matchBlock(logFilter, 1L, "Block Hash", new ArrayList<>(), true);

    // Assert
    assertTrue(actualMatchBlockResult.isEmpty());
  }

  /**
   * Test {@link LogMatch#matchBlockOneByOne()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogMatch#matchBlockOneByOne()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] LogMatch.matchBlockOneByOne()"})
  public void testMatchBlockOneByOne_thenReturnArrayLengthIsZero()
      throws BadItemException, ItemNotFoundException, JsonRpcInvalidParamsException,
          JsonRpcTooManyResultException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());
    ArrayList<Long> blockNumList = new ArrayList<>();

    LogMatch logMatch = new LogMatch(logFilterWrapper, blockNumList, new Manager());

    // Act and Assert
    assertEquals(0, logMatch.matchBlockOneByOne().length);
  }
}
