package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractTriggerCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link ContractTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    ContractTrigger contractTrigger = new ContractTrigger();
    ContractTriggerCapsule contractTriggerCapsule = new ContractTriggerCapsule(contractTrigger);

    // Act
    contractTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    ContractTrigger contractTrigger2 = contractTriggerCapsule.getContractTrigger();
    assertEquals(1L, contractTrigger2.getLatestSolidifiedBlockNumber());
    assertSame(contractTrigger, contractTrigger2);
  }

  /**
   * Method under test: {@link ContractTriggerCapsule#setBlockHash(String)}
   */
  @Test
  public void testSetBlockHash() {
    // Arrange
    ContractTrigger contractTrigger = new ContractTrigger();
    ContractTriggerCapsule contractTriggerCapsule = new ContractTriggerCapsule(contractTrigger);

    // Act
    contractTriggerCapsule.setBlockHash("Block Hash");

    // Assert
    ContractTrigger contractTrigger2 = contractTriggerCapsule.getContractTrigger();
    assertEquals("Block Hash", contractTrigger2.getBlockHash());
    assertSame(contractTrigger, contractTrigger2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ContractTriggerCapsule#ContractTriggerCapsule(ContractTrigger)}
   *   <li>{@link ContractTriggerCapsule#setContractTrigger(ContractTrigger)}
   *   <li>{@link ContractTriggerCapsule#getContractTrigger()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ContractTrigger contractTrigger = new ContractTrigger();
    contractTrigger.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    contractTrigger.setBlockHash("Block Hash");
    contractTrigger.setBlockNumber(1L);
    contractTrigger.setCallerAddress("42 Main St");
    contractTrigger.setContractAddress("42 Main St");
    contractTrigger.setCreatorAddress("42 Main St");
    contractTrigger.setLatestSolidifiedBlockNumber(1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    contractTrigger.setLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));
    contractTrigger.setOriginAddress("42 Main St");
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    contractTrigger.setRawData(new RawData(address2, topics2, "AXAXAXAX".getBytes("UTF-8")));
    contractTrigger.setRemoved(true);
    contractTrigger.setTimeStamp(10L);
    contractTrigger.setTransactionId("42");
    contractTrigger.setTriggerName("Trigger Name");
    contractTrigger.setUniqueId("42");

    // Act
    ContractTriggerCapsule actualContractTriggerCapsule = new ContractTriggerCapsule(contractTrigger);
    ContractTrigger contractTrigger2 = new ContractTrigger();
    contractTrigger2.setAbi(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    contractTrigger2.setBlockHash("Block Hash");
    contractTrigger2.setBlockNumber(1L);
    contractTrigger2.setCallerAddress("42 Main St");
    contractTrigger2.setContractAddress("42 Main St");
    contractTrigger2.setCreatorAddress("42 Main St");
    contractTrigger2.setLatestSolidifiedBlockNumber(1L);
    byte[] address3 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics3 = new ArrayList<>();
    contractTrigger2.setLogInfo(new LogInfo(address3, topics3, "AXAXAXAX".getBytes("UTF-8")));
    contractTrigger2.setOriginAddress("42 Main St");
    byte[] address4 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics4 = new ArrayList<>();
    contractTrigger2.setRawData(new RawData(address4, topics4, "AXAXAXAX".getBytes("UTF-8")));
    contractTrigger2.setRemoved(true);
    contractTrigger2.setTimeStamp(10L);
    contractTrigger2.setTransactionId("42");
    contractTrigger2.setTriggerName("Trigger Name");
    contractTrigger2.setUniqueId("42");
    actualContractTriggerCapsule.setContractTrigger(contractTrigger2);

    // Assert that nothing has changed
    assertSame(contractTrigger2, actualContractTriggerCapsule.getContractTrigger());
  }

  /**
   * Method under test: {@link ContractTriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger() throws UnsupportedEncodingException {
    // Arrange
    LogInfo logInfo = mock(LogInfo.class);
    when(logInfo.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getHexData()).thenReturn("0123456789ABCDEF");
    when(logInfo.getHexTopics()).thenReturn(new ArrayList<>());
    when(logInfo.getTopics()).thenReturn(new ArrayList<>());

    ContractTrigger contractTrigger = new ContractTrigger();
    contractTrigger.setBlockNumber(3L);
    contractTrigger.setLogInfo(logInfo);

    // Act
    (new ContractTriggerCapsule(contractTrigger)).processTrigger();

    // Assert
    verify(logInfo).getAddress();
    verify(logInfo).getData();
    verify(logInfo).getHexData();
    verify(logInfo).getHexTopics();
    verify(logInfo, atLeast(1)).getTopics();
  }

  /**
   * Method under test: {@link ContractTriggerCapsule#processTrigger()}
   */
  @Test
  public void testProcessTrigger2() {
    // Arrange
    ContractLogTrigger contractTrigger = mock(ContractLogTrigger.class);
    when(contractTrigger.isRemoved()).thenReturn(true);
    when(contractTrigger.getBlockNumber()).thenReturn(1L);
    when(contractTrigger.getBlockHash()).thenReturn("Block Hash");
    when(contractTrigger.getContractAddress()).thenReturn("42 Main St");
    when(contractTrigger.getCreatorAddress()).thenReturn("42 Main St");
    when(contractTrigger.getOriginAddress()).thenReturn("42 Main St");
    when(contractTrigger.getTransactionId()).thenReturn("42");
    when(contractTrigger.getUniqueId()).thenReturn("42");
    when(contractTrigger.getLatestSolidifiedBlockNumber()).thenReturn(1L);
    when(contractTrigger.getTimeStamp()).thenReturn(10L);
    when(contractTrigger.getLogInfo()).thenReturn(new LogInfo(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new ArrayList<>(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    when(contractTrigger.getAbi()).thenReturn(SmartContractOuterClass.SmartContract.ABI.getDefaultInstance());
    doNothing().when(contractTrigger).setLogInfo(Mockito.<LogInfo>any());
    contractTrigger.setLogInfo(mock(LogInfo.class));

    // Act
    (new ContractTriggerCapsule(contractTrigger)).processTrigger();

    // Assert
    verify(contractTrigger).getAbi();
    verify(contractTrigger).getBlockHash();
    verify(contractTrigger, atLeast(1)).getBlockNumber();
    verify(contractTrigger).getContractAddress();
    verify(contractTrigger).getCreatorAddress();
    verify(contractTrigger).getLatestSolidifiedBlockNumber();
    verify(contractTrigger).getLogInfo();
    verify(contractTrigger).getOriginAddress();
    verify(contractTrigger).getTransactionId();
    verify(contractTrigger).getUniqueId();
    verify(contractTrigger).isRemoved();
    verify(contractTrigger).setLogInfo(isA(LogInfo.class));
    verify(contractTrigger).getTimeStamp();
  }
}
