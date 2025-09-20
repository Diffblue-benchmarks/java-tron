package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

public class LogFilterWrapperDiffblueTest {
  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper() throws JsonRpcInvalidParamsException {
    // Arrange
    Object[] topics = new Object[] {new ArrayList<>()};
    FilterRequest fr = new FilterRequest(null, null, null, topics, null);

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, -1L, null);

    // Assert
    assertEquals(-1L, actualLogFilterWrapper.getFromBlock());
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    List<byte[][]> topics2 = logFilter.getTopics();
    assertEquals(1, topics2.size());
    assertEquals(0, topics2.get(0).length);
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper2() throws JsonRpcInvalidParamsException {
    // Arrange
    Object[] topics = new Object[] {new ArrayList<>()};
    FilterRequest fr = new FilterRequest("", null, null, topics, null);

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, -1L, null);

    // Assert
    assertEquals(-1L, actualLogFilterWrapper.getFromBlock());
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    List<byte[][]> topics2 = logFilter.getTopics();
    assertEquals(1, topics2.size());
    assertEquals(0, topics2.get(0).length);
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenArrayList() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = mock(FilterRequest.class);
    when(fr.getAddress()).thenReturn(new ArrayList<>());
    when(fr.getTopics()).thenReturn(null);
    when(fr.getBlockHash()).thenReturn("0x");
    when(fr.getFromBlock()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
    verify(fr, atLeast(1)).getAddress();
    verify(fr, atLeast(1)).getBlockHash();
    verify(fr).getFromBlock();
    verify(fr).getTopics();
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenEmptyArrayOfObject()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = mock(FilterRequest.class);
    when(fr.getAddress()).thenReturn(null);
    when(fr.getTopics()).thenReturn(new Object[] {});
    when(fr.getBlockHash()).thenReturn("0x");
    when(fr.getFromBlock()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
    verify(fr, atLeast(1)).getAddress();
    verify(fr, atLeast(1)).getBlockHash();
    verify(fr).getFromBlock();
    verify(fr, atLeast(1)).getTopics();
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TronJsonRpc.FilterRequest} {@link TronJsonRpc.FilterRequest#getBlockHash()}
   *       return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenFoo_whenFilterRequestGetBlockHashReturnFoo()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = mock(FilterRequest.class);
    when(fr.getAddress()).thenReturn(null);
    when(fr.getTopics()).thenReturn(null);
    when(fr.getBlockHash()).thenReturn("foo");
    when(fr.getFromBlock()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
    verify(fr, atLeast(1)).getAddress();
    verify(fr, atLeast(1)).getBlockHash();
    verify(fr).getFromBlock();
    verify(fr).getTopics();
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Then calls {@link TronJsonRpc.FilterRequest#getToBlock()}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenCallsGetToBlock() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = mock(FilterRequest.class);
    when(fr.getAddress()).thenReturn(null);
    when(fr.getTopics()).thenReturn(null);
    when(fr.getBlockHash()).thenReturn("0x");
    when(fr.getFromBlock()).thenReturn(null);
    when(fr.getToBlock()).thenReturn("");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
    verify(fr, atLeast(1)).getAddress();
    verify(fr, atLeast(1)).getBlockHash();
    verify(fr).getFromBlock();
    verify(fr).getToBlock();
    verify(fr).getTopics();
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Then return LogFilter Topics first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenReturnLogFilterTopicsFirstIsNull()
      throws JsonRpcInvalidParamsException {
    // Arrange
    Object[] topics = new Object[] {null};
    FilterRequest fr = new FilterRequest(null, null, null, topics, null);

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, -1L, null);

    // Assert
    LogFilter logFilter = actualLogFilterWrapper.getLogFilter();
    List<byte[][]> topics2 = logFilter.getTopics();
    assertEquals(1, topics2.size());
    assertNull(topics2.get(0));
    assertEquals(-1L, actualLogFilterWrapper.getFromBlock());
    assertEquals(0, logFilter.getContractAddresses().length);
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = mock(FilterRequest.class);
    when(fr.getAddress()).thenReturn(null);
    when(fr.getTopics()).thenReturn(null);
    when(fr.getBlockHash()).thenReturn("0x");
    when(fr.getFromBlock()).thenReturn("not empty");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, new Wallet()));
    verify(fr, atLeast(1)).getAddress();
    verify(fr, atLeast(1)).getBlockHash();
    verify(fr).getFromBlock();
    verify(fr).getTopics();
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()}.
   *   <li>Then return FromBlock is one.
   * </ul>
   *
   * <p>Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long,
   * Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequest_thenReturnFromBlockIsOne()
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
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
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
  @Category(MaintainedByDiffblue.class)
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
