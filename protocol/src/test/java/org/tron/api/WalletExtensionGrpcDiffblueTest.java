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

public class WalletExtensionGrpcDiffblueTest {
  /**
   * Method under test:
   * {@link WalletExtensionGrpc#getGetTransactionsFromThisMethod()}
   */
  @Test
  public void testGetGetTransactionsFromThisMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.AccountPaginated, GrpcAPI.TransactionList> actualGetTransactionsFromThisMethod = WalletExtensionGrpc
        .getGetTransactionsFromThisMethod();

    // Assert
    assertEquals("GetTransactionsFromThis", actualGetTransactionsFromThisMethod.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis",
        actualGetTransactionsFromThisMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionsFromThisMethod.getType());
    assertFalse(actualGetTransactionsFromThisMethod.isIdempotent());
    assertFalse(actualGetTransactionsFromThisMethod.isSafe());
    assertTrue(actualGetTransactionsFromThisMethod.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsFromThisMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletExtensionGrpc#getGetTransactionsFromThis2Method()}
   */
  @Test
  public void testGetGetTransactionsFromThis2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.AccountPaginated, GrpcAPI.TransactionListExtention> actualGetTransactionsFromThis2Method = WalletExtensionGrpc
        .getGetTransactionsFromThis2Method();

    // Assert
    assertEquals("GetTransactionsFromThis2", actualGetTransactionsFromThis2Method.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis2",
        actualGetTransactionsFromThis2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionsFromThis2Method.getType());
    assertFalse(actualGetTransactionsFromThis2Method.isIdempotent());
    assertFalse(actualGetTransactionsFromThis2Method.isSafe());
    assertTrue(actualGetTransactionsFromThis2Method.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsFromThis2Method.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletExtensionGrpc#getGetTransactionsToThisMethod()}
   */
  @Test
  public void testGetGetTransactionsToThisMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.AccountPaginated, GrpcAPI.TransactionList> actualGetTransactionsToThisMethod = WalletExtensionGrpc
        .getGetTransactionsToThisMethod();

    // Assert
    assertEquals("GetTransactionsToThis", actualGetTransactionsToThisMethod.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis",
        actualGetTransactionsToThisMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionsToThisMethod.getType());
    assertFalse(actualGetTransactionsToThisMethod.isIdempotent());
    assertFalse(actualGetTransactionsToThisMethod.isSafe());
    assertTrue(actualGetTransactionsToThisMethod.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsToThisMethod.getServiceName());
  }

  /**
   * Method under test:
   * {@link WalletExtensionGrpc#getGetTransactionsToThis2Method()}
   */
  @Test
  public void testGetGetTransactionsToThis2Method() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.AccountPaginated, GrpcAPI.TransactionListExtention> actualGetTransactionsToThis2Method = WalletExtensionGrpc
        .getGetTransactionsToThis2Method();

    // Assert
    assertEquals("GetTransactionsToThis2", actualGetTransactionsToThis2Method.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis2",
        actualGetTransactionsToThis2Method.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetTransactionsToThis2Method.getType());
    assertFalse(actualGetTransactionsToThis2Method.isIdempotent());
    assertFalse(actualGetTransactionsToThis2Method.isSafe());
    assertTrue(actualGetTransactionsToThis2Method.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsToThis2Method.getServiceName());
  }

  /**
   * Method under test: {@link WalletExtensionGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionGrpc.WalletExtensionStub actualNewStubResult = WalletExtensionGrpc.newStub(channel);

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
   * Method under test: {@link WalletExtensionGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionGrpc.WalletExtensionBlockingStub actualNewBlockingStubResult = WalletExtensionGrpc
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
   * Method under test: {@link WalletExtensionGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionGrpc.WalletExtensionFutureStub actualNewFutureStubResult = WalletExtensionGrpc
        .newFutureStub(channel);

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
   * Method under test: {@link WalletExtensionGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletExtensionGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(4, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("GetTransactionsFromThis", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("GetTransactionsFromThis2", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("GetTransactionsToThis", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("GetTransactionsToThis2", getResult4.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis", getResult.getFullMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis2", getResult2.getFullMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis", getResult3.getFullMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis2", getResult4.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult4.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
