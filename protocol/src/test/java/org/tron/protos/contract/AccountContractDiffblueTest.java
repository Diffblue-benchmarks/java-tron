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
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.AccountType;
import org.tron.protos.Protocol.Key;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Permission.PermissionType;
import org.tron.protos.contract.AccountContract.AccountCreateContract;
import org.tron.protos.contract.AccountContract.AccountCreateContract.Builder;
import org.tron.protos.contract.AccountContract.AccountPermissionUpdateContract;
import org.tron.protos.contract.AccountContract.AccountUpdateContract;
import org.tron.protos.contract.AccountContract.SetAccountIdContract;

public class AccountContractDiffblueTest {
  /**
   * Test AccountCreateContract {@link AccountCreateContract#equals(Object)}, and {@link AccountCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountCreateContract#equals(Object)}
   *   <li>{@link AccountCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.equals(Object)", "int AccountCreateContract.hashCode()"})
  public void testAccountCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountCreateContract defaultInstance = AccountCreateContract.getDefaultInstance();
    AccountCreateContract defaultInstance2 = AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#equals(Object)}, and {@link AccountCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountCreateContract#equals(Object)}
   *   <li>{@link AccountCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.equals(Object)", "int AccountCreateContract.hashCode()"})
  public void testAccountCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountCreateContract defaultInstance = AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.equals(Object)", "int AccountCreateContract.hashCode()"})
  public void testAccountCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.equals(Object)", "int AccountCreateContract.hashCode()"})
  public void testAccountCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountCreateContract.getDefaultInstance(), null);
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.equals(Object)", "int AccountCreateContract.hashCode()"})
  public void testAccountCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountCreateContract.getDefaultInstance(), "Different type to AccountCreateContract");
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountCreateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.getDefaultInstanceForType()"})
  public void testAccountCreateContractGetDefaultInstanceForType() {
    // Arrange
    AccountCreateContract defaultInstance = AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountCreateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountCreateContract.getDescriptor()"})
  public void testAccountCreateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountCreateContract.getDescriptor();

    // Assert
    assertEquals("AccountCreateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountCreateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
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
   * Test AccountCreateContract {@link AccountCreateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountCreateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountCreateContract.getSerializedSize()"})
  public void testAccountCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#getType()}.
   * <p>
   * Method under test: {@link AccountCreateContract#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType AccountCreateContract.getType()"})
  public void testAccountCreateContractGetType() {
    // Arrange, Act and Assert
    assertEquals(AccountType.Normal, AccountCreateContract.getDefaultInstance().getType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#isInitialized()}.
   * <p>
   * Method under test: {@link AccountCreateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountCreateContract.isInitialized()"})
  public void testAccountCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountCreateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountCreateContract actualParseDelimitedFromResult = AccountCreateContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(AccountType.Normal, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountCreateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountCreateContract actualParseDelimitedFromResult = AccountCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(AccountType.Normal, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountCreateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountCreateContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(byte[])"})
  public void testAccountCreateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteBuffer)"})
  public void testAccountCreateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteString)"})
  public void testAccountCreateContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteString)"})
  public void testAccountCreateContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(CodedInputStream)"})
  public void testAccountCreateContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(CodedInputStream)"})
  public void testAccountCreateContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream)"})
  public void testAccountCreateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountCreateContract actualParseFromResult = AccountCreateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream)"})
  public void testAccountCreateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(AccountType.Normal, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountCreateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream)"})
  public void testAccountCreateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountCreateContract {@link AccountCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountCreateContract AccountCreateContract.parseFrom(InputStream)"})
  public void testAccountCreateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountCreateContract actualParseFromResult = AccountCreateContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountCreateContract_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testAccountCreateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("AccountCreateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountCreateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
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
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#equals(Object)}, and {@link AccountPermissionUpdateContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountPermissionUpdateContract#equals(Object)}
   *   <li>{@link AccountPermissionUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.equals(Object)",
      "int AccountPermissionUpdateContract.hashCode()"})
  public void testAccountPermissionUpdateContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    AccountPermissionUpdateContract defaultInstance = AccountPermissionUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#equals(Object)}, and {@link AccountPermissionUpdateContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountPermissionUpdateContract#equals(Object)}
   *   <li>{@link AccountPermissionUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.equals(Object)",
      "int AccountPermissionUpdateContract.hashCode()"})
  public void testAccountPermissionUpdateContractEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    AccountPermissionUpdateContract defaultInstance = AccountPermissionUpdateContract.getDefaultInstance();
    AccountPermissionUpdateContract defaultInstance2 = AccountPermissionUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.equals(Object)",
      "int AccountPermissionUpdateContract.hashCode()"})
  public void testAccountPermissionUpdateContractEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountPermissionUpdateContract.getDefaultInstance(),
        "Different type to AccountPermissionUpdateContract");
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.equals(Object)",
      "int AccountPermissionUpdateContract.hashCode()"})
  public void testAccountPermissionUpdateContractEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(AccountPermissionUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.equals(Object)",
      "int AccountPermissionUpdateContract.hashCode()"})
  public void testAccountPermissionUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountPermissionUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getActivesCount()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getActivesCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountPermissionUpdateContract.getActivesCount()"})
  public void testAccountPermissionUpdateContractGetActivesCount() {
    // Arrange, Act and Assert
    assertEquals(0, AccountPermissionUpdateContract.getDefaultInstance().getActivesCount());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.getDefaultInstanceForType()"})
  public void testAccountPermissionUpdateContractGetDefaultInstanceForType() {
    // Arrange
    AccountPermissionUpdateContract defaultInstance = AccountPermissionUpdateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountPermissionUpdateContract.getDescriptor()"})
  public void testAccountPermissionUpdateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountPermissionUpdateContract.getDescriptor();

    // Assert
    assertEquals("AccountPermissionUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountPermissionUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getOwner()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getOwner()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Permission AccountPermissionUpdateContract.getOwner()"})
  public void testAccountPermissionUpdateContractGetOwner() {
    // Arrange and Act
    Permission actualOwner = AccountPermissionUpdateContract.getDefaultInstance().getOwner();

    // Assert
    assertEquals("", actualOwner.getInitializationErrorString());
    assertEquals("", actualOwner.getPermissionName());
    assertEquals(0, actualOwner.getId());
    assertEquals(0, actualOwner.getKeysCount());
    assertEquals(0, actualOwner.getParentId());
    assertEquals(0, actualOwner.getSerializedSize());
    assertEquals(0, actualOwner.getTypeValue());
    assertEquals(0L, actualOwner.getThreshold());
    assertEquals(PermissionType.Owner, actualOwner.getType());
    assertTrue(actualOwner.findInitializationErrors().isEmpty());
    List<Key> keysList = actualOwner.getKeysList();
    assertTrue(keysList.isEmpty());
    assertTrue(actualOwner.getAllFields().isEmpty());
    assertTrue(actualOwner.isInitialized());
    assertSame(keysList, actualOwner.getKeysOrBuilderList());
    assertSame(actualOwner, actualOwner.getDefaultInstanceForType());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountPermissionUpdateContract.getSerializedSize()"})
  public void testAccountPermissionUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountPermissionUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#getWitness()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#getWitness()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Permission AccountPermissionUpdateContract.getWitness()"})
  public void testAccountPermissionUpdateContractGetWitness() {
    // Arrange and Act
    Permission actualWitness = AccountPermissionUpdateContract.getDefaultInstance().getWitness();

    // Assert
    assertEquals("", actualWitness.getInitializationErrorString());
    assertEquals("", actualWitness.getPermissionName());
    assertEquals(0, actualWitness.getId());
    assertEquals(0, actualWitness.getKeysCount());
    assertEquals(0, actualWitness.getParentId());
    assertEquals(0, actualWitness.getSerializedSize());
    assertEquals(0, actualWitness.getTypeValue());
    assertEquals(0L, actualWitness.getThreshold());
    assertEquals(PermissionType.Owner, actualWitness.getType());
    assertTrue(actualWitness.findInitializationErrors().isEmpty());
    List<Key> keysList = actualWitness.getKeysList();
    assertTrue(keysList.isEmpty());
    assertTrue(actualWitness.getAllFields().isEmpty());
    assertTrue(actualWitness.isInitialized());
    assertSame(keysList, actualWitness.getKeysOrBuilderList());
    assertSame(actualWitness, actualWitness.getDefaultInstanceForType());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#hasOwner()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#hasOwner()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.hasOwner()"})
  public void testAccountPermissionUpdateContractHasOwner() {
    // Arrange, Act and Assert
    assertFalse(AccountPermissionUpdateContract.getDefaultInstance().hasOwner());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#hasWitness()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#hasWitness()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.hasWitness()"})
  public void testAccountPermissionUpdateContractHasWitness() {
    // Arrange, Act and Assert
    assertFalse(AccountPermissionUpdateContract.getDefaultInstance().hasWitness());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#isInitialized()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountPermissionUpdateContract.isInitialized()"})
  public void testAccountPermissionUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountPermissionUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, AccountPermissionUpdateContract.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountPermissionUpdateContract actualParseDelimitedFromResult = AccountPermissionUpdateContract
        .parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(4, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Permission owner = actualParseDelimitedFromResult.getOwner();
    assertSame(unknownFields, owner.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(owner, owner.getDefaultInstanceForType());
    assertSame(owner, actualParseDelimitedFromResult.getOwnerOrBuilder());
    assertSame(owner, actualParseDelimitedFromResult.getWitness());
    assertSame(owner, actualParseDelimitedFromResult.getWitnessOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountPermissionUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountPermissionUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, AccountPermissionUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry())
        .getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountPermissionUpdateContract actualParseDelimitedFromResult = AccountPermissionUpdateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(4, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Permission owner = actualParseDelimitedFromResult.getOwner();
    assertSame(unknownFields, owner.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(owner, owner.getDefaultInstanceForType());
    assertSame(owner, actualParseDelimitedFromResult.getOwnerOrBuilder());
    assertSame(owner, actualParseDelimitedFromResult.getWitness());
    assertSame(owner, actualParseDelimitedFromResult.getWitnessOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountPermissionUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountPermissionUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountPermissionUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountPermissionUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(byte[])"})
  public void testAccountPermissionUpdateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActivesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasOwner());
    assertFalse(actualParseFromResult.hasWitness());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Permission> activesList = actualParseFromResult.getActivesList();
    assertTrue(activesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(activesList, actualParseFromResult.getActivesOrBuilderList());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(ByteBuffer)"})
  public void testAccountPermissionUpdateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActivesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasOwner());
    assertFalse(actualParseFromResult.hasWitness());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Permission> activesList = actualParseFromResult.getActivesList();
    assertTrue(activesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(activesList, actualParseFromResult.getActivesOrBuilderList());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActivesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasOwner());
    assertFalse(actualParseFromResult.hasWitness());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Permission> activesList = actualParseFromResult.getActivesList();
    assertTrue(activesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(activesList, actualParseFromResult.getActivesOrBuilderList());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActivesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasOwner());
    assertFalse(actualParseFromResult.hasWitness());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Permission> activesList = actualParseFromResult.getActivesList();
    assertTrue(activesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(activesList, actualParseFromResult.getActivesOrBuilderList());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Permission owner = actualParseFromResult.getOwner();
    assertSame(unknownFields, owner.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(owner, owner.getDefaultInstanceForType());
    assertSame(owner, actualParseFromResult.getOwnerOrBuilder());
    assertSame(owner, actualParseFromResult.getWitness());
    assertSame(owner, actualParseFromResult.getWitnessOrBuilder());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountPermissionUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getActivesCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasOwner());
    assertFalse(actualParseFromResult.hasWitness());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Permission> activesList = actualParseFromResult.getActivesList();
    assertTrue(activesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(activesList, actualParseFromResult.getActivesOrBuilderList());
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountPermissionUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountPermissionUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountPermissionUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountPermissionUpdateContract {@link AccountPermissionUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountPermissionUpdateContract AccountPermissionUpdateContract.parseFrom(InputStream)"})
  public void testAccountPermissionUpdateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountPermissionUpdateContract actualParseFromResult = AccountPermissionUpdateContract
        .parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Permission owner = actualParseFromResult.getOwner();
    assertSame(unknownFields, owner.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(owner, owner.getDefaultInstanceForType());
    assertSame(owner, actualParseFromResult.getOwnerOrBuilder());
    assertSame(owner, actualParseFromResult.getWitness());
    assertSame(owner, actualParseFromResult.getWitnessOrBuilder());
  }

  /**
   * Test AccountPermissionUpdateContract_Builder {@link AccountPermissionUpdateContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountPermissionUpdateContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountPermissionUpdateContract.Builder.getDescriptor()"})
  public void testAccountPermissionUpdateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountPermissionUpdateContract.Builder.getDescriptor();

    // Assert
    assertEquals("AccountPermissionUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountPermissionUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#equals(Object)}, and {@link AccountUpdateContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountUpdateContract#equals(Object)}
   *   <li>{@link AccountUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.equals(Object)", "int AccountUpdateContract.hashCode()"})
  public void testAccountUpdateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountUpdateContract defaultInstance = AccountUpdateContract.getDefaultInstance();
    AccountUpdateContract defaultInstance2 = AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#equals(Object)}, and {@link AccountUpdateContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountUpdateContract#equals(Object)}
   *   <li>{@link AccountUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.equals(Object)", "int AccountUpdateContract.hashCode()"})
  public void testAccountUpdateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountUpdateContract defaultInstance = AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.equals(Object)", "int AccountUpdateContract.hashCode()"})
  public void testAccountUpdateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.equals(Object)", "int AccountUpdateContract.hashCode()"})
  public void testAccountUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.equals(Object)", "int AccountUpdateContract.hashCode()"})
  public void testAccountUpdateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountUpdateContract.getDefaultInstance(), "Different type to AccountUpdateContract");
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AccountUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.getDefaultInstanceForType()"})
  public void testAccountUpdateContractGetDefaultInstanceForType() {
    // Arrange
    AccountUpdateContract defaultInstance = AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountUpdateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountUpdateContract.getDescriptor()"})
  public void testAccountUpdateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountUpdateContract.getDescriptor();

    // Assert
    assertEquals("AccountUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link AccountUpdateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AccountUpdateContract.getSerializedSize()"})
  public void testAccountUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#isInitialized()}.
   * <p>
   * Method under test: {@link AccountUpdateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountUpdateContract.isInitialized()"})
  public void testAccountUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountUpdateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountUpdateContract actualParseDelimitedFromResult = AccountUpdateContract.parseDelimitedFrom(input);

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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountUpdateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AccountUpdateContract actualParseDelimitedFromResult = AccountUpdateContract.parseDelimitedFrom(input,
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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountUpdateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testAccountUpdateContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(byte[])"})
  public void testAccountUpdateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(ByteBuffer)"})
  public void testAccountUpdateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(data,
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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(new byte[]{},
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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(ByteString)"})
  public void testAccountUpdateContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(data);

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
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(data,
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
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(CodedInputStream)"})
  public void testAccountUpdateContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(input);

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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(input,
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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream)"})
  public void testAccountUpdateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream)"})
  public void testAccountUpdateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom(input,
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
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAccountUpdateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream)"})
  public void testAccountUpdateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AccountUpdateContract {@link AccountUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountUpdateContract AccountUpdateContract.parseFrom(InputStream)"})
  public void testAccountUpdateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AccountUpdateContract actualParseFromResult = AccountUpdateContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AccountUpdateContract_Builder {@link AccountUpdateContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link AccountUpdateContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AccountUpdateContract.Builder.getDescriptor()"})
  public void testAccountUpdateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AccountUpdateContract.Builder.getDescriptor();

    // Assert
    assertEquals("AccountUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.AccountUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#equals(Object)}, and {@link SetAccountIdContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetAccountIdContract#equals(Object)}
   *   <li>{@link SetAccountIdContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.equals(Object)", "int SetAccountIdContract.hashCode()"})
  public void testSetAccountIdContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SetAccountIdContract defaultInstance = SetAccountIdContract.getDefaultInstance();
    SetAccountIdContract defaultInstance2 = SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#equals(Object)}, and {@link SetAccountIdContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetAccountIdContract#equals(Object)}
   *   <li>{@link SetAccountIdContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.equals(Object)", "int SetAccountIdContract.hashCode()"})
  public void testSetAccountIdContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SetAccountIdContract defaultInstance = SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.equals(Object)", "int SetAccountIdContract.hashCode()"})
  public void testSetAccountIdContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SetAccountIdContract.getDefaultInstance(), 1);
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.equals(Object)", "int SetAccountIdContract.hashCode()"})
  public void testSetAccountIdContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SetAccountIdContract.getDefaultInstance(), null);
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.equals(Object)", "int SetAccountIdContract.hashCode()"})
  public void testSetAccountIdContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SetAccountIdContract.getDefaultInstance(), "Different type to SetAccountIdContract");
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SetAccountIdContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.getDefaultInstanceForType()"})
  public void testSetAccountIdContractGetDefaultInstanceForType() {
    // Arrange
    SetAccountIdContract defaultInstance = SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#getDescriptor()}.
   * <p>
   * Method under test: {@link SetAccountIdContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SetAccountIdContract.getDescriptor()"})
  public void testSetAccountIdContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SetAccountIdContract.getDescriptor();

    // Assert
    assertEquals("SetAccountIdContract", actualDescriptor.getName());
    assertEquals("protocol.SetAccountIdContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link SetAccountIdContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SetAccountIdContract.getSerializedSize()"})
  public void testSetAccountIdContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SetAccountIdContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#isInitialized()}.
   * <p>
   * Method under test: {@link SetAccountIdContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SetAccountIdContract.isInitialized()"})
  public void testSetAccountIdContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SetAccountIdContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream)"})
  public void testSetAccountIdContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SetAccountIdContract actualParseDelimitedFromResult = SetAccountIdContract.parseDelimitedFrom(input);

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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream)"})
  public void testSetAccountIdContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SetAccountIdContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SetAccountIdContract actualParseDelimitedFromResult = SetAccountIdContract.parseDelimitedFrom(input,
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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream)"})
  public void testSetAccountIdContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SetAccountIdContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseDelimitedFrom(InputStream)"})
  public void testSetAccountIdContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SetAccountIdContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(byte[])"})
  public void testSetAccountIdContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(ByteBuffer)"})
  public void testSetAccountIdContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(data,
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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(new byte[]{},
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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(ByteString)"})
  public void testSetAccountIdContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(data);

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
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(data,
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
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAccountId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(CodedInputStream)"})
  public void testSetAccountIdContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(input);

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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(input,
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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream)"})
  public void testSetAccountIdContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream)"})
  public void testSetAccountIdContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SetAccountIdContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom(input,
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
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SetAccountIdContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSetAccountIdContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SetAccountIdContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream)"})
  public void testSetAccountIdContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SetAccountIdContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SetAccountIdContract {@link SetAccountIdContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAccountIdContract SetAccountIdContract.parseFrom(InputStream)"})
  public void testSetAccountIdContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SetAccountIdContract actualParseFromResult = SetAccountIdContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SetAccountIdContract_Builder {@link SetAccountIdContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link SetAccountIdContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SetAccountIdContract.Builder.getDescriptor()"})
  public void testSetAccountIdContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SetAccountIdContract.Builder.getDescriptor();

    // Assert
    assertEquals("SetAccountIdContract", actualDescriptor.getName());
    assertEquals("protocol.SetAccountIdContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }
}
