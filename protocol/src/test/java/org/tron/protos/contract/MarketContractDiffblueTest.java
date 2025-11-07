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

public class MarketContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarketContract.MarketCancelOrderContract#equals(Object)}
   *   <li>{@link MarketContract.MarketCancelOrderContract#hashCode()}
   * </ul>
   */
  @Test
  public void testMarketCancelOrderContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MarketContract.MarketCancelOrderContract defaultInstance = MarketContract.MarketCancelOrderContract
        .getDefaultInstance();
    MarketContract.MarketCancelOrderContract defaultInstance2 = MarketContract.MarketCancelOrderContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarketContract.MarketCancelOrderContract#equals(Object)}
   *   <li>{@link MarketContract.MarketCancelOrderContract#hashCode()}
   * </ul>
   */
  @Test
  public void testMarketCancelOrderContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MarketContract.MarketCancelOrderContract defaultInstance = MarketContract.MarketCancelOrderContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#equals(Object)}
   */
  @Test
  public void testMarketCancelOrderContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketCancelOrderContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#equals(Object)}
   */
  @Test
  public void testMarketCancelOrderContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketCancelOrderContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#equals(Object)}
   */
  @Test
  public void testMarketCancelOrderContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketCancelOrderContract.getDefaultInstance(),
        "Different type to MarketCancelOrderContract");
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#getDefaultInstanceForType()}
   */
  @Test
  public void testMarketCancelOrderContractGetDefaultInstanceForType() {
    // Arrange
    MarketContract.MarketCancelOrderContract defaultInstance = MarketContract.MarketCancelOrderContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#getSerializedSize()}
   */
  @Test
  public void testMarketCancelOrderContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MarketContract.MarketCancelOrderContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#isInitialized()}
   */
  @Test
  public void testMarketCancelOrderContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MarketContract.MarketCancelOrderContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testMarketCancelOrderContractNewInstance() {
    // Arrange
    MarketContract.MarketCancelOrderContract defaultInstance = MarketContract.MarketCancelOrderContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MarketContract.MarketCancelOrderContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MarketContract.MarketCancelOrderContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketCancelOrderContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MarketContract.MarketCancelOrderContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        MarketContract.MarketCancelOrderContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketCancelOrderContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketCancelOrderContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MarketContract.MarketCancelOrderContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseFrom(InputStream)}
   */
  @Test
  public void testMarketCancelOrderContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketCancelOrderContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseFrom(InputStream)}
   */
  @Test
  public void testMarketCancelOrderContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MarketContract.MarketCancelOrderContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketCancelOrderContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MarketContract.MarketCancelOrderContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketCancelOrderContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketCancelOrderContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MarketContract.MarketCancelOrderContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarketContract.MarketSellAssetContract#equals(Object)}
   *   <li>{@link MarketContract.MarketSellAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testMarketSellAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MarketContract.MarketSellAssetContract defaultInstance = MarketContract.MarketSellAssetContract
        .getDefaultInstance();
    MarketContract.MarketSellAssetContract defaultInstance2 = MarketContract.MarketSellAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MarketContract.MarketSellAssetContract#equals(Object)}
   *   <li>{@link MarketContract.MarketSellAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testMarketSellAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MarketContract.MarketSellAssetContract defaultInstance = MarketContract.MarketSellAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#equals(Object)}
   */
  @Test
  public void testMarketSellAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketSellAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#equals(Object)}
   */
  @Test
  public void testMarketSellAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketSellAssetContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#equals(Object)}
   */
  @Test
  public void testMarketSellAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MarketContract.MarketSellAssetContract.getDefaultInstance(),
        "Different type to MarketSellAssetContract");
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#getDefaultInstanceForType()}
   */
  @Test
  public void testMarketSellAssetContractGetDefaultInstanceForType() {
    // Arrange
    MarketContract.MarketSellAssetContract defaultInstance = MarketContract.MarketSellAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#getSerializedSize()}
   */
  @Test
  public void testMarketSellAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MarketContract.MarketSellAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#isInitialized()}
   */
  @Test
  public void testMarketSellAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MarketContract.MarketSellAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testMarketSellAssetContractNewInstance() {
    // Arrange
    MarketContract.MarketSellAssetContract defaultInstance = MarketContract.MarketSellAssetContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MarketContract.MarketSellAssetContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MarketContract.MarketSellAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketSellAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MarketContract.MarketSellAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        MarketContract.MarketSellAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketSellAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketSellAssetContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MarketContract.MarketSellAssetContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testMarketSellAssetContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MarketContract.MarketSellAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testMarketSellAssetContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MarketContract.MarketSellAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketSellAssetContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MarketContract.MarketSellAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MarketContract.MarketSellAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMarketSellAssetContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MarketContract.MarketSellAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
