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

public class NetworkGrpcDiffblueTest {
  /**
   * Method under test: {@link NetworkGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    NetworkGrpc.NetworkStub actualNewStubResult = NetworkGrpc.newStub(channel);

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
   * Method under test: {@link NetworkGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    NetworkGrpc.NetworkBlockingStub actualNewBlockingStubResult = NetworkGrpc.newBlockingStub(channel);

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
   * Method under test: {@link NetworkGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    NetworkGrpc.NetworkFutureStub actualNewFutureStubResult = NetworkGrpc.newFutureStub(channel);

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
   * Method under test: {@link NetworkGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = NetworkGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertTrue(methods instanceof List);
    assertTrue(methods.isEmpty());
    assertEquals(NetworkGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
