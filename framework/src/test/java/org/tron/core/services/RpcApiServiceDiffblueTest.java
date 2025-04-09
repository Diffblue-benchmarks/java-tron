package org.tron.core.services;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.api.GrpcAPI;
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
import org.tron.api.GrpcAPI.DecryptNotesTRC20;
import org.tron.api.GrpcAPI.DelegatedResourceList;
import org.tron.api.GrpcAPI.DelegatedResourceMessage;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.GrpcAPI.EstimateEnergyMessage;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountRequestMessage;
import org.tron.api.GrpcAPI.GetAvailableUnfreezeCountResponseMessage;
import org.tron.api.GrpcAPI.IvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.NfTRC20Parameters;
import org.tron.api.GrpcAPI.NoteParameters;
import org.tron.api.GrpcAPI.NullifierResult;
import org.tron.api.GrpcAPI.NumberMessage;
import org.tron.api.GrpcAPI.OvkDecryptTRC20Parameters;
import org.tron.api.GrpcAPI.PricesResponseMessage;
import org.tron.api.GrpcAPI.PrivateParameters;
import org.tron.api.GrpcAPI.PrivateParametersWithoutAsk;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk;
import org.tron.api.GrpcAPI.ShieldedAddressInfo;
import org.tron.api.GrpcAPI.ShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.ShieldedTRC20TriggerContractParameters;
import org.tron.api.GrpcAPI.SpendAuthSigParameters;
import org.tron.api.GrpcAPI.SpendResult;
import org.tron.api.GrpcAPI.TransactionExtention;
import org.tron.api.GrpcAPI.TransactionIdList;
import org.tron.api.GrpcAPI.TransactionInfoList;
import org.tron.core.db.Manager;
import org.tron.core.service.MortgageService;
import org.tron.core.services.RpcApiService.WalletApi;
import org.tron.core.services.RpcApiService.WalletSolidityApi;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.DelegatedResourceAccountIndex;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrderList;
import org.tron.protos.Protocol.MarketOrderPair;
import org.tron.protos.Protocol.MarketOrderPairList;
import org.tron.protos.Protocol.MarketPriceList;
import org.tron.protos.Protocol.NodeInfo;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.AccountContract.AccountCreateContract;
import org.tron.protos.contract.AccountContract.AccountPermissionUpdateContract;
import org.tron.protos.contract.AccountContract.AccountUpdateContract;
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
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateEnergyLimitContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateSettingContract;
import org.tron.protos.contract.StorageContract;
import org.tron.protos.contract.StorageContract.UpdateBrokerageContract;
import org.tron.protos.contract.WitnessContract;
import org.tron.protos.contract.WitnessContract.VoteWitnessContract;
import org.tron.protos.contract.WitnessContract.WitnessCreateContract;
import org.tron.protos.contract.WitnessContract.WitnessUpdateContract;

@RunWith(MockitoJUnitRunner.class)
public class RpcApiServiceDiffblueTest {
  @Mock
  private Manager manager;

  @InjectMocks
  private RpcApiService rpcApiService;

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getMortgageService()} return {@link MortgageService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_givenManagerGetMortgageServiceReturnMortgageService() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(new MortgageService());
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getMortgageService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getMortgageService()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_givenManagerGetMortgageServiceReturnNull() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(null);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getMortgageService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_givenRuntimeExceptionWithFoo() {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_thenThrowIllegalArgumentException() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(new MortgageService());
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getRewardInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getMortgageService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_whenNull() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(mock(MortgageService.class));
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getMortgageService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.</li>
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetRewardInfoCommon_whenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_givenManagerGetDynamicPropertiesStoreReturnNull() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_givenRuntimeExceptionWithFoo() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_thenThrowIllegalArgumentException() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBurnTrxCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.</li>
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_whenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDelegationStore()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_givenManagerGetDelegationStoreReturnNull() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDelegationStore()} return {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_givenManagerGetDelegationStoreReturnNull_whenNull() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_givenManagerGetDynamicPropertiesStoreReturnNull() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_givenRuntimeExceptionWithFoo() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_thenThrowIllegalArgumentException() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBrokerageInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.</li>
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetBrokerageInfoCommon_whenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetTransactionFromPendingCommon_thenThrowIllegalArgumentException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetTransactionFromPendingCommon_whenDefaultInstance_thenCallsOnCompleted() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testGetTransactionFromPendingCommon_whenNull_thenCallsOnCompleted() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionFromPendingCommon(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetTransactionListFromPendingCommon_givenArrayListAddFoo() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetTransactionListFromPendingCommon_thenThrowIllegalArgumentException() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetTransactionListFromPendingCommon_thenThrowRuntimeException() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onCompleted()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetTransactionListFromPendingCommon_whenStreamObserverOnCompletedDoesNothing() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act
    rpcApiService.getTransactionListFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetPendingSizeCommon_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<NumberMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetPendingSizeCommon_thenThrowIllegalArgumentException() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<NumberMessage>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onCompleted()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetPendingSizeCommon_whenStreamObserverOnCompletedDoesNothing() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());

    // Act
    rpcApiService.getPendingSizeCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_thenThrowIllegalArgumentException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BlockReq request = BlockReq.getDefaultInstance();
    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onCompleted()} does nothing.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_whenStreamObserverOnCompletedDoesNothing_thenCallsOnCompleted() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BlockReq request = BlockReq.getDefaultInstance();
    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBlockCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#accountPermissionUpdate(AccountPermissionUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)"})
  public void testWalletApiAccountPermissionUpdate_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountPermissionUpdateContract request = AccountPermissionUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.accountPermissionUpdate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#accountPermissionUpdate(AccountPermissionUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)"})
  public void testWalletApiAccountPermissionUpdate_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountPermissionUpdateContract request = AccountPermissionUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.accountPermissionUpdate(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#cancelAllUnfreezeV2(CancelAllUnfreezeV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)"})
  public void testWalletApiCancelAllUnfreezeV2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CancelAllUnfreezeV2Contract request = CancelAllUnfreezeV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.cancelAllUnfreezeV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#cancelAllUnfreezeV2(CancelAllUnfreezeV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)"})
  public void testWalletApiCancelAllUnfreezeV2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CancelAllUnfreezeV2Contract request = CancelAllUnfreezeV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.cancelAllUnfreezeV2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#clearContractABI(ClearABIContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#clearContractABI(ClearABIContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.clearContractABI(ClearABIContract, StreamObserver)"})
  public void testWalletApiClearContractABI_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ClearABIContract request = ClearABIContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.clearContractABI(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#clearContractABI(ClearABIContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#clearContractABI(ClearABIContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.clearContractABI(ClearABIContract, StreamObserver)"})
  public void testWalletApiClearContractABI_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ClearABIContract request = ClearABIContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.clearContractABI(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createAccount2(AccountCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createAccount2(AccountCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createAccount2(AccountCreateContract, StreamObserver)"})
  public void testWalletApiCreateAccount2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountCreateContract request = AccountCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createAccount2(AccountCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createAccount2(AccountCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createAccount2(AccountCreateContract, StreamObserver)"})
  public void testWalletApiCreateAccount2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountCreateContract request = AccountCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createAssetIssue2(AssetIssueContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createAssetIssue2(AssetIssueContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createAssetIssue2(AssetIssueContract, StreamObserver)"})
  public void testWalletApiCreateAssetIssue2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContract request = AssetIssueContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createAssetIssue2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createAssetIssue2(AssetIssueContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createAssetIssue2(AssetIssueContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createAssetIssue2(AssetIssueContract, StreamObserver)"})
  public void testWalletApiCreateAssetIssue2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContract request = AssetIssueContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createAssetIssue2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedContractParametersWithoutAsk(PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletApi#createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)"})
  public void testWalletApiCreateShieldedContractParametersWithoutAsk() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateShieldedTRC20ParametersWithoutAsk request = PrivateShieldedTRC20ParametersWithoutAsk.getDefaultInstance();
    StreamObserver<ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.createShieldedContractParametersWithoutAsk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedContractParametersWithoutAsk(PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)"})
  public void testWalletApiCreateShieldedContractParametersWithoutAsk_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateShieldedTRC20ParametersWithoutAsk request = PrivateShieldedTRC20ParametersWithoutAsk.getDefaultInstance();
    StreamObserver<ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createShieldedContractParametersWithoutAsk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedContractParameters(PrivateShieldedTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)"})
  public void testWalletApiCreateShieldedContractParameters_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateShieldedTRC20Parameters request = PrivateShieldedTRC20Parameters.getDefaultInstance();
    StreamObserver<ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createShieldedContractParameters(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedContractParameters(PrivateShieldedTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)"})
  public void testWalletApiCreateShieldedContractParameters_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateShieldedTRC20Parameters request = PrivateShieldedTRC20Parameters.getDefaultInstance();
    StreamObserver<ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createShieldedContractParameters(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletApi#createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)"})
  public void testWalletApiCreateShieldedTransactionWithoutSpendAuthSig() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateParametersWithoutAsk request = PrivateParametersWithoutAsk.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.createShieldedTransactionWithoutSpendAuthSig(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.createShieldedTransactionWithoutSpendAuthSig(PrivateParametersWithoutAsk, StreamObserver)"})
  public void testWalletApiCreateShieldedTransactionWithoutSpendAuthSig_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateParametersWithoutAsk request = PrivateParametersWithoutAsk.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createShieldedTransactionWithoutSpendAuthSig(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedTransaction(PrivateParameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)"})
  public void testWalletApiCreateShieldedTransaction_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateParameters request = PrivateParameters.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createShieldedTransaction(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createShieldedTransaction(PrivateParameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)"})
  public void testWalletApiCreateShieldedTransaction_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    PrivateParameters request = PrivateParameters.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createShieldedTransaction(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createSpendAuthSig(SpendAuthSigParameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createSpendAuthSig(SpendAuthSigParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createSpendAuthSig(SpendAuthSigParameters, StreamObserver)"})
  public void testWalletApiCreateSpendAuthSig_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SpendAuthSigParameters request = SpendAuthSigParameters.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createSpendAuthSig(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createSpendAuthSig(SpendAuthSigParameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createSpendAuthSig(SpendAuthSigParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createSpendAuthSig(SpendAuthSigParameters, StreamObserver)"})
  public void testWalletApiCreateSpendAuthSig_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SpendAuthSigParameters request = SpendAuthSigParameters.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createSpendAuthSig(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createTransaction2(TransferContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createTransaction2(BalanceContract.TransferContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createTransaction2(BalanceContract.TransferContract, StreamObserver)"})
  public void testWalletApiCreateTransaction2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TransferContract request = TransferContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createTransaction2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createTransaction2(TransferContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createTransaction2(BalanceContract.TransferContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createTransaction2(BalanceContract.TransferContract, StreamObserver)"})
  public void testWalletApiCreateTransaction2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TransferContract request = TransferContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createTransaction2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createWitness2(WitnessCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)"})
  public void testWalletApiCreateWitness2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessCreateContract request = WitnessCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.createWitness2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#createWitness2(WitnessCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)"})
  public void testWalletApiCreateWitness2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessCreateContract request = WitnessCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createWitness2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#delegateResource(DelegateResourceContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)"})
  public void testWalletApiDelegateResource_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    DelegateResourceContract request = DelegateResourceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.delegateResource(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#delegateResource(DelegateResourceContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)"})
  public void testWalletApiDelegateResource_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    DelegateResourceContract request = DelegateResourceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.delegateResource(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#deployContract(CreateSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#deployContract(CreateSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.deployContract(CreateSmartContract, StreamObserver)"})
  public void testWalletApiDeployContract_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CreateSmartContract request = CreateSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.deployContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#deployContract(CreateSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#deployContract(CreateSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.deployContract(CreateSmartContract, StreamObserver)"})
  public void testWalletApiDeployContract_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CreateSmartContract request = CreateSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.deployContract(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#estimateEnergy(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiEstimateEnergy_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<EstimateEnergyMessage>any());

    // Act
    walletApi.estimateEnergy(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(EstimateEnergyMessage.class));
  }

  /**
   * Test WalletApi {@link WalletApi#estimateEnergy(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiEstimateEnergy_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<EstimateEnergyMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.estimateEnergy(request, responseObserver));
    verify(responseObserver).onNext(isA(EstimateEnergyMessage.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeCreate(ExchangeCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)"})
  public void testWalletApiExchangeCreate_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeCreateContract request = ExchangeCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.exchangeCreate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeCreate(ExchangeCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)"})
  public void testWalletApiExchangeCreate_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeCreateContract request = ExchangeCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeCreate(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeInject(ExchangeInjectContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)"})
  public void testWalletApiExchangeInject_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeInjectContract request = ExchangeInjectContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.exchangeInject(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeInject(ExchangeInjectContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)"})
  public void testWalletApiExchangeInject_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeInjectContract request = ExchangeInjectContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeInject(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeTransaction(ExchangeTransactionContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)"})
  public void testWalletApiExchangeTransaction_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeTransactionContract request = ExchangeTransactionContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.exchangeTransaction(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeTransaction(ExchangeTransactionContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)"})
  public void testWalletApiExchangeTransaction_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeTransactionContract request = ExchangeTransactionContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeTransaction(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeWithdraw(ExchangeWithdrawContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)"})
  public void testWalletApiExchangeWithdraw_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeWithdrawContract request = ExchangeWithdrawContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.exchangeWithdraw(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#exchangeWithdraw(ExchangeWithdrawContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)"})
  public void testWalletApiExchangeWithdraw_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeWithdrawContract request = ExchangeWithdrawContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeWithdraw(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#freezeBalance2(FreezeBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)"})
  public void testWalletApiFreezeBalance2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    FreezeBalanceContract request = FreezeBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.freezeBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#freezeBalance2(FreezeBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)"})
  public void testWalletApiFreezeBalance2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    FreezeBalanceContract request = FreezeBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.freezeBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#freezeBalanceV2(FreezeBalanceV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)"})
  public void testWalletApiFreezeBalanceV2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    FreezeBalanceV2Contract request = FreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.freezeBalanceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#freezeBalanceV2(FreezeBalanceV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)"})
  public void testWalletApiFreezeBalanceV2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    FreezeBalanceV2Contract request = FreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.freezeBalanceV2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getAccountBalance(AccountBalanceRequest, StreamObserver)}.
   * <ul>
   *   <li>Given {@link WalletApi#WalletApi(RpcApiService)} with this$0 is {@link RpcApiService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)"})
  public void testWalletApiGetAccountBalance_givenWalletApiWithThis$0IsRpcApiService() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountBalanceRequest request = AccountBalanceRequest.getDefaultInstance();
    StreamObserver<AccountBalanceResponse> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAccountBalance(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getAccountBalance(AccountBalanceRequest, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)"})
  public void testWalletApiGetAccountBalance_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountBalanceRequest request = AccountBalanceRequest.getDefaultInstance();
    StreamObserver<AccountBalanceResponse> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getAccountBalance(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletApiGetAvailableUnfreezeCount_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GetAvailableUnfreezeCountRequestMessage request = GetAvailableUnfreezeCountRequestMessage.getDefaultInstance();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAvailableUnfreezeCount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletApiGetAvailableUnfreezeCount_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GetAvailableUnfreezeCountRequestMessage request = GetAvailableUnfreezeCountRequestMessage.getDefaultInstance();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getAvailableUnfreezeCount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletApiGetAvailableUnfreezeCount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAvailableUnfreezeCount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBandwidthPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetBandwidthPrices_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBandwidthPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBandwidthPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetBandwidthPrices_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBandwidthPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockBalanceTrace(BlockIdentifier, StreamObserver)}.
   * <ul>
   *   <li>Given {@link WalletApi#WalletApi(RpcApiService)} with this$0 is {@link RpcApiService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)"})
  public void testWalletApiGetBlockBalanceTrace_givenWalletApiWithThis$0IsRpcApiService() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockIdentifier request = BlockIdentifier.getDefaultInstance();
    StreamObserver<BlockBalanceTrace> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBlockBalanceTrace(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockBalanceTrace(BlockIdentifier, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)"})
  public void testWalletApiGetBlockBalanceTrace_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockIdentifier request = BlockIdentifier.getDefaultInstance();
    StreamObserver<BlockBalanceTrace> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockBalanceTrace(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLatestNum2(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetBlockByLatestNum2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<BlockListExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<BlockListExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLatestNum2(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLatestNum2(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetBlockByLatestNum2_whenDefaultInstance_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<BlockListExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<BlockListExtention>any());

    // Act
    walletApi.getBlockByLatestNum2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLatestNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetBlockByLatestNum_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<BlockList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<BlockList>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLatestNum(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLatestNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetBlockByLatestNum_whenDefaultInstance_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<BlockList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<BlockList>any());

    // Act
    walletApi.getBlockByLatestNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLimitNext2(BlockLimit, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLimitNext2(BlockLimit, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLimitNext2(BlockLimit, StreamObserver)"})
  public void testWalletApiGetBlockByLimitNext2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockLimit request = BlockLimit.getDefaultInstance();
    StreamObserver<BlockListExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<BlockListExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLimitNext2(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLimitNext2(BlockLimit, StreamObserver)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLimitNext2(BlockLimit, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLimitNext2(BlockLimit, StreamObserver)"})
  public void testWalletApiGetBlockByLimitNext2_whenDefaultInstance_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockLimit request = BlockLimit.getDefaultInstance();
    StreamObserver<BlockListExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<BlockListExtention>any());

    // Act
    walletApi.getBlockByLimitNext2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLimitNext(BlockLimit, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLimitNext(BlockLimit, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLimitNext(BlockLimit, StreamObserver)"})
  public void testWalletApiGetBlockByLimitNext_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockLimit request = BlockLimit.getDefaultInstance();
    StreamObserver<BlockList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<BlockList>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLimitNext(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlockByLimitNext(BlockLimit, StreamObserver)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlockByLimitNext(BlockLimit, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlockByLimitNext(BlockLimit, StreamObserver)"})
  public void testWalletApiGetBlockByLimitNext_whenDefaultInstance_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockLimit request = BlockLimit.getDefaultInstance();
    StreamObserver<BlockList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<BlockList>any());

    // Act
    walletApi.getBlockByLimitNext(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Test WalletApi {@link WalletApi#getBlock(BlockReq, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBlock(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBlock(GrpcAPI.BlockReq, StreamObserver)"})
  public void testWalletApiGetBlock_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BlockReq request = BlockReq.getDefaultInstance();
    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBlock(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBrokerageInfo(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetBrokerageInfo_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBrokerageInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getBurnTrx(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetBurnTrx_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBurnTrx(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanDelegatedMaxSize_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CanDelegatedMaxSizeRequestMessage request = CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanDelegatedMaxSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanDelegatedMaxSize_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CanDelegatedMaxSizeRequestMessage request = CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getCanDelegatedMaxSize(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanDelegatedMaxSize_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanDelegatedMaxSize(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanWithdrawUnfreezeAmount_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CanWithdrawUnfreezeAmountRequestMessage request = CanWithdrawUnfreezeAmountRequestMessage.getDefaultInstance();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanWithdrawUnfreezeAmount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanWithdrawUnfreezeAmount_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    CanWithdrawUnfreezeAmountRequestMessage request = CanWithdrawUnfreezeAmountRequestMessage.getDefaultInstance();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getCanWithdrawUnfreezeAmount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletApiGetCanWithdrawUnfreezeAmount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanWithdrawUnfreezeAmount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndexV2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndexV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndexV2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceAccountIndexV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndexV2_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndexV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndex_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndex(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndex_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceAccountIndex(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceAccountIndex_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndex(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceV2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    DelegatedResourceMessage request = DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceV2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    DelegatedResourceMessage request = DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletApiGetDelegatedResourceV2_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getEnergyPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetEnergyPrices_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getEnergyPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getEnergyPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetEnergyPrices_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getEnergyPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderByAccount_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderByAccount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderByAccount_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderByAccount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderByAccount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderByAccount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderById_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderById(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderById_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderById(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetMarketOrderById_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderById(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketOrderListByPair_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderListByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketOrderListByPair_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderListByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketOrderListByPair_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderListByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketPairList(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetMarketPairList_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPairList(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketPairList(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetMarketPairList_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketPairList(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketPriceByPair_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPriceByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketPriceByPair_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketPriceByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletApiGetMarketPriceByPair_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPriceByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMemoFee(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetMemoFee_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMemoFee(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMemoFee(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetMemoFee_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMemoFee(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)"})
  public void testWalletApiGetMerkleTreeVoucherInfo_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    OutputPointInfo request = OutputPointInfo.getDefaultInstance();
    StreamObserver<IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMerkleTreeVoucherInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)"})
  public void testWalletApiGetMerkleTreeVoucherInfo_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    OutputPointInfo request = OutputPointInfo.getDefaultInstance();
    StreamObserver<IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMerkleTreeVoucherInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getNewShieldedAddress(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetNewShieldedAddress_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<ShieldedAddressInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getNewShieldedAddress(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getNewShieldedAddress(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetNewShieldedAddress_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<ShieldedAddressInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getNewShieldedAddress(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getNodeInfo(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetNodeInfo_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NodeInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getNodeInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getNodeInfo(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetNodeInfo_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NodeInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getNodeInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getPendingSize(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getPendingSize(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getPendingSize(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetPendingSize_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getPendingSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getRcm(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Given {@link WalletApi#WalletApi(RpcApiService)} with this$0 is {@link RpcApiService} (default constructor).</li>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getRcm(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getRcm(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetRcm_givenWalletApiWithThis$0IsRpcApiService_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getRcm(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getRcm(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getRcm(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getRcm(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetRcm_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getRcm(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getRewardInfo(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetRewardInfo_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getRewardInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getShieldTransactionHash(Transaction, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getShieldTransactionHash(Protocol.Transaction, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getShieldTransactionHash(Protocol.Transaction, StreamObserver)"})
  public void testWalletApiGetShieldTransactionHash_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Transaction request = Transaction.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getShieldTransactionHash(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getShieldTransactionHash(Transaction, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getShieldTransactionHash(Protocol.Transaction, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getShieldTransactionHash(Protocol.Transaction, StreamObserver)"})
  public void testWalletApiGetShieldTransactionHash_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Transaction request = Transaction.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getShieldTransactionHash(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getSpendingKey(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetSpendingKey_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getSpendingKey(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getSpendingKey(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetSpendingKey_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getSpendingKey(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionCountByBlockNum(NumberMessage, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletApi#getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetTransactionCountByBlockNum() {
    // Arrange
    RpcApiService rpcApiService = mock(RpcApiService.class);
    doNothing().when(rpcApiService)
        .getTransactionCountByBlockNumCommon(Mockito.<NumberMessage>any(),
            Mockito.<StreamObserver<NumberMessage>>any());
    WalletApi walletApi = rpcApiService.new WalletApi();

    // Act
    walletApi.getTransactionCountByBlockNum(NumberMessage.getDefaultInstance(), mock(StreamObserver.class));

    // Assert
    verify(rpcApiService).getTransactionCountByBlockNumCommon(isA(NumberMessage.class), isA(StreamObserver.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionFromPending(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetTransactionFromPending_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionFromPending(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionFromPending(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletApiGetTransactionFromPending_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionFromPending(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetTransactionInfoByBlockNum_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionInfoByBlockNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetTransactionInfoByBlockNum_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getTransactionInfoByBlockNum(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletApiGetTransactionInfoByBlockNum_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionInfoByBlockNum(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTransactionListFromPending(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTransactionListFromPending(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.getTransactionListFromPending(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletApiGetTransactionListFromPending_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionListFromPending(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletApi#getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)"})
  public void testWalletApiGetTriggerInputForShieldedTRC20Contract() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ShieldedTRC20TriggerContractParameters request = ShieldedTRC20TriggerContractParameters.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTriggerInputForShieldedTRC20Contract(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.getTriggerInputForShieldedTRC20Contract(ShieldedTRC20TriggerContractParameters, StreamObserver)"})
  public void testWalletApiGetTriggerInputForShieldedTRC20Contract_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ShieldedTRC20TriggerContractParameters request = ShieldedTRC20TriggerContractParameters.getDefaultInstance();
    StreamObserver<BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.getTriggerInputForShieldedTRC20Contract(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)"})
  public void testWalletApiIsShieldedTRC20ContractNoteSpent_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NfTRC20Parameters request = NfTRC20Parameters.getDefaultInstance();
    StreamObserver<NullifierResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.isShieldedTRC20ContractNoteSpent(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)"})
  public void testWalletApiIsShieldedTRC20ContractNoteSpent_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NfTRC20Parameters request = NfTRC20Parameters.getDefaultInstance();
    StreamObserver<NullifierResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.isShieldedTRC20ContractNoteSpent(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#isSpend(NoteParameters, StreamObserver)}.
   * <ul>
   *   <li>Given {@link WalletApi#WalletApi(RpcApiService)} with this$0 is {@link RpcApiService} (default constructor).</li>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.isSpend(GrpcAPI.NoteParameters, StreamObserver)"})
  public void testWalletApiIsSpend_givenWalletApiWithThis$0IsRpcApiService_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NoteParameters request = NoteParameters.getDefaultInstance();
    StreamObserver<SpendResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.isSpend(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#isSpend(NoteParameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.isSpend(GrpcAPI.NoteParameters, StreamObserver)"})
  public void testWalletApiIsSpend_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    NoteParameters request = NoteParameters.getDefaultInstance();
    StreamObserver<SpendResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.isSpend(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#marketCancelOrder(MarketCancelOrderContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)"})
  public void testWalletApiMarketCancelOrder_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketCancelOrderContract request = MarketCancelOrderContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.marketCancelOrder(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#marketCancelOrder(MarketCancelOrderContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)"})
  public void testWalletApiMarketCancelOrder_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketCancelOrderContract request = MarketCancelOrderContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.marketCancelOrder(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#marketSellAsset(MarketSellAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)"})
  public void testWalletApiMarketSellAsset_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketSellAssetContract request = MarketSellAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.marketSellAsset(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#marketSellAsset(MarketSellAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)"})
  public void testWalletApiMarketSellAsset_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketSellAssetContract request = MarketSellAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.marketSellAsset(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)"})
  public void testWalletApiParticipateAssetIssue2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ParticipateAssetIssueContract request = ParticipateAssetIssueContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.participateAssetIssue2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.participateAssetIssue2(ParticipateAssetIssueContract, StreamObserver)"})
  public void testWalletApiParticipateAssetIssue2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ParticipateAssetIssueContract request = ParticipateAssetIssueContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.participateAssetIssue2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalApprove(ProposalApproveContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)"})
  public void testWalletApiProposalApprove_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalApproveContract request = ProposalApproveContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.proposalApprove(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalApprove(ProposalApproveContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)"})
  public void testWalletApiProposalApprove_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalApproveContract request = ProposalApproveContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalApprove(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalCreate(ProposalCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)"})
  public void testWalletApiProposalCreate_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalCreateContract request = ProposalCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.proposalCreate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalCreate(ProposalCreateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)"})
  public void testWalletApiProposalCreate_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalCreateContract request = ProposalCreateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalCreate(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalDelete(ProposalDeleteContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)"})
  public void testWalletApiProposalDelete_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalDeleteContract request = ProposalDeleteContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.proposalDelete(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#proposalDelete(ProposalDeleteContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)"})
  public void testWalletApiProposalDelete_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalDeleteContract request = ProposalDeleteContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalDelete(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletApiScanShieldedTRC20NotesByIvk_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    IvkDecryptTRC20Parameters request = IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.scanShieldedTRC20NotesByIvk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletApiScanShieldedTRC20NotesByIvk_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    IvkDecryptTRC20Parameters request = IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.scanShieldedTRC20NotesByIvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletApiScanShieldedTRC20NotesByOvk_thenCallsOnError() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    OvkDecryptTRC20Parameters request = OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.scanShieldedTRC20NotesByOvk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletApiScanShieldedTRC20NotesByOvk_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    OvkDecryptTRC20Parameters request = OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.scanShieldedTRC20NotesByOvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletApi {@link WalletApi#transferAsset2(TransferAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#transferAsset2(TransferAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.transferAsset2(TransferAssetContract, StreamObserver)"})
  public void testWalletApiTransferAsset2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TransferAssetContract request = TransferAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.transferAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#transferAsset2(TransferAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#transferAsset2(TransferAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.transferAsset2(TransferAssetContract, StreamObserver)"})
  public void testWalletApiTransferAsset2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TransferAssetContract request = TransferAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.transferAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#triggerConstantContract(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiTriggerConstantContract_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.triggerConstantContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#triggerConstantContract(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiTriggerConstantContract_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.triggerConstantContract(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#triggerContract(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiTriggerContract_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.triggerContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#triggerContract(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletApiTriggerContract_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.triggerContract(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unDelegateResource(UnDelegateResourceContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)"})
  public void testWalletApiUnDelegateResource_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnDelegateResourceContract request = UnDelegateResourceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.unDelegateResource(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unDelegateResource(UnDelegateResourceContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)"})
  public void testWalletApiUnDelegateResource_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnDelegateResourceContract request = UnDelegateResourceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unDelegateResource(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeAsset2(UnfreezeAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeAsset2(UnfreezeAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeAsset2(UnfreezeAssetContract, StreamObserver)"})
  public void testWalletApiUnfreezeAsset2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeAssetContract request = UnfreezeAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.unfreezeAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeAsset2(UnfreezeAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeAsset2(UnfreezeAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeAsset2(UnfreezeAssetContract, StreamObserver)"})
  public void testWalletApiUnfreezeAsset2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeAssetContract request = UnfreezeAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeBalance2(UnfreezeBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)"})
  public void testWalletApiUnfreezeBalance2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeBalanceContract request = UnfreezeBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.unfreezeBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeBalance2(UnfreezeBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)"})
  public void testWalletApiUnfreezeBalance2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeBalanceContract request = UnfreezeBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeBalanceV2(UnfreezeBalanceV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)"})
  public void testWalletApiUnfreezeBalanceV2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeBalanceV2Contract request = UnfreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.unfreezeBalanceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#unfreezeBalanceV2(UnfreezeBalanceV2Contract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)"})
  public void testWalletApiUnfreezeBalanceV2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UnfreezeBalanceV2Contract request = UnfreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeBalanceV2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateAccount2(AccountUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)"})
  public void testWalletApiUpdateAccount2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountUpdateContract request = AccountUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateAccount2(AccountUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)"})
  public void testWalletApiUpdateAccount2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountUpdateContract request = AccountUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateAsset2(UpdateAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateAsset2(UpdateAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateAsset2(UpdateAssetContract, StreamObserver)"})
  public void testWalletApiUpdateAsset2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateAssetContract request = UpdateAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateAsset2(UpdateAssetContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateAsset2(UpdateAssetContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateAsset2(UpdateAssetContract, StreamObserver)"})
  public void testWalletApiUpdateAsset2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateAssetContract request = UpdateAssetContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateBrokerage(UpdateBrokerageContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)"})
  public void testWalletApiUpdateBrokerage_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateBrokerageContract request = UpdateBrokerageContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateBrokerage(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateBrokerage(UpdateBrokerageContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)"})
  public void testWalletApiUpdateBrokerage_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateBrokerageContract request = UpdateBrokerageContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateBrokerage(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)"})
  public void testWalletApiUpdateEnergyLimit_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateEnergyLimitContract request = UpdateEnergyLimitContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateEnergyLimit(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateEnergyLimit(UpdateEnergyLimitContract, StreamObserver)"})
  public void testWalletApiUpdateEnergyLimit_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateEnergyLimitContract request = UpdateEnergyLimitContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateEnergyLimit(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateSetting(UpdateSettingContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateSetting(UpdateSettingContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateSetting(UpdateSettingContract, StreamObserver)"})
  public void testWalletApiUpdateSetting_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateSettingContract request = UpdateSettingContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateSetting(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateSetting(UpdateSettingContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateSetting(UpdateSettingContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateSetting(UpdateSettingContract, StreamObserver)"})
  public void testWalletApiUpdateSetting_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    UpdateSettingContract request = UpdateSettingContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateSetting(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateWitness2(WitnessUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)"})
  public void testWalletApiUpdateWitness2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessUpdateContract request = WitnessUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.updateWitness2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#updateWitness2(WitnessUpdateContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)"})
  public void testWalletApiUpdateWitness2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessUpdateContract request = WitnessUpdateContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateWitness2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#voteWitnessAccount2(VoteWitnessContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)"})
  public void testWalletApiVoteWitnessAccount2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    VoteWitnessContract request = VoteWitnessContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.voteWitnessAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#voteWitnessAccount2(VoteWitnessContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)"})
  public void testWalletApiVoteWitnessAccount2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    VoteWitnessContract request = VoteWitnessContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.voteWitnessAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#withdrawBalance2(WithdrawBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)"})
  public void testWalletApiWithdrawBalance2_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WithdrawBalanceContract request = WithdrawBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.withdrawBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#withdrawBalance2(WithdrawBalanceContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletApi.withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)"})
  public void testWalletApiWithdrawBalance2_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WithdrawBalanceContract request = WithdrawBalanceContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.withdrawBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#withdrawExpireUnfreeze(WithdrawExpireUnfreezeContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)"})
  public void testWalletApiWithdrawExpireUnfreeze_thenCallsOnCompleted() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WithdrawExpireUnfreezeContract request = WithdrawExpireUnfreezeContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletApi.withdrawExpireUnfreeze(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletApi {@link WalletApi#withdrawExpireUnfreeze(WithdrawExpireUnfreezeContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletApi#withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletApi.withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)"})
  public void testWalletApiWithdrawExpireUnfreeze_thenThrowRuntimeException() {
    // Arrange
    WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WithdrawExpireUnfreezeContract request = WithdrawExpireUnfreezeContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.withdrawExpireUnfreeze(request, responseObserver));
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#estimateEnergy(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletSolidityApiEstimateEnergy_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<EstimateEnergyMessage>any());

    // Act
    walletSolidityApi.estimateEnergy(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(EstimateEnergyMessage.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#estimateEnergy(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletSolidityApiEstimateEnergy_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<EstimateEnergyMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.estimateEnergy(request, responseObserver));
    verify(responseObserver).onNext(isA(EstimateEnergyMessage.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetAvailableUnfreezeCount_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GetAvailableUnfreezeCountRequestMessage request = GetAvailableUnfreezeCountRequestMessage.getDefaultInstance();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getAvailableUnfreezeCount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetAvailableUnfreezeCount_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GetAvailableUnfreezeCountRequestMessage request = GetAvailableUnfreezeCountRequestMessage.getDefaultInstance();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getAvailableUnfreezeCount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getAvailableUnfreezeCount(GetAvailableUnfreezeCountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetAvailableUnfreezeCount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getAvailableUnfreezeCount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getBandwidthPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetBandwidthPrices_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBandwidthPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getBandwidthPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetBandwidthPrices_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getBandwidthPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getBlock(BlockReq, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getBlock(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getBlock(GrpcAPI.BlockReq, StreamObserver)"})
  public void testWalletSolidityApiGetBlock_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BlockReq request = BlockReq.getDefaultInstance();
    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBlock(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getBrokerageInfo(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetBrokerageInfo_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBrokerageInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getBurnTrx(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetBurnTrx_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBurnTrx(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanDelegatedMaxSize_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    CanDelegatedMaxSizeRequestMessage request = CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanDelegatedMaxSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanDelegatedMaxSize_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    CanDelegatedMaxSizeRequestMessage request = CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getCanDelegatedMaxSize(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanDelegatedMaxSize(CanDelegatedMaxSizeRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanDelegatedMaxSize_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanDelegatedMaxSize(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    CanWithdrawUnfreezeAmountRequestMessage request = CanWithdrawUnfreezeAmountRequestMessage.getDefaultInstance();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanWithdrawUnfreezeAmount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    CanWithdrawUnfreezeAmountRequestMessage request = CanWithdrawUnfreezeAmountRequestMessage.getDefaultInstance();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getCanWithdrawUnfreezeAmount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)"})
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanWithdrawUnfreezeAmount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV2() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getDelegatedResourceAccountIndexV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV2_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndexV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV2_whenNull() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndexV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndex(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getDelegatedResourceAccountIndex(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceAccountIndex(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex_whenNull() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndex(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceV2_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    DelegatedResourceMessage request = DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceV2_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    DelegatedResourceMessage request = DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getDelegatedResourceV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getDelegatedResourceV2(DelegatedResourceMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)"})
  public void testWalletSolidityApiGetDelegatedResourceV2_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getEnergyPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetEnergyPrices_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getEnergyPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getEnergyPrices(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetEnergyPrices_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getEnergyPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderByAccount_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderByAccount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderByAccount_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderByAccount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderByAccount(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderByAccount_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderByAccount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderById_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderById(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderById_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderById(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderById(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderById_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderById(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderListByPair_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderListByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderListByPair_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderListByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketOrderListByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketOrderListByPair_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderListByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketPairList(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketPairList_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPairList(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketPairList(EmptyMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testWalletSolidityApiGetMarketPairList_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    EmptyMessage request = EmptyMessage.getDefaultInstance();
    StreamObserver<MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketPairList(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketPriceByPair_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPriceByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketPriceByPair_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    MarketOrderPair request = MarketOrderPair.getDefaultInstance();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketPriceByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMarketPriceByPair(MarketOrderPair, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)"})
  public void testWalletSolidityApiGetMarketPriceByPair_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPriceByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)"})
  public void testWalletSolidityApiGetMerkleTreeVoucherInfo_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    OutputPointInfo request = OutputPointInfo.getDefaultInstance();
    StreamObserver<IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMerkleTreeVoucherInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getMerkleTreeVoucherInfo(OutputPointInfo, StreamObserver)"})
  public void testWalletSolidityApiGetMerkleTreeVoucherInfo_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    OutputPointInfo request = OutputPointInfo.getDefaultInstance();
    StreamObserver<IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMerkleTreeVoucherInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getRewardInfo(BytesMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)"})
  public void testWalletSolidityApiGetRewardInfo_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    BytesMessage request = BytesMessage.getDefaultInstance();
    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getRewardInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getTransactionCountByBlockNum(NumberMessage, StreamObserver)}.
   * <p>
   * Method under test: {@link WalletSolidityApi#getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletSolidityApiGetTransactionCountByBlockNum() {
    // Arrange
    RpcApiService rpcApiService = mock(RpcApiService.class);
    doNothing().when(rpcApiService)
        .getTransactionCountByBlockNumCommon(Mockito.<NumberMessage>any(),
            Mockito.<StreamObserver<NumberMessage>>any());
    WalletSolidityApi walletSolidityApi = rpcApiService.new WalletSolidityApi();

    // Act
    walletSolidityApi.getTransactionCountByBlockNum(NumberMessage.getDefaultInstance(), mock(StreamObserver.class));

    // Assert
    verify(rpcApiService).getTransactionCountByBlockNumCommon(isA(NumberMessage.class), isA(StreamObserver.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletSolidityApiGetTransactionInfoByBlockNum_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getTransactionInfoByBlockNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletSolidityApiGetTransactionInfoByBlockNum_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NumberMessage request = NumberMessage.getDefaultInstance();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getTransactionInfoByBlockNum(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#getTransactionInfoByBlockNum(NumberMessage, StreamObserver)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)"})
  public void testWalletSolidityApiGetTransactionInfoByBlockNum_whenNull_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getTransactionInfoByBlockNum(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiIsShieldedTRC20ContractNoteSpent_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NfTRC20Parameters request = NfTRC20Parameters.getDefaultInstance();
    StreamObserver<NullifierResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.isShieldedTRC20ContractNoteSpent(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.isShieldedTRC20ContractNoteSpent(NfTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiIsShieldedTRC20ContractNoteSpent_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NfTRC20Parameters request = NfTRC20Parameters.getDefaultInstance();
    StreamObserver<NullifierResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.isShieldedTRC20ContractNoteSpent(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#isSpend(NoteParameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.isSpend(GrpcAPI.NoteParameters, StreamObserver)"})
  public void testWalletSolidityApiIsSpend_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NoteParameters request = NoteParameters.getDefaultInstance();
    StreamObserver<SpendResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.isSpend(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#isSpend(NoteParameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.isSpend(GrpcAPI.NoteParameters, StreamObserver)"})
  public void testWalletSolidityApiIsSpend_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    NoteParameters request = NoteParameters.getDefaultInstance();
    StreamObserver<SpendResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.isSpend(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiScanShieldedTRC20NotesByIvk_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    IvkDecryptTRC20Parameters request = IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.scanShieldedTRC20NotesByIvk(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.scanShieldedTRC20NotesByIvk(IvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiScanShieldedTRC20NotesByIvk_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    IvkDecryptTRC20Parameters request = IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.scanShieldedTRC20NotesByIvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiScanShieldedTRC20NotesByOvk_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    OvkDecryptTRC20Parameters request = OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.scanShieldedTRC20NotesByOvk(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WalletSolidityApi.scanShieldedTRC20NotesByOvk(OvkDecryptTRC20Parameters, StreamObserver)"})
  public void testWalletSolidityApiScanShieldedTRC20NotesByOvk_thenThrowRuntimeException() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    OvkDecryptTRC20Parameters request = OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.scanShieldedTRC20NotesByOvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test WalletSolidityApi {@link WalletSolidityApi#triggerConstantContract(TriggerSmartContract, StreamObserver)}.
   * <ul>
   *   <li>Then calls {@link StreamObserver#onCompleted()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletSolidityApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void WalletSolidityApi.triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)"})
  public void testWalletSolidityApiTriggerConstantContract_thenCallsOnCompleted() {
    // Arrange
    WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    TriggerSmartContract request = TriggerSmartContract.getDefaultInstance();
    StreamObserver<TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<TransactionExtention>any());

    // Act
    walletSolidityApi.triggerConstantContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(TransactionExtention.class));
  }
}
