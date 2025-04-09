package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.capsule.TransactionResultCapsule;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.Result.contractResult;

public class ProgramResultDiffblueTest {
  /**
   * Test {@link ProgramResult#createEmpty()}.
   * <p>
   * Method under test: {@link ProgramResult#createEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramResult ProgramResult.createEmpty()"})
  public void testCreateEmpty() {
    // Arrange and Act
    ProgramResult actualCreateEmptyResult = ProgramResult.createEmpty();

    // Assert
    assertNull(actualCreateEmptyResult.getException());
    assertNull(actualCreateEmptyResult.getRuntimeError());
    assertNull(actualCreateEmptyResult.getResultCode());
    assertEquals(0L, actualCreateEmptyResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCreateEmptyResult.getEnergyUsed());
    assertFalse(actualCreateEmptyResult.isRevert());
    assertTrue(actualCreateEmptyResult.getCallCreateList().isEmpty());
    assertTrue(actualCreateEmptyResult.getInternalTransactions().isEmpty());
    assertTrue(actualCreateEmptyResult.getLogInfoList().isEmpty());
    assertTrue(actualCreateEmptyResult.getTriggerList().isEmpty());
    assertTrue(actualCreateEmptyResult.getDeleteAccounts().isEmpty());
    assertArrayEquals(new byte[]{}, actualCreateEmptyResult.getContractAddress());
    assertArrayEquals(new byte[]{}, actualCreateEmptyResult.getHReturn());
  }

  /**
   * Test {@link ProgramResult#spendEnergyWithPenalty(long, long)}.
   * <p>
   * Method under test: {@link ProgramResult#spendEnergyWithPenalty(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.spendEnergyWithPenalty(long, long)"})
  public void testSpendEnergyWithPenalty() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.spendEnergyWithPenalty(1L, 1L);

    // Assert
    assertEquals(1L, createEmptyResult.getEnergyPenaltyTotal());
    assertEquals(1L, createEmptyResult.getEnergyUsed());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProgramResult#refundEnergy(long)}
   *   <li>{@link ProgramResult#setException(RuntimeException)}
   *   <li>{@link ProgramResult#setHReturn(byte[])}
   *   <li>{@link ProgramResult#setResultCode(contractResult)}
   *   <li>{@link ProgramResult#setRet(TransactionResultCapsule)}
   *   <li>{@link ProgramResult#setRuntimeError(String)}
   *   <li>{@link ProgramResult#setTriggerList(List)}
   *   <li>{@link ProgramResult#spendEnergy(long)}
   *   <li>{@link ProgramResult#addTotalPenalty(long)}
   *   <li>{@link ProgramResult#setRevert()}
   *   <li>{@link ProgramResult#getEnergyPenaltyTotal()}
   *   <li>{@link ProgramResult#getEnergyUsed()}
   *   <li>{@link ProgramResult#getException()}
   *   <li>{@link ProgramResult#getHReturn()}
   *   <li>{@link ProgramResult#getResultCode()}
   *   <li>{@link ProgramResult#getRet()}
   *   <li>{@link ProgramResult#getRuntimeError()}
   *   <li>{@link ProgramResult#isRevert()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addTotalPenalty(long)", "long ProgramResult.getEnergyPenaltyTotal()",
      "long ProgramResult.getEnergyUsed()", "RuntimeException ProgramResult.getException()",
      "byte[] ProgramResult.getHReturn()", "contractResult ProgramResult.getResultCode()",
      "TransactionResultCapsule ProgramResult.getRet()", "String ProgramResult.getRuntimeError()",
      "boolean ProgramResult.isRevert()", "void ProgramResult.refundEnergy(long)",
      "void ProgramResult.setException(RuntimeException)", "void ProgramResult.setHReturn(byte[])",
      "void ProgramResult.setResultCode(contractResult)", "void ProgramResult.setRet(TransactionResultCapsule)",
      "void ProgramResult.setRevert()", "void ProgramResult.setRuntimeError(String)",
      "void ProgramResult.setTriggerList(List)", "void ProgramResult.spendEnergy(long)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.refundEnergy(1L);
    RuntimeException exception = new RuntimeException("foo");
    createEmptyResult.setException(exception);
    byte[] hReturn = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.setHReturn(hReturn);
    createEmptyResult.setResultCode(contractResult.DEFAULT);
    TransactionResultCapsule ret = new TransactionResultCapsule();
    createEmptyResult.setRet(ret);
    createEmptyResult.setRuntimeError("An error occurred");
    createEmptyResult.setTriggerList(new ArrayList<>());
    createEmptyResult.spendEnergy(1L);
    createEmptyResult.addTotalPenalty(1L);
    createEmptyResult.setRevert();
    long actualEnergyPenaltyTotal = createEmptyResult.getEnergyPenaltyTotal();
    long actualEnergyUsed = createEmptyResult.getEnergyUsed();
    RuntimeException actualException = createEmptyResult.getException();
    byte[] actualHReturn = createEmptyResult.getHReturn();
    contractResult actualResultCode = createEmptyResult.getResultCode();
    TransactionResultCapsule actualRet = createEmptyResult.getRet();
    String actualRuntimeError = createEmptyResult.getRuntimeError();

    // Assert
    assertEquals("An error occurred", actualRuntimeError);
    assertEquals(0L, actualEnergyUsed);
    assertEquals(1L, actualEnergyPenaltyTotal);
    assertEquals(contractResult.DEFAULT, actualResultCode);
    assertTrue(createEmptyResult.isRevert());
    assertSame(exception, actualException);
    assertSame(ret, actualRet);
    assertSame(hReturn, actualHReturn);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualHReturn);
  }

  /**
   * Test {@link ProgramResult#getContractAddress()}.
   * <p>
   * Method under test: {@link ProgramResult#getContractAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramResult.getContractAddress()"})
  public void testGetContractAddress() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ProgramResult.createEmpty().getContractAddress());
  }

  /**
   * Test {@link ProgramResult#setContractAddress(byte[])}.
   * <p>
   * Method under test: {@link ProgramResult#setContractAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.setContractAddress(byte[])"})
  public void testSetContractAddress() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.setContractAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedContractAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedContractAddress, createEmptyResult.getContractAddress());
  }

  /**
   * Test {@link ProgramResult#getTriggerList()}.
   * <ul>
   *   <li>Given createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getTriggerList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getTriggerList()"})
  public void testGetTriggerList_givenCreateEmpty() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getTriggerList().isEmpty());
  }

  /**
   * Test {@link ProgramResult#getTriggerList()}.
   * <ul>
   *   <li>Given createEmpty TriggerList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getTriggerList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getTriggerList()"})
  public void testGetTriggerList_givenCreateEmptyTriggerListIsArrayList() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.setTriggerList(new ArrayList<>());

    // Act and Assert
    assertTrue(createEmptyResult.getTriggerList().isEmpty());
  }

  /**
   * Test {@link ProgramResult#getDeleteAccounts()}.
   * <ul>
   *   <li>Given createEmpty addDeleteAccount ZERO.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getDeleteAccounts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set ProgramResult.getDeleteAccounts()"})
  public void testGetDeleteAccounts_givenCreateEmptyAddDeleteAccountZero_thenReturnSizeIsOne() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act and Assert
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Test {@link ProgramResult#getDeleteAccounts()}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getDeleteAccounts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set ProgramResult.getDeleteAccounts()"})
  public void testGetDeleteAccounts_givenCreateEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getDeleteAccounts().isEmpty());
  }

  /**
   * Test {@link ProgramResult#addDeleteAccount(DataWord)}.
   * <ul>
   *   <li>Given createEmpty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addDeleteAccount(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addDeleteAccount(DataWord)"})
  public void testAddDeleteAccount_givenCreateEmpty() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Assert
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Test {@link ProgramResult#addDeleteAccount(DataWord)}.
   * <ul>
   *   <li>Given createEmpty addDeleteAccount ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addDeleteAccount(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addDeleteAccount(DataWord)"})
  public void testAddDeleteAccount_givenCreateEmptyAddDeleteAccountZero() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Assert that nothing has changed
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Test {@link ProgramResult#getLogInfoList()}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getLogInfoList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getLogInfoList()"})
  public void testGetLogInfoList_givenCreateEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getLogInfoList().isEmpty());
  }

  /**
   * Test {@link ProgramResult#getLogInfoList()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getLogInfoList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getLogInfoList()"})
  public void testGetLogInfoList_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    createEmptyResult.addLogInfo(logInfo);

    // Act
    List<LogInfo> actualLogInfoList = createEmptyResult.getLogInfoList();

    // Assert
    assertEquals(1, actualLogInfoList.size());
    assertSame(logInfo, actualLogInfoList.get(0));
  }

  /**
   * Test {@link ProgramResult#addLogInfo(LogInfo)}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>Then createEmpty LogInfoList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addLogInfo(LogInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addLogInfo(LogInfo)"})
  public void testAddLogInfo_givenCreateEmpty_thenCreateEmptyLogInfoListSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    createEmptyResult.addLogInfo(logInfo);

    // Assert
    List<LogInfo> logInfoList = createEmptyResult.getLogInfoList();
    assertEquals(1, logInfoList.size());
    assertSame(logInfo, logInfoList.get(0));
  }

  /**
   * Test {@link ProgramResult#addLogInfo(LogInfo)}.
   * <ul>
   *   <li>Then createEmpty LogInfoList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addLogInfo(LogInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addLogInfo(LogInfo)"})
  public void testAddLogInfo_thenCreateEmptyLogInfoListSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    LogInfo logInfo = new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8"));

    createEmptyResult.addLogInfo(logInfo);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics2 = new ArrayList<>();
    LogInfo logInfo2 = new LogInfo(address2, topics2, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    createEmptyResult.addLogInfo(logInfo2);

    // Assert
    List<LogInfo> logInfoList = createEmptyResult.getLogInfoList();
    assertEquals(2, logInfoList.size());
    assertSame(logInfo, logInfoList.get(0));
    assertSame(logInfo2, logInfoList.get(1));
  }

  /**
   * Test {@link ProgramResult#getCallCreateList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getCallCreateList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getCallCreateList()"})
  public void testGetCallCreateList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getCallCreateList().isEmpty());
  }

  /**
   * Test {@link ProgramResult#getCallCreateList()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getCallCreateList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getCallCreateList()"})
  public void testGetCallCreateList_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.addCallCreate(data, destination, energyLimit, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<CallCreate> actualCallCreateList = createEmptyResult.getCallCreateList();

    // Assert
    assertEquals(1, actualCallCreateList.size());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    CallCreate getResult = actualCallCreateList.get(0);
    assertArrayEquals(expectedData, getResult.getData());
    byte[] expectedDestination = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedDestination, getResult.getDestination());
    byte[] expectedEnergyLimit = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedEnergyLimit, getResult.getEnergyLimit());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, getResult.getValue());
  }

  /**
   * Test {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}.
   * <ul>
   *   <li>Then createEmpty CallCreateList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addCallCreate(byte[], byte[], byte[], byte[])"})
  public void testAddCallCreate_thenCreateEmptyCallCreateListSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createEmptyResult.addCallCreate(data, destination, energyLimit, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<CallCreate> callCreateList = createEmptyResult.getCallCreateList();
    assertEquals(1, callCreateList.size());
    assertTrue(
        createEmptyResult.getRet().getInstance().getDescriptorForType().toProto().getReservedNameList().isEmpty());
    CallCreate getResult = callCreateList.get(0);
    assertSame(data, getResult.getData());
    byte[] expectedDestination = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedDestination, getResult.getDestination());
    byte[] expectedEnergyLimit = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedEnergyLimit, getResult.getEnergyLimit());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, getResult.getValue());
  }

  /**
   * Test {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}.
   * <ul>
   *   <li>Then createEmpty CallCreateList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.addCallCreate(byte[], byte[], byte[], byte[])"})
  public void testAddCallCreate_thenCreateEmptyCallCreateListSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.addCallCreate(data, destination, energyLimit, "AXAXAXAX".getBytes("UTF-8"));
    byte[] data2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createEmptyResult.addCallCreate(data2, destination2, energyLimit2, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<CallCreate> callCreateList = createEmptyResult.getCallCreateList();
    assertEquals(2, callCreateList.size());
    CallCreate getResult = callCreateList.get(1);
    assertSame(data2, getResult.getData());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    CallCreate getResult2 = callCreateList.get(0);
    assertArrayEquals(expectedData, getResult2.getData());
    byte[] expectedDestination = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedDestination, getResult2.getDestination());
    byte[] expectedDestination2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedDestination2, getResult.getDestination());
    byte[] expectedEnergyLimit = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedEnergyLimit, getResult2.getEnergyLimit());
    byte[] expectedEnergyLimit2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedEnergyLimit2, getResult.getEnergyLimit());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, getResult2.getValue());
    byte[] expectedValue2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue2, getResult.getValue());
  }

  /**
   * Test {@link ProgramResult#getInternalTransactions()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getInternalTransactions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getInternalTransactions()"})
  public void testGetInternalTransactions_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getInternalTransactions().isEmpty());
  }

  /**
   * Test {@link ProgramResult#getInternalTransactions()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#getInternalTransactions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProgramResult.getInternalTransactions()"})
  public void testGetInternalTransactions_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] senderAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.addInternalTransaction(parentHash, 2, senderAddress, transferAddress, 42L, data, "Note", 1L,
        new HashMap<>());

    // Act
    List<InternalTransaction> actualInternalTransactions = createEmptyResult.getInternalTransactions();

    // Assert
    assertEquals(1, actualInternalTransactions.size());
    InternalTransaction getResult = actualInternalTransactions.get(0);
    assertEquals("", getResult.getExtra());
    assertEquals("Note", getResult.getNote());
    assertNull(getResult.getTransaction());
    assertEquals(0, getResult.getIndex());
    assertEquals(1L, getResult.getNonce());
    assertEquals(2, getResult.getDeep());
    assertEquals(42L, getResult.getValue());
    assertFalse(getResult.isRejected());
    assertTrue(getResult.getTokenInfo().isEmpty());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, getResult.getData());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, getResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, getResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, getResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, getResult.getTransferToAddress());
    assertArrayEquals(new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115,
        'X', '7', 'O', -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'}, getResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'}, getResult.getEncoded());
  }

  /**
   * Test {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)} with {@code parentHash}, {@code deep}, {@code senderAddress}, {@code transferAddress}, {@code value}, {@code data}, {@code note}, {@code nonce}, {@code token}.
   * <p>
   * Method under test: {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction ProgramResult.addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)"})
  public void testAddInternalTransactionWithParentHashDeepSenderAddressTransferAddressValueDataNoteNonceToken()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] senderAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualAddInternalTransactionResult = createEmptyResult.addInternalTransaction(parentHash, 2,
        senderAddress, transferAddress, 42L, data, "Note", 1L, new HashMap<>());

    // Assert
    assertEquals(0, actualAddInternalTransactionResult.getIndex());
    assertEquals(1, createEmptyResult.getInternalTransactions().size());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualAddInternalTransactionResult.getData());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualAddInternalTransactionResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, actualAddInternalTransactionResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, actualAddInternalTransactionResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, actualAddInternalTransactionResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X', '7', 'O',
            -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'},
        actualAddInternalTransactionResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'}, actualAddInternalTransactionResult.getEncoded());
  }

  /**
   * Test {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)} with {@code parentHash}, {@code deep}, {@code senderAddress}, {@code transferAddress}, {@code value}, {@code data}, {@code note}, {@code nonce}, {@code token}.
   * <p>
   * Method under test: {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "InternalTransaction ProgramResult.addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)"})
  public void testAddInternalTransactionWithParentHashDeepSenderAddressTransferAddressValueDataNoteNonceToken2()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addInternalTransaction(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 2,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 42L,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, "create", 1L, new HashMap<>());
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] senderAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    InternalTransaction actualAddInternalTransactionResult = createEmptyResult.addInternalTransaction(parentHash, 2,
        senderAddress, transferAddress, 42L, data, "Note", 1L, new HashMap<>());

    // Assert
    assertEquals(1, actualAddInternalTransactionResult.getIndex());
    assertEquals(2, createEmptyResult.getInternalTransactions().size());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualAddInternalTransactionResult.getData());
    byte[] expectedParentHash = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedParentHash, actualAddInternalTransactionResult.getParentHash());
    byte[] expectedReceiveAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedReceiveAddress, actualAddInternalTransactionResult.getReceiveAddress());
    byte[] expectedSender = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSender, actualAddInternalTransactionResult.getSender());
    byte[] expectedTransferToAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedTransferToAddress, actualAddInternalTransactionResult.getTransferToAddress());
    assertArrayEquals(
        new byte[]{-86, -122, 'e', -58, -112, -66, -120, '$', -71, '/', -97, '!', 5, -100, -121, -115, 'X', '7', 'O',
            -75, -96, -37, -12, -77, -89, 'l', -44, -13, -57, -36, 'w', 'r'},
        actualAddInternalTransactionResult.getHash());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, '*'}, actualAddInternalTransactionResult.getEncoded());
  }

  /**
   * Test {@link ProgramResult#rejectInternalTransactions()}.
   * <ul>
   *   <li>Then createEmpty InternalTransactions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#rejectInternalTransactions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.rejectInternalTransactions()"})
  public void testRejectInternalTransactions_thenCreateEmptyInternalTransactionsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] parentHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] senderAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] transferAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.addInternalTransaction(parentHash, 2, senderAddress, transferAddress, 42L, data, "Note", 1L,
        new HashMap<>());

    // Act
    createEmptyResult.rejectInternalTransactions();

    // Assert
    List<InternalTransaction> internalTransactions = createEmptyResult.getInternalTransactions();
    assertEquals(1, internalTransactions.size());
    assertTrue(internalTransactions.get(0).isRejected());
  }

  /**
   * Test {@link ProgramResult#reset()}.
   * <p>
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.reset()"})
  public void testReset() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    createEmptyResult.addLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));

    // Act
    createEmptyResult.reset();

    // Assert
    List<FieldDescriptor> fields = createEmptyResult.getRet().getInstance().getDescriptorForType().getFields();
    assertEquals(15, fields.size());
    FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
  }

  /**
   * Test {@link ProgramResult#reset()}.
   * <ul>
   *   <li>Given createEmpty addDeleteAccount ZERO.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.reset()"})
  public void testReset_givenCreateEmptyAddDeleteAccountZero() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act
    createEmptyResult.reset();

    // Assert
    List<FieldDescriptor> fields = createEmptyResult.getRet().getInstance().getDescriptorForType().getFields();
    assertEquals(15, fields.size());
    FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getDeleteAccounts().isEmpty());
  }

  /**
   * Test {@link ProgramResult#reset()}.
   * <ul>
   *   <li>Given createEmpty.</li>
   *   <li>Then createEmpty DeleteAccounts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.reset()"})
  public void testReset_givenCreateEmpty_thenCreateEmptyDeleteAccountsEmpty() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.reset();

    // Assert that nothing has changed
    List<FieldDescriptor> fields = createEmptyResult.getRet().getInstance().getDescriptorForType().getFields();
    assertEquals(15, fields.size());
    FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getDeleteAccounts().isEmpty());
  }

  /**
   * Test new {@link ProgramResult} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ProgramResult}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramResult.<init>()"})
  public void testNewProgramResult() {
    // Arrange and Act
    ProgramResult actualProgramResult = new ProgramResult();

    // Assert
    assertNull(actualProgramResult.getException());
    assertNull(actualProgramResult.getRuntimeError());
    assertNull(actualProgramResult.getResultCode());
    assertEquals(0L, actualProgramResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualProgramResult.getEnergyUsed());
    assertFalse(actualProgramResult.isRevert());
    assertTrue(actualProgramResult.getCallCreateList().isEmpty());
    assertTrue(actualProgramResult.getInternalTransactions().isEmpty());
    assertTrue(actualProgramResult.getLogInfoList().isEmpty());
    assertTrue(actualProgramResult.getTriggerList().isEmpty());
    assertTrue(actualProgramResult.getDeleteAccounts().isEmpty());
    assertArrayEquals(new byte[]{}, actualProgramResult.getContractAddress());
    assertArrayEquals(new byte[]{}, actualProgramResult.getHReturn());
  }
}
