package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcApiUtilDiffblueTest {
  @InjectMocks
  private JsonRpcApiUtil jsonRpcApiUtil;

  /**
   * Test {@link JsonRpcApiUtil#encode58Check(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code 1NtLSPRy5w6XsQUY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.encode58Check(byte[])"})
  public void testEncode58Check_whenA_thenReturn1NtLSPRy5w6XsQUY() {
    // Arrange, Act and Assert
    assertEquals("1NtLSPRy5w6XsQUY", JsonRpcApiUtil.encode58Check(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JsonRpcApiUtil#encode58Check(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 2EXBt7okuCNpeP6cB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.encode58Check(byte[])"})
  public void testEncode58Check_whenAxaxaxaxBytesIsUtf8_thenReturn2EXBt7okuCNpeP6cB()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("2EXBt7okuCNpeP6cB", JsonRpcApiUtil.encode58Check("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonRpcApiUtil#encode58Check(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.encode58Check(byte[])"})
  public void testEncode58Check_whenEmptyArrayOfByte_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JsonRpcApiUtil.encode58Check(new byte[]{}));
  }

  /**
   * Test {@link JsonRpcApiUtil#encode58Check(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.encode58Check(byte[])"})
  public void testEncode58Check_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JsonRpcApiUtil.encode58Check(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#encode58Check(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code A8jneNrc5qLrteEU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.encode58Check(byte[])"})
  public void testEncode58Check_whenXaxaxaxBytesIsUtf8_thenReturnA8jneNrc5qLrteEU()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("A8jneNrc5qLrteEU", JsonRpcApiUtil.encode58Check("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JsonRpcApiUtil#getMethodSign(String)}.
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getMethodSign(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.getMethodSign(String)"})
  public void testGetMethodSign() {
    // Arrange, Act and Assert
    assertEquals("770748fd", JsonRpcApiUtil.getMethodSign("Method"));
  }

  /**
   * Test {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return SerializedSize is thirty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract JsonRpcApiUtil.triggerCallContract(byte[], byte[], long, byte[], long, String)"})
  public void testTriggerCallContract_when42_thenReturnSerializedSizeIsThirtySix() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] contractAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    TriggerSmartContract actualTriggerCallContractResult = JsonRpcApiUtil.triggerCallContract(address, contractAddress,
        42L, "AXAXAXAX".getBytes("UTF-8"), 42L, "42");

    // Assert
    assertEquals(36, actualTriggerCallContractResult.getSerializedSize());
    assertEquals(42L, actualTriggerCallContractResult.getCallTokenValue());
    assertEquals(42L, actualTriggerCallContractResult.getTokenId());
    assertEquals(6, actualTriggerCallContractResult.getAllFields().size());
    UnknownFieldSet unknownFields = actualTriggerCallContractResult.getUnknownFields();
    TriggerSmartContract defaultInstanceForType = actualTriggerCallContractResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract JsonRpcApiUtil.triggerCallContract(byte[], byte[], long, byte[], long, String)"})
  public void testTriggerCallContract_whenA() {
    // Arrange and Act
    TriggerSmartContract actualTriggerCallContractResult = JsonRpcApiUtil.triggerCallContract(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 42L,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 42L, null);

    // Assert
    UnknownFieldSet unknownFields = actualTriggerCallContractResult.getUnknownFields();
    TriggerSmartContract defaultInstanceForType = actualTriggerCallContractResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#triggerCallContract(byte[], byte[], long, byte[], long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract JsonRpcApiUtil.triggerCallContract(byte[], byte[], long, byte[], long, String)"})
  public void testTriggerCallContract_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] contractAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    TriggerSmartContract actualTriggerCallContractResult = JsonRpcApiUtil.triggerCallContract(address, contractAddress,
        42L, "AXAXAXAX".getBytes("UTF-8"), 42L, "");

    // Assert
    UnknownFieldSet unknownFields = actualTriggerCallContractResult.getUnknownFields();
    TriggerSmartContract defaultInstanceForType = actualTriggerCallContractResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonRpcApiUtil#getBlockID(Block)}.
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getBlockID(Block)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.getBlockID(Block)"})
  public void testGetBlockID() {
    // Arrange, Act and Assert
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        JsonRpcApiUtil.getBlockID(Block.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTxID(Transaction)}.
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTxID(Transaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JsonRpcApiUtil.getTxID(Transaction)"})
  public void testGetTxID() {
    // Arrange, Act and Assert
    assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        JsonRpcApiUtil.getTxID(Transaction.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionAmount(Contract, String, TransactionInfo, Wallet)} with {@code contract}, {@code hash}, {@code transactionInfo}, {@code wallet}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionAmount(Transaction.Contract, String, TransactionInfo, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getTransactionAmount(Transaction.Contract, String, TransactionInfo, Wallet)"})
  public void testGetTransactionAmountWithContractHashTransactionInfoWallet_whenNull() {
    // Arrange
    TransactionInfo transactionInfo = TransactionInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(null, "Hash", transactionInfo, new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionAmount(Contract, String, TransactionInfo, Wallet)} with {@code contract}, {@code hash}, {@code transactionInfo}, {@code wallet}.
   * <ul>
   *   <li>When {@link Wallet#Wallet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionAmount(Transaction.Contract, String, TransactionInfo, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getTransactionAmount(Transaction.Contract, String, TransactionInfo, Wallet)"})
  public void testGetTransactionAmountWithContractHashTransactionInfoWallet_whenWallet() {
    // Arrange
    Contract contract = Contract.getDefaultInstance();
    TransactionInfo transactionInfo = TransactionInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "Hash", transactionInfo, new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionAmount(Contract, String, Wallet)} with {@code contract}, {@code hash}, {@code wallet}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionAmount(Transaction.Contract, String, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getTransactionAmount(Transaction.Contract, String, Wallet)"})
  public void testGetTransactionAmountWithContractHashWallet_when0x() {
    // Arrange
    Contract contract = Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "0x", new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionAmount(Contract, String, Wallet)} with {@code contract}, {@code hash}, {@code wallet}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionAmount(Transaction.Contract, String, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getTransactionAmount(Transaction.Contract, String, Wallet)"})
  public void testGetTransactionAmountWithContractHashWallet_whenDefaultInstance() {
    // Arrange
    Contract contract = Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "Hash", new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionAmount(Contract, String, Wallet)} with {@code contract}, {@code hash}, {@code wallet}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionAmount(Transaction.Contract, String, Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getTransactionAmount(Transaction.Contract, String, Wallet)"})
  public void testGetTransactionAmountWithContractHashWallet_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(null, "Hash", new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code AccountCreateContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenAccountCreateContract() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", ContractType.AccountCreateContract,
        TransactionInfo.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", null, TransactionInfo.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code UnfreezeBalanceContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenUnfreezeBalanceContract() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", ContractType.UnfreezeBalanceContract, null));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code UnfreezeBalanceContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenUnfreezeBalanceContract2() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", ContractType.UnfreezeBalanceContract,
        TransactionInfo.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code WithdrawBalanceContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenWithdrawBalanceContract() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", ContractType.WithdrawBalanceContract,
        TransactionInfo.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, ContractType, TransactionInfo)}.
   * <ul>
   *   <li>When {@code WithdrawExpireUnfreezeContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "long JsonRpcApiUtil.getAmountFromTransactionInfo(String, Transaction.Contract.ContractType, TransactionInfo)"})
  public void testGetAmountFromTransactionInfo_whenWithdrawExpireUnfreezeContract() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", ContractType.WithdrawExpireUnfreezeContract,
        TransactionInfo.getDefaultInstance()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getUnfreezeAssetAmount(byte[], Wallet)"})
  public void testGetUnfreezeAssetAmount_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] addressBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getUnfreezeAssetAmount(addressBytes, new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getUnfreezeAssetAmount(byte[], Wallet)"})
  public void testGetUnfreezeAssetAmount_whenAxaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getUnfreezeAssetAmount("AXAXAXAX".getBytes("UTF-8"), null));
  }

  /**
   * Test {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getUnfreezeAssetAmount(byte[], Wallet)"})
  public void testGetUnfreezeAssetAmount_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getUnfreezeAssetAmount(new byte[]{}, new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getUnfreezeAssetAmount(byte[], Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getUnfreezeAssetAmount(byte[], Wallet)"})
  public void testGetUnfreezeAssetAmount_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getUnfreezeAssetAmount(null, new Wallet()));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressCompatibleToByteArray(String)"})
  public void testAddressCompatibleToByteArray_when0x() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("0x"));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}.
   * <ul>
   *   <li>When {@code 11 Station Rd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressCompatibleToByteArray(String)"})
  public void testAddressCompatibleToByteArray_when11StationRd() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> JsonRpcApiUtil.addressCompatibleToByteArray("11 Station Rd"));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressCompatibleToByteArray(String)"})
  public void testAddressCompatibleToByteArray_when42() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("42"));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}.
   * <ul>
   *   <li>When {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressCompatibleToByteArray(String)"})
  public void testAddressCompatibleToByteArray_when42MainSt() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("42 Main St"));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressCompatibleToByteArray(String)"})
  public void testAddressCompatibleToByteArray_whenNull() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressToByteArray(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressToByteArray(String)"})
  public void testAddressToByteArray_when0x_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressToByteArray("0x"));
  }

  /**
   * Test {@link JsonRpcApiUtil#addressToByteArray(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#addressToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.addressToByteArray(String)"})
  public void testAddressToByteArray_when42_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressToByteArray("42"));
  }

  /**
   * Test {@link JsonRpcApiUtil#topicToByteArray(String)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#topicToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.topicToByteArray(String)"})
  public void testTopicToByteArray_when0_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.topicToByteArray("0"));
  }

  /**
   * Test {@link JsonRpcApiUtil#topicToByteArray(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#topicToByteArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] JsonRpcApiUtil.topicToByteArray(String)"})
  public void testTopicToByteArray_when0x_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.topicToByteArray("0x"));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramStringIsNull(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramStringIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramStringIsNull(String)"})
  public void testParamStringIsNull_when0x_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramStringIsNull("0x"));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramStringIsNull(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramStringIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramStringIsNull(String)"})
  public void testParamStringIsNull_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramStringIsNull(""));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramStringIsNull(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramStringIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramStringIsNull(String)"})
  public void testParamStringIsNull_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramStringIsNull(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramStringIsNull(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramStringIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramStringIsNull(String)"})
  public void testParamStringIsNull_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonRpcApiUtil.paramStringIsNull("String"));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramQuantityIsNull(String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramQuantityIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramQuantityIsNull(String)"})
  public void testParamQuantityIsNull_when0x0_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull("0x0"));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramQuantityIsNull(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramQuantityIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramQuantityIsNull(String)"})
  public void testParamQuantityIsNull_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull(""));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramQuantityIsNull(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramQuantityIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramQuantityIsNull(String)"})
  public void testParamQuantityIsNull_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#paramQuantityIsNull(String)}.
   * <ul>
   *   <li>When {@code Quantity}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#paramQuantityIsNull(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonRpcApiUtil.paramQuantityIsNull(String)"})
  public void testParamQuantityIsNull_whenQuantity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonRpcApiUtil.paramQuantityIsNull("Quantity"));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseQuantityValue(String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseQuantityValue(String)"})
  public void testParseQuantityValue_when0x0_thenReturnZero() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue("0x0"));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseQuantityValue(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseQuantityValue(String)"})
  public void testParseQuantityValue_when0x_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.parseQuantityValue("0x"));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseQuantityValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseQuantityValue(String)"})
  public void testParseQuantityValue_when42_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.parseQuantityValue("42"));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseQuantityValue(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseQuantityValue(String)"})
  public void testParseQuantityValue_whenEmptyString_thenReturnZero() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue(""));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseQuantityValue(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseQuantityValue(String)"})
  public void testParseQuantityValue_whenNull_thenReturnZero() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)} with {@code transactionInfoList}, {@code i}, {@code blockNum}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getEnergyUsageTotal(List, int, long)"})
  public void testGetEnergyUsageTotalWithTransactionInfoListIBlockNum_givenDefaultInstance() {
    // Arrange
    ArrayList<TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Test {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)} with {@code transactionInfoList}, {@code i}, {@code blockNum}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getEnergyUsageTotal(List, int, long)"})
  public void testGetEnergyUsageTotalWithTransactionInfoListIBlockNum_givenDefaultInstance2() {
    // Arrange
    ArrayList<TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(TransactionInfo.getDefaultInstance());
    transactionInfoList.add(TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Test {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)} with {@code transactionInfoList}, {@code i}, {@code blockNum}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getEnergyUsageTotal(List, int, long)"})
  public void testGetEnergyUsageTotalWithTransactionInfoListIBlockNum_givenNull() {
    // Arrange
    ArrayList<TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(TransactionInfo.getDefaultInstance());
    transactionInfoList.add(null);

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Test {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)} with {@code transactionInfoList}, {@code i}, {@code blockNum}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getEnergyUsageTotal(List, int, long)"})
  public void testGetEnergyUsageTotalWithTransactionInfoListIBlockNum_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(new ArrayList<>(), 1, 1L));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionIndex(String, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonRpcApiUtil.getTransactionIndex(String, List)"})
  public void testGetTransactionIndex_givenDefaultInstance_thenReturnMinusOne() {
    // Arrange
    ArrayList<Transaction> txList = new ArrayList<>();
    txList.add(Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", txList));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionIndex(String, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonRpcApiUtil.getTransactionIndex(String, List)"})
  public void testGetTransactionIndex_givenDefaultInstance_thenReturnMinusOne2() {
    // Arrange
    ArrayList<Transaction> txList = new ArrayList<>();
    txList.add(Transaction.getDefaultInstance());
    txList.add(Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", txList));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionIndex(String, List)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonRpcApiUtil.getTransactionIndex(String, List)"})
  public void testGetTransactionIndex_thenReturnZero() {
    // Arrange
    ArrayList<Transaction> txList = new ArrayList<>();
    txList.add(Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(0,
        JsonRpcApiUtil.getTransactionIndex("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", txList));
  }

  /**
   * Test {@link JsonRpcApiUtil#getTransactionIndex(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JsonRpcApiUtil.getTransactionIndex(String, List)"})
  public void testGetTransactionIndex_whenArrayList_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", new ArrayList<>()));
  }

  /**
   * Test {@link JsonRpcApiUtil#parseEnergyFee(long, String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#parseEnergyFee(long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.parseEnergyFee(long, String)"})
  public void testParseEnergyFee_whenComma_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.parseEnergyFee(10L, ","));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_when0x0_thenReturnZero() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getByJsonBlockId("0x0"));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#EARLIEST_STR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_whenEarliest_str_thenReturnZero() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.EARLIEST_STR));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_whenEmptyString_thenReturnMinusOne() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(""));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#LATEST_STR}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_whenLatest_str_thenReturnMinusOne() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.LATEST_STR));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_whenNull_thenReturnMinusOne() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(null));
  }

  /**
   * Test {@link JsonRpcApiUtil#getByJsonBlockId(String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#PENDING_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long JsonRpcApiUtil.getByJsonBlockId(String)"})
  public void testGetByJsonBlockId_whenPending_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.PENDING_STR));
  }
}
