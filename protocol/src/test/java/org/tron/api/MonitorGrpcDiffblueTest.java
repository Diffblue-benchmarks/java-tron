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

public class MonitorGrpcDiffblueTest {
  /**
   * Method under test: {@link MonitorGrpc#getGetStatsInfoMethod()}
   */
  @Test
  public void testGetGetStatsInfoMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.MetricsInfo> actualGetStatsInfoMethod = MonitorGrpc
        .getGetStatsInfoMethod();

    // Assert
    assertEquals("GetStatsInfo", actualGetStatsInfoMethod.getBareMethodName());
    assertEquals("protocol.Monitor/GetStatsInfo", actualGetStatsInfoMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetStatsInfoMethod.getType());
    assertFalse(actualGetStatsInfoMethod.isIdempotent());
    assertFalse(actualGetStatsInfoMethod.isSafe());
    assertTrue(actualGetStatsInfoMethod.isSampledToLocalTracing());
    assertEquals(MonitorGrpc.SERVICE_NAME, actualGetStatsInfoMethod.getServiceName());
  }

  /**
   * Method under test: {@link MonitorGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorGrpc.MonitorStub actualNewStubResult = MonitorGrpc.newStub(channel);

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
   * Method under test: {@link MonitorGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorGrpc.MonitorBlockingStub actualNewBlockingStubResult = MonitorGrpc.newBlockingStub(channel);

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
   * Method under test: {@link MonitorGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorGrpc.MonitorFutureStub actualNewFutureStubResult = MonitorGrpc.newFutureStub(channel);

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
   * Method under test: {@link MonitorGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = MonitorGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(1, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("GetStatsInfo", getResult.getBareMethodName());
    assertEquals("protocol.Monitor/GetStatsInfo", getResult.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(MonitorGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(MonitorGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
