package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.capsule.ProtoCapsule;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Key;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.core.vm.repository.Value;
import org.tron.protos.contract.SmartContractOuterClass;

public class LogInfoTriggerParserDiffblueTest {
  /**
   * Method under test:
   * {@link LogInfoTriggerParser#getEntrySignature(SmartContractOuterClass.SmartContract.ABI.Entry)}
   */
  @Test
  public void testGetEntrySignature() {
    // Arrange, Act and Assert
    assertEquals("()",
        LogInfoTriggerParser.getEntrySignature(SmartContractOuterClass.SmartContract.ABI.Entry.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  public void testParseLogInfos() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));
    ArrayList<LogInfo> logInfos = new ArrayList<>();

    // Act and Assert
    assertTrue(
        logInfoTriggerParser.parseLogInfos(logInfos, RepositoryImpl.createRoot(StoreFactory.getInstance())).isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  public void testParseLogInfos2() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(
        logInfoTriggerParser.parseLogInfos(null, RepositoryImpl.createRoot(StoreFactory.getInstance())).isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  public void testParseLogInfos3() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));
    ArrayList<LogInfo> logInfos = new ArrayList<>();
    ProtoCapsule<Object> capsule = mock(ProtoCapsule.class);
    when(capsule.getInstance()).thenReturn("Instance");
    Value<Object> value = Value.create(capsule, 1);
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    deposit.putAccount(Key.create("AXAXAXAX".getBytes("UTF-8")), value);

    // Act
    List<ContractTrigger> actualParseLogInfosResult = logInfoTriggerParser.parseLogInfos(logInfos, deposit);

    // Assert
    verify(capsule).getInstance();
    assertTrue(actualParseLogInfosResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#parseLogInfos(List, Repository)}
   */
  @Test
  public void testParseLogInfos4() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    LogInfoTriggerParser logInfoTriggerParser = new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"));
    COWArrayList<LogInfo> logInfos = mock(COWArrayList.class);

    ArrayList<LogInfo> logInfoList = new ArrayList<>();
    when(logInfos.iterator()).thenReturn(logInfoList.iterator());
    when(logInfos.size()).thenReturn(3);

    // Act
    List<ContractTrigger> actualParseLogInfosResult = logInfoTriggerParser.parseLogInfos(logInfos,
        RepositoryImpl.createRoot(StoreFactory.getInstance()));

    // Assert
    verify(logInfos, atLeast(1)).iterator();
    verify(logInfos).size();
    assertTrue(actualParseLogInfosResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  public void testNewLogInfoTriggerParser() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(
        (new LogInfoTriggerParser(1L, 1L, txId, "AXAXAXAX".getBytes("UTF-8"))).parseLogInfos(null, null).isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  public void testNewLogInfoTriggerParser2() {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, null, null)).parseLogInfos(null, null).isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  public void testNewLogInfoTriggerParser3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, new byte[]{}, "AXAXAXAX".getBytes("UTF-8"))).parseLogInfos(null, null)
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link LogInfoTriggerParser#LogInfoTriggerParser(Long, Long, byte[], byte[])}
   */
  @Test
  public void testNewLogInfoTriggerParser4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new LogInfoTriggerParser(1L, 1L, "AXAXAXAX".getBytes("UTF-8"),
        new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).parseLogInfos(null, null).isEmpty());
  }
}
