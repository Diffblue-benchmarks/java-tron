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

public class TronZksnarkGrpcDiffblueTest {
  /**
   * Method under test: {@link TronZksnarkGrpc#getCheckZksnarkProofMethod()}
   */
  @Test
  public void testGetCheckZksnarkProofMethod() {
    // Arrange and Act
    MethodDescriptor<ZksnarkGrpcAPI.ZksnarkRequest, ZksnarkGrpcAPI.ZksnarkResponse> actualCheckZksnarkProofMethod = TronZksnarkGrpc
        .getCheckZksnarkProofMethod();

    // Assert
    assertEquals("CheckZksnarkProof", actualCheckZksnarkProofMethod.getBareMethodName());
    assertEquals("protocol.TronZksnark/CheckZksnarkProof", actualCheckZksnarkProofMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualCheckZksnarkProofMethod.getType());
    assertFalse(actualCheckZksnarkProofMethod.isIdempotent());
    assertFalse(actualCheckZksnarkProofMethod.isSafe());
    assertTrue(actualCheckZksnarkProofMethod.isSampledToLocalTracing());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, actualCheckZksnarkProofMethod.getServiceName());
  }

  /**
   * Method under test: {@link TronZksnarkGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkGrpc.TronZksnarkStub actualNewStubResult = TronZksnarkGrpc.newStub(channel);

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
   * Method under test: {@link TronZksnarkGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkGrpc.TronZksnarkBlockingStub actualNewBlockingStubResult = TronZksnarkGrpc.newBlockingStub(channel);

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
   * Method under test: {@link TronZksnarkGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkGrpc.TronZksnarkFutureStub actualNewFutureStubResult = TronZksnarkGrpc.newFutureStub(channel);

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
   * Method under test: {@link TronZksnarkGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = TronZksnarkGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(1, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("CheckZksnarkProof", getResult.getBareMethodName());
    assertEquals("protocol.TronZksnark/CheckZksnarkProof", getResult.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
