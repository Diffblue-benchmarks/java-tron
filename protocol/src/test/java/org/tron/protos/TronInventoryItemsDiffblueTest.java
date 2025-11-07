package org.tron.protos;

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

public class TronInventoryItemsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronInventoryItems.InventoryItems#equals(Object)}
   *   <li>{@link TronInventoryItems.InventoryItems#hashCode()}
   * </ul>
   */
  @Test
  public void testInventoryItemsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TronInventoryItems.InventoryItems defaultInstance = TronInventoryItems.InventoryItems.getDefaultInstance();
    TronInventoryItems.InventoryItems defaultInstance2 = TronInventoryItems.InventoryItems.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TronInventoryItems.InventoryItems#equals(Object)}
   *   <li>{@link TronInventoryItems.InventoryItems#hashCode()}
   * </ul>
   */
  @Test
  public void testInventoryItemsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TronInventoryItems.InventoryItems defaultInstance = TronInventoryItems.InventoryItems.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TronInventoryItems.InventoryItems#equals(Object)}
   */
  @Test
  public void testInventoryItemsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TronInventoryItems.InventoryItems.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TronInventoryItems.InventoryItems#equals(Object)}
   */
  @Test
  public void testInventoryItemsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TronInventoryItems.InventoryItems.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TronInventoryItems.InventoryItems#equals(Object)}
   */
  @Test
  public void testInventoryItemsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TronInventoryItems.InventoryItems.getDefaultInstance(), "Different type to InventoryItems");
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#getDefaultInstanceForType()}
   */
  @Test
  public void testInventoryItemsGetDefaultInstanceForType() {
    // Arrange
    TronInventoryItems.InventoryItems defaultInstance = TronInventoryItems.InventoryItems.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TronInventoryItems.InventoryItems#getItemsCount()}
   */
  @Test
  public void testInventoryItemsGetItemsCount() {
    // Arrange, Act and Assert
    assertEquals(0, TronInventoryItems.InventoryItems.getDefaultInstance().getItemsCount());
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#getSerializedSize()}
   */
  @Test
  public void testInventoryItemsGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TronInventoryItems.InventoryItems.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TronInventoryItems.InventoryItems#isInitialized()}
   */
  @Test
  public void testInventoryItemsIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TronInventoryItems.InventoryItems.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testInventoryItemsNewInstance() {
    // Arrange
    TronInventoryItems.InventoryItems defaultInstance = TronInventoryItems.InventoryItems.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TronInventoryItems.InventoryItems);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TronInventoryItems.InventoryItems.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TronInventoryItems.InventoryItems.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TronInventoryItems.InventoryItems.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TronInventoryItems.InventoryItems.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TronInventoryItems.InventoryItems.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testInventoryItemsParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TronInventoryItems.InventoryItems.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseFrom(InputStream)}
   */
  @Test
  public void testInventoryItemsParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TronInventoryItems.InventoryItems.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseFrom(InputStream)}
   */
  @Test
  public void testInventoryItemsParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TronInventoryItems.InventoryItems.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testInventoryItemsParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TronInventoryItems.InventoryItems.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TronInventoryItems.InventoryItems#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testInventoryItemsParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TronInventoryItems.InventoryItems.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
