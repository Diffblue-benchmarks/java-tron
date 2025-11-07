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

public class DatabaseGrpcDiffblueTest {
  /**
   * Method under test: {@link DatabaseGrpc#getGetBlockReferenceMethod()}
   */
  @Test
  public void testGetGetBlockReferenceMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, GrpcAPI.BlockReference> actualGetBlockReferenceMethod = DatabaseGrpc
        .getGetBlockReferenceMethod();

    // Assert
    assertEquals("getBlockReference", actualGetBlockReferenceMethod.getBareMethodName());
    assertEquals("protocol.Database/getBlockReference", actualGetBlockReferenceMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockReferenceMethod.getType());
    assertFalse(actualGetBlockReferenceMethod.isIdempotent());
    assertFalse(actualGetBlockReferenceMethod.isSafe());
    assertTrue(actualGetBlockReferenceMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetBlockReferenceMethod.getServiceName());
  }

  /**
   * Method under test: {@link DatabaseGrpc#getGetDynamicPropertiesMethod()}
   */
  @Test
  public void testGetGetDynamicPropertiesMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.DynamicProperties> actualGetDynamicPropertiesMethod = DatabaseGrpc
        .getGetDynamicPropertiesMethod();

    // Assert
    assertEquals("GetDynamicProperties", actualGetDynamicPropertiesMethod.getBareMethodName());
    assertEquals("protocol.Database/GetDynamicProperties", actualGetDynamicPropertiesMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetDynamicPropertiesMethod.getType());
    assertFalse(actualGetDynamicPropertiesMethod.isIdempotent());
    assertFalse(actualGetDynamicPropertiesMethod.isSafe());
    assertTrue(actualGetDynamicPropertiesMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetDynamicPropertiesMethod.getServiceName());
  }

  /**
   * Method under test: {@link DatabaseGrpc#getGetNowBlockMethod()}
   */
  @Test
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.EmptyMessage, Protocol.Block> actualGetNowBlockMethod = DatabaseGrpc
        .getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.Database/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Method under test: {@link DatabaseGrpc#getGetBlockByNumMethod()}
   */
  @Test
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<GrpcAPI.NumberMessage, Protocol.Block> actualGetBlockByNumMethod = DatabaseGrpc
        .getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.Database/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Method under test: {@link DatabaseGrpc#newStub(Channel)}
   */
  @Test
  public void testNewStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseGrpc.DatabaseStub actualNewStubResult = DatabaseGrpc.newStub(channel);

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
   * Method under test: {@link DatabaseGrpc#newBlockingStub(Channel)}
   */
  @Test
  public void testNewBlockingStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseGrpc.DatabaseBlockingStub actualNewBlockingStubResult = DatabaseGrpc.newBlockingStub(channel);

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
   * Method under test: {@link DatabaseGrpc#newFutureStub(Channel)}
   */
  @Test
  public void testNewFutureStub() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseGrpc.DatabaseFutureStub actualNewFutureStubResult = DatabaseGrpc.newFutureStub(channel);

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
   * Method under test: {@link DatabaseGrpc#getServiceDescriptor()}
   */
  @Test
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = DatabaseGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(4, methods.size());
    assertTrue(methods instanceof List);
    MethodDescriptor<?, ?> getResult = ((List<MethodDescriptor<?, ?>>) methods).get(3);
    assertEquals("GetBlockByNum", getResult.getBareMethodName());
    MethodDescriptor<?, ?> getResult2 = ((List<MethodDescriptor<?, ?>>) methods).get(1);
    assertEquals("GetDynamicProperties", getResult2.getBareMethodName());
    MethodDescriptor<?, ?> getResult3 = ((List<MethodDescriptor<?, ?>>) methods).get(2);
    assertEquals("GetNowBlock", getResult3.getBareMethodName());
    MethodDescriptor<?, ?> getResult4 = ((List<MethodDescriptor<?, ?>>) methods).get(0);
    assertEquals("getBlockReference", getResult4.getBareMethodName());
    assertEquals("protocol.Database/GetBlockByNum", getResult.getFullMethodName());
    assertEquals("protocol.Database/GetDynamicProperties", getResult2.getFullMethodName());
    assertEquals("protocol.Database/GetNowBlock", getResult3.getFullMethodName());
    assertEquals("protocol.Database/getBlockReference", getResult4.getFullMethodName());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult4.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult2.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult3.getType());
    assertEquals(MethodDescriptor.MethodType.UNARY, getResult.getType());
    assertFalse(getResult4.isIdempotent());
    assertFalse(getResult2.isIdempotent());
    assertFalse(getResult3.isIdempotent());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult4.isSafe());
    assertFalse(getResult2.isSafe());
    assertFalse(getResult3.isSafe());
    assertFalse(getResult.isSafe());
    assertTrue(getResult4.isSampledToLocalTracing());
    assertTrue(getResult2.isSampledToLocalTracing());
    assertTrue(getResult3.isSampledToLocalTracing());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, getResult4.getServiceName());
    assertEquals(DatabaseGrpc.SERVICE_NAME, getResult2.getServiceName());
    assertEquals(DatabaseGrpc.SERVICE_NAME, getResult3.getServiceName());
    assertEquals(DatabaseGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
