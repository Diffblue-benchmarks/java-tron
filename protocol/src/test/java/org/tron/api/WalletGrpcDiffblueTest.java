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
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.BalanceContract;
import org.tron.protos.contract.ExchangeContract;
import org.tron.protos.contract.MarketContract;
import org.tron.protos.contract.ProposalContract;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.StorageContract;
import org.tron.protos.contract.WitnessContract;

public class WalletGrpcDiffblueTest {
  /**
   * Method under test: {@link WalletGrpc#getGetAccountMethod()}
   */
  @Test
  public void testGetGetAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, Protocol.Account> actualGetAccountMethod = WalletGrpc.getGetAccountMethod();

    // Assert
    assertEquals("GetAccount", actualGetAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccount", actualGetAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountMethod.getType());
    assertFalse(actualGetAccountMethod.isIdempotent());
    assertFalse(actualGetAccountMethod.isSafe());
    assertTrue(actualGetAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAccountByIdMethod()}
   */
  @Test
  public void testGetGetAccountByIdMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, Protocol.Account> actualGetAccountByIdMethod = WalletGrpc
        .getGetAccountByIdMethod();

    // Assert
    assertEquals("GetAccountById", actualGetAccountByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountById", actualGetAccountByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountByIdMethod.getType());
    assertFalse(actualGetAccountByIdMethod.isIdempotent());
    assertFalse(actualGetAccountByIdMethod.isSafe());
    assertTrue(actualGetAccountByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAccountBalanceMethod()}
   */
  @Test
  public void testGetGetAccountBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.AccountBalanceRequest, BalanceContract.AccountBalanceResponse> actualGetAccountBalanceMethod = WalletGrpc
        .getGetAccountBalanceMethod();

    // Assert
    assertEquals("GetAccountBalance", actualGetAccountBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountBalance", actualGetAccountBalanceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountBalanceMethod.getType());
    assertFalse(actualGetAccountBalanceMethod.isIdempotent());
    assertFalse(actualGetAccountBalanceMethod.isSafe());
    assertTrue(actualGetAccountBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountBalanceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockBalanceTraceMethod()}
   */
  @Test
  public void testGetGetBlockBalanceTraceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.BlockBalanceTrace.BlockIdentifier, BalanceContract.BlockBalanceTrace> actualGetBlockBalanceTraceMethod = WalletGrpc
        .getGetBlockBalanceTraceMethod();

    // Assert
    assertEquals("GetBlockBalanceTrace", actualGetBlockBalanceTraceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockBalanceTrace", actualGetBlockBalanceTraceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockBalanceTraceMethod.getType());
    assertFalse(actualGetBlockBalanceTraceMethod.isIdempotent());
    assertFalse(actualGetBlockBalanceTraceMethod.isSafe());
    assertTrue(actualGetBlockBalanceTraceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockBalanceTraceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateTransactionMethod()}
   */
  @Test
  public void testGetCreateTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.TransferContract, Protocol.Transaction> actualCreateTransactionMethod = WalletGrpc
        .getCreateTransactionMethod();

    // Assert
    assertEquals("CreateTransaction", actualCreateTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateTransaction", actualCreateTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateTransactionMethod.getType());
    assertFalse(actualCreateTransactionMethod.isIdempotent());
    assertFalse(actualCreateTransactionMethod.isSafe());
    assertTrue(actualCreateTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateTransaction2Method()}
   */
  @Test
  public void testGetCreateTransaction2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.TransferContract, GrpcAPI.TransactionExtention> actualCreateTransaction2Method = WalletGrpc
        .getCreateTransaction2Method();

    // Assert
    assertEquals("CreateTransaction2", actualCreateTransaction2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateTransaction2", actualCreateTransaction2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateTransaction2Method.getType());
    assertFalse(actualCreateTransaction2Method.isIdempotent());
    assertFalse(actualCreateTransaction2Method.isSafe());
    assertTrue(actualCreateTransaction2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateTransaction2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getBroadcastTransactionMethod()}
   */
  @Test
  public void testGetBroadcastTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Transaction, GrpcAPI.Return> actualBroadcastTransactionMethod = WalletGrpc
        .getBroadcastTransactionMethod();

    // Assert
    assertEquals("BroadcastTransaction", actualBroadcastTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BroadcastTransaction", actualBroadcastTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualBroadcastTransactionMethod.getType());
    assertFalse(actualBroadcastTransactionMethod.isIdempotent());
    assertFalse(actualBroadcastTransactionMethod.isSafe());
    assertTrue(actualBroadcastTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBroadcastTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateAccountMethod()}
   */
  @Test
  public void testGetUpdateAccountMethod() {
    // Arrange and Act
    MethodDescriptor<AccountContract.AccountUpdateContract, Protocol.Transaction> actualUpdateAccountMethod = WalletGrpc
        .getUpdateAccountMethod();

    // Assert
    assertEquals("UpdateAccount", actualUpdateAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAccount", actualUpdateAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateAccountMethod.getType());
    assertFalse(actualUpdateAccountMethod.isIdempotent());
    assertFalse(actualUpdateAccountMethod.isSafe());
    assertTrue(actualUpdateAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getSetAccountIdMethod()}
   */
  @Test
  public void testGetSetAccountIdMethod() {
    // Arrange and Act
    MethodDescriptor<AccountContract.SetAccountIdContract, Protocol.Transaction> actualSetAccountIdMethod = WalletGrpc
        .getSetAccountIdMethod();

    // Assert
    assertEquals("SetAccountId", actualSetAccountIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/SetAccountId", actualSetAccountIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualSetAccountIdMethod.getType());
    assertFalse(actualSetAccountIdMethod.isIdempotent());
    assertFalse(actualSetAccountIdMethod.isSafe());
    assertTrue(actualSetAccountIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualSetAccountIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateAccount2Method()}
   */
  @Test
  public void testGetUpdateAccount2Method() {
    // Arrange and Act
    MethodDescriptor<AccountContract.AccountUpdateContract, GrpcAPI.TransactionExtention> actualUpdateAccount2Method = WalletGrpc
        .getUpdateAccount2Method();

    // Assert
    assertEquals("UpdateAccount2", actualUpdateAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAccount2", actualUpdateAccount2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateAccount2Method.getType());
    assertFalse(actualUpdateAccount2Method.isIdempotent());
    assertFalse(actualUpdateAccount2Method.isSafe());
    assertTrue(actualUpdateAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAccount2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getVoteWitnessAccountMethod()}
   */
  @Test
  public void testGetVoteWitnessAccountMethod() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.VoteWitnessContract, Protocol.Transaction> actualVoteWitnessAccountMethod = WalletGrpc
        .getVoteWitnessAccountMethod();

    // Assert
    assertEquals("VoteWitnessAccount", actualVoteWitnessAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/VoteWitnessAccount", actualVoteWitnessAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualVoteWitnessAccountMethod.getType());
    assertFalse(actualVoteWitnessAccountMethod.isIdempotent());
    assertFalse(actualVoteWitnessAccountMethod.isSafe());
    assertTrue(actualVoteWitnessAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualVoteWitnessAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateSettingMethod()}
   */
  @Test
  public void testGetUpdateSettingMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.UpdateSettingContract, GrpcAPI.TransactionExtention> actualUpdateSettingMethod = WalletGrpc
        .getUpdateSettingMethod();

    // Assert
    assertEquals("UpdateSetting", actualUpdateSettingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateSetting", actualUpdateSettingMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateSettingMethod.getType());
    assertFalse(actualUpdateSettingMethod.isIdempotent());
    assertFalse(actualUpdateSettingMethod.isSafe());
    assertTrue(actualUpdateSettingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateSettingMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateEnergyLimitMethod()}
   */
  @Test
  public void testGetUpdateEnergyLimitMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.UpdateEnergyLimitContract, GrpcAPI.TransactionExtention> actualUpdateEnergyLimitMethod = WalletGrpc
        .getUpdateEnergyLimitMethod();

    // Assert
    assertEquals("UpdateEnergyLimit", actualUpdateEnergyLimitMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateEnergyLimit", actualUpdateEnergyLimitMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateEnergyLimitMethod.getType());
    assertFalse(actualUpdateEnergyLimitMethod.isIdempotent());
    assertFalse(actualUpdateEnergyLimitMethod.isSafe());
    assertTrue(actualUpdateEnergyLimitMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateEnergyLimitMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getVoteWitnessAccount2Method()}
   */
  @Test
  public void testGetVoteWitnessAccount2Method() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.VoteWitnessContract, GrpcAPI.TransactionExtention> actualVoteWitnessAccount2Method = WalletGrpc
        .getVoteWitnessAccount2Method();

    // Assert
    assertEquals("VoteWitnessAccount2", actualVoteWitnessAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/VoteWitnessAccount2", actualVoteWitnessAccount2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualVoteWitnessAccount2Method.getType());
    assertFalse(actualVoteWitnessAccount2Method.isIdempotent());
    assertFalse(actualVoteWitnessAccount2Method.isSafe());
    assertTrue(actualVoteWitnessAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualVoteWitnessAccount2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateAssetIssueMethod()}
   */
  @Test
  public void testGetCreateAssetIssueMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.AssetIssueContract, Protocol.Transaction> actualCreateAssetIssueMethod = WalletGrpc
        .getCreateAssetIssueMethod();

    // Assert
    assertEquals("CreateAssetIssue", actualCreateAssetIssueMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAssetIssue", actualCreateAssetIssueMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateAssetIssueMethod.getType());
    assertFalse(actualCreateAssetIssueMethod.isIdempotent());
    assertFalse(actualCreateAssetIssueMethod.isSafe());
    assertTrue(actualCreateAssetIssueMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAssetIssueMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateAssetIssue2Method()}
   */
  @Test
  public void testGetCreateAssetIssue2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.AssetIssueContract, GrpcAPI.TransactionExtention> actualCreateAssetIssue2Method = WalletGrpc
        .getCreateAssetIssue2Method();

    // Assert
    assertEquals("CreateAssetIssue2", actualCreateAssetIssue2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAssetIssue2", actualCreateAssetIssue2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateAssetIssue2Method.getType());
    assertFalse(actualCreateAssetIssue2Method.isIdempotent());
    assertFalse(actualCreateAssetIssue2Method.isSafe());
    assertTrue(actualCreateAssetIssue2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAssetIssue2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateWitnessMethod()}
   */
  @Test
  public void testGetUpdateWitnessMethod() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.WitnessUpdateContract, Protocol.Transaction> actualUpdateWitnessMethod = WalletGrpc
        .getUpdateWitnessMethod();

    // Assert
    assertEquals("UpdateWitness", actualUpdateWitnessMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateWitness", actualUpdateWitnessMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateWitnessMethod.getType());
    assertFalse(actualUpdateWitnessMethod.isIdempotent());
    assertFalse(actualUpdateWitnessMethod.isSafe());
    assertTrue(actualUpdateWitnessMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateWitnessMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateWitness2Method()}
   */
  @Test
  public void testGetUpdateWitness2Method() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.WitnessUpdateContract, GrpcAPI.TransactionExtention> actualUpdateWitness2Method = WalletGrpc
        .getUpdateWitness2Method();

    // Assert
    assertEquals("UpdateWitness2", actualUpdateWitness2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateWitness2", actualUpdateWitness2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateWitness2Method.getType());
    assertFalse(actualUpdateWitness2Method.isIdempotent());
    assertFalse(actualUpdateWitness2Method.isSafe());
    assertTrue(actualUpdateWitness2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateWitness2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateAccountMethod()}
   */
  @Test
  public void testGetCreateAccountMethod() {
    // Arrange and Act
    MethodDescriptor<AccountContract.AccountCreateContract, Protocol.Transaction> actualCreateAccountMethod = WalletGrpc
        .getCreateAccountMethod();

    // Assert
    assertEquals("CreateAccount", actualCreateAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAccount", actualCreateAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateAccountMethod.getType());
    assertFalse(actualCreateAccountMethod.isIdempotent());
    assertFalse(actualCreateAccountMethod.isSafe());
    assertTrue(actualCreateAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateAccount2Method()}
   */
  @Test
  public void testGetCreateAccount2Method() {
    // Arrange and Act
    MethodDescriptor<AccountContract.AccountCreateContract, GrpcAPI.TransactionExtention> actualCreateAccount2Method = WalletGrpc
        .getCreateAccount2Method();

    // Assert
    assertEquals("CreateAccount2", actualCreateAccount2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateAccount2", actualCreateAccount2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateAccount2Method.getType());
    assertFalse(actualCreateAccount2Method.isIdempotent());
    assertFalse(actualCreateAccount2Method.isSafe());
    assertTrue(actualCreateAccount2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateAccount2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateWitnessMethod()}
   */
  @Test
  public void testGetCreateWitnessMethod() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.WitnessCreateContract, Protocol.Transaction> actualCreateWitnessMethod = WalletGrpc
        .getCreateWitnessMethod();

    // Assert
    assertEquals("CreateWitness", actualCreateWitnessMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateWitness", actualCreateWitnessMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateWitnessMethod.getType());
    assertFalse(actualCreateWitnessMethod.isIdempotent());
    assertFalse(actualCreateWitnessMethod.isSafe());
    assertTrue(actualCreateWitnessMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateWitnessMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateWitness2Method()}
   */
  @Test
  public void testGetCreateWitness2Method() {
    // Arrange and Act
    MethodDescriptor<WitnessContract.WitnessCreateContract, GrpcAPI.TransactionExtention> actualCreateWitness2Method = WalletGrpc
        .getCreateWitness2Method();

    // Assert
    assertEquals("CreateWitness2", actualCreateWitness2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CreateWitness2", actualCreateWitness2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateWitness2Method.getType());
    assertFalse(actualCreateWitness2Method.isIdempotent());
    assertFalse(actualCreateWitness2Method.isSafe());
    assertTrue(actualCreateWitness2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateWitness2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getTransferAssetMethod()}
   */
  @Test
  public void testGetTransferAssetMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.TransferAssetContract, Protocol.Transaction> actualTransferAssetMethod = WalletGrpc
        .getTransferAssetMethod();

    // Assert
    assertEquals("TransferAsset", actualTransferAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TransferAsset", actualTransferAssetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTransferAssetMethod.getType());
    assertFalse(actualTransferAssetMethod.isIdempotent());
    assertFalse(actualTransferAssetMethod.isSafe());
    assertTrue(actualTransferAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTransferAssetMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getTransferAsset2Method()}
   */
  @Test
  public void testGetTransferAsset2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.TransferAssetContract, GrpcAPI.TransactionExtention> actualTransferAsset2Method = WalletGrpc
        .getTransferAsset2Method();

    // Assert
    assertEquals("TransferAsset2", actualTransferAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/TransferAsset2", actualTransferAsset2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTransferAsset2Method.getType());
    assertFalse(actualTransferAsset2Method.isIdempotent());
    assertFalse(actualTransferAsset2Method.isSafe());
    assertTrue(actualTransferAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTransferAsset2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getParticipateAssetIssueMethod()}
   */
  @Test
  public void testGetParticipateAssetIssueMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.ParticipateAssetIssueContract, Protocol.Transaction> actualParticipateAssetIssueMethod = WalletGrpc
        .getParticipateAssetIssueMethod();

    // Assert
    assertEquals("ParticipateAssetIssue", actualParticipateAssetIssueMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ParticipateAssetIssue", actualParticipateAssetIssueMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualParticipateAssetIssueMethod.getType());
    assertFalse(actualParticipateAssetIssueMethod.isIdempotent());
    assertFalse(actualParticipateAssetIssueMethod.isSafe());
    assertTrue(actualParticipateAssetIssueMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualParticipateAssetIssueMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getParticipateAssetIssue2Method()}
   */
  @Test
  public void testGetParticipateAssetIssue2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.ParticipateAssetIssueContract, GrpcAPI.TransactionExtention> actualParticipateAssetIssue2Method = WalletGrpc
        .getParticipateAssetIssue2Method();

    // Assert
    assertEquals("ParticipateAssetIssue2", actualParticipateAssetIssue2Method.getBareMethodName());
    assertEquals("protocol.Wallet/ParticipateAssetIssue2", actualParticipateAssetIssue2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualParticipateAssetIssue2Method.getType());
    assertFalse(actualParticipateAssetIssue2Method.isIdempotent());
    assertFalse(actualParticipateAssetIssue2Method.isSafe());
    assertTrue(actualParticipateAssetIssue2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualParticipateAssetIssue2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getFreezeBalanceMethod()}
   */
  @Test
  public void testGetFreezeBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.FreezeBalanceContract, Protocol.Transaction> actualFreezeBalanceMethod = WalletGrpc
        .getFreezeBalanceMethod();

    // Assert
    assertEquals("FreezeBalance", actualFreezeBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalance", actualFreezeBalanceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualFreezeBalanceMethod.getType());
    assertFalse(actualFreezeBalanceMethod.isIdempotent());
    assertFalse(actualFreezeBalanceMethod.isSafe());
    assertTrue(actualFreezeBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalanceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getFreezeBalance2Method()}
   */
  @Test
  public void testGetFreezeBalance2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.FreezeBalanceContract, GrpcAPI.TransactionExtention> actualFreezeBalance2Method = WalletGrpc
        .getFreezeBalance2Method();

    // Assert
    assertEquals("FreezeBalance2", actualFreezeBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalance2", actualFreezeBalance2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualFreezeBalance2Method.getType());
    assertFalse(actualFreezeBalance2Method.isIdempotent());
    assertFalse(actualFreezeBalance2Method.isSafe());
    assertTrue(actualFreezeBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalance2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getFreezeBalanceV2Method()}
   */
  @Test
  public void testGetFreezeBalanceV2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.FreezeBalanceV2Contract, GrpcAPI.TransactionExtention> actualFreezeBalanceV2Method = WalletGrpc
        .getFreezeBalanceV2Method();

    // Assert
    assertEquals("FreezeBalanceV2", actualFreezeBalanceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/FreezeBalanceV2", actualFreezeBalanceV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualFreezeBalanceV2Method.getType());
    assertFalse(actualFreezeBalanceV2Method.isIdempotent());
    assertFalse(actualFreezeBalanceV2Method.isSafe());
    assertTrue(actualFreezeBalanceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualFreezeBalanceV2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnfreezeBalanceMethod()}
   */
  @Test
  public void testGetUnfreezeBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.UnfreezeBalanceContract, Protocol.Transaction> actualUnfreezeBalanceMethod = WalletGrpc
        .getUnfreezeBalanceMethod();

    // Assert
    assertEquals("UnfreezeBalance", actualUnfreezeBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalance", actualUnfreezeBalanceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnfreezeBalanceMethod.getType());
    assertFalse(actualUnfreezeBalanceMethod.isIdempotent());
    assertFalse(actualUnfreezeBalanceMethod.isSafe());
    assertTrue(actualUnfreezeBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalanceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnfreezeBalance2Method()}
   */
  @Test
  public void testGetUnfreezeBalance2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.UnfreezeBalanceContract, GrpcAPI.TransactionExtention> actualUnfreezeBalance2Method = WalletGrpc
        .getUnfreezeBalance2Method();

    // Assert
    assertEquals("UnfreezeBalance2", actualUnfreezeBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalance2", actualUnfreezeBalance2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnfreezeBalance2Method.getType());
    assertFalse(actualUnfreezeBalance2Method.isIdempotent());
    assertFalse(actualUnfreezeBalance2Method.isSafe());
    assertTrue(actualUnfreezeBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalance2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnfreezeBalanceV2Method()}
   */
  @Test
  public void testGetUnfreezeBalanceV2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.UnfreezeBalanceV2Contract, GrpcAPI.TransactionExtention> actualUnfreezeBalanceV2Method = WalletGrpc
        .getUnfreezeBalanceV2Method();

    // Assert
    assertEquals("UnfreezeBalanceV2", actualUnfreezeBalanceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeBalanceV2", actualUnfreezeBalanceV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnfreezeBalanceV2Method.getType());
    assertFalse(actualUnfreezeBalanceV2Method.isIdempotent());
    assertFalse(actualUnfreezeBalanceV2Method.isSafe());
    assertTrue(actualUnfreezeBalanceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeBalanceV2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnfreezeAssetMethod()}
   */
  @Test
  public void testGetUnfreezeAssetMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.UnfreezeAssetContract, Protocol.Transaction> actualUnfreezeAssetMethod = WalletGrpc
        .getUnfreezeAssetMethod();

    // Assert
    assertEquals("UnfreezeAsset", actualUnfreezeAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeAsset", actualUnfreezeAssetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnfreezeAssetMethod.getType());
    assertFalse(actualUnfreezeAssetMethod.isIdempotent());
    assertFalse(actualUnfreezeAssetMethod.isSafe());
    assertTrue(actualUnfreezeAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeAssetMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnfreezeAsset2Method()}
   */
  @Test
  public void testGetUnfreezeAsset2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.UnfreezeAssetContract, GrpcAPI.TransactionExtention> actualUnfreezeAsset2Method = WalletGrpc
        .getUnfreezeAsset2Method();

    // Assert
    assertEquals("UnfreezeAsset2", actualUnfreezeAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UnfreezeAsset2", actualUnfreezeAsset2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnfreezeAsset2Method.getType());
    assertFalse(actualUnfreezeAsset2Method.isIdempotent());
    assertFalse(actualUnfreezeAsset2Method.isSafe());
    assertTrue(actualUnfreezeAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnfreezeAsset2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getWithdrawBalanceMethod()}
   */
  @Test
  public void testGetWithdrawBalanceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.WithdrawBalanceContract, Protocol.Transaction> actualWithdrawBalanceMethod = WalletGrpc
        .getWithdrawBalanceMethod();

    // Assert
    assertEquals("WithdrawBalance", actualWithdrawBalanceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawBalance", actualWithdrawBalanceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualWithdrawBalanceMethod.getType());
    assertFalse(actualWithdrawBalanceMethod.isIdempotent());
    assertFalse(actualWithdrawBalanceMethod.isSafe());
    assertTrue(actualWithdrawBalanceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawBalanceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getWithdrawBalance2Method()}
   */
  @Test
  public void testGetWithdrawBalance2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.WithdrawBalanceContract, GrpcAPI.TransactionExtention> actualWithdrawBalance2Method = WalletGrpc
        .getWithdrawBalance2Method();

    // Assert
    assertEquals("WithdrawBalance2", actualWithdrawBalance2Method.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawBalance2", actualWithdrawBalance2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualWithdrawBalance2Method.getType());
    assertFalse(actualWithdrawBalance2Method.isIdempotent());
    assertFalse(actualWithdrawBalance2Method.isSafe());
    assertTrue(actualWithdrawBalance2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawBalance2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getWithdrawExpireUnfreezeMethod()}
   */
  @Test
  public void testGetWithdrawExpireUnfreezeMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.WithdrawExpireUnfreezeContract, GrpcAPI.TransactionExtention> actualWithdrawExpireUnfreezeMethod = WalletGrpc
        .getWithdrawExpireUnfreezeMethod();

    // Assert
    assertEquals("WithdrawExpireUnfreeze", actualWithdrawExpireUnfreezeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/WithdrawExpireUnfreeze", actualWithdrawExpireUnfreezeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualWithdrawExpireUnfreezeMethod.getType());
    assertFalse(actualWithdrawExpireUnfreezeMethod.isIdempotent());
    assertFalse(actualWithdrawExpireUnfreezeMethod.isSafe());
    assertTrue(actualWithdrawExpireUnfreezeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualWithdrawExpireUnfreezeMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getDelegateResourceMethod()}
   */
  @Test
  public void testGetDelegateResourceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.DelegateResourceContract, GrpcAPI.TransactionExtention> actualDelegateResourceMethod = WalletGrpc
        .getDelegateResourceMethod();

    // Assert
    assertEquals("DelegateResource", actualDelegateResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/DelegateResource", actualDelegateResourceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualDelegateResourceMethod.getType());
    assertFalse(actualDelegateResourceMethod.isIdempotent());
    assertFalse(actualDelegateResourceMethod.isSafe());
    assertTrue(actualDelegateResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualDelegateResourceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUnDelegateResourceMethod()}
   */
  @Test
  public void testGetUnDelegateResourceMethod() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.UnDelegateResourceContract, GrpcAPI.TransactionExtention> actualUnDelegateResourceMethod = WalletGrpc
        .getUnDelegateResourceMethod();

    // Assert
    assertEquals("UnDelegateResource", actualUnDelegateResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UnDelegateResource", actualUnDelegateResourceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUnDelegateResourceMethod.getType());
    assertFalse(actualUnDelegateResourceMethod.isIdempotent());
    assertFalse(actualUnDelegateResourceMethod.isSafe());
    assertTrue(actualUnDelegateResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUnDelegateResourceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCancelAllUnfreezeV2Method()}
   */
  @Test
  public void testGetCancelAllUnfreezeV2Method() {
    // Arrange and Act
    MethodDescriptor<BalanceContract.CancelAllUnfreezeV2Contract, GrpcAPI.TransactionExtention> actualCancelAllUnfreezeV2Method = WalletGrpc
        .getCancelAllUnfreezeV2Method();

    // Assert
    assertEquals("CancelAllUnfreezeV2", actualCancelAllUnfreezeV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/CancelAllUnfreezeV2", actualCancelAllUnfreezeV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCancelAllUnfreezeV2Method.getType());
    assertFalse(actualCancelAllUnfreezeV2Method.isIdempotent());
    assertFalse(actualCancelAllUnfreezeV2Method.isSafe());
    assertTrue(actualCancelAllUnfreezeV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCancelAllUnfreezeV2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateAssetMethod()}
   */
  @Test
  public void testGetUpdateAssetMethod() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.UpdateAssetContract, Protocol.Transaction> actualUpdateAssetMethod = WalletGrpc
        .getUpdateAssetMethod();

    // Assert
    assertEquals("UpdateAsset", actualUpdateAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAsset", actualUpdateAssetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateAssetMethod.getType());
    assertFalse(actualUpdateAssetMethod.isIdempotent());
    assertFalse(actualUpdateAssetMethod.isSafe());
    assertTrue(actualUpdateAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAssetMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateAsset2Method()}
   */
  @Test
  public void testGetUpdateAsset2Method() {
    // Arrange and Act
    MethodDescriptor<AssetIssueContractOuterClass.UpdateAssetContract, GrpcAPI.TransactionExtention> actualUpdateAsset2Method = WalletGrpc
        .getUpdateAsset2Method();

    // Assert
    assertEquals("UpdateAsset2", actualUpdateAsset2Method.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateAsset2", actualUpdateAsset2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateAsset2Method.getType());
    assertFalse(actualUpdateAsset2Method.isIdempotent());
    assertFalse(actualUpdateAsset2Method.isSafe());
    assertTrue(actualUpdateAsset2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateAsset2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getProposalCreateMethod()}
   */
  @Test
  public void testGetProposalCreateMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalContract.ProposalCreateContract, GrpcAPI.TransactionExtention> actualProposalCreateMethod = WalletGrpc
        .getProposalCreateMethod();

    // Assert
    assertEquals("ProposalCreate", actualProposalCreateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalCreate", actualProposalCreateMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualProposalCreateMethod.getType());
    assertFalse(actualProposalCreateMethod.isIdempotent());
    assertFalse(actualProposalCreateMethod.isSafe());
    assertTrue(actualProposalCreateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalCreateMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getProposalApproveMethod()}
   */
  @Test
  public void testGetProposalApproveMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalContract.ProposalApproveContract, GrpcAPI.TransactionExtention> actualProposalApproveMethod = WalletGrpc
        .getProposalApproveMethod();

    // Assert
    assertEquals("ProposalApprove", actualProposalApproveMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalApprove", actualProposalApproveMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualProposalApproveMethod.getType());
    assertFalse(actualProposalApproveMethod.isIdempotent());
    assertFalse(actualProposalApproveMethod.isSafe());
    assertTrue(actualProposalApproveMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalApproveMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getProposalDeleteMethod()}
   */
  @Test
  public void testGetProposalDeleteMethod() {
    // Arrange and Act
    MethodDescriptor<ProposalContract.ProposalDeleteContract, GrpcAPI.TransactionExtention> actualProposalDeleteMethod = WalletGrpc
        .getProposalDeleteMethod();

    // Assert
    assertEquals("ProposalDelete", actualProposalDeleteMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ProposalDelete", actualProposalDeleteMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualProposalDeleteMethod.getType());
    assertFalse(actualProposalDeleteMethod.isIdempotent());
    assertFalse(actualProposalDeleteMethod.isSafe());
    assertTrue(actualProposalDeleteMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualProposalDeleteMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getBuyStorageMethod()}
   */
  @Test
  public void testGetBuyStorageMethod() {
    // Arrange and Act
    MethodDescriptor<StorageContract.BuyStorageContract, GrpcAPI.TransactionExtention> actualBuyStorageMethod = WalletGrpc
        .getBuyStorageMethod();

    // Assert
    assertEquals("BuyStorage", actualBuyStorageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BuyStorage", actualBuyStorageMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualBuyStorageMethod.getType());
    assertFalse(actualBuyStorageMethod.isIdempotent());
    assertFalse(actualBuyStorageMethod.isSafe());
    assertTrue(actualBuyStorageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBuyStorageMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getBuyStorageBytesMethod()}
   */
  @Test
  public void testGetBuyStorageBytesMethod() {
    // Arrange and Act
    MethodDescriptor<StorageContract.BuyStorageBytesContract, GrpcAPI.TransactionExtention> actualBuyStorageBytesMethod = WalletGrpc
        .getBuyStorageBytesMethod();

    // Assert
    assertEquals("BuyStorageBytes", actualBuyStorageBytesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/BuyStorageBytes", actualBuyStorageBytesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualBuyStorageBytesMethod.getType());
    assertFalse(actualBuyStorageBytesMethod.isIdempotent());
    assertFalse(actualBuyStorageBytesMethod.isSafe());
    assertTrue(actualBuyStorageBytesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualBuyStorageBytesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getSellStorageMethod()}
   */
  @Test
  public void testGetSellStorageMethod() {
    // Arrange and Act
    MethodDescriptor<StorageContract.SellStorageContract, GrpcAPI.TransactionExtention> actualSellStorageMethod = WalletGrpc
        .getSellStorageMethod();

    // Assert
    assertEquals("SellStorage", actualSellStorageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/SellStorage", actualSellStorageMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualSellStorageMethod.getType());
    assertFalse(actualSellStorageMethod.isIdempotent());
    assertFalse(actualSellStorageMethod.isSafe());
    assertTrue(actualSellStorageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualSellStorageMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getExchangeCreateMethod()}
   */
  @Test
  public void testGetExchangeCreateMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeContract.ExchangeCreateContract, GrpcAPI.TransactionExtention> actualExchangeCreateMethod = WalletGrpc
        .getExchangeCreateMethod();

    // Assert
    assertEquals("ExchangeCreate", actualExchangeCreateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeCreate", actualExchangeCreateMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualExchangeCreateMethod.getType());
    assertFalse(actualExchangeCreateMethod.isIdempotent());
    assertFalse(actualExchangeCreateMethod.isSafe());
    assertTrue(actualExchangeCreateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeCreateMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getExchangeInjectMethod()}
   */
  @Test
  public void testGetExchangeInjectMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeContract.ExchangeInjectContract, GrpcAPI.TransactionExtention> actualExchangeInjectMethod = WalletGrpc
        .getExchangeInjectMethod();

    // Assert
    assertEquals("ExchangeInject", actualExchangeInjectMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeInject", actualExchangeInjectMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualExchangeInjectMethod.getType());
    assertFalse(actualExchangeInjectMethod.isIdempotent());
    assertFalse(actualExchangeInjectMethod.isSafe());
    assertTrue(actualExchangeInjectMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeInjectMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getExchangeWithdrawMethod()}
   */
  @Test
  public void testGetExchangeWithdrawMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeContract.ExchangeWithdrawContract, GrpcAPI.TransactionExtention> actualExchangeWithdrawMethod = WalletGrpc
        .getExchangeWithdrawMethod();

    // Assert
    assertEquals("ExchangeWithdraw", actualExchangeWithdrawMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeWithdraw", actualExchangeWithdrawMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualExchangeWithdrawMethod.getType());
    assertFalse(actualExchangeWithdrawMethod.isIdempotent());
    assertFalse(actualExchangeWithdrawMethod.isSafe());
    assertTrue(actualExchangeWithdrawMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeWithdrawMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getExchangeTransactionMethod()}
   */
  @Test
  public void testGetExchangeTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<ExchangeContract.ExchangeTransactionContract, GrpcAPI.TransactionExtention> actualExchangeTransactionMethod = WalletGrpc
        .getExchangeTransactionMethod();

    // Assert
    assertEquals("ExchangeTransaction", actualExchangeTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ExchangeTransaction", actualExchangeTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualExchangeTransactionMethod.getType());
    assertFalse(actualExchangeTransactionMethod.isIdempotent());
    assertFalse(actualExchangeTransactionMethod.isSafe());
    assertTrue(actualExchangeTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualExchangeTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getMarketSellAssetMethod()}
   */
  @Test
  public void testGetMarketSellAssetMethod() {
    // Arrange and Act
    MethodDescriptor<MarketContract.MarketSellAssetContract, GrpcAPI.TransactionExtention> actualMarketSellAssetMethod = WalletGrpc
        .getMarketSellAssetMethod();

    // Assert
    assertEquals("MarketSellAsset", actualMarketSellAssetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/MarketSellAsset", actualMarketSellAssetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualMarketSellAssetMethod.getType());
    assertFalse(actualMarketSellAssetMethod.isIdempotent());
    assertFalse(actualMarketSellAssetMethod.isSafe());
    assertTrue(actualMarketSellAssetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualMarketSellAssetMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getMarketCancelOrderMethod()}
   */
  @Test
  public void testGetMarketCancelOrderMethod() {
    // Arrange and Act
    MethodDescriptor<MarketContract.MarketCancelOrderContract, GrpcAPI.TransactionExtention> actualMarketCancelOrderMethod = WalletGrpc
        .getMarketCancelOrderMethod();

    // Assert
    assertEquals("MarketCancelOrder", actualMarketCancelOrderMethod.getBareMethodName());
    assertEquals("protocol.Wallet/MarketCancelOrder", actualMarketCancelOrderMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualMarketCancelOrderMethod.getType());
    assertFalse(actualMarketCancelOrderMethod.isIdempotent());
    assertFalse(actualMarketCancelOrderMethod.isSafe());
    assertTrue(actualMarketCancelOrderMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualMarketCancelOrderMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMarketOrderByIdMethod()}
   */
  @Test
  public void testGetGetMarketOrderByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.MarketOrder> actualGetMarketOrderByIdMethod = WalletGrpc
        .getGetMarketOrderByIdMethod();

    // Assert
    assertEquals("GetMarketOrderById", actualGetMarketOrderByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderById", actualGetMarketOrderByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderByIdMethod.getType());
    assertFalse(actualGetMarketOrderByIdMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByIdMethod.isSafe());
    assertTrue(actualGetMarketOrderByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMarketOrderByAccountMethod()}
   */
  @Test
  public void testGetGetMarketOrderByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.MarketOrderList> actualGetMarketOrderByAccountMethod = WalletGrpc
        .getGetMarketOrderByAccountMethod();

    // Assert
    assertEquals("GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderByAccount", actualGetMarketOrderByAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderByAccountMethod.getType());
    assertFalse(actualGetMarketOrderByAccountMethod.isIdempotent());
    assertFalse(actualGetMarketOrderByAccountMethod.isSafe());
    assertTrue(actualGetMarketOrderByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderByAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMarketPriceByPairMethod()}
   */
  @Test
  public void testGetGetMarketPriceByPairMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.MarketOrderPair, Protocol.MarketPriceList> actualGetMarketPriceByPairMethod = WalletGrpc
        .getGetMarketPriceByPairMethod();

    // Assert
    assertEquals("GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketPriceByPair", actualGetMarketPriceByPairMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketPriceByPairMethod.getType());
    assertFalse(actualGetMarketPriceByPairMethod.isIdempotent());
    assertFalse(actualGetMarketPriceByPairMethod.isSafe());
    assertTrue(actualGetMarketPriceByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketPriceByPairMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMarketOrderListByPairMethod()}
   */
  @Test
  public void testGetGetMarketOrderListByPairMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.MarketOrderPair, Protocol.MarketOrderList> actualGetMarketOrderListByPairMethod = WalletGrpc
        .getGetMarketOrderListByPairMethod();

    // Assert
    assertEquals("GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketOrderListByPair", actualGetMarketOrderListByPairMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketOrderListByPairMethod.getType());
    assertFalse(actualGetMarketOrderListByPairMethod.isIdempotent());
    assertFalse(actualGetMarketOrderListByPairMethod.isSafe());
    assertTrue(actualGetMarketOrderListByPairMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketOrderListByPairMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMarketPairListMethod()}
   */
  @Test
  public void testGetGetMarketPairListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.MarketOrderPairList> actualGetMarketPairListMethod = WalletGrpc
        .getGetMarketPairListMethod();

    // Assert
    assertEquals("GetMarketPairList", actualGetMarketPairListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMarketPairList", actualGetMarketPairListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMarketPairListMethod.getType());
    assertFalse(actualGetMarketPairListMethod.isIdempotent());
    assertFalse(actualGetMarketPairListMethod.isSafe());
    assertTrue(actualGetMarketPairListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMarketPairListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getListNodesMethod()}
   */
  @Test
  public void testGetListNodesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NodeList> actualListNodesMethod = WalletGrpc.getListNodesMethod();

    // Assert
    assertEquals("ListNodes", actualListNodesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListNodes", actualListNodesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListNodesMethod.getType());
    assertFalse(actualListNodesMethod.isIdempotent());
    assertFalse(actualListNodesMethod.isSafe());
    assertTrue(actualListNodesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListNodesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAssetIssueByAccountMethod()}
   */
  @Test
  public void testGetGetAssetIssueByAccountMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, GrpcAPI.AssetIssueList> actualGetAssetIssueByAccountMethod = WalletGrpc
        .getGetAssetIssueByAccountMethod();

    // Assert
    assertEquals("GetAssetIssueByAccount", actualGetAssetIssueByAccountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueByAccount", actualGetAssetIssueByAccountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueByAccountMethod.getType());
    assertFalse(actualGetAssetIssueByAccountMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByAccountMethod.isSafe());
    assertTrue(actualGetAssetIssueByAccountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByAccountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAccountNetMethod()}
   */
  @Test
  public void testGetGetAccountNetMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, GrpcAPI.AccountNetMessage> actualGetAccountNetMethod = WalletGrpc
        .getGetAccountNetMethod();

    // Assert
    assertEquals("GetAccountNet", actualGetAccountNetMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountNet", actualGetAccountNetMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountNetMethod.getType());
    assertFalse(actualGetAccountNetMethod.isIdempotent());
    assertFalse(actualGetAccountNetMethod.isSafe());
    assertTrue(actualGetAccountNetMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountNetMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAccountResourceMethod()}
   */
  @Test
  public void testGetGetAccountResourceMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Account, GrpcAPI.AccountResourceMessage> actualGetAccountResourceMethod = WalletGrpc
        .getGetAccountResourceMethod();

    // Assert
    assertEquals("GetAccountResource", actualGetAccountResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccountResource", actualGetAccountResourceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAccountResourceMethod.getType());
    assertFalse(actualGetAccountResourceMethod.isIdempotent());
    assertFalse(actualGetAccountResourceMethod.isSafe());
    assertTrue(actualGetAccountResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAccountResourceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAssetIssueByNameMethod()}
   */
  @Test
  public void testGetGetAssetIssueByNameMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, AssetIssueContractOuterClass.AssetIssueContract> actualGetAssetIssueByNameMethod = WalletGrpc
        .getGetAssetIssueByNameMethod();

    // Assert
    assertEquals("GetAssetIssueByName", actualGetAssetIssueByNameMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueByName", actualGetAssetIssueByNameMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueByNameMethod.getType());
    assertFalse(actualGetAssetIssueByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByNameMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAssetIssueListByNameMethod()}
   */
  @Test
  public void testGetGetAssetIssueListByNameMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.AssetIssueList> actualGetAssetIssueListByNameMethod = WalletGrpc
        .getGetAssetIssueListByNameMethod();

    // Assert
    assertEquals("GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueListByName", actualGetAssetIssueListByNameMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueListByNameMethod.getType());
    assertFalse(actualGetAssetIssueListByNameMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListByNameMethod.isSafe());
    assertTrue(actualGetAssetIssueListByNameMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueListByNameMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAssetIssueByIdMethod()}
   */
  @Test
  public void testGetGetAssetIssueByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, AssetIssueContractOuterClass.AssetIssueContract> actualGetAssetIssueByIdMethod = WalletGrpc
        .getGetAssetIssueByIdMethod();

    // Assert
    assertEquals("GetAssetIssueById", actualGetAssetIssueByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueById", actualGetAssetIssueByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueByIdMethod.getType());
    assertFalse(actualGetAssetIssueByIdMethod.isIdempotent());
    assertFalse(actualGetAssetIssueByIdMethod.isSafe());
    assertTrue(actualGetAssetIssueByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNowBlockMethod()}
   */
  @Test
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.Block> actualGetNowBlockMethod = WalletGrpc.getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNowBlock2Method()}
   */
  @Test
  public void testGetGetNowBlock2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.BlockExtention> actualGetNowBlock2Method = WalletGrpc
        .getGetNowBlock2Method();

    // Assert
    assertEquals("GetNowBlock2", actualGetNowBlock2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetNowBlock2", actualGetNowBlock2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNowBlock2Method.getType());
    assertFalse(actualGetNowBlock2Method.isIdempotent());
    assertFalse(actualGetNowBlock2Method.isSafe());
    assertTrue(actualGetNowBlock2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNowBlock2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByNumMethod()}
   */
  @Test
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, Protocol.Block> actualGetBlockByNumMethod = WalletGrpc
        .getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByNum2Method()}
   */
  @Test
  public void testGetGetBlockByNum2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.BlockExtention> actualGetBlockByNum2Method = WalletGrpc
        .getGetBlockByNum2Method();

    // Assert
    assertEquals("GetBlockByNum2", actualGetBlockByNum2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByNum2", actualGetBlockByNum2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByNum2Method.getType());
    assertFalse(actualGetBlockByNum2Method.isIdempotent());
    assertFalse(actualGetBlockByNum2Method.isSafe());
    assertTrue(actualGetBlockByNum2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByNum2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getGetTransactionCountByBlockNumMethod()}
   */
  @Test
  public void testGetGetTransactionCountByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.NumberMessage> actualGetTransactionCountByBlockNumMethod = WalletGrpc
        .getGetTransactionCountByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionCountByBlockNum", actualGetTransactionCountByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionCountByBlockNum",
        actualGetTransactionCountByBlockNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionCountByBlockNumMethod.getType());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionCountByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionCountByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionCountByBlockNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByIdMethod()}
   */
  @Test
  public void testGetGetBlockByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Block> actualGetBlockByIdMethod = WalletGrpc
        .getGetBlockByIdMethod();

    // Assert
    assertEquals("GetBlockById", actualGetBlockByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockById", actualGetBlockByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByIdMethod.getType());
    assertFalse(actualGetBlockByIdMethod.isIdempotent());
    assertFalse(actualGetBlockByIdMethod.isSafe());
    assertTrue(actualGetBlockByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByLimitNextMethod()}
   */
  @Test
  public void testGetGetBlockByLimitNextMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BlockLimit, GrpcAPI.BlockList> actualGetBlockByLimitNextMethod = WalletGrpc
        .getGetBlockByLimitNextMethod();

    // Assert
    assertEquals("GetBlockByLimitNext", actualGetBlockByLimitNextMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLimitNext", actualGetBlockByLimitNextMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByLimitNextMethod.getType());
    assertFalse(actualGetBlockByLimitNextMethod.isIdempotent());
    assertFalse(actualGetBlockByLimitNextMethod.isSafe());
    assertTrue(actualGetBlockByLimitNextMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLimitNextMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByLimitNext2Method()}
   */
  @Test
  public void testGetGetBlockByLimitNext2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BlockLimit, GrpcAPI.BlockListExtention> actualGetBlockByLimitNext2Method = WalletGrpc
        .getGetBlockByLimitNext2Method();

    // Assert
    assertEquals("GetBlockByLimitNext2", actualGetBlockByLimitNext2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLimitNext2", actualGetBlockByLimitNext2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByLimitNext2Method.getType());
    assertFalse(actualGetBlockByLimitNext2Method.isIdempotent());
    assertFalse(actualGetBlockByLimitNext2Method.isSafe());
    assertTrue(actualGetBlockByLimitNext2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLimitNext2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByLatestNumMethod()}
   */
  @Test
  public void testGetGetBlockByLatestNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.BlockList> actualGetBlockByLatestNumMethod = WalletGrpc
        .getGetBlockByLatestNumMethod();

    // Assert
    assertEquals("GetBlockByLatestNum", actualGetBlockByLatestNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLatestNum", actualGetBlockByLatestNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByLatestNumMethod.getType());
    assertFalse(actualGetBlockByLatestNumMethod.isIdempotent());
    assertFalse(actualGetBlockByLatestNumMethod.isSafe());
    assertTrue(actualGetBlockByLatestNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLatestNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockByLatestNum2Method()}
   */
  @Test
  public void testGetGetBlockByLatestNum2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.BlockListExtention> actualGetBlockByLatestNum2Method = WalletGrpc
        .getGetBlockByLatestNum2Method();

    // Assert
    assertEquals("GetBlockByLatestNum2", actualGetBlockByLatestNum2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlockByLatestNum2", actualGetBlockByLatestNum2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByLatestNum2Method.getType());
    assertFalse(actualGetBlockByLatestNum2Method.isIdempotent());
    assertFalse(actualGetBlockByLatestNum2Method.isSafe());
    assertTrue(actualGetBlockByLatestNum2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockByLatestNum2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionByIdMethod()}
   */
  @Test
  public void testGetGetTransactionByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Transaction> actualGetTransactionByIdMethod = WalletGrpc
        .getGetTransactionByIdMethod();

    // Assert
    assertEquals("GetTransactionById", actualGetTransactionByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionById", actualGetTransactionByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionByIdMethod.getType());
    assertFalse(actualGetTransactionByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionByIdMethod.isSafe());
    assertTrue(actualGetTransactionByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getDeployContractMethod()}
   */
  @Test
  public void testGetDeployContractMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.CreateSmartContract, GrpcAPI.TransactionExtention> actualDeployContractMethod = WalletGrpc
        .getDeployContractMethod();

    // Assert
    assertEquals("DeployContract", actualDeployContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/DeployContract", actualDeployContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualDeployContractMethod.getType());
    assertFalse(actualDeployContractMethod.isIdempotent());
    assertFalse(actualDeployContractMethod.isSafe());
    assertTrue(actualDeployContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualDeployContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetContractMethod()}
   */
  @Test
  public void testGetGetContractMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, SmartContractOuterClass.SmartContract> actualGetContractMethod = WalletGrpc
        .getGetContractMethod();

    // Assert
    assertEquals("GetContract", actualGetContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetContract", actualGetContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetContractMethod.getType());
    assertFalse(actualGetContractMethod.isIdempotent());
    assertFalse(actualGetContractMethod.isSafe());
    assertTrue(actualGetContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetContractInfoMethod()}
   */
  @Test
  public void testGetGetContractInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, SmartContractOuterClass.SmartContractDataWrapper> actualGetContractInfoMethod = WalletGrpc
        .getGetContractInfoMethod();

    // Assert
    assertEquals("GetContractInfo", actualGetContractInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetContractInfo", actualGetContractInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetContractInfoMethod.getType());
    assertFalse(actualGetContractInfoMethod.isIdempotent());
    assertFalse(actualGetContractInfoMethod.isSafe());
    assertTrue(actualGetContractInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetContractInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getTriggerContractMethod()}
   */
  @Test
  public void testGetTriggerContractMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.TriggerSmartContract, GrpcAPI.TransactionExtention> actualTriggerContractMethod = WalletGrpc
        .getTriggerContractMethod();

    // Assert
    assertEquals("TriggerContract", actualTriggerContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TriggerContract", actualTriggerContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTriggerContractMethod.getType());
    assertFalse(actualTriggerContractMethod.isIdempotent());
    assertFalse(actualTriggerContractMethod.isSafe());
    assertTrue(actualTriggerContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTriggerContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getTriggerConstantContractMethod()}
   */
  @Test
  public void testGetTriggerConstantContractMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.TriggerSmartContract, GrpcAPI.TransactionExtention> actualTriggerConstantContractMethod = WalletGrpc
        .getTriggerConstantContractMethod();

    // Assert
    assertEquals("TriggerConstantContract", actualTriggerConstantContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TriggerConstantContract", actualTriggerConstantContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTriggerConstantContractMethod.getType());
    assertFalse(actualTriggerConstantContractMethod.isIdempotent());
    assertFalse(actualTriggerConstantContractMethod.isSafe());
    assertTrue(actualTriggerConstantContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTriggerConstantContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getEstimateEnergyMethod()}
   */
  @Test
  public void testGetEstimateEnergyMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.TriggerSmartContract, GrpcAPI.EstimateEnergyMessage> actualEstimateEnergyMethod = WalletGrpc
        .getEstimateEnergyMethod();

    // Assert
    assertEquals("EstimateEnergy", actualEstimateEnergyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/EstimateEnergy", actualEstimateEnergyMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualEstimateEnergyMethod.getType());
    assertFalse(actualEstimateEnergyMethod.isIdempotent());
    assertFalse(actualEstimateEnergyMethod.isSafe());
    assertTrue(actualEstimateEnergyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualEstimateEnergyMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getClearContractABIMethod()}
   */
  @Test
  public void testGetClearContractABIMethod() {
    // Arrange and Act
    MethodDescriptor<SmartContractOuterClass.ClearABIContract, GrpcAPI.TransactionExtention> actualClearContractABIMethod = WalletGrpc
        .getClearContractABIMethod();

    // Assert
    assertEquals("ClearContractABI", actualClearContractABIMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ClearContractABI", actualClearContractABIMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualClearContractABIMethod.getType());
    assertFalse(actualClearContractABIMethod.isIdempotent());
    assertFalse(actualClearContractABIMethod.isSafe());
    assertTrue(actualClearContractABIMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualClearContractABIMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getListWitnessesMethod()}
   */
  @Test
  public void testGetListWitnessesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.WitnessList> actualListWitnessesMethod = WalletGrpc
        .getListWitnessesMethod();

    // Assert
    assertEquals("ListWitnesses", actualListWitnessesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListWitnesses", actualListWitnessesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListWitnessesMethod.getType());
    assertFalse(actualListWitnessesMethod.isIdempotent());
    assertFalse(actualListWitnessesMethod.isSafe());
    assertTrue(actualListWitnessesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListWitnessesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceMethod()}
   */
  @Test
  public void testGetGetDelegatedResourceMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.DelegatedResourceMessage, GrpcAPI.DelegatedResourceList> actualGetDelegatedResourceMethod = WalletGrpc
        .getGetDelegatedResourceMethod();

    // Assert
    assertEquals("GetDelegatedResource", actualGetDelegatedResourceMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResource", actualGetDelegatedResourceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceMethod.getType());
    assertFalse(actualGetDelegatedResourceMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceMethod.isSafe());
    assertTrue(actualGetDelegatedResourceMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetDelegatedResourceV2Method()}
   */
  @Test
  public void testGetGetDelegatedResourceV2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.DelegatedResourceMessage, GrpcAPI.DelegatedResourceList> actualGetDelegatedResourceV2Method = WalletGrpc
        .getGetDelegatedResourceV2Method();

    // Assert
    assertEquals("GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceV2", actualGetDelegatedResourceV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceV2Method.getType());
    assertFalse(actualGetDelegatedResourceV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceV2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getGetDelegatedResourceAccountIndexMethod()}
   */
  @Test
  public void testGetGetDelegatedResourceAccountIndexMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexMethod = WalletGrpc
        .getGetDelegatedResourceAccountIndexMethod();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndex", actualGetDelegatedResourceAccountIndexMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceAccountIndex",
        actualGetDelegatedResourceAccountIndexMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceAccountIndexMethod.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexMethod.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getGetDelegatedResourceAccountIndexV2Method()}
   */
  @Test
  public void testGetGetDelegatedResourceAccountIndexV2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.DelegatedResourceAccountIndex> actualGetDelegatedResourceAccountIndexV2Method = WalletGrpc
        .getGetDelegatedResourceAccountIndexV2Method();

    // Assert
    assertEquals("GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getBareMethodName());
    assertEquals("protocol.Wallet/GetDelegatedResourceAccountIndexV2",
        actualGetDelegatedResourceAccountIndexV2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDelegatedResourceAccountIndexV2Method.getType());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isIdempotent());
    assertFalse(actualGetDelegatedResourceAccountIndexV2Method.isSafe());
    assertTrue(actualGetDelegatedResourceAccountIndexV2Method.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDelegatedResourceAccountIndexV2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetCanDelegatedMaxSizeMethod()}
   */
  @Test
  public void testGetGetCanDelegatedMaxSizeMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.CanDelegatedMaxSizeRequestMessage, GrpcAPI.CanDelegatedMaxSizeResponseMessage> actualGetCanDelegatedMaxSizeMethod = WalletGrpc
        .getGetCanDelegatedMaxSizeMethod();

    // Assert
    assertEquals("GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetCanDelegatedMaxSize", actualGetCanDelegatedMaxSizeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetCanDelegatedMaxSizeMethod.getType());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isIdempotent());
    assertFalse(actualGetCanDelegatedMaxSizeMethod.isSafe());
    assertTrue(actualGetCanDelegatedMaxSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetCanDelegatedMaxSizeMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAvailableUnfreezeCountMethod()}
   */
  @Test
  public void testGetGetAvailableUnfreezeCountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.GetAvailableUnfreezeCountRequestMessage, GrpcAPI.GetAvailableUnfreezeCountResponseMessage> actualGetAvailableUnfreezeCountMethod = WalletGrpc
        .getGetAvailableUnfreezeCountMethod();

    // Assert
    assertEquals("GetAvailableUnfreezeCount", actualGetAvailableUnfreezeCountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAvailableUnfreezeCount",
        actualGetAvailableUnfreezeCountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAvailableUnfreezeCountMethod.getType());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isIdempotent());
    assertFalse(actualGetAvailableUnfreezeCountMethod.isSafe());
    assertTrue(actualGetAvailableUnfreezeCountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAvailableUnfreezeCountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetCanWithdrawUnfreezeAmountMethod()}
   */
  @Test
  public void testGetGetCanWithdrawUnfreezeAmountMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> actualGetCanWithdrawUnfreezeAmountMethod = WalletGrpc
        .getGetCanWithdrawUnfreezeAmountMethod();

    // Assert
    assertEquals("GetCanWithdrawUnfreezeAmount", actualGetCanWithdrawUnfreezeAmountMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetCanWithdrawUnfreezeAmount",
        actualGetCanWithdrawUnfreezeAmountMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetCanWithdrawUnfreezeAmountMethod.getType());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isIdempotent());
    assertFalse(actualGetCanWithdrawUnfreezeAmountMethod.isSafe());
    assertTrue(actualGetCanWithdrawUnfreezeAmountMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetCanWithdrawUnfreezeAmountMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getListProposalsMethod()}
   */
  @Test
  public void testGetListProposalsMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.ProposalList> actualListProposalsMethod = WalletGrpc
        .getListProposalsMethod();

    // Assert
    assertEquals("ListProposals", actualListProposalsMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListProposals", actualListProposalsMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListProposalsMethod.getType());
    assertFalse(actualListProposalsMethod.isIdempotent());
    assertFalse(actualListProposalsMethod.isSafe());
    assertTrue(actualListProposalsMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListProposalsMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetPaginatedProposalListMethod()}
   */
  @Test
  public void testGetGetPaginatedProposalListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PaginatedMessage, GrpcAPI.ProposalList> actualGetPaginatedProposalListMethod = WalletGrpc
        .getGetPaginatedProposalListMethod();

    // Assert
    assertEquals("GetPaginatedProposalList", actualGetPaginatedProposalListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedProposalList", actualGetPaginatedProposalListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetPaginatedProposalListMethod.getType());
    assertFalse(actualGetPaginatedProposalListMethod.isIdempotent());
    assertFalse(actualGetPaginatedProposalListMethod.isSafe());
    assertTrue(actualGetPaginatedProposalListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedProposalListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetProposalByIdMethod()}
   */
  @Test
  public void testGetGetProposalByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Proposal> actualGetProposalByIdMethod = WalletGrpc
        .getGetProposalByIdMethod();

    // Assert
    assertEquals("GetProposalById", actualGetProposalByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetProposalById", actualGetProposalByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetProposalByIdMethod.getType());
    assertFalse(actualGetProposalByIdMethod.isIdempotent());
    assertFalse(actualGetProposalByIdMethod.isSafe());
    assertTrue(actualGetProposalByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetProposalByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getListExchangesMethod()}
   */
  @Test
  public void testGetListExchangesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.ExchangeList> actualListExchangesMethod = WalletGrpc
        .getListExchangesMethod();

    // Assert
    assertEquals("ListExchanges", actualListExchangesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ListExchanges", actualListExchangesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualListExchangesMethod.getType());
    assertFalse(actualListExchangesMethod.isIdempotent());
    assertFalse(actualListExchangesMethod.isSafe());
    assertTrue(actualListExchangesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualListExchangesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetPaginatedExchangeListMethod()}
   */
  @Test
  public void testGetGetPaginatedExchangeListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PaginatedMessage, GrpcAPI.ExchangeList> actualGetPaginatedExchangeListMethod = WalletGrpc
        .getGetPaginatedExchangeListMethod();

    // Assert
    assertEquals("GetPaginatedExchangeList", actualGetPaginatedExchangeListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedExchangeList", actualGetPaginatedExchangeListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetPaginatedExchangeListMethod.getType());
    assertFalse(actualGetPaginatedExchangeListMethod.isIdempotent());
    assertFalse(actualGetPaginatedExchangeListMethod.isSafe());
    assertTrue(actualGetPaginatedExchangeListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedExchangeListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetExchangeByIdMethod()}
   */
  @Test
  public void testGetGetExchangeByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Exchange> actualGetExchangeByIdMethod = WalletGrpc
        .getGetExchangeByIdMethod();

    // Assert
    assertEquals("GetExchangeById", actualGetExchangeByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetExchangeById", actualGetExchangeByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetExchangeByIdMethod.getType());
    assertFalse(actualGetExchangeByIdMethod.isIdempotent());
    assertFalse(actualGetExchangeByIdMethod.isSafe());
    assertTrue(actualGetExchangeByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetExchangeByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetChainParametersMethod()}
   */
  @Test
  public void testGetGetChainParametersMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.ChainParameters> actualGetChainParametersMethod = WalletGrpc
        .getGetChainParametersMethod();

    // Assert
    assertEquals("GetChainParameters", actualGetChainParametersMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetChainParameters", actualGetChainParametersMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetChainParametersMethod.getType());
    assertFalse(actualGetChainParametersMethod.isIdempotent());
    assertFalse(actualGetChainParametersMethod.isSafe());
    assertTrue(actualGetChainParametersMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetChainParametersMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAssetIssueListMethod()}
   */
  @Test
  public void testGetGetAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.AssetIssueList> actualGetAssetIssueListMethod = WalletGrpc
        .getGetAssetIssueListMethod();

    // Assert
    assertEquals("GetAssetIssueList", actualGetAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAssetIssueList", actualGetAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAssetIssueListMethod.getType());
    assertFalse(actualGetAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetAssetIssueListMethod.isSafe());
    assertTrue(actualGetAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAssetIssueListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetPaginatedAssetIssueListMethod()}
   */
  @Test
  public void testGetGetPaginatedAssetIssueListMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PaginatedMessage, GrpcAPI.AssetIssueList> actualGetPaginatedAssetIssueListMethod = WalletGrpc
        .getGetPaginatedAssetIssueListMethod();

    // Assert
    assertEquals("GetPaginatedAssetIssueList", actualGetPaginatedAssetIssueListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPaginatedAssetIssueList",
        actualGetPaginatedAssetIssueListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetPaginatedAssetIssueListMethod.getType());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isIdempotent());
    assertFalse(actualGetPaginatedAssetIssueListMethod.isSafe());
    assertTrue(actualGetPaginatedAssetIssueListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPaginatedAssetIssueListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getTotalTransactionMethod()}
   */
  @Test
  public void testGetTotalTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NumberMessage> actualTotalTransactionMethod = WalletGrpc
        .getTotalTransactionMethod();

    // Assert
    assertEquals("TotalTransaction", actualTotalTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/TotalTransaction", actualTotalTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualTotalTransactionMethod.getType());
    assertFalse(actualTotalTransactionMethod.isIdempotent());
    assertFalse(actualTotalTransactionMethod.isSafe());
    assertTrue(actualTotalTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualTotalTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNextMaintenanceTimeMethod()}
   */
  @Test
  public void testGetGetNextMaintenanceTimeMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NumberMessage> actualGetNextMaintenanceTimeMethod = WalletGrpc
        .getGetNextMaintenanceTimeMethod();

    // Assert
    assertEquals("GetNextMaintenanceTime", actualGetNextMaintenanceTimeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNextMaintenanceTime", actualGetNextMaintenanceTimeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNextMaintenanceTimeMethod.getType());
    assertFalse(actualGetNextMaintenanceTimeMethod.isIdempotent());
    assertFalse(actualGetNextMaintenanceTimeMethod.isSafe());
    assertTrue(actualGetNextMaintenanceTimeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNextMaintenanceTimeMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionInfoByIdMethod()}
   */
  @Test
  public void testGetGetTransactionInfoByIdMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.TransactionInfo> actualGetTransactionInfoByIdMethod = WalletGrpc
        .getGetTransactionInfoByIdMethod();

    // Assert
    assertEquals("GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionInfoById", actualGetTransactionInfoByIdMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionInfoByIdMethod.getType());
    assertFalse(actualGetTransactionInfoByIdMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByIdMethod.isSafe());
    assertTrue(actualGetTransactionInfoByIdMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionInfoByIdMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getAccountPermissionUpdateMethod()}
   */
  @Test
  public void testGetAccountPermissionUpdateMethod() {
    // Arrange and Act
    MethodDescriptor<AccountContract.AccountPermissionUpdateContract, GrpcAPI.TransactionExtention> actualAccountPermissionUpdateMethod = WalletGrpc
        .getAccountPermissionUpdateMethod();

    // Assert
    assertEquals("AccountPermissionUpdate", actualAccountPermissionUpdateMethod.getBareMethodName());
    assertEquals("protocol.Wallet/AccountPermissionUpdate", actualAccountPermissionUpdateMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualAccountPermissionUpdateMethod.getType());
    assertFalse(actualAccountPermissionUpdateMethod.isIdempotent());
    assertFalse(actualAccountPermissionUpdateMethod.isSafe());
    assertTrue(actualAccountPermissionUpdateMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualAccountPermissionUpdateMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionSignWeightMethod()}
   */
  @Test
  public void testGetGetTransactionSignWeightMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Transaction, GrpcAPI.TransactionSignWeight> actualGetTransactionSignWeightMethod = WalletGrpc
        .getGetTransactionSignWeightMethod();

    // Assert
    assertEquals("GetTransactionSignWeight", actualGetTransactionSignWeightMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionSignWeight", actualGetTransactionSignWeightMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionSignWeightMethod.getType());
    assertFalse(actualGetTransactionSignWeightMethod.isIdempotent());
    assertFalse(actualGetTransactionSignWeightMethod.isSafe());
    assertTrue(actualGetTransactionSignWeightMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionSignWeightMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionApprovedListMethod()}
   */
  @Test
  public void testGetGetTransactionApprovedListMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Transaction, GrpcAPI.TransactionApprovedList> actualGetTransactionApprovedListMethod = WalletGrpc
        .getGetTransactionApprovedListMethod();

    // Assert
    assertEquals("GetTransactionApprovedList", actualGetTransactionApprovedListMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionApprovedList",
        actualGetTransactionApprovedListMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionApprovedListMethod.getType());
    assertFalse(actualGetTransactionApprovedListMethod.isIdempotent());
    assertFalse(actualGetTransactionApprovedListMethod.isSafe());
    assertTrue(actualGetTransactionApprovedListMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionApprovedListMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNodeInfoMethod()}
   */
  @Test
  public void testGetGetNodeInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.NodeInfo> actualGetNodeInfoMethod = WalletGrpc
        .getGetNodeInfoMethod();

    // Assert
    assertEquals("GetNodeInfo", actualGetNodeInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNodeInfo", actualGetNodeInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNodeInfoMethod.getType());
    assertFalse(actualGetNodeInfoMethod.isIdempotent());
    assertFalse(actualGetNodeInfoMethod.isSafe());
    assertTrue(actualGetNodeInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNodeInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetRewardInfoMethod()}
   */
  @Test
  public void testGetGetRewardInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.NumberMessage> actualGetRewardInfoMethod = WalletGrpc
        .getGetRewardInfoMethod();

    // Assert
    assertEquals("GetRewardInfo", actualGetRewardInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetRewardInfo", actualGetRewardInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetRewardInfoMethod.getType());
    assertFalse(actualGetRewardInfoMethod.isIdempotent());
    assertFalse(actualGetRewardInfoMethod.isSafe());
    assertTrue(actualGetRewardInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetRewardInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBrokerageInfoMethod()}
   */
  @Test
  public void testGetGetBrokerageInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.NumberMessage> actualGetBrokerageInfoMethod = WalletGrpc
        .getGetBrokerageInfoMethod();

    // Assert
    assertEquals("GetBrokerageInfo", actualGetBrokerageInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBrokerageInfo", actualGetBrokerageInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBrokerageInfoMethod.getType());
    assertFalse(actualGetBrokerageInfoMethod.isIdempotent());
    assertFalse(actualGetBrokerageInfoMethod.isSafe());
    assertTrue(actualGetBrokerageInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBrokerageInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getUpdateBrokerageMethod()}
   */
  @Test
  public void testGetUpdateBrokerageMethod() {
    // Arrange and Act
    MethodDescriptor<StorageContract.UpdateBrokerageContract, GrpcAPI.TransactionExtention> actualUpdateBrokerageMethod = WalletGrpc
        .getUpdateBrokerageMethod();

    // Assert
    assertEquals("UpdateBrokerage", actualUpdateBrokerageMethod.getBareMethodName());
    assertEquals("protocol.Wallet/UpdateBrokerage", actualUpdateBrokerageMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualUpdateBrokerageMethod.getType());
    assertFalse(actualUpdateBrokerageMethod.isIdempotent());
    assertFalse(actualUpdateBrokerageMethod.isSafe());
    assertTrue(actualUpdateBrokerageMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualUpdateBrokerageMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateShieldedTransactionMethod()}
   */
  @Test
  public void testGetCreateShieldedTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PrivateParameters, GrpcAPI.TransactionExtention> actualCreateShieldedTransactionMethod = WalletGrpc
        .getCreateShieldedTransactionMethod();

    // Assert
    assertEquals("CreateShieldedTransaction", actualCreateShieldedTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedTransaction",
        actualCreateShieldedTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateShieldedTransactionMethod.getType());
    assertFalse(actualCreateShieldedTransactionMethod.isIdempotent());
    assertFalse(actualCreateShieldedTransactionMethod.isSafe());
    assertTrue(actualCreateShieldedTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMerkleTreeVoucherInfoMethod()}
   */
  @Test
  public void testGetGetMerkleTreeVoucherInfoMethod() {
    // Arrange and Act
    MethodDescriptor<ShieldContract.OutputPointInfo, ShieldContract.IncrementalMerkleVoucherInfo> actualGetMerkleTreeVoucherInfoMethod = WalletGrpc
        .getGetMerkleTreeVoucherInfoMethod();

    // Assert
    assertEquals("GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMerkleTreeVoucherInfo", actualGetMerkleTreeVoucherInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMerkleTreeVoucherInfoMethod.getType());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isIdempotent());
    assertFalse(actualGetMerkleTreeVoucherInfoMethod.isSafe());
    assertTrue(actualGetMerkleTreeVoucherInfoMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMerkleTreeVoucherInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getScanNoteByIvkMethod()}
   */
  @Test
  public void testGetScanNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptParameters, GrpcAPI.DecryptNotes> actualScanNoteByIvkMethod = WalletGrpc
        .getScanNoteByIvkMethod();

    // Assert
    assertEquals("ScanNoteByIvk", actualScanNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanNoteByIvk", actualScanNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanNoteByIvkMethod.getType());
    assertFalse(actualScanNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanNoteByIvkMethod.isSafe());
    assertTrue(actualScanNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanNoteByIvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getScanAndMarkNoteByIvkMethod()}
   */
  @Test
  public void testGetScanAndMarkNoteByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptAndMarkParameters, GrpcAPI.DecryptNotesMarked> actualScanAndMarkNoteByIvkMethod = WalletGrpc
        .getScanAndMarkNoteByIvkMethod();

    // Assert
    assertEquals("ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanAndMarkNoteByIvk", actualScanAndMarkNoteByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanAndMarkNoteByIvkMethod.getType());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isIdempotent());
    assertFalse(actualScanAndMarkNoteByIvkMethod.isSafe());
    assertTrue(actualScanAndMarkNoteByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanAndMarkNoteByIvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getScanNoteByOvkMethod()}
   */
  @Test
  public void testGetScanNoteByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.OvkDecryptParameters, GrpcAPI.DecryptNotes> actualScanNoteByOvkMethod = WalletGrpc
        .getScanNoteByOvkMethod();

    // Assert
    assertEquals("ScanNoteByOvk", actualScanNoteByOvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanNoteByOvk", actualScanNoteByOvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanNoteByOvkMethod.getType());
    assertFalse(actualScanNoteByOvkMethod.isIdempotent());
    assertFalse(actualScanNoteByOvkMethod.isSafe());
    assertTrue(actualScanNoteByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanNoteByOvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetSpendingKeyMethod()}
   */
  @Test
  public void testGetGetSpendingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.BytesMessage> actualGetSpendingKeyMethod = WalletGrpc
        .getGetSpendingKeyMethod();

    // Assert
    assertEquals("GetSpendingKey", actualGetSpendingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetSpendingKey", actualGetSpendingKeyMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetSpendingKeyMethod.getType());
    assertFalse(actualGetSpendingKeyMethod.isIdempotent());
    assertFalse(actualGetSpendingKeyMethod.isSafe());
    assertTrue(actualGetSpendingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetSpendingKeyMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetExpandedSpendingKeyMethod()}
   */
  @Test
  public void testGetGetExpandedSpendingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.ExpandedSpendingKeyMessage> actualGetExpandedSpendingKeyMethod = WalletGrpc
        .getGetExpandedSpendingKeyMethod();

    // Assert
    assertEquals("GetExpandedSpendingKey", actualGetExpandedSpendingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetExpandedSpendingKey", actualGetExpandedSpendingKeyMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetExpandedSpendingKeyMethod.getType());
    assertFalse(actualGetExpandedSpendingKeyMethod.isIdempotent());
    assertFalse(actualGetExpandedSpendingKeyMethod.isSafe());
    assertTrue(actualGetExpandedSpendingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetExpandedSpendingKeyMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetAkFromAskMethod()}
   */
  @Test
  public void testGetGetAkFromAskMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.BytesMessage> actualGetAkFromAskMethod = WalletGrpc
        .getGetAkFromAskMethod();

    // Assert
    assertEquals("GetAkFromAsk", actualGetAkFromAskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetAkFromAsk", actualGetAkFromAskMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetAkFromAskMethod.getType());
    assertFalse(actualGetAkFromAskMethod.isIdempotent());
    assertFalse(actualGetAkFromAskMethod.isSafe());
    assertTrue(actualGetAkFromAskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetAkFromAskMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNkFromNskMethod()}
   */
  @Test
  public void testGetGetNkFromNskMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, GrpcAPI.BytesMessage> actualGetNkFromNskMethod = WalletGrpc
        .getGetNkFromNskMethod();

    // Assert
    assertEquals("GetNkFromNsk", actualGetNkFromNskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNkFromNsk", actualGetNkFromNskMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNkFromNskMethod.getType());
    assertFalse(actualGetNkFromNskMethod.isIdempotent());
    assertFalse(actualGetNkFromNskMethod.isSafe());
    assertTrue(actualGetNkFromNskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNkFromNskMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetIncomingViewingKeyMethod()}
   */
  @Test
  public void testGetGetIncomingViewingKeyMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.ViewingKeyMessage, GrpcAPI.IncomingViewingKeyMessage> actualGetIncomingViewingKeyMethod = WalletGrpc
        .getGetIncomingViewingKeyMethod();

    // Assert
    assertEquals("GetIncomingViewingKey", actualGetIncomingViewingKeyMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetIncomingViewingKey", actualGetIncomingViewingKeyMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetIncomingViewingKeyMethod.getType());
    assertFalse(actualGetIncomingViewingKeyMethod.isIdempotent());
    assertFalse(actualGetIncomingViewingKeyMethod.isSafe());
    assertTrue(actualGetIncomingViewingKeyMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetIncomingViewingKeyMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetDiversifierMethod()}
   */
  @Test
  public void testGetGetDiversifierMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.DiversifierMessage> actualGetDiversifierMethod = WalletGrpc
        .getGetDiversifierMethod();

    // Assert
    assertEquals("GetDiversifier", actualGetDiversifierMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetDiversifier", actualGetDiversifierMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDiversifierMethod.getType());
    assertFalse(actualGetDiversifierMethod.isIdempotent());
    assertFalse(actualGetDiversifierMethod.isSafe());
    assertTrue(actualGetDiversifierMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetDiversifierMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetNewShieldedAddressMethod()}
   */
  @Test
  public void testGetGetNewShieldedAddressMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.ShieldedAddressInfo> actualGetNewShieldedAddressMethod = WalletGrpc
        .getGetNewShieldedAddressMethod();

    // Assert
    assertEquals("GetNewShieldedAddress", actualGetNewShieldedAddressMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetNewShieldedAddress", actualGetNewShieldedAddressMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNewShieldedAddressMethod.getType());
    assertFalse(actualGetNewShieldedAddressMethod.isIdempotent());
    assertFalse(actualGetNewShieldedAddressMethod.isSafe());
    assertTrue(actualGetNewShieldedAddressMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetNewShieldedAddressMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetZenPaymentAddressMethod()}
   */
  @Test
  public void testGetGetZenPaymentAddressMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IncomingViewingKeyDiversifierMessage, GrpcAPI.PaymentAddressMessage> actualGetZenPaymentAddressMethod = WalletGrpc
        .getGetZenPaymentAddressMethod();

    // Assert
    assertEquals("GetZenPaymentAddress", actualGetZenPaymentAddressMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetZenPaymentAddress", actualGetZenPaymentAddressMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetZenPaymentAddressMethod.getType());
    assertFalse(actualGetZenPaymentAddressMethod.isIdempotent());
    assertFalse(actualGetZenPaymentAddressMethod.isSafe());
    assertTrue(actualGetZenPaymentAddressMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetZenPaymentAddressMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetRcmMethod()}
   */
  @Test
  public void testGetGetRcmMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.BytesMessage> actualGetRcmMethod = WalletGrpc.getGetRcmMethod();

    // Assert
    assertEquals("GetRcm", actualGetRcmMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetRcm", actualGetRcmMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetRcmMethod.getType());
    assertFalse(actualGetRcmMethod.isIdempotent());
    assertFalse(actualGetRcmMethod.isSafe());
    assertTrue(actualGetRcmMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetRcmMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getIsSpendMethod()}
   */
  @Test
  public void testGetIsSpendMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NoteParameters, GrpcAPI.SpendResult> actualIsSpendMethod = WalletGrpc.getIsSpendMethod();

    // Assert
    assertEquals("IsSpend", actualIsSpendMethod.getBareMethodName());
    assertEquals("protocol.Wallet/IsSpend", actualIsSpendMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualIsSpendMethod.getType());
    assertFalse(actualIsSpendMethod.isIdempotent());
    assertFalse(actualIsSpendMethod.isSafe());
    assertTrue(actualIsSpendMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualIsSpendMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getCreateShieldedTransactionWithoutSpendAuthSigMethod()}
   */
  @Test
  public void testGetCreateShieldedTransactionWithoutSpendAuthSigMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PrivateParametersWithoutAsk, GrpcAPI.TransactionExtention> actualCreateShieldedTransactionWithoutSpendAuthSigMethod = WalletGrpc
        .getCreateShieldedTransactionWithoutSpendAuthSigMethod();

    // Assert
    assertEquals("CreateShieldedTransactionWithoutSpendAuthSig",
        actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedTransactionWithoutSpendAuthSig",
        actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getType());
    assertFalse(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isIdempotent());
    assertFalse(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isSafe());
    assertTrue(actualCreateShieldedTransactionWithoutSpendAuthSigMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedTransactionWithoutSpendAuthSigMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetShieldTransactionHashMethod()}
   */
  @Test
  public void testGetGetShieldTransactionHashMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Transaction, GrpcAPI.BytesMessage> actualGetShieldTransactionHashMethod = WalletGrpc
        .getGetShieldTransactionHashMethod();

    // Assert
    assertEquals("GetShieldTransactionHash", actualGetShieldTransactionHashMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetShieldTransactionHash", actualGetShieldTransactionHashMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetShieldTransactionHashMethod.getType());
    assertFalse(actualGetShieldTransactionHashMethod.isIdempotent());
    assertFalse(actualGetShieldTransactionHashMethod.isSafe());
    assertTrue(actualGetShieldTransactionHashMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetShieldTransactionHashMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateSpendAuthSigMethod()}
   */
  @Test
  public void testGetCreateSpendAuthSigMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.SpendAuthSigParameters, GrpcAPI.BytesMessage> actualCreateSpendAuthSigMethod = WalletGrpc
        .getCreateSpendAuthSigMethod();

    // Assert
    assertEquals("CreateSpendAuthSig", actualCreateSpendAuthSigMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateSpendAuthSig", actualCreateSpendAuthSigMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateSpendAuthSigMethod.getType());
    assertFalse(actualCreateSpendAuthSigMethod.isIdempotent());
    assertFalse(actualCreateSpendAuthSigMethod.isSafe());
    assertTrue(actualCreateSpendAuthSigMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateSpendAuthSigMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateShieldNullifierMethod()}
   */
  @Test
  public void testGetCreateShieldNullifierMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NfParameters, GrpcAPI.BytesMessage> actualCreateShieldNullifierMethod = WalletGrpc
        .getCreateShieldNullifierMethod();

    // Assert
    assertEquals("CreateShieldNullifier", actualCreateShieldNullifierMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldNullifier", actualCreateShieldNullifierMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateShieldNullifierMethod.getType());
    assertFalse(actualCreateShieldNullifierMethod.isIdempotent());
    assertFalse(actualCreateShieldNullifierMethod.isSafe());
    assertTrue(actualCreateShieldNullifierMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldNullifierMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getCreateShieldedContractParametersMethod()}
   */
  @Test
  public void testGetCreateShieldedContractParametersMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PrivateShieldedTRC20Parameters, GrpcAPI.ShieldedTRC20Parameters> actualCreateShieldedContractParametersMethod = WalletGrpc
        .getCreateShieldedContractParametersMethod();

    // Assert
    assertEquals("CreateShieldedContractParameters", actualCreateShieldedContractParametersMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedContractParameters",
        actualCreateShieldedContractParametersMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateShieldedContractParametersMethod.getType());
    assertFalse(actualCreateShieldedContractParametersMethod.isIdempotent());
    assertFalse(actualCreateShieldedContractParametersMethod.isSafe());
    assertTrue(actualCreateShieldedContractParametersMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedContractParametersMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getCreateShieldedContractParametersWithoutAskMethod()}
   */
  @Test
  public void testGetCreateShieldedContractParametersWithoutAskMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, GrpcAPI.ShieldedTRC20Parameters> actualCreateShieldedContractParametersWithoutAskMethod = WalletGrpc
        .getCreateShieldedContractParametersWithoutAskMethod();

    // Assert
    assertEquals("CreateShieldedContractParametersWithoutAsk",
        actualCreateShieldedContractParametersWithoutAskMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateShieldedContractParametersWithoutAsk",
        actualCreateShieldedContractParametersWithoutAskMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateShieldedContractParametersWithoutAskMethod.getType());
    assertFalse(actualCreateShieldedContractParametersWithoutAskMethod.isIdempotent());
    assertFalse(actualCreateShieldedContractParametersWithoutAskMethod.isSafe());
    assertTrue(actualCreateShieldedContractParametersWithoutAskMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateShieldedContractParametersWithoutAskMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getScanShieldedTRC20NotesByIvkMethod()}
   */
  @Test
  public void testGetScanShieldedTRC20NotesByIvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.IvkDecryptTRC20Parameters, GrpcAPI.DecryptNotesTRC20> actualScanShieldedTRC20NotesByIvkMethod = WalletGrpc
        .getScanShieldedTRC20NotesByIvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByIvk", actualScanShieldedTRC20NotesByIvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanShieldedTRC20NotesByIvk",
        actualScanShieldedTRC20NotesByIvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanShieldedTRC20NotesByIvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByIvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByIvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByIvkMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getScanShieldedTRC20NotesByOvkMethod()}
   */
  @Test
  public void testGetScanShieldedTRC20NotesByOvkMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.OvkDecryptTRC20Parameters, GrpcAPI.DecryptNotesTRC20> actualScanShieldedTRC20NotesByOvkMethod = WalletGrpc
        .getScanShieldedTRC20NotesByOvkMethod();

    // Assert
    assertEquals("ScanShieldedTRC20NotesByOvk", actualScanShieldedTRC20NotesByOvkMethod.getBareMethodName());
    assertEquals("protocol.Wallet/ScanShieldedTRC20NotesByOvk",
        actualScanShieldedTRC20NotesByOvkMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualScanShieldedTRC20NotesByOvkMethod.getType());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isIdempotent());
    assertFalse(actualScanShieldedTRC20NotesByOvkMethod.isSafe());
    assertTrue(actualScanShieldedTRC20NotesByOvkMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualScanShieldedTRC20NotesByOvkMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getIsShieldedTRC20ContractNoteSpentMethod()}
   */
  @Test
  public void testGetIsShieldedTRC20ContractNoteSpentMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NfTRC20Parameters, GrpcAPI.NullifierResult> actualIsShieldedTRC20ContractNoteSpentMethod = WalletGrpc
        .getIsShieldedTRC20ContractNoteSpentMethod();

    // Assert
    assertEquals("IsShieldedTRC20ContractNoteSpent", actualIsShieldedTRC20ContractNoteSpentMethod.getBareMethodName());
    assertEquals("protocol.Wallet/IsShieldedTRC20ContractNoteSpent",
        actualIsShieldedTRC20ContractNoteSpentMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualIsShieldedTRC20ContractNoteSpentMethod.getType());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isIdempotent());
    assertFalse(actualIsShieldedTRC20ContractNoteSpentMethod.isSafe());
    assertTrue(actualIsShieldedTRC20ContractNoteSpentMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualIsShieldedTRC20ContractNoteSpentMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getGetTriggerInputForShieldedTRC20ContractMethod()}
   */
  @Test
  public void testGetGetTriggerInputForShieldedTRC20ContractMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.ShieldedTRC20TriggerContractParameters, GrpcAPI.BytesMessage> actualGetTriggerInputForShieldedTRC20ContractMethod = WalletGrpc
        .getGetTriggerInputForShieldedTRC20ContractMethod();

    // Assert
    assertEquals("GetTriggerInputForShieldedTRC20Contract",
        actualGetTriggerInputForShieldedTRC20ContractMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTriggerInputForShieldedTRC20Contract",
        actualGetTriggerInputForShieldedTRC20ContractMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTriggerInputForShieldedTRC20ContractMethod.getType());
    assertFalse(actualGetTriggerInputForShieldedTRC20ContractMethod.isIdempotent());
    assertFalse(actualGetTriggerInputForShieldedTRC20ContractMethod.isSafe());
    assertTrue(actualGetTriggerInputForShieldedTRC20ContractMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTriggerInputForShieldedTRC20ContractMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getCreateCommonTransactionMethod()}
   */
  @Test
  public void testGetCreateCommonTransactionMethod() {
    // Arrange and Act
    MethodDescriptor<Protocol.Transaction, GrpcAPI.TransactionExtention> actualCreateCommonTransactionMethod = WalletGrpc
        .getCreateCommonTransactionMethod();

    // Assert
    assertEquals("CreateCommonTransaction", actualCreateCommonTransactionMethod.getBareMethodName());
    assertEquals("protocol.Wallet/CreateCommonTransaction", actualCreateCommonTransactionMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCreateCommonTransactionMethod.getType());
    assertFalse(actualCreateCommonTransactionMethod.isIdempotent());
    assertFalse(actualCreateCommonTransactionMethod.isSafe());
    assertTrue(actualCreateCommonTransactionMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualCreateCommonTransactionMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionInfoByBlockNumMethod()}
   */
  @Test
  public void testGetGetTransactionInfoByBlockNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, GrpcAPI.TransactionInfoList> actualGetTransactionInfoByBlockNumMethod = WalletGrpc
        .getGetTransactionInfoByBlockNumMethod();

    // Assert
    assertEquals("GetTransactionInfoByBlockNum", actualGetTransactionInfoByBlockNumMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionInfoByBlockNum",
        actualGetTransactionInfoByBlockNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionInfoByBlockNumMethod.getType());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isIdempotent());
    assertFalse(actualGetTransactionInfoByBlockNumMethod.isSafe());
    assertTrue(actualGetTransactionInfoByBlockNumMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionInfoByBlockNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBurnTrxMethod()}
   */
  @Test
  public void testGetGetBurnTrxMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NumberMessage> actualGetBurnTrxMethod = WalletGrpc
        .getGetBurnTrxMethod();

    // Assert
    assertEquals("GetBurnTrx", actualGetBurnTrxMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBurnTrx", actualGetBurnTrxMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBurnTrxMethod.getType());
    assertFalse(actualGetBurnTrxMethod.isIdempotent());
    assertFalse(actualGetBurnTrxMethod.isSafe());
    assertTrue(actualGetBurnTrxMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBurnTrxMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetTransactionFromPendingMethod()}
   */
  @Test
  public void testGetGetTransactionFromPendingMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BytesMessage, Protocol.Transaction> actualGetTransactionFromPendingMethod = WalletGrpc
        .getGetTransactionFromPendingMethod();

    // Assert
    assertEquals("GetTransactionFromPending", actualGetTransactionFromPendingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionFromPending",
        actualGetTransactionFromPendingMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionFromPendingMethod.getType());
    assertFalse(actualGetTransactionFromPendingMethod.isIdempotent());
    assertFalse(actualGetTransactionFromPendingMethod.isSafe());
    assertTrue(actualGetTransactionFromPendingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionFromPendingMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletGrpc#getGetTransactionListFromPendingMethod()}
   */
  @Test
  public void testGetGetTransactionListFromPendingMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.TransactionIdList> actualGetTransactionListFromPendingMethod = WalletGrpc
        .getGetTransactionListFromPendingMethod();

    // Assert
    assertEquals("GetTransactionListFromPending", actualGetTransactionListFromPendingMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetTransactionListFromPending",
        actualGetTransactionListFromPendingMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionListFromPendingMethod.getType());
    assertFalse(actualGetTransactionListFromPendingMethod.isIdempotent());
    assertFalse(actualGetTransactionListFromPendingMethod.isSafe());
    assertTrue(actualGetTransactionListFromPendingMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetTransactionListFromPendingMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetPendingSizeMethod()}
   */
  @Test
  public void testGetGetPendingSizeMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.NumberMessage> actualGetPendingSizeMethod = WalletGrpc
        .getGetPendingSizeMethod();

    // Assert
    assertEquals("GetPendingSize", actualGetPendingSizeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetPendingSize", actualGetPendingSizeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetPendingSizeMethod.getType());
    assertFalse(actualGetPendingSizeMethod.isIdempotent());
    assertFalse(actualGetPendingSizeMethod.isSafe());
    assertTrue(actualGetPendingSizeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetPendingSizeMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBlockMethod()}
   */
  @Test
  public void testGetGetBlockMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.BlockReq, GrpcAPI.BlockExtention> actualGetBlockMethod = WalletGrpc.getGetBlockMethod();

    // Assert
    assertEquals("GetBlock", actualGetBlockMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBlock", actualGetBlockMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockMethod.getType());
    assertFalse(actualGetBlockMethod.isIdempotent());
    assertFalse(actualGetBlockMethod.isSafe());
    assertTrue(actualGetBlockMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBlockMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetBandwidthPricesMethod()}
   */
  @Test
  public void testGetGetBandwidthPricesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.PricesResponseMessage> actualGetBandwidthPricesMethod = WalletGrpc
        .getGetBandwidthPricesMethod();

    // Assert
    assertEquals("GetBandwidthPrices", actualGetBandwidthPricesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetBandwidthPrices", actualGetBandwidthPricesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBandwidthPricesMethod.getType());
    assertFalse(actualGetBandwidthPricesMethod.isIdempotent());
    assertFalse(actualGetBandwidthPricesMethod.isSafe());
    assertTrue(actualGetBandwidthPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetBandwidthPricesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetEnergyPricesMethod()}
   */
  @Test
  public void testGetGetEnergyPricesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.PricesResponseMessage> actualGetEnergyPricesMethod = WalletGrpc
        .getGetEnergyPricesMethod();

    // Assert
    assertEquals("GetEnergyPrices", actualGetEnergyPricesMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetEnergyPrices", actualGetEnergyPricesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetEnergyPricesMethod.getType());
    assertFalse(actualGetEnergyPricesMethod.isIdempotent());
    assertFalse(actualGetEnergyPricesMethod.isSafe());
    assertTrue(actualGetEnergyPricesMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetEnergyPricesMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#getGetMemoFeeMethod()}
   */
  @Test
  public void testGetGetMemoFeeMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.PricesResponseMessage> actualGetMemoFeeMethod = WalletGrpc
        .getGetMemoFeeMethod();

    // Assert
    assertEquals("GetMemoFee", actualGetMemoFeeMethod.getBareMethodName());
    assertEquals("protocol.Wallet/GetMemoFee", actualGetMemoFeeMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetMemoFeeMethod.getType());
    assertFalse(actualGetMemoFeeMethod.isIdempotent());
    assertFalse(actualGetMemoFeeMethod.isSafe());
    assertTrue(actualGetMemoFeeMethod.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, actualGetMemoFeeMethod.getServiceName());
  }

  /**
   * Method under test: {@link WalletGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletGrpc.WalletStub actualNewStubResult = WalletGrpc.newStub(channel);

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
   * Method under test: {@link WalletGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletGrpc.WalletBlockingStub actualNewBlockingStubResult = WalletGrpc.newBlockingStub(channel);

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
   * Method under test: {@link WalletGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletGrpc.WalletFutureStub actualNewFutureStubResult = WalletGrpc.newFutureStub(channel);

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
   * Method under test: {@link WalletGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(146, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("GetAccount", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("GetAccountBalance", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("GetAccountById", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(143);
    assertEquals("GetBandwidthPrices", getResult4.getBareMethodName());
    MethodDescriptor<?, ?> getResult5 = ((List<MethodDescriptor<?, ?>>) methods).get(144);
    assertEquals("GetEnergyPrices", getResult5.getBareMethodName());
    MethodDescriptor<?, ?> getResult6 = ((List<MethodDescriptor<?, ?>>) methods).get(145);
    assertEquals("GetMemoFee", getResult6.getBareMethodName());
    assertEquals("protocol.Wallet/GetAccount", getResult.getFullMethodName());
    assertEquals("protocol.Wallet/GetAccountBalance", getResult2.getFullMethodName());
    assertEquals("protocol.Wallet/GetAccountById", getResult3.getFullMethodName());
    assertEquals("protocol.Wallet/GetBandwidthPrices", getResult4.getFullMethodName());
    assertEquals("protocol.Wallet/GetEnergyPrices", getResult5.getFullMethodName());
    assertEquals("protocol.Wallet/GetMemoFee", getResult6.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult5.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult6.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult5.isIdempotent());
    assertFalse(getResult6.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult5.isSafe());
    assertFalse(getResult6.isSafe());
    assertFalse(getResult2.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult5.isSampledToLocalTracing());
    assertTrue(getResult6.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult5.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult6.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(WalletGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
