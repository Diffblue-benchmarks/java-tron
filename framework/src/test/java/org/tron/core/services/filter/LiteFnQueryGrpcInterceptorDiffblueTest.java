package org.tron.core.services.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;

@RunWith(MockitoJUnitRunner.class)
public class LiteFnQueryGrpcInterceptorDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private LiteFnQueryGrpcInterceptor liteFnQueryGrpcInterceptor;

  /**
   * Method under test: {@link LiteFnQueryGrpcInterceptor#getFilterMethods()}
   */
  @Test
  public void testGetFilterMethods() {
    // Arrange and Act
    Set<String> actualFilterMethods = (new LiteFnQueryGrpcInterceptor()).getFilterMethods();

    // Assert
    assertEquals(43, actualFilterMethods.size());
    assertTrue(actualFilterMethods.contains("protocol.Wallet/GetBlockById"));
    assertTrue(actualFilterMethods.contains("protocol.Wallet/GetBlockByNum"));
    assertTrue(actualFilterMethods.contains("protocol.Wallet/GetTransactionInfoById"));
    assertTrue(actualFilterMethods.contains("protocol.Wallet/ScanNoteByIvk"));
    assertTrue(actualFilterMethods.contains("protocol.Wallet/ScanNoteByOvk"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/GetBlockByNum2"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/GetMarketOrderListByPair"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/IsShieldedTRC20ContractNoteSpent"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/ScanAndMarkNoteByIvk"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/ScanShieldedTRC20NotesByIvk"));
    assertTrue(actualFilterMethods.contains("protocol.WalletSolidity/ScanShieldedTRC20NotesByOvk"));
  }

  /**
   * Method under test:
   * {@link LiteFnQueryGrpcInterceptor#interceptCall(ServerCall, Metadata, ServerCallHandler)}
   */
  @Test
  public void testInterceptCall() {
    // Arrange
    when(chainBaseManager.isLiteNode()).thenReturn(false);
    Metadata headers = new Metadata();
    ServerCallHandler<Object, Object> next = mock(ServerCallHandler.class);
    when(next.startCall(Mockito.<ServerCall<Object, Object>>any(), Mockito.<Metadata>any())).thenReturn(null);

    // Act
    ServerCall.Listener<Object> actualInterceptCallResult = liteFnQueryGrpcInterceptor.interceptCall(null, headers,
        next);

    // Assert
    verify(next).startCall(isNull(), isA(Metadata.class));
    verify(chainBaseManager).isLiteNode();
    assertNull(actualInterceptCallResult);
  }
}
