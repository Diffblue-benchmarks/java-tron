package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class LogInfoTriggerParserDiffblueTest {
  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenA() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, "AXAXAXAX".getBytes("UTF-8"),
        new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).parseLogInfos(null, null).isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(
        (new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"))).parseLogInfos(null, null).isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, new byte[]{}, "AXAXAXAX".getBytes("UTF-8"))).parseLogInfos(null, null)
        .isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenNull() {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, null, null)).parseLogInfos(null, null).isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#getEntrySignature(Entry)}.
   * <ul>
   *   <li>Then return {@code ()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#getEntrySignature(ABI.Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LogInfoTriggerParser.getEntrySignature(ABI.Entry)"})
  public void testGetEntrySignature_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("()", LogInfoTriggerParser.getEntrySignature(Entry.getDefaultInstance()));
  }

  /**
   * Test {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogInfoTriggerParser.parseLogInfos(List, Repository)"})
  public void testParseLogInfos_whenArrayList_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));
    ArrayList<LogInfo> logInfos = new ArrayList<>();

    // Act and Assert
    assertTrue(
        logInfoTriggerParser.parseLogInfos(logInfos, RepositoryImpl.createRoot(StoreFactory.getInstance())).isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List LogInfoTriggerParser.parseLogInfos(List, Repository)"})
  public void testParseLogInfos_whenNull_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(
        logInfoTriggerParser.parseLogInfos(null, RepositoryImpl.createRoot(StoreFactory.getInstance())).isEmpty());
  }
}
