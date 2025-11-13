package org.tron.core.services;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import java.io.UnsupportedEncodingException;
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
import org.tron.api.GrpcAPI.BlockReq;
import org.tron.api.GrpcAPI.BytesMessage;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.GrpcAPI.NumberMessage;
import org.tron.api.GrpcAPI.TransactionIdList;
import org.tron.core.ChainBaseManager;
import org.tron.core.Wallet;
import org.tron.core.db.Manager;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.service.MortgageService;
import org.tron.core.services.RpcApiService.DatabaseApi;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

@RunWith(MockitoJUnitRunner.class)
public class RpcApiServiceDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private DatabaseApi databaseApi;

  @Mock private Manager manager;

  @InjectMocks private RpcApiService rpcApiService;

  @Mock private Wallet wallet;

  /**
   * Test {@link RpcApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link DatabaseApi} {@link DatabaseApi#bindService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link DatabaseApi#bindService()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.start()"})
  public void testStart_givenDatabaseApiBindServiceThrowRuntimeException_thenCallsBindService() {
    // Arrange
    when(databaseApi.bindService()).thenThrow(new RuntimeException());

    // Act
    rpcApiService.start();

    // Assert
    verify(databaseApi).bindService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getMortgageService()} return {@link MortgageService}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getMortgageService()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   *
   * <ul>
   *   <li>Given {@link MortgageService} {@link MortgageService#queryReward(byte[])} return one.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetRewardInfoCommon_givenMortgageServiceQueryRewardReturnOne_thenCallsOnNext() {
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
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link GrpcAPI.BytesMessage} {@link GrpcAPI.BytesMessage#getValue()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetRewardInfoCommon_givenNull_whenBytesMessageGetValueReturnNull() {
    // Arrange
    when(manager.getMortgageService()).thenReturn(mock(MortgageService.class));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(null);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(request).getValue();
    verify(manager).getMortgageService();
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link StreamObserver#onError(Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetRewardInfoCommon_givenRpcApiService_whenDefaultInstance_thenCallsOnError() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetRewardInfoCommon_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getRewardInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetRewardInfoCommon_thenCallsToByteArray() throws UnsupportedEncodingException {
    // Arrange
    MortgageService mortgageService = mock(MortgageService.class);
    when(mortgageService.queryReward(Mockito.<byte[]>any())).thenReturn(1L);
    when(manager.getMortgageService()).thenReturn(mortgageService);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(byteString);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getRewardInfoCommon(request, responseObserver);

    // Assert
    verify(byteString).toByteArray();
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(request).getValue();
    verify(manager).getMortgageService();
    verify(mortgageService).queryReward(isA(byte[].class));
  }

  /**
   * Test {@link RpcApiService#getRewardInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getRewardInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getRewardInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When {@link StreamObserver} {@link StreamObserver#onError(Throwable)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_givenRpcApiService_whenStreamObserverOnErrorDoesNothing() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBurnTrxCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_thenThrowRuntimeException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getBurnTrxCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link RpcApiService#getBurnTrxCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBurnTrxCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBurnTrxCommon(GrpcAPI.EmptyMessage, StreamObserver)"})
  public void testGetBurnTrxCommon_whenStreamObserverOnNextThrowRuntimeException() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBurnTrxAmount()).thenReturn(1L);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onNext(Mockito.<NumberMessage>any());
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
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDelegationStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDelegationStore()} return {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDelegationStore()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_givenManagerGetDelegationStoreThrowRuntimeException() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenThrow(new RuntimeException());
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
   *
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getDynamicPropertiesStore()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link GrpcAPI.BytesMessage} {@link GrpcAPI.BytesMessage#getValue()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_givenNull_whenBytesMessageGetValueReturnNull() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(null);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(request).getValue();
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_givenRpcApiService_whenDefaultInstance() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);
    when(manager.getDelegationStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(byteString);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(byteString).toByteArray();
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(request).getValue();
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_thenThrowRuntimeException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getBrokerageInfoCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_whenStreamObserverOnNextDoesNothing_thenCallsOnNext()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);

    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(byteString);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(byteString).toByteArray();
    verify(responseObserver).onCompleted();
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(request).getValue();
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getBrokerageInfoCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBrokerageInfoCommon(GrpcAPI.BytesMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getBrokerageInfoCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetBrokerageInfoCommon_whenStreamObserverOnNextThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getCurrentCycleNumber()).thenReturn(1L);

    DelegationStore delegationStore = mock(DelegationStore.class);
    when(delegationStore.getBrokerage(anyLong(), Mockito.<byte[]>any())).thenReturn(1);
    when(manager.getDelegationStore()).thenReturn(delegationStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(byteString);

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onNext(Mockito.<NumberMessage>any());
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getBrokerageInfoCommon(request, responseObserver);

    // Assert
    verify(byteString).toByteArray();
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(request).getValue();
    verify(manager).getDelegationStore();
    verify(manager).getDynamicPropertiesStore();
    verify(delegationStore).getBrokerage(eq(1L), isA(byte[].class));
    verify(dynamicPropertiesStore).getCurrentCycleNumber();
  }

  /**
   * Test {@link RpcApiService#getTransactionCountByBlockNumCommon(NumberMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link GrpcAPI.NumberMessage#getNum()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)"
  })
  public void testGetTransactionCountByBlockNumCommon_givenOne_thenCallsGetNum()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());

    NumberMessage request = mock(NumberMessage.class);
    when(request.getNum()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rpcApiService.getTransactionCountByBlockNumCommon(request, mock(StreamObserver.class)));
    verify(request).getNum();
    verify(chainBaseManager).getBlockByNum(1L);
  }

  /**
   * Test {@link RpcApiService#getTransactionCountByBlockNumCommon(NumberMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionCountByBlockNumCommon(GrpcAPI.NumberMessage, StreamObserver)"
  })
  public void testGetTransactionCountByBlockNumCommon_thenThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    when(chainBaseManager.getBlockByNum(anyLong())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rpcApiService.getTransactionCountByBlockNumCommon(
                NumberMessage.getDefaultInstance(), mock(StreamObserver.class)));
    verify(chainBaseManager).getBlockByNum(0L);
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link GrpcAPI.BytesMessage} {@link GrpcAPI.BytesMessage#getValue()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon_givenNull_whenBytesMessageGetValueReturnNull() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(null);

    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(request).getValue();
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon_givenRpcApiService_whenDefaultInstance() {
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
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon_givenRpcApiService_whenNull() {
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
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then calls {@link Manager#getTxFromPending(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon_thenCallsGetTxFromPending() {
    // Arrange
    when(manager.getTxFromPending(Mockito.<String>any())).thenThrow(new RuntimeException());
    BytesMessage request = BytesMessage.getDefaultInstance();

    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(manager).getTxFromPending("");
  }

  /**
   * Test {@link RpcApiService#getTransactionFromPendingCommon(BytesMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionFromPendingCommon(GrpcAPI.BytesMessage, StreamObserver)"
  })
  public void testGetTransactionFromPendingCommon_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    when(manager.getTxFromPending(Mockito.<String>any())).thenThrow(new RuntimeException());

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BytesMessage request = mock(BytesMessage.class);
    when(request.getValue()).thenReturn(byteString);

    StreamObserver<Transaction> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionFromPendingCommon(request, responseObserver));
    verify(byteString).toByteArray();
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(request).getValue();
    verify(manager).getTxFromPending("4158415841584158");
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetTransactionListFromPendingCommon() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetTransactionListFromPendingCommon2() {
    // Arrange
    when(manager.getTxListFromPending()).thenReturn(new ArrayList<>());
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();
    doThrow(new RuntimeException()).when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetTransactionListFromPendingCommon_givenArrayListAddFoo() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    when(manager.getTxListFromPending()).thenReturn(stringList);
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();
    doThrow(new RuntimeException()).when(responseObserver).onNext(Mockito.<TransactionIdList>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getTransactionListFromPendingCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(TransactionIdList.class));
    verify(manager).getTxListFromPending();
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetTransactionListFromPendingCommon_givenRpcApiService() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<TransactionIdList> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getTransactionListFromPendingCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getTransactionListFromPendingCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * RpcApiService#getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getTransactionListFromPendingCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetTransactionListFromPendingCommon_whenStreamObserverOnNextDoesNothing() {
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
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetPendingSizeCommon_givenRpcApiService() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onCompleted();
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());

    // Act
    rpcApiService.getPendingSizeCommon(request, responseObserver);

    // Assert
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onCompleted()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetPendingSizeCommon_whenStreamObserverOnCompletedThrowRuntimeException() {
    // Arrange
    when(manager.getPendingSize()).thenReturn(3L);
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();
    doThrow(new RuntimeException()).when(responseObserver).onNext(Mockito.<NumberMessage>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(responseObserver).onNext(isA(NumberMessage.class));
    verify(manager).getPendingSize();
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onError(Throwable)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetPendingSizeCommon_whenStreamObserverOnErrorThrowRuntimeException() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    EmptyMessage request = EmptyMessage.getDefaultInstance();

    StreamObserver<NumberMessage> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rpcApiService.getPendingSizeCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getPendingSizeCommon(EmptyMessage, StreamObserver)}.
   *
   * <ul>
   *   <li>When {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getPendingSizeCommon(GrpcAPI.EmptyMessage,
   * StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcApiService.getPendingSizeCommon(GrpcAPI.EmptyMessage, StreamObserver)"
  })
  public void testGetPendingSizeCommon_whenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
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
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_givenRpcApiService() {
    // Arrange
    RpcApiService rpcApiService = new RpcApiService();
    BlockReq request = BlockReq.getDefaultInstance();

    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
  }

  /**
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link RpcApiService} (default constructor).
   *   <li>When {@link StreamObserver} {@link StreamObserver#onCompleted()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_givenRpcApiService_whenStreamObserverOnCompletedDoesNothing() {
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
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlock(BlockReq)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_givenWalletGetBlockThrowIllegalArgumentException() {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    BlockReq request = BlockReq.getDefaultInstance();

    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(wallet).getBlock(isA(BlockReq.class));
  }

  /**
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlock(BlockReq)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_givenWalletGetBlockThrowIllegalArgumentException2() {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new IllegalArgumentException());
    BlockReq request = BlockReq.getDefaultInstance();

    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doThrow(new RuntimeException()).when(responseObserver).onError(Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onError(isA(Throwable.class));
    verify(wallet).getBlock(isA(BlockReq.class));
  }

  /**
   * Test {@link RpcApiService#getBlockCommon(BlockReq, StreamObserver)}.
   *
   * <ul>
   *   <li>Given {@link Wallet} {@link Wallet#getBlock(BlockReq)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RpcApiService#getBlockCommon(GrpcAPI.BlockReq, StreamObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RpcApiService.getBlockCommon(GrpcAPI.BlockReq, StreamObserver)"})
  public void testGetBlockCommon_givenWalletGetBlockThrowRuntimeException() {
    // Arrange
    when(wallet.getBlock(Mockito.<BlockReq>any())).thenThrow(new RuntimeException());
    BlockReq request = BlockReq.getDefaultInstance();

    StreamObserver<BlockExtention> responseObserver = mock(StreamObserver.class);
    doNothing().when(responseObserver).onError(Mockito.<Throwable>any());
    doThrow(new RuntimeException()).when(responseObserver).onCompleted();

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rpcApiService.getBlockCommon(request, responseObserver));
    verify(responseObserver).onCompleted();
    verify(responseObserver).onError(isA(Throwable.class));
    verify(wallet).getBlock(isA(BlockReq.class));
  }
}
