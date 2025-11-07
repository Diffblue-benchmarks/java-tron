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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.Edition;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract.Builder;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract.FrozenSupply;
import org.tron.protos.contract.AssetIssueContractOuterClass.ParticipateAssetIssueContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.TransferAssetContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.UnfreezeAssetContract;
import org.tron.protos.contract.AssetIssueContractOuterClass.UpdateAssetContract;

public class AssetIssueContractOuterClassDiffblueTest {
  /**
   * Test AssetIssueContract {@link AssetIssueContract#equals(Object)}, and {@link AssetIssueContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContract#equals(Object)}
   *   <li>{@link AssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.equals(Object)", "int AssetIssueContract.hashCode()"})
  public void testAssetIssueContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetIssueContract defaultInstance = AssetIssueContract.getDefaultInstance();
    AssetIssueContract defaultInstance2 = AssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#equals(Object)}, and {@link AssetIssueContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetIssueContract#equals(Object)}
   *   <li>{@link AssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.equals(Object)", "int AssetIssueContract.hashCode()"})
  public void testAssetIssueContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetIssueContract defaultInstance = AssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.equals(Object)", "int AssetIssueContract.hashCode()"})
  public void testAssetIssueContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContract.getDefaultInstance(), 1);
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.equals(Object)", "int AssetIssueContract.hashCode()"})
  public void testAssetIssueContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContract.getDefaultInstance(), null);
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.equals(Object)", "int AssetIssueContract.hashCode()"})
  public void testAssetIssueContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetIssueContract.getDefaultInstance(), "Different type to AssetIssueContract");
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.getDefaultInstanceForType()"})
  public void testAssetIssueContractGetDefaultInstanceForType() {
    // Arrange
    AssetIssueContract defaultInstance = AssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getDescriptor()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor AssetIssueContract.getDescriptor()"})
  public void testAssetIssueContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = AssetIssueContract.getDescriptor();

    // Assert
    assertEquals("AssetIssueContract", actualDescriptor.getName());
    assertEquals("protocol.AssetIssueContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(19, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getFrozenSupplyCount()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getFrozenSupplyCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueContract.getFrozenSupplyCount()"})
  public void testAssetIssueContractGetFrozenSupplyCount() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContract.getDefaultInstance().getFrozenSupplyCount());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getId()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AssetIssueContract.getId()"})
  public void testAssetIssueContractGetId() {
    // Arrange, Act and Assert
    assertEquals("", AssetIssueContract.getDefaultInstance().getId());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getIdBytes()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getIdBytes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString AssetIssueContract.getIdBytes()"})
  public void testAssetIssueContractGetIdBytes() {
    // Arrange
    AssetIssueContract defaultInstance = AssetIssueContract.getDefaultInstance();

    // Act
    ByteString actualIdBytes = defaultInstance.getIdBytes();

    // Assert
    ByteString byteString = actualIdBytes.EMPTY;
    assertEquals(byteString, actualIdBytes);
    assertSame(byteString, defaultInstance.getAbbr());
    assertSame(byteString, defaultInstance.getDescription());
    assertSame(byteString, defaultInstance.getName());
    assertSame(byteString, defaultInstance.getOwnerAddress());
    assertSame(byteString, defaultInstance.getUrl());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link AssetIssueContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueContract.getSerializedSize()"})
  public void testAssetIssueContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetIssueContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#isInitialized()}.
   * <p>
   * Method under test: {@link AssetIssueContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetIssueContract.isInitialized()"})
  public void testAssetIssueContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetIssueContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AssetIssueContract actualParseDelimitedFromResult = AssetIssueContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getFrozenSupplyCount());
    assertEquals(0, actualParseDelimitedFromResult.getNum());
    assertEquals(0, actualParseDelimitedFromResult.getPrecision());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTrxNum());
    assertEquals(0, actualParseDelimitedFromResult.getVoteScore());
    assertEquals(0L, actualParseDelimitedFromResult.getEndTime());
    assertEquals(0L, actualParseDelimitedFromResult.getFreeAssetNetLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getOrder());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicLatestFreeNetTime());
    assertEquals(0L, actualParseDelimitedFromResult.getStartTime());
    assertEquals(0L, actualParseDelimitedFromResult.getTotalSupply());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<FrozenSupply> frozenSupplyList = actualParseDelimitedFromResult.getFrozenSupplyList();
    assertTrue(frozenSupplyList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(frozenSupplyList, actualParseDelimitedFromResult.getFrozenSupplyOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContractParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AssetIssueContract actualParseDelimitedFromResult = AssetIssueContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getFrozenSupplyCount());
    assertEquals(0, actualParseDelimitedFromResult.getNum());
    assertEquals(0, actualParseDelimitedFromResult.getPrecision());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTrxNum());
    assertEquals(0, actualParseDelimitedFromResult.getVoteScore());
    assertEquals(0L, actualParseDelimitedFromResult.getEndTime());
    assertEquals(0L, actualParseDelimitedFromResult.getFreeAssetNetLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getOrder());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualParseDelimitedFromResult.getPublicLatestFreeNetTime());
    assertEquals(0L, actualParseDelimitedFromResult.getStartTime());
    assertEquals(0L, actualParseDelimitedFromResult.getTotalSupply());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<FrozenSupply> frozenSupplyList = actualParseDelimitedFromResult.getFrozenSupplyList();
    assertTrue(frozenSupplyList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(frozenSupplyList, actualParseDelimitedFromResult.getFrozenSupplyOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetIssueContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[])"})
  public void testAssetIssueContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(new byte[]{});

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    MessageOptions options = descriptorForType.getOptions();
    FileDescriptor file = options.getDescriptorForType().getFile();
    assertEquals("", file.getEditionName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(Edition.EDITION_UNKNOWN, file.getEdition());
    Map<FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file2 = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file2.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file2.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[])"})
  public void testAssetIssueContractParseFromWithByte2() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract
        .parseFrom(new byte[]{'\n', 6, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ByteString ownerAddress = actualParseFromResult.getOwnerAddress();
    assertEquals("AXAXAX", ownerAddress.toStringUtf8());
    assertFalse(ownerAddress.isEmpty());
    assertTrue(ownerAddress.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(ByteBuffer)"})
  public void testAssetIssueContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getFrozenSupplyCount());
    assertEquals(0, actualParseFromResult.getNum());
    assertEquals(0, actualParseFromResult.getPrecision());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTrxNum());
    assertEquals(0, actualParseFromResult.getVoteScore());
    assertEquals(0L, actualParseFromResult.getEndTime());
    assertEquals(0L, actualParseFromResult.getFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getOrder());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualParseFromResult.getPublicLatestFreeNetTime());
    assertEquals(0L, actualParseFromResult.getStartTime());
    assertEquals(0L, actualParseFromResult.getTotalSupply());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<FrozenSupply> frozenSupplyList = actualParseFromResult.getFrozenSupplyList();
    assertTrue(frozenSupplyList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(frozenSupplyList, actualParseFromResult.getFrozenSupplyOrBuilderList());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getFrozenSupplyCount());
    assertEquals(0, actualParseFromResult.getNum());
    assertEquals(0, actualParseFromResult.getPrecision());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTrxNum());
    assertEquals(0, actualParseFromResult.getVoteScore());
    assertEquals(0L, actualParseFromResult.getEndTime());
    assertEquals(0L, actualParseFromResult.getFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getOrder());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualParseFromResult.getPublicLatestFreeNetTime());
    assertEquals(0L, actualParseFromResult.getStartTime());
    assertEquals(0L, actualParseFromResult.getTotalSupply());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<FrozenSupply> frozenSupplyList = actualParseFromResult.getFrozenSupplyList();
    assertTrue(frozenSupplyList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(frozenSupplyList, actualParseFromResult.getFrozenSupplyOrBuilderList());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    MessageOptions options = descriptorForType.getOptions();
    FileDescriptor file = options.getDescriptorForType().getFile();
    assertEquals("", file.getEditionName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(Edition.EDITION_UNKNOWN, file.getEdition());
    Map<FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file2 = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file2.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file2.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithByteExtensionRegistryLite2() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract
        .parseFrom(new byte[]{'\n', 6, 'A', 'X', 'A', 'X', 'A', 'X'}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ByteString ownerAddress = actualParseFromResult.getOwnerAddress();
    assertEquals("AXAXAX", ownerAddress.toStringUtf8());
    assertFalse(ownerAddress.isEmpty());
    assertTrue(ownerAddress.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithByteExtensionRegistryLite3() throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract
        .parseFrom(new byte[]{18, 6, 'A', 'X', 'A', 'X', 'A', 'X'}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ByteString name = actualParseFromResult.getName();
    assertEquals("AXAXAX", name.toStringUtf8());
    assertFalse(name.isEmpty());
    assertTrue(name.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return Name toStringUtf8 is {@code AXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(byte[])"})
  public void testAssetIssueContractParseFromWithByte_thenReturnNameToStringUtf8IsAxaxax()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract
        .parseFrom(new byte[]{18, 6, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ByteString name = actualParseFromResult.getName();
    assertEquals("AXAXAX", name.toStringUtf8());
    assertFalse(name.isEmpty());
    assertTrue(name.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream)"})
  public void testAssetIssueContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream)"})
  public void testAssetIssueContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getFrozenSupplyCount());
    assertEquals(0, actualParseFromResult.getNum());
    assertEquals(0, actualParseFromResult.getPrecision());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTrxNum());
    assertEquals(0, actualParseFromResult.getVoteScore());
    assertEquals(0L, actualParseFromResult.getEndTime());
    assertEquals(0L, actualParseFromResult.getFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getOrder());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualParseFromResult.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualParseFromResult.getPublicLatestFreeNetTime());
    assertEquals(0L, actualParseFromResult.getStartTime());
    assertEquals(0L, actualParseFromResult.getTotalSupply());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<FrozenSupply> frozenSupplyList = actualParseFromResult.getFrozenSupplyList();
    assertTrue(frozenSupplyList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(frozenSupplyList, actualParseFromResult.getFrozenSupplyOrBuilderList());
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetIssueContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetIssueContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream)"})
  public void testAssetIssueContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract {@link AssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueContract.parseFrom(InputStream)"})
  public void testAssetIssueContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AssetIssueContract actualParseFromResult = AssetIssueContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_Builder {@link Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor Builder.getDescriptor()"})
  public void testAssetIssueContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = Builder.getDescriptor();

    // Assert
    assertEquals("AssetIssueContract", actualDescriptor.getName());
    assertEquals("protocol.AssetIssueContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(1, actualDescriptor.getNestedTypes().size());
    assertEquals(19, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#equals(Object)}, and {@link FrozenSupply#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FrozenSupply#equals(Object)}
   *   <li>{@link FrozenSupply#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.equals(Object)", "int FrozenSupply.hashCode()"})
  public void testAssetIssueContract_FrozenSupplyEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    FrozenSupply defaultInstance = FrozenSupply.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#equals(Object)}, and {@link FrozenSupply#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FrozenSupply#equals(Object)}
   *   <li>{@link FrozenSupply#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.equals(Object)", "int FrozenSupply.hashCode()"})
  public void testAssetIssueContract_FrozenSupplyEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    FrozenSupply defaultInstance = FrozenSupply.getDefaultInstance();
    FrozenSupply defaultInstance2 = FrozenSupply.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.equals(Object)", "int FrozenSupply.hashCode()"})
  public void testAssetIssueContract_FrozenSupplyEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FrozenSupply.getDefaultInstance(), "Different type to FrozenSupply");
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.equals(Object)", "int FrozenSupply.hashCode()"})
  public void testAssetIssueContract_FrozenSupplyEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(FrozenSupply.getDefaultInstance(), 1);
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.equals(Object)", "int FrozenSupply.hashCode()"})
  public void testAssetIssueContract_FrozenSupplyEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FrozenSupply.getDefaultInstance(), null);
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link FrozenSupply#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.getDefaultInstanceForType()"})
  public void testAssetIssueContract_FrozenSupplyGetDefaultInstanceForType() {
    // Arrange
    FrozenSupply defaultInstance = FrozenSupply.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#getDescriptor()}.
   * <p>
   * Method under test: {@link FrozenSupply#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FrozenSupply.getDescriptor()"})
  public void testAssetIssueContract_FrozenSupplyGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FrozenSupply.getDescriptor();

    // Assert
    assertEquals("FrozenSupply", actualDescriptor.getName());
    assertEquals("protocol.AssetIssueContract.FrozenSupply", actualDescriptor.getFullName());
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
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#getSerializedSize()}.
   * <p>
   * Method under test: {@link FrozenSupply#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FrozenSupply.getSerializedSize()"})
  public void testAssetIssueContract_FrozenSupplyGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, FrozenSupply.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#isInitialized()}.
   * <p>
   * Method under test: {@link FrozenSupply#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FrozenSupply.isInitialized()"})
  public void testAssetIssueContract_FrozenSupplyIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(FrozenSupply.getDefaultInstance().isInitialized());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FrozenSupply actualParseDelimitedFromResult = FrozenSupply.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenDays());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> FrozenSupply.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FrozenSupply.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    FrozenSupply actualParseDelimitedFromResult = FrozenSupply.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenAmount());
    assertEquals(0L, actualParseDelimitedFromResult.getFrozenDays());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FrozenSupply.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> FrozenSupply.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FrozenSupply.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseDelimitedFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(FrozenSupply.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(byte[])"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(ByteBuffer)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(ByteString)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(CodedInputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStream() throws IOException {
    // Arrange and Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> FrozenSupply.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getFrozenAmount());
    assertEquals(0L, actualParseFromResult.getFrozenDays());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FrozenSupply.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> FrozenSupply.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> FrozenSupply.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AssetIssueContract_FrozenSupply {@link FrozenSupply#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrozenSupply#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FrozenSupply FrozenSupply.parseFrom(InputStream)"})
  public void testAssetIssueContract_FrozenSupplyParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    FrozenSupply actualParseFromResult = FrozenSupply.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AssetIssueContract_FrozenSupply_Builder {@link FrozenSupply.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link FrozenSupply.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor FrozenSupply.Builder.getDescriptor()"})
  public void testAssetIssueContract_FrozenSupply_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = FrozenSupply.Builder.getDescriptor();

    // Assert
    assertEquals("FrozenSupply", actualDescriptor.getName());
    assertEquals("protocol.AssetIssueContract.FrozenSupply", actualDescriptor.getFullName());
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
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#equals(Object)}, and {@link ParticipateAssetIssueContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParticipateAssetIssueContract#equals(Object)}
   *   <li>{@link ParticipateAssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.equals(Object)",
      "int ParticipateAssetIssueContract.hashCode()"})
  public void testParticipateAssetIssueContractEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    ParticipateAssetIssueContract defaultInstance = ParticipateAssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#equals(Object)}, and {@link ParticipateAssetIssueContract#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParticipateAssetIssueContract#equals(Object)}
   *   <li>{@link ParticipateAssetIssueContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.equals(Object)",
      "int ParticipateAssetIssueContract.hashCode()"})
  public void testParticipateAssetIssueContractEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    ParticipateAssetIssueContract defaultInstance = ParticipateAssetIssueContract.getDefaultInstance();
    ParticipateAssetIssueContract defaultInstance2 = ParticipateAssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.equals(Object)",
      "int ParticipateAssetIssueContract.hashCode()"})
  public void testParticipateAssetIssueContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ParticipateAssetIssueContract.getDefaultInstance(), 1);
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.equals(Object)",
      "int ParticipateAssetIssueContract.hashCode()"})
  public void testParticipateAssetIssueContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ParticipateAssetIssueContract.getDefaultInstance(), null);
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.equals(Object)",
      "int ParticipateAssetIssueContract.hashCode()"})
  public void testParticipateAssetIssueContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ParticipateAssetIssueContract.getDefaultInstance(),
        "Different type to ParticipateAssetIssueContract");
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.getDefaultInstanceForType()"})
  public void testParticipateAssetIssueContractGetDefaultInstanceForType() {
    // Arrange
    ParticipateAssetIssueContract defaultInstance = ParticipateAssetIssueContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#getDescriptor()}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ParticipateAssetIssueContract.getDescriptor()"})
  public void testParticipateAssetIssueContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ParticipateAssetIssueContract.getDescriptor();

    // Assert
    assertEquals("ParticipateAssetIssueContract", actualDescriptor.getName());
    assertEquals("protocol.ParticipateAssetIssueContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(4, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ParticipateAssetIssueContract.getSerializedSize()"})
  public void testParticipateAssetIssueContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ParticipateAssetIssueContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#isInitialized()}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ParticipateAssetIssueContract.isInitialized()"})
  public void testParticipateAssetIssueContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ParticipateAssetIssueContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParticipateAssetIssueContract actualParseDelimitedFromResult = ParticipateAssetIssueContract
        .parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ParticipateAssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ParticipateAssetIssueContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParticipateAssetIssueContract actualParseDelimitedFromResult = ParticipateAssetIssueContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ParticipateAssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ParticipateAssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ParticipateAssetIssueContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseDelimitedFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ParticipateAssetIssueContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(byte[])"})
  public void testParticipateAssetIssueContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(ByteBuffer)"})
  public void testParticipateAssetIssueContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(ByteString)"})
  public void testParticipateAssetIssueContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAssetName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAssetName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(CodedInputStream)"})
  public void testParticipateAssetIssueContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ParticipateAssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ParticipateAssetIssueContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testParticipateAssetIssueContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ParticipateAssetIssueContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ParticipateAssetIssueContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ParticipateAssetIssueContract {@link ParticipateAssetIssueContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ParticipateAssetIssueContract ParticipateAssetIssueContract.parseFrom(InputStream)"})
  public void testParticipateAssetIssueContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ParticipateAssetIssueContract actualParseFromResult = ParticipateAssetIssueContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ParticipateAssetIssueContract_Builder {@link ParticipateAssetIssueContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link ParticipateAssetIssueContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor ParticipateAssetIssueContract.Builder.getDescriptor()"})
  public void testParticipateAssetIssueContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = ParticipateAssetIssueContract.Builder.getDescriptor();

    // Assert
    assertEquals("ParticipateAssetIssueContract", actualDescriptor.getName());
    assertEquals("protocol.ParticipateAssetIssueContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(4, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#equals(Object)}, and {@link TransferAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransferAssetContract#equals(Object)}
   *   <li>{@link TransferAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.equals(Object)", "int TransferAssetContract.hashCode()"})
  public void testTransferAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransferAssetContract defaultInstance = TransferAssetContract.getDefaultInstance();
    TransferAssetContract defaultInstance2 = TransferAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#equals(Object)}, and {@link TransferAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransferAssetContract#equals(Object)}
   *   <li>{@link TransferAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.equals(Object)", "int TransferAssetContract.hashCode()"})
  public void testTransferAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransferAssetContract defaultInstance = TransferAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.equals(Object)", "int TransferAssetContract.hashCode()"})
  public void testTransferAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.equals(Object)", "int TransferAssetContract.hashCode()"})
  public void testTransferAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferAssetContract.getDefaultInstance(), null);
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.equals(Object)", "int TransferAssetContract.hashCode()"})
  public void testTransferAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransferAssetContract.getDefaultInstance(), "Different type to TransferAssetContract");
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TransferAssetContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.getDefaultInstanceForType()"})
  public void testTransferAssetContractGetDefaultInstanceForType() {
    // Arrange
    TransferAssetContract defaultInstance = TransferAssetContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#getDescriptor()}.
   * <p>
   * Method under test: {@link TransferAssetContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransferAssetContract.getDescriptor()"})
  public void testTransferAssetContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransferAssetContract.getDescriptor();

    // Assert
    assertEquals("TransferAssetContract", actualDescriptor.getName());
    assertEquals("protocol.TransferAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link TransferAssetContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TransferAssetContract.getSerializedSize()"})
  public void testTransferAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransferAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#isInitialized()}.
   * <p>
   * Method under test: {@link TransferAssetContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransferAssetContract.isInitialized()"})
  public void testTransferAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransferAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream)"})
  public void testTransferAssetContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransferAssetContract actualParseDelimitedFromResult = TransferAssetContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream)"})
  public void testTransferAssetContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransferAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TransferAssetContract actualParseDelimitedFromResult = TransferAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getAmount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransferAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransferAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransferAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream)"})
  public void testTransferAssetContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransferAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseDelimitedFrom(InputStream)"})
  public void testTransferAssetContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransferAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(byte[])"})
  public void testTransferAssetContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(ByteBuffer)"})
  public void testTransferAssetContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(ByteString)"})
  public void testTransferAssetContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAssetName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getAssetName());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getToAddress());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(CodedInputStream)"})
  public void testTransferAssetContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream)"})
  public void testTransferAssetContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TransferAssetContract actualParseFromResult = TransferAssetContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream)"})
  public void testTransferAssetContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransferAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getAmount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransferAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testTransferAssetContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransferAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream)"})
  public void testTransferAssetContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransferAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TransferAssetContract {@link TransferAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransferAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransferAssetContract TransferAssetContract.parseFrom(InputStream)"})
  public void testTransferAssetContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TransferAssetContract actualParseFromResult = TransferAssetContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TransferAssetContract_Builder {@link TransferAssetContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link TransferAssetContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor TransferAssetContract.Builder.getDescriptor()"})
  public void testTransferAssetContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = TransferAssetContract.Builder.getDescriptor();

    // Assert
    assertEquals("TransferAssetContract", actualDescriptor.getName());
    assertEquals("protocol.TransferAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#equals(Object)}, and {@link UnfreezeAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeAssetContract#equals(Object)}
   *   <li>{@link UnfreezeAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.equals(Object)", "int UnfreezeAssetContract.hashCode()"})
  public void testUnfreezeAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnfreezeAssetContract defaultInstance = UnfreezeAssetContract.getDefaultInstance();
    UnfreezeAssetContract defaultInstance2 = UnfreezeAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#equals(Object)}, and {@link UnfreezeAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnfreezeAssetContract#equals(Object)}
   *   <li>{@link UnfreezeAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.equals(Object)", "int UnfreezeAssetContract.hashCode()"})
  public void testUnfreezeAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnfreezeAssetContract defaultInstance = UnfreezeAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.equals(Object)", "int UnfreezeAssetContract.hashCode()"})
  public void testUnfreezeAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.equals(Object)", "int UnfreezeAssetContract.hashCode()"})
  public void testUnfreezeAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeAssetContract.getDefaultInstance(), null);
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.equals(Object)", "int UnfreezeAssetContract.hashCode()"})
  public void testUnfreezeAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UnfreezeAssetContract.getDefaultInstance(), "Different type to UnfreezeAssetContract");
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.getDefaultInstanceForType()"})
  public void testUnfreezeAssetContractGetDefaultInstanceForType() {
    // Arrange
    UnfreezeAssetContract defaultInstance = UnfreezeAssetContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeAssetContract.getDescriptor()"})
  public void testUnfreezeAssetContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeAssetContract.getDescriptor();

    // Assert
    assertEquals("UnfreezeAssetContract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnfreezeAssetContract.getSerializedSize()"})
  public void testUnfreezeAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UnfreezeAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#isInitialized()}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnfreezeAssetContract.isInitialized()"})
  public void testUnfreezeAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UnfreezeAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeAssetContract actualParseDelimitedFromResult = UnfreezeAssetContract.parseDelimitedFrom(input);

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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UnfreezeAssetContract actualParseDelimitedFromResult = UnfreezeAssetContract.parseDelimitedFrom(input,
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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UnfreezeAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUnfreezeAssetContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(byte[])"})
  public void testUnfreezeAssetContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(ByteBuffer)"})
  public void testUnfreezeAssetContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(data,
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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(new byte[]{},
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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(ByteString)"})
  public void testUnfreezeAssetContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(data);

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
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(data,
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
    ByteString expectedOwnerAddress = data.EMPTY;
    assertSame(expectedOwnerAddress, actualParseFromResult.getOwnerAddress());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(CodedInputStream)"})
  public void testUnfreezeAssetContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(input);

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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(input,
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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream)"})
  public void testUnfreezeAssetContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream)"})
  public void testUnfreezeAssetContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UnfreezeAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom(input,
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
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UnfreezeAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUnfreezeAssetContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UnfreezeAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream)"})
  public void testUnfreezeAssetContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UnfreezeAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UnfreezeAssetContract {@link UnfreezeAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnfreezeAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UnfreezeAssetContract UnfreezeAssetContract.parseFrom(InputStream)"})
  public void testUnfreezeAssetContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UnfreezeAssetContract actualParseFromResult = UnfreezeAssetContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UnfreezeAssetContract_Builder {@link UnfreezeAssetContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UnfreezeAssetContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UnfreezeAssetContract.Builder.getDescriptor()"})
  public void testUnfreezeAssetContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UnfreezeAssetContract.Builder.getDescriptor();

    // Assert
    assertEquals("UnfreezeAssetContract", actualDescriptor.getName());
    assertEquals("protocol.UnfreezeAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getFields().size());
    assertEquals(2, actualDescriptor.getIndex());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#equals(Object)}, and {@link UpdateAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateAssetContract#equals(Object)}
   *   <li>{@link UpdateAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.equals(Object)", "int UpdateAssetContract.hashCode()"})
  public void testUpdateAssetContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UpdateAssetContract defaultInstance = UpdateAssetContract.getDefaultInstance();
    UpdateAssetContract defaultInstance2 = UpdateAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#equals(Object)}, and {@link UpdateAssetContract#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateAssetContract#equals(Object)}
   *   <li>{@link UpdateAssetContract#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.equals(Object)", "int UpdateAssetContract.hashCode()"})
  public void testUpdateAssetContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UpdateAssetContract defaultInstance = UpdateAssetContract.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.equals(Object)", "int UpdateAssetContract.hashCode()"})
  public void testUpdateAssetContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateAssetContract.getDefaultInstance(), 1);
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.equals(Object)", "int UpdateAssetContract.hashCode()"})
  public void testUpdateAssetContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateAssetContract.getDefaultInstance(), null);
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.equals(Object)", "int UpdateAssetContract.hashCode()"})
  public void testUpdateAssetContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UpdateAssetContract.getDefaultInstance(), "Different type to UpdateAssetContract");
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UpdateAssetContract#getDefaultInstanceForType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.getDefaultInstanceForType()"})
  public void testUpdateAssetContractGetDefaultInstanceForType() {
    // Arrange
    UpdateAssetContract defaultInstance = UpdateAssetContract.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateAssetContract#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateAssetContract.getDescriptor()"})
  public void testUpdateAssetContractGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateAssetContract.getDescriptor();

    // Assert
    assertEquals("UpdateAssetContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#getSerializedSize()}.
   * <p>
   * Method under test: {@link UpdateAssetContract#getSerializedSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UpdateAssetContract.getSerializedSize()"})
  public void testUpdateAssetContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UpdateAssetContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#isInitialized()}.
   * <p>
   * Method under test: {@link UpdateAssetContract#isInitialized()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UpdateAssetContract.isInitialized()"})
  public void testUpdateAssetContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UpdateAssetContract.getDefaultInstance().isInitialized());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateAssetContractParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateAssetContract actualParseDelimitedFromResult = UpdateAssetContract.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getNewLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getNewPublicLimit());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateAssetContractParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    UpdateAssetContract actualParseDelimitedFromResult = UpdateAssetContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getNewLimit());
    assertEquals(0L, actualParseDelimitedFromResult.getNewPublicLimit());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateAssetContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateAssetContractParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UpdateAssetContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseDelimitedFrom(InputStream)"})
  public void testUpdateAssetContractParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateAssetContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(byte[])"})
  public void testUpdateAssetContractParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(ByteBuffer)"})
  public void testUpdateAssetContractParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(byte[], ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(ByteString)"})
  public void testUpdateAssetContractParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getDescription());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUrl());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(ByteString, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertSame(byteString, actualParseFromResult.getDescription());
    assertSame(byteString, actualParseFromResult.getOwnerAddress());
    assertSame(byteString, actualParseFromResult.getUrl());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(CodedInputStream)"})
  public void testUpdateAssetContractParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream)"})
  public void testUpdateAssetContractParseFromWithInputStream() throws IOException {
    // Arrange and Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream)"})
  public void testUpdateAssetContractParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UpdateAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getNewLimit());
    assertEquals(0L, actualParseFromResult.getNewPublicLimit());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> UpdateAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream, ExtensionRegistryLite)"})
  public void testUpdateAssetContractParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UpdateAssetContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream)"})
  public void testUpdateAssetContractParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UpdateAssetContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test UpdateAssetContract {@link UpdateAssetContract#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateAssetContract#parseFrom(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UpdateAssetContract UpdateAssetContract.parseFrom(InputStream)"})
  public void testUpdateAssetContractParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UpdateAssetContract actualParseFromResult = UpdateAssetContract.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test UpdateAssetContract_Builder {@link UpdateAssetContract.Builder#getDescriptor()}.
   * <p>
   * Method under test: {@link UpdateAssetContract.Builder#getDescriptor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Descriptors.Descriptor UpdateAssetContract.Builder.getDescriptor()"})
  public void testUpdateAssetContract_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptor actualDescriptor = UpdateAssetContract.Builder.getDescriptor();

    // Assert
    assertEquals("UpdateAssetContract", actualDescriptor.getName());
    assertEquals("protocol.UpdateAssetContract", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(3, actualDescriptor.getIndex());
    assertEquals(5, actualDescriptor.getFields().size());
    assertFalse(actualDescriptor.isExtendable());
    assertTrue(actualDescriptor.getEnumTypes().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
  }
}
