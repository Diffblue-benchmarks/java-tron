package org.tron.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.ServiceDescriptor;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.MonitorGrpc.MonitorBlockingStub;
import org.tron.api.MonitorGrpc.MonitorFutureStub;
import org.tron.api.MonitorGrpc.MonitorStub;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MetricsInfo;

public class MonitorGrpcDiffblueTest {
  /**
   * Test {@link MonitorGrpc#getGetStatsInfoMethod()}.
   * <p>
   * Method under test: {@link MonitorGrpc#getGetStatsInfoMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor MonitorGrpc.getGetStatsInfoMethod()"})
  public void testGetGetStatsInfoMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, MetricsInfo> actualGetStatsInfoMethod = MonitorGrpc.getGetStatsInfoMethod();

    // Assert
    assertEquals("GetStatsInfo", actualGetStatsInfoMethod.getBareMethodName());
    assertEquals("protocol.Monitor/GetStatsInfo", actualGetStatsInfoMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetStatsInfoMethod.getType());
    assertFalse(actualGetStatsInfoMethod.isIdempotent());
    assertFalse(actualGetStatsInfoMethod.isSafe());
    assertTrue(actualGetStatsInfoMethod.isSampledToLocalTracing());
    assertEquals(MonitorGrpc.SERVICE_NAME, actualGetStatsInfoMethod.getServiceName());
  }

  /**
   * Test {@link MonitorGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonitorGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MonitorStub MonitorGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorStub actualNewStubResult = MonitorGrpc.newStub(channel);

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
   * Test {@link MonitorGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonitorGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MonitorBlockingStub MonitorGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorBlockingStub actualNewBlockingStubResult = MonitorGrpc.newBlockingStub(channel);

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
   * Test {@link MonitorGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonitorGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MonitorFutureStub MonitorGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    MonitorFutureStub actualNewFutureStubResult = MonitorGrpc.newFutureStub(channel);

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
   * Test {@link MonitorGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link MonitorGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor MonitorGrpc.getServiceDescriptor()"})
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
    assertEquals(MethodType.UNARY, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(MonitorGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(MonitorGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
