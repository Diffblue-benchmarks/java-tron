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

public class VoteAssetContractOuterClassDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VoteAssetContractOuterClass.VoteAssetContract#equals(Object)}
   *   <li>{@link VoteAssetContractOuterClass.VoteAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VoteAssetContractOuterClass.VoteAssetContract defaultInstance = VoteAssetContractOuterClass.VoteAssetContract
        .getDefaultInstance();
    VoteAssetContractOuterClass.VoteAssetContract defaultInstance2 = VoteAssetContractOuterClass.VoteAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VoteAssetContractOuterClass.VoteAssetContract#equals(Object)}
   *   <li>{@link VoteAssetContractOuterClass.VoteAssetContract#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VoteAssetContractOuterClass.VoteAssetContract defaultInstance = VoteAssetContractOuterClass.VoteAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#equals(Object)}
   */
  @Test
  public void testVoteAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#equals(Object)}
   */
  @Test
  public void testVoteAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#equals(Object)}
   */
  @Test
  public void testVoteAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance(),
        "Different type to VoteAssetContract");
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#getDefaultInstanceForType()}
   */
  @Test
  public void testVoteAssetContractGetDefaultInstanceForType() {
    // Arrange
    VoteAssetContractOuterClass.VoteAssetContract defaultInstance = VoteAssetContractOuterClass.VoteAssetContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#getSerializedSize()}
   */
  @Test
  public void testVoteAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#getVoteAddressCount()}
   */
  @Test
  public void testVoteAssetContractGetVoteAddressCount() {
    // Arrange, Act and Assert
    assertEquals(0, VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance().getVoteAddressCount());
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#isInitialized()}
   */
  @Test
  public void testVoteAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(VoteAssetContractOuterClass.VoteAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testVoteAssetContractNewInstance() {
    // Arrange
    VoteAssetContractOuterClass.VoteAssetContract defaultInstance = VoteAssetContractOuterClass.VoteAssetContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof VoteAssetContractOuterClass.VoteAssetContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(VoteAssetContractOuterClass.VoteAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> VoteAssetContractOuterClass.VoteAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> VoteAssetContractOuterClass.VoteAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(VoteAssetContractOuterClass.VoteAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> VoteAssetContractOuterClass.VoteAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteAssetContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> VoteAssetContractOuterClass.VoteAssetContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testVoteAssetContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> VoteAssetContractOuterClass.VoteAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseFrom(InputStream)}
   */
  @Test
  public void testVoteAssetContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> VoteAssetContractOuterClass.VoteAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteAssetContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> VoteAssetContractOuterClass.VoteAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link VoteAssetContractOuterClass.VoteAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteAssetContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> VoteAssetContractOuterClass.VoteAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
