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
import org.tron.api.TronZksnarkGrpc.TronZksnarkBlockingStub;
import org.tron.api.TronZksnarkGrpc.TronZksnarkFutureStub;
import org.tron.api.TronZksnarkGrpc.TronZksnarkStub;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkRequest;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkResponse;

public class TronZksnarkGrpcDiffblueTest {
  /**
   * Test {@link TronZksnarkGrpc#getCheckZksnarkProofMethod()}.
   * <p>
   * Method under test: {@link TronZksnarkGrpc#getCheckZksnarkProofMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor TronZksnarkGrpc.getCheckZksnarkProofMethod()"})
  public void testGetCheckZksnarkProofMethod() {
    // Arrange and Act
    MethodDescriptor<ZksnarkRequest, ZksnarkResponse> actualCheckZksnarkProofMethod = TronZksnarkGrpc
        .getCheckZksnarkProofMethod();

    // Assert
    assertEquals("CheckZksnarkProof", actualCheckZksnarkProofMethod.getBareMethodName());
    assertEquals("protocol.TronZksnark/CheckZksnarkProof", actualCheckZksnarkProofMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualCheckZksnarkProofMethod.getType());
    assertFalse(actualCheckZksnarkProofMethod.isIdempotent());
    assertFalse(actualCheckZksnarkProofMethod.isSafe());
    assertTrue(actualCheckZksnarkProofMethod.isSampledToLocalTracing());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, actualCheckZksnarkProofMethod.getServiceName());
  }

  /**
   * Test {@link TronZksnarkGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronZksnarkGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronZksnarkStub TronZksnarkGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkStub actualNewStubResult = TronZksnarkGrpc.newStub(channel);

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
   * Test {@link TronZksnarkGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronZksnarkGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronZksnarkBlockingStub TronZksnarkGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkBlockingStub actualNewBlockingStubResult = TronZksnarkGrpc.newBlockingStub(channel);

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
   * Test {@link TronZksnarkGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronZksnarkGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronZksnarkFutureStub TronZksnarkGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    TronZksnarkFutureStub actualNewFutureStubResult = TronZksnarkGrpc.newFutureStub(channel);

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
   * Test {@link TronZksnarkGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link TronZksnarkGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor TronZksnarkGrpc.getServiceDescriptor()"})
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
    assertEquals(MethodType.UNARY, getResult.getType());
    assertFalse(getResult.isIdempotent());
    assertFalse(getResult.isSafe());
    assertTrue(getResult.isSampledToLocalTracing());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, getResult.getServiceName());
    assertEquals(TronZksnarkGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
