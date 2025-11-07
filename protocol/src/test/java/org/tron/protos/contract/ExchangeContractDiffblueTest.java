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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.protos.contract.ExchangeContract.ExchangeCreateContract;
import org.tron.protos.contract.ExchangeContract.ExchangeCreateContract.Builder;
import org.tron.protos.contract.ExchangeContract.ExchangeInjectContract;
import org.tron.protos.contract.ExchangeContract.ExchangeTransactionContract;
import org.tron.protos.contract.ExchangeContract.ExchangeWithdrawContract;

public class ExchangeContractDiffblueTest {
  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#equals(Object)}, and {@link ExchangeCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeCreateContract#equals(Object)}
   *   <li>{@link ExchangeCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.equals(Object)", "int ExchangeCreateContract.hashCode()"})
  public void testExchangeCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeCreateContract defaultInstance = ExchangeCreateContract.getDefaultInstance();
    ExchangeCreateContract defaultInstance2 = ExchangeCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#equals(Object)}, and {@link ExchangeCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeCreateContract#equals(Object)}
   *   <li>{@link ExchangeCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.equals(Object)", "int ExchangeCreateContract.hashCode()"})
  public void testExchangeCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeCreateContract defaultInstance = ExchangeCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.equals(Object)", "int ExchangeCreateContract.hashCode()"})
  public void testExchangeCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.equals(Object)", "int ExchangeCreateContract.hashCode()"})
  public void testExchangeCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeCreateContract.getDefaultInstance(), null);
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.equals(Object)", "int ExchangeCreateContract.hashCode()"})
  public void testExchangeCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeCreateContract.getDefaultInstance(), "Different type to ExchangeCreateContract");
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.getDefaultInstanceForType()"})
  public void testExchangeCreateContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeCreateContract defaultInstance = ExchangeCreateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeCreateContract.getDescriptor()"})
  public void testExchangeCreateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeCreateContract.getDescriptor();

    // Assert
    assertEquals("ExchangeCreateContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeCreateContract", actualDescriptor.getFullName());
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
   * Test ExchangeCreateContract {@link ExchangeCreateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ExchangeCreateContract.getSerializedSize()"})
  public void testExchangeCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#isInitialized()}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeCreateContract.isInitialized()"})
  public void testExchangeCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeCreateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeCreateContract actualParseDelimitedFromResult = ExchangeCreateContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getSecondTokenBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeCreateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeCreateContract actualParseDelimitedFromResult = ExchangeCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseDelimitedFromResult.getSecondTokenBalance());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeCreateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeCreateContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(byte[])"})
  public void testExchangeCreateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteBuffer)"})
  public void testExchangeCreateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteString)"})
  public void testExchangeCreateContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getFirstTokenId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getSecondTokenId());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteString)"})
  public void testExchangeCreateContractParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getFirstTokenId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getSecondTokenId());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getFirstTokenId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getSecondTokenId());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getFirstTokenId());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getSecondTokenId());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeCreateContract ExchangeCreateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(CodedInputStream)"})
  public void testExchangeCreateContractParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(CodedInputStream)"})
  public void testExchangeCreateContractParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream)"})
  public void testExchangeCreateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream)"})
  public void testExchangeCreateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFirstTokenBalance());
    assertEquals(0L, actualParseFromResult.getSecondTokenBalance());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeCreateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream)"})
  public void testExchangeCreateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeCreateContract {@link ExchangeCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeCreateContract ExchangeCreateContract.parseFrom(InputStream)"})
  public void testExchangeCreateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ExchangeCreateContract actualParseFromResult = ExchangeCreateContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeCreateContract_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testExchangeCreateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("ExchangeCreateContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeCreateContract", actualDescriptor.getFullName());
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
   * Test ExchangeInjectContract {@link ExchangeInjectContract#equals(Object)}, and {@link ExchangeInjectContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeInjectContract#equals(Object)}
   *   <li>{@link ExchangeInjectContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.equals(Object)", "int ExchangeInjectContract.hashCode()"})
  public void testExchangeInjectContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeInjectContract defaultInstance = ExchangeInjectContract.getDefaultInstance();
    ExchangeInjectContract defaultInstance2 = ExchangeInjectContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#equals(Object)}, and {@link ExchangeInjectContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeInjectContract#equals(Object)}
   *   <li>{@link ExchangeInjectContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.equals(Object)", "int ExchangeInjectContract.hashCode()"})
  public void testExchangeInjectContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeInjectContract defaultInstance = ExchangeInjectContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.equals(Object)", "int ExchangeInjectContract.hashCode()"})
  public void testExchangeInjectContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeInjectContract.getDefaultInstance(), 1);
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.equals(Object)", "int ExchangeInjectContract.hashCode()"})
  public void testExchangeInjectContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeInjectContract.getDefaultInstance(), null);
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.equals(Object)", "int ExchangeInjectContract.hashCode()"})
  public void testExchangeInjectContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeInjectContract.getDefaultInstance(), "Different type to ExchangeInjectContract");
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.getDefaultInstanceForType()"})
  public void testExchangeInjectContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeInjectContract defaultInstance = ExchangeInjectContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeInjectContract.getDescriptor()"})
  public void testExchangeInjectContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeInjectContract.getDescriptor();

    // Assert
    assertEquals("ExchangeInjectContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeInjectContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ExchangeInjectContract.getSerializedSize()"})
  public void testExchangeInjectContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeInjectContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#isInitialized()}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeInjectContract.isInitialized()"})
  public void testExchangeInjectContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeInjectContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeInjectContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeInjectContract actualParseDelimitedFromResult = ExchangeInjectContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeInjectContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeInjectContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeInjectContract actualParseDelimitedFromResult = ExchangeInjectContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeInjectContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeInjectContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeInjectContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeInjectContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeInjectContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeInjectContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeInjectContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(byte[])"})
  public void testExchangeInjectContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(ByteBuffer)"})
  public void testExchangeInjectContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(ByteString)"})
  public void testExchangeInjectContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(CodedInputStream)"})
  public void testExchangeInjectContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeInjectContract ExchangeInjectContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream)"})
  public void testExchangeInjectContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream)"})
  public void testExchangeInjectContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeInjectContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeInjectContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeInjectContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeInjectContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream)"})
  public void testExchangeInjectContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeInjectContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeInjectContract {@link ExchangeInjectContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeInjectContract ExchangeInjectContract.parseFrom(InputStream)"})
  public void testExchangeInjectContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ExchangeInjectContract actualParseFromResult = ExchangeInjectContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeInjectContract_Builder {@link ExchangeInjectContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeInjectContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeInjectContract.Builder.getDescriptor()"})
  public void testExchangeInjectContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeInjectContract.Builder.getDescriptor();

    // Assert
    assertEquals("ExchangeInjectContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeInjectContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#equals(Object)}, and {@link ExchangeTransactionContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeTransactionContract#equals(Object)}
   *   <li>{@link ExchangeTransactionContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.equals(Object)",
      "int ExchangeTransactionContract.hashCode()"})
  public void testExchangeTransactionContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    ExchangeTransactionContract defaultInstance = ExchangeTransactionContract.getDefaultInstance();
    ExchangeTransactionContract defaultInstance2 = ExchangeTransactionContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#equals(Object)}, and {@link ExchangeTransactionContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeTransactionContract#equals(Object)}
   *   <li>{@link ExchangeTransactionContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.equals(Object)",
      "int ExchangeTransactionContract.hashCode()"})
  public void testExchangeTransactionContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeTransactionContract defaultInstance = ExchangeTransactionContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.equals(Object)",
      "int ExchangeTransactionContract.hashCode()"})
  public void testExchangeTransactionContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeTransactionContract.getDefaultInstance(), 1);
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.equals(Object)",
      "int ExchangeTransactionContract.hashCode()"})
  public void testExchangeTransactionContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeTransactionContract.getDefaultInstance(), null);
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.equals(Object)",
      "int ExchangeTransactionContract.hashCode()"})
  public void testExchangeTransactionContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeTransactionContract.getDefaultInstance(), "Different type to ExchangeTransactionContract");
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.getDefaultInstanceForType()"})
  public void testExchangeTransactionContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeTransactionContract defaultInstance = ExchangeTransactionContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeTransactionContract.getDescriptor()"})
  public void testExchangeTransactionContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeTransactionContract.getDescriptor();

    // Assert
    assertEquals("ExchangeTransactionContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeTransactionContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ExchangeTransactionContract.getSerializedSize()"})
  public void testExchangeTransactionContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeTransactionContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#isInitialized()}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeTransactionContract.isInitialized()"})
  public void testExchangeTransactionContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeTransactionContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeTransactionContract actualParseDelimitedFromResult = ExchangeTransactionContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getExpected());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeTransactionContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeTransactionContract actualParseDelimitedFromResult = ExchangeTransactionContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getExpected());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeTransactionContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeTransactionContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeTransactionContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeTransactionContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeTransactionContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeTransactionContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(byte[])"})
  public void testExchangeTransactionContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(ByteBuffer)"})
  public void testExchangeTransactionContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(ByteString)"})
  public void testExchangeTransactionContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(CodedInputStream)"})
  public void testExchangeTransactionContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream)"})
  public void testExchangeTransactionContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(5, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream)"})
  public void testExchangeTransactionContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeTransactionContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getExpected());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeTransactionContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeTransactionContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeTransactionContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream)"})
  public void testExchangeTransactionContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeTransactionContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeTransactionContract {@link ExchangeTransactionContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeTransactionContract ExchangeTransactionContract.parseFrom(InputStream)"})
  public void testExchangeTransactionContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ExchangeTransactionContract actualParseFromResult = ExchangeTransactionContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(5, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeTransactionContract_Builder {@link ExchangeTransactionContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeTransactionContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeTransactionContract.Builder.getDescriptor()"})
  public void testExchangeTransactionContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeTransactionContract.Builder.getDescriptor();

    // Assert
    assertEquals("ExchangeTransactionContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeTransactionContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#equals(Object)}, and {@link ExchangeWithdrawContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeWithdrawContract#equals(Object)}
   *   <li>{@link ExchangeWithdrawContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.equals(Object)", "int ExchangeWithdrawContract.hashCode()"})
  public void testExchangeWithdrawContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeWithdrawContract defaultInstance = ExchangeWithdrawContract.getDefaultInstance();
    ExchangeWithdrawContract defaultInstance2 = ExchangeWithdrawContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#equals(Object)}, and {@link ExchangeWithdrawContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeWithdrawContract#equals(Object)}
   *   <li>{@link ExchangeWithdrawContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.equals(Object)", "int ExchangeWithdrawContract.hashCode()"})
  public void testExchangeWithdrawContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeWithdrawContract defaultInstance = ExchangeWithdrawContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.equals(Object)", "int ExchangeWithdrawContract.hashCode()"})
  public void testExchangeWithdrawContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeWithdrawContract.getDefaultInstance(), 1);
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.equals(Object)", "int ExchangeWithdrawContract.hashCode()"})
  public void testExchangeWithdrawContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeWithdrawContract.getDefaultInstance(), null);
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.equals(Object)", "int ExchangeWithdrawContract.hashCode()"})
  public void testExchangeWithdrawContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeWithdrawContract.getDefaultInstance(), "Different type to ExchangeWithdrawContract");
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.getDefaultInstanceForType()"})
  public void testExchangeWithdrawContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeWithdrawContract defaultInstance = ExchangeWithdrawContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeWithdrawContract.getDescriptor()"})
  public void testExchangeWithdrawContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeWithdrawContract.getDescriptor();

    // Assert
    assertEquals("ExchangeWithdrawContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeWithdrawContract", actualDescriptor.getFullName());
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
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ExchangeWithdrawContract.getSerializedSize()"})
  public void testExchangeWithdrawContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeWithdrawContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#isInitialized()}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExchangeWithdrawContract.isInitialized()"})
  public void testExchangeWithdrawContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeWithdrawContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeWithdrawContract actualParseDelimitedFromResult = ExchangeWithdrawContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeWithdrawContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ExchangeWithdrawContract actualParseDelimitedFromResult = ExchangeWithdrawContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getExchangeId());
    assertEquals(0L, actualParseDelimitedFromResult.getQuant());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeWithdrawContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeWithdrawContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeWithdrawContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeWithdrawContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseDelimitedFrom(InputStream)"})
  public void testExchangeWithdrawContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeWithdrawContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(byte[])"})
  public void testExchangeWithdrawContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(ByteBuffer)"})
  public void testExchangeWithdrawContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(ByteString)"})
  public void testExchangeWithdrawContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getTokenId());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(CodedInputStream)"})
  public void testExchangeWithdrawContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream)"})
  public void testExchangeWithdrawContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream)"})
  public void testExchangeWithdrawContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeWithdrawContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getExchangeId());
    assertEquals(0L, actualParseFromResult.getQuant());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeWithdrawContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testExchangeWithdrawContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeWithdrawContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream)"})
  public void testExchangeWithdrawContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeWithdrawContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ExchangeWithdrawContract {@link ExchangeWithdrawContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeWithdrawContract ExchangeWithdrawContract.parseFrom(InputStream)"})
  public void testExchangeWithdrawContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ExchangeWithdrawContract actualParseFromResult = ExchangeWithdrawContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ExchangeWithdrawContract_Builder {@link ExchangeWithdrawContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ExchangeWithdrawContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ExchangeWithdrawContract.Builder.getDescriptor()"})
  public void testExchangeWithdrawContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ExchangeWithdrawContract.Builder.getDescriptor();

    // Assert
    assertEquals("ExchangeWithdrawContract", actualDescriptor.getName());
    assertEquals("protocol.ExchangeWithdrawContract", actualDescriptor.getFullName());
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
}
