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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.cedarsoftware.util.io.JsonObject;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.entity.NodeInfo;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.Wallet;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.Manager;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db2.core.Chainbase.Cursor;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.JsonRpcInternalException;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;
import org.tron.core.exception.JsonRpcMethodNotFoundException;
import org.tron.core.exception.JsonRpcTooManyResultException;
import org.tron.core.services.NodeInfoService;
import org.tron.core.services.jsonrpc.TronJsonRpc.FilterRequest;
import org.tron.core.services.jsonrpc.TronJsonRpc.LogFilterElement;
import org.tron.core.services.jsonrpc.TronJsonRpcImpl.RequestSource;
import org.tron.core.services.jsonrpc.filters.BlockFilterAndResult;
import org.tron.core.services.jsonrpc.filters.LogFilterAndResult;
import org.tron.core.services.jsonrpc.types.BuildArguments;
import org.tron.core.services.jsonrpc.types.CallArguments;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TronJsonRpcImplDiffblueTest {
  @InjectMocks
  private TronJsonRpcImpl tronJsonRpcImpl;

  @Mock
  private Wallet wallet;

  @Mock
  private NodeInfoService nodeInfoService;

  /**
   * Test {@link TronJsonRpcImpl#web3ClientVersion()}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#web3ClientVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.web3ClientVersion()"})
  public void testWeb3ClientVersion() {
    // Arrange, Act and Assert
    assertEquals("TRON/v4.7.7/Linux/Java1.8", tronJsonRpcImpl.web3ClientVersion());
  }

  /**
   * Test {@link TronJsonRpcImpl#web3Sha3(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#web3Sha3(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.web3Sha3(String)"})
  public void testWeb3Sha3() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals("0xc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a470", tronJsonRpcImpl.web3Sha3("0x"));
  }

  /**
   * Test {@link TronJsonRpcImpl#web3Sha3(String)}.
   * <ul>
   *   <li>When {@code Data}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#web3Sha3(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.web3Sha3(String)"})
  public void testWeb3Sha3_whenData_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.web3Sha3("Data"));
  }

  /**
   * Test {@link TronJsonRpcImpl#web3Sha3(String)}.
   * <ul>
   *   <li>When {@code invalid input value}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#web3Sha3(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.web3Sha3(String)"})
  public void testWeb3Sha3_whenInvalidInputValue_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.web3Sha3("invalid input value"));
  }

  /**
   * Test {@link TronJsonRpcImpl#web3Sha3(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#web3Sha3(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.web3Sha3(String)"})
  public void testWeb3Sha32() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals("0x1f675bff07515f5df96737194ea945c36c41e7b4fcef307b7cd4d0e602a69111", tronJsonRpcImpl.web3Sha3("42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethGetBlockTransactionCountByHash(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethGetBlockTransactionCountByHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethGetBlockTransactionCountByHash(String)"})
  public void testEthGetBlockTransactionCountByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.ethGetBlockTransactionCountByHash("Block Hash"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}.
   * <ul>
   *   <li>Then return {@code 0x0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethGetBlockTransactionCountByNumber(String)"})
  public void testEthGetBlockTransactionCountByNumber_thenReturn0x0() throws JsonRpcInvalidParamsException {
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
   * Test {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}.
   * <ul>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethGetBlockTransactionCountByNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethGetBlockTransactionCountByNumber(String)"})
  public void testEthGetBlockTransactionCountByNumber_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange
    when(wallet.getTransactionsByJsonBlockId(Mockito.<String>any())).thenThrow(new JsonRpcInvalidParamsException());

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.ethGetBlockTransactionCountByNumber("Block Num Or Tag"));
    verify(wallet).getTransactionsByJsonBlockId(eq("Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethGetBlockByHash(String, Boolean)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethGetBlockByHash(String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.BlockResult TronJsonRpcImpl.ethGetBlockByHash(String, Boolean)"})
  public void testEthGetBlockByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.ethGetBlockByHash("Block Hash", true));
  }

  /**
   * Test {@link TronJsonRpcImpl#getNetVersion()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code 0x00000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getNetVersion()"})
  public void testGetNetVersion_givenBlockCapsuleGetBlockIdReturnBlockId_thenReturn0x00000000()
      throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualNetVersion = tronJsonRpcImpl.getNetVersion();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x00000000", actualNetVersion);
  }

  /**
   * Test {@link TronJsonRpcImpl#getNetVersion()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getNetVersion()"})
  public void testGetNetVersion_givenBlockCapsuleGetBlockIdReturnNull() throws JsonRpcInternalException {
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
   * Test {@link TronJsonRpcImpl#getNetVersion()}.
   * <ul>
   *   <li>Given {@link BlockId} {@link Sha256Hash#getBytes()} return empty array of {@code byte}.</li>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getNetVersion()"})
  public void testGetNetVersion_givenBlockIdGetBytesReturnEmptyArrayOfByte_thenCallsGetBytes()
      throws JsonRpcInternalException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
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
   * Test {@link TronJsonRpcImpl#getNetVersion()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlockCapsuleByNum(long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getNetVersion()"})
  public void testGetNetVersion_givenWalletGetBlockCapsuleByNumReturnNull() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getNetVersion());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
  }

  /**
   * Test {@link TronJsonRpcImpl#getNetVersion()}.
   * <ul>
   *   <li>Then return {@code 0x41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getNetVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getNetVersion()"})
  public void testGetNetVersion_thenReturn0x41584158() throws UnsupportedEncodingException, JsonRpcInternalException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
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
   * Test {@link TronJsonRpcImpl#ethChainId()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@link BlockId#BlockId()}.</li>
   *   <li>Then return {@code 0x00000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethChainId()"})
  public void testEthChainId_givenBlockCapsuleGetBlockIdReturnBlockId_thenReturn0x00000000()
      throws JsonRpcInternalException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(blockCapsule);

    // Act
    String actualEthChainIdResult = tronJsonRpcImpl.ethChainId();

    // Assert
    verify(wallet).getBlockCapsuleByNum(eq(0L));
    verify(blockCapsule).getBlockId();
    assertEquals("0x00000000", actualEthChainIdResult);
  }

  /**
   * Test {@link TronJsonRpcImpl#ethChainId()}.
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getBlockId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethChainId()"})
  public void testEthChainId_givenBlockCapsuleGetBlockIdReturnNull() throws JsonRpcInternalException {
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
   * Test {@link TronJsonRpcImpl#ethChainId()}.
   * <ul>
   *   <li>Given {@link BlockId} {@link Sha256Hash#getBytes()} return empty array of {@code byte}.</li>
   *   <li>Then calls {@link Sha256Hash#getBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethChainId()"})
  public void testEthChainId_givenBlockIdGetBytesReturnEmptyArrayOfByte_thenCallsGetBytes()
      throws JsonRpcInternalException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
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
   * Test {@link TronJsonRpcImpl#ethChainId()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlockCapsuleByNum(long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethChainId()"})
  public void testEthChainId_givenWalletGetBlockCapsuleByNumReturnNull() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getBlockCapsuleByNum(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.ethChainId());
    verify(wallet).getBlockCapsuleByNum(eq(0L));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethChainId()}.
   * <ul>
   *   <li>Then return {@code 0x41584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethChainId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethChainId()"})
  public void testEthChainId_thenReturn0x41584158() throws UnsupportedEncodingException, JsonRpcInternalException {
    // Arrange
    BlockId blockId = mock(BlockId.class);
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
   * Test {@link TronJsonRpcImpl#isListening()}.
   * <ul>
   *   <li>Given {@link NodeInfo} {@link NodeInfo#getActiveConnectCount()} return three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#isListening()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.isListening()"})
  public void testIsListening_givenNodeInfoGetActiveConnectCountReturnThree_thenReturnTrue() {
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
   * Test {@link TronJsonRpcImpl#isListening()}.
   * <ul>
   *   <li>Given {@link NodeInfoService} {@link NodeInfoService#getNodeInfo()} return {@link NodeInfo} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#isListening()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.isListening()"})
  public void testIsListening_givenNodeInfoServiceGetNodeInfoReturnNodeInfo_thenReturnFalse() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    boolean actualIsListeningResult = tronJsonRpcImpl.isListening();

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertFalse(actualIsListeningResult);
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_when0x0_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "0x0"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_when42_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@code Block Num Or Tag}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_whenBlockNumOrTag_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", "Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#EARLIEST_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_whenEarliest_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", TronJsonRpcImpl.EARLIEST_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_whenNull_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTrxBalance(null, "0x"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTrxBalance(String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#PENDING_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTrxBalance(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getTrxBalance(String, String)"})
  public void testGetTrxBalance_whenPending_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTrxBalance("42 Main St", TronJsonRpcImpl.PENDING_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_when0x0_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "0x0"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_when42_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@code Block Num Or Tag}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_whenBlockNumOrTag_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", "Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#EARLIEST_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_whenEarliest_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", TronJsonRpcImpl.EARLIEST_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_whenNull_thenThrowJsonRpcInvalidParamsException() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getStorageAt(null, null, "0x"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getStorageAt(String, String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#PENDING_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getStorageAt(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getStorageAt(String, String, String)"})
  public void testGetStorageAt_whenPending_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getStorageAt("42 Main St", "Storage Idx", TronJsonRpcImpl.PENDING_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_when0x0_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "0x0"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_when42_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@code Block Num Or Tag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_whenBlockNumOrTag() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", "Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#EARLIEST_STR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_whenEarliest_str() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", TronJsonRpcImpl.EARLIEST_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_whenNull_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getABIOfSmartContract(null, "0x"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#PENDING_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getABIOfSmartContract(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getABIOfSmartContract(String, String)"})
  public void testGetABIOfSmartContract_whenPending_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getABIOfSmartContract("42 Main St", TronJsonRpcImpl.PENDING_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCoinbase()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCoinbase()} return {@code Coinbase}.</li>
   *   <li>Then return {@code Coinbase}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCoinbase()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCoinbase()"})
  public void testGetCoinbase_givenWalletGetCoinbaseReturnCoinbase_thenReturnCoinbase()
      throws JsonRpcInternalException {
    // Arrange
    when(wallet.getCoinbase()).thenReturn("Coinbase");

    // Act
    String actualCoinbase = tronJsonRpcImpl.getCoinbase();

    // Assert
    verify(wallet).getCoinbase();
    assertEquals("Coinbase", actualCoinbase);
  }

  /**
   * Test {@link TronJsonRpcImpl#getCoinbase()}.
   * <ul>
   *   <li>Then throw {@link JsonRpcInternalException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCoinbase()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCoinbase()"})
  public void testGetCoinbase_thenThrowJsonRpcInternalException() throws JsonRpcInternalException {
    // Arrange
    when(wallet.getCoinbase()).thenReturn("");

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.getCoinbase());
    verify(wallet).getCoinbase();
  }

  /**
   * Test {@link TronJsonRpcImpl#gasPrice()}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#gasPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.gasPrice()"})
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
   * Test {@link TronJsonRpcImpl#estimateGas(CallArguments)}.
   * <ul>
   *   <li>Given {@code AccountCreateContract}.</li>
   *   <li>Then throw {@link JsonRpcInternalException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#estimateGas(CallArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.estimateGas(CallArguments)"})
  public void testEstimateGas_givenAccountCreateContract_thenThrowJsonRpcInternalException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    NodeInfoService nodeInfoService = new NodeInfoService();
    Wallet wallet = new Wallet();
    TronJsonRpcImpl tronJsonRpcImpl = new TronJsonRpcImpl(nodeInfoService, wallet, new Manager());
    CallArguments args = mock(CallArguments.class);
    when(args.getData()).thenReturn("Data");
    when(args.parseValue()).thenReturn(42L);
    when(args.getContractType(Mockito.<Wallet>any())).thenReturn(ContractType.AccountCreateContract);
    when(args.getFrom()).thenReturn("0x0000000000000000000000000000000000000000");

    // Act and Assert
    assertThrows(JsonRpcInternalException.class, () -> tronJsonRpcImpl.estimateGas(args));
    verify(args).getContractType(isA(Wallet.class));
    verify(args).getData();
    verify(args).getFrom();
    verify(args).parseValue();
  }

  /**
   * Test {@link TronJsonRpcImpl#getTransactionByHash(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTransactionByHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.TransactionResult TronJsonRpcImpl.getTransactionByHash(String)"})
  public void testGetTransactionByHash() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTransactionByHash("42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTransactionByBlockHashAndIndex(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTransactionByBlockHashAndIndex(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.TransactionResult TronJsonRpcImpl.getTransactionByBlockHashAndIndex(String, String)"})
  public void testGetTransactionByBlockHashAndIndex() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getTransactionByBlockHashAndIndex("Block Hash", "Index"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getTransactionReceipt(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getTransactionReceipt(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.TransactionReceipt TronJsonRpcImpl.getTransactionReceipt(String)"})
  public void testGetTransactionReceipt() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getTransactionReceipt("42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>Given {@link ClassCastException#ClassCastException(String)} with {@code blockNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_givenClassCastExceptionWithBlockNumber()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments transactionCall = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");

    JsonObject<Object, Object> objectObjectMap = mock(JsonObject.class);
    when(objectObjectMap.get(Mockito.<Object>any())).thenThrow(new ClassCastException("blockNumber"));
    when(objectObjectMap.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getCall(transactionCall, objectObjectMap));
    verify(objectObjectMap).containsKey(isA(Object.class));
    verify(objectObjectMap).get(isA(Object.class));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>Given {@code Get}.</li>
   *   <li>When {@link JsonObject} {@link LinkedHashMap#get(Object)} return {@code Get}.</li>
   *   <li>Then calls {@link HashMap#containsKey(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_givenGet_whenJsonObjectGetReturnGet_thenCallsContainsKey()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments transactionCall = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");

    JsonObject<Object, Object> objectObjectMap = mock(JsonObject.class);
    when(objectObjectMap.get(Mockito.<Object>any())).thenReturn("Get");
    when(objectObjectMap.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getCall(transactionCall, objectObjectMap));
    verify(objectObjectMap).containsKey(isA(Object.class));
    verify(objectObjectMap).get(isA(Object.class));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link JsonObject} {@link LinkedHashMap#get(Object)} return {@code null}.</li>
   *   <li>Then calls {@link HashMap#containsKey(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_givenNull_whenJsonObjectGetReturnNull_thenCallsContainsKey()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments transactionCall = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");

    JsonObject<Object, Object> objectObjectMap = mock(JsonObject.class);
    when(objectObjectMap.get(Mockito.<Object>any())).thenReturn(null);
    when(objectObjectMap.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getCall(transactionCall, objectObjectMap));
    verify(objectObjectMap).containsKey(isA(Object.class));
    verify(objectObjectMap).get(isA(Object.class));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JsonObject} {@link LinkedHashMap#get(Object)} return one.</li>
   *   <li>Then calls {@link HashMap#containsKey(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_givenOne_whenJsonObjectGetReturnOne_thenCallsContainsKey()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments transactionCall = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");

    JsonObject<Object, Object> objectObjectMap = mock(JsonObject.class);
    when(objectObjectMap.get(Mockito.<Object>any())).thenReturn(1);
    when(objectObjectMap.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class, () -> tronJsonRpcImpl.getCall(transactionCall, objectObjectMap));
    verify(objectObjectMap).containsKey(isA(Object.class));
    verify(objectObjectMap).get(isA(Object.class));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@code 0x0}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_when0x0_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), "0x0"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_when0x_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), "0x"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_when42_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), "42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@code Block Param Obj}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_whenBlockParamObj_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), "Block Param Obj"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#EARLIEST_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_whenEarliest_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), TronJsonRpcImpl.EARLIEST_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_whenHashMap_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments transactionCall = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.getCall(transactionCall, new HashMap<>()));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_whenOne_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), 1));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCall(CallArguments, Object)}.
   * <ul>
   *   <li>When {@link TronJsonRpcImpl#PENDING_STR}.</li>
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCall(CallArguments, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getCall(CallArguments, Object)"})
  public void testGetCall_whenPending_str_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidParamsException.class,
        () -> tronJsonRpcImpl.getCall(new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
            "Gas Price", "42", "Data", "Nonce"), TronJsonRpcImpl.PENDING_STR));
  }

  /**
   * Test {@link TronJsonRpcImpl#getPeerCount()}.
   * <ul>
   *   <li>Given {@link NodeInfoService} {@link NodeInfoService#getNodeInfo()} return {@link NodeInfo} (default constructor).</li>
   *   <li>Then return {@code 0x0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getPeerCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getPeerCount()"})
  public void testGetPeerCount_givenNodeInfoServiceGetNodeInfoReturnNodeInfo_thenReturn0x0() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    String actualPeerCount = tronJsonRpcImpl.getPeerCount();

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals("0x0", actualPeerCount);
  }

  /**
   * Test {@link TronJsonRpcImpl#getSyncingStatus()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getSyncingStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object TronJsonRpcImpl.getSyncingStatus()"})
  public void testGetSyncingStatus_thenReturnFalse() {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());

    // Act
    Object actualSyncingStatus = tronJsonRpcImpl.getSyncingStatus();

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertFalse((Boolean) actualSyncingStatus);
  }

  /**
   * Test {@link TronJsonRpcImpl#getUncleByBlockHashAndIndex(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getUncleByBlockHashAndIndex(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.BlockResult TronJsonRpcImpl.getUncleByBlockHashAndIndex(String, String)"})
  public void testGetUncleByBlockHashAndIndex() {
    // Arrange, Act and Assert
    assertNull(tronJsonRpcImpl.getUncleByBlockHashAndIndex("Block Hash", "Index"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getUncleByBlockNumberAndIndex(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getUncleByBlockNumberAndIndex(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.tron.core.services.jsonrpc.types.BlockResult TronJsonRpcImpl.getUncleByBlockNumberAndIndex(String, String)"})
  public void testGetUncleByBlockNumberAndIndex() {
    // Arrange, Act and Assert
    assertNull(tronJsonRpcImpl.getUncleByBlockNumberAndIndex("Block Num Or Tag", "Index"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getUncleCountByBlockHash(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getUncleCountByBlockHash(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getUncleCountByBlockHash(String)"})
  public void testGetUncleCountByBlockHash() {
    // Arrange, Act and Assert
    assertEquals("0x0", tronJsonRpcImpl.getUncleCountByBlockHash("Block Hash"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getUncleCountByBlockNumber(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getUncleCountByBlockNumber(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getUncleCountByBlockNumber(String)"})
  public void testGetUncleCountByBlockNumber() {
    // Arrange, Act and Assert
    assertEquals("0x0", tronJsonRpcImpl.getUncleCountByBlockNumber("Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#isMining()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#isMining()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#isMining()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.isMining()"})
  public void testIsMining_givenWalletIsMiningReturnFalse_thenReturnFalse() {
    // Arrange
    when(wallet.isMining()).thenReturn(false);

    // Act
    boolean actualIsMiningResult = tronJsonRpcImpl.isMining();

    // Assert
    verify(wallet).isMining();
    assertFalse(actualIsMiningResult);
  }

  /**
   * Test {@link TronJsonRpcImpl#isMining()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#isMining()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#isMining()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.isMining()"})
  public void testIsMining_givenWalletIsMiningReturnTrue_thenReturnTrue() {
    // Arrange
    when(wallet.isMining()).thenReturn(true);

    // Act
    boolean actualIsMiningResult = tronJsonRpcImpl.isMining();

    // Assert
    verify(wallet).isMining();
    assertTrue(actualIsMiningResult);
  }

  /**
   * Test {@link TronJsonRpcImpl#getAccounts()}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getAccounts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] TronJsonRpcImpl.getAccounts()"})
  public void testGetAccounts() {
    // Arrange, Act and Assert
    assertEquals(0, tronJsonRpcImpl.getAccounts().length);
  }

  /**
   * Test {@link TronJsonRpcImpl#getSource()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>Then return {@code FULLNODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RequestSource TronJsonRpcImpl.getSource()"})
  public void testGetSource_givenWalletGetCursorReturnHead_thenReturnFullnode() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act
    RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(RequestSource.FULLNODE, actualSource);
  }

  /**
   * Test {@link TronJsonRpcImpl#getSource()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code PBFT}.</li>
   *   <li>Then return {@code PBFT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RequestSource TronJsonRpcImpl.getSource()"})
  public void testGetSource_givenWalletGetCursorReturnPbft_thenReturnPbft() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act
    RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(RequestSource.PBFT, actualSource);
  }

  /**
   * Test {@link TronJsonRpcImpl#getSource()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   *   <li>Then return {@code SOLIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getSource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RequestSource TronJsonRpcImpl.getSource()"})
  public void testGetSource_givenWalletGetCursorReturnSolidity_thenReturnSolidity() {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act
    RequestSource actualSource = tronJsonRpcImpl.getSource();

    // Assert
    verify(wallet).getCursor();
    assertEquals(RequestSource.SOLIDITY, actualSource);
  }

  /**
   * Test {@link TronJsonRpcImpl#disableInPBFT(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronJsonRpcImpl.disableInPBFT(String)"})
  public void testDisableInPBFT_givenWalletGetCursorReturnHead() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act
    tronJsonRpcImpl.disableInPBFT("Method");

    // Assert
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#disableInPBFT(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronJsonRpcImpl.disableInPBFT(String)"})
  public void testDisableInPBFT_givenWalletGetCursorReturnSolidity() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act
    tronJsonRpcImpl.disableInPBFT("Method");

    // Assert
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#disableInPBFT(String)}.
   * <ul>
   *   <li>Then throw {@link JsonRpcMethodNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#disableInPBFT(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronJsonRpcImpl.disableInPBFT(String)"})
  public void testDisableInPBFT_thenThrowJsonRpcMethodNotFoundException() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.disableInPBFT("Method"));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction() throws JsonRpcInternalException, JsonRpcInvalidParamsException,
      JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class,
        () -> tronJsonRpcImpl.buildTransaction(new BuildArguments(
            new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "invalid address hash value",
                "invalid address hash value", "42", "invalid address hash value", "invalid address hash value"))));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@code 0x}.</li>
   *   <li>When {@link BuildArguments} {@link BuildArguments#getFrom()} return {@code 0x}.</li>
   *   <li>Then calls {@link BuildArguments#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_given0x_whenBuildArgumentsGetFromReturn0x_thenCallsGetFrom()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException,
      JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("0x");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link BuildArguments} {@link BuildArguments#getFrom()} return {@code 42}.</li>
   *   <li>Then calls {@link BuildArguments#getFrom()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_given42_whenBuildArgumentsGetFromReturn42_thenCallsGetFrom()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException,
      JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("42");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link BuildArguments} {@link BuildArguments#getFrom()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_givenFoo_whenBuildArgumentsGetFromReturnFoo() throws JsonRpcInternalException,
      JsonRpcInvalidParamsException, JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("foo");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_givenJaneDoeExampleOrg() throws JsonRpcInternalException,
      JsonRpcInvalidParamsException, JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);
    BuildArguments args = mock(BuildArguments.class);
    when(args.getFrom()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(args));
    verify(wallet).getCursor();
    verify(args).getFrom();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code PBFT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_givenWalletGetCursorReturnPbft() throws JsonRpcInternalException,
      JsonRpcInvalidParamsException, JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_givenWalletGetCursorReturnSolidity() throws JsonRpcInternalException,
      JsonRpcInvalidParamsException, JsonRpcInvalidRequestException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}.
   * <ul>
   *   <li>When {@link BuildArguments#BuildArguments()}.</li>
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#buildTransaction(BuildArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.TransactionJson TronJsonRpcImpl.buildTransaction(BuildArguments)"})
  public void testBuildTransaction_whenBuildArguments_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInternalException, JsonRpcInvalidParamsException, JsonRpcInvalidRequestException,
      JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> tronJsonRpcImpl.buildTransaction(new BuildArguments()));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSubmitWork(String, String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSubmitWork(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.ethSubmitWork(String, String, String)"})
  public void testEthSubmitWork() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSubmitWork("Nonce Hex", "Header Hex", "Digest Hex"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSendRawTransaction(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSendRawTransaction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethSendRawTransaction(String)"})
  public void testEthSendRawTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSendRawTransaction("Raw Data"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSendTransaction(CallArguments)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSendTransaction(CallArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethSendTransaction(CallArguments)"})
  public void testEthSendTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSendTransaction(new CallArguments("jane.doe@example.org", "alice.liddell@example.org",
            "Gas", "Gas Price", "42", "Data", "Nonce")));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSign(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSign(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethSign(String, String)"})
  public void testEthSign() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSign("42 Main St", "Msg"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSignTransaction(CallArguments)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSignTransaction(CallArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.ethSignTransaction(CallArguments)"})
  public void testEthSignTransaction() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.ethSignTransaction(new CallArguments("jane.doe@example.org", "alice.liddell@example.org",
            "Gas", "Gas Price", "42", "Data", "Nonce")));
  }

  /**
   * Test {@link TronJsonRpcImpl#parityNextNonce(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#parityNextNonce(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.parityNextNonce(String)"})
  public void testParityNextNonce() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.parityNextNonce("42 Main St"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getSendTransactionCountOfAddress(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getSendTransactionCountOfAddress(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.getSendTransactionCountOfAddress(String, String)"})
  public void testGetSendTransactionCountOfAddress() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class,
        () -> tronJsonRpcImpl.getSendTransactionCountOfAddress("42 Main St", "Block Num Or Tag"));
  }

  /**
   * Test {@link TronJsonRpcImpl#getCompilers()}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getCompilers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] TronJsonRpcImpl.getCompilers()"})
  public void testGetCompilers() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getCompilers());
  }

  /**
   * Test {@link TronJsonRpcImpl#ethCompileSolidity(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethCompileSolidity(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.CompilationResult TronJsonRpcImpl.ethCompileSolidity(String)"})
  public void testEthCompileSolidity() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileSolidity("Contract"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethCompileLLL(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethCompileLLL(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.CompilationResult TronJsonRpcImpl.ethCompileLLL(String)"})
  public void testEthCompileLLL() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileLLL("Contract"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethCompileSerpent(String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethCompileSerpent(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.CompilationResult TronJsonRpcImpl.ethCompileSerpent(String)"})
  public void testEthCompileSerpent() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethCompileSerpent("Contract"));
  }

  /**
   * Test {@link TronJsonRpcImpl#ethSubmitHashrate(String, String)}.
   * <p>
   * Method under test: {@link TronJsonRpcImpl#ethSubmitHashrate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronJsonRpc.CompilationResult TronJsonRpcImpl.ethSubmitHashrate(String, String)"})
  public void testEthSubmitHashrate() throws JsonRpcMethodNotFoundException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.ethSubmitHashrate("Hashrate", "42"));
  }

  /**
   * Test {@link TronJsonRpcImpl#newBlockFilter()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.newBlockFilter()"})
  public void testNewBlockFilter_givenWalletGetCursorReturnHead() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act
    tronJsonRpcImpl.newBlockFilter();

    // Assert
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#newBlockFilter()}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.newBlockFilter()"})
  public void testNewBlockFilter_givenWalletGetCursorReturnSolidity() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act
    tronJsonRpcImpl.newBlockFilter();

    // Assert
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#newBlockFilter()}.
   * <ul>
   *   <li>Then throw {@link JsonRpcMethodNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#newBlockFilter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TronJsonRpcImpl.newBlockFilter()"})
  public void testNewBlockFilter_thenThrowJsonRpcMethodNotFoundException() throws JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.newBlockFilter());
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#uninstallFilter(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 0x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.uninstallFilter(String)"})
  public void testUninstallFilter_givenWalletGetCursorReturnHead_when0x()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#uninstallFilter(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.uninstallFilter(String)"})
  public void testUninstallFilter_givenWalletGetCursorReturnHead_when42()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#uninstallFilter(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code eth_uninstallFilter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.uninstallFilter(String)"})
  public void testUninstallFilter_givenWalletGetCursorReturnHead_whenEthUninstallFilter()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("eth_uninstallFilter"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#uninstallFilter(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.uninstallFilter(String)"})
  public void testUninstallFilter_givenWalletGetCursorReturnSolidity_when42()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#uninstallFilter(String)}.
   * <ul>
   *   <li>Then throw {@link JsonRpcMethodNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#uninstallFilter(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronJsonRpcImpl.uninstallFilter(String)"})
  public void testUninstallFilter_thenThrowJsonRpcMethodNotFoundException()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.uninstallFilter("42"));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterChanges(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 0x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterChanges(String)"})
  public void testGetFilterChanges_givenWalletGetCursorReturnHead_when0x()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterChanges(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterChanges(String)"})
  public void testGetFilterChanges_givenWalletGetCursorReturnHead_when42()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterChanges(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code Filter Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterChanges(String)"})
  public void testGetFilterChanges_givenWalletGetCursorReturnHead_whenFilterId()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("Filter Id"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterChanges(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterChanges(String)"})
  public void testGetFilterChanges_givenWalletGetCursorReturnSolidity_when42()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterChanges(String)}.
   * <ul>
   *   <li>Then throw {@link JsonRpcMethodNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterChanges(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterChanges(String)"})
  public void testGetFilterChanges_thenThrowJsonRpcMethodNotFoundException()
      throws ItemNotFoundException, JsonRpcMethodNotFoundException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getFilterChanges("42"));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterLogs(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 0x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] TronJsonRpcImpl.getFilterLogs(String)"})
  public void testGetFilterLogs_givenWalletGetCursorReturnHead_when0x() throws InterruptedException, ExecutionException,
      BadItemException, ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("0x"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterLogs(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] TronJsonRpcImpl.getFilterLogs(String)"})
  public void testGetFilterLogs_givenWalletGetCursorReturnHead_when42() throws InterruptedException, ExecutionException,
      BadItemException, ItemNotFoundException, JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterLogs(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code HEAD}.</li>
   *   <li>When {@code eth_getFilterLogs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] TronJsonRpcImpl.getFilterLogs(String)"})
  public void testGetFilterLogs_givenWalletGetCursorReturnHead_whenEthGetFilterLogs()
      throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.HEAD);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("eth_getFilterLogs"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterLogs(String)}.
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getCursor()} return {@code SOLIDITY}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] TronJsonRpcImpl.getFilterLogs(String)"})
  public void testGetFilterLogs_givenWalletGetCursorReturnSolidity_when42()
      throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.SOLIDITY);

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet, atLeast(1)).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterLogs(String)}.
   * <ul>
   *   <li>Then throw {@link JsonRpcMethodNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterLogs(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LogFilterElement[] TronJsonRpcImpl.getFilterLogs(String)"})
  public void testGetFilterLogs_thenThrowJsonRpcMethodNotFoundException()
      throws InterruptedException, ExecutionException, BadItemException, ItemNotFoundException,
      JsonRpcMethodNotFoundException, JsonRpcTooManyResultException {
    // Arrange
    when(wallet.getCursor()).thenReturn(Cursor.PBFT);

    // Act and Assert
    assertThrows(JsonRpcMethodNotFoundException.class, () -> tronJsonRpcImpl.getFilterLogs("42"));
    verify(wallet).getCursor();
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link BlockFilterAndResult} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterResult(String, Map, Map)"})
  public void testGetFilterResult_givenBlockFilterAndResult() throws ItemNotFoundException {
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
   * Test {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}.
   * <ul>
   *   <li>Then calls {@link BlockFilterAndResult#popAll()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterResult(String, Map, Map)"})
  public void testGetFilterResult_thenCallsPopAll() throws ItemNotFoundException {
    // Arrange
    BlockFilterAndResult blockFilterAndResult = mock(BlockFilterAndResult.class);
    when(blockFilterAndResult.popAll()).thenReturn(new ArrayList<>());
    doNothing().when(blockFilterAndResult).updateExpireTime();

    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();
    blockFilter2Result.put("42", blockFilterAndResult);

    // Act
    Object[] actualFilterResult = TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, new HashMap<>());

    // Assert
    verify(blockFilterAndResult).popAll();
    verify(blockFilterAndResult).updateExpireTime();
    assertTrue(actualFilterResult instanceof String[]);
    assertEquals(0, actualFilterResult.length);
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}.
   * <ul>
   *   <li>Then return {@code TronJsonRpc.LogFilterElement[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterResult(String, Map, Map)"})
  public void testGetFilterResult_thenReturnLogFilterElement()
      throws ItemNotFoundException, JsonRpcInvalidParamsException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();

    HashMap<String, LogFilterAndResult> eventFilter2Result = new HashMap<>();
    eventFilter2Result.put("42", new LogFilterAndResult(new FilterRequest(), 1L, wallet));

    // Act
    Object[] actualFilterResult = TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, eventFilter2Result);

    // Assert
    assertTrue(actualFilterResult instanceof LogFilterElement[]);
    assertEquals(0, actualFilterResult.length);
  }

  /**
   * Test {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronJsonRpcImpl#getFilterResult(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] TronJsonRpcImpl.getFilterResult(String, Map, Map)"})
  public void testGetFilterResult_whenHashMap_thenThrowItemNotFoundException() throws ItemNotFoundException {
    // Arrange
    HashMap<String, BlockFilterAndResult> blockFilter2Result = new HashMap<>();

    // Act and Assert
    assertThrows(ItemNotFoundException.class,
        () -> TronJsonRpcImpl.getFilterResult("42", blockFilter2Result, new HashMap<>()));
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map TronJsonRpcImpl.getBlockFilter2ResultFull()",
      "Map TronJsonRpcImpl.getBlockFilter2ResultSolidity()", "Map TronJsonRpcImpl.getEventFilter2ResultFull()",
      "Map TronJsonRpcImpl.getEventFilter2ResultSolidity()", "String TronJsonRpcImpl.getHashRate()"})
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
