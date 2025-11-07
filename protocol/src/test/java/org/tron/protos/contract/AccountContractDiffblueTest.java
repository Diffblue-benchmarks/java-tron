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
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.protos.Protocol;

public class AccountContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountCreateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountContract.AccountCreateContract defaultInstance = AccountContract.AccountCreateContract.getDefaultInstance();
    AccountContract.AccountCreateContract defaultInstance2 = AccountContract.AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountCreateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountCreateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountContract.AccountCreateContract defaultInstance = AccountContract.AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#equals(Object)}
   */
  @Test
  public void testAccountCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#equals(Object)}
   */
  @Test
  public void testAccountCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountCreateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#equals(Object)}
   */
  @Test
  public void testAccountCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountCreateContract.getDefaultInstance(),
        "Different type to AccountCreateContract");
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testAccountCreateContractGetDefaultInstanceForType() {
    // Arrange
    AccountContract.AccountCreateContract defaultInstance = AccountContract.AccountCreateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#getSerializedSize()}
   */
  @Test
  public void testAccountCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountContract.AccountCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link AccountContract.AccountCreateContract#getType()}
   */
  @Test
  public void testAccountCreateContractGetType() {
    // Arrange, Act and Assert
    assertEquals(Protocol.AccountType.Normal, AccountContract.AccountCreateContract.getDefaultInstance().getType());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#isInitialized()}
   */
  @Test
  public void testAccountCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountContract.AccountCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAccountCreateContractNewInstance() {
    // Arrange
    AccountContract.AccountCreateContract defaultInstance = AccountContract.AccountCreateContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AccountContract.AccountCreateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountContract.AccountCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        AccountContract.AccountCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountCreateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountCreateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountCreateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountCreateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountCreateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountContract.AccountCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountCreateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountPermissionUpdateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountPermissionUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountPermissionUpdateContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    AccountContract.AccountPermissionUpdateContract defaultInstance = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountPermissionUpdateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountPermissionUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountPermissionUpdateContractEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    AccountContract.AccountPermissionUpdateContract defaultInstance = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();
    AccountContract.AccountPermissionUpdateContract defaultInstance2 = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#equals(Object)}
   */
  @Test
  public void testAccountPermissionUpdateContractEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountPermissionUpdateContract.getDefaultInstance(),
        "Different type to AccountPermissionUpdateContract");
    assertNotEquals(AccountContract.AccountPermissionUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#equals(Object)}
   */
  @Test
  public void testAccountPermissionUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountPermissionUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#getActivesCount()}
   */
  @Test
  public void testAccountPermissionUpdateContractGetActivesCount() {
    // Arrange, Act and Assert
    assertEquals(0, AccountContract.AccountPermissionUpdateContract.getDefaultInstance().getActivesCount());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testAccountPermissionUpdateContractGetDefaultInstanceForType() {
    // Arrange
    AccountContract.AccountPermissionUpdateContract defaultInstance = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#getSerializedSize()}
   */
  @Test
  public void testAccountPermissionUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountContract.AccountPermissionUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#hasOwner()}
   */
  @Test
  public void testAccountPermissionUpdateContractHasOwner() {
    // Arrange, Act and Assert
    assertFalse(AccountContract.AccountPermissionUpdateContract.getDefaultInstance().hasOwner());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#hasWitness()}
   */
  @Test
  public void testAccountPermissionUpdateContractHasWitness() {
    // Arrange, Act and Assert
    assertFalse(AccountContract.AccountPermissionUpdateContract.getDefaultInstance().hasWitness());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#isInitialized()}
   */
  @Test
  public void testAccountPermissionUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountContract.AccountPermissionUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAccountPermissionUpdateContractNewInstance() {
    // Arrange
    AccountContract.AccountPermissionUpdateContract defaultInstance = AccountContract.AccountPermissionUpdateContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AccountContract.AccountPermissionUpdateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountContract.AccountPermissionUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountPermissionUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountPermissionUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountContract.AccountPermissionUpdateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountPermissionUpdateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountPermissionUpdateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountPermissionUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountPermissionUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountPermissionUpdateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountPermissionUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountPermissionUpdateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountPermissionUpdateContract
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountUpdateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountUpdateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountContract.AccountUpdateContract defaultInstance = AccountContract.AccountUpdateContract.getDefaultInstance();
    AccountContract.AccountUpdateContract defaultInstance2 = AccountContract.AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.AccountUpdateContract#equals(Object)}
   *   <li>{@link AccountContract.AccountUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  public void testAccountUpdateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountContract.AccountUpdateContract defaultInstance = AccountContract.AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#equals(Object)}
   */
  @Test
  public void testAccountUpdateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#equals(Object)}
   */
  @Test
  public void testAccountUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#equals(Object)}
   */
  @Test
  public void testAccountUpdateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.AccountUpdateContract.getDefaultInstance(),
        "Different type to AccountUpdateContract");
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  public void testAccountUpdateContractGetDefaultInstanceForType() {
    // Arrange
    AccountContract.AccountUpdateContract defaultInstance = AccountContract.AccountUpdateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#getSerializedSize()}
   */
  @Test
  public void testAccountUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountContract.AccountUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#isInitialized()}
   */
  @Test
  public void testAccountUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountContract.AccountUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAccountUpdateContractNewInstance() {
    // Arrange
    AccountContract.AccountUpdateContract defaultInstance = AccountContract.AccountUpdateContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AccountContract.AccountUpdateContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountContract.AccountUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        AccountContract.AccountUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountUpdateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountUpdateContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountUpdateContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountUpdateContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.AccountUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseFrom(InputStream)}
   */
  @Test
  public void testAccountUpdateContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.AccountUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountUpdateContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountContract.AccountUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.AccountUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAccountUpdateContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.AccountUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.SetAccountIdContract#equals(Object)}
   *   <li>{@link AccountContract.SetAccountIdContract#hashCode()}
   * </ul>
   */
  @Test
  public void testSetAccountIdContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountContract.SetAccountIdContract defaultInstance = AccountContract.SetAccountIdContract.getDefaultInstance();
    AccountContract.SetAccountIdContract defaultInstance2 = AccountContract.SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountContract.SetAccountIdContract#equals(Object)}
   *   <li>{@link AccountContract.SetAccountIdContract#hashCode()}
   * </ul>
   */
  @Test
  public void testSetAccountIdContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountContract.SetAccountIdContract defaultInstance = AccountContract.SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#equals(Object)}
   */
  @Test
  public void testSetAccountIdContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.SetAccountIdContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#equals(Object)}
   */
  @Test
  public void testSetAccountIdContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.SetAccountIdContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#equals(Object)}
   */
  @Test
  public void testSetAccountIdContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AccountContract.SetAccountIdContract.getDefaultInstance(),
        "Different type to SetAccountIdContract");
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#getDefaultInstanceForType()}
   */
  @Test
  public void testSetAccountIdContractGetDefaultInstanceForType() {
    // Arrange
    AccountContract.SetAccountIdContract defaultInstance = AccountContract.SetAccountIdContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#getSerializedSize()}
   */
  @Test
  public void testSetAccountIdContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AccountContract.SetAccountIdContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#isInitialized()}
   */
  @Test
  public void testSetAccountIdContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AccountContract.SetAccountIdContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testSetAccountIdContractNewInstance() {
    // Arrange
    AccountContract.SetAccountIdContract defaultInstance = AccountContract.SetAccountIdContract.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AccountContract.SetAccountIdContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AccountContract.SetAccountIdContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.SetAccountIdContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.SetAccountIdContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        AccountContract.SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountContract.SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSetAccountIdContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.SetAccountIdContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  public void testSetAccountIdContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AccountContract.SetAccountIdContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseFrom(InputStream)}
   */
  @Test
  public void testSetAccountIdContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AccountContract.SetAccountIdContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSetAccountIdContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AccountContract.SetAccountIdContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AccountContract.SetAccountIdContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSetAccountIdContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AccountContract.SetAccountIdContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
