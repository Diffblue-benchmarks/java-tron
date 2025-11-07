package org.tron.api;

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
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.api.GrpcAPI.AccountResourceMessage;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkRequest;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkRequest.Builder;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkResponse;
import org.tron.api.ZksnarkGrpcAPI.ZksnarkResponse.Code;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.raw;

public class ZksnarkGrpcAPIDiffblueTest {
  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#equals(Object)}, and {@link ZksnarkRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ZksnarkRequest#equals(Object)}
   *   <li>{@link ZksnarkRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.equals(Object)", "int ZksnarkRequest.hashCode()"})
  public void testZksnarkRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ZksnarkRequest defaultInstance = ZksnarkRequest.getDefaultInstance();
    ZksnarkRequest defaultInstance2 = ZksnarkRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#equals(Object)}, and {@link ZksnarkRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ZksnarkRequest#equals(Object)}
   *   <li>{@link ZksnarkRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.equals(Object)", "int ZksnarkRequest.hashCode()"})
  public void testZksnarkRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ZksnarkRequest defaultInstance = ZksnarkRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.equals(Object)", "int ZksnarkRequest.hashCode()"})
  public void testZksnarkRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkRequest.getDefaultInstance(), 1);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.equals(Object)", "int ZksnarkRequest.hashCode()"})
  public void testZksnarkRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkRequest.getDefaultInstance(), null);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.equals(Object)", "int ZksnarkRequest.hashCode()"})
  public void testZksnarkRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkRequest.getDefaultInstance(), "Different type to ZksnarkRequest");
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.getDefaultInstanceForType()"})
  public void testZksnarkRequestGetDefaultInstanceForType() {
    // Arrange
    ZksnarkRequest defaultInstance = ZksnarkRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getDescriptor()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ZksnarkRequest.getDescriptor()"})
  public void testZksnarkRequestGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ZksnarkRequest.getDescriptor();

    // Assert
    assertEquals("ZksnarkRequest", actualDescriptor.getName());
    assertEquals("protocol.ZksnarkRequest", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ZksnarkRequest.getSerializedSize()"})
  public void testZksnarkRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ZksnarkRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getTransaction()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.Transaction ZksnarkRequest.getTransaction()"})
  public void testZksnarkRequestGetTransaction() {
    // Arrange and Act
    Transaction actualTransaction = ZksnarkRequest.getDefaultInstance().getTransaction();

    // Assert
    assertEquals("", actualTransaction.getInitializationErrorString());
    assertEquals(0, actualTransaction.getRetCount());
    assertEquals(0, actualTransaction.getSerializedSize());
    assertEquals(0, actualTransaction.getSignatureCount());
    assertFalse(actualTransaction.hasRawData());
    assertTrue(actualTransaction.findInitializationErrors().isEmpty());
    List<Result> retList = actualTransaction.getRetList();
    assertTrue(retList.isEmpty());
    assertTrue(actualTransaction.getSignatureList().isEmpty());
    assertTrue(actualTransaction.getAllFields().isEmpty());
    assertTrue(actualTransaction.isInitialized());
    assertSame(actualTransaction, actualTransaction.getDefaultInstanceForType());
    assertSame(retList, actualTransaction.getRetOrBuilderList());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getTxId()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getTxId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ZksnarkRequest.getTxId()"})
  public void testZksnarkRequestGetTxId() {
    // Arrange, Act and Assert
    assertEquals("", ZksnarkRequest.getDefaultInstance().getTxId());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#getTxIdBytes()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#getTxIdBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ZksnarkRequest.getTxIdBytes()"})
  public void testZksnarkRequestGetTxIdBytes() {
    // Arrange
    ZksnarkRequest defaultInstance = ZksnarkRequest.getDefaultInstance();

    // Act
    ByteString actualTxIdBytes = defaultInstance.getTxIdBytes();

    // Assert
    ByteString byteString = actualTxIdBytes.EMPTY;
    assertEquals(byteString, actualTxIdBytes);
    assertSame(byteString, defaultInstance.getSighash());
    raw rawData = defaultInstance.getTransaction().getRawData();
    assertSame(byteString, rawData.getData());
    assertSame(byteString, rawData.getRefBlockBytes());
    assertSame(byteString, rawData.getRefBlockHash());
    assertSame(byteString, rawData.getScripts());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#hasTransaction()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#hasTransaction()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.hasTransaction()"})
  public void testZksnarkRequestHasTransaction() {
    // Arrange, Act and Assert
    assertFalse(ZksnarkRequest.getDefaultInstance().hasTransaction());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#isInitialized()}.
   * <p>
   * Method under test: {@link ZksnarkRequest#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkRequest.isInitialized()"})
  public void testZksnarkRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ZksnarkRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkRequest actualParseDelimitedFromResult = ZksnarkRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ZksnarkRequest defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Transaction transaction = actualParseDelimitedFromResult.getTransaction();
    assertSame(transaction, defaultInstanceForType.getTransaction());
    assertSame(transaction, defaultInstanceForType.getTransactionOrBuilder());
    assertSame(transaction, actualParseDelimitedFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkRequest actualParseDelimitedFromResult = ZksnarkRequest.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Transaction transaction = actualParseDelimitedFromResult.getTransaction();
    assertSame(unknownFields, transaction.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(transaction, actualParseDelimitedFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ZksnarkRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkRequest actualParseDelimitedFromResult = ZksnarkRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ZksnarkRequest defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Transaction transaction = actualParseDelimitedFromResult.getTransaction();
    assertSame(transaction, defaultInstanceForType.getTransaction());
    assertSame(transaction, defaultInstanceForType.getTransactionOrBuilder());
    assertSame(transaction, actualParseDelimitedFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkRequest actualParseDelimitedFromResult = ZksnarkRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Transaction transaction = actualParseDelimitedFromResult.getTransaction();
    assertSame(unknownFields, transaction.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(transaction, actualParseDelimitedFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ZksnarkRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ZksnarkRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ZksnarkRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ZksnarkRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ZksnarkRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseDelimitedFrom(InputStream)"})
  public void testZksnarkRequestParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ZksnarkRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(byte[])"})
  public void testZksnarkRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(ByteBuffer)"})
  public void testZksnarkRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(ByteString)"})
  public void testZksnarkRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSighash = data.EMPTY;
    assertSame(expectedSighash, actualParseFromResult.getSighash());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSighash = data.EMPTY;
    assertSame(expectedSighash, actualParseFromResult.getSighash());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(CodedInputStream)"})
  public void testZksnarkRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream)"})
  public void testZksnarkRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Transaction transaction = actualParseFromResult.getTransaction();
    assertSame(unknownFields, transaction.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(transaction, actualParseFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream)"})
  public void testZksnarkRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ZksnarkRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTxId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getValueBalance());
    assertFalse(actualParseFromResult.hasTransaction());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ZksnarkRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream)"})
  public void testZksnarkRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkRequest {@link ZksnarkRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkRequest#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkRequest ZksnarkRequest.parseFrom(InputStream)"})
  public void testZksnarkRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ZksnarkRequest actualParseFromResult = ZksnarkRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Transaction transaction = actualParseFromResult.getTransaction();
    assertSame(unknownFields, transaction.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(transaction, actualParseFromResult.getTransactionOrBuilder());
    assertSame(transaction, transaction.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkRequest_Builder {@link ZksnarkRequest.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ZksnarkRequest.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ZksnarkRequest.Builder.getDescriptor()"})
  public void testZksnarkRequest_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("ZksnarkRequest", actualDescriptor.getName());
    assertEquals("protocol.ZksnarkRequest", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#equals(Object)}, and {@link ZksnarkResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ZksnarkResponse#equals(Object)}
   *   <li>{@link ZksnarkResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.equals(Object)", "int ZksnarkResponse.hashCode()"})
  public void testZksnarkResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ZksnarkResponse defaultInstance = ZksnarkResponse.getDefaultInstance();
    ZksnarkResponse defaultInstance2 = ZksnarkResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#equals(Object)}, and {@link ZksnarkResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ZksnarkResponse#equals(Object)}
   *   <li>{@link ZksnarkResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.equals(Object)", "int ZksnarkResponse.hashCode()"})
  public void testZksnarkResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ZksnarkResponse defaultInstance = ZksnarkResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.equals(Object)", "int ZksnarkResponse.hashCode()"})
  public void testZksnarkResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkResponse.getDefaultInstance(), 1);
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.equals(Object)", "int ZksnarkResponse.hashCode()"})
  public void testZksnarkResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkResponse.getDefaultInstance(), null);
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.equals(Object)", "int ZksnarkResponse.hashCode()"})
  public void testZksnarkResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ZksnarkResponse.getDefaultInstance(), "Different type to ZksnarkResponse");
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#getCode()}.
   * <p>
   * Method under test: {@link ZksnarkResponse#getCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.getCode()"})
  public void testZksnarkResponseGetCode() {
    // Arrange, Act and Assert
    assertEquals(Code.SUCCESS, ZksnarkResponse.getDefaultInstance().getCode());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ZksnarkResponse#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.getDefaultInstanceForType()"})
  public void testZksnarkResponseGetDefaultInstanceForType() {
    // Arrange
    ZksnarkResponse defaultInstance = ZksnarkResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#getDescriptor()}.
   * <p>
   * Method under test: {@link ZksnarkResponse#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ZksnarkResponse.getDescriptor()"})
  public void testZksnarkResponseGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ZksnarkResponse.getDescriptor();

    // Assert
    assertEquals("ZksnarkResponse", actualDescriptor.getName());
    assertEquals("protocol.ZksnarkResponse", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getEnumTypes().size());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link ZksnarkResponse#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ZksnarkResponse.getSerializedSize()"})
  public void testZksnarkResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ZksnarkResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#isInitialized()}.
   * <p>
   * Method under test: {@link ZksnarkResponse#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZksnarkResponse.isInitialized()"})
  public void testZksnarkResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ZksnarkResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream)"})
  public void testZksnarkResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkResponse actualParseDelimitedFromResult = ZksnarkResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Code.SUCCESS, actualParseDelimitedFromResult.getCode());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream)"})
  public void testZksnarkResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ZksnarkResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ZksnarkResponse actualParseDelimitedFromResult = ZksnarkResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Code.SUCCESS, actualParseDelimitedFromResult.getCode());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ZksnarkResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ZksnarkResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ZksnarkResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream)"})
  public void testZksnarkResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ZksnarkResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseDelimitedFrom(InputStream)"})
  public void testZksnarkResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(byte[])"})
  public void testZksnarkResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(ByteBuffer)"})
  public void testZksnarkResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(ByteString)"})
  public void testZksnarkResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(CodedInputStream)"})
  public void testZksnarkResponseParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream)"})
  public void testZksnarkResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream)"})
  public void testZksnarkResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ZksnarkResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(Code.SUCCESS, actualParseFromResult.getCode());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testZksnarkResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ZksnarkResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream)"})
  public void testZksnarkResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ZksnarkResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ZksnarkResponse {@link ZksnarkResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse ZksnarkResponse.parseFrom(InputStream)"})
  public void testZksnarkResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ZksnarkResponse actualParseFromResult = ZksnarkResponse.parseFrom((InputStream) null);

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ZksnarkResponse_Builder {@link ZksnarkResponse.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ZksnarkResponse.Builder.getDescriptor()"})
  public void testZksnarkResponse_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ZksnarkResponse.Builder.getDescriptor();

    // Assert
    assertEquals("ZksnarkResponse", actualDescriptor.getName());
    assertEquals("protocol.ZksnarkResponse", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getEnumTypes().size());
    assertEquals(1, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.forNumber(int)"})
  public void testZksnarkResponse_CodeForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Code.forNumber(42));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.forNumber(int)"})
  public void testZksnarkResponse_CodeForNumber_whenOne_thenReturnFailed() {
    // Arrange, Act and Assert
    assertEquals(Code.FAILED, Code.forNumber(1));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SUCCESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#forNumber(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.forNumber(int)"})
  public void testZksnarkResponse_CodeForNumber_whenZero_thenReturnSuccess() {
    // Arrange, Act and Assert
    assertEquals(Code.SUCCESS, Code.forNumber(0));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getDescriptor()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ZksnarkResponse.Code.getDescriptor()"})
  public void testZksnarkResponse_CodeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = Code.getDescriptor();

    // Assert
    assertEquals("Code", actualDescriptor.getName());
    assertEquals("protocol.ZksnarkResponse.Code", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getDescriptorForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumDescriptor ZksnarkResponse.Code.getDescriptorForType()"})
  public void testZksnarkResponse_CodeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = Code.SUCCESS.getDescriptorForType();

    // Assert
    assertEquals("Code", actualDescriptorForType.getName());
    assertEquals("protocol.ZksnarkResponse.Code", actualDescriptorForType.getFullName());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(2, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getNumber()}.
   * <ul>
   *   <li>Given {@code SUCCESS}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ZksnarkResponse.Code.getNumber()"})
  public void testZksnarkResponse_CodeGetNumber_givenSuccess_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Code.SUCCESS.getNumber());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getNumber()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ZksnarkResponse.Code.getNumber()"})
  public void testZksnarkResponse_CodeGetNumber_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Code.UNRECOGNIZED.getNumber());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code SUCCESS}.</li>
   *   <li>Then return Name is {@code SUCCESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ZksnarkResponse.Code.getValueDescriptor()"})
  public void testZksnarkResponse_CodeGetValueDescriptor_givenSuccess_thenReturnNameIsSuccess() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = Code.SUCCESS.getValueDescriptor();

    // Assert
    assertEquals("SUCCESS", actualValueDescriptor.getName());
    assertEquals("protocol.ZksnarkResponse.Code.SUCCESS", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#getValueDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ZksnarkResponse.Code.getValueDescriptor()"})
  public void testZksnarkResponse_CodeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> Code.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ZksnarkResponse.Code.internalGetValueMap()"})
  public void testZksnarkResponse_CodeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<Code> actualInternalGetValueMapResult = Code.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(AccountResourceMessage.TRONPOWERUSED_FIELD_NUMBER));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ZksnarkResponse.Code.internalGetValueMap()"})
  public void testZksnarkResponse_CodeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<Code> actualInternalGetValueMapResult = Code.internalGetValueMap();

    // Assert
    assertEquals(Code.FAILED, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#internalGetValueMap()}.
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#internalGetValueMap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Internal.EnumLiteMap ZksnarkResponse.Code.internalGetValueMap()"})
  public void testZksnarkResponse_CodeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<Code> actualInternalGetValueMapResult = Code.internalGetValueMap();

    // Assert
    assertEquals(Code.SUCCESS, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.valueOf(int)"})
  public void testZksnarkResponse_CodeValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Code.valueOf(42));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code FAILED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.valueOf(int)"})
  public void testZksnarkResponse_CodeValueOfWithValue_whenOne_thenReturnFailed() {
    // Arrange, Act and Assert
    assertEquals(Code.FAILED, Code.valueOf(1));
  }

  /**
   * Test ZksnarkResponse_Code {@link ZksnarkResponse.Code#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SUCCESS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ZksnarkResponse.Code#valueOf(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkResponse.Code ZksnarkResponse.Code.valueOf(int)"})
  public void testZksnarkResponse_CodeValueOfWithValue_whenZero_thenReturnSuccess() {
    // Arrange, Act and Assert
    assertEquals(Code.SUCCESS, Code.valueOf(0));
  }
}
