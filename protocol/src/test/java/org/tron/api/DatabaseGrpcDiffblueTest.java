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
import org.tron.api.DatabaseGrpc.DatabaseBlockingStub;
import org.tron.api.DatabaseGrpc.DatabaseFutureStub;
import org.tron.api.DatabaseGrpc.DatabaseStub;
import org.tron.api.GrpcAPI.BlockReference;
import org.tron.api.GrpcAPI.EmptyMessage;
import org.tron.api.GrpcAPI.NumberMessage;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Block;
import org.tron.protos.Protocol.DynamicProperties;

public class DatabaseGrpcDiffblueTest {
  /**
   * Test {@link DatabaseGrpc#getGetBlockReferenceMethod()}.
   * <p>
   * Method under test: {@link DatabaseGrpc#getGetBlockReferenceMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor DatabaseGrpc.getGetBlockReferenceMethod()"})
  public void testGetGetBlockReferenceMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, BlockReference> actualGetBlockReferenceMethod = DatabaseGrpc
        .getGetBlockReferenceMethod();

    // Assert
    assertEquals("getBlockReference", actualGetBlockReferenceMethod.getBareMethodName());
    assertEquals("protocol.Database/getBlockReference", actualGetBlockReferenceMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockReferenceMethod.getType());
    assertFalse(actualGetBlockReferenceMethod.isIdempotent());
    assertFalse(actualGetBlockReferenceMethod.isSafe());
    assertTrue(actualGetBlockReferenceMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetBlockReferenceMethod.getServiceName());
  }

  /**
   * Test {@link DatabaseGrpc#getGetDynamicPropertiesMethod()}.
   * <p>
   * Method under test: {@link DatabaseGrpc#getGetDynamicPropertiesMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor DatabaseGrpc.getGetDynamicPropertiesMethod()"})
  public void testGetGetDynamicPropertiesMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, DynamicProperties> actualGetDynamicPropertiesMethod = DatabaseGrpc
        .getGetDynamicPropertiesMethod();

    // Assert
    assertEquals("GetDynamicProperties", actualGetDynamicPropertiesMethod.getBareMethodName());
    assertEquals("protocol.Database/GetDynamicProperties", actualGetDynamicPropertiesMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetDynamicPropertiesMethod.getType());
    assertFalse(actualGetDynamicPropertiesMethod.isIdempotent());
    assertFalse(actualGetDynamicPropertiesMethod.isSafe());
    assertTrue(actualGetDynamicPropertiesMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetDynamicPropertiesMethod.getServiceName());
  }

  /**
   * Test {@link DatabaseGrpc#getGetNowBlockMethod()}.
   * <p>
   * Method under test: {@link DatabaseGrpc#getGetNowBlockMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor DatabaseGrpc.getGetNowBlockMethod()"})
  public void testGetGetNowBlockMethod() {
    // Arrange and Act
    MethodDescriptor<EmptyMessage, Block> actualGetNowBlockMethod = DatabaseGrpc.getGetNowBlockMethod();

    // Assert
    assertEquals("GetNowBlock", actualGetNowBlockMethod.getBareMethodName());
    assertEquals("protocol.Database/GetNowBlock", actualGetNowBlockMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetNowBlockMethod.getType());
    assertFalse(actualGetNowBlockMethod.isIdempotent());
    assertFalse(actualGetNowBlockMethod.isSafe());
    assertTrue(actualGetNowBlockMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetNowBlockMethod.getServiceName());
  }

  /**
   * Test {@link DatabaseGrpc#getGetBlockByNumMethod()}.
   * <p>
   * Method under test: {@link DatabaseGrpc#getGetBlockByNumMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor DatabaseGrpc.getGetBlockByNumMethod()"})
  public void testGetGetBlockByNumMethod() {
    // Arrange and Act
    MethodDescriptor<NumberMessage, Block> actualGetBlockByNumMethod = DatabaseGrpc.getGetBlockByNumMethod();

    // Assert
    assertEquals("GetBlockByNum", actualGetBlockByNumMethod.getBareMethodName());
    assertEquals("protocol.Database/GetBlockByNum", actualGetBlockByNumMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetBlockByNumMethod.getType());
    assertFalse(actualGetBlockByNumMethod.isIdempotent());
    assertFalse(actualGetBlockByNumMethod.isSafe());
    assertTrue(actualGetBlockByNumMethod.isSampledToLocalTracing());
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualGetBlockByNumMethod.getServiceName());
  }

  /**
   * Test {@link DatabaseGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DatabaseStub DatabaseGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseStub actualNewStubResult = DatabaseGrpc.newStub(channel);

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
   * Test {@link DatabaseGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DatabaseBlockingStub DatabaseGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseBlockingStub actualNewBlockingStubResult = DatabaseGrpc.newBlockingStub(channel);

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
   * Test {@link DatabaseGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DatabaseFutureStub DatabaseGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    DatabaseFutureStub actualNewFutureStubResult = DatabaseGrpc.newFutureStub(channel);

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
   * Test {@link DatabaseGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link DatabaseGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor DatabaseGrpc.getServiceDescriptor()"})
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = DatabaseGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(4, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(DatabaseGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
