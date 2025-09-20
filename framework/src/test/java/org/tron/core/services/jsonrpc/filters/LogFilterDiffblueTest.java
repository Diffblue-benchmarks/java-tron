package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.bloom.Bloom;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.services.jsonrpc.TronJsonRpc;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.Protocol.TransactionInfo.Log;

public class LogFilterDiffblueTest {
  /**
   * Test {@link LogFilter#LogFilter()}.
   *
   * <p>Method under test: {@link LogFilter#LogFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>()"})
  public void testNewLogFilter() {
    // Arrange and Act
    LogFilter actualLogFilter = new LogFilter();

    // Assert
    assertEquals(0, actualLogFilter.getContractAddresses().length);
    assertTrue(actualLogFilter.getTopics().isEmpty());
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter2() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr =
        new FilterRequest("jane.doe@example.org", "To Block", null, new Object[] {}, "Block Hash");

    // Act
    LogFilter actualLogFilter = new LogFilter(fr);

    // Assert
    assertEquals(0, actualLogFilter.getContractAddresses().length);
    assertTrue(actualLogFilter.getTopics().isEmpty());
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter3() throws JsonRpcInvalidParamsException {
    // Arrange
    FilterRequest fr =
        new FilterRequest(
            "jane.doe@example.org", "To Block", new ArrayList<>(), null, "Block Hash");

    // Act
    LogFilter actualLogFilter = new LogFilter(fr);

    // Assert
    assertEquals(0, actualLogFilter.getContractAddresses().length);
    assertTrue(actualLogFilter.getTopics().isEmpty());
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <ul>
   *   <li>Given {@code 42 Main St}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter_given42MainSt_whenLinkedHashSetAdd42MainSt()
      throws JsonRpcInvalidParamsException {
    // Arrange
    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("42 Main St");
    FilterRequest fr =
        new FilterRequest("jane.doe@example.org", "To Block", objectSet, null, "Block Hash");

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> new LogFilter(fr));
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter_given42_whenArrayListAdd42() throws JsonRpcInvalidParamsException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Object[] topics = new Object[] {"Topics"};

    FilterRequest fr =
        new FilterRequest("jane.doe@example.org", "To Block", objectList, topics, "Block Hash");

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> new LogFilter(fr));
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter_givenNull_whenArrayListAddNull()
      throws JsonRpcInvalidParamsException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(null);
    Object[] topics = new Object[] {"Topics"};

    FilterRequest fr =
        new FilterRequest("jane.doe@example.org", "To Block", objectList, topics, "Block Hash");

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> new LogFilter(fr));
  }

  /**
   * Test {@link LogFilter#LogFilter(FilterRequest)}.
   *
   * <ul>
   *   <li>When {@link TronJsonRpc.FilterRequest#FilterRequest()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#LogFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogFilter.<init>(TronJsonRpc.FilterRequest)"})
  public void testNewLogFilter_whenFilterRequest_thenReturnArrayLengthIsZero()
      throws JsonRpcInvalidParamsException {
    // Arrange and Act
    LogFilter actualLogFilter = new LogFilter(new FilterRequest());

    // Assert
    assertEquals(0, actualLogFilter.getContractAddresses().length);
    assertTrue(actualLogFilter.getTopics().isEmpty());
  }

  /**
   * Test {@link LogFilter#matchBloom(Bloom)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link Bloom#Bloom()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#matchBloom(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LogFilter.matchBloom(Bloom)"})
  public void testMatchBloom_givenA_whenBloom_thenReturnFalse() {
    // Arrange
    LogFilter logFilter = new LogFilter();
    logFilter.setContractAddresses(new byte[][] {new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}});

    // Act and Assert
    assertFalse(logFilter.matchBloom(new Bloom()));
  }

  /**
   * Test {@link LogFilter#matchBloom(Bloom)}.
   *
   * <ul>
   *   <li>Given array of {@link Bloom} with {@link Bloom#Bloom()}.
   *   <li>When {@link Bloom#Bloom()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#matchBloom(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LogFilter.matchBloom(Bloom)"})
  public void testMatchBloom_givenArrayOfBloomWithBloom_whenBloom_thenReturnTrue() {
    // Arrange
    LogFilter logFilter = new LogFilter();
    logFilter.setFilterBlooms(new Bloom[][] {new Bloom[] {new Bloom()}});

    // Act and Assert
    assertTrue(logFilter.matchBloom(new Bloom()));
  }

  /**
   * Test {@link LogFilter#matchBloom(Bloom)}.
   *
   * <ul>
   *   <li>Given {@link LogFilter#LogFilter()} ContractAddresses is {@code null}.
   *   <li>When {@link Bloom#Bloom()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#matchBloom(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LogFilter.matchBloom(Bloom)"})
  public void testMatchBloom_givenLogFilterContractAddressesIsNull_whenBloom_thenReturnTrue() {
    // Arrange
    LogFilter logFilter = new LogFilter();
    logFilter.setContractAddresses(null);

    // Act and Assert
    assertTrue(logFilter.matchBloom(new Bloom()));
  }

  /**
   * Test {@link LogFilter#matchBloom(Bloom)}.
   *
   * <ul>
   *   <li>Given {@link LogFilter#LogFilter()}.
   *   <li>When {@link Bloom#Bloom()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogFilter#matchBloom(Bloom)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LogFilter.matchBloom(Bloom)"})
  public void testMatchBloom_givenLogFilter_whenBloom_thenReturnTrue() {
    // Arrange
    LogFilter logFilter = new LogFilter();

    // Act and Assert
    assertTrue(logFilter.matchBloom(new Bloom()));
  }

  /**
   * Test {@link LogFilter#matchesExactly(Log)}.
   *
   * <p>Method under test: {@link LogFilter#matchesExactly(Log)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LogFilter.matchesExactly(Log)"})
  public void testMatchesExactly() {
    // Arrange, Act and Assert
    assertTrue(new LogFilter().matchesExactly(Log.getDefaultInstance()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LogFilter#setContractAddresses(byte[][])}
   *   <li>{@link LogFilter#setFilterBlooms(Bloom[][])}
   *   <li>{@link LogFilter#setTopics(List)}
   *   <li>{@link LogFilter#getContractAddresses()}
   *   <li>{@link LogFilter#getTopics()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "byte[][] LogFilter.getContractAddresses()",
    "List LogFilter.getTopics()",
    "void LogFilter.setContractAddresses(byte[][])",
    "void LogFilter.setFilterBlooms(Bloom[][])",
    "void LogFilter.setTopics(List)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    LogFilter logFilter = new LogFilter();
    byte[][] contractAddresses = new byte[][] {"AXAXAXAX".getBytes("UTF-8")};

    // Act
    logFilter.setContractAddresses(contractAddresses);
    logFilter.setFilterBlooms(new Bloom[][] {new Bloom[] {new Bloom()}});
    ArrayList<byte[][]> topics = new ArrayList<>();
    logFilter.setTopics(topics);
    byte[][] actualContractAddresses = logFilter.getContractAddresses();
    List<byte[][]> actualTopics = logFilter.getTopics();

    // Assert
    assertEquals(1, actualContractAddresses.length);
    assertTrue(actualTopics.isEmpty());
    assertSame(topics, actualTopics);
    assertSame(contractAddresses, actualContractAddresses);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualContractAddresses[0]);
  }
}
