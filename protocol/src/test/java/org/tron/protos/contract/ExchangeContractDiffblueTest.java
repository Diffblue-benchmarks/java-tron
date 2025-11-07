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

public class ExchangeContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeCreateContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeCreateContract defaultInstance = ExchangeContract.ExchangeCreateContract
        .getDefaultInstance();
    ExchangeContract.ExchangeCreateContract defaultInstance2 = ExchangeContract.ExchangeCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeCreateContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeCreateContract defaultInstance = ExchangeContract.ExchangeCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#equals(Object)}
   */
  @Test
  public void testExchangeCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#equals(Object)}
   */
  @Test
  public void testExchangeCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeCreateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#equals(Object)}
   */
  @Test
  public void testExchangeCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeCreateContract.getDefaultInstance(),
        "Different type to ExchangeCreateContract");
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testExchangeCreateContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeContract.ExchangeCreateContract defaultInstance = ExchangeContract.ExchangeCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#getSerializedSize()}
   */
  @Test
  public void testExchangeCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeContract.ExchangeCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#isInitialized()}
   */
  @Test
  public void testExchangeCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeContract.ExchangeCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testExchangeCreateContractNewInstance() {
    // Arrange
    ExchangeContract.ExchangeCreateContract defaultInstance = ExchangeContract.ExchangeCreateContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ExchangeContract.ExchangeCreateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeContract.ExchangeCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ExchangeContract.ExchangeCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeCreateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeCreateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeCreateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeCreateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeCreateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeContract.ExchangeCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeCreateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeInjectContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeInjectContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeInjectContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeInjectContract defaultInstance = ExchangeContract.ExchangeInjectContract
        .getDefaultInstance();
    ExchangeContract.ExchangeInjectContract defaultInstance2 = ExchangeContract.ExchangeInjectContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeInjectContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeInjectContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeInjectContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeInjectContract defaultInstance = ExchangeContract.ExchangeInjectContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#equals(Object)}
   */
  @Test
  public void testExchangeInjectContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeInjectContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#equals(Object)}
   */
  @Test
  public void testExchangeInjectContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeInjectContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#equals(Object)}
   */
  @Test
  public void testExchangeInjectContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeInjectContract.getDefaultInstance(),
        "Different type to ExchangeInjectContract");
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#getDefaultInstanceForType()}
   */
  @Test
  public void testExchangeInjectContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeContract.ExchangeInjectContract defaultInstance = ExchangeContract.ExchangeInjectContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#getSerializedSize()}
   */
  @Test
  public void testExchangeInjectContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeContract.ExchangeInjectContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#isInitialized()}
   */
  @Test
  public void testExchangeInjectContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeContract.ExchangeInjectContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testExchangeInjectContractNewInstance() {
    // Arrange
    ExchangeContract.ExchangeInjectContract defaultInstance = ExchangeContract.ExchangeInjectContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ExchangeContract.ExchangeInjectContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeContract.ExchangeInjectContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeInjectContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeInjectContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ExchangeContract.ExchangeInjectContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeInjectContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeInjectContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeInjectContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeInjectContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeInjectContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeInjectContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeInjectContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeInjectContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeContract.ExchangeInjectContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeInjectContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeInjectContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeInjectContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeTransactionContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeTransactionContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeTransactionContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeTransactionContract defaultInstance = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();
    ExchangeContract.ExchangeTransactionContract defaultInstance2 = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeTransactionContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeTransactionContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeTransactionContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeTransactionContract defaultInstance = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#equals(Object)}
   */
  @Test
  public void testExchangeTransactionContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeTransactionContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#equals(Object)}
   */
  @Test
  public void testExchangeTransactionContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeTransactionContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#equals(Object)}
   */
  @Test
  public void testExchangeTransactionContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeTransactionContract.getDefaultInstance(),
        "Different type to ExchangeTransactionContract");
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#getDefaultInstanceForType()}
   */
  @Test
  public void testExchangeTransactionContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeContract.ExchangeTransactionContract defaultInstance = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#getSerializedSize()}
   */
  @Test
  public void testExchangeTransactionContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeContract.ExchangeTransactionContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#isInitialized()}
   */
  @Test
  public void testExchangeTransactionContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeContract.ExchangeTransactionContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testExchangeTransactionContractNewInstance() {
    // Arrange
    ExchangeContract.ExchangeTransactionContract defaultInstance = ExchangeContract.ExchangeTransactionContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ExchangeContract.ExchangeTransactionContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeContract.ExchangeTransactionContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeTransactionContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeTransactionContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeContract.ExchangeTransactionContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeTransactionContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeTransactionContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeTransactionContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeTransactionContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeTransactionContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeTransactionContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeTransactionContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeTransactionContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeContract.ExchangeTransactionContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeTransactionContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeTransactionContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeTransactionContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeWithdrawContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeWithdrawContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeWithdrawContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeWithdrawContract defaultInstance = ExchangeContract.ExchangeWithdrawContract
        .getDefaultInstance();
    ExchangeContract.ExchangeWithdrawContract defaultInstance2 = ExchangeContract.ExchangeWithdrawContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExchangeContract.ExchangeWithdrawContract#equals(Object)}
   *   <li>{@link ExchangeContract.ExchangeWithdrawContract#hashCode()}
   * </ul>
   */
  @Test
  public void testExchangeWithdrawContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExchangeContract.ExchangeWithdrawContract defaultInstance = ExchangeContract.ExchangeWithdrawContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  public void testExchangeWithdrawContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeWithdrawContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  public void testExchangeWithdrawContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeWithdrawContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#equals(Object)}
   */
  @Test
  public void testExchangeWithdrawContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExchangeContract.ExchangeWithdrawContract.getDefaultInstance(),
        "Different type to ExchangeWithdrawContract");
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#getDefaultInstanceForType()}
   */
  @Test
  public void testExchangeWithdrawContractGetDefaultInstanceForType() {
    // Arrange
    ExchangeContract.ExchangeWithdrawContract defaultInstance = ExchangeContract.ExchangeWithdrawContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#getSerializedSize()}
   */
  @Test
  public void testExchangeWithdrawContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ExchangeContract.ExchangeWithdrawContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#isInitialized()}
   */
  @Test
  public void testExchangeWithdrawContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ExchangeContract.ExchangeWithdrawContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testExchangeWithdrawContractNewInstance() {
    // Arrange
    ExchangeContract.ExchangeWithdrawContract defaultInstance = ExchangeContract.ExchangeWithdrawContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ExchangeContract.ExchangeWithdrawContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ExchangeContract.ExchangeWithdrawContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeWithdrawContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeWithdrawContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ExchangeContract.ExchangeWithdrawContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeWithdrawContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeWithdrawContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ExchangeContract.ExchangeWithdrawContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeWithdrawContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ExchangeContract.ExchangeWithdrawContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseFrom(InputStream)}
   */
  @Test
  public void testExchangeWithdrawContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeWithdrawContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeWithdrawContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ExchangeContract.ExchangeWithdrawContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ExchangeContract.ExchangeWithdrawContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testExchangeWithdrawContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ExchangeContract.ExchangeWithdrawContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
