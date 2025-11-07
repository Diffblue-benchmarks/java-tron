package org.tron.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.SmartContractOuterClass;

public class WalletSolidityGrpcDiffblueTest {
  /**
   * Method under test: {@link WalletSolidityGrpc#getGetAccountMethod()}
   */
  @Test
  public void testGetGetAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, Protocol.Account> actualGetAccountMethod = WalletSolidityGrpc
        .getGetAccountMethod();

    // Assert
    assertEquals("GetAccount", actualGetAccountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAccount", actualGetAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountMethod.getType());
    assertFalse(actualGetAccountMethod.isIdempotent());
    assertFalse(actualGetAccountMethod.isSafe());
    assertTrue(actualGetAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetAccountByIdMethod()}
   */
  @Test
  public void testGetGetAccountByIdMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, Protocol.Account> actualGetAccountByIdMethod = WalletSolidityGrpc
        .getGetAccountByIdMethod();

    // Assert
    assertEquals("GetAccountById", actualGetAccountByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAccountById", actualGetAccountByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountByIdMethod.getType());
    assertFalse(actualGetAccountByIdMethod.isIdempotent());
    assertFalse(actualGetAccountByIdMethod.isSafe());
    assertTrue(actualGetAccountByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAccountByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getListWitnessesMethod()}
   */
  @Test
  public void testGetListWitnessesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.WitnessList> actualListWitnessesMethod = WalletSolidityGrpc
        .getListWitnessesMethod();

    // Assert
    assertEquals("ListWitnesses", actualListWitnessesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ListWitnesses", actualListWitnessesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListWitnessesMethod.getType());
    assertFalse(actualListWitnessesMethod.isIdempotent());
    assertFalse(actualListWitnessesMethod.isSafe());
    assertTrue(actualListWitnessesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualListWitnessesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueListMethod()}
   */
  @Test
  public void testGetGetAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.AssetIssueList> actualGetAssetIssueListMethod = WalletSolidityGrpc
        .getGetAssetIssueListMethod();

    // Assert
    assertEquals("GetAssetIssueList", actualGetAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueList", actualGetAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueListMethod.getType());
    assertFalse(actualGetAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListMethod.isSafe());
    assertTrue(actualGetAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueListMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetPaginatedAssetIssueListMethod()}
   */
  @Test
  public void testGetGetPaginatedAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PaginatedMessage, GrpcAPI.AssetIssueList> actualGetPaginatedAssetIssueListMethod = WalletSolidityGrpc
        .getGetPaginatedAssetIssueListMethod();

    // Assert
    assertEquals("GetPaginatedAssetIssueList", actualGetPaginatedAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetPaginatedAssetIssueList",
        actualGetPaginatedAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetPaginatedAssetIssueListMethod.getType());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isSafe());
    assertTrue(actualGetPaginatedAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetPaginatedAssetIssueListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueByNameMethod()}
   */
  @Test
  public void testGetGetAssetIssueByNameMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, AssetIssueContractOuterClass.AssetIssueContract> actualGetAssetIssueByNameMethod = WalletSolidityGrpc
        .getGetAssetIssueByNameMethod();

    // Assert
    assertEquals("GetAssetIssueByName", actualGetAssetIssueByNameMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueByName", actualGetAssetIssueByNameMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueByNameMethod.getType());
    assertFalse(actualGetAssetIssueByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueByNameMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetAssetIssueListByNameMethod()}
   */
  @Test
  public void testGetGetAssetIssueListByNameMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.AssetIssueList> actualGetAssetIssueListByNameMethod = WalletSolidityGrpc
        .getGetAssetIssueListByNameMethod();

    // Assert
    assertEquals("GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueListByName",
        actualGetAssetIssueListByNameMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueListByNameMethod.getType());
    assertFalse(actualGetAssetIssueListByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueListByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueListByNameMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueByIdMethod()}
   */
  @Test
  public void testGetGetAssetIssueByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, AssetIssueContractOuterClass.AssetIssueContract> actualGetAssetIssueByIdMethod = WalletSolidityGrpc
        .getGetAssetIssueByIdMethod();

    // Assert
    assertEquals("GetAssetIssueById", actualGetAssetIssueByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueById", actualGetAssetIssueByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueByIdMethod.getType());
    assertFalse(actualGetAssetIssueByIdMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByIdMethod.isSafe());
    assertTrue(actualGetAssetIssueByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetNowBlockMethod()}
   */
  @Test
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.Block> actualGetNowBlockMethod = WalletSolidityGrpc
        .getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetNowBlock2Method()}
   */
  @Test
  public void testGetGetNowBlock2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.BlockExtention> actualGetNowBlock2Method = WalletSolidityGrpc
        .getGetNowBlock2Method();

    // Assert
    assertEquals("GetNowBlock2", actualGetNowBlock2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetNowBlock2", actualGetNowBlock2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNowBlock2Method.getType());
    assertFalse(actualGetNowBlock2Method.isIdempotent());
    assertFalse(actualGetNowBlock2Method.isSafe());
    assertTrue(actualGetNowBlock2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetNowBlock2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBlockByNumMethod()}
   */
  @Test
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, Protocol.Block> actualGetBlockByNumMethod = WalletSolidityGrpc
        .getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBlockByNum2Method()}
   */
  @Test
  public void testGetGetBlockByNum2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.BlockExtention> actualGetBlockByNum2Method = WalletSolidityGrpc
        .getGetBlockByNum2Method();

    // Assert
    assertEquals("GetBlockByNum2", actualGetBlockByNum2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlockByNum2", actualGetBlockByNum2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByNum2Method.getType());
    assertFalse(actualGetBlockByNum2Method.isIdempotent());
    assertFalse(actualGetBlockByNum2Method.isSafe());
    assertTrue(actualGetBlockByNum2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockByNum2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetTransactionCountByBlockNumMethod()}
   */
  @Test
  public void testGetGetTransactionCountByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.NumberMessage> actualGetTransactionCountByBlockNumMethod = WalletSolidityGrpc
        .getGetTransactionCountByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionCountByBlockNum", actualGetTransactionCountByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionCountByBlockNum",
        actualGetTransactionCountByBlockNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionCountByBlockNumMethod.getType());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionCountByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionCountByBlockNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetDelegatedResourceMethod()}
   */
  @Test
  public void testGetGetDelegatedResourceMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.DelegatedResourceMessage, GrpcAPI.DelegatedResourceList> actualGetDelegatedResourceMethod = WalletSolidityGrpc
        .getGetDelegatedResourceMethod();

    // Assert
    assertEquals("GetDelegatedResource", actualGetDelegatedResourceMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResource", actualGetDelegatedResourceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceMethod.getType());
    assertFalse(actualGetDelegatedResourceMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceMethod.isSafe());
    assertTrue(actualGetDelegatedResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetDelegatedResourceV2Method()}
   */
  @Test
  public void testGetGetDelegatedResourceV2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.DelegatedResourceMessage, GrpcAPI.DelegatedResourceList> actualGetDelegatedResourceV2Method = WalletSolidityGrpc
        .getGetDelegatedResourceV2Method();

    // Assert
    assertEquals("GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceV2",
        actualGetDelegatedResourceV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceV2Method.getType());
    assertFalse(actualGetDelegatedResourceV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceV2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceV2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexMethod()}
   */
  @Test
  public void testGetGetDelegatedResourceAccountIndexMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexMethod = WalletSolidityGrpc
        .getGetDelegatedResourceAccountIndexMethod();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndex", actualGetDelegatedResourceAccountIndexMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceAccountIndex",
        actualGetDelegatedResourceAccountIndexMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceAccountIndexMethod.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexV2Method()}
   */
  @Test
  public void testGetGetDelegatedResourceAccountIndexV2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexV2Method = WalletSolidityGrpc
        .getGetDelegatedResourceAccountIndexV2Method();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceAccountIndexV2Method.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexV2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexV2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetCanDelegatedMaxSizeMethod()}
   */
  @Test
  public void testGetGetCanDelegatedMaxSizeMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.CanDelegatedMaxSizeRequestMessage, GrpcAPI.CanDelegatedMaxSizeResponseMessage> actualGetCanDelegatedMaxSizeMethod = WalletSolidityGrpc
        .getGetCanDelegatedMaxSizeMethod();

    // Assert
    assertEquals("GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetCanDelegatedMaxSize",
        actualGetCanDelegatedMaxSizeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetCanDelegatedMaxSizeMethod.getType());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isIdempotent());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isSafe());
    assertTrue(actualGetCanDelegatedMaxSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetCanDelegatedMaxSizeMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetAvailableUnfreezeCountMethod()}
   */
  @Test
  public void testGetGetAvailableUnfreezeCountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.GetAvailableUnfreezeCountRequestMessage, GrpcAPI.GetAvailableUnfreezeCountResponseMessage> actualGetAvailableUnfreezeCountMethod = WalletSolidityGrpc
        .getGetAvailableUnfreezeCountMethod();

    // Assert
    assertEquals("GetAvailableUnfreezeCount", actualGetAvailableUnfreezeCountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAvailableUnfreezeCount",
        actualGetAvailableUnfreezeCountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAvailableUnfreezeCountMethod.getType());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isIdempotent());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isSafe());
    assertTrue(actualGetAvailableUnfreezeCountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAvailableUnfreezeCountMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetCanWithdrawUnfreezeAmountMethod()}
   */
  @Test
  public void testGetGetCanWithdrawUnfreezeAmountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> actualGetCanWithdrawUnfreezeAmountMethod = WalletSolidityGrpc
        .getGetCanWithdrawUnfreezeAmountMethod();

    // Assert
    assertEquals("GetCanWithdrawUnfreezeAmount", actualGetCanWithdrawUnfreezeAmountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetCanWithdrawUnfreezeAmount",
        actualGetCanWithdrawUnfreezeAmountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetCanWithdrawUnfreezeAmountMethod.getType());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isIdempotent());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isSafe());
    assertTrue(actualGetCanWithdrawUnfreezeAmountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetCanWithdrawUnfreezeAmountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetExchangeByIdMethod()}
   */
  @Test
  public void testGetGetExchangeByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Exchange> actualGetExchangeByIdMethod = WalletSolidityGrpc
        .getGetExchangeByIdMethod();

    // Assert
    assertEquals("GetExchangeById", actualGetExchangeByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetExchangeById", actualGetExchangeByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetExchangeByIdMethod.getType());
    assertFalse(actualGetExchangeByIdMethod.isIdempotent());
    assertFalse(actualGetExchangeByIdMethod.isSafe());
    assertTrue(actualGetExchangeByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetExchangeByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getListExchangesMethod()}
   */
  @Test
  public void testGetListExchangesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.ExchangeList> actualListExchangesMethod = WalletSolidityGrpc
        .getListExchangesMethod();

    // Assert
    assertEquals("ListExchanges", actualListExchangesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ListExchanges", actualListExchangesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListExchangesMethod.getType());
    assertFalse(actualListExchangesMethod.isIdempotent());
    assertFalse(actualListExchangesMethod.isSafe());
    assertTrue(actualListExchangesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualListExchangesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetTransactionByIdMethod()}
   */
  @Test
  public void testGetGetTransactionByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Transaction> actualGetTransactionByIdMethod = WalletSolidityGrpc
        .getGetTransactionByIdMethod();

    // Assert
    assertEquals("GetTransactionById", actualGetTransactionByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionById", actualGetTransactionByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionByIdMethod.getType());
    assertFalse(actualGetTransactionByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionByIdMethod.isSafe());
    assertTrue(actualGetTransactionByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionByIdMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetTransactionInfoByIdMethod()}
   */
  @Test
  public void testGetGetTransactionInfoByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.TransactionInfo> actualGetTransactionInfoByIdMethod = WalletSolidityGrpc
        .getGetTransactionInfoByIdMethod();

    // Assert
    assertEquals("GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionInfoById",
        actualGetTransactionInfoByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionInfoByIdMethod.getType());
    assertFalse(actualGetTransactionInfoByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByIdMethod.isSafe());
    assertTrue(actualGetTransactionInfoByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionInfoByIdMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetMerkleTreeVoucherInfoMethod()}
   */
  @Test
  public void testGetGetMerkleTreeVoucherInfoMethod() {
    // Arrange and Act
    MethodDescriptor<ShieldContract.OutputPointInfo, ShieldContract.IncrementalMerkleVoucherInfo> actualGetMerkleTreeVoucherInfoMethod = WalletSolidityGrpc
        .getGetMerkleTreeVoucherInfoMethod();

    // Assert
    assertEquals("GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMerkleTreeVoucherInfo",
        actualGetMerkleTreeVoucherInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMerkleTreeVoucherInfoMethod.getType());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isIdempotent());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isSafe());
    assertTrue(actualGetMerkleTreeVoucherInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMerkleTreeVoucherInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getScanNoteByIvkMethod()}
   */
  @Test
  public void testGetScanNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptParameters, GrpcAPI.DecryptNotes> actualScanNoteByIvkMethod = WalletSolidityGrpc
        .getScanNoteByIvkMethod();

    // Assert
    assertEquals("ScanNoteByIvk", actualScanNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanNoteByIvk", actualScanNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanNoteByIvkMethod.getType());
    assertFalse(actualScanNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanNoteByIvkMethod.isSafe());
    assertTrue(actualScanNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanNoteByIvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getScanAndMarkNoteByIvkMethod()}
   */
  @Test
  public void testGetScanAndMarkNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptAndMarkParameters, GrpcAPI.DecryptNotesMarked> actualScanAndMarkNoteByIvkMethod = WalletSolidityGrpc
        .getScanAndMarkNoteByIvkMethod();

    // Assert
    assertEquals("ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanAndMarkNoteByIvkMethod.getType());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isSafe());
    assertTrue(actualScanAndMarkNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanAndMarkNoteByIvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getScanNoteByOvkMethod()}
   */
  @Test
  public void testGetScanNoteByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.OvkDecryptParameters, GrpcAPI.DecryptNotes> actualScanNoteByOvkMethod = WalletSolidityGrpc
        .getScanNoteByOvkMethod();

    // Assert
    assertEquals("ScanNoteByOvk", actualScanNoteByOvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanNoteByOvk", actualScanNoteByOvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanNoteByOvkMethod.getType());
    assertFalse(actualScanNoteByOvkMethod.isIdempotent());
    assertFalse(actualScanNoteByOvkMethod.isSafe());
    assertTrue(actualScanNoteByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanNoteByOvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getIsSpendMethod()}
   */
  @Test
  public void testGetIsSpendMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NoteParameters, GrpcAPI.SpendResult> actualIsSpendMethod = WalletSolidityGrpc
        .getIsSpendMethod();

    // Assert
    assertEquals("IsSpend", actualIsSpendMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/IsSpend", actualIsSpendMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualIsSpendMethod.getType());
    assertFalse(actualIsSpendMethod.isIdempotent());
    assertFalse(actualIsSpendMethod.isSafe());
    assertTrue(actualIsSpendMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualIsSpendMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByIvkMethod()}
   */
  @Test
  public void testGetScanShieldedTRC20NotesByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptTRC20Parameters, GrpcAPI.DecryptNotesTRC20> actualScanShieldedTRC20NotesByIvkMethod = WalletSolidityGrpc
        .getScanShieldedTRC20NotesByIvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByIvk", actualScanShieldedTRC20NotesByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanShieldedTRC20NotesByIvk",
        actualScanShieldedTRC20NotesByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanShieldedTRC20NotesByIvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByIvkMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByOvkMethod()}
   */
  @Test
  public void testGetScanShieldedTRC20NotesByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.OvkDecryptTRC20Parameters, GrpcAPI.DecryptNotesTRC20> actualScanShieldedTRC20NotesByOvkMethod = WalletSolidityGrpc
        .getScanShieldedTRC20NotesByOvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByOvk", actualScanShieldedTRC20NotesByOvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanShieldedTRC20NotesByOvk",
        actualScanShieldedTRC20NotesByOvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanShieldedTRC20NotesByOvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByOvkMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}
   */
  @Test
  public void testGetIsShieldedTRC20ContractNoteSpentMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NfTRC20Parameters, GrpcAPI.NullifierResult> actualIsShieldedTRC20ContractNoteSpentMethod = WalletSolidityGrpc
        .getIsShieldedTRC20ContractNoteSpentMethod();

    // Assert
    assertEquals("IsShieldedTRC20ContractNoteSpent", actualIsShieldedTRC20ContractNoteSpentMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/IsShieldedTRC20ContractNoteSpent",
        actualIsShieldedTRC20ContractNoteSpentMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualIsShieldedTRC20ContractNoteSpentMethod.getType());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isIdempotent());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isSafe());
    assertTrue(actualIsShieldedTRC20ContractNoteSpentMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualIsShieldedTRC20ContractNoteSpentMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetRewardInfoMethod()}
   */
  @Test
  public void testGetGetRewardInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.NumberMessage> actualGetRewardInfoMethod = WalletSolidityGrpc
        .getGetRewardInfoMethod();

    // Assert
    assertEquals("GetRewardInfo", actualGetRewardInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetRewardInfo", actualGetRewardInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetRewardInfoMethod.getType());
    assertFalse(actualGetRewardInfoMethod.isIdempotent());
    assertFalse(actualGetRewardInfoMethod.isSafe());
    assertTrue(actualGetRewardInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetRewardInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBrokerageInfoMethod()}
   */
  @Test
  public void testGetGetBrokerageInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.NumberMessage> actualGetBrokerageInfoMethod = WalletSolidityGrpc
        .getGetBrokerageInfoMethod();

    // Assert
    assertEquals("GetBrokerageInfo", actualGetBrokerageInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBrokerageInfo", actualGetBrokerageInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBrokerageInfoMethod.getType());
    assertFalse(actualGetBrokerageInfoMethod.isIdempotent());
    assertFalse(actualGetBrokerageInfoMethod.isSafe());
    assertTrue(actualGetBrokerageInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBrokerageInfoMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getTriggerConstantContractMethod()}
   */
  @Test
  public void testGetTriggerConstantContractMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.TriggerSmartContract, GrpcAPI.TransactionExtention> actualTriggerConstantContractMethod = WalletSolidityGrpc
        .getTriggerConstantContractMethod();

    // Assert
    assertEquals("TriggerConstantContract", actualTriggerConstantContractMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/TriggerConstantContract",
        actualTriggerConstantContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTriggerConstantContractMethod.getType());
    assertFalse(actualTriggerConstantContractMethod.isIdempotent());
    assertFalse(actualTriggerConstantContractMethod.isSafe());
    assertTrue(actualTriggerConstantContractMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualTriggerConstantContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getEstimateEnergyMethod()}
   */
  @Test
  public void testGetEstimateEnergyMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.TriggerSmartContract, GrpcAPI.EstimateEnergyMessage> actualEstimateEnergyMethod = WalletSolidityGrpc
        .getEstimateEnergyMethod();

    // Assert
    assertEquals("EstimateEnergy", actualEstimateEnergyMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/EstimateEnergy", actualEstimateEnergyMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualEstimateEnergyMethod.getType());
    assertFalse(actualEstimateEnergyMethod.isIdempotent());
    assertFalse(actualEstimateEnergyMethod.isSafe());
    assertTrue(actualEstimateEnergyMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualEstimateEnergyMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetTransactionInfoByBlockNumMethod()}
   */
  @Test
  public void testGetGetTransactionInfoByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.TransactionInfoList> actualGetTransactionInfoByBlockNumMethod = WalletSolidityGrpc
        .getGetTransactionInfoByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionInfoByBlockNum", actualGetTransactionInfoByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionInfoByBlockNum",
        actualGetTransactionInfoByBlockNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionInfoByBlockNumMethod.getType());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionInfoByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionInfoByBlockNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetMarketOrderByIdMethod()}
   */
  @Test
  public void testGetGetMarketOrderByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.MarketOrder> actualGetMarketOrderByIdMethod = WalletSolidityGrpc
        .getGetMarketOrderByIdMethod();

    // Assert
    assertEquals("GetMarketOrderById", actualGetMarketOrderByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderById", actualGetMarketOrderByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderByIdMethod.getType());
    assertFalse(actualGetMarketOrderByIdMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByIdMethod.isSafe());
    assertTrue(actualGetMarketOrderByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderByIdMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetMarketOrderByAccountMethod()}
   */
  @Test
  public void testGetGetMarketOrderByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.MarketOrderList> actualGetMarketOrderByAccountMethod = WalletSolidityGrpc
        .getGetMarketOrderByAccountMethod();

    // Assert
    assertEquals("GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderByAccount",
        actualGetMarketOrderByAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderByAccountMethod.getType());
    assertFalse(actualGetMarketOrderByAccountMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByAccountMethod.isSafe());
    assertTrue(actualGetMarketOrderByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderByAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetMarketPriceByPairMethod()}
   */
  @Test
  public void testGetGetMarketPriceByPairMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.MarketOrderPair, Protocol.MarketPriceList> actualGetMarketPriceByPairMethod = WalletSolidityGrpc
        .getGetMarketPriceByPairMethod();

    // Assert
    assertEquals("GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketPriceByPairMethod.getType());
    assertFalse(actualGetMarketPriceByPairMethod.isIdempotent());
    assertFalse(actualGetMarketPriceByPairMethod.isSafe());
    assertTrue(actualGetMarketPriceByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketPriceByPairMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletSolidityGrpc#getGetMarketOrderListByPairMethod()}
   */
  @Test
  public void testGetGetMarketOrderListByPairMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.MarketOrderPair, Protocol.MarketOrderList> actualGetMarketOrderListByPairMethod = WalletSolidityGrpc
        .getGetMarketOrderListByPairMethod();

    // Assert
    assertEquals("GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderListByPair",
        actualGetMarketOrderListByPairMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderListByPairMethod.getType());
    assertFalse(actualGetMarketOrderListByPairMethod.isIdempotent());
    assertFalse(actualGetMarketOrderListByPairMethod.isSafe());
    assertTrue(actualGetMarketOrderListByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderListByPairMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetMarketPairListMethod()}
   */
  @Test
  public void testGetGetMarketPairListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.MarketOrderPairList> actualGetMarketPairListMethod = WalletSolidityGrpc
        .getGetMarketPairListMethod();

    // Assert
    assertEquals("GetMarketPairList", actualGetMarketPairListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketPairList", actualGetMarketPairListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketPairListMethod.getType());
    assertFalse(actualGetMarketPairListMethod.isIdempotent());
    assertFalse(actualGetMarketPairListMethod.isSafe());
    assertTrue(actualGetMarketPairListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketPairListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBurnTrxMethod()}
   */
  @Test
  public void testGetGetBurnTrxMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NumberMessage> actualGetBurnTrxMethod = WalletSolidityGrpc
        .getGetBurnTrxMethod();

    // Assert
    assertEquals("GetBurnTrx", actualGetBurnTrxMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBurnTrx", actualGetBurnTrxMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBurnTrxMethod.getType());
    assertFalse(actualGetBurnTrxMethod.isIdempotent());
    assertFalse(actualGetBurnTrxMethod.isSafe());
    assertTrue(actualGetBurnTrxMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBurnTrxMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBlockMethod()}
   */
  @Test
  public void testGetGetBlockMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BlockReq, GrpcAPI.BlockExtention> actualGetBlockMethod = WalletSolidityGrpc
        .getGetBlockMethod();

    // Assert
    assertEquals("GetBlock", actualGetBlockMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlock", actualGetBlockMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockMethod.getType());
    assertFalse(actualGetBlockMethod.isIdempotent());
    assertFalse(actualGetBlockMethod.isSafe());
    assertTrue(actualGetBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetBandwidthPricesMethod()}
   */
  @Test
  public void testGetGetBandwidthPricesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.PricesResponseMessage> actualGetBandwidthPricesMethod = WalletSolidityGrpc
        .getGetBandwidthPricesMethod();

    // Assert
    assertEquals("GetBandwidthPrices", actualGetBandwidthPricesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBandwidthPrices", actualGetBandwidthPricesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBandwidthPricesMethod.getType());
    assertFalse(actualGetBandwidthPricesMethod.isIdempotent());
    assertFalse(actualGetBandwidthPricesMethod.isSafe());
    assertTrue(actualGetBandwidthPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBandwidthPricesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getGetEnergyPricesMethod()}
   */
  @Test
  public void testGetGetEnergyPricesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.PricesResponseMessage> actualGetEnergyPricesMethod = WalletSolidityGrpc
        .getGetEnergyPricesMethod();

    // Assert
    assertEquals("GetEnergyPrices", actualGetEnergyPricesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetEnergyPrices", actualGetEnergyPricesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetEnergyPricesMethod.getType());
    assertFalse(actualGetEnergyPricesMethod.isIdempotent());
    assertFalse(actualGetEnergyPricesMethod.isSafe());
    assertTrue(actualGetEnergyPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetEnergyPricesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityGrpc.WalletSolidityStub actualNewStubResult = WalletSolidityGrpc.newStub(channel);

    // Assert
    CallOptions callOptions = actualNewStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewStubResult.getChannel());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityGrpc.WalletSolidityBlockingStub actualNewBlockingStubResult = WalletSolidityGrpc
        .newBlockingStub(channel);

    // Assert
    CallOptions callOptions = actualNewBlockingStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewBlockingStubResult.getChannel());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityGrpc.WalletSolidityFutureStub actualNewFutureStubResult = WalletSolidityGrpc.newFutureStub(channel);

    // Assert
    CallOptions callOptions = actualNewFutureStubResult.getCallOptions();
    assertNull(callOptions.getCredentials());
    assertNull(callOptions.getDeadline());
    assertNull(callOptions.getMaxInboundMessageSize());
    assertNull(callOptions.getMaxOutboundMessageSize());
    assertNull(callOptions.getAuthority());
    assertNull(callOptions.getCompressor());
    assertNull(callOptions.getExecutor());
    assertFalse(callOptions.isWaitForReady());
    assertTrue(callOptions.getStreamTracerFactories().isEmpty());
    assertSame(channel, actualNewFutureStubResult.getChannel());
  }

  /**
   * Method under test: {@link WalletSolidityGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletSolidityGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(46, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("GetAccount", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("GetAccountById", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(44);
    assertEquals("GetBandwidthPrices", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(43);
    assertEquals("GetBlock", getResult4.getBareMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(45);
    assertEquals("GetEnergyPrices", getResult5.getBareMethodName());
    MethodDescriptor<?, ?> getResult6 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("ListWitnesses", getResult6.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAccount", getResult.getFullMethodName());
    assertEquals("protocol.WalletSolidity/GetAccountById", getResult2.getFullMethodName());
    assertEquals("protocol.WalletSolidity/GetBandwidthPrices", getResult3.getFullMethodName());
    assertEquals("protocol.WalletSolidity/GetBlock", getResult4.getFullMethodName());
    assertEquals("protocol.WalletSolidity/GetEnergyPrices", getResult5.getFullMethodName());
    assertEquals("protocol.WalletSolidity/ListWitnesses", getResult6.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult6.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult6.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult6.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult5.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult6.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult6.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
