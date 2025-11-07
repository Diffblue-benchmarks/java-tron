package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.bloom.Bloom;
import org.tron.protos.Protocol;

public class LogsFilterCapsuleDiffblueTest {
  /**
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
    ArrayList<Protocol.TransactionInfo> txInfoList = new ArrayList<>();
    logsFilterCapsule.setTxInfoList(txInfoList);
    String actualToStringResult = logsFilterCapsule.toString();
    String actualBlockHash = logsFilterCapsule.getBlockHash();
    long actualBlockNumber = logsFilterCapsule.getBlockNumber();
    Bloom actualBloom = logsFilterCapsule.getBloom();
    List<Protocol.TransactionInfo> actualTxInfoList = logsFilterCapsule.getTxInfoList();
    boolean actualIsRemovedResult = logsFilterCapsule.isRemoved();
    boolean actualIsSolidifiedResult = logsFilterCapsule.isSolidified();

    // Assert that nothing has changed
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

  /**
   * Method under test:
   * {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  public void testNewLogsFilterCapsule() {
    // Arrange
    Bloom bloom = new Bloom();
    ArrayList<Protocol.TransactionInfo> txInfoList = new ArrayList<>();

    // Act
    LogsFilterCapsule actualLogsFilterCapsule = new LogsFilterCapsule(1L, "Block Hash", bloom, txInfoList, true, true);

    // Assert
    assertEquals("Block Hash", actualLogsFilterCapsule.getBlockHash());
    assertEquals(1L, actualLogsFilterCapsule.getBlockNumber());
    List<Protocol.TransactionInfo> txInfoList2 = actualLogsFilterCapsule.getTxInfoList();
    assertTrue(txInfoList2.isEmpty());
    assertTrue(actualLogsFilterCapsule.isRemoved());
    assertTrue(actualLogsFilterCapsule.isSolidified());
    assertSame(txInfoList, txInfoList2);
    assertSame(bloom, actualLogsFilterCapsule.getBloom());
  }

  /**
   * Method under test:
   * {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  public void testNewLogsFilterCapsule2() {
    // Arrange
    Bloom bloom = new Bloom();

    ArrayList<Protocol.TransactionInfo> txInfoList = new ArrayList<>();
    txInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    LogsFilterCapsule actualLogsFilterCapsule = new LogsFilterCapsule(1L, "Block Hash", bloom, txInfoList, true, true);

    // Assert
    assertEquals("Block Hash", actualLogsFilterCapsule.getBlockHash());
    assertEquals(1L, actualLogsFilterCapsule.getBlockNumber());
    assertTrue(actualLogsFilterCapsule.isRemoved());
    assertTrue(actualLogsFilterCapsule.isSolidified());
    assertSame(txInfoList, actualLogsFilterCapsule.getTxInfoList());
    assertSame(bloom, actualLogsFilterCapsule.getBloom());
  }

  /**
   * Method under test:
   * {@link LogsFilterCapsule#LogsFilterCapsule(long, String, Bloom, List, boolean, boolean)}
   */
  @Test
  public void testNewLogsFilterCapsule3() {
    // Arrange
    Bloom bloom = new Bloom();

    ArrayList<Protocol.TransactionInfo> txInfoList = new ArrayList<>();
    txInfoList.add(Protocol.TransactionInfo.getDefaultInstance());
    txInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    LogsFilterCapsule actualLogsFilterCapsule = new LogsFilterCapsule(1L, "Block Hash", bloom, txInfoList, true, true);

    // Assert
    assertEquals("Block Hash", actualLogsFilterCapsule.getBlockHash());
    assertEquals(1L, actualLogsFilterCapsule.getBlockNumber());
    assertTrue(actualLogsFilterCapsule.isRemoved());
    assertTrue(actualLogsFilterCapsule.isSolidified());
    assertSame(txInfoList, actualLogsFilterCapsule.getTxInfoList());
    assertSame(bloom, actualLogsFilterCapsule.getBloom());
  }
}
