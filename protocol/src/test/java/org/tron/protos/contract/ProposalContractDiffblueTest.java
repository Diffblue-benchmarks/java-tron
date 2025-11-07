package org.tron.protos.contract;

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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.mockito.Mockito;

public class ProposalContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalApproveContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalApproveContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalApproveContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalApproveContract defaultInstance = ProposalContract.ProposalApproveContract
        .getDefaultInstance();
    ProposalContract.ProposalApproveContract defaultInstance2 = ProposalContract.ProposalApproveContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalApproveContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalApproveContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalApproveContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalApproveContract defaultInstance = ProposalContract.ProposalApproveContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#equals(Object)}
   */
  @Test
  public void testProposalApproveContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalApproveContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#equals(Object)}
   */
  @Test
  public void testProposalApproveContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalApproveContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#equals(Object)}
   */
  @Test
  public void testProposalApproveContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalApproveContract.getDefaultInstance(),
        "Different type to ProposalApproveContract");
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#getDefaultInstanceForType()}
   */
  @Test
  public void testProposalApproveContractGetDefaultInstanceForType() {
    // Arrange
    ProposalContract.ProposalApproveContract defaultInstance = ProposalContract.ProposalApproveContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#getSerializedSize()}
   */
  @Test
  public void testProposalApproveContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProposalContract.ProposalApproveContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#isInitialized()}
   */
  @Test
  public void testProposalApproveContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProposalContract.ProposalApproveContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testProposalApproveContractNewInstance() {
    // Arrange
    ProposalContract.ProposalApproveContract defaultInstance = ProposalContract.ProposalApproveContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ProposalContract.ProposalApproveContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProposalContract.ProposalApproveContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalApproveContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalApproveContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ProposalContract.ProposalApproveContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalApproveContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalApproveContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalApproveContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalApproveContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalApproveContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalApproveContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalApproveContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalApproveContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProposalContract.ProposalApproveContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalApproveContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalApproveContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalApproveContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#containsParameters(long)}
   */
  @Test
  public void testProposalCreateContractContainsParameters() {
    // Arrange, Act and Assert
    assertFalse(ProposalContract.ProposalCreateContract.getDefaultInstance().containsParameters(1L));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalCreateContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalCreateContract defaultInstance = ProposalContract.ProposalCreateContract
        .getDefaultInstance();
    ProposalContract.ProposalCreateContract defaultInstance2 = ProposalContract.ProposalCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalCreateContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalCreateContract defaultInstance = ProposalContract.ProposalCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#equals(Object)}
   */
  @Test
  public void testProposalCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#equals(Object)}
   */
  @Test
  public void testProposalCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalCreateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#equals(Object)}
   */
  @Test
  public void testProposalCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalCreateContract.getDefaultInstance(),
        "Different type to ProposalCreateContract");
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testProposalCreateContractGetDefaultInstanceForType() {
    // Arrange
    ProposalContract.ProposalCreateContract defaultInstance = ProposalContract.ProposalCreateContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getParameters()}
   */
  @Test
  public void testProposalCreateContractGetParameters() {
    // Arrange, Act and Assert
    assertTrue(ProposalContract.ProposalCreateContract.getDefaultInstance().getParameters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getParametersCount()}
   */
  @Test
  public void testProposalCreateContractGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getParametersMap()}
   */
  @Test
  public void testProposalCreateContractGetParametersMap() {
    // Arrange, Act and Assert
    assertTrue(ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getParametersOrDefault(long, long)}
   */
  @Test
  public void testProposalCreateContractGetParametersOrDefault() {
    // Arrange, Act and Assert
    assertEquals(42L, ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersOrDefault(5L, 42L));
    assertEquals(42L, ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersOrDefault(1L, 42L));
    assertEquals(42L, ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersOrDefault(0L, 42L));
    assertEquals(42L, ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersOrDefault(-1L, 42L));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getParametersOrThrow(long)}
   */
  @Test
  public void testProposalCreateContractGetParametersOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProposalContract.ProposalCreateContract.getDefaultInstance().getParametersOrThrow(1L));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#getSerializedSize()}
   */
  @Test
  public void testProposalCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProposalContract.ProposalCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#internalGetMapFieldReflection(int)}
   */
  @Test
  public void testProposalCreateContractInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ProposalContract.ProposalCreateContract.getDefaultInstance()
        .internalGetMapFieldReflection(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#internalGetMapFieldReflection(int)}
   */
  @Test
  public void testProposalCreateContractInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = ProposalContract.ProposalCreateContract
        .getDefaultInstance()
        .internalGetMapFieldReflection(2);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#isInitialized()}
   */
  @Test
  public void testProposalCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProposalContract.ProposalCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testProposalCreateContractNewInstance() {
    // Arrange
    ProposalContract.ProposalCreateContract defaultInstance = ProposalContract.ProposalCreateContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ProposalContract.ProposalCreateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProposalContract.ProposalCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ProposalContract.ProposalCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ProposalContract.ProposalCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ProposalContract.ProposalCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalCreateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalCreateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProposalContract.ProposalCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalCreateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalDeleteContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalDeleteContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalDeleteContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalDeleteContract defaultInstance = ProposalContract.ProposalDeleteContract
        .getDefaultInstance();
    ProposalContract.ProposalDeleteContract defaultInstance2 = ProposalContract.ProposalDeleteContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProposalContract.ProposalDeleteContract#equals(Object)}
   *   <li>{@link ProposalContract.ProposalDeleteContract#hashCode()}
   * </ul>
   */
  @Test
  public void testProposalDeleteContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProposalContract.ProposalDeleteContract defaultInstance = ProposalContract.ProposalDeleteContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#equals(Object)}
   */
  @Test
  public void testProposalDeleteContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalDeleteContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#equals(Object)}
   */
  @Test
  public void testProposalDeleteContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalDeleteContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#equals(Object)}
   */
  @Test
  public void testProposalDeleteContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProposalContract.ProposalDeleteContract.getDefaultInstance(),
        "Different type to ProposalDeleteContract");
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#getDefaultInstanceForType()}
   */
  @Test
  public void testProposalDeleteContractGetDefaultInstanceForType() {
    // Arrange
    ProposalContract.ProposalDeleteContract defaultInstance = ProposalContract.ProposalDeleteContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#getSerializedSize()}
   */
  @Test
  public void testProposalDeleteContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProposalContract.ProposalDeleteContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#isInitialized()}
   */
  @Test
  public void testProposalDeleteContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProposalContract.ProposalDeleteContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testProposalDeleteContractNewInstance() {
    // Arrange
    ProposalContract.ProposalDeleteContract defaultInstance = ProposalContract.ProposalDeleteContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ProposalContract.ProposalDeleteContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProposalContract.ProposalDeleteContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalDeleteContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalDeleteContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ProposalContract.ProposalDeleteContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalDeleteContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalDeleteContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalDeleteContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalDeleteContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProposalContract.ProposalDeleteContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseFrom(InputStream)}
   */
  @Test
  public void testProposalDeleteContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProposalContract.ProposalDeleteContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalDeleteContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProposalContract.ProposalDeleteContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ProposalContract.ProposalDeleteContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testProposalDeleteContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProposalContract.ProposalDeleteContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
