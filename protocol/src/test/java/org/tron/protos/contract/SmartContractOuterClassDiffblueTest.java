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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
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
import org.tron.protos.contract.SmartContractOuterClass.ClearABIContract;
import org.tron.protos.contract.SmartContractOuterClass.ClearABIContract.Builder;
import org.tron.protos.contract.SmartContractOuterClass.ContractState;
import org.tron.protos.contract.SmartContractOuterClass.CreateSmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry.EntryType;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry.Param;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry.StateMutabilityType;
import org.tron.protos.contract.SmartContractOuterClass.SmartContractDataWrapper;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateEnergyLimitContract;
import org.tron.protos.contract.SmartContractOuterClass.UpdateSettingContract;

public class SmartContractOuterClassDiffblueTest {
  /**
   * Test ClearABIContract {@link ClearABIContract#equals(Object)}, and {@link ClearABIContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClearABIContract#equals(Object)}
   *   <li>{@link ClearABIContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.equals(Object)", "int ClearABIContract.hashCode()"})
  public void testClearABIContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClearABIContract defaultInstance = ClearABIContract.getDefaultInstance();
    ClearABIContract defaultInstance2 = ClearABIContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#equals(Object)}, and {@link ClearABIContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClearABIContract#equals(Object)}
   *   <li>{@link ClearABIContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.equals(Object)", "int ClearABIContract.hashCode()"})
  public void testClearABIContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClearABIContract defaultInstance = ClearABIContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.equals(Object)", "int ClearABIContract.hashCode()"})
  public void testClearABIContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClearABIContract.getDefaultInstance(), 1);
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.equals(Object)", "int ClearABIContract.hashCode()"})
  public void testClearABIContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClearABIContract.getDefaultInstance(), null);
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.equals(Object)", "int ClearABIContract.hashCode()"})
  public void testClearABIContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClearABIContract.getDefaultInstance(), "Different type to ClearABIContract");
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ClearABIContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.getDefaultInstanceForType()"})
  public void testClearABIContractGetDefaultInstanceForType() {
    // Arrange
    ClearABIContract defaultInstance = ClearABIContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ClearABIContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ClearABIContract.getDescriptor()"})
  public void testClearABIContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ClearABIContract.getDescriptor();

    // Assert
    assertEquals("ClearABIContract", actualDescriptor.getName());
    assertEquals("protocol.ClearABIContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ClearABIContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ClearABIContract.getSerializedSize()"})
  public void testClearABIContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ClearABIContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#isInitialized()}.
   * <p>
   * Method under test: {@link ClearABIContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClearABIContract.isInitialized()"})
  public void testClearABIContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ClearABIContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream)"})
  public void testClearABIContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClearABIContract actualParseDelimitedFromResult = ClearABIContract.parseDelimitedFrom(input);

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
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream)"})
  public void testClearABIContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClearABIContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClearABIContract actualParseDelimitedFromResult = ClearABIContract.parseDelimitedFrom(input,
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
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ClearABIContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClearABIContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClearABIContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream)"})
  public void testClearABIContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClearABIContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseDelimitedFrom(InputStream)"})
  public void testClearABIContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ClearABIContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(byte[])"})
  public void testClearABIContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(ByteBuffer)"})
  public void testClearABIContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(new byte[]{},
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
   * Test ClearABIContract {@link ClearABIContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(ByteString)"})
  public void testClearABIContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(data);

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
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

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
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(CodedInputStream)"})
  public void testClearABIContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(input);

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
   * Test ClearABIContract {@link ClearABIContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(input,
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
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream)"})
  public void testClearABIContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream)"})
  public void testClearABIContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClearABIContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom(input,
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
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClearABIContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testClearABIContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClearABIContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream)"})
  public void testClearABIContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClearABIContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClearABIContract {@link ClearABIContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClearABIContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClearABIContract ClearABIContract.parseFrom(InputStream)"})
  public void testClearABIContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ClearABIContract actualParseFromResult = ClearABIContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClearABIContract_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testClearABIContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("ClearABIContract", actualDescriptor.getName());
    assertEquals("protocol.ClearABIContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getFields().size());
    assertEquals(4, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ContractState {@link ContractState#equals(Object)}, and {@link ContractState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContractState#equals(Object)}
   *   <li>{@link ContractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.equals(Object)", "int ContractState.hashCode()"})
  public void testContractStateEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ContractState defaultInstance = ContractState.getDefaultInstance();
    ContractState defaultInstance2 = ContractState.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ContractState {@link ContractState#equals(Object)}, and {@link ContractState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContractState#equals(Object)}
   *   <li>{@link ContractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.equals(Object)", "int ContractState.hashCode()"})
  public void testContractStateEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ContractState defaultInstance = ContractState.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ContractState {@link ContractState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.equals(Object)", "int ContractState.hashCode()"})
  public void testContractStateEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContractState.getDefaultInstance(), 1);
  }

  /**
   * Test ContractState {@link ContractState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.equals(Object)", "int ContractState.hashCode()"})
  public void testContractStateEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContractState.getDefaultInstance(), null);
  }

  /**
   * Test ContractState {@link ContractState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.equals(Object)", "int ContractState.hashCode()"})
  public void testContractStateEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ContractState.getDefaultInstance(), "Different type to ContractState");
  }

  /**
   * Test ContractState {@link ContractState#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ContractState#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.getDefaultInstanceForType()"})
  public void testContractStateGetDefaultInstanceForType() {
    // Arrange
    ContractState defaultInstance = ContractState.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#getDescriptor()}.
   * <p>
   * Method under test: {@link ContractState#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ContractState.getDescriptor()"})
  public void testContractStateGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ContractState.getDescriptor();

    // Assert
    assertEquals("ContractState", actualDescriptor.getName());
    assertEquals("protocol.ContractState", actualDescriptor.getFullName());
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
   * Test ContractState {@link ContractState#getSerializedSize()}.
   * <p>
   * Method under test: {@link ContractState#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ContractState.getSerializedSize()"})
  public void testContractStateGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ContractState.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ContractState {@link ContractState#isInitialized()}.
   * <p>
   * Method under test: {@link ContractState#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractState.isInitialized()"})
  public void testContractStateIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ContractState.getDefaultInstance().isInitialized());
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream)"})
  public void testContractStateParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ContractState actualParseDelimitedFromResult = ContractState.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getEnergyFactor());
    assertEquals(0L, actualParseDelimitedFromResult.getEnergyUsage());
    assertEquals(0L, actualParseDelimitedFromResult.getUpdateCycle());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream)"})
  public void testContractStateParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ContractState.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ContractState actualParseDelimitedFromResult = ContractState.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getEnergyFactor());
    assertEquals(0L, actualParseDelimitedFromResult.getEnergyUsage());
    assertEquals(0L, actualParseDelimitedFromResult.getUpdateCycle());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ContractState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ContractState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ContractState.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream)"})
  public void testContractStateParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ContractState.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ContractState {@link ContractState#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseDelimitedFrom(InputStream)"})
  public void testContractStateParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ContractState.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(byte[])"})
  public void testContractStateParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ContractState actualParseFromResult = ContractState.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(ByteBuffer)"})
  public void testContractStateParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ContractState actualParseFromResult = ContractState.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testContractStateParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ContractState actualParseFromResult = ContractState.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(ByteString)"})
  public void testContractStateParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(CodedInputStream)"})
  public void testContractStateParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream)"})
  public void testContractStateParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ContractState actualParseFromResult = ContractState.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream)"})
  public void testContractStateParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ContractState.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ContractState actualParseFromResult = ContractState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getEnergyFactor());
    assertEquals(0L, actualParseFromResult.getEnergyUsage());
    assertEquals(0L, actualParseFromResult.getUpdateCycle());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ContractState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testContractStateParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ContractState.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream)"})
  public void testContractStateParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ContractState.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ContractState {@link ContractState#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractState#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractState.parseFrom(InputStream)"})
  public void testContractStateParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ContractState actualParseFromResult = ContractState.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ContractState_Builder {@link ContractState.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ContractState.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ContractState.Builder.getDescriptor()"})
  public void testContractState_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ContractState.Builder.getDescriptor();

    // Assert
    assertEquals("ContractState", actualDescriptor.getName());
    assertEquals("protocol.ContractState", actualDescriptor.getFullName());
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
   * Test CreateSmartContract {@link CreateSmartContract#equals(Object)}, and {@link CreateSmartContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreateSmartContract#equals(Object)}
   *   <li>{@link CreateSmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.equals(Object)", "int CreateSmartContract.hashCode()"})
  public void testCreateSmartContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CreateSmartContract defaultInstance = CreateSmartContract.getDefaultInstance();
    CreateSmartContract defaultInstance2 = CreateSmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#equals(Object)}, and {@link CreateSmartContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreateSmartContract#equals(Object)}
   *   <li>{@link CreateSmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.equals(Object)", "int CreateSmartContract.hashCode()"})
  public void testCreateSmartContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CreateSmartContract defaultInstance = CreateSmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.equals(Object)", "int CreateSmartContract.hashCode()"})
  public void testCreateSmartContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreateSmartContract.getDefaultInstance(), 1);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.equals(Object)", "int CreateSmartContract.hashCode()"})
  public void testCreateSmartContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreateSmartContract.getDefaultInstance(), null);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.equals(Object)", "int CreateSmartContract.hashCode()"})
  public void testCreateSmartContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreateSmartContract.getDefaultInstance(), "Different type to CreateSmartContract");
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link CreateSmartContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.getDefaultInstanceForType()"})
  public void testCreateSmartContractGetDefaultInstanceForType() {
    // Arrange
    CreateSmartContract defaultInstance = CreateSmartContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#getDescriptor()}.
   * <p>
   * Method under test: {@link CreateSmartContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor CreateSmartContract.getDescriptor()"})
  public void testCreateSmartContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = CreateSmartContract.getDescriptor();

    // Assert
    assertEquals("CreateSmartContract", actualDescriptor.getName());
    assertEquals("protocol.CreateSmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#getNewContract()}.
   * <p>
   * Method under test: {@link CreateSmartContract#getNewContract()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract CreateSmartContract.getNewContract()"})
  public void testCreateSmartContractGetNewContract() {
    // Arrange and Act
    SmartContract actualNewContract = CreateSmartContract.getDefaultInstance().getNewContract();

    // Assert
    assertEquals("", actualNewContract.getInitializationErrorString());
    assertEquals("", actualNewContract.getName());
    assertEquals(0, actualNewContract.getSerializedSize());
    assertEquals(0, actualNewContract.getVersion());
    assertEquals(0L, actualNewContract.getCallValue());
    assertEquals(0L, actualNewContract.getConsumeUserResourcePercent());
    assertEquals(0L, actualNewContract.getOriginEnergyLimit());
    assertFalse(actualNewContract.hasAbi());
    assertTrue(actualNewContract.findInitializationErrors().isEmpty());
    assertTrue(actualNewContract.getAllFields().isEmpty());
    assertTrue(actualNewContract.isInitialized());
    assertSame(actualNewContract, actualNewContract.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link CreateSmartContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CreateSmartContract.getSerializedSize()"})
  public void testCreateSmartContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, CreateSmartContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#hasNewContract()}.
   * <p>
   * Method under test: {@link CreateSmartContract#hasNewContract()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.hasNewContract()"})
  public void testCreateSmartContractHasNewContract() {
    // Arrange, Act and Assert
    assertFalse(CreateSmartContract.getDefaultInstance().hasNewContract());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#isInitialized()}.
   * <p>
   * Method under test: {@link CreateSmartContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreateSmartContract.isInitialized()"})
  public void testCreateSmartContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(CreateSmartContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream)"})
  public void testCreateSmartContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    CreateSmartContract actualParseDelimitedFromResult = CreateSmartContract.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(4, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    SmartContract newContract = actualParseDelimitedFromResult.getNewContract();
    assertSame(unknownFields, newContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(newContract, actualParseDelimitedFromResult.getNewContractOrBuilder());
    assertSame(newContract, newContract.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream)"})
  public void testCreateSmartContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> CreateSmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        CreateSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    CreateSmartContract actualParseDelimitedFromResult = CreateSmartContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(4, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    SmartContract newContract = actualParseDelimitedFromResult.getNewContract();
    assertSame(unknownFields, newContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(newContract, actualParseDelimitedFromResult.getNewContractOrBuilder());
    assertSame(newContract, newContract.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(CreateSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> CreateSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> CreateSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream)"})
  public void testCreateSmartContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(CreateSmartContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream)"})
  public void testCreateSmartContractParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, CreateSmartContract.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseDelimitedFrom(InputStream)"})
  public void testCreateSmartContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> CreateSmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(byte[])"})
  public void testCreateSmartContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteBuffer)"})
  public void testCreateSmartContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteString)"})
  public void testCreateSmartContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteString)"})
  public void testCreateSmartContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(CodedInputStream)"})
  public void testCreateSmartContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(CodedInputStream)"})
  public void testCreateSmartContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream)"})
  public void testCreateSmartContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    SmartContract newContract = actualParseFromResult.getNewContract();
    assertSame(unknownFields, newContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(newContract, actualParseFromResult.getNewContractOrBuilder());
    assertSame(newContract, newContract.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream)"})
  public void testCreateSmartContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> CreateSmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertFalse(actualParseFromResult.hasNewContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> CreateSmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testCreateSmartContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> CreateSmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream)"})
  public void testCreateSmartContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> CreateSmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test CreateSmartContract {@link CreateSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateSmartContract CreateSmartContract.parseFrom(InputStream)"})
  public void testCreateSmartContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    CreateSmartContract actualParseFromResult = CreateSmartContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    SmartContract newContract = actualParseFromResult.getNewContract();
    assertSame(unknownFields, newContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(newContract, actualParseFromResult.getNewContractOrBuilder());
    assertSame(newContract, newContract.getDefaultInstanceForType());
  }

  /**
   * Test CreateSmartContract_Builder {@link CreateSmartContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link CreateSmartContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor CreateSmartContract.Builder.getDescriptor()"})
  public void testCreateSmartContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = CreateSmartContract.Builder.getDescriptor();

    // Assert
    assertEquals("CreateSmartContract", actualDescriptor.getName());
    assertEquals("protocol.CreateSmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#equals(Object)}, and {@link SmartContractDataWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmartContractDataWrapper#equals(Object)}
   *   <li>{@link SmartContractDataWrapper#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.equals(Object)", "int SmartContractDataWrapper.hashCode()"})
  public void testSmartContractDataWrapperEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmartContractDataWrapper defaultInstance = SmartContractDataWrapper.getDefaultInstance();
    SmartContractDataWrapper defaultInstance2 = SmartContractDataWrapper.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#equals(Object)}, and {@link SmartContractDataWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmartContractDataWrapper#equals(Object)}
   *   <li>{@link SmartContractDataWrapper#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.equals(Object)", "int SmartContractDataWrapper.hashCode()"})
  public void testSmartContractDataWrapperEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmartContractDataWrapper defaultInstance = SmartContractDataWrapper.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.equals(Object)", "int SmartContractDataWrapper.hashCode()"})
  public void testSmartContractDataWrapperEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContractDataWrapper.getDefaultInstance(), 1);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.equals(Object)", "int SmartContractDataWrapper.hashCode()"})
  public void testSmartContractDataWrapperEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContractDataWrapper.getDefaultInstance(), null);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.equals(Object)", "int SmartContractDataWrapper.hashCode()"})
  public void testSmartContractDataWrapperEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContractDataWrapper.getDefaultInstance(), "Different type to SmartContractDataWrapper");
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#getContractState()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#getContractState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState SmartContractDataWrapper.getContractState()"})
  public void testSmartContractDataWrapperGetContractState() {
    // Arrange and Act
    ContractState actualContractState = SmartContractDataWrapper.getDefaultInstance().getContractState();

    // Assert
    assertEquals("", actualContractState.getInitializationErrorString());
    assertEquals(0, actualContractState.getSerializedSize());
    assertEquals(0L, actualContractState.getEnergyFactor());
    assertEquals(0L, actualContractState.getEnergyUsage());
    assertEquals(0L, actualContractState.getUpdateCycle());
    assertTrue(actualContractState.findInitializationErrors().isEmpty());
    assertTrue(actualContractState.getAllFields().isEmpty());
    assertTrue(actualContractState.isInitialized());
    assertSame(actualContractState, actualContractState.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.getDefaultInstanceForType()"})
  public void testSmartContractDataWrapperGetDefaultInstanceForType() {
    // Arrange
    SmartContractDataWrapper defaultInstance = SmartContractDataWrapper.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#getDescriptor()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SmartContractDataWrapper.getDescriptor()"})
  public void testSmartContractDataWrapperGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SmartContractDataWrapper.getDescriptor();

    // Assert
    assertEquals("SmartContractDataWrapper", actualDescriptor.getName());
    assertEquals("protocol.SmartContractDataWrapper", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#getSerializedSize()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SmartContractDataWrapper.getSerializedSize()"})
  public void testSmartContractDataWrapperGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SmartContractDataWrapper.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#getSmartContract()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#getSmartContract()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContractDataWrapper.getSmartContract()"})
  public void testSmartContractDataWrapperGetSmartContract() {
    // Arrange and Act
    SmartContract actualSmartContract = SmartContractDataWrapper.getDefaultInstance().getSmartContract();

    // Assert
    assertEquals("", actualSmartContract.getInitializationErrorString());
    assertEquals("", actualSmartContract.getName());
    assertEquals(0, actualSmartContract.getSerializedSize());
    assertEquals(0, actualSmartContract.getVersion());
    assertEquals(0L, actualSmartContract.getCallValue());
    assertEquals(0L, actualSmartContract.getConsumeUserResourcePercent());
    assertEquals(0L, actualSmartContract.getOriginEnergyLimit());
    assertFalse(actualSmartContract.hasAbi());
    assertTrue(actualSmartContract.findInitializationErrors().isEmpty());
    assertTrue(actualSmartContract.getAllFields().isEmpty());
    assertTrue(actualSmartContract.isInitialized());
    assertSame(actualSmartContract, actualSmartContract.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#hasContractState()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#hasContractState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.hasContractState()"})
  public void testSmartContractDataWrapperHasContractState() {
    // Arrange, Act and Assert
    assertFalse(SmartContractDataWrapper.getDefaultInstance().hasContractState());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#hasSmartContract()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#hasSmartContract()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.hasSmartContract()"})
  public void testSmartContractDataWrapperHasSmartContract() {
    // Arrange, Act and Assert
    assertFalse(SmartContractDataWrapper.getDefaultInstance().hasSmartContract());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#isInitialized()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContractDataWrapper.isInitialized()"})
  public void testSmartContractDataWrapperIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SmartContractDataWrapper.getDefaultInstance().isInitialized());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, SmartContractDataWrapper.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContractDataWrapper actualParseDelimitedFromResult = SmartContractDataWrapper.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SmartContractDataWrapper.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, SmartContractDataWrapper.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry())
        .getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContractDataWrapper actualParseDelimitedFromResult = SmartContractDataWrapper.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SmartContractDataWrapper.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SmartContractDataWrapper.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SmartContractDataWrapper.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SmartContractDataWrapper.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseDelimitedFrom(InputStream)"})
  public void testSmartContractDataWrapperParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SmartContractDataWrapper.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(byte[])"})
  public void testSmartContractDataWrapperParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(ByteBuffer)"})
  public void testSmartContractDataWrapperParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(ByteString)"})
  public void testSmartContractDataWrapperParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRuntimecode = data.EMPTY;
    assertSame(expectedRuntimecode, actualParseFromResult.getRuntimecode());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedRuntimecode = data.EMPTY;
    assertSame(expectedRuntimecode, actualParseFromResult.getRuntimecode());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(CodedInputStream)"})
  public void testSmartContractDataWrapperParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SmartContractDataWrapper SmartContractDataWrapper.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream)"})
  public void testSmartContractDataWrapperParseFromWithInputStream() throws IOException {
    // Arrange and Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ContractState contractState = actualParseFromResult.getContractState();
    assertSame(unknownFields, contractState.getUnknownFields());
    SmartContract smartContract = actualParseFromResult.getSmartContract();
    assertSame(unknownFields, smartContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(contractState, contractState.getDefaultInstanceForType());
    assertSame(contractState, actualParseFromResult.getContractStateOrBuilder());
    assertSame(smartContract, smartContract.getDefaultInstanceForType());
    assertSame(smartContract, actualParseFromResult.getSmartContractOrBuilder());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream)"})
  public void testSmartContractDataWrapperParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SmartContractDataWrapper.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasContractState());
    assertFalse(actualParseFromResult.hasSmartContract());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SmartContractDataWrapper.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractDataWrapperParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SmartContractDataWrapper.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream)"})
  public void testSmartContractDataWrapperParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SmartContractDataWrapper.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContractDataWrapper {@link SmartContractDataWrapper#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContractDataWrapper#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContractDataWrapper SmartContractDataWrapper.parseFrom(InputStream)"})
  public void testSmartContractDataWrapperParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SmartContractDataWrapper actualParseFromResult = SmartContractDataWrapper.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ContractState contractState = actualParseFromResult.getContractState();
    assertSame(unknownFields, contractState.getUnknownFields());
    SmartContract smartContract = actualParseFromResult.getSmartContract();
    assertSame(unknownFields, smartContract.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(contractState, contractState.getDefaultInstanceForType());
    assertSame(contractState, actualParseFromResult.getContractStateOrBuilder());
    assertSame(smartContract, smartContract.getDefaultInstanceForType());
    assertSame(smartContract, actualParseFromResult.getSmartContractOrBuilder());
  }

  /**
   * Test SmartContractDataWrapper_Builder {@link SmartContractDataWrapper.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link SmartContractDataWrapper.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SmartContractDataWrapper.Builder.getDescriptor()"})
  public void testSmartContractDataWrapper_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SmartContractDataWrapper.Builder.getDescriptor();

    // Assert
    assertEquals("SmartContractDataWrapper", actualDescriptor.getName());
    assertEquals("protocol.SmartContractDataWrapper", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(7, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContract {@link SmartContract#equals(Object)}, and {@link SmartContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmartContract#equals(Object)}
   *   <li>{@link SmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.equals(Object)", "int SmartContract.hashCode()"})
  public void testSmartContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmartContract defaultInstance = SmartContract.getDefaultInstance();
    SmartContract defaultInstance2 = SmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SmartContract {@link SmartContract#equals(Object)}, and {@link SmartContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmartContract#equals(Object)}
   *   <li>{@link SmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.equals(Object)", "int SmartContract.hashCode()"})
  public void testSmartContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmartContract defaultInstance = SmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SmartContract {@link SmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.equals(Object)", "int SmartContract.hashCode()"})
  public void testSmartContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContract.getDefaultInstance(), 1);
  }

  /**
   * Test SmartContract {@link SmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.equals(Object)", "int SmartContract.hashCode()"})
  public void testSmartContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContract.getDefaultInstance(), null);
  }

  /**
   * Test SmartContract {@link SmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.equals(Object)", "int SmartContract.hashCode()"})
  public void testSmartContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SmartContract.getDefaultInstance(), "Different type to SmartContract");
  }

  /**
   * Test SmartContract {@link SmartContract#getAbi()}.
   * <p>
   * Method under test: {@link SmartContract#getAbi()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI SmartContract.getAbi()"})
  public void testSmartContractGetAbi() {
    // Arrange and Act
    ABI actualAbi = SmartContract.getDefaultInstance().getAbi();

    // Assert
    assertEquals("", actualAbi.getInitializationErrorString());
    assertEquals(0, actualAbi.getEntrysCount());
    assertEquals(0, actualAbi.getSerializedSize());
    assertTrue(actualAbi.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualAbi.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualAbi.getAllFields().isEmpty());
    assertTrue(actualAbi.isInitialized());
    assertSame(actualAbi, actualAbi.getDefaultInstanceForType());
    assertSame(entrysList, actualAbi.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract {@link SmartContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SmartContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.getDefaultInstanceForType()"})
  public void testSmartContractGetDefaultInstanceForType() {
    // Arrange
    SmartContract defaultInstance = SmartContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#getDescriptor()}.
   * <p>
   * Method under test: {@link SmartContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SmartContract.getDescriptor()"})
  public void testSmartContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SmartContract.getDescriptor();

    // Assert
    assertEquals("SmartContract", actualDescriptor.getName());
    assertEquals("protocol.SmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(SmartContract.VERSION_FIELD_NUMBER, actualDescriptor.getFields().size());
  }

  /**
   * Test SmartContract {@link SmartContract#getName()}.
   * <p>
   * Method under test: {@link SmartContract#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String SmartContract.getName()"})
  public void testSmartContractGetName() {
    // Arrange, Act and Assert
    assertEquals("", SmartContract.getDefaultInstance().getName());
  }

  /**
   * Test SmartContract {@link SmartContract#getNameBytes()}.
   * <p>
   * Method under test: {@link SmartContract#getNameBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SmartContract.getNameBytes()"})
  public void testSmartContractGetNameBytes() {
    // Arrange
    SmartContract defaultInstance = SmartContract.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, actualNameBytes);
    assertSame(byteString, defaultInstance.getBytecode());
    assertSame(byteString, defaultInstance.getCodeHash());
    assertSame(byteString, defaultInstance.getContractAddress());
    assertSame(byteString, defaultInstance.getOriginAddress());
    assertSame(byteString, defaultInstance.getTrxHash());
  }

  /**
   * Test SmartContract {@link SmartContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link SmartContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SmartContract.getSerializedSize()"})
  public void testSmartContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SmartContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SmartContract {@link SmartContract#hasAbi()}.
   * <p>
   * Method under test: {@link SmartContract#hasAbi()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.hasAbi()"})
  public void testSmartContractHasAbi() {
    // Arrange, Act and Assert
    assertFalse(SmartContract.getDefaultInstance().hasAbi());
  }

  /**
   * Test SmartContract {@link SmartContract#isInitialized()}.
   * <p>
   * Method under test: {@link SmartContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SmartContract.isInitialized()"})
  public void testSmartContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SmartContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContract actualParseDelimitedFromResult = SmartContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertEquals(65, actualParseDelimitedFromResult.getVersion());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContract actualParseDelimitedFromResult = SmartContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVersion());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput_thenReturnAllFieldsSizeIsOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContract actualParseDelimitedFromResult = SmartContract.parseDelimitedFrom(input);

    // Assert
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertEquals(65, actualParseDelimitedFromResult.getVersion());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SmartContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SmartContract actualParseDelimitedFromResult = SmartContract.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVersion());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseDelimitedFrom(InputStream)"})
  public void testSmartContractParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(byte[])"})
  public void testSmartContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(ByteBuffer)"})
  public void testSmartContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(ByteString)"})
  public void testSmartContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getBytecode());
    assertSame(byteString, actualParseFromResult.getCodeHash());
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOriginAddress());
    assertSame(byteString, actualParseFromResult.getTrxHash());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getBytecode());
    assertSame(byteString, actualParseFromResult.getCodeHash());
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOriginAddress());
    assertSame(byteString, actualParseFromResult.getTrxHash());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(CodedInputStream)"})
  public void testSmartContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream)"})
  public void testSmartContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ABI abi = actualParseFromResult.getAbi();
    assertSame(unknownFields, abi.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(abi, actualParseFromResult.getAbiOrBuilder());
    assertSame(abi, abi.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream)"})
  public void testSmartContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SmartContract actualParseFromResult = SmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVersion());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertFalse(actualParseFromResult.hasAbi());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream)"})
  public void testSmartContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract {@link SmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SmartContract SmartContract.parseFrom(InputStream)"})
  public void testSmartContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SmartContract actualParseFromResult = SmartContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ABI abi = actualParseFromResult.getAbi();
    assertSame(unknownFields, abi.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(abi, actualParseFromResult.getAbiOrBuilder());
    assertSame(abi, abi.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI {@link ABI#equals(Object)}, and {@link ABI#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI#equals(Object)}
   *   <li>{@link ABI#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.equals(Object)", "int ABI.hashCode()"})
  public void testSmartContract_ABIEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ABI defaultInstance = ABI.getDefaultInstance();
    ABI defaultInstance2 = ABI.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SmartContract_ABI {@link ABI#equals(Object)}, and {@link ABI#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI#equals(Object)}
   *   <li>{@link ABI#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.equals(Object)", "int ABI.hashCode()"})
  public void testSmartContract_ABIEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ABI defaultInstance = ABI.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SmartContract_ABI {@link ABI#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.equals(Object)", "int ABI.hashCode()"})
  public void testSmartContract_ABIEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ABI.getDefaultInstance(), 1);
  }

  /**
   * Test SmartContract_ABI {@link ABI#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.equals(Object)", "int ABI.hashCode()"})
  public void testSmartContract_ABIEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ABI.getDefaultInstance(), null);
  }

  /**
   * Test SmartContract_ABI {@link ABI#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.equals(Object)", "int ABI.hashCode()"})
  public void testSmartContract_ABIEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ABI.getDefaultInstance(), "Different type to ABI");
  }

  /**
   * Test SmartContract_ABI {@link ABI#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ABI#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.getDefaultInstanceForType()"})
  public void testSmartContract_ABIGetDefaultInstanceForType() {
    // Arrange
    ABI defaultInstance = ABI.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI {@link ABI#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.getDescriptor()"})
  public void testSmartContract_ABIGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ABI.getDescriptor();

    // Assert
    assertEquals("ABI", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContract_ABI {@link ABI#getEntrysCount()}.
   * <p>
   * Method under test: {@link ABI#getEntrysCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.getEntrysCount()"})
  public void testSmartContract_ABIGetEntrysCount() {
    // Arrange, Act and Assert
    assertEquals(0, ABI.getDefaultInstance().getEntrysCount());
  }

  /**
   * Test SmartContract_ABI {@link ABI#getSerializedSize()}.
   * <p>
   * Method under test: {@link ABI#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.getSerializedSize()"})
  public void testSmartContract_ABIGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ABI.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SmartContract_ABI {@link ABI#isInitialized()}.
   * <p>
   * Method under test: {@link ABI#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.isInitialized()"})
  public void testSmartContract_ABIIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ABI.getDefaultInstance().isInitialized());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABIParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ABI actualParseDelimitedFromResult = ABI.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getEntrysCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseDelimitedFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseDelimitedFromResult.getEntrysOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABIParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ABI.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ABI actualParseDelimitedFromResult = ABI.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getEntrysCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseDelimitedFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseDelimitedFromResult.getEntrysOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ABI.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ABI.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ABI.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABIParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ABI.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABIParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ABI.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ABI#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(byte[])"})
  public void testSmartContract_ABIParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ABI actualParseFromResult = ABI.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getEntrysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseFromResult.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ABI#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(ByteBuffer)"})
  public void testSmartContract_ABIParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ABI actualParseFromResult = ABI.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getEntrysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseFromResult.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ABI actualParseFromResult = ABI.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getEntrysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseFromResult.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ABI actualParseFromResult = ABI.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getEntrysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseFromResult.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream)"})
  public void testSmartContract_ABIParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ABI actualParseFromResult = ABI.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream)"})
  public void testSmartContract_ABIParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ABI.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ABI actualParseFromResult = ABI.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getEntrysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Entry> entrysList = actualParseFromResult.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(entrysList, actualParseFromResult.getEntrysOrBuilderList());
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ABI.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABIParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ABI.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream)"})
  public void testSmartContract_ABIParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ABI.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI {@link ABI#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI ABI.parseFrom(InputStream)"})
  public void testSmartContract_ABIParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ABI actualParseFromResult = ABI.parseFrom((InputStream) null);

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Builder {@link ABI.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.Builder.getDescriptor()"})
  public void testSmartContract_ABI_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ABI.Builder.getDescriptor();

    // Assert
    assertEquals("ABI", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#equals(Object)}, and {@link ABI.Entry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI.Entry#equals(Object)}
   *   <li>{@link ABI.Entry#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.equals(Object)", "int ABI.Entry.hashCode()"})
  public void testSmartContract_ABI_EntryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entry defaultInstance = Entry.getDefaultInstance();
    Entry defaultInstance2 = Entry.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#equals(Object)}, and {@link ABI.Entry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI.Entry#equals(Object)}
   *   <li>{@link ABI.Entry#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.equals(Object)", "int ABI.Entry.hashCode()"})
  public void testSmartContract_ABI_EntryEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Entry defaultInstance = Entry.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.equals(Object)", "int ABI.Entry.hashCode()"})
  public void testSmartContract_ABI_EntryEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Entry.getDefaultInstance(), 1);
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.equals(Object)", "int ABI.Entry.hashCode()"})
  public void testSmartContract_ABI_EntryEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Entry.getDefaultInstance(), null);
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.equals(Object)", "int ABI.Entry.hashCode()"})
  public void testSmartContract_ABI_EntryEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Entry.getDefaultInstance(), "Different type to Entry");
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ABI.Entry#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.getDefaultInstanceForType()"})
  public void testSmartContract_ABI_EntryGetDefaultInstanceForType() {
    // Arrange
    Entry defaultInstance = Entry.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.Entry.getDescriptor()"})
  public void testSmartContract_ABI_EntryGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Entry.getDescriptor();

    // Assert
    assertEquals("Entry", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(2, actualDescriptor.getEnumTypes().size());
    assertEquals(8, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getInputsCount()}.
   * <p>
   * Method under test: {@link ABI.Entry#getInputsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.getInputsCount()"})
  public void testSmartContract_ABI_EntryGetInputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Entry.getDefaultInstance().getInputsCount());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getName()}.
   * <p>
   * Method under test: {@link ABI.Entry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ABI.Entry.getName()"})
  public void testSmartContract_ABI_EntryGetName() {
    // Arrange, Act and Assert
    assertEquals("", Entry.getDefaultInstance().getName());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getNameBytes()}.
   * <p>
   * Method under test: {@link ABI.Entry#getNameBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ABI.Entry.getNameBytes()"})
  public void testSmartContract_ABI_EntryGetNameBytes() {
    // Arrange
    Entry defaultInstance = Entry.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualNameBytes);
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getOutputsCount()}.
   * <p>
   * Method under test: {@link ABI.Entry#getOutputsCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.getOutputsCount()"})
  public void testSmartContract_ABI_EntryGetOutputsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Entry.getDefaultInstance().getOutputsCount());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getSerializedSize()}.
   * <p>
   * Method under test: {@link ABI.Entry#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.getSerializedSize()"})
  public void testSmartContract_ABI_EntryGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Entry.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getStateMutability()}.
   * <p>
   * Method under test: {@link ABI.Entry#getStateMutability()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.getStateMutability()"})
  public void testSmartContract_ABI_EntryGetStateMutability() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.UnknownMutabilityType, Entry.getDefaultInstance().getStateMutability());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#getType()}.
   * <p>
   * Method under test: {@link ABI.Entry#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.getType()"})
  public void testSmartContract_ABI_EntryGetType() {
    // Arrange, Act and Assert
    assertEquals(EntryType.UnknownEntryType, Entry.getDefaultInstance().getType());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#isInitialized()}.
   * <p>
   * Method under test: {@link ABI.Entry#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.isInitialized()"})
  public void testSmartContract_ABI_EntryIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Entry.getDefaultInstance().isInitialized());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Entry actualParseDelimitedFromResult = Entry.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals(0, actualParseDelimitedFromResult.getInputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getOutputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(EntryType.UnknownEntryType, actualParseDelimitedFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseDelimitedFromResult.getStateMutability());
    assertFalse(actualParseDelimitedFromResult.getAnonymous());
    assertFalse(actualParseDelimitedFromResult.getConstant());
    assertFalse(actualParseDelimitedFromResult.getPayable());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseDelimitedFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseDelimitedFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Entry.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Entry.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Entry actualParseDelimitedFromResult = Entry.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals(0, actualParseDelimitedFromResult.getInputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getOutputsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(EntryType.UnknownEntryType, actualParseDelimitedFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseDelimitedFromResult.getStateMutability());
    assertFalse(actualParseDelimitedFromResult.getAnonymous());
    assertFalse(actualParseDelimitedFromResult.getConstant());
    assertFalse(actualParseDelimitedFromResult.getPayable());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseDelimitedFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseDelimitedFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsList());
    assertSame(inputsList, actualParseDelimitedFromResult.getOutputsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Entry.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Entry.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Entry.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Entry.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Entry.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Entry.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(byte[])"})
  public void testSmartContract_ABI_EntryParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Entry actualParseFromResult = Entry.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(EntryType.UnknownEntryType, actualParseFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseFromResult.getStateMutability());
    assertFalse(actualParseFromResult.getAnonymous());
    assertFalse(actualParseFromResult.getConstant());
    assertFalse(actualParseFromResult.getPayable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getOutputsOrBuilderList());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(ByteBuffer)"})
  public void testSmartContract_ABI_EntryParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Entry actualParseFromResult = Entry.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(EntryType.UnknownEntryType, actualParseFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseFromResult.getStateMutability());
    assertFalse(actualParseFromResult.getAnonymous());
    assertFalse(actualParseFromResult.getConstant());
    assertFalse(actualParseFromResult.getPayable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getOutputsOrBuilderList());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Entry actualParseFromResult = Entry.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(EntryType.UnknownEntryType, actualParseFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseFromResult.getStateMutability());
    assertFalse(actualParseFromResult.getAnonymous());
    assertFalse(actualParseFromResult.getConstant());
    assertFalse(actualParseFromResult.getPayable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getOutputsOrBuilderList());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Entry actualParseFromResult = Entry.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(EntryType.UnknownEntryType, actualParseFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseFromResult.getStateMutability());
    assertFalse(actualParseFromResult.getAnonymous());
    assertFalse(actualParseFromResult.getConstant());
    assertFalse(actualParseFromResult.getPayable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getOutputsOrBuilderList());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Entry actualParseFromResult = Entry.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Entry.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Entry actualParseFromResult = Entry.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals(0, actualParseFromResult.getInputsCount());
    assertEquals(0, actualParseFromResult.getOutputsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStateMutabilityValue());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(EntryType.UnknownEntryType, actualParseFromResult.getType());
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualParseFromResult.getStateMutability());
    assertFalse(actualParseFromResult.getAnonymous());
    assertFalse(actualParseFromResult.getConstant());
    assertFalse(actualParseFromResult.getPayable());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Param> inputsList = actualParseFromResult.getInputsList();
    assertTrue(inputsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(inputsList, actualParseFromResult.getInputsOrBuilderList());
    assertSame(inputsList, actualParseFromResult.getOutputsList());
    assertSame(inputsList, actualParseFromResult.getOutputsOrBuilderList());
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Entry.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Entry.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Entry.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry {@link ABI.Entry#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry ABI.Entry.parseFrom(InputStream)"})
  public void testSmartContract_ABI_EntryParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Entry actualParseFromResult = Entry.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Builder {@link ABI.Entry.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.Entry.Builder.getDescriptor()"})
  public void testSmartContract_ABI_Entry_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Entry.Builder.getDescriptor();

    // Assert
    assertEquals("Entry", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(2, actualDescriptor.getEnumTypes().size());
    assertEquals(8, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code UnknownEntryType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_thenReturnUnknownEntryType() {
    // Arrange, Act and Assert
    assertEquals(EntryType.UnknownEntryType, EntryType.forNumber(0));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code Receive}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenFive_thenReturnReceive() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Receive, EntryType.forNumber(5));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EntryType.forNumber(42));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code Fallback}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenFour_thenReturnFallback() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Fallback, EntryType.forNumber(4));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Constructor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenOne_thenReturnConstructor() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Constructor, EntryType.forNumber(1));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code Error}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenSix_thenReturnError() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Error, EntryType.forNumber(6));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code Event}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenThree_thenReturnEvent() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Event, EntryType.forNumber(3));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code Function}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeForNumber_whenTwo_thenReturnFunction() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Function, EntryType.forNumber(2));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ABI.Entry.EntryType.getDescriptor()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = EntryType.getDescriptor();

    // Assert
    assertEquals("EntryType", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.EntryType", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(7, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getDescriptorForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ABI.Entry.EntryType.getDescriptorForType()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = EntryType.UnknownEntryType.getDescriptorForType();

    // Assert
    assertEquals("EntryType", actualDescriptorForType.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.EntryType", actualDescriptorForType.getFullName());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(7, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getNumber()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.EntryType.getNumber()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetNumber_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, EntryType.UnknownEntryType.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getNumber()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.EntryType.getNumber()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetNumber_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EntryType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getValueDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ABI.Entry.EntryType.getValueDescriptor()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetValueDescriptor() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = EntryType.UnknownEntryType.getValueDescriptor();

    // Assert
    assertEquals("UnknownEntryType", actualValueDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.EntryType.UnknownEntryType", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#getValueDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ABI.Entry.EntryType.getValueDescriptor()"})
  public void testSmartContract_ABI_Entry_EntryTypeGetValueDescriptor2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> EntryType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AssetIssueContract.END_TIME_FIELD_NUMBER));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Constructor, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Function, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Event, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap5() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Fallback, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap6() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Receive, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap7() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.UnknownEntryType, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.EntryType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_EntryTypeInternalGetValueMap8() {
    // Arrange and Act
    EnumLiteMap<EntryType> actualInternalGetValueMapResult = EntryType.internalGetValueMap();

    // Assert
    assertEquals(EntryType.Error, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code Constructor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_thenReturnConstructor() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Constructor, EntryType.valueOf(1));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code Fallback}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_thenReturnFallback() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Fallback, EntryType.valueOf(4));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EntryType.valueOf(42));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code UnknownEntryType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_thenReturnUnknownEntryType() {
    // Arrange, Act and Assert
    assertEquals(EntryType.UnknownEntryType, EntryType.valueOf(0));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code Receive}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_whenFive_thenReturnReceive() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Receive, EntryType.valueOf(5));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code Error}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_whenSix_thenReturnError() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Error, EntryType.valueOf(6));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code Event}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_whenThree_thenReturnEvent() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Event, EntryType.valueOf(3));
  }

  /**
   * Test SmartContract_ABI_Entry_EntryType {@link ABI.Entry.EntryType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code Function}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.EntryType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.EntryType ABI.Entry.EntryType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_EntryTypeValueOfWithValue_whenTwo_thenReturnFunction() {
    // Arrange, Act and Assert
    assertEquals(EntryType.Function, EntryType.valueOf(2));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#equals(Object)}, and {@link ABI.Entry.Param#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI.Entry.Param#equals(Object)}
   *   <li>{@link ABI.Entry.Param#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.equals(Object)", "int ABI.Entry.Param.hashCode()"})
  public void testSmartContract_ABI_Entry_ParamEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    Param defaultInstance = Param.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#equals(Object)}, and {@link ABI.Entry.Param#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ABI.Entry.Param#equals(Object)}
   *   <li>{@link ABI.Entry.Param#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.equals(Object)", "int ABI.Entry.Param.hashCode()"})
  public void testSmartContract_ABI_Entry_ParamEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    Param defaultInstance = Param.getDefaultInstance();
    Param defaultInstance2 = Param.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.equals(Object)", "int ABI.Entry.Param.hashCode()"})
  public void testSmartContract_ABI_Entry_ParamEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Param.getDefaultInstance(), 1);
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.equals(Object)", "int ABI.Entry.Param.hashCode()"})
  public void testSmartContract_ABI_Entry_ParamEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Param.getDefaultInstance(), null);
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.equals(Object)", "int ABI.Entry.Param.hashCode()"})
  public void testSmartContract_ABI_Entry_ParamEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Param.getDefaultInstance(), "Different type to Param");
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.getDefaultInstanceForType()"})
  public void testSmartContract_ABI_Entry_ParamGetDefaultInstanceForType() {
    // Arrange
    Param defaultInstance = Param.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.Entry.Param.getDescriptor()"})
  public void testSmartContract_ABI_Entry_ParamGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Param.getDescriptor();

    // Assert
    assertEquals("Param", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.Param", actualDescriptor.getFullName());
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
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getName()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ABI.Entry.Param.getName()"})
  public void testSmartContract_ABI_Entry_ParamGetName() {
    // Arrange, Act and Assert
    assertEquals("", Param.getDefaultInstance().getName());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getNameBytes()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getNameBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ABI.Entry.Param.getNameBytes()"})
  public void testSmartContract_ABI_Entry_ParamGetNameBytes() {
    // Arrange
    Param defaultInstance = Param.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getSerializedSize()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.Param.getSerializedSize()"})
  public void testSmartContract_ABI_Entry_ParamGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Param.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getType()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ABI.Entry.Param.getType()"})
  public void testSmartContract_ABI_Entry_ParamGetType() {
    // Arrange, Act and Assert
    assertEquals("", Param.getDefaultInstance().getType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#getTypeBytes()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#getTypeBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ABI.Entry.Param.getTypeBytes()"})
  public void testSmartContract_ABI_Entry_ParamGetTypeBytes() {
    // Arrange
    Param defaultInstance = Param.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, actualTypeBytes);
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#isInitialized()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ABI.Entry.Param.isInitialized()"})
  public void testSmartContract_ABI_Entry_ParamIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Param.getDefaultInstance().isInitialized());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Param actualParseDelimitedFromResult = Param.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getType());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getIndexed());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Param.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Param.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Param.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Param actualParseDelimitedFromResult = Param.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getType());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getIndexed());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Param.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Param.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Param.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Param.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseDelimitedFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Param.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(byte[])"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Param actualParseFromResult = Param.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(ByteBuffer)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Param actualParseFromResult = Param.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Param actualParseFromResult = Param.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Param actualParseFromResult = Param.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(ByteString)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Param actualParseFromResult = Param.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getNameBytes());
    assertEquals(byteString, actualParseFromResult.getTypeBytes());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Param actualParseFromResult = Param.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getNameBytes());
    assertEquals(byteString, actualParseFromResult.getTypeBytes());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(CodedInputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Param actualParseFromResult = Param.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Param actualParseFromResult = Param.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Param actualParseFromResult = Param.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Param.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Param actualParseFromResult = Param.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIndexed());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Param.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Param.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Param.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test SmartContract_ABI_Entry_Param {@link ABI.Entry.Param#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.Param#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.Param ABI.Entry.Param.parseFrom(InputStream)"})
  public void testSmartContract_ABI_Entry_ParamParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Param actualParseFromResult = Param.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test SmartContract_ABI_Entry_Param_Builder {@link ABI.Entry.Param.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.Param.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ABI.Entry.Param.Builder.getDescriptor()"})
  public void testSmartContract_ABI_Entry_Param_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Param.Builder.getDescriptor();

    // Assert
    assertEquals("Param", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.Param", actualDescriptor.getFullName());
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
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.UnknownMutabilityType, StateMutabilityType.forNumber(0));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code Nonpayable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber_thenReturnNonpayable() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Nonpayable, StateMutabilityType.forNumber(3));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StateMutabilityType.forNumber(42));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code Payable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber_thenReturnPayable() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Payable, StateMutabilityType.forNumber(4));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Pure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber_whenOne_thenReturnPure() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Pure, StateMutabilityType.forNumber(1));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code View}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.forNumber(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeForNumber_whenTwo_thenReturnView() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.View, StateMutabilityType.forNumber(2));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ABI.Entry.StateMutabilityType.getDescriptor()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = StateMutabilityType.getDescriptor();

    // Assert
    assertEquals("StateMutabilityType", actualDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.StateMutabilityType", actualDescriptor.getFullName());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getDescriptorForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ABI.Entry.StateMutabilityType.getDescriptorForType()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = StateMutabilityType.UnknownMutabilityType.getDescriptorForType();

    // Assert
    assertEquals("StateMutabilityType", actualDescriptorForType.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.StateMutabilityType", actualDescriptorForType.getFullName());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(5, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getNumber()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.StateMutabilityType.getNumber()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetNumber() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StateMutabilityType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getNumber()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ABI.Entry.StateMutabilityType.getNumber()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetNumber_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, StateMutabilityType.UnknownMutabilityType.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getValueDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ABI.Entry.StateMutabilityType.getValueDescriptor()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetValueDescriptor() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = StateMutabilityType.UnknownMutabilityType.getValueDescriptor();

    // Assert
    assertEquals("UnknownMutabilityType", actualValueDescriptor.getName());
    assertEquals("protocol.SmartContract.ABI.Entry.StateMutabilityType.UnknownMutabilityType",
        actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#getValueDescriptor()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ABI.Entry.StateMutabilityType.getValueDescriptor()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeGetValueDescriptor2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> StateMutabilityType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AssetIssueContract.END_TIME_FIELD_NUMBER));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertEquals(StateMutabilityType.Pure, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertEquals(StateMutabilityType.View, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertEquals(StateMutabilityType.Nonpayable, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap5() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertEquals(StateMutabilityType.Payable, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ABI.Entry.StateMutabilityType.internalGetValueMap()"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeInternalGetValueMap6() {
    // Arrange and Act
    EnumLiteMap<StateMutabilityType> actualInternalGetValueMapResult = StateMutabilityType.internalGetValueMap();

    // Assert
    assertEquals(StateMutabilityType.UnknownMutabilityType, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.UnknownMutabilityType, StateMutabilityType.valueOf(0));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue2() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Nonpayable, StateMutabilityType.valueOf(3));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue3() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Payable, StateMutabilityType.valueOf(4));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StateMutabilityType.valueOf(42));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code Pure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue_thenReturnPure() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.Pure, StateMutabilityType.valueOf(1));
  }

  /**
   * Test SmartContract_ABI_Entry_StateMutabilityType {@link ABI.Entry.StateMutabilityType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code View}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ABI.Entry.StateMutabilityType#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI.Entry.StateMutabilityType ABI.Entry.StateMutabilityType.valueOf(int)"})
  public void testSmartContract_ABI_Entry_StateMutabilityTypeValueOfWithValue_thenReturnView() {
    // Arrange, Act and Assert
    assertEquals(StateMutabilityType.View, StateMutabilityType.valueOf(2));
  }

  /**
   * Test SmartContract_Builder {@link SmartContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link SmartContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor SmartContract.Builder.getDescriptor()"})
  public void testSmartContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = SmartContract.Builder.getDescriptor();

    // Assert
    assertEquals("SmartContract", actualDescriptor.getName());
    assertEquals("protocol.SmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertEquals(AssetIssueContract.ORDER_FIELD_NUMBER, actualDescriptor.getFields().size());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#equals(Object)}, and {@link TriggerSmartContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TriggerSmartContract#equals(Object)}
   *   <li>{@link TriggerSmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.equals(Object)", "int TriggerSmartContract.hashCode()"})
  public void testTriggerSmartContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TriggerSmartContract defaultInstance = TriggerSmartContract.getDefaultInstance();
    TriggerSmartContract defaultInstance2 = TriggerSmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#equals(Object)}, and {@link TriggerSmartContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TriggerSmartContract#equals(Object)}
   *   <li>{@link TriggerSmartContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.equals(Object)", "int TriggerSmartContract.hashCode()"})
  public void testTriggerSmartContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TriggerSmartContract defaultInstance = TriggerSmartContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.equals(Object)", "int TriggerSmartContract.hashCode()"})
  public void testTriggerSmartContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TriggerSmartContract.getDefaultInstance(), 1);
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.equals(Object)", "int TriggerSmartContract.hashCode()"})
  public void testTriggerSmartContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TriggerSmartContract.getDefaultInstance(), null);
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.equals(Object)", "int TriggerSmartContract.hashCode()"})
  public void testTriggerSmartContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TriggerSmartContract.getDefaultInstance(), "Different type to TriggerSmartContract");
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TriggerSmartContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.getDefaultInstanceForType()"})
  public void testTriggerSmartContractGetDefaultInstanceForType() {
    // Arrange
    TriggerSmartContract defaultInstance = TriggerSmartContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#getDescriptor()}.
   * <p>
   * Method under test: {@link TriggerSmartContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TriggerSmartContract.getDescriptor()"})
  public void testTriggerSmartContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TriggerSmartContract.getDescriptor();

    // Assert
    assertEquals("TriggerSmartContract", actualDescriptor.getName());
    assertEquals("protocol.TriggerSmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link TriggerSmartContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TriggerSmartContract.getSerializedSize()"})
  public void testTriggerSmartContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TriggerSmartContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#isInitialized()}.
   * <p>
   * Method under test: {@link TriggerSmartContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TriggerSmartContract.isInitialized()"})
  public void testTriggerSmartContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TriggerSmartContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream)"})
  public void testTriggerSmartContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TriggerSmartContract actualParseDelimitedFromResult = TriggerSmartContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getCallTokenValue());
    assertEquals(0L, actualParseDelimitedFromResult.getCallValue());
    assertEquals(0L, actualParseDelimitedFromResult.getTokenId());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream)"})
  public void testTriggerSmartContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TriggerSmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TriggerSmartContract actualParseDelimitedFromResult = TriggerSmartContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getCallTokenValue());
    assertEquals(0L, actualParseDelimitedFromResult.getCallValue());
    assertEquals(0L, actualParseDelimitedFromResult.getTokenId());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TriggerSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TriggerSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TriggerSmartContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream)"})
  public void testTriggerSmartContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TriggerSmartContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseDelimitedFrom(InputStream)"})
  public void testTriggerSmartContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TriggerSmartContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(byte[])"})
  public void testTriggerSmartContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteBuffer)"})
  public void testTriggerSmartContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteString)"})
  public void testTriggerSmartContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getData());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteString)"})
  public void testTriggerSmartContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getData());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getData());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getData());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(CodedInputStream)"})
  public void testTriggerSmartContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(CodedInputStream)"})
  public void testTriggerSmartContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream)"})
  public void testTriggerSmartContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream)"})
  public void testTriggerSmartContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TriggerSmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getCallTokenValue());
    assertEquals(0L, actualParseFromResult.getCallValue());
    assertEquals(0L, actualParseFromResult.getTokenId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TriggerSmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTriggerSmartContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TriggerSmartContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream)"})
  public void testTriggerSmartContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TriggerSmartContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TriggerSmartContract {@link TriggerSmartContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TriggerSmartContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TriggerSmartContract TriggerSmartContract.parseFrom(InputStream)"})
  public void testTriggerSmartContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TriggerSmartContract actualParseFromResult = TriggerSmartContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TriggerSmartContract_Builder {@link TriggerSmartContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link TriggerSmartContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TriggerSmartContract.Builder.getDescriptor()"})
  public void testTriggerSmartContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TriggerSmartContract.Builder.getDescriptor();

    // Assert
    assertEquals("TriggerSmartContract", actualDescriptor.getName());
    assertEquals("protocol.TriggerSmartContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(6, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#equals(Object)}, and {@link UpdateEnergyLimitContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateEnergyLimitContract#equals(Object)}
   *   <li>{@link UpdateEnergyLimitContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.equals(Object)", "int UpdateEnergyLimitContract.hashCode()"})
  public void testUpdateEnergyLimitContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UpdateEnergyLimitContract defaultInstance = UpdateEnergyLimitContract.getDefaultInstance();
    UpdateEnergyLimitContract defaultInstance2 = UpdateEnergyLimitContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#equals(Object)}, and {@link UpdateEnergyLimitContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateEnergyLimitContract#equals(Object)}
   *   <li>{@link UpdateEnergyLimitContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.equals(Object)", "int UpdateEnergyLimitContract.hashCode()"})
  public void testUpdateEnergyLimitContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UpdateEnergyLimitContract defaultInstance = UpdateEnergyLimitContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.equals(Object)", "int UpdateEnergyLimitContract.hashCode()"})
  public void testUpdateEnergyLimitContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateEnergyLimitContract.getDefaultInstance(), 1);
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.equals(Object)", "int UpdateEnergyLimitContract.hashCode()"})
  public void testUpdateEnergyLimitContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateEnergyLimitContract.getDefaultInstance(), null);
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.equals(Object)", "int UpdateEnergyLimitContract.hashCode()"})
  public void testUpdateEnergyLimitContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateEnergyLimitContract.getDefaultInstance(), "Different type to UpdateEnergyLimitContract");
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.getDefaultInstanceForType()"})
  public void testUpdateEnergyLimitContractGetDefaultInstanceForType() {
    // Arrange
    UpdateEnergyLimitContract defaultInstance = UpdateEnergyLimitContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateEnergyLimitContract.getDescriptor()"})
  public void testUpdateEnergyLimitContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateEnergyLimitContract.getDescriptor();

    // Assert
    assertEquals("UpdateEnergyLimitContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateEnergyLimitContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(6, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UpdateEnergyLimitContract.getSerializedSize()"})
  public void testUpdateEnergyLimitContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UpdateEnergyLimitContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#isInitialized()}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateEnergyLimitContract.isInitialized()"})
  public void testUpdateEnergyLimitContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UpdateEnergyLimitContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateEnergyLimitContract actualParseDelimitedFromResult = UpdateEnergyLimitContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getOriginEnergyLimit());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateEnergyLimitContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateEnergyLimitContract actualParseDelimitedFromResult = UpdateEnergyLimitContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getOriginEnergyLimit());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateEnergyLimitContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateEnergyLimitContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateEnergyLimitContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateEnergyLimitContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateEnergyLimitContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(byte[])"})
  public void testUpdateEnergyLimitContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteBuffer)"})
  public void testUpdateEnergyLimitContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteString)"})
  public void testUpdateEnergyLimitContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteString)"})
  public void testUpdateEnergyLimitContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(CodedInputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(CodedInputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateEnergyLimitContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getOriginEnergyLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateEnergyLimitContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateEnergyLimitContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateEnergyLimitContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateEnergyLimitContract {@link UpdateEnergyLimitContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateEnergyLimitContract UpdateEnergyLimitContract.parseFrom(InputStream)"})
  public void testUpdateEnergyLimitContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UpdateEnergyLimitContract actualParseFromResult = UpdateEnergyLimitContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateEnergyLimitContract_Builder {@link UpdateEnergyLimitContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateEnergyLimitContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateEnergyLimitContract.Builder.getDescriptor()"})
  public void testUpdateEnergyLimitContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateEnergyLimitContract.Builder.getDescriptor();

    // Assert
    assertEquals("UpdateEnergyLimitContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateEnergyLimitContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getFields().size());
    assertEquals(6, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#equals(Object)}, and {@link UpdateSettingContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateSettingContract#equals(Object)}
   *   <li>{@link UpdateSettingContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.equals(Object)", "int UpdateSettingContract.hashCode()"})
  public void testUpdateSettingContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UpdateSettingContract defaultInstance = UpdateSettingContract.getDefaultInstance();
    UpdateSettingContract defaultInstance2 = UpdateSettingContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#equals(Object)}, and {@link UpdateSettingContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateSettingContract#equals(Object)}
   *   <li>{@link UpdateSettingContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.equals(Object)", "int UpdateSettingContract.hashCode()"})
  public void testUpdateSettingContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UpdateSettingContract defaultInstance = UpdateSettingContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.equals(Object)", "int UpdateSettingContract.hashCode()"})
  public void testUpdateSettingContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateSettingContract.getDefaultInstance(), 1);
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.equals(Object)", "int UpdateSettingContract.hashCode()"})
  public void testUpdateSettingContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateSettingContract.getDefaultInstance(), null);
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.equals(Object)", "int UpdateSettingContract.hashCode()"})
  public void testUpdateSettingContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateSettingContract.getDefaultInstance(), "Different type to UpdateSettingContract");
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UpdateSettingContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.getDefaultInstanceForType()"})
  public void testUpdateSettingContractGetDefaultInstanceForType() {
    // Arrange
    UpdateSettingContract defaultInstance = UpdateSettingContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateSettingContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateSettingContract.getDescriptor()"})
  public void testUpdateSettingContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateSettingContract.getDescriptor();

    // Assert
    assertEquals("UpdateSettingContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateSettingContract", actualDescriptor.getFullName());
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
   * Test UpdateSettingContract {@link UpdateSettingContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UpdateSettingContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UpdateSettingContract.getSerializedSize()"})
  public void testUpdateSettingContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UpdateSettingContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#isInitialized()}.
   * <p>
   * Method under test: {@link UpdateSettingContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateSettingContract.isInitialized()"})
  public void testUpdateSettingContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UpdateSettingContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateSettingContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateSettingContract actualParseDelimitedFromResult = UpdateSettingContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getConsumeUserResourcePercent());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateSettingContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateSettingContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateSettingContract actualParseDelimitedFromResult = UpdateSettingContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getConsumeUserResourcePercent());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateSettingContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateSettingContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateSettingContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateSettingContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateSettingContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateSettingContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateSettingContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(byte[])"})
  public void testUpdateSettingContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteBuffer)"})
  public void testUpdateSettingContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteString)"})
  public void testUpdateSettingContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteString)"})
  public void testUpdateSettingContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getContractAddress());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(CodedInputStream)"})
  public void testUpdateSettingContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(CodedInputStream)"})
  public void testUpdateSettingContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream)"})
  public void testUpdateSettingContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream)"})
  public void testUpdateSettingContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateSettingContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getConsumeUserResourcePercent());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateSettingContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateSettingContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateSettingContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream)"})
  public void testUpdateSettingContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateSettingContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateSettingContract {@link UpdateSettingContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateSettingContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateSettingContract UpdateSettingContract.parseFrom(InputStream)"})
  public void testUpdateSettingContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UpdateSettingContract actualParseFromResult = UpdateSettingContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateSettingContract_Builder {@link UpdateSettingContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateSettingContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateSettingContract.Builder.getDescriptor()"})
  public void testUpdateSettingContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateSettingContract.Builder.getDescriptor();

    // Assert
    assertEquals("UpdateSettingContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateSettingContract", actualDescriptor.getFullName());
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
}
