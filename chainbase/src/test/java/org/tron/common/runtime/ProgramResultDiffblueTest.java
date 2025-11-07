package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.ContractTrigger;
import org.tron.common.runtime.vm.DataWord;
import org.tron.common.runtime.vm.LogInfo;
import org.tron.core.capsule.TransactionResultCapsule;
import org.tron.protos.Protocol;

public class ProgramResultDiffblueTest {
  /**
   * Method under test: {@link ProgramResult#spendEnergyWithPenalty(long, long)}
   */
  @Test
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
   * Method under test: {@link ProgramResult#getContractAddress()}
   */
  @Test
  public void testGetContractAddress() {
    // Arrange, Act and Assert
    assertEquals(0, ProgramResult.createEmpty().getContractAddress().length);
  }

  /**
   * Method under test: {@link ProgramResult#setContractAddress(byte[])}
   */
  @Test
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
   * Method under test: {@link ProgramResult#getTriggerList()}
   */
  @Test
  public void testGetTriggerList() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getTriggerList().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#getTriggerList()}
   */
  @Test
  public void testGetTriggerList2() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    ArrayList<ContractTrigger> triggerList = new ArrayList<>();
    createEmptyResult.setTriggerList(triggerList);

    // Act
    List<ContractTrigger> actualTriggerList = createEmptyResult.getTriggerList();

    // Assert
    assertTrue(actualTriggerList.isEmpty());
    assertSame(triggerList, actualTriggerList);
  }

  /**
   * Method under test: {@link ProgramResult#getDeleteAccounts()}
   */
  @Test
  public void testGetDeleteAccounts() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getDeleteAccounts().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#getDeleteAccounts()}
   */
  @Test
  public void testGetDeleteAccounts2() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act and Assert
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Method under test: {@link ProgramResult#addDeleteAccount(DataWord)}
   */
  @Test
  public void testAddDeleteAccount() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Assert
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Method under test: {@link ProgramResult#addDeleteAccount(DataWord)}
   */
  @Test
  public void testAddDeleteAccount2() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Assert
    assertEquals(1, createEmptyResult.getDeleteAccounts().size());
  }

  /**
   * Method under test: {@link ProgramResult#getLogInfoList()}
   */
  @Test
  public void testGetLogInfoList() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getLogInfoList().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#getLogInfoList()}
   */
  @Test
  public void testGetLogInfoList2() throws UnsupportedEncodingException {
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
   * Method under test: {@link ProgramResult#addLogInfo(LogInfo)}
   */
  @Test
  public void testAddLogInfo() throws UnsupportedEncodingException {
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
   * Method under test: {@link ProgramResult#addLogInfo(LogInfo)}
   */
  @Test
  public void testAddLogInfo2() throws UnsupportedEncodingException {
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
   * Method under test: {@link ProgramResult#getCallCreateList()}
   */
  @Test
  public void testGetCallCreateList() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getCallCreateList().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#getCallCreateList()}
   */
  @Test
  public void testGetCallCreateList2() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}
   */
  @Test
  public void testAddCallCreate() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createEmptyResult.addCallCreate(data, destination, energyLimit, value);

    // Assert
    TransactionResultCapsule ret = createEmptyResult.getRet();
    Protocol.Transaction.Result instance = ret.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<CallCreate> callCreateList = createEmptyResult.getCallCreateList();
    assertEquals(1, callCreateList.size());
    assertEquals(15, descriptorForType.getFields().size());
    assertEquals(2, descriptorForType.getEnumTypes().size());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    assertEquals(3, containingType.getNestedTypes().size());
    assertTrue(descriptorForType.getOptions().findInitializationErrors().isEmpty());
    assertTrue(containingType.toProto().findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(containingType.getEnumTypes().isEmpty());
    assertTrue(containingType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(containingType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(containingType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getTriggerList().isEmpty());
    assertTrue(ret.getOrderDetailsList().isEmpty());
    assertEquals(instance, instance.getDefaultInstanceForType());
    CallCreate getResult = callCreateList.get(0);
    assertSame(data, getResult.getData());
    assertSame(destination, getResult.getDestination());
    assertSame(energyLimit, getResult.getEnergyLimit());
    assertSame(value, getResult.getValue());
  }

  /**
   * Method under test:
   * {@link ProgramResult#addCallCreate(byte[], byte[], byte[], byte[])}
   */
  @Test
  public void testAddCallCreate2() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.addCallCreate(data, destination, energyLimit, "AXAXAXAX".getBytes("UTF-8"));
    byte[] data2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act
    createEmptyResult.addCallCreate(data2, destination2, energyLimit2, value);

    // Assert
    TransactionResultCapsule ret = createEmptyResult.getRet();
    Protocol.Transaction.Result instance = ret.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(15, descriptorForType.getFields().size());
    assertEquals(2, descriptorForType.getEnumTypes().size());
    List<CallCreate> callCreateList = createEmptyResult.getCallCreateList();
    assertEquals(2, callCreateList.size());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    assertEquals(3, containingType.getNestedTypes().size());
    CallCreate getResult = callCreateList.get(0);
    assertEquals(8, getResult.getData().length);
    assertTrue(descriptorForType.getOptions().findInitializationErrors().isEmpty());
    assertTrue(containingType.toProto().findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(containingType.getEnumTypes().isEmpty());
    assertTrue(containingType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(containingType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(containingType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getTriggerList().isEmpty());
    assertTrue(ret.getOrderDetailsList().isEmpty());
    assertEquals(instance, instance.getDefaultInstanceForType());
    CallCreate getResult2 = callCreateList.get(1);
    assertSame(data2, getResult2.getData());
    assertSame(destination2, getResult2.getDestination());
    assertSame(energyLimit2, getResult2.getEnergyLimit());
    assertSame(value, getResult2.getValue());
    byte[] expectedDestination = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedDestination, getResult.getDestination());
    byte[] expectedEnergyLimit = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedEnergyLimit, getResult.getEnergyLimit());
    byte[] expectedValue = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedValue, getResult.getValue());
  }

  /**
   * Method under test: {@link ProgramResult#getInternalTransactions()}
   */
  @Test
  public void testGetInternalTransactions() {
    // Arrange, Act and Assert
    assertTrue(ProgramResult.createEmpty().getInternalTransactions().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#getInternalTransactions()}
   */
  @Test
  public void testGetInternalTransactions2() throws UnsupportedEncodingException {
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
   * Method under test:
   * {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  public void testAddInternalTransaction() throws UnsupportedEncodingException {
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
    assertEquals("", actualAddInternalTransactionResult.getExtra());
    assertEquals("Note", actualAddInternalTransactionResult.getNote());
    assertNull(actualAddInternalTransactionResult.getTransaction());
    assertEquals(0, actualAddInternalTransactionResult.getIndex());
    assertEquals(1, createEmptyResult.getInternalTransactions().size());
    assertEquals(1L, actualAddInternalTransactionResult.getNonce());
    assertEquals(2, actualAddInternalTransactionResult.getDeep());
    assertEquals(42L, actualAddInternalTransactionResult.getValue());
    assertFalse(actualAddInternalTransactionResult.isRejected());
    assertTrue(actualAddInternalTransactionResult.getTokenInfo().isEmpty());
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
   * Method under test:
   * {@link ProgramResult#addInternalTransaction(byte[], int, byte[], byte[], long, byte[], String, long, Map)}
   */
  @Test
  public void testAddInternalTransaction2() throws UnsupportedEncodingException {
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
    assertEquals("", actualAddInternalTransactionResult.getExtra());
    assertEquals("Note", actualAddInternalTransactionResult.getNote());
    assertNull(actualAddInternalTransactionResult.getTransaction());
    assertEquals(1, actualAddInternalTransactionResult.getIndex());
    assertEquals(1L, actualAddInternalTransactionResult.getNonce());
    assertEquals(2, createEmptyResult.getInternalTransactions().size());
    assertEquals(2, actualAddInternalTransactionResult.getDeep());
    assertEquals(42L, actualAddInternalTransactionResult.getValue());
    assertFalse(actualAddInternalTransactionResult.isRejected());
    assertTrue(actualAddInternalTransactionResult.getTokenInfo().isEmpty());
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
   * Method under test: {@link ProgramResult#rejectInternalTransactions()}
   */
  @Test
  public void testRejectInternalTransactions() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.rejectInternalTransactions();

    // Assert
    assertTrue(createEmptyResult.getInternalTransactions().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#rejectInternalTransactions()}
   */
  @Test
  public void testRejectInternalTransactions2() throws UnsupportedEncodingException {
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
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.reset();

    // Assert
    List<Descriptors.FieldDescriptor> fields = createEmptyResult.getRet()
        .getInstance()
        .getDescriptorForType()
        .getFields();
    assertEquals(15, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getDeleteAccounts().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  public void testReset2() {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    createEmptyResult.addDeleteAccount(DataWord.ZERO());

    // Act
    createEmptyResult.reset();

    // Assert
    List<Descriptors.FieldDescriptor> fields = createEmptyResult.getRet()
        .getInstance()
        .getDescriptorForType()
        .getFields();
    assertEquals(15, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getDeleteAccounts().isEmpty());
  }

  /**
   * Method under test: {@link ProgramResult#reset()}
   */
  @Test
  public void testReset3() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<DataWord> topics = new ArrayList<>();
    createEmptyResult.addLogInfo(new LogInfo(address, topics, "AXAXAXAX".getBytes("UTF-8")));

    // Act
    createEmptyResult.reset();

    // Assert
    List<Descriptors.FieldDescriptor> fields = createEmptyResult.getRet()
        .getInstance()
        .getDescriptorForType()
        .getFields();
    assertEquals(15, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(14).toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getJsonName());
    assertEquals("cancel_unfreezeV2_amount", toProtoResult.getName());
    assertEquals(0, toProtoResult.getOneofIndex());
    assertEquals(28, toProtoResult.getNumber());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult.getLabel());
    assertTrue(createEmptyResult.getLogInfoList().isEmpty());
    assertTrue(createEmptyResult.getDeleteAccounts().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProgramResult#refundEnergy(long)}
   *   <li>{@link ProgramResult#setException(RuntimeException)}
   *   <li>{@link ProgramResult#setHReturn(byte[])}
   *   <li>
   * {@link ProgramResult#setResultCode(Protocol.Transaction.Result.contractResult)}
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
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ProgramResult createEmptyResult = ProgramResult.createEmpty();

    // Act
    createEmptyResult.refundEnergy(1L);
    RuntimeException exception = new RuntimeException("foo");
    createEmptyResult.setException(exception);
    byte[] hReturn = "AXAXAXAX".getBytes("UTF-8");
    createEmptyResult.setHReturn(hReturn);
    createEmptyResult.setResultCode(Protocol.Transaction.Result.contractResult.DEFAULT);
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
    Protocol.Transaction.Result.contractResult actualResultCode = createEmptyResult.getResultCode();
    TransactionResultCapsule actualRet = createEmptyResult.getRet();
    String actualRuntimeError = createEmptyResult.getRuntimeError();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualRuntimeError);
    assertEquals(0L, actualEnergyUsed);
    assertEquals(1L, actualEnergyPenaltyTotal);
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, actualResultCode);
    assertTrue(createEmptyResult.isRevert());
    assertSame(exception, actualException);
    assertSame(ret, actualRet);
    assertSame(hReturn, actualHReturn);
  }
}
