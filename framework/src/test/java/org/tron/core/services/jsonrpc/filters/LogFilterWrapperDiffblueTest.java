package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
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

public class LogFilterWrapperDiffblueTest {
  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given array of {@link Object} with {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenArrayOfObjectWithArrayList() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash(null);
    fr.setFromBlock(null);
    fr.setToBlock(null);
    fr.setAddress(null);
    fr.setTopics(new Object[]{new ArrayList<>()});

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, -1L, null);

    // Assert
    assertEquals(-1L, actualLogFilterWrapper.getFromBlock());
    List<byte[][]> topics = actualLogFilterWrapper.getLogFilter().getTopics();
    assertEquals(1, topics.size());
    assertEquals(0, topics.get(0).length);
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given {@code Block Hash}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenBlockHash_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash("Block Hash");

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> new LogFilterWrapper(fr, 1L, null));

  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenEmptyString_whenFilterRequestFromBlockIsEmptyString()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("");

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
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given {@code latest}.</li>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is {@code latest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenLatest_whenFilterRequestFromBlockIsLatest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("latest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterWrapper.getLogFilter().getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Given {@code latest}.</li>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} ToBlock is {@code latest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_givenLatest_whenFilterRequestToBlockIsLatest()
      throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setToBlock("latest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterWrapper.getLogFilter().getTopics().isEmpty());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Then return LogFilter Topics first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenReturnLogFilterTopicsFirstIsNull() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setBlockHash(null);
    fr.setFromBlock(null);
    fr.setToBlock(null);
    fr.setAddress(null);
    fr.setTopics(new Object[]{null});

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, -1L, null);

    // Assert
    List<byte[][]> topics = actualLogFilterWrapper.getLogFilter().getTopics();
    assertEquals(1, topics.size());
    assertNull(topics.get(0));
    assertEquals(-1L, actualLogFilterWrapper.getFromBlock());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>Then return ToBlock is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_thenReturnToBlockIsZero() throws JsonRpcInvalidParamsException {
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
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()} FromBlock is {@code earliest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilterWrapper.<init>(TronJsonRpc.FilterRequest, long, Wallet)"})
  public void testNewLogFilterWrapper_whenFilterRequestFromBlockIsEarliest() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr = new FilterRequest();
    fr.setFromBlock("earliest");

    // Act
    LogFilterWrapper actualLogFilterWrapper = new LogFilterWrapper(fr, 1L, new Wallet());

    // Assert
    assertEquals(0L, actualLogFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterWrapper.getLogFilter().getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test {@link LogFilterWrapper#LogFilterWrapper(FilterRequest, long, Wallet)}.
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()}.</li>
   *   <li>Then return FromBlock is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogFilterWrapper#LogFilterWrapper(TronJsonRpc.FilterRequest, long, Wallet)}
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
    assertEquals(1L, actualLogFilterWrapper.getFromBlock());
    assertTrue(actualLogFilterWrapper.getLogFilter().getTopics().isEmpty());
    assertEquals(Long.MAX_VALUE, actualLogFilterWrapper.getToBlock());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LogFilterWrapper#getFromBlock()}
   *   <li>{@link LogFilterWrapper#getLogFilter()}
   *   <li>{@link LogFilterWrapper#getToBlock()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long LogFilterWrapper.getFromBlock()", "LogFilter LogFilterWrapper.getLogFilter()",
      "long LogFilterWrapper.getToBlock()"})
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
