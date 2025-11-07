package org.tron.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI.AssetIssueList;
import org.tron.api.GrpcAPI.BlockExtention;
import org.tron.api.GrpcAPI.BlockReq;
import org.tron.api.GrpcAPI.BytesMessage;
import org.tron.api.GrpcAPI.CanDelegatedMaxSizeRequestMessage;
import org.tron.api.GrpcAPI.CanDelegatedMaxSizeResponseMessage;
import org.tron.api.GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage;
import org.tron.api.GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage;
import org.tron.api.GrpcAPI.DecryptNotes;
import org.tron.api.GrpcAPI.DecryptNotesMarked;
import org.tron.api.GrpcAPI.DecryptNotesTRC20;
import org.tron.api.GrpcAPI.DelegatedResourceList;
import org.tron.api.GrpcAPI.DelegatedResourceMessage;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.GrpcAPI.EstimateEnergyMessage;
import org.tron.api.GrpcAPI.ExchangeList;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountRequestMessage;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountResponseMessage;
import org.tron.api.GrpcAPI.IvkDecryptAndMarkParameters;
import org.tron.api.GrpcAPI.IvkDecryptParameters;
import org.tron.api.GrpcAPI.IvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.NfTRC20Parameters;
import org.tron.api.GrpcAPI.NoteParameters;
import org.tron.api.GrpcAPI.NullifierResult;
import org.tron.api.GrpcAPI.NumberMessage;
import org.tron.api.GrpcAPI.OvkDecryptParameters;
import org.tron.api.GrpcAPI.OvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.PaginatedMessage;
import org.tron.api.GrpcAPI.PricesResponseMessage;
import org.tron.api.GrpcAPI.SpendResult;
import org.tron.api.GrpcAPI.TransactionExtention;
import org.tron.api.GrpcAPI.TransactionInfoList;
import org.tron.api.GrpcAPI.WitnessList;
import org.tron.api.WalletSolidityGrpc.WalletSolidityBlockingStub;
import org.tron.api.WalletSolidityGrpc.WalletSolidityFutureStub;
import org.tron.api.WalletSolidityGrpc.WalletSolidityStub;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.DelegatedResourceAccountIndex;
import org.tron.protos.Protocol.Exchange;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrderList;
import org.tron.protos.Protocol.MarketOrderPair;
import org.tron.protos.Protocol.MarketOrderPairList;
import org.tron.protos.Protocol.MarketPriceList;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo;
import org.tron.protos.contract.ShieldContract.OutputPointInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;

public class WalletSolidityGrpcDiffblueTest {
  /**
   * Test {@link WalletSolidityGrpc#getGetAccountMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAccountMethod()"})
  public void testGetGetAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Account, Account> actualGetAccountMethod = WalletSolidityGrpc.getGetAccountMethod();

    // Assert
    assertEquals("GetAccount", actualGetAccountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAccount", actualGetAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountMethod.getType());
    assertFalse(actualGetAccountMethod.isIdempotent());
    assertFalse(actualGetAccountMethod.isSafe());
    assertTrue(actualGetAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAccountByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAccountByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAccountByIdMethod()"})
  public void testGetGetAccountByIdMethod() {
    // Arrange and Act
    MethodDescriptor<Account, Account> actualGetAccountByIdMethod = WalletSolidityGrpc.getGetAccountByIdMethod();

    // Assert
    assertEquals("GetAccountById", actualGetAccountByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAccountById", actualGetAccountByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountByIdMethod.getType());
    assertFalse(actualGetAccountByIdMethod.isIdempotent());
    assertFalse(actualGetAccountByIdMethod.isSafe());
    assertTrue(actualGetAccountByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAccountByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getListWitnessesMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getListWitnessesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getListWitnessesMethod()"})
  public void testGetListWitnessesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, WitnessList> actualListWitnessesMethod = WalletSolidityGrpc.getListWitnessesMethod();

    // Assert
    assertEquals("ListWitnesses", actualListWitnessesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ListWitnesses", actualListWitnessesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListWitnessesMethod.getType());
    assertFalse(actualListWitnessesMethod.isIdempotent());
    assertFalse(actualListWitnessesMethod.isSafe());
    assertTrue(actualListWitnessesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualListWitnessesMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAssetIssueListMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAssetIssueListMethod()"})
  public void testGetGetAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, AssetIssueList> actualGetAssetIssueListMethod = WalletSolidityGrpc
        .getGetAssetIssueListMethod();

    // Assert
    assertEquals("GetAssetIssueList", actualGetAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueList", actualGetAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueListMethod.getType());
    assertFalse(actualGetAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListMethod.isSafe());
    assertTrue(actualGetAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueListMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetPaginatedAssetIssueListMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetPaginatedAssetIssueListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetPaginatedAssetIssueListMethod()"})
  public void testGetGetPaginatedAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<PaginatedMessage, AssetIssueList> actualGetPaginatedAssetIssueListMethod = WalletSolidityGrpc
        .getGetPaginatedAssetIssueListMethod();

    // Assert
    assertEquals("GetPaginatedAssetIssueList", actualGetPaginatedAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetPaginatedAssetIssueList",
        actualGetPaginatedAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetPaginatedAssetIssueListMethod.getType());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isSafe());
    assertTrue(actualGetPaginatedAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetPaginatedAssetIssueListMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAssetIssueByNameMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueByNameMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAssetIssueByNameMethod()"})
  public void testGetGetAssetIssueByNameMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueContract> actualGetAssetIssueByNameMethod = WalletSolidityGrpc
        .getGetAssetIssueByNameMethod();

    // Assert
    assertEquals("GetAssetIssueByName", actualGetAssetIssueByNameMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueByName", actualGetAssetIssueByNameMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueByNameMethod.getType());
    assertFalse(actualGetAssetIssueByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueByNameMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAssetIssueListByNameMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueListByNameMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAssetIssueListByNameMethod()"})
  public void testGetGetAssetIssueListByNameMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueList> actualGetAssetIssueListByNameMethod = WalletSolidityGrpc
        .getGetAssetIssueListByNameMethod();

    // Assert
    assertEquals("GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueListByName",
        actualGetAssetIssueListByNameMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueListByNameMethod.getType());
    assertFalse(actualGetAssetIssueListByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueListByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueListByNameMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAssetIssueByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAssetIssueByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAssetIssueByIdMethod()"})
  public void testGetGetAssetIssueByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueContract> actualGetAssetIssueByIdMethod = WalletSolidityGrpc
        .getGetAssetIssueByIdMethod();

    // Assert
    assertEquals("GetAssetIssueById", actualGetAssetIssueByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAssetIssueById", actualGetAssetIssueByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueByIdMethod.getType());
    assertFalse(actualGetAssetIssueByIdMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByIdMethod.isSafe());
    assertTrue(actualGetAssetIssueByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAssetIssueByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetNowBlockMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetNowBlockMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetNowBlockMethod()"})
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, Block> actualGetNowBlockMethod = WalletSolidityGrpc.getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetNowBlock2Method()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetNowBlock2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetNowBlock2Method()"})
  public void testGetGetNowBlock2Method() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, BlockExtention> actualGetNowBlock2Method = WalletSolidityGrpc
        .getGetNowBlock2Method();

    // Assert
    assertEquals("GetNowBlock2", actualGetNowBlock2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetNowBlock2", actualGetNowBlock2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNowBlock2Method.getType());
    assertFalse(actualGetNowBlock2Method.isIdempotent());
    assertFalse(actualGetNowBlock2Method.isSafe());
    assertTrue(actualGetNowBlock2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetNowBlock2Method.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBlockByNumMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBlockByNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBlockByNumMethod()"})
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, Block> actualGetBlockByNumMethod = WalletSolidityGrpc.getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBlockByNum2Method()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBlockByNum2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBlockByNum2Method()"})
  public void testGetGetBlockByNum2Method() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, BlockExtention> actualGetBlockByNum2Method = WalletSolidityGrpc
        .getGetBlockByNum2Method();

    // Assert
    assertEquals("GetBlockByNum2", actualGetBlockByNum2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlockByNum2", actualGetBlockByNum2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByNum2Method.getType());
    assertFalse(actualGetBlockByNum2Method.isIdempotent());
    assertFalse(actualGetBlockByNum2Method.isSafe());
    assertTrue(actualGetBlockByNum2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockByNum2Method.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetTransactionCountByBlockNumMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetTransactionCountByBlockNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetTransactionCountByBlockNumMethod()"})
  public void testGetGetTransactionCountByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, NumberMessage> actualGetTransactionCountByBlockNumMethod = WalletSolidityGrpc
        .getGetTransactionCountByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionCountByBlockNum", actualGetTransactionCountByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionCountByBlockNum",
        actualGetTransactionCountByBlockNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionCountByBlockNumMethod.getType());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionCountByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionCountByBlockNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetDelegatedResourceMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetDelegatedResourceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetDelegatedResourceMethod()"})
  public void testGetGetDelegatedResourceMethod() {
    // Arrange and Act
    MethodDescriptor<DelegatedResourceMessage, DelegatedResourceList> actualGetDelegatedResourceMethod = WalletSolidityGrpc
        .getGetDelegatedResourceMethod();

    // Assert
    assertEquals("GetDelegatedResource", actualGetDelegatedResourceMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResource", actualGetDelegatedResourceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceMethod.getType());
    assertFalse(actualGetDelegatedResourceMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceMethod.isSafe());
    assertTrue(actualGetDelegatedResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetDelegatedResourceV2Method()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetDelegatedResourceV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetDelegatedResourceV2Method()"})
  public void testGetGetDelegatedResourceV2Method() {
    // Arrange and Act
    MethodDescriptor<DelegatedResourceMessage, DelegatedResourceList> actualGetDelegatedResourceV2Method = WalletSolidityGrpc
        .getGetDelegatedResourceV2Method();

    // Assert
    assertEquals("GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceV2",
        actualGetDelegatedResourceV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceV2Method.getType());
    assertFalse(actualGetDelegatedResourceV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceV2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceV2Method.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetDelegatedResourceAccountIndexMethod()"})
  public void testGetGetDelegatedResourceAccountIndexMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexMethod = WalletSolidityGrpc
        .getGetDelegatedResourceAccountIndexMethod();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndex", actualGetDelegatedResourceAccountIndexMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceAccountIndex",
        actualGetDelegatedResourceAccountIndexMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceAccountIndexMethod.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexV2Method()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetDelegatedResourceAccountIndexV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetDelegatedResourceAccountIndexV2Method()"})
  public void testGetGetDelegatedResourceAccountIndexV2Method() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexV2Method = WalletSolidityGrpc
        .getGetDelegatedResourceAccountIndexV2Method();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceAccountIndexV2Method.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexV2Method.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexV2Method.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetCanDelegatedMaxSizeMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetCanDelegatedMaxSizeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetCanDelegatedMaxSizeMethod()"})
  public void testGetGetCanDelegatedMaxSizeMethod() {
    // Arrange and Act
    MethodDescriptor<CanDelegatedMaxSizeRequestMessage, CanDelegatedMaxSizeResponseMessage> actualGetCanDelegatedMaxSizeMethod = WalletSolidityGrpc
        .getGetCanDelegatedMaxSizeMethod();

    // Assert
    assertEquals("GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetCanDelegatedMaxSize",
        actualGetCanDelegatedMaxSizeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetCanDelegatedMaxSizeMethod.getType());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isIdempotent());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isSafe());
    assertTrue(actualGetCanDelegatedMaxSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetCanDelegatedMaxSizeMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetAvailableUnfreezeCountMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetAvailableUnfreezeCountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetAvailableUnfreezeCountMethod()"})
  public void testGetGetAvailableUnfreezeCountMethod() {
    // Arrange and Act
    MethodDescriptor<GetAvailableUnfreezeCountRequestMessage, GetAvailableUnfreezeCountResponseMessage> actualGetAvailableUnfreezeCountMethod = WalletSolidityGrpc
        .getGetAvailableUnfreezeCountMethod();

    // Assert
    assertEquals("GetAvailableUnfreezeCount", actualGetAvailableUnfreezeCountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetAvailableUnfreezeCount",
        actualGetAvailableUnfreezeCountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAvailableUnfreezeCountMethod.getType());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isIdempotent());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isSafe());
    assertTrue(actualGetAvailableUnfreezeCountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetAvailableUnfreezeCountMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetCanWithdrawUnfreezeAmountMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetCanWithdrawUnfreezeAmountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetCanWithdrawUnfreezeAmountMethod()"})
  public void testGetGetCanWithdrawUnfreezeAmountMethod() {
    // Arrange and Act
    MethodDescriptor<CanWithdrawUnfreezeAmountRequestMessage, CanWithdrawUnfreezeAmountResponseMessage> actualGetCanWithdrawUnfreezeAmountMethod = WalletSolidityGrpc
        .getGetCanWithdrawUnfreezeAmountMethod();

    // Assert
    assertEquals("GetCanWithdrawUnfreezeAmount", actualGetCanWithdrawUnfreezeAmountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetCanWithdrawUnfreezeAmount",
        actualGetCanWithdrawUnfreezeAmountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetCanWithdrawUnfreezeAmountMethod.getType());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isIdempotent());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isSafe());
    assertTrue(actualGetCanWithdrawUnfreezeAmountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetCanWithdrawUnfreezeAmountMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetExchangeByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetExchangeByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetExchangeByIdMethod()"})
  public void testGetGetExchangeByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Exchange> actualGetExchangeByIdMethod = WalletSolidityGrpc
        .getGetExchangeByIdMethod();

    // Assert
    assertEquals("GetExchangeById", actualGetExchangeByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetExchangeById", actualGetExchangeByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetExchangeByIdMethod.getType());
    assertFalse(actualGetExchangeByIdMethod.isIdempotent());
    assertFalse(actualGetExchangeByIdMethod.isSafe());
    assertTrue(actualGetExchangeByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetExchangeByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getListExchangesMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getListExchangesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getListExchangesMethod()"})
  public void testGetListExchangesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, ExchangeList> actualListExchangesMethod = WalletSolidityGrpc
        .getListExchangesMethod();

    // Assert
    assertEquals("ListExchanges", actualListExchangesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ListExchanges", actualListExchangesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListExchangesMethod.getType());
    assertFalse(actualListExchangesMethod.isIdempotent());
    assertFalse(actualListExchangesMethod.isSafe());
    assertTrue(actualListExchangesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualListExchangesMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetTransactionByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetTransactionByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetTransactionByIdMethod()"})
  public void testGetGetTransactionByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Transaction> actualGetTransactionByIdMethod = WalletSolidityGrpc
        .getGetTransactionByIdMethod();

    // Assert
    assertEquals("GetTransactionById", actualGetTransactionByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionById", actualGetTransactionByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionByIdMethod.getType());
    assertFalse(actualGetTransactionByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionByIdMethod.isSafe());
    assertTrue(actualGetTransactionByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetTransactionInfoByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetTransactionInfoByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetTransactionInfoByIdMethod()"})
  public void testGetGetTransactionInfoByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, TransactionInfo> actualGetTransactionInfoByIdMethod = WalletSolidityGrpc
        .getGetTransactionInfoByIdMethod();

    // Assert
    assertEquals("GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionInfoById",
        actualGetTransactionInfoByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionInfoByIdMethod.getType());
    assertFalse(actualGetTransactionInfoByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByIdMethod.isSafe());
    assertTrue(actualGetTransactionInfoByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionInfoByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMerkleTreeVoucherInfoMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMerkleTreeVoucherInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMerkleTreeVoucherInfoMethod()"})
  public void testGetGetMerkleTreeVoucherInfoMethod() {
    // Arrange and Act
    MethodDescriptor<OutputPointInfo, IncrementalMerkleVoucherInfo> actualGetMerkleTreeVoucherInfoMethod = WalletSolidityGrpc
        .getGetMerkleTreeVoucherInfoMethod();

    // Assert
    assertEquals("GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMerkleTreeVoucherInfo",
        actualGetMerkleTreeVoucherInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMerkleTreeVoucherInfoMethod.getType());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isIdempotent());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isSafe());
    assertTrue(actualGetMerkleTreeVoucherInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMerkleTreeVoucherInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getScanNoteByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getScanNoteByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getScanNoteByIvkMethod()"})
  public void testGetScanNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptParameters, DecryptNotes> actualScanNoteByIvkMethod = WalletSolidityGrpc
        .getScanNoteByIvkMethod();

    // Assert
    assertEquals("ScanNoteByIvk", actualScanNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanNoteByIvk", actualScanNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanNoteByIvkMethod.getType());
    assertFalse(actualScanNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanNoteByIvkMethod.isSafe());
    assertTrue(actualScanNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanNoteByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getScanAndMarkNoteByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getScanAndMarkNoteByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getScanAndMarkNoteByIvkMethod()"})
  public void testGetScanAndMarkNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptAndMarkParameters, DecryptNotesMarked> actualScanAndMarkNoteByIvkMethod = WalletSolidityGrpc
        .getScanAndMarkNoteByIvkMethod();

    // Assert
    assertEquals("ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanAndMarkNoteByIvkMethod.getType());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isSafe());
    assertTrue(actualScanAndMarkNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanAndMarkNoteByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getScanNoteByOvkMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getScanNoteByOvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getScanNoteByOvkMethod()"})
  public void testGetScanNoteByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<OvkDecryptParameters, DecryptNotes> actualScanNoteByOvkMethod = WalletSolidityGrpc
        .getScanNoteByOvkMethod();

    // Assert
    assertEquals("ScanNoteByOvk", actualScanNoteByOvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanNoteByOvk", actualScanNoteByOvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanNoteByOvkMethod.getType());
    assertFalse(actualScanNoteByOvkMethod.isIdempotent());
    assertFalse(actualScanNoteByOvkMethod.isSafe());
    assertTrue(actualScanNoteByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanNoteByOvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getIsSpendMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getIsSpendMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getIsSpendMethod()"})
  public void testGetIsSpendMethod() {
    // Arrange and Act
    MethodDescriptor<NoteParameters, SpendResult> actualIsSpendMethod = WalletSolidityGrpc.getIsSpendMethod();

    // Assert
    assertEquals("IsSpend", actualIsSpendMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/IsSpend", actualIsSpendMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualIsSpendMethod.getType());
    assertFalse(actualIsSpendMethod.isIdempotent());
    assertFalse(actualIsSpendMethod.isSafe());
    assertTrue(actualIsSpendMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualIsSpendMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getScanShieldedTRC20NotesByIvkMethod()"})
  public void testGetScanShieldedTRC20NotesByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptTRC20Parameters, DecryptNotesTRC20> actualScanShieldedTRC20NotesByIvkMethod = WalletSolidityGrpc
        .getScanShieldedTRC20NotesByIvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByIvk", actualScanShieldedTRC20NotesByIvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanShieldedTRC20NotesByIvk",
        actualScanShieldedTRC20NotesByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanShieldedTRC20NotesByIvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByOvkMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getScanShieldedTRC20NotesByOvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getScanShieldedTRC20NotesByOvkMethod()"})
  public void testGetScanShieldedTRC20NotesByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<OvkDecryptTRC20Parameters, DecryptNotesTRC20> actualScanShieldedTRC20NotesByOvkMethod = WalletSolidityGrpc
        .getScanShieldedTRC20NotesByOvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByOvk", actualScanShieldedTRC20NotesByOvkMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/ScanShieldedTRC20NotesByOvk",
        actualScanShieldedTRC20NotesByOvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanShieldedTRC20NotesByOvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByOvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getIsShieldedTRC20ContractNoteSpentMethod()"})
  public void testGetIsShieldedTRC20ContractNoteSpentMethod() {
    // Arrange and Act
    MethodDescriptor<NfTRC20Parameters, NullifierResult> actualIsShieldedTRC20ContractNoteSpentMethod = WalletSolidityGrpc
        .getIsShieldedTRC20ContractNoteSpentMethod();

    // Assert
    assertEquals("IsShieldedTRC20ContractNoteSpent", actualIsShieldedTRC20ContractNoteSpentMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/IsShieldedTRC20ContractNoteSpent",
        actualIsShieldedTRC20ContractNoteSpentMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualIsShieldedTRC20ContractNoteSpentMethod.getType());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isIdempotent());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isSafe());
    assertTrue(actualIsShieldedTRC20ContractNoteSpentMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualIsShieldedTRC20ContractNoteSpentMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetRewardInfoMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetRewardInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetRewardInfoMethod()"})
  public void testGetGetRewardInfoMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, NumberMessage> actualGetRewardInfoMethod = WalletSolidityGrpc
        .getGetRewardInfoMethod();

    // Assert
    assertEquals("GetRewardInfo", actualGetRewardInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetRewardInfo", actualGetRewardInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetRewardInfoMethod.getType());
    assertFalse(actualGetRewardInfoMethod.isIdempotent());
    assertFalse(actualGetRewardInfoMethod.isSafe());
    assertTrue(actualGetRewardInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetRewardInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBrokerageInfoMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBrokerageInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBrokerageInfoMethod()"})
  public void testGetGetBrokerageInfoMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, NumberMessage> actualGetBrokerageInfoMethod = WalletSolidityGrpc
        .getGetBrokerageInfoMethod();

    // Assert
    assertEquals("GetBrokerageInfo", actualGetBrokerageInfoMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBrokerageInfo", actualGetBrokerageInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBrokerageInfoMethod.getType());
    assertFalse(actualGetBrokerageInfoMethod.isIdempotent());
    assertFalse(actualGetBrokerageInfoMethod.isSafe());
    assertTrue(actualGetBrokerageInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBrokerageInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getTriggerConstantContractMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getTriggerConstantContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getTriggerConstantContractMethod()"})
  public void testGetTriggerConstantContractMethod() {
    // Arrange and Act
    MethodDescriptor<TriggerSmartContract, TransactionExtention> actualTriggerConstantContractMethod = WalletSolidityGrpc
        .getTriggerConstantContractMethod();

    // Assert
    assertEquals("TriggerConstantContract", actualTriggerConstantContractMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/TriggerConstantContract",
        actualTriggerConstantContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTriggerConstantContractMethod.getType());
    assertFalse(actualTriggerConstantContractMethod.isIdempotent());
    assertFalse(actualTriggerConstantContractMethod.isSafe());
    assertTrue(actualTriggerConstantContractMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualTriggerConstantContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getEstimateEnergyMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getEstimateEnergyMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getEstimateEnergyMethod()"})
  public void testGetEstimateEnergyMethod() {
    // Arrange and Act
    MethodDescriptor<TriggerSmartContract, EstimateEnergyMessage> actualEstimateEnergyMethod = WalletSolidityGrpc
        .getEstimateEnergyMethod();

    // Assert
    assertEquals("EstimateEnergy", actualEstimateEnergyMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/EstimateEnergy", actualEstimateEnergyMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualEstimateEnergyMethod.getType());
    assertFalse(actualEstimateEnergyMethod.isIdempotent());
    assertFalse(actualEstimateEnergyMethod.isSafe());
    assertTrue(actualEstimateEnergyMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualEstimateEnergyMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetTransactionInfoByBlockNumMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetTransactionInfoByBlockNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetTransactionInfoByBlockNumMethod()"})
  public void testGetGetTransactionInfoByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, TransactionInfoList> actualGetTransactionInfoByBlockNumMethod = WalletSolidityGrpc
        .getGetTransactionInfoByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionInfoByBlockNum", actualGetTransactionInfoByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetTransactionInfoByBlockNum",
        actualGetTransactionInfoByBlockNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionInfoByBlockNumMethod.getType());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionInfoByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetTransactionInfoByBlockNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMarketOrderByIdMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMarketOrderByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMarketOrderByIdMethod()"})
  public void testGetGetMarketOrderByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, MarketOrder> actualGetMarketOrderByIdMethod = WalletSolidityGrpc
        .getGetMarketOrderByIdMethod();

    // Assert
    assertEquals("GetMarketOrderById", actualGetMarketOrderByIdMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderById", actualGetMarketOrderByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderByIdMethod.getType());
    assertFalse(actualGetMarketOrderByIdMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByIdMethod.isSafe());
    assertTrue(actualGetMarketOrderByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMarketOrderByAccountMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMarketOrderByAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMarketOrderByAccountMethod()"})
  public void testGetGetMarketOrderByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, MarketOrderList> actualGetMarketOrderByAccountMethod = WalletSolidityGrpc
        .getGetMarketOrderByAccountMethod();

    // Assert
    assertEquals("GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderByAccount",
        actualGetMarketOrderByAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderByAccountMethod.getType());
    assertFalse(actualGetMarketOrderByAccountMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByAccountMethod.isSafe());
    assertTrue(actualGetMarketOrderByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderByAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMarketPriceByPairMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMarketPriceByPairMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMarketPriceByPairMethod()"})
  public void testGetGetMarketPriceByPairMethod() {
    // Arrange and Act
    MethodDescriptor<MarketOrderPair, MarketPriceList> actualGetMarketPriceByPairMethod = WalletSolidityGrpc
        .getGetMarketPriceByPairMethod();

    // Assert
    assertEquals("GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketPriceByPairMethod.getType());
    assertFalse(actualGetMarketPriceByPairMethod.isIdempotent());
    assertFalse(actualGetMarketPriceByPairMethod.isSafe());
    assertTrue(actualGetMarketPriceByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketPriceByPairMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMarketOrderListByPairMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMarketOrderListByPairMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMarketOrderListByPairMethod()"})
  public void testGetGetMarketOrderListByPairMethod() {
    // Arrange and Act
    MethodDescriptor<MarketOrderPair, MarketOrderList> actualGetMarketOrderListByPairMethod = WalletSolidityGrpc
        .getGetMarketOrderListByPairMethod();

    // Assert
    assertEquals("GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketOrderListByPair",
        actualGetMarketOrderListByPairMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderListByPairMethod.getType());
    assertFalse(actualGetMarketOrderListByPairMethod.isIdempotent());
    assertFalse(actualGetMarketOrderListByPairMethod.isSafe());
    assertTrue(actualGetMarketOrderListByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketOrderListByPairMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetMarketPairListMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetMarketPairListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetMarketPairListMethod()"})
  public void testGetGetMarketPairListMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, MarketOrderPairList> actualGetMarketPairListMethod = WalletSolidityGrpc
        .getGetMarketPairListMethod();

    // Assert
    assertEquals("GetMarketPairList", actualGetMarketPairListMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetMarketPairList", actualGetMarketPairListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketPairListMethod.getType());
    assertFalse(actualGetMarketPairListMethod.isIdempotent());
    assertFalse(actualGetMarketPairListMethod.isSafe());
    assertTrue(actualGetMarketPairListMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetMarketPairListMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBurnTrxMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBurnTrxMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBurnTrxMethod()"})
  public void testGetGetBurnTrxMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NumberMessage> actualGetBurnTrxMethod = WalletSolidityGrpc.getGetBurnTrxMethod();

    // Assert
    assertEquals("GetBurnTrx", actualGetBurnTrxMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBurnTrx", actualGetBurnTrxMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBurnTrxMethod.getType());
    assertFalse(actualGetBurnTrxMethod.isIdempotent());
    assertFalse(actualGetBurnTrxMethod.isSafe());
    assertTrue(actualGetBurnTrxMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBurnTrxMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBlockMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBlockMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBlockMethod()"})
  public void testGetGetBlockMethod() {
    // Arrange and Act
    MethodDescriptor<BlockReq, BlockExtention> actualGetBlockMethod = WalletSolidityGrpc.getGetBlockMethod();

    // Assert
    assertEquals("GetBlock", actualGetBlockMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBlock", actualGetBlockMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockMethod.getType());
    assertFalse(actualGetBlockMethod.isIdempotent());
    assertFalse(actualGetBlockMethod.isSafe());
    assertTrue(actualGetBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBlockMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetBandwidthPricesMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetBandwidthPricesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetBandwidthPricesMethod()"})
  public void testGetGetBandwidthPricesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, PricesResponseMessage> actualGetBandwidthPricesMethod = WalletSolidityGrpc
        .getGetBandwidthPricesMethod();

    // Assert
    assertEquals("GetBandwidthPrices", actualGetBandwidthPricesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetBandwidthPrices", actualGetBandwidthPricesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBandwidthPricesMethod.getType());
    assertFalse(actualGetBandwidthPricesMethod.isIdempotent());
    assertFalse(actualGetBandwidthPricesMethod.isSafe());
    assertTrue(actualGetBandwidthPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetBandwidthPricesMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#getGetEnergyPricesMethod()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getGetEnergyPricesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletSolidityGrpc.getGetEnergyPricesMethod()"})
  public void testGetGetEnergyPricesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, PricesResponseMessage> actualGetEnergyPricesMethod = WalletSolidityGrpc
        .getGetEnergyPricesMethod();

    // Assert
    assertEquals("GetEnergyPrices", actualGetEnergyPricesMethod.getBareMethodName());
    assertEquals("protocol.WalletSolidity/GetEnergyPrices", actualGetEnergyPricesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetEnergyPricesMethod.getType());
    assertFalse(actualGetEnergyPricesMethod.isIdempotent());
    assertFalse(actualGetEnergyPricesMethod.isSafe());
    assertTrue(actualGetEnergyPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualGetEnergyPricesMethod.getServiceName());
  }

  /**
   * Test {@link WalletSolidityGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletSolidityStub WalletSolidityGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityStub actualNewStubResult = WalletSolidityGrpc.newStub(channel);

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
   * Test {@link WalletSolidityGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletSolidityBlockingStub WalletSolidityGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityBlockingStub actualNewBlockingStubResult = WalletSolidityGrpc.newBlockingStub(channel);

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
   * Test {@link WalletSolidityGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletSolidityFutureStub WalletSolidityGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletSolidityFutureStub actualNewFutureStubResult = WalletSolidityGrpc.newFutureStub(channel);

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
   * Test {@link WalletSolidityGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link WalletSolidityGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor WalletSolidityGrpc.getServiceDescriptor()"})
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletSolidityGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(46, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(WalletSolidityGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
