package org.tron.protos.contract;

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
import com.google.protobuf.ExtensionRegistryLite;
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
import org.tron.protos.contract.WitnessContract.VoteWitnessContract;
import org.tron.protos.contract.WitnessContract.VoteWitnessContract.Builder;
import org.tron.protos.contract.WitnessContract.VoteWitnessContract.Vote;
import org.tron.protos.contract.WitnessContract.WitnessCreateContract;
import org.tron.protos.contract.WitnessContract.WitnessUpdateContract;

public class WitnessContractDiffblueTest {
  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#equals(Object)}, and {@link VoteWitnessContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VoteWitnessContract#equals(Object)}
   *   <li>{@link VoteWitnessContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.equals(Object)", "int VoteWitnessContract.hashCode()"})
  public void testVoteWitnessContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VoteWitnessContract defaultInstance = VoteWitnessContract.getDefaultInstance();
    VoteWitnessContract defaultInstance2 = VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#equals(Object)}, and {@link VoteWitnessContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VoteWitnessContract#equals(Object)}
   *   <li>{@link VoteWitnessContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.equals(Object)", "int VoteWitnessContract.hashCode()"})
  public void testVoteWitnessContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VoteWitnessContract defaultInstance = VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.equals(Object)", "int VoteWitnessContract.hashCode()"})
  public void testVoteWitnessContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteWitnessContract.getDefaultInstance(), 1);
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.equals(Object)", "int VoteWitnessContract.hashCode()"})
  public void testVoteWitnessContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteWitnessContract.getDefaultInstance(), null);
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.equals(Object)", "int VoteWitnessContract.hashCode()"})
  public void testVoteWitnessContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VoteWitnessContract.getDefaultInstance(), "Different type to VoteWitnessContract");
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link VoteWitnessContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.getDefaultInstanceForType()"})
  public void testVoteWitnessContractGetDefaultInstanceForType() {
    // Arrange
    VoteWitnessContract defaultInstance = VoteWitnessContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#getDescriptor()}.
   * <p>
   * Method under test: {@link VoteWitnessContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor VoteWitnessContract.getDescriptor()"})
  public void testVoteWitnessContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = VoteWitnessContract.getDescriptor();

    // Assert
    assertEquals("VoteWitnessContract", actualDescriptor.getName());
    assertEquals("protocol.VoteWitnessContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link VoteWitnessContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VoteWitnessContract.getSerializedSize()"})
  public void testVoteWitnessContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, VoteWitnessContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#getVotesCount()}.
   * <p>
   * Method under test: {@link VoteWitnessContract#getVotesCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VoteWitnessContract.getVotesCount()"})
  public void testVoteWitnessContractGetVotesCount() {
    // Arrange, Act and Assert
    assertEquals(0, VoteWitnessContract.getDefaultInstance().getVotesCount());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#isInitialized()}.
   * <p>
   * Method under test: {@link VoteWitnessContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.isInitialized()"})
  public void testVoteWitnessContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(VoteWitnessContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    VoteWitnessContract actualParseDelimitedFromResult = VoteWitnessContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVotesCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getSupport());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseDelimitedFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseDelimitedFromResult.getVotesOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> VoteWitnessContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    VoteWitnessContract actualParseDelimitedFromResult = VoteWitnessContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getVotesCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getSupport());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseDelimitedFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseDelimitedFromResult.getVotesOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> VoteWitnessContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(VoteWitnessContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> VoteWitnessContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(byte[])"})
  public void testVoteWitnessContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVotesCount());
    assertFalse(actualParseFromResult.getSupport());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseFromResult.getVotesOrBuilderList());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(ByteBuffer)"})
  public void testVoteWitnessContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVotesCount());
    assertFalse(actualParseFromResult.getSupport());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseFromResult.getVotesOrBuilderList());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVotesCount());
    assertFalse(actualParseFromResult.getSupport());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseFromResult.getVotesOrBuilderList());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVotesCount());
    assertFalse(actualParseFromResult.getSupport());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseFromResult.getVotesOrBuilderList());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream)"})
  public void testVoteWitnessContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(3, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream)"})
  public void testVoteWitnessContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> VoteWitnessContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getVotesCount());
    assertFalse(actualParseFromResult.getSupport());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Vote> votesList = actualParseFromResult.getVotesList();
    assertTrue(votesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(votesList, actualParseFromResult.getVotesOrBuilderList());
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> VoteWitnessContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> VoteWitnessContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream)"})
  public void testVoteWitnessContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> VoteWitnessContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract {@link VoteWitnessContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract VoteWitnessContract.parseFrom(InputStream)"})
  public void testVoteWitnessContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    VoteWitnessContract actualParseFromResult = VoteWitnessContract.parseFrom((InputStream) null);

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(3, descriptorForType.getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Builder {@link VoteWitnessContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor VoteWitnessContract.Builder.getDescriptor()"})
  public void testVoteWitnessContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("VoteWitnessContract", actualDescriptor.getName());
    assertEquals("protocol.VoteWitnessContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#equals(Object)}, and {@link VoteWitnessContract.Vote#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VoteWitnessContract.Vote#equals(Object)}
   *   <li>{@link VoteWitnessContract.Vote#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.equals(Object)", "int VoteWitnessContract.Vote.hashCode()"})
  public void testVoteWitnessContract_VoteEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Vote defaultInstance = Vote.getDefaultInstance();
    Vote defaultInstance2 = Vote.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#equals(Object)}, and {@link VoteWitnessContract.Vote#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VoteWitnessContract.Vote#equals(Object)}
   *   <li>{@link VoteWitnessContract.Vote#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.equals(Object)", "int VoteWitnessContract.Vote.hashCode()"})
  public void testVoteWitnessContract_VoteEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Vote defaultInstance = Vote.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.equals(Object)", "int VoteWitnessContract.Vote.hashCode()"})
  public void testVoteWitnessContract_VoteEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vote.getDefaultInstance(), 1);
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.equals(Object)", "int VoteWitnessContract.Vote.hashCode()"})
  public void testVoteWitnessContract_VoteEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vote.getDefaultInstance(), null);
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.equals(Object)", "int VoteWitnessContract.Vote.hashCode()"})
  public void testVoteWitnessContract_VoteEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Vote.getDefaultInstance(), "Different type to Vote");
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.getDefaultInstanceForType()"})
  public void testVoteWitnessContract_VoteGetDefaultInstanceForType() {
    // Arrange
    Vote defaultInstance = Vote.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#getDescriptor()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor VoteWitnessContract.Vote.getDescriptor()"})
  public void testVoteWitnessContract_VoteGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Vote.getDescriptor();

    // Assert
    assertEquals("Vote", actualDescriptor.getName());
    assertEquals("protocol.VoteWitnessContract.Vote", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#getSerializedSize()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VoteWitnessContract.Vote.getSerializedSize()"})
  public void testVoteWitnessContract_VoteGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Vote.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#isInitialized()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoteWitnessContract.Vote.isInitialized()"})
  public void testVoteWitnessContract_VoteIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Vote.getDefaultInstance().isInitialized());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Vote actualParseDelimitedFromResult = Vote.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getVoteCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Vote.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Vote actualParseDelimitedFromResult = Vote.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getVoteCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Vote.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Vote.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Vote.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Vote.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseDelimitedFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Vote.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(byte[])"})
  public void testVoteWitnessContract_VoteParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Vote actualParseFromResult = Vote.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(ByteBuffer)"})
  public void testVoteWitnessContract_VoteParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Vote actualParseFromResult = Vote.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Vote actualParseFromResult = Vote.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Vote actualParseFromResult = Vote.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(ByteString)"})
  public void testVoteWitnessContract_VoteParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Vote actualParseFromResult = Vote.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedVoteAddress = data.EMPTY;
    assertSame(expectedVoteAddress, actualParseFromResult.getVoteAddress());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Vote actualParseFromResult = Vote.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedVoteAddress = data.EMPTY;
    assertSame(expectedVoteAddress, actualParseFromResult.getVoteAddress());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(CodedInputStream)"})
  public void testVoteWitnessContract_VoteParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Vote actualParseFromResult = Vote.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Vote actualParseFromResult = Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Vote actualParseFromResult = Vote.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Vote.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Vote actualParseFromResult = Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getVoteCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Vote.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Vote.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test VoteWitnessContract_Vote {@link VoteWitnessContract.Vote#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VoteWitnessContract.Vote VoteWitnessContract.Vote.parseFrom(InputStream)"})
  public void testVoteWitnessContract_VoteParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Vote actualParseFromResult = Vote.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test VoteWitnessContract_Vote_Builder {@link VoteWitnessContract.Vote.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link VoteWitnessContract.Vote.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor VoteWitnessContract.Vote.Builder.getDescriptor()"})
  public void testVoteWitnessContract_Vote_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Vote.Builder.getDescriptor();

    // Assert
    assertEquals("Vote", actualDescriptor.getName());
    assertEquals("protocol.VoteWitnessContract.Vote", actualDescriptor.getFullName());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#equals(Object)}, and {@link WitnessCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessCreateContract#equals(Object)}
   *   <li>{@link WitnessCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.equals(Object)", "int WitnessCreateContract.hashCode()"})
  public void testWitnessCreateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessCreateContract defaultInstance = WitnessCreateContract.getDefaultInstance();
    WitnessCreateContract defaultInstance2 = WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#equals(Object)}, and {@link WitnessCreateContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessCreateContract#equals(Object)}
   *   <li>{@link WitnessCreateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.equals(Object)", "int WitnessCreateContract.hashCode()"})
  public void testWitnessCreateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessCreateContract defaultInstance = WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.equals(Object)", "int WitnessCreateContract.hashCode()"})
  public void testWitnessCreateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessCreateContract.getDefaultInstance(), 1);
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.equals(Object)", "int WitnessCreateContract.hashCode()"})
  public void testWitnessCreateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessCreateContract.getDefaultInstance(), null);
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.equals(Object)", "int WitnessCreateContract.hashCode()"})
  public void testWitnessCreateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessCreateContract.getDefaultInstance(), "Different type to WitnessCreateContract");
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link WitnessCreateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.getDefaultInstanceForType()"})
  public void testWitnessCreateContractGetDefaultInstanceForType() {
    // Arrange
    WitnessCreateContract defaultInstance = WitnessCreateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link WitnessCreateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WitnessCreateContract.getDescriptor()"})
  public void testWitnessCreateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WitnessCreateContract.getDescriptor();

    // Assert
    assertEquals("WitnessCreateContract", actualDescriptor.getName());
    assertEquals("protocol.WitnessCreateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link WitnessCreateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WitnessCreateContract.getSerializedSize()"})
  public void testWitnessCreateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessCreateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#isInitialized()}.
   * <p>
   * Method under test: {@link WitnessCreateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCreateContract.isInitialized()"})
  public void testWitnessCreateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessCreateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessCreateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WitnessCreateContract actualParseDelimitedFromResult = WitnessCreateContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessCreateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WitnessCreateContract actualParseDelimitedFromResult = WitnessCreateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessCreateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessCreateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessCreateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessCreateContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessCreateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(byte[])"})
  public void testWitnessCreateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(ByteBuffer)"})
  public void testWitnessCreateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(ByteString)"})
  public void testWitnessCreateContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUrl());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUrl());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(CodedInputStream)"})
  public void testWitnessCreateContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream)"})
  public void testWitnessCreateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream)"})
  public void testWitnessCreateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessCreateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessCreateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream)"})
  public void testWitnessCreateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessCreateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessCreateContract {@link WitnessCreateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCreateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessCreateContract WitnessCreateContract.parseFrom(InputStream)"})
  public void testWitnessCreateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    WitnessCreateContract actualParseFromResult = WitnessCreateContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WitnessCreateContract_Builder {@link WitnessCreateContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link WitnessCreateContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WitnessCreateContract.Builder.getDescriptor()"})
  public void testWitnessCreateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WitnessCreateContract.Builder.getDescriptor();

    // Assert
    assertEquals("WitnessCreateContract", actualDescriptor.getName());
    assertEquals("protocol.WitnessCreateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#equals(Object)}, and {@link WitnessUpdateContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessUpdateContract#equals(Object)}
   *   <li>{@link WitnessUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.equals(Object)", "int WitnessUpdateContract.hashCode()"})
  public void testWitnessUpdateContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WitnessUpdateContract defaultInstance = WitnessUpdateContract.getDefaultInstance();
    WitnessUpdateContract defaultInstance2 = WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#equals(Object)}, and {@link WitnessUpdateContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WitnessUpdateContract#equals(Object)}
   *   <li>{@link WitnessUpdateContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.equals(Object)", "int WitnessUpdateContract.hashCode()"})
  public void testWitnessUpdateContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WitnessUpdateContract defaultInstance = WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.equals(Object)", "int WitnessUpdateContract.hashCode()"})
  public void testWitnessUpdateContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessUpdateContract.getDefaultInstance(), 1);
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.equals(Object)", "int WitnessUpdateContract.hashCode()"})
  public void testWitnessUpdateContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessUpdateContract.getDefaultInstance(), null);
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.equals(Object)", "int WitnessUpdateContract.hashCode()"})
  public void testWitnessUpdateContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WitnessUpdateContract.getDefaultInstance(), "Different type to WitnessUpdateContract");
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.getDefaultInstanceForType()"})
  public void testWitnessUpdateContractGetDefaultInstanceForType() {
    // Arrange
    WitnessUpdateContract defaultInstance = WitnessUpdateContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#getDescriptor()}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WitnessUpdateContract.getDescriptor()"})
  public void testWitnessUpdateContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WitnessUpdateContract.getDescriptor();

    // Assert
    assertEquals("WitnessUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.WitnessUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WitnessUpdateContract.getSerializedSize()"})
  public void testWitnessUpdateContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, WitnessUpdateContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#isInitialized()}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessUpdateContract.isInitialized()"})
  public void testWitnessUpdateContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(WitnessUpdateContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WitnessUpdateContract actualParseDelimitedFromResult = WitnessUpdateContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WitnessUpdateContract actualParseDelimitedFromResult = WitnessUpdateContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessUpdateContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(WitnessUpdateContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseDelimitedFrom(InputStream)"})
  public void testWitnessUpdateContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessUpdateContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(byte[])"})
  public void testWitnessUpdateContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(ByteBuffer)"})
  public void testWitnessUpdateContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(ByteString)"})
  public void testWitnessUpdateContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUpdateUrl());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUpdateUrl());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(CodedInputStream)"})
  public void testWitnessUpdateContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream)"})
  public void testWitnessUpdateContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream)"})
  public void testWitnessUpdateContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> WitnessUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> WitnessUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testWitnessUpdateContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> WitnessUpdateContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream)"})
  public void testWitnessUpdateContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> WitnessUpdateContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test WitnessUpdateContract {@link WitnessUpdateContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessUpdateContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessUpdateContract WitnessUpdateContract.parseFrom(InputStream)"})
  public void testWitnessUpdateContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    WitnessUpdateContract actualParseFromResult = WitnessUpdateContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test WitnessUpdateContract_Builder {@link WitnessUpdateContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link WitnessUpdateContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor WitnessUpdateContract.Builder.getDescriptor()"})
  public void testWitnessUpdateContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = WitnessUpdateContract.Builder.getDescriptor();

    // Assert
    assertEquals("WitnessUpdateContract", actualDescriptor.getName());
    assertEquals("protocol.WitnessUpdateContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(2, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }
}
