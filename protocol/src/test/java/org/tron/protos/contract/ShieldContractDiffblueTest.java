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
import org.tron.protos.contract.ShieldContract.AuthenticationPath;
import org.tron.protos.contract.ShieldContract.AuthenticationPath.Builder;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleTree;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucher;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo;
import org.tron.protos.contract.ShieldContract.MerklePath;
import org.tron.protos.contract.ShieldContract.OutputPoint;
import org.tron.protos.contract.ShieldContract.OutputPointInfo;
import org.tron.protos.contract.ShieldContract.PedersenHash;
import org.tron.protos.contract.ShieldContract.ReceiveDescription;
import org.tron.protos.contract.ShieldContract.ShieldedTransferContract;
import org.tron.protos.contract.ShieldContract.SpendDescription;

public class ShieldContractDiffblueTest {
  /**
   * Test AuthenticationPath {@link AuthenticationPath#equals(Object)}, and {@link AuthenticationPath#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthenticationPath#equals(Object)}
   *   <li>{@link AuthenticationPath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.equals(Object)", "int AuthenticationPath.hashCode()"})
  public void testAuthenticationPathEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuthenticationPath defaultInstance = AuthenticationPath.getDefaultInstance();
    AuthenticationPath defaultInstance2 = AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#equals(Object)}, and {@link AuthenticationPath#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuthenticationPath#equals(Object)}
   *   <li>{@link AuthenticationPath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.equals(Object)", "int AuthenticationPath.hashCode()"})
  public void testAuthenticationPathEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuthenticationPath defaultInstance = AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.equals(Object)", "int AuthenticationPath.hashCode()"})
  public void testAuthenticationPathEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthenticationPath.getDefaultInstance(), 1);
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.equals(Object)", "int AuthenticationPath.hashCode()"})
  public void testAuthenticationPathEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthenticationPath.getDefaultInstance(), null);
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.equals(Object)", "int AuthenticationPath.hashCode()"})
  public void testAuthenticationPathEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AuthenticationPath.getDefaultInstance(), "Different type to AuthenticationPath");
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AuthenticationPath#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.getDefaultInstanceForType()"})
  public void testAuthenticationPathGetDefaultInstanceForType() {
    // Arrange
    AuthenticationPath defaultInstance = AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#getDescriptor()}.
   * <p>
   * Method under test: {@link AuthenticationPath#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AuthenticationPath.getDescriptor()"})
  public void testAuthenticationPathGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AuthenticationPath.getDescriptor();

    // Assert
    assertEquals("AuthenticationPath", actualDescriptor.getName());
    assertEquals("protocol.AuthenticationPath", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#getSerializedSize()}.
   * <p>
   * Method under test: {@link AuthenticationPath#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AuthenticationPath.getSerializedSize()"})
  public void testAuthenticationPathGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AuthenticationPath.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#getValueCount()}.
   * <p>
   * Method under test: {@link AuthenticationPath#getValueCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AuthenticationPath.getValueCount()"})
  public void testAuthenticationPathGetValueCount() {
    // Arrange, Act and Assert
    assertEquals(0, AuthenticationPath.getDefaultInstance().getValueCount());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#isInitialized()}.
   * <p>
   * Method under test: {@link AuthenticationPath#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AuthenticationPath.isInitialized()"})
  public void testAuthenticationPathIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AuthenticationPath.getDefaultInstance().isInitialized());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream)"})
  public void testAuthenticationPathParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AuthenticationPath actualParseDelimitedFromResult = AuthenticationPath.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getValueCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getValueList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream)"})
  public void testAuthenticationPathParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AuthenticationPath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AuthenticationPath actualParseDelimitedFromResult = AuthenticationPath.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getValueCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getValueList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream)"})
  public void testAuthenticationPathParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AuthenticationPath.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseDelimitedFrom(InputStream)"})
  public void testAuthenticationPathParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AuthenticationPath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(byte[])"})
  public void testAuthenticationPathParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(ByteBuffer)"})
  public void testAuthenticationPathParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(ByteString)"})
  public void testAuthenticationPathParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(CodedInputStream)"})
  public void testAuthenticationPathParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream)"})
  public void testAuthenticationPathParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream)"})
  public void testAuthenticationPathParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AuthenticationPath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AuthenticationPath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAuthenticationPathParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AuthenticationPath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream)"})
  public void testAuthenticationPathParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AuthenticationPath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AuthenticationPath {@link AuthenticationPath#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AuthenticationPath AuthenticationPath.parseFrom(InputStream)"})
  public void testAuthenticationPathParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AuthenticationPath actualParseFromResult = AuthenticationPath.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AuthenticationPath_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testAuthenticationPath_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("AuthenticationPath", actualDescriptor.getName());
    assertEquals("protocol.AuthenticationPath", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#equals(Object)}, and {@link IncrementalMerkleTree#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleTree#equals(Object)}
   *   <li>{@link IncrementalMerkleTree#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.equals(Object)", "int IncrementalMerkleTree.hashCode()"})
  public void testIncrementalMerkleTreeEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IncrementalMerkleTree defaultInstance = IncrementalMerkleTree.getDefaultInstance();
    IncrementalMerkleTree defaultInstance2 = IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#equals(Object)}, and {@link IncrementalMerkleTree#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleTree#equals(Object)}
   *   <li>{@link IncrementalMerkleTree#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.equals(Object)", "int IncrementalMerkleTree.hashCode()"})
  public void testIncrementalMerkleTreeEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IncrementalMerkleTree defaultInstance = IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.equals(Object)", "int IncrementalMerkleTree.hashCode()"})
  public void testIncrementalMerkleTreeEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleTree.getDefaultInstance(), 1);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.equals(Object)", "int IncrementalMerkleTree.hashCode()"})
  public void testIncrementalMerkleTreeEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleTree.getDefaultInstance(), null);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.equals(Object)", "int IncrementalMerkleTree.hashCode()"})
  public void testIncrementalMerkleTreeEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleTree.getDefaultInstance(), "Different type to IncrementalMerkleTree");
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.getDefaultInstanceForType()"})
  public void testIncrementalMerkleTreeGetDefaultInstanceForType() {
    // Arrange
    IncrementalMerkleTree defaultInstance = IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleTree.getDescriptor()"})
  public void testIncrementalMerkleTreeGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleTree.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleTree", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleTree", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(5, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getLeft()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTree.getLeft()"})
  public void testIncrementalMerkleTreeGetLeft() {
    // Arrange and Act
    PedersenHash actualLeft = IncrementalMerkleTree.getDefaultInstance().getLeft();

    // Assert
    assertEquals("", actualLeft.getInitializationErrorString());
    assertEquals(0, actualLeft.getSerializedSize());
    assertTrue(actualLeft.findInitializationErrors().isEmpty());
    assertTrue(actualLeft.getAllFields().isEmpty());
    assertTrue(actualLeft.isInitialized());
    assertSame(actualLeft, actualLeft.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getParentsCount()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getParentsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTree.getParentsCount()"})
  public void testIncrementalMerkleTreeGetParentsCount() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleTree.getDefaultInstance().getParentsCount());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getRight()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTree.getRight()"})
  public void testIncrementalMerkleTreeGetRight() {
    // Arrange and Act
    PedersenHash actualRight = IncrementalMerkleTree.getDefaultInstance().getRight();

    // Assert
    assertEquals("", actualRight.getInitializationErrorString());
    assertEquals(0, actualRight.getSerializedSize());
    assertTrue(actualRight.findInitializationErrors().isEmpty());
    assertTrue(actualRight.getAllFields().isEmpty());
    assertTrue(actualRight.isInitialized());
    assertSame(actualRight, actualRight.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#getSerializedSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTree.getSerializedSize()"})
  public void testIncrementalMerkleTreeGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleTree.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#hasLeft()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#hasLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.hasLeft()"})
  public void testIncrementalMerkleTreeHasLeft() {
    // Arrange, Act and Assert
    assertFalse(IncrementalMerkleTree.getDefaultInstance().hasLeft());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#hasRight()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#hasRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.hasRight()"})
  public void testIncrementalMerkleTreeHasRight() {
    // Arrange, Act and Assert
    assertFalse(IncrementalMerkleTree.getDefaultInstance().hasRight());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#isInitialized()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTree.isInitialized()"})
  public void testIncrementalMerkleTreeIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(IncrementalMerkleTree.getDefaultInstance().isInitialized());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, IncrementalMerkleTree.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleTree actualParseDelimitedFromResult = IncrementalMerkleTree.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(3, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PedersenHash left = actualParseDelimitedFromResult.getLeft();
    assertSame(unknownFields, left.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(left, actualParseDelimitedFromResult.getLeftOrBuilder());
    assertSame(left, actualParseDelimitedFromResult.getRight());
    assertSame(left, actualParseDelimitedFromResult.getRightOrBuilder());
    assertSame(left, left.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleTree.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleTree actualParseDelimitedFromResult = IncrementalMerkleTree.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(3, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PedersenHash left = actualParseDelimitedFromResult.getLeft();
    assertSame(unknownFields, left.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(left, actualParseDelimitedFromResult.getLeftOrBuilder());
    assertSame(left, actualParseDelimitedFromResult.getRight());
    assertSame(left, actualParseDelimitedFromResult.getRightOrBuilder());
    assertSame(left, left.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleTree.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleTree.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(byte[])"})
  public void testIncrementalMerkleTreeParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParentsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasLeft());
    assertFalse(actualParseFromResult.hasRight());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualParseFromResult.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(parentsList, actualParseFromResult.getParentsOrBuilderList());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(ByteBuffer)"})
  public void testIncrementalMerkleTreeParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParentsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasLeft());
    assertFalse(actualParseFromResult.hasRight());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualParseFromResult.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(parentsList, actualParseFromResult.getParentsOrBuilderList());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParentsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasLeft());
    assertFalse(actualParseFromResult.hasRight());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualParseFromResult.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(parentsList, actualParseFromResult.getParentsOrBuilderList());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParentsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasLeft());
    assertFalse(actualParseFromResult.hasRight());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualParseFromResult.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(parentsList, actualParseFromResult.getParentsOrBuilderList());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseFromWithInputStream() throws IOException {
    // Arrange and Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PedersenHash left = actualParseFromResult.getLeft();
    assertSame(unknownFields, left.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(left, actualParseFromResult.getLeftOrBuilder());
    assertSame(left, actualParseFromResult.getRight());
    assertSame(left, actualParseFromResult.getRightOrBuilder());
    assertSame(left, left.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleTree.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getParentsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasLeft());
    assertFalse(actualParseFromResult.hasRight());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualParseFromResult.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(parentsList, actualParseFromResult.getParentsOrBuilderList());
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleTree.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleTreeParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleTree.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleTree.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleTree {@link IncrementalMerkleTree#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTree.parseFrom(InputStream)"})
  public void testIncrementalMerkleTreeParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    IncrementalMerkleTree actualParseFromResult = IncrementalMerkleTree.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PedersenHash left = actualParseFromResult.getLeft();
    assertSame(unknownFields, left.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(left, actualParseFromResult.getLeftOrBuilder());
    assertSame(left, actualParseFromResult.getRight());
    assertSame(left, actualParseFromResult.getRightOrBuilder());
    assertSame(left, left.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleTree_Builder {@link IncrementalMerkleTree.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleTree.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleTree.Builder.getDescriptor()"})
  public void testIncrementalMerkleTree_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleTree.Builder.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleTree", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleTree", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(5, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#equals(Object)}, and {@link IncrementalMerkleVoucher#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleVoucher#equals(Object)}
   *   <li>{@link IncrementalMerkleVoucher#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.equals(Object)", "int IncrementalMerkleVoucher.hashCode()"})
  public void testIncrementalMerkleVoucherEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IncrementalMerkleVoucher defaultInstance = IncrementalMerkleVoucher.getDefaultInstance();
    IncrementalMerkleVoucher defaultInstance2 = IncrementalMerkleVoucher.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#equals(Object)}, and {@link IncrementalMerkleVoucher#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleVoucher#equals(Object)}
   *   <li>{@link IncrementalMerkleVoucher#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.equals(Object)", "int IncrementalMerkleVoucher.hashCode()"})
  public void testIncrementalMerkleVoucherEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IncrementalMerkleVoucher defaultInstance = IncrementalMerkleVoucher.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.equals(Object)", "int IncrementalMerkleVoucher.hashCode()"})
  public void testIncrementalMerkleVoucherEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucher.getDefaultInstance(), 1);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.equals(Object)", "int IncrementalMerkleVoucher.hashCode()"})
  public void testIncrementalMerkleVoucherEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucher.getDefaultInstance(), null);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.equals(Object)", "int IncrementalMerkleVoucher.hashCode()"})
  public void testIncrementalMerkleVoucherEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucher.getDefaultInstance(), "Different type to IncrementalMerkleVoucher");
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleVoucher.getCursor()"})
  public void testIncrementalMerkleVoucherGetCursor() {
    // Arrange and Act
    IncrementalMerkleTree actualCursor = IncrementalMerkleVoucher.getDefaultInstance().getCursor();

    // Assert
    assertEquals("", actualCursor.getInitializationErrorString());
    assertEquals(0, actualCursor.getParentsCount());
    assertEquals(0, actualCursor.getSerializedSize());
    assertFalse(actualCursor.hasLeft());
    assertFalse(actualCursor.hasRight());
    assertTrue(actualCursor.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualCursor.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualCursor.getAllFields().isEmpty());
    assertTrue(actualCursor.isInitialized());
    assertSame(parentsList, actualCursor.getParentsOrBuilderList());
    assertSame(actualCursor, actualCursor.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.getDefaultInstanceForType()"})
  public void testIncrementalMerkleVoucherGetDefaultInstanceForType() {
    // Arrange
    IncrementalMerkleVoucher defaultInstance = IncrementalMerkleVoucher.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleVoucher.getDescriptor()"})
  public void testIncrementalMerkleVoucherGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleVoucher.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleVoucher", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleVoucher", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getFilledCount()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getFilledCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucher.getFilledCount()"})
  public void testIncrementalMerkleVoucherGetFilledCount() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleVoucher.getDefaultInstance().getFilledCount());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getOutputPoint()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getOutputPoint()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint IncrementalMerkleVoucher.getOutputPoint()"})
  public void testIncrementalMerkleVoucherGetOutputPoint() {
    // Arrange and Act
    OutputPoint actualOutputPoint = IncrementalMerkleVoucher.getDefaultInstance().getOutputPoint();

    // Assert
    assertEquals("", actualOutputPoint.getInitializationErrorString());
    assertEquals(0, actualOutputPoint.getIndex());
    assertEquals(0, actualOutputPoint.getSerializedSize());
    assertTrue(actualOutputPoint.findInitializationErrors().isEmpty());
    assertTrue(actualOutputPoint.getAllFields().isEmpty());
    assertTrue(actualOutputPoint.isInitialized());
    assertSame(actualOutputPoint, actualOutputPoint.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getSerializedSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucher.getSerializedSize()"})
  public void testIncrementalMerkleVoucherGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleVoucher.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#getTree()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#getTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleVoucher.getTree()"})
  public void testIncrementalMerkleVoucherGetTree() {
    // Arrange and Act
    IncrementalMerkleTree actualTree = IncrementalMerkleVoucher.getDefaultInstance().getTree();

    // Assert
    assertEquals("", actualTree.getInitializationErrorString());
    assertEquals(0, actualTree.getParentsCount());
    assertEquals(0, actualTree.getSerializedSize());
    assertFalse(actualTree.hasLeft());
    assertFalse(actualTree.hasRight());
    assertTrue(actualTree.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualTree.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualTree.getAllFields().isEmpty());
    assertTrue(actualTree.isInitialized());
    assertSame(parentsList, actualTree.getParentsOrBuilderList());
    assertSame(actualTree, actualTree.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#hasCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#hasCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.hasCursor()"})
  public void testIncrementalMerkleVoucherHasCursor() {
    // Arrange, Act and Assert
    assertFalse(IncrementalMerkleVoucher.getDefaultInstance().hasCursor());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#hasOutputPoint()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#hasOutputPoint()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.hasOutputPoint()"})
  public void testIncrementalMerkleVoucherHasOutputPoint() {
    // Arrange, Act and Assert
    assertFalse(IncrementalMerkleVoucher.getDefaultInstance().hasOutputPoint());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#hasTree()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#hasTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.hasTree()"})
  public void testIncrementalMerkleVoucherHasTree() {
    // Arrange, Act and Assert
    assertFalse(IncrementalMerkleVoucher.getDefaultInstance().hasTree());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#equals(Object)}, and {@link IncrementalMerkleVoucherInfo#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleVoucherInfo#equals(Object)}
   *   <li>{@link IncrementalMerkleVoucherInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.equals(Object)",
      "int IncrementalMerkleVoucherInfo.hashCode()"})
  public void testIncrementalMerkleVoucherInfoEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    IncrementalMerkleVoucherInfo defaultInstance = IncrementalMerkleVoucherInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#equals(Object)}, and {@link IncrementalMerkleVoucherInfo#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IncrementalMerkleVoucherInfo#equals(Object)}
   *   <li>{@link IncrementalMerkleVoucherInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.equals(Object)",
      "int IncrementalMerkleVoucherInfo.hashCode()"})
  public void testIncrementalMerkleVoucherInfoEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    IncrementalMerkleVoucherInfo defaultInstance = IncrementalMerkleVoucherInfo.getDefaultInstance();
    IncrementalMerkleVoucherInfo defaultInstance2 = IncrementalMerkleVoucherInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.equals(Object)",
      "int IncrementalMerkleVoucherInfo.hashCode()"})
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucherInfo.getDefaultInstance(), 1);
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.equals(Object)",
      "int IncrementalMerkleVoucherInfo.hashCode()"})
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucherInfo.getDefaultInstance(), null);
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.equals(Object)",
      "int IncrementalMerkleVoucherInfo.hashCode()"})
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IncrementalMerkleVoucherInfo.getDefaultInstance(),
        "Different type to IncrementalMerkleVoucherInfo");
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.getDefaultInstanceForType()"})
  public void testIncrementalMerkleVoucherInfoGetDefaultInstanceForType() {
    // Arrange
    IncrementalMerkleVoucherInfo defaultInstance = IncrementalMerkleVoucherInfo.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleVoucherInfo.getDescriptor()"})
  public void testIncrementalMerkleVoucherInfoGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleVoucherInfo.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleVoucherInfo", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleVoucherInfo", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#getPathsCount()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#getPathsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherInfo.getPathsCount()"})
  public void testIncrementalMerkleVoucherInfoGetPathsCount() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleVoucherInfo.getDefaultInstance().getPathsCount());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#getSerializedSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherInfo.getSerializedSize()"})
  public void testIncrementalMerkleVoucherInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleVoucherInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#getVouchersCount()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#getVouchersCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherInfo.getVouchersCount()"})
  public void testIncrementalMerkleVoucherInfoGetVouchersCount() {
    // Arrange, Act and Assert
    assertEquals(0, IncrementalMerkleVoucherInfo.getDefaultInstance().getVouchersCount());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#isInitialized()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucherInfo.isInitialized()"})
  public void testIncrementalMerkleVoucherInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(IncrementalMerkleVoucherInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleVoucherInfo actualParseDelimitedFromResult = IncrementalMerkleVoucherInfo
        .parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getPathsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVouchersCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseDelimitedFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseDelimitedFromResult.getVouchersOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleVoucherInfo actualParseDelimitedFromResult = IncrementalMerkleVoucherInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getPathsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVouchersCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseDelimitedFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseDelimitedFromResult.getVouchersOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleVoucherInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleVoucherInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleVoucherInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(byte[])"})
  public void testIncrementalMerkleVoucherInfoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPathsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVouchersCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseFromResult.getVouchersOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(ByteBuffer)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPathsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVouchersCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseFromResult.getVouchersOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPathsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVouchersCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseFromResult.getVouchersOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPathsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVouchersCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseFromResult.getVouchersOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleVoucherInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPathsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVouchersCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getPathsList().isEmpty());
    List<IncrementalMerkleVoucher> vouchersList = actualParseFromResult.getVouchersList();
    assertTrue(vouchersList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(vouchersList, actualParseFromResult.getVouchersOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleVoucherInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleVoucherInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleVoucherInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucherInfo {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherInfo IncrementalMerkleVoucherInfo.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherInfoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    IncrementalMerkleVoucherInfo actualParseFromResult = IncrementalMerkleVoucherInfo.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucherInfo_Builder {@link IncrementalMerkleVoucherInfo.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherInfo.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleVoucherInfo.Builder.getDescriptor()"})
  public void testIncrementalMerkleVoucherInfo_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleVoucherInfo.Builder.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleVoucherInfo", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleVoucherInfo", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#isInitialized()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleVoucher.isInitialized()"})
  public void testIncrementalMerkleVoucherIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(IncrementalMerkleVoucher.getDefaultInstance().isInitialized());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, IncrementalMerkleVoucher.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleVoucher actualParseDelimitedFromResult = IncrementalMerkleVoucher.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleVoucher.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, IncrementalMerkleVoucher.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry())
        .getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    IncrementalMerkleVoucher actualParseDelimitedFromResult = IncrementalMerkleVoucher.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleVoucher.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleVoucher.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleVoucher.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(IncrementalMerkleVoucher.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseDelimitedFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleVoucher.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(byte[])"})
  public void testIncrementalMerkleVoucherParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFilledCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCursorDepth());
    assertFalse(actualParseFromResult.hasCursor());
    assertFalse(actualParseFromResult.hasOutputPoint());
    assertFalse(actualParseFromResult.hasTree());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualParseFromResult.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(filledList, actualParseFromResult.getFilledOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(ByteBuffer)"})
  public void testIncrementalMerkleVoucherParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFilledCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCursorDepth());
    assertFalse(actualParseFromResult.hasCursor());
    assertFalse(actualParseFromResult.hasOutputPoint());
    assertFalse(actualParseFromResult.hasTree());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualParseFromResult.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(filledList, actualParseFromResult.getFilledOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFilledCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCursorDepth());
    assertFalse(actualParseFromResult.hasCursor());
    assertFalse(actualParseFromResult.hasOutputPoint());
    assertFalse(actualParseFromResult.hasTree());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualParseFromResult.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(filledList, actualParseFromResult.getFilledOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFilledCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCursorDepth());
    assertFalse(actualParseFromResult.hasCursor());
    assertFalse(actualParseFromResult.hasOutputPoint());
    assertFalse(actualParseFromResult.hasTree());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualParseFromResult.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(filledList, actualParseFromResult.getFilledOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStream() throws IOException {
    // Arrange and Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> IncrementalMerkleVoucher.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getFilledCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCursorDepth());
    assertFalse(actualParseFromResult.hasCursor());
    assertFalse(actualParseFromResult.hasOutputPoint());
    assertFalse(actualParseFromResult.hasTree());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualParseFromResult.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(filledList, actualParseFromResult.getFilledOrBuilderList());
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> IncrementalMerkleVoucher.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> IncrementalMerkleVoucher.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> IncrementalMerkleVoucher.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test IncrementalMerkleVoucher {@link IncrementalMerkleVoucher#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucher.parseFrom(InputStream)"})
  public void testIncrementalMerkleVoucherParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    IncrementalMerkleVoucher actualParseFromResult = IncrementalMerkleVoucher.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test IncrementalMerkleVoucher_Builder {@link IncrementalMerkleVoucher.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucher.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor IncrementalMerkleVoucher.Builder.getDescriptor()"})
  public void testIncrementalMerkleVoucher_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = IncrementalMerkleVoucher.Builder.getDescriptor();

    // Assert
    assertEquals("IncrementalMerkleVoucher", actualDescriptor.getName());
    assertEquals("protocol.IncrementalMerkleVoucher", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test MerklePath {@link MerklePath#equals(Object)}, and {@link MerklePath#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MerklePath#equals(Object)}
   *   <li>{@link MerklePath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.equals(Object)", "int MerklePath.hashCode()"})
  public void testMerklePathEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MerklePath defaultInstance = MerklePath.getDefaultInstance();
    MerklePath defaultInstance2 = MerklePath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test MerklePath {@link MerklePath#equals(Object)}, and {@link MerklePath#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MerklePath#equals(Object)}
   *   <li>{@link MerklePath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.equals(Object)", "int MerklePath.hashCode()"})
  public void testMerklePathEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MerklePath defaultInstance = MerklePath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test MerklePath {@link MerklePath#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.equals(Object)", "int MerklePath.hashCode()"})
  public void testMerklePathEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MerklePath.getDefaultInstance(), 1);
  }

  /**
   * Test MerklePath {@link MerklePath#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.equals(Object)", "int MerklePath.hashCode()"})
  public void testMerklePathEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MerklePath.getDefaultInstance(), null);
  }

  /**
   * Test MerklePath {@link MerklePath#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.equals(Object)", "int MerklePath.hashCode()"})
  public void testMerklePathEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MerklePath.getDefaultInstance(), "Different type to MerklePath");
  }

  /**
   * Test MerklePath {@link MerklePath#getAuthenticationPathsCount()}.
   * <p>
   * Method under test: {@link MerklePath#getAuthenticationPathsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MerklePath.getAuthenticationPathsCount()"})
  public void testMerklePathGetAuthenticationPathsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MerklePath.getDefaultInstance().getAuthenticationPathsCount());
  }

  /**
   * Test MerklePath {@link MerklePath#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MerklePath#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.getDefaultInstanceForType()"})
  public void testMerklePathGetDefaultInstanceForType() {
    // Arrange
    MerklePath defaultInstance = MerklePath.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test MerklePath {@link MerklePath#getDescriptor()}.
   * <p>
   * Method under test: {@link MerklePath#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor MerklePath.getDescriptor()"})
  public void testMerklePathGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = MerklePath.getDescriptor();

    // Assert
    assertEquals("MerklePath", actualDescriptor.getName());
    assertEquals("protocol.MerklePath", actualDescriptor.getFullName());
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
   * Test MerklePath {@link MerklePath#getIndexCount()}.
   * <p>
   * Method under test: {@link MerklePath#getIndexCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MerklePath.getIndexCount()"})
  public void testMerklePathGetIndexCount() {
    // Arrange, Act and Assert
    assertEquals(0, MerklePath.getDefaultInstance().getIndexCount());
  }

  /**
   * Test MerklePath {@link MerklePath#getSerializedSize()}.
   * <p>
   * Method under test: {@link MerklePath#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MerklePath.getSerializedSize()"})
  public void testMerklePathGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MerklePath.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test MerklePath {@link MerklePath#isInitialized()}.
   * <p>
   * Method under test: {@link MerklePath#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MerklePath.isInitialized()"})
  public void testMerklePathIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MerklePath.getDefaultInstance().isInitialized());
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream)"})
  public void testMerklePathParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MerklePath actualParseDelimitedFromResult = MerklePath.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseDelimitedFromResult.getIndexCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseDelimitedFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getIndexList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseDelimitedFromResult.getAuthenticationPathsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream)"})
  public void testMerklePathParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MerklePath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MerklePath actualParseDelimitedFromResult = MerklePath.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseDelimitedFromResult.getIndexCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseDelimitedFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getIndexList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseDelimitedFromResult.getAuthenticationPathsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream)"})
  public void testMerklePathParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MerklePath.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test MerklePath {@link MerklePath#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseDelimitedFrom(InputStream)"})
  public void testMerklePathParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MerklePath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(ByteBuffer)"})
  public void testMerklePathParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseFromResult.getIndexCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseFromResult.getIndexList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseFromResult.getAuthenticationPathsOrBuilderList());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testMerklePathParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseFromResult.getIndexCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseFromResult.getIndexList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseFromResult.getAuthenticationPathsOrBuilderList());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testMerklePathParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseFromResult.getIndexCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseFromResult.getIndexList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseFromResult.getAuthenticationPathsOrBuilderList());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(byte[])"})
  public void testMerklePathParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseFromResult.getIndexCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseFromResult.getIndexList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseFromResult.getAuthenticationPathsOrBuilderList());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream)"})
  public void testMerklePathParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MerklePath actualParseFromResult = MerklePath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getAuthenticationPathsCount());
    assertEquals(0, actualParseFromResult.getIndexCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AuthenticationPath> authenticationPathsList = actualParseFromResult.getAuthenticationPathsList();
    assertTrue(authenticationPathsList.isEmpty());
    assertTrue(actualParseFromResult.getIndexList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(authenticationPathsList, actualParseFromResult.getAuthenticationPathsOrBuilderList());
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MerklePath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testMerklePathParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MerklePath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream)"})
  public void testMerklePathParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MerklePath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream)"})
  public void testMerklePathParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MerklePath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test MerklePath {@link MerklePath#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerklePath#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath MerklePath.parseFrom(InputStream)"})
  public void testMerklePathParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MerklePath actualParseFromResult = MerklePath.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test MerklePath_Builder {@link MerklePath.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link MerklePath.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor MerklePath.Builder.getDescriptor()"})
  public void testMerklePath_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = MerklePath.Builder.getDescriptor();

    // Assert
    assertEquals("MerklePath", actualDescriptor.getName());
    assertEquals("protocol.MerklePath", actualDescriptor.getFullName());
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
   * Test OutputPoint {@link OutputPoint#equals(Object)}, and {@link OutputPoint#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OutputPoint#equals(Object)}
   *   <li>{@link OutputPoint#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.equals(Object)", "int OutputPoint.hashCode()"})
  public void testOutputPointEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OutputPoint defaultInstance = OutputPoint.getDefaultInstance();
    OutputPoint defaultInstance2 = OutputPoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test OutputPoint {@link OutputPoint#equals(Object)}, and {@link OutputPoint#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OutputPoint#equals(Object)}
   *   <li>{@link OutputPoint#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.equals(Object)", "int OutputPoint.hashCode()"})
  public void testOutputPointEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OutputPoint defaultInstance = OutputPoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test OutputPoint {@link OutputPoint#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.equals(Object)", "int OutputPoint.hashCode()"})
  public void testOutputPointEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPoint.getDefaultInstance(), 1);
  }

  /**
   * Test OutputPoint {@link OutputPoint#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.equals(Object)", "int OutputPoint.hashCode()"})
  public void testOutputPointEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPoint.getDefaultInstance(), null);
  }

  /**
   * Test OutputPoint {@link OutputPoint#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.equals(Object)", "int OutputPoint.hashCode()"})
  public void testOutputPointEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPoint.getDefaultInstance(), "Different type to OutputPoint");
  }

  /**
   * Test OutputPoint {@link OutputPoint#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link OutputPoint#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.getDefaultInstanceForType()"})
  public void testOutputPointGetDefaultInstanceForType() {
    // Arrange
    OutputPoint defaultInstance = OutputPoint.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#getDescriptor()}.
   * <p>
   * Method under test: {@link OutputPoint#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor OutputPoint.getDescriptor()"})
  public void testOutputPointGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = OutputPoint.getDescriptor();

    // Assert
    assertEquals("OutputPoint", actualDescriptor.getName());
    assertEquals("protocol.OutputPoint", actualDescriptor.getFullName());
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
   * Test OutputPoint {@link OutputPoint#getSerializedSize()}.
   * <p>
   * Method under test: {@link OutputPoint#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OutputPoint.getSerializedSize()"})
  public void testOutputPointGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, OutputPoint.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#equals(Object)}, and {@link OutputPointInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OutputPointInfo#equals(Object)}
   *   <li>{@link OutputPointInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.equals(Object)", "int OutputPointInfo.hashCode()"})
  public void testOutputPointInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OutputPointInfo defaultInstance = OutputPointInfo.getDefaultInstance();
    OutputPointInfo defaultInstance2 = OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#equals(Object)}, and {@link OutputPointInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OutputPointInfo#equals(Object)}
   *   <li>{@link OutputPointInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.equals(Object)", "int OutputPointInfo.hashCode()"})
  public void testOutputPointInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OutputPointInfo defaultInstance = OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.equals(Object)", "int OutputPointInfo.hashCode()"})
  public void testOutputPointInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPointInfo.getDefaultInstance(), 1);
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.equals(Object)", "int OutputPointInfo.hashCode()"})
  public void testOutputPointInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPointInfo.getDefaultInstance(), null);
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.equals(Object)", "int OutputPointInfo.hashCode()"})
  public void testOutputPointInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OutputPointInfo.getDefaultInstance(), "Different type to OutputPointInfo");
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link OutputPointInfo#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.getDefaultInstanceForType()"})
  public void testOutputPointInfoGetDefaultInstanceForType() {
    // Arrange
    OutputPointInfo defaultInstance = OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#getDescriptor()}.
   * <p>
   * Method under test: {@link OutputPointInfo#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor OutputPointInfo.getDescriptor()"})
  public void testOutputPointInfoGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = OutputPointInfo.getDescriptor();

    // Assert
    assertEquals("OutputPointInfo", actualDescriptor.getName());
    assertEquals("protocol.OutputPointInfo", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(3, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#getOutPointsCount()}.
   * <p>
   * Method under test: {@link OutputPointInfo#getOutPointsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OutputPointInfo.getOutPointsCount()"})
  public void testOutputPointInfoGetOutPointsCount() {
    // Arrange, Act and Assert
    assertEquals(0, OutputPointInfo.getDefaultInstance().getOutPointsCount());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#getSerializedSize()}.
   * <p>
   * Method under test: {@link OutputPointInfo#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OutputPointInfo.getSerializedSize()"})
  public void testOutputPointInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, OutputPointInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#isInitialized()}.
   * <p>
   * Method under test: {@link OutputPointInfo#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPointInfo.isInitialized()"})
  public void testOutputPointInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(OutputPointInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream)"})
  public void testOutputPointInfoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    OutputPointInfo actualParseDelimitedFromResult = OutputPointInfo.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getBlockNum());
    assertEquals(0, actualParseDelimitedFromResult.getOutPointsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseDelimitedFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseDelimitedFromResult.getOutPointsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream)"})
  public void testOutputPointInfoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OutputPointInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    OutputPointInfo actualParseDelimitedFromResult = OutputPointInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getBlockNum());
    assertEquals(0, actualParseDelimitedFromResult.getOutPointsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseDelimitedFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseDelimitedFromResult.getOutPointsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream)"})
  public void testOutputPointInfoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OutputPointInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseDelimitedFrom(InputStream)"})
  public void testOutputPointInfoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPointInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(byte[])"})
  public void testOutputPointInfoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBlockNum());
    assertEquals(0, actualParseFromResult.getOutPointsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseFromResult.getOutPointsOrBuilderList());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(ByteBuffer)"})
  public void testOutputPointInfoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBlockNum());
    assertEquals(0, actualParseFromResult.getOutPointsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseFromResult.getOutPointsOrBuilderList());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBlockNum());
    assertEquals(0, actualParseFromResult.getOutPointsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseFromResult.getOutPointsOrBuilderList());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testOutputPointInfoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBlockNum());
    assertEquals(0, actualParseFromResult.getOutPointsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseFromResult.getOutPointsOrBuilderList());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream)"})
  public void testOutputPointInfoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream)"})
  public void testOutputPointInfoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OutputPointInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getBlockNum());
    assertEquals(0, actualParseFromResult.getOutPointsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<OutputPoint> outPointsList = actualParseFromResult.getOutPointsList();
    assertTrue(outPointsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(outPointsList, actualParseFromResult.getOutPointsOrBuilderList());
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPointInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointInfoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> OutputPointInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream)"})
  public void testOutputPointInfoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPointInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPointInfo {@link OutputPointInfo#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPointInfo OutputPointInfo.parseFrom(InputStream)"})
  public void testOutputPointInfoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    OutputPointInfo actualParseFromResult = OutputPointInfo.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test OutputPointInfo_Builder {@link OutputPointInfo.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link OutputPointInfo.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor OutputPointInfo.Builder.getDescriptor()"})
  public void testOutputPointInfo_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = OutputPointInfo.Builder.getDescriptor();

    // Assert
    assertEquals("OutputPointInfo", actualDescriptor.getName());
    assertEquals("protocol.OutputPointInfo", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(3, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test OutputPoint {@link OutputPoint#isInitialized()}.
   * <p>
   * Method under test: {@link OutputPoint#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OutputPoint.isInitialized()"})
  public void testOutputPointIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(OutputPoint.getDefaultInstance().isInitialized());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream)"})
  public void testOutputPointParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    OutputPoint actualParseDelimitedFromResult = OutputPoint.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getIndex());
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
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream)"})
  public void testOutputPointParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OutputPoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    OutputPoint actualParseDelimitedFromResult = OutputPoint.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getIndex());
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
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream)"})
  public void testOutputPointParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OutputPoint.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseDelimitedFrom(InputStream)"})
  public void testOutputPointParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(byte[])"})
  public void testOutputPointParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(ByteBuffer)"})
  public void testOutputPointParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(ByteString)"})
  public void testOutputPointParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedHash = data.EMPTY;
    assertSame(expectedHash, actualParseFromResult.getHash());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedHash = data.EMPTY;
    assertSame(expectedHash, actualParseFromResult.getHash());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(CodedInputStream)"})
  public void testOutputPointParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream)"})
  public void testOutputPointParseFromWithInputStream() throws IOException {
    // Arrange and Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testOutputPointParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream)"})
  public void testOutputPointParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OutputPoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream)"})
  public void testOutputPointParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OutputPoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test OutputPoint {@link OutputPoint#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OutputPoint#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OutputPoint OutputPoint.parseFrom(InputStream)"})
  public void testOutputPointParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    OutputPoint actualParseFromResult = OutputPoint.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test OutputPoint_Builder {@link OutputPoint.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link OutputPoint.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor OutputPoint.Builder.getDescriptor()"})
  public void testOutputPoint_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = OutputPoint.Builder.getDescriptor();

    // Assert
    assertEquals("OutputPoint", actualDescriptor.getName());
    assertEquals("protocol.OutputPoint", actualDescriptor.getFullName());
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
   * Test PedersenHash {@link PedersenHash#equals(Object)}, and {@link PedersenHash#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PedersenHash#equals(Object)}
   *   <li>{@link PedersenHash#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.equals(Object)", "int PedersenHash.hashCode()"})
  public void testPedersenHashEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PedersenHash defaultInstance = PedersenHash.getDefaultInstance();
    PedersenHash defaultInstance2 = PedersenHash.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test PedersenHash {@link PedersenHash#equals(Object)}, and {@link PedersenHash#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PedersenHash#equals(Object)}
   *   <li>{@link PedersenHash#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.equals(Object)", "int PedersenHash.hashCode()"})
  public void testPedersenHashEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PedersenHash defaultInstance = PedersenHash.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test PedersenHash {@link PedersenHash#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.equals(Object)", "int PedersenHash.hashCode()"})
  public void testPedersenHashEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PedersenHash.getDefaultInstance(), 1);
  }

  /**
   * Test PedersenHash {@link PedersenHash#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.equals(Object)", "int PedersenHash.hashCode()"})
  public void testPedersenHashEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PedersenHash.getDefaultInstance(), null);
  }

  /**
   * Test PedersenHash {@link PedersenHash#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.equals(Object)", "int PedersenHash.hashCode()"})
  public void testPedersenHashEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PedersenHash.getDefaultInstance(), "Different type to PedersenHash");
  }

  /**
   * Test PedersenHash {@link PedersenHash#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PedersenHash#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.getDefaultInstanceForType()"})
  public void testPedersenHashGetDefaultInstanceForType() {
    // Arrange
    PedersenHash defaultInstance = PedersenHash.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#getDescriptor()}.
   * <p>
   * Method under test: {@link PedersenHash#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor PedersenHash.getDescriptor()"})
  public void testPedersenHashGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = PedersenHash.getDescriptor();

    // Assert
    assertEquals("PedersenHash", actualDescriptor.getName());
    assertEquals("protocol.PedersenHash", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test PedersenHash {@link PedersenHash#getSerializedSize()}.
   * <p>
   * Method under test: {@link PedersenHash#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PedersenHash.getSerializedSize()"})
  public void testPedersenHashGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PedersenHash.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test PedersenHash {@link PedersenHash#isInitialized()}.
   * <p>
   * Method under test: {@link PedersenHash#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PedersenHash.isInitialized()"})
  public void testPedersenHashIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PedersenHash.getDefaultInstance().isInitialized());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream)"})
  public void testPedersenHashParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PedersenHash actualParseDelimitedFromResult = PedersenHash.parseDelimitedFrom(input);

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
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream)"})
  public void testPedersenHashParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PedersenHash.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PedersenHash actualParseDelimitedFromResult = PedersenHash.parseDelimitedFrom(input,
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
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream)"})
  public void testPedersenHashParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PedersenHash.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseDelimitedFrom(InputStream)"})
  public void testPedersenHashParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PedersenHash.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(byte[])"})
  public void testPedersenHashParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(ByteBuffer)"})
  public void testPedersenHashParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(ByteString)"})
  public void testPedersenHashParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(data);

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
    ByteString expectedContent = data.EMPTY;
    assertSame(expectedContent, actualParseFromResult.getContent());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

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
    ByteString expectedContent = data.EMPTY;
    assertSame(expectedContent, actualParseFromResult.getContent());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(CodedInputStream)"})
  public void testPedersenHashParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(input);

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
   * Test PedersenHash {@link PedersenHash#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

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
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream)"})
  public void testPedersenHashParseFromWithInputStream() throws IOException {
    // Arrange and Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testPedersenHashParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream)"})
  public void testPedersenHashParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PedersenHash.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream)"})
  public void testPedersenHashParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PedersenHash.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test PedersenHash {@link PedersenHash#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PedersenHash#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PedersenHash.parseFrom(InputStream)"})
  public void testPedersenHashParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PedersenHash actualParseFromResult = PedersenHash.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test PedersenHash_Builder {@link PedersenHash.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link PedersenHash.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor PedersenHash.Builder.getDescriptor()"})
  public void testPedersenHash_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = PedersenHash.Builder.getDescriptor();

    // Assert
    assertEquals("PedersenHash", actualDescriptor.getName());
    assertEquals("protocol.PedersenHash", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#equals(Object)}, and {@link ReceiveDescription#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReceiveDescription#equals(Object)}
   *   <li>{@link ReceiveDescription#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.equals(Object)", "int ReceiveDescription.hashCode()"})
  public void testReceiveDescriptionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReceiveDescription defaultInstance = ReceiveDescription.getDefaultInstance();
    ReceiveDescription defaultInstance2 = ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#equals(Object)}, and {@link ReceiveDescription#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReceiveDescription#equals(Object)}
   *   <li>{@link ReceiveDescription#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.equals(Object)", "int ReceiveDescription.hashCode()"})
  public void testReceiveDescriptionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReceiveDescription defaultInstance = ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.equals(Object)", "int ReceiveDescription.hashCode()"})
  public void testReceiveDescriptionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReceiveDescription.getDefaultInstance(), 1);
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.equals(Object)", "int ReceiveDescription.hashCode()"})
  public void testReceiveDescriptionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReceiveDescription.getDefaultInstance(), null);
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.equals(Object)", "int ReceiveDescription.hashCode()"})
  public void testReceiveDescriptionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ReceiveDescription.getDefaultInstance(), "Different type to ReceiveDescription");
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ReceiveDescription#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.getDefaultInstanceForType()"})
  public void testReceiveDescriptionGetDefaultInstanceForType() {
    // Arrange
    ReceiveDescription defaultInstance = ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#getDescriptor()}.
   * <p>
   * Method under test: {@link ReceiveDescription#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ReceiveDescription.getDescriptor()"})
  public void testReceiveDescriptionGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ReceiveDescription.getDescriptor();

    // Assert
    assertEquals("ReceiveDescription", actualDescriptor.getName());
    assertEquals("protocol.ReceiveDescription", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.START_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#getSerializedSize()}.
   * <p>
   * Method under test: {@link ReceiveDescription#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReceiveDescription.getSerializedSize()"})
  public void testReceiveDescriptionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ReceiveDescription.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#isInitialized()}.
   * <p>
   * Method under test: {@link ReceiveDescription#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiveDescription.isInitialized()"})
  public void testReceiveDescriptionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ReceiveDescription.getDefaultInstance().isInitialized());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream)"})
  public void testReceiveDescriptionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ReceiveDescription actualParseDelimitedFromResult = ReceiveDescription.parseDelimitedFrom(input);

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
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream)"})
  public void testReceiveDescriptionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ReceiveDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ReceiveDescription actualParseDelimitedFromResult = ReceiveDescription.parseDelimitedFrom(input,
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
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream)"})
  public void testReceiveDescriptionParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ReceiveDescription.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseDelimitedFrom(InputStream)"})
  public void testReceiveDescriptionParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ReceiveDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(byte[])"})
  public void testReceiveDescriptionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(ByteBuffer)"})
  public void testReceiveDescriptionParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(data,
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
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(new byte[]{},
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
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(ByteString)"})
  public void testReceiveDescriptionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(data);

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
    assertSame(byteString, actualParseFromResult.getCEnc());
    assertSame(byteString, actualParseFromResult.getCOut());
    assertSame(byteString, actualParseFromResult.getEpk());
    assertSame(byteString, actualParseFromResult.getNoteCommitment());
    assertSame(byteString, actualParseFromResult.getValueCommitment());
    assertSame(byteString, actualParseFromResult.getZkproof());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(data,
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
    assertSame(byteString, actualParseFromResult.getCEnc());
    assertSame(byteString, actualParseFromResult.getCOut());
    assertSame(byteString, actualParseFromResult.getEpk());
    assertSame(byteString, actualParseFromResult.getNoteCommitment());
    assertSame(byteString, actualParseFromResult.getValueCommitment());
    assertSame(byteString, actualParseFromResult.getZkproof());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(CodedInputStream)"})
  public void testReceiveDescriptionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(input);

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
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(input,
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
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream)"})
  public void testReceiveDescriptionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream)"})
  public void testReceiveDescriptionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ReceiveDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom(input,
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
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ReceiveDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testReceiveDescriptionParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ReceiveDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream)"})
  public void testReceiveDescriptionParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ReceiveDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ReceiveDescription {@link ReceiveDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescription.parseFrom(InputStream)"})
  public void testReceiveDescriptionParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ReceiveDescription actualParseFromResult = ReceiveDescription.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ReceiveDescription_Builder {@link ReceiveDescription.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ReceiveDescription.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ReceiveDescription.Builder.getDescriptor()"})
  public void testReceiveDescription_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ReceiveDescription.Builder.getDescriptor();

    // Assert
    assertEquals("ReceiveDescription", actualDescriptor.getName());
    assertEquals("protocol.ReceiveDescription", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.START_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#equals(Object)}, and {@link ShieldedTransferContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldedTransferContract#equals(Object)}
   *   <li>{@link ShieldedTransferContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.equals(Object)", "int ShieldedTransferContract.hashCode()"})
  public void testShieldedTransferContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldedTransferContract defaultInstance = ShieldedTransferContract.getDefaultInstance();
    ShieldedTransferContract defaultInstance2 = ShieldedTransferContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#equals(Object)}, and {@link ShieldedTransferContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldedTransferContract#equals(Object)}
   *   <li>{@link ShieldedTransferContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.equals(Object)", "int ShieldedTransferContract.hashCode()"})
  public void testShieldedTransferContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldedTransferContract defaultInstance = ShieldedTransferContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.equals(Object)", "int ShieldedTransferContract.hashCode()"})
  public void testShieldedTransferContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldedTransferContract.getDefaultInstance(), 1);
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.equals(Object)", "int ShieldedTransferContract.hashCode()"})
  public void testShieldedTransferContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldedTransferContract.getDefaultInstance(), null);
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.equals(Object)", "int ShieldedTransferContract.hashCode()"})
  public void testShieldedTransferContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldedTransferContract.getDefaultInstance(), "Different type to ShieldedTransferContract");
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.getDefaultInstanceForType()"})
  public void testShieldedTransferContractGetDefaultInstanceForType() {
    // Arrange
    ShieldedTransferContract defaultInstance = ShieldedTransferContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ShieldedTransferContract.getDescriptor()"})
  public void testShieldedTransferContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ShieldedTransferContract.getDescriptor();

    // Assert
    assertEquals("ShieldedTransferContract", actualDescriptor.getName());
    assertEquals("protocol.ShieldedTransferContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(7, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.END_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#getReceiveDescriptionCount()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#getReceiveDescriptionCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ShieldedTransferContract.getReceiveDescriptionCount()"})
  public void testShieldedTransferContractGetReceiveDescriptionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldedTransferContract.getDefaultInstance().getReceiveDescriptionCount());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ShieldedTransferContract.getSerializedSize()"})
  public void testShieldedTransferContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldedTransferContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#getSpendDescriptionCount()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#getSpendDescriptionCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ShieldedTransferContract.getSpendDescriptionCount()"})
  public void testShieldedTransferContractGetSpendDescriptionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldedTransferContract.getDefaultInstance().getSpendDescriptionCount());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#isInitialized()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ShieldedTransferContract.isInitialized()"})
  public void testShieldedTransferContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldedTransferContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream)"})
  public void testShieldedTransferContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ShieldedTransferContract actualParseDelimitedFromResult = ShieldedTransferContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseDelimitedFromResult.getFromAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getToAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseDelimitedFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getSpendDescriptionOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream)"})
  public void testShieldedTransferContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldedTransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ShieldedTransferContract actualParseDelimitedFromResult = ShieldedTransferContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseDelimitedFromResult.getFromAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getToAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseDelimitedFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseDelimitedFromResult.getSpendDescriptionOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldedTransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldedTransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldedTransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream)"})
  public void testShieldedTransferContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldedTransferContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseDelimitedFrom(InputStream)"})
  public void testShieldedTransferContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldedTransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(byte[])"})
  public void testShieldedTransferContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseFromResult.getFromAmount());
    assertEquals(0L, actualParseFromResult.getToAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionOrBuilderList());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(ByteBuffer)"})
  public void testShieldedTransferContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseFromResult.getFromAmount());
    assertEquals(0L, actualParseFromResult.getToAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionOrBuilderList());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseFromResult.getFromAmount());
    assertEquals(0L, actualParseFromResult.getToAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionOrBuilderList());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseFromResult.getFromAmount());
    assertEquals(0L, actualParseFromResult.getToAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionOrBuilderList());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream)"})
  public void testShieldedTransferContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream)"})
  public void testShieldedTransferContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldedTransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getReceiveDescriptionCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSpendDescriptionCount());
    assertEquals(0L, actualParseFromResult.getFromAmount());
    assertEquals(0L, actualParseFromResult.getToAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ReceiveDescription> receiveDescriptionList = actualParseFromResult.getReceiveDescriptionList();
    assertTrue(receiveDescriptionList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(receiveDescriptionList, actualParseFromResult.getReceiveDescriptionOrBuilderList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionList());
    assertSame(receiveDescriptionList, actualParseFromResult.getSpendDescriptionOrBuilderList());
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldedTransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testShieldedTransferContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldedTransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream)"})
  public void testShieldedTransferContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldedTransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ShieldedTransferContract {@link ShieldedTransferContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldedTransferContract ShieldedTransferContract.parseFrom(InputStream)"})
  public void testShieldedTransferContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ShieldedTransferContract actualParseFromResult = ShieldedTransferContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ShieldedTransferContract_Builder {@link ShieldedTransferContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ShieldedTransferContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ShieldedTransferContract.Builder.getDescriptor()"})
  public void testShieldedTransferContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ShieldedTransferContract.Builder.getDescriptor();

    // Assert
    assertEquals("ShieldedTransferContract", actualDescriptor.getName());
    assertEquals("protocol.ShieldedTransferContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(7, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.END_TIME_FIELD_NUMBER, actualDescriptor.getIndex());
  }

  /**
   * Test SpendDescription {@link SpendDescription#equals(Object)}, and {@link SpendDescription#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SpendDescription#equals(Object)}
   *   <li>{@link SpendDescription#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.equals(Object)", "int SpendDescription.hashCode()"})
  public void testSpendDescriptionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SpendDescription defaultInstance = SpendDescription.getDefaultInstance();
    SpendDescription defaultInstance2 = SpendDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SpendDescription {@link SpendDescription#equals(Object)}, and {@link SpendDescription#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SpendDescription#equals(Object)}
   *   <li>{@link SpendDescription#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.equals(Object)", "int SpendDescription.hashCode()"})
  public void testSpendDescriptionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SpendDescription defaultInstance = SpendDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SpendDescription {@link SpendDescription#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.equals(Object)", "int SpendDescription.hashCode()"})
  public void testSpendDescriptionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SpendDescription.getDefaultInstance(), 1);
  }

  /**
   * Test SpendDescription {@link SpendDescription#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.equals(Object)", "int SpendDescription.hashCode()"})
  public void testSpendDescriptionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SpendDescription.getDefaultInstance(), null);
  }

  /**
   * Test SpendDescription {@link SpendDescription#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.equals(Object)", "int SpendDescription.hashCode()"})
  public void testSpendDescriptionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SpendDescription.getDefaultInstance(), "Different type to SpendDescription");
  }

  /**
   * Test SpendDescription {@link SpendDescription#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SpendDescription#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.getDefaultInstanceForType()"})
  public void testSpendDescriptionGetDefaultInstanceForType() {
    // Arrange
    SpendDescription defaultInstance = SpendDescription.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription {@link SpendDescription#getDescriptor()}.
   * <p>
   * Method under test: {@link SpendDescription#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SpendDescription.getDescriptor()"})
  public void testSpendDescriptionGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SpendDescription.getDescriptor();

    // Assert
    assertEquals("SpendDescription", actualDescriptor.getName());
    assertEquals("protocol.SpendDescription", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getFields().size());
    assertEquals(8, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SpendDescription {@link SpendDescription#getSerializedSize()}.
   * <p>
   * Method under test: {@link SpendDescription#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SpendDescription.getSerializedSize()"})
  public void testSpendDescriptionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SpendDescription.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SpendDescription {@link SpendDescription#isInitialized()}.
   * <p>
   * Method under test: {@link SpendDescription#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpendDescription.isInitialized()"})
  public void testSpendDescriptionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SpendDescription.getDefaultInstance().isInitialized());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream)"})
  public void testSpendDescriptionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SpendDescription actualParseDelimitedFromResult = SpendDescription.parseDelimitedFrom(input);

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
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream)"})
  public void testSpendDescriptionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SpendDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SpendDescription actualParseDelimitedFromResult = SpendDescription.parseDelimitedFrom(input,
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
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream)"})
  public void testSpendDescriptionParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SpendDescription.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseDelimitedFrom(InputStream)"})
  public void testSpendDescriptionParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SpendDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(byte[])"})
  public void testSpendDescriptionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(ByteBuffer)"})
  public void testSpendDescriptionParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(new byte[]{},
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
   * Test SpendDescription {@link SpendDescription#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(ByteString)"})
  public void testSpendDescriptionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(data);

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
    assertSame(byteString, actualParseFromResult.getAnchor());
    assertSame(byteString, actualParseFromResult.getNullifier());
    assertSame(byteString, actualParseFromResult.getRk());
    assertSame(byteString, actualParseFromResult.getSpendAuthoritySignature());
    assertSame(byteString, actualParseFromResult.getValueCommitment());
    assertSame(byteString, actualParseFromResult.getZkproof());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

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
    assertSame(byteString, actualParseFromResult.getAnchor());
    assertSame(byteString, actualParseFromResult.getNullifier());
    assertSame(byteString, actualParseFromResult.getRk());
    assertSame(byteString, actualParseFromResult.getSpendAuthoritySignature());
    assertSame(byteString, actualParseFromResult.getValueCommitment());
    assertSame(byteString, actualParseFromResult.getZkproof());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(CodedInputStream)"})
  public void testSpendDescriptionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(input);

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
   * Test SpendDescription {@link SpendDescription#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(input,
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
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream)"})
  public void testSpendDescriptionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream)"})
  public void testSpendDescriptionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SpendDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom(input,
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
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SpendDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSpendDescriptionParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SpendDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream)"})
  public void testSpendDescriptionParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SpendDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SpendDescription {@link SpendDescription#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescription#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescription.parseFrom(InputStream)"})
  public void testSpendDescriptionParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SpendDescription actualParseFromResult = SpendDescription.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SpendDescription_Builder {@link SpendDescription.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link SpendDescription.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SpendDescription.Builder.getDescriptor()"})
  public void testSpendDescription_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SpendDescription.Builder.getDescriptor();

    // Assert
    assertEquals("SpendDescription", actualDescriptor.getName());
    assertEquals("protocol.SpendDescription", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(6, actualDescriptor.getFields().size());
    assertEquals(8, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }
}
