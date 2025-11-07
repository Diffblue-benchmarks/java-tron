package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.core.store.SectionBloomStore;

public class LogBlockQueryDiffblueTest {
  /**
   * Test {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}.
   * <p>
   * Method under test: {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogBlockQuery.<init>(LogFilterWrapper, SectionBloomStore, long, ExecutorService)"})
  public void testNewLogBlockQuery() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, Long.MAX_VALUE, new Wallet());

    // Act and Assert
    assertEquals(0, (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop())).getConditions().length);
  }

  /**
   * Test {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}.
   * <ul>
   *   <li>Given {@code 2048}.</li>
   *   <li>When {@link LogFilterWrapper} {@link LogFilterWrapper#getToBlock()} return {@code 2048}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogBlockQuery.<init>(LogFilterWrapper, SectionBloomStore, long, ExecutorService)"})
  public void testNewLogBlockQuery_given2048_whenLogFilterWrapperGetToBlockReturn2048() {
    // Arrange
    LogFilterWrapper logFilterWrapper = mock(LogFilterWrapper.class);
    when(logFilterWrapper.getFromBlock()).thenReturn(1L);
    when(logFilterWrapper.getToBlock()).thenReturn(2048L);

    // Act
    new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop());

    // Assert
    verify(logFilterWrapper, atLeast(1)).getFromBlock();
    verify(logFilterWrapper, atLeast(1)).getToBlock();
  }

  /**
   * Test {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogBlockQuery.<init>(LogFilterWrapper, SectionBloomStore, long, ExecutorService)"})
  public void testNewLogBlockQuery_thenReturnArrayLengthIsZero() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act and Assert
    assertEquals(0, (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop())).getConditions().length);
  }

  /**
   * Test {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}.
   * <ul>
   *   <li>When {@link LogFilterWrapper} {@link LogFilterWrapper#getToBlock()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#LogBlockQuery(LogFilterWrapper, SectionBloomStore, long, ExecutorService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogBlockQuery.<init>(LogFilterWrapper, SectionBloomStore, long, ExecutorService)"})
  public void testNewLogBlockQuery_whenLogFilterWrapperGetToBlockReturnOne() {
    // Arrange
    LogFilterWrapper logFilterWrapper = mock(LogFilterWrapper.class);
    when(logFilterWrapper.getFromBlock()).thenReturn(1L);
    when(logFilterWrapper.getToBlock()).thenReturn(1L);

    // Act
    new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop());

    // Assert
    verify(logFilterWrapper, atLeast(1)).getFromBlock();
    verify(logFilterWrapper, atLeast(1)).getToBlock();
  }

  /**
   * Test {@link LogBlockQuery#getPossibleBlock()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#getPossibleBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogBlockQuery.getPossibleBlock()"})
  public void testGetPossibleBlock_thenReturnEmpty()
      throws InterruptedException, ExecutionException, JsonRpcInvalidParamsException, JsonRpcTooManyResultException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 2048L, new Wallet());

    // Act and Assert
    assertTrue((new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop())).getPossibleBlock().isEmpty());
  }

  /**
   * Test {@link LogBlockQuery#getPossibleBlock()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#getPossibleBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogBlockQuery.getPossibleBlock()"})
  public void testGetPossibleBlock_thenReturnSizeIsOne()
      throws InterruptedException, ExecutionException, JsonRpcInvalidParamsException, JsonRpcTooManyResultException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act
    List<Long> actualPossibleBlock = (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop()))
        .getPossibleBlock();

    // Assert
    assertEquals(1, actualPossibleBlock.size());
    assertEquals(1L, actualPossibleBlock.get(0).longValue());
  }

  /**
   * Test {@link LogBlockQuery#getConditions()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogBlockQuery#getConditions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[][][] LogBlockQuery.getConditions()"})
  public void testGetConditions_thenReturnArrayLengthIsZero() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    LogFilterWrapper logFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Act and Assert
    assertEquals(0, (new LogBlockQuery(logFilterWrapper, null, 1L, new DefaultEventLoop())).getConditions().length);
  }
}
