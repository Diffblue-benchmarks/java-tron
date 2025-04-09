package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.bloom.Bloom;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TransactionInfo;

public class LogsFilterCapsuleDiffblueTest {
  /**
   * Test {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return TxInfoList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogsFilterCapsule.<init>(long, String, Bloom, List, boolean, boolean)"})
  public void testNewLogsFilterCapsule_givenDefaultInstance_thenReturnTxInfoListIsArrayList() {
    // Arrange
    Bloom bloom = new Bloom();

    ArrayList<TransactionInfo> txInfoList = new ArrayList<>();
    txInfoList.add(TransactionInfo.getDefaultInstance());
    txInfoList.add(TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertSame(txInfoList, (new LogsFilterCapsule(1L, "Block Hash", bloom, txInfoList, true, true)).getTxInfoList());
  }

  /**
   * Test {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return TxInfoList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogsFilterCapsule.<init>(long, String, Bloom, List, boolean, boolean)"})
  public void testNewLogsFilterCapsule_givenDefaultInstance_thenReturnTxInfoListSizeIsOne() {
    // Arrange
    Bloom bloom = new Bloom();

    ArrayList<TransactionInfo> txInfoList = new ArrayList<>();
    TransactionInfo defaultInstance = TransactionInfo.getDefaultInstance();
    txInfoList.add(defaultInstance);

    // Act and Assert
    List<TransactionInfo> txInfoList2 = (new LogsFilterCapsule(1L, "Block Hash", bloom, txInfoList, true, true))
        .getTxInfoList();
    assertEquals(1, txInfoList2.size());
    assertSame(txInfoList, txInfoList2);
    assertSame(defaultInstance, txInfoList2.get(0));
  }

  /**
   * Test {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code Block Hash}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LogsFilterCapsule.<init>(long, String, Bloom, List, boolean, boolean)"})
  public void testNewLogsFilterCapsule_whenArrayList_thenReturnBlockHash() {
    // Arrange
    Bloom bloom = new Bloom();

    // Act
    LogsFilterCapsule actualLogsFilterCapsule = new LogsFilterCapsule(1L, "Block Hash", bloom, new ArrayList<>(), true,
        true);

    // Assert
    assertEquals("Block Hash", actualLogsFilterCapsule.getBlockHash());
    assertEquals(1L, actualLogsFilterCapsule.getBlockNumber());
    assertTrue(actualLogsFilterCapsule.getTxInfoList().isEmpty());
    assertTrue(actualLogsFilterCapsule.isRemoved());
    assertTrue(actualLogsFilterCapsule.isSolidified());
    assertSame(bloom, actualLogsFilterCapsule.getBloom());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LogsFilterCapsule#setBlockHash(String)}
   *   <li>{@link LogsFilterCapsule#setBlockNumber(long)}
   *   <li>{@link LogsFilterCapsule#setBloom(Bloom)}
   *   <li>{@link LogsFilterCapsule#setRemoved(boolean)}
   *   <li>{@link LogsFilterCapsule#setSolidified(boolean)}
   *   <li>{@link LogsFilterCapsule#setTxInfoList(List)}
   *   <li>{@link LogsFilterCapsule#toString()}
   *   <li>{@link LogsFilterCapsule#getBlockHash()}
   *   <li>{@link LogsFilterCapsule#getBlockNumber()}
   *   <li>{@link LogsFilterCapsule#getBloom()}
   *   <li>{@link LogsFilterCapsule#getTxInfoList()}
   *   <li>{@link LogsFilterCapsule#isRemoved()}
   *   <li>{@link LogsFilterCapsule#isSolidified()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LogsFilterCapsule.getBlockHash()", "long LogsFilterCapsule.getBlockNumber()",
      "Bloom LogsFilterCapsule.getBloom()", "List LogsFilterCapsule.getTxInfoList()",
      "boolean LogsFilterCapsule.isRemoved()", "boolean LogsFilterCapsule.isSolidified()",
      "void LogsFilterCapsule.setBlockHash(String)", "void LogsFilterCapsule.setBlockNumber(long)",
      "void LogsFilterCapsule.setBloom(Bloom)", "void LogsFilterCapsule.setRemoved(boolean)",
      "void LogsFilterCapsule.setSolidified(boolean)", "void LogsFilterCapsule.setTxInfoList(List)",
      "String LogsFilterCapsule.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    Bloom bloom = new Bloom();
    LogsFilterCapsule logsFilterCapsule = new LogsFilterCapsule(1L, "Block Hash", bloom, new ArrayList<>(), true, true);

    // Act
    logsFilterCapsule.setBlockHash("Block Hash");
    logsFilterCapsule.setBlockNumber(1L);
    Bloom bloom2 = new Bloom();
    logsFilterCapsule.setBloom(bloom2);
    logsFilterCapsule.setRemoved(true);
    logsFilterCapsule.setSolidified(true);
    ArrayList<TransactionInfo> txInfoList = new ArrayList<>();
    logsFilterCapsule.setTxInfoList(txInfoList);
    String actualToStringResult = logsFilterCapsule.toString();
    String actualBlockHash = logsFilterCapsule.getBlockHash();
    long actualBlockNumber = logsFilterCapsule.getBlockNumber();
    Bloom actualBloom = logsFilterCapsule.getBloom();
    List<TransactionInfo> actualTxInfoList = logsFilterCapsule.getTxInfoList();
    boolean actualIsRemovedResult = logsFilterCapsule.isRemoved();
    boolean actualIsSolidifiedResult = logsFilterCapsule.isSolidified();

    // Assert
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("LogsFilterCapsule(blockNumber=1, blockHash=Block Hash, bloom=000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000, txInfoList=[], solidified=true,"
        + " removed=true)", actualToStringResult);
    assertEquals(1L, actualBlockNumber);
    assertTrue(actualTxInfoList.isEmpty());
    assertTrue(actualIsRemovedResult);
    assertTrue(actualIsSolidifiedResult);
    assertSame(txInfoList, actualTxInfoList);
    assertSame(bloom2, actualBloom);
  }
}
