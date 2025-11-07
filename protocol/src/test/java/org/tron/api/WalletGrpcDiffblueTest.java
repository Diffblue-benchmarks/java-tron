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
import org.tron.api.GrpcAPI.AccountNetMessage;
import org.tron.api.GrpcAPI.AccountResourceMessage;
import org.tron.api.GrpcAPI.AssetIssueList;
import org.tron.api.GrpcAPI.BlockExtention;
import org.tron.api.GrpcAPI.BlockLimit;
import org.tron.api.GrpcAPI.BlockList;
import org.tron.api.GrpcAPI.BlockListExtention;
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
import org.tron.api.GrpcAPI.DiversifierMessage;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.GrpcAPI.EstimateEnergyMessage;
import org.tron.api.GrpcAPI.ExchangeList;
import org.tron.api.GrpcAPI.ExpandedSpendingKeyMessage;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountRequestMessage;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountResponseMessage;
import org.tron.api.GrpcAPI.IncomingViewingKeyDiversifierMessage;
import org.tron.api.GrpcAPI.IncomingViewingKeyMessage;
import org.tron.api.GrpcAPI.IvkDecryptAndMarkParameters;
import org.tron.api.GrpcAPI.IvkDecryptParameters;
import org.tron.api.GrpcAPI.IvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.NfParameters;
import org.tron.api.GrpcAPI.NfTRC20Parameters;
import org.tron.api.GrpcAPI.NodeList;
import org.tron.api.GrpcAPI.NoteParameters;
import org.tron.api.GrpcAPI.NullifierResult;
import org.tron.api.GrpcAPI.NumberMessage;
import org.tron.api.GrpcAPI.OvkDecryptParameters;
import org.tron.api.GrpcAPI.OvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.PaginatedMessage;
import org.tron.api.GrpcAPI.PaymentAddressMessage;
import org.tron.api.GrpcAPI.PricesResponseMessage;
import org.tron.api.GrpcAPI.PrivateParameters;
import org.tron.api.GrpcAPI.PrivateParametersWithoutAsk;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk;
import org.tron.api.GrpcAPI.ProposalList;
import org.tron.api.GrpcAPI.Return;
import org.tron.api.GrpcAPI.ShieldedAddressInfo;
import org.tron.api.GrpcAPI.ShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.ShieldedTRC20TriggerContractParameters;
import org.tron.api.GrpcAPI.SpendAuthSigParameters;
import org.tron.api.GrpcAPI.SpendResult;
import org.tron.api.GrpcAPI.TransactionApprovedList;
import org.tron.api.GrpcAPI.TransactionExtention;
import org.tron.api.GrpcAPI.TransactionIdList;
import org.tron.api.GrpcAPI.TransactionInfoList;
import org.tron.api.GrpcAPI.TransactionSignWeight;
import org.tron.api.GrpcAPI.ViewingKeyMessage;
import org.tron.api.GrpcAPI.WitnessList;
import org.tron.api.WalletGrpc.WalletBlockingStub;
import org.tron.api.WalletGrpc.WalletFutureStub;
import org.tron.api.WalletGrpc.WalletStub;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.ChainParameters;
import org.tron.protos.Protocol.DelegatedResourceAccountIndex;
import org.tron.protos.Protocol.Exchange;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrderList;
import org.tron.protos.Protocol.MarketOrderPair;
import org.tron.protos.Protocol.MarketOrderPairList;
import org.tron.protos.Protocol.MarketPriceList;
import org.tron.protos.Protocol.NodeInfo;
import org.tron.protos.Protocol.Proposal;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.TransactionInfo;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AccountContract.AccountCreateContract;
import org.tron.protos.contract.AccountContract.AccountPermissionUpdateContract;
import org.tron.protos.contract.AccountContract.AccountUpdateContract;
import org.tron.protos.contract.AccountContract.SetAccountIdContract;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.ParticipateAssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.TransferAssetContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.UnfreezeAssetContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.UpdateAssetContract;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.BalanceContract.AccountBalanceRequest;
import org.tron.protos.contract.BalanceContract.AccountBalanceResponse;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace.BlockIdentifier;
import org.tron.protos.contract.BalanceContract.CancelAllUnfreezeV2Contract;
import org.tron.protos.contract.BalanceContract.DelegateResourceContract;
import org.tron.protos.contract.BalanceContract.FreezeBalanceContract;
import org.tron.protos.contract.BalanceContract.FreezeBalanceV2Contract;
import org.tron.protos.contract.BalanceContract.TransferContract;
import org.tron.protos.contract.BalanceContract.UnDelegateResourceContract;
import org.tron.protos.contract.BalanceContract.UnfreezeBalanceContract;
import org.tron.protos.contract.BalanceContract.UnfreezeBalanceV2Contract;
import org.tron.protos.contract.BalanceContract.WithdrawBalanceContract;
import org.tron.protos.contract.BalanceContract.WithdrawExpireUnfreezeContract;
import org.tron.protos.contract.ExchangeContract;
import org.tron.protos.contract.ExchangeContract.ExchangeCreateContract;
import org.tron.protos.contract.ExchangeContract.ExchangeInjectContract;
import org.tron.protos.contract.ExchangeContract.ExchangeTransactionContract;
import org.tron.protos.contract.ExchangeContract.ExchangeWithdrawContract;
import org.tron.protos.contract.MarketContract;
import org.tron.protos.contract.MarketContract.MarketCancelOrderContract;
import org.tron.protos.contract.MarketContract.MarketSellAssetContract;
import org.tron.protos.contract.ProposalContract;
import org.tron.protos.contract.ProposalContract.ProposalApproveContract;
import org.tron.protos.contract.ProposalContract.ProposalCreateContract;
import org.tron.protos.contract.ProposalContract.ProposalDeleteContract;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo;
import org.tron.protos.contract.ShieldContract.OutputPointInfo;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.ClearABIContract;
import org.tron.protos.contract.SmartContractOuterClass.CreateSmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContractDataWrapper;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateEnergyLimitContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateSettingContract;
import org.tron.protos.contract.StorageContract;
import org.tron.protos.contract.StorageContract.BuyStorageBytesContract;
import org.tron.protos.contract.StorageContract.BuyStorageContract;
import org.tron.protos.contract.StorageContract.SellStorageContract;
import org.tron.protos.contract.StorageContract.UpdateBrokerageContract;
import org.tron.protos.contract.WitnessContract;
import org.tron.protos.contract.WitnessContract.VoteWitnessContract;
import org.tron.protos.contract.WitnessContract.WitnessCreateContract;
import org.tron.protos.contract.WitnessContract.WitnessUpdateContract;

public class WalletGrpcDiffblueTest {
  /**
   * Test {@link WalletGrpc#getGetAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAccountMethod()"})
  public void testGetGetAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Account, Account> actualGetAccountMethod = WalletGrpc.getGetAccountMethod();

    // Assert
    assertEquals("GetAccount", actualGetAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccount", actualGetAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountMethod.getType());
    assertFalse(actualGetAccountMethod.isIdempotent());
    assertFalse(actualGetAccountMethod.isSafe());
    assertTrue(actualGetAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAccountByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAccountByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAccountByIdMethod()"})
  public void testGetGetAccountByIdMethod() {
    // Arrange and Act
    MethodDescriptor<Account, Account> actualGetAccountByIdMethod = WalletGrpc.getGetAccountByIdMethod();

    // Assert
    assertEquals("GetAccountById", actualGetAccountByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountById", actualGetAccountByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountByIdMethod.getType());
    assertFalse(actualGetAccountByIdMethod.isIdempotent());
    assertFalse(actualGetAccountByIdMethod.isSafe());
    assertTrue(actualGetAccountByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAccountBalanceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAccountBalanceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAccountBalanceMethod()"})
  public void testGetGetAccountBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<AccountBalanceRequest, AccountBalanceResponse> actualGetAccountBalanceMethod = WalletGrpc
        .getGetAccountBalanceMethod();

    // Assert
    assertEquals("GetAccountBalance", actualGetAccountBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountBalance", actualGetAccountBalanceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountBalanceMethod.getType());
    assertFalse(actualGetAccountBalanceMethod.isIdempotent());
    assertFalse(actualGetAccountBalanceMethod.isSafe());
    assertTrue(actualGetAccountBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountBalanceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockBalanceTraceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockBalanceTraceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockBalanceTraceMethod()"})
  public void testGetGetBlockBalanceTraceMethod() {
    // Arrange and Act
    MethodDescriptor<BlockIdentifier, BlockBalanceTrace> actualGetBlockBalanceTraceMethod = WalletGrpc
        .getGetBlockBalanceTraceMethod();

    // Assert
    assertEquals("GetBlockBalanceTrace", actualGetBlockBalanceTraceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockBalanceTrace", actualGetBlockBalanceTraceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockBalanceTraceMethod.getType());
    assertFalse(actualGetBlockBalanceTraceMethod.isIdempotent());
    assertFalse(actualGetBlockBalanceTraceMethod.isSafe());
    assertTrue(actualGetBlockBalanceTraceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockBalanceTraceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateTransactionMethod()"})
  public void testGetCreateTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<TransferContract, Transaction> actualCreateTransactionMethod = WalletGrpc
        .getCreateTransactionMethod();

    // Assert
    assertEquals("CreateTransaction", actualCreateTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateTransaction", actualCreateTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateTransactionMethod.getType());
    assertFalse(actualCreateTransactionMethod.isIdempotent());
    assertFalse(actualCreateTransactionMethod.isSafe());
    assertTrue(actualCreateTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateTransaction2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateTransaction2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateTransaction2Method()"})
  public void testGetCreateTransaction2Method() {
    // Arrange and Act
    MethodDescriptor<TransferContract, TransactionExtention> actualCreateTransaction2Method = WalletGrpc
        .getCreateTransaction2Method();

    // Assert
    assertEquals("CreateTransaction2", actualCreateTransaction2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateTransaction2", actualCreateTransaction2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateTransaction2Method.getType());
    assertFalse(actualCreateTransaction2Method.isIdempotent());
    assertFalse(actualCreateTransaction2Method.isSafe());
    assertTrue(actualCreateTransaction2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateTransaction2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getBroadcastTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getBroadcastTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getBroadcastTransactionMethod()"})
  public void testGetBroadcastTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<Transaction, Return> actualBroadcastTransactionMethod = WalletGrpc.getBroadcastTransactionMethod();

    // Assert
    assertEquals("BroadcastTransaction", actualBroadcastTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BroadcastTransaction", actualBroadcastTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualBroadcastTransactionMethod.getType());
    assertFalse(actualBroadcastTransactionMethod.isIdempotent());
    assertFalse(actualBroadcastTransactionMethod.isSafe());
    assertTrue(actualBroadcastTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBroadcastTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateAccountMethod()"})
  public void testGetUpdateAccountMethod() {
    // Arrange and Act
    MethodDescriptor<AccountUpdateContract, Transaction> actualUpdateAccountMethod = WalletGrpc
        .getUpdateAccountMethod();

    // Assert
    assertEquals("UpdateAccount", actualUpdateAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAccount", actualUpdateAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateAccountMethod.getType());
    assertFalse(actualUpdateAccountMethod.isIdempotent());
    assertFalse(actualUpdateAccountMethod.isSafe());
    assertTrue(actualUpdateAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getSetAccountIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getSetAccountIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getSetAccountIdMethod()"})
  public void testGetSetAccountIdMethod() {
    // Arrange and Act
    MethodDescriptor<SetAccountIdContract, Transaction> actualSetAccountIdMethod = WalletGrpc.getSetAccountIdMethod();

    // Assert
    assertEquals("SetAccountId", actualSetAccountIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/SetAccountId", actualSetAccountIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualSetAccountIdMethod.getType());
    assertFalse(actualSetAccountIdMethod.isIdempotent());
    assertFalse(actualSetAccountIdMethod.isSafe());
    assertTrue(actualSetAccountIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualSetAccountIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateAccount2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateAccount2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateAccount2Method()"})
  public void testGetUpdateAccount2Method() {
    // Arrange and Act
    MethodDescriptor<AccountUpdateContract, TransactionExtention> actualUpdateAccount2Method = WalletGrpc
        .getUpdateAccount2Method();

    // Assert
    assertEquals("UpdateAccount2", actualUpdateAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAccount2", actualUpdateAccount2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateAccount2Method.getType());
    assertFalse(actualUpdateAccount2Method.isIdempotent());
    assertFalse(actualUpdateAccount2Method.isSafe());
    assertTrue(actualUpdateAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAccount2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getVoteWitnessAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getVoteWitnessAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getVoteWitnessAccountMethod()"})
  public void testGetVoteWitnessAccountMethod() {
    // Arrange and Act
    MethodDescriptor<VoteWitnessContract, Transaction> actualVoteWitnessAccountMethod = WalletGrpc
        .getVoteWitnessAccountMethod();

    // Assert
    assertEquals("VoteWitnessAccount", actualVoteWitnessAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/VoteWitnessAccount", actualVoteWitnessAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualVoteWitnessAccountMethod.getType());
    assertFalse(actualVoteWitnessAccountMethod.isIdempotent());
    assertFalse(actualVoteWitnessAccountMethod.isSafe());
    assertTrue(actualVoteWitnessAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualVoteWitnessAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateSettingMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateSettingMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateSettingMethod()"})
  public void testGetUpdateSettingMethod() {
    // Arrange and Act
    MethodDescriptor<UpdateSettingContract, TransactionExtention> actualUpdateSettingMethod = WalletGrpc
        .getUpdateSettingMethod();

    // Assert
    assertEquals("UpdateSetting", actualUpdateSettingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateSetting", actualUpdateSettingMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateSettingMethod.getType());
    assertFalse(actualUpdateSettingMethod.isIdempotent());
    assertFalse(actualUpdateSettingMethod.isSafe());
    assertTrue(actualUpdateSettingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateSettingMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateEnergyLimitMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateEnergyLimitMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateEnergyLimitMethod()"})
  public void testGetUpdateEnergyLimitMethod() {
    // Arrange and Act
    MethodDescriptor<UpdateEnergyLimitContract, TransactionExtention> actualUpdateEnergyLimitMethod = WalletGrpc
        .getUpdateEnergyLimitMethod();

    // Assert
    assertEquals("UpdateEnergyLimit", actualUpdateEnergyLimitMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateEnergyLimit", actualUpdateEnergyLimitMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateEnergyLimitMethod.getType());
    assertFalse(actualUpdateEnergyLimitMethod.isIdempotent());
    assertFalse(actualUpdateEnergyLimitMethod.isSafe());
    assertTrue(actualUpdateEnergyLimitMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateEnergyLimitMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getVoteWitnessAccount2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getVoteWitnessAccount2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getVoteWitnessAccount2Method()"})
  public void testGetVoteWitnessAccount2Method() {
    // Arrange and Act
    MethodDescriptor<VoteWitnessContract, TransactionExtention> actualVoteWitnessAccount2Method = WalletGrpc
        .getVoteWitnessAccount2Method();

    // Assert
    assertEquals("VoteWitnessAccount2", actualVoteWitnessAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/VoteWitnessAccount2", actualVoteWitnessAccount2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualVoteWitnessAccount2Method.getType());
    assertFalse(actualVoteWitnessAccount2Method.isIdempotent());
    assertFalse(actualVoteWitnessAccount2Method.isSafe());
    assertTrue(actualVoteWitnessAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualVoteWitnessAccount2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateAssetIssueMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateAssetIssueMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateAssetIssueMethod()"})
  public void testGetCreateAssetIssueMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContract, Transaction> actualCreateAssetIssueMethod = WalletGrpc
        .getCreateAssetIssueMethod();

    // Assert
    assertEquals("CreateAssetIssue", actualCreateAssetIssueMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAssetIssue", actualCreateAssetIssueMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateAssetIssueMethod.getType());
    assertFalse(actualCreateAssetIssueMethod.isIdempotent());
    assertFalse(actualCreateAssetIssueMethod.isSafe());
    assertTrue(actualCreateAssetIssueMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAssetIssueMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateAssetIssue2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateAssetIssue2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateAssetIssue2Method()"})
  public void testGetCreateAssetIssue2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContract, TransactionExtention> actualCreateAssetIssue2Method = WalletGrpc
        .getCreateAssetIssue2Method();

    // Assert
    assertEquals("CreateAssetIssue2", actualCreateAssetIssue2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAssetIssue2", actualCreateAssetIssue2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateAssetIssue2Method.getType());
    assertFalse(actualCreateAssetIssue2Method.isIdempotent());
    assertFalse(actualCreateAssetIssue2Method.isSafe());
    assertTrue(actualCreateAssetIssue2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAssetIssue2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateWitnessMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateWitnessMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateWitnessMethod()"})
  public void testGetUpdateWitnessMethod() {
    // Arrange and Act
    MethodDescriptor<WitnessUpdateContract, Transaction> actualUpdateWitnessMethod = WalletGrpc
        .getUpdateWitnessMethod();

    // Assert
    assertEquals("UpdateWitness", actualUpdateWitnessMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateWitness", actualUpdateWitnessMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateWitnessMethod.getType());
    assertFalse(actualUpdateWitnessMethod.isIdempotent());
    assertFalse(actualUpdateWitnessMethod.isSafe());
    assertTrue(actualUpdateWitnessMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateWitnessMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateWitness2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateWitness2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateWitness2Method()"})
  public void testGetUpdateWitness2Method() {
    // Arrange and Act
    MethodDescriptor<WitnessUpdateContract, TransactionExtention> actualUpdateWitness2Method = WalletGrpc
        .getUpdateWitness2Method();

    // Assert
    assertEquals("UpdateWitness2", actualUpdateWitness2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateWitness2", actualUpdateWitness2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateWitness2Method.getType());
    assertFalse(actualUpdateWitness2Method.isIdempotent());
    assertFalse(actualUpdateWitness2Method.isSafe());
    assertTrue(actualUpdateWitness2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateWitness2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateAccountMethod()"})
  public void testGetCreateAccountMethod() {
    // Arrange and Act
    MethodDescriptor<AccountCreateContract, Transaction> actualCreateAccountMethod = WalletGrpc
        .getCreateAccountMethod();

    // Assert
    assertEquals("CreateAccount", actualCreateAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAccount", actualCreateAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateAccountMethod.getType());
    assertFalse(actualCreateAccountMethod.isIdempotent());
    assertFalse(actualCreateAccountMethod.isSafe());
    assertTrue(actualCreateAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateAccount2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateAccount2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateAccount2Method()"})
  public void testGetCreateAccount2Method() {
    // Arrange and Act
    MethodDescriptor<AccountCreateContract, TransactionExtention> actualCreateAccount2Method = WalletGrpc
        .getCreateAccount2Method();

    // Assert
    assertEquals("CreateAccount2", actualCreateAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAccount2", actualCreateAccount2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateAccount2Method.getType());
    assertFalse(actualCreateAccount2Method.isIdempotent());
    assertFalse(actualCreateAccount2Method.isSafe());
    assertTrue(actualCreateAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAccount2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateWitnessMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateWitnessMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateWitnessMethod()"})
  public void testGetCreateWitnessMethod() {
    // Arrange and Act
    MethodDescriptor<WitnessCreateContract, Transaction> actualCreateWitnessMethod = WalletGrpc
        .getCreateWitnessMethod();

    // Assert
    assertEquals("CreateWitness", actualCreateWitnessMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateWitness", actualCreateWitnessMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateWitnessMethod.getType());
    assertFalse(actualCreateWitnessMethod.isIdempotent());
    assertFalse(actualCreateWitnessMethod.isSafe());
    assertTrue(actualCreateWitnessMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateWitnessMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateWitness2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateWitness2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateWitness2Method()"})
  public void testGetCreateWitness2Method() {
    // Arrange and Act
    MethodDescriptor<WitnessCreateContract, TransactionExtention> actualCreateWitness2Method = WalletGrpc
        .getCreateWitness2Method();

    // Assert
    assertEquals("CreateWitness2", actualCreateWitness2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateWitness2", actualCreateWitness2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateWitness2Method.getType());
    assertFalse(actualCreateWitness2Method.isIdempotent());
    assertFalse(actualCreateWitness2Method.isSafe());
    assertTrue(actualCreateWitness2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateWitness2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getTransferAssetMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getTransferAssetMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getTransferAssetMethod()"})
  public void testGetTransferAssetMethod() {
    // Arrange and Act
    MethodDescriptor<TransferAssetContract, Transaction> actualTransferAssetMethod = WalletGrpc
        .getTransferAssetMethod();

    // Assert
    assertEquals("TransferAsset", actualTransferAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TransferAsset", actualTransferAssetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTransferAssetMethod.getType());
    assertFalse(actualTransferAssetMethod.isIdempotent());
    assertFalse(actualTransferAssetMethod.isSafe());
    assertTrue(actualTransferAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTransferAssetMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getTransferAsset2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getTransferAsset2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getTransferAsset2Method()"})
  public void testGetTransferAsset2Method() {
    // Arrange and Act
    MethodDescriptor<TransferAssetContract, TransactionExtention> actualTransferAsset2Method = WalletGrpc
        .getTransferAsset2Method();

    // Assert
    assertEquals("TransferAsset2", actualTransferAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/TransferAsset2", actualTransferAsset2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTransferAsset2Method.getType());
    assertFalse(actualTransferAsset2Method.isIdempotent());
    assertFalse(actualTransferAsset2Method.isSafe());
    assertTrue(actualTransferAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTransferAsset2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getParticipateAssetIssueMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getParticipateAssetIssueMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getParticipateAssetIssueMethod()"})
  public void testGetParticipateAssetIssueMethod() {
    // Arrange and Act
    MethodDescriptor<ParticipateAssetIssueContract, Transaction> actualParticipateAssetIssueMethod = WalletGrpc
        .getParticipateAssetIssueMethod();

    // Assert
    assertEquals("ParticipateAssetIssue", actualParticipateAssetIssueMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ParticipateAssetIssue", actualParticipateAssetIssueMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualParticipateAssetIssueMethod.getType());
    assertFalse(actualParticipateAssetIssueMethod.isIdempotent());
    assertFalse(actualParticipateAssetIssueMethod.isSafe());
    assertTrue(actualParticipateAssetIssueMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualParticipateAssetIssueMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getParticipateAssetIssue2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getParticipateAssetIssue2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getParticipateAssetIssue2Method()"})
  public void testGetParticipateAssetIssue2Method() {
    // Arrange and Act
    MethodDescriptor<ParticipateAssetIssueContract, TransactionExtention> actualParticipateAssetIssue2Method = WalletGrpc
        .getParticipateAssetIssue2Method();

    // Assert
    assertEquals("ParticipateAssetIssue2", actualParticipateAssetIssue2Method.getBareMethodName());
    assertEquals("protocol.Wallet/ParticipateAssetIssue2", actualParticipateAssetIssue2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualParticipateAssetIssue2Method.getType());
    assertFalse(actualParticipateAssetIssue2Method.isIdempotent());
    assertFalse(actualParticipateAssetIssue2Method.isSafe());
    assertTrue(actualParticipateAssetIssue2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualParticipateAssetIssue2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getFreezeBalanceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getFreezeBalanceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getFreezeBalanceMethod()"})
  public void testGetFreezeBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<FreezeBalanceContract, Transaction> actualFreezeBalanceMethod = WalletGrpc
        .getFreezeBalanceMethod();

    // Assert
    assertEquals("FreezeBalance", actualFreezeBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalance", actualFreezeBalanceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualFreezeBalanceMethod.getType());
    assertFalse(actualFreezeBalanceMethod.isIdempotent());
    assertFalse(actualFreezeBalanceMethod.isSafe());
    assertTrue(actualFreezeBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalanceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getFreezeBalance2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getFreezeBalance2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getFreezeBalance2Method()"})
  public void testGetFreezeBalance2Method() {
    // Arrange and Act
    MethodDescriptor<FreezeBalanceContract, TransactionExtention> actualFreezeBalance2Method = WalletGrpc
        .getFreezeBalance2Method();

    // Assert
    assertEquals("FreezeBalance2", actualFreezeBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalance2", actualFreezeBalance2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualFreezeBalance2Method.getType());
    assertFalse(actualFreezeBalance2Method.isIdempotent());
    assertFalse(actualFreezeBalance2Method.isSafe());
    assertTrue(actualFreezeBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalance2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getFreezeBalanceV2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getFreezeBalanceV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getFreezeBalanceV2Method()"})
  public void testGetFreezeBalanceV2Method() {
    // Arrange and Act
    MethodDescriptor<FreezeBalanceV2Contract, TransactionExtention> actualFreezeBalanceV2Method = WalletGrpc
        .getFreezeBalanceV2Method();

    // Assert
    assertEquals("FreezeBalanceV2", actualFreezeBalanceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalanceV2", actualFreezeBalanceV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualFreezeBalanceV2Method.getType());
    assertFalse(actualFreezeBalanceV2Method.isIdempotent());
    assertFalse(actualFreezeBalanceV2Method.isSafe());
    assertTrue(actualFreezeBalanceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalanceV2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnfreezeBalanceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnfreezeBalanceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnfreezeBalanceMethod()"})
  public void testGetUnfreezeBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<UnfreezeBalanceContract, Transaction> actualUnfreezeBalanceMethod = WalletGrpc
        .getUnfreezeBalanceMethod();

    // Assert
    assertEquals("UnfreezeBalance", actualUnfreezeBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalance", actualUnfreezeBalanceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnfreezeBalanceMethod.getType());
    assertFalse(actualUnfreezeBalanceMethod.isIdempotent());
    assertFalse(actualUnfreezeBalanceMethod.isSafe());
    assertTrue(actualUnfreezeBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalanceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnfreezeBalance2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnfreezeBalance2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnfreezeBalance2Method()"})
  public void testGetUnfreezeBalance2Method() {
    // Arrange and Act
    MethodDescriptor<UnfreezeBalanceContract, TransactionExtention> actualUnfreezeBalance2Method = WalletGrpc
        .getUnfreezeBalance2Method();

    // Assert
    assertEquals("UnfreezeBalance2", actualUnfreezeBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalance2", actualUnfreezeBalance2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnfreezeBalance2Method.getType());
    assertFalse(actualUnfreezeBalance2Method.isIdempotent());
    assertFalse(actualUnfreezeBalance2Method.isSafe());
    assertTrue(actualUnfreezeBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalance2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnfreezeBalanceV2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnfreezeBalanceV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnfreezeBalanceV2Method()"})
  public void testGetUnfreezeBalanceV2Method() {
    // Arrange and Act
    MethodDescriptor<UnfreezeBalanceV2Contract, TransactionExtention> actualUnfreezeBalanceV2Method = WalletGrpc
        .getUnfreezeBalanceV2Method();

    // Assert
    assertEquals("UnfreezeBalanceV2", actualUnfreezeBalanceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalanceV2", actualUnfreezeBalanceV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnfreezeBalanceV2Method.getType());
    assertFalse(actualUnfreezeBalanceV2Method.isIdempotent());
    assertFalse(actualUnfreezeBalanceV2Method.isSafe());
    assertTrue(actualUnfreezeBalanceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalanceV2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnfreezeAssetMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnfreezeAssetMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnfreezeAssetMethod()"})
  public void testGetUnfreezeAssetMethod() {
    // Arrange and Act
    MethodDescriptor<UnfreezeAssetContract, Transaction> actualUnfreezeAssetMethod = WalletGrpc
        .getUnfreezeAssetMethod();

    // Assert
    assertEquals("UnfreezeAsset", actualUnfreezeAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeAsset", actualUnfreezeAssetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnfreezeAssetMethod.getType());
    assertFalse(actualUnfreezeAssetMethod.isIdempotent());
    assertFalse(actualUnfreezeAssetMethod.isSafe());
    assertTrue(actualUnfreezeAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeAssetMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnfreezeAsset2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnfreezeAsset2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnfreezeAsset2Method()"})
  public void testGetUnfreezeAsset2Method() {
    // Arrange and Act
    MethodDescriptor<UnfreezeAssetContract, TransactionExtention> actualUnfreezeAsset2Method = WalletGrpc
        .getUnfreezeAsset2Method();

    // Assert
    assertEquals("UnfreezeAsset2", actualUnfreezeAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeAsset2", actualUnfreezeAsset2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnfreezeAsset2Method.getType());
    assertFalse(actualUnfreezeAsset2Method.isIdempotent());
    assertFalse(actualUnfreezeAsset2Method.isSafe());
    assertTrue(actualUnfreezeAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeAsset2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getWithdrawBalanceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getWithdrawBalanceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getWithdrawBalanceMethod()"})
  public void testGetWithdrawBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<WithdrawBalanceContract, Transaction> actualWithdrawBalanceMethod = WalletGrpc
        .getWithdrawBalanceMethod();

    // Assert
    assertEquals("WithdrawBalance", actualWithdrawBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawBalance", actualWithdrawBalanceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualWithdrawBalanceMethod.getType());
    assertFalse(actualWithdrawBalanceMethod.isIdempotent());
    assertFalse(actualWithdrawBalanceMethod.isSafe());
    assertTrue(actualWithdrawBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawBalanceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getWithdrawBalance2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getWithdrawBalance2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getWithdrawBalance2Method()"})
  public void testGetWithdrawBalance2Method() {
    // Arrange and Act
    MethodDescriptor<WithdrawBalanceContract, TransactionExtention> actualWithdrawBalance2Method = WalletGrpc
        .getWithdrawBalance2Method();

    // Assert
    assertEquals("WithdrawBalance2", actualWithdrawBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawBalance2", actualWithdrawBalance2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualWithdrawBalance2Method.getType());
    assertFalse(actualWithdrawBalance2Method.isIdempotent());
    assertFalse(actualWithdrawBalance2Method.isSafe());
    assertTrue(actualWithdrawBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawBalance2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getWithdrawExpireUnfreezeMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getWithdrawExpireUnfreezeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getWithdrawExpireUnfreezeMethod()"})
  public void testGetWithdrawExpireUnfreezeMethod() {
    // Arrange and Act
    MethodDescriptor<WithdrawExpireUnfreezeContract, TransactionExtention> actualWithdrawExpireUnfreezeMethod = WalletGrpc
        .getWithdrawExpireUnfreezeMethod();

    // Assert
    assertEquals("WithdrawExpireUnfreeze", actualWithdrawExpireUnfreezeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawExpireUnfreeze", actualWithdrawExpireUnfreezeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualWithdrawExpireUnfreezeMethod.getType());
    assertFalse(actualWithdrawExpireUnfreezeMethod.isIdempotent());
    assertFalse(actualWithdrawExpireUnfreezeMethod.isSafe());
    assertTrue(actualWithdrawExpireUnfreezeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawExpireUnfreezeMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getDelegateResourceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getDelegateResourceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getDelegateResourceMethod()"})
  public void testGetDelegateResourceMethod() {
    // Arrange and Act
    MethodDescriptor<DelegateResourceContract, TransactionExtention> actualDelegateResourceMethod = WalletGrpc
        .getDelegateResourceMethod();

    // Assert
    assertEquals("DelegateResource", actualDelegateResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/DelegateResource", actualDelegateResourceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualDelegateResourceMethod.getType());
    assertFalse(actualDelegateResourceMethod.isIdempotent());
    assertFalse(actualDelegateResourceMethod.isSafe());
    assertTrue(actualDelegateResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualDelegateResourceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUnDelegateResourceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUnDelegateResourceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUnDelegateResourceMethod()"})
  public void testGetUnDelegateResourceMethod() {
    // Arrange and Act
    MethodDescriptor<UnDelegateResourceContract, TransactionExtention> actualUnDelegateResourceMethod = WalletGrpc
        .getUnDelegateResourceMethod();

    // Assert
    assertEquals("UnDelegateResource", actualUnDelegateResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnDelegateResource", actualUnDelegateResourceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUnDelegateResourceMethod.getType());
    assertFalse(actualUnDelegateResourceMethod.isIdempotent());
    assertFalse(actualUnDelegateResourceMethod.isSafe());
    assertTrue(actualUnDelegateResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnDelegateResourceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCancelAllUnfreezeV2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCancelAllUnfreezeV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCancelAllUnfreezeV2Method()"})
  public void testGetCancelAllUnfreezeV2Method() {
    // Arrange and Act
    MethodDescriptor<CancelAllUnfreezeV2Contract, TransactionExtention> actualCancelAllUnfreezeV2Method = WalletGrpc
        .getCancelAllUnfreezeV2Method();

    // Assert
    assertEquals("CancelAllUnfreezeV2", actualCancelAllUnfreezeV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CancelAllUnfreezeV2", actualCancelAllUnfreezeV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCancelAllUnfreezeV2Method.getType());
    assertFalse(actualCancelAllUnfreezeV2Method.isIdempotent());
    assertFalse(actualCancelAllUnfreezeV2Method.isSafe());
    assertTrue(actualCancelAllUnfreezeV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCancelAllUnfreezeV2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateAssetMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateAssetMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateAssetMethod()"})
  public void testGetUpdateAssetMethod() {
    // Arrange and Act
    MethodDescriptor<UpdateAssetContract, Transaction> actualUpdateAssetMethod = WalletGrpc.getUpdateAssetMethod();

    // Assert
    assertEquals("UpdateAsset", actualUpdateAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAsset", actualUpdateAssetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateAssetMethod.getType());
    assertFalse(actualUpdateAssetMethod.isIdempotent());
    assertFalse(actualUpdateAssetMethod.isSafe());
    assertTrue(actualUpdateAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAssetMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateAsset2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateAsset2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateAsset2Method()"})
  public void testGetUpdateAsset2Method() {
    // Arrange and Act
    MethodDescriptor<UpdateAssetContract, TransactionExtention> actualUpdateAsset2Method = WalletGrpc
        .getUpdateAsset2Method();

    // Assert
    assertEquals("UpdateAsset2", actualUpdateAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAsset2", actualUpdateAsset2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateAsset2Method.getType());
    assertFalse(actualUpdateAsset2Method.isIdempotent());
    assertFalse(actualUpdateAsset2Method.isSafe());
    assertTrue(actualUpdateAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAsset2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getProposalCreateMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getProposalCreateMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getProposalCreateMethod()"})
  public void testGetProposalCreateMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalCreateContract, TransactionExtention> actualProposalCreateMethod = WalletGrpc
        .getProposalCreateMethod();

    // Assert
    assertEquals("ProposalCreate", actualProposalCreateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalCreate", actualProposalCreateMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualProposalCreateMethod.getType());
    assertFalse(actualProposalCreateMethod.isIdempotent());
    assertFalse(actualProposalCreateMethod.isSafe());
    assertTrue(actualProposalCreateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalCreateMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getProposalApproveMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getProposalApproveMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getProposalApproveMethod()"})
  public void testGetProposalApproveMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalApproveContract, TransactionExtention> actualProposalApproveMethod = WalletGrpc
        .getProposalApproveMethod();

    // Assert
    assertEquals("ProposalApprove", actualProposalApproveMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalApprove", actualProposalApproveMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualProposalApproveMethod.getType());
    assertFalse(actualProposalApproveMethod.isIdempotent());
    assertFalse(actualProposalApproveMethod.isSafe());
    assertTrue(actualProposalApproveMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalApproveMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getProposalDeleteMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getProposalDeleteMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getProposalDeleteMethod()"})
  public void testGetProposalDeleteMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalDeleteContract, TransactionExtention> actualProposalDeleteMethod = WalletGrpc
        .getProposalDeleteMethod();

    // Assert
    assertEquals("ProposalDelete", actualProposalDeleteMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalDelete", actualProposalDeleteMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualProposalDeleteMethod.getType());
    assertFalse(actualProposalDeleteMethod.isIdempotent());
    assertFalse(actualProposalDeleteMethod.isSafe());
    assertTrue(actualProposalDeleteMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalDeleteMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getBuyStorageMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getBuyStorageMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getBuyStorageMethod()"})
  public void testGetBuyStorageMethod() {
    // Arrange and Act
    MethodDescriptor<BuyStorageContract, TransactionExtention> actualBuyStorageMethod = WalletGrpc
        .getBuyStorageMethod();

    // Assert
    assertEquals("BuyStorage", actualBuyStorageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BuyStorage", actualBuyStorageMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualBuyStorageMethod.getType());
    assertFalse(actualBuyStorageMethod.isIdempotent());
    assertFalse(actualBuyStorageMethod.isSafe());
    assertTrue(actualBuyStorageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBuyStorageMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getBuyStorageBytesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getBuyStorageBytesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getBuyStorageBytesMethod()"})
  public void testGetBuyStorageBytesMethod() {
    // Arrange and Act
    MethodDescriptor<BuyStorageBytesContract, TransactionExtention> actualBuyStorageBytesMethod = WalletGrpc
        .getBuyStorageBytesMethod();

    // Assert
    assertEquals("BuyStorageBytes", actualBuyStorageBytesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BuyStorageBytes", actualBuyStorageBytesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualBuyStorageBytesMethod.getType());
    assertFalse(actualBuyStorageBytesMethod.isIdempotent());
    assertFalse(actualBuyStorageBytesMethod.isSafe());
    assertTrue(actualBuyStorageBytesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBuyStorageBytesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getSellStorageMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getSellStorageMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getSellStorageMethod()"})
  public void testGetSellStorageMethod() {
    // Arrange and Act
    MethodDescriptor<SellStorageContract, TransactionExtention> actualSellStorageMethod = WalletGrpc
        .getSellStorageMethod();

    // Assert
    assertEquals("SellStorage", actualSellStorageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/SellStorage", actualSellStorageMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualSellStorageMethod.getType());
    assertFalse(actualSellStorageMethod.isIdempotent());
    assertFalse(actualSellStorageMethod.isSafe());
    assertTrue(actualSellStorageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualSellStorageMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getExchangeCreateMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getExchangeCreateMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getExchangeCreateMethod()"})
  public void testGetExchangeCreateMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeCreateContract, TransactionExtention> actualExchangeCreateMethod = WalletGrpc
        .getExchangeCreateMethod();

    // Assert
    assertEquals("ExchangeCreate", actualExchangeCreateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeCreate", actualExchangeCreateMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualExchangeCreateMethod.getType());
    assertFalse(actualExchangeCreateMethod.isIdempotent());
    assertFalse(actualExchangeCreateMethod.isSafe());
    assertTrue(actualExchangeCreateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeCreateMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getExchangeInjectMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getExchangeInjectMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getExchangeInjectMethod()"})
  public void testGetExchangeInjectMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeInjectContract, TransactionExtention> actualExchangeInjectMethod = WalletGrpc
        .getExchangeInjectMethod();

    // Assert
    assertEquals("ExchangeInject", actualExchangeInjectMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeInject", actualExchangeInjectMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualExchangeInjectMethod.getType());
    assertFalse(actualExchangeInjectMethod.isIdempotent());
    assertFalse(actualExchangeInjectMethod.isSafe());
    assertTrue(actualExchangeInjectMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeInjectMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getExchangeWithdrawMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getExchangeWithdrawMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getExchangeWithdrawMethod()"})
  public void testGetExchangeWithdrawMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeWithdrawContract, TransactionExtention> actualExchangeWithdrawMethod = WalletGrpc
        .getExchangeWithdrawMethod();

    // Assert
    assertEquals("ExchangeWithdraw", actualExchangeWithdrawMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeWithdraw", actualExchangeWithdrawMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualExchangeWithdrawMethod.getType());
    assertFalse(actualExchangeWithdrawMethod.isIdempotent());
    assertFalse(actualExchangeWithdrawMethod.isSafe());
    assertTrue(actualExchangeWithdrawMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeWithdrawMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getExchangeTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getExchangeTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getExchangeTransactionMethod()"})
  public void testGetExchangeTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeTransactionContract, TransactionExtention> actualExchangeTransactionMethod = WalletGrpc
        .getExchangeTransactionMethod();

    // Assert
    assertEquals("ExchangeTransaction", actualExchangeTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeTransaction", actualExchangeTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualExchangeTransactionMethod.getType());
    assertFalse(actualExchangeTransactionMethod.isIdempotent());
    assertFalse(actualExchangeTransactionMethod.isSafe());
    assertTrue(actualExchangeTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getMarketSellAssetMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getMarketSellAssetMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getMarketSellAssetMethod()"})
  public void testGetMarketSellAssetMethod() {
    // Arrange and Act
    MethodDescriptor<MarketSellAssetContract, TransactionExtention> actualMarketSellAssetMethod = WalletGrpc
        .getMarketSellAssetMethod();

    // Assert
    assertEquals("MarketSellAsset", actualMarketSellAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/MarketSellAsset", actualMarketSellAssetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualMarketSellAssetMethod.getType());
    assertFalse(actualMarketSellAssetMethod.isIdempotent());
    assertFalse(actualMarketSellAssetMethod.isSafe());
    assertTrue(actualMarketSellAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualMarketSellAssetMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getMarketCancelOrderMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getMarketCancelOrderMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getMarketCancelOrderMethod()"})
  public void testGetMarketCancelOrderMethod() {
    // Arrange and Act
    MethodDescriptor<MarketCancelOrderContract, TransactionExtention> actualMarketCancelOrderMethod = WalletGrpc
        .getMarketCancelOrderMethod();

    // Assert
    assertEquals("MarketCancelOrder", actualMarketCancelOrderMethod.getBareMethodName());
    assertEquals("protocol.Wallet/MarketCancelOrder", actualMarketCancelOrderMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualMarketCancelOrderMethod.getType());
    assertFalse(actualMarketCancelOrderMethod.isIdempotent());
    assertFalse(actualMarketCancelOrderMethod.isSafe());
    assertTrue(actualMarketCancelOrderMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualMarketCancelOrderMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMarketOrderByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMarketOrderByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMarketOrderByIdMethod()"})
  public void testGetGetMarketOrderByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, MarketOrder> actualGetMarketOrderByIdMethod = WalletGrpc
        .getGetMarketOrderByIdMethod();

    // Assert
    assertEquals("GetMarketOrderById", actualGetMarketOrderByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderById", actualGetMarketOrderByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderByIdMethod.getType());
    assertFalse(actualGetMarketOrderByIdMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByIdMethod.isSafe());
    assertTrue(actualGetMarketOrderByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMarketOrderByAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMarketOrderByAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMarketOrderByAccountMethod()"})
  public void testGetGetMarketOrderByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, MarketOrderList> actualGetMarketOrderByAccountMethod = WalletGrpc
        .getGetMarketOrderByAccountMethod();

    // Assert
    assertEquals("GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderByAccountMethod.getType());
    assertFalse(actualGetMarketOrderByAccountMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByAccountMethod.isSafe());
    assertTrue(actualGetMarketOrderByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderByAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMarketPriceByPairMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMarketPriceByPairMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMarketPriceByPairMethod()"})
  public void testGetGetMarketPriceByPairMethod() {
    // Arrange and Act
    MethodDescriptor<MarketOrderPair, MarketPriceList> actualGetMarketPriceByPairMethod = WalletGrpc
        .getGetMarketPriceByPairMethod();

    // Assert
    assertEquals("GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketPriceByPairMethod.getType());
    assertFalse(actualGetMarketPriceByPairMethod.isIdempotent());
    assertFalse(actualGetMarketPriceByPairMethod.isSafe());
    assertTrue(actualGetMarketPriceByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketPriceByPairMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMarketOrderListByPairMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMarketOrderListByPairMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMarketOrderListByPairMethod()"})
  public void testGetGetMarketOrderListByPairMethod() {
    // Arrange and Act
    MethodDescriptor<MarketOrderPair, MarketOrderList> actualGetMarketOrderListByPairMethod = WalletGrpc
        .getGetMarketOrderListByPairMethod();

    // Assert
    assertEquals("GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketOrderListByPairMethod.getType());
    assertFalse(actualGetMarketOrderListByPairMethod.isIdempotent());
    assertFalse(actualGetMarketOrderListByPairMethod.isSafe());
    assertTrue(actualGetMarketOrderListByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderListByPairMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMarketPairListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMarketPairListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMarketPairListMethod()"})
  public void testGetGetMarketPairListMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, MarketOrderPairList> actualGetMarketPairListMethod = WalletGrpc
        .getGetMarketPairListMethod();

    // Assert
    assertEquals("GetMarketPairList", actualGetMarketPairListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketPairList", actualGetMarketPairListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMarketPairListMethod.getType());
    assertFalse(actualGetMarketPairListMethod.isIdempotent());
    assertFalse(actualGetMarketPairListMethod.isSafe());
    assertTrue(actualGetMarketPairListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketPairListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getListNodesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getListNodesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getListNodesMethod()"})
  public void testGetListNodesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NodeList> actualListNodesMethod = WalletGrpc.getListNodesMethod();

    // Assert
    assertEquals("ListNodes", actualListNodesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListNodes", actualListNodesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListNodesMethod.getType());
    assertFalse(actualListNodesMethod.isIdempotent());
    assertFalse(actualListNodesMethod.isSafe());
    assertTrue(actualListNodesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListNodesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAssetIssueByAccountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAssetIssueByAccountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAssetIssueByAccountMethod()"})
  public void testGetGetAssetIssueByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Account, AssetIssueList> actualGetAssetIssueByAccountMethod = WalletGrpc
        .getGetAssetIssueByAccountMethod();

    // Assert
    assertEquals("GetAssetIssueByAccount", actualGetAssetIssueByAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueByAccount", actualGetAssetIssueByAccountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueByAccountMethod.getType());
    assertFalse(actualGetAssetIssueByAccountMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByAccountMethod.isSafe());
    assertTrue(actualGetAssetIssueByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByAccountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAccountNetMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAccountNetMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAccountNetMethod()"})
  public void testGetGetAccountNetMethod() {
    // Arrange and Act
    MethodDescriptor<Account, AccountNetMessage> actualGetAccountNetMethod = WalletGrpc.getGetAccountNetMethod();

    // Assert
    assertEquals("GetAccountNet", actualGetAccountNetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountNet", actualGetAccountNetMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountNetMethod.getType());
    assertFalse(actualGetAccountNetMethod.isIdempotent());
    assertFalse(actualGetAccountNetMethod.isSafe());
    assertTrue(actualGetAccountNetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountNetMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAccountResourceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAccountResourceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAccountResourceMethod()"})
  public void testGetGetAccountResourceMethod() {
    // Arrange and Act
    MethodDescriptor<Account, AccountResourceMessage> actualGetAccountResourceMethod = WalletGrpc
        .getGetAccountResourceMethod();

    // Assert
    assertEquals("GetAccountResource", actualGetAccountResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountResource", actualGetAccountResourceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAccountResourceMethod.getType());
    assertFalse(actualGetAccountResourceMethod.isIdempotent());
    assertFalse(actualGetAccountResourceMethod.isSafe());
    assertTrue(actualGetAccountResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountResourceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAssetIssueByNameMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAssetIssueByNameMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAssetIssueByNameMethod()"})
  public void testGetGetAssetIssueByNameMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueContract> actualGetAssetIssueByNameMethod = WalletGrpc
        .getGetAssetIssueByNameMethod();

    // Assert
    assertEquals("GetAssetIssueByName", actualGetAssetIssueByNameMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueByName", actualGetAssetIssueByNameMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueByNameMethod.getType());
    assertFalse(actualGetAssetIssueByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByNameMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAssetIssueListByNameMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAssetIssueListByNameMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAssetIssueListByNameMethod()"})
  public void testGetGetAssetIssueListByNameMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueList> actualGetAssetIssueListByNameMethod = WalletGrpc
        .getGetAssetIssueListByNameMethod();

    // Assert
    assertEquals("GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueListByNameMethod.getType());
    assertFalse(actualGetAssetIssueListByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueListByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueListByNameMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAssetIssueByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAssetIssueByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAssetIssueByIdMethod()"})
  public void testGetGetAssetIssueByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, AssetIssueContract> actualGetAssetIssueByIdMethod = WalletGrpc
        .getGetAssetIssueByIdMethod();

    // Assert
    assertEquals("GetAssetIssueById", actualGetAssetIssueByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueById", actualGetAssetIssueByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueByIdMethod.getType());
    assertFalse(actualGetAssetIssueByIdMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByIdMethod.isSafe());
    assertTrue(actualGetAssetIssueByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNowBlockMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNowBlockMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNowBlockMethod()"})
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, Block> actualGetNowBlockMethod = WalletGrpc.getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNowBlock2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNowBlock2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNowBlock2Method()"})
  public void testGetGetNowBlock2Method() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, BlockExtention> actualGetNowBlock2Method = WalletGrpc.getGetNowBlock2Method();

    // Assert
    assertEquals("GetNowBlock2", actualGetNowBlock2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetNowBlock2", actualGetNowBlock2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNowBlock2Method.getType());
    assertFalse(actualGetNowBlock2Method.isIdempotent());
    assertFalse(actualGetNowBlock2Method.isSafe());
    assertTrue(actualGetNowBlock2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNowBlock2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByNumMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByNumMethod()"})
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, Block> actualGetBlockByNumMethod = WalletGrpc.getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByNum2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByNum2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByNum2Method()"})
  public void testGetGetBlockByNum2Method() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, BlockExtention> actualGetBlockByNum2Method = WalletGrpc.getGetBlockByNum2Method();

    // Assert
    assertEquals("GetBlockByNum2", actualGetBlockByNum2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByNum2", actualGetBlockByNum2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByNum2Method.getType());
    assertFalse(actualGetBlockByNum2Method.isIdempotent());
    assertFalse(actualGetBlockByNum2Method.isSafe());
    assertTrue(actualGetBlockByNum2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByNum2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionCountByBlockNumMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionCountByBlockNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionCountByBlockNumMethod()"})
  public void testGetGetTransactionCountByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, NumberMessage> actualGetTransactionCountByBlockNumMethod = WalletGrpc
        .getGetTransactionCountByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionCountByBlockNum", actualGetTransactionCountByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionCountByBlockNum",
        actualGetTransactionCountByBlockNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionCountByBlockNumMethod.getType());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionCountByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionCountByBlockNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByIdMethod()"})
  public void testGetGetBlockByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Block> actualGetBlockByIdMethod = WalletGrpc.getGetBlockByIdMethod();

    // Assert
    assertEquals("GetBlockById", actualGetBlockByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockById", actualGetBlockByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByIdMethod.getType());
    assertFalse(actualGetBlockByIdMethod.isIdempotent());
    assertFalse(actualGetBlockByIdMethod.isSafe());
    assertTrue(actualGetBlockByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByLimitNextMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByLimitNextMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByLimitNextMethod()"})
  public void testGetGetBlockByLimitNextMethod() {
    // Arrange and Act
    MethodDescriptor<BlockLimit, BlockList> actualGetBlockByLimitNextMethod = WalletGrpc.getGetBlockByLimitNextMethod();

    // Assert
    assertEquals("GetBlockByLimitNext", actualGetBlockByLimitNextMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLimitNext", actualGetBlockByLimitNextMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByLimitNextMethod.getType());
    assertFalse(actualGetBlockByLimitNextMethod.isIdempotent());
    assertFalse(actualGetBlockByLimitNextMethod.isSafe());
    assertTrue(actualGetBlockByLimitNextMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLimitNextMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByLimitNext2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByLimitNext2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByLimitNext2Method()"})
  public void testGetGetBlockByLimitNext2Method() {
    // Arrange and Act
    MethodDescriptor<BlockLimit, BlockListExtention> actualGetBlockByLimitNext2Method = WalletGrpc
        .getGetBlockByLimitNext2Method();

    // Assert
    assertEquals("GetBlockByLimitNext2", actualGetBlockByLimitNext2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLimitNext2", actualGetBlockByLimitNext2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByLimitNext2Method.getType());
    assertFalse(actualGetBlockByLimitNext2Method.isIdempotent());
    assertFalse(actualGetBlockByLimitNext2Method.isSafe());
    assertTrue(actualGetBlockByLimitNext2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLimitNext2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByLatestNumMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByLatestNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByLatestNumMethod()"})
  public void testGetGetBlockByLatestNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, BlockList> actualGetBlockByLatestNumMethod = WalletGrpc
        .getGetBlockByLatestNumMethod();

    // Assert
    assertEquals("GetBlockByLatestNum", actualGetBlockByLatestNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLatestNum", actualGetBlockByLatestNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByLatestNumMethod.getType());
    assertFalse(actualGetBlockByLatestNumMethod.isIdempotent());
    assertFalse(actualGetBlockByLatestNumMethod.isSafe());
    assertTrue(actualGetBlockByLatestNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLatestNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockByLatestNum2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockByLatestNum2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockByLatestNum2Method()"})
  public void testGetGetBlockByLatestNum2Method() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, BlockListExtention> actualGetBlockByLatestNum2Method = WalletGrpc
        .getGetBlockByLatestNum2Method();

    // Assert
    assertEquals("GetBlockByLatestNum2", actualGetBlockByLatestNum2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLatestNum2", actualGetBlockByLatestNum2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByLatestNum2Method.getType());
    assertFalse(actualGetBlockByLatestNum2Method.isIdempotent());
    assertFalse(actualGetBlockByLatestNum2Method.isSafe());
    assertTrue(actualGetBlockByLatestNum2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLatestNum2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionByIdMethod()"})
  public void testGetGetTransactionByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Transaction> actualGetTransactionByIdMethod = WalletGrpc
        .getGetTransactionByIdMethod();

    // Assert
    assertEquals("GetTransactionById", actualGetTransactionByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionById", actualGetTransactionByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionByIdMethod.getType());
    assertFalse(actualGetTransactionByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionByIdMethod.isSafe());
    assertTrue(actualGetTransactionByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getDeployContractMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getDeployContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getDeployContractMethod()"})
  public void testGetDeployContractMethod() {
    // Arrange and Act
    MethodDescriptor<CreateSmartContract, TransactionExtention> actualDeployContractMethod = WalletGrpc
        .getDeployContractMethod();

    // Assert
    assertEquals("DeployContract", actualDeployContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/DeployContract", actualDeployContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualDeployContractMethod.getType());
    assertFalse(actualDeployContractMethod.isIdempotent());
    assertFalse(actualDeployContractMethod.isSafe());
    assertTrue(actualDeployContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualDeployContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetContractMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetContractMethod()"})
  public void testGetGetContractMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, SmartContract> actualGetContractMethod = WalletGrpc.getGetContractMethod();

    // Assert
    assertEquals("GetContract", actualGetContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetContract", actualGetContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetContractMethod.getType());
    assertFalse(actualGetContractMethod.isIdempotent());
    assertFalse(actualGetContractMethod.isSafe());
    assertTrue(actualGetContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetContractInfoMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetContractInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetContractInfoMethod()"})
  public void testGetGetContractInfoMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, SmartContractDataWrapper> actualGetContractInfoMethod = WalletGrpc
        .getGetContractInfoMethod();

    // Assert
    assertEquals("GetContractInfo", actualGetContractInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetContractInfo", actualGetContractInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetContractInfoMethod.getType());
    assertFalse(actualGetContractInfoMethod.isIdempotent());
    assertFalse(actualGetContractInfoMethod.isSafe());
    assertTrue(actualGetContractInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetContractInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getTriggerContractMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getTriggerContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getTriggerContractMethod()"})
  public void testGetTriggerContractMethod() {
    // Arrange and Act
    MethodDescriptor<TriggerSmartContract, TransactionExtention> actualTriggerContractMethod = WalletGrpc
        .getTriggerContractMethod();

    // Assert
    assertEquals("TriggerContract", actualTriggerContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TriggerContract", actualTriggerContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTriggerContractMethod.getType());
    assertFalse(actualTriggerContractMethod.isIdempotent());
    assertFalse(actualTriggerContractMethod.isSafe());
    assertTrue(actualTriggerContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTriggerContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getTriggerConstantContractMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getTriggerConstantContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getTriggerConstantContractMethod()"})
  public void testGetTriggerConstantContractMethod() {
    // Arrange and Act
    MethodDescriptor<TriggerSmartContract, TransactionExtention> actualTriggerConstantContractMethod = WalletGrpc
        .getTriggerConstantContractMethod();

    // Assert
    assertEquals("TriggerConstantContract", actualTriggerConstantContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TriggerConstantContract", actualTriggerConstantContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTriggerConstantContractMethod.getType());
    assertFalse(actualTriggerConstantContractMethod.isIdempotent());
    assertFalse(actualTriggerConstantContractMethod.isSafe());
    assertTrue(actualTriggerConstantContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTriggerConstantContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getEstimateEnergyMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getEstimateEnergyMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getEstimateEnergyMethod()"})
  public void testGetEstimateEnergyMethod() {
    // Arrange and Act
    MethodDescriptor<TriggerSmartContract, EstimateEnergyMessage> actualEstimateEnergyMethod = WalletGrpc
        .getEstimateEnergyMethod();

    // Assert
    assertEquals("EstimateEnergy", actualEstimateEnergyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/EstimateEnergy", actualEstimateEnergyMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualEstimateEnergyMethod.getType());
    assertFalse(actualEstimateEnergyMethod.isIdempotent());
    assertFalse(actualEstimateEnergyMethod.isSafe());
    assertTrue(actualEstimateEnergyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualEstimateEnergyMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getClearContractABIMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getClearContractABIMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getClearContractABIMethod()"})
  public void testGetClearContractABIMethod() {
    // Arrange and Act
    MethodDescriptor<ClearABIContract, TransactionExtention> actualClearContractABIMethod = WalletGrpc
        .getClearContractABIMethod();

    // Assert
    assertEquals("ClearContractABI", actualClearContractABIMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ClearContractABI", actualClearContractABIMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualClearContractABIMethod.getType());
    assertFalse(actualClearContractABIMethod.isIdempotent());
    assertFalse(actualClearContractABIMethod.isSafe());
    assertTrue(actualClearContractABIMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualClearContractABIMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getListWitnessesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getListWitnessesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getListWitnessesMethod()"})
  public void testGetListWitnessesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, WitnessList> actualListWitnessesMethod = WalletGrpc.getListWitnessesMethod();

    // Assert
    assertEquals("ListWitnesses", actualListWitnessesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListWitnesses", actualListWitnessesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListWitnessesMethod.getType());
    assertFalse(actualListWitnessesMethod.isIdempotent());
    assertFalse(actualListWitnessesMethod.isSafe());
    assertTrue(actualListWitnessesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListWitnessesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetDelegatedResourceMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetDelegatedResourceMethod()"})
  public void testGetGetDelegatedResourceMethod() {
    // Arrange and Act
    MethodDescriptor<DelegatedResourceMessage, DelegatedResourceList> actualGetDelegatedResourceMethod = WalletGrpc
        .getGetDelegatedResourceMethod();

    // Assert
    assertEquals("GetDelegatedResource", actualGetDelegatedResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResource", actualGetDelegatedResourceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceMethod.getType());
    assertFalse(actualGetDelegatedResourceMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceMethod.isSafe());
    assertTrue(actualGetDelegatedResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetDelegatedResourceV2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetDelegatedResourceV2Method()"})
  public void testGetGetDelegatedResourceV2Method() {
    // Arrange and Act
    MethodDescriptor<DelegatedResourceMessage, DelegatedResourceList> actualGetDelegatedResourceV2Method = WalletGrpc
        .getGetDelegatedResourceV2Method();

    // Assert
    assertEquals("GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceV2Method.getType());
    assertFalse(actualGetDelegatedResourceV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceV2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetDelegatedResourceAccountIndexMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceAccountIndexMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetDelegatedResourceAccountIndexMethod()"})
  public void testGetGetDelegatedResourceAccountIndexMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexMethod = WalletGrpc
        .getGetDelegatedResourceAccountIndexMethod();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndex", actualGetDelegatedResourceAccountIndexMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceAccountIndex",
        actualGetDelegatedResourceAccountIndexMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceAccountIndexMethod.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetDelegatedResourceAccountIndexV2Method()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceAccountIndexV2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetDelegatedResourceAccountIndexV2Method()"})
  public void testGetGetDelegatedResourceAccountIndexV2Method() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexV2Method = WalletGrpc
        .getGetDelegatedResourceAccountIndexV2Method();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDelegatedResourceAccountIndexV2Method.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexV2Method.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetCanDelegatedMaxSizeMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetCanDelegatedMaxSizeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetCanDelegatedMaxSizeMethod()"})
  public void testGetGetCanDelegatedMaxSizeMethod() {
    // Arrange and Act
    MethodDescriptor<CanDelegatedMaxSizeRequestMessage, CanDelegatedMaxSizeResponseMessage> actualGetCanDelegatedMaxSizeMethod = WalletGrpc
        .getGetCanDelegatedMaxSizeMethod();

    // Assert
    assertEquals("GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetCanDelegatedMaxSizeMethod.getType());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isIdempotent());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isSafe());
    assertTrue(actualGetCanDelegatedMaxSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetCanDelegatedMaxSizeMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAvailableUnfreezeCountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAvailableUnfreezeCountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAvailableUnfreezeCountMethod()"})
  public void testGetGetAvailableUnfreezeCountMethod() {
    // Arrange and Act
    MethodDescriptor<GetAvailableUnfreezeCountRequestMessage, GetAvailableUnfreezeCountResponseMessage> actualGetAvailableUnfreezeCountMethod = WalletGrpc
        .getGetAvailableUnfreezeCountMethod();

    // Assert
    assertEquals("GetAvailableUnfreezeCount", actualGetAvailableUnfreezeCountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAvailableUnfreezeCount",
        actualGetAvailableUnfreezeCountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAvailableUnfreezeCountMethod.getType());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isIdempotent());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isSafe());
    assertTrue(actualGetAvailableUnfreezeCountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAvailableUnfreezeCountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetCanWithdrawUnfreezeAmountMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetCanWithdrawUnfreezeAmountMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetCanWithdrawUnfreezeAmountMethod()"})
  public void testGetGetCanWithdrawUnfreezeAmountMethod() {
    // Arrange and Act
    MethodDescriptor<CanWithdrawUnfreezeAmountRequestMessage, CanWithdrawUnfreezeAmountResponseMessage> actualGetCanWithdrawUnfreezeAmountMethod = WalletGrpc
        .getGetCanWithdrawUnfreezeAmountMethod();

    // Assert
    assertEquals("GetCanWithdrawUnfreezeAmount", actualGetCanWithdrawUnfreezeAmountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetCanWithdrawUnfreezeAmount",
        actualGetCanWithdrawUnfreezeAmountMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetCanWithdrawUnfreezeAmountMethod.getType());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isIdempotent());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isSafe());
    assertTrue(actualGetCanWithdrawUnfreezeAmountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetCanWithdrawUnfreezeAmountMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getListProposalsMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getListProposalsMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getListProposalsMethod()"})
  public void testGetListProposalsMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, ProposalList> actualListProposalsMethod = WalletGrpc.getListProposalsMethod();

    // Assert
    assertEquals("ListProposals", actualListProposalsMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListProposals", actualListProposalsMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListProposalsMethod.getType());
    assertFalse(actualListProposalsMethod.isIdempotent());
    assertFalse(actualListProposalsMethod.isSafe());
    assertTrue(actualListProposalsMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListProposalsMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetPaginatedProposalListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetPaginatedProposalListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetPaginatedProposalListMethod()"})
  public void testGetGetPaginatedProposalListMethod() {
    // Arrange and Act
    MethodDescriptor<PaginatedMessage, ProposalList> actualGetPaginatedProposalListMethod = WalletGrpc
        .getGetPaginatedProposalListMethod();

    // Assert
    assertEquals("GetPaginatedProposalList", actualGetPaginatedProposalListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedProposalList", actualGetPaginatedProposalListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetPaginatedProposalListMethod.getType());
    assertFalse(actualGetPaginatedProposalListMethod.isIdempotent());
    assertFalse(actualGetPaginatedProposalListMethod.isSafe());
    assertTrue(actualGetPaginatedProposalListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedProposalListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetProposalByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetProposalByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetProposalByIdMethod()"})
  public void testGetGetProposalByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Proposal> actualGetProposalByIdMethod = WalletGrpc.getGetProposalByIdMethod();

    // Assert
    assertEquals("GetProposalById", actualGetProposalByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetProposalById", actualGetProposalByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetProposalByIdMethod.getType());
    assertFalse(actualGetProposalByIdMethod.isIdempotent());
    assertFalse(actualGetProposalByIdMethod.isSafe());
    assertTrue(actualGetProposalByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetProposalByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getListExchangesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getListExchangesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getListExchangesMethod()"})
  public void testGetListExchangesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, ExchangeList> actualListExchangesMethod = WalletGrpc.getListExchangesMethod();

    // Assert
    assertEquals("ListExchanges", actualListExchangesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListExchanges", actualListExchangesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualListExchangesMethod.getType());
    assertFalse(actualListExchangesMethod.isIdempotent());
    assertFalse(actualListExchangesMethod.isSafe());
    assertTrue(actualListExchangesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListExchangesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetPaginatedExchangeListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetPaginatedExchangeListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetPaginatedExchangeListMethod()"})
  public void testGetGetPaginatedExchangeListMethod() {
    // Arrange and Act
    MethodDescriptor<PaginatedMessage, ExchangeList> actualGetPaginatedExchangeListMethod = WalletGrpc
        .getGetPaginatedExchangeListMethod();

    // Assert
    assertEquals("GetPaginatedExchangeList", actualGetPaginatedExchangeListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedExchangeList", actualGetPaginatedExchangeListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetPaginatedExchangeListMethod.getType());
    assertFalse(actualGetPaginatedExchangeListMethod.isIdempotent());
    assertFalse(actualGetPaginatedExchangeListMethod.isSafe());
    assertTrue(actualGetPaginatedExchangeListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedExchangeListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetExchangeByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetExchangeByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetExchangeByIdMethod()"})
  public void testGetGetExchangeByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Exchange> actualGetExchangeByIdMethod = WalletGrpc.getGetExchangeByIdMethod();

    // Assert
    assertEquals("GetExchangeById", actualGetExchangeByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetExchangeById", actualGetExchangeByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetExchangeByIdMethod.getType());
    assertFalse(actualGetExchangeByIdMethod.isIdempotent());
    assertFalse(actualGetExchangeByIdMethod.isSafe());
    assertTrue(actualGetExchangeByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetExchangeByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetChainParametersMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetChainParametersMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetChainParametersMethod()"})
  public void testGetGetChainParametersMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, ChainParameters> actualGetChainParametersMethod = WalletGrpc
        .getGetChainParametersMethod();

    // Assert
    assertEquals("GetChainParameters", actualGetChainParametersMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetChainParameters", actualGetChainParametersMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetChainParametersMethod.getType());
    assertFalse(actualGetChainParametersMethod.isIdempotent());
    assertFalse(actualGetChainParametersMethod.isSafe());
    assertTrue(actualGetChainParametersMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetChainParametersMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAssetIssueListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAssetIssueListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAssetIssueListMethod()"})
  public void testGetGetAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, AssetIssueList> actualGetAssetIssueListMethod = WalletGrpc
        .getGetAssetIssueListMethod();

    // Assert
    assertEquals("GetAssetIssueList", actualGetAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueList", actualGetAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAssetIssueListMethod.getType());
    assertFalse(actualGetAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListMethod.isSafe());
    assertTrue(actualGetAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetPaginatedAssetIssueListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetPaginatedAssetIssueListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetPaginatedAssetIssueListMethod()"})
  public void testGetGetPaginatedAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<PaginatedMessage, AssetIssueList> actualGetPaginatedAssetIssueListMethod = WalletGrpc
        .getGetPaginatedAssetIssueListMethod();

    // Assert
    assertEquals("GetPaginatedAssetIssueList", actualGetPaginatedAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedAssetIssueList",
        actualGetPaginatedAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetPaginatedAssetIssueListMethod.getType());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isSafe());
    assertTrue(actualGetPaginatedAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedAssetIssueListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getTotalTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getTotalTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getTotalTransactionMethod()"})
  public void testGetTotalTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NumberMessage> actualTotalTransactionMethod = WalletGrpc.getTotalTransactionMethod();

    // Assert
    assertEquals("TotalTransaction", actualTotalTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TotalTransaction", actualTotalTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualTotalTransactionMethod.getType());
    assertFalse(actualTotalTransactionMethod.isIdempotent());
    assertFalse(actualTotalTransactionMethod.isSafe());
    assertTrue(actualTotalTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTotalTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNextMaintenanceTimeMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNextMaintenanceTimeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNextMaintenanceTimeMethod()"})
  public void testGetGetNextMaintenanceTimeMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NumberMessage> actualGetNextMaintenanceTimeMethod = WalletGrpc
        .getGetNextMaintenanceTimeMethod();

    // Assert
    assertEquals("GetNextMaintenanceTime", actualGetNextMaintenanceTimeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNextMaintenanceTime", actualGetNextMaintenanceTimeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNextMaintenanceTimeMethod.getType());
    assertFalse(actualGetNextMaintenanceTimeMethod.isIdempotent());
    assertFalse(actualGetNextMaintenanceTimeMethod.isSafe());
    assertTrue(actualGetNextMaintenanceTimeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNextMaintenanceTimeMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionInfoByIdMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionInfoByIdMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionInfoByIdMethod()"})
  public void testGetGetTransactionInfoByIdMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, TransactionInfo> actualGetTransactionInfoByIdMethod = WalletGrpc
        .getGetTransactionInfoByIdMethod();

    // Assert
    assertEquals("GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionInfoByIdMethod.getType());
    assertFalse(actualGetTransactionInfoByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByIdMethod.isSafe());
    assertTrue(actualGetTransactionInfoByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionInfoByIdMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getAccountPermissionUpdateMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getAccountPermissionUpdateMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getAccountPermissionUpdateMethod()"})
  public void testGetAccountPermissionUpdateMethod() {
    // Arrange and Act
    MethodDescriptor<AccountPermissionUpdateContract, TransactionExtention> actualAccountPermissionUpdateMethod = WalletGrpc
        .getAccountPermissionUpdateMethod();

    // Assert
    assertEquals("AccountPermissionUpdate", actualAccountPermissionUpdateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/AccountPermissionUpdate", actualAccountPermissionUpdateMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualAccountPermissionUpdateMethod.getType());
    assertFalse(actualAccountPermissionUpdateMethod.isIdempotent());
    assertFalse(actualAccountPermissionUpdateMethod.isSafe());
    assertTrue(actualAccountPermissionUpdateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualAccountPermissionUpdateMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionSignWeightMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionSignWeightMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionSignWeightMethod()"})
  public void testGetGetTransactionSignWeightMethod() {
    // Arrange and Act
    MethodDescriptor<Transaction, TransactionSignWeight> actualGetTransactionSignWeightMethod = WalletGrpc
        .getGetTransactionSignWeightMethod();

    // Assert
    assertEquals("GetTransactionSignWeight", actualGetTransactionSignWeightMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionSignWeight", actualGetTransactionSignWeightMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionSignWeightMethod.getType());
    assertFalse(actualGetTransactionSignWeightMethod.isIdempotent());
    assertFalse(actualGetTransactionSignWeightMethod.isSafe());
    assertTrue(actualGetTransactionSignWeightMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionSignWeightMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionApprovedListMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionApprovedListMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionApprovedListMethod()"})
  public void testGetGetTransactionApprovedListMethod() {
    // Arrange and Act
    MethodDescriptor<Transaction, TransactionApprovedList> actualGetTransactionApprovedListMethod = WalletGrpc
        .getGetTransactionApprovedListMethod();

    // Assert
    assertEquals("GetTransactionApprovedList", actualGetTransactionApprovedListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionApprovedList",
        actualGetTransactionApprovedListMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionApprovedListMethod.getType());
    assertFalse(actualGetTransactionApprovedListMethod.isIdempotent());
    assertFalse(actualGetTransactionApprovedListMethod.isSafe());
    assertTrue(actualGetTransactionApprovedListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionApprovedListMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNodeInfoMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNodeInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNodeInfoMethod()"})
  public void testGetGetNodeInfoMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NodeInfo> actualGetNodeInfoMethod = WalletGrpc.getGetNodeInfoMethod();

    // Assert
    assertEquals("GetNodeInfo", actualGetNodeInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNodeInfo", actualGetNodeInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNodeInfoMethod.getType());
    assertFalse(actualGetNodeInfoMethod.isIdempotent());
    assertFalse(actualGetNodeInfoMethod.isSafe());
    assertTrue(actualGetNodeInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNodeInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetRewardInfoMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetRewardInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetRewardInfoMethod()"})
  public void testGetGetRewardInfoMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, NumberMessage> actualGetRewardInfoMethod = WalletGrpc.getGetRewardInfoMethod();

    // Assert
    assertEquals("GetRewardInfo", actualGetRewardInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetRewardInfo", actualGetRewardInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetRewardInfoMethod.getType());
    assertFalse(actualGetRewardInfoMethod.isIdempotent());
    assertFalse(actualGetRewardInfoMethod.isSafe());
    assertTrue(actualGetRewardInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetRewardInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBrokerageInfoMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBrokerageInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBrokerageInfoMethod()"})
  public void testGetGetBrokerageInfoMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, NumberMessage> actualGetBrokerageInfoMethod = WalletGrpc.getGetBrokerageInfoMethod();

    // Assert
    assertEquals("GetBrokerageInfo", actualGetBrokerageInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBrokerageInfo", actualGetBrokerageInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBrokerageInfoMethod.getType());
    assertFalse(actualGetBrokerageInfoMethod.isIdempotent());
    assertFalse(actualGetBrokerageInfoMethod.isSafe());
    assertTrue(actualGetBrokerageInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBrokerageInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getUpdateBrokerageMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getUpdateBrokerageMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getUpdateBrokerageMethod()"})
  public void testGetUpdateBrokerageMethod() {
    // Arrange and Act
    MethodDescriptor<UpdateBrokerageContract, TransactionExtention> actualUpdateBrokerageMethod = WalletGrpc
        .getUpdateBrokerageMethod();

    // Assert
    assertEquals("UpdateBrokerage", actualUpdateBrokerageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateBrokerage", actualUpdateBrokerageMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualUpdateBrokerageMethod.getType());
    assertFalse(actualUpdateBrokerageMethod.isIdempotent());
    assertFalse(actualUpdateBrokerageMethod.isSafe());
    assertTrue(actualUpdateBrokerageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateBrokerageMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateShieldedTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateShieldedTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateShieldedTransactionMethod()"})
  public void testGetCreateShieldedTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<PrivateParameters, TransactionExtention> actualCreateShieldedTransactionMethod = WalletGrpc
        .getCreateShieldedTransactionMethod();

    // Assert
    assertEquals("CreateShieldedTransaction", actualCreateShieldedTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedTransaction",
        actualCreateShieldedTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateShieldedTransactionMethod.getType());
    assertFalse(actualCreateShieldedTransactionMethod.isIdempotent());
    assertFalse(actualCreateShieldedTransactionMethod.isSafe());
    assertTrue(actualCreateShieldedTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMerkleTreeVoucherInfoMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMerkleTreeVoucherInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMerkleTreeVoucherInfoMethod()"})
  public void testGetGetMerkleTreeVoucherInfoMethod() {
    // Arrange and Act
    MethodDescriptor<OutputPointInfo, IncrementalMerkleVoucherInfo> actualGetMerkleTreeVoucherInfoMethod = WalletGrpc
        .getGetMerkleTreeVoucherInfoMethod();

    // Assert
    assertEquals("GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMerkleTreeVoucherInfoMethod.getType());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isIdempotent());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isSafe());
    assertTrue(actualGetMerkleTreeVoucherInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMerkleTreeVoucherInfoMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getScanNoteByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getScanNoteByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getScanNoteByIvkMethod()"})
  public void testGetScanNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptParameters, DecryptNotes> actualScanNoteByIvkMethod = WalletGrpc
        .getScanNoteByIvkMethod();

    // Assert
    assertEquals("ScanNoteByIvk", actualScanNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanNoteByIvk", actualScanNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanNoteByIvkMethod.getType());
    assertFalse(actualScanNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanNoteByIvkMethod.isSafe());
    assertTrue(actualScanNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanNoteByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getScanAndMarkNoteByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getScanAndMarkNoteByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getScanAndMarkNoteByIvkMethod()"})
  public void testGetScanAndMarkNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptAndMarkParameters, DecryptNotesMarked> actualScanAndMarkNoteByIvkMethod = WalletGrpc
        .getScanAndMarkNoteByIvkMethod();

    // Assert
    assertEquals("ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanAndMarkNoteByIvkMethod.getType());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isSafe());
    assertTrue(actualScanAndMarkNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanAndMarkNoteByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getScanNoteByOvkMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getScanNoteByOvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getScanNoteByOvkMethod()"})
  public void testGetScanNoteByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<OvkDecryptParameters, DecryptNotes> actualScanNoteByOvkMethod = WalletGrpc
        .getScanNoteByOvkMethod();

    // Assert
    assertEquals("ScanNoteByOvk", actualScanNoteByOvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanNoteByOvk", actualScanNoteByOvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanNoteByOvkMethod.getType());
    assertFalse(actualScanNoteByOvkMethod.isIdempotent());
    assertFalse(actualScanNoteByOvkMethod.isSafe());
    assertTrue(actualScanNoteByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanNoteByOvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetSpendingKeyMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetSpendingKeyMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetSpendingKeyMethod()"})
  public void testGetGetSpendingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, BytesMessage> actualGetSpendingKeyMethod = WalletGrpc.getGetSpendingKeyMethod();

    // Assert
    assertEquals("GetSpendingKey", actualGetSpendingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetSpendingKey", actualGetSpendingKeyMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetSpendingKeyMethod.getType());
    assertFalse(actualGetSpendingKeyMethod.isIdempotent());
    assertFalse(actualGetSpendingKeyMethod.isSafe());
    assertTrue(actualGetSpendingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetSpendingKeyMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetExpandedSpendingKeyMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetExpandedSpendingKeyMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetExpandedSpendingKeyMethod()"})
  public void testGetGetExpandedSpendingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, ExpandedSpendingKeyMessage> actualGetExpandedSpendingKeyMethod = WalletGrpc
        .getGetExpandedSpendingKeyMethod();

    // Assert
    assertEquals("GetExpandedSpendingKey", actualGetExpandedSpendingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetExpandedSpendingKey", actualGetExpandedSpendingKeyMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetExpandedSpendingKeyMethod.getType());
    assertFalse(actualGetExpandedSpendingKeyMethod.isIdempotent());
    assertFalse(actualGetExpandedSpendingKeyMethod.isSafe());
    assertTrue(actualGetExpandedSpendingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetExpandedSpendingKeyMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetAkFromAskMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetAkFromAskMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetAkFromAskMethod()"})
  public void testGetGetAkFromAskMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, BytesMessage> actualGetAkFromAskMethod = WalletGrpc.getGetAkFromAskMethod();

    // Assert
    assertEquals("GetAkFromAsk", actualGetAkFromAskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAkFromAsk", actualGetAkFromAskMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetAkFromAskMethod.getType());
    assertFalse(actualGetAkFromAskMethod.isIdempotent());
    assertFalse(actualGetAkFromAskMethod.isSafe());
    assertTrue(actualGetAkFromAskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAkFromAskMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNkFromNskMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNkFromNskMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNkFromNskMethod()"})
  public void testGetGetNkFromNskMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, BytesMessage> actualGetNkFromNskMethod = WalletGrpc.getGetNkFromNskMethod();

    // Assert
    assertEquals("GetNkFromNsk", actualGetNkFromNskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNkFromNsk", actualGetNkFromNskMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNkFromNskMethod.getType());
    assertFalse(actualGetNkFromNskMethod.isIdempotent());
    assertFalse(actualGetNkFromNskMethod.isSafe());
    assertTrue(actualGetNkFromNskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNkFromNskMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetIncomingViewingKeyMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetIncomingViewingKeyMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetIncomingViewingKeyMethod()"})
  public void testGetGetIncomingViewingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<ViewingKeyMessage, IncomingViewingKeyMessage> actualGetIncomingViewingKeyMethod = WalletGrpc
        .getGetIncomingViewingKeyMethod();

    // Assert
    assertEquals("GetIncomingViewingKey", actualGetIncomingViewingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetIncomingViewingKey", actualGetIncomingViewingKeyMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetIncomingViewingKeyMethod.getType());
    assertFalse(actualGetIncomingViewingKeyMethod.isIdempotent());
    assertFalse(actualGetIncomingViewingKeyMethod.isSafe());
    assertTrue(actualGetIncomingViewingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetIncomingViewingKeyMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetDiversifierMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetDiversifierMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetDiversifierMethod()"})
  public void testGetGetDiversifierMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, DiversifierMessage> actualGetDiversifierMethod = WalletGrpc
        .getGetDiversifierMethod();

    // Assert
    assertEquals("GetDiversifier", actualGetDiversifierMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDiversifier", actualGetDiversifierMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDiversifierMethod.getType());
    assertFalse(actualGetDiversifierMethod.isIdempotent());
    assertFalse(actualGetDiversifierMethod.isSafe());
    assertTrue(actualGetDiversifierMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDiversifierMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetNewShieldedAddressMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetNewShieldedAddressMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetNewShieldedAddressMethod()"})
  public void testGetGetNewShieldedAddressMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, ShieldedAddressInfo> actualGetNewShieldedAddressMethod = WalletGrpc
        .getGetNewShieldedAddressMethod();

    // Assert
    assertEquals("GetNewShieldedAddress", actualGetNewShieldedAddressMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNewShieldedAddress", actualGetNewShieldedAddressMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNewShieldedAddressMethod.getType());
    assertFalse(actualGetNewShieldedAddressMethod.isIdempotent());
    assertFalse(actualGetNewShieldedAddressMethod.isSafe());
    assertTrue(actualGetNewShieldedAddressMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNewShieldedAddressMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetZenPaymentAddressMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetZenPaymentAddressMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetZenPaymentAddressMethod()"})
  public void testGetGetZenPaymentAddressMethod() {
    // Arrange and Act
    MethodDescriptor<IncomingViewingKeyDiversifierMessage, PaymentAddressMessage> actualGetZenPaymentAddressMethod = WalletGrpc
        .getGetZenPaymentAddressMethod();

    // Assert
    assertEquals("GetZenPaymentAddress", actualGetZenPaymentAddressMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetZenPaymentAddress", actualGetZenPaymentAddressMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetZenPaymentAddressMethod.getType());
    assertFalse(actualGetZenPaymentAddressMethod.isIdempotent());
    assertFalse(actualGetZenPaymentAddressMethod.isSafe());
    assertTrue(actualGetZenPaymentAddressMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetZenPaymentAddressMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetRcmMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetRcmMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetRcmMethod()"})
  public void testGetGetRcmMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, BytesMessage> actualGetRcmMethod = WalletGrpc.getGetRcmMethod();

    // Assert
    assertEquals("GetRcm", actualGetRcmMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetRcm", actualGetRcmMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetRcmMethod.getType());
    assertFalse(actualGetRcmMethod.isIdempotent());
    assertFalse(actualGetRcmMethod.isSafe());
    assertTrue(actualGetRcmMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetRcmMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getIsSpendMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getIsSpendMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getIsSpendMethod()"})
  public void testGetIsSpendMethod() {
    // Arrange and Act
    MethodDescriptor<NoteParameters, SpendResult> actualIsSpendMethod = WalletGrpc.getIsSpendMethod();

    // Assert
    assertEquals("IsSpend", actualIsSpendMethod.getBareMethodName());
    assertEquals("protocol.Wallet/IsSpend", actualIsSpendMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualIsSpendMethod.getType());
    assertFalse(actualIsSpendMethod.isIdempotent());
    assertFalse(actualIsSpendMethod.isSafe());
    assertTrue(actualIsSpendMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualIsSpendMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateShieldedTransactionWithoutSpendAuthSigMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateShieldedTransactionWithoutSpendAuthSigMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateShieldedTransactionWithoutSpendAuthSigMethod()"})
  public void testGetCreateShieldedTransactionWithoutSpendAuthSigMethod() {
    // Arrange and Act
    MethodDescriptor<PrivateParametersWithoutAsk, TransactionExtention> actualCreateShieldedTransactionWithoutSpendAuthSigMethod = WalletGrpc
        .getCreateShieldedTransactionWithoutSpendAuthSigMethod();

    // Assert
    assertEquals("CreateShieldedTransactionWithoutSpendAuthSig",
        actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedTransactionWithoutSpendAuthSig",
        actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getType());
    assertFalse(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isIdempotent());
    assertFalse(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isSafe());
    assertTrue(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetShieldTransactionHashMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetShieldTransactionHashMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetShieldTransactionHashMethod()"})
  public void testGetGetShieldTransactionHashMethod() {
    // Arrange and Act
    MethodDescriptor<Transaction, BytesMessage> actualGetShieldTransactionHashMethod = WalletGrpc
        .getGetShieldTransactionHashMethod();

    // Assert
    assertEquals("GetShieldTransactionHash", actualGetShieldTransactionHashMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetShieldTransactionHash", actualGetShieldTransactionHashMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetShieldTransactionHashMethod.getType());
    assertFalse(actualGetShieldTransactionHashMethod.isIdempotent());
    assertFalse(actualGetShieldTransactionHashMethod.isSafe());
    assertTrue(actualGetShieldTransactionHashMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetShieldTransactionHashMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateSpendAuthSigMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateSpendAuthSigMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateSpendAuthSigMethod()"})
  public void testGetCreateSpendAuthSigMethod() {
    // Arrange and Act
    MethodDescriptor<SpendAuthSigParameters, BytesMessage> actualCreateSpendAuthSigMethod = WalletGrpc
        .getCreateSpendAuthSigMethod();

    // Assert
    assertEquals("CreateSpendAuthSig", actualCreateSpendAuthSigMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateSpendAuthSig", actualCreateSpendAuthSigMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateSpendAuthSigMethod.getType());
    assertFalse(actualCreateSpendAuthSigMethod.isIdempotent());
    assertFalse(actualCreateSpendAuthSigMethod.isSafe());
    assertTrue(actualCreateSpendAuthSigMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateSpendAuthSigMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateShieldNullifierMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateShieldNullifierMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateShieldNullifierMethod()"})
  public void testGetCreateShieldNullifierMethod() {
    // Arrange and Act
    MethodDescriptor<NfParameters, BytesMessage> actualCreateShieldNullifierMethod = WalletGrpc
        .getCreateShieldNullifierMethod();

    // Assert
    assertEquals("CreateShieldNullifier", actualCreateShieldNullifierMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldNullifier", actualCreateShieldNullifierMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateShieldNullifierMethod.getType());
    assertFalse(actualCreateShieldNullifierMethod.isIdempotent());
    assertFalse(actualCreateShieldNullifierMethod.isSafe());
    assertTrue(actualCreateShieldNullifierMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldNullifierMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateShieldedContractParametersMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateShieldedContractParametersMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateShieldedContractParametersMethod()"})
  public void testGetCreateShieldedContractParametersMethod() {
    // Arrange and Act
    MethodDescriptor<PrivateShieldedTRC20Parameters, ShieldedTRC20Parameters> actualCreateShieldedContractParametersMethod = WalletGrpc
        .getCreateShieldedContractParametersMethod();

    // Assert
    assertEquals("CreateShieldedContractParameters", actualCreateShieldedContractParametersMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedContractParameters",
        actualCreateShieldedContractParametersMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateShieldedContractParametersMethod.getType());
    assertFalse(actualCreateShieldedContractParametersMethod.isIdempotent());
    assertFalse(actualCreateShieldedContractParametersMethod.isSafe());
    assertTrue(actualCreateShieldedContractParametersMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedContractParametersMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateShieldedContractParametersWithoutAskMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateShieldedContractParametersWithoutAskMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateShieldedContractParametersWithoutAskMethod()"})
  public void testGetCreateShieldedContractParametersWithoutAskMethod() {
    // Arrange and Act
    MethodDescriptor<PrivateShieldedTRC20ParametersWithoutAsk, ShieldedTRC20Parameters> actualCreateShieldedContractParametersWithoutAskMethod = WalletGrpc
        .getCreateShieldedContractParametersWithoutAskMethod();

    // Assert
    assertEquals("CreateShieldedContractParametersWithoutAsk",
        actualCreateShieldedContractParametersWithoutAskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedContractParametersWithoutAsk",
        actualCreateShieldedContractParametersWithoutAskMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateShieldedContractParametersWithoutAskMethod.getType());
    assertFalse(actualCreateShieldedContractParametersWithoutAskMethod.isIdempotent());
    assertFalse(actualCreateShieldedContractParametersWithoutAskMethod.isSafe());
    assertTrue(actualCreateShieldedContractParametersWithoutAskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedContractParametersWithoutAskMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getScanShieldedTRC20NotesByIvkMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getScanShieldedTRC20NotesByIvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getScanShieldedTRC20NotesByIvkMethod()"})
  public void testGetScanShieldedTRC20NotesByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<IvkDecryptTRC20Parameters, DecryptNotesTRC20> actualScanShieldedTRC20NotesByIvkMethod = WalletGrpc
        .getScanShieldedTRC20NotesByIvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByIvk", actualScanShieldedTRC20NotesByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanShieldedTRC20NotesByIvk",
        actualScanShieldedTRC20NotesByIvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanShieldedTRC20NotesByIvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByIvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getScanShieldedTRC20NotesByOvkMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getScanShieldedTRC20NotesByOvkMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getScanShieldedTRC20NotesByOvkMethod()"})
  public void testGetScanShieldedTRC20NotesByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<OvkDecryptTRC20Parameters, DecryptNotesTRC20> actualScanShieldedTRC20NotesByOvkMethod = WalletGrpc
        .getScanShieldedTRC20NotesByOvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByOvk", actualScanShieldedTRC20NotesByOvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanShieldedTRC20NotesByOvk",
        actualScanShieldedTRC20NotesByOvkMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualScanShieldedTRC20NotesByOvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByOvkMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getIsShieldedTRC20ContractNoteSpentMethod()"})
  public void testGetIsShieldedTRC20ContractNoteSpentMethod() {
    // Arrange and Act
    MethodDescriptor<NfTRC20Parameters, NullifierResult> actualIsShieldedTRC20ContractNoteSpentMethod = WalletGrpc
        .getIsShieldedTRC20ContractNoteSpentMethod();

    // Assert
    assertEquals("IsShieldedTRC20ContractNoteSpent", actualIsShieldedTRC20ContractNoteSpentMethod.getBareMethodName());
    assertEquals("protocol.Wallet/IsShieldedTRC20ContractNoteSpent",
        actualIsShieldedTRC20ContractNoteSpentMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualIsShieldedTRC20ContractNoteSpentMethod.getType());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isIdempotent());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isSafe());
    assertTrue(actualIsShieldedTRC20ContractNoteSpentMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualIsShieldedTRC20ContractNoteSpentMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTriggerInputForShieldedTRC20ContractMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTriggerInputForShieldedTRC20ContractMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTriggerInputForShieldedTRC20ContractMethod()"})
  public void testGetGetTriggerInputForShieldedTRC20ContractMethod() {
    // Arrange and Act
    MethodDescriptor<ShieldedTRC20TriggerContractParameters, BytesMessage> actualGetTriggerInputForShieldedTRC20ContractMethod = WalletGrpc
        .getGetTriggerInputForShieldedTRC20ContractMethod();

    // Assert
    assertEquals("GetTriggerInputForShieldedTRC20Contract",
        actualGetTriggerInputForShieldedTRC20ContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTriggerInputForShieldedTRC20Contract",
        actualGetTriggerInputForShieldedTRC20ContractMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTriggerInputForShieldedTRC20ContractMethod.getType());
    assertFalse(actualGetTriggerInputForShieldedTRC20ContractMethod.isIdempotent());
    assertFalse(actualGetTriggerInputForShieldedTRC20ContractMethod.isSafe());
    assertTrue(actualGetTriggerInputForShieldedTRC20ContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTriggerInputForShieldedTRC20ContractMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getCreateCommonTransactionMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getCreateCommonTransactionMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getCreateCommonTransactionMethod()"})
  public void testGetCreateCommonTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<Transaction, TransactionExtention> actualCreateCommonTransactionMethod = WalletGrpc
        .getCreateCommonTransactionMethod();

    // Assert
    assertEquals("CreateCommonTransaction", actualCreateCommonTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateCommonTransaction", actualCreateCommonTransactionMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCreateCommonTransactionMethod.getType());
    assertFalse(actualCreateCommonTransactionMethod.isIdempotent());
    assertFalse(actualCreateCommonTransactionMethod.isSafe());
    assertTrue(actualCreateCommonTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateCommonTransactionMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionInfoByBlockNumMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionInfoByBlockNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionInfoByBlockNumMethod()"})
  public void testGetGetTransactionInfoByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, TransactionInfoList> actualGetTransactionInfoByBlockNumMethod = WalletGrpc
        .getGetTransactionInfoByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionInfoByBlockNum", actualGetTransactionInfoByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionInfoByBlockNum",
        actualGetTransactionInfoByBlockNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionInfoByBlockNumMethod.getType());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionInfoByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionInfoByBlockNumMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBurnTrxMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBurnTrxMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBurnTrxMethod()"})
  public void testGetGetBurnTrxMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NumberMessage> actualGetBurnTrxMethod = WalletGrpc.getGetBurnTrxMethod();

    // Assert
    assertEquals("GetBurnTrx", actualGetBurnTrxMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBurnTrx", actualGetBurnTrxMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBurnTrxMethod.getType());
    assertFalse(actualGetBurnTrxMethod.isIdempotent());
    assertFalse(actualGetBurnTrxMethod.isSafe());
    assertTrue(actualGetBurnTrxMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBurnTrxMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionFromPendingMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionFromPendingMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionFromPendingMethod()"})
  public void testGetGetTransactionFromPendingMethod() {
    // Arrange and Act
    MethodDescriptor<BytesMessage, Transaction> actualGetTransactionFromPendingMethod = WalletGrpc
        .getGetTransactionFromPendingMethod();

    // Assert
    assertEquals("GetTransactionFromPending", actualGetTransactionFromPendingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionFromPending",
        actualGetTransactionFromPendingMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionFromPendingMethod.getType());
    assertFalse(actualGetTransactionFromPendingMethod.isIdempotent());
    assertFalse(actualGetTransactionFromPendingMethod.isSafe());
    assertTrue(actualGetTransactionFromPendingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionFromPendingMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetTransactionListFromPendingMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetTransactionListFromPendingMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetTransactionListFromPendingMethod()"})
  public void testGetGetTransactionListFromPendingMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, TransactionIdList> actualGetTransactionListFromPendingMethod = WalletGrpc
        .getGetTransactionListFromPendingMethod();

    // Assert
    assertEquals("GetTransactionListFromPending", actualGetTransactionListFromPendingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionListFromPending",
        actualGetTransactionListFromPendingMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionListFromPendingMethod.getType());
    assertFalse(actualGetTransactionListFromPendingMethod.isIdempotent());
    assertFalse(actualGetTransactionListFromPendingMethod.isSafe());
    assertTrue(actualGetTransactionListFromPendingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionListFromPendingMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetPendingSizeMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetPendingSizeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetPendingSizeMethod()"})
  public void testGetGetPendingSizeMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, NumberMessage> actualGetPendingSizeMethod = WalletGrpc.getGetPendingSizeMethod();

    // Assert
    assertEquals("GetPendingSize", actualGetPendingSizeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPendingSize", actualGetPendingSizeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetPendingSizeMethod.getType());
    assertFalse(actualGetPendingSizeMethod.isIdempotent());
    assertFalse(actualGetPendingSizeMethod.isSafe());
    assertTrue(actualGetPendingSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPendingSizeMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBlockMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBlockMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBlockMethod()"})
  public void testGetGetBlockMethod() {
    // Arrange and Act
    MethodDescriptor<BlockReq, BlockExtention> actualGetBlockMethod = WalletGrpc.getGetBlockMethod();

    // Assert
    assertEquals("GetBlock", actualGetBlockMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlock", actualGetBlockMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockMethod.getType());
    assertFalse(actualGetBlockMethod.isIdempotent());
    assertFalse(actualGetBlockMethod.isSafe());
    assertTrue(actualGetBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetBandwidthPricesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetBandwidthPricesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetBandwidthPricesMethod()"})
  public void testGetGetBandwidthPricesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, PricesResponseMessage> actualGetBandwidthPricesMethod = WalletGrpc
        .getGetBandwidthPricesMethod();

    // Assert
    assertEquals("GetBandwidthPrices", actualGetBandwidthPricesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBandwidthPrices", actualGetBandwidthPricesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBandwidthPricesMethod.getType());
    assertFalse(actualGetBandwidthPricesMethod.isIdempotent());
    assertFalse(actualGetBandwidthPricesMethod.isSafe());
    assertTrue(actualGetBandwidthPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBandwidthPricesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetEnergyPricesMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetEnergyPricesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetEnergyPricesMethod()"})
  public void testGetGetEnergyPricesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, PricesResponseMessage> actualGetEnergyPricesMethod = WalletGrpc
        .getGetEnergyPricesMethod();

    // Assert
    assertEquals("GetEnergyPrices", actualGetEnergyPricesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetEnergyPrices", actualGetEnergyPricesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetEnergyPricesMethod.getType());
    assertFalse(actualGetEnergyPricesMethod.isIdempotent());
    assertFalse(actualGetEnergyPricesMethod.isSafe());
    assertTrue(actualGetEnergyPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetEnergyPricesMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#getGetMemoFeeMethod()}.
   * <p>
   * Method under test: {@link WalletGrpc#getGetMemoFeeMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletGrpc.getGetMemoFeeMethod()"})
  public void testGetGetMemoFeeMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, PricesResponseMessage> actualGetMemoFeeMethod = WalletGrpc.getGetMemoFeeMethod();

    // Assert
    assertEquals("GetMemoFee", actualGetMemoFeeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMemoFee", actualGetMemoFeeMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetMemoFeeMethod.getType());
    assertFalse(actualGetMemoFeeMethod.isIdempotent());
    assertFalse(actualGetMemoFeeMethod.isSafe());
    assertTrue(actualGetMemoFeeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMemoFeeMethod.getServiceName());
  }

  /**
   * Test {@link WalletGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletStub WalletGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletStub actualNewStubResult = WalletGrpc.newStub(channel);

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
   * Test {@link WalletGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletBlockingStub WalletGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletBlockingStub actualNewBlockingStubResult = WalletGrpc.newBlockingStub(channel);

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
   * Test {@link WalletGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletFutureStub WalletGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletFutureStub actualNewFutureStubResult = WalletGrpc.newFutureStub(channel);

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
   * Test {@link WalletGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link WalletGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor WalletGrpc.getServiceDescriptor()"})
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(146, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(WalletGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
