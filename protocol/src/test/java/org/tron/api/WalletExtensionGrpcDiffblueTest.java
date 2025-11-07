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
import org.tron.api.GrpcAPI.AccountPaginated;
import org.tron.api.GrpcAPI.TransactionList;
import org.tron.api.GrpcAPI.TransactionListExtention;
import org.tron.api.WalletExtensionGrpc.WalletExtensionBlockingStub;
import org.tron.api.WalletExtensionGrpc.WalletExtensionFutureStub;
import org.tron.api.WalletExtensionGrpc.WalletExtensionStub;

public class WalletExtensionGrpcDiffblueTest {
  /**
   * Test {@link WalletExtensionGrpc#getGetTransactionsFromThisMethod()}.
   * <p>
   * Method under test: {@link WalletExtensionGrpc#getGetTransactionsFromThisMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletExtensionGrpc.getGetTransactionsFromThisMethod()"})
  public void testGetGetTransactionsFromThisMethod() {
    // Arrange and Act
    MethodDescriptor<AccountPaginated, TransactionList> actualGetTransactionsFromThisMethod = WalletExtensionGrpc
        .getGetTransactionsFromThisMethod();

    // Assert
    assertEquals("GetTransactionsFromThis", actualGetTransactionsFromThisMethod.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis",
        actualGetTransactionsFromThisMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionsFromThisMethod.getType());
    assertFalse(actualGetTransactionsFromThisMethod.isIdempotent());
    assertFalse(actualGetTransactionsFromThisMethod.isSafe());
    assertTrue(actualGetTransactionsFromThisMethod.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsFromThisMethod.getServiceName());
  }

  /**
   * Test {@link WalletExtensionGrpc#getGetTransactionsFromThis2Method()}.
   * <p>
   * Method under test: {@link WalletExtensionGrpc#getGetTransactionsFromThis2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletExtensionGrpc.getGetTransactionsFromThis2Method()"})
  public void testGetGetTransactionsFromThis2Method() {
    // Arrange and Act
    MethodDescriptor<AccountPaginated, TransactionListExtention> actualGetTransactionsFromThis2Method = WalletExtensionGrpc
        .getGetTransactionsFromThis2Method();

    // Assert
    assertEquals("GetTransactionsFromThis2", actualGetTransactionsFromThis2Method.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsFromThis2",
        actualGetTransactionsFromThis2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionsFromThis2Method.getType());
    assertFalse(actualGetTransactionsFromThis2Method.isIdempotent());
    assertFalse(actualGetTransactionsFromThis2Method.isSafe());
    assertTrue(actualGetTransactionsFromThis2Method.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsFromThis2Method.getServiceName());
  }

  /**
   * Test {@link WalletExtensionGrpc#getGetTransactionsToThisMethod()}.
   * <p>
   * Method under test: {@link WalletExtensionGrpc#getGetTransactionsToThisMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletExtensionGrpc.getGetTransactionsToThisMethod()"})
  public void testGetGetTransactionsToThisMethod() {
    // Arrange and Act
    MethodDescriptor<AccountPaginated, TransactionList> actualGetTransactionsToThisMethod = WalletExtensionGrpc
        .getGetTransactionsToThisMethod();

    // Assert
    assertEquals("GetTransactionsToThis", actualGetTransactionsToThisMethod.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis",
        actualGetTransactionsToThisMethod.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionsToThisMethod.getType());
    assertFalse(actualGetTransactionsToThisMethod.isIdempotent());
    assertFalse(actualGetTransactionsToThisMethod.isSafe());
    assertTrue(actualGetTransactionsToThisMethod.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsToThisMethod.getServiceName());
  }

  /**
   * Test {@link WalletExtensionGrpc#getGetTransactionsToThis2Method()}.
   * <p>
   * Method under test: {@link WalletExtensionGrpc#getGetTransactionsToThis2Method()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodDescriptor WalletExtensionGrpc.getGetTransactionsToThis2Method()"})
  public void testGetGetTransactionsToThis2Method() {
    // Arrange and Act
    MethodDescriptor<AccountPaginated, TransactionListExtention> actualGetTransactionsToThis2Method = WalletExtensionGrpc
        .getGetTransactionsToThis2Method();

    // Assert
    assertEquals("GetTransactionsToThis2", actualGetTransactionsToThis2Method.getBareMethodName());
    assertEquals("protocol.WalletExtension/GetTransactionsToThis2",
        actualGetTransactionsToThis2Method.getFullMethodName());
    assertEquals(MethodType.UNARY, actualGetTransactionsToThis2Method.getType());
    assertFalse(actualGetTransactionsToThis2Method.isIdempotent());
    assertFalse(actualGetTransactionsToThis2Method.isSafe());
    assertTrue(actualGetTransactionsToThis2Method.isSampledToLocalTracing());
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualGetTransactionsToThis2Method.getServiceName());
  }

  /**
   * Test {@link WalletExtensionGrpc#newStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletExtensionGrpc#newStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletExtensionStub WalletExtensionGrpc.newStub(Channel)"})
  public void testNewStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionStub actualNewStubResult = WalletExtensionGrpc.newStub(channel);

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
   * Test {@link WalletExtensionGrpc#newBlockingStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletExtensionGrpc#newBlockingStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletExtensionBlockingStub WalletExtensionGrpc.newBlockingStub(Channel)"})
  public void testNewBlockingStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionBlockingStub actualNewBlockingStubResult = WalletExtensionGrpc.newBlockingStub(channel);

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
   * Test {@link WalletExtensionGrpc#newFutureStub(Channel)}.
   * <ul>
   *   <li>When {@link Channel}.</li>
   *   <li>Then return CallOptions Credentials is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WalletExtensionGrpc#newFutureStub(Channel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WalletExtensionFutureStub WalletExtensionGrpc.newFutureStub(Channel)"})
  public void testNewFutureStub_whenChannel_thenReturnCallOptionsCredentialsIsNull() {
    // Arrange
    Channel channel = mock(Channel.class);

    // Act
    WalletExtensionFutureStub actualNewFutureStubResult = WalletExtensionGrpc.newFutureStub(channel);

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
   * Test {@link WalletExtensionGrpc#getServiceDescriptor()}.
   * <p>
   * Method under test: {@link WalletExtensionGrpc#getServiceDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ServiceDescriptor WalletExtensionGrpc.getServiceDescriptor()"})
  public void testGetServiceDescriptor() {
    // Arrange and Act
    ServiceDescriptor actualServiceDescriptor = WalletExtensionGrpc.getServiceDescriptor();

    // Assert
    Collection<MethodDescriptor<?, ?>> methods = actualServiceDescriptor.getMethods();
    assertEquals(4, methods.size());
    assertTrue(methods instanceof List);
    assertEquals(WalletExtensionGrpc.SERVICE_NAME, actualServiceDescriptor.getName());
  }
}
