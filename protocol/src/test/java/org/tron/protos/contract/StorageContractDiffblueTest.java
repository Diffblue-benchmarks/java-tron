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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.mockito.Mockito;

public class StorageContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.BuyStorageBytesContract#equals(Object)}
   *   <li>{@link StorageContract.BuyStorageBytesContract#hashCode()}
   * </ul>
   */
  @Test
  public void testBuyStorageBytesContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageContract.BuyStorageBytesContract defaultInstance = StorageContract.BuyStorageBytesContract
        .getDefaultInstance();
    StorageContract.BuyStorageBytesContract defaultInstance2 = StorageContract.BuyStorageBytesContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.BuyStorageBytesContract#equals(Object)}
   *   <li>{@link StorageContract.BuyStorageBytesContract#hashCode()}
   * </ul>
   */
  @Test
  public void testBuyStorageBytesContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageContract.BuyStorageBytesContract defaultInstance = StorageContract.BuyStorageBytesContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#equals(Object)}
   */
  @Test
  public void testBuyStorageBytesContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageBytesContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#equals(Object)}
   */
  @Test
  public void testBuyStorageBytesContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageBytesContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#equals(Object)}
   */
  @Test
  public void testBuyStorageBytesContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageBytesContract.getDefaultInstance(),
        "Different type to BuyStorageBytesContract");
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#getDefaultInstanceForType()}
   */
  @Test
  public void testBuyStorageBytesContractGetDefaultInstanceForType() {
    // Arrange
    StorageContract.BuyStorageBytesContract defaultInstance = StorageContract.BuyStorageBytesContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#getSerializedSize()}
   */
  @Test
  public void testBuyStorageBytesContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageContract.BuyStorageBytesContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#isInitialized()}
   */
  @Test
  public void testBuyStorageBytesContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageContract.BuyStorageBytesContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testBuyStorageBytesContractNewInstance() {
    // Arrange
    StorageContract.BuyStorageBytesContract defaultInstance = StorageContract.BuyStorageBytesContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof StorageContract.BuyStorageBytesContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.BuyStorageBytesContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.BuyStorageBytesContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.BuyStorageBytesContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        StorageContract.BuyStorageBytesContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.BuyStorageBytesContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageBytesContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.BuyStorageBytesContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseFrom(InputStream)}
   */
  @Test
  public void testBuyStorageBytesContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.BuyStorageBytesContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseFrom(InputStream)}
   */
  @Test
  public void testBuyStorageBytesContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.BuyStorageBytesContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageBytesContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.BuyStorageBytesContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageBytesContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageBytesContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.BuyStorageBytesContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.BuyStorageContract#equals(Object)}
   *   <li>{@link StorageContract.BuyStorageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testBuyStorageContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageContract.BuyStorageContract defaultInstance = StorageContract.BuyStorageContract.getDefaultInstance();
    StorageContract.BuyStorageContract defaultInstance2 = StorageContract.BuyStorageContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.BuyStorageContract#equals(Object)}
   *   <li>{@link StorageContract.BuyStorageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testBuyStorageContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageContract.BuyStorageContract defaultInstance = StorageContract.BuyStorageContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link StorageContract.BuyStorageContract#equals(Object)}
   */
  @Test
  public void testBuyStorageContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link StorageContract.BuyStorageContract#equals(Object)}
   */
  @Test
  public void testBuyStorageContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageContract.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link StorageContract.BuyStorageContract#equals(Object)}
   */
  @Test
  public void testBuyStorageContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.BuyStorageContract.getDefaultInstance(), "Different type to BuyStorageContract");
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#getDefaultInstanceForType()}
   */
  @Test
  public void testBuyStorageContractGetDefaultInstanceForType() {
    // Arrange
    StorageContract.BuyStorageContract defaultInstance = StorageContract.BuyStorageContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#getSerializedSize()}
   */
  @Test
  public void testBuyStorageContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageContract.BuyStorageContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link StorageContract.BuyStorageContract#isInitialized()}
   */
  @Test
  public void testBuyStorageContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageContract.BuyStorageContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testBuyStorageContractNewInstance() {
    // Arrange
    StorageContract.BuyStorageContract defaultInstance = StorageContract.BuyStorageContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof StorageContract.BuyStorageContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.BuyStorageContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.BuyStorageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.BuyStorageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.BuyStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.BuyStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.BuyStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseFrom(InputStream)}
   */
  @Test
  public void testBuyStorageContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.BuyStorageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseFrom(InputStream)}
   */
  @Test
  public void testBuyStorageContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.BuyStorageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.BuyStorageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.BuyStorageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBuyStorageContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.BuyStorageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.SellStorageContract#equals(Object)}
   *   <li>{@link StorageContract.SellStorageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testSellStorageContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageContract.SellStorageContract defaultInstance = StorageContract.SellStorageContract.getDefaultInstance();
    StorageContract.SellStorageContract defaultInstance2 = StorageContract.SellStorageContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.SellStorageContract#equals(Object)}
   *   <li>{@link StorageContract.SellStorageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testSellStorageContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageContract.SellStorageContract defaultInstance = StorageContract.SellStorageContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link StorageContract.SellStorageContract#equals(Object)}
   */
  @Test
  public void testSellStorageContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.SellStorageContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link StorageContract.SellStorageContract#equals(Object)}
   */
  @Test
  public void testSellStorageContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.SellStorageContract.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link StorageContract.SellStorageContract#equals(Object)}
   */
  @Test
  public void testSellStorageContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.SellStorageContract.getDefaultInstance(), "Different type to SellStorageContract");
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#getDefaultInstanceForType()}
   */
  @Test
  public void testSellStorageContractGetDefaultInstanceForType() {
    // Arrange
    StorageContract.SellStorageContract defaultInstance = StorageContract.SellStorageContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#getSerializedSize()}
   */
  @Test
  public void testSellStorageContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageContract.SellStorageContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#isInitialized()}
   */
  @Test
  public void testSellStorageContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageContract.SellStorageContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testSellStorageContractNewInstance() {
    // Arrange
    StorageContract.SellStorageContract defaultInstance = StorageContract.SellStorageContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof StorageContract.SellStorageContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.SellStorageContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.SellStorageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.SellStorageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.SellStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.SellStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSellStorageContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.SellStorageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseFrom(InputStream)}
   */
  @Test
  public void testSellStorageContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.SellStorageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseFrom(InputStream)}
   */
  @Test
  public void testSellStorageContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.SellStorageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSellStorageContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.SellStorageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.SellStorageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSellStorageContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.SellStorageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.UpdateBrokerageContract#equals(Object)}
   *   <li>{@link StorageContract.UpdateBrokerageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUpdateBrokerageContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StorageContract.UpdateBrokerageContract defaultInstance = StorageContract.UpdateBrokerageContract
        .getDefaultInstance();
    StorageContract.UpdateBrokerageContract defaultInstance2 = StorageContract.UpdateBrokerageContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageContract.UpdateBrokerageContract#equals(Object)}
   *   <li>{@link StorageContract.UpdateBrokerageContract#hashCode()}
   * </ul>
   */
  @Test
  public void testUpdateBrokerageContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StorageContract.UpdateBrokerageContract defaultInstance = StorageContract.UpdateBrokerageContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#equals(Object)}
   */
  @Test
  public void testUpdateBrokerageContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.UpdateBrokerageContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#equals(Object)}
   */
  @Test
  public void testUpdateBrokerageContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.UpdateBrokerageContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#equals(Object)}
   */
  @Test
  public void testUpdateBrokerageContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StorageContract.UpdateBrokerageContract.getDefaultInstance(),
        "Different type to UpdateBrokerageContract");
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#getDefaultInstanceForType()}
   */
  @Test
  public void testUpdateBrokerageContractGetDefaultInstanceForType() {
    // Arrange
    StorageContract.UpdateBrokerageContract defaultInstance = StorageContract.UpdateBrokerageContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#getSerializedSize()}
   */
  @Test
  public void testUpdateBrokerageContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, StorageContract.UpdateBrokerageContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#isInitialized()}
   */
  @Test
  public void testUpdateBrokerageContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(StorageContract.UpdateBrokerageContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testUpdateBrokerageContractNewInstance() {
    // Arrange
    StorageContract.UpdateBrokerageContract defaultInstance = StorageContract.UpdateBrokerageContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof StorageContract.UpdateBrokerageContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(StorageContract.UpdateBrokerageContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.UpdateBrokerageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.UpdateBrokerageContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        StorageContract.UpdateBrokerageContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.UpdateBrokerageContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateBrokerageContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.UpdateBrokerageContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseFrom(InputStream)}
   */
  @Test
  public void testUpdateBrokerageContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> StorageContract.UpdateBrokerageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseFrom(InputStream)}
   */
  @Test
  public void testUpdateBrokerageContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> StorageContract.UpdateBrokerageContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateBrokerageContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> StorageContract.UpdateBrokerageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link StorageContract.UpdateBrokerageContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testUpdateBrokerageContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> StorageContract.UpdateBrokerageContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
