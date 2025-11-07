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

public class WitnessContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.VoteWitnessContract#equals(Object)}
   *   <li>{@link WitnessContract.VoteWitnessContract#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteWitnessContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessContract.VoteWitnessContract defaultInstance = WitnessContract.VoteWitnessContract.getDefaultInstance();
    WitnessContract.VoteWitnessContract defaultInstance2 = WitnessContract.VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.VoteWitnessContract#equals(Object)}
   *   <li>{@link WitnessContract.VoteWitnessContract#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteWitnessContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessContract.VoteWitnessContract defaultInstance = WitnessContract.VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link WitnessContract.VoteWitnessContract#equals(Object)}
   */
  @Test
  public void testVoteWitnessContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link WitnessContract.VoteWitnessContract#equals(Object)}
   */
  @Test
  public void testVoteWitnessContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link WitnessContract.VoteWitnessContract#equals(Object)}
   */
  @Test
  public void testVoteWitnessContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.getDefaultInstance(), "Different type to VoteWitnessContract");
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#getDefaultInstanceForType()}
   */
  @Test
  public void testVoteWitnessContractGetDefaultInstanceForType() {
    // Arrange
    WitnessContract.VoteWitnessContract defaultInstance = WitnessContract.VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#getSerializedSize()}
   */
  @Test
  public void testVoteWitnessContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessContract.VoteWitnessContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#getVotesCount()}
   */
  @Test
  public void testVoteWitnessContractGetVotesCount() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessContract.VoteWitnessContract.getDefaultInstance().getVotesCount());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#isInitialized()}
   */
  @Test
  public void testVoteWitnessContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessContract.VoteWitnessContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testVoteWitnessContractNewInstance() {
    // Arrange
    WitnessContract.VoteWitnessContract defaultInstance = WitnessContract.VoteWitnessContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof WitnessContract.VoteWitnessContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessContract.VoteWitnessContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.VoteWitnessContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.VoteWitnessContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessContract.VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessContract.VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.VoteWitnessContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.VoteWitnessContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessContract.VoteWitnessContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.VoteWitnessContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.VoteWitnessContract.Vote#equals(Object)}
   *   <li>{@link WitnessContract.VoteWitnessContract.Vote#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteWitnessContract_VoteEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessContract.VoteWitnessContract.Vote defaultInstance = WitnessContract.VoteWitnessContract.Vote
        .getDefaultInstance();
    WitnessContract.VoteWitnessContract.Vote defaultInstance2 = WitnessContract.VoteWitnessContract.Vote
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.VoteWitnessContract.Vote#equals(Object)}
   *   <li>{@link WitnessContract.VoteWitnessContract.Vote#hashCode()}
   * </ul>
   */
  @Test
  public void testVoteWitnessContract_VoteEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessContract.VoteWitnessContract.Vote defaultInstance = WitnessContract.VoteWitnessContract.Vote
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  public void testVoteWitnessContract_VoteEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.Vote.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  public void testVoteWitnessContract_VoteEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.Vote.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  public void testVoteWitnessContract_VoteEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.VoteWitnessContract.Vote.getDefaultInstance(), "Different type to Vote");
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#getDefaultInstanceForType()}
   */
  @Test
  public void testVoteWitnessContract_VoteGetDefaultInstanceForType() {
    // Arrange
    WitnessContract.VoteWitnessContract.Vote defaultInstance = WitnessContract.VoteWitnessContract.Vote
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#getSerializedSize()}
   */
  @Test
  public void testVoteWitnessContract_VoteGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessContract.VoteWitnessContract.Vote.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#isInitialized()}
   */
  @Test
  public void testVoteWitnessContract_VoteIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessContract.VoteWitnessContract.Vote.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testVoteWitnessContract_VoteNewInstance() {
    // Arrange
    WitnessContract.VoteWitnessContract.Vote defaultInstance = WitnessContract.VoteWitnessContract.Vote
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof WitnessContract.VoteWitnessContract.Vote);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessContract.VoteWitnessContract.Vote.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.VoteWitnessContract.Vote.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.VoteWitnessContract.Vote.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        WitnessContract.VoteWitnessContract.Vote.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.VoteWitnessContract.Vote.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.VoteWitnessContract.Vote
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.VoteWitnessContract.Vote.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.VoteWitnessContract.Vote.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessContract.VoteWitnessContract.Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testVoteWitnessContract_VoteParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.VoteWitnessContract.Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.WitnessCreateContract#equals(Object)}
   *   <li>{@link WitnessContract.WitnessCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testWitnessCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessContract.WitnessCreateContract defaultInstance = WitnessContract.WitnessCreateContract.getDefaultInstance();
    WitnessContract.WitnessCreateContract defaultInstance2 = WitnessContract.WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.WitnessCreateContract#equals(Object)}
   *   <li>{@link WitnessContract.WitnessCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testWitnessCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessContract.WitnessCreateContract defaultInstance = WitnessContract.WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#equals(Object)}
   */
  @Test
  public void testWitnessCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#equals(Object)}
   */
  @Test
  public void testWitnessCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessCreateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#equals(Object)}
   */
  @Test
  public void testWitnessCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessCreateContract.getDefaultInstance(),
        "Different type to WitnessCreateContract");
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testWitnessCreateContractGetDefaultInstanceForType() {
    // Arrange
    WitnessContract.WitnessCreateContract defaultInstance = WitnessContract.WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#getSerializedSize()}
   */
  @Test
  public void testWitnessCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessContract.WitnessCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#isInitialized()}
   */
  @Test
  public void testWitnessCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessContract.WitnessCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testWitnessCreateContractNewInstance() {
    // Arrange
    WitnessContract.WitnessCreateContract defaultInstance = WitnessContract.WitnessCreateContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof WitnessContract.WitnessCreateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessContract.WitnessCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.WitnessCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        WitnessContract.WitnessCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessCreateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.WitnessCreateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testWitnessCreateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testWitnessCreateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.WitnessCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessCreateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessContract.WitnessCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessCreateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.WitnessCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.WitnessUpdateContract#equals(Object)}
   *   <li>{@link WitnessContract.WitnessUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testWitnessUpdateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessContract.WitnessUpdateContract defaultInstance = WitnessContract.WitnessUpdateContract.getDefaultInstance();
    WitnessContract.WitnessUpdateContract defaultInstance2 = WitnessContract.WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessContract.WitnessUpdateContract#equals(Object)}
   *   <li>{@link WitnessContract.WitnessUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testWitnessUpdateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessContract.WitnessUpdateContract defaultInstance = WitnessContract.WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#equals(Object)}
   */
  @Test
  public void testWitnessUpdateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#equals(Object)}
   */
  @Test
  public void testWitnessUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#equals(Object)}
   */
  @Test
  public void testWitnessUpdateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessContract.WitnessUpdateContract.getDefaultInstance(),
        "Different type to WitnessUpdateContract");
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testWitnessUpdateContractGetDefaultInstanceForType() {
    // Arrange
    WitnessContract.WitnessUpdateContract defaultInstance = WitnessContract.WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#getSerializedSize()}
   */
  @Test
  public void testWitnessUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessContract.WitnessUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#isInitialized()}
   */
  @Test
  public void testWitnessUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessContract.WitnessUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testWitnessUpdateContractNewInstance() {
    // Arrange
    WitnessContract.WitnessUpdateContract defaultInstance = WitnessContract.WitnessUpdateContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof WitnessContract.WitnessUpdateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessContract.WitnessUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.WitnessUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        WitnessContract.WitnessUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessUpdateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessUpdateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.WitnessUpdateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testWitnessUpdateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessContract.WitnessUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testWitnessUpdateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessContract.WitnessUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessUpdateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessContract.WitnessUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link WitnessContract.WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testWitnessUpdateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessContract.WitnessUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
