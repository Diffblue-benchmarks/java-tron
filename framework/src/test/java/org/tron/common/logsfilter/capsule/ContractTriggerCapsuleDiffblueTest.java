package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;

public class ContractTriggerCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContractTriggerCapsule#ContractTriggerCapsule(ContractTrigger)}
   *   <li>{@link ContractTriggerCapsule#setContractTrigger(ContractTrigger)}
   *   <li>{@link ContractTriggerCapsule#getContractTrigger()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.<init>(ContractTrigger)",
      "ContractTrigger ContractTriggerCapsule.getContractTrigger()",
      "void ContractTriggerCapsule.setContractTrigger(ContractTrigger)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ContractTrigger contractTrigger = new ContractTrigger();
    contractTrigger.setAbi(ABI.getDefaultInstance());
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
    contractTrigger2.setAbi(ABI.getDefaultInstance());
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

    // Assert
    assertSame(contractTrigger2, actualContractTriggerCapsule.getContractTrigger());
  }

  /**
   * Test {@link ContractTriggerCapsule#setLatestSolidifiedBlockNumber(long)}.
   * <p>
   * Method under test: {@link ContractTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.setLatestSolidifiedBlockNumber(long)"})
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    ContractTriggerCapsule contractTriggerCapsule = new ContractTriggerCapsule(new ContractTrigger());

    // Act
    contractTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    assertEquals(1L, contractTriggerCapsule.getContractTrigger().getLatestSolidifiedBlockNumber());
  }

  /**
   * Test {@link ContractTriggerCapsule#setBlockHash(String)}.
   * <p>
   * Method under test: {@link ContractTriggerCapsule#setBlockHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.setBlockHash(String)"})
  public void testSetBlockHash() {
    // Arrange
    ContractTriggerCapsule contractTriggerCapsule = new ContractTriggerCapsule(new ContractTrigger());

    // Act
    contractTriggerCapsule.setBlockHash("Block Hash");

    // Assert
    assertEquals("Block Hash", contractTriggerCapsule.getContractTrigger().getBlockHash());
  }

  /**
   * Test {@link ContractTriggerCapsule#processTrigger()}.
   * <ul>
   *   <li>Given {@link ContractTrigger} (default constructor) BlockNumber is minus one.</li>
   *   <li>Then calls {@link LogInfo#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractTriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.processTrigger()"})
  public void testProcessTrigger_givenContractTriggerBlockNumberIsMinusOne_thenCallsGetAddress()
      throws UnsupportedEncodingException {
    // Arrange
    LogInfo logInfo = mock(LogInfo.class);
    when(logInfo.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getHexData()).thenReturn("0123456789ABCDEF");
    when(logInfo.getHexTopics()).thenReturn(new ArrayList<>());
    when(logInfo.getTopics()).thenReturn(new ArrayList<>());

    ContractTrigger contractTrigger = new ContractTrigger();
    contractTrigger.setBlockNumber(-1L);
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
   * Test {@link ContractTriggerCapsule#processTrigger()}.
   * <ul>
   *   <li>Given {@link ContractTrigger} (default constructor) BlockNumber is one.</li>
   *   <li>Then calls {@link LogInfo#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractTriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.processTrigger()"})
  public void testProcessTrigger_givenContractTriggerBlockNumberIsOne_thenCallsGetAddress()
      throws UnsupportedEncodingException {
    // Arrange
    LogInfo logInfo = mock(LogInfo.class);
    when(logInfo.getAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(logInfo.getHexData()).thenReturn("0123456789ABCDEF");
    when(logInfo.getHexTopics()).thenReturn(new ArrayList<>());
    when(logInfo.getTopics()).thenReturn(new ArrayList<>());

    ContractTrigger contractTrigger = new ContractTrigger();
    contractTrigger.setBlockNumber(1L);
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
   * Test {@link ContractTriggerCapsule#processTrigger()}.
   * <ul>
   *   <li>Given {@link ContractTrigger} (default constructor) BlockNumber is three.</li>
   *   <li>Then calls {@link LogInfo#getAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractTriggerCapsule#processTrigger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractTriggerCapsule.processTrigger()"})
  public void testProcessTrigger_givenContractTriggerBlockNumberIsThree_thenCallsGetAddress()
      throws UnsupportedEncodingException {
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
}
