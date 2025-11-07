package org.tron.protos.contract;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.BalanceContract.AccountBalanceRequest;
import org.tron.protos.contract.BalanceContract.AccountBalanceRequest.Builder;
import org.tron.protos.contract.BalanceContract.AccountBalanceResponse;
import org.tron.protos.contract.BalanceContract.AccountIdentifier;
import org.tron.protos.contract.BalanceContract.AccountTrace;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace;
import org.tron.protos.contract.BalanceContract.BlockBalanceTrace.BlockIdentifier;
import org.tron.protos.contract.BalanceContract.CancelAllUnfreezeV2Contract;
import org.tron.protos.contract.BalanceContract.DelegateResourceContract;
import org.tron.protos.contract.BalanceContract.FreezeBalanceContract;
import org.tron.protos.contract.BalanceContract.FreezeBalanceV2Contract;
import org.tron.protos.contract.BalanceContract.TransactionBalanceTrace;
import org.tron.protos.contract.BalanceContract.TransactionBalanceTrace.Operation;
import org.tron.protos.contract.BalanceContract.TransferContract;
import org.tron.protos.contract.BalanceContract.UnDelegateResourceContract;
import org.tron.protos.contract.BalanceContract.UnfreezeBalanceContract;
import org.tron.protos.contract.BalanceContract.UnfreezeBalanceV2Contract;
import org.tron.protos.contract.BalanceContract.WithdrawBalanceContract;
import org.tron.protos.contract.BalanceContract.WithdrawExpireUnfreezeContract;
import org.tron.protos.contract.Common.ResourceCode;
import org.tron.protos.contract.WitnessContract.WitnessUpdateContract;

public class BalanceContractDiffblueTest {
  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#equals(Object)}, and {@link AccountBalanceRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountBalanceRequest#equals(Object)}
   *   <li>{@link AccountBalanceRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.equals(Object)", "int AccountBalanceRequest.hashCode()"})
  public void testAccountBalanceRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountBalanceRequest defaultInstance = AccountBalanceRequest.getDefaultInstance();
    AccountBalanceRequest defaultInstance2 = AccountBalanceRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#equals(Object)}, and {@link AccountBalanceRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountBalanceRequest#equals(Object)}
   *   <li>{@link AccountBalanceRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.equals(Object)", "int AccountBalanceRequest.hashCode()"})
  public void testAccountBalanceRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountBalanceRequest defaultInstance = AccountBalanceRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.equals(Object)", "int AccountBalanceRequest.hashCode()"})
  public void testAccountBalanceRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceRequest.getDefaultInstance(), 1);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.equals(Object)", "int AccountBalanceRequest.hashCode()"})
  public void testAccountBalanceRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceRequest.getDefaultInstance(), null);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.equals(Object)", "int AccountBalanceRequest.hashCode()"})
  public void testAccountBalanceRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceRequest.getDefaultInstance(), "Different type to AccountBalanceRequest");
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#getAccountIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#getAccountIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountBalanceRequest.getAccountIdentifier()"})
  public void testAccountBalanceRequestGetAccountIdentifier() {
    // Arrange and Act
    AccountIdentifier actualAccountIdentifier = AccountBalanceRequest.getDefaultInstance().getAccountIdentifier();

    // Assert
    assertEquals("", actualAccountIdentifier.getInitializationErrorString());
    assertEquals(0, actualAccountIdentifier.getSerializedSize());
    assertTrue(actualAccountIdentifier.findInitializationErrors().isEmpty());
    assertTrue(actualAccountIdentifier.getAllFields().isEmpty());
    assertTrue(actualAccountIdentifier.isInitialized());
    assertSame(actualAccountIdentifier, actualAccountIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#getBlockIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#getBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier AccountBalanceRequest.getBlockIdentifier()"})
  public void testAccountBalanceRequestGetBlockIdentifier() {
    // Arrange and Act
    BlockIdentifier actualBlockIdentifier = AccountBalanceRequest.getDefaultInstance().getBlockIdentifier();

    // Assert
    assertEquals("", actualBlockIdentifier.getInitializationErrorString());
    assertEquals(0, actualBlockIdentifier.getSerializedSize());
    assertEquals(0L, actualBlockIdentifier.getNumber());
    assertTrue(actualBlockIdentifier.findInitializationErrors().isEmpty());
    assertTrue(actualBlockIdentifier.getAllFields().isEmpty());
    assertTrue(actualBlockIdentifier.isInitialized());
    assertSame(actualBlockIdentifier, actualBlockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.getDefaultInstanceForType()"})
  public void testAccountBalanceRequestGetDefaultInstanceForType() {
    // Arrange
    AccountBalanceRequest defaultInstance = AccountBalanceRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountBalanceRequest.getDescriptor()"})
  public void testAccountBalanceRequestGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountBalanceRequest.getDescriptor();

    // Assert
    assertEquals("AccountBalanceRequest", actualDescriptor.getName());
    assertEquals("protocol.AccountBalanceRequest", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(8, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountBalanceRequest.getSerializedSize()"})
  public void testAccountBalanceRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountBalanceRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#hasAccountIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#hasAccountIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.hasAccountIdentifier()"})
  public void testAccountBalanceRequestHasAccountIdentifier() {
    // Arrange, Act and Assert
    assertFalse(AccountBalanceRequest.getDefaultInstance().hasAccountIdentifier());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#hasBlockIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#hasBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.hasBlockIdentifier()"})
  public void testAccountBalanceRequestHasBlockIdentifier() {
    // Arrange, Act and Assert
    assertFalse(AccountBalanceRequest.getDefaultInstance().hasBlockIdentifier());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#isInitialized()}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceRequest.isInitialized()"})
  public void testAccountBalanceRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountBalanceRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceRequest actualParseDelimitedFromResult = AccountBalanceRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    AccountIdentifier accountIdentifier = actualParseDelimitedFromResult.getAccountIdentifier();
    AccountBalanceRequest defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(accountIdentifier, defaultInstanceForType.getAccountIdentifier());
    assertSame(accountIdentifier, defaultInstanceForType.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, actualParseDelimitedFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceRequest actualParseDelimitedFromResult = AccountBalanceRequest.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    AccountIdentifier accountIdentifier = actualParseDelimitedFromResult.getAccountIdentifier();
    assertSame(unknownFields, accountIdentifier.getUnknownFields());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(accountIdentifier, actualParseDelimitedFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountBalanceRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceRequest actualParseDelimitedFromResult = AccountBalanceRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    AccountIdentifier accountIdentifier = actualParseDelimitedFromResult.getAccountIdentifier();
    AccountBalanceRequest defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(accountIdentifier, defaultInstanceForType.getAccountIdentifier());
    assertSame(accountIdentifier, defaultInstanceForType.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, actualParseDelimitedFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceRequest actualParseDelimitedFromResult = AccountBalanceRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    AccountIdentifier accountIdentifier = actualParseDelimitedFromResult.getAccountIdentifier();
    assertSame(unknownFields, accountIdentifier.getUnknownFields());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(accountIdentifier, actualParseDelimitedFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountBalanceRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountBalanceRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountBalanceRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountBalanceRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountBalanceRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(byte[])"})
  public void testAccountBalanceRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(ByteBuffer)"})
  public void testAccountBalanceRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(ByteString)"})
  public void testAccountBalanceRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(CodedInputStream)"})
  public void testAccountBalanceRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream)"})
  public void testAccountBalanceRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    AccountIdentifier accountIdentifier = actualParseFromResult.getAccountIdentifier();
    assertSame(unknownFields, accountIdentifier.getUnknownFields());
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(accountIdentifier, actualParseFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream)"})
  public void testAccountBalanceRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountBalanceRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasAccountIdentifier());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountBalanceRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountBalanceRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream)"})
  public void testAccountBalanceRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountBalanceRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceRequest {@link AccountBalanceRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceRequest AccountBalanceRequest.parseFrom(InputStream)"})
  public void testAccountBalanceRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountBalanceRequest actualParseFromResult = AccountBalanceRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    AccountIdentifier accountIdentifier = actualParseFromResult.getAccountIdentifier();
    assertSame(unknownFields, accountIdentifier.getUnknownFields());
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(accountIdentifier, actualParseFromResult.getAccountIdentifierOrBuilder());
    assertSame(accountIdentifier, accountIdentifier.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceRequest_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testAccountBalanceRequest_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("AccountBalanceRequest", actualDescriptor.getName());
    assertEquals("protocol.AccountBalanceRequest", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(8, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#equals(Object)}, and {@link AccountBalanceResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountBalanceResponse#equals(Object)}
   *   <li>{@link AccountBalanceResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.equals(Object)", "int AccountBalanceResponse.hashCode()"})
  public void testAccountBalanceResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountBalanceResponse defaultInstance = AccountBalanceResponse.getDefaultInstance();
    AccountBalanceResponse defaultInstance2 = AccountBalanceResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#equals(Object)}, and {@link AccountBalanceResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountBalanceResponse#equals(Object)}
   *   <li>{@link AccountBalanceResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.equals(Object)", "int AccountBalanceResponse.hashCode()"})
  public void testAccountBalanceResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountBalanceResponse defaultInstance = AccountBalanceResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.equals(Object)", "int AccountBalanceResponse.hashCode()"})
  public void testAccountBalanceResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceResponse.getDefaultInstance(), 1);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.equals(Object)", "int AccountBalanceResponse.hashCode()"})
  public void testAccountBalanceResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceResponse.getDefaultInstance(), null);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.equals(Object)", "int AccountBalanceResponse.hashCode()"})
  public void testAccountBalanceResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountBalanceResponse.getDefaultInstance(), "Different type to AccountBalanceResponse");
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#getBlockIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#getBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier AccountBalanceResponse.getBlockIdentifier()"})
  public void testAccountBalanceResponseGetBlockIdentifier() {
    // Arrange and Act
    BlockIdentifier actualBlockIdentifier = AccountBalanceResponse.getDefaultInstance().getBlockIdentifier();

    // Assert
    assertEquals("", actualBlockIdentifier.getInitializationErrorString());
    assertEquals(0, actualBlockIdentifier.getSerializedSize());
    assertEquals(0L, actualBlockIdentifier.getNumber());
    assertTrue(actualBlockIdentifier.findInitializationErrors().isEmpty());
    assertTrue(actualBlockIdentifier.getAllFields().isEmpty());
    assertTrue(actualBlockIdentifier.isInitialized());
    assertSame(actualBlockIdentifier, actualBlockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.getDefaultInstanceForType()"})
  public void testAccountBalanceResponseGetDefaultInstanceForType() {
    // Arrange
    AccountBalanceResponse defaultInstance = AccountBalanceResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountBalanceResponse.getDescriptor()"})
  public void testAccountBalanceResponseGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountBalanceResponse.getDescriptor();

    // Assert
    assertEquals("AccountBalanceResponse", actualDescriptor.getName());
    assertEquals("protocol.AccountBalanceResponse", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.START_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountBalanceResponse.getSerializedSize()"})
  public void testAccountBalanceResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountBalanceResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#hasBlockIdentifier()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#hasBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.hasBlockIdentifier()"})
  public void testAccountBalanceResponseHasBlockIdentifier() {
    // Arrange, Act and Assert
    assertFalse(AccountBalanceResponse.getDefaultInstance().hasBlockIdentifier());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#isInitialized()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountBalanceResponse.isInitialized()"})
  public void testAccountBalanceResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountBalanceResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceResponse actualParseDelimitedFromResult = AccountBalanceResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    AccountBalanceResponse defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceResponse actualParseDelimitedFromResult = AccountBalanceResponse.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountBalanceResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceResponse actualParseDelimitedFromResult = AccountBalanceResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    AccountBalanceResponse defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountBalanceResponse actualParseDelimitedFromResult = AccountBalanceResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountBalanceResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountBalanceResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountBalanceResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountBalanceResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseDelimitedFrom(InputStream)"})
  public void testAccountBalanceResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountBalanceResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(byte[])"})
  public void testAccountBalanceResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(ByteBuffer)"})
  public void testAccountBalanceResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(ByteString)"})
  public void testAccountBalanceResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(CodedInputStream)"})
  public void testAccountBalanceResponseParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountBalanceResponse AccountBalanceResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream)"})
  public void testAccountBalanceResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream)"})
  public void testAccountBalanceResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountBalanceResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountBalanceResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountBalanceResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountBalanceResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream)"})
  public void testAccountBalanceResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountBalanceResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountBalanceResponse {@link AccountBalanceResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountBalanceResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountBalanceResponse AccountBalanceResponse.parseFrom(InputStream)"})
  public void testAccountBalanceResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountBalanceResponse actualParseFromResult = AccountBalanceResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test AccountBalanceResponse_Builder {@link AccountBalanceResponse.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountBalanceResponse.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountBalanceResponse.Builder.getDescriptor()"})
  public void testAccountBalanceResponse_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountBalanceResponse.Builder.getDescriptor();

    // Assert
    assertEquals("AccountBalanceResponse", actualDescriptor.getName());
    assertEquals("protocol.AccountBalanceResponse", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.START_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#equals(Object)}, and {@link AccountIdentifier#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountIdentifier#equals(Object)}
   *   <li>{@link AccountIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.equals(Object)", "int AccountIdentifier.hashCode()"})
  public void testAccountIdentifierEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountIdentifier defaultInstance = AccountIdentifier.getDefaultInstance();
    AccountIdentifier defaultInstance2 = AccountIdentifier.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#equals(Object)}, and {@link AccountIdentifier#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountIdentifier#equals(Object)}
   *   <li>{@link AccountIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.equals(Object)", "int AccountIdentifier.hashCode()"})
  public void testAccountIdentifierEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountIdentifier defaultInstance = AccountIdentifier.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.equals(Object)", "int AccountIdentifier.hashCode()"})
  public void testAccountIdentifierEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountIdentifier.getDefaultInstance(), 1);
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.equals(Object)", "int AccountIdentifier.hashCode()"})
  public void testAccountIdentifierEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountIdentifier.getDefaultInstance(), null);
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.equals(Object)", "int AccountIdentifier.hashCode()"})
  public void testAccountIdentifierEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountIdentifier.getDefaultInstance(), "Different type to AccountIdentifier");
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountIdentifier#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.getDefaultInstanceForType()"})
  public void testAccountIdentifierGetDefaultInstanceForType() {
    // Arrange
    AccountIdentifier defaultInstance = AccountIdentifier.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountIdentifier#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountIdentifier.getDescriptor()"})
  public void testAccountIdentifierGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountIdentifier.getDescriptor();

    // Assert
    assertEquals("AccountIdentifier", actualDescriptor.getName());
    assertEquals("protocol.AccountIdentifier", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountIdentifier#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountIdentifier.getSerializedSize()"})
  public void testAccountIdentifierGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountIdentifier.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#isInitialized()}.
   * <p>
   * Method under test: {@link AccountIdentifier#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountIdentifier.isInitialized()"})
  public void testAccountIdentifierIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountIdentifier.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream)"})
  public void testAccountIdentifierParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountIdentifier actualParseDelimitedFromResult = AccountIdentifier.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream)"})
  public void testAccountIdentifierParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountIdentifier.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountIdentifier actualParseDelimitedFromResult = AccountIdentifier.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream)"})
  public void testAccountIdentifierParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountIdentifier.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseDelimitedFrom(InputStream)"})
  public void testAccountIdentifierParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountIdentifier.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(byte[])"})
  public void testAccountIdentifierParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(ByteBuffer)"})
  public void testAccountIdentifierParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(ByteString)"})
  public void testAccountIdentifierParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedAddress = data.EMPTY;
    assertSame(expectedAddress, actualParseFromResult.getAddress());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedAddress = data.EMPTY;
    assertSame(expectedAddress, actualParseFromResult.getAddress());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(CodedInputStream)"})
  public void testAccountIdentifierParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream)"})
  public void testAccountIdentifierParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream)"})
  public void testAccountIdentifierParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountIdentifier.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountIdentifierParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream)"})
  public void testAccountIdentifierParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountIdentifier.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountIdentifier {@link AccountIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdentifier AccountIdentifier.parseFrom(InputStream)"})
  public void testAccountIdentifierParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountIdentifier actualParseFromResult = AccountIdentifier.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountIdentifier_Builder {@link AccountIdentifier.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountIdentifier.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountIdentifier.Builder.getDescriptor()"})
  public void testAccountIdentifier_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountIdentifier.Builder.getDescriptor();

    // Assert
    assertEquals("AccountIdentifier", actualDescriptor.getName());
    assertEquals("protocol.AccountIdentifier", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountTrace {@link AccountTrace#equals(Object)}, and {@link AccountTrace#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountTrace#equals(Object)}
   *   <li>{@link AccountTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.equals(Object)", "int AccountTrace.hashCode()"})
  public void testAccountTraceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountTrace defaultInstance = AccountTrace.getDefaultInstance();
    AccountTrace defaultInstance2 = AccountTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountTrace {@link AccountTrace#equals(Object)}, and {@link AccountTrace#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountTrace#equals(Object)}
   *   <li>{@link AccountTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.equals(Object)", "int AccountTrace.hashCode()"})
  public void testAccountTraceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountTrace defaultInstance = AccountTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountTrace {@link AccountTrace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.equals(Object)", "int AccountTrace.hashCode()"})
  public void testAccountTraceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountTrace.getDefaultInstance(), 1);
  }

  /**
   * Test AccountTrace {@link AccountTrace#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.equals(Object)", "int AccountTrace.hashCode()"})
  public void testAccountTraceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountTrace.getDefaultInstance(), null);
  }

  /**
   * Test AccountTrace {@link AccountTrace#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.equals(Object)", "int AccountTrace.hashCode()"})
  public void testAccountTraceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountTrace.getDefaultInstance(), "Different type to AccountTrace");
  }

  /**
   * Test AccountTrace {@link AccountTrace#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountTrace#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.getDefaultInstanceForType()"})
  public void testAccountTraceGetDefaultInstanceForType() {
    // Arrange
    AccountTrace defaultInstance = AccountTrace.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountTrace#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountTrace.getDescriptor()"})
  public void testAccountTraceGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountTrace.getDescriptor();

    // Assert
    assertEquals("AccountTrace", actualDescriptor.getName());
    assertEquals("protocol.AccountTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(6, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountTrace {@link AccountTrace#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountTrace#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountTrace.getSerializedSize()"})
  public void testAccountTraceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountTrace.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountTrace {@link AccountTrace#isInitialized()}.
   * <p>
   * Method under test: {@link AccountTrace#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountTrace.isInitialized()"})
  public void testAccountTraceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountTrace.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream)"})
  public void testAccountTraceParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountTrace actualParseDelimitedFromResult = AccountTrace.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getPlaceholder());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream)"})
  public void testAccountTraceParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountTrace actualParseDelimitedFromResult = AccountTrace.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getPlaceholder());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream)"})
  public void testAccountTraceParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountTrace.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseDelimitedFrom(InputStream)"})
  public void testAccountTraceParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(byte[])"})
  public void testAccountTraceParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(ByteBuffer)"})
  public void testAccountTraceParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(ByteString)"})
  public void testAccountTraceParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(CodedInputStream)"})
  public void testAccountTraceParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream)"})
  public void testAccountTraceParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getPlaceholder());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountTraceParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream)"})
  public void testAccountTraceParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream)"})
  public void testAccountTraceParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountTrace {@link AccountTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountTrace AccountTrace.parseFrom(InputStream)"})
  public void testAccountTraceParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountTrace actualParseFromResult = AccountTrace.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountTrace_Builder {@link AccountTrace.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountTrace.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountTrace.Builder.getDescriptor()"})
  public void testAccountTrace_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountTrace.Builder.getDescriptor();

    // Assert
    assertEquals("AccountTrace", actualDescriptor.getName());
    assertEquals("protocol.AccountTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(6, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#equals(Object)}, and {@link BlockBalanceTrace#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockBalanceTrace#equals(Object)}
   *   <li>{@link BlockBalanceTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.equals(Object)", "int BlockBalanceTrace.hashCode()"})
  public void testBlockBalanceTraceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockBalanceTrace defaultInstance = BlockBalanceTrace.getDefaultInstance();
    BlockBalanceTrace defaultInstance2 = BlockBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#equals(Object)}, and {@link BlockBalanceTrace#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockBalanceTrace#equals(Object)}
   *   <li>{@link BlockBalanceTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.equals(Object)", "int BlockBalanceTrace.hashCode()"})
  public void testBlockBalanceTraceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockBalanceTrace defaultInstance = BlockBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.equals(Object)", "int BlockBalanceTrace.hashCode()"})
  public void testBlockBalanceTraceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlockBalanceTrace.getDefaultInstance(), 1);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.equals(Object)", "int BlockBalanceTrace.hashCode()"})
  public void testBlockBalanceTraceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlockBalanceTrace.getDefaultInstance(), null);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.equals(Object)", "int BlockBalanceTrace.hashCode()"})
  public void testBlockBalanceTraceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlockBalanceTrace.getDefaultInstance(), "Different type to BlockBalanceTrace");
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#getBlockIdentifier()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#getBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.getBlockIdentifier()"})
  public void testBlockBalanceTraceGetBlockIdentifier() {
    // Arrange and Act
    BlockIdentifier actualBlockIdentifier = BlockBalanceTrace.getDefaultInstance().getBlockIdentifier();

    // Assert
    assertEquals("", actualBlockIdentifier.getInitializationErrorString());
    assertEquals(0, actualBlockIdentifier.getSerializedSize());
    assertEquals(0L, actualBlockIdentifier.getNumber());
    assertTrue(actualBlockIdentifier.findInitializationErrors().isEmpty());
    assertTrue(actualBlockIdentifier.getAllFields().isEmpty());
    assertTrue(actualBlockIdentifier.isInitialized());
    assertSame(actualBlockIdentifier, actualBlockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.getDefaultInstanceForType()"})
  public void testBlockBalanceTraceGetDefaultInstanceForType() {
    // Arrange
    BlockBalanceTrace defaultInstance = BlockBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#getDescriptor()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor BlockBalanceTrace.getDescriptor()"})
  public void testBlockBalanceTraceGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = BlockBalanceTrace.getDescriptor();

    // Assert
    assertEquals("BlockBalanceTrace", actualDescriptor.getName());
    assertEquals("protocol.BlockBalanceTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(5, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#getSerializedSize()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BlockBalanceTrace.getSerializedSize()"})
  public void testBlockBalanceTraceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, BlockBalanceTrace.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#getTransactionBalanceTraceCount()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#getTransactionBalanceTraceCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BlockBalanceTrace.getTransactionBalanceTraceCount()"})
  public void testBlockBalanceTraceGetTransactionBalanceTraceCount() {
    // Arrange, Act and Assert
    assertEquals(0, BlockBalanceTrace.getDefaultInstance().getTransactionBalanceTraceCount());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#hasBlockIdentifier()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#hasBlockIdentifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.hasBlockIdentifier()"})
  public void testBlockBalanceTraceHasBlockIdentifier() {
    // Arrange, Act and Assert
    assertFalse(BlockBalanceTrace.getDefaultInstance().hasBlockIdentifier());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#isInitialized()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.isInitialized()"})
  public void testBlockBalanceTraceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(BlockBalanceTrace.getDefaultInstance().isInitialized());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockBalanceTrace actualParseDelimitedFromResult = BlockBalanceTrace.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    BlockBalanceTrace defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockBalanceTrace actualParseDelimitedFromResult = BlockBalanceTrace.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> BlockBalanceTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockBalanceTrace actualParseDelimitedFromResult = BlockBalanceTrace.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    BlockBalanceTrace defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifier());
    assertSame(blockIdentifier, defaultInstanceForType.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockBalanceTrace actualParseDelimitedFromResult = BlockBalanceTrace.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    BlockIdentifier blockIdentifier = actualParseDelimitedFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseDelimitedFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> BlockBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> BlockBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(BlockBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(BlockBalanceTrace.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTraceParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> BlockBalanceTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(byte[])"})
  public void testBlockBalanceTraceParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTransactionBalanceTraceCount());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualParseFromResult.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualParseFromResult.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(ByteBuffer)"})
  public void testBlockBalanceTraceParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTransactionBalanceTraceCount());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualParseFromResult.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualParseFromResult.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTransactionBalanceTraceCount());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualParseFromResult.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualParseFromResult.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTransactionBalanceTraceCount());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualParseFromResult.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualParseFromResult.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream)"})
  public void testBlockBalanceTraceParseFromWithInputStream() throws IOException {
    // Arrange and Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream)"})
  public void testBlockBalanceTraceParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> BlockBalanceTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTransactionBalanceTraceCount());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBlockIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TransactionBalanceTrace> transactionBalanceTraceList = actualParseFromResult.getTransactionBalanceTraceList();
    assertTrue(transactionBalanceTraceList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(transactionBalanceTraceList, actualParseFromResult.getTransactionBalanceTraceOrBuilderList());
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> BlockBalanceTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTraceParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> BlockBalanceTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream)"})
  public void testBlockBalanceTraceParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> BlockBalanceTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace {@link BlockBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace BlockBalanceTrace.parseFrom(InputStream)"})
  public void testBlockBalanceTraceParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    BlockBalanceTrace actualParseFromResult = BlockBalanceTrace.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    BlockIdentifier blockIdentifier = actualParseFromResult.getBlockIdentifier();
    assertSame(unknownFields, blockIdentifier.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(blockIdentifier, actualParseFromResult.getBlockIdentifierOrBuilder());
    assertSame(blockIdentifier, blockIdentifier.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}, and {@link BlockBalanceTrace.BlockIdentifier#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockBalanceTrace.BlockIdentifier#equals(Object)}
   *   <li>{@link BlockBalanceTrace.BlockIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.equals(Object)",
      "int BlockBalanceTrace.BlockIdentifier.hashCode()"})
  public void testBlockBalanceTrace_BlockIdentifierEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    BlockIdentifier defaultInstance = BlockIdentifier.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}, and {@link BlockBalanceTrace.BlockIdentifier#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockBalanceTrace.BlockIdentifier#equals(Object)}
   *   <li>{@link BlockBalanceTrace.BlockIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.equals(Object)",
      "int BlockBalanceTrace.BlockIdentifier.hashCode()"})
  public void testBlockBalanceTrace_BlockIdentifierEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    BlockIdentifier defaultInstance = BlockIdentifier.getDefaultInstance();
    BlockIdentifier defaultInstance2 = BlockIdentifier.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.equals(Object)",
      "int BlockBalanceTrace.BlockIdentifier.hashCode()"})
  public void testBlockBalanceTrace_BlockIdentifierEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlockIdentifier.getDefaultInstance(), "Different type to BlockIdentifier");
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.equals(Object)",
      "int BlockBalanceTrace.BlockIdentifier.hashCode()"})
  public void testBlockBalanceTrace_BlockIdentifierEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(BlockIdentifier.getDefaultInstance(), 1);
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.equals(Object)",
      "int BlockBalanceTrace.BlockIdentifier.hashCode()"})
  public void testBlockBalanceTrace_BlockIdentifierEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BlockIdentifier.getDefaultInstance(), null);
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.getDefaultInstanceForType()"})
  public void testBlockBalanceTrace_BlockIdentifierGetDefaultInstanceForType() {
    // Arrange
    BlockIdentifier defaultInstance = BlockIdentifier.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#getDescriptor()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor BlockBalanceTrace.BlockIdentifier.getDescriptor()"})
  public void testBlockBalanceTrace_BlockIdentifierGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = BlockIdentifier.getDescriptor();

    // Assert
    assertEquals("BlockIdentifier", actualDescriptor.getName());
    assertEquals("protocol.BlockBalanceTrace.BlockIdentifier", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#getSerializedSize()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BlockBalanceTrace.BlockIdentifier.getSerializedSize()"})
  public void testBlockBalanceTrace_BlockIdentifierGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, BlockIdentifier.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#isInitialized()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BlockBalanceTrace.BlockIdentifier.isInitialized()"})
  public void testBlockBalanceTrace_BlockIdentifierIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(BlockIdentifier.getDefaultInstance().isInitialized());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockIdentifier actualParseDelimitedFromResult = BlockIdentifier.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getNumber());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> BlockIdentifier.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> BlockIdentifier.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    BlockIdentifier actualParseDelimitedFromResult = BlockIdentifier.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getNumber());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(BlockIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> BlockIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> BlockIdentifier.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseDelimitedFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(BlockIdentifier.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(byte[])"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(ByteBuffer)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(ByteString)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedHash = data.EMPTY;
    assertSame(expectedHash, actualParseFromResult.getHash());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedHash = data.EMPTY;
    assertSame(expectedHash, actualParseFromResult.getHash());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(CodedInputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStream() throws IOException {
    // Arrange and Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> BlockIdentifier.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> BlockIdentifier.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNumber());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> BlockIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> BlockIdentifier.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockBalanceTrace.BlockIdentifier BlockBalanceTrace.BlockIdentifier.parseFrom(InputStream)"})
  public void testBlockBalanceTrace_BlockIdentifierParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    BlockIdentifier actualParseFromResult = BlockIdentifier.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test BlockBalanceTrace_BlockIdentifier_Builder {@link BlockBalanceTrace.BlockIdentifier.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.BlockIdentifier.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor BlockBalanceTrace.BlockIdentifier.Builder.getDescriptor()"})
  public void testBlockBalanceTrace_BlockIdentifier_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = BlockIdentifier.Builder.getDescriptor();

    // Assert
    assertEquals("BlockIdentifier", actualDescriptor.getName());
    assertEquals("protocol.BlockBalanceTrace.BlockIdentifier", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test BlockBalanceTrace_Builder {@link BlockBalanceTrace.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link BlockBalanceTrace.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor BlockBalanceTrace.Builder.getDescriptor()"})
  public void testBlockBalanceTrace_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = BlockBalanceTrace.Builder.getDescriptor();

    // Assert
    assertEquals("BlockBalanceTrace", actualDescriptor.getName());
    assertEquals("protocol.BlockBalanceTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(5, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#equals(Object)}, and {@link CancelAllUnfreezeV2Contract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CancelAllUnfreezeV2Contract#equals(Object)}
   *   <li>{@link CancelAllUnfreezeV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.equals(Object)",
      "int CancelAllUnfreezeV2Contract.hashCode()"})
  public void testCancelAllUnfreezeV2ContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    CancelAllUnfreezeV2Contract defaultInstance = CancelAllUnfreezeV2Contract.getDefaultInstance();
    CancelAllUnfreezeV2Contract defaultInstance2 = CancelAllUnfreezeV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#equals(Object)}, and {@link CancelAllUnfreezeV2Contract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CancelAllUnfreezeV2Contract#equals(Object)}
   *   <li>{@link CancelAllUnfreezeV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.equals(Object)",
      "int CancelAllUnfreezeV2Contract.hashCode()"})
  public void testCancelAllUnfreezeV2ContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CancelAllUnfreezeV2Contract defaultInstance = CancelAllUnfreezeV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.equals(Object)",
      "int CancelAllUnfreezeV2Contract.hashCode()"})
  public void testCancelAllUnfreezeV2ContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CancelAllUnfreezeV2Contract.getDefaultInstance(), 1);
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.equals(Object)",
      "int CancelAllUnfreezeV2Contract.hashCode()"})
  public void testCancelAllUnfreezeV2ContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CancelAllUnfreezeV2Contract.getDefaultInstance(), null);
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.equals(Object)",
      "int CancelAllUnfreezeV2Contract.hashCode()"})
  public void testCancelAllUnfreezeV2ContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CancelAllUnfreezeV2Contract.getDefaultInstance(), "Different type to CancelAllUnfreezeV2Contract");
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.getDefaultInstanceForType()"})
  public void testCancelAllUnfreezeV2ContractGetDefaultInstanceForType() {
    // Arrange
    CancelAllUnfreezeV2Contract defaultInstance = CancelAllUnfreezeV2Contract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#getDescriptor()}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor CancelAllUnfreezeV2Contract.getDescriptor()"})
  public void testCancelAllUnfreezeV2ContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = CancelAllUnfreezeV2Contract.getDescriptor();

    // Assert
    assertEquals("CancelAllUnfreezeV2Contract", actualDescriptor.getName());
    assertEquals("protocol.CancelAllUnfreezeV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(FreezeBalanceContract.RECEIVER_ADDRESS_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#getSerializedSize()}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CancelAllUnfreezeV2Contract.getSerializedSize()"})
  public void testCancelAllUnfreezeV2ContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, CancelAllUnfreezeV2Contract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#isInitialized()}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CancelAllUnfreezeV2Contract.isInitialized()"})
  public void testCancelAllUnfreezeV2ContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(CancelAllUnfreezeV2Contract.getDefaultInstance().isInitialized());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    CancelAllUnfreezeV2Contract actualParseDelimitedFromResult = CancelAllUnfreezeV2Contract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> CancelAllUnfreezeV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    CancelAllUnfreezeV2Contract actualParseDelimitedFromResult = CancelAllUnfreezeV2Contract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(CancelAllUnfreezeV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> CancelAllUnfreezeV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> CancelAllUnfreezeV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(CancelAllUnfreezeV2Contract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseDelimitedFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> CancelAllUnfreezeV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(byte[])"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(ByteBuffer)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(ByteString)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(CodedInputStream)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> CancelAllUnfreezeV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> CancelAllUnfreezeV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> CancelAllUnfreezeV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> CancelAllUnfreezeV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CancelAllUnfreezeV2Contract {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CancelAllUnfreezeV2Contract CancelAllUnfreezeV2Contract.parseFrom(InputStream)"})
  public void testCancelAllUnfreezeV2ContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    CancelAllUnfreezeV2Contract actualParseFromResult = CancelAllUnfreezeV2Contract.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test CancelAllUnfreezeV2Contract_Builder {@link CancelAllUnfreezeV2Contract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Contract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor CancelAllUnfreezeV2Contract.Builder.getDescriptor()"})
  public void testCancelAllUnfreezeV2Contract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = CancelAllUnfreezeV2Contract.Builder.getDescriptor();

    // Assert
    assertEquals("CancelAllUnfreezeV2Contract", actualDescriptor.getName());
    assertEquals("protocol.CancelAllUnfreezeV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(FreezeBalanceContract.RECEIVER_ADDRESS_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#equals(Object)}, and {@link DelegateResourceContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DelegateResourceContract#equals(Object)}
   *   <li>{@link DelegateResourceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.equals(Object)", "int DelegateResourceContract.hashCode()"})
  public void testDelegateResourceContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DelegateResourceContract defaultInstance = DelegateResourceContract.getDefaultInstance();
    DelegateResourceContract defaultInstance2 = DelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#equals(Object)}, and {@link DelegateResourceContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DelegateResourceContract#equals(Object)}
   *   <li>{@link DelegateResourceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.equals(Object)", "int DelegateResourceContract.hashCode()"})
  public void testDelegateResourceContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DelegateResourceContract defaultInstance = DelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.equals(Object)", "int DelegateResourceContract.hashCode()"})
  public void testDelegateResourceContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DelegateResourceContract.getDefaultInstance(), 1);
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.equals(Object)", "int DelegateResourceContract.hashCode()"})
  public void testDelegateResourceContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DelegateResourceContract.getDefaultInstance(), null);
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.equals(Object)", "int DelegateResourceContract.hashCode()"})
  public void testDelegateResourceContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DelegateResourceContract.getDefaultInstance(), "Different type to DelegateResourceContract");
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DelegateResourceContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.getDefaultInstanceForType()"})
  public void testDelegateResourceContractGetDefaultInstanceForType() {
    // Arrange
    DelegateResourceContract defaultInstance = DelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#getDescriptor()}.
   * <p>
   * Method under test: {@link DelegateResourceContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor DelegateResourceContract.getDescriptor()"})
  public void testDelegateResourceContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = DelegateResourceContract.getDescriptor();

    // Assert
    assertEquals("DelegateResourceContract", actualDescriptor.getName());
    assertEquals("protocol.DelegateResourceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(13, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#getResource()}.
   * <p>
   * Method under test: {@link DelegateResourceContract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode DelegateResourceContract.getResource()"})
  public void testDelegateResourceContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, DelegateResourceContract.getDefaultInstance().getResource());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link DelegateResourceContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DelegateResourceContract.getSerializedSize()"})
  public void testDelegateResourceContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DelegateResourceContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#isInitialized()}.
   * <p>
   * Method under test: {@link DelegateResourceContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DelegateResourceContract.isInitialized()"})
  public void testDelegateResourceContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DelegateResourceContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testDelegateResourceContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DelegateResourceContract actualParseDelimitedFromResult = DelegateResourceContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getLockPeriod());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertFalse(actualParseDelimitedFromResult.getLock());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testDelegateResourceContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DelegateResourceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DelegateResourceContract actualParseDelimitedFromResult = DelegateResourceContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getLockPeriod());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertFalse(actualParseDelimitedFromResult.getLock());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testDelegateResourceContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DelegateResourceContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testDelegateResourceContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DelegateResourceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(byte[])"})
  public void testDelegateResourceContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(ByteBuffer)"})
  public void testDelegateResourceContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(ByteString)"})
  public void testDelegateResourceContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(CodedInputStream)"})
  public void testDelegateResourceContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DelegateResourceContract DelegateResourceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream)"})
  public void testDelegateResourceContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(6, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream)"})
  public void testDelegateResourceContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DelegateResourceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(0L, actualParseFromResult.getLockPeriod());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertFalse(actualParseFromResult.getLock());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DelegateResourceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DelegateResourceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream)"})
  public void testDelegateResourceContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DelegateResourceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DelegateResourceContract {@link DelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegateResourceContract DelegateResourceContract.parseFrom(InputStream)"})
  public void testDelegateResourceContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DelegateResourceContract actualParseFromResult = DelegateResourceContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(6, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DelegateResourceContract_Builder {@link DelegateResourceContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link DelegateResourceContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor DelegateResourceContract.Builder.getDescriptor()"})
  public void testDelegateResourceContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = DelegateResourceContract.Builder.getDescriptor();

    // Assert
    assertEquals("DelegateResourceContract", actualDescriptor.getName());
    assertEquals("protocol.DelegateResourceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(13, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#equals(Object)}, and {@link FreezeBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreezeBalanceContract#equals(Object)}
   *   <li>{@link FreezeBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.equals(Object)", "int FreezeBalanceContract.hashCode()"})
  public void testFreezeBalanceContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FreezeBalanceContract defaultInstance = FreezeBalanceContract.getDefaultInstance();
    FreezeBalanceContract defaultInstance2 = FreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#equals(Object)}, and {@link FreezeBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreezeBalanceContract#equals(Object)}
   *   <li>{@link FreezeBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.equals(Object)", "int FreezeBalanceContract.hashCode()"})
  public void testFreezeBalanceContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FreezeBalanceContract defaultInstance = FreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.equals(Object)", "int FreezeBalanceContract.hashCode()"})
  public void testFreezeBalanceContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceContract.getDefaultInstance(), 1);
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.equals(Object)", "int FreezeBalanceContract.hashCode()"})
  public void testFreezeBalanceContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceContract.getDefaultInstance(), null);
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.equals(Object)", "int FreezeBalanceContract.hashCode()"})
  public void testFreezeBalanceContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceContract.getDefaultInstance(), "Different type to FreezeBalanceContract");
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.getDefaultInstanceForType()"})
  public void testFreezeBalanceContractGetDefaultInstanceForType() {
    // Arrange
    FreezeBalanceContract defaultInstance = FreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#getDescriptor()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FreezeBalanceContract.getDescriptor()"})
  public void testFreezeBalanceContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FreezeBalanceContract.getDescriptor();

    // Assert
    assertEquals("FreezeBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.FreezeBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#getResource()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode FreezeBalanceContract.getResource()"})
  public void testFreezeBalanceContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, FreezeBalanceContract.getDefaultInstance().getResource());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FreezeBalanceContract.getSerializedSize()"})
  public void testFreezeBalanceContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FreezeBalanceContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#isInitialized()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceContract.isInitialized()"})
  public void testFreezeBalanceContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FreezeBalanceContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FreezeBalanceContract actualParseDelimitedFromResult = FreezeBalanceContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenDuration());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FreezeBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FreezeBalanceContract actualParseDelimitedFromResult = FreezeBalanceContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenDuration());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FreezeBalanceContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FreezeBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(byte[])"})
  public void testFreezeBalanceContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(ByteBuffer)"})
  public void testFreezeBalanceContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(ByteString)"})
  public void testFreezeBalanceContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(CodedInputStream)"})
  public void testFreezeBalanceContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream)"})
  public void testFreezeBalanceContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(5, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream)"})
  public void testFreezeBalanceContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FreezeBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(0L, actualParseFromResult.getFrozenDuration());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> FreezeBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FreezeBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream)"})
  public void testFreezeBalanceContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FreezeBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceContract {@link FreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceContract FreezeBalanceContract.parseFrom(InputStream)"})
  public void testFreezeBalanceContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    FreezeBalanceContract actualParseFromResult = FreezeBalanceContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(5, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceContract_Builder {@link FreezeBalanceContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link FreezeBalanceContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FreezeBalanceContract.Builder.getDescriptor()"})
  public void testFreezeBalanceContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FreezeBalanceContract.Builder.getDescriptor();

    // Assert
    assertEquals("FreezeBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.FreezeBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#equals(Object)}, and {@link FreezeBalanceV2Contract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreezeBalanceV2Contract#equals(Object)}
   *   <li>{@link FreezeBalanceV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.equals(Object)", "int FreezeBalanceV2Contract.hashCode()"})
  public void testFreezeBalanceV2ContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FreezeBalanceV2Contract defaultInstance = FreezeBalanceV2Contract.getDefaultInstance();
    FreezeBalanceV2Contract defaultInstance2 = FreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#equals(Object)}, and {@link FreezeBalanceV2Contract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreezeBalanceV2Contract#equals(Object)}
   *   <li>{@link FreezeBalanceV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.equals(Object)", "int FreezeBalanceV2Contract.hashCode()"})
  public void testFreezeBalanceV2ContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FreezeBalanceV2Contract defaultInstance = FreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.equals(Object)", "int FreezeBalanceV2Contract.hashCode()"})
  public void testFreezeBalanceV2ContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceV2Contract.getDefaultInstance(), 1);
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.equals(Object)", "int FreezeBalanceV2Contract.hashCode()"})
  public void testFreezeBalanceV2ContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceV2Contract.getDefaultInstance(), null);
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.equals(Object)", "int FreezeBalanceV2Contract.hashCode()"})
  public void testFreezeBalanceV2ContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FreezeBalanceV2Contract.getDefaultInstance(), "Different type to FreezeBalanceV2Contract");
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.getDefaultInstanceForType()"})
  public void testFreezeBalanceV2ContractGetDefaultInstanceForType() {
    // Arrange
    FreezeBalanceV2Contract defaultInstance = FreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#getDescriptor()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FreezeBalanceV2Contract.getDescriptor()"})
  public void testFreezeBalanceV2ContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FreezeBalanceV2Contract.getDescriptor();

    // Assert
    assertEquals("FreezeBalanceV2Contract", actualDescriptor.getName());
    assertEquals("protocol.FreezeBalanceV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.END_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#getResource()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode FreezeBalanceV2Contract.getResource()"})
  public void testFreezeBalanceV2ContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, FreezeBalanceV2Contract.getDefaultInstance().getResource());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#getSerializedSize()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FreezeBalanceV2Contract.getSerializedSize()"})
  public void testFreezeBalanceV2ContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FreezeBalanceV2Contract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#isInitialized()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FreezeBalanceV2Contract.isInitialized()"})
  public void testFreezeBalanceV2ContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FreezeBalanceV2Contract.getDefaultInstance().isInitialized());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FreezeBalanceV2Contract actualParseDelimitedFromResult = FreezeBalanceV2Contract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FreezeBalanceV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FreezeBalanceV2Contract actualParseDelimitedFromResult = FreezeBalanceV2Contract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FreezeBalanceV2Contract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FreezeBalanceV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(byte[])"})
  public void testFreezeBalanceV2ContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteBuffer)"})
  public void testFreezeBalanceV2ContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteString)"})
  public void testFreezeBalanceV2ContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteString)"})
  public void testFreezeBalanceV2ContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(CodedInputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(CodedInputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FreezeBalanceV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> FreezeBalanceV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FreezeBalanceV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FreezeBalanceV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test FreezeBalanceV2Contract {@link FreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FreezeBalanceV2Contract FreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testFreezeBalanceV2ContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    FreezeBalanceV2Contract actualParseFromResult = FreezeBalanceV2Contract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test FreezeBalanceV2Contract_Builder {@link FreezeBalanceV2Contract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link FreezeBalanceV2Contract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FreezeBalanceV2Contract.Builder.getDescriptor()"})
  public void testFreezeBalanceV2Contract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FreezeBalanceV2Contract.Builder.getDescriptor();

    // Assert
    assertEquals("FreezeBalanceV2Contract", actualDescriptor.getName());
    assertEquals("protocol.FreezeBalanceV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.END_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#equals(Object)}, and {@link TransactionBalanceTrace#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionBalanceTrace#equals(Object)}
   *   <li>{@link TransactionBalanceTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.equals(Object)", "int TransactionBalanceTrace.hashCode()"})
  public void testTransactionBalanceTraceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransactionBalanceTrace defaultInstance = TransactionBalanceTrace.getDefaultInstance();
    TransactionBalanceTrace defaultInstance2 = TransactionBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#equals(Object)}, and {@link TransactionBalanceTrace#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionBalanceTrace#equals(Object)}
   *   <li>{@link TransactionBalanceTrace#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.equals(Object)", "int TransactionBalanceTrace.hashCode()"})
  public void testTransactionBalanceTraceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransactionBalanceTrace defaultInstance = TransactionBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.equals(Object)", "int TransactionBalanceTrace.hashCode()"})
  public void testTransactionBalanceTraceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransactionBalanceTrace.getDefaultInstance(), 1);
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.equals(Object)", "int TransactionBalanceTrace.hashCode()"})
  public void testTransactionBalanceTraceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransactionBalanceTrace.getDefaultInstance(), null);
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.equals(Object)", "int TransactionBalanceTrace.hashCode()"})
  public void testTransactionBalanceTraceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransactionBalanceTrace.getDefaultInstance(), "Different type to TransactionBalanceTrace");
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.getDefaultInstanceForType()"})
  public void testTransactionBalanceTraceGetDefaultInstanceForType() {
    // Arrange
    TransactionBalanceTrace defaultInstance = TransactionBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getDescriptor()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransactionBalanceTrace.getDescriptor()"})
  public void testTransactionBalanceTraceGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransactionBalanceTrace.getDescriptor();

    // Assert
    assertEquals("TransactionBalanceTrace", actualDescriptor.getName());
    assertEquals("protocol.TransactionBalanceTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getOperationCount()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getOperationCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TransactionBalanceTrace.getOperationCount()"})
  public void testTransactionBalanceTraceGetOperationCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransactionBalanceTrace.getDefaultInstance().getOperationCount());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TransactionBalanceTrace.getSerializedSize()"})
  public void testTransactionBalanceTraceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransactionBalanceTrace.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getStatus()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TransactionBalanceTrace.getStatus()"})
  public void testTransactionBalanceTraceGetStatus() {
    // Arrange, Act and Assert
    assertEquals("", TransactionBalanceTrace.getDefaultInstance().getStatus());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getStatusBytes()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getStatusBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString TransactionBalanceTrace.getStatusBytes()"})
  public void testTransactionBalanceTraceGetStatusBytes() {
    // Arrange
    TransactionBalanceTrace defaultInstance = TransactionBalanceTrace.getDefaultInstance();

    // Act
    ByteString actualStatusBytes = defaultInstance.getStatusBytes();

    // Assert
    ByteString byteString = actualStatusBytes.EMPTY;
    assertEquals(byteString, actualStatusBytes);
    assertSame(byteString, defaultInstance.getTransactionIdentifier());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getType()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TransactionBalanceTrace.getType()"})
  public void testTransactionBalanceTraceGetType() {
    // Arrange, Act and Assert
    assertEquals("", TransactionBalanceTrace.getDefaultInstance().getType());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#getTypeBytes()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#getTypeBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString TransactionBalanceTrace.getTypeBytes()"})
  public void testTransactionBalanceTraceGetTypeBytes() {
    // Arrange
    TransactionBalanceTrace defaultInstance = TransactionBalanceTrace.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, actualTypeBytes);
    assertSame(byteString, defaultInstance.getTransactionIdentifier());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#isInitialized()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionBalanceTrace.isInitialized()"})
  public void testTransactionBalanceTraceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransactionBalanceTrace.getDefaultInstance().isInitialized());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransactionBalanceTrace actualParseDelimitedFromResult = TransactionBalanceTrace.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStatus());
    assertEquals("", actualParseDelimitedFromResult.getType());
    assertEquals(0, actualParseDelimitedFromResult.getOperationCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseDelimitedFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseDelimitedFromResult.getOperationOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransactionBalanceTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransactionBalanceTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransactionBalanceTrace actualParseDelimitedFromResult = TransactionBalanceTrace.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStatus());
    assertEquals("", actualParseDelimitedFromResult.getType());
    assertEquals(0, actualParseDelimitedFromResult.getOperationCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseDelimitedFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseDelimitedFromResult.getOperationOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransactionBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransactionBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransactionBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransactionBalanceTrace.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransactionBalanceTrace.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTraceParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransactionBalanceTrace.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(byte[])"})
  public void testTransactionBalanceTraceParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatus());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getOperationCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseFromResult.getOperationOrBuilderList());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(ByteBuffer)"})
  public void testTransactionBalanceTraceParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatus());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getOperationCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseFromResult.getOperationOrBuilderList());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatus());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getOperationCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseFromResult.getOperationOrBuilderList());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatus());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getOperationCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseFromResult.getOperationOrBuilderList());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream)"})
  public void testTransactionBalanceTraceParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream)"})
  public void testTransactionBalanceTraceParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransactionBalanceTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatus());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getOperationCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Operation> operationList = actualParseFromResult.getOperationList();
    assertTrue(operationList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(operationList, actualParseFromResult.getOperationOrBuilderList());
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransactionBalanceTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTraceParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransactionBalanceTrace.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream)"})
  public void testTransactionBalanceTraceParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransactionBalanceTrace.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace {@link TransactionBalanceTrace#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionBalanceTrace#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionBalanceTrace TransactionBalanceTrace.parseFrom(InputStream)"})
  public void testTransactionBalanceTraceParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransactionBalanceTrace actualParseFromResult = TransactionBalanceTrace.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Builder {@link TransactionBalanceTrace.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link TransactionBalanceTrace.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransactionBalanceTrace.Builder.getDescriptor()"})
  public void testTransactionBalanceTrace_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransactionBalanceTrace.Builder.getDescriptor();

    // Assert
    assertEquals("TransactionBalanceTrace", actualDescriptor.getName());
    assertEquals("protocol.TransactionBalanceTrace", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#equals(Object)}, and {@link Operation#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Operation#equals(Object)}
   *   <li>{@link Operation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.equals(Object)", "int Operation.hashCode()"})
  public void testTransactionBalanceTrace_OperationEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    Operation defaultInstance = Operation.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#equals(Object)}, and {@link Operation#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Operation#equals(Object)}
   *   <li>{@link Operation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.equals(Object)", "int Operation.hashCode()"})
  public void testTransactionBalanceTrace_OperationEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    Operation defaultInstance = Operation.getDefaultInstance();
    Operation defaultInstance2 = Operation.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.equals(Object)", "int Operation.hashCode()"})
  public void testTransactionBalanceTrace_OperationEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Operation.getDefaultInstance(), "Different type to Operation");
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.equals(Object)", "int Operation.hashCode()"})
  public void testTransactionBalanceTrace_OperationEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(Operation.getDefaultInstance(), 1);
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.equals(Object)", "int Operation.hashCode()"})
  public void testTransactionBalanceTrace_OperationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Operation.getDefaultInstance(), null);
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Operation#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.getDefaultInstanceForType()"})
  public void testTransactionBalanceTrace_OperationGetDefaultInstanceForType() {
    // Arrange
    Operation defaultInstance = Operation.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#getDescriptor()}.
   * <p>
   * Method under test: {@link Operation#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Operation.getDescriptor()"})
  public void testTransactionBalanceTrace_OperationGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Operation.getDescriptor();

    // Assert
    assertEquals("Operation", actualDescriptor.getName());
    assertEquals("protocol.TransactionBalanceTrace.Operation", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#getSerializedSize()}.
   * <p>
   * Method under test: {@link Operation#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Operation.getSerializedSize()"})
  public void testTransactionBalanceTrace_OperationGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Operation.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#isInitialized()}.
   * <p>
   * Method under test: {@link Operation#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Operation.isInitialized()"})
  public void testTransactionBalanceTrace_OperationIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Operation.getDefaultInstance().isInitialized());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Operation actualParseDelimitedFromResult = Operation.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getOperationIdentifier());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Operation.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Operation.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Operation actualParseDelimitedFromResult = Operation.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getOperationIdentifier());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Operation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Operation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Operation.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseDelimitedFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Operation.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link Operation#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(byte[])"})
  public void testTransactionBalanceTrace_OperationParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Operation actualParseFromResult = Operation.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Operation#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(ByteBuffer)"})
  public void testTransactionBalanceTrace_OperationParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Operation actualParseFromResult = Operation.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Operation actualParseFromResult = Operation.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Operation actualParseFromResult = Operation.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link Operation#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(ByteString)"})
  public void testTransactionBalanceTrace_OperationParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Operation actualParseFromResult = Operation.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedAddress = data.EMPTY;
    assertSame(expectedAddress, actualParseFromResult.getAddress());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Operation actualParseFromResult = Operation.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedAddress = data.EMPTY;
    assertSame(expectedAddress, actualParseFromResult.getAddress());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Operation#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(CodedInputStream)"})
  public void testTransactionBalanceTrace_OperationParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Operation actualParseFromResult = Operation.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Operation actualParseFromResult = Operation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Operation actualParseFromResult = Operation.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Operation.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Operation.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Operation actualParseFromResult = Operation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertEquals(0L, actualParseFromResult.getOperationIdentifier());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Operation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Operation.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransactionBalanceTrace_Operation {@link Operation#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation Operation.parseFrom(InputStream)"})
  public void testTransactionBalanceTrace_OperationParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Operation actualParseFromResult = Operation.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransactionBalanceTrace_Operation_Builder {@link Operation.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Operation.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Operation.Builder.getDescriptor()"})
  public void testTransactionBalanceTrace_Operation_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Operation.Builder.getDescriptor();

    // Assert
    assertEquals("Operation", actualDescriptor.getName());
    assertEquals("protocol.TransactionBalanceTrace.Operation", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransferContract {@link TransferContract#equals(Object)}, and {@link TransferContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransferContract#equals(Object)}
   *   <li>{@link TransferContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.equals(Object)", "int TransferContract.hashCode()"})
  public void testTransferContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransferContract defaultInstance = TransferContract.getDefaultInstance();
    TransferContract defaultInstance2 = TransferContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TransferContract {@link TransferContract#equals(Object)}, and {@link TransferContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransferContract#equals(Object)}
   *   <li>{@link TransferContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.equals(Object)", "int TransferContract.hashCode()"})
  public void testTransferContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransferContract defaultInstance = TransferContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TransferContract {@link TransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.equals(Object)", "int TransferContract.hashCode()"})
  public void testTransferContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferContract.getDefaultInstance(), 1);
  }

  /**
   * Test TransferContract {@link TransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.equals(Object)", "int TransferContract.hashCode()"})
  public void testTransferContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferContract.getDefaultInstance(), null);
  }

  /**
   * Test TransferContract {@link TransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.equals(Object)", "int TransferContract.hashCode()"})
  public void testTransferContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferContract.getDefaultInstance(), "Different type to TransferContract");
  }

  /**
   * Test TransferContract {@link TransferContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TransferContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.getDefaultInstanceForType()"})
  public void testTransferContractGetDefaultInstanceForType() {
    // Arrange
    TransferContract defaultInstance = TransferContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#getDescriptor()}.
   * <p>
   * Method under test: {@link TransferContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransferContract.getDescriptor()"})
  public void testTransferContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransferContract.getDescriptor();

    // Assert
    assertEquals("TransferContract", actualDescriptor.getName());
    assertEquals("protocol.TransferContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransferContract {@link TransferContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransferContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TransferContract.getSerializedSize()"})
  public void testTransferContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransferContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TransferContract {@link TransferContract#isInitialized()}.
   * <p>
   * Method under test: {@link TransferContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferContract.isInitialized()"})
  public void testTransferContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransferContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream)"})
  public void testTransferContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransferContract actualParseDelimitedFromResult = TransferContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream)"})
  public void testTransferContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransferContract actualParseDelimitedFromResult = TransferContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream)"})
  public void testTransferContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransferContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransferContract {@link TransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseDelimitedFrom(InputStream)"})
  public void testTransferContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(byte[])"})
  public void testTransferContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteBuffer)"})
  public void testTransferContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteString)"})
  public void testTransferContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteString)"})
  public void testTransferContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(CodedInputStream)"})
  public void testTransferContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(CodedInputStream)"})
  public void testTransferContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream)"})
  public void testTransferContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream)"})
  public void testTransferContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TransferContract actualParseFromResult = TransferContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream)"})
  public void testTransferContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferContract {@link TransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferContract TransferContract.parseFrom(InputStream)"})
  public void testTransferContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransferContract actualParseFromResult = TransferContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransferContract_Builder {@link TransferContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link TransferContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransferContract.Builder.getDescriptor()"})
  public void testTransferContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransferContract.Builder.getDescriptor();

    // Assert
    assertEquals("TransferContract", actualDescriptor.getName());
    assertEquals("protocol.TransferContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#equals(Object)}, and {@link UnDelegateResourceContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnDelegateResourceContract#equals(Object)}
   *   <li>{@link UnDelegateResourceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.equals(Object)", "int UnDelegateResourceContract.hashCode()"})
  public void testUnDelegateResourceContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnDelegateResourceContract defaultInstance = UnDelegateResourceContract.getDefaultInstance();
    UnDelegateResourceContract defaultInstance2 = UnDelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#equals(Object)}, and {@link UnDelegateResourceContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnDelegateResourceContract#equals(Object)}
   *   <li>{@link UnDelegateResourceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.equals(Object)", "int UnDelegateResourceContract.hashCode()"})
  public void testUnDelegateResourceContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnDelegateResourceContract defaultInstance = UnDelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.equals(Object)", "int UnDelegateResourceContract.hashCode()"})
  public void testUnDelegateResourceContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnDelegateResourceContract.getDefaultInstance(), 1);
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.equals(Object)", "int UnDelegateResourceContract.hashCode()"})
  public void testUnDelegateResourceContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnDelegateResourceContract.getDefaultInstance(), null);
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.equals(Object)", "int UnDelegateResourceContract.hashCode()"})
  public void testUnDelegateResourceContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnDelegateResourceContract.getDefaultInstance(), "Different type to UnDelegateResourceContract");
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.getDefaultInstanceForType()"})
  public void testUnDelegateResourceContractGetDefaultInstanceForType() {
    // Arrange
    UnDelegateResourceContract defaultInstance = UnDelegateResourceContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnDelegateResourceContract.getDescriptor()"})
  public void testUnDelegateResourceContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnDelegateResourceContract.getDescriptor();

    // Assert
    assertEquals("UnDelegateResourceContract", actualDescriptor.getName());
    assertEquals("protocol.UnDelegateResourceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(14, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#getResource()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode UnDelegateResourceContract.getResource()"})
  public void testUnDelegateResourceContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, UnDelegateResourceContract.getDefaultInstance().getResource());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnDelegateResourceContract.getSerializedSize()"})
  public void testUnDelegateResourceContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UnDelegateResourceContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#isInitialized()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnDelegateResourceContract.isInitialized()"})
  public void testUnDelegateResourceContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UnDelegateResourceContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnDelegateResourceContract actualParseDelimitedFromResult = UnDelegateResourceContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnDelegateResourceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnDelegateResourceContract actualParseDelimitedFromResult = UnDelegateResourceContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnDelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnDelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnDelegateResourceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnDelegateResourceContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseDelimitedFrom(InputStream)"})
  public void testUnDelegateResourceContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UnDelegateResourceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(byte[])"})
  public void testUnDelegateResourceContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteBuffer)"})
  public void testUnDelegateResourceContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteString)"})
  public void testUnDelegateResourceContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteString)"})
  public void testUnDelegateResourceContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(CodedInputStream)"})
  public void testUnDelegateResourceContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(CodedInputStream)"})
  public void testUnDelegateResourceContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream)"})
  public void testUnDelegateResourceContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream)"})
  public void testUnDelegateResourceContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnDelegateResourceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnDelegateResourceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnDelegateResourceContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnDelegateResourceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream)"})
  public void testUnDelegateResourceContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UnDelegateResourceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnDelegateResourceContract {@link UnDelegateResourceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnDelegateResourceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnDelegateResourceContract UnDelegateResourceContract.parseFrom(InputStream)"})
  public void testUnDelegateResourceContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UnDelegateResourceContract actualParseFromResult = UnDelegateResourceContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnDelegateResourceContract_Builder {@link UnDelegateResourceContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UnDelegateResourceContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnDelegateResourceContract.Builder.getDescriptor()"})
  public void testUnDelegateResourceContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnDelegateResourceContract.Builder.getDescriptor();

    // Assert
    assertEquals("UnDelegateResourceContract", actualDescriptor.getName());
    assertEquals("protocol.UnDelegateResourceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(14, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#equals(Object)}, and {@link UnfreezeBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeBalanceContract#equals(Object)}
   *   <li>{@link UnfreezeBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.equals(Object)", "int UnfreezeBalanceContract.hashCode()"})
  public void testUnfreezeBalanceContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnfreezeBalanceContract defaultInstance = UnfreezeBalanceContract.getDefaultInstance();
    UnfreezeBalanceContract defaultInstance2 = UnfreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#equals(Object)}, and {@link UnfreezeBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeBalanceContract#equals(Object)}
   *   <li>{@link UnfreezeBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.equals(Object)", "int UnfreezeBalanceContract.hashCode()"})
  public void testUnfreezeBalanceContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnfreezeBalanceContract defaultInstance = UnfreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.equals(Object)", "int UnfreezeBalanceContract.hashCode()"})
  public void testUnfreezeBalanceContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceContract.getDefaultInstance(), 1);
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.equals(Object)", "int UnfreezeBalanceContract.hashCode()"})
  public void testUnfreezeBalanceContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceContract.getDefaultInstance(), null);
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.equals(Object)", "int UnfreezeBalanceContract.hashCode()"})
  public void testUnfreezeBalanceContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceContract.getDefaultInstance(), "Different type to UnfreezeBalanceContract");
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.getDefaultInstanceForType()"})
  public void testUnfreezeBalanceContractGetDefaultInstanceForType() {
    // Arrange
    UnfreezeBalanceContract defaultInstance = UnfreezeBalanceContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeBalanceContract.getDescriptor()"})
  public void testUnfreezeBalanceContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeBalanceContract.getDescriptor();

    // Assert
    assertEquals("UnfreezeBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#getResource()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode UnfreezeBalanceContract.getResource()"})
  public void testUnfreezeBalanceContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, UnfreezeBalanceContract.getDefaultInstance().getResource());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnfreezeBalanceContract.getSerializedSize()"})
  public void testUnfreezeBalanceContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UnfreezeBalanceContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#isInitialized()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceContract.isInitialized()"})
  public void testUnfreezeBalanceContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UnfreezeBalanceContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeBalanceContract actualParseDelimitedFromResult = UnfreezeBalanceContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeBalanceContract actualParseDelimitedFromResult = UnfreezeBalanceContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeBalanceContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(byte[])"})
  public void testUnfreezeBalanceContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(ByteBuffer)"})
  public void testUnfreezeBalanceContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(ByteString)"})
  public void testUnfreezeBalanceContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getReceiverAddress());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(CodedInputStream)"})
  public void testUnfreezeBalanceContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceContract {@link UnfreezeBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceContract UnfreezeBalanceContract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UnfreezeBalanceContract actualParseFromResult = UnfreezeBalanceContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceContract_Builder {@link UnfreezeBalanceContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeBalanceContract.Builder.getDescriptor()"})
  public void testUnfreezeBalanceContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeBalanceContract.Builder.getDescriptor();

    // Assert
    assertEquals("UnfreezeBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#equals(Object)}, and {@link UnfreezeBalanceV2Contract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeBalanceV2Contract#equals(Object)}
   *   <li>{@link UnfreezeBalanceV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.equals(Object)", "int UnfreezeBalanceV2Contract.hashCode()"})
  public void testUnfreezeBalanceV2ContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnfreezeBalanceV2Contract defaultInstance = UnfreezeBalanceV2Contract.getDefaultInstance();
    UnfreezeBalanceV2Contract defaultInstance2 = UnfreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#equals(Object)}, and {@link UnfreezeBalanceV2Contract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeBalanceV2Contract#equals(Object)}
   *   <li>{@link UnfreezeBalanceV2Contract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.equals(Object)", "int UnfreezeBalanceV2Contract.hashCode()"})
  public void testUnfreezeBalanceV2ContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnfreezeBalanceV2Contract defaultInstance = UnfreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.equals(Object)", "int UnfreezeBalanceV2Contract.hashCode()"})
  public void testUnfreezeBalanceV2ContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceV2Contract.getDefaultInstance(), 1);
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.equals(Object)", "int UnfreezeBalanceV2Contract.hashCode()"})
  public void testUnfreezeBalanceV2ContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceV2Contract.getDefaultInstance(), null);
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.equals(Object)", "int UnfreezeBalanceV2Contract.hashCode()"})
  public void testUnfreezeBalanceV2ContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeBalanceV2Contract.getDefaultInstance(), "Different type to UnfreezeBalanceV2Contract");
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.getDefaultInstanceForType()"})
  public void testUnfreezeBalanceV2ContractGetDefaultInstanceForType() {
    // Arrange
    UnfreezeBalanceV2Contract defaultInstance = UnfreezeBalanceV2Contract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeBalanceV2Contract.getDescriptor()"})
  public void testUnfreezeBalanceV2ContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeBalanceV2Contract.getDescriptor();

    // Assert
    assertEquals("UnfreezeBalanceV2Contract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeBalanceV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.ORDER_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#getResource()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#getResource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceCode UnfreezeBalanceV2Contract.getResource()"})
  public void testUnfreezeBalanceV2ContractGetResource() {
    // Arrange, Act and Assert
    assertEquals(ResourceCode.BANDWIDTH, UnfreezeBalanceV2Contract.getDefaultInstance().getResource());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnfreezeBalanceV2Contract.getSerializedSize()"})
  public void testUnfreezeBalanceV2ContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UnfreezeBalanceV2Contract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#isInitialized()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeBalanceV2Contract.isInitialized()"})
  public void testUnfreezeBalanceV2ContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UnfreezeBalanceV2Contract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeBalanceV2Contract actualParseDelimitedFromResult = UnfreezeBalanceV2Contract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getUnfreezeBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeBalanceV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeBalanceV2Contract actualParseDelimitedFromResult = UnfreezeBalanceV2Contract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getResourceValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getUnfreezeBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ResourceCode.BANDWIDTH, actualParseDelimitedFromResult.getResource());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeBalanceV2Contract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeBalanceV2Contract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeBalanceV2Contract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(byte[])"})
  public void testUnfreezeBalanceV2ContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteBuffer)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteString)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteString)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(CodedInputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(CodedInputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeBalanceV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getUnfreezeBalance());
    assertEquals(ResourceCode.BANDWIDTH, actualParseFromResult.getResource());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeBalanceV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeBalanceV2Contract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeBalanceV2Contract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeBalanceV2Contract {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeBalanceV2Contract UnfreezeBalanceV2Contract.parseFrom(InputStream)"})
  public void testUnfreezeBalanceV2ContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UnfreezeBalanceV2Contract actualParseFromResult = UnfreezeBalanceV2Contract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeBalanceV2Contract_Builder {@link UnfreezeBalanceV2Contract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeBalanceV2Contract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeBalanceV2Contract.Builder.getDescriptor()"})
  public void testUnfreezeBalanceV2Contract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeBalanceV2Contract.Builder.getDescriptor();

    // Assert
    assertEquals("UnfreezeBalanceV2Contract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeBalanceV2Contract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.ORDER_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#equals(Object)}, and {@link WithdrawBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WithdrawBalanceContract#equals(Object)}
   *   <li>{@link WithdrawBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.equals(Object)", "int WithdrawBalanceContract.hashCode()"})
  public void testWithdrawBalanceContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WithdrawBalanceContract defaultInstance = WithdrawBalanceContract.getDefaultInstance();
    WithdrawBalanceContract defaultInstance2 = WithdrawBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#equals(Object)}, and {@link WithdrawBalanceContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WithdrawBalanceContract#equals(Object)}
   *   <li>{@link WithdrawBalanceContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.equals(Object)", "int WithdrawBalanceContract.hashCode()"})
  public void testWithdrawBalanceContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WithdrawBalanceContract defaultInstance = WithdrawBalanceContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.equals(Object)", "int WithdrawBalanceContract.hashCode()"})
  public void testWithdrawBalanceContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawBalanceContract.getDefaultInstance(), 1);
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.equals(Object)", "int WithdrawBalanceContract.hashCode()"})
  public void testWithdrawBalanceContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawBalanceContract.getDefaultInstance(), null);
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.equals(Object)", "int WithdrawBalanceContract.hashCode()"})
  public void testWithdrawBalanceContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawBalanceContract.getDefaultInstance(), "Different type to WithdrawBalanceContract");
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.getDefaultInstanceForType()"})
  public void testWithdrawBalanceContractGetDefaultInstanceForType() {
    // Arrange
    WithdrawBalanceContract defaultInstance = WithdrawBalanceContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#getDescriptor()}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WithdrawBalanceContract.getDescriptor()"})
  public void testWithdrawBalanceContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WithdrawBalanceContract.getDescriptor();

    // Assert
    assertEquals("WithdrawBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.WithdrawBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WithdrawBalanceContract.getSerializedSize()"})
  public void testWithdrawBalanceContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WithdrawBalanceContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#isInitialized()}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawBalanceContract.isInitialized()"})
  public void testWithdrawBalanceContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WithdrawBalanceContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WithdrawBalanceContract actualParseDelimitedFromResult = WithdrawBalanceContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WithdrawBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WithdrawBalanceContract actualParseDelimitedFromResult = WithdrawBalanceContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WithdrawBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> WithdrawBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WithdrawBalanceContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WithdrawBalanceContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawBalanceContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WithdrawBalanceContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(byte[])"})
  public void testWithdrawBalanceContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(ByteBuffer)"})
  public void testWithdrawBalanceContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(ByteString)"})
  public void testWithdrawBalanceContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(CodedInputStream)"})
  public void testWithdrawBalanceContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawBalanceContract WithdrawBalanceContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream)"})
  public void testWithdrawBalanceContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream)"})
  public void testWithdrawBalanceContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WithdrawBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WithdrawBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawBalanceContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WithdrawBalanceContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream)"})
  public void testWithdrawBalanceContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WithdrawBalanceContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawBalanceContract {@link WithdrawBalanceContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawBalanceContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawBalanceContract WithdrawBalanceContract.parseFrom(InputStream)"})
  public void testWithdrawBalanceContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    WithdrawBalanceContract actualParseFromResult = WithdrawBalanceContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawBalanceContract_Builder {@link WithdrawBalanceContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link WithdrawBalanceContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WithdrawBalanceContract.Builder.getDescriptor()"})
  public void testWithdrawBalanceContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WithdrawBalanceContract.Builder.getDescriptor();

    // Assert
    assertEquals("WithdrawBalanceContract", actualDescriptor.getName());
    assertEquals("protocol.WithdrawBalanceContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#equals(Object)}, and {@link WithdrawExpireUnfreezeContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WithdrawExpireUnfreezeContract#equals(Object)}
   *   <li>{@link WithdrawExpireUnfreezeContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.equals(Object)",
      "int WithdrawExpireUnfreezeContract.hashCode()"})
  public void testWithdrawExpireUnfreezeContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    WithdrawExpireUnfreezeContract defaultInstance = WithdrawExpireUnfreezeContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#equals(Object)}, and {@link WithdrawExpireUnfreezeContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WithdrawExpireUnfreezeContract#equals(Object)}
   *   <li>{@link WithdrawExpireUnfreezeContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.equals(Object)",
      "int WithdrawExpireUnfreezeContract.hashCode()"})
  public void testWithdrawExpireUnfreezeContractEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    WithdrawExpireUnfreezeContract defaultInstance = WithdrawExpireUnfreezeContract.getDefaultInstance();
    WithdrawExpireUnfreezeContract defaultInstance2 = WithdrawExpireUnfreezeContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.equals(Object)",
      "int WithdrawExpireUnfreezeContract.hashCode()"})
  public void testWithdrawExpireUnfreezeContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawExpireUnfreezeContract.getDefaultInstance(), 1);
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.equals(Object)",
      "int WithdrawExpireUnfreezeContract.hashCode()"})
  public void testWithdrawExpireUnfreezeContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawExpireUnfreezeContract.getDefaultInstance(), null);
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.equals(Object)",
      "int WithdrawExpireUnfreezeContract.hashCode()"})
  public void testWithdrawExpireUnfreezeContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WithdrawExpireUnfreezeContract.getDefaultInstance(),
        "Different type to WithdrawExpireUnfreezeContract");
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.getDefaultInstanceForType()"})
  public void testWithdrawExpireUnfreezeContractGetDefaultInstanceForType() {
    // Arrange
    WithdrawExpireUnfreezeContract defaultInstance = WithdrawExpireUnfreezeContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#getDescriptor()}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WithdrawExpireUnfreezeContract.getDescriptor()"})
  public void testWithdrawExpireUnfreezeContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WithdrawExpireUnfreezeContract.getDescriptor();

    // Assert
    assertEquals("WithdrawExpireUnfreezeContract", actualDescriptor.getName());
    assertEquals("protocol.WithdrawExpireUnfreezeContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WithdrawExpireUnfreezeContract.getSerializedSize()"})
  public void testWithdrawExpireUnfreezeContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WithdrawExpireUnfreezeContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#isInitialized()}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WithdrawExpireUnfreezeContract.isInitialized()"})
  public void testWithdrawExpireUnfreezeContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WithdrawExpireUnfreezeContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WithdrawExpireUnfreezeContract actualParseDelimitedFromResult = WithdrawExpireUnfreezeContract
        .parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WithdrawExpireUnfreezeContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WithdrawExpireUnfreezeContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WithdrawExpireUnfreezeContract actualParseDelimitedFromResult = WithdrawExpireUnfreezeContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WithdrawExpireUnfreezeContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> WithdrawExpireUnfreezeContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WithdrawExpireUnfreezeContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseDelimitedFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WithdrawExpireUnfreezeContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(byte[])"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(ByteBuffer)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(ByteString)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(CodedInputStream)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WithdrawExpireUnfreezeContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WithdrawExpireUnfreezeContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WithdrawExpireUnfreezeContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WithdrawExpireUnfreezeContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WithdrawExpireUnfreezeContract {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WithdrawExpireUnfreezeContract WithdrawExpireUnfreezeContract.parseFrom(InputStream)"})
  public void testWithdrawExpireUnfreezeContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    WithdrawExpireUnfreezeContract actualParseFromResult = WithdrawExpireUnfreezeContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WithdrawExpireUnfreezeContract_Builder {@link WithdrawExpireUnfreezeContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link WithdrawExpireUnfreezeContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WithdrawExpireUnfreezeContract.Builder.getDescriptor()"})
  public void testWithdrawExpireUnfreezeContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WithdrawExpireUnfreezeContract.Builder.getDescriptor();

    // Assert
    assertEquals("WithdrawExpireUnfreezeContract", actualDescriptor.getName());
    assertEquals("protocol.WithdrawExpireUnfreezeContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, actualDescriptor.getIndex());
  }
}
