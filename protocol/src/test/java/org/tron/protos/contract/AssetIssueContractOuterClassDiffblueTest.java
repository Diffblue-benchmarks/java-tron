package org.tron.protos.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class AssetIssueContractOuterClassDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.AssetIssueContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.AssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAssetIssueContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance2 = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.AssetIssueContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.AssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAssetIssueContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#equals(Object)}
   */
  @Test
  public void testAssetIssueContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#equals(Object)}
   */
  @Test
  public void testAssetIssueContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#equals(Object)}
   */
  @Test
  public void testAssetIssueContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance(),
        "Different type to AssetIssueContract");
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#getDefaultInstanceForType()}
   */
  @Test
  public void testAssetIssueContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#getFrozenSupplyCount()}
   */
  @Test
  public void testAssetIssueContractGetFrozenSupplyCount() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance().getFrozenSupplyCount());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#getId()}
   */
  @Test
  public void testAssetIssueContractGetId() {
    // Arrange, Act and Assert
    assertEquals("", AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance().getId());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#getIdBytes()}
   */
  @Test
  public void testAssetIssueContractGetIdBytes() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act
    ByteString actualIdBytes = defaultInstance.getIdBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(19, fields.size());
    ByteString byteString = actualIdBytes.EMPTY;
    assertEquals(byteString, actualIdBytes);
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, defaultInstance.getAbbr());
    assertSame(byteString, defaultInstance.getDescription());
    assertSame(byteString, defaultInstance.getName());
    assertSame(byteString, defaultInstance.getOwnerAddress());
    assertSame(byteString, defaultInstance.getUrl());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#getSerializedSize()}
   */
  @Test
  public void testAssetIssueContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#isInitialized()}
   */
  @Test
  public void testAssetIssueContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAssetIssueContractNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract defaultInstance = AssetIssueContractOuterClass.AssetIssueContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.AssetIssueContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.AssetIssueContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AssetIssueContractOuterClass.AssetIssueContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.AssetIssueContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#equals(Object)}
   *   <li>
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#hashCode()}
   * </ul>
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply defaultInstance = AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#equals(Object)}
   *   <li>
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#hashCode()}
   * </ul>
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply defaultInstance = AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .getDefaultInstance();
    AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply defaultInstance2 = AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#equals(Object)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.getDefaultInstance(),
        "Different type to FrozenSupply");
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#equals(Object)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#getDefaultInstanceForType()}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply defaultInstance = AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#getSerializedSize()}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#isInitialized()}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply defaultInstance = AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseDelimitedFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAssetIssueContract_FrozenSupplyParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply.parseFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#equals(Object)}
   *   <li>
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  public void testParticipateAssetIssueContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.ParticipateAssetIssueContract defaultInstance = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#equals(Object)}
   *   <li>
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  public void testParticipateAssetIssueContractEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    AssetIssueContractOuterClass.ParticipateAssetIssueContract defaultInstance = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();
    AssetIssueContractOuterClass.ParticipateAssetIssueContract defaultInstance2 = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  public void testParticipateAssetIssueContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.ParticipateAssetIssueContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  public void testParticipateAssetIssueContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.ParticipateAssetIssueContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  public void testParticipateAssetIssueContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.ParticipateAssetIssueContract.getDefaultInstance(),
        "Different type to ParticipateAssetIssueContract");
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#getDefaultInstanceForType()}
   */
  @Test
  public void testParticipateAssetIssueContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.ParticipateAssetIssueContract defaultInstance = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#getSerializedSize()}
   */
  @Test
  public void testParticipateAssetIssueContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        AssetIssueContractOuterClass.ParticipateAssetIssueContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#isInitialized()}
   */
  @Test
  public void testParticipateAssetIssueContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.ParticipateAssetIssueContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testParticipateAssetIssueContractNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.ParticipateAssetIssueContract defaultInstance = AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.ParticipateAssetIssueContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testParticipateAssetIssueContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  public void testParticipateAssetIssueContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  public void testParticipateAssetIssueContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testParticipateAssetIssueContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testParticipateAssetIssueContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.ParticipateAssetIssueContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.TransferAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.TransferAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testTransferAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.TransferAssetContract defaultInstance = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();
    AssetIssueContractOuterClass.TransferAssetContract defaultInstance2 = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.TransferAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.TransferAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testTransferAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.TransferAssetContract defaultInstance = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#equals(Object)}
   */
  @Test
  public void testTransferAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.TransferAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#equals(Object)}
   */
  @Test
  public void testTransferAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.TransferAssetContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#equals(Object)}
   */
  @Test
  public void testTransferAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.TransferAssetContract.getDefaultInstance(),
        "Different type to TransferAssetContract");
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#getDefaultInstanceForType()}
   */
  @Test
  public void testTransferAssetContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.TransferAssetContract defaultInstance = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#getSerializedSize()}
   */
  @Test
  public void testTransferAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContractOuterClass.TransferAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#isInitialized()}
   */
  @Test
  public void testTransferAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.TransferAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testTransferAssetContractNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.TransferAssetContract defaultInstance = AssetIssueContractOuterClass.TransferAssetContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.TransferAssetContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.TransferAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.TransferAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.TransferAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.TransferAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.TransferAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testTransferAssetContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.TransferAssetContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testTransferAssetContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.TransferAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testTransferAssetContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.TransferAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testTransferAssetContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.TransferAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testTransferAssetContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.TransferAssetContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.UnfreezeAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.UnfreezeAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUnfreezeAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.UnfreezeAssetContract defaultInstance = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();
    AssetIssueContractOuterClass.UnfreezeAssetContract defaultInstance2 = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.UnfreezeAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.UnfreezeAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUnfreezeAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.UnfreezeAssetContract defaultInstance = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#equals(Object)}
   */
  @Test
  public void testUnfreezeAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UnfreezeAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#equals(Object)}
   */
  @Test
  public void testUnfreezeAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UnfreezeAssetContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#equals(Object)}
   */
  @Test
  public void testUnfreezeAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UnfreezeAssetContract.getDefaultInstance(),
        "Different type to UnfreezeAssetContract");
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#getDefaultInstanceForType()}
   */
  @Test
  public void testUnfreezeAssetContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.UnfreezeAssetContract defaultInstance = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#getSerializedSize()}
   */
  @Test
  public void testUnfreezeAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContractOuterClass.UnfreezeAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#isInitialized()}
   */
  @Test
  public void testUnfreezeAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.UnfreezeAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testUnfreezeAssetContractNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.UnfreezeAssetContract defaultInstance = AssetIssueContractOuterClass.UnfreezeAssetContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.UnfreezeAssetContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.UnfreezeAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.UnfreezeAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUnfreezeAssetContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testUnfreezeAssetContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testUnfreezeAssetContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUnfreezeAssetContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUnfreezeAssetContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.UnfreezeAssetContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.UpdateAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.UpdateAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUpdateAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.UpdateAssetContract defaultInstance = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();
    AssetIssueContractOuterClass.UpdateAssetContract defaultInstance2 = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContractOuterClass.UpdateAssetContract#equals(Object)}
   *   <li>{@link AssetIssueContractOuterClass.UpdateAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUpdateAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssueContractOuterClass.UpdateAssetContract defaultInstance = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#equals(Object)}
   */
  @Test
  public void testUpdateAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UpdateAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#equals(Object)}
   */
  @Test
  public void testUpdateAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UpdateAssetContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#equals(Object)}
   */
  @Test
  public void testUpdateAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContractOuterClass.UpdateAssetContract.getDefaultInstance(),
        "Different type to UpdateAssetContract");
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#getDefaultInstanceForType()}
   */
  @Test
  public void testUpdateAssetContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContractOuterClass.UpdateAssetContract defaultInstance = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#getSerializedSize()}
   */
  @Test
  public void testUpdateAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContractOuterClass.UpdateAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#isInitialized()}
   */
  @Test
  public void testUpdateAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContractOuterClass.UpdateAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testUpdateAssetContractNewInstance() {
    // Arrange
    AssetIssueContractOuterClass.UpdateAssetContract defaultInstance = AssetIssueContractOuterClass.UpdateAssetContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetIssueContractOuterClass.UpdateAssetContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.UpdateAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.UpdateAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContractOuterClass.UpdateAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateAssetContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testUpdateAssetContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testUpdateAssetContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContractOuterClass.UpdateAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateAssetContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetIssueContractOuterClass.UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateAssetContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContractOuterClass.UpdateAssetContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
