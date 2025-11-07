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
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.api.GrpcAPI;
import org.tron.core.ChainBaseManager;
import org.tron.core.Wallet;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.metrics.MetricsApiService;
import org.tron.core.service.MortgageService;
import org.tron.core.services.filter.LiteFnQueryGrpcInterceptor;
import org.tron.core.services.ratelimiter.PrometheusInterceptor;
import org.tron.core.services.ratelimiter.RateLimiterInterceptor;
import org.tron.core.services.ratelimiter.RpcApiAccessInterceptor;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.utils.TransactionUtil;
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

@RunWith(MockitoJUnitRunner.class)
public class RpcApiServiceDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private LiteFnQueryGrpcInterceptor liteFnQueryGrpcInterceptor;

  @Mock
  private Manager manager;

  @Mock
  private MetricsApiService metricsApiService;

  @Mock
  private NodeInfoService nodeInfoService;

  @Mock
  private PrometheusInterceptor prometheusInterceptor;

  @Mock
  private RateLimiterInterceptor rateLimiterInterceptor;

  @Mock
  private RpcApiAccessInterceptor rpcApiAccessInterceptor;

  @InjectMocks
  private RpcApiService rpcApiService;

  @Mock
  private TransactionUtil transactionUtil;

  @Mock
  private Wallet wallet;

  /**
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(new MortgageService());
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon2() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(new MortgageService());
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getRewardInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getMortgageService();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon3() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(null);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon4() {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon5() {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon6() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(mock(MortgageService.class));
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetRewardInfoCommon7() {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getRewardInfoCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetBurnTrxCommon() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetBurnTrxCommon2() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBurnTrxCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetBurnTrxCommon3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetBurnTrxCommon4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetBurnTrxCommon5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBurnTrxCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBurnTrxAmount();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon2() {
    // Arrange
    when(manager.getDynamicPropertiesStore()).thenReturn(null);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBrokerageInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getDynamicPropertiesStore();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
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
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetBrokerageInfoCommon6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionCountByBlockNumCommon() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act
    rpcApiService.getTransactionCountByBlockNumCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(chainBaseManager).getBlockByNum(eq(0L));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionCountByBlockNumCommon2() throws BadItemException, ItemNotFoundException {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(blockCapsule);
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act
    rpcApiService.getTransactionCountByBlockNumCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(chainBaseManager).getBlockByNum(eq(0L));
    verify(blockCapsule).getInstance();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionCountByBlockNumCommon3() throws BadItemException, ItemNotFoundException {
    // Arrange
    when(chainBaseManager.getBlockByNum(anyLong())).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionCountByBlockNumCommon(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(chainBaseManager).getBlockByNum(eq(0L));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionFromPendingCommon() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionFromPendingCommon2() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    StreamObserver<Protocol.Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionFromPendingCommon(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionFromPendingCommon3() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.Transaction> responseObserver = mock(StreamObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionListFromPendingCommon() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionIdList>any());

    // Act
    rpcApiService.getTransactionListFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionListFromPendingCommon2() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver)
        .onNext(Mockito.<GrpcAPI.TransactionIdList>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionListFromPendingCommon3() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionIdList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver)
        .onNext(Mockito.<GrpcAPI.TransactionIdList>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetTransactionListFromPendingCommon4() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver)
        .onNext(Mockito.<GrpcAPI.TransactionIdList>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetPendingSizeCommon() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act
    rpcApiService.getPendingSizeCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetPendingSizeCommon2() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testGetPendingSizeCommon3() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.NumberMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testGetBlockCommon() {
    // Arrange
    when(wallet.getBlock(Mockito.<GrpcAPI.BlockReq>any())).thenReturn(Protocol.Block.getDefaultInstance());
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.BlockExtention>any());

    // Act
    rpcApiService.getBlockCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.BlockExtention.class));
    verify(wallet).getBlock(isA(GrpcAPI.BlockReq.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testGetBlockCommon2() {
    // Arrange
    when(wallet.getBlock(Mockito.<GrpcAPI.BlockReq>any())).thenReturn(Protocol.Block.getDefaultInstance());
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockExtention>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.BlockExtention.class));
    verify(wallet).getBlock(isA(GrpcAPI.BlockReq.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testGetBlockCommon3() {
    // Arrange
    when(wallet.getBlock(Mockito.<GrpcAPI.BlockReq>any())).thenReturn(Protocol.Block.getDefaultInstance());
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("ECKey")).when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.BlockExtention.class));
    verify(wallet).getBlock(isA(GrpcAPI.BlockReq.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testGetBlockCommon4() {
    // Arrange
    when(wallet.getBlock(Mockito.<GrpcAPI.BlockReq>any())).thenReturn(null);
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockExtention>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isNull());
    verify(wallet).getBlock(isA(GrpcAPI.BlockReq.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testGetBlockCommon5() {
    // Arrange
    when(wallet.getBlock(Mockito.<GrpcAPI.BlockReq>any())).thenReturn(Protocol.Block.getDefaultInstance());
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new IllegalArgumentException("foo")).when(responseObserver).onCompleted();
    doThrow(new IllegalArgumentException((String) null)).when(responseObserver)
        .onNext(Mockito.<GrpcAPI.BlockExtention>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(GrpcAPI.BlockExtention.class));
    verify(wallet).getBlock(isA(GrpcAPI.BlockReq.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiAccountPermissionUpdate() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountPermissionUpdateContract request = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.accountPermissionUpdate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#accountPermissionUpdate(AccountContract.AccountPermissionUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiAccountPermissionUpdate2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountPermissionUpdateContract request = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.accountPermissionUpdate(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiCancelAllUnfreezeV2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.CancelAllUnfreezeV2Contract request = BalanceContract.CancelAllUnfreezeV2Contract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.cancelAllUnfreezeV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#cancelAllUnfreezeV2(BalanceContract.CancelAllUnfreezeV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiCancelAllUnfreezeV22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.CancelAllUnfreezeV2Contract request = BalanceContract.CancelAllUnfreezeV2Contract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.cancelAllUnfreezeV2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#clearContractABI(SmartContractOuterClass.ClearABIContract, StreamObserver)}
   */
  @Test
  public void testWalletApiClearContractABI() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.ClearABIContract request = SmartContractOuterClass.ClearABIContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.clearContractABI(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#clearContractABI(SmartContractOuterClass.ClearABIContract, StreamObserver)}
   */
  @Test
  public void testWalletApiClearContractABI2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.ClearABIContract request = SmartContractOuterClass.ClearABIContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.clearContractABI(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createAccount2(AccountContract.AccountCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateAccount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountCreateContract request = AccountContract.AccountCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createAccount2(AccountContract.AccountCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateAccount22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountCreateContract request = AccountContract.AccountCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createAssetIssue2(AssetIssueContractOuterClass.AssetIssueContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateAssetIssue2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.AssetIssueContract request = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createAssetIssue2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createAssetIssue2(AssetIssueContractOuterClass.AssetIssueContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateAssetIssue22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.AssetIssueContract request = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createAssetIssue2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedContractParameters() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateShieldedTRC20Parameters request = GrpcAPI.PrivateShieldedTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createShieldedContractParameters(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedContractParameters(GrpcAPI.PrivateShieldedTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedContractParameters2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateShieldedTRC20Parameters request = GrpcAPI.PrivateShieldedTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createShieldedContractParameters(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedContractParametersWithoutAsk() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk request = GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk
        .getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createShieldedContractParametersWithoutAsk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedContractParametersWithoutAsk(GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedContractParametersWithoutAsk2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk request = GrpcAPI.PrivateShieldedTRC20ParametersWithoutAsk
        .getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedTRC20Parameters> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.createShieldedContractParametersWithoutAsk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedTransaction() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateParameters request = GrpcAPI.PrivateParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createShieldedTransaction(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedTransaction(GrpcAPI.PrivateParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedTransaction2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateParameters request = GrpcAPI.PrivateParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createShieldedTransaction(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedTransactionWithoutSpendAuthSig(GrpcAPI.PrivateParametersWithoutAsk, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedTransactionWithoutSpendAuthSig() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateParametersWithoutAsk request = GrpcAPI.PrivateParametersWithoutAsk.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createShieldedTransactionWithoutSpendAuthSig(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createShieldedTransactionWithoutSpendAuthSig(GrpcAPI.PrivateParametersWithoutAsk, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateShieldedTransactionWithoutSpendAuthSig2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.PrivateParametersWithoutAsk request = GrpcAPI.PrivateParametersWithoutAsk.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.createShieldedTransactionWithoutSpendAuthSig(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createSpendAuthSig(GrpcAPI.SpendAuthSigParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateSpendAuthSig() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.SpendAuthSigParameters request = GrpcAPI.SpendAuthSigParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.createSpendAuthSig(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createSpendAuthSig(GrpcAPI.SpendAuthSigParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateSpendAuthSig2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.SpendAuthSigParameters request = GrpcAPI.SpendAuthSigParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createSpendAuthSig(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createTransaction2(BalanceContract.TransferContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateTransaction2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.TransferContract request = BalanceContract.TransferContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createTransaction2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createTransaction2(BalanceContract.TransferContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateTransaction22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.TransferContract request = BalanceContract.TransferContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createTransaction2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateWitness2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.WitnessCreateContract request = WitnessContract.WitnessCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.createWitness2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#createWitness2(WitnessContract.WitnessCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiCreateWitness22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.WitnessCreateContract request = WitnessContract.WitnessCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.createWitness2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiDelegateResource() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.DelegateResourceContract request = BalanceContract.DelegateResourceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.delegateResource(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#delegateResource(BalanceContract.DelegateResourceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiDelegateResource2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.DelegateResourceContract request = BalanceContract.DelegateResourceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.delegateResource(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#deployContract(SmartContractOuterClass.CreateSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiDeployContract() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.CreateSmartContract request = SmartContractOuterClass.CreateSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.deployContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#deployContract(SmartContractOuterClass.CreateSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiDeployContract2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.CreateSmartContract request = SmartContractOuterClass.CreateSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.deployContract(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiEstimateEnergy() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.EstimateEnergyMessage>any());

    // Act
    walletApi.estimateEnergy(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.EstimateEnergyMessage.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiEstimateEnergy2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.EstimateEnergyMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.estimateEnergy(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.EstimateEnergyMessage.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeCreate() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeCreateContract request = ExchangeContract.ExchangeCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.exchangeCreate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeCreate(ExchangeContract.ExchangeCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeCreate2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeCreateContract request = ExchangeContract.ExchangeCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeCreate(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeInject() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeInjectContract request = ExchangeContract.ExchangeInjectContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.exchangeInject(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeInject(ExchangeContract.ExchangeInjectContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeInject2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeInjectContract request = ExchangeContract.ExchangeInjectContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeInject(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeTransaction() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeTransactionContract request = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.exchangeTransaction(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeTransaction(ExchangeContract.ExchangeTransactionContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeTransaction2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeTransactionContract request = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeTransaction(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeWithdraw() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeWithdrawContract request = ExchangeContract.ExchangeWithdrawContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.exchangeWithdraw(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#exchangeWithdraw(ExchangeContract.ExchangeWithdrawContract, StreamObserver)}
   */
  @Test
  public void testWalletApiExchangeWithdraw2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ExchangeContract.ExchangeWithdrawContract request = ExchangeContract.ExchangeWithdrawContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.exchangeWithdraw(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiFreezeBalance2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.FreezeBalanceContract request = BalanceContract.FreezeBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.freezeBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#freezeBalance2(BalanceContract.FreezeBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiFreezeBalance22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.FreezeBalanceContract request = BalanceContract.FreezeBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.freezeBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiFreezeBalanceV2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.FreezeBalanceV2Contract request = BalanceContract.FreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.freezeBalanceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#freezeBalanceV2(BalanceContract.FreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiFreezeBalanceV22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.FreezeBalanceV2Contract request = BalanceContract.FreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.freezeBalanceV2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)}
   */
  @Test
  public void testWalletApiGetAccountBalance() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.AccountBalanceRequest request = BalanceContract.AccountBalanceRequest.getDefaultInstance();
    StreamObserver<BalanceContract.AccountBalanceResponse> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAccountBalance(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getAccountBalance(BalanceContract.AccountBalanceRequest, StreamObserver)}
   */
  @Test
  public void testWalletApiGetAccountBalance2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.AccountBalanceRequest request = BalanceContract.AccountBalanceRequest.getDefaultInstance();
    StreamObserver<BalanceContract.AccountBalanceResponse> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getAccountBalance(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetAvailableUnfreezeCount() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.GetAvailableUnfreezeCountRequestMessage request = GrpcAPI.GetAvailableUnfreezeCountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAvailableUnfreezeCount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetAvailableUnfreezeCount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getAvailableUnfreezeCount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetAvailableUnfreezeCount3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.GetAvailableUnfreezeCountRequestMessage request = GrpcAPI.GetAvailableUnfreezeCountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getAvailableUnfreezeCount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBandwidthPrices() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBandwidthPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBandwidthPrices2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBandwidthPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlock(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlock() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBlock(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockBalanceTrace() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.BlockBalanceTrace.BlockIdentifier request = BalanceContract.BlockBalanceTrace.BlockIdentifier
        .getDefaultInstance();
    StreamObserver<BalanceContract.BlockBalanceTrace> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBlockBalanceTrace(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockBalanceTrace(BalanceContract.BlockBalanceTrace.BlockIdentifier, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockBalanceTrace2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.BlockBalanceTrace.BlockIdentifier request = BalanceContract.BlockBalanceTrace.BlockIdentifier
        .getDefaultInstance();
    StreamObserver<BalanceContract.BlockBalanceTrace> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockBalanceTrace(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLatestNum() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.BlockList>any());

    // Act
    walletApi.getBlockByLatestNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLatestNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLatestNum2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockList>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLatestNum(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLatestNum22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockListExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.BlockListExtention>any());

    // Act
    walletApi.getBlockByLatestNum2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLatestNum2(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLatestNum23() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockListExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockListExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLatestNum2(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLimitNext(GrpcAPI.BlockLimit, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLimitNext() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BlockLimit request = GrpcAPI.BlockLimit.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.BlockList>any());

    // Act
    walletApi.getBlockByLimitNext(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLimitNext(GrpcAPI.BlockLimit, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLimitNext2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BlockLimit request = GrpcAPI.BlockLimit.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockList>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLimitNext(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLimitNext2(GrpcAPI.BlockLimit, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLimitNext22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BlockLimit request = GrpcAPI.BlockLimit.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockListExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.BlockListExtention>any());

    // Act
    walletApi.getBlockByLimitNext2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBlockByLimitNext2(GrpcAPI.BlockLimit, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBlockByLimitNext23() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BlockLimit request = GrpcAPI.BlockLimit.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockListExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onNext(Mockito.<GrpcAPI.BlockListExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getBlockByLimitNext2(request, responseObserver));
    verify(responseObserver).onNext(isNull());
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBrokerageInfo() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBrokerageInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetBurnTrx() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getBurnTrx(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanDelegatedMaxSize() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.CanDelegatedMaxSizeRequestMessage request = GrpcAPI.CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanDelegatedMaxSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanDelegatedMaxSize2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanDelegatedMaxSize(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanDelegatedMaxSize3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.CanDelegatedMaxSizeRequestMessage request = GrpcAPI.CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getCanDelegatedMaxSize(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanWithdrawUnfreezeAmount() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage request = GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanWithdrawUnfreezeAmount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanWithdrawUnfreezeAmount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getCanWithdrawUnfreezeAmount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetCanWithdrawUnfreezeAmount3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage request = GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getCanWithdrawUnfreezeAmount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndex() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndex(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndex2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndex(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndex3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceAccountIndex(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndexV2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndexV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndexV22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceAccountIndexV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceAccountIndexV23() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceAccountIndexV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceV2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.DelegatedResourceMessage request = GrpcAPI.DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceV22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getDelegatedResourceV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetDelegatedResourceV23() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.DelegatedResourceMessage request = GrpcAPI.DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getDelegatedResourceV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetEnergyPrices() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getEnergyPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetEnergyPrices2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getEnergyPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderByAccount() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderByAccount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderByAccount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderByAccount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderByAccount3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderByAccount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderById() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderById(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderById2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderById(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderById3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderById(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderListByPair() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderListByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderListByPair2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketOrderListByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketOrderListByPair3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketOrderListByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketPairList() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPairList(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketPairList2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketPairList(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketPriceByPair() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPriceByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketPriceByPair2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMarketPriceByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMarketPriceByPair3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMarketPriceByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMemoFee() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMemoFee(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMemoFee(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMemoFee2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMemoFee(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMerkleTreeVoucherInfo(ShieldContract.OutputPointInfo, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMerkleTreeVoucherInfo() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ShieldContract.OutputPointInfo request = ShieldContract.OutputPointInfo.getDefaultInstance();
    StreamObserver<ShieldContract.IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getMerkleTreeVoucherInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getMerkleTreeVoucherInfo(ShieldContract.OutputPointInfo, StreamObserver)}
   */
  @Test
  public void testWalletApiGetMerkleTreeVoucherInfo2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ShieldContract.OutputPointInfo request = ShieldContract.OutputPointInfo.getDefaultInstance();
    StreamObserver<ShieldContract.IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getMerkleTreeVoucherInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetNewShieldedAddress() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedAddressInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getNewShieldedAddress(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getNewShieldedAddress(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetNewShieldedAddress2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.ShieldedAddressInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getNewShieldedAddress(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetNodeInfo() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.NodeInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getNodeInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getNodeInfo(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetNodeInfo2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.NodeInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getNodeInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getPendingSize(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetPendingSize() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getPendingSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getRcm(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetRcm() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getRcm(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getRcm(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetRcm2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getRcm(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetRewardInfo() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getRewardInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getShieldTransactionHash(Protocol.Transaction, StreamObserver)}
   */
  @Test
  public void testWalletApiGetShieldTransactionHash() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.Transaction request = Protocol.Transaction.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getShieldTransactionHash(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getShieldTransactionHash(Protocol.Transaction, StreamObserver)}
   */
  @Test
  public void testWalletApiGetShieldTransactionHash2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    Protocol.Transaction request = Protocol.Transaction.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getShieldTransactionHash(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetSpendingKey() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getSpendingKey(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getSpendingKey(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetSpendingKey2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getSpendingKey(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionCountByBlockNum() {
    // Arrange
    RpcApiService rpcApiService = mock(RpcApiService.class);
    doNothing().when(rpcApiService)
        .getTransactionCountByBlockNumCommon(Mockito.<GrpcAPI.NumberMessage>any(),
            Mockito.<StreamObserver<GrpcAPI.NumberMessage>>any());
    RpcApiService.WalletApi walletApi = rpcApiService.new WalletApi();

    // Act
    walletApi.getTransactionCountByBlockNum(GrpcAPI.NumberMessage.getDefaultInstance(), mock(StreamObserver.class));

    // Assert that nothing has changed
    verify(rpcApiService).getTransactionCountByBlockNumCommon(isA(GrpcAPI.NumberMessage.class),
        isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionFromPending() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionFromPending(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionFromPending(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionFromPending2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<Protocol.Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionFromPending(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionInfoByBlockNum() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionInfoByBlockNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionInfoByBlockNum2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionInfoByBlockNum(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionInfoByBlockNum3() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.getTransactionInfoByBlockNum(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTransactionListFromPending(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTransactionListFromPending() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTransactionListFromPending(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTriggerInputForShieldedTRC20Contract(GrpcAPI.ShieldedTRC20TriggerContractParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTriggerInputForShieldedTRC20Contract() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.ShieldedTRC20TriggerContractParameters request = GrpcAPI.ShieldedTRC20TriggerContractParameters
        .getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.getTriggerInputForShieldedTRC20Contract(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#getTriggerInputForShieldedTRC20Contract(GrpcAPI.ShieldedTRC20TriggerContractParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiGetTriggerInputForShieldedTRC20Contract2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.ShieldedTRC20TriggerContractParameters request = GrpcAPI.ShieldedTRC20TriggerContractParameters
        .getDefaultInstance();
    StreamObserver<GrpcAPI.BytesMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletApi.getTriggerInputForShieldedTRC20Contract(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#isShieldedTRC20ContractNoteSpent(GrpcAPI.NfTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiIsShieldedTRC20ContractNoteSpent() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NfTRC20Parameters request = GrpcAPI.NfTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.NullifierResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.isShieldedTRC20ContractNoteSpent(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#isShieldedTRC20ContractNoteSpent(GrpcAPI.NfTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiIsShieldedTRC20ContractNoteSpent2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NfTRC20Parameters request = GrpcAPI.NfTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.NullifierResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.isShieldedTRC20ContractNoteSpent(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiIsSpend() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NoteParameters request = GrpcAPI.NoteParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.SpendResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.isSpend(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  public void testWalletApiIsSpend2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.NoteParameters request = GrpcAPI.NoteParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.SpendResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.isSpend(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)}
   */
  @Test
  public void testWalletApiMarketCancelOrder() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketContract.MarketCancelOrderContract request = MarketContract.MarketCancelOrderContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.marketCancelOrder(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#marketCancelOrder(MarketContract.MarketCancelOrderContract, StreamObserver)}
   */
  @Test
  public void testWalletApiMarketCancelOrder2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketContract.MarketCancelOrderContract request = MarketContract.MarketCancelOrderContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.marketCancelOrder(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiMarketSellAsset() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketContract.MarketSellAssetContract request = MarketContract.MarketSellAssetContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.marketSellAsset(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#marketSellAsset(MarketContract.MarketSellAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiMarketSellAsset2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    MarketContract.MarketSellAssetContract request = MarketContract.MarketSellAssetContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.marketSellAsset(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#participateAssetIssue2(AssetIssueContractOuterClass.ParticipateAssetIssueContract, StreamObserver)}
   */
  @Test
  public void testWalletApiParticipateAssetIssue2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.ParticipateAssetIssueContract request = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.participateAssetIssue2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#participateAssetIssue2(AssetIssueContractOuterClass.ParticipateAssetIssueContract, StreamObserver)}
   */
  @Test
  public void testWalletApiParticipateAssetIssue22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.ParticipateAssetIssueContract request = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.participateAssetIssue2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalApprove() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalApproveContract request = ProposalContract.ProposalApproveContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.proposalApprove(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalApprove(ProposalContract.ProposalApproveContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalApprove2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalApproveContract request = ProposalContract.ProposalApproveContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalApprove(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalCreate() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalCreateContract request = ProposalContract.ProposalCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.proposalCreate(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalCreate(ProposalContract.ProposalCreateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalCreate2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalCreateContract request = ProposalContract.ProposalCreateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalCreate(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalDelete() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalDeleteContract request = ProposalContract.ProposalDeleteContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.proposalDelete(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#proposalDelete(ProposalContract.ProposalDeleteContract, StreamObserver)}
   */
  @Test
  public void testWalletApiProposalDelete2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    ProposalContract.ProposalDeleteContract request = ProposalContract.ProposalDeleteContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.proposalDelete(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#scanShieldedTRC20NotesByIvk(GrpcAPI.IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiScanShieldedTRC20NotesByIvk() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.IvkDecryptTRC20Parameters request = GrpcAPI.IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.scanShieldedTRC20NotesByIvk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#scanShieldedTRC20NotesByIvk(GrpcAPI.IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiScanShieldedTRC20NotesByIvk2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.IvkDecryptTRC20Parameters request = GrpcAPI.IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.scanShieldedTRC20NotesByIvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#scanShieldedTRC20NotesByOvk(GrpcAPI.OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiScanShieldedTRC20NotesByOvk() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.OvkDecryptTRC20Parameters request = GrpcAPI.OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletApi.scanShieldedTRC20NotesByOvk(request, responseObserver);

    // Assert
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#scanShieldedTRC20NotesByOvk(GrpcAPI.OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletApiScanShieldedTRC20NotesByOvk2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    GrpcAPI.OvkDecryptTRC20Parameters request = GrpcAPI.OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.scanShieldedTRC20NotesByOvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#transferAsset2(AssetIssueContractOuterClass.TransferAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTransferAsset2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.TransferAssetContract request = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.transferAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#transferAsset2(AssetIssueContractOuterClass.TransferAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTransferAsset22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.TransferAssetContract request = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.transferAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTriggerConstantContract() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.triggerConstantContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTriggerConstantContract2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.triggerConstantContract(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTriggerContract() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.triggerContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#triggerContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletApiTriggerContract2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.triggerContract(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnDelegateResource() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnDelegateResourceContract request = BalanceContract.UnDelegateResourceContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.unDelegateResource(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unDelegateResource(BalanceContract.UnDelegateResourceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnDelegateResource2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnDelegateResourceContract request = BalanceContract.UnDelegateResourceContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unDelegateResource(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeAsset2(AssetIssueContractOuterClass.UnfreezeAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeAsset2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.UnfreezeAssetContract request = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.unfreezeAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeAsset2(AssetIssueContractOuterClass.UnfreezeAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeAsset22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.UnfreezeAssetContract request = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeBalance2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnfreezeBalanceContract request = BalanceContract.UnfreezeBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.unfreezeBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeBalance2(BalanceContract.UnfreezeBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeBalance22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnfreezeBalanceContract request = BalanceContract.UnfreezeBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeBalanceV2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnfreezeBalanceV2Contract request = BalanceContract.UnfreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.unfreezeBalanceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#unfreezeBalanceV2(BalanceContract.UnfreezeBalanceV2Contract, StreamObserver)}
   */
  @Test
  public void testWalletApiUnfreezeBalanceV22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.UnfreezeBalanceV2Contract request = BalanceContract.UnfreezeBalanceV2Contract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.unfreezeBalanceV2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateAccount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountUpdateContract request = AccountContract.AccountUpdateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateAccount2(AccountContract.AccountUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateAccount22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AccountContract.AccountUpdateContract request = AccountContract.AccountUpdateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateAsset2(AssetIssueContractOuterClass.UpdateAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateAsset2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.UpdateAssetContract request = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateAsset2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateAsset2(AssetIssueContractOuterClass.UpdateAssetContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateAsset22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    AssetIssueContractOuterClass.UpdateAssetContract request = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateAsset2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateBrokerage() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StorageContract.UpdateBrokerageContract request = StorageContract.UpdateBrokerageContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateBrokerage(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateBrokerage(StorageContract.UpdateBrokerageContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateBrokerage2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    StorageContract.UpdateBrokerageContract request = StorageContract.UpdateBrokerageContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateBrokerage(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateEnergyLimit(SmartContractOuterClass.UpdateEnergyLimitContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateEnergyLimit() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.UpdateEnergyLimitContract request = SmartContractOuterClass.UpdateEnergyLimitContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateEnergyLimit(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateEnergyLimit(SmartContractOuterClass.UpdateEnergyLimitContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateEnergyLimit2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.UpdateEnergyLimitContract request = SmartContractOuterClass.UpdateEnergyLimitContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateEnergyLimit(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateSetting(SmartContractOuterClass.UpdateSettingContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateSetting() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.UpdateSettingContract request = SmartContractOuterClass.UpdateSettingContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateSetting(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateSetting(SmartContractOuterClass.UpdateSettingContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateSetting2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    SmartContractOuterClass.UpdateSettingContract request = SmartContractOuterClass.UpdateSettingContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateSetting(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateWitness2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.WitnessUpdateContract request = WitnessContract.WitnessUpdateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.updateWitness2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#updateWitness2(WitnessContract.WitnessUpdateContract, StreamObserver)}
   */
  @Test
  public void testWalletApiUpdateWitness22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.WitnessUpdateContract request = WitnessContract.WitnessUpdateContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.updateWitness2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)}
   */
  @Test
  public void testWalletApiVoteWitnessAccount2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.VoteWitnessContract request = WitnessContract.VoteWitnessContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.voteWitnessAccount2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#voteWitnessAccount2(WitnessContract.VoteWitnessContract, StreamObserver)}
   */
  @Test
  public void testWalletApiVoteWitnessAccount22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    WitnessContract.VoteWitnessContract request = WitnessContract.VoteWitnessContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.voteWitnessAccount2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiWithdrawBalance2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.WithdrawBalanceContract request = BalanceContract.WithdrawBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.withdrawBalance2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#withdrawBalance2(BalanceContract.WithdrawBalanceContract, StreamObserver)}
   */
  @Test
  public void testWalletApiWithdrawBalance22() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.WithdrawBalanceContract request = BalanceContract.WithdrawBalanceContract.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.withdrawBalance2(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)}
   */
  @Test
  public void testWalletApiWithdrawExpireUnfreeze() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.WithdrawExpireUnfreezeContract request = BalanceContract.WithdrawExpireUnfreezeContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletApi.withdrawExpireUnfreeze(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletApi#withdrawExpireUnfreeze(BalanceContract.WithdrawExpireUnfreezeContract, StreamObserver)}
   */
  @Test
  public void testWalletApiWithdrawExpireUnfreeze2() {
    // Arrange
    RpcApiService.WalletApi walletApi = (new RpcApiService()).new WalletApi();
    BalanceContract.WithdrawExpireUnfreezeContract request = BalanceContract.WithdrawExpireUnfreezeContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletApi.withdrawExpireUnfreeze(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiEstimateEnergy() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.EstimateEnergyMessage>any());

    // Act
    walletSolidityApi.estimateEnergy(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.EstimateEnergyMessage.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#estimateEnergy(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiEstimateEnergy2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.EstimateEnergyMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException(" : ")).when(responseObserver).onNext(Mockito.<GrpcAPI.EstimateEnergyMessage>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.estimateEnergy(request, responseObserver));
    verify(responseObserver).onNext(isA(GrpcAPI.EstimateEnergyMessage.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetAvailableUnfreezeCount() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.GetAvailableUnfreezeCountRequestMessage request = GrpcAPI.GetAvailableUnfreezeCountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getAvailableUnfreezeCount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetAvailableUnfreezeCount2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getAvailableUnfreezeCount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getAvailableUnfreezeCount(GrpcAPI.GetAvailableUnfreezeCountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetAvailableUnfreezeCount3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.GetAvailableUnfreezeCountRequestMessage request = GrpcAPI.GetAvailableUnfreezeCountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.GetAvailableUnfreezeCountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getAvailableUnfreezeCount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetBandwidthPrices() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBandwidthPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getBandwidthPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetBandwidthPrices2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getBandwidthPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getBlock(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetBlock() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BlockReq request = GrpcAPI.BlockReq.getDefaultInstance();
    StreamObserver<GrpcAPI.BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBlock(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getBrokerageInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetBrokerageInfo() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBrokerageInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getBurnTrx(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetBurnTrx() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getBurnTrx(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanDelegatedMaxSize() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.CanDelegatedMaxSizeRequestMessage request = GrpcAPI.CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanDelegatedMaxSize(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanDelegatedMaxSize2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanDelegatedMaxSize(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanDelegatedMaxSize(GrpcAPI.CanDelegatedMaxSizeRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanDelegatedMaxSize3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.CanDelegatedMaxSizeRequestMessage request = GrpcAPI.CanDelegatedMaxSizeRequestMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.CanDelegatedMaxSizeResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getCanDelegatedMaxSize(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage request = GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanWithdrawUnfreezeAmount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getCanWithdrawUnfreezeAmount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getCanWithdrawUnfreezeAmount(GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetCanWithdrawUnfreezeAmount3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage request = GrpcAPI.CanWithdrawUnfreezeAmountRequestMessage
        .getDefaultInstance();
    StreamObserver<GrpcAPI.CanWithdrawUnfreezeAmountResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getCanWithdrawUnfreezeAmount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndex(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndex(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndex(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndex3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getDelegatedResourceAccountIndex(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndexV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV22() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceAccountIndexV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceAccountIndexV2(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceAccountIndexV23() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.DelegatedResourceAccountIndex> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getDelegatedResourceAccountIndexV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceV2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.DelegatedResourceMessage request = GrpcAPI.DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceV2(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceV22() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getDelegatedResourceV2(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getDelegatedResourceV2(GrpcAPI.DelegatedResourceMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetDelegatedResourceV23() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.DelegatedResourceMessage request = GrpcAPI.DelegatedResourceMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.DelegatedResourceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getDelegatedResourceV2(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetEnergyPrices() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getEnergyPrices(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getEnergyPrices(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetEnergyPrices2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.PricesResponseMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getEnergyPrices(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderByAccount() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderByAccount(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderByAccount2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderByAccount(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderByAccount(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderByAccount3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderByAccount(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderById() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderById(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderById2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderById(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderById(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderById3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrder> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderById(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderListByPair() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderListByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderListByPair2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketOrderListByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketOrderListByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketOrderListByPair3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketOrderListByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketPairList() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPairList(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketPairList(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketPairList2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.EmptyMessage request = GrpcAPI.EmptyMessage.getDefaultInstance();
    StreamObserver<Protocol.MarketOrderPairList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketPairList(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketPriceByPair() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPriceByPair(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketPriceByPair2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMarketPriceByPair(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMarketPriceByPair(Protocol.MarketOrderPair, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMarketPriceByPair3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    Protocol.MarketOrderPair request = Protocol.MarketOrderPair.getDefaultInstance();
    StreamObserver<Protocol.MarketPriceList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMarketPriceByPair(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMerkleTreeVoucherInfo(ShieldContract.OutputPointInfo, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMerkleTreeVoucherInfo() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    ShieldContract.OutputPointInfo request = ShieldContract.OutputPointInfo.getDefaultInstance();
    StreamObserver<ShieldContract.IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getMerkleTreeVoucherInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getMerkleTreeVoucherInfo(ShieldContract.OutputPointInfo, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetMerkleTreeVoucherInfo2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    ShieldContract.OutputPointInfo request = ShieldContract.OutputPointInfo.getDefaultInstance();
    StreamObserver<ShieldContract.IncrementalMerkleVoucherInfo> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.getMerkleTreeVoucherInfo(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getRewardInfo(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetRewardInfo() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.BytesMessage request = GrpcAPI.BytesMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getRewardInfo(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getTransactionCountByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetTransactionCountByBlockNum() {
    // Arrange
    RpcApiService rpcApiService = mock(RpcApiService.class);
    doNothing().when(rpcApiService)
        .getTransactionCountByBlockNumCommon(Mockito.<GrpcAPI.NumberMessage>any(),
            Mockito.<StreamObserver<GrpcAPI.NumberMessage>>any());
    RpcApiService.WalletSolidityApi walletSolidityApi = rpcApiService.new WalletSolidityApi();

    // Act
    walletSolidityApi.getTransactionCountByBlockNum(GrpcAPI.NumberMessage.getDefaultInstance(),
        mock(StreamObserver.class));

    // Assert that nothing has changed
    verify(rpcApiService).getTransactionCountByBlockNumCommon(isA(GrpcAPI.NumberMessage.class),
        isA(StreamObserver.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetTransactionInfoByBlockNum() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getTransactionInfoByBlockNum(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetTransactionInfoByBlockNum2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.getTransactionInfoByBlockNum(null, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#getTransactionInfoByBlockNum(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiGetTransactionInfoByBlockNum3() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NumberMessage request = GrpcAPI.NumberMessage.getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionInfoList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("foo")).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.getTransactionInfoByBlockNum(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#isShieldedTRC20ContractNoteSpent(GrpcAPI.NfTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiIsShieldedTRC20ContractNoteSpent() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NfTRC20Parameters request = GrpcAPI.NfTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.NullifierResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.isShieldedTRC20ContractNoteSpent(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#isShieldedTRC20ContractNoteSpent(GrpcAPI.NfTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiIsShieldedTRC20ContractNoteSpent2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NfTRC20Parameters request = GrpcAPI.NfTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.NullifierResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.isShieldedTRC20ContractNoteSpent(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiIsSpend() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NoteParameters request = GrpcAPI.NoteParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.SpendResult> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.isSpend(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#isSpend(GrpcAPI.NoteParameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiIsSpend2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.NoteParameters request = GrpcAPI.NoteParameters.getDefaultInstance();
    StreamObserver<GrpcAPI.SpendResult> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> walletSolidityApi.isSpend(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#scanShieldedTRC20NotesByIvk(GrpcAPI.IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiScanShieldedTRC20NotesByIvk() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.IvkDecryptTRC20Parameters request = GrpcAPI.IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.scanShieldedTRC20NotesByIvk(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#scanShieldedTRC20NotesByIvk(GrpcAPI.IvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiScanShieldedTRC20NotesByIvk2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.IvkDecryptTRC20Parameters request = GrpcAPI.IvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.scanShieldedTRC20NotesByIvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#scanShieldedTRC20NotesByOvk(GrpcAPI.OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiScanShieldedTRC20NotesByOvk() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.OvkDecryptTRC20Parameters request = GrpcAPI.OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    walletSolidityApi.scanShieldedTRC20NotesByOvk(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#scanShieldedTRC20NotesByOvk(GrpcAPI.OvkDecryptTRC20Parameters, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiScanShieldedTRC20NotesByOvk2() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    GrpcAPI.OvkDecryptTRC20Parameters request = GrpcAPI.OvkDecryptTRC20Parameters.getDefaultInstance();
    StreamObserver<GrpcAPI.DecryptNotesTRC20> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException("Not support Shielded TRC20 Transaction, need to be opened by the committee"))
        .when(responseObserver)
        .onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> walletSolidityApi.scanShieldedTRC20NotesByOvk(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Method under test:
   * {@link RpcApiService.WalletSolidityApi#triggerConstantContract(SmartContractOuterClass.TriggerSmartContract, StreamObserver)}
   */
  @Test
  public void testWalletSolidityApiTriggerConstantContract() {
    // Arrange
    RpcApiService.WalletSolidityApi walletSolidityApi = (new RpcApiService()).new WalletSolidityApi();
    SmartContractOuterClass.TriggerSmartContract request = SmartContractOuterClass.TriggerSmartContract
        .getDefaultInstance();
    StreamObserver<GrpcAPI.TransactionExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onNext(Mockito.<GrpcAPI.TransactionExtention>any());

    // Act
    walletSolidityApi.triggerConstantContract(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(GrpcAPI.TransactionExtention.class));
  }
}
