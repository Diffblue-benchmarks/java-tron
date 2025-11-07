package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class JsonRpcApiUtilDiffblueTest {
  @InjectMocks
  private JsonRpcApiUtil jsonRpcApiUtil;

  /**
   * Method under test: {@link JsonRpcApiUtil#encode58Check(byte[])}
   */
  @Test
  public void testEncode58Check() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("2EXBt7okuCNpeP6cB", JsonRpcApiUtil.encode58Check("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("A8jneNrc5qLrteEU", JsonRpcApiUtil.encode58Check("\bXAXAXAX".getBytes("UTF-8")));
    assertEquals("1NtLSPRy5w6XsQUY", JsonRpcApiUtil.encode58Check(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertEquals("", JsonRpcApiUtil.encode58Check(null));
    assertEquals("", JsonRpcApiUtil.encode58Check(new byte[]{}));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getMethodSign(String)}
   */
  @Test
  public void testGetMethodSign() {
    // Arrange, Act and Assert
    assertEquals("770748fd", JsonRpcApiUtil.getMethodSign("Method"));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getBlockID(Protocol.Block)}
   */
  @Test
  public void testGetBlockID() {
    // Arrange, Act and Assert
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        JsonRpcApiUtil.getBlockID(Protocol.Block.getDefaultInstance()));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getTxID(Protocol.Transaction)}
   */
  @Test
  public void testGetTxID() {
    // Arrange, Act and Assert
    assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        JsonRpcApiUtil.getTxID(Protocol.Transaction.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Wallet)}
   */
  @Test
  public void testGetTransactionAmount() {
    // Arrange
    Protocol.Transaction.Contract contract = Protocol.Transaction.Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "Hash", new Wallet()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Wallet)}
   */
  @Test
  public void testGetTransactionAmount2() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(null, "Hash", new Wallet()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Wallet)}
   */
  @Test
  public void testGetTransactionAmount3() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(Protocol.Transaction.Contract.getDefaultInstance(), "Hash",
        mock(Wallet.class)));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Protocol.TransactionInfo, Wallet)}
   */
  @Test
  public void testGetTransactionAmount4() {
    // Arrange
    Protocol.Transaction.Contract contract = Protocol.Transaction.Contract.getDefaultInstance();
    Protocol.TransactionInfo transactionInfo = Protocol.TransactionInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "Hash", transactionInfo, new Wallet()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Protocol.TransactionInfo, Wallet)}
   */
  @Test
  public void testGetTransactionAmount5() {
    // Arrange
    Protocol.TransactionInfo transactionInfo = Protocol.TransactionInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(null, "Hash", transactionInfo, new Wallet()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getTransactionAmount(Protocol.Transaction.Contract, String, Protocol.TransactionInfo, Wallet)}
   */
  @Test
  public void testGetTransactionAmount6() {
    // Arrange
    Protocol.Transaction.Contract contract = Protocol.Transaction.Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getTransactionAmount(contract, "Hash",
        Protocol.TransactionInfo.getDefaultInstance(), mock(Wallet.class)));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getAmountFromTransactionInfo(String, Protocol.Transaction.Contract.ContractType, Protocol.TransactionInfo)}
   */
  @Test
  public void testGetAmountFromTransactionInfo() {
    // Arrange, Act and Assert
    assertEquals(0L,
        JsonRpcApiUtil.getAmountFromTransactionInfo("Hash",
            Protocol.Transaction.Contract.ContractType.AccountCreateContract,
            Protocol.TransactionInfo.getDefaultInstance()));
    assertEquals(0L, JsonRpcApiUtil.getAmountFromTransactionInfo("Hash",
        Protocol.Transaction.Contract.ContractType.UnfreezeBalanceContract, null));
    assertEquals(0L,
        JsonRpcApiUtil.getAmountFromTransactionInfo("Hash",
            Protocol.Transaction.Contract.ContractType.UnfreezeBalanceContract,
            Protocol.TransactionInfo.getDefaultInstance()));
    assertEquals(0L,
        JsonRpcApiUtil.getAmountFromTransactionInfo("Hash",
            Protocol.Transaction.Contract.ContractType.WithdrawBalanceContract,
            Protocol.TransactionInfo.getDefaultInstance()));
    assertEquals(0L,
        JsonRpcApiUtil.getAmountFromTransactionInfo("Hash",
            Protocol.Transaction.Contract.ContractType.WithdrawExpireUnfreezeContract,
            Protocol.TransactionInfo.getDefaultInstance()));
    assertEquals(0L,
        JsonRpcApiUtil.getAmountFromTransactionInfo("Hash", null, Protocol.TransactionInfo.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#addressCompatibleToByteArray(String)}
   */
  @Test
  public void testAddressCompatibleToByteArray() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("42 Main St"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray(null));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("0x"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> JsonRpcApiUtil.addressCompatibleToByteArray("11 Station Rd"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressCompatibleToByteArray("42"));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#addressToByteArray(String)}
   */
  @Test
  public void testAddressToByteArray() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressToByteArray("0x"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.addressToByteArray("42"));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#topicToByteArray(String)}
   */
  @Test
  public void testTopicToByteArray() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.topicToByteArray("0x"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.topicToByteArray("0"));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#paramStringIsNull(String)}
   */
  @Test
  public void testParamStringIsNull() {
    // Arrange, Act and Assert
    assertFalse(JsonRpcApiUtil.paramStringIsNull("String"));
    assertTrue(JsonRpcApiUtil.paramStringIsNull("0x"));
    assertTrue(JsonRpcApiUtil.paramStringIsNull(null));
    assertTrue(JsonRpcApiUtil.paramStringIsNull(""));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#paramQuantityIsNull(String)}
   */
  @Test
  public void testParamQuantityIsNull() {
    // Arrange, Act and Assert
    assertFalse(JsonRpcApiUtil.paramQuantityIsNull("Quantity"));
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull("0x0"));
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull(null));
    assertTrue(JsonRpcApiUtil.paramQuantityIsNull(""));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#parseQuantityValue(String)}
   */
  @Test
  public void testParseQuantityValue() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.parseQuantityValue("42"));
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue(null));
    assertThrows(JsonRpcInvalidParamsException.class, () -> JsonRpcApiUtil.parseQuantityValue("0x"));
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue("0x0"));
    assertEquals(0L, JsonRpcApiUtil.parseQuantityValue(""));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  public void testGetEnergyUsageTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(new ArrayList<>(), 1, 1L));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  public void testGetEnergyUsageTotal2() {
    // Arrange
    ArrayList<Protocol.TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  public void testGetEnergyUsageTotal3() {
    // Arrange
    ArrayList<Protocol.TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(List, int, long)}
   */
  @Test
  public void testGetEnergyUsageTotal4() {
    // Arrange
    ArrayList<Protocol.TransactionInfo> transactionInfoList = new ArrayList<>();
    transactionInfoList.add(Protocol.TransactionInfo.getDefaultInstance());
    transactionInfoList.add(null);

    // Act and Assert
    assertEquals(0L, JsonRpcApiUtil.getEnergyUsageTotal(transactionInfoList, 1, 1L));
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(Protocol.Transaction, Wallet)}
   */
  @Test
  public void testGetEnergyUsageTotal5() {
    // Arrange
    Protocol.Transaction transaction = Protocol.Transaction.getDefaultInstance();
    Wallet wallet = mock(Wallet.class);
    when(wallet.getTransactionInfoById(Mockito.<ByteString>any()))
        .thenReturn(Protocol.TransactionInfo.getDefaultInstance());

    // Act
    long actualEnergyUsageTotal = JsonRpcApiUtil.getEnergyUsageTotal(transaction, wallet);

    // Assert
    verify(wallet).getTransactionInfoById(isA(ByteString.class));
    assertEquals(0L, actualEnergyUsageTotal);
  }

  /**
   * Method under test:
   * {@link JsonRpcApiUtil#getEnergyUsageTotal(Protocol.Transaction, Wallet)}
   */
  @Test
  public void testGetEnergyUsageTotal6() {
    // Arrange
    Protocol.Transaction transaction = Protocol.Transaction.getDefaultInstance();
    Wallet wallet = mock(Wallet.class);
    when(wallet.getTransactionInfoById(Mockito.<ByteString>any())).thenReturn(null);

    // Act
    long actualEnergyUsageTotal = JsonRpcApiUtil.getEnergyUsageTotal(transaction, wallet);

    // Assert
    verify(wallet).getTransactionInfoById(isA(ByteString.class));
    assertEquals(0L, actualEnergyUsageTotal);
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  public void testGetTransactionIndex() {
    // Arrange, Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", new ArrayList<>()));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  public void testGetTransactionIndex2() {
    // Arrange
    ArrayList<Protocol.Transaction> txList = new ArrayList<>();
    txList.add(Protocol.Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", txList));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  public void testGetTransactionIndex3() {
    // Arrange
    ArrayList<Protocol.Transaction> txList = new ArrayList<>();
    txList.add(Protocol.Transaction.getDefaultInstance());
    txList.add(Protocol.Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(-1, JsonRpcApiUtil.getTransactionIndex("42", txList));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getTransactionIndex(String, List)}
   */
  @Test
  public void testGetTransactionIndex4() {
    // Arrange
    ArrayList<Protocol.Transaction> txList = new ArrayList<>();
    txList.add(Protocol.Transaction.getDefaultInstance());

    // Act and Assert
    assertEquals(0,
        JsonRpcApiUtil.getTransactionIndex("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", txList));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#parseEnergyFee(long, String)}
   */
  @Test
  public void testParseEnergyFee() {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.parseEnergyFee(10L, ","));
  }

  /**
   * Method under test: {@link JsonRpcApiUtil#getByJsonBlockId(String)}
   */
  @Test
  public void testGetByJsonBlockId() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(null));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.PENDING_STR));
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.LATEST_STR));
    assertEquals(0L, JsonRpcApiUtil.getByJsonBlockId(TronJsonRpcImpl.EARLIEST_STR));
    assertEquals(0L, JsonRpcApiUtil.getByJsonBlockId("0x0"));
    assertEquals(-1L, JsonRpcApiUtil.getByJsonBlockId(""));
  }
}
