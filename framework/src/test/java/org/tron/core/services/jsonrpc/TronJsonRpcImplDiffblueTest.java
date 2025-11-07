package org.tron.core.services.jsonrpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.api.GrpcAPI;
import org.tron.common.entity.NodeInfo;
import org.tron.common.entity.PeerInfo;
import org.tron.common.logsfilter.capsule.BlockFilterCapsule;
import org.tron.core.ChainBaseManager;
import org.tron.core.Wallet;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.TransactionRetCapsule;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.JsonRpcInternalException;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;
import org.tron.core.exception.JsonRpcMethodNotFoundException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.NodeInfoService;
import org.tron.core.services.jsonrpc.filters.BlockFilterAndResult;
import org.tron.core.services.jsonrpc.filters.LogFilterAndResult;
import org.tron.core.services.jsonrpc.types.BlockResult;
import org.tron.core.services.jsonrpc.types.BuildArguments;
import org.tron.core.services.jsonrpc.types.CallArguments;
import org.tron.core.services.jsonrpc.types.TransactionResult;
import org.tron.core.store.TransactionRetStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class TronJsonRpcImplDiffblueTest {
  @Mock
  private Manager manager;

  @Mock
  private NodeInfoService nodeInfoService;

  @InjectMocks
  private TronJsonRpcImpl tronJsonRpcImpl;

  @Mock
  private Wallet wallet;

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#handleBLockFilter(BlockFilterCapsule)}
   */
  @Test
  public void testHandleBLockFilter() {
    // Arrange
    BlockFilterCapsule blockFilterCapsule = mock(BlockFilterCapsule.class);
    when(blockFilterCapsule.isSolidified()).thenReturn(true);

    // Act
    TronJsonRpcImpl.handleBLockFilter(blockFilterCapsule);

    // Assert that nothing has changed
    verify(blockFilterCapsule).isSolidified();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#web3ClientVersion()}
   */
  @Test
  public void testWeb3ClientVersion() {
    // Arrange, Act and Assert
    assertEquals("TRON/v4.7.7/Linux/Java1.8", tronJsonRpcImpl.web3ClientVersion());
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#web3Sha3(String)}
   */
  @Test
  public void testWeb3Sha3() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.web3Sha3("Data"));
    assertEquals("0xc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a470", tronJsonRpcImpl.web3Sha3("0x"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.web3Sha3("invalid input value"));
    assertEquals("0x1f675bff07515f5df96737194ea945c36c41e7b4fcef307b7cd4d0e602a69111", tronJsonRpcImpl.web3Sha3("42"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockTransactionCountByHash(String)}
   */
  @Test
  public void testEthGetBlockTransactionCountByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.ethGetBlockTransactionCountByHash("Block Hash"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}
   */
  @Test
  public void testEthGetBlockTransactionCountByNumber() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getTransactionsByJsonBlockId(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    String actualEthGetBlockTransactionCountByNumberResult = tronJsonRpcImpl
        .ethGetBlockTransactionCountByNumber("Block Num Or Tag");

    // Assert
    verify(wallet).getTransactionsByJsonBlockId(eq("Block Num Or Tag"));
    assertEquals("0x0", actualEthGetBlockTransactionCountByNumberResult);
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}
   */
  @Test
  public void testEthGetBlockTransactionCountByNumber2() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getTransactionsByJsonBlockId(Mockito.<String>any())).thenThrow(new JsonRpcInvalidParamsException());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.ethGetBlockTransactionCountByNumber("Block Num Or Tag"));
    verify(wallet).getTransactionsByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethGetBlockByHash(String, Boolean)}
   */
  @Test
  public void testEthGetBlockByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.ethGetBlockByHash("Block Hash", true));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockByNumber(String, Boolean)}
   */
  @Test
  public void testEthGetBlockByNumber() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getEnergyFee(anyLong())).thenReturn(1L);
    when(wallet.getTransactionInfoByBlockNum(anyLong())).thenReturn(GrpcAPI.TransactionInfoList.getDefaultInstance());
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    BlockResult actualEthGetBlockByNumberResult = tronJsonRpcImpl.ethGetBlockByNumber("Block Num Or Tag", true);

    // Assert
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
    verify(wallet).getEnergyFee(eq(0L));
    verify(wallet).getTransactionInfoByBlockNum(eq(0L));
    assertEquals("0x", actualEthGetBlockByNumberResult.getExtraData());
    assertEquals("0x", actualEthGetBlockByNumberResult.getParentHash());
    assertEquals("0x", actualEthGetBlockByNumberResult.getStateRoot());
    assertEquals("0x", actualEthGetBlockByNumberResult.getTransactionsRoot());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getBaseFeePerGas());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getDifficulty());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getGasLimit());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getGasUsed());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getNumber());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getSize());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getTimestamp());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getTotalDifficulty());
    assertEquals("0x0000000000000000", actualEthGetBlockByNumberResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualEthGetBlockByNumberResult.getMiner());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getMixHash());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getReceiptsRoot());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getSha3Uncles());
    assertEquals("0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "00000000000000", actualEthGetBlockByNumberResult.getLogsBloom());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualEthGetBlockByNumberResult.getHash());
    assertEquals(0, actualEthGetBlockByNumberResult.getTransactions().length);
    assertEquals(0, actualEthGetBlockByNumberResult.getUncles().length);
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockByNumber(String, Boolean)}
   */
  @Test
  public void testEthGetBlockByNumber2() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(null);

    // Act
    BlockResult actualEthGetBlockByNumberResult = tronJsonRpcImpl.ethGetBlockByNumber("Block Num Or Tag", true);

    // Assert
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
    assertNull(actualEthGetBlockByNumberResult);
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethGetBlockByNumber(String, Boolean)}
   */
  @Test
  public void testEthGetBlockByNumber3() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getTransactionInfoByBlockNum(anyLong())).thenReturn(GrpcAPI.TransactionInfoList.getDefaultInstance());
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    BlockResult actualEthGetBlockByNumberResult = tronJsonRpcImpl.ethGetBlockByNumber("Block Num Or Tag", false);

    // Assert
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
    verify(wallet).getTransactionInfoByBlockNum(eq(0L));
    assertEquals("0x", actualEthGetBlockByNumberResult.getExtraData());
    assertEquals("0x", actualEthGetBlockByNumberResult.getParentHash());
    assertEquals("0x", actualEthGetBlockByNumberResult.getStateRoot());
    assertEquals("0x", actualEthGetBlockByNumberResult.getTransactionsRoot());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getBaseFeePerGas());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getDifficulty());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getGasLimit());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getGasUsed());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getNumber());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getSize());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getTimestamp());
    assertEquals("0x0", actualEthGetBlockByNumberResult.getTotalDifficulty());
    assertEquals("0x0000000000000000", actualEthGetBlockByNumberResult.getNonce());
    assertEquals("0x0000000000000000000000000000000000000000", actualEthGetBlockByNumberResult.getMiner());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getMixHash());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getReceiptsRoot());
    assertEquals("0x0000000000000000000000000000000000000000000000000000000000000000",
        actualEthGetBlockByNumberResult.getSha3Uncles());
    assertEquals("0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "00000000000000", actualEthGetBlockByNumberResult.getLogsBloom());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
        actualEthGetBlockByNumberResult.getHash());
    assertEquals(0, actualEthGetBlockByNumberResult.getTransactions().length);
    assertEquals(0, actualEthGetBlockByNumberResult.getUncles().length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getNetVersion());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion2() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Act
    String actualNetVersion = tronJsonRpcImpl.getNetVersion();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    assertEquals("0x7852b855", actualNetVersion);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion3() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualNetVersion = tronJsonRpcImpl.getNetVersion();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x00000000", actualNetVersion);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion4() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(null);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getNetVersion());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion5() throws UnsupportedEncodingException, JsonRpcInternalException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualNetVersion = tronJsonRpcImpl.getNetVersion();

    // Assert
    verify(blockId).getBytes();
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x41584158", actualNetVersion);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  public void testGetNetVersion6() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn(new byte[]{});
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getNetVersion());
    verify(blockId).getBytes();
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.ethChainId());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId2() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Act
    String actualEthChainIdResult = tronJsonRpcImpl.ethChainId();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    assertEquals("0x7852b855", actualEthChainIdResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId3() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualEthChainIdResult = tronJsonRpcImpl.ethChainId();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x00000000", actualEthChainIdResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId4() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(null);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.ethChainId());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId5() throws UnsupportedEncodingException, JsonRpcInternalException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualEthChainIdResult = tronJsonRpcImpl.ethChainId();

    // Assert
    verify(blockId).getBytes();
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x41584158", actualEthChainIdResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  public void testEthChainId6() throws JsonRpcInternalException {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getBytes()).thenReturn(new byte[]{});
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(blockId);
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.ethChainId());
    verify(blockId).getBytes();
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#isListening()}
   */
  @Test
  public void testIsListening() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    boolean actualIsListeningResult = tronJsonRpcImpl.isListening();

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertFalse(actualIsListeningResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#isListening()}
   */
  @Test
  public void testIsListening2() {
    // Arrange
    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);

    // Act
    boolean actualIsListeningResult = tronJsonRpcImpl.isListening();

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfoService).getNodeInfo();
    assertTrue(actualIsListeningResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getProtocolVersion()}
   */
  @Test
  public void testGetProtocolVersion() {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    String actualProtocolVersion = tronJsonRpcImpl.getProtocolVersion();

    // Assert
    verify(wallet).getNowBlock();
    assertEquals("0x0", actualProtocolVersion);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLatestBlockNum()}
   */
  @Test
  public void testGetLatestBlockNum() {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    String actualLatestBlockNum = tronJsonRpcImpl.getLatestBlockNum();

    // Assert
    verify(wallet).getNowBlock();
    assertEquals("0x0", actualLatestBlockNum);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  public void testGetTrxBalance() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "Block Num Or Tag"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", TronJsonRpcImpl.EARLIEST_STR));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", TronJsonRpcImpl.PENDING_STR));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "0x"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "42"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "0x0"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  public void testGetStorageAt() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "Block Num Or Tag"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", TronJsonRpcImpl.EARLIEST_STR));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", TronJsonRpcImpl.PENDING_STR));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "0x"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "42"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "0x0"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  public void testGetABIOfSmartContract() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "Block Num Or Tag"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", TronJsonRpcImpl.EARLIEST_STR));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", TronJsonRpcImpl.PENDING_STR));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "0x"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "42"));
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "0x0"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getCoinbase()}
   */
  @Test
  public void testGetCoinbase() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getCoinbase()).thenReturn("Coinbase");

    // Act
    String actualCoinbase = tronJsonRpcImpl.getCoinbase();

    // Assert
    verify(wallet).getCoinbase();
    assertEquals("Coinbase", actualCoinbase);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getCoinbase()}
   */
  @Test
  public void testGetCoinbase2() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getCoinbase()).thenReturn("");

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getCoinbase());
    verify(wallet).getCoinbase();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#gasPrice()}
   */
  @Test
  public void testGasPrice() {
    // Arrange
    when(wallet.getEnergyFee()).thenReturn(1L);

    // Act
    String actualGasPriceResult = tronJsonRpcImpl.gasPrice();

    // Assert
    verify(wallet).getEnergyFee();
    assertEquals("0x1", actualGasPriceResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#estimateGas(CallArguments)}
   */
  @Test
  public void testEstimateGas()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    NodeInfoService nodeInfoService = new NodeInfoService();
    Wallet wallet = new Wallet();
    TronJsonRpcImpl tronJsonRpcImpl = new TronJsonRpcImpl(nodeInfoService, wallet, new Manager());
    CallArguments args = mock(CallArguments.class);
    when(args.getData()).thenReturn("Data");
    when(args.parseValue()).thenReturn(42L);
    when(args.getContractType(Mockito.<Wallet>any()))
        .thenReturn(Protocol.Transaction.Contract.ContractType.AccountCreateContract);
    when(args.getFrom()).thenReturn("0x0000000000000000000000000000000000000000");

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.estimateGas(args));
    verify(args).getContractType(isA(Wallet.class));
    verify(args).getData();
    verify(args).getFrom();
    verify(args).parseValue();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getTransactionByHash(String)}
   */
  @Test
  public void testGetTransactionByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTransactionByHash("42"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockHashAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockHashAndIndex() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockHashAndIndex("Block Hash", "Index"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockNumberAndIndex("Block Num Or Tag", "Index"));
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex2() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(null);

    // Act
    TransactionResult actualTransactionByBlockNumberAndIndex = tronJsonRpcImpl
        .getTransactionByBlockNumberAndIndex("Block Num Or Tag", "Index");

    // Assert
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
    assertNull(actualTransactionByBlockNumberAndIndex);
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex3() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockNumberAndIndex("Block Num Or Tag", "0x"));
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex4() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockNumberAndIndex("Block Num Or Tag", null));
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex5() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenThrow(new JsonRpcInvalidParamsException());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockNumberAndIndex("Block Num Or Tag", "Index"));
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getTransactionByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetTransactionByBlockNumberAndIndex6() throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getByJsonBlockId(Mockito.<String>any())).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    TransactionResult actualTransactionByBlockNumberAndIndex = tronJsonRpcImpl
        .getTransactionByBlockNumberAndIndex("Block Num Or Tag", "0x0");

    // Assert
    verify(wallet).getByJsonBlockId(eq("Block Num Or Tag"));
    assertNull(actualTransactionByBlockNumberAndIndex);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getTransactionReceipt(String)}
   */
  @Test
  public void testGetTransactionReceipt() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTransactionReceipt("42"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  public void testGetCall()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), "Block Param Obj"));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(mock(CallArguments.class), TronJsonRpcImpl.EARLIEST_STR));
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(mock(CallArguments.class), TronJsonRpcImpl.PENDING_STR));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getPeerCount()}
   */
  @Test
  public void testGetPeerCount() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    String actualPeerCount = tronJsonRpcImpl.getPeerCount();

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals("0x0", actualPeerCount);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getSyncingStatus()}
   */
  @Test
  public void testGetSyncingStatus() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    tronJsonRpcImpl.getSyncingStatus();

    // Assert
    verify(nodeInfoService).getNodeInfo();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getSyncingStatus()}
   */
  @Test
  public void testGetSyncingStatus2() {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(1L);
    peerInfo.setDisconnectTimes(1);
    peerInfo.setHeadBlockTimeWeBothHave(1L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(1L);
    peerInfo.setLastBlockUpdateTime(1L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(1L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(1L);

    ArrayList<PeerInfo> peerList = new ArrayList<>();
    peerList.add(peerInfo);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setPeerList(peerList);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    Object actualSyncingStatus = tronJsonRpcImpl.getSyncingStatus();

    // Assert
    verify(wallet).getNowBlock();
    verify(nodeInfoService, atLeast(1)).getNodeInfo();
    assertTrue(actualSyncingStatus instanceof TronJsonRpc.SyncingResult);
    assertEquals("0x0", ((TronJsonRpc.SyncingResult) actualSyncingStatus).getCurrentBlock());
    assertEquals("0x0", ((TronJsonRpc.SyncingResult) actualSyncingStatus).getStartingBlock());
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getUncleByBlockHashAndIndex(String, String)}
   */
  @Test
  public void testGetUncleByBlockHashAndIndex() {
    // Arrange, Act and Assert
    assertNull(tronJsonRpcImpl.getUncleByBlockHashAndIndex("Block Hash", "Index"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getUncleByBlockNumberAndIndex(String, String)}
   */
  @Test
  public void testGetUncleByBlockNumberAndIndex() {
    // Arrange, Act and Assert
    assertNull(tronJsonRpcImpl.getUncleByBlockNumberAndIndex("Block Num Or Tag", "Index"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getUncleCountByBlockHash(String)}
   */
  @Test
  public void testGetUncleCountByBlockHash() {
    // Arrange, Act and Assert
    assertEquals("0x0", tronJsonRpcImpl.getUncleCountByBlockHash("Block Hash"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getUncleCountByBlockNumber(String)}
   */
  @Test
  public void testGetUncleCountByBlockNumber() {
    // Arrange, Act and Assert
    assertEquals("0x0", tronJsonRpcImpl.getUncleCountByBlockNumber("Block Num Or Tag"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethGetWork()}
   */
  @Test
  public void testEthGetWork() {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    List<Object> actualEthGetWorkResult = tronJsonRpcImpl.ethGetWork();

    // Assert
    verify(wallet).getNowBlock();
    assertEquals(3, actualEthGetWorkResult.size());
    assertEquals("0x00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", actualEthGetWorkResult.get(0));
    assertNull(actualEthGetWorkResult.get(1));
    assertNull(actualEthGetWorkResult.get(2));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethGetWork()}
   */
  @Test
  public void testEthGetWork2() {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(null);

    // Act
    List<Object> actualEthGetWorkResult = tronJsonRpcImpl.ethGetWork();

    // Assert
    verify(wallet).getNowBlock();
    assertEquals(3, actualEthGetWorkResult.size());
    assertNull(actualEthGetWorkResult.get(0));
    assertNull(actualEthGetWorkResult.get(1));
    assertNull(actualEthGetWorkResult.get(2));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#isMining()}
   */
  @Test
  public void testIsMining() {
    // Arrange
    when(wallet.isMining()).thenReturn(true);

    // Act
    boolean actualIsMiningResult = tronJsonRpcImpl.isMining();

    // Assert
    verify(wallet).isMining();
    assertTrue(actualIsMiningResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#isMining()}
   */
  @Test
  public void testIsMining2() {
    // Arrange
    when(wallet.isMining()).thenReturn(false);

    // Act
    boolean actualIsMiningResult = tronJsonRpcImpl.isMining();

    // Assert
    verify(wallet).isMining();
    assertFalse(actualIsMiningResult);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getAccounts()}
   */
  @Test
  public void testGetAccounts() {
    // Arrange, Act and Assert
    assertEquals(0, tronJsonRpcImpl.getAccounts().length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  public void testGetSource() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act
    TronJsonRpcImpl.RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(TronJsonRpcImpl.RequestSource.FULLNODE, actualSource);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  public void testGetSource2() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act
    TronJsonRpcImpl.RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(TronJsonRpcImpl.RequestSource.SOLIDITY, actualSource);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  public void testGetSource3() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act
    TronJsonRpcImpl.RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(TronJsonRpcImpl.RequestSource.PBFT, actualSource);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  public void testDisableInPBFT() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act
    tronJsonRpcImpl.disableInPBFT("Method");

    // Assert that nothing has changed
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  public void testDisableInPBFT2() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act
    tronJsonRpcImpl.disableInPBFT("Method");

    // Assert that nothing has changed
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  public void testDisableInPBFT3() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.disableInPBFT("Method"));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction2() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction3() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction4() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class,
        () -> tronJsonRpcImpl.buildTransaction(new BuildArguments(
            new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "invalid address hash value",
                "invalid address hash value", "42", "invalid address hash value", "invalid address hash value"))));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction5() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction6() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("0x");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction7() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("foo");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  public void testBuildTransaction8() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("42");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#ethSubmitWork(String, String, String)}
   */
  @Test
  public void testEthSubmitWork() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSubmitWork("Nonce Hex", "Header Hex", "Digest Hex"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethSendRawTransaction(String)}
   */
  @Test
  public void testEthSendRawTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSendRawTransaction("Raw Data"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethSendTransaction(CallArguments)}
   */
  @Test
  public void testEthSendTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSendTransaction(new CallArguments("jane.doe@example.org", "alice.liddell@example.org",
            "Gas", "Gas Price", "42", "Data", "Nonce")));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethSign(String, String)}
   */
  @Test
  public void testEthSign() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSign("42 Main St", "Msg"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethSignTransaction(CallArguments)}
   */
  @Test
  public void testEthSignTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSignTransaction(new CallArguments("jane.doe@example.org", "alice.liddell@example.org",
            "Gas", "Gas Price", "42", "Data", "Nonce")));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#parityNextNonce(String)}
   */
  @Test
  public void testParityNextNonce() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.parityNextNonce("42 Main St"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#getSendTransactionCountOfAddress(String, String)}
   */
  @Test
  public void testGetSendTransactionCountOfAddress() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.getSendTransactionCountOfAddress("42 Main St", "Block Num Or Tag"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getCompilers()}
   */
  @Test
  public void testGetCompilers() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getCompilers());
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethCompileSolidity(String)}
   */
  @Test
  public void testEthCompileSolidity() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileSolidity("Contract"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethCompileLLL(String)}
   */
  @Test
  public void testEthCompileLLL() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileLLL("Contract"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethCompileSerpent(String)}
   */
  @Test
  public void testEthCompileSerpent() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileSerpent("Contract"));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#ethSubmitHashrate(String, String)}
   */
  @Test
  public void testEthSubmitHashrate() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSubmitHashrate("Hashrate", "42"));
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#newFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testNewFilter() throws JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act
    tronJsonRpcImpl.newFilter(new TronJsonRpc.FilterRequest());

    // Assert
    verify(wallet, atLeast(1)).getCursor();
    verify(wallet).getNowBlock();
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#newFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testNewFilter2() throws JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act
    tronJsonRpcImpl.newFilter(new TronJsonRpc.FilterRequest());

    // Assert
    verify(wallet, atLeast(1)).getCursor();
    verify(wallet).getNowBlock();
  }

  /**
   * Method under test:
   * {@link TronJsonRpcImpl#newFilter(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testNewFilter3() throws JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.newFilter(new TronJsonRpc.FilterRequest()));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  public void testNewBlockFilter() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act
    tronJsonRpcImpl.newBlockFilter();

    // Assert
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  public void testNewBlockFilter2() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act
    tronJsonRpcImpl.newBlockFilter();

    // Assert
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  public void testNewBlockFilter3() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.newBlockFilter());
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  public void testUninstallFilter() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  public void testUninstallFilter2() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  public void testUninstallFilter3() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  public void testUninstallFilter4() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("eth_uninstallFilter"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  public void testUninstallFilter5() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  public void testGetFilterChanges() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  public void testGetFilterChanges2() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  public void testGetFilterChanges3() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  public void testGetFilterChanges4() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  public void testGetFilterChanges5() throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("Filter Id"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLogs(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testGetLogs() throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    TransactionRetStore transactionRetStore = mock(TransactionRetStore.class);
    when(transactionRetStore.getTransactionInfoByBlockNum(Mockito.<byte[]>any())).thenReturn(null);
    when(manager.getTransactionRetStore()).thenReturn(transactionRetStore);
    when(manager.getChainBaseManager()).thenReturn(new ChainBaseManager());

    // Act
    TronJsonRpc.LogFilterElement[] actualLogs = tronJsonRpcImpl.getLogs(new TronJsonRpc.FilterRequest());

    // Assert
    verify(wallet).getCursor();
    verify(wallet).getNowBlock();
    verify(manager).getChainBaseManager();
    verify(manager).getTransactionRetStore();
    verify(transactionRetStore).getTransactionInfoByBlockNum(isA(byte[].class));
    assertEquals(0, actualLogs.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLogs(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testGetLogs2() throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenReturn(new BlockCapsule.BlockId());
    when(chainBaseManager.getSectionBloomStore()).thenReturn(null);
    TransactionRetCapsule transactionRetCapsule = mock(TransactionRetCapsule.class);
    when(transactionRetCapsule.getInstance()).thenReturn(Protocol.TransactionRet.getDefaultInstance());
    TransactionRetStore transactionRetStore = mock(TransactionRetStore.class);
    when(transactionRetStore.getTransactionInfoByBlockNum(Mockito.<byte[]>any())).thenReturn(transactionRetCapsule);
    when(manager.getTransactionRetStore()).thenReturn(transactionRetStore);
    when(manager.getChainBaseManager()).thenReturn(chainBaseManager);

    // Act
    TronJsonRpc.LogFilterElement[] actualLogs = tronJsonRpcImpl.getLogs(new TronJsonRpc.FilterRequest());

    // Assert
    verify(chainBaseManager).getBlockIdByNum(eq(0L));
    verify(chainBaseManager).getSectionBloomStore();
    verify(wallet).getCursor();
    verify(wallet).getNowBlock();
    verify(transactionRetCapsule).getInstance();
    verify(manager, atLeast(1)).getChainBaseManager();
    verify(manager).getTransactionRetStore();
    verify(transactionRetStore).getTransactionInfoByBlockNum(isA(byte[].class));
    assertEquals(0, actualLogs.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLogs(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testGetLogs3() throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getLogs(new TronJsonRpc.FilterRequest()));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLogs(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testGetLogs4() throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenReturn(new BlockCapsule.BlockId());
    when(chainBaseManager.getSectionBloomStore()).thenReturn(null);
    TransactionRetCapsule transactionRetCapsule = mock(TransactionRetCapsule.class);
    when(transactionRetCapsule.getInstance()).thenReturn(Protocol.TransactionRet.getDefaultInstance());
    TransactionRetStore transactionRetStore = mock(TransactionRetStore.class);
    when(transactionRetStore.getTransactionInfoByBlockNum(Mockito.<byte[]>any())).thenReturn(transactionRetCapsule);
    when(manager.getTransactionRetStore()).thenReturn(transactionRetStore);
    when(manager.getChainBaseManager()).thenReturn(chainBaseManager);

    // Act
    TronJsonRpc.LogFilterElement[] actualLogs = tronJsonRpcImpl.getLogs(new TronJsonRpc.FilterRequest());

    // Assert
    verify(chainBaseManager).getBlockIdByNum(eq(0L));
    verify(chainBaseManager).getSectionBloomStore();
    verify(wallet).getCursor();
    verify(wallet).getNowBlock();
    verify(transactionRetCapsule).getInstance();
    verify(manager, atLeast(1)).getChainBaseManager();
    verify(manager).getTransactionRetStore();
    verify(transactionRetStore).getTransactionInfoByBlockNum(isA(byte[].class));
    assertEquals(0, actualLogs.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getLogs(TronJsonRpc.FilterRequest)}
   */
  @Test
  public void testGetLogs5() throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcInvalidParamsException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getNowBlock()).thenReturn(Protocol.Block.getDefaultInstance());
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockIdByNum(anyLong())).thenReturn(mock(BlockCapsule.BlockId.class));
    when(chainBaseManager.getSectionBloomStore()).thenReturn(null);
    TransactionRetCapsule transactionRetCapsule = mock(TransactionRetCapsule.class);
    when(transactionRetCapsule.getInstance()).thenReturn(Protocol.TransactionRet.getDefaultInstance());
    TransactionRetStore transactionRetStore = mock(TransactionRetStore.class);
    when(transactionRetStore.getTransactionInfoByBlockNum(Mockito.<byte[]>any())).thenReturn(transactionRetCapsule);
    when(manager.getTransactionRetStore()).thenReturn(transactionRetStore);
    when(manager.getChainBaseManager()).thenReturn(chainBaseManager);

    // Act
    TronJsonRpc.LogFilterElement[] actualLogs = tronJsonRpcImpl.getLogs(new TronJsonRpc.FilterRequest());

    // Assert
    verify(chainBaseManager).getBlockIdByNum(eq(0L));
    verify(chainBaseManager).getSectionBloomStore();
    verify(wallet).getCursor();
    verify(wallet).getNowBlock();
    verify(transactionRetCapsule).getInstance();
    verify(manager, atLeast(1)).getChainBaseManager();
    verify(manager).getTransactionRetStore();
    verify(transactionRetStore).getTransactionInfoByBlockNum(isA(byte[].class));
    assertEquals(0, actualLogs.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  public void testGetFilterLogs() throws InterruptedException, ExecutionException, BadItemException,
      ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  public void testGetFilterLogs2() throws InterruptedException, ExecutionException, BadItemException,
      ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  public void testGetFilterLogs3() throws InterruptedException, ExecutionException, BadItemException,
      ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  public void testGetFilterLogs4() throws InterruptedException, ExecutionException, BadItemException,
      ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("eth_getFilterLogs"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  public void testGetFilterLogs5() throws InterruptedException, ExecutionException, BadItemException,
      ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Chainbase.Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  public void testGetFilterResult() throws ItemNotFoundException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();

    // Act and Assert
    assertThrows(ItemNotFoundException.class,
        () -> TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, new HashMap<>()));
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  public void testGetFilterResult2() throws ItemNotFoundException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();
    blockFilter2Result.put("42", new BlockFilterAndResult());

    // Act
    Object[] actualFilterResult = TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, new HashMap<>());

    // Assert
    assertTrue(actualFilterResult instanceof String[]);
    assertEquals(0, actualFilterResult.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  public void testGetFilterResult3() throws ItemNotFoundException, JsonRpcInvalidParamsException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();

    HashMap<String, LogFilterAndResult> eventFilter2Result = new HashMap<>();
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    eventFilter2Result.put("42", new LogFilterAndResult(fr, 1L, wallet));

    // Act
    Object[] actualFilterResult = TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, eventFilter2Result);

    // Assert
    assertTrue(actualFilterResult instanceof TronJsonRpc.LogFilterElement[]);
    assertEquals(0, actualFilterResult.length);
  }

  /**
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  public void testGetFilterResult4() throws ItemNotFoundException, JsonRpcInvalidParamsException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();
    blockFilter2Result.computeIfPresent("filter not found", mock(BiFunction.class));

    HashMap<String, LogFilterAndResult> eventFilter2Result = new HashMap<>();
    TronJsonRpc.FilterRequest fr = new TronJsonRpc.FilterRequest();
    eventFilter2Result.put("42", new LogFilterAndResult(fr, 1L, wallet));
    TronJsonRpc.FilterRequest fr2 = new TronJsonRpc.FilterRequest();
    eventFilter2Result.put("foo", new LogFilterAndResult(fr2, 1L, wallet));

    // Act
    Object[] actualFilterResult = TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, eventFilter2Result);

    // Assert
    assertTrue(actualFilterResult instanceof TronJsonRpc.LogFilterElement[]);
    assertEquals(0, actualFilterResult.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronJsonRpcImpl#getBlockFilter2ResultFull()}
   *   <li>{@link TronJsonRpcImpl#getBlockFilter2ResultSolidity()}
   *   <li>{@link TronJsonRpcImpl#getEventFilter2ResultFull()}
   *   <li>{@link TronJsonRpcImpl#getEventFilter2ResultSolidity()}
   *   <li>{@link TronJsonRpcImpl#getHashRate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NodeInfoService nodeInfoService = new NodeInfoService();
    Wallet wallet = new Wallet();
    TronJsonRpcImpl tronJsonRpcImpl = new TronJsonRpcImpl(nodeInfoService, wallet, new Manager());

    // Act
    Map<String, BlockFilterAndResult> actualBlockFilter2ResultFull = tronJsonRpcImpl.getBlockFilter2ResultFull();
    Map<String, BlockFilterAndResult> actualBlockFilter2ResultSolidity = tronJsonRpcImpl
        .getBlockFilter2ResultSolidity();
    Map<String, LogFilterAndResult> actualEventFilter2ResultFull = tronJsonRpcImpl.getEventFilter2ResultFull();
    Map<String, LogFilterAndResult> actualEventFilter2ResultSolidity = tronJsonRpcImpl.getEventFilter2ResultSolidity();

    // Assert
    assertEquals("0x0", tronJsonRpcImpl.getHashRate());
    assertTrue(actualBlockFilter2ResultFull.isEmpty());
    assertTrue(actualBlockFilter2ResultSolidity.isEmpty());
    assertTrue(actualEventFilter2ResultFull.isEmpty());
    assertTrue(actualEventFilter2ResultSolidity.isEmpty());
  }
}
