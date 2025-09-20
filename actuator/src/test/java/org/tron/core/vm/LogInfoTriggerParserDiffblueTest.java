package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class LogInfoTriggerParserDiffblueTest {
  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenA() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new LogInfoTriggerParser(
                1L,
                1L,
                "AXAXAXAX".getBytes("UTF-8"),
                new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})
            .parseLogInfos(null, null)
            .isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new LogInfoTriggerParser(1L, 1L, "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"))
            .parseLogInfos(null, null)
            .isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new LogInfoTriggerParser(1L, 1L, new byte[] {}, "AXAXAXAX".getBytes("UTF-8"))
            .parseLogInfos(null, null)
            .isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogInfoTriggerParser.<init>(Long, Long, byte[], byte[])"})
  public void testNewLogInfoTriggerParser_whenNull() {
    // Arrange and Act
    LogInfoTriggerParser actualLogInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, null, null);

    // Assert
    assertTrue(actualLogInfoTriggerParser.parseLogInfos(null, null).isEmpty());
  }

  /**
   * Test {@link LogInfoTriggerParser#getEntrySignature(Entry)}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link LogInfoTriggerParser#getEntrySignature(Entry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LogInfoTriggerParser.getEntrySignature(Entry)"})
  public void testGetEntrySignature_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("()", LogInfoTriggerParser.getEntrySignature(Entry.getDefaultInstance()));
  }
}
